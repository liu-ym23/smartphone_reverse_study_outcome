package jr;

import ai.j0;
import android.view.View;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.web.jsbridge2.k f18435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18437c;
    public String d;
    public int e;
    public final ArrayList f;

    public g() {
        this.f18437c = 0;
        this.d = null;
        this.e = 0;
        this.f = new ArrayList();
    }

    public static g c(String r12) {
        if (r12.startsWith("CUSTOM") == false) goto L6;
        d r13 = new d();
        r13.g = new float[1];
        return r13;
    L6:
        byte r10 = -1;
        switch(r12.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r10) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L84;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L84:
        f r14 = new f();
        r14.g = false;
        return r14;
    L69:
        return new c(0);
    L71:
        return new c(0);
    L73:
        return new e();
    L75:
        return new c(1);
    L77:
        return new c(2);
    L79:
        return new c(0);
    L81:
        return new c(6);
    L83:
        return new c(5);
    L87:
        return new c(9);
    L89:
        return new c(8);
    L91:
        return new c(7);
    L93:
        return new c(4);
    L95:
        return new c(3);
    L10:
        if (r12.equals("waveOffset") == false) goto L65;
        r10 = 13;
        goto L65
    L14:
        if (r12.equals("alpha") == false) goto L65;
        r10 = 12;
        goto L65
    L18:
        if (r12.equals("transitionPathRotate") == false) goto L65;
        r10 = 11;
        goto L65
    L22:
        if (r12.equals("elevation") == false) goto L65;
        r10 = 10;
        goto L65
    L26:
        if (r12.equals("rotation") == false) goto L65;
        r10 = 9;
        goto L65
    L30:
        if (r12.equals("waveVariesBy") == false) goto L65;
        r10 = 8;
        goto L65
    L34:
        if (r12.equals("scaleY") == false) goto L65;
        r10 = 7;
        goto L65
    L38:
        if (r12.equals("scaleX") == false) goto L65;
        r10 = 6;
        goto L65
    L42:
        if (r12.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L65;
        r10 = 5;
        goto L65
    L46:
        if (r12.equals("translationZ") == false) goto L65;
        r10 = 4;
        goto L65
    L50:
        if (r12.equals("translationY") == false) goto L65;
        r10 = 3;
        goto L65
    L54:
        if (r12.equals("translationX") == false) goto L65;
        r10 = 2;
        goto L65
    L58:
        if (r12.equals("rotationY") == false) goto L65;
        r10 = 1;
        goto L65
    L62:
        if (r12.equals("rotationX") == false) goto L65;
        r10 = 0;
        goto L65
    }

    public final float a(float r10) {
        com.bytedance.ies.web.jsbridge2.k r11 = this.f18435a;
        qo.a r5 = (qo.a) r11.g;
        if (r5 == null) goto L5;
        r5.w(r10, (double[]) r11.f6287h);
    L6:
        double[] r12 = (double[]) r11.f6287h;
        return (float) ((((bi.e) r11.f6284a).v(r10, r12[1]) * ((double[]) r11.f6287h)[2]) + r12[0]);
    L5:
        double[] r13 = (double[]) r11.f6287h;
        r13[0] = ((float[]) r11.e)[0];
        r13[1] = ((float[]) r11.f)[0];
        r13[2] = ((float[]) r11.f6285b)[0];
        goto L6
    }

    public final float b(float r23) {
        com.bytedance.ies.web.jsbridge2.k r5 = this.f18435a;
        qo.a r10 = (qo.a) r5.g;
        if (r10 == null) goto L5;
        double r11 = r23;
        r10.z(r11, (double[]) r5.f6288i);
        ((qo.a) r5.g).w(r11, (double[]) r5.f6287h);
    L6:
        double r12 = r23;
        double r13 = ((double[]) r5.f6287h)[1];
        bi.e r14 = (bi.e) r5.f6284a;
        double r15 = r14.v(r12, r13);
        double r16 = ((double[]) r5.f6287h)[1];
        double r17 = ((double[]) r5.f6288i)[1];
        double r18 = r14.u(r12) + r16;
        if (r12 > 0.0d) goto L10;
        double r19 = 0.0d;
    L16:
        double r20 = r19 + r17;
        double r21 = 2.0d;
        switch(r14.f930b) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            default: goto L18;
        };
    L18:
        double r22 = r20 * 6.283185307179586d;
        double r24 = Math.cos(6.283185307179586d * r18);
    L19:
        double r25 = r24 * r22;
    L28:
        double[] r26 = (double[]) r5.f6288i;
        return (float) ((r25 * ((double[]) r5.f6287h)[2]) + ((r15 * r26[2]) + r26[0]));
    L20:
        r25 = ((gr.h) r14.f).y(r18 % 1.0d);
        goto L28
    L21:
        r25 = ((((r18 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * (r20 * 4.0d);
        goto L28
    L22:
        r21 = (-6.283185307179586d) * r20;
        double r27 = Math.sin(6.283185307179586d * r18);
    L23:
        r25 = r21 * r27;
        goto L28
    L24:
        r27 = -r20;
        goto L23
    L25:
        r25 = 2.0d * r20;
        goto L28
    L26:
        r22 = r20 * 4.0d;
        r24 = Math.signum((((r18 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L19
    L27:
        r25 = 0.0d;
        goto L28
    L10:
        if (r12 < 1.0d) goto L12;
        r19 = 1.0d;
        goto L16
    L12:
        int r110 = Arrays.binarySearch((double[]) r14.d, r12);
        if (r110 >= 0) goto L15;
        r110 = (-r110) - 1;
    L15:
        float[] r28 = (float[]) r14.f931c;
        float r111 = r28[r110];
        int r112 = r110 - 1;
        float r29 = r28[r112];
        double r30 = r111 - r29;
        double[] r113 = (double[]) r14.d;
        double r210 = r113[r110];
        double r114 = r113[r112];
        double r31 = r30 / (r210 - r114);
        r19 = (((double) r29) - (r31 * r114)) + (r12 * r31);
        goto L16
    L5:
        double[] r32 = (double[]) r5.f6288i;
        r32[0] = 0.0d;
        r32[1] = 0.0d;
        r32[2] = 0.0d;
        goto L6
    }

    public void d(lr.b r5) {
    }

    public abstract void e(View r5, float r10);

    /* JADX WARN: Type inference failed for: r4v2, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v4, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v6, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v9, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [double[], java.io.Serializable] */
    public final void f() {
        ArrayList r5 = this.f;
        int r10 = r5.size();
        if (r10 != 0) goto L5;
        return;
    L5:
        Collections.sort(r5, new ca.d(19));
        double[] r11 = new double[r10];
        double[][] r12 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, 3});
        int r13 = this.f18437c;
        String r14 = this.d;
        com.bytedance.ies.web.jsbridge2.k r15 = new com.bytedance.ies.web.jsbridge2.k();
        bi.e r16 = new bi.e(2);
        r16.f931c = new float[0];
        r16.d = new double[0];
        r15.f6284a = r16;
        r16.f930b = r13;
        if (r14 == null) goto L19;
        double[] r17 = new double[r14.length() / 2];
        int r18 = r14.indexOf(40) + 1;
        int r19 = r14.indexOf(44, r18);
        int r110 = 0;
    L9:
        if (r19 == (-1)) goto L11;
        r17[r110] = Double.parseDouble(r14.substring(r18, r19).trim());
        int r111 = r19 + 1;
        r110 = r110 + 1;
        r18 = r111;
        r19 = r14.indexOf(44, r111);
        goto L9
    L11:
        r17[r110] = Double.parseDouble(r14.substring(r18, r14.indexOf(41, r18)).trim());
        double[] r20 = Arrays.copyOf(r17, r110 + 1);
        int r112 = (r20.length * 3) - 2;
        int r113 = r20.length - 1;
        double r114 = 1.0d / ((double) r113);
        char r115 = 0;
        double[][] r21 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r112, 1});
        double[] r116 = new double[r112];
        int r117 = 0;
    L13:
        if (r117 >= r20.length) goto L18;
        double r22 = r20[r117];
        int r23 = r117 + r113;
        r21[r23][r115] = r22;
        double[][] r24 = r21;
        double r25 = ((double) r117) * r114;
        r116[r23] = r25;
        if (r117 <= 0) goto L17;
        int r26 = (r113 * 2) + r117;
        r24[r26][r115] = r22 + 1.0d;
        r116[r26] = r25 + 1.0d;
        int r27 = r117 - 1;
        r24[r27][r115] = (r22 - 1.0d) - r114;
        r116[r27] = (r25 - 1.0d) - r114;
    L17:
        r117 = r117 + 1;
        r21 = r24;
        r115 = 0;
        goto L13
    L18:
        r16.f = new gr.h(r116, r21);
    L19:
        r15.f6285b = new float[r10];
        r15.f6286c = new double[r10];
        r15.d = new float[r10];
        r15.e = new float[r10];
        r15.f = new float[r10];
        float[] r28 = new float[r10];
        this.f18435a = r15;
        Iterator r29 = r5.iterator();
        int r30 = 0;
    L21:
        if (r29.hasNext() == false) goto L23;
        gr.f r31 = (gr.f) r29.next();
        float r32 = r31.d;
        r11[r30] = ((double) r32) * 0.01d;
        double[] r33 = r12[r30];
        float r34 = r31.f17147b;
        r33[0] = r34;
        float r35 = r31.f17148c;
        r33[1] = r35;
        float r118 = r31.e;
        r33[2] = r118;
        com.bytedance.ies.web.jsbridge2.k r36 = this.f18435a;
        ((double[]) r36.f6286c)[r30] = ((double) r31.f17146a) / 100.0d;
        ((float[]) r36.d)[r30] = r32;
        ((float[]) r36.e)[r30] = r35;
        ((float[]) r36.f)[r30] = r118;
        ((float[]) r36.f6285b)[r30] = r34;
        r30 = r30 + 1;
        goto L21
    L23:
        com.bytedance.ies.web.jsbridge2.k r37 = this.f18435a;
        double[] r38 = (double[]) r37.f6286c;
        double[][] r39 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r38.length, 3});
        float[] r40 = (float[]) r37.f6285b;
        r37.f6287h = new double[r40.length + 2];
        r37.f6288i = new double[r40.length + 2];
        double r41 = r38[0];
        float[] r42 = (float[]) r37.d;
        bi.e r119 = (bi.e) r37.f6284a;
        if (r41 <= 0.0d) goto L26;
        r119.c(0.0d, r42[0]);
    L26:
        int r43 = r38.length - 1;
        if (r38[r43] >= 1.0d) goto L29;
        r119.c(1.0d, r42[r43]);
    L29:
        int r44 = 0;
    L31:
        if (r44 >= r39.length) goto L33;
        double[] r45 = r39[r44];
        r45[0] = ((float[]) r37.e)[r44];
        r45[1] = ((float[]) r37.f)[r44];
        r45[2] = r40[r44];
        r119.c(r38[r44], r42[r44]);
        r44 = r44 + 1;
        goto L31
    L33:
        double r46 = 0.0d;
        int r47 = 0;
    L34:
        float[] r48 = (float[]) r119.f931c;
        if (r47 >= r48.length) goto L37;
        r46 = r46 + ((double) r48[r47]);
        r47 = r47 + 1;
        goto L34
    L37:
        double r120 = 0.0d;
        int r121 = 1;
    L38:
        float[] r49 = (float[]) r119.f931c;
        if (r121 >= r49.length) goto L41;
        int r50 = r121 - 1;
        float r51 = (r49[r50] + r49[r121]) / 2.0f;
        double[] r122 = (double[]) r119.d;
        r120 = ((r122[r121] - r122[r50]) * ((double) r51)) + r120;
        r121 = r121 + 1;
        goto L38
    L41:
        int r52 = 0;
    L42:
        float[] r53 = (float[]) r119.f931c;
        if (r52 >= r53.length) goto L45;
        r53[r52] = r53[r52] * ((float) (r46 / r120));
        r52 = r52 + 1;
        r39 = r39;
        r11 = r11;
        goto L42
    L45:
        double[][] r210 = r39;
        double[] r123 = r11;
        ((double[]) r119.e)[0] = 0.0d;
        int r124 = 1;
    L46:
        float[] r54 = (float[]) r119.f931c;
        if (r124 >= r54.length) goto L50;
        int r55 = r124 - 1;
        float r56 = (r54[r55] + r54[r124]) / 2.0f;
        double[] r57 = (double[]) r119.d;
        double r58 = r57[r124] - r57[r55];
        double[] r59 = (double[]) r119.e;
        r59[r124] = (r58 * ((double) r56)) + r59[r55];
        r124 = r124 + 1;
        goto L46
    L50:
        if (r38.length <= 1) goto L52;
        int r60 = 0;
        r37.g = qo.a.u(0, r38, r210);
    L53:
        qo.a.u(r60, r123, r12);
        return;
    L52:
        r60 = 0;
        r37.g = null;
        goto L53
    }

    public final String toString() {
        String r5 = this.f18436b;
        DecimalFormat r10 = new DecimalFormat("##.##");
        Iterator r11 = this.f.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        gr.f r12 = (gr.f) r11.next();
        StringBuilder r13 = j0.w(r5, "[");
        r13.append(r12.f17146a);
        r13.append(" , ");
        r13.append(r10.format(r12.f17147b));
        r13.append("] ");
        r5 = r13.toString();
        goto L4
    L6:
        return r5;
    }
}
