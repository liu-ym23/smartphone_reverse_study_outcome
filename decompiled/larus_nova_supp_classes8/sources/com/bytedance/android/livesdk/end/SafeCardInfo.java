package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J!\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "Lyu1/a;", "", "component1", "component2", "template", "data", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTemplate", "()Ljava/lang/String;", "setTemplate", "(Ljava/lang/String;)V", "getData", "setData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SafeCardInfo extends a {

    @SerializedName("data")
    private String data;

    @SerializedName("template")
    private String template;

    public SafeCardInfo() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ SafeCardInfo copy$default(SafeCardInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.template;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.template;
    }

    public final String component2() {
        return this.data;
    }

    public final SafeCardInfo copy(String r2, String r3) {
        return new SafeCardInfo(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SafeCardInfo) == false) goto L10;
        SafeCardInfo r4 = (SafeCardInfo) r3;
        if (Intrinsics.areEqual(this.template, r4.template) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.template;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.data;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SafeCardInfo(template=" + this.template + ", data=" + this.data + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final void setData(String r1) {
        this.data = r1;
    }

    public final void setTemplate(String r1) {
        this.template = r1;
    }

    public SafeCardInfo(String r1, String r2) {
        this.template = r1;
        this.data = r2;
    }

    public /* synthetic */ SafeCardInfo(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
