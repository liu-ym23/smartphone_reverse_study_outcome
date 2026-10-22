package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft;", "", "type", "", "picInfo", "Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "textInfo", "Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "<init>", "(ILcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;)V", "getType", "()I", "setType", "(I)V", "getPicInfo", "()Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "setPicInfo", "(Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;)V", "getTextInfo", "()Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "setTextInfo", "(Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;)V", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BigIslandImageTextInfoLeft {
    public static final a Companion = null;
    public static final int TYPE_LEFT = 1;
    public static final int TYPE_RIGHT = 2;
    public static final int TYPE_RIGHT2 = 3;
    private BigIslandPicInfo picInfo;
    private BigIslandTextInfo textInfo;
    private int type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft$Companion;", "", "<init>", "()V", "TYPE_LEFT", "", "TYPE_RIGHT", "TYPE_RIGHT2", "create", "Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft;", "pic", "", "picResId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public BigIslandImageTextInfoLeft() {
        this(0, null, null, 7, null);
    }

    public BigIslandImageTextInfoLeft(int r1, BigIslandPicInfo r2, BigIslandTextInfo r3) {
        this.type = r1;
        this.picInfo = r2;
        this.textInfo = r3;
    }

    public /* synthetic */ BigIslandImageTextInfoLeft(int r2, BigIslandPicInfo r3, BigIslandTextInfo r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ BigIslandImageTextInfoLeft copy$default(BigIslandImageTextInfoLeft r0, int r1, BigIslandPicInfo r2, BigIslandTextInfo r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.picInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.type;
    }

    public final BigIslandPicInfo component2() {
        return this.picInfo;
    }

    public final BigIslandTextInfo component3() {
        return this.textInfo;
    }

    public final BigIslandImageTextInfoLeft copy(int r1, BigIslandPicInfo r2, BigIslandTextInfo r3) {
        return new BigIslandImageTextInfoLeft(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BigIslandImageTextInfoLeft.class) == true) goto L8;
        return false;
    L8:
        BigIslandImageTextInfoLeft r6 = (BigIslandImageTextInfoLeft) ZeusTransformUtils.preCheckCast(r5, BigIslandImageTextInfoLeft.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textInfo, r6.textInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final BigIslandPicInfo getPicInfo() {
        return this.picInfo;
    }

    public final BigIslandTextInfo getTextInfo() {
        return this.textInfo;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        BigIslandPicInfo r1 = this.picInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        BigIslandTextInfo r5 = this.textInfo;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setPicInfo(BigIslandPicInfo r1) {
        this.picInfo = r1;
    }

    public final void setTextInfo(BigIslandTextInfo r1) {
        this.textInfo = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("BigIslandImageTextInfo.toJSONObject: type=").append(this.type).append(", hasPicInfo=");
        boolean r3 = true;
        if (this.picInfo == null) goto L5;
        boolean r2 = true;
    L6:
        StringBuilder r4 = r1.append(r2).append(", hasTextInfo=");
        if (this.textInfo != null) goto L10;
        r3 = false;
    L10:
        r0.debug("IslandComponents", r4.append(r3).toString());
        JSONObject r5 = new JSONObject();
        r5.put("type", this.type);
        BigIslandPicInfo r6 = this.picInfo;
        if (r6 == null) goto L15;
        JSONObject r7 = r6.toJSONObject();
        if (r7 == null) goto L15;
        r5.put("picInfo", r7);
    L15:
        BigIslandTextInfo r8 = this.textInfo;
        if (r8 == null) goto L20;
        JSONObject r9 = r8.toJSONObject();
        if (r9 == null) goto L20;
        r5.put("textInfo", r9);
    L20:
        return r5;
    L5:
        r2 = false;
        goto L6
    }

    public String toString() {
        return "BigIslandImageTextInfoLeft(type=" + this.type + ", picInfo=" + this.picInfo + ", textInfo=" + this.textInfo + ')';
    }
}
