package com.bytedance.ai.bridge.info;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetUserInfoResultModel", "UserInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetUserInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "", "userID", "", "shortID", "secUserID", "uniqueID", "nickname", "avatarURL", "hasBoundPhone", "", "isBoundPhone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUserID", "()Ljava/lang/String;", "getShortID", "getSecUserID", "getUniqueID", "getNickname", "getAvatarURL", "getHasBoundPhone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserInfo {

        @SerializedName("avatarURL")
        private final String avatarURL;

        @SerializedName("hasBoundPhone")
        private final Boolean hasBoundPhone;

        @SerializedName("isBoundPhone")
        private final Boolean isBoundPhone;

        @SerializedName("nickname")
        private final String nickname;

        @SerializedName("secUserID")
        private final String secUserID;

        @SerializedName("shortID")
        private final String shortID;

        @SerializedName("uniqueID")
        private final String uniqueID;

        @SerializedName("userID")
        private final String userID;

        public UserInfo() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ UserInfo copy$default(UserInfo r10, String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, Boolean r18, int r19, Object r110) {
            if ((r19 & 1) == 0) goto L5;
            String r20 = r10.userID;
        L7:
            if ((r19 & 2) == 0) goto L9;
            String r21 = r10.shortID;
        L11:
            if ((r19 & 4) == 0) goto L13;
            String r22 = r10.secUserID;
        L15:
            if ((r19 & 8) == 0) goto L17;
            String r23 = r10.uniqueID;
        L19:
            if ((r19 & 16) == 0) goto L21;
            String r24 = r10.nickname;
        L23:
            if ((r19 & 32) == 0) goto L25;
            String r25 = r10.avatarURL;
        L27:
            if ((r19 & 64) == 0) goto L29;
            Boolean r26 = r10.hasBoundPhone;
        L31:
            if ((r19 & 128) == 0) goto L33;
            Boolean r1 = r10.isBoundPhone;
        L35:
            return r10.copy(r20, r21, r22, r23, r24, r25, r26, r1);
        L33:
            r1 = r18;
            goto L35
        L29:
            r26 = r17;
            goto L31
        L25:
            r25 = r16;
            goto L27
        L21:
            r24 = r15;
            goto L23
        L17:
            r23 = r14;
            goto L19
        L13:
            r22 = r13;
            goto L15
        L9:
            r21 = r12;
            goto L11
        L5:
            r20 = r11;
            goto L7
        }

        public final String component1() {
            return this.userID;
        }

        public final String component2() {
            return this.shortID;
        }

        public final String component3() {
            return this.secUserID;
        }

        public final String component4() {
            return this.uniqueID;
        }

        public final String component5() {
            return this.nickname;
        }

        public final String component6() {
            return this.avatarURL;
        }

        public final Boolean component7() {
            return this.hasBoundPhone;
        }

        public final Boolean component8() {
            return this.isBoundPhone;
        }

        public final UserInfo copy(String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, Boolean r18) {
            return new UserInfo(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof UserInfo) == true) goto L8;
            return false;
        L8:
            UserInfo r11 = (UserInfo) r10;
            if (Intrinsics.areEqual(this.userID, r11.userID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.shortID, r11.shortID) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.secUserID, r11.secUserID) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.uniqueID, r11.uniqueID) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.nickname, r11.nickname) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.avatarURL, r11.avatarURL) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.hasBoundPhone, r11.hasBoundPhone) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isBoundPhone, r11.isBoundPhone) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            String r0 = this.userID;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.shortID;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.secUserID;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.uniqueID;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            String r21 = this.nickname;
            if (r21 != null) goto L21;
            int r22 = 0;
        L22:
            int r23 = (r20 + r22) * 31;
            String r24 = this.avatarURL;
            if (r24 != null) goto L25;
            int r25 = 0;
        L26:
            int r26 = (r23 + r25) * 31;
            Boolean r27 = this.hasBoundPhone;
            if (r27 != null) goto L29;
            int r28 = 0;
        L30:
            int r29 = (r26 + r28) * 31;
            Boolean r30 = this.isBoundPhone;
            if (r30 == null) goto L35;
            r1 = r30.hashCode();
        L35:
            return r29 + r1;
        L29:
            r28 = r27.hashCode();
            goto L30
        L25:
            r25 = r24.hashCode();
            goto L26
        L21:
            r22 = r21.hashCode();
            goto L22
        L17:
            r19 = r18.hashCode();
            goto L18
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "UserInfo(userID=" + this.userID + ", shortID=" + this.shortID + ", secUserID=" + this.secUserID + ", uniqueID=" + this.uniqueID + ", nickname=" + this.nickname + ", avatarURL=" + this.avatarURL + ", hasBoundPhone=" + this.hasBoundPhone + ", isBoundPhone=" + this.isBoundPhone + ')';
        }

        public final String getAvatarURL() {
            return this.avatarURL;
        }

        public final Boolean getHasBoundPhone() {
            return this.hasBoundPhone;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getSecUserID() {
            return this.secUserID;
        }

        public final String getShortID() {
            return this.shortID;
        }

        public final String getUniqueID() {
            return this.uniqueID;
        }

        public final String getUserID() {
            return this.userID;
        }

        public final Boolean isBoundPhone() {
            return this.isBoundPhone;
        }

        public UserInfo(String r1, String r10, String r11, String r12, String r13, String r14, Boolean r15, Boolean r16) {
            this.userID = r1;
            this.shortID = r10;
            this.secUserID = r11;
            this.uniqueID = r12;
            this.nickname = r13;
            this.avatarURL = r14;
            this.hasBoundPhone = r15;
            this.isBoundPhone = r16;
        }

        public /* synthetic */ UserInfo(String r10, String r11, String r12, String r13, String r14, String r15, Boolean r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
            Boolean r20 = null;
            if ((r18 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r21 = null;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r22 = null;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r23 = null;
        L19:
            if ((r18 & 16) == 0) goto L21;
            String r24 = null;
        L23:
            if ((r18 & 32) == 0) goto L25;
            String r25 = null;
        L27:
            if ((r18 & 64) == 0) goto L29;
            Boolean r26 = null;
        L31:
            if ((r18 & 128) != 0) goto L34;
            r20 = r17;
        L34:
            this(r1, r21, r22, r23, r24, r25, r26, r20);
            return;
        L29:
            r26 = r16;
            goto L31
        L25:
            r25 = r15;
            goto L27
        L21:
            r24 = r14;
            goto L23
        L17:
            r23 = r13;
            goto L19
        L13:
            r22 = r12;
            goto L15
        L9:
            r21 = r11;
            goto L11
        L5:
            r1 = r10;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "hasLoggedIn", required = true)
        void setHasLoggedIn(boolean r1);

        @AIBridgeParamField(keyPath = "isLogin", required = true)
        void setLogin(boolean r1);

        @AIBridgeParamField(keyPath = "userInfo", required = false)
        void setUserInfo(UserInfo r1);
    }

    public AbsGetUserInfoMethodIDL() {
        this.a = "applet.getUserInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
