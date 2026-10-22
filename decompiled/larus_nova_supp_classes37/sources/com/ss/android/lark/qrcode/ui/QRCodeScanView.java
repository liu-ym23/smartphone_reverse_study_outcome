package com.ss.android.lark.qrcode.ui;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.mvp.IView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.vesdk.VECameraSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class QRCodeScanView implements com.ss.android.lark.qrcode.ui.c {
    public final c a;
    public final FragmentActivity b;
    public com.ss.android.lark.qrcode.ui.c.a c;
    public final a0 d;
    public ScannerView e;
    public VECameraSettings.CAMERA_FLASH_MODE f;
    public boolean g;
    public LKUIStatus h;
    public a i;
    public final a2c.a j;
    public final c2c.a k;
    public final Long l;

    @BindView(8716)
    FrameLayout mCustomViewContainer;

    @BindView(8828)
    ImageView mFlashLight;

    @BindView(8829)
    TextView mFlashLightTips;

    @BindView(9522)
    CommonTitleBar mMyTitleBar;

    public class a extends OrientationEventListener {
        public int a;
        public TabletState b;
        public final /* synthetic */ QRCodeScanView c;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r3) {
            if (this.a != r3) goto L5;
            return;
        L5:
            if (r3 <= 80) goto L13;
            if (r3 >= 90) goto L13;
            if (this.b != TabletState.ROTATION_90) goto L11;
            this.c.d.getClass();
            this.c.d.getClass();
        L11:
            this.b = TabletState.ROTATION_270;
        L13:
            if (r3 > 260) goto L15;
        L20:
            this.a = r3;
            return;
        L15:
            if (r3 >= 280) goto L20;
            if (this.b != TabletState.ROTATION_270) goto L19;
            this.c.d.getClass();
            this.c.d.getClass();
        L19:
            this.b = TabletState.ROTATION_90;
            goto L20
        }

        public a(QRCodeScanView r1, FragmentActivity r2) {
            this.c = r1;
            super(r2);
            this.a = -1;
            this.b = TabletState.NULL;
        }
    }

    public class b implements com.ss.android.lark.utils.h.e {
        public final /* synthetic */ QRCodeScanView a;

        public b(QRCodeScanView r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            if (r2 == false) goto L4;
            fsb.f.b().i("FastQRCodeOnStart");
            this.a.d.getClass();
            fsb.f.b().h("FastQRCodeOnStart");
            fsb.f.b().e();
            return;
        L4:
            fsb.f.b().d();
        }
    }

    public interface c {
        void a(QRCodeScanView r1);

        void b();

        void c(View r1);
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void J4() {
        this.d.getClass();
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void K4() {
        FragmentActivity r0 = this.b;
        b r1 = new b(this);
        int r2 = com.ss.android.lark.utils.n.a;
        com.ss.android.lark.utils.h.d(r0, r1, "android.permission.CAMERA", null, new com.ss.android.lark.utils.l(2131890570, 2131890569, 2131890570, 2131890569, null, null, 240));
    }

    public final void create() {
        this.a.a(this);
        if ((this.b.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        boolean r0 = true;
    L6:
        a r1 = new a(this, this.b);
        this.i = r1;
        if (r1.canDetectOrientation() == false) goto L10;
        if (r0 == false) goto L10;
    L15:
        this.i.enable();
        this.g = true;
    L17:
        WindowInsetsUtils.f(this.b);
        WindowInsetsUtils.e(this.b);
        WindowInsetsUtils.d(this.b);
        CommonTitleBar r2 = this.mMyTitleBar;
        r2.setLeftImageDrawable(UDIconUtils.getIconDrawable(r2.getContext(), 2131254123));
        this.mMyTitleBar.getLeftDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.mMyTitleBar.setLeftClickListener(new r(this));
        this.mMyTitleBar.setImmersive(true);
        h.c.a.getClass();
        fsb.f.b().i("FastQRCodeOnCreate");
        long r3 = System.currentTimeMillis();
        if (this.g == false) goto L22;
        ScannerView r4 = this.e;
        if (r4 == null) goto L22;
        this.d.getClass();
        Intrinsics.checkNotNullParameter(r4, "scannerView");
    L22:
        a0 r5 = this.d;
        FragmentActivity r6 = this.b;
        this.c.getFormats();
        s r7 = new s(this, r3);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "listener");
        r5.a = r7;
        Log.i("QRCode-VESDKQRCodeScanner", "OfficeSDK VESDKQRCodeScanner is disabled");
        fsb.f.b().h("FastQRCodeOnCreate");
        this.mFlashLight.setOnClickListener(new u(this));
        FrameLayout r8 = this.mCustomViewContainer;
        if (r8 == null) goto L33;
        if ((r8.getContext() instanceof Activity) == false) goto L33;
        View r9 = ((Activity) this.mCustomViewContainer.getContext()).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L31;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r10 = ThreadMethodProxy.currentThread();
        if (r10 == com.larus.home.impl.utils.c.a) goto L31;
        com.larus.home.impl.utils.c.a(r10, "getDecorView");
    L31:
        LKUIStatus.b r11 = new LKUIStatus.b((ViewGroup) r9);
        r11.b = UIHelper.getString(2131891899);
        this.h = new LKUIStatus(r11);
    L33:
        if (this.j.isFeatureGatingEnable("core.scan.flashlight") == false) goto L36;
        a0 r12 = this.d;
        v r13 = new v();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "listener");
        return;
    L36:
        return;
    L10:
        if (this.i.canDetectOrientation() == false) goto L16;
        a2c.a r14 = z1c.a.a;
        if (r14 == null) goto L16;
        if (r14.isFeatureGatingEnable("im.scan_code.use_new_scanner_view.forall") == true) goto L15;
    L16:
        this.i.disable();
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    public final void destroy() {
        this.i.disable();
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void f() {
        this.d.a = null;
        this.i.disable();
        this.mMyTitleBar.getLeftDrawable().setColorFilter(FakePickerAvatarCreator.BLACK, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void hideLoading() {
        UICallbackExecutor.execute(new q(this));
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void onResume() {
        this.d.getClass();
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.c = (com.ss.android.lark.qrcode.ui.c.a) r1;
    }

    @Override // com.ss.android.lark.qrcode.ui.c
    public final void showToast(String r2) {
        LKUIToast.show(this.b, r2);
    }

    public QRCodeScanView(QRCodeScanFragment.b r3, FragmentActivity r4) {
        this.g = false;
        this.j = z1c.a.a;
        this.k = new c2c.a();
        this.l = Long.valueOf(System.currentTimeMillis());
        this.a = r3;
        this.b = r4;
        this.d = new a0();
    }

    public QRCodeScanView(QRCodeScanFragment.b r3, FragmentActivity r4, int[] r5) {
        this.g = false;
        this.j = z1c.a.a;
        this.k = new c2c.a();
        this.l = Long.valueOf(System.currentTimeMillis());
        this.a = r3;
        this.b = r4;
        Intrinsics.checkNotNullParameter(r5, "formats");
        this.d = new a0();
    }
}
