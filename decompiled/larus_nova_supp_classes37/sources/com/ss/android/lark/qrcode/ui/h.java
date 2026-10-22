package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.core.api.BarcodeFormat;
import com.ss.android.lark.biz.core.api.BaseCodeType;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import com.ss.android.lark.biz.core.api.VEBaseScanResult;
import com.ss.android.lark.biz.core.api.VEScanStrategy;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.DynamicPlugins;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.medialib.model.Enigma;
import com.ss.android.medialib.model.EnigmaResult;
import com.ss.android.medialib.qr.PicScanner;
import com.ss.android.medialib.qr.ScanSettings;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.algorithm.VEThirdQRCodeDetectParam;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final List<IQRCodeScanResultHandler> a;
    public final List<IQRCodeScanResultHandler> b;
    public dxa.b c;
    public final a2c.a d;
    public QRCodeScanFragment e;
    public final Handler f;
    public final Boolean g;
    public final Boolean h;

    public class a implements PicScanner.a {
        public final /* synthetic */ PicScanner a;
        public final /* synthetic */ EnigmaResult b;
        public final /* synthetic */ Object c;

        public a(PicScanner r1, EnigmaResult r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class b implements com.ss.android.lark.qrcode.ui.a.b {
        public final Bitmap a;

        public b(Bitmap r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.qrcode.ui.a.b
        public final int a(PicScanner r3) {
            return r3.start(this.a, new ScanSettings());
        }
    }

    public static final class c {
        public static final h a = null;

        static {
            a = new h();
        }
    }

    public static class d implements com.ss.android.lark.qrcode.ui.a.b {
        public final String a;

        public d(String r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.qrcode.ui.a.b
        public final int a(PicScanner r3) {
            return r3.start(this.a, new ScanSettings());
        }
    }

    private Context getContext() {
        dxa.b r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    public static boolean k() {
        boolean r0 = z1c.a.a.isFeatureGatingEnable("im.scan_code.multi_code_identification");
        Log.i("QRCodeScanManager", "im.scan_code.multi_code_identification is " + r0);
        if (r0 == true) goto L5;
        return false;
    L5:
        Log.i("QRCodeScanManager", "im.scan_code.multi_code_identification is true");
        LarkBuildConfig r1 = LarkAppContext.inst().buildConfig();
        if (r1.isHWComponentEnabled() == false) goto L10;
        Log.i("QRCodeScanManager", "isHWComponentEnabled is true");
        return true;
    L10:
        if (r1.isPluginEnable(DynamicPlugins.HW) == true) goto L13;
        Log.i("QRCodeScanManager", "MiraModule.isPluginEnable is false");
        return false;
    L13:
        int r2 = vrb.a.a;
        Intrinsics.checkNotNullParameter("com.ss.android.lark.plugin.hw_sdk", "pluginPackageName");
        Log.i("QRCodeScanManager", "MiraModule.isPluginInstalled is false");
        return false;
    }

    public static boolean l() {
        boolean r0 = z1c.a.a.isFeatureGatingEnable("im.scan_code.use_enigma_detect");
        Log.i("QRCodeScanManager", "im.scan_code.use_enigma_detect is " + r0);
        return r0;
    }

    public final VEBachQRCodeParam.Builder j() {
        AtomicBoolean r0 = com.ss.android.lark.videosend.tools.f.a;
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L11;
        if (this.h.booleanValue() == false) goto L7;
        int r1 = 4095;
    L9:
        return new VEBachQRCodeParam.Builder().setCodeType(r1).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.PICTURE).setRunSyncMode(true);
    L7:
        r1 = 4093;
        goto L9
    L11:
        if (this.h.booleanValue() == false) goto L13;
        int r2 = 1023;
    L15:
        return new VEBachQRCodeParam.Builder().setCodeType(r2).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.PICTURE).setRunSyncMode(true);
    L13:
        r2 = 1021;
        goto L15
    }

    public h() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        ArrayList r1 = new ArrayList();
        this.b = r1;
        this.f = new Handler(Looper.getMainLooper());
        Boolean r2 = Boolean.FALSE;
        this.g = r2;
        this.h = r2;
        VideoTools.checkToInitSDK();
        a2c.a r3 = z1c.a.a;
        this.d = r3;
        if (r3 != null) goto L5;
        Log.e("QRCodeScanManager", "QRCodeModule.getDependency() is null");
        return;
    L5:
        r0.addAll(r3.getQRCodeHandlers());
        this.g = Boolean.valueOf(!m());
        this.h = Boolean.valueOf(r3.isFeatureGatingEnable("lark.im.scan_ve_algorithm.enableVortextCode"));
        r1.addAll(r3.getQRCodeInterceptHandlers());
        r1.addAll(((soc.a) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(soc.a.class)).getInterceptors());
    }

    public static boolean m() {
        if (k() == false) goto L7;
        boolean r0 = z1c.a.a.isFeatureGatingEnable("im.scan_code.use_bach");
        Log.i("QRCodeScanManager", "im.scan_code.use_bach is " + r0);
        if (r0 == false) goto L7;
    L8:
        return true;
    L7:
        if (k() == false) goto L8;
        return false;
    }

    public final void n() {
        Context r0 = getContext();
        if (r0 == null) goto L8;
        Vibrator r1 = (Vibrator) r0.getSystemService("vibrator");
        if (r1 == null) goto L9;
        r1.vibrate(200);
        return;
    L9:
        return;
    }

    public static dxa.g c(com.ss.android.lark.qrcode.ui.a.b r7) {
        Object r1 = new Object();
        PicScanner r2 = new PicScanner();
        EnigmaResult r3 = new EnigmaResult();     // Catch: Throwable -> L34
        r2.setListener(new a(r2, r3, r1));     // Catch: Throwable -> L34
        monitor-enter(r1);     // Catch: InterruptedException -> L31 Throwable -> L34
        int r8 = r7.a(r2);     // Catch: Throwable -> L28
        if (r8 == 0) goto L13;
        Log.w("QRCodeScanManager", "decodeQRCode start failed, startResult = " + r8);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
    L38:
    L10:
        r2.stop();
        r2.release();
        return null;
    L13:
        r1.wait(3000);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        Enigma[] r9 = r3.getResult();     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r9 == null) goto L38;
        if (r9.length <= 0) goto L38;
        Enigma r10 = r9[0];     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r10 == null) goto L38;
        String r0 = r10.getText();     // Catch: InterruptedException -> L31 Throwable -> L34
        if (r10.getType() != 1) goto L38;
        if (r0 == null) goto L25;
        BarcodeFormat r4 = BarcodeFormat.CODABAR;     // Catch: InterruptedException -> L31 Throwable -> L34
        dxa.g r11 = new dxa.g(r0);     // Catch: InterruptedException -> L31 Throwable -> L34
    L26:
        r2.stop();
        r2.release();
        return r11;
    L25:
        BarcodeFormat r5 = BarcodeFormat.CODABAR;     // Catch: InterruptedException -> L31 Throwable -> L34
        r11 = new dxa.g("");     // Catch: InterruptedException -> L31 Throwable -> L34
    L28:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L31 Throwable -> L34
    L31:
        e = move-exception;
        Log.e("QRCodeScanManager", "Scanning is interrupted", e);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r2.stop();
        r2.release();
        throw th;
    }

    public static dxa.g e(VEBachQRCodeParam r18) {
        long r0 = System.currentTimeMillis();
        List r2 = VEUtils.scanPicture(r18);
        if (CollectionUtils.isEmpty(r2) == false) goto L21;
        Log.i("QRCodeScanManager", "scan result is isEmpty");
        return new dxa.g("");
    L21:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L20
        int r6 = 0;
    L8:
        if (r6 >= r2.size()) goto L14;
        VEBachQRCodeResult r7 = (VEBachQRCodeResult) ListProtector.get(r2, r6);     // Catch: Throwable -> L20
        int r13 = a(r7.getCurrentFrameWidth(), r7.getLocation(), 0, true);     // Catch: Throwable -> L20
        int r14 = a(r7.getCurrentFrameWidth(), r7.getLocation(), 0, false);     // Catch: Throwable -> L20
        int r15 = a(r7.getCurrentFrameHeight(), r7.getLocation(), 1, true);     // Catch: Throwable -> L20
        int r16 = a(r7.getCurrentFrameHeight(), r7.getLocation(), 1, false);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r7.getResult()) == true) goto L12;
        String r12 = r7.getResult();     // Catch: Throwable -> L20
        r7.getIsFromBach();     // Catch: Throwable -> L20
        r7.getCurrentFrameWidth();     // Catch: Throwable -> L20
        r7.getCurrentFrameHeight();     // Catch: Throwable -> L20
        r7.getCurrentFrame();     // Catch: Throwable -> L20
        r3.add(new dxa.f(r12, r13, r14, r15, r16, r7.getCodeType()));     // Catch: Throwable -> L20
        c2c.a.b(System.currentTimeMillis() - r0, r7);     // Catch: Throwable -> L20
        Log.i("QRCodeScanManager", "res is * ,codeType is " + r7.getCodeType() + " ,left is " + r7.getLeft() + " ,right is " + r7.getRight() + " ,top is " + r7.getTop() + " ,bottom is " + r7.getBottom() + " ,isFromBach is " + r7.getIsFromBach());     // Catch: Throwable -> L20
    L12:
        r6 = r6 + 1;     // Catch: Throwable -> L20
        goto L8
    L14:
        if (CollectionUtils.isEmpty(r3) == true) goto L17;
        dxa.f r1 = (dxa.f) ListProtector.get(r3, 0);     // Catch: Throwable -> L20
        String r4 = r1.a;     // Catch: Throwable -> L20
        f(r1.f);     // Catch: Throwable -> L20
        return new dxa.g(r4, r3);
    L17:
        Log.i("QRCodeScanManager", "scan pic return non-zero code. return default empty value");     // Catch: Throwable -> L20
        return null;
    L25:
        return null;
    }

    public static BarcodeFormat f(int r2) {
        a2c.a r0 = z1c.a.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.isFeatureGatingEnable("im.scan_code.support_code_type_93");
    L7:
        if (r1 == false) goto L31;
        switch(r2) {
            case 1: goto L29;
            case 4: goto L27;
            case 8: goto L25;
            case 16: goto L23;
            case 32: goto L25;
            case 64: goto L21;
            case 128: goto L19;
            case 256: goto L17;
            case 512: goto L15;
            case 1024: goto L13;
            case 2048: goto L11;
            default: goto L9;
        };
    L9:
        return null;
    L11:
        return BarcodeFormat.CODE_ITF;
    L13:
        return BarcodeFormat.CODE_93;
    L15:
        return BarcodeFormat.PDF_417;
    L17:
        return BarcodeFormat.DATA_MATRIX;
    L19:
        return BarcodeFormat.CODE_128;
    L21:
        return BarcodeFormat.CODE_39;
    L23:
        return BarcodeFormat.EAN_8;
    L25:
        return BarcodeFormat.UPC_E;
    L27:
        return BarcodeFormat.UPC_A;
    L29:
        return BarcodeFormat.QR_CODE;
    L31:
        if (r2 == 1) goto L64;
        if (r2 == 4) goto L62;
        if (r2 == 8) goto L60;
        if (r2 == 16) goto L58;
        if (r2 == 32) goto L60;
        if (r2 == 64) goto L56;
        if (r2 == 128) goto L54;
        if (r2 == 256) goto L52;
        if (r2 == 512) goto L50;
        return null;
    L50:
        return BarcodeFormat.PDF_417;
    L52:
        return BarcodeFormat.DATA_MATRIX;
    L54:
        return BarcodeFormat.CODE_128;
    L56:
        return BarcodeFormat.CODE_39;
    L58:
        return BarcodeFormat.EAN_8;
    L60:
        return BarcodeFormat.UPC_E;
    L62:
        return BarcodeFormat.UPC_A;
    L64:
        return BarcodeFormat.QR_CODE;
    L5:
        r1 = false;
        goto L7
    }

    public final VEBachQRCodeParam h(Bitmap r2) {
        AtomicBoolean r0 = com.ss.android.lark.videosend.tools.f.a;
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L7;
        return j().setBitmap(r2).setMultoCode(true).build();
    L7:
        return j().setBitmap(r2).build();
    }

    public final VEBachQRCodeParam i(String r2) {
        AtomicBoolean r0 = com.ss.android.lark.videosend.tools.f.a;
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L7;
        return j().setPicturePath(r2).setMultoCode(true).build();
    L7:
        return j().setPicturePath(r2).build();
    }

    public static ArrayList g(dxa.g r20, Bitmap r21) {
        float r1 = r21.getWidth();
        float r2 = r21.getHeight();
        ArrayList r3 = new ArrayList();
        if (r20 == null) goto L49;
        List r4 = r20.b;
        if (r4 == null) goto L48;
        Iterator r0 = r4.iterator();
    L8:
        if (r0.hasNext() == false) goto L49;
        dxa.f r5 = (dxa.f) r0.next();
        String r6 = r5.a;
        float r7 = r5.b / r1;
        float r8 = r5.d / r2;
        float r9 = r5.c / r1;
        float r10 = r5.e / r2;
        int r11 = r5.f;
        if (z1c.a.a.isFeatureGatingEnable("im.scan_code.support_code_type_93") == false) goto L31;
        if (r11 == 4) goto L30;
        if (r11 == 8) goto L30;
        if (r11 == 16) goto L30;
        if (r11 == 32) goto L30;
        if (r11 == 64) goto L30;
        if (r11 == 128) goto L30;
        if (r11 == 512) goto L30;
        if (r11 == 1024) goto L30;
        if (r11 == 2048) goto L30;
        if (r11 == 514) goto L30;
        if (r11 == 515) goto L30;
        BaseCodeType r12 = BaseCodeType.QRCODE;
    L47:
        r3.add(new VEBaseScanResult(r6, r7, r8, r9, r10, r12));
    L30:
        r12 = BaseCodeType.BARCODE;
        goto L47
    L31:
        if (r11 == 4) goto L46;
        if (r11 == 8) goto L46;
        if (r11 == 16) goto L46;
        if (r11 == 32) goto L46;
        if (r11 == 64) goto L46;
        if (r11 == 128) goto L46;
        if (r11 == 512) goto L46;
        if (r11 == 514) goto L46;
        if (r11 == 515) goto L46;
        r12 = BaseCodeType.QRCODE;
    L46:
        r12 = BaseCodeType.BARCODE;
        goto L47
    L48:
        r3.add(new VEBaseScanResult(r20.a, 0.0f, 0.0f, 0.0f, 0.0f, BaseCodeType.QRCODE));
    L49:
        return r3;
    }

    public final void b(IGetDataCallback<dxa.g> r3, String r4) {
        VEBachQRCodeParam r5 = i(r4);
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L5;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new g(this, r5, r3));
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new f(this, r5, r3));
    }

    public final dxa.g d(b r17, Bitmap r18, VEScanStrategy r19) {
        if (r19 != VEScanStrategy.HW_SCAN) goto L30;
        if (this.g.booleanValue() == false) goto L30;
        VEThirdQRCodeDetectParam r2 = new VEThirdQRCodeDetectParam();
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L9;
        this.h.booleanValue();
        r2.codeType = 4095;
    L10:
        ArrayList r3 = new ArrayList();
        if (r18 == null) goto L13;
        ((VEBachAlgorithmParam) r2).bitmap = r18;
    L13:
        r2.isMultiCode = true;
        List r4 = VEUtils.scanPicture(r2);
        if (CollectionUtils.isEmpty(r4) == false) goto L16;
        Log.i("QRCodeScanManager", "scan result is isEmpty");
        return new dxa.g("", r3);
    L16:
        int r5 = 0;
    L18:
        if (r5 >= r4.size()) goto L28;
        VEBachQRCodeResult r7 = (VEBachQRCodeResult) ListProtector.get(r4, r5);
        if (r7.getRetCode() >= 0) goto L26;
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L42;
        if (r18 == null) goto L26;
        return e(h(r18));
    L42:
        return c(r17);
    L26:
        String r9 = r7.getResult();
        int r10 = r7.getLeft();
        int r11 = r7.getRight();
        int r12 = r7.getTop();
        int r13 = r7.getBottom();
        r7.getIsFromBach();
        r7.getCurrentFrameWidth();
        r7.getCurrentFrameHeight();
        r7.getCurrentFrame();
        r3.add(new dxa.f(r9, r10, r11, r12, r13, r7.getCodeType()));
        Log.i("QRCodeScanManager", "res is * ,codeType is " + r7.getCodeType() + " ,left is " + r7.getLeft() + " ,right is " + r7.getRight() + " ,top is " + r7.getTop() + " ,bottom is " + r7.getBottom() + " ,isFromBach is " + r7.getIsFromBach());
        r5 = r5 + 1;
        goto L18
    L28:
        return new dxa.g("", r3);
    L9:
        this.h.booleanValue();
        r2.codeType = 1023;
    L30:
        if (com.ss.android.lark.videosend.tools.f.e == false) goto L34;
        return e(h(r18));
    L34:
        return c(r17);
    }

    public static int a(int r4, float[][] r5, int r6, boolean r7) {
        if (r7 == false) goto L4;
        float r0 = Float.MAX_VALUE;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        float r3 = r5[r2][r6];
        if (r7 == false) goto L10;
        r0 = Math.min(r0, r3);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r0 = Math.max(r0, r3);
        goto L11
    L13:
        return (int) (r0 * r4);
    L4:
        r0 = Float.MIN_VALUE;
        goto L5
    }
}
