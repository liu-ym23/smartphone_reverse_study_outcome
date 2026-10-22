package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\"\u001a\u00020#J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003JT\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "", "type", "", "pic", "", "picResId", "picDark", "picDarkResId", "actionInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;)V", "getType", "()I", "setType", "(I)V", "getPic", "()Ljava/lang/String;", "setPic", "(Ljava/lang/String;)V", "getPicResId", "()Ljava/lang/Integer;", "setPicResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPicDark", "setPicDark", "getPicDarkResId", "setPicDarkResId", "getActionInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;", "setActionInfo", "(Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;)V", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;)Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "equals", "", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedIdentifyPicInfo {
    public static final a Companion = null;
    public static final int TYPE_APP_ICON = 1;
    public static final int TYPE_LARGE = 3;
    public static final int TYPE_MIDDLE = 2;
    private ExpandedImageTextActionInfo actionInfo;
    private String pic;
    private String picDark;
    private Integer picDarkResId;
    private Integer picResId;
    private int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo$Companion;", "", "<init>", "()V", "TYPE_APP_ICON", "", "TYPE_MIDDLE", "TYPE_LARGE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public ExpandedIdentifyPicInfo() {
        this(0, null, null, null, null, null, 63, null);
    }

    public ExpandedIdentifyPicInfo(int r1, String r2, Integer r3, String r4, Integer r5, ExpandedImageTextActionInfo r6) {
        this.type = r1;
        this.pic = r2;
        this.picResId = r3;
        this.picDark = r4;
        this.picDarkResId = r5;
        this.actionInfo = r6;
    }

    public /* synthetic */ ExpandedIdentifyPicInfo(int r5, String r6, Integer r7, String r8, Integer r9, ExpandedImageTextActionInfo r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = 1;
    L5:
        ExpandedImageTextActionInfo r0 = null;
        if ((r11 & 2) == 0) goto L8;
        String r13 = null;
    L10:
        if ((r11 & 4) == 0) goto L12;
        Integer r1 = null;
    L14:
        if ((r11 & 8) == 0) goto L16;
        String r2 = null;
    L18:
        if ((r11 & 16) == 0) goto L20;
        Integer r3 = null;
    L22:
        if ((r11 & 32) != 0) goto L25;
        r0 = r10;
    L25:
        this(r5, r13, r1, r2, r3, r0);
        return;
    L20:
        r3 = r9;
        goto L22
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }

    public static /* synthetic */ ExpandedIdentifyPicInfo copy$default(ExpandedIdentifyPicInfo r4, int r5, String r6, Integer r7, String r8, Integer r9, ExpandedImageTextActionInfo r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.type;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.pic;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.picResId;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.picDark;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.picDarkResId;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.actionInfo;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.pic;
    }

    public final Integer component3() {
        return this.picResId;
    }

    public final String component4() {
        return this.picDark;
    }

    public final Integer component5() {
        return this.picDarkResId;
    }

    public final ExpandedImageTextActionInfo component6() {
        return this.actionInfo;
    }

    public final ExpandedIdentifyPicInfo copy(int r8, String r9, Integer r10, String r11, Integer r12, ExpandedImageTextActionInfo r13) {
        return new ExpandedIdentifyPicInfo(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedIdentifyPicInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedIdentifyPicInfo r6 = (ExpandedIdentifyPicInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedIdentifyPicInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pic, r6.pic) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.picResId, r6.picResId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.picDark, r6.picDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.picDarkResId, r6.picDarkResId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.actionInfo, r6.actionInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final ExpandedImageTextActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getPicDark() {
        return this.picDark;
    }

    public final Integer getPicDarkResId() {
        return this.picDarkResId;
    }

    public final Integer getPicResId() {
        return this.picResId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.pic;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.picResId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.picDark;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.picDarkResId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ExpandedImageTextActionInfo r14 = this.actionInfo;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
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

    public final void setActionInfo(ExpandedImageTextActionInfo r1) {
        this.actionInfo = r1;
    }

    public final void setPic(String r1) {
        this.pic = r1;
    }

    public final void setPicDark(String r1) {
        this.picDark = r1;
    }

    public final void setPicDarkResId(Integer r1) {
        this.picDarkResId = r1;
    }

    public final void setPicResId(Integer r1) {
        this.picResId = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedIdentifyPicInfo.toJSONObject: type=" + this.type + ", pic=" + this.pic);
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        String r1 = this.pic;
        if (r1 == null) goto L5;
        r0.put("pic", r1);
    L5:
        String r2 = this.picDark;
        if (r2 == null) goto L8;
        r0.put("picDark", r2);
    L8:
        ExpandedImageTextActionInfo r3 = this.actionInfo;
        if (r3 == null) goto L13;
        JSONObject r4 = r3.toJSONObject();
        if (r4 == null) goto L13;
        r0.put("actionInfo", r4);
    L13:
        return r0;
    }

    public String toString() {
        return "ExpandedIdentifyPicInfo(type=" + this.type + ", pic=" + this.pic + ", picResId=" + this.picResId + ", picDark=" + this.picDark + ", picDarkResId=" + this.picDarkResId + ", actionInfo=" + this.actionInfo + ')';
    }
}
