package com.bytedance.android.live.liveinteract.api.utils;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.livelink.kmp.api.base.config.Vendor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveSeiCreator {
    public final a a;
    public long b;
    public List<ti6.f> c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegionComparePolicy {
    }

    public interface a {
        boolean a(ti6.f r1, ti6.f r2);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator.a
        public final boolean a(ti6.f r7, ti6.f r8) {
            if (r7 == null) goto L24;
            if (r8 != null) goto L7;
            return false;
        L7:
            if (TextUtils.equals(r7.b, r8.b) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(r7.c, r8.c) == true) goto L11;
            return false;
        L11:
            if (r7.d == r8.d) goto L13;
            return false;
        L13:
            if (r7.e == r8.e) goto L15;
            return false;
        L15:
            if (r7.f == r8.f) goto L17;
            return false;
        L17:
            if (r7.g == r8.g) goto L19;
            return false;
        L19:
            if (r7.i == r8.i) goto L21;
            return false;
        L21:
            if (r7.m != r8.m) goto L32;
            return true;
        L32:
            return false;
        L24:
            return false;
        }
    }

    public LiveSeiCreator() {
        this.b = 0;
        this.c = new ArrayList();
        this.a = new b();
    }

    public static int e() {
        u r0 = m.d();
        if (r0 != null) goto L5;
    L7:
        int r1 = 0;
    L8:
        if (r1 != 0) goto L11;
        return 8;
    L11:
        return r1;
    L5:
        if (r0.getVideoTalkRoomSubScene().getValue() == null) goto L7;
        r1 = ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getVideoTalkRoomSubScene().getValue()).t().a;
        goto L8
    }

    public static int d(int r3) {
        u r0 = m.d();
        if (r0 != null) goto L5;
    L7:
        int r1 = 0;
    L8:
        if (r3 == 0) goto L10;
    L12:
        if (r1 != 0) goto L15;
        return 5;
    L15:
        return r1;
    L10:
        if (r1 == 9) goto L12;
        return 0;
    L5:
        if (r0.s().getValue() == null) goto L7;
        r1 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t().a;
        goto L8
    }

    public static String f(List<ti6.f> r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder("RegionList{");
        Iterator<ti6.f> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.append(r3.next().b);
        r0.append(",");
        goto L7
    L9:
        r0.append("}");
        return r0.toString();
    }

    public static JSONObject a(List<ti6.f> r6, fi6.a r7, long r8) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L31
        r0.put("ver", r7.d);     // Catch: JSONException -> L31
        r0.put("vendor", "byte");     // Catch: JSONException -> L31
        r0.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L31
        r0.put("channel_id", String.valueOf(r8));     // Catch: JSONException -> L31
        JSONArray r9 = new JSONArray();     // Catch: JSONException -> L31
        Iterator<ti6.f> r10 = r6.iterator();     // Catch: JSONException -> L31
    L4:
        if (r10.hasNext() == false) goto L17;
        ti6.f r11 = r10.next();     // Catch: JSONException -> L31
        if (r11.l == false) goto L4;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L31
        r1.put("type", r11.a);     // Catch: JSONException -> L31
        int r3 = 1;
        r1.put("alpha", 1);     // Catch: JSONException -> L31
        r1.put("w", r11.f);     // Catch: JSONException -> L31
        r1.put("h", r11.g);     // Catch: JSONException -> L31
        r1.put("x", r11.d);     // Catch: JSONException -> L31
        r1.put("y", r11.e);     // Catch: JSONException -> L31
        r1.put("account", 0);     // Catch: JSONException -> L31
        r1.put("uid", 0);     // Catch: JSONException -> L31
        r1.put("uid_str", r11.b);     // Catch: JSONException -> L31
        r1.put("zorder", r11.o);     // Catch: JSONException -> L31
        r1.put("render_mode", r11.s);     // Catch: JSONException -> L31
        r1.put("stat", r11.i);     // Catch: JSONException -> L31
        if (r11.j == false) goto L11;
        int r5 = 1;
    L12:
        r1.put("talk", r5);     // Catch: JSONException -> L31
        if (r11.m == true) goto L16;
        r3 = 0;
    L16:
        r1.put("mute_audio", r3);     // Catch: JSONException -> L31
        r9.put(r1);     // Catch: JSONException -> L31
        goto L4
    L11:
        r5 = 0;
        goto L12
    L17:
        r0.put("grids", r9);     // Catch: JSONException -> L31
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L31
        Room r13 = m.i().getCurrentRoom();     // Catch: JSONException -> L31
        if (r13 != null) goto L21;
    L23:
        qi6.g r14 = r7.F;     // Catch: JSONException -> L31
        if (r14 == null) goto L26;
        r12.put("width", r14.c);     // Catch: JSONException -> L31
        r12.put("height", r7.F.d);     // Catch: JSONException -> L31
    L26:
        ti6.h r15 = r7.T;     // Catch: JSONException -> L31
        if (r15 == null) goto L29;
        r12.put("background", r15.b());     // Catch: JSONException -> L31
    L29:
        r0.put("canvas", r12);     // Catch: JSONException -> L31
        HashMap r16 = new HashMap();     // Catch: JSONException -> L31
        r16.put("sei", r0.toString());     // Catch: JSONException -> L31
        g.p(r16);     // Catch: JSONException -> L31
        return r0;
    L21:
        if (r13.getStreamUrlExtra() == null) goto L23;
        r12.put("width", r13.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L31
        r12.put("height", r13.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L31
    L31:
        return null;
    }

    public static JSONObject c(List<ti6.f> r18, fi6.a r19, Map<String, Integer> r20, long r21, int r23, int r24, int r25, int r26, String r27, List<Integer> r28) {
        Object r6 = null;
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L96
        r7.put("ver", r23);     // Catch: JSONException -> L96
        r7.put("ui_layout", r24);     // Catch: JSONException -> L96
        if (r25 == 0) goto L6;
        r7.put("style", r25);     // Catch: JSONException -> L96
    L6:
        r7.put("position_stash_status", r26);     // Catch: JSONException -> L96
        r7.put("vendor", Vendor.BYTE.getValue());     // Catch: JSONException -> L96
        r7.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L96
        r7.put("channel_id", String.valueOf(r21));     // Catch: JSONException -> L96
        r7.put("sub_scene", e());     // Catch: JSONException -> L96
        r7.put("interactive_scene", e());     // Catch: JSONException -> L96
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L11
        IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L11
        if (r9 == null) goto L12;
        r8.put("func_type", r9.getFunctionType2());     // Catch: JSONException -> L11
    L12:
        r7.put("event_params", r8);     // Catch: JSONException -> L96
        Room r3 = m.i().getCurrentRoom();     // Catch: JSONException -> L96
        if (r3 == null) goto L15;
        String r10 = r3.getOwnerUserIdString();     // Catch: JSONException -> L96
    L16:
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L96
        Iterator<ti6.f> r12 = r18.iterator();     // Catch: JSONException -> L96
    L18:
        if (r12.hasNext() == false) goto L58;
        ti6.f r13 = r12.next();     // Catch: JSONException -> L96
        if (r13.l == false) goto L18;
        ReadOnlyProperty r15 = vm2.e.L;     // Catch: JSONException -> L96
        KProperty[] r16 = vm2.e.a;     // Catch: JSONException -> L96
        if (((Boolean) r15.getValue(r6, r16[36])).booleanValue() == true) goto L27;
        if (r20.containsKey(r13.b) == false) goto L18;
    L27:
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L96
        if (((Boolean) vm2.e.K.getValue(r6, r16[35])).booleanValue() == true) goto L30;
        r14.put("account", r13.c);     // Catch: JSONException -> L96
    L30:
        r14.put("uid_str", r13.b);     // Catch: JSONException -> L96
        if (r13.j == false) goto L33;
        int r17 = 1;
    L34:
        r14.put("talk", r17);     // Catch: JSONException -> L96
        r14.put("type", r13.a);     // Catch: JSONException -> L96
        if (r20.containsKey(r13.b) == false) goto L38;
        r14.put("p", r20.get(r13.b));     // Catch: JSONException -> L96
    L38:
        if (r13.m == false) goto L40;
        int r110 = 1;
    L41:
        r14.put("mute_audio", r110);     // Catch: JSONException -> L96
        if (r24 != 15) goto L57;
        if (r26 == 2) goto L47;
        r14.put("visible", 1);     // Catch: JSONException -> L96
        goto L57
    L47:
        if (TextUtils.isEmpty(r13.c) == true) goto L54;
        if (r13.c.equals(r27) == false) goto L51;
    L52:
        r14.put("visible", 1);     // Catch: JSONException -> L96
        goto L57
    L51:
        if (r13.c.equals(r10) == true) goto L52;
    L54:
        r14.put("visible", 0);     // Catch: JSONException -> L96
    L57:
        r11.put(r14);     // Catch: JSONException -> L96
        r6 = null;
        goto L18
    L40:
        r110 = 0;
        goto L41
    L33:
        r17 = 0;
        goto L34
    L58:
        r7.put("grids", r11);     // Catch: JSONException -> L96
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L96
        if (((Boolean) vm2.e.I.getValue(null, vm2.e.a[33])).booleanValue() == false) goto L73;
        if (r3 == null) goto L73;
        if (r3.getStreamUrlExtraSafely() == null) goto L73;
        int r2 = (int) r3.getStreamUrlExtraSafely().getHeightFlex();     // Catch: JSONException -> L96
        r1.put("height", r3.getStreamUrlExtraSafely().getHeightFlex());     // Catch: JSONException -> L96
        if (r3.getSceneTypeInfo() != null) goto L67;
    L69:
        boolean r111 = false;
    L70:
        if (r111 == false) goto L72;
        r1.put("width", d5.b((String) vm2.e.k().get(String.valueOf(r2))));     // Catch: JSONException -> L96
    L85:
        ti6.h r0 = r19.T;     // Catch: JSONException -> L96
        if (r0 == null) goto L88;
        r1.put("background", r0.b());     // Catch: JSONException -> L96
    L88:
        r7.put("canvas", r1);     // Catch: JSONException -> L96
        if (r28 == null) goto L91;
        r7.put("ui_feature_list", new JSONArray(r28));     // Catch: JSONException -> L96
    L91:
        boolean r4 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;     // Catch: JSONException -> L96
        if (com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a == false) goto L94;
        r7.put("hide_micseat", 1);     // Catch: JSONException -> L96
    L94:
        HashMap r5 = new HashMap();     // Catch: JSONException -> L96
        r5.put("sei", r7.toString());     // Catch: JSONException -> L96
        g.o("rtc_mix_sei", r5, tc0.c.h());     // Catch: JSONException -> L96
        return r7;
    L72:
        r1.put("width", r3.getStreamUrlExtraSafely().getWidthFlex());     // Catch: JSONException -> L96
        goto L85
    L67:
        if (r3.getSceneTypeInfo().isLandscapeVerticalRoom() == 1) goto L69;
        r111 = true;
    L73:
        if (r3 == null) goto L78;
        if (r3.getStreamUrlExtra() == null) goto L78;
        r1.put("width", r3.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L96
        r1.put("height", r3.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L96
    L78:
        if (((Boolean) vm2.i.K.getValue(null, vm2.i.a[35])).booleanValue() == false) goto L82;
        ti6.h r22 = r19.T;     // Catch: JSONException -> L96
        if (r22 == null) goto L85;
        r1.put("width", r22.a);     // Catch: JSONException -> L96
        r1.put("height", r19.T.b);     // Catch: JSONException -> L96
        goto L85
    L82:
        qi6.g r29 = r19.F;     // Catch: JSONException -> L96
        if (r29 == null) goto L85;
        r1.put("width", r29.c);     // Catch: JSONException -> L96
        r1.put("height", r19.F.d);     // Catch: JSONException -> L96
        goto L85
    L15:
        r10 = null;
    L11:
        r8 = null;
    L96:
        return null;
    }

    public static JSONObject b(List<ti6.f> r16, Map<String, Integer> r17, fi6.a r18, Map<String, Integer> r19, long r20, int r22, boolean r23, int r24, int r25, List<Integer> r26, int r27) {
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L104
        u r9 = m.d();     // Catch: JSONException -> L104
        if (r9 != null) goto L6;
    L8:
        int r10 = 0;
        int r11 = 0;
    L10:
        if (r11 == 16) goto L12;
        int r12 = r18.d;     // Catch: JSONException -> L104
    L28:
        r7.put("ver", r12);     // Catch: JSONException -> L104
        r7.put("ui_layout", r22);     // Catch: JSONException -> L104
        r7.put("vendor", Vendor.BYTE.getValue());     // Catch: JSONException -> L104
        r7.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L104
        r7.put("channel_id", String.valueOf(r20));     // Catch: JSONException -> L104
        if (r27 == (-1)) goto L32;
        r7.put("sub_scene", r27);     // Catch: JSONException -> L104
        r7.put("interactive_scene", r27);     // Catch: JSONException -> L104
    L105:
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L38
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L38
        if (r13 == null) goto L39;
        r8.put("func_type", r13.getFunctionType2());     // Catch: JSONException -> L38
    L39:
        r7.put("event_params", r8);     // Catch: JSONException -> L104
        r7.put("sub_ui_layout", r25);     // Catch: JSONException -> L104
        JSONArray r5 = new JSONArray();     // Catch: JSONException -> L104
        Iterator<ti6.f> r14 = r16.iterator();     // Catch: JSONException -> L104
    L41:
        if (r14.hasNext() == false) goto L74;
        ti6.f r15 = r14.next();     // Catch: JSONException -> L104
        if (r15.l == false) goto L41;
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L104
        ReadOnlyProperty r111 = vm2.e.K;     // Catch: JSONException -> L104
        KProperty[] r112 = vm2.e.a;     // Catch: JSONException -> L104
        if (((Boolean) r111.getValue(null, r112[35])).booleanValue() == true) goto L49;
        r110.put("account", r15.c);     // Catch: JSONException -> L104
    L49:
        if (((Boolean) vm2.e.N.getValue(null, r112[38])).booleanValue() == true) goto L51;
        r110.put("uid", 0);     // Catch: JSONException -> L104
    L51:
        r110.put("uid_str", r15.b);     // Catch: JSONException -> L104
        if (r17 == null) goto L66;
        if (r17.containsKey(r15.b) == false) goto L66;
        if (((Boolean) vm2.e.X.getValue(null, r112[48])).booleanValue() == false) goto L66;
        if (r15.j == false) goto L64;
        int r113 = r17.get(r15.b).intValue();     // Catch: JSONException -> L104
        if (r113 != 0) goto L63;
        r113 = 2;
    L63:
        r110.put("talk", r113);     // Catch: JSONException -> L104
    L71:
        if (r19.containsKey(r15.b) == false) goto L73;
        r110.put("p", r19.get(r15.b));     // Catch: JSONException -> L104
    L73:
        r110.put("type", r15.a);     // Catch: JSONException -> L104
        r5.put(r110);     // Catch: JSONException -> L104
        goto L41
    L64:
        r110.put("talk", 0);     // Catch: JSONException -> L104
    L66:
        if (r15.j == false) goto L68;
        int r114 = 1;
    L69:
        r110.put("talk", r114);     // Catch: JSONException -> L104
        goto L71
    L68:
        r114 = 0;
        goto L69
    L74:
        r7.put("grids", r5);     // Catch: JSONException -> L104
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L104
        Room r2 = m.i().getCurrentRoom();     // Catch: JSONException -> L104
        if (r2 != null) goto L78;
    L80:
        qi6.g r3 = r18.F;     // Catch: JSONException -> L104
        if (r3 == null) goto L83;
        r0.put("width", r3.c);     // Catch: JSONException -> L104
        r0.put("height", r18.F.d);     // Catch: JSONException -> L104
    L83:
        ti6.h r4 = r18.T;     // Catch: JSONException -> L104
        if (r4 == null) goto L87;
        r0.put("background", r4.b());     // Catch: JSONException -> L104
    L87:
        if (jc1.k.f(IInteractService.class) != null) goto L89;
    L93:
        if (r23 == false) goto L99;
        r7.put("show_player", r23);     // Catch: JSONException -> L104
        if (vm2.h.h0().h() == false) goto L99;
        ti6.h r6 = r18.T;     // Catch: JSONException -> L104
        if (r6 == null) goto L99;
        r0.put("width", r6.a);     // Catch: JSONException -> L104
        r0.put("height", r18.T.b);     // Catch: JSONException -> L104
    L99:
        r7.put("hide_audio_bg", r24);     // Catch: JSONException -> L104
        if (r26 == null) goto L102;
        r7.put("ui_feature_list", new JSONArray(r26));     // Catch: JSONException -> L104
    L102:
        r7.put("canvas", r0);     // Catch: JSONException -> L104
        HashMap r1 = new HashMap();     // Catch: JSONException -> L104
        r1.put("sei", r7.toString());     // Catch: JSONException -> L104
        g.o("rtc_mix_sei", r1, tc0.c.h());     // Catch: JSONException -> L104
        return r7;
    L89:
        if (((IInteractService) jc1.k.f(IInteractService.class)).getTalkRoomLogUtils() == null) goto L93;
        ((TalkRoomLogUtils) ((IInteractService) jc1.k.f(IInteractService.class)).getTalkRoomLogUtils()).getClass();     // Catch: JSONException -> L104
        if (u0.d() == null) goto L93;
        ((TalkRoomLogUtils) ((IInteractService) jc1.k.f(IInteractService.class)).getTalkRoomLogUtils()).getClass();     // Catch: JSONException -> L104
        r7.put("play_mode_list", new JSONArray(u0.d()).toString());     // Catch: JSONException -> L104
        goto L93
    L78:
        if (r2.getStreamUrlExtra() == null) goto L80;
        r0.put("width", r2.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L104
        r0.put("height", r2.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L104
    L38:
        r8 = null;
        goto L39
    L32:
        r7.put("sub_scene", d(r22));     // Catch: JSONException -> L104
        r7.put("interactive_scene", d(r22));     // Catch: JSONException -> L104
        goto L105
    L12:
        if (r10 != 51) goto L15;
        r12 = 17;
        goto L28
    L15:
        if (r10 != 56) goto L18;
        r12 = 31;
        goto L28
    L18:
        if (r10 != 57) goto L21;
        r12 = 32;
        goto L28
    L21:
        if (r10 != 58) goto L24;
        r12 = 33;
        goto L28
    L24:
        if (r10 != 67) goto L26;
        r12 = 39;
        goto L28
    L26:
        r12 = 0;
        goto L28
    L6:
        if (r9.s().getValue() == null) goto L8;
        r11 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r9.s().getValue()).t().a;     // Catch: JSONException -> L104
        r10 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r9.s().getValue()).t().b;     // Catch: JSONException -> L104
    L104:
        return null;
    }
}
