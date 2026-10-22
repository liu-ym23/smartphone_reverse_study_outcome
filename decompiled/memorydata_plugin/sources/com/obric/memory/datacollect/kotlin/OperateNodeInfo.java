package com.obric.memory.datacollect.kotlin;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003JY\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012¨\u00064"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/OperateNodeInfo;", "Ljava/io/Serializable;", "className", "", "desc", "hintText", OaidModel.KEY_ID, "", "isClickable", "", "parentId", "rect", "Lcom/obric/memory/datacollect/kotlin/Rect;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILcom/obric/memory/datacollect/kotlin/Rect;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getDesc", "setDesc", "getHintText", "setHintText", "getId", "()I", "setId", "(I)V", "()Z", "setClickable", "(Z)V", "getParentId", "setParentId", "getRect", "()Lcom/obric/memory/datacollect/kotlin/Rect;", "setRect", "(Lcom/obric/memory/datacollect/kotlin/Rect;)V", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class OperateNodeInfo implements Serializable {

    @SerializedName("className")
    private String className;

    @SerializedName("desc")
    private String desc;

    @SerializedName("hintText")
    private String hintText;

    @SerializedName(OaidModel.KEY_ID)
    private int id;

    @SerializedName("isClickable")
    private boolean isClickable;

    @SerializedName("parentId")
    private int parentId;

    @SerializedName("rect")
    private Rect rect;

    @SerializedName(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT)
    private String text;

    public OperateNodeInfo(String r2, String r3, String r4, int r5, boolean r6, int r7, Rect r8, String r9) {
        Intrinsics.checkParameterIsNotNull(r2, "className");
        Intrinsics.checkParameterIsNotNull(r3, "desc");
        Intrinsics.checkParameterIsNotNull(r4, "hintText");
        Intrinsics.checkParameterIsNotNull(r8, "rect");
        Intrinsics.checkParameterIsNotNull(r9, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.className = r2;
        this.desc = r3;
        this.hintText = r4;
        this.id = r5;
        this.isClickable = r6;
        this.parentId = r7;
        this.rect = r8;
        this.text = r9;
    }

    public static /* synthetic */ OperateNodeInfo copy$default(OperateNodeInfo r9, String r10, String r11, String r12, int r13, boolean r14, int r15, Rect r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.className;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.desc;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.hintText;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.id;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.isClickable;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.parentId;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Rect r8 = r9.rect;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.text;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.className;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.hintText;
    }

    public final int component4() {
        return this.id;
    }

    public final boolean component5() {
        return this.isClickable;
    }

    public final int component6() {
        return this.parentId;
    }

    public final Rect component7() {
        return this.rect;
    }

    public final String component8() {
        return this.text;
    }

    public final OperateNodeInfo copy(String r11, String r12, String r13, int r14, boolean r15, int r16, Rect r17, String r18) {
        Intrinsics.checkParameterIsNotNull(r11, "className");
        Intrinsics.checkParameterIsNotNull(r12, "desc");
        Intrinsics.checkParameterIsNotNull(r13, "hintText");
        Intrinsics.checkParameterIsNotNull(r17, "rect");
        Intrinsics.checkParameterIsNotNull(r18, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return new OperateNodeInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, OperateNodeInfo.class) == false) goto L23;
        OperateNodeInfo r4 = (OperateNodeInfo) ZeusTransformUtils.preCheckCast(r3, OperateNodeInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.className, r4.className) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.hintText, r4.hintText) == true) goto L13;
        return false;
    L13:
        if (this.id == r4.id) goto L15;
        return false;
    L15:
        if (this.isClickable == r4.isClickable) goto L17;
        return false;
    L17:
        if (this.parentId == r4.parentId) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.rect, r4.rect) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L35;
        return false;
    L35:
        return true;
    L23:
        return false;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final int getId() {
        return this.id;
    }

    public final int getParentId() {
        return this.parentId;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        String r0 = this.className;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.desc;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.hintText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.id)) * 31;
        boolean r10 = this.isClickable;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.parentId)) * 31;
        Rect r13 = this.rect;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.text;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
    L20:
        r14 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public final void setClassName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.className = r2;
    }

    public final void setClickable(boolean r1) {
        this.isClickable = r1;
    }

    public final void setDesc(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.desc = r2;
    }

    public final void setHintText(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.hintText = r2;
    }

    public final void setId(int r1) {
        this.id = r1;
    }

    public final void setParentId(int r1) {
        this.parentId = r1;
    }

    public final void setRect(Rect r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.rect = r2;
    }

    public final void setText(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.text = r2;
    }

    public String toString() {
        return "OperateNodeInfo(className=" + this.className + ", desc=" + this.desc + ", hintText=" + this.hintText + ", id=" + this.id + ", isClickable=" + this.isClickable + ", parentId=" + this.parentId + ", rect=" + this.rect + ", text=" + this.text + ")";
    }
}
