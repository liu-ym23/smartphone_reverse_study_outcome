package com.larus.suggest.impl.popup.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\bHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/larus/suggest/impl/popup/model/PopWindowCommonBizData;", "", "showMessageValue", "Lcom/google/gson/JsonElement;", "isSuccessValue", "<init>", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "showMessage", "", "getShowMessage", "()Ljava/lang/String;", "isSuccess", "", "()Ljava/lang/Boolean;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PopWindowCommonBizData {

    @SerializedName("is_success")
    private final JsonElement isSuccessValue;

    @SerializedName("show_message")
    private final JsonElement showMessageValue;

    public PopWindowCommonBizData() {
        JsonElement r0 = null;
        this(r0, r0, 3, r0);
    }

    private final JsonElement component1() {
        return this.showMessageValue;
    }

    private final JsonElement component2() {
        return this.isSuccessValue;
    }

    public static /* synthetic */ PopWindowCommonBizData copy$default(PopWindowCommonBizData r0, JsonElement r1, JsonElement r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.showMessageValue;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isSuccessValue;
    L9:
        return r0.copy(r1, r2);
    }

    public final PopWindowCommonBizData copy(JsonElement r2, JsonElement r3) {
        return new PopWindowCommonBizData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowCommonBizData) == true) goto L8;
        return false;
    L8:
        PopWindowCommonBizData r6 = (PopWindowCommonBizData) r5;
        if (Intrinsics.areEqual(this.showMessageValue, r6.showMessageValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSuccessValue, r6.isSuccessValue) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        JsonElement r0 = this.showMessageValue;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JsonElement r4 = this.isSuccessValue;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowCommonBizData(showMessageValue=" + this.showMessageValue + ", isSuccessValue=" + this.isSuccessValue + ')';
    }

    public final String getShowMessage() {
        return a.a(this.showMessageValue);
    }

    public final Boolean isSuccess() {
        String r0 = a.a(this.isSuccessValue);
        if (r0 == null) goto L32;
        String r1 = StringsKt.trim(r0).toString();
        if (r1 == null) goto L32;
        String r2 = r1.toLowerCase(Locale.ROOT);
        if (r2 == null) goto L32;
        int r3 = r2.hashCode();
        if (r3 == 48) goto L29;
        if (r3 == 49) goto L25;
        if (r3 == 3569038) goto L22;
        if (r3 != 97196323) goto L32;
        if (r2.equals("false") == false) goto L32;
    L35:
        return Boolean.FALSE;
    L22:
        if (r2.equals("true") == false) goto L32;
    L34:
        return Boolean.TRUE;
    L25:
        if (r2.equals("1") == true) goto L34;
    L29:
        if (r2.equals("0") == true) goto L35;
    L32:
        return null;
    }

    public PopWindowCommonBizData(JsonElement r1, JsonElement r2) {
        this.showMessageValue = r1;
        this.isSuccessValue = r2;
    }

    public /* synthetic */ PopWindowCommonBizData(JsonElement r2, JsonElement r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
