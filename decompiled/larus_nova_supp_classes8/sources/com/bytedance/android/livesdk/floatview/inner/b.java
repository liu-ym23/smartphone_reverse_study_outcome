package com.bytedance.android.livesdk.floatview.inner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.bs;
import com.bytedance.android.livesdk.config.g4;
import com.bytedance.android.livesdk.config.n3;
import com.bytedance.android.livesdk.config.rr;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.listener.ICallStatusListener;
import com.bytedance.android.livesdkapi.listener.ILoginOrLogoutListener;
import com.bytedance.android.livesdkapi.listener.ITeenModeStatusListener;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> a = null;
    public static final List<IInnerFloatWindowManager> b = null;
    public static DataCenter c;
    public static final a d = null;
    public static final d e = null;
    public static final c f = null;
    public static boolean g;
    public static final com.bytedance.android.livesdk.floatview.q h = null;

    public static final class a implements ICallStatusListener {
        public a() {
        }

        public final void onCallActivityDestroy(boolean r1) {
        }

        public final void onCallEnd() {
        }

        public final void onCallStart() {
            Iterator r0 = ((ArrayList) b.a).iterator();
        L3:
            Object r2 = null;
            String r3 = null;
            if (r0.hasNext() == false) goto L12;
            Object r1 = r0.next();
            String r4 = InnerFloatViewTAG.TAG_LINKMIC_ONLINE_FLOAT.getTag();
            IInnerFloatWindowSceneInterceptor r5 = (IInnerFloatWindowSceneInterceptor) ((Pair) r1).getFirst();
            if (r5 == null) goto L9;
            r3 = r5.tag();
        L9:
            if (TextUtils.equals(r4, r3) == false) goto L3;
            r2 = r1;
        L12:
            if (((Pair) r2) == null) goto L14;
            boolean r6 = false;
        L15:
            if (r6 == false) goto L21;
            b.b("call", 0, true);
            return;
        L21:
            return;
        L14:
            r6 = true;
            goto L15
        }

        public final void onCallActivityCreate(boolean r5) {
            Iterator r6 = ((ArrayList) b.a).iterator();
        L3:
            Object r1 = null;
            String r2 = null;
            if (r6.hasNext() == false) goto L12;
            Object r0 = r6.next();
            String r3 = InnerFloatViewTAG.TAG_LINKMIC_ONLINE_FLOAT.getTag();
            IInnerFloatWindowSceneInterceptor r4 = (IInnerFloatWindowSceneInterceptor) ((Pair) r0).getFirst();
            if (r4 == null) goto L9;
            r2 = r4.tag();
        L9:
            if (TextUtils.equals(r3, r2) == false) goto L3;
            r1 = r0;
        L12:
            if (((Pair) r1) == null) goto L18;
            b.b("call", 0, true);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.floatview.inner.b$b, reason: collision with other inner class name */
    public static final class C0349b implements nz.s {
        public C0349b() {
        }

        public final void a(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void b() {
            b.g = false;
            Iterator r1 = ((ArrayList) b.b).iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            IInnerFloatWindowManager r2 = (IInnerFloatWindowManager) r1.next();
            if (r2 == null) goto L4;
            if (r2.floatWindowEntityExists() == false) goto L4;
            r2.showFloatWindow();
            int r3 = f.a;
            Intrinsics.checkNotNullParameter("back to app", "reason");
            ALogger.i("InnerFloatWindowTracker", "show window for reason: back to app");
            Lazy r4 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.e(false);
            goto L4
        }

        public final void onCreate(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onPause(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStop(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void c(Context r10) {
            Iterator r11 = ((ArrayList) b.b).iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            IInnerFloatWindowManager r2 = (IInnerFloatWindowManager) r11.next();
            if (r2 == null) goto L4;
            if (r2.floatWindowEntityExists() == false) goto L4;
            if (r2.dismissWindowWhenToDesktop() == false) goto L4;
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(r2, 0, null, false, 3, null);
            f.a("exit to desktop");
            goto L4
        L12:
            Iterator r12 = ((ArrayList) b.b).iterator();
        L14:
            if (r12.hasNext() == false) goto L29;
            IInnerFloatWindowManager r0 = (IInnerFloatWindowManager) r12.next();
            if (r0 == null) goto L14;
            if (r0.floatWindowIsShowing() == false) goto L14;
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == true) goto L24;
            if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_INNER_FLOAT_WINDOW_TO_OUT.getValue()).booleanValue() == true) goto L24;
        L25:
            r0.hideFloatWindow();
            int r1 = f.a;
            Intrinsics.checkNotNullParameter("exit to desktop", "reason");
            ALogger.i("InnerFloatWindowTracker", "hide window for reason: exit to desktop");
        L24:
            if (r0.hideWindowWhenToDesktop() == true) goto L25;
            if (b.g == true) goto L14;
            Lazy r3 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.e(true);
            goto L14
        L29:
            b.g = true;
        }

        public final void onResume(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r3 = b.a;
            b.g = false;
        }

        public final void onStart(Activity r14) {
            Intrinsics.checkNotNullParameter(r14, "activity");
            List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r0 = b.a;
            if (StringsKt.contains$default(r14.getLocalClassName(), "VideoRecordNewActivity", false, 2, null) == false) goto L5;
        L6:
            Iterator r1 = ((ArrayList) b.b).iterator();
        L8:
            if (r1.hasNext() == false) goto L26;
            IInnerFloatWindowManager r6 = (IInnerFloatWindowManager) r1.next();
            if (r6 == null) goto L8;
            if (r6.floatWindowEntityExists() == false) goto L8;
            if (StringsKt.contains$default(r14.getLocalClassName(), "VideoRecordNewActivity", false, 2, null) == false) goto L16;
            String r9 = "VideoRecordNewActivity";
        L17:
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(r6, 0, r9, false, 5, null);
            f.a("enter publish page");
            goto L8
        L16:
            r9 = "";
            goto L17
        L26:
            return;
        L5:
            if (StringsKt.contains$default(r14.getLocalClassName(), "XmojiFaceRecordActivity", false, 2, null) == true) goto L6;
        }
    }

    public static final class c implements ILoginOrLogoutListener {
        public c() {
        }

        public final void onAccountResult(int r2, boolean r3, int r4) {
            if (r2 != 2) goto L5;
        L6:
            b.b("user logout or switch account", 0, true);
            return;
        L5:
            if (r2 == 3) goto L6;
        }
    }

    public static final class d implements ITeenModeStatusListener {
        public d() {
        }

        public final void onTeenModeStatusChange(boolean r1) {
        }

        public final void onReceiveServerStatus(boolean r4) {
            if (r4 == false) goto L5;
            b.b("teen mode on", 0, true);
            return;
        }
    }

    public b() {
    }

    static {
        a = new ArrayList();
        b = new ArrayList();
        d = new a();
        e = new d();
        f = new c();
        h = new com.bytedance.android.livesdk.floatview.q(jc1.a.b(), new C0349b());
        Iterator<com.bytedance.android.livesdk.floatview.inner.c> r0 = com.bytedance.android.livesdk.floatview.inner.c.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.floatview.inner.c r1 = r0.next();
        b.add(r1.a);
        a.add(new Pair(r1.b, Integer.valueOf(r1.c)));
        goto L4
    L6:
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r2 = a;
        if (r2.size() <= 1) goto L10;
        CollectionsKt.sortWith(r2, new com.bytedance.android.livesdk.floatview.inner.a());
    L10:
        if (tb1.c.a == false) goto L25;
        IHostApp r3 = jc1.k.f(IHostApp.class);
        if (r3 == null) goto L14;
        r3.registerLiveLifeCycleListener(h);
    L14:
        IHostBusiness r4 = jc1.k.f(IHostBusiness.class);
        if (r4 == null) goto L17;
        r4.registerCallStatusListener(d);
    L17:
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        if (r5 == null) goto L20;
        r5.registerTeenModeStatusListener(e);
    L20:
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        if (r6 == null) goto L26;
        r6.registerLoginOrLogoutListener(f);
        return;
    L26:
        return;
    }

    public static boolean a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L9:
        if (r2 == null) goto L11;
        boolean r3 = bs.a.getValue().booleanValue();
    L12:
        Boolean r4 = g4.a.getValue();
        Integer r5 = n3.a.getValue();
        if (r5 == null) goto L22;
        if (r5.intValue() != 0) goto L22;
        if (r3 == true) goto L22;
        if (r4.booleanValue() == true) goto L22;
        return false;
    L22:
        if (com.bytedance.android.livesdk.floatview.p.c() == true) goto L25;
        return false;
    L25:
        if (PadConfigUtils.c() == false) goto L28;
        return false;
    L28:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == false) goto L30;
        return false;
    L30:
        DataCenter r6 = c;
        if (r6 != null) goto L34;
        return false;
    L34:
        if (z.m(r6, true) == true) goto L36;
    L61:
        return false;
    L36:
        if (z.e(r6, false) == true) goto L61;
        Boolean r7 = rr.a.getValue();
        if (TextUtils.equals((CharSequence) r6.get("user_distribution_source", ""), "chat") == true) goto L41;
    L43:
        IMediaReplayService r8 = jc1.k.f(IMediaReplayService.class);
        if (r8 == null) goto L49;
        if (r8.isReplaySync(z.o(r6).id) != true) goto L49;
        return false;
    L49:
        if (((LiveMode) r6.get("data_live_mode", LiveMode.VIDEO)) != LiveMode.AUDIO) goto L55;
        if (r3 == true) goto L55;
        if (r4.booleanValue() == true) goto L55;
        return false;
    L55:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r6), PaidSceneEnum.PAID_ROOM, 2) == true) goto L58;
        return false;
    L58:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r6).F0(PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L60;
        return false;
    L60:
        return true;
    L41:
        if (r7.booleanValue() == true) goto L43;
        return false;
    L11:
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public static void c(HashMap r3, boolean r4) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        IInnerFloatWindowSceneInterceptor r1 = (IInnerFloatWindowSceneInterceptor) ((Pair) r0.next()).getFirst();
        if (r1 == null) goto L4;
        if (r1.canShow() == false) goto L4;
        FloatWindowConfig r2 = new FloatWindowConfig(false);
        r2.setLogExtras(r3);
        r2.setAutoPlay(r4);
        DataCenter r5 = c;
        if (r5 == null) goto L12;
        Room r6 = z.o(r5);
    L13:
        r1.showFloat(r6, r2);
        int r7 = f.a;
        String r8 = "first start of TAG: " + r1.tag();
        Intrinsics.checkNotNullParameter(r8, "reason");
        ALogger.i("InnerFloatWindowTracker", "show window for reason: " + r8);
        return;
    L12:
        r6 = null;
        goto L13
    }

    public static void b(String r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        IInnerFloatWindowManager r1 = (IInnerFloatWindowManager) r0.next();
        if (r1 == null) goto L4;
        if (r1.floatWindowEntityExists() == false) goto L4;
        r1.dismissFloatWindow(r4, r3, r6);
        f.a(r3);
        goto L4
    }
}
