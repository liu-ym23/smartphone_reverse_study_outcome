package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import am2.x;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.ability.bridge.IBridgeAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.record.LiveRecordPreviewDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.v0;
import com.bytedance.android.livesdk.chatroom.widget.z0;
import com.bytedance.android.livesdk.config.hv;
import com.bytedance.android.livesdk.config.p71;
import com.bytedance.android.livesdk.config.pm0;
import com.bytedance.android.livesdk.config.qm0;
import com.bytedance.android.livesdk.config.rm0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.pluggableinterface.IShareGuideService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.record.admin.AdminRecordManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import zg1.d3;
import zg1.e3;
import zg1.i1;
import zg1.n1;
import zg1.o2;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveRecordWidget extends LiveRecyclableWidget implements View.OnClickListener, WeakHandler.IHandler, DialogInterface.OnDismissListener, Observer<KVData>, com.bytedance.android.livesdk.chatroom.viewmodule.record.c {
    public static boolean L;
    public View A;
    public boolean B;
    public View C;
    public View D;
    public RecordDragParentView E;
    public com.bytedance.android.livesdk.chatroom.viewmodule.record.e F;
    public m G;
    public final a H;
    public AdminRecordPermissionChanger I;
    public final boolean J;
    public final e K;
    public TextView a;
    public View b;
    public TextView c;
    public boolean d;
    public final boolean e;
    public WeakHandler f;
    public int g;
    public int h;
    public int i;
    public com.bytedance.android.livesdk.chatroom.record.h j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public Room q;
    public boolean r;
    public com.bytedance.android.live.pushstream.d s;
    public Intent t;
    public View u;
    public View v;
    public View w;
    public TextView x;
    public TextView y;
    public View z;

    public class a implements Observer<KVData> {
        public final /* synthetic */ LiveRecordWidget a;

        public a(LiveRecordWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KVData r3 = (KVData) r2;
            if (this.a.isViewValid() == false) goto L8;
            if (r3 == null) goto L9;
            LiveRecordWidget r0 = this.a;
            ((Boolean) r3.getData()).booleanValue();
            r0.getClass();
            return;
        L9:
            return;
        }
    }

    public class b implements o60.e {
        public final /* synthetic */ LiveRecordWidget a;

        public b(LiveRecordWidget r1) {
            this.a = r1;
        }

        public final void onPermissionDenied(String... r2) {
            LiveRecordWidget r3 = this.a;
            if (r3.n == true) goto L6;
            r3.hide();
            return;
        }

        public final void onPermissionGrant(String... r1) {
            this.a.Aq();
        }
    }

    public class c implements tp2.a.b {
        public c(LiveRecordWidget r1) {
        }
    }

    public class d implements js0.b {
        public final /* synthetic */ LiveRecordWidget a;

        public d(LiveRecordWidget r1) {
            this.a = r1;
        }

        public final void onSuccess(String r2) {
            LiveRecordWidget r3 = this.a;
            r3.l = true;
            r3.s.J();
            throw null;
        }
    }

    public class e implements z0.b {
        public final /* synthetic */ LiveRecordWidget a;

        public final void b() {
            com.bytedance.android.livesdk.chatroom.record.h r0 = this.a.j;
            if (r0 != null) goto L5;
        L7:
            HashMap r1 = new HashMap();
            r1.put("anchor_id", this.a.q.author().getIdString());
            r1.put("room_id", String.valueOf(this.a.q.getId()));
            if (this.a.r == false) goto L10;
            String r2 = "clear";
        L11:
            r1.put("clear_status", r2);
            AdminRecordManager.k(r1);
            if (this.a.isScreenPortrait() == false) goto L14;
            String r3 = "0";
        L15:
            r1.put("room_orientation", r3);
            u.l().sendLog("livesdk_pm_live_record_finish_save", r1, new Object[]{new x()});
            return;
        L14:
            r3 = "1";
            goto L15
        L10:
            r2 = "not_clear";
            goto L11
        L5:
            if (r0.p() == false) goto L7;
            this.a.j.dismissAllowingStateLoss();
            this.a.j = null;
            goto L7
        }

        public e(LiveRecordWidget r1) {
            this.a = r1;
        }

        public final void a(Object r3) {
            ALogger.e("LiveRecordWidget", "onSaveFailure:" + r3);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ LiveRecordWidget a;

        public final void a() {
            this.a.yq();
            if (this.a.isViewValid() == true) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.chatroom.record.h r0 = this.a.j;
            if (r0 == null) goto L11;
            if (r0.p() == false) goto L11;
            return;
        L11:
            if (this.a.getComponentContext().a() != null) goto L13;
        L15:
            boolean r1 = com.bytedance.android.livesdk.service.l.d().e().isPreview();
        L16:
            if (r1 == false) goto L18;
            return;
        L18:
            this.a.setRecordStatus(ILiveRecordService.RecordStatus.PREVIEW);
            Fragment r2 = ((Widget) this.a).context.getSupportFragmentManager().findFragmentByTag(com.bytedance.android.livesdk.chatroom.record.h.class.getSimpleName());
            if (r2 != null) goto L21;
        L24:
            ALogger.e("LiveRecordWidget", "Show record share dialog " + this.a.j);
            this.a.getClass();
            LiveRecordWidget.wq(true);
            LiveRecordWidget r3 = this.a;
            r3.j.show(((Widget) r3).context.getSupportFragmentManager(), com.bytedance.android.livesdk.chatroom.record.h.class.getSimpleName());
            return;
        L21:
            if (r2.isAdded() == false) goto L24;
            ALogger.e("LiveRecordWidget", "Fragment " + r2 + " already added.");
            return;
        L13:
            if (this.a.getComponentContext().a().getAbility(IRoomRecordService.class) == null) goto L15;
            r1 = this.a.getComponentContext().a().getAbility(IRoomRecordService.class).isPreview();
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(LiveRecordWidget r1) {
            this.a = r1;
        }
    }

    public final String getSpm() {
        return "a100.a100.a198";
    }

    public final void onUnload() {
        Bq(false);
        com.bytedance.android.livesdk.chatroom.record.h r0 = this.j;
        if (r0 == null) goto L5;
        r0.dismissAllowingStateLoss();
    L5:
        getDataCenter().removeObserver("data_keyboard_status", this.H);
        this.f.removeCallbacksAndMessages(null);
        if (tb1.c.a == false) goto L8;
    L10:
        this.k = null;
        AdminRecordPermissionChanger r1 = this.I;
        if (r1 == null) goto L20;
        DataCenter r2 = r1.d;
        if (r2 == null) goto L15;
        r2.removeObserver(r1);
    L15:
        vlc.d r3 = r1.b;
        if (r3 == null) goto L18;
        r3.removeMessageListener(r1);
    L18:
        r1.c.clear();
        return;
    L20:
        return;
    L8:
        if (TextUtils.isEmpty(this.k) == true) goto L10;
        com.bytedance.android.livesdk.service.l.d().e().deleteLastVideo();
        goto L10
    }

    public final void Aq() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.l == true) goto L55;
        String r1 = com.bytedance.android.livesdk.chatroom.record.u.c(((Widget) this).context, "record" + System.currentTimeMillis() + ".mp4");
        this.k = r1;
        Logger.d("LiveRecordWidget", r1);
        boolean r4 = false;
        if (((float) ((Environment.getDataDirectory().getFreeSpace() * 1.0d) / 1048576.0d)) >= 20.0f) goto L12;
        f2.b(2131919854, 0);
        return;
    L12:
        if (this.k != null) goto L16;
        f2.b(2131919851, 0);
        yq();
        return;
    L16:
        if (Build.VERSION.SDK_INT <= 21) goto L41;
        Intent r2 = com.bytedance.android.livesdk.service.l.d().e().getRecordPermissionIntent();
        this.t = r2;
        if (r2 != null) goto L38;
        MediaProjectionManager r3 = (MediaProjectionManager) ((Widget) this).context.getSystemService("media_projection");
        int r5 = jc1.f.a;
        Intrinsics.checkNotNullParameter(r3, "projectionManager");
        ArrayList r6 = new ArrayList();
        Object[] r14 = new Object[0];
        f06.b r15 = new f06.b();
        g06.a r7 = (g06.a) ApiHookConfig.b.get(102100);
        if (r7 == null) goto L22;
        f06.a[] r8 = r7.i;
    L23:
        f06.a[] r13 = r8;
        int r12 = r13.length;
        int r11 = 0;
    L25:
        if (r11 >= r12) goto L32;
        f06.a r10 = r13[r11];
        int r19 = r11;
        int r20 = r12;
        f06.a[] r21 = r13;
        f06.d r9 = r10.preInvoke(102100, "android/media/projection/MediaProjectionManager", "createScreenCaptureIntent", r3, r14, "android.content.Intent", r15);     // Catch: Exception -> L48
        if (r9.a == true) goto L34;
        r6.add(r10);     // Catch: Exception -> L48
    L34:
        if (r9.a == false) goto L36;
        Intent r16 = (Intent) r9.b;
    L37:
        startActivityForResult(r16, 42342);
        r4 = true;
        goto L38
    L36:
        r16 = r3.createScreenCaptureIntent();
    L31:
        r11 = r19 + 1;
        r12 = r20;
        r13 = r21;
        goto L25
    L32:
        r9 = new f06.d(false, null);
        goto L34
    L22:
        r8 = ApiHookConfig.d;
    L38:
        if (r4 == false) goto L41;
        return;
    L41:
        if (this.t != null) goto L44;
        return;
    L44:
        if (this.s != null) goto L46;
        return;
    L46:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new d(this)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("LiveRecordWidget");
        return;
    }

    public final int getLayoutId() {
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room");
        this.q = r0;
        if (tb1.c.a == true) goto L5;
        return 2131567757;
    L5:
        if (this.e == false) goto L14;
        if (r0 != null) goto L8;
        return 2131567758;
    L8:
        if (r0.getStreamType() == LiveMode.THIRD_PARTY) goto L15;
        return 2131567758;
    L15:
        return 2131567757;
    L14:
        return 2131567757;
    }

    public final void hide() {
        com.bytedance.android.livesdk.chatroom.viewmodule.record.e r0 = this.F;
        if (r0 == null) goto L8;
        r0.b();
        RecordDragParentView r3 = r0.m;
        View r4 = r3.a;
        if (r4 == null) goto L7;
        r3.removeView(r4);
    L7:
        r3.a = null;
        UtilityKotlinExtentionsKt.t(r0.m);
        r0.c.setReverse(false);
        r0.b = 0;
    L8:
        com.bytedance.android.livesdk.f.d().f();
        wq(false);
        if (tb1.c.a == true) goto L11;
        getDataCenter().put("data_screen_record_is_open", Boolean.FALSE);
    L14:
        setRecordStatus(ILiveRecordService.RecordStatus.FINISH);
        String r1 = (String) ((Widget) this).dataCenter.get("data_room_unique_id", null);
        RxBusAbility.INSTANCE.getRxBus(r1).post(new o2(false));
        ((Widget) this).contentView.setVisibility(8);
        L = false;
        this.n = true;
        m r2 = this.G;
        if (r2 == null) goto L18;
        r3.o(((Widget) this).context, r2);
        return;
    L18:
        return;
    L11:
        if (this.B == true) goto L14;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.RECORD.extended());
        pp1.b r5 = new pp1.b();
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.RECORD_LANDSCAPE, r5);
        goto L14
    }

    public final void yq() {
        UIUtils.setViewVisibility(this.A, 0);
        UIUtils.setViewVisibility(this.u, 0);
        UIUtils.setViewVisibility(this.c, 0);
        UIUtils.setViewVisibility(this.b, 0);
        if (this.B == true) goto L5;
        y3.i(((Widget) this).dataCenter).h(ExtendedToolbarButton.e(ToolbarButton.RECORD_LANDSCAPE));
        y3.i(((Widget) this).dataCenter).h(ExtendedToolbarButton.e(ToolbarButton.SWITCH_SCREEN_ORIENTATION));
        y3.i(((Widget) this).dataCenter).h(ExtendedToolbarButton.e(ToolbarButton.RECORD_COMBINE));
    L5:
        View r0 = this.z;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
    L8:
        boolean r1 = isScreenPortrait();
        int r2 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r1) == false) goto L11;
        UIUtils.setViewVisibility(this.v, 0);
    L11:
        this.g = 0;
        this.l = false;
        this.f.removeMessages(2);
        jc1.k.f(IPerformanceManager.class).onModuleStop("streamer_record");
    }

    public final void zq() {
        if (this.l == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        Aq();
        return;
    L9:
        Activity r0 = ContextUtil.contextToActivity(((Widget) this).context);
        SettingKey r1 = m60.i.a;
        new m60.i.b(r0).b(new b(this), null, TokenCert.with("bpea-live_record_LiveRecordWidget"), new String[]{"android.permission.RECORD_AUDIO"});
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.g < this.h) goto L7;
        boolean r0 = true;
    L8:
        Bq(r0);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public LiveRecordWidget(boolean r3) {
        this.g = 0;
        this.h = 5;
        this.i = 15;
        this.m = false;
        this.n = true;
        this.o = 576;
        this.p = 1024;
        this.H = new a(this);
        this.J = true;
        new c(this);
        this.K = new e(this);
        this.e = r3;
    }

    public static void wq(boolean r2) {
        if (hv.a.getValue().booleanValue() == false) goto L8;
        IShareGuideService r0 = (IShareGuideService) com.bytedance.android.livesdk.service.l.d().b().a(IShareGuideService.class);
        if (r0 == null) goto L9;
        r0.markShow(r2);
        return;
    L9:
        return;
    }

    public final void Bq(boolean r14) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.f.d().a();
        hide();
        setRecordStatus(ILiveRecordService.RecordStatus.FINISH);
        if (r14 == true) goto L8;
    L10:
        if (r14 == true) goto L12;
        yq();
    L53:
        this.l = false;
        if (Build.VERSION.SDK_INT < 34) goto L57;
        this.t = null;
        com.bytedance.android.livesdk.service.l.d().e().saveRecordPermissionIntent(this.t);
        return;
    L57:
        return;
    L12:
        if (this.m == true) goto L48;
        HashMap r15 = new HashMap();
        r15.put("room_id", String.valueOf(this.q.getId()));
        r15.put("anchor_id", this.q.getBaseOwner().getIdString());
        r15.put("time", String.valueOf(this.g));
        AdminRecordManager.k(r15);
        if (isScreenPortrait() == false) goto L16;
        String r2 = "0";
    L17:
        r15.put("room_orientation", r2);
        u.l().sendLog("livesdk_pm_live_record_time", r15, new Object[]{new x()});
        com.bytedance.android.livesdk.chatroom.record.h r16 = this.j;
        if (r16 == null) goto L23;
        if (r16.p() == false) goto L23;
        return;
    L23:
        if (com.bytedance.android.livesdk.chatroom.record.u.f(this.e, this.q) == false) goto L25;
    L33:
        String r17 = this.k;
        Rect r3 = new Rect();
        if (this.r == false) goto L36;
        this.w.getGlobalVisibleRect(r3);
    L46:
        DisplayMetrics r4 = s1.q(ContextUtil.contextToActivity(((Widget) this).context));
        float r5 = (this.p * 1.0f) / r4.heightPixels;
        float r8 = r3.left * r5;
        float r9 = this.o * 1.0f;
        float r10 = r3.top * r5;
        float r11 = this.p * 1.0f;
        RectF r7 = new RectF(r8 / r9, r10 / r11, (r3.right * r5) / r9, (r3.bottom * r5) / r11);
        ALogger.d("LiveRecordWidget", "rect:" + r3 + " rectF:" + r7 + " zoom:" + r5 + " height:" + r4.heightPixels + " width:" + r4.widthPixels + " vWidth:" + this.o + " vHeight:" + this.p);
        e r1 = this.K;
        boolean r6 = this.e;
        Room r12 = this.q;
        boolean r13 = this.B;
        DataCenter r18 = ((Widget) this).dataCenter;
        int r19 = this.o;
        int r20 = this.p;
        long r110 = System.currentTimeMillis();
        int r111 = LiveRecordPreviewDialog.C;
        Intrinsics.checkNotNullParameter(r17, "filePath");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        LiveRecordPreviewDialog r112 = new LiveRecordPreviewDialog();
        r112.g = r17;
        r112.k = r6;
        r112.j = r12;
        r112.l = r18;
        r112.f = r1;
        r112.h = r7;
        r112.i = r13;
        r112.t = true;
        r112.u = r19;
        r112.v = r20;
        r112.w = 0;
        r112.x = r110;
        this.j = r112;
        ((Widget) this).dataCenter.put("cmd_show_record_finished_dialog", new com.bytedance.android.livesdk.chatroom.model.q());
    L47:
        this.j.setOnDismissListener(this);
        ((Widget) this).contentView.postDelayed(new f(this), 100);
        goto L53
    L36:
        IMicRoomService r21 = jc1.k.f(IMicRoomService.class);
        if (r21 == null) goto L44;
        if (r21.isMicRoom(this.q) == false) goto L44;
        if (getWidgetInfo(r21.getMicRoomOfficialInfoWidget()) == null) goto L46;
        r3 = getWidgetInfo(r21.getMicRoomOfficialInfoWidget()).getGlobalVisibleRect();
    L44:
        if (getWidgetInfo(jc1.k.f(INavigationService.class).getUserInfoWidget(getDataCenter())) == null) goto L46;
        r3 = getWidgetInfo(jc1.k.f(INavigationService.class).getUserInfoWidget(getDataCenter())).getGlobalVisibleRect();
        goto L46
    L25:
        if (this.J == true) goto L27;
    L29:
        boolean r113 = false;
    L30:
        if (r113 == true) goto L33;
        this.j = new v0(ContextUtil.contextToActivity(((Widget) this).context), this.q, this.K, this.e, this.k);
        goto L47
    L27:
        if (this.e == true) goto L29;
        r113 = true;
        goto L30
    L16:
        r2 = "1";
        goto L17
    L48:
        DataCenter r114 = ((Widget) this).dataCenter;
        if (r114 == null) goto L51;
        r114.put("data_live_auto_record_finish", this.k);
        this.m = false;
    L51:
        yq();
        goto L53
    L8:
        if (FileUtils.checkFileExists(this.k) == true) goto L10;
        ALogger.e("LiveRecordWidget", "stopRecord, but file is not exit");
        f2.b(2131919882, 0);
        r14 = false;
        goto L10
    }

    public final void handleMsg(Message r12) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        int r0 = r12.what;
        if (r0 != 1) goto L8;
        Bq(true);
        return;
    L8:
        if (r0 != 2) goto L17;
        long r3 = SystemClock.uptimeMillis() - ((Long) r12.obj).longValue();
        long r5 = ((Long) r12.obj).longValue();
        long r4 = r3 / 1000;
        int r13 = (int) r4;
        this.g = r13;
        if (r13 < this.i) goto L13;
        this.f.sendEmptyMessage(1);
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.record.e r14 = this.F;
        String r1 = String.format(Locale.getDefault(), "%02d", new Object[]{Long.valueOf(r4 / 60)}) + String.format(Locale.getDefault(), ":%02d ", new Object[]{Long.valueOf(r4 % 60)});
        r14.getClass();
        Intrinsics.checkNotNullParameter(r1, "time");
        r14.f.setText(r1);
        WeakHandler r15 = this.f;
        r15.sendMessageDelayed(r15.obtainMessage(2, Long.valueOf(r5)), 300);
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        String r1 = "1";
        if (2131390273 != r11.getId()) goto L5;
    L16:
        hide();
        HashMap r12 = new HashMap();
        r12.put("anchor_id", this.q.author().getIdString());
        r12.put("room_id", String.valueOf(this.q.getId()));
        r12.put("is_recording", "0");
        AdminRecordManager.k(r12);
        if (isScreenPortrait() == false) goto L19;
        r1 = "0";
    L19:
        r12.put("room_orientation", r1);
        u.l().sendLog("livesdk_pm_live_record_cancel_click", r12, new Object[]{new x()});
        return;
    L5:
        if (2131369150 == r11.getId()) goto L16;
        if (2131390313 != r11.getId()) goto L11;
        xq(true);
        return;
    L11:
        if (2131376629 != r11.getId()) goto L22;
        this.m = false;
        zq();
        HashMap r13 = new HashMap();
        r13.put("anchor_id", this.q.author().getIdString());
        r13.put("room_id", String.valueOf(this.q.getId()));
        AdminRecordManager.k(r13);
        if (isScreenPortrait() == false) goto L15;
        r1 = "0";
    L15:
        r13.put("room_orientation", r1);
        u.l().sendLog("livesdk_pm_live_record_button_click", r13, new Object[]{new x()});
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        setRecordStatus(ILiveRecordService.RecordStatus.FINISH);
        yq();
        if (tb1.c.a == false) goto L5;
    L7:
        this.k = null;
        com.bytedance.android.livesdk.f.d().f();
        wq(false);
        return;
    L5:
        if (TextUtils.isEmpty(this.k) == true) goto L7;
        com.bytedance.android.livesdk.service.l.d().e().deleteLastVideo();
        goto L7
    }

    public void onEvent(s r1) {
        boolean r2 = r1.a;
    }

    public final void onInit(Object[] r3) {
        this.q = (Room) ((Widget) this).dataCenter.get("data_room");
        this.f = new WeakHandler(this);
        int r4 = rm0.a.getValue().intValue();
        int r0 = qm0.a.getValue().intValue();
        if (r4 < 1) goto L8;
        if (r4 > r0) goto L9;
        this.h = r4;
        this.i = r0;
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.record.j] */
    public final void onLoad(Object[] r6) {
        this.B = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        DisplayMetrics r7 = s1.q(ContextUtil.contextToActivity(((Widget) this).context));
        int r0 = r7.heightPixels;
        int r8 = r7.widthPixels;
        if (this.B == false) goto L5;
        this.o = 576;
        this.p = (int) (576 * (r0 / r8));
    L6:
        getDataCenter().observeForever("data_keyboard_status", this.H);
        L7(e3.class, new com.bytedance.android.livesdk.chatroom.viewmodule.record.f(this));
        L7(i1.class, new g(this));
        L7(n1.class, new h(this));
        L7(d3.class, new i(this));
        ((Widget) this).contentView.setVisibility(8);
        L = false;
        AdminRecordPermissionChanger r1 = new AdminRecordPermissionChanger(((Widget) this).dataCenter, new j(this));
        this.I = r1;
        if (gb2.a.a(r1.d, false) == false) goto L10;
        ALogger.i(r1.a, "不监听");
        return;
    L10:
        if (UserSetting.b() == false) goto L16;
        DataCenter r9 = r1.d;
        if (r9 == null) goto L30;
        com.bytedance.android.live.user.api.a r10 = com.bytedance.android.live.user.api.b.a(r9);
        if (r10 == null) goto L31;
        RxUtilKt.c(r10.isAdmin().subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.record.a(r1)), r1.c);
        RxUtilKt.c(r10.getOnPermissionChangeDelete().subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.record.b(r10, r1)), r1.c);
        return;
    L31:
        return;
    L30:
        return;
    L16:
        DataCenter r11 = r1.d;
        if (r11 == null) goto L19;
        r11.observe("data_user_in_room", r1);
    L19:
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, r1.d, 0, 2);
        if (r12 == null) goto L24;
        com.bytedance.live.datacontext.j r13 = r12.getMessageManager();
        if (r13 == null) goto L24;
        vlc.d r14 = (vlc.d) r13.getValue();
    L25:
        r1.b = r14;
        if (r14 == null) goto L33;
        r14.addMessageListener(MessageType.ADMIN_PRIVILEGE_CHANGE.getIntType(), r1);
        return;
    L33:
        return;
    L24:
        r14 = null;
        goto L25
    L5:
        this.p = 576;
        this.o = (int) (576 * (r8 / r0));
        goto L6
    }

    public final void setRecordStatus(ILiveRecordService.RecordStatus r3) {
        if (getComponentContext() != null) goto L5;
    L8:
        com.bytedance.android.livesdk.service.l.d().e().setRecordStatus(r3);
        return;
    L5:
        if (getComponentContext().a().getAbility(IRoomRecordService.class) == null) goto L8;
        if (r3 == null) goto L8;
        getComponentContext().a().getAbility(IRoomRecordService.class).setRecordStatus(r3);
        getComponentContext().a().getAbility(IBridgeAbilityCenter.class).getParentAbility().getAbility(ISessionRecordService.class).callRecordStatsChangeListener(r3);
    }

    public final void xq(boolean r7) {
        boolean r0 = !this.r;
        this.r = r0;
        if (r0 == false) goto L5;
        r3.g(this.c, s1.B(2131921127));
    L6:
        com.bytedance.android.livesdk.service.l.d().e().setClearScreen(this.r);
        TextView r1 = this.c;
        if (this.r == false) goto L9;
        int r2 = 2131251153;
    L10:
        r1.setCompoundDrawablesWithIntrinsicBounds(0, r2, 0, 0);
        View r3 = this.w;
        if (r3 != null) goto L13;
    L17:
        RxBusAbility.INSTANCE.getRxBus((String) ((Widget) this).dataCenter.get("data_room_unique_id", null)).post(new o2(this.r));
        if (r7 == false) goto L25;
        HashMap r8 = new HashMap();
        r8.put("anchor_id", this.q.author().getIdString());
        r8.put("room_id", String.valueOf(this.q.getId()));
        String r4 = "0";
        r8.put("is_recording", "0");
        AdminRecordManager.k(r8);
        if (isScreenPortrait() == true) goto L23;
        r4 = "1";
    L23:
        r8.put("room_orientation", r4);
        u.l().sendLog("livesdk_pm_live_record_clear_button_click", r8, new Object[]{new x()});
        return;
    L25:
        return;
    L13:
        if (this.r == false) goto L15;
        int r5 = 0;
    L16:
        r3.setVisibility(r5);
        goto L17
    L15:
        r5 = 8;
        goto L16
    L9:
        r2 = 2131251152;
        goto L10
    L5:
        r3.g(this.c, s1.B(2131915842));
        goto L6
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 == 42342) goto L6;
        return;
    L6:
        if (r4 != 0) goto L13;
        Logger.d("LiveRecordWidget", "hookActivityResult, resultCode = " + r4);
        f2.b(2131919856, 0);
        yq();
        if (this.m == false) goto L10;
    L11:
        hide();
        return;
    L10:
        if (this.n == false) goto L11;
        return;
    L13:
        this.t = r5;
        com.bytedance.android.livesdk.service.l.d().e().saveRecordPermissionIntent(r5);
        if (((Widget) this).contentView == null) goto L29;
        int r6 = com.bytedance.android.livesdk.config.setting.n.a;
        p71 r7 = pm0.a.getValue();
        if (Build.VERSION.SDK_INT < r7.b()) goto L18;
        long r8 = r7.a();
    L19:
        ALogger.i("LiveRecordWidget", "live record first delay time = " + r8);
        if (r8 <= 0) goto L22;
        ((Widget) this).contentView.postDelayed(new k(this), r8);
        return;
    L22:
        if (this.l == false) goto L24;
        return;
    L24:
        if (isViewValid() == false) goto L31;
        zq();
        return;
    L31:
        return;
    L18:
        r8 = 300;
        goto L19
    }
}
