package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017¨\u0006\u000f"}, d2 = {"Landroidx/activity/EdgeToEdgeApi29;", "Landroidx/activity/EdgeToEdgeImpl;", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EdgeToEdgeApi29 implements EdgeToEdgeImpl {
    public EdgeToEdgeApi29() {
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(SystemBarStyle r5, SystemBarStyle r10, Window r11, View r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "statusBarStyle");
        Intrinsics.checkNotNullParameter(r10, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(r11, "window");
        Intrinsics.checkNotNullParameter(r12, "view");
        boolean r15 = false;
        WindowCompat.setDecorFitsSystemWindows(r11, false);
        r11.setStatusBarColor(r5.getScrimWithEnforcedContrast$activity_release(r13));
        r11.setNavigationBarColor(r10.getScrimWithEnforcedContrast$activity_release(r14));
        r11.setStatusBarContrastEnforced(false);
        if (r10.getNightMode$activity_release() != 0) goto L5;
        r15 = true;
    L5:
        r11.setNavigationBarContrastEnforced(r15);
        WindowInsetsControllerCompat r16 = new WindowInsetsControllerCompat(r11, r12);
        r16.setAppearanceLightStatusBars(!r13);
        r16.setAppearanceLightNavigationBars(!r14);
    }
}
