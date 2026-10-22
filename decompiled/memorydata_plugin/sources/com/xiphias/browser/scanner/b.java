package com.xiphias.browser.scanner;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.databinding.ActivityScannerBinding;
import com.xiphias.browser.scanner.util.AutoFitSurfaceView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/xiphias/browser/scanner/DefaultScannerUi;", "Lcom/xiphias/browser/scanner/BaseScannerUi;", "<init>", "()V", "create", "Lcom/xiphias/browser/scanner/ScannerUiBinding;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "controller", "Lcom/xiphias/browser/scanner/ScannerUiController;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements a {
    public b() {
    }

    private static final Unit a(h r2) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin")).b();
        return Unit.INSTANCE;
    }

    private static final void a(h r1, View r2) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.memorydata.plugin")).a();
    }

    private static final void b(h r1, View r2) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.memorydata.plugin")).c();
    }

    public static /* synthetic */ void lambda$Odj9imjdTXyQ0v9ecIZ4iqNtbMM(h r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$aQwyEMv0onzyYhi3fu9qBNliUsE(h r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$byAYA_KDHkDZ4CyuSdrOfuXj3M8(h r0, View r1) {
        a(r0, r1);
    }

    @Override // com.xiphias.browser.scanner.a
    public g a(AppCompatActivity r8, h r9) {
        AppCompatActivity r7 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r8, AppCompatActivity.class, "com.obric.memorydata.plugin");
        final h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r10, "controller");
        ActivityScannerBinding r11 = ActivityScannerBinding.inflate(r7.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
        r11.exitBarcodeScan.setOnClickListener(new $$Lambda$b$byAYA_KDHkDZ4CyuSdrOfuXj3M8(r10));
        r11.scannerPage.setHandleInterceptEvent(new $$Lambda$b$aQwyEMv0onzyYhi3fu9qBNliUsE(r10));
        r11.inactivePage.setOnClickListener(new $$Lambda$b$Odj9imjdTXyQ0v9ecIZ4iqNtbMM(r10));
        r11.scannerModeScroll.setVisibility(8);
        r11.scannerActionContainer.setVisibility(8);
        r11.barcodeScanHint.setText(ZeusTransformUtils.mapRes(R.string.same_network_hint, TypedValues.Custom.S_STRING, "same_network_hint"));
        ConstraintLayout r12 = r11.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
        ScannerContainerView r13 = r11.scannerPage;
        Intrinsics.checkNotNullExpressionValue(r13, "scannerPage");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin");
        ScannerContainerView r14 = r11.inactivePage;
        Intrinsics.checkNotNullExpressionValue(r14, "inactivePage");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
        AutoFitSurfaceView r5 = r11.barcodeScanner;
        Intrinsics.checkNotNullExpressionValue(r5, "barcodeScanner");
        ScannerMaskView r6 = r11.scannerMask;
        Intrinsics.checkNotNullExpressionValue(r6, "scannerMask");
        return new g(r2, r3, r4, r5, r6);
    }
}
