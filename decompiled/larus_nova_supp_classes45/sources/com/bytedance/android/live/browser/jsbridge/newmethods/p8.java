package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SelectAtUser;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCommentPanel")
public final class p8 extends com.bytedance.ies.web.jsbridge2.f<b, Object> implements b30.i.a {
    public boolean a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/p8$b;", "", "", "content", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "requestSource", "l", "source", "m", "replyUserId", "j", "replyUserName", "k", "switchType", "n", "preAtUserId", "g", "preAtSecUserId", "f", "preAtUserName", "h", "commentId", "b", "atInfo", "a", "pageName", "e", "toCommentCategory", "o", "replyClickPosition", "i", "defaultPanel", "d", "Lcom/google/gson/JsonObject;", "trackParams", "Lcom/google/gson/JsonObject;", "p", "()Lcom/google/gson/JsonObject;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("at_info")
        private final String atInfo;

        @SerializedName("comment_id")
        private final String commentId;

        @SerializedName("content")
        private final String content;

        @SerializedName("default_panel")
        private final String defaultPanel;

        @SerializedName("vs_event_page")
        private final String pageName;

        @SerializedName("pre_at_sec_user_id")
        private final String preAtSecUserId;

        @SerializedName("pre_at_user_id")
        private final String preAtUserId;

        @SerializedName("pre_at_user_name")
        private final String preAtUserName;

        @SerializedName("vs_reply_click_position")
        private final String replyClickPosition;

        @SerializedName("reply_user_id")
        private final String replyUserId;

        @SerializedName("reply_user_name")
        private final String replyUserName;

        @SerializedName("request_source")
        private final String requestSource;

        @SerializedName("message_source")
        private final String source;

        @SerializedName("switch_type")
        private final String switchType;

        @SerializedName("to_comment_category")
        private final String toCommentCategory;

