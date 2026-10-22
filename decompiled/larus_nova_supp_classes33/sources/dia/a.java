package dia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends eia.e {

    /* JADX INFO: renamed from: dia.a$a, reason: collision with other inner class name */
    public static final class C0051a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger.a.i("LandscapeActionBarStrategy", "applyOrientationChange " + hashCode());
        c();
    }

    public a(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
