package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jf\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppBadgeNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_APP_ID, "feature", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;", "needShow", BuildConfig.FLAVOR, "updateTime", "badgeNum", BuildConfig.FLAVOR, "extra", Keys.API_RETURN_KEY_VERSION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getAppId", "getFeature", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;", "getNeedShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUpdateTime", "getBadgeNum", "()I", "getExtra", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppBadgeNode;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyOpenAppBadgeNode implements NonProguard {
    private final String appId;
    private final int badgeNum;
    private final String extra;
    private final MyOpenAppFeatureType feature;
    private final String id;
    private final Boolean needShow;
    private final String updateTime;
    private final String version;

    public static /* synthetic */ MyOpenAppBadgeNode copy$default(MyOpenAppBadgeNode r9, String r10, String r11, MyOpenAppFeatureType r12, Boolean r13, String r14, int r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.appId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        MyOpenAppFeatureType r4 = r9.feature;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = r9.needShow;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.updateTime;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.badgeNum;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.extra;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.version;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.appId;
    }

    public final MyOpenAppFeatureType component3() {
        return this.feature;
    }

    public final Boolean component4() {
        return this.needShow;
    }

    public final String component5() {
        return this.updateTime;
    }

    public final int component6() {
        return this.badgeNum;
    }

    public final String component7() {
        return this.extra;
    }

    public final String component8() {
        return this.version;
    }

    public final MyOpenAppBadgeNode copy(String r11, String r12, MyOpenAppFeatureType r13, Boolean r14, String r15, int r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r18, Keys.API_RETURN_KEY_VERSION);
        return new MyOpenAppBadgeNode(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyOpenAppBadgeNode) == true) goto L8;
        return false;
    L8:
        MyOpenAppBadgeNode r6 = (MyOpenAppBadgeNode) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L15;
        return false;
    L15:
        if (this.feature == r6.feature) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.needShow, r6.needShow) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L24;
        return false;
    L24:
        if (this.badgeNum == r6.badgeNum) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.appId.hashCode()) * 31;
        MyOpenAppFeatureType r1 = this.feature;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.needShow;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.updateTime;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.badgeNum) * 31;
        String r11 = this.extra;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + this.version.hashCode();
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MyOpenAppBadgeNode(id=" + this.id + ", appId=" + this.appId + ", feature=" + this.feature + ", needShow=" + this.needShow + ", updateTime=" + this.updateTime + ", badgeNum=" + this.badgeNum + ", extra=" + this.extra + ", version=" + this.version + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getBadgeNum() {
        return this.badgeNum;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final MyOpenAppFeatureType getFeature() {
        return this.feature;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getNeedShow() {
        return this.needShow;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public MyOpenAppBadgeNode(String r2, String r3, MyOpenAppFeatureType r4, Boolean r5, String r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r9, Keys.API_RETURN_KEY_VERSION);
        this.id = r2;
        this.appId = r3;
        this.feature = r4;
        this.needShow = r5;
        this.updateTime = r6;
        this.badgeNum = r7;
        this.extra = r8;
        this.version = r9;
    }
}
