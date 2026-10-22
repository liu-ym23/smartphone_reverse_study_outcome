package kotlinx.serialization.json.internal;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020 H&J\u0006\u0010!\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0004H\u0003J\u0006\u0010#\u001a\u00020 J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u000fH&J\u001a\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020 H&J\b\u0010*\u001a\u00020+H&J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u000fJ \u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0005J\u0006\u00101\u001a\u00020\u000fJ\u0006\u00102\u001a\u00020\u000fJ\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u00104\u001a\u00020\u001cH\u0016J\u0006\u00105\u001a\u00020\u001cJ\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u00020+H\u0000¢\u0006\u0002\b9J\"\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u000fJ\u0018\u0010?\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0006\u0010B\u001a\u00020 J\u0010\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020-H\u0004J\u0006\u0010E\u001a\u00020+J\u0010\u0010F\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020 J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004H&J1\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020 2\b\b\u0002\u0010;\u001a\u00020\u00042\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f0JH\u0080\bø\u0001\u0000¢\u0006\u0002\bKJ\u000e\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020 J\b\u0010N\u001a\u00020\u0004H\u0016J\u0018\u0010O\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u000fH\u0002J\b\u0010R\u001a\u00020\u000fH\u0016J\b\u0010S\u001a\u00020 H&J\u0006\u0010T\u001a\u00020 J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0004J\b\u0010V\u001a\u00020 H\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0011X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006W"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "()V", "currentPosition", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "", AILabCheckPermissionTask.KEY_SOURCE, "", "getSource", "()Ljava/lang/CharSequence;", "appendEsc", "startPosition", "appendEscape", "lastPosition", "current", "appendHex", "startPos", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeBoolean", CommonConsts.APM_INNER_EVENT_COST_START, "consumeBooleanLenient", "consumeBooleanLiteral", "literalSuffix", "consumeKeyString", "consumeLeadingMatchingValue", "keyToMatch", "isLenient", "consumeNextToken", "", "expected", "", "consumeNumericLiteral", "", "consumeString", "consumeStringLenient", "consumeStringLenientNotNull", "decodedString", "ensureHaveChars", "expectEof", "fail", "", "expectedToken", "fail$kotlinx_serialization_json", "message", "position", "hint", "failOnUnknownKey", "key", "fromHexChar", "indexOf", "char", "isNotEof", "isValidValueStart", "c", "peekNextToken", "peekString", "prefetchOrEof", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "skipElement", "allowLenientStrings", "skipWhitespaces", "substring", "endPos", "takePeeked", "toString", "tryConsumeComma", "tryConsumeNotNull", "unexpectedToken", "wasUnquotedString", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f17837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f17838b;
    private String c;
    private StringBuilder d;

    public a() {
        this.f17838b = new l();
        this.d = new StringBuilder();
    }

    private final int a(CharSequence r7, int r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r8 + 4;
        if (r0 < r9.length()) goto L10;
        this.f17837a = r8;
        b();
        if ((this.f17837a + 4) < r9.length()) goto L7;
        a(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L7:
        return a(r9, this.f17837a);
    L10:
        this.d.append((char) ((((b(r9, r8) << 12) + (b(r9, r8 + 1) << 8)) + (b(r9, r8 + 2) << 4)) + b(r9, r8 + 3)));
        return r0;
    }

    public static final /* synthetic */ int a(a r0) {
        return r0.f17837a;
    }

    public static /* synthetic */ Void a(a r0, String r1, int r2, String r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = r0.f17837a;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = "";
    L10:
        return r0.a(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    private final int b(int r7) {
        int r8 = a(r7);
        if (r8 == (-1)) goto L14;
        int r1 = r8 + 1;
        char r9 = a().charAt(r8);
        if (r9 == 'u') goto L7;
        char r0 = b.a(r9);
        if (r0 == 0) goto L12;
        this.d.append(r0);
        return r1;
    L12:
        a(this, "Invalid escaped char '" + r9 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    L7:
        return a(a(), r1);
    L14:
        a(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int b(CharSequence r7, int r8) {
        char r9 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin")).charAt(r8);
        boolean r0 = true;
        if ('0' <= r9) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L26;
        char r10 = 'a';
        if ('a' <= r9) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L29;
        r10 = 'A';
        if ('A' <= r9) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == true) goto L29;
        a(this, "Invalid toHexChar char '" + r9 + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L21:
        if (r9 >= 'G') goto L23;
    L29:
        return (r9 - r10) + 10;
    L13:
        if (r9 >= 'g') goto L15;
        r3 = true;
        goto L16
    L26:
        return r9 - '0';
    L5:
        if (r9 >= ':') goto L7;
        r2 = true;
        goto L8
    }

    private final int c(int r1, int r2) {
        b(r1, r2);
        return b(r2 + 1);
    }

    private final String d(int r1, int r2) {
        b(r1, r2);
        String r3 = this.d.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "escapedString.toString()");
        this.d.setLength(0);
        return r3;
    }

    private final String j() {
        String r0 = this.c;
        Intrinsics.checkNotNull(r0);
        this.c = null;
        return r0;
    }

    public final byte a(byte r2) {
        byte r0 = d();
        if (r0 != r2) goto L5;
        return r0;
    L5:
        b(r2);
        throw new KotlinNothingValueException();
    }

    public abstract int a(int r1);

    public abstract CharSequence a();

    public String a(int r1, int r2) {
        return a().subSequence(r1, r2).toString();
    }

    public final String a(CharSequence r12, int r13, int r14) {
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, AILabCheckPermissionTask.KEY_SOURCE);
        char r0 = r15.charAt(r14);
        boolean r1 = false;
    L4:
        if (r0 == '\"') goto L20;
        if (r0 != '\\') goto L12;
        int r7 = a(c(r13, r14));
        if (r7 == (-1)) goto L10;
    L9:
        r1 = true;
        r13 = r7;
        r14 = r13;
    L19:
        r0 = r15.charAt(r14);
        goto L4
    L10:
        a(this, "EOF", r7, null, 4, null);
        throw new KotlinNothingValueException();
    L12:
        r14 = r14 + 1;
        if (r14 < r15.length()) goto L19;
        b(r13, r14);
        r7 = a(r14);
        if (r7 != (-1)) goto L9;
        a(this, "EOF", r7, null, 4, null);
        throw new KotlinNothingValueException();
    L20:
        if (r1 == true) goto L22;
        String r16 = a(r13, r14);
    L23:
        this.f17837a = r14 + 1;
        return r16;
    L22:
        r16 = d(r13, r14);
        goto L23
    }

    public final Void a(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r5, "hint");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r6 = "";
    L10:
        throw j.a(r4, r3 + " at path: " + this.f17838b.a() + r6, a());
    L8:
        r6 = '\n' + r5;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(char r3) {
        boolean r2 = false;
        if (r3 != '}') goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
    L10:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
    L16:
        r2 = true;
    L21:
        return !r2;
    L18:
        if (r3 != ',') goto L21;
    L12:
        if (r3 == ':') goto L10;
        r4 = false;
        goto L15
    L6:
        if (r3 == ']') goto L4;
        r1 = false;
        goto L9
    }

    public final Void b(byte r8) {
        if (r8 != 1) goto L6;
        String r9 = "quotation mark '\"'";
    L25:
        if (this.f17837a != a().length()) goto L27;
    L30:
        String r1 = "EOF";
    L31:
        a(this, "Expected " + r9 + ", but had '" + r1 + "' instead", this.f17837a - 1, null, 4, null);
        throw new KotlinNothingValueException();
    L27:
        if (this.f17837a <= 0) goto L30;
        r1 = String.valueOf(a().charAt(this.f17837a - 1));
        goto L31
    L6:
        if (r8 != 4) goto L9;
        r9 = "comma ','";
        goto L25
    L9:
        if (r8 != 5) goto L12;
        r9 = "colon ':'";
        goto L25
    L12:
        if (r8 != 6) goto L15;
        r9 = "start of the object '{'";
        goto L25
    L15:
        if (r8 != 7) goto L18;
        r9 = "end of the object '}'";
        goto L25
    L18:
        if (r8 != 8) goto L21;
        r9 = "start of the array '['";
        goto L25
    L21:
        if (r8 != 9) goto L23;
        r9 = "end of the array ']'";
        goto L25
    L23:
        r9 = "valid token";
        goto L25
    }

    public void b() {
    }

    public void b(char r5) {
        b();
        CharSequence r0 = a();
        int r1 = this.f17837a;
    L3:
        int r2 = a(r1);
        if (r2 == (-1)) goto L19;
        int r3 = r2 + 1;
        char r4 = r0.charAt(r2);
        if (r4 == ' ') goto L18;
        if (r4 == '\n') goto L18;
        if (r4 == '\r') goto L18;
        if (r4 == '\t') goto L18;
        this.f17837a = r3;
        if (r4 == r5) goto L16;
        c(r5);
        goto L18
    L16:
        return;
    L18:
        r1 = r3;
        goto L3
    L19:
        this.f17837a = r2;
        c(r5);
    }

    public void b(int r2, int r3) {
        this.d.append(a(), r2, r3);
    }

    public final void c(char r3) {
        int r0 = this.f17837a - 1;
        this.f17837a = r0;
        if (r0 >= 0) goto L5;
    L10:
        b(b.a(r3));
        throw new KotlinNothingValueException();
    L5:
        if (r3 != '\"') goto L10;
        if (Intrinsics.areEqual(i(), "null") == false) goto L10;
        a("Expected string literal but 'null' literal was found", this.f17837a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
        throw new KotlinNothingValueException();
    }

    public abstract boolean c();

    public abstract byte d();

    public final byte e() {
        CharSequence r0 = a();
        int r1 = this.f17837a;
    L3:
        int r2 = a(r1);
        if (r2 == (-1)) goto L16;
        char r3 = r0.charAt(r2);
        if (r3 == ' ') goto L15;
        if (r3 == '\n') goto L15;
        if (r3 == '\r') goto L15;
        if (r3 == '\t') goto L15;
        this.f17837a = r2;
        return b.a(r3);
    L15:
        r1 = r2 + 1;
        goto L3
    L16:
        this.f17837a = r2;
        return 10;
    }

    public int f() {
        int r0 = this.f17837a;
    L3:
        int r1 = a(r0);
        if (r1 == (-1)) goto L14;
        char r2 = a().charAt(r1);
        if (r2 == ' ') goto L13;
        if (r2 == '\n') goto L13;
        if (r2 == '\r') goto L13;
        if (r2 != '\t') goto L14;
    L13:
        r0 = r1 + 1;
    L14:
        this.f17837a = r1;
        return r1;
    }

    public abstract String g();

    public final String h() {
        if (this.c == null) goto L7;
        return j();
    L7:
        return g();
    }

    public final String i() {
        if (this.c != null) goto L5;
        int r2 = f();
        if (r2 < a().length()) goto L9;
    L33:
        a(this, "EOF", r2, null, 4, null);
        throw new KotlinNothingValueException();
    L9:
        if (r2 == (-1)) goto L33;
        byte r1 = b.a(a().charAt(r2));
        if (r1 == 1) goto L13;
        if (r1 != 0) goto L31;
        boolean r4 = false;
    L17:
        if (b.a(a().charAt(r2)) != 0) goto L25;
        r2 = r2 + 1;
        if (r2 < a().length()) goto L17;
        b(this.f17837a, r2);
        int r5 = a(r2);
        if (r5 == (-1)) goto L22;
        r2 = r5;
        r4 = true;
        goto L17
    L22:
        this.f17837a = r2;
        return d(0, 0);
    L25:
        int r0 = this.f17837a;
        if (r4 == true) goto L28;
        String r3 = a(r0, r2);
    L29:
        this.f17837a = r2;
        return r3;
    L28:
        r3 = d(r0, r2);
        goto L29
    L31:
        a(this, "Expected beginning of the string, but got " + a().charAt(r2), 0, null, 6, null);
        throw new KotlinNothingValueException();
    L13:
        return h();
    L5:
        return j();
    }

    public String toString() {
        return "JsonReader(source='" + a() + "', currentPosition=" + this.f17837a + ')';
    }
}
