package com.obric.memorydata.memory.bridge;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/bridge/InfoCommonEntitySimplify;", "", OaidModel.KEY_ID, "", "infoKey", "infoValue", MemoryListActivity.JUMP_FROM_DETAIL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getInfoKey", "getInfoValue", "getDetail", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InfoCommonEntitySimplify {

    @SerializedName(MemoryListActivity.JUMP_FROM_DETAIL)
    private final String detail;
    private final String id;

    @SerializedName(EventBody.KEY_CATEGORY)
    private final String infoKey;

    @SerializedName("summary")
    private final String infoValue;

    public InfoCommonEntitySimplify(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "infoKey");
        Intrinsics.checkNotNullParameter(r4, "infoValue");
        this.id = r2;
        this.infoKey = r3;
        this.infoValue = r4;
        this.detail = r5;
    }

    public static /* synthetic */ InfoCommonEntitySimplify copy$default(InfoCommonEntitySimplify r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.infoKey;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.infoValue;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.detail;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.infoKey;
    }

    public final String component3() {
        return this.infoValue;
    }

    public final String component4() {
        return this.detail;
    }

    public final InfoCommonEntitySimplify copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r2, "infoKey");
        Intrinsics.checkNotNullParameter(r3, "infoValue");
        return new InfoCommonEntitySimplify(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InfoCommonEntitySimplify.class) == true) goto L8;
        return false;
    L8:
        InfoCommonEntitySimplify r6 = (InfoCommonEntitySimplify) ZeusTransformUtils.preCheckCast(r5, InfoCommonEntitySimplify.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.infoKey, r6.infoKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.infoValue, r6.infoValue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detail, r6.detail) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInfoKey() {
        return this.infoKey;
    }

    public final String getInfoValue() {
        return this.infoValue;
    }

    public int hashCode() {
        int r0 = ((((this.id.hashCode() * 31) + this.infoKey.hashCode()) * 31) + this.infoValue.hashCode()) * 31;
        String r2 = this.detail;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "InfoCommonEntitySimplify(id=" + this.id + ", infoKey=" + this.infoKey + ", infoValue=" + this.infoValue + ", detail=" + this.detail + ')';
    }
}
