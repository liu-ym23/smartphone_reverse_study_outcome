package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.b0;
import kotlinx.serialization.json.q;
import kotlinx.serialization.json.u;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bi.e f19431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19433c;

    public l(kotlinx.serialization.json.i r5, bi.e r10) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        Intrinsics.checkNotNullParameter(r10, "lexer");
        this.f19431a = r10;
        this.f19432b = r5.f19407c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008c -> B:27:0x0092). Please report as a decompilation issue!!! */
    public static final Object a(l r13, DeepRecursiveScope r14, BaseContinuationImpl r15) {
        r13.getClass();
        if ((r15 instanceof JsonTreeReader$readObject$2) == false) goto L7;
        JsonTreeReader$readObject$2 r5 = (JsonTreeReader$readObject$2) r15;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        String r17 = (String) r5.L$3;
        LinkedHashMap r18 = (LinkedHashMap) r5.L$2;
        l r19 = (l) r5.L$1;
        DeepRecursiveScope r20 = (DeepRecursiveScope) r5.L$0;
        ResultKt.throwOnFailure(r16);
    L27:
        r18.put(r17, (kotlinx.serialization.json.l) r16);
        byte r110 = r19.f19431a.i();
        if (r110 == 4) goto L33;
        if (r110 != 7) goto L31;
        l r111 = r19;
        byte r21 = r110;
        r13 = r111;
    L34:
        bi.e r112 = r13.f19431a;
        if (r21 != 6) goto L37;
        r112.j((byte) 7);
    L39:
        return new x(r18);
    L37:
        if (r21 != 4) goto L39;
        bi.e.q(r112, "Unexpected trailing comma", 0, null, 6);
        throw null;
    L31:
        bi.e.q(r19.f19431a, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L33:
        DeepRecursiveScope r113 = r20;
        l r114 = r19;
        r21 = r110;
        r13 = r114;
    L17:
        bi.e r22 = r13.f19431a;
        if (r22.e() == false) goto L34;
        if (r13.f19432b == false) goto L22;
        String r23 = r22.n();
    L23:
        r22.j((byte) 5);
        Unit r24 = Unit.INSTANCE;
        r5.L$0 = r113;
        r5.L$1 = r13;
        r5.L$2 = r18;
        r5.L$3 = r23;
        r5.label = 1;
        Object r25 = r113.callRecursive(r24, r5);
        if (r25 == r11) goto L44;
        String r115 = r23;
        r19 = r13;
        r17 = r115;
        r20 = r113;
        r16 = r25;
        goto L27
    L44:
        return r11;
    L22:
        r23 = r22.m();
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        bi.e r116 = r13.f19431a;
        r21 = r116.j((byte) 6);
        if (r116.y() == 4) goto L42;
        r113 = r14;
        r18 = new LinkedHashMap();
        goto L17
    L42:
        bi.e.q(r116, "Unexpected leading comma", 0, null, 6);
        throw null;
    L7:
        r5 = new JsonTreeReader$readObject$2(r13, r15);
        goto L8
    }

    public final kotlinx.serialization.json.l b() {
        bi.e r5 = this.f19431a;
        byte r10 = r5.y();
        if (r10 != 1) goto L6;
        return d(true);
    L6:
        if (r10 != 0) goto L9;
        return d(false);
    L9:
        if (r10 != 6) goto L38;
        int r11 = this.f19433c + 1;
        this.f19433c = r11;
        if (r11 != 200) goto L13;
        kotlinx.serialization.json.l r12 = (kotlinx.serialization.json.l) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    L32:
        this.f19433c--;
        return r12;
    L13:
        byte r13 = r5.j((byte) 6);
        if (r5.y() == 4) goto L35;
        LinkedHashMap r14 = new LinkedHashMap();
    L17:
        if (r5.e() == false) goto L28;
        if (this.f19432b == false) goto L21;
        String r15 = r5.n();
    L22:
        r5.j((byte) 5);
        r14.put(r15, b());
        r13 = r5.i();
        if (r13 == 4) goto L17;
        if (r13 == 7) goto L28;
        bi.e.q(r5, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L21:
        r15 = r5.m();
    L28:
        if (r13 != 6) goto L30;
        r5.j((byte) 7);
    L31:
        r12 = new x(r14);
        goto L32
    L30:
        if (r13 != 4) goto L31;
        bi.e.q(r5, "Unexpected trailing comma", 0, null, 6);
        throw null;
    L35:
        bi.e.q(r5, "Unexpected leading comma", 0, null, 6);
        throw null;
    L38:
        if (r10 == 8) goto L40;
        bi.e.q(r5, "Cannot read Json element because of unexpected ".concat(f.p(r10)), 0, null, 6);
        throw null;
    L40:
        return c();
    }

    public final kotlinx.serialization.json.d c() {
        bi.e r5 = this.f19431a;
        byte r10 = r5.i();
        if (r5.y() == 4) goto L25;
        ArrayList r11 = new ArrayList();
    L6:
        if (r5.e() == false) goto L18;
        r11.add(b());
        r10 = r5.i();
        if (r10 == 4) goto L6;
        if (r10 != 9) goto L11;
        boolean r12 = true;
    L12:
        int r13 = r5.f930b;
        if (r12 == true) goto L6;
        bi.e.q(r5, "Expected end of the array or comma", r13, null, 4);
        throw null;
    L11:
        r12 = false;
        goto L12
    L18:
        if (r10 != 8) goto L20;
        r5.j((byte) 9);
    L22:
        return new kotlinx.serialization.json.d(r11);
    L20:
        if (r10 != 4) goto L22;
        bi.e.q(r5, "Unexpected trailing comma", 0, null, 6);
        throw null;
    L25:
        bi.e.q(r5, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    public final b0 d(boolean r5) {
        bi.e r10 = this.f19431a;
        if (this.f19432b == true) goto L7;
        if (r5 == false) goto L7;
        String r11 = r10.m();
    L8:
        if (r5 == true) goto L14;
        if (Intrinsics.areEqual(r11, "null") == false) goto L14;
        return u.INSTANCE;
    L14:
        return new q(r11, r5);
    L7:
        r11 = r10.n();
        goto L8
    }
}
