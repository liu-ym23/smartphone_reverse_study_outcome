package com.obric.memorydata.memory.island.gr;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003JW\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedIconTextInfo;", "", "title", "", Params.CONTENT, "colorTitle", "colorTitleDark", "colorContent", "colorContentDark", "animIconInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "getColorTitle", "setColorTitle", "getColorTitleDark", "setColorTitleDark", "getColorContent", "setColorContent", "getColorContentDark", "setColorContentDark", "getAnimIconInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;", "setAnimIconInfo", "(Lcom/obric/memorydata/memory/island/gr/ExpandedAnimIconInfo;)V", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedIconTextInfo {
    private ExpandedAnimIconInfo animIconInfo;
    private String colorContent;
    private String colorContentDark;
    private String colorTitle;
    private String colorTitleDark;
    private String content;
    private String title;

    public ExpandedIconTextInfo(String r2, String r3, String r4, String r5, String r6, String r7, ExpandedAnimIconInfo r8) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r8, "animIconInfo");
        this.title = r2;
        this.content = r3;
        this.colorTitle = r4;
        this.colorTitleDark = r5;
        this.colorContent = r6;
        this.colorContentDark = r7;
        this.animIconInfo = r8;
    }

    public /* synthetic */ ExpandedIconTextInfo(String r11, String r12, String r13, String r14, String r15, String r16, ExpandedAnimIconInfo r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r8 = null;
    L18:
        this(r11, r12, r5, r6, r7, r8, r17);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ ExpandedIconTextInfo copy$default(ExpandedIconTextInfo r5, String r6, String r7, String r8, String r9, String r10, String r11, ExpandedAnimIconInfo r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.title;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.content;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.colorTitle;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.colorTitleDark;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.colorContent;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.colorContentDark;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.animIconInfo;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.colorTitle;
    }

    public final String component4() {
        return this.colorTitleDark;
    }

    public final String component5() {
        return this.colorContent;
    }

    public final String component6() {
        return this.colorContentDark;
    }

    public final ExpandedAnimIconInfo component7() {
        return this.animIconInfo;
    }

    public final ExpandedIconTextInfo copy(String r9, String r10, String r11, String r12, String r13, String r14, ExpandedAnimIconInfo r15) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r15, "animIconInfo");
        return new ExpandedIconTextInfo(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedIconTextInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedIconTextInfo r6 = (ExpandedIconTextInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedIconTextInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.colorTitle, r6.colorTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.colorTitleDark, r6.colorTitleDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.colorContent, r6.colorContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.colorContentDark, r6.colorContentDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.animIconInfo, r6.animIconInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final ExpandedAnimIconInfo getAnimIconInfo() {
        return this.animIconInfo;
    }

    public final String getColorContent() {
        return this.colorContent;
    }

    public final String getColorContentDark() {
        return this.colorContentDark;
    }

    public final String getColorTitle() {
        return this.colorTitle;
    }

    public final String getColorTitleDark() {
        return this.colorTitleDark;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int r0 = ((this.title.hashCode() * 31) + this.content.hashCode()) * 31;
        String r1 = this.colorTitle;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.colorTitleDark;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.colorContent;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.colorContentDark;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + this.animIconInfo.hashCode();
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

    public final void setAnimIconInfo(ExpandedAnimIconInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.animIconInfo = r2;
    }

    public final void setColorContent(String r1) {
        this.colorContent = r1;
    }

    public final void setColorContentDark(String r1) {
        this.colorContentDark = r1;
    }

    public final void setColorTitle(String r1) {
        this.colorTitle = r1;
    }

    public final void setColorTitleDark(String r1) {
        this.colorTitleDark = r1;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedIconTextInfo.toJSONObject: title=" + this.title + ", content=" + this.content);
        JSONObject r0 = new JSONObject();
        r0.put("title", this.title);
        r0.put(Params.CONTENT, this.content);
        String r1 = this.colorTitle;
        if (r1 == null) goto L5;
        r0.put("colorTitle", r1);
    L5:
        String r2 = this.colorTitleDark;
        if (r2 == null) goto L8;
        r0.put("colorTitleDark", r2);
    L8:
        String r3 = this.colorContent;
        if (r3 == null) goto L11;
        r0.put("colorContent", r3);
    L11:
        String r4 = this.colorContentDark;
        if (r4 == null) goto L14;
        r0.put("colorContentDark", r4);
    L14:
        r0.put("animIconInfo", this.animIconInfo.toJSONObject());
        return r0;
    }

    public String toString() {
        return "ExpandedIconTextInfo(title=" + this.title + ", content=" + this.content + ", colorTitle=" + this.colorTitle + ", colorTitleDark=" + this.colorTitleDark + ", colorContent=" + this.colorContent + ", colorContentDark=" + this.colorContentDark + ", animIconInfo=" + this.animIconInfo + ')';
    }
}
