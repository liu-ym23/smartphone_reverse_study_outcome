package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v6;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.config.ff1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f2 {
    public static final List<Long> f = null;
    public kc0.t a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;

    public static final class a {
    }

    public f2() {
    }

    static {
        f = CollectionsKt.listOf(new Long[]{Long.valueOf(6), Long.valueOf(2)});
    }

    public static long a(String r5, int r6) {
        int r0 = r5.length();
        long r1 = 0;
        if (r6 >= 0) goto L5;
        return 0;
    L5:
        if (r6 >= r0) goto L9;
        if (Character.isDigit(r5.charAt(r6)) == true) goto L9;
        r6 = r6 + 1;
    L9:
        if (r6 >= r0) goto L13;
        if (Character.isDigit(r5.charAt(r6)) == false) goto L13;
        r1 = (r1 * ((long) 10)) + ((long) (r5.charAt(r6) - '0'));
        r6 = r6 + 1;
    L13:
        return r1;
    }

    public final void b(Context r24, DataCenter r25, String r26, RoomSession r27) {
        String r3 = "";
        if (ff1.a.getValue().booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) v6.a.getValue()).booleanValue() == false) goto L16;
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L12;
        LivePlayerClientContext r1 = r0.context();
        if (r1 == null) goto L12;
        String r2 = r1.getLastLayoutSei();
    L14:
        if (com.bytedance.android.livesdk.utils.r2.a(r2) == false) goto L16;
        String r15 = r2;
    L18:
        if (r15 != null) goto L20;
    L23:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L27;
        return;
    L27:
        if (Intrinsics.areEqual(r15, this.d) == false) goto L29;
        return;
    L29:
        int r13 = StringsKt.indexOf$default(r15, "app_data", 0, false, 6, null);
        if (r13 >= 0) goto L32;
        return;
    L32:
        int r5 = StringsKt.indexOf$default(r15, "ver", r13, false, 4, null);
        if (r5 >= 0) goto L35;
        return;
    L35:
        long r21 = a(r15, r5);
        if (f.contains(Long.valueOf(r21)) == true) goto L118;
        return;
    L118:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L40
        String r7 = new JSONObject(r15).optString("app_data", "");     // Catch: Throwable -> L40
    L46:
        if (Intrinsics.areEqual(r7, this.e) == false) goto L48;
        return;
    L48:
        int r8 = StringsKt.indexOf$default(r15, "channel_id", r13, false, 4, null);
        if (r8 >= 0) goto L51;
        return;
    L51:
        long r14 = a(r15, r8);
        if (r14 != 0) goto L54;
        return;
    L54:
        this.d = r15;
        this.e = r7;
        if (r27 == null) goto L57;
        long r10 = r27.getRoomId();
    L58:
        if (r27 == null) goto L63;
        Room r9 = r27.getPreLoadRoom();
        if (r9 == null) goto L63;
        String r11 = r9.getOwnerUserIdString();
        if (r11 == null) goto L63;
    L64:
        if (r27 == null) goto L71;
        Room r12 = r27.getPreLoadRoom();
        if (r12 == null) goto L71;
        User r16 = r12.getOwner();
        if (r16 == null) goto L71;
        String r17 = r16.getCastSecUid();
        if (r17 == null) goto L71;
    L72:
        IUserService r18 = jc1.k.f(IUserService.class);
        if (r18 == null) goto L78;
        com.bytedance.android.livesdk.user.f r19 = r18.user();
        if (r19 == null) goto L78;
        String r20 = r19.n();
        if (r20 == null) goto L78;
    L79:
        IUserService r110 = jc1.k.f(IUserService.class);
        if (r110 == null) goto L88;
        com.bytedance.android.livesdk.user.f r22 = r110.user();
        if (r22 == null) goto L88;
        String r23 = r22.a(r20);
        if (r23 == null) goto L88;
        r3 = r23;
    L88:
        if ((!Intrinsics.areEqual(r11, r20)) == false) goto L90;
        String r28 = "0";
    L91:
        ALogger.e("MultiLinkPreloadWidget", "update info channelID: " + r14 + " roomID: " + r10 + " ownerID: " + r11 + " sei: " + r15);
        if (this.a != null) goto L101;
        ILinkServiceExternal r29 = jc1.k.f(ILinkServiceExternal.class);
        if (r29 == null) goto L98;
        lc0.b r30 = r29.getMultiAnchorServiceExternal();
        if (r30 == null) goto L98;
        kc0.t r31 = r30.e();
    L99:
        this.a = r31;
    L98:
        r31 = null;
    L101:
        if (this.c == false) goto L103;
    L108:
        kc0.t r32 = this.a;
        if (r32 == null) goto L115;
        if (r27 == null) goto L112;
        long r111 = r27.getRoomId();
    L113:
        r32.b(r24, r14, r111, r11, r21, r15, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("anchor_id", r11), TuplesKt.to("sec_anchor_id", r17), TuplesKt.to("user_id", r20), TuplesKt.to("sec_user_id", r3), TuplesKt.to("is_anchor", r28)}));
        goto L115
    L112:
        r111 = 0;
    L115:
        if (r25 == null) goto L120;
        r25.put("DATA_MULTI_REVENUE_PRELOAD_INFO", new h2(r10, r14, r21));
        return;
    L120:
        return;
    L103:
        if (this.b == false) goto L108;
        kc0.t r33 = this.a;
        if (r33 == null) goto L108;
        this.c = true;
        r33.c(r10);
        goto L108
    L90:
        r28 = "1";
    L78:
        r20 = "";
    L71:
        r17 = "";
    L63:
        r11 = "";
        goto L64
    L57:
        r10 = 0;
    L40:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Object r35 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r35) == false) goto L44;
        r35 = null;
    L44:
        r7 = (String) r35;
        goto L46
    L20:
        if (r15.length() == 0) goto L23;
        r4 = false;
    L12:
        r2 = null;
    L16:
        r15 = r26;
        goto L18
    }
}
