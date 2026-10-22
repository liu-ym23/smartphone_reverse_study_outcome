package gi;

import com.bytedance.android.ec.diff.lib.di.ToCServiceModule_ProvideFactory;
import com.bytedance.android.ec.diff.lib.di.ToCServiceModule_ProvideTuringFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static fi.b a;
    public static hi.a b;

    static {
        c r0 = new c();
        Provider r1 = DoubleCheck.provider(ToCServiceModule_ProvideFactory.create(r0));
        Provider r10 = DoubleCheck.provider(ToCServiceModule_ProvideTuringFactory.create(r0));
        fi.b r11 = (fi.b) r1.get();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        a = r11;
        hi.a r12 = (hi.a) r10.get();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        b = r12;
    }
}
