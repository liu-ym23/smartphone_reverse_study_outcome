package b52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import d52.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends a52.a<d52.a, Float> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // a52.a
    public final BaseStyleSettingModel<d52.a> a() {
        return y42.a.c;
    }

    public static Float c(d52.a r1) {
        Intrinsics.checkNotNullParameter(r1, "style");
        if (Intrinsics.areEqual(r1, d52.a.C0224a.b) == false) goto L6;
        float r2 = PublicScreenABHelper.h().fontSize;
        float r0 = 16.0f;
    L8:
        float r3 = r0 / r2;
    L13:
        return Float.valueOf(r3);
    L6:
        if (Intrinsics.areEqual(r1, d52.a.b.b) == false) goto L10;
        r2 = PublicScreenABHelper.h().fontSize;
        r0 = 18.0f;
        goto L8
    L10:
        if (Intrinsics.areEqual(r1, d52.a.c.a) == false) goto L15;
        r3 = 1.0f;
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // a52.a
    public final /* bridge */ /* synthetic */ Float b(c r1) {
        return c((d52.a) r1);
    }
}
