package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeQuickRecordWidget;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import f06.d;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class QuickRecordingPresenter extends com.bytedance.android.livesdk.chatroom.ui.record.presenter.b {
    public static boolean p;
    public Intent k;
    public boolean l;
    public final Lazy m;
    public final Lazy n;
    public final Widget o;

    public static final class a {
    }

    public interface b {
        void Gm();

        void a1();

        void lk(boolean r1);

        void onShareDialogDismiss();

        void onShareDialogShow();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ QuickRecordingPresenter a;

        public c(QuickRecordingPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.g() == false) goto L9;
            this.a.h(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    public final boolean g() {
        if (((Boolean) this.g.get("data_game_screen_cast_tv", Boolean.FALSE)).booleanValue() == false) goto L7;
        f2.c("投屏中暂不支持该功能", 0);
        return false;
    L7:
        if (r.r().f(this.g) == false) goto L9;
    L47:
        f2.c("当前正在录屏，请稍后再操作", 0);
        return false;
    L9:
        if (this.l == true) goto L47;
        if (((float) ((Environment.getDataDirectory().getFreeSpace() * 1.0d) / ((double) 1048576))) >= 25) goto L16;
        f2.c("屏幕录制失败，请检查存储空间是否充足", 0);
        return false;
    L16:
        if (Build.VERSION.SDK_INT <= 21) goto L45;
        Intent r1 = r.r().getRecordPermissionIntent();
        this.k = r1;
        if (r1 != null) goto L42;
        Object r2 = getContext().getSystemService("media_projection");
        if (r2 == null) goto L41;
        MediaProjectionManager r3 = (MediaProjectionManager) r2;
        Widget r4 = this.o;
        ArrayList r13 = new ArrayList();
        Object[] r14 = new Object[0];
        f06.b r15 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(102100);
        if (r5 == null) goto L24;
        f06.a[] r6 = r5.i;
    L25:
        f06.a[] r12 = r6;
        int r11 = r12.length;
        int r10 = 0;
    L27:
        if (r10 >= r11) goto L34;
        f06.a r9 = r12[r10];
        int r19 = r10;
        int r20 = r11;
        f06.a[] r21 = r12;
        d r7 = r9.preInvoke(102100, "android/media/projection/MediaProjectionManager", "createScreenCaptureIntent", r3, r14, "android.content.Intent", r15);     // Catch: Exception -> L49
        if (r7.a == true) goto L36;
        r13.add(r9);     // Catch: Exception -> L49
    L36:
        if (r7.a == false) goto L38;
        Intent r8 = (Intent) r7.b;
    L39:
        r4.startActivityForResult(r8, 42342);
        boolean r16 = true;
    L43:
        if (r16 == false) goto L55;
        return false;
    L55:
        return true;
    L38:
        r8 = r3.createScreenCaptureIntent();
    L33:
        r10 = r19 + 1;
        r11 = r20;
        r12 = r21;
        goto L27
    L34:
        r7 = new d(false, null);
        goto L36
    L24:
        r6 = ApiHookConfig.d;
        goto L25
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
    L42:
        r16 = false;
        goto L43
    L45:
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.a
    public final void onStop() {
        IQuickRecordPopupWindow r0 = this.a;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b, com.bytedance.android.livesdk.chatroom.ui.record.presenter.a
    public final void a(long r4) {
        this.j.a1();
        this.h.getLocationOnScreen(this.b);
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L6;
        String[] r1 = {"android.permission.RECORD_AUDIO"};
    L9:
        c(r4, (String[]) Arrays.copyOf(r1, r1.length));
        return;
    L6:
        if (r0 < 33) goto L8;
        r1 = new String[]{"android.permission.RECORD_AUDIO"};
        goto L9
    L8:
        r1 = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO"};
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void d(long r2) {
        if (g() == false) goto L6;
        h(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void e(ILiveRecordService.RecordStatus r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        r.r().d(r6, this.g);
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == true) goto L15;
        if (r6 != ILiveRecordService.RecordStatus.READY) goto L12;
        this.l = true;
        u r0 = r.u(this.g, null, 2);
        if (r0 == null) goto L15;
        m<Boolean> r1 = r0.x0();
        if (r1 == null) goto L15;
        r1.setValue(Boolean.TRUE);
        goto L15
    L12:
        if (r6 != ILiveRecordService.RecordStatus.FINISH) goto L15;
        this.l = false;
        this.g.put("data_screen_record_is_open", Boolean.FALSE);
    L15:
        if (r6 != ILiveRecordService.RecordStatus.READY) goto L17;
    L26:
        u r7 = r.u(this.g, null, 2);
        if (r7 == null) goto L36;
        m<Boolean> r8 = r7.x0();
        if (r8 == null) goto L37;
        r8.setValue(Boolean.TRUE);
        return;
    L37:
        return;
    L36:
        return;
    L17:
        if (r6 == ILiveRecordService.RecordStatus.RECORDING) goto L26;
        if (r6 != ILiveRecordService.RecordStatus.FINISH) goto L32;
        u r9 = r.u(this.g, null, 2);
        if (r9 == null) goto L33;
        m<Boolean> r10 = r9.x0();
        if (r10 == null) goto L34;
        r10.setValue(Boolean.FALSE);
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void h(long r3) {
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new QuickRecordingPresenter$startRecord$1(this, r3)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("QuickRecordingPresenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b, com.bytedance.android.livesdk.chatroom.ui.record.presenter.a
    public final void onActivityResult(int r3, int r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if (r3 == 42342) goto L5;
        return;
    L5:
        if (r4 != 0) goto L8;
        f2.b(2131919856, 0);
        return;
    L8:
        this.k = r5;
        r.r().saveRecordPermissionIntent(r5);
        this.h.postDelayed(new c(this), 300);
    }

    public QuickRecordingPresenter(Context r7, DataCenter r8, final View r9, LandscapeQuickRecordWidget r10, final LandscapeQuickRecordWidget r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "anchorView");
        Intrinsics.checkNotNullParameter(r10, "widget");
        Intrinsics.checkNotNullParameter(r11, "listener");
        super(r7, r8, r9, r12, r11);
        this.o = r10;
        this.m = LazyKt.lazy(QuickRecordingPresenter$mVideoWidth$2.INSTANCE);
        this.n = LazyKt.lazy(QuickRecordingPresenter$mVideoHeight$2.INSTANCE);
        if (p == false) goto L5;
        r9.setVisibility(0);
    L6:
        Function1<Boolean, Unit> r13 = new AnonymousClass1(r9, r11);
        if (p == true) goto L11;
        NewPluginType r14 = NewPluginType.LiveResource;
        r14.preload();
        r14.checkInstall(getContext(), "quickShotRecord", new com.bytedance.android.livesdk.chatroom.ui.record.presenter.c(this, r13));
        return;
    L11:
        return;
    L5:
        r9.setVisibility(8);
        goto L6
    }
}
