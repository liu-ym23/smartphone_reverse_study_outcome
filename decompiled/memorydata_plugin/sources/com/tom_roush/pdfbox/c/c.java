package com.tom_roush.pdfbox.c;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f16090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tom_roush.pdfbox.util.c f16091b;
    private final float c;
    private final float d;
    private final float e;
    private final int f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private final float k;
    private final int[] l;
    private final p m;
    private final float n;
    private final int o;
    private float[] p;
    private String q;
    private float r;

    static {
        f16090a = p();
    }

    public c(int r2, float r3, float r4, com.tom_roush.pdfbox.util.c r5, float r6, float r7, float r8, float r9, float r10, String r11, int[] r12, p r13, float r14, int r15) {
        this.r = -1.0f;
        this.f16091b = r5;
        this.c = r6;
        this.d = r7;
        this.f = r2;
        this.e = r8;
        this.i = r4;
        this.j = r3;
        this.p = new float[]{r9};
        this.k = r10;
        this.q = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.g = a(r2);
        if (r2 != 0) goto L5;
    L8:
        this.h = r4 - b(r2);
        return;
    L5:
        if (r2 == 180) goto L8;
        this.h = r3 - b(r2);
    }

    private float a(float r3) {
        if (r3 != 0.0f) goto L7;
        return this.f16091b.i();
    L7:
        if (r3 != 90.0f) goto L11;
        return this.f16091b.j();
    L11:
        if (r3 != 180.0f) goto L16;
        float r4 = this.j;
        float r2 = this.f16091b.i();
    L14:
        return r4 - r2;
    L16:
        if (r3 != 270.0f) goto L18;
        r4 = this.i;
        r2 = this.f16091b.j();
        goto L14
    L18:
        return 0.0f;
    }

    private String a(String r3) {
        int r2 = r3.codePointAt(0);
        Map<Integer, String> r0 = f16090a;
        if (r0.containsKey(Integer.valueOf(r2)) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    L7:
        return Normalizer.normalize(r3, Normalizer.Form.NFKC).trim();
    }

    private void a(int r6, c r7) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.q, 0, r6);
        float[] r1 = this.p;
        float[] r3 = new float[r1.length + 1];
        System.arraycopy(r1, 0, r3, 0, r6);
        r0.append(this.q.charAt(r6));
        r3[r6] = this.p[r6];
        r0.append(a(r7.a()));
        int r8 = r6 + 1;
        r3[r8] = 0.0f;
        r0.append(this.q.substring(r8));
        float[] r2 = this.p;
        System.arraycopy(r2, r8, r3, r6 + 2, (r2.length - r6) - 1);
        this.q = r0.toString();
        this.p = r3;
    }

    private float b(float r3) {
        if (r3 != 0.0f) goto L7;
        return this.f16091b.j();
    L7:
        if (r3 != 90.0f) goto L12;
        float r4 = this.j;
        float r2 = this.f16091b.i();
    L10:
        return r4 - r2;
    L12:
        if (r3 != 180.0f) goto L15;
        r4 = this.i;
        r2 = this.f16091b.j();
        goto L10
    L15:
        if (r3 == 270.0f) goto L17;
        return 0.0f;
    L17:
        return this.f16091b.i();
    }

    private float c(float r2) {
        if (r2 != 90.0f) goto L5;
    L10:
        float r3 = this.d;
        float r1 = this.f16091b.j();
    L9:
        return Math.abs(r3 - r1);
    L5:
        if (r2 == 270.0f) goto L10;
        r3 = this.c;
        r1 = this.f16091b.i();
        goto L9
    }

    private static Map<Integer, String> p() {
        HashMap r0 = new HashMap(31);
        r0.put(96, "̀");
        r0.put(715, "̀");
        r0.put(39, "́");
        r0.put(697, "́");
        r0.put(714, "́");
        r0.put(94, "̂");
        r0.put(710, "̂");
        r0.put(Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "̃");
        r0.put(713, "̄");
        r0.put(176, "̊");
        r0.put(698, "̋");
        r0.put(711, "̌");
        r0.put(712, "̍");
        r0.put(34, "̎");
        r0.put(699, "̒");
        r0.put(Integer.valueOf(TypedValues.TransitionType.TYPE_DURATION), "̓");
        r0.put(1158, "̓");
        r0.put(1370, "̓");
        r0.put(701, "̔");
        r0.put(1157, "̔");
        r0.put(1369, "̔");
        r0.put(724, "̝");
        r0.put(725, "̞");
        r0.put(726, "̟");
        r0.put(727, "̠");
        r0.put(690, "̡");
        r0.put(716, "̩");
        r0.put(695, "̫");
        r0.put(717, "̱");
        r0.put(95, "̲");
        r0.put(8270, "͙");
        return r0;
    }

    public String a() {
        return this.q;
    }

    public boolean a(c r17) {
        double r0 = d();
        double r2 = h();
        double r4 = r0 + r2;
        double r6 = r17.d();
        double r8 = ((double) r17.h()) + r6;
        if (r8 > r0) goto L5;
        return false;
    L5:
        if (r6 >= r4) goto L38;
        double r12 = f();
        double r14 = r17.f();
        if ((((double) r17.j()) + r14) >= r12) goto L10;
        return false;
    L10:
        if (r14 <= (r12 + ((double) j()))) goto L13;
        return false;
    L13:
        if (r6 <= r0) goto L22;
        if (r8 <= r4) goto L22;
        if (((r4 - r6) / r2) > 0.15d) goto L35;
        return false;
    L35:
        return true;
    L22:
        if (r6 < r0) goto L24;
    L30:
        return true;
    L24:
        if (r8 >= r4) goto L30;
        if (((r8 - r0) / r2) > 0.15d) goto L36;
        return false;
    L36:
        return true;
    L38:
        return false;
    }

    public float b() {
        if (this.r >= 0.0f) goto L43;
        float r0 = this.f16091b.h();
        float r2 = this.f16091b.f();
        float r3 = this.f16091b.g();
        float r4 = this.f16091b.e();
        if (r0 <= 0.0f) goto L14;
        if (Math.abs(r2) >= r4) goto L14;
        if (Math.abs(r3) >= r0) goto L14;
        if (r4 <= 0.0f) goto L14;
    L41:
        this.r = 0.0f;
    L14:
        if (r0 >= 0.0f) goto L24;
        if (Math.abs(r2) >= Math.abs(r4)) goto L24;
        if (Math.abs(r3) >= Math.abs(r0)) goto L24;
        if (r4 >= 0.0f) goto L24;
        float r1 = 180.0f;
    L22:
        this.r = r1;
    L24:
        if (Math.abs(r0) >= Math.abs(r3)) goto L33;
        if (r2 <= 0.0f) goto L33;
        if (r3 >= 0.0f) goto L33;
        if (Math.abs(r4) >= r2) goto L33;
        r1 = 90.0f;
    L33:
        if (Math.abs(r0) >= r3) goto L41;
        if (r2 >= 0.0f) goto L41;
        if (r3 <= 0.0f) goto L41;
        if (Math.abs(r4) >= Math.abs(r2)) goto L41;
        r1 = 270.0f;
    L43:
        return this.r;
    }

    public void b(c r12) {
        if (r12.a().length() <= 1) goto L5;
        return;
    L5:
        float r0 = r12.d();
        int r3 = 0;
        float r2 = r12.p[0] + r0;
        float r4 = d();
        int r5 = this.q.length();
        float r6 = r4;
        boolean r7 = false;
    L6:
        if (r3 >= r5) goto L37;
        if (r7 == true) goto L38;
        float[] r8 = this.p;
        if (r3 >= r8.length) goto L10;
        float r9 = r8[r3] + r6;
        if (r0 < r6) goto L14;
    L21:
        if (r0 >= r6) goto L25;
    L22:
        a(r3, r12);
    L23:
        r7 = true;
    L30:
        r6 = r6 + this.p[r3];
        r3 = r3 + 1;
        goto L6
    L25:
        if (r2 <= r9) goto L22;
        if (r3 != (r5 - 1)) goto L30;
    L14:
        if (r2 > r9) goto L21;
        if (r3 == 0) goto L22;
        int r10 = r3 - 1;
        if (((r2 - r6) / r8[r3]) >= ((r6 - r0) / r8[r10])) goto L22;
        a(r10, r12);
        goto L23
    L10:
        Log.i("PdfBox-Android", "diacritic " + r12.a() + " on ligature " + this.q + " is not supported yet and is ignored (PDFBOX-2831)");
        return;
    L38:
        return;
    }

    public float c() {
        return this.g;
    }

    public float d() {
        return a(b());
    }

    public float e() {
        return this.h;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Float.compare(r6.c, this.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(r6.d, this.d) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(r6.e, this.e) == 0) goto L18;
        return false;
    L18:
        if (this.f == r6.f) goto L21;
        return false;
    L21:
        if (Float.compare(r6.g, this.g) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(r6.h, this.h) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(r6.i, this.i) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(r6.j, this.j) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(r6.k, this.k) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(r6.n, this.n) == 0) goto L39;
        return false;
    L39:
        if (this.o == r6.o) goto L41;
        return false;
    L41:
        com.tom_roush.pdfbox.util.c r0 = this.f16091b;
        if (r0 == null) goto L47;
        if (r0.equals(r6.f16091b) == true) goto L50;
    L48:
        return false;
    L50:
        if (Arrays.equals(this.l, r6.l) == true) goto L52;
        return false;
    L52:
        p r4 = this.m;
        if (r4 == null) goto L56;
        return r4.equals(r6.m);
    L56:
        if (r6.m != null) goto L59;
        return true;
    L59:
        return false;
    L47:
        if (r6.f16091b == null) goto L50;
        goto L48
    }

    public float f() {
        float r0 = b();
        if (r0 != 0.0f) goto L5;
    L10:
        float r1 = this.i;
    L9:
        return r1 - b(r0);
    L5:
        if (r0 == 180.0f) goto L10;
        r1 = this.j;
        goto L9
    }

    public float g() {
        return c(this.f);
    }

    public float h() {
        return c(b());
    }

    public int hashCode() {
        com.tom_roush.pdfbox.util.c r0 = this.f16091b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((((((((((((((((r2 * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + Arrays.hashCode(this.l)) * 31;
        p r4 = this.m;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((((r3 + r1) * 31) + Float.floatToIntBits(this.n)) * 31) + this.o;
    L5:
        r2 = 0;
        goto L6
    }

    public float i() {
        return this.e;
    }

    public float j() {
        return this.e;
    }

    public float k() {
        return this.n;
    }

    public p l() {
        return this.m;
    }

    public float m() {
        return this.k;
    }

    public float[] n() {
        return this.p;
    }

    public boolean o() {
        String r3 = a();
        if (r3.length() == 1) goto L6;
        return false;
    L6:
        if ("ー".equals(r3) == false) goto L8;
        return false;
    L8:
        int r4 = Character.getType(r3.charAt(0));
        if (r4 != 6) goto L11;
        return true;
    L11:
        if (r4 != 27) goto L13;
        return true;
    L13:
        if (r4 != 4) goto L16;
        return true;
    L16:
        return false;
    }

    public String toString() {
        return a();
    }
}
