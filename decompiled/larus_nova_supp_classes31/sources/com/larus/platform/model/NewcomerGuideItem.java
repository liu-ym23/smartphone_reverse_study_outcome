package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/NewcomerGuideItem;", "Ljava/io/Serializable;", "id", "", "titleKey", "type", "actionValue", "titleText", "isLoading", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getTitleKey", "getType", "getActionValue", "getTitleText", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class NewcomerGuideItem implements Serializable {

    @SerializedName("action_value")
    private final String actionValue;

    @SerializedName("id")
    private final String id;
    private final boolean isLoading;

    @SerializedName("title_key")
    private final String titleKey;

    @SerializedName("title_text")
    private final String titleText;

    @SerializedName("type")
    private final String type;

    public NewcomerGuideItem() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ NewcomerGuideItem copy$default(NewcomerGuideItem r4, String r5, String r6, String r7, String r8, String r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.titleKey;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.type;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.actionValue;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.titleText;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isLoading;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.titleKey;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.actionValue;
    }

    public final String component5() {
        return this.titleText;
    }

    public final boolean component6() {
        return this.isLoading;
    }

    public final NewcomerGuideItem copy(String r9, String r10, String r11, String r12, String r13, boolean r14) {
        return new NewcomerGuideItem(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NewcomerGuideItem) == true) goto L8;
        return false;
    L8:
        NewcomerGuideItem r6 = (NewcomerGuideItem) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleKey, r6.titleKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionValue, r6.actionValue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleText, r6.titleText) == true) goto L24;
        return false;
    L24:
        if (this.isLoading == r6.isLoading) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.titleKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.type;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.actionValue;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.titleText;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        if (this.isLoading == false) goto L25;
        int r15 = 1231;
    L27:
        return r14 + r15;
    L25:
        r15 = 1237;
        goto L27
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public String toString() {
        return "NewcomerGuideItem(id=" + this.id + ", titleKey=" + this.titleKey + ", type=" + this.type + ", actionValue=" + this.actionValue + ", titleText=" + this.titleText + ", isLoading=" + this.isLoading + ')';
    }

    public final String getActionValue() {
        return this.actionValue;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitleKey() {
        return this.titleKey;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public NewcomerGuideItem(String r1, String r2, String r3, String r4, String r5, boolean r6) {
        this.id = r1;
        this.titleKey = r2;
        this.type = r3;
        this.actionValue = r4;
        this.titleText = r5;
        this.isLoading = r6;
    }

    public /* synthetic */ NewcomerGuideItem(String r5, String r6, String r7, String r8, String r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        String r0 = null;
        if ((r11 & 1) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r11 & 16) != 0) goto L23;
        r0 = r9;
    L23:
        if ((r11 & 32) == 0) goto L25;
        boolean r14 = false;
    L26:
        this(r13, r1, r2, r3, r0, r14);
        return;
    L25:
        r14 = r10;
        goto L26
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
