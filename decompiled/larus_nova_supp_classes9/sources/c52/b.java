package c52;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b extends a52.a<d52.b, Integer> {
    public final int a;
    public final float b;
    public final float c;
    public final float d;

    public abstract int d();

    public abstract int f();

    public b() {
        this.a = UtilityKotlinExtentionsKt.i(100);
        this.b = f.a().highHeightMultiFactor;
        this.c = f.a().midHeightMultiFactor;
        this.d = f.a().lowHeightMultiFactor;
    }

    public final int c() {
        return (int) (((((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(330)) - f()) - d()) * (1 - this.c));
    }

    public final int e() {
        return f() + ((int) (((((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(330)) - f()) - d()) * this.c));
    }

    @Override // a52.a
    public final BaseStyleSettingModel<d52.b> a() {
        return z42.a.c;
    }

    @Override // a52.a
    public final /* bridge */ /* synthetic */ Integer b(d52.c r1) {
        return g((d52.b) r1);
    }

    public final Integer g(d52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "style");
        if (c() >= 0) goto L7;
        return Integer.valueOf(e());
    L7:
        if (Intrinsics.areEqual(r3, d52.b.C0225b.a) == false) goto L11;
        int r4 = e();
        float r0 = c();
        float r1 = this.d;
    L9:
        int r5 = r4 + ((int) (r0 * r1));
    L17:
        return Integer.valueOf(RangesKt.coerceAtLeast(r5, this.a));
    L11:
        if (Intrinsics.areEqual(r3, d52.b.a.b) == false) goto L14;
        r4 = e();
        r0 = c();
        r1 = this.b;
        goto L9
    L14:
        if (Intrinsics.areEqual(r3, d52.b.c.b) == false) goto L19;
        r5 = e();
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
