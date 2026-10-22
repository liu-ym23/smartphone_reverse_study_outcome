package com.byted.mgl.merge.service.api.share;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/byted/mgl/merge/service/api/share/ShareImCallbackInfo;", "", "avatar", "", "userName", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", ShareImCallbackInfo.KEY_ICON, "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "name", "getName", "setName", "shareData", "Lorg/json/JSONObject;", "getUserId", "setUserId", "clipData", "needAddUid", "", "toString", "Companion", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public final class ShareImCallbackInfo {
    public static final Companion Companion = null;
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_DATA = "data";
    private static final String KEY_ICON = "icon";
    private static final String KEY_NAME = "name";
    private static final String KEY_UID = "uid";
    private static final String VALUE_CHANNEL_INVITE = "invite";
    private String icon;
    private String name;
    private JSONObject shareData;
    private String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/byted/mgl/merge/service/api/share/ShareImCallbackInfo$Companion;", "", "()V", "KEY_CHANNEL", "", "KEY_DATA", "KEY_ICON", "KEY_NAME", "KEY_UID", "VALUE_CHANNEL_INVITE", "isInviteChannel", "", "jsonObject", "Lorg/json/JSONObject;", "praseData", "Lcom/byted/mgl/merge/service/api/share/ShareImCallbackInfo;", "jsonObj", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean isInviteChannel(JSONObject r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            return Intrinsics.areEqual(ShareImCallbackInfo.VALUE_CHANNEL_INVITE, r10.optString(ShareImCallbackInfo.KEY_CHANNEL));
        }

        public final ShareImCallbackInfo praseData(JSONObject r10) {
            if (r10 == null) goto L16;
            JSONArray r0 = r10.optJSONArray(ShareImCallbackInfo.KEY_DATA);     // Catch: JSONException -> L10
            if (Intrinsics.areEqual(ShareImCallbackInfo.VALUE_CHANNEL_INVITE, r10.optString(ShareImCallbackInfo.KEY_CHANNEL)) == false) goto L17;
            if (r0 != null) goto L7;
            return null;
        L7:
            if (r0.length() <= 0) goto L19;
            JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r0, 0);     // Catch: JSONException -> L10
            String r1 = r11.optString("name");     // Catch: JSONException -> L10
            return new ShareImCallbackInfo(r11.optString(ShareImCallbackInfo.KEY_ICON), r1, r11.optString("uid"));
        L19:
            return null;
        L17:
            return null;
        L10:
            e = move-exception;
            e.printStackTrace();
            return null;
        L16:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        JSONObject r0 = this.shareData;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String clipData(boolean r10) {
        JSONObject r0 = this.shareData;
        if (r0 == null) goto L22;
        JSONArray r1 = r0.optJSONArray(KEY_DATA);
        if (r1 == null) goto L22;
        int r11 = 0;
        if (r1.length() <= 0) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L22;
        int r13 = r1.length();
    L15:
        if (r11 >= r13) goto L20;
        JSONObject r14 = JSONArrayProtectorUtils.getJSONObject(r1, r11);
        if (r10 == true) goto L19;
        r14.remove("uid");
    L19:
        r11 = r11 + 1;
        goto L15
    L20:
        JSONObject r15 = new JSONObject();
        r15.put(KEY_DATA, r1);
        return r15.toString();
    L9:
        r12 = false;
    L22:
        return null;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setUserId(String r1) {
        this.userId = r1;
    }

    public ShareImCallbackInfo(String r10, String r11, String r12) {
        this.shareData = new JSONObject();
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("name", r11);
        r1.put(KEY_ICON, r10);
        r1.put("uid", r12);
        r0.put(r1);
        JSONObject r13 = this.shareData;
        if (r13 == null) goto L5;
        r13.put(KEY_DATA, r0);
    L5:
        JSONObject r14 = this.shareData;
        if (r14 == null) goto L9;
        r14.put(KEY_CHANNEL, VALUE_CHANNEL_INVITE);
        return;
    }
}
