package bi;

import ai.j0;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import fi.i;
import gr.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f931c;
    public Object d;
    public Object e;
    public Object f;

    public e(int r10) {
        this.f929a = r10;
        switch(r10) {
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        this.d = MapsKt.mapOf(new Pair[]{TuplesKt.to("jsbError", new w4.a(2)), TuplesKt.to("fetchError", new w4.a(1)), TuplesKt.to("nativeError", new w4.a(4)), TuplesKt.to("jsbPerf", new w4.a(3)), TuplesKt.to("custom", new w4.a(0))});
        return;
    }

    public static /* synthetic */ void q(e r5, String r10, int r11, String r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = r5.f930b;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = "";
    L8:
        r5.p(r11, r10, r12);
        throw null;
    }

    public int A(int r5) {
        if (r5 < ((String) this.f).length()) goto L7;
        return -1;
    L7:
        return r5;
    }

    public int B() {
        int r5 = this.f930b;
        if (r5 != (-1)) goto L5;
        return r5;
    L5:
        String r10 = (String) this.f;
        if (r5 >= r10.length()) goto L16;
        char r11 = r10.charAt(r5);
        if (r11 == ' ') goto L15;
        if (r11 == '\n') goto L15;
        if (r11 == '\r') goto L15;
        if (r11 != '\t') goto L16;
    L15:
        r5 = r5 + 1;
    L16:
        this.f930b = r5;
        return r5;
    }

    public boolean C() {
        int r5 = B();
        String r10 = (String) this.f;
        if (r5 != r10.length()) goto L5;
    L11:
        return false;
    L5:
        if (r5 == (-1)) goto L11;
        if (r10.charAt(r5) != ',') goto L11;
        this.f930b++;
        return true;
    }

    public boolean D(boolean r10) {
        int r5 = A(B());
        String r11 = (String) this.f;
        int r12 = r11.length() - r5;
        if (r12 >= 4) goto L5;
    L21:
        return false;
    L5:
        if (r5 == (-1)) goto L21;
        int r13 = 0;
    L8:
        if (r13 >= 4) goto L13;
        if ("null".charAt(r13) != r11.charAt(r5 + r13)) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return false;
    L13:
        if (r12 > 4) goto L15;
    L17:
        if (r10 == false) goto L24;
        this.f930b = r5 + 4;
        return true;
    L24:
        return true;
    L15:
        if (kotlinx.serialization.json.internal.f.g(r11.charAt(r5 + 4)) != 0) goto L17;
        return false;
    }

    public void E(char r5) {
        int r10 = this.f930b;
        if (r10 > 0) goto L5;
    L15:
        r(kotlinx.serialization.json.internal.f.g(r5), true);
        throw null;
    L5:
        if (r5 != '\"') goto L15;
        this.f930b = r10 - 1;     // Catch: Throwable -> L12
        String r11 = n();     // Catch: Throwable -> L12
        this.f930b = r10;
        if (Intrinsics.areEqual(r11, "null") == false) goto L15;
        p(this.f930b - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls to default values.");
        throw null;
    L12:
        th = move-exception;
        this.f930b = r10;
        throw th;
    }

    public void a(UIComponent r5, boolean r10) {
        int r11 = this.f930b;
        if (r11 <= 0) goto L22;
        if (r5 == null) goto L23;
        UIList r12 = (UIList) this.f931c;
        if (r10 == false) goto L15;
        ArrayList r13 = (ArrayList) this.d;
        if (r13.size() <= r11) goto L13;
        UIComponent r14 = (UIComponent) r13.remove(0);
        if (r14 == null) goto L13;
        r12.f10509b.b(r14);
    L13:
        r13.add(r5);
        return;
    L15:
        ArrayList r15 = (ArrayList) this.e;
        if (r15.size() <= r11) goto L20;
        UIComponent r16 = (UIComponent) r15.remove(0);
        if (r16 == null) goto L20;
        r12.f10509b.b(r16);
    L20:
        r15.add(r5);
        return;
    L23:
        return;
    }

    public boolean b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        int r5 = 0;
    L6:
        ArrayList r11 = (ArrayList) this.d;
        if (r5 >= r11.size()) goto L14;
        UIComponent r12 = (UIComponent) r11.get(r5);
        if (r12 == null) goto L13;
        if (r10.equals(r12.f10770b) == false) goto L13;
        return true;
    L13:
        r5 = r5 + 1;
        goto L6
    L14:
        int r13 = 0;
    L15:
        ArrayList r14 = (ArrayList) this.e;
        if (r13 >= r14.size()) goto L23;
        UIComponent r15 = (UIComponent) r14.get(r13);
        if (r15 == null) goto L22;
        if (r10.equals(r15.f10770b) == false) goto L22;
        return true;
    L22:
        r13 = r13 + 1;
        goto L15
    L23:
        return false;
    }

    public void c(double r5, float r10) {
        int r11 = ((float[]) this.f931c).length + 1;
        int r12 = Arrays.binarySearch((double[]) this.d, r5);
        if (r12 >= 0) goto L5;
        r12 = (-r12) - 1;
    L5:
        this.d = Arrays.copyOf((double[]) this.d, r11);
        this.f931c = Arrays.copyOf((float[]) this.f931c, r11);
        this.e = new double[r11];
        double[] r13 = (double[]) this.d;
        System.arraycopy(r13, r12, r13, r12 + 1, (r11 - r12) - 1);
        ((double[]) this.d)[r12] = r5;
        ((float[]) this.f931c)[r12] = r10;
    }

    public int d(CharSequence r5, int r10) {
        int r11 = r10 + 4;
        if (r11 < r5.length()) goto L10;
        this.f930b = r10;
        if (r11 < r5.length()) goto L7;
        q(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    L7:
        return d(r5, this.f930b);
    L10:
        int r12 = ((s(r5, r10) << 12) + (s(r5, r10 + 1) << 8)) + (s(r5, r10 + 2) << 4);
        char r13 = (char) (s(r5, r10 + 3) + r12);
        ((StringBuilder) this.e).append(r13);
        return r11;
    }

    public boolean e() {
        int r5 = this.f930b;
        boolean r10 = false;
        if (r5 != (-1)) goto L5;
        return false;
    L5:
        String r11 = (String) this.f;
        if (r5 >= r11.length()) goto L31;
        char r12 = r11.charAt(r5);
        if (r12 == ' ') goto L30;
        if (r12 == '\n') goto L30;
        if (r12 == '\r') goto L30;
        if (r12 == '\t') goto L30;
        this.f930b = r5;
        if (r12 != '}') goto L20;
    L24:
        r10 = true;
    L29:
        return !r10;
    L20:
        if (r12 == ']') goto L24;
        if (r12 == ':') goto L24;
        if (r12 != ',') goto L29;
    L30:
        r5 = r5 + 1;
        goto L5
    L31:
        this.f930b = r5;
        return false;
    }

    public boolean f(int r10) {
        int r11 = A(r10);
        String r5 = (String) this.f;
        if (r11 < r5.length()) goto L5;
    L15:
        q(this, "EOF", 0, null, 6);
        throw null;
    L5:
        if (r11 == (-1)) goto L15;
        int r12 = r11 + 1;
        int r13 = r5.charAt(r11) | ' ';
        if (r13 != 102) goto L9;
        g(r12, "alse");
        return false;
    L9:
        if (r13 != 116) goto L11;
        g(r12, "rue");
        return true;
    L11:
        q(this, "Expected valid boolean literal prefix, but had '" + n() + '\'', 0, null, 6);
        throw null;
    }

    public void g(int r10, String r11) {
        String r5 = (String) this.f;
        if ((r5.length() - r10) < r11.length()) goto L13;
        int r12 = r11.length();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (r11.charAt(r13) != (r5.charAt(r10 + r13) | ' ')) goto L9;
        r13 = r13 + 1;
        goto L5
    L9:
        q(this, "Expected valid boolean literal prefix, but had '" + n() + '\'', 0, null, 6);
        throw null;
    L11:
        this.f930b = r11.length() + r10;
        return;
    L13:
        q(this, "Unexpected end of boolean literal", 0, null, 6);
        throw null;
    }

    public String h() {
        k(Typography.quote);
        int r5 = this.f930b;
        String r10 = (String) this.f;
        int r11 = StringsKt.q(r10, Typography.quote, r5, 4);
        if (r11 == (-1)) goto L47;
        int r12 = r5;
    L5:
        if (r12 >= r11) goto L45;
        if (r10.charAt(r12) == '\\') goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        int r13 = this.f930b;
        Intrinsics.checkNotNullParameter(r10, "source");
        char r14 = r10.charAt(r12);
        boolean r15 = false;
    L9:
        if (r14 == '\"') goto L39;
        if (r14 != '\\') goto L31;
        ((StringBuilder) this.e).append(r10, r13, r12);
        int r16 = A(r12 + 1);
        if (r16 == (-1)) goto L29;
        int r17 = r16 + 1;
        char r18 = r10.charAt(r16);
        if (r18 != 'u') goto L17;
        r17 = d(r10, r17);
    L22:
        r13 = A(r17);
        if (r13 == (-1)) goto L25;
    L24:
        r12 = r13;
        r15 = true;
    L38:
        r14 = r10.charAt(r12);
        goto L9
    L25:
        q(this, "Unexpected EOF", r13, null, 4);
        throw null;
    L17:
        if (r18 >= 'u') goto L19;
        char r19 = kotlinx.serialization.json.internal.c.f19417a[r18];
    L20:
        if (r19 == 0) goto L27;
        ((StringBuilder) this.e).append(r19);
        goto L22
    L27:
        q(this, "Invalid escaped char '" + r18 + '\'', 0, null, 6);
        throw null;
    L19:
        r19 = 0;
        goto L20
    L29:
        q(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
        throw null;
    L31:
        r12 = r12 + 1;
        if (r12 < r10.length()) goto L38;
        ((StringBuilder) this.e).append(r10, r13, r12);
        r13 = A(r12);
        if (r13 != (-1)) goto L24;
        q(this, "Unexpected EOF", r13, null, 4);
        throw null;
    L39:
        if (r15 == true) goto L41;
        String r20 = r10.subSequence(r13, r12).toString();
    L42:
        this.f930b = r12 + 1;
        return r20;
    L41:
        ((StringBuilder) this.e).append(r10, r13, r12);
        StringBuilder r21 = (StringBuilder) this.e;
        String r22 = r21.toString();
        r21.setLength(0);
        r20 = r22;
        goto L42
    L45:
        this.f930b = r11 + 1;
        return r10.substring(r5, r11);
    L47:
        n();
        r((byte) 1, false);
        throw null;
    }

    public byte i() {
    L2:
        int r5 = this.f930b;
        if (r5 == (-1)) goto L9;
        String r10 = (String) this.f;
        if (r5 >= r10.length()) goto L15;
        int r11 = this.f930b;
        this.f930b = r11 + 1;
        byte r12 = kotlinx.serialization.json.internal.f.g(r10.charAt(r11));
        if (r12 == 3) goto L2;
        return r12;
    L15:
        return 10;
    L9:
        return 10;
    }

    public byte j(byte r5) {
        byte r10 = i();
        if (r10 != r5) goto L5;
        return r10;
    L5:
        r(r5, true);
        throw null;
    }

    public void k(char r10) {
        if (this.f930b == (-1)) goto L21;
    L4:
        int r5 = this.f930b;
        String r11 = (String) this.f;
        if (r5 >= r11.length()) goto L19;
        int r12 = this.f930b;
        this.f930b = r12 + 1;
        char r13 = r11.charAt(r12);
        if (r13 == ' ') goto L4;
        if (r13 == '\n') goto L4;
        if (r13 == '\r') goto L4;
        if (r13 == '\t') goto L4;
        if (r13 != r10) goto L17;
        return;
    L17:
        E(r10);
        throw null;
    L19:
        this.f930b = -1;
        E(r10);
        throw null;
    L21:
        E(r10);
        throw null;
    }

    public long l() {
        int r5 = A(B());
        String r10 = (String) this.f;
        String r11 = "EOF";
        if (r5 < r10.length()) goto L5;
    L115:
        q(this, "EOF", 0, null, 6);
        throw null;
    L5:
        if (r5 == (-1)) goto L115;
        if (r10.charAt(r5) != '\"') goto L13;
        r5 = r5 + 1;
        if (r5 == r10.length()) goto L11;
        boolean r12 = true;
    L14:
        int r13 = r5;
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
        long r17 = 0;
        long r18 = 0;
    L16:
        if (r13 == r10.length()) goto L65;
        char r19 = r10.charAt(r13);
        if (r19 != 'e') goto L20;
    L23:
        if (r14 == false) goto L24;
    L22:
        String r110 = r11;
        boolean r111 = r16;
        if (r19 != '-') goto L37;
        if (r14 == false) goto L37;
        if (r13 == r5) goto L34;
        r13 = r13 + 1;
        r11 = r110;
        r16 = false;
        goto L16
    L34:
        q(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L37:
        if (r19 != '+') goto L43;
        if (r14 == false) goto L43;
        if (r13 == r5) goto L41;
        r13 = r13 + 1;
        r11 = r110;
    L26:
        r16 = true;
        goto L16
    L41:
        q(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
        throw null;
    L43:
        String r112 = r10;
        if (r19 == '-') goto L45;
        if (kotlinx.serialization.json.internal.f.g(r19) != 0) goto L66;
        r13 = r13 + 1;
        int r20 = r19 - '0';
        if (r20 < 0) goto L63;
        if (r20 >= 10) goto L63;
        if (r14 == false) goto L58;
        r18 = (r18 * ((long) 10)) + ((long) r20);
    L57:
        r16 = r111;
        r11 = r110;
        r10 = r112;
        goto L16
    L58:
        r17 = (r17 * ((long) 10)) - ((long) r20);
        if (r17 <= 0) goto L57;
        q(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L63:
        q(this, "Unexpected symbol '" + r19 + "' in numeric literal", 0, null, 6);
        throw null;
    L66:
        if (r13 == r5) goto L68;
        boolean r21 = true;
    L69:
        if (r5 == r13) goto L113;
        if (r15 == true) goto L72;
    L75:
        if (r12 == false) goto L84;
        if (r21 == true) goto L78;
        q(this, r110, 0, null, 6);
        throw null;
    L78:
        if (r112.charAt(r13) != '\"') goto L80;
        r13 = r13 + 1;
        goto L84
    L80:
        q(this, "Expected closing quotation mark", 0, null, 6);
        throw null;
    L84:
        this.f930b = r13;
        if (r14 == false) goto L105;
        double r22 = r17;
        if (r111 == true) goto L90;
        double r23 = Math.pow(10.0d, -r18);
    L92:
        double r24 = r22 * r23;
        if (r24 <= 9.223372036854776E18d) goto L95;
    L101:
        q(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L95:
        if (r24 < (-9.223372036854776E18d)) goto L101;
        if (Math.floor(r24) != r24) goto L99;
        r17 = (long) r24;
        goto L105
    L99:
        q(this, "Can't convert " + r24 + " to Long", 0, null, 6);
        throw null;
    L90:
        if (r111 != true) goto L104;
        r23 = Math.pow(10.0d, r18);
        goto L92
    L104:
        throw new NoWhenBranchMatchedException();
    L105:
        if (r15 == false) goto L108;
        return r17;
    L108:
        if (r17 != Long.MIN_VALUE) goto L110;
        q(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L110:
        return -r17;
    L72:
        if (r5 != (r13 - 1)) goto L75;
    L113:
        q(this, "Expected numeric literal", 0, null, 6);
        throw null;
    L68:
        r21 = false;
        goto L69
    L45:
        if (r13 != r5) goto L47;
        r13 = r13 + 1;
        r16 = r111;
        r11 = r110;
        r10 = r112;
        r15 = true;
        goto L16
    L47:
        q(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L24:
        if (r13 == r5) goto L27;
        r13 = r13 + 1;
        r14 = true;
        goto L26
    L27:
        q(this, "Unexpected symbol " + r19 + " in numeric literal", 0, null, 6);
        throw null;
    L20:
        if (r19 != 'E') goto L22;
    L65:
        r112 = r10;
        r110 = r11;
        r111 = r16;
        goto L66
    L11:
        q(this, "EOF", 0, null, 6);
        throw null;
    L13:
        r12 = false;
        goto L14
    }

    public String m() {
        String r5 = (String) this.f931c;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r5);
        this.f931c = null;
        return r5;
    L7:
        return h();
    }

    public String n() {
        String r5 = (String) this.f931c;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        this.f931c = null;
        return r5;
    L6:
        int r10 = B();
        String r11 = (String) this.f;
        if (r10 < r11.length()) goto L9;
    L33:
        q(this, "EOF", r10, null, 4);
        throw null;
    L9:
        if (r10 == (-1)) goto L33;
        byte r12 = kotlinx.serialization.json.internal.f.g(r11.charAt(r10));
        if (r12 != 1) goto L15;
        return m();
    L15:
        if (r12 != 0) goto L31;
        boolean r13 = false;
    L18:
        if (kotlinx.serialization.json.internal.f.g(r11.charAt(r10)) != 0) goto L26;
        r10 = r10 + 1;
        if (r10 < r11.length()) goto L18;
        ((StringBuilder) this.e).append(r11, this.f930b, r10);
        int r14 = A(r10);
        if (r14 == (-1)) goto L23;
        r10 = r14;
        r13 = true;
        goto L18
    L23:
        this.f930b = r10;
        ((StringBuilder) this.e).append(r11, 0, 0);
        StringBuilder r15 = (StringBuilder) this.e;
        String r16 = r15.toString();
        r15.setLength(0);
        return r16;
    L26:
        if (r13 == true) goto L28;
        String r17 = r11.subSequence(this.f930b, r10).toString();
    L29:
        this.f930b = r10;
        return r17;
    L28:
        ((StringBuilder) this.e).append(r11, this.f930b, r10);
        StringBuilder r18 = (StringBuilder) this.e;
        String r19 = r18.toString();
        r18.setLength(0);
        r17 = r19;
        goto L29
    L31:
        q(this, "Expected beginning of the string, but got " + r11.charAt(r10), 0, null, 6);
        throw null;
    }

    public String o() {
        String r5 = n();
        if (Intrinsics.areEqual(r5, "null") == true) goto L5;
    L9:
        return r5;
    L5:
        if (((String) this.f).charAt(this.f930b - 1) == '\"') goto L9;
        q(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    }

    public void p(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "hint");
        if (r11.length() != 0) goto L5;
        String r12 = "";
    L6:
        StringBuilder r13 = j0.w(r10, " at path: ");
        r13.append(((b0) this.d).b());
        r13.append(r12);
        String r14 = r13.toString();
        throw kotlinx.serialization.json.internal.f.c(r5, (String) this.f, r14);
    L5:
        r12 = "\n".concat(r11);
        goto L6
    }

    public void r(byte r5, boolean r10) {
        String r11 = kotlinx.serialization.json.internal.f.p(r5);
        if (r10 == false) goto L5;
        int r12 = this.f930b - 1;
    L6:
        int r13 = this.f930b;
        String r14 = (String) this.f;
        if (r13 == r14.length()) goto L11;
        if (r12 < 0) goto L11;
        String r15 = String.valueOf(r14.charAt(r12));
    L12:
        q(this, j0.l("Expected ", r11, ", but had '", r15, "' instead"), r12, null, 4);
        throw null;
    L11:
        r15 = "EOF";
        goto L12
    L5:
        r12 = this.f930b;
        goto L6
    }

    public int s(CharSequence r5, int r10) {
        char r11 = r5.charAt(r10);
        if ('0' > r11) goto L8;
        if (r11 >= ':') goto L8;
        return r11 - '0';
    L8:
        if ('a' > r11) goto L13;
        if (r11 >= 'g') goto L13;
        return r11 - 'W';
    L13:
        if ('A' <= r11) goto L15;
    L18:
        q(this, "Invalid toHexChar char '" + r11 + "' in unicode escape", 0, null, 6);
        throw null;
    L15:
        if (r11 >= 'G') goto L18;
        return r11 - '7';
    }

    public c t(String r5) {
        List r10 = (List) this.d;
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        c r12 = (c) r11.next();
        if (r5.equalsIgnoreCase(r12.f915a) == false) goto L7;
        return r12;
    L11:
        return null;
    }

    public String toString() {
        switch(this.f929a) {
            case 2: goto L11;
            case 3: goto L8;
            case 4: goto L5;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("UrlRequest{paramMap=");
        r5.append((HashMap) this.d);
        r5.append(", url='");
        r5.append((String) this.f931c);
        r5.append("', method='");
        r5.append((String) this.e);
        r5.append("', body='");
        r5.append((String) this.f);
        r5.append("', timeoutMs=");
        return j0.n(r5, this.f930b, '}');
    L8:
        StringBuilder r10 = new StringBuilder("JsonReader(source='");
        r10.append((String) this.f);
        r10.append("', currentPosition=");
        return j0.n(r10, this.f930b, ')');
    L5:
        return super.toString();
    L11:
        return "pos =" + Arrays.toString((double[]) this.d) + " period=" + Arrays.toString((float[]) this.f931c);
    }

    public double u(double r15) {
        if (r15 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r15 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r5 = Arrays.binarySearch((double[]) this.d, r15);
        if (r5 >= 0) goto L11;
        r5 = (-r5) - 1;
    L11:
        float[] r10 = (float[]) this.f931c;
        float r11 = r10[r5];
        int r12 = r5 - 1;
        float r13 = r10[r12];
        double r14 = r11 - r13;
        double[] r16 = (double[]) this.d;
        double r17 = r16[r5];
        double r18 = r16[r12];
        double r19 = r14 / (r17 - r18);
        return ((((r15 * r15) - (r18 * r18)) * r19) / 2.0d) + j0.a(r15, r18, ((double) r13) - (r19 * r18), ((double[]) this.e)[r12]);
    }

    public double v(double r10, double r12) {
        double r11 = u(r10) + r12;
        switch(this.f930b) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r13 = 1.0d - Math.abs(((r11 * 4.0d) % 4.0d) - 2.0d);
        return 1.0d - (r13 * r13);
    L5:
        return Math.sin(6.283185307179586d * r11);
    L7:
        return ((h) this.f).v(r11 % 1.0d);
    L11:
        return Math.cos((r12 + r11) * 6.283185307179586d);
    L13:
        return 1.0d - (((r11 * 2.0d) + 1.0d) % 2.0d);
    L15:
        return (((r11 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L17:
        return 1.0d - Math.abs((((r11 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
    L19:
        return Math.signum(0.5d - (r11 % 1.0d));
    }

    public boolean w() {
        int r5 = this.f930b;
        if (r5 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r5 >= 300) goto L7;
        return true;
    }

    public String x(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "keyToMatch");
        int r11 = this.f930b;
    L20:
        th = move-exception;
        this.f930b = r11;
        this.f931c = null;
        throw th;
    L5:
        if (i() == 6) goto L9;
        this.f930b = r11;
        this.f931c = null;
        return null;
    L9:
        if (Intrinsics.areEqual(z(r10), r5) == true) goto L12;
        this.f930b = r11;
        this.f931c = null;
        return null;
    L12:
        this.f931c = null;     // Catch: Throwable -> L20
        if (i() == 5) goto L17;
        this.f930b = r11;
        this.f931c = null;
        return null;
    L17:
        String r12 = z(r10);     // Catch: Throwable -> L20
        this.f930b = r11;
        this.f931c = null;
        return r12;
    }

    public byte y() {
        int r5 = this.f930b;
    L3:
        int r10 = A(r5);
        if (r10 == (-1)) goto L16;
        char r11 = ((String) this.f).charAt(r10);
        if (r11 == ' ') goto L15;
        if (r11 == '\n') goto L15;
        if (r11 == '\r') goto L15;
        if (r11 == '\t') goto L15;
        this.f930b = r10;
        return kotlinx.serialization.json.internal.f.g(r11);
    L15:
        r5 = r10 + 1;
        goto L3
    L16:
        this.f930b = r10;
        return 10;
    }

    public String z(boolean r5) {
        byte r10 = y();
        if (r5 == false) goto L8;
        if (r10 == 1) goto L7;
        if (r10 == 0) goto L7;
        return null;
    L7:
        String r11 = n();
    L11:
        this.f931c = r11;
        return r11;
    L8:
        if (r10 == 1) goto L10;
        return null;
    L10:
        r11 = m();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(UIList r5, int r10) {
        this.f929a = 1;
        this.f930b = 0;
        this.d = new ArrayList();
        this.e = new ArrayList();
        en.b r11 = new en.b();
        this.f = r11;
        this.f931c = r5;
        this.f930b = r10;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getView() == 0) goto L9;
        ((RecyclerView) r5.getView()).addOnScrollListener(r11);
        return;
    }

    public e(String r5, int r10, String r11, ArrayList r12, i r13) {
        this.f929a = 0;
        if (r5 == null) goto L17;
        if (r10 < 200) goto L15;
        if (r11 == null) goto L13;
        if (r12 == null) goto L11;
        this.f930b = r10;
        this.f931c = r11;
        this.d = Collections.unmodifiableList(new ArrayList(r12));
        this.e = r13;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException(j0.g(r10, "Invalid status code: "));
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public e(String r5, int r10) {
        this.f929a = r10;
        switch(r10) {
            case 5: goto L10;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "source");
        b0 r11 = new b0(5, 0);
        r11.f7247c = new Object[8];
        int[] r12 = new int[8];
        int r13 = 0;
    L6:
        if (r13 >= 8) goto L8;
        r12[r13] = -1;
        r13 = r13 + 1;
        goto L6
    L8:
        r11.d = r12;
        r11.f7246b = -1;
        this.d = r11;
        this.e = new StringBuilder();
        this.f = r5;
        return;
    L10:
        this.f930b = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.f931c = r5;
    }
}
