package ok8;

import com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.view.DeepResearchProgressCard;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import com.larus.im.bean.message.block.Status;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DeepResearchProgressCard a;

    public /* synthetic */ e(DeepResearchProgressCard r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.view.DeepResearchProgressCard] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a;
        int r1 = DeepResearchProgressCard.c;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        ResearchProcessBlock r3 = r0.a.b;     // Catch: Throwable -> L28
        Integer r4 = null;
        if (r3 == null) goto L6;
        Integer r5 = r3.getStartTimestamp();     // Catch: Throwable -> L28
    L7:
        ResearchProcessBlock r6 = r0.a.b;     // Catch: Throwable -> L28
        if (r6 == null) goto L10;
        r4 = r6.getEstimatedDuration();     // Catch: Throwable -> L28
    L10:
        a r7 = r0.a;     // Catch: Throwable -> L28
        if (r7.a == false) goto L25;
        ResearchProcessBlock r8 = r7.b;     // Catch: Throwable -> L28
        if (r8 == null) goto L20;
        Integer r9 = r8.getStatus();     // Catch: Throwable -> L28
        int r10 = Status.STATUS_PROCESSING.getValue();     // Catch: Throwable -> L28
        if (r9 == null) goto L20;
        if (r9.intValue() != r10) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L25;
        if (r5 == null) goto L25;
        if (r4 == null) goto L25;
        r0.T5(r0.a.b);     // Catch: Throwable -> L28
        r0.a.c = true;     // Catch: Throwable -> L28
        r0.postDelayed(new e(r0), 20000);     // Catch: Throwable -> L28
    L26:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L36;
        com.larus.platform.service.g.a.ensureNotReachHere(r13);
        return;
    L36:
        return;
    L20:
        r11 = false;
    L25:
        r0.a.c = false;     // Catch: Throwable -> L28
        goto L26
    L6:
        r5 = null;
    L28:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }
}
