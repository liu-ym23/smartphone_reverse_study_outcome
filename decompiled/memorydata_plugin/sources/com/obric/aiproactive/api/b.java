package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "", "title", "", "executeInstruction", "status", "", "format", "textField", "includeTitleField", "", "includeFormatField", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZ)V", "getTitle", "()Ljava/lang/String;", "getExecuteInstruction", "getStatus", "()I", "getFormat", "getTextField", "getIncludeTitleField", "()Z", "getIncludeFormatField", "isPending", "isContinue", "shouldLaunchAssistant", "getShouldLaunchAssistant", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6243b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final boolean g;
    private final boolean h;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem$Companion;", "", "<init>", "()V", "STATUS_PENDING", "", "STATUS_EXECUTED", "FORMAT_EXECUTE", "", "FORMAT_REPLY", "FORMAT_CONTINUE", "TEXT_FIELD_EXECUTE_INSTRUCTION", "TEXT_FIELD_CONTENT", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6242a = new a(null);
    }

    public b(String r2, String r3, int r4, String r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "executeInstruction");
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r6, "textField");
        this.f6243b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public /* synthetic */ b(String r10, String r11, int r12, String r13, String r14, boolean r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 4) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r17 & 8) == 0) goto L9;
        String r5 = "execute";
    L11:
        if ((r17 & 16) == 0) goto L13;
        String r6 = "execute_instruction";
    L15:
        if ((r17 & 32) == 0) goto L17;
        boolean r7 = true;
    L19:
        if ((r17 & 64) == 0) goto L21;
        boolean r8 = StringsKt.equals(r5, "continue", true);
    L22:
        this(r10, r11, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r16;
        goto L22
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public static /* synthetic */ b a(b r5, String r6, String r7, int r8, String r9, String r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.f6243b;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.c;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.d;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.e;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.f;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.g;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.h;
    L23:
        String r16 = r6;
        return r5.a(r16, r15, r0, r1, r2, r3, r12);
    }

    public final b a(String r9, String r10, int r11, String r12, String r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "executeInstruction");
        Intrinsics.checkNotNullParameter(r12, "format");
        Intrinsics.checkNotNullParameter(r13, "textField");
        return new b(r9, r10, r11, r12, r13, r14, r15);
    }

    public final String a() {
        return this.f6243b;
    }

    public final String b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6243b, r6.f6243b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L27;
        return false;
    L27:
        if (this.h == r6.h) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }

    public final boolean h() {
        if (this.d != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f6243b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    }

    public final boolean i() {
        return StringsKt.equals(this.e, "continue", true);
    }

    public final boolean j() {
        if (StringsKt.equals(this.e, "reply", true) == false) goto L5;
    L7:
        return false;
    L5:
        if (i() == true) goto L7;
        return true;
    }

    public String toString() {
        return "AiProactiveActionExecuteItem(title=" + this.f6243b + ", executeInstruction=" + this.c + ", status=" + this.d + ", format=" + this.e + ", textField=" + this.f + ", includeTitleField=" + this.g + ", includeFormatField=" + this.h + ')';
    }
}
