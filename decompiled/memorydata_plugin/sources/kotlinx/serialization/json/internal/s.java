package kotlinx.serialization.json.internal;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", AILabCheckPermissionTask.KEY_SOURCE, "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "canConsumeValue", "", "consumeKeyString", "consumeLeadingMatchingValue", "keyToMatch", "isLenient", "consumeNextToken", "", "", "expected", "", "prefetchOrEof", "", "position", "skipWhitespaces", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class s extends a {
    private final String c;

    public s(String r2) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        this.c = r2;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int a(int r1) {
        if (r1 < j().length()) goto L7;
        return -1;
    L7:
        return r1;
    }

    @Override // kotlinx.serialization.json.internal.a
    public /* synthetic */ CharSequence a() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(j(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.json.internal.a
    public void b(char r4) {
        if (this.f17837a != (-1)) goto L5;
        c(r4);
    L5:
        String r0 = j();
    L7:
        if (this.f17837a >= r0.length()) goto L20;
        int r1 = this.f17837a;
        this.f17837a = r1 + 1;
        char r2 = r0.charAt(r1);
        if (r2 == ' ') goto L7;
        if (r2 == '\n') goto L7;
        if (r2 == '\r') goto L7;
        if (r2 == '\t') goto L7;
        if (r2 == r4) goto L18;
        c(r4);
        goto L7
    L18:
        return;
    L20:
        c(r4);
    }

    @Override // kotlinx.serialization.json.internal.a
    public boolean c() {
        int r0 = this.f17837a;
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 >= j().length()) goto L19;
        char r2 = j().charAt(r0);
        if (r2 == ' ') goto L18;
        if (r2 == '\n') goto L18;
        if (r2 == '\r') goto L18;
        if (r2 == '\t') goto L18;
        this.f17837a = r0;
        return a(r2);
    L18:
        r0 = r0 + 1;
        goto L6
    L19:
        this.f17837a = r0;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.a
    public byte d() {
        String r0 = j();
    L4:
        if (this.f17837a == (-1)) goto L10;
        if (this.f17837a >= r0.length()) goto L16;
        int r1 = this.f17837a;
        this.f17837a = r1 + 1;
        byte r2 = b.a(r0.charAt(r1));
        if (r2 == 3) goto L4;
        return r2;
    L16:
        return 10;
    L10:
        return 10;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int f() {
        int r0 = this.f17837a;
        if (r0 != (-1)) goto L6;
        return r0;
    L6:
        if (r0 >= j().length()) goto L16;
        char r1 = j().charAt(r0);
        if (r1 == ' ') goto L15;
        if (r1 == '\n') goto L15;
        if (r1 == '\r') goto L15;
        if (r1 != '\t') goto L16;
    L15:
        r0 = r0 + 1;
    L16:
        this.f17837a = r0;
        return r0;
    }

    @Override // kotlinx.serialization.json.internal.a
    public String g() {
        b(Typography.quote);
        int r0 = this.f17837a;
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(j(), CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, r0, false, 4, null);
        if (r1 == (-1)) goto L13;
        int r2 = r0;
    L5:
        if (r2 >= r1) goto L11;
        if (j().charAt(r2) == '\\') goto L9;
        r2 = r2 + 1;
        goto L5
    L9:
        return a((CharSequence) ZeusTransformUtils.preCheckCast(j(), CharSequence.class, "com.obric.memorydata.plugin"), this.f17837a, r2);
    L11:
        this.f17837a = r1 + 1;
        String r8 = j().substring(r0, r1);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        return r8;
    L13:
        b((byte) 1);
        throw new KotlinNothingValueException();
    }

    public String j() {
        return this.c;
    }
}
