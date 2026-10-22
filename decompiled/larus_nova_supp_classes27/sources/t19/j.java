package t19;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Integer c;

    public /* synthetic */ j(String r1, Context r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        Context r1 = this.b;
        Integer r2 = this.c;
        s r3 = s.a;
        r3.a();
        Intrinsics.checkNotNullParameter(r0, "text");
        if (r2 == null) goto L5;
        int r4 = r2.intValue();
        TimeUnit r5 = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(r5, "unit");
        int r6 = (int) r5.toMillis(r4);
    L6:
        Object r7 = ObricToastHelperDelegate.b.createToastHolder(r1);
        if ((r7 instanceof u19.f) == false) goto L9;
        u19.f r8 = (u19.f) r7;
    L10:
        if (r8 != null) goto L12;
        r8 = new u19.i();
    L12:
        r8.setAutoDisappear(true);
        r8.setDuration(r6);
        r8.icon(0);
        r8.text(r0);
        r8.setYOffsetPx(null);
        r3.r(r8);
        FLogger.a.d("ToastLogger", "toast utils show, method name: showWithForceToast");
        r8.show(r1, false);
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
