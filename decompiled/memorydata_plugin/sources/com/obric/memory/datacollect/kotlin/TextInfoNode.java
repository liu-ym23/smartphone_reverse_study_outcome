package com.obric.memory.datacollect.kotlin;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/TextInfoNode;", "Ljava/io/Serializable;", OaidModel.KEY_ID, "", ActivityLifecycle.NAME, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "desc", "hint", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getHint", "setHint", "getId", "()I", "setId", "(I)V", "getName", "setName", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class TextInfoNode implements Serializable {

    @SerializedName("desc")
    private String desc;

    @SerializedName("hint")
    private String hint;

    @SerializedName(OaidModel.KEY_ID)
    private int id;

    @SerializedName(ActivityLifecycle.NAME)
    private String name;

    @SerializedName(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT)
    private String text;

    public TextInfoNode(int r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkParameterIsNotNull(r3, ActivityLifecycle.NAME);
        this.id = r2;
        this.name = r3;
        this.text = r4;
        this.desc = r5;
        this.hint = r6;
    }

    public /* synthetic */ TextInfoNode(int r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r11 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L5:
        String r5 = r11;
        if ((r14 & 8) == 0) goto L8;
        r12 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L8:
        String r6 = r12;
        if ((r14 & 16) == 0) goto L11;
        r13 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L11:
        this(r9, r10, r5, r6, r13);
    }

    public static /* synthetic */ TextInfoNode copy$default(TextInfoNode r3, int r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.name;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.text;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.desc;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.hint;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.hint;
    }

    public final TextInfoNode copy(int r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r8, ActivityLifecycle.NAME);
        return new TextInfoNode(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, TextInfoNode.class) == false) goto L17;
        TextInfoNode r4 = (TextInfoNode) ZeusTransformUtils.preCheckCast(r3, TextInfoNode.class, "com.obric.memorydata.plugin");
        if (this.id == r4.id) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hint, r4.hint) == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.id) * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.text;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.desc;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.hint;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void setDesc(String r1) {
        this.desc = r1;
    }

    public final void setHint(String r1) {
        this.hint = r1;
    }

    public final void setId(int r1) {
        this.id = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.name = r2;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public String toString() {
        return "TextInfoNode(id=" + this.id + ", name=" + this.name + ", text=" + this.text + ", desc=" + this.desc + ", hint=" + this.hint + ")";
    }
}
