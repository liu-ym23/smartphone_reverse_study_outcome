package de8;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.ChatUserContextParam;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements t1a.c {
    public static final c s = null;
    public final Bundle a;
    public final Bundle b;
    public final boolean c;
    public final RecommendFrom d;
    public final SearchMobParam e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final Integer j;
    public final boolean k;
    public final boolean l;
    public final BotRecommendMobInfo m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final Lazy r;

    public static final class a {
        public static c a(Bundle r4) {
            return c.c(c.s, r4, 0, 32766);
        }
    }

    public c() {
        this(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Bundle r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Bundle r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        RecommendFrom r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        SearchMobParam r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.f == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        String r18 = this.g;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.i;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.j;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        if (this.k == false) goto L45;
        int r30 = 1231;
    L46:
        int r31 = (r29 + r30) * 31;
        if (this.l == false) goto L49;
        int r32 = 1231;
    L50:
        int r33 = (r31 + r32) * 31;
        BotRecommendMobInfo r34 = this.m;
        if (r34 == null) goto L54;
        r1 = r34.hashCode();
    L54:
        int r35 = (r33 + r1) * 31;
        long r36 = this.n;
        int r37 = (r35 + ((int) (r36 ^ (r36 >>> 32)))) * 31;
        if (this.o == true) goto L59;
        r7 = 1237;
    L59:
        return r37 + r7;
    L49:
        r32 = 1237;
        goto L50
    L45:
        r30 = 1237;
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatArgumentData(arguments=" + this.a + ", currentArgument=" + this.b + ", skipRefresh=" + this.c + ", recommendFrom=" + this.d + ", searchMobParam=" + this.e + ", bgImgOpen=" + this.f + ", bgImgUrlStr=" + this.g + ", bgImgColorStr=" + this.h + ", bgVideoModel=" + this.i + ", immerseOrientation=" + this.j + ", shouldShowImeOnce=" + this.k + ", isUnreadDotEnable=" + this.l + ", mobSegmentRecommendBot=" + this.m + ", uniqueChatKey=" + this.n + ", syncSidebarSelection=" + this.o + ')';
    }

    public final boolean w() {
        List r0 = CollectionsKt.listOf(new String[]{ChatLandingChannel.COLD_PURE_CHAT.getChannel(), ChatLandingChannel.COLD_MULTI_CHAT.getChannel(), ChatLandingChannel.COLD_VIDEO_CHAT.getChannel()});
        Bundle r1 = this.b;
        String r2 = "";
        if (r1 == null) goto L9;
        String r3 = r1.getString("landing_channel", "");
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        return r0.contains(r2);
    }

    static {
        s = new c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    }

    public final boolean B() {
        Bundle r0 = this.b;
        if (r0 == null) goto L5;
        long r3 = r0.getLong("target_middle_msg_local_index", -1);
    L7:
        if (r3 == (-1)) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = -1;
        goto L7
    }

    public final boolean C() {
        if (((Boolean) this.r.getValue()).booleanValue() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f == false) goto L11;
        if (o0.d(this.g) == false) goto L11;
        if (o0.d(this.h) == false) goto L11;
        return true;
    }

    public final boolean E() {
        Bundle r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        Bundle r2 = this.b;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.getInt("argBotType") != 4) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.getInt("argBotConversationType") != 6) goto L7;
        r1 = true;
        goto L8
    }

    public final ChatPassThroughParams b() {
        Bundle r1 = this.b;
        if (r1 == null) goto L5;
        ChatPassThroughParams r2 = k.a(r1);
    L6:
        Bundle r3 = this.b;
        if (r3 == null) goto L9;
        String r4 = r3.getString("argCommerceFunctionScene");
    L10:
        if (r4 != null) goto L12;
    L17:
        r4 = null;
    L18:
        Bundle r5 = this.b;
        if (r5 == null) goto L25;
        ChatUserContextParam r6 = (ChatUserContextParam) r5.getParcelable("argLarkUserContext");
        if (r6 == null) goto L25;
        if (r6.isNotEmpty() == false) goto L25;
    L26:
        if (r2 != null) goto L28;
        ChatPassThroughParams r13 = new ChatPassThroughParams(null, false, false, null, 15, null);
    L29:
        if (r4 != null) goto L33;
        if (r2 == null) goto L32;
        r4 = r2.getFlowFunctionScene();
        goto L33
    L32:
        String r14 = null;
    L35:
        if (r6 != null) goto L39;
        if (r2 == null) goto L38;
        r6 = r2.getUserContextParam();
        goto L39
    L38:
        ChatUserContextParam r17 = null;
    L40:
        ChatPassThroughParams r7 = ChatPassThroughParams.copy$default(r13, r14, false, false, r17, 6, null);
        if (r7.isNotEmpty() == true) goto L43;
        return null;
    L43:
        return r7;
    L39:
        r17 = r6;
    L33:
        r14 = r4;
        goto L35
    L28:
        r13 = r2;
    L25:
        r6 = null;
        goto L26
    L12:
        if (r4.length() <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
    L14:
        r8 = false;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String d() {
        Bundle r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("from_activity_module");
    }

    public final String e() {
        Bundle r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("from_activity_name");
    }

    public final String f() {
        Bundle r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("argBotId");
    }

    public final String g() {
        Bundle r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("argConversationId");
    }

    public final String h() {
        Bundle r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("argConversationId", "");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        Bundle r3 = this.b;
        if (r3 != null) goto L22;
        return null;
    L22:
        return r3.getString("argConversationId", "");
    L14:
        if (z2.a.d1() != this.q) goto L24;
        UserSettingRepoDelegate r4 = UserSettingRepoDelegate.b;
        if (Intrinsics.areEqual(r4.c(), Boolean.TRUE) == false) goto L24;
        return r4.Y1();
    L24:
        return "";
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final String i() {
        Bundle r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getString("create_sub_conv_collection_id");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String k() {
        Bundle r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("enter_method");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L19;
        Bundle r3 = this.b;
        if (r3 == null) goto L26;
        String r4 = r3.getString("enter_chat_method");
        if (r4 != null) goto L25;
        return "";
    L25:
        return r4;
    L26:
        return "";
    L19:
        Bundle r5 = this.b;
        if (r5 == null) goto L27;
        r4 = r5.getString("enter_method");
        if (r4 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final long l() {
        Bundle r0 = this.a;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getLong("enter_session", -1);
    }

    public final Integer m() {
        if (o0.d(this.h) == true) goto L5;
        return null;
    L5:
        if (C() == false) goto L13;
        return Integer.valueOf(Color.parseColor(this.h));
    L8:
        FLogger.a.e(c.class.getSimpleName(), "bgPickedColor is not formatted");
        return null;
    L13:
        return null;
    }

    public final boolean n() {
        Bundle r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("argIsHalfScreen", false);
    }

    public final String o() {
        Bundle r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getString("open_comment_id", null);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String p() {
        Bundle r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("argPreviousPage");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L19;
        Bundle r3 = this.b;
        if (r3 == null) goto L26;
        String r4 = r3.getString("previous_page");
        if (r4 != null) goto L25;
        return "";
    L25:
        return r4;
    L26:
        return "";
    L19:
        Bundle r5 = this.b;
        if (r5 == null) goto L27;
        r4 = r5.getString("argPreviousPage");
        if (r4 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final String q() {
        Bundle r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getString("argPushContentId", "");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String r() {
        Bundle r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getString("push_open_url");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String t() {
        Bundle r0 = this.b;
        if (r0 == null) goto L8;
        String r1 = r0.getString("target_scroll_message_id", null);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Bundle r2 = this.b;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getString("target_message_id", null);
    }

    public final boolean v() {
        Bundle r0 = this.b;
        String r1 = "";
        if (r0 == null) goto L9;
        String r2 = r0.getString("auto_open_plus_camera", "");
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        return Intrinsics.areEqual(r1, "1");
    }

    public final boolean z() {
        Bundle r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("is_in_immers_fragment", false);
    }

    public final boolean A() {
        return Intrinsics.areEqual("selfshare_open", k());
    }

    public final boolean D() {
        if (C() == false) goto L10;
        Integer r0 = this.j;
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public final ChatPageContext a() {
        ChatPassThroughParams r0 = b();
        LinkedHashMap r1 = new LinkedHashMap();
        boolean r2 = false;
        if (r0 == null) goto L16;
        String r5 = r0.getFlowFunctionScene();
        if (r5 == null) goto L16;
        if (r5.length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L16;
        r1.put("x-flow-function-scene", r5);
        goto L16
    L9:
        r6 = false;
    L16:
        if ((!r1.isEmpty()) == false) goto L18;
        LinkedHashMap r7 = r1;
    L19:
        Bundle r3 = this.b;
        if (r3 == null) goto L32;
        String r4 = r3.getString("project_id");
        if (r4 == null) goto L32;
        if (r4.length() <= 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L30;
        r4 = null;
    L30:
        if (r4 == null) goto L32;
        Map r9 = MapsKt.mapOf(TuplesKt.to("project_id", r4));
    L33:
        Bundle r10 = this.b;
        if (r10 == null) goto L42;
        String r11 = r10.getString("conversation_mode_key_override");
        if (r11 == null) goto L42;
        if (r11.length() <= 0) goto L40;
        r2 = true;
    L40:
        if (r2 == false) goto L42;
        String r12 = r11;
    L43:
        if (r0 == null) goto L49;
        ChatUserContextParam r13 = r0.getUserContextParam();
        if (r13 == null) goto L49;
        if (r13.isNotEmpty() == false) goto L49;
        ChatUserContextParam r14 = r13;
    L50:
        ChatPageContext r15 = new ChatPageContext(r7, r9, r14, null, null, r12, 24, null);
        if (r15.isNotEmpty() == true) goto L53;
        return null;
    L53:
        return r15;
    L49:
        r14 = null;
    L42:
        r12 = null;
        goto L43
    L26:
        r8 = false;
    L32:
        r9 = null;
        goto L33
    L18:
        r7 = null;
        goto L19
    }

    public final long s() {
        if (wi8.d.a().b() == true) goto L5;
        return -1;
    L5:
        Bundle r0 = this.b;
        if (r0 != null) goto L8;
        return -1;
    L8:
        return r0.getLong("red_dot_entry_read_message_index", -1);
    }

    public final boolean x() {
        if (wi8.d.a().a() == true) goto L5;
        return false;
    L5:
        Bundle r0 = this.b;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.getBoolean("is_from_chat_list", false) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean y() {
        if (wi8.d.a().b() == true) goto L5;
        return false;
    L5:
        Bundle r0 = this.b;
        String r2 = null;
        if (r0 == null) goto L8;
        String r1 = r0.getString("is_from_push", "false");
    L9:
        boolean r3 = Intrinsics.areEqual(r1, "true");
        Bundle r4 = this.b;
        if (r4 == null) goto L12;
        r2 = r4.getString("push_content_type", "");
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r2, "im_push") == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final Bundle j() {
        return this.b;
    }

    public final boolean u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        String r0 = r();
        boolean r2 = true;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L24;
        return false;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        Uri r4 = UriProtector.parse(r0);     // Catch: Throwable -> L17
        if (r4 == null) goto L11;
        String r6 = UriProtector.getQueryParameter(r4, r5);     // Catch: Throwable -> L17
    L12:
        if (r6 != null) goto L15;
        r2 = false;
    L15:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L17
    L19:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L23;
        r7 = r8;
    L23:
        return ((Boolean) r7).booleanValue();
    L11:
        r6 = null;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        r1 = false;
        goto L6
    }

    public static c c(c r20, Bundle r21, long r22, int r24) {
        if ((r24 & 1) == 0) goto L5;
        Bundle r4 = r20.a;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Bundle r5 = r20.b;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r2 = r20.c;
    L15:
        if ((r24 & 8) == 0) goto L17;
        RecommendFrom r7 = r20.d;
    L19:
        if ((r24 & 16) == 0) goto L21;
        SearchMobParam r8 = r20.e;
    L23:
        if ((r24 & 32) == 0) goto L25;
        boolean r9 = r20.f;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r10 = r20.g;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r11 = r20.h;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r12 = r20.i;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Integer r13 = r20.j;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r14 = r20.k;
    L47:
        if ((r24 & 2048) == 0) goto L49;
        boolean r15 = r20.l;
    L51:
        if ((r24 & 4096) == 0) goto L53;
        BotRecommendMobInfo r16 = r20.m;
    L54:
        RecommendFrom r17 = r7;
        if ((r24 & 8192) == 0) goto L57;
        long r18 = r20.n;
    L59:
        if ((r24 & 16384) == 0) goto L61;
        boolean r1 = r20.o;
    L62:
        r20.getClass();
        return new c(r4, r5, r2, r17, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r1);
    L61:
        r1 = false;
        goto L62
    L57:
        r18 = r22;
        goto L59
    L53:
        r16 = null;
        goto L54
    L49:
        r15 = false;
        goto L51
    L45:
        r14 = false;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = false;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r2 = false;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public c(Bundle r8, Bundle r9, boolean r10, RecommendFrom r11, SearchMobParam r12, boolean r13, String r14, String r15, String r16, Integer r17, boolean r18, boolean r19, BotRecommendMobInfo r20, long r21, boolean r23) {
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r23;
        String r3 = null;
        if (r9 == null) goto L5;
        String r4 = r9.getString("share_to_chat_text");
    L6:
        boolean r5 = true;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        if (r9 == null) goto L22;
        String r2 = r9.getString("reference_text");
    L23:
        if (r2 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L19;
        if (r9 == null) goto L33;
        r3 = r9.getString("auto_send_text");
    L33:
        if (r3 != null) goto L35;
    L38:
        boolean r1 = true;
    L39:
        if (r1 == true) goto L19;
        if (z2.a.getRouterConfig().b() == true) goto L19;
    L42:
        this.p = r5;
        this.q = 2;
        this.r = LazyKt.lazy(new b());
        return;
    L35:
        if (r3.length() == 0) goto L38;
        r1 = false;
    L19:
        r5 = false;
        goto L42
    L25:
        if (r2.length() == 0) goto L28;
        r7 = false;
        goto L29
    L22:
        r2 = null;
        goto L23
    L15:
        if (z2.a.getRouterConfig().b() == false) goto L42;
        if (u("share_to_chat_text") == true) goto L19;
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public /* synthetic */ c(Bundle r21, Bundle r22, boolean r23, RecommendFrom r24, SearchMobParam r25, boolean r26, String r27, String r28, String r29, Integer r30, boolean r31, boolean r32, BotRecommendMobInfo r33, long r34, int r36) {
        if ((r36 & 1) == 0) goto L5;
        Bundle r4 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Bundle r5 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r36 & 8) == 0) goto L17;
        RecommendFrom r7 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        SearchMobParam r8 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Integer r13 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        boolean r1 = true;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        BotRecommendMobInfo r16 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        long r17 = SystemClock.elapsedRealtime();
    L59:
        if ((r36 & 16384) == 0) goto L61;
        boolean r19 = true;
    L62:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1, r16, r17, r19);
        return;
    L61:
        r19 = false;
        goto L62
    L57:
        r17 = r34;
        goto L59
    L53:
        r16 = r33;
        goto L55
    L49:
        r1 = r32;
        goto L51
    L45:
        r14 = r31;
        goto L47
    L41:
        r13 = r30;
        goto L43
    L37:
        r12 = r29;
        goto L39
    L33:
        r11 = r28;
        goto L35
    L29:
        r10 = r27;
        goto L31
    L25:
        r9 = r26;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }
}
