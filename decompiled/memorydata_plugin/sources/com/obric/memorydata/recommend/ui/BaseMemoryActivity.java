package com.obric.memorydata.recommend.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.g;
import com.obric.oui.titlebar.OCTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/BaseMemoryActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initTitleBar", "titleBar", "Lcom/obric/oui/titlebar/OCTitleBar;", "setupImmersiveStatusBars", "light", "", "isDarkMode", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseMemoryActivity extends FragmentActivity {
    public BaseMemoryActivity() {
    }

    private static final void initTitleBar$lambda$0(BaseMemoryActivity r1, View r2) {
        ((BaseMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, BaseMemoryActivity.class, "com.obric.memorydata.plugin")).finish();
    }

    /* JADX INFO: renamed from: lambda$Soqq96-lvMFI87ii-yVZxpPx9BY, reason: not valid java name */
    public static /* synthetic */ void m1138lambda$Soqq96lvMFI87iiyVZxpPx9BY(BaseMemoryActivity r0, View r1) {
        initTitleBar$lambda$0(r0, r1);
    }

    private final void setupImmersiveStatusBars(FragmentActivity r5, boolean r6, boolean r7) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r5, FragmentActivity.class, "com.obric.memorydata.plugin");
        WindowCompat.setDecorFitsSystemWindows(r4.getWindow(), false);
        boolean r1 = true;
        r4.getWindow().setStatusBarColor(Color.argb(1, 255, 255, 255));
        Window r8 = r4.getWindow();
        Intrinsics.checkNotNullExpressionValue(r8, "getWindow(...)");
        g.a(r8, NavigationBarScheme.B1);
        WindowInsetsControllerCompat r9 = WindowCompat.getInsetsController(r4.getWindow(), r4.getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(r9, "getInsetsController(...)");
        Window r10 = r4.getWindow();
        Intrinsics.checkNotNullExpressionValue(r10, "getWindow(...)");
        if (r7 == true) goto L6;
        if (r6 == false) goto L6;
    L7:
        g.a(r10, r1);
        if (r7 == false) goto L10;
        r9.setAppearanceLightStatusBars(false);
        return;
    L10:
        r9.setAppearanceLightStatusBars(r6);
        return;
    L6:
        r1 = false;
        goto L7
    }

    static /* synthetic */ void setupImmersiveStatusBars$default(BaseMemoryActivity r2, FragmentActivity r3, boolean r4, boolean r5, int r6, Object r7) {
        BaseMemoryActivity r8 = (BaseMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 2) == 0) goto L7;
        r5 = false;
    L7:
        r8.setupImmersiveStatusBars(r9, r4, r5);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupImmersiveStatusBars");
    }

    public void initTitleBar(OCTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "titleBar");
        r2.getMLeftActionBack().setOnClickListener(new $$Lambda$BaseMemoryActivity$Soqq96lvMFI87iiyVZxpPx9BY(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        setupImmersiveStatusBars((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin"), true, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
