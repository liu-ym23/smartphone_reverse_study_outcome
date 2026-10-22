package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/Chatter;", "Lcom/bytedance/ee/util/io/NonProguard;", "avatarKey", BuildConfig.FLAVOR, IPortraitService.NAME, "localizedName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getName", "getLocalizedName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Chatter implements NonProguard {
    private final String avatarKey;
    private final String localizedName;
    private final String name;

    public static /* synthetic */ Chatter copy$default(Chatter r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.avatarKey;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.localizedName;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.localizedName;
    }

    public final Chatter copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r4, "localizedName");
        return new Chatter(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Chatter) == true) goto L8;
        return false;
    L8:
        Chatter r6 = (Chatter) r5;
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localizedName, r6.localizedName) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.avatarKey.hashCode() * 31) + this.name.hashCode()) * 31) + this.localizedName.hashCode();
    }

    public String toString() {
        return "Chatter(avatarKey=" + this.avatarKey + ", name=" + this.name + ", localizedName=" + this.localizedName + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getLocalizedName() {
        return this.localizedName;
    }

    public final String getName() {
        return this.name;
    }

    public Chatter(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r4, "localizedName");
        this.avatarKey = r2;
        this.name = r3;
        this.localizedName = r4;
    }
}
