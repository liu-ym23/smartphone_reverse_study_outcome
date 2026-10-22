package un8;

import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardView;
import com.larus.im.bean.message.block.Status;
import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ TaskCardView a;

    public /* synthetic */ e(TaskCardView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskCardView r0 = this.a;
        int r1 = TaskCardView.d;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        a r3 = r0.b;     // Catch: Throwable -> L27
        TaskCardBlock r4 = r3.b;     // Catch: Throwable -> L27
        Long r5 = null;
        if (r4 == null) goto L6;
        Long r6 = r4.startTimestamp;     // Catch: Throwable -> L27
    L7:
        if (r4 == null) goto L10;
        r5 = r4.estimatedDuration;     // Catch: Throwable -> L27
    L10:
        if (r3.a == true) goto L12;
    L24:
        r0.b.c = false;     // Catch: Throwable -> L27
    L25:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L35;
        com.larus.platform.service.g.a.ensureNotReachHere(r8);
        return;
    L35:
        return;
    L12:
        if (r4 == null) goto L19;
        Integer r9 = r4.status;     // Catch: Throwable -> L27
        int r10 = Status.STATUS_PROCESSING.getValue();     // Catch: Throwable -> L27
        if (r9 == null) goto L19;
        if (r9.intValue() != r10) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L24;
        if (r6 == null) goto L24;
        if (r5 == null) goto L24;
        r0.e(r0.b.b);     // Catch: Throwable -> L27
        r0.b.c = true;     // Catch: Throwable -> L27
        r0.postDelayed(new e(r0), 20000);     // Catch: Throwable -> L27
    L19:
        r11 = false;
        goto L20
    L6:
        r6 = null;
    L27:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
