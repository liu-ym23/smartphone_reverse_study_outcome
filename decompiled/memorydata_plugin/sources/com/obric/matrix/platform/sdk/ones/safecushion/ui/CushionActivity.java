package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.matrix.platform.sdk.ones.safecushion.c;
import com.obric.matrix.platform.sdk.ones.safecushion.d;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity;", "Landroid/app/Activity;", "()V", "config", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "getConfig", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "controller", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$CushionControllerImpl;", "flagHelper", "Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "repairHandler", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "CushionControllerImpl", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CushionActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f8142b;
    private final com.obric.matrix.platform.sdk.ones.safecushion.a.b c;
    private final com.obric.matrix.platform.sdk.ones.safecushion.repair.b d;
    private final b e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016JR\u0010\u0019\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$CushionControllerImpl;", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionController;", "(Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity;)V", "crashCount", "", "getCrashCount", "()I", "mode", "", "getMode", "()Ljava/lang/String;", "repairAliases", "", "getRepairAliases", "()Ljava/util/List;", "finish", "", "killApp", "killSelf", "markFinished", "openMarket", "", "openMarketByWeb", "pkgName", "restartApp", "startRepair", "repairList", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "success", NotificationCompat.CATEGORY_MESSAGE, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class b implements com.obric.matrix.platform.sdk.ones.safecushion.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CushionActivity f8143a;

        public b(CushionActivity r3) {
            this.f8143a = (CushionActivity) ZeusTransformUtils.wrapperContextForParams(r3, CushionActivity.class, "com.obric.memorydata.plugin");
        }

        public String a() {
            String r0 = CushionActivity.a(this.f8143a).e();
            if (r0 != null) goto L6;
            return "repair";
        L6:
            return r0;
        }
    }

    static {
        f8141a = new a(null);
    }

    public CushionActivity() {
        this.f8142b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.c = new com.obric.matrix.platform.sdk.ones.safecushion.a.b();
        this.d = new com.obric.matrix.platform.sdk.ones.safecushion.repair.b();
        this.e = new b(this);
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.safecushion.a.b a(CushionActivity r2) {
        return ((CushionActivity) ZeusTransformUtils.wrapperContextForParams(r2, CushionActivity.class, "com.obric.memorydata.plugin")).c;
    }

    private final com.obric.matrix.platform.sdk.ones.safecushion.b a() {
        return c.f8131a.a().a();
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r5) {
        super/*android.app.Activity*/.onCreate(r5);
        com.obric.matrix.platform.sdk.ones.safecushion.ui.b r6 = a().c();
        if (r6 != null) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("CushionActivity", "onCreate: uiProvider is null, finish", null, 4, null);
        finish();
        return;
    L6:
        d.f8133a.a();
        setContentView(r6.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), (com.obric.matrix.platform.sdk.ones.safecushion.ui.a) ZeusTransformUtils.preCheckCast(this.e, com.obric.matrix.platform.sdk.ones.safecushion.ui.a.class, "com.obric.memorydata.plugin")));
        this.c.b(this.e.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        com.obric.matrix.platform.sdk.ones.safecushion.ui.b r0 = a().c();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
