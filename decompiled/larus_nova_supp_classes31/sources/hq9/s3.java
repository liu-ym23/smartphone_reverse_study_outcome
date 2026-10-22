package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001b\u001a\u00020\u0007J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/platform/model/OriginTextCheckItem;", "", "monitorItemType", "", "exceptionType", "regex", "needSecondVerification", "", "secondVerificationRegex", "secondVerificationInvalidRegex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getMonitorItemType", "()Ljava/lang/String;", "getExceptionType", "getRegex", "getNeedSecondVerification", "()Z", "getSecondVerificationRegex", "getSecondVerificationInvalidRegex", "patternCache", "Lkotlin/text/Regex;", "secondVerificationPatternCache", "secondVerificationInvalidPatternCache", "getPattern", "getSecondVerificationPattern", "getSecondVerificationInvalidPattern", "isValid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class s3 {
    public Regex a;
    public Regex b;
    public Regex c;

    @SerializedName("exception_type")
    private final String exceptionType;

    @SerializedName("monitor_item_type")
    private final String monitorItemType;

    @SerializedName("need_second_verification")
    private final boolean needSecondVerification;

    @SerializedName("regex")
    private final String regex;

    @SerializedName("second_verification_invalid_regex")
    private final String secondVerificationInvalidRegex;

    @SerializedName("second_verification_regex")
    private final String secondVerificationRegex;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s3) == true) goto L8;
        return false;
    L8:
        s3 r6 = (s3) r5;
        if (Intrinsics.areEqual(this.monitorItemType, r6.monitorItemType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exceptionType, r6.exceptionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.regex, r6.regex) == true) goto L18;
        return false;
    L18:
        if (this.needSecondVerification == r6.needSecondVerification) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secondVerificationRegex, r6.secondVerificationRegex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secondVerificationInvalidRegex, r6.secondVerificationInvalidRegex) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.monitorItemType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.exceptionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.regex;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.needSecondVerification == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.secondVerificationRegex;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.secondVerificationInvalidRegex;
        if (r15 == null) goto L27;
        r1 = r15.hashCode();
    L27:
        return r14 + r1;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
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

    public final String toString() {
        return "OriginTextCheckItem(monitorItemType=" + this.monitorItemType + ", exceptionType=" + this.exceptionType + ", regex=" + this.regex + ", needSecondVerification=" + this.needSecondVerification + ", secondVerificationRegex=" + this.secondVerificationRegex + ", secondVerificationInvalidRegex=" + this.secondVerificationInvalidRegex + ')';
    }

    public final Regex d() {
        if (this.a != null) goto L14;
        String r0 = this.regex;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        this.a = new Regex(this.regex);
        goto L14
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L14:
        return this.a;
    }

    public final Regex e() {
        if (this.c != null) goto L14;
        String r0 = this.secondVerificationInvalidRegex;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        this.c = new Regex(this.secondVerificationInvalidRegex);
        goto L14
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L14:
        return this.c;
    }

    public final Regex f() {
        if (this.b != null) goto L14;
        String r0 = this.secondVerificationRegex;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        this.b = new Regex(this.secondVerificationRegex);
        goto L14
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L14:
        return this.b;
    }

    public final boolean g() {
        String r0 = this.monitorItemType;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L28;
        String r2 = this.exceptionType;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L29;
        String r4 = this.regex;
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (StringsKt.isBlank(r4) == true) goto L24;
        r5 = false;
        goto L25
    L29:
        return false;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r3 = false;
        goto L17
    L28:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public s3() {
        this.monitorItemType = null;
        this.exceptionType = null;
        this.regex = null;
        this.needSecondVerification = false;
        this.secondVerificationRegex = null;
        this.secondVerificationInvalidRegex = null;
    }

    public final String a() {
        return this.exceptionType;
    }

    public final String b() {
        return this.monitorItemType;
    }

    public final boolean c() {
        return this.needSecondVerification;
    }
}
