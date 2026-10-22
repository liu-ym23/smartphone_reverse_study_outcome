package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/dd1;", "", "", "firstTitle", "Ljava/lang/String;", "getFirstTitle", "()Ljava/lang/String;", "setFirstTitle", "(Ljava/lang/String;)V", "secondTitleHasTest", "getSecondTitleHasTest", "setSecondTitleHasTest", "secondTitleNoTest", "getSecondTitleNoTest", "setSecondTitleNoTest", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class dd1 {

    @SerializedName("first_title")
    private String firstTitle;

    @SerializedName("second_title_has_test")
    private String secondTitleHasTest;

    @SerializedName("second_title_no_test")
    private String secondTitleNoTest;

    public dd1() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof dd1) == false) goto L12;
        dd1 r4 = (dd1) r3;
        if (Intrinsics.areEqual(this.firstTitle, r4.firstTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secondTitleHasTest, r4.secondTitleHasTest) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secondTitleNoTest, r4.secondTitleNoTest) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.firstTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.secondTitleHasTest;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.secondTitleNoTest;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSingStageConfig(firstTitle=" + this.firstTitle + ", secondTitleHasTest=" + this.secondTitleHasTest + ", secondTitleNoTest=" + this.secondTitleNoTest + ")";
    }

    public dd1(int r1) {
        this.firstTitle = "你点我唱";
        this.secondTitleHasTest = "欢迎选择嘉宾送礼试音/点唱";
        this.secondTitleNoTest = "欢迎选择嘉宾送礼点唱";
    }
}
