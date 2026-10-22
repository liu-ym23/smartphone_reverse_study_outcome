package s7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("biz_name")
    private final String f12734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("loraType")
    private final String f12735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("reject_thresh")
    private final int f12736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("warn_thresh")
    private final int f12737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d6.c("callType")
    private final int f12738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d6.c("quota_dur_in_sec")
    private final String f12739f;

    public j(String r10, String r11, int r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        this.f12734a = r10;
        this.f12735b = r11;
        this.f12736c = r12;
        this.f12737d = r13;
        this.f12738e = r14;
        this.f12739f = r15;
    }

    public /* synthetic */ j(String r10, String r11, int r12, int r13, int r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = null;
    L5:
        String r18 = r11;
        if ((r16 & 16) == 0) goto L8;
        r14 = 0;
    L8:
        int r19 = r14;
        if ((r16 & 32) == 0) goto L11;
        r15 = "300";
    L11:
        this(r10, r18, r12, r13, r19, r15);
    }

    public static /* synthetic */ j b(j r10, String r11, String r12, int r13, int r14, int r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.f12734a;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.f12735b;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.f12736c;
    L11:
        int r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.f12737d;
    L14:
        int r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.f12738e;
    L17:
        int r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.f12739f;
    L20:
        String r23 = r11;
        return r10.a(r23, r19, r20, r21, r22, r16);
    }

    public final j a(String r10, String r11, int r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        return new j(r10, r11, r12, r13, r14, r15);
    }

    public final String c() {
        return this.f12734a;
    }

    public final int d() {
        return this.f12738e;
    }

    public final String e() {
        return this.f12735b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(j.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aikernel.middleware.api.settings.NativeModelQuotaMappingConfig");
        j r12 = (j) r10;
        if (Intrinsics.areEqual(this.f12734a, r12.f12734a) == false) goto L20;
        if (Intrinsics.areEqual(this.f12735b, r12.f12735b) == false) goto L20;
        if (this.f12738e != r12.f12738e) goto L20;
        return true;
    L20:
        return false;
    L8:
        r11 = null;
        goto L10
    }

    public final String f() {
        return this.f12739f;
    }

    public final int g() {
        return this.f12736c;
    }

    public final int h() {
        return this.f12737d;
    }

    public int hashCode() {
        return this.f12734a.hashCode();
    }

    public final int i(int r10) {
        String r11 = this.f12739f;
        if (r11 == null) goto L26;
        String r12 = StringsKt.trim(r11).toString();
        if (r12 == null) goto L27;
        boolean r13 = true;
        if (r12.length() <= 0) goto L9;
        boolean r14 = true;
    L10:
        Integer r15 = null;
        if (r14 == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L28;
        Integer r16 = StringsKt.toIntOrNull(r12);
        if (r16 != null) goto L18;
        return r10;
    L18:
        if (r16.intValue() > 0) goto L21;
        r13 = false;
    L21:
        if (r13 == false) goto L23;
        r15 = r16;
    L23:
        if (r15 != null) goto L25;
        return r10;
    L25:
        return r15.intValue();
    L28:
        return r10;
    L9:
        r14 = false;
        goto L10
    L27:
        return r10;
    L26:
        return r10;
    }

    public String toString() {
        String r10 = this.f12739f;
        Integer r11 = null;
        if (r10 == null) goto L16;
        String r12 = StringsKt.trim(r10).toString();
        if (r12 == null) goto L16;
        if (r12.length() <= 0) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == true) goto L13;
        r12 = null;
    L13:
        if (r12 == null) goto L16;
        r11 = StringsKt.toIntOrNull(r12);
        goto L16
    L9:
        r13 = false;
    L16:
        return this.f12734a + '#' + this.f12735b + '#' + this.f12738e + " rejectThresh=" + this.f12736c + ", warnThresh=" + this.f12737d + ", quotaDurInSecRaw=" + this.f12739f + ", quotaDurInSecParsed=" + r11;
    }
}
