package com.bytedance.android.ec.adapter.impl.utils;

import android.os.Bundle;
import com.bytedance.android.ec.adapter.api.state.ECEcomData;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdkapi.TTInternalBusinessService;
import com.bytedance.android.livesdkapi.room.state.AppState;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RoomStateExtensionsKt {
    public static final com.bytedance.android.ec.adapter.api.state.a a(IRoomState r28) {
        if (r28 != null) goto L5;
        return null;
    L5:
        Map r1 = r28.getEnterRoomParams();
        Map r10 = r28.getReportParams();
        if (r28.getEnterRoomParams().containsKey("tmp_log_extra_for_inner") == false) goto L22;
        r1 = MapsKt.toMutableMap(r1);
        String r11 = (String) r1.get("tmp_log_extra_for_inner");
        if (r11 == null) goto L21;
        JSONObject r12 = z1.g(r11);
        if (r12 == null) goto L21;
        r10 = MapsKt.toMutableMap(r28.getReportParams());
        if (r10.containsKey(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA) == true) goto L17;
        String r13 = a2.d(r12.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA));
        if (r13 == null) goto L17;
        r10.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r13);
    L17:
        if (r10.containsKey(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID) == true) goto L21;
        String r14 = a2.d(r12.optString(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID));
        if (r14 == null) goto L21;
        r10.put(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r14);
    L21:
        r1.remove("tmp_log_extra_for_inner");
    L22:
        Map r17 = r10;
        int r15 = r28.getItemType();
        boolean r16 = r28.isAnchor();
        boolean r18 = r28.isPortrait();
        String r19 = r28.getRoomId();
        String r110 = r28.getRoomAnchorId();
        boolean r111 = r28.isFollowed();
        boolean r112 = r28.isReplayOpen();
        Function0 r113 = r28.isLoginFunc();
        int r114 = r28.getStreamType();
        Bundle r115 = r28.getExtra();
        int r116 = r28.getLiveSdkVersion();
        return new com.bytedance.android.ec.adapter.api.state.a(r15, r16, r18, "", r19, r110, "", r111, r112, r113, r114, r17, r115, r116, r1, r28.isKtvFun(), r28.isInInteractionGameFun(), RoomStateExtensionsKt$trans$2.INSTANCE, null, r28.getEnterFromSpecialAd(), RoomStateExtensionsKt$trans$3.INSTANCE, new ECEcomData(null));
    }

    public static final com.bytedance.android.ec.adapter.api.state.c b(final UserState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$trans");
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L5;
        AppState r1 = r0.getAppState();
    L6:
        r10.getUserName();
        r10.getAvatarUrl();
        String r11 = r10.getOpenId();
        if (r11 != null) goto L9;
        String r12 = "";
    L10:
        String r13 = r10.getSecUid();
        if (r13 != null) goto L13;
        String r14 = "";
    L14:
        if (r1 == null) goto L19;
        String r15 = r1.getClientKey();
        if (r15 == null) goto L19;
        String r16 = r15;
    L20:
        if (r1 == null) goto L23;
        String r17 = r1.getAppName();
        if (r17 == null) goto L23;
    L24:
        Function0<Boolean> r18 = new RoomStateExtensionsKt$trans$5(r10);
        Map r19 = r10.getReportParams();
        if (r19 != null) goto L27;
        r19 = MapsKt.emptyMap();
    L27:
        Map r20 = r19;
        Bundle r110 = r10.getExtra();
        if (r110 != null) goto L30;
        r110 = new Bundle();
    L30:
        String r21 = r12;
        String r22 = r14;
        String r23 = r16;
        String r24 = r17;
        return new com.bytedance.android.ec.adapter.api.state.c(r21, r22, r23, r24, r18, r20, r110);
    L23:
        r17 = "";
    L19:
        r16 = "";
        goto L20
    L13:
        r14 = r13;
        goto L14
    L9:
        r12 = r11;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
