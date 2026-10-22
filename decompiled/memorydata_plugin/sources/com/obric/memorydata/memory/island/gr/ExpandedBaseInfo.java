package com.obric.memorydata.memory.island.gr;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedBaseInfo;", "", "type", "", "title", "", Params.CONTENT, "colorTitle", "colorContent", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "getColorTitle", "setColorTitle", "getColorContent", "setColorContent", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedBaseInfo {
    private String colorContent;
    private String colorTitle;
    private String content;
    private String title;
    private int type;

    public ExpandedBaseInfo(int r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        this.type = r2;
        this.title = r3;
        this.content = r4;
        this.colorTitle = r5;
        this.colorContent = r6;
    }

    public /* synthetic */ ExpandedBaseInfo(int r7, String r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 1;
    L5:
        int r1 = r7;
        if ((r12 & 8) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        String r5 = null;
    L13:
        this(r1, r8, r9, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public static /* synthetic */ ExpandedBaseInfo copy$default(ExpandedBaseInfo r3, int r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
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
        r7 = r3.colorTitle;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.colorContent;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.colorTitle;
    }

    public final String component5() {
        return this.colorContent;
    }

    public final ExpandedBaseInfo copy(int r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        return new ExpandedBaseInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedBaseInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedBaseInfo r6 = (ExpandedBaseInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedBaseInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.colorTitle, r6.colorTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.colorContent, r6.colorContent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getColorContent() {
        return this.colorContent;
    }

    public final String getColorTitle() {
        return this.colorTitle;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.type) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31;
        String r1 = this.colorTitle;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.colorContent;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setColorContent(String r1) {
        this.colorContent = r1;
    }

    public final void setColorTitle(String r1) {
        this.colorTitle = r1;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedBaseInfo.toJSONObject: title=" + this.title + ", content=" + StringsKt.take(this.content, 30));
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        r0.put("title", this.title);
        r0.put(Params.CONTENT, this.content);
        String r1 = this.colorTitle;
        if (r1 == null) goto L5;
        r0.put("colorTitle", r1);
    L5:
        String r4 = this.colorContent;
        if (r4 == null) goto L8;
        r0.put("colorContent", r4);
    L8:
        return r0;
    }

    public String toString() {
        return "ExpandedBaseInfo(type=" + this.type + ", title=" + this.title + ", content=" + this.content + ", colorTitle=" + this.colorTitle + ", colorContent=" + this.colorContent + ')';
    }
}
