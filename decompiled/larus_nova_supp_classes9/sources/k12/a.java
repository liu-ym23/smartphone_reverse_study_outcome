package k12;

import com.bytedance.android.scope.o;
import ft1.k;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements b, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // k12.b
    public final void trackPlayInfoForSlardar(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "slardarKey");
        Intrinsics.checkNotNullParameter(r3, "slardarInfo");
        int r0 = k.a;
        HashMap r1 = new HashMap();
        r1.put(r2, r3);
        Unit r4 = Unit.INSTANCE;
        k.a(r1);
    }
}
