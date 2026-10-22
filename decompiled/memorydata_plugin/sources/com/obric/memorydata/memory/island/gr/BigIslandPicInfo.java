package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "", "type", "", "pic", "", "picResId", "<init>", "(ILjava/lang/String;I)V", "getType", "()I", "setType", "(I)V", "getPic", "()Ljava/lang/String;", "setPic", "(Ljava/lang/String;)V", "getPicResId", "setPicResId", "toJSONObject", "Lorg/json/JSONObject;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BigIslandPicInfo {
    public static final a Companion = null;
    private String pic;
    private int picResId;
    private int type;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "pic", "", "picResId", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final BigIslandPicInfo a(String r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "pic");
            RunLog.INSTANCE.debug("IslandComponents", "BigIslandPicInfo.create: pic=" + r9 + ", picResId=" + r10);
            return new BigIslandPicInfo(0, r9, r10, 1, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public BigIslandPicInfo(int r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "pic");
        this.type = r2;
        this.pic = r3;
        this.picResId = r4;
    }

    public /* synthetic */ BigIslandPicInfo(int r1, String r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 1;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ BigIslandPicInfo copy$default(BigIslandPicInfo r0, int r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.pic;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.picResId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.pic;
    }

    public final int component3() {
        return this.picResId;
    }

    public final BigIslandPicInfo copy(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "pic");
        return new BigIslandPicInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BigIslandPicInfo.class) == true) goto L8;
        return false;
    L8:
        BigIslandPicInfo r6 = (BigIslandPicInfo) ZeusTransformUtils.preCheckCast(r5, BigIslandPicInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pic, r6.pic) == true) goto L15;
        return false;
    L15:
        if (this.picResId == r6.picResId) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getPic() {
        return this.pic;
    }

    public final int getPicResId() {
        return this.picResId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.type) * 31) + this.pic.hashCode()) * 31) + Integer.hashCode(this.picResId);
    }

    public final void setPic(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pic = r2;
    }

    public final void setPicResId(int r1) {
        this.picResId = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "BigIslandPicInfo.toJSONObject: type=" + this.type + ", pic=" + this.pic);
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        r0.put("pic", this.pic);
        return r0;
    }

    public String toString() {
        return "{\"type\":" + this.type + ",\"pic\":\"" + this.pic + "\", \"picResId\":" + this.picResId + '}';
    }
}
