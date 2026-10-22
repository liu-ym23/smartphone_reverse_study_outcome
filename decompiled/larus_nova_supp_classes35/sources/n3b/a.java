package n3b;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements o3b.a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: n3b.a$a, reason: collision with other inner class name */
    public static final class C0263a {
    }

    static {
    }

    @Override // o3b.a
    public final int a() {
        return 36;
    }

    @Override // o3b.a
    public final int c() {
        return 54;
    }

    public a() {
        this.a = 12;
        this.b = 54;
        this.c = 0;
        this.d = 0;
    }

    public final int e(Context r4, Integer r5) {
        int r2 = UIUtils.dp2px(r4, 54) + (zz7.b.g(r4, 36) - UIUtils.dp2px(r4, 36));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.fold.support") == true) goto L5;
        int r6 = DeviceUtils.getScreenWidth(r4);
    L12:
        return (((r6 - r2) - UIUtils.dp2px(r4, this.b)) - zz7.b.g(r4, this.c)) - UIUtils.dp2px(r4, this.d);
    L5:
        if (r5 != null) goto L7;
    L10:
        r6 = DeviceUtils.getScreenWidth(r4);
        goto L12
    L7:
        if (r5.intValue() <= 0) goto L10;
        r6 = r5.intValue();
        goto L12
    }

    @Override // o3b.a
    public final int b(Context r1, Integer r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return (e(r1, r2) - (UIUtils.dp2px(r1, this.a) * 2)) - UIUtils.dp2px(r1, 2.0f);
    }

    @Override // o3b.a
    public final int d(Context r1, Integer r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return e(r1, r2);
    }
}
