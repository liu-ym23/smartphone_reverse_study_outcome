package u19;

import android.content.Context;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public boolean a;
    public boolean b;
    public int c;
    public CharSequence d;
    public int e;
    public Integer f;

    public g() {
        this.a = true;
        this.d = "";
    }

    public final f a(Context r2) {
        Object r3 = ObricToastHelperDelegate.b.createToastHolder(r2);
        if ((r3 instanceof f) == false) goto L5;
        f r4 = (f) r3;
    L6:
        if (r4 == null) goto L8;
    L14:
        r4.setAutoDisappear(this.a);
        r4.setDuration(this.e);
        r4.icon(this.c);
        r4.text(this.d);
        r4.setYOffsetPx(this.f);
        return r4;
    L8:
        if (this.a == true) goto L10;
    L13:
        r4 = new e();
        goto L14
    L10:
        if (this.b == true) goto L13;
        r4 = new i();
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    public final void b(int r5, TimeUnit r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "unit");
        if (r7 == false) goto L5;
    L6:
        this.b = true;
    L7:
        this.e = (int) r6.toMillis(r5);
        return;
    L5:
        if (r6.toMillis(r5) <= 3500) goto L7;
        goto L6
    }
}
