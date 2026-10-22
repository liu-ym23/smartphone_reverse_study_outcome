package com.obric.memorydata.memory.utils;

import android.app.Activity;
import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.larus.permission.ExplainRequestDialog;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.ScannerContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/utils/QrScannerHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onScanSuccess", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function1;)V", "scannerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/xiphias/browser/scanner/ScannerOptions;", "requestCameraPermissionLauncher", "startScan", "showExplainDialog", "dismissExplainDialog", "CameraPermissionRequestCallback", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f11559b;
    private final Function1<String, Unit> c;
    private final ActivityResultLauncher<com.xiphias.browser.scanner.f> d;
    private final ActivityResultLauncher<String> e;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/utils/QrScannerHelper$CameraPermissionRequestCallback;", "Lcom/obric/memorydata/memory/permission/IRequestPermissionCallback;", "<init>", "(Lcom/obric/memorydata/memory/utils/QrScannerHelper;)V", "onResult", "", "allGranted", "", "grantedList", "", "", "deniedList", "getGoSettingPagePermissionParams", "getShowGoSettingPageDialogTitle", "getShowGoSettingPageDialogMessage", "onGoSettingPageFailed", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class a implements com.obric.memorydata.memory.permission.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f11560a;

        public a(n r1) {
            this.f11560a = r1;
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String a() {
            String r3 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(n.a(this.f11560a), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_camera_go_setting_page_dialog_title, TypedValues.Custom.S_STRING, "memory_camera_go_setting_page_dialog_title"));
            Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
            return r3;
        }

        @Override // com.obric.memorydata.memory.permission.a
        public void a(List<String> r3) {
            com.obric.memorydata.memory.permission.a.C0508a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String b() {
            String r3 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(n.a(this.f11560a), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_camera_go_setting_page_dialog_message, TypedValues.Custom.S_STRING, "memory_camera_go_setting_page_dialog_message"));
            Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
            return r3;
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String b(List<String> r2) {
            Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "deniedList");
            return "android.permission-group.CAMERA";
        }

        @Override // com.obric.memorydata.memory.permission.a
        public void c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/utils/QrScannerHelper$Companion;", "", "<init>", "()V", "EXPLAIN_DIALOG_TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11558a = new b(null);
    }

    public n(FragmentActivity r4, Function1<? super String, Unit> r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "onScanSuccess");
        this.f11559b = r6;
        this.c = r7;
        ActivityResultLauncher<com.xiphias.browser.scanner.f> r8 = r6.registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ScannerContract(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$n$WpcMR4u73Q2yUgMSqgrcdxShqtM(this));
        Intrinsics.checkNotNullExpressionValue(r8, "registerForActivityResult(...)");
        this.d = r8;
        ActivityResultLauncher<String> r9 = r6.registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.RequestPermission(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$n$3QXJR_cHfGgLJAmQV1tDDwezmo(this));
        Intrinsics.checkNotNullExpressionValue(r9, "registerForActivityResult(...)");
        this.e = r9;
    }

    public static final /* synthetic */ FragmentActivity a(n r0) {
        return r0.f11559b;
    }

    private static final void a(n r3, com.xiphias.browser.scanner.e r4) {
        Integer r0 = r4.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() == (-1)) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        r3.c.invoke(r4.b());
        return;
    }

    private static final void a(n r4, Boolean r5) {
        r4.c();
        if (r5.booleanValue() == false) goto L6;
        r4.d.launch(new com.xiphias.browser.scanner.f(null, 1, null));
        return;
    L6:
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) ZeusTransformUtils.preCheckCast(r4.f11559b, Activity.class, "com.obric.memorydata.plugin"), "android.permission.CAMERA") == true) goto L8;
        com.obric.memorydata.memory.permission.d.f10344a.a(r4.f11559b, CollectionsKt.listOf("android.permission.CAMERA"), (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.preCheckCast(new a(r4), com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r4.f11559b, Context.class, "com.obric.memorydata.plugin");
        String r7 = r4.f11559b.getString(ZeusTransformUtils.mapRes(R.string.memory_camera_permission_denied, TypedValues.Custom.S_STRING, "memory_camera_permission_denied"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        ba.a(r6, r7, 0, 4, null);
    }

    private final void b() {
        FragmentManager r0 = this.f11559b.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getSupportFragmentManager(...)");
        if (r0.findFragmentByTag("QrScannerCameraExplain") == null) goto L5;
        return;
    L5:
        ExplainRequestDialog.a r2 = ExplainRequestDialog.Companion;
        String r3 = this.f11559b.getString(ZeusTransformUtils.mapRes(R.string.larus_camera_authorization_topbar_title, TypedValues.Custom.S_STRING, "larus_camera_authorization_topbar_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        String r8 = this.f11559b.getString(ZeusTransformUtils.mapRes(R.string.larus_camera_authorization_message, TypedValues.Custom.S_STRING, "larus_camera_authorization_message"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        r2.a(r3, r8).show(r0, "QrScannerCameraExplain");
    }

    private final void c() {
        Fragment r2 = this.f11559b.getSupportFragmentManager().findFragmentByTag("QrScannerCameraExplain");
        if (ZeusTransformUtils.instanceOf(r2, ExplainRequestDialog.class) == false) goto L5;
        ExplainRequestDialog r3 = (ExplainRequestDialog) ZeusTransformUtils.preCheckCast(r2, ExplainRequestDialog.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L9;
        r3.dismiss();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$3QX-JR_cHfGgLJAmQV1tDDwezmo, reason: not valid java name */
    public static /* synthetic */ void m996lambda$3QXJR_cHfGgLJAmQV1tDDwezmo(n r0, Boolean r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$WpcMR4u73Q2yUgMSqgrcdxShqtM(n r0, com.xiphias.browser.scanner.e r1) {
        a(r0, r1);
    }

    public final void a() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(this.f11559b, Context.class, "com.obric.memorydata.plugin"), "android.permission.CAMERA") != 0) goto L5;
        this.d.launch(new com.xiphias.browser.scanner.f(null, 1, null));
        return;
    L5:
        b();
        this.e.launch("android.permission.CAMERA");
    }
}
