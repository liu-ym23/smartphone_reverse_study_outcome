package com.obric.aiagent.authentication;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/authentication/PolicyItem;", "", "type", "", "settingKey", "", "<init>", "(ILjava/lang/String;)V", "getType", "()I", "getSettingKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PolicyItem {

    @SerializedName("setting_key")
    private final String settingKey;
    private final int type;

    public PolicyItem(int r1, String r2) {
        this.type = r1;
        this.settingKey = r2;
    }

    public static /* synthetic */ PolicyItem copy$default(PolicyItem r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.settingKey;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.settingKey;
    }

    public final PolicyItem copy(int r1, String r2) {
        return new PolicyItem(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PolicyItem.class) == true) goto L8;
        return false;
    L8:
        PolicyItem r6 = (PolicyItem) ZeusTransformUtils.preCheckCast(r5, PolicyItem.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settingKey, r6.settingKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getSettingKey() {
        return this.settingKey;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.settingKey;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PolicyItem(type=" + this.type + ", settingKey=" + this.settingKey + ')';
    }
}
