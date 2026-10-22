package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkLoadWidgetUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MultiLinkLoadWidgetUtils$preloadALogEnable$2.INSTANCE);
    }

    public static boolean g() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().innerPreload() == false) goto L7;
        return true;
    }

    public static boolean a() {
        return vm2.h.W().byteLinkWrdsPreload();
    }

    public static boolean b() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().functionTypeLogFallBack() == false) goto L7;
        return true;
    }

    public static boolean c() {
        if (l() == true) goto L5;
    L9:
        return false;
    L5:
        if (vm2.h.W().enablePreFetchListData() == false) goto L9;
        if (((a50.a) vm2.f.e.getValue(null, vm2.f.a[3])).i() != true) goto L9;
        return true;
    }

    public static boolean d() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().logFallback() == false) goto L7;
        return true;
    }

    public static boolean e() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().logPageSelect() == false) goto L7;
        return true;
    }

    public static boolean f() {
        boolean r0 = l();
        boolean r1 = vm2.h.W().isInitFastModeEnable();
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean h() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().publicScreenOpt() == false) goto L7;
        return true;
    }

    public static boolean i() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().smoothEnter() == false) goto L7;
        return true;
    }

    public static boolean j() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().useServerLinkTypeWhenPreload() == false) goto L7;
        return true;
    }

    public static boolean k() {
        return vm2.h.W().isEnablePassedThroughAudioStageData();
    }

    public static boolean l() {
        boolean r0 = vm2.h.W().isTotalEnable();
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        LiveMode r2 = null;
        if (r1 == null) goto L5;
        Boolean r3 = r1.isAnchor();
    L6:
        boolean r4 = Intrinsics.areEqual(r3, Boolean.TRUE);
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L13;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L13;
        r2 = r7.getStreamType();
    L13:
        if (r0 == false) goto L18;
        if (r4 == true) goto L18;
        if (r2 == LiveMode.THIRD_PARTY) goto L18;
        return true;
    L18:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    @Deprecated(message = "支持直播间多实例后，应使用printKeyLog(dataCenter: DataCenter?, step: String, content: String)", replaceWith = @ReplaceWith(expression = "printKeyLog(null, step, content)", imports = {"com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils.printKeyLog"}))
    public static void o(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "step");
        Intrinsics.checkNotNullParameter(r2, "content");
        n(null, r1, r2);
    }

    public static void m(DataCenter r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "step");
        Intrinsics.checkNotNullParameter(r5, "content");
        StringBuilder r0 = new StringBuilder("dataCenter(hash:");
        String r1 = null;
        if (r3 == null) goto L5;
        Integer r2 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r2);
        r0.append(",rid:");
        if (r3 == null) goto L11;
        IRoom r6 = com.bytedance.android.live.core.utils.a0.o(r3);
        if (r6 == null) goto L11;
        r1 = r6.getIdStr();
    L11:
        r0.append(r1);
        r0.append(") ");
        String r7 = r0.toString();
        if (vm2.h.S().d() == true) goto L16;
        ALogger.e("ttlive_link", "MultiLinkLoadWidget, " + r7 + ", printKeyLog: step = " + r4 + ", content = " + r5);
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void n(DataCenter r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "step");
        Intrinsics.checkNotNullParameter(r7, "content");
        Integer r0 = null;
        if (r5 == null) goto L5;
        IRoom r1 = com.bytedance.android.live.core.utils.a0.o(r5);
    L6:
        if (r5 == null) goto L8;
        Boolean r2 = (Boolean) r5.get("data_is_feed");
    L10:
        if ((r2 instanceof Boolean) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        boolean r3 = r2.booleanValue();
    L15:
        StringBuilder r4 = new StringBuilder("(");
        if (r1 == null) goto L20;
        IBaseUser r8 = r1.getOwner();
        if (r8 == null) goto L20;
        String r9 = r8.getNickName();
    L21:
        r4.append(r9);
        r4.append(", ");
        if (r5 == null) goto L26;
        IRoom r10 = com.bytedance.android.live.core.utils.a0.o(r5);
        if (r10 == null) goto L26;
        String r11 = r10.getIdStr();
    L27:
        r4.append(r11);
        r4.append(", ");
        if (r3 == false) goto L30;
        String r12 = PbRequest.SwitchType.FEED;
    L31:
        r4.append(r12);
        r4.append("), dataCenter(hash:");
        if (r5 == null) goto L34;
        r0 = Integer.valueOf(r5.hashCode());
    L34:
        r4.append(r0);
        r4.append(')');
        String r13 = r4.toString();
        if (vm2.h.S().d() == true) goto L39;
        ALogger.i("ttlive_link", "MultiLinkLoadWidget, " + r13 + " printKeyLog: step = " + r6 + ", content = " + r7);
        return;
    L39:
        return;
    L30:
        r12 = PbRequest.SwitchType.ROOM;
    L26:
        r11 = null;
    L20:
        r9 = null;
        goto L21
    L14:
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static void p(DataCenter r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "step");
        Intrinsics.checkNotNullParameter(r4, "content");
        if (((Boolean) a.getValue()).booleanValue() == false) goto L5;
        n(r2, r3, r4);
        return;
    L5:
        Boolean r5 = null;
        if (r2 == null) goto L8;
        IRoom r6 = com.bytedance.android.live.core.utils.a0.o(r2);
    L9:
        if (r2 == null) goto L11;
        Boolean r0 = (Boolean) r2.get("data_is_feed");
    L13:
        if ((r0 instanceof Boolean) == false) goto L16;
        r5 = r0;
    L16:
        if (r5 == null) goto L19;
        r5.booleanValue();
    L19:
        if (r6 == null) goto L23;
        IBaseUser r7 = r6.getOwner();
        if (r7 == null) goto L23;
        r7.getNickName();
    L23:
        if (r2 == null) goto L27;
        IRoom r8 = com.bytedance.android.live.core.utils.a0.o(r2);
        if (r8 == null) goto L27;
        r8.getIdStr();
    L27:
        if (r2 == null) goto L30;
        r2.hashCode();
    L30:
        return;
    L11:
        r0 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }
}
