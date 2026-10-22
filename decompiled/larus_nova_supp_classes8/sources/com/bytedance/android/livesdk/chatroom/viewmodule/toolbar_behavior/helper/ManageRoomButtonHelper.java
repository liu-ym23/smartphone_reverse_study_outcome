package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarManageBehavior;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.t;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ManageRoomButtonHelper {
    public static final Map<Integer, ToolbarButton> a = null;
    public static final ManageRoomButtonHelper b = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RoomContext a;

        public a(RoomContext r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            if (((BaseResponse) r5).data != null) goto L5;
            return;
        L5:
            if (this.a.isCleared() == true) goto L10;
            boolean r0 = ((Room) this.a.getRoom().getValue()).getMRoomAuthStatus().getEnableDanmaku();
            boolean r6 = ((Room) ((BaseResponse) r5).data).getMRoomAuthStatus().getEnableDanmaku();
            ((Room) this.a.getRoom().getValue()).getMRoomAuthStatus().setEnableDanmaku(r6);
            ALogger.w("LiveRoomPermission", "danmuku update: " + r0 + " -> " + r6);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.w("LiveRoomPermission", "danmuku update failed");
            ((Throwable) r3).printStackTrace();
        }
    }

    public ManageRoomButtonHelper() {
    }

    static {
        b = new ManageRoomButtonHelper();
        LiveRoomPermission.Companion r1 = LiveRoomPermission.D;
        r1.getClass();
        r1.getClass();
        r1.getClass();
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(LiveRoomPermission.m.a), ToolbarButton.PROMPT), TuplesKt.to(Integer.valueOf(LiveRoomPermission.n.a), ToolbarButton.WISH_LIST), TuplesKt.to(Integer.valueOf(LiveRoomPermission.o.a), ToolbarButton.VOTE)});
    }

    public static void a() {
        String r0 = k.n(IUserService.class).user().b().getIdString();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L9;
        m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L9;
        long r4 = r3.id;
    L10:
        String r5 = r0 + r4;
        e r6 = l42.a.i;
        Map r7 = (Map) r6.getValue();
        if (r7 != null) goto L13;
        r7 = new HashMap();
    L13:
        r7.put(r5, "");
        f.d(r6, r7);
        if (c.i() == null) goto L21;
        com.bytedance.android.live.profit.privilege.a r8 = c.i();
        if (r8 == null) goto L22;
        m r9 = r8.isInDanmakuMode();
        if (r9 == null) goto L23;
        r9.setValue(Boolean.FALSE);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r4 = -1;
        goto L10
    }

    public static void b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = ((Room) r0.getRoom().getValue()).id;
        l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).getRoomInfoByScene(r1, "admin_privilege").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(r0), b.a);
    }

    public static void c(DataCenter r22, com.bytedance.android.livesdk.message.model.k.a r23) {
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        Intrinsics.checkNotNullParameter(r23, "msg");
        int r1 = r23.b();
        RoomPermissionContext.Companion.getClass();
        RoomPermissionContext r3 = RoomPermissionContext.a.f(r22);
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, r22, 0, 2);
        if (r4 == null) goto L7;
        m r5 = r4.getUser();
        if (r5 == null) goto L7;
        User r6 = (User) r5.getValue();
    L9:
        if (r3 == null) goto L92;
        if (r6 == null) goto L92;
        if (r1 != 3) goto L15;
        List r2 = r23.a();
    L16:
        ArrayList r11 = new ArrayList();
        Iterator r7 = r2.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        int r12 = ((Number) r7.next()).intValue();
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r13 = LiveRoomPermission.Companion.a(r12);
        if (r13 == null) goto L18;
        r11.add(r13);
        goto L18
    L22:
        ArrayList r8 = new ArrayList();
        Iterator r14 = r11.iterator();
    L24:
        if (r14.hasNext() == false) goto L27;
        r8.add(Integer.valueOf(((LiveRoomPermission) r14.next()).a));
        goto L24
    L27:
        if (r11.isEmpty() == false) goto L30;
        ALogger.w("LiveRoomPermission", "permission lis null");
        return;
    L30:
        List r15 = CollectionsKt.toMutableList((Collection) r3.getCurrentPermissions().getValue());
        t r16 = r6.getUserAttr();
        if (r16 == null) goto L36;
        List r17 = r16.getAdminPrivileges();
        if (r17 == null) goto L36;
        List r18 = CollectionsKt.toMutableList(r17);
        if (r18 == null) goto L36;
    L38:
        if (r6.getUserAttr() != null) goto L40;
        r6.setUserAttr(new UserAttr());
    L40:
        ArrayList r19 = new ArrayList();
        ArrayList r110 = new ArrayList();
        boolean r9 = true;
        if (r1 != 1) goto L43;
        r19 = new ArrayList(CollectionsKt.union(r15, r11));
        r110 = new ArrayList(CollectionsKt.union(r18, r8));
    L59:
        r15.clear();
        r15.addAll(r19);
        r18.clear();
        r18.addAll(r110);
        r3.getCurrentPermissions().setValue(r15);
        t r10 = r6.getUserAttr();
        if (r10 == null) goto L62;
        r10.setAdminPrivileges(r18);
    L62:
        if (r1 == 1) goto L66;
        if (r1 == 3) goto L66;
        r9 = false;
    L66:
        if (r9 == true) goto L69;
        r8 = null;
    L69:
        if (r8 == null) goto L82;
        Iterator r20 = r8.iterator();
    L72:
        if (r20.hasNext() == false) goto L76;
        Object r21 = r20.next();
        if (a.keySet().contains(Integer.valueOf(((Number) r21).intValue())) == false) goto L72;
        Object r24 = r21;
    L77:
        Integer r25 = (Integer) r24;
        if (r25 == null) goto L82;
        ToolbarButton r26 = a.get(Integer.valueOf(r25.intValue()));
        if (r26 == null) goto L82;
        r22.put("cmd_show_admin_bubble_in_more", r26);
        goto L82
    L76:
        r24 = null;
    L82:
        LiveRoomPermission.D.getClass();
        if (r11.contains(LiveRoomPermission.j) == false) goto L87;
        b();
        return;
    L87:
        if (r11.contains(LiveRoomPermission.z) == false) goto L90;
        b();
        return;
    L90:
        k.n(IUserService.class).user().f(r6.getUserAttr());
        r22.put("data_user_in_room", r6);
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r22, 0, 2);
        Intrinsics.checkNotNull(r0);
        r0.getUser().setValue(r6);
        ALogger.i("LiveRoomPermission", "update to " + CollectionsKt.joinToString$default(r15, null, null, null, 0, null, ManageRoomButtonHelper$handleAdminPermissionChange$5.INSTANCE, 31, null));
        return;
    L43:
        if (r1 != 2) goto L48;
        r19 = new ArrayList(CollectionsKt.subtract(r15, r11));
        r110 = new ArrayList(CollectionsKt.subtract(r18, r8));
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r27 = LiveRoomPermission.u;
        if (r8.contains(Integer.valueOf(r27.a)) == false) goto L47;
        d(r27.a, r110, r19);
    L47:
        a();
        goto L59
    L48:
        if (r1 != 3) goto L59;
        r19 = new ArrayList(r11);
        r110 = new ArrayList(r8);
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r28 = LiveRoomPermission.u;
        if (r18.contains(Integer.valueOf(r28.a)) == true) goto L52;
    L54:
        LiveRoomPermission r29 = LiveRoomPermission.j;
        if (r15.contains(r29) == false) goto L59;
        if (r11.contains(r29) == true) goto L59;
        a();
        goto L59
    L52:
        if (r110.contains(Integer.valueOf(r28.a)) == true) goto L54;
        d(r28.a, r110, r19);
    L36:
        r18 = new ArrayList();
        goto L38
    L15:
        r2 = CollectionsKt.listOf(Integer.valueOf(r23.c()));
    L92:
        ALogger.w("LiveRoomPermission", "null, ctx: " + r3 + ", user: " + r6);
        return;
    L7:
        r6 = null;
        goto L9
    }

    public static void d(int r1, List r2, List r3) {
        LiveRoomPermission.D.getClass();
        if (r1 != LiveRoomPermission.u.a) goto L6;
        LiveRoomPermission r4 = LiveRoomPermission.q;
        r2.remove(Integer.valueOf(r4.a));
        r3.remove(r4);
        LiveRoomPermission r5 = LiveRoomPermission.s;
        r2.remove(Integer.valueOf(r5.a));
        r3.remove(r5);
        LiveRoomPermission r6 = LiveRoomPermission.r;
        r2.remove(Integer.valueOf(r6.a));
        r3.remove(r6);
        LiveRoomPermission r7 = LiveRoomPermission.t;
        r2.remove(Integer.valueOf(r7.a));
        r3.remove(r7);
        return;
    }

    public static void e(DataCenter r6, boolean r7, Set r8, List r9, Room r10) {
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r9, "permissions");
        g3 r0 = y3.f(r6);
        ToolbarButton r1 = ToolbarButton.MANAGE;
        boolean r4 = true;
        r0.p(r1.extended(), new ToolbarManageBehavior(true));
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r11 == null) goto L9;
        m r12 = r11.isPortraitInteraction();
        if (r12 == null) goto L9;
        Boolean r13 = (Boolean) r12.getValue();
        if (r13 == null) goto L9;
        boolean r14 = r13.booleanValue();
    L10:
        LiveRoomPermission.D.getClass();
        if (LiveRoomPermission.Companion.d(r9) == true) goto L20;
        if (r7 == false) goto L19;
        if (r10 == null) goto L15;
        String r15 = r10.getAnchorAbValue("admin_optimize_third");
    L17:
        if ("1".equals(r15) == false) goto L19;
    L15:
        r15 = null;
    L19:
        boolean r16 = false;
    L21:
        UtilityKotlinExtentionsKt.c(r8, r1, r16);
        ToolbarButton r17 = ToolbarButton.VOTE;
        if (r9.contains(LiveRoomPermission.o) == false) goto L25;
        if (r14 == false) goto L25;
    L26:
        UtilityKotlinExtentionsKt.c(r8, r17, r4);
        return;
    L25:
        r4 = false;
    L20:
        r16 = true;
    L9:
        r14 = true;
        goto L10
    }
}
