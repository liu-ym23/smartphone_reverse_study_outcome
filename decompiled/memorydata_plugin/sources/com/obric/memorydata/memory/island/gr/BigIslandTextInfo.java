package com.obric.memorydata.memory.island.gr;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014JH\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "", "frontTitle", "", "title", Params.CONTENT, "narrowFont", "", "showHighlightColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getFrontTitle", "()Ljava/lang/String;", "setFrontTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getContent", "setContent", "getNarrowFont", "()Ljava/lang/Boolean;", "setNarrowFont", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowHighlightColor", "setShowHighlightColor", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BigIslandTextInfo {
    private String content;
    private String frontTitle;
    private Boolean narrowFont;
    private Boolean showHighlightColor;
    private String title;

    public BigIslandTextInfo(String r2, String r3, String r4, Boolean r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "title");
        this.frontTitle = r2;
        this.title = r3;
        this.content = r4;
        this.narrowFont = r5;
        this.showHighlightColor = r6;
    }

    public /* synthetic */ BigIslandTextInfo(String r8, String r9, String r10, Boolean r11, Boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Boolean r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        Boolean r6 = null;
    L18:
        this(r2, r9, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ BigIslandTextInfo copy$default(BigIslandTextInfo r3, String r4, String r5, String r6, Boolean r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.frontTitle;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.title;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.content;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.narrowFont;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.showHighlightColor;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.frontTitle;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final Boolean component4() {
        return this.narrowFont;
    }

    public final Boolean component5() {
        return this.showHighlightColor;
    }

    public final BigIslandTextInfo copy(String r7, String r8, String r9, Boolean r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "title");
        return new BigIslandTextInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BigIslandTextInfo.class) == true) goto L8;
        return false;
    L8:
        BigIslandTextInfo r6 = (BigIslandTextInfo) ZeusTransformUtils.preCheckCast(r5, BigIslandTextInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.frontTitle, r6.frontTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.narrowFont, r6.narrowFont) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showHighlightColor, r6.showHighlightColor) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFrontTitle() {
        return this.frontTitle;
    }

    public final Boolean getNarrowFont() {
        return this.narrowFont;
    }

    public final Boolean getShowHighlightColor() {
        return this.showHighlightColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r0 = this.frontTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.title.hashCode()) * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.narrowFont;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.showHighlightColor;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setFrontTitle(String r1) {
        this.frontTitle = r1;
    }

    public final void setNarrowFont(Boolean r1) {
        this.narrowFont = r1;
    }

    public final void setShowHighlightColor(Boolean r1) {
        this.showHighlightColor = r1;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "BigIslandTextInfo.toJSONObject: title=" + this.title + ", content=" + this.content);
        JSONObject r0 = new JSONObject();
        String r1 = this.frontTitle;
        if (r1 == null) goto L5;
        r0.put("frontTitle", r1);
    L5:
        r0.put("title", this.title);
        String r2 = this.content;
        if (r2 == null) goto L8;
        r0.put(Params.CONTENT, r2);
    L8:
        Boolean r3 = this.narrowFont;
        if (r3 == null) goto L11;
        r0.put("narrowFont", r3.booleanValue());
    L11:
        Boolean r4 = this.showHighlightColor;
        if (r4 == null) goto L14;
        r0.put("showHighlightColor", r4.booleanValue());
    L14:
        return r0;
    }

    public String toString() {
        return "BigIslandTextInfo(frontTitle=" + this.frontTitle + ", title=" + this.title + ", content=" + this.content + ", narrowFont=" + this.narrowFont + ", showHighlightColor=" + this.showHighlightColor + ')';
    }
}
