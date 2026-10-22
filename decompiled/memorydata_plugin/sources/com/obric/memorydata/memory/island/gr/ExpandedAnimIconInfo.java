package com.obric.memorydata.memory.island.gr;

import android.graphics.drawable.Icon;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\"\u001a\u00020#J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003JP\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;", "", "type", "", "src", "", "srcResId", "srcDark", "srcDarkResId", "iconOverride", "Landroid/graphics/drawable/Icon;", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Icon;)V", "getType", "()I", "setType", "(I)V", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "getSrcResId", "setSrcResId", "getSrcDark", "setSrcDark", "getSrcDarkResId", "()Ljava/lang/Integer;", "setSrcDarkResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIconOverride", "()Landroid/graphics/drawable/Icon;", "setIconOverride", "(Landroid/graphics/drawable/Icon;)V", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Icon;)Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedAnimIconInfo {
    private Icon iconOverride;
    private String src;
    private String srcDark;
    private Integer srcDarkResId;
    private int srcResId;
    private int type;

    public ExpandedAnimIconInfo(int r2, String r3, int r4, String r5, Integer r6, Icon r7) {
        Intrinsics.checkNotNullParameter(r3, "src");
        this.type = r2;
        this.src = r3;
        this.srcResId = r4;
        this.srcDark = r5;
        this.srcDarkResId = r6;
        this.iconOverride = r7;
    }

    public /* synthetic */ ExpandedAnimIconInfo(int r8, String r9, int r10, String r11, Integer r12, Icon r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        int r1 = r8;
        if ((r14 & 8) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r14 & 16) == 0) goto L12;
        Integer r5 = null;
    L14:
        if ((r14 & 32) == 0) goto L16;
        Icon r6 = null;
    L17:
        this(r1, r9, r10, r4, r5, r6);
        return;
    L16:
        r6 = r13;
        goto L17
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = r11;
        goto L10
    }

    public static /* synthetic */ ExpandedAnimIconInfo copy$default(ExpandedAnimIconInfo r4, int r5, String r6, int r7, String r8, Integer r9, Icon r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.type;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.src;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.srcResId;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.srcDark;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.srcDarkResId;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.iconOverride;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.src;
    }

    public final int component3() {
        return this.srcResId;
    }

    public final String component4() {
        return this.srcDark;
    }

    public final Integer component5() {
        return this.srcDarkResId;
    }

    public final Icon component6() {
        return this.iconOverride;
    }

    public final ExpandedAnimIconInfo copy(int r8, String r9, int r10, String r11, Integer r12, Icon r13) {
        Intrinsics.checkNotNullParameter(r9, "src");
        return new ExpandedAnimIconInfo(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedAnimIconInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedAnimIconInfo r6 = (ExpandedAnimIconInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedAnimIconInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.src, r6.src) == true) goto L15;
        return false;
    L15:
        if (this.srcResId == r6.srcResId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.srcDark, r6.srcDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.srcDarkResId, r6.srcDarkResId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconOverride, r6.iconOverride) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final Icon getIconOverride() {
        return this.iconOverride;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getSrcDark() {
        return this.srcDark;
    }

    public final Integer getSrcDarkResId() {
        return this.srcDarkResId;
    }

    public final int getSrcResId() {
        return this.srcResId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.type) * 31) + this.src.hashCode()) * 31) + Integer.hashCode(this.srcResId)) * 31;
        String r1 = this.srcDark;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.srcDarkResId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Icon r8 = this.iconOverride;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setIconOverride(Icon r1) {
        this.iconOverride = r1;
    }

    public final void setSrc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.src = r2;
    }

    public final void setSrcDark(String r1) {
        this.srcDark = r1;
    }

    public final void setSrcDarkResId(Integer r1) {
        this.srcDarkResId = r1;
    }

    public final void setSrcResId(int r1) {
        this.srcResId = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("ExpandedAnimIconInfo.toJSONObject: type=").append(this.type).append(", src=").append(this.src).append(", hasIconOverride=");
        if (this.iconOverride == null) goto L5;
        boolean r2 = true;
    L6:
        r0.debug("IslandComponents", r1.append(r2).toString());
        JSONObject r3 = new JSONObject();
        r3.put("type", this.type);
        r3.put("src", this.src);
        String r4 = this.srcDark;
        if (r4 == null) goto L9;
        r3.put("srcDark", r4);
    L9:
        return r3;
    L5:
        r2 = false;
        goto L6
    }

    public String toString() {
        return "ExpandedAnimIconInfo(type=" + this.type + ", src=" + this.src + ", srcResId=" + this.srcResId + ", srcDark=" + this.srcDark + ", srcDarkResId=" + this.srcDarkResId + ", iconOverride=" + this.iconOverride + ')';
    }
}
