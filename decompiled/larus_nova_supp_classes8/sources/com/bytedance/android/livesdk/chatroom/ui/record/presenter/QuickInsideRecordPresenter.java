package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.record.z;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.record.VSVideoDataPushThread;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.utils.w;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeQuickRecordWidget;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import oo1.e;
import oo1.g;
import oo1.j;
import pm1.h;
import vr1.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class QuickInsideRecordPresenter extends b implements j {
    public static final /* synthetic */ int p = 0;
    public long k;
    public int l;
    public g m;
    public VSVideoDataPushThread n;
    public final IRoom o;

    public static final class a implements Runnable {
        public final /* synthetic */ QuickInsideRecordPresenter a;

        public a(QuickInsideRecordPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IQuickRecordPopupWindow r0 = this.a.a;     // Catch: Throwable -> L14
            if (r0 != null) goto L6;
        L19:
            return;
        L6:
            if (r0.isShowing() != true) goto L19;
            IQuickRecordPopupWindow r1 = this.a.a;     // Catch: Exception -> L11 Throwable -> L14
            if (r1 == null) goto L19;
            r1.dismiss();     // Catch: Exception -> L11 Throwable -> L14
        L11:
            e = move-exception;
            ALogger.e("QuickRecordBasePresenter", "recordDialog dismiss fail errorMsg:" + e.getMessage());     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.a
    public final void onStop() {
        IQuickRecordPopupWindow r0 = this.a;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void audioClose() {
        super.audioClose();
        g r0 = this.m;
        if (r0 == null) goto L9;
        e.f.set(false);
        CopyOnWriteArrayList<oo1.b> r2 = r0.x;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        r0.v.set(false);
    L9:
        if (this.n == null) goto L12;
        e.f.set(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void d(long r10) {
        com.bytedance.android.livesdk.chatroom.vs_base.player.a r0 = (com.bytedance.android.livesdk.chatroom.vs_base.player.a) h.d.c(com.bytedance.android.livesdk.chatroom.vs_base.player.a.class);
        if (r0 == null) goto L63;
        IPlayerProgressService r1 = r0.a(this.g);
        if (r1 == null) goto L63;
        MiddlewareRoomContext r2 = o3.b();
        if (r2 == null) goto L14;
        m r3 = r2.getVsInChorusConcert();
        if (r3 == null) goto L14;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L14;
        f2.c("合唱状态下不支持录屏", 0);
    L14:
        PlayerProgressServiceContext r4 = r1.provideContext(this.g);
        if (r4 == null) goto L17;
        Boolean r5 = r4.isPlaying();
    L19:
        if ((!Intrinsics.areEqual(r5, Boolean.FALSE)) == false) goto L62;
        int[] r6 = new int[2];
        this.h.getLocationInWindow(r6);
        Context r7 = getContext();
        if ((r7 instanceof Activity) == true) goto L24;
        r7 = null;
    L24:
        if (((Activity) r7) == null) goto L35;
        t r8 = r.r();
        Activity r9 = (Activity) getContext();
        DataCenter r11 = this.g;
        if (r11 == null) goto L33;
        IRoom r12 = (IRoom) r11.get("data_room");
        if (r12 == null) goto L33;
        IBaseUser r13 = r12.getOwner();
        if (r13 == null) goto L33;
        String r14 = r13.getNickName();
        if (r14 == null) goto L33;
    L34:
        this.a = r8.c(r9, r14);
    L33:
        r14 = "";
    L35:
        IQuickRecordPopupWindow r15 = this.a;
        if (r15 == null) goto L38;
        r15.setDismissListener(new QuickInsideRecordPresenter$showProcessDialog$2(this));
    L38:
        IQuickRecordPopupWindow r16 = this.a;
        if (r16 == null) goto L54;
        Context r17 = getContext();
        if ((r17 instanceof Activity) == true) goto L43;
        r17 = null;
    L43:
        Activity r18 = (Activity) r17;
        if (r18 == null) goto L52;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L52;
        View r20 = r19.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L53;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r21 = ThreadMethodProxy.currentThread();
        if (r21 == com.larus.home.impl.utils.c.a) goto L53;
        com.larus.home.impl.utils.c.a(r21, "getDecorView");
    L53:
        r16.showAtLocation(r20, 0, r6[0], r6[1]);
    L52:
        r20 = null;
    L54:
        e(ILiveRecordService.RecordStatus.RECORDING);
        this.m = new g(this);
        this.n = new VSVideoDataPushThread(this.g);
        DataCenter r22 = this.g;
        if (r22 == null) goto L59;
        if (((VideoViewParams) r22.get("live_render_view_params", null)) == null) goto L59;
    L59:
        f(false);
        ALogger.i("QuickRecordBasePresenter", "开启音频数据回调");
        ILivePlayerClient r23 = r.p().currentClient();
        if (r23 == null) goto L63;
        r23.setAudioProcessor(this, false);
        goto L63
    L62:
        f2.c("播放后即可录屏", 0);
        goto L63
    L17:
        r5 = null;
    L63:
        this.k = r10;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void audioProcess(ByteBuffer[] r8, int r9, long r10) {
        super.audioProcess(r8, r9, r10);
        if (r8 == null) goto L51;
        int r1 = 0;
        if (r8.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) != true) goto L52;
        int r2 = this.l;
        byte[] r3 = null;
        if (r9 >= 1) goto L13;
    L12:
        ByteBuffer r5 = null;
    L37:
        if (r5 == null) goto L40;
        r5.rewind();
        r3 = new byte[r5.remaining()];
        r5.get(r3);
    L40:
        if (r3 == null) goto L53;
        g r11 = this.m;
        if (r11 == null) goto L54;
        oo1.b r4 = new oo1.b(r3, r9, r10);
        if (e.f.get() == false) goto L55;
        System.currentTimeMillis();
        CopyOnWriteArrayList<oo1.b> r12 = r11.x;
        if (r12 == null) goto L56;
        r12.add(r4);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L13:
        if (r2 != 1) goto L20;
        if (r8.length < 1) goto L12;
        if (r8[0] == null) goto L12;
    L20:
        if (r2 == 2) goto L22;
    L28:
        r5 = ByteBuffer.allocate((r2 * r9) * 2);
        ByteOrder r6 = ByteOrder.LITTLE_ENDIAN;
        r5.order(r6);
        r5.clear();
        if (r2 != 1) goto L33;
        ByteBuffer r13 = r8[0];
        r13.order(r6);
    L31:
        if (r1 >= r9) goto L37;
        oo1.c.a(r13, r5);
        r1 = r1 + 1;
        goto L31
    L33:
        if (r2 != 2) goto L37;
        ByteBuffer r7 = r8[0];
        ByteBuffer r14 = r8[1];
        r7.order(r6);
        r14.order(r6);
    L35:
        if (r1 >= r9) goto L37;
        oo1.c.a(r7, r5);
        oo1.c.a(r14, r5);
        r1 = r1 + 1;
        goto L35
    L22:
        if (r8.length < 2) goto L12;
        if (r8[0] == null) goto L12;
        if (r8[1] != null) goto L28;
    L52:
        return;
    L7:
        r0 = false;
        goto L9
    }

    @Override // oo1.j
    public final void b(String r12, String r13, int r14) {
        e(ILiveRecordService.RecordStatus.FINISH);
        String r3 = "0";
        Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(this.k)), TuplesKt.to("is_success", "0")});
        if (TextUtils.isEmpty(r12) == true) goto L20;
        int r4 = w.a;
        if (TextUtils.isEmpty(r12) == true) goto L13;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r12);
        if (r5.exists() == false) goto L13;
        if (r5.length() <= 0) goto L13;
        boolean r6 = false;
    L14:
        if (r6 == true) goto L20;
        new z((WeakHandler) this.c.getValue()).execute1(new String[]{r12});
        Intrinsics.checkNotNull(r12);
        long r15 = this.d;
        Intrinsics.checkNotNullParameter(r12, "path");
        if (this.e == true) goto L19;
        this.h.getLocationOnScreen(this.b);
        int r2 = com.bytedance.android.livesdk.chatroom.utils.m.a;
        com.bytedance.android.livesdk.chatroom.utils.m.a(new QuickRecordBasePresenter$showRecordShareDialog$1(this, r15, r12));
    L19:
        r0.put("is_success", "1");
    L35:
        r.m().logQuickRecordTaskFinish(r0);
        return;
    L13:
        r6 = true;
    L20:
        r0.put("is_success", "0");
        if (r13 != null) goto L23;
        String r1 = "";
    L24:
        r0.put("error_msg", r1);
        r0.put("error_code", String.valueOf(r14));
        if (TextUtils.isEmpty(r12) == false) goto L27;
        String r7 = "1";
    L28:
        r0.put("path_is_empty", r7);
        View r8 = this.h;
        if (r8 == null) goto L31;
        r8.post(new a(this));
    L31:
        StringBuilder r9 = new StringBuilder("录制失败 失败原因:");
        r9.append(r13);
        r9.append(" 错误码:");
        r9.append(r14);
        r9.append(" 路径是否为空:");
        if (TextUtils.isEmpty(r12) == false) goto L34;
        r3 = "1";
    L34:
        r9.append(r3);
        ALogger.e("QuickRecordBasePresenter", r9.toString());
        f2.c("录制失败，请稍后再试", 0);
        goto L35
    L27:
        r7 = "0";
        goto L28
    L23:
        r1 = r13;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.b
    public final void audioOpen(final int r1, final int r2, int r3, int r4) {
        super.audioOpen(r1, r2, r3, r4);
        g r5 = this.m;
        if (r5 == null) goto L5;
        r5.C = r1;
        r5.D = r2;
    L5:
        e(ILiveRecordService.RecordStatus.RECORDING);
        this.l = r2;
        int r6 = com.bytedance.android.livesdk.chatroom.utils.m.a;
        com.bytedance.android.livesdk.chatroom.utils.m.a(new AnonymousClass1(this, r1, r2));
    }

    public QuickInsideRecordPresenter(Context r7, DataCenter r8, View r9, IRoom r10, boolean r11, LandscapeQuickRecordWidget r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "anchorView");
        Intrinsics.checkNotNullParameter(r12, "listener");
        super(r7, r8, r9, r11, r12);
        this.o = r10;
        this.l = 2;
    }
}