        @SerializedName("track_params")
        private final JsonObject trackParams;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L38;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.requestSource, r4.requestSource) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.source, r4.source) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.replyUserId, r4.replyUserId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.replyUserName, r4.replyUserName) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.switchType, r4.switchType) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.preAtUserId, r4.preAtUserId) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.preAtSecUserId, r4.preAtSecUserId) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.preAtUserName, r4.preAtUserName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.commentId, r4.commentId) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.atInfo, r4.atInfo) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.toCommentCategory, r4.toCommentCategory) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.replyClickPosition, r4.replyClickPosition) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.defaultPanel, r4.defaultPanel) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.trackParams, r4.trackParams) == true) goto L58;
            return false;
        L58:
            return true;
        L38:
            return false;
        }

        public final int hashCode() {
            String r0 = this.content;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.requestSource;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.source;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.replyUserId;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.replyUserName;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.switchType;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            String r21 = this.preAtUserId;
            if (r21 == null) goto L29;
            int r22 = r21.hashCode();
        L30:
            int r23 = (r19 + r22) * 31;
            String r24 = this.preAtSecUserId;
            if (r24 == null) goto L33;
            int r25 = r24.hashCode();
        L34:
            int r26 = (r23 + r25) * 31;
            String r27 = this.preAtUserName;
            if (r27 == null) goto L37;
            int r28 = r27.hashCode();
        L38:
            int r29 = (r26 + r28) * 31;
            String r31 = this.commentId;
            if (r31 == null) goto L41;
            int r32 = r31.hashCode();
        L42:
            int r33 = (r29 + r32) * 31;
            String r34 = this.atInfo;
            if (r34 == null) goto L45;
            int r35 = r34.hashCode();
        L46:
            int r36 = (r33 + r35) * 31;
            String r37 = this.pageName;
            if (r37 == null) goto L49;
            int r38 = r37.hashCode();
        L50:
            int r39 = (r36 + r38) * 31;
            String r41 = this.toCommentCategory;
            if (r41 == null) goto L53;
            int r42 = r41.hashCode();
        L54:
            int r43 = (r39 + r42) * 31;
            String r44 = this.replyClickPosition;
            if (r44 == null) goto L57;
            int r45 = r44.hashCode();
        L58:
            int r46 = (r43 + r45) * 31;
            String r47 = this.defaultPanel;
            if (r47 == null) goto L61;
            int r48 = r47.hashCode();
        L62:
            int r49 = (r46 + r48) * 31;
            JsonObject r51 = this.trackParams;
            if (r51 == null) goto L66;
            r1 = r51.hashCode();
        L66:
            return r49 + r1;
        L61:
            r48 = 0;
            goto L62
        L57:
            r45 = 0;
            goto L58
        L53:
            r42 = 0;
            goto L54
        L49:
            r38 = 0;
            goto L50
        L45:
            r35 = 0;
            goto L46
        L41:
            r32 = 0;
            goto L42
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r22 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(content=" + this.content + ", requestSource=" + this.requestSource + ", source=" + this.source + ", replyUserId=" + this.replyUserId + ", replyUserName=" + this.replyUserName + ", switchType=" + this.switchType + ", preAtUserId=" + this.preAtUserId + ", preAtSecUserId=" + this.preAtSecUserId + ", preAtUserName=" + this.preAtUserName + ", commentId=" + this.commentId + ", atInfo=" + this.atInfo + ", pageName=" + this.pageName + ", toCommentCategory=" + this.toCommentCategory + ", replyClickPosition=" + this.replyClickPosition + ", defaultPanel=" + this.defaultPanel + ", trackParams=" + this.trackParams + ")";
        }

        public final String a() {
            return this.atInfo;
        }

        public final String b() {
            return this.commentId;
        }

        public final String c() {
            return this.content;
        }

        public final String d() {
            return this.defaultPanel;
        }

        public final String e() {
            return this.pageName;
        }

        public final String f() {
            return this.preAtSecUserId;
        }

        public final String g() {
            return this.preAtUserId;
        }

        public final String h() {
            return this.preAtUserName;
        }

        public final String i() {
            return this.replyClickPosition;
        }

        public final String j() {
            return this.replyUserId;
        }

        public final String k() {
            return this.replyUserName;
        }

        public final String l() {
            return this.requestSource;
        }

        public final String m() {
            return this.source;
        }

        public final String n() {
            return this.switchType;
        }

        public final String o() {
            return this.toCommentCategory;
        }

        public final JsonObject p() {
            return this.trackParams;
        }
    }

    static {
    }

    public final void onTerminate() {
    }

    public p8() {
    }

    public final void invoke(Object r29, CallContext r31) {
        b r0 = (b) r29;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r31, "context");
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r1 = com.bytedance.android.livesdk.interactivity.api.monitor.b.a;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.d(r0.m(), r0.c());
        long r11 = System.currentTimeMillis();
        String r2 = r0.g();
        String r3 = r0.f();
        String r4 = r0.h();
        if (TextUtils.isEmpty(r2) == true) goto L5;
    L13:
        String r21 = r2;
        String r22 = r3;
        String r23 = r4;
        this.a = !Intrinsics.areEqual(r0.m(), "vs_send_danmaku");
        String r5 = r0.c();
        String r6 = r0.m();
        if (r6 != null) goto L16;
        String r7 = "jsbridge";
    L17:
        xs2.b.a().post(new b30.i(r5, "jsbridge", r7, this, new b30.h(r0.j(), r0.k(), r0.n(), r21, r22, r23, r0.b(), r0.e(), r0.o(), r0.i()), r0.l(), r0.d(), r11, true, r0.p(), null, null, null, 7168));
        if (((Boolean) com.bytedance.android.livesdk.s4.a.getValue()).booleanValue() == false) goto L26;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("sender", "jsbridge");
        String r9 = r0.l();
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r8.put("request_source", r9);
        r8.put("jsb_name", "openCommentPanel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r8, new Object[0]);
        return;
    L26:
        return;
    L16:
        r7 = r6;
        goto L17
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        if (TextUtils.isEmpty(r4) == false) goto L13;
        if (TextUtils.isEmpty(r0.a()) == true) goto L13;
        JsonObject r12 = (JsonObject) ((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).get().fromJson(r0.a(), JsonObject.class);     // Catch: Exception -> L12
        r2 = r12.get("pre_at_user_id").getAsString();     // Catch: Exception -> L12
        r3 = r12.get("pre_at_sec_user_id").getAsString();     // Catch: Exception -> L12
        r4 = r12.get("pre_at_user_name").getAsString();     // Catch: Exception -> L12
    L12:
        x8.a.d("OpenCommentPanelMethod", "opt params fail", false);
        goto L13
    }

    @Override // b30.i.a
    public final void onCommentSuccess(CharSequence r7, ISelfEmoji r8, List<SelectAtUser> r9) {
        if (this.a == true) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject();
        r11.put("status_code", 1);
        String r12 = "";
        Object r0 = "".toString();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r11.put("message", r0);
        JSONObject r1 = new JSONObject();
        r1.put("height", null);
        r1.put("width", null);
        r1.put("id", null);
        JSONArray r2 = new JSONArray();
        Unit r3 = Unit.INSTANCE;
        r1.put("url_list", r2);
        r1.put("is_gif", null);
        r1.put("web_uri", null);
        r1.put("animate_type", null);
        r1.put("display_name", null);
        r11.put("image", r1);
        r11.put("at_info", new JSONArray());
        String r4 = "".toString();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        int r5 = r4.length();
        int r6 = 0;
        int r13 = 0;
    L12:
        if (r13 >= r5) goto L17;
        if (com.bytedance.android.livesdk.utils.l1.b(r4.charAt(r13)) == true) goto L15;
        r13 = r13 + 1;
        goto L12
    L15:
        int r14 = 1;
    L18:
        String r15 = "".toString();
        if (r15 == null) goto L22;
        r12 = r15;
    L22:
        boolean r16 = com.bytedance.android.livesdk.utils.l1.a(r12);
        r11.put("has_keyboard_emoji", r16 ? 1 : 0);
        r11.put("has_system_emoji", r14);
        if (r16 == true) goto L26;
        if (r14 != 0) goto L26;
        r6 = 1;
    L26:
        r11.put("is_pure_text", r6);
        r11.put("has_emoji_package", !TextUtils.isEmpty(null) ? 1 : 0);
        JSONObject r17 = new JSONObject();
        r17.put("code", 1);
        r17.put("data", r11);
        finishWithResult(r17);
        return;
    L17:
        r14 = 0;
        goto L18
    }
}
