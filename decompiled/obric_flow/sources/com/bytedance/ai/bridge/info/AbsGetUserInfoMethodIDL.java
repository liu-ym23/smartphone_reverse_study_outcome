package com.bytedance.ai.bridge.info;

import androidx.annotation.Keep;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetUserInfoResultModel", "UserInfo", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsGetUserInfoMethodIDL extends CoreAIBridgeMethod<EmptyMessageModel, GetUserInfoResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface EmptyMessageModel extends ParamModel {
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R&\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000b@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "isLogin", "()Z", "setLogin", "(Z)V", "hasLoggedIn", "getHasLoggedIn", "setHasLoggedIn", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "userInfo", "getUserInfo", "()Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "setUserInfo", "(Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetUserInfoResultModel extends ResultModel {
        boolean getHasLoggedIn();

        UserInfo getUserInfo();

        boolean isLogin();

        @AIBridgeParamField(keyPath = "hasLoggedIn", required = true)
        void setHasLoggedIn(boolean r5);

        @AIBridgeParamField(keyPath = "isLogin", required = true)
        void setLogin(boolean r5);

        @AIBridgeParamField(keyPath = "userInfo", required = false)
        void setUserInfo(UserInfo r5);
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "", "userID", "", "shortID", "secUserID", "uniqueID", "nickname", "avatarURL", "hasBoundPhone", "", "isBoundPhone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUserID", "()Ljava/lang/String;", "getShortID", "getSecUserID", "getUniqueID", "getNickname", "getAvatarURL", "getHasBoundPhone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            String r5 = null;
            String r10 = null;
            String r11 = null;
            String r12 = null;
            String r13 = null;
            String r14 = null;
            Boolean r15 = null;
            Boolean r16 = null;
            this(r5, r10, r11, r12, r13, r14, r15, r16, 255, null);
        }

        public static /* synthetic */ UserInfo copy$default(UserInfo r10, String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, Boolean r18, int r19, Object r110) {
            if ((r19 & 1) == 0) goto L5;
            String r5 = r10.userID;
        L7:
            if ((r19 & 2) == 0) goto L9;
            String r20 = r10.shortID;
        L11:
            if ((r19 & 4) == 0) goto L13;
            String r21 = r10.secUserID;
        L15:
            if ((r19 & 8) == 0) goto L17;
            String r22 = r10.uniqueID;
        L19:
            if ((r19 & 16) == 0) goto L21;
            String r23 = r10.nickname;
        L23:
            if ((r19 & 32) == 0) goto L25;
            String r24 = r10.avatarURL;
        L27:
            if ((r19 & 64) == 0) goto L29;
            Boolean r25 = r10.hasBoundPhone;
        L31:
            if ((r19 & 128) == 0) goto L33;
            Boolean r26 = r10.isBoundPhone;
        L35:
            return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
        L33:
            r26 = r18;
            goto L35
        L29:
            r25 = r17;
            goto L31
        L25:
            r24 = r16;
            goto L27
        L21:
            r23 = r15;
            goto L23
        L17:
            r22 = r14;
            goto L19
        L13:
            r21 = r13;
            goto L15
        L9:
            r20 = r12;
            goto L11
        L5:
            r5 = r11;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UserInfo) == true) goto L8;
            return false;
        L8:
            UserInfo r10 = (UserInfo) r5;
            if (Intrinsics.areEqual(this.userID, r10.userID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.shortID, r10.shortID) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.secUserID, r10.secUserID) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.uniqueID, r10.uniqueID) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.nickname, r10.nickname) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.avatarURL, r10.avatarURL) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.hasBoundPhone, r10.hasBoundPhone) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isBoundPhone, r10.isBoundPhone) == true) goto L32;
            return false;
        L32:
            return true;
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

        public int hashCode() {
            String r5 = this.userID;
            int r10 = 0;
            if (r5 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = r11 * 31;
            String r13 = this.shortID;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            String r16 = this.secUserID;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.uniqueID;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = (r18 + r20) * 31;
            String r22 = this.nickname;
            if (r22 != null) goto L21;
            int r23 = 0;
        L22:
            int r24 = (r21 + r23) * 31;
            String r25 = this.avatarURL;
            if (r25 != null) goto L25;
            int r26 = 0;
        L26:
            int r27 = (r24 + r26) * 31;
            Boolean r28 = this.hasBoundPhone;
            if (r28 != null) goto L29;
            int r29 = 0;
        L30:
            int r30 = (r27 + r29) * 31;
            Boolean r31 = this.isBoundPhone;
            if (r31 == null) goto L35;
            r10 = r31.hashCode();
        L35:
            return r30 + r10;
        L29:
            r29 = r28.hashCode();
            goto L30
        L25:
            r26 = r25.hashCode();
            goto L26
        L21:
            r23 = r22.hashCode();
            goto L22
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r5.hashCode();
            goto L6
        }

        public final Boolean isBoundPhone() {
            return this.isBoundPhone;
        }

        public String toString() {
            return "UserInfo(userID=" + this.userID + ", shortID=" + this.shortID + ", secUserID=" + this.secUserID + ", uniqueID=" + this.uniqueID + ", nickname=" + this.nickname + ", avatarURL=" + this.avatarURL + ", hasBoundPhone=" + this.hasBoundPhone + ", isBoundPhone=" + this.isBoundPhone + ')';
        }

        public UserInfo(String r5, String r10, String r11, String r12, String r13, String r14, Boolean r15, Boolean r16) {
            this.userID = r5;
            this.shortID = r10;
            this.secUserID = r11;
            this.uniqueID = r12;
            this.nickname = r13;
            this.avatarURL = r14;
            this.hasBoundPhone = r15;
            this.isBoundPhone = r16;
        }

        public /* synthetic */ UserInfo(String r5, String r10, String r11, String r12, String r13, String r14, Boolean r15, Boolean r16, int r17, DefaultConstructorMarker r18) {
            if ((r17 & 1) == 0) goto L6;
            r5 = null;
        L6:
            if ((r17 & 2) == 0) goto L9;
            r10 = null;
        L9:
            if ((r17 & 4) == 0) goto L12;
            r11 = null;
        L12:
            if ((r17 & 8) == 0) goto L15;
            r12 = null;
        L15:
            if ((r17 & 16) == 0) goto L18;
            r13 = null;
        L18:
            if ((r17 & 32) == 0) goto L21;
            r14 = null;
        L21:
            if ((r17 & 64) == 0) goto L24;
            r15 = null;
        L24:
            if ((r17 & 128) == 0) goto L26;
            r16 = null;
        L26:
            this(r5, r10, r11, r12, r13, r14, r15, r16);
        }
    }

    public AbsGetUserInfoMethodIDL() {
        this.name = "applet.getUserInfo";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
