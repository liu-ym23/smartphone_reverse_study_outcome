package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import ouc.f;
import ouc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g0 {
    public final a a;
    public final boolean b;
    public final boolean c;
    public int d;

    public final ouc.i b() {
        byte r0 = this.a.r();
        if (r0 != 1) goto L6;
        return d(true);
    L6:
        if (r0 != 0) goto L9;
        return d(false);
    L9:
        if (r0 != 6) goto L41;
        int r1 = this.d + 1;
        this.d = r1;
        if (r1 != 200) goto L13;
        ouc.i r2 = (ouc.i) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader.readDeepRecursive.1(this, null)), Unit.INSTANCE);
    L37:
        this.d--;
        return r2;
    L13:
        byte r3 = this.a.f((byte) 6);
        if (this.a.r() == 4) goto L38;
        LinkedHashMap r4 = new LinkedHashMap();
    L17:
        if (this.a.b() == false) goto L28;
        if (this.b == false) goto L21;
        String r5 = this.a.j();
    L22:
        this.a.f((byte) 5);
        r4.put(r5, b());
        r3 = this.a.e();
        if (r3 == 4) goto L17;
        if (r3 == 7) goto L28;
        a.m(this.a, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L21:
        r5 = this.a.i();
    L28:
        if (r3 != 6) goto L30;
        this.a.f((byte) 7);
    L36:
        r2 = new ouc.d0(r4);
        goto L37
    L30:
        if (r3 != 4) goto L36;
        if (this.c == false) goto L34;
        this.a.f((byte) 7);
        goto L36
    L34:
        s.e(this.a, "object");
        throw null;
    L38:
        a.m(this.a, "Unexpected leading comma", 0, null, 6);
        throw null;
    L41:
        if (r0 == 8) goto L43;
        a.m(this.a, "Cannot read Json element because of unexpected ".concat(b.b(r0)), 0, null, 6);
        throw null;
    L43:
        return c();
    }

    public final ouc.b c() {
        byte r0 = this.a.e();
        if (this.a.r() == 4) goto L29;
        ArrayList r1 = new ArrayList();
    L6:
        if (this.a.b() == false) goto L19;
        r1.add(b());
        r0 = this.a.e();
        if (r0 == 4) goto L6;
        a r5 = this.a;
        if (r0 != 9) goto L12;
        boolean r6 = true;
    L13:
        int r7 = r5.a;
        if (r6 == true) goto L6;
        a.m(r5, "Expected end of the array or comma", r7, null, 4);
        throw null;
    L12:
        r6 = false;
        goto L13
    L19:
        if (r0 != 8) goto L21;
        this.a.f((byte) 9);
    L28:
        return new ouc.b(r1);
    L21:
        if (r0 != 4) goto L28;
        if (this.c == false) goto L25;
        this.a.f((byte) 9);
        goto L28
    L25:
        s.e(this.a, "array");
        throw null;
    L29:
        a.m(this.a, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    public final ouc.g0 d(boolean r4) {
        if (this.b == true) goto L7;
        if (r4 == false) goto L7;
        String r0 = this.a.i();
    L8:
        if (r4 == true) goto L14;
        if (Intrinsics.areEqual(r0, "null") == false) goto L14;
        return ouc.a0.INSTANCE;
    L14:
        return new x(r0, r4, null);
    L7:
        r0 = this.a.j();
        goto L8
    }

    public g0(f r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "lexer");
        this.a = r3;
        this.b = r2.c;
        this.c = r2.n;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0094 -> B:27:0x0099). Please report as a decompilation issue!!! */
    public static final Object a(g0 r12, DeepRecursiveScope r13, Continuation r14) {
        r12.getClass();
        if ((r14 instanceof JsonTreeReader.readObject.2) == false) goto L7;
        JsonTreeReader.readObject.2 r0 = (JsonTreeReader.readObject.2) r14;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r16 = (String) r0.L$3;
        LinkedHashMap r17 = (LinkedHashMap) r0.L$2;
        g0 r4 = (g0) r0.L$1;
        DeepRecursiveScope r9 = (DeepRecursiveScope) r0.L$0;
        ResultKt.throwOnFailure(r15);
        LinkedHashMap r10 = r17;
        r13 = r9;
    L27:
        r10.put(r16, (ouc.i) r15);
        byte r18 = r4.a.e();
        if (r18 == 4) goto L33;
        if (r18 != 7) goto L31;
        r12 = r4;
        LinkedHashMap r5 = r10;
    L34:
        if (r18 != 6) goto L36;
        r12.a.f((byte) 7);
    L43:
        return new ouc.d0(r5);
    L36:
        if (r18 != 4) goto L43;
        if (r12.c == false) goto L40;
        r12.a.f((byte) 7);
        goto L43
    L40:
        s.e(r12.a, "object");
        throw null;
    L31:
        a.m(r4.a, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L33:
        r12 = r4;
        r5 = r10;
    L18:
        if (r12.a.b() == false) goto L34;
        if (r12.b == false) goto L22;
        String r19 = r12.a.j();
    L23:
        r12.a.f((byte) 5);
        Unit r11 = Unit.INSTANCE;
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.L$2 = r5;
        r0.L$3 = r19;
        r0.label = 1;
        Object r20 = r13.callRecursive(r11, r0);
        if (r20 == r2) goto L46;
        LinkedHashMap r110 = r5;
        r4 = r12;
        r16 = r19;
        r15 = r20;
        r10 = r110;
        goto L27
    L46:
        return r2;
    L22:
        r19 = r12.a.i();
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r18 = r12.a.f((byte) 6);
        if (r12.a.r() == 4) goto L44;
        r5 = new LinkedHashMap();
        goto L18
    L44:
        a.m(r12.a, "Unexpected leading comma", 0, null, 6);
        throw null;
    L7:
        r0 = new JsonTreeReader.readObject.2(r12, r14);
        goto L8
    }
}
