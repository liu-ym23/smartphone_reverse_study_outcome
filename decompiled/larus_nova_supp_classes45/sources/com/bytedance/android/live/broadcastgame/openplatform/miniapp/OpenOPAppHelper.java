package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.f;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenOPAppHelper {
    public static final /* synthetic */ int a = 0;

    public static final class CheckGameConflictNode extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;
        public final Context c;

        public final Context getContext() {
            return this.c;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(final com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r8) {
            Intrinsics.checkNotNullParameter(r8, "chains");
            int r0 = q.a;
            StringBuilder r1 = new StringBuilder("启动小程序, 命中effect等游戏互斥逻辑");
            r r2 = this.a.c();
            if (r2 == null) goto L5;
            String r3 = r2.b();
        L6:
            r1.append(r3);
            q.g(r1.toString(), "OpenOPAppHelper");
            ((IInteractGameService) k.n(IInteractGameService.class)).tryGetSwitchGameConfirmDialog(this.a, this.c, this.b, new OpenOPAppHelper$CheckGameConflictNode$process$1(r8), new OpenOPAppHelper$CheckGameConflictNode$process$2(this));
            return;
        L5:
            r3 = null;
            goto L6
        }

        public CheckGameConflictNode(u r2, DataCenter r3, Context r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class CheckMiniAppRunningNode extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;
        public final Context c;

        public final Context getContext() {
            return this.c;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r6) {
            Intrinsics.checkNotNullParameter(r6, "chains");
            int r0 = n.a;
            u r1 = this.a;
            final String r2 = n.l(r1.groupType, r1.c, false);
            r r3 = this.a.c();
            ShelfInfo r4 = null;
            if (r3 == null) goto L5;
            String r5 = r3.b();
        L6:
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r7 = AnchorMiniAppDataContext.a.a();
            if (r7 == null) goto L15;
            com.bytedance.live.datacontext.n r8 = r7.getShelfInfo();
            if (r8 == null) goto L15;
            ShelfInfo r9 = (ShelfInfo) r8.getValue();
            if (r9 == null) goto L15;
            ShelfMicroAppInfo r11 = r9.appInfo;
            if (r11 == null) goto L15;
            String r12 = r11.appId;
        L17:
            if (Intrinsics.areEqual(r5, r12) == false) goto L19;
            this.b.put("cmd_live_toolbarmore_dialog_dismiss", 0);
            int r13 = OpenOPAppHelper.a;
            OpenOPAppHelper.a(this.a, r2);
            return;
        L19:
            AnchorMiniAppDataContext r14 = AnchorMiniAppDataContext.a.a();
            if (r14 == null) goto L24;
            com.bytedance.live.datacontext.n r15 = r14.getShelfInfo();
            if (r15 == null) goto L24;
            r4 = (ShelfInfo) r15.getValue();
        L24:
            if (r4 == null) goto L32;
            int r16 = OpenOPAppHelper.a;
            Context r17 = this.c;
            Function0<Unit> r18 = new OpenOPAppHelper$CheckMiniAppRunningNode$process$1(this, r2);
            OpenOPAppHelper$CheckMiniAppRunningNode$process$2 r19 = OpenOPAppHelper$CheckMiniAppRunningNode$process$2.INSTANCE;
            x0.d r21 = new x0.d();
            r21.b = r17;
            r21.a = 7;
            r21.k = false;
            r21.l = false;
            r21.c = s1.B(2131922677);
            r21.d = s1.B(2131922675);
            com.bytedance.android.live.broadcastgame.openplatform.miniapp.c r22 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.c(r18);
            x0.c[] r23 = r21.g;
            x0.c r24 = r23[0];
            if (r24 != null) goto L28;
            r24 = new x0.c();
            r23[0] = r24;
        L28:
            r24.a = "确认";
            r24.b = r22;
            com.bytedance.android.live.broadcastgame.openplatform.miniapp.d r25 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.d(r19);
            x0.c[] r26 = r21.g;
            x0.c r27 = r26[1];
            if (r27 != null) goto L31;
            r27 = new x0.c();
            r26[1] = r27;
        L31:
            r27.a = "取消";
            r27.b = r25;
            x0.b.g(new x0(r21.b, r21));
            return;
        L32:
            r6.a();
            return;
        L15:
            r12 = null;
            goto L17
        L5:
            r5 = null;
            goto L6
        }

        public CheckMiniAppRunningNode(u r2, DataCenter r3, Context r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class CheckMiniGameToolbarConflictNode extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final p a;

        public CheckMiniGameToolbarConflictNode(p r2) {
            Intrinsics.checkNotNullParameter(r2, "miniAppHelper");
            this.a = r2;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(final com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r3) {
            Intrinsics.checkNotNullParameter(r3, "chains");
            this.a.a(new OpenOPAppHelper$CheckMiniGameToolbarConflictNode$process$1(this, r3), OpenOPAppHelper$CheckMiniGameToolbarConflictNode$process$2.INSTANCE);
        }
    }

    public static final class CheckOpenPlatformPluginRunningNode extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;
        public final Context c;
        public final boolean d;

        public final Context getContext() {
            return this.c;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(final com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r11) {
            Intrinsics.checkNotNullParameter(r11, "chains");
            DataContext r0 = com.bytedance.live.datacontext.d.d(RoomContext.class);
            String r2 = null;
            if ((r0 instanceof RoomContext) == true) goto L5;
            r0 = null;
        L5:
            RoomContext r1 = (RoomContext) r0;
            if (r1 == null) goto L10;
            m r3 = r1.getRoom();
            if (r3 == null) goto L10;
            final Room r4 = (Room) r3.getValue();
        L11:
            r r5 = this.a.c();
            if (r5 == null) goto L23;
            String r6 = r5.b();
            if (r6 == null) goto L23;
            if (InteractGameContext.Companion.h(r6) != true) goto L23;
            if (this.d == true) goto L23;
            int r12 = q.a;
            StringBuilder r13 = new StringBuilder("复访小程序, 直接展示面板, ");
            r r7 = this.a.c();
            if (r7 == null) goto L22;
            r2 = r7.b();
        L22:
            r13.append(r2);
            q.g(r13.toString(), "OpenOPAppHelper");
            this.b.put("cmd_live_toolbarmore_dialog_dismiss", 0);
            xs2.b.a().post(new f("from_panel"));
            OpenPlatformMonitorUtils.c.l(this.a, new com.bytedance.android.live.broadcastgame.api.openplatform.e(r4, "anchor", 12), false);
            return;
        L23:
            OpenPlatformMonitorUtils.c.l(this.a, new com.bytedance.android.live.broadcastgame.api.openplatform.e(r4, "anchor", 12), true);
            int r8 = q.a;
            StringBuilder r9 = new StringBuilder("切换当前挂载的小程序, ");
            r r14 = this.a.c();
            if (r14 == null) goto L26;
            r2 = r14.b();
        L26:
            r9.append(r2);
            q.g(r9.toString(), "OpenOPAppHelper");
            ((IInteractGameService) k.n(IInteractGameService.class)).tryGetSwitchGameConfirmDialog(this.a, this.c, this.b, new OpenOPAppHelper$CheckOpenPlatformPluginRunningNode$process$2(r11), new OpenOPAppHelper$CheckOpenPlatformPluginRunningNode$process$3(this, r4));
            return;
        L10:
            r4 = null;
            goto L11
        }

        public CheckOpenPlatformPluginRunningNode(u r2, DataCenter r3, Context r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class CheckToolbarConflictNode extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final p b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(final com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r3) {
            Intrinsics.checkNotNullParameter(r3, "chains");
            this.b.a(new OpenOPAppHelper$CheckToolbarConflictNode$process$1(this, r3), new OpenOPAppHelper$CheckToolbarConflictNode$process$2(this));
        }

        public CheckToolbarConflictNode(u r2, p r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "miniAppHelper");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class a extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;
        public final Context c;

        public final Context getContext() {
            return this.c;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r6) {
            Intrinsics.checkNotNullParameter(r6, "chains");
            int r0 = n.a;
            u r1 = this.a;
            long r2 = r1.groupType;
            r r3 = r1.c();
            c0 r4 = null;
            if (r3 == null) goto L7;
            c0 r5 = r3.x();
            if (r5 == null) goto L7;
            String r7 = r5.gameId;
        L8:
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r8 = AnchorMiniGameDataContext.a.a();
            if (r8 == null) goto L13;
            com.bytedance.live.datacontext.n r9 = r8.getFirstMountGameId();
            if (r9 == null) goto L13;
            String r11 = (String) r9.getValue();
        L15:
            if (r2.a(r7) == false) goto L27;
            AnchorMiniGameDataContext r12 = AnchorMiniGameDataContext.a.a();
            if (r12 == null) goto L23;
            com.bytedance.live.datacontext.n r13 = r12.getMicroGameInfo();
            if (r13 == null) goto L23;
            c0 r14 = (c0) r13.getValue();
            if (r14 == null) goto L23;
            String r15 = r14.gameId;
        L25:
            if (Intrinsics.areEqual(r7, r15) == false) goto L27;
            this.b.put("cmd_live_toolbarmore_dialog_dismiss", 0);
            int r16 = OpenOPAppHelper.a;
            k.n(IOpenPlatformMgAnchorService.class).mount(this.c, this.a);
            return;
        L23:
            r15 = null;
        L27:
            AnchorMiniGameDataContext r17 = AnchorMiniGameDataContext.a.a();
            if (r17 == null) goto L33;
            com.bytedance.live.datacontext.n r18 = r17.getMicroGameInfo();
            if (r18 == null) goto L33;
            r4 = (c0) r18.getValue();
        L33:
            if (r4 == null) goto L44;
            AnchorMiniGameDataContext r19 = AnchorMiniGameDataContext.a.a();
            if (r19 == null) goto L42;
            m r21 = r19.getSupportChangeMount();
            if (r21 == null) goto L42;
            if (((Boolean) r21.getValue()).booleanValue() == true) goto L42;
            f2.c(s1.B(2131922678), 0);
            return;
        L42:
            r6.a();
            return;
        L44:
            if (r2.a(r7) == true) goto L46;
        L58:
            r6.a();
            return;
        L46:
            if (r2.a(r11) == false) goto L58;
            if ((!Intrinsics.areEqual(r7, r11)) == false) goto L58;
            AnchorMiniGameDataContext r22 = AnchorMiniGameDataContext.a.a();
            if (r22 == null) goto L57;
            m r23 = r22.getSupportChangeMount();
            if (r23 == null) goto L57;
            if (((Boolean) r23.getValue()).booleanValue() == true) goto L57;
            f2.c(s1.B(2131922678), 0);
            return;
        L57:
            r6.a();
            return;
        L13:
            r11 = null;
        L7:
            r7 = null;
            goto L8
        }

        public a(u r2, DataCenter r3, Context r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final Context a;
        public final u b;

        public final Context getContext() {
            return this.a;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r4) {
            Intrinsics.checkNotNullParameter(r4, "chains");
            int r0 = n.a;
            u r1 = this.b;
            long r2 = r1.groupType;
            int r3 = OpenOPAppHelper.a;
            Context r5 = this.a;
            k.n(IOpenPlatformMgAnchorService.class).mount(r5, r1);
            r4.a();
        }

        public b(Context r2, u r3, DataCenter r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "dataCenter");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r4) {
            Intrinsics.checkNotNullParameter(r4, "chains");
            this.b.put("cmd_live_toolbarmore_dialog_dismiss", 0);
            int r5 = n.a;
            u r6 = this.a;
            String r7 = n.l(r6.groupType, r6.c, false);
            int r0 = OpenOPAppHelper.a;
            OpenOPAppHelper.a(this.a, r7);
        }

        public c(u r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final DataCenter b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r7) {
            Intrinsics.checkNotNullParameter(r7, "chains");
            int r0 = q.a;
            StringBuilder r1 = new StringBuilder("启动开放平台功能,Schema为: ");
            r r2 = this.a.c();
            if (r2 == null) goto L5;
            String r3 = r2.C();
        L6:
            r1.append(r3);
            q.g(r1.toString(), "OpenOPAppHelper");
            this.b.put("cmd_interact_game_startup", this.a);
            DataContext r4 = com.bytedance.live.datacontext.d.d(RoomContext.class);
            if ((r4 instanceof RoomContext) == true) goto L9;
            r4 = null;
        L9:
            RoomContext r5 = (RoomContext) r4;
            if (r5 == null) goto L14;
            m r6 = r5.getRoom();
            if (r6 == null) goto L14;
            Room r8 = (Room) r6.getValue();
        L15:
            OpenPlatformMonitorUtils r9 = OpenPlatformMonitorUtils.c;
            OpenPlatformMonitorUtils.m(this.a, new com.bytedance.android.live.broadcastgame.api.openplatform.e(r8, "anchor", 12), 0, null, null);
            r7.a();
            return;
        L14:
            r8 = null;
            goto L15
        L5:
            r3 = null;
            goto L6
        }

        public d(u r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b {
        public final u a;
        public final Map<String, Object> b;
        public final boolean c;
        public final boolean d;
        public final com.bytedance.android.live.broadcastgame.api.openplatform.b e;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b
        public final void a(com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r11) {
            Intrinsics.checkNotNullParameter(r11, "chains");
            com.bytedance.android.live.broadcastgame.api.openplatform.b r1 = this.e;
            r r0 = this.a.c();
            if (r0 == null) goto L5;
            long r2 = r0.p();
        L6:
            r r3 = this.a.c();
            if (r3 == null) goto L10;
            String r4 = r3.b();
            if (r4 == null) goto L10;
        L11:
            r r5 = this.a.c();
            if (r5 == null) goto L15;
            String r6 = r5.C();
            if (r6 == null) goto L15;
        L16:
            String r7 = r4;
            r1.i(r2, r7, r6, this.b, this.c, this.d);
            r11.a();
            return;
        L15:
            r6 = "";
        L10:
            r4 = "";
            goto L11
        L5:
            r2 = 0;
            goto L6
        }

        public e(u r2, Map r3, com.bytedance.android.live.broadcastgame.api.openplatform.b r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "pluginManager");
            this.a = r2;
            this.b = r3;
            this.c = true;
            this.d = true;
            this.e = r4;
        }
    }

    public OpenOPAppHelper() {
    }

    static {
    }

    public static final void a(u r18, String r19) {
        IOpenPlatformAnchorService r0 = k.n(IOpenPlatformAnchorService.class);
        r r1 = r18.c();
        if (r1 == null) goto L6;
        String r2 = r1.C();
        if (r2 == null) goto L6;
    L7:
        String r3 = LaunchParamConstant.Scene.a;
        List r4 = r18.j;
        if (r4 != null) goto L10;
        r4 = new ArrayList();
    L10:
        r0.openMiniApp(r2, new ko0.b(r3, GamePromoteDataContext.LIVE, "preview", "solid_entrance", "live_take_page", r19, null, null, null, false, false, r4, 8128));
        return;
    L6:
        r2 = "";
        goto L7
    }

    public static void b(Context r6, u r7, p r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "miniAppHelper");
        ArrayList r0 = new ArrayList();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L16;
        com.bytedance.live.datacontext.n r2 = r1.getDataCenter();
        if (r2 == null) goto L17;
        DataCenter r3 = (DataCenter) r2.getValue();
        if (r3 == null) goto L18;
        CheckMiniAppRunningNode r4 = new CheckMiniAppRunningNode(r7, r3, r6);
        Intrinsics.checkNotNullParameter(r4, "node");
        r0.add(r4);
        CheckToolbarConflictNode r5 = new CheckToolbarConflictNode(r7, r8);
        Intrinsics.checkNotNullParameter(r5, "node");
        r0.add(r5);
        c r9 = new c(r7, r3);
        Intrinsics.checkNotNullParameter(r9, "node");
        r0.add(r9);
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r11 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a();
        Iterator r12 = r0.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b r13 = (com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b) r12.next();
        ((ArrayList) r11.a).add(r13);
        goto L11
    L13:
        r11.b = 0;
        r11.a();
        return;
    L18:
        return;
    L17:
        return;
    }
}
