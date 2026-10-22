package com.xiphias.browser.scanner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.ScannerContainerView;
import com.xiphias.browser.scanner.ScannerMaskView;
import com.xiphias.browser.scanner.util.AutoFitSurfaceView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityScannerBinding implements ViewBinding {
    public final OTextView barcodeScanHint;
    public final AutoFitSurfaceView barcodeScanner;
    public final View captureVisualSearch;
    public final OIconButtonFloating exitBarcodeScan;
    public final ScannerContainerView inactivePage;
    public final ConstraintLayout main;
    public final Button modeBarcode;
    public final Button modeDocument;
    public final Button modeExtractText;
    public final Button modeGeneral;
    public final Button modeGoods;
    public final Button modeQuestion;
    public final Button modeTranslate;
    private final ConstraintLayout rootView;
    public final ConstraintLayout scannerActionContainer;
    public final ScannerMaskView scannerMask;
    public final LinearLayout scannerModeContainer;
    public final HorizontalScrollView scannerModeScroll;
    public final ScannerContainerView scannerPage;
    public final OIconButtonFloating selectPicture;
    public final OIconButtonFloating toggleFlashlight;

    private ActivityScannerBinding(ConstraintLayout r3, OTextView r4, AutoFitSurfaceView r5, View r6, OIconButtonFloating r7, ScannerContainerView r8, ConstraintLayout r9, Button r10, Button r11, Button r12, Button r13, Button r14, Button r15, Button r16, ConstraintLayout r17, ScannerMaskView r18, LinearLayout r19, HorizontalScrollView r20, ScannerContainerView r21, OIconButtonFloating r22, OIconButtonFloating r23) {
        this.rootView = r3;
        this.barcodeScanHint = r4;
        this.barcodeScanner = r5;
        this.captureVisualSearch = r6;
        this.exitBarcodeScan = r7;
        this.inactivePage = r8;
        this.main = r9;
        this.modeBarcode = r10;
        this.modeDocument = r11;
        this.modeExtractText = r12;
        this.modeGeneral = r13;
        this.modeGoods = r14;
        this.modeQuestion = r15;
        this.modeTranslate = r16;
        this.scannerActionContainer = r17;
        this.scannerMask = r18;
        this.scannerModeContainer = r19;
        this.scannerModeScroll = r20;
        this.scannerPage = r21;
        this.selectPicture = r22;
        this.toggleFlashlight = r23;
    }

    public static ActivityScannerBinding bind(View r28) {
        int r1 = ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint");
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.barcode_scanner, OaidModel.KEY_ID, "barcode_scanner");
        AutoFitSurfaceView r9 = (AutoFitSurfaceView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), AutoFitSurfaceView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search");
        View r10 = ViewBindings.findChildViewById(r28, r1);
        if (r10 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.exit_barcode_scan, OaidModel.KEY_ID, "exit_barcode_scan");
        OIconButtonFloating r11 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.inactive_page, OaidModel.KEY_ID, "inactive_page");
        ScannerContainerView r12 = (ScannerContainerView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), ScannerContainerView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L43;
        ConstraintLayout r13 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r28, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.mode_barcode, OaidModel.KEY_ID, "mode_barcode");
        Button r14 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_document, OaidModel.KEY_ID, "mode_document");
        Button r15 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_extract_text, OaidModel.KEY_ID, "mode_extract_text");
        Button r16 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_general, OaidModel.KEY_ID, "mode_general");
        Button r17 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_goods, OaidModel.KEY_ID, "mode_goods");
        Button r18 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_question, OaidModel.KEY_ID, "mode_question");
        Button r19 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.mode_translate, OaidModel.KEY_ID, "mode_translate");
        Button r20 = (Button) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), Button.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.scanner_action_container, OaidModel.KEY_ID, "scanner_action_container");
        ConstraintLayout r21 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.scanner_mask, OaidModel.KEY_ID, "scanner_mask");
        ScannerMaskView r22 = (ScannerMaskView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), ScannerMaskView.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.scanner_mode_container, OaidModel.KEY_ID, "scanner_mode_container");
        LinearLayout r23 = (LinearLayout) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.scanner_mode_scroll, OaidModel.KEY_ID, "scanner_mode_scroll");
        HorizontalScrollView r24 = (HorizontalScrollView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), HorizontalScrollView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.scanner_page, OaidModel.KEY_ID, "scanner_page");
        ScannerContainerView r25 = (ScannerContainerView) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), ScannerContainerView.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.select_picture, OaidModel.KEY_ID, "select_picture");
        OIconButtonFloating r26 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L43;
        r1 = ZeusTransformUtils.mapRes(R.id.toggle_flashlight, OaidModel.KEY_ID, "toggle_flashlight");
        OIconButtonFloating r27 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(ViewBindings.findChildViewById(r28, r1), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L43;
        return new ActivityScannerBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r28, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r28, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityScannerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityScannerBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_scanner, "layout", "activity_scanner"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
