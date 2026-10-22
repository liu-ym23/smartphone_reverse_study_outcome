package com.ss.android.lark.chameleonv2.lkapi.passport;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J%\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Ju\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$UserInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "avatarKey", BuildConfig.FLAVOR, "avatarUrl", "geo", "i18nNames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "id", IPortraitService.NAME, "tenant", "Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;", "unit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getAvatarUrl", "getGeo", "getI18nNames", "()Ljava/util/HashMap;", "getId", "getName", "getTenant", "()Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;", "getUnit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPassport$UserInfo implements NonProguard {
    private final String avatarKey;
    private final String avatarUrl;
    private final String geo;
    private final HashMap<String, String> i18nNames;
    private final String id;
    private final String name;
    private final IPassport$TenantInfo tenant;
    private final String unit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IPassport$UserInfo copy$default(IPassport$UserInfo r9, String r10, String r11, String r12, HashMap r13, String r14, String r15, IPassport$TenantInfo r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.avatarKey;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.avatarUrl;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.geo;
    L15:
        if ((r18 & 8) == 0) goto L17;
        HashMap r5 = r9.i18nNames;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.id;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.name;
    L27:
        if ((r18 & 64) == 0) goto L29;
        IPassport$TenantInfo r8 = r9.tenant;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.unit;
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
        return this.avatarKey;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final String component3() {
        return this.geo;
    }

    public final HashMap<String, String> component4() {
        return this.i18nNames;
    }

    public final String component5() {
        return this.id;
    }

    public final String component6() {
        return this.name;
    }

    public final IPassport$TenantInfo component7() {
        return this.tenant;
    }

    public final String component8() {
        return this.unit;
    }

    public final IPassport$UserInfo copy(String r11, String r12, String r13, HashMap<String, String> r14, String r15, String r16, IPassport$TenantInfo r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "avatarKey");
        Intrinsics.checkNotNullParameter(r12, "avatarUrl");
        Intrinsics.checkNotNullParameter(r13, "geo");
        Intrinsics.checkNotNullParameter(r14, "i18nNames");
        Intrinsics.checkNotNullParameter(r15, "id");
        Intrinsics.checkNotNullParameter(r16, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r17, "tenant");
        Intrinsics.checkNotNullParameter(r18, "unit");
        return new IPassport$UserInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IPassport$UserInfo) == true) goto L8;
        return false;
    L8:
        IPassport$UserInfo r6 = (IPassport$UserInfo) r5;
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.geo, r6.geo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nNames, r6.i18nNames) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tenant, r6.tenant) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.unit, r6.unit) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.avatarKey.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.geo.hashCode()) * 31) + this.i18nNames.hashCode()) * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.tenant.hashCode()) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "UserInfo(avatarKey=" + this.avatarKey + ", avatarUrl=" + this.avatarUrl + ", geo=" + this.geo + ", i18nNames=" + this.i18nNames + ", id=" + this.id + ", name=" + this.name + ", tenant=" + this.tenant + ", unit=" + this.unit + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getGeo() {
        return this.geo;
    }

    public final HashMap<String, String> getI18nNames() {
        return this.i18nNames;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final IPassport$TenantInfo getTenant() {
        return this.tenant;
    }

    public final String getUnit() {
        return this.unit;
    }

    public IPassport$UserInfo(String r2, String r3, String r4, HashMap<String, String> r5, String r6, String r7, IPassport$TenantInfo r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "geo");
        Intrinsics.checkNotNullParameter(r5, "i18nNames");
        Intrinsics.checkNotNullParameter(r6, "id");
        Intrinsics.checkNotNullParameter(r7, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r8, "tenant");
        Intrinsics.checkNotNullParameter(r9, "unit");
        this.avatarKey = r2;
        this.avatarUrl = r3;
        this.geo = r4;
        this.i18nNames = r5;
        this.id = r6;
        this.name = r7;
        this.tenant = r8;
        this.unit = r9;
    }
}
