package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;", "", "type", "", "colorBg", "", "colorBgDark", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getColorBg", "()Ljava/lang/String;", "setColorBg", "(Ljava/lang/String;)V", "getColorBgDark", "setColorBgDark", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedBgInfo {
    private String colorBg;
    private String colorBgDark;
    private int type;

    public ExpandedBgInfo() {
        this(0, null, null, 7, null);
    }

    public ExpandedBgInfo(int r1, String r2, String r3) {
        this.type = r1;
        this.colorBg = r2;
        this.colorBgDark = r3;
    }

    public /* synthetic */ ExpandedBgInfo(int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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

    public static /* synthetic */ ExpandedBgInfo copy$default(ExpandedBgInfo r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.colorBg;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.colorBgDark;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.colorBg;
    }

    public final String component3() {
        return this.colorBgDark;
    }

    public final ExpandedBgInfo copy(int r1, String r2, String r3) {
        return new ExpandedBgInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedBgInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedBgInfo r6 = (ExpandedBgInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedBgInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorBg, r6.colorBg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.colorBgDark, r6.colorBgDark) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getColorBg() {
        return this.colorBg;
    }

    public final String getColorBgDark() {
        return this.colorBgDark;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.colorBg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.colorBgDark;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setColorBg(String r1) {
        this.colorBg = r1;
    }

    public final void setColorBgDark(String r1) {
        this.colorBgDark = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedBgInfo.toJSONObject: type=" + this.type + ", colorBg=" + this.colorBg);
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        String r1 = this.colorBg;
        if (r1 == null) goto L5;
        r0.put("colorBg", r1);
    L5:
        String r3 = this.colorBgDark;
        if (r3 == null) goto L8;
        r0.put("colorBgDark", r3);
    L8:
        return r0;
    }

    public String toString() {
        return "ExpandedBgInfo(type=" + this.type + ", colorBg=" + this.colorBg + ", colorBgDark=" + this.colorBgDark + ')';
    }
}
