package sea;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final Function0<Unit> a;
    public final long b;
    public long c;

    /* JADX INFO: renamed from: sea.a$a, reason: collision with other inner class name */
    public static final class C0071a {
    }

    static {
    }

    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i("ClickWithQuicklyProtection", "onClick hashcode " + hashCode());
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - this.c) >= this.b) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        this.c = r3;
    L8:
        if (r1 == false) goto L11;
        r0.i("ClickWithQuicklyProtection", "isQuicklyClick");
        return;
    L11:
        this.a.invoke();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public a(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClickListener");
        this.a = r3;
        this.b = 3000;
    }
}
