package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u0001:\u0004PQRSB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u00020\tH\u0016J\b\u0010B\u001a\u00020\tH\u0016J\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\tH\u0016J\"\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010K\u001a\u00020\t2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\tH\u0002J\u0006\u00107\u001a\u00020\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "formats", "", "statistics", "Lcom/ss/android/lark/qrcode/statistics/VEScannerStatistics;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "scanListener", "Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanListener;", "getScanListener", "()Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanListener;", "setScanListener", "(Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanListener;)V", "customViewInjector", "Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanCustomViewInjector;", "getCustomViewInjector", "()Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanCustomViewInjector;", "setCustomViewInjector", "(Lcom/ss/android/lark/qrcode/ui/QRCodeScanFragment$IQRCodeScanCustomViewInjector;)V", "mPresenter", "Lcom/ss/android/lark/qrcode/ui/QRCodeScanPresenter;", "getMPresenter", "()Lcom/ss/android/lark/qrcode/ui/QRCodeScanPresenter;", "setMPresenter", "(Lcom/ss/android/lark/qrcode/ui/QRCodeScanPresenter;)V", "mCreateTime", "", "mActivityDestroyListeners", "", "Lcom/ss/android/lark/biz/core/api/IQRCodeContext$IActivityDestoryListener;", "mViewClickListeners", "Lcom/ss/android/lark/biz/core/api/IQRCodeContext$IViewClickListener;", "mViewDependency", "Lcom/ss/android/lark/qrcode/ui/QRCodeScanView$ViewDependency;", "getMViewDependency", "()Lcom/ss/android/lark/qrcode/ui/QRCodeScanView$ViewDependency;", "setMViewDependency", "(Lcom/ss/android/lark/qrcode/ui/QRCodeScanView$ViewDependency;)V", "mVideoChatService", "Lcom/ss/android/lark/qrcode/dependency/IQRCodeModuleDependency;", "getMVideoChatService", "()Lcom/ss/android/lark/qrcode/dependency/IQRCodeModuleDependency;", "setMVideoChatService", "(Lcom/ss/android/lark/qrcode/dependency/IQRCodeModuleDependency;)V", "windowRotationArbiter", "Lcom/ss/android/lark/qrcode/ui/WindowRotationArbiter;", "getWindowRotationArbiter", "()Lcom/ss/android/lark/qrcode/ui/WindowRotationArbiter;", "setWindowRotationArbiter", "(Lcom/ss/android/lark/qrcode/ui/WindowRotationArbiter;)V", "addDefaultBackground", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onActivityCreated", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleSelectedPhoto", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "rebindNewInstance", "IQRCodeScanListener", "ScanResult", "IQRCodeScanCustomViewInjector", "Companion", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class QRCodeScanFragment extends BaseFragment {
    public static final /* synthetic */ int n = 0;
    public int[] d;
    public final c2c.a e;
    public p f;
    public final long g;
    public final List<dxa.b.a> h;
    public final List<dxa.b.b> i;
    public final b j;
    public final a2c.a k;
    public b0 l;
    public boolean m;

    public static final class a {
    }

    public static final class b implements QRCodeScanView.c {
        public final /* synthetic */ QRCodeScanFragment a;

        @Override // com.ss.android.lark.qrcode.ui.QRCodeScanView.c
        public final void b() {
            a2c.a r0 = z1c.a.a;
            if (r0 == null) goto L6;
            r0.openInviteExternalPage(this.a.requireActivity(), "QRCodeScanFragment", true);
            return;
        }

        public b(QRCodeScanFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.qrcode.ui.QRCodeScanView.c
        public final void a(QRCodeScanView r2) {
            Intrinsics.checkNotNullParameter(r2, "qrCodeScanView");
            ButterKnife.bind(r2, this.a.requireView());
        }

        @Override // com.ss.android.lark.qrcode.ui.QRCodeScanView.c
        public final void c(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            Iterator r5 = ((CopyOnWriteArrayList) this.a.i).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            dxa.b.b r0 = (dxa.b.b) r5.next();
            if (r0 == null) goto L4;
            r0.a();
            goto L4
        L8:
            FragmentActivity r6 = this.a.requireActivity();
            String r1 = QRCodeScanActivity.b;
            com.ss.android.lark.widget.photopicker.s.a r2 = new com.ss.android.lark.widget.photopicker.s.a();
            r2.c = 1;
            r2.l = true;
            r2.o = false;
            new com.ss.android.lark.widget.photopicker.e(new com.ss.android.lark.widget.photopicker.s(r2)).b(r6, null, 233);
            Log.i("QRCodeScanActivity", "selectFromGalleryInternal");
            c2c.a r7 = this.a.e;
            h.c.a.getClass();
            if (h.m() == false) goto L11;
            String r3 = "ve";
        L12:
            boolean r8 = h.l();
            r7.getClass();
            Intrinsics.checkNotNullParameter(r3, "type");
            a2c.a r9 = z1c.a.a;
            Log.i("QRCodeModule", "click album button");
            Statistics.sendEvent("scan_code_click_album", new JSONObject().put("ve_scan_type", r3).put("use_enigma_detect", r8).put("vesdk_enabled", "true"));
            return;
        L11:
            r3 = PickerReporterConstants.VALUE.SCENE.OTHERS;
            goto L12
        }
    }

    public static final class c implements dxa.b {
        public final /* synthetic */ QRCodeScanFragment a;

        public Context getContext() {
            return this.a.requireContext();
        }

        public c(QRCodeScanFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ QRCodeScanFragment a;

        public d(QRCodeScanFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.ss.android.lark.qrcode.ui.c) this.a.S90().getView()).K4();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final p S90() {
        p r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        return null;
    }

    public final void onDestroy() {
        int r0 = ((ArrayList) this.h).size() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r1 = r0 - 1;
        dxa.b.a r2 = (dxa.b.a) ListProtector.get(this.h, r0);
        if (r2 == null) goto L7;
        requireActivity();
        r2.a();
    L7:
        if (r1 < 0) goto L10;
        r0 = r1;
    L10:
        p r3 = S90();
        if (r3.c.get() <= 0) goto L18;
        long r4 = System.currentTimeMillis();
        int r5 = (int) (r4 - r3.c.get());
        Statistics.sendEvent("qrcode_start_process_time", new JSONObject().put("processname", r3.d).put("cost_time_int", r5));     // Catch: JSONException -> L15
    L17:
        a2c.a r6 = z1c.a.a;
        Log.i("QRCodeModule", "preload process success" + r3.d + ", at " + r4 + ", cost " + r5);
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        ((com.ss.android.lark.qrcode.ui.c) r3.getView()).f();
        a0b.h.e();
        super.onDestroy();
        h r7 = h.c.a;
        if (r7.e != this) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
        r7.c = null;
        r7.e = null;
    L24:
        ((ArrayList) this.h).clear();
        ((CopyOnWriteArrayList) this.i).clear();
        return;
    L21:
        r8 = false;
        goto L22
    }

    public QRCodeScanFragment() {
        this.e = new c2c.a();
        this.g = System.currentTimeMillis();
        this.h = new ArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new b(this);
        this.k = z1c.a.a;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        a2c.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.otherOpenCamera();
    L5:
        ((com.ss.android.lark.qrcode.ui.c) S90().getView()).J4();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (TextUtils.isEmpty(QRCodeScanActivity.b) == true) goto L5;
        HashMap r3 = new HashMap();
        r3.put("first_render", Long.valueOf(System.currentTimeMillis() - this.g));
        AppreciableKit.Companion.getInstance().resume(QRCodeScanActivity.b, r3, null, null, null);
    L5:
        ((com.ss.android.lark.qrcode.ui.c) S90().getView()).onResume();
    }

    public final void onStart() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStart();
        a2c.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.otherOpenCamera();
    L5:
        a2c.a r1 = z1c.a.a;
        Intrinsics.checkNotNull(r1);
        if (r1.isInMeeting() == false) goto L8;
        new Handler(Looper.getMainLooper()).postDelayed(new d(this), 500);
        return;
    L8:
        ((com.ss.android.lark.qrcode.ui.c) S90().getView()).K4();
    }

    public final void onStop() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
    }

    public final void onActivityCreated(Bundle r11) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r11);
        h r12 = h.c.a;
        r12.c = new c(this);
        if (this.d == null) goto L5;
        p r13 = new p(requireActivity(), this.j, requireActivity().getIntent(), this.d);
    L6:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.f = r13;
        ConstraintLayout r14 = requireView().findViewById(2131383517);
        QRCodeScanView r1 = S90().a;
        r1.d.getClass();
        Intrinsics.checkNotNullParameter(r14, "parent");
        View r2 = new View(r14.getContext());
        Log.d("QRCode-QRCodeScanView", "setupNewScanView");
        View r4 = r2.findViewById(2131383515);
        View r5 = r2.findViewById(2131383514);
        View r6 = r2.findViewById(2131383513);
        View r7 = r2.findViewById(2131383506);
        r1.e = (ScannerView) r2.findViewById(2131383520);
        r4.setVisibility(0);
        r5.setVisibility(0);
        r6.setVisibility(8);
        r7.setVisibility(8);
        r4.setOnClickListener(new w(r1));
        r5.setOnClickListener(new x(r1));
        View r3 = r2.findViewById(2131372907);
        ConstraintLayout.LayoutParams r8 = r3.getLayoutParams();
        if ((r8 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r9 = r8;
        r9.bottomToTop = 2131383515;
        r3.setLayoutParams(r9);
    L9:
        WindowInsetsUtils.g(r4, false, true);
        WindowInsetsUtils.g(r5, false, true);
        r14.addView(r2, 0);
        S90().create();
        S90().getClass();
        if (TextUtils.isEmpty(QRCodeScanActivity.b) == true) goto L12;
        HashMap r10 = new HashMap();
        r10.put("init_view_cost", Long.valueOf(System.currentTimeMillis() - this.g));
        AppreciableKit.Companion.getInstance().resume(QRCodeScanActivity.b, r10, null, null, null);
    L12:
        b0 r15 = new b0(requireActivity(), new AnonymousClass2(this));
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.l = r15;
        return;
    L5:
        r13 = new p(requireActivity(), this.j, requireActivity().getIntent());
        goto L6
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        b0 r1 = this.l;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("windowRotationArbiter");
        r1 = null;
    L6:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        int r4 = r1.a.getWindowManager().getDefaultDisplay().getRotation();
        int r0 = r1.c;
        if (r4 == r0) goto L10;
        r1.c = r4;
        r1.b.invoke(Integer.valueOf(r0), Integer.valueOf(r4));
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        this.d = r3.getIntArray("formats");
    L5:
        h.c.a.e = this;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L8;
        return;
    L8:
        if (r2 != 233) goto L33;
        ArrayList<String> r5 = r4.getStringArrayListExtra("SELECTED_PHOTOS");
        if (CollectionUtils.isEmpty(r5) == false) goto L12;
        Log.i("QRCodeScanFragment", "onActivityResult photos is empty");
        return;
    L12:
        if (r5 == null) goto L14;
        final String r6 = (String) ListProtector.get(r5, 0);
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L35;
        h r7 = h.c.a;
        r7.getClass();
        if (h.k() == true) goto L30;
        boolean r8 = com.ss.android.lark.videosend.tools.f.e;
        if (r8 == true) goto L30;
        final p r0 = S90();
        r0.getClass();
        if (r8 == false) goto L28;
        if (TextUtils.isEmpty(r6) == true) goto L36;
        r7.b(new QRCodeScanPresenter$4(r0, r6), r6);
        return;
    L36:
        return;
    L28:
        if (TextUtils.isEmpty(r6) == true) goto L38;
        r7.b(new QRCodeScanPresenter$3(r0, r6), r6);
        return;
    L38:
        return;
    L30:
        mlb.d r9 = new mlb.d();
        r9.b = r6;
        com.ss.android.lark.qrcode.ui.d r10 = new com.ss.android.lark.qrcode.ui.d(this, r6);
        Intrinsics.checkNotNullParameter(r10, "callback");
        r9.d = r10;
        mlb.b.e(r9);
        return;
    L35:
        return;
    L14:
        r6 = null;
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131558506, r3, false);
        if (this.m == false) goto L5;
        r5.setBackgroundResource(2131106500);
    L5:
        return r5;
    }
}
