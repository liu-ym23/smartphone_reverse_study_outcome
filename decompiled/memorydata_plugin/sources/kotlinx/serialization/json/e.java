package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u007f\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\b\u0010!\u001a\u00020\nH\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "prettyPrintIndent", "", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZ)V", "getAllowSpecialFloatingPointValues", "()Z", "getAllowStructuredMapKeys", "getClassDiscriminator", "()Ljava/lang/String;", "getCoerceInputValues", "getEncodeDefaults", "getExplicitNulls$annotations", "()V", "getExplicitNulls", "getIgnoreUnknownKeys", "getPrettyPrint", "getPrettyPrintIndent$annotations", "getPrettyPrintIndent", "getUseAlternativeNames", "getUseArrayPolymorphism", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17833b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final String j;
    private final boolean k;
    private final boolean l;

    public e() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, 4095, null);
    }

    public e(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, String r8, boolean r9, boolean r10, String r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(r11, "classDiscriminator");
        this.f17832a = r2;
        this.f17833b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }

    public /* synthetic */ e(boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, String r21, boolean r22, boolean r23, String r24, boolean r25, boolean r26, int r27, DefaultConstructorMarker r28) {
        boolean r2 = false;
        if ((r27 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r27 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r27 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r27 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r27 & 16) == 0) goto L21;
        boolean r6 = false;
    L22:
        boolean r8 = true;
        if ((r27 & 32) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r9 = "    ";
    L31:
        if ((r27 & 128) == 0) goto L33;
        boolean r10 = false;
    L35:
        if ((r27 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r27 & 512) == 0) goto L41;
        String r12 = "type";
    L43:
        if ((r27 & 1024) != 0) goto L47;
        r2 = r25;
    L47:
        if ((r27 & 2048) != 0) goto L50;
        r8 = r26;
    L50:
        this(r1, r3, r4, r5, r6, r7, r9, r10, r11, r12, r2, r8);
        return;
    L41:
        r12 = r24;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L22
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }

    public final boolean a() {
        return this.f17833b;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.h;
    }

    public final boolean f() {
        return this.i;
    }

    public final String g() {
        return this.j;
    }

    public final boolean h() {
        return this.k;
    }

    public final boolean i() {
        return this.l;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("JsonConfiguration(encodeDefaults=").append(this.f17832a).append(", ignoreUnknownKeys=").append(this.f17833b).append(", isLenient=").append(this.c).append(", allowStructuredMapKeys=").append(this.d).append(", prettyPrint=").append(this.e).append(", explicitNulls=").append(this.f).append(", prettyPrintIndent='").append(this.g).append("', coerceInputValues=").append(this.h).append(", useArrayPolymorphism=").append(this.i).append(", classDiscriminator='").append(this.j).append("', allowSpecialFloatingPointValues=").append(this.k).append(')');
        return r0.toString();
    }
}
