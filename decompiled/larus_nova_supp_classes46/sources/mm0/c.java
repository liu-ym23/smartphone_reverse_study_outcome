package mm0;

import am2.n;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdk.message.model.y1;
import com.bytedance.android.livesdk.message.model.z1;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static JSONObject b() {
        String r0 = n.f().d();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L20;
        return new JSONObject(r0);
    L14:
        e = move-exception;
        SafetyGuard.a(null, e, "parse LiveAd extra fail by welfareAppLog");
        return null;
    L20:
        return null;
    L7:
        r2 = false;
        goto L8
    }

    static {
    }

    @JvmStatic
    public static final Uri c(m1 r4) {
        Intrinsics.checkNotNullParameter(r4, "bottomRightCardArea");
        u1 r5 = r4.cardDisplayInfo;
        if (r5 == null) goto L26;
        String r1 = r5.url;
        if (r1 == null) goto L27;
        int r2 = r5.containerType;
        if (r2 != 1) goto L9;
        Uri.Builder r3 = x6.a.d(r1).buildUpon();
        if (r3 == null) goto L29;
        String r6 = r5.fallbackUrl;
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        Uri.Builder r7 = r3.appendQueryParameter("fallback_url", x6.a.b(r6).toString());
        if (r7 == null) goto L30;
        Uri.Builder r8 = r7.appendQueryParameter("screen_size_adaptation", "1");
        if (r8 == null) goto L31;
        Uri r9 = r8.build();
    L28:
        return r9;
    L31:
        return null;
    L30:
        return null;
    L29:
        return null;
    L9:
        if (r2 != 2) goto L11;
        r9 = x6.a.b(r1);
        goto L28
    L11:
        if (r2 != 3) goto L32;
        r9 = UriProtector.parse(r1);
        goto L28
    L32:
        return null;
    L27:
        return null;
    L26:
        return null;
    }

    public static List d(JSONArray r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toList");
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L8;
        r3 = d((JSONArray) r3);
    L10:
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONObject) == false) goto L10;
        r3 = e((JSONObject) r3);
        goto L10
    L11:
        return r0;
    }

    public static Map e(JSONObject r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = d((JSONArray) r3);
    L11:
        r0.put(r2, r3);
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = e((JSONObject) r3);
        goto L11
    L12:
        return r0;
    }

    public static void a(DataCenter r6, m1 r7, JSONObject r8) {
        Long r0 = null;
        if (r6 == null) goto L5;
        IRoom r9 = (IRoom) r6.get("data_room");
    L6:
        boolean r1 = k.n(IMiddlewareMicRoomService.class).isLoyalAudience();
        r8.put("room_type", "carousel");
        r8.put("user_type", b.c(Boolean.valueOf(r1), "loyal_audience", "carousel_audience"));
        if (r9 == null) goto L13;
        IOfficialChannelInfo r2 = r9.getOfficialChannelInfo();
        if (r2 == null) goto L13;
        IBaseUser r3 = r2.getChannelUser();
        if (r3 == null) goto L13;
        String r4 = r3.getIdString();
    L14:
        r8.put("channel_uid", r4);
        if (r9 == null) goto L19;
        IOfficialChannelInfo r5 = r9.getOfficialChannelInfo();
        if (r5 == null) goto L19;
        Long r10 = Long.valueOf(r5.getBackupRoomId());
    L20:
        r8.put("carousel_room_id", r10);
        r8.put("enter_way", b.c(Boolean.valueOf(r1), "anchor", "official_id"));
        if (r9 == null) goto L25;
        OfficialChannelExtraInfo r11 = r9.getOfficialChannelExtraInfo();
        if (r11 == null) goto L25;
        Long r12 = Long.valueOf(r11.getShowListId());
    L26:
        r8.put("showlist_id", r12);
        if (r9 == null) goto L31;
        OfficialChannelExtraInfo r13 = r9.getOfficialChannelExtraInfo();
        if (r13 == null) goto L31;
        String r14 = r13.getShowListName();
    L32:
        r8.put("showlist_name", r14);
        Boolean r15 = Boolean.valueOf(r1);
        if (r9 == null) goto L37;
        IBaseUser r16 = r9.getOwner();
        if (r16 == null) goto L37;
        Long r17 = Long.valueOf(r16.getLiveRoomId());
    L38:
        if (r9 == null) goto L42;
        IOfficialChannelInfo r18 = r9.getOfficialChannelInfo();
        if (r18 == null) goto L42;
        Long r19 = Long.valueOf(r18.getBackupRoomId());
    L43:
        r8.put("room_id_from_mic", b.c(r15, r17, r19));
        Boolean r20 = Boolean.valueOf(r1);
        if (r9 == null) goto L46;
        String r21 = r9.getOwnerUserIdString();
    L47:
        if (r9 == null) goto L53;
        IOfficialChannelInfo r22 = r9.getOfficialChannelInfo();
        if (r22 == null) goto L53;
        IBaseUser r23 = r22.getChannelUser();
        if (r23 == null) goto L53;
        String r24 = r23.getIdString();
    L54:
        r8.put("anchor_id_from_mic", b.c(r20, r21, r24));
        if (r9 == null) goto L59;
        IBaseUser r25 = r9.getOwner();
        if (r25 == null) goto L59;
        Long r26 = Long.valueOf(r25.getLiveRoomId());
    L60:
        r8.put("anchor_room_id", String.valueOf(r26));
        if (r9 == null) goto L63;
        String r27 = r9.getOwnerUserIdString();
    L64:
        r8.put("carousel_anchor_id", String.valueOf(r27));
        if (r9 == null) goto L69;
        IBaseUser r28 = r9.getOwner();
        if (r28 == null) goto L69;
        Boolean r29 = Boolean.valueOf(r28.isFollowing());
    L70:
        r8.put("follow_status", r29);
        if (r7 == null) goto L91;
        u1 r30 = r7.cardDisplayInfo;
        if (r30 == null) goto L91;
        z1 r31 = r30.triggerConfig;
        if (r31 == null) goto L91;
        List r32 = r31.commonTriggerList;
        if (r32 == null) goto L91;
        Iterator r33 = r32.iterator();
    L80:
        if (r33.hasNext() == false) goto L87;
        Object r34 = r33.next();
        if (((y1) r34).type != TriggerId.ENTER_ROOM_TIME_LIMIT.getValue()) goto L84;
        boolean r35 = true;
    L85:
        if (r35 == false) goto L80;
    L88:
        y1 r36 = (y1) r34;
        if (r36 == null) goto L91;
        r0 = r36.value;
        goto L91
    L84:
        r35 = false;
        goto L85
    L87:
        r34 = null;
    L91:
        r8.put("to_show_second", String.valueOf(r0));
        return;
    L69:
        r29 = null;
        goto L70
    L63:
        r27 = null;
    L59:
        r26 = null;
    L53:
        r24 = null;
        goto L54
    L46:
        r21 = null;
    L42:
        r19 = null;
    L37:
        r17 = null;
    L31:
        r14 = null;
    L25:
        r12 = null;
    L19:
        r10 = null;
    L13:
        r4 = null;
        goto L14
    L5:
        r9 = null;
        goto L6
    }
}
