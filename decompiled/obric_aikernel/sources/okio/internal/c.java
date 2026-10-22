package okio.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.ByteString;
import okio.y;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-Path")
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/internal/-Path\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,406:1\n59#1,22:407\n209#1:433\n209#1:434\n1549#2:429\n1620#2,3:430\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/internal/-Path\n*L\n53#1:407,22\n199#1:433\n204#1:434\n53#1:429\n53#1:430,3\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f12239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f12240b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ByteString f12241c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ByteString f12242d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ByteString f12243e = null;

    static {
        ByteString.a r10 = ByteString.Companion;
        f12239a = r10.d("/");
        f12240b = r10.d("\\");
        f12241c = r10.d("/\\");
        f12242d = r10.d(".");
        f12243e = r10.d("..");
    }

    public static final /* synthetic */ ByteString a() {
        return f12240b;
    }

    public static final /* synthetic */ ByteString b() {
        return f12242d;
    }

    public static final /* synthetic */ ByteString c() {
        return f12243e;
    }

    public static final /* synthetic */ int d(y r10) {
        return l(r10);
    }

    public static final /* synthetic */ ByteString e() {
        return f12239a;
    }

    public static final /* synthetic */ ByteString f(y r10) {
        return m(r10);
    }

    public static final /* synthetic */ boolean g(y r10) {
        return n(r10);
    }

    public static final /* synthetic */ int h(y r10) {
        return o(r10);
    }

    public static final /* synthetic */ ByteString i(String r10) {
        return s(r10);
    }

    public static final y j(y r10, y r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "child");
        if (r11.e() == false) goto L5;
    L17:
        return r11;
    L5:
        if (r11.o() != null) goto L17;
        ByteString r13 = m(r10);
        if (r13 != null) goto L12;
        r13 = m(r11);
        if (r13 != null) goto L12;
        r13 = s(y.f12275h);
    L12:
        okio.d r14 = new okio.d();
        r14.V(r10.b());
        if (r14.M() <= 0) goto L15;
        r14.V(r13);
    L15:
        r14.V(r11.b());
        return q(r14, r12);
    }

    public static final y k(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return q(new okio.d().l0(r10), r11);
    }

    private static final int l(y r10) {
        int r11 = ByteString.lastIndexOf$default(r10.b(), f12239a, 0, 2, null);
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        return ByteString.lastIndexOf$default(r10.b(), f12240b, 0, 2, null);
    }

    private static final ByteString m(y r10) {
        ByteString r11 = r10.b();
        ByteString r12 = f12239a;
        if (ByteString.indexOf$default(r11, r12, 0, 2, null) != (-1)) goto L10;
        ByteString r13 = r10.b();
        ByteString r14 = f12240b;
        if (ByteString.indexOf$default(r13, r14, 0, 2, null) == (-1)) goto L9;
        return r14;
    L9:
        return null;
    L10:
        return r12;
    }

    private static final boolean n(y r10) {
        if (r10.b().endsWith(f12243e) == true) goto L5;
    L13:
        return false;
    L5:
        if (r10.b().size() != 2) goto L8;
        return true;
    L8:
        if (r10.b().rangeEquals(r10.b().size() - 3, f12239a, 0, 1) == false) goto L11;
        return true;
    L11:
        if (r10.b().rangeEquals(r10.b().size() - 3, f12240b, 0, 1) == false) goto L13;
        return true;
    }

    private static final int o(y r10) {
        if (r10.b().size() != 0) goto L5;
        return -1;
    L5:
        boolean r11 = false;
        if (r10.b().getByte(0) != 47) goto L9;
        return 1;
    L9:
        if (r10.b().getByte(0) != 92) goto L20;
        if (r10.b().size() > 2) goto L13;
    L18:
        return 1;
    L13:
        if (r10.b().getByte(1) != 92) goto L18;
        int r12 = r10.b().indexOf(f12240b, 2);
        if (r12 == (-1)) goto L17;
        return r12;
    L17:
        return r10.b().size();
    L20:
        if (r10.b().size() > 2) goto L22;
    L41:
        return -1;
    L22:
        if (r10.b().getByte(1) != 58) goto L41;
        if (r10.b().getByte(2) != 92) goto L41;
        char r13 = (char) r10.b().getByte(0);
        if ('a' <= r13) goto L28;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == false) goto L33;
        return 3;
    L33:
        if ('A' <= r13) goto L35;
    L37:
        if (r11 == true) goto L43;
        return -1;
    L43:
        return 3;
    L35:
        if (r13 >= '[') goto L37;
        r11 = true;
        goto L37
    L28:
        if (r13 >= '{') goto L30;
        r14 = true;
        goto L31
    }

    private static final boolean p(okio.d r10, ByteString r11) {
        if (Intrinsics.areEqual(r11, f12240b) == true) goto L6;
        return false;
    L6:
        if (r10.M() >= 2) goto L9;
        return false;
    L9:
        if (r10.r(1) == 58) goto L11;
        return false;
    L11:
        char r12 = (char) r10.r(0);
        if ('a' <= r12) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == true) goto L26;
        if ('A' <= r12) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == true) goto L26;
        return false;
    L21:
        if (r12 >= '[') goto L23;
        r14 = true;
    L26:
        return true;
    L14:
        if (r12 >= '{') goto L16;
        r13 = true;
        goto L17
    }

    public static final y q(okio.d r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        okio.d r10 = new okio.d();
        int r11 = 0;
        ByteString r12 = null;
        int r13 = 0;
    L4:
        if (r16.A(0, f12239a) == true) goto L74;
        ByteString r14 = f12240b;
        if (r16.A(0, r14) == true) goto L74;
        if (r13 >= 2) goto L11;
    L13:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L18;
        Intrinsics.checkNotNull(r12);
        r10.V(r12);
    L17:
        r10.V(r12);
    L33:
        if (r10.M() <= 0) goto L35;
        boolean r18 = true;
    L36:
        ArrayList r19 = new ArrayList();
    L38:
        if (r16.n() == true) goto L64;
        long r110 = r16.u(f12241c);
        if (r110 != (-1)) goto L42;
        ByteString r111 = r16.D();
    L43:
        ByteString r112 = f12243e;
        if (Intrinsics.areEqual(r111, r112) == true) goto L45;
        if (Intrinsics.areEqual(r111, f12242d) == true) goto L38;
        if (Intrinsics.areEqual(r111, ByteString.EMPTY) == true) goto L38;
    L63:
        r19.add(r111);
        goto L38
    L45:
        if (r18 == false) goto L48;
        if (r19.isEmpty() == true) goto L38;
    L48:
        if (r17 == false) goto L63;
        if (r18 == true) goto L55;
        if (r19.isEmpty() == true) goto L63;
        if (Intrinsics.areEqual(CollectionsKt.last(r19), r112) == true) goto L63;
    L55:
        if (r15 == false) goto L58;
        if (r19.size() == 1) goto L38;
    L58:
        CollectionsKt.removeLastOrNull(r19);
        goto L38
    L42:
        r111 = r16.g(r110);
        r16.readByte();
        goto L43
    L64:
        int r20 = r19.size();
    L65:
        if (r11 >= r20) goto L70;
        if (r11 <= 0) goto L68;
        r10.V(r12);
    L68:
        r10.V((ByteString) r19.get(r11));
        r11 = r11 + 1;
        goto L65
    L70:
        if (r10.M() != 0) goto L73;
        r10.V(f12242d);
    L73:
        return new y(r10.D());
    L35:
        r18 = false;
        goto L36
    L18:
        if (r13 <= 0) goto L20;
        Intrinsics.checkNotNull(r12);
        goto L17
    L20:
        long r113 = r16.u(f12241c);
        if (r12 != null) goto L27;
        if (r113 != (-1)) goto L25;
        r12 = s(y.f12275h);
        goto L27
    L25:
        r12 = r(r16.r(r113));
    L27:
        if (p(r16, r12) == false) goto L33;
        if (r113 != 2) goto L31;
        r10.x(r16, 3);
        goto L33
    L31:
        r10.x(r16, 2);
        goto L33
    L11:
        if (Intrinsics.areEqual(r12, r14) == false) goto L13;
        r15 = true;
    L74:
        byte r21 = r16.readByte();
        if (r12 != null) goto L77;
        r12 = r(r21);
    L77:
        r13 = r13 + 1;
        goto L4
    }

    private static final ByteString r(byte r10) {
        if (r10 == 47) goto L10;
        if (r10 != 92) goto L8;
        return f12240b;
    L8:
        throw new IllegalArgumentException("not a directory separator: " + r10);
    L10:
        return f12239a;
    }

    private static final ByteString s(String r10) {
        if (Intrinsics.areEqual(r10, "/") == false) goto L6;
        return f12239a;
    L6:
        if (Intrinsics.areEqual(r10, "\\") == false) goto L10;
        return f12240b;
    L10:
        throw new IllegalArgumentException("not a directory separator: " + r10);
    }
}
