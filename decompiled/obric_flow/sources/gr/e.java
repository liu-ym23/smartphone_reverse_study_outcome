package gr;

import android.view.View;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f17143c = null;
    public static final String[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f17145b;

    static {
        f17143c = new e(0);
        d = new String[]{"standard", "accelerate", "decelerate", "linear"};
    }

    public e(int r5) {
        this.f17144a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f17145b = "identity";
        return;
    L6:
        this.f17145b = new HashMap();
    }

    public static e d(String r21) {
        byte r5 = 3;
        if (r21 != null) goto L7;
        return null;
    L7:
        if (r21.startsWith("cubic") == false) goto L11;
        return new d(r21);
    L11:
        if (r21.startsWith("spline") == false) goto L26;
        k r10 = new k(0);
        r10.f17145b = r21;
        double[] r11 = new double[r21.length() / 2];
        int r12 = r21.indexOf(40) + 1;
        int r13 = r21.indexOf(44, r12);
        int r14 = 0;
    L13:
        if (r13 == (-1)) goto L15;
        r11[r14] = Double.parseDouble(r21.substring(r12, r13).trim());
        r12 = r13 + 1;
        r13 = r21.indexOf(44, r12);
        r14 = r14 + 1;
        goto L13
    L15:
        r11[r14] = Double.parseDouble(r21.substring(r12, r21.indexOf(41, r12)).trim());
        double[] r15 = Arrays.copyOf(r11, r14 + 1);
        int r16 = (r15.length * 3) - 2;
        int r17 = r15.length - 1;
        double r18 = 1.0d / ((double) r17);
        double[][] r19 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r16, 1});
        double[] r20 = new double[r16];
        int r110 = 0;
    L17:
        if (r110 >= r15.length) goto L23;
        double r111 = r15[r110];
        int r112 = r110 + r17;
        r19[r112][0] = r111;
        k r113 = r10;
        double r22 = ((double) r110) * r18;
        r20[r112] = r22;
        if (r110 <= 0) goto L21;
        int r114 = (r17 * 2) + r110;
        r19[r114][0] = r111 + 1.0d;
        r20[r114] = r22 + 1.0d;
        int r115 = 1;
        int r116 = r110 - 1;
        r19[r116][0] = (r111 - 1.0d) - r18;
        r20[r116] = (r22 - 1.0d) - r18;
    L22:
        r110 = r110 + r115;
        r10 = r113;
        goto L17
    L21:
        r115 = 1;
        goto L22
    L23:
        k r117 = r10;
        h r23 = new h(r20, r19);
        PrintStream r24 = System.out;
        r24.println(" 0 " + r23.v(0.0d));
        r24.println(" 1 " + r23.v(1.0d));
        r117.e = r23;
        return r117;
    L26:
        if (r21.startsWith("Schlick") == false) goto L30;
        i r25 = new i(0);
        r25.f17145b = r21;
        int r26 = r21.indexOf(40);
        int r27 = r21.indexOf(44, r26);
        r25.e = Double.parseDouble(r21.substring(r26 + 1, r27).trim());
        int r28 = r27 + 1;
        r25.f = Double.parseDouble(r21.substring(r28, r21.indexOf(44, r28)).trim());
        return r25;
    L30:
        switch(r21.hashCode()) {
            case -1354466595: goto L52;
            case -1263948740: goto L48;
            case -1197605014: goto L44;
            case -1102672091: goto L41;
            case -749065269: goto L37;
            case 1312628413: goto L33;
            default: goto L31;
        };
    L31:
        r5 = -1;
    L55:
        switch(r5) {
            case 0: goto L69;
            case 1: goto L67;
            case 2: goto L65;
            case 3: goto L63;
            case 4: goto L61;
            case 5: goto L59;
            default: goto L56;
        };
    L56:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(d));
        return f17143c;
    L59:
        return new d("cubic(0.4, 0.0, 0.2, 1)");
    L61:
        return new d("cubic(0.34, 1.56, 0.64, 1)");
    L63:
        return new d("cubic(1, 1, 0, 0)");
    L65:
        return new d("cubic(0.36, 0, 0.66, -0.56)");
    L67:
        return new d("cubic(0.0, 0.0, 0.2, 0.95)");
    L69:
        return new d("cubic(0.4, 0.05, 0.8, 0.7)");
    L33:
        if (r21.equals("standard") == false) goto L74;
        r5 = 5;
        goto L55
    L74:
        r5 = -1;
        goto L55
    L37:
        if (r21.equals("overshoot") == false) goto L75;
        r5 = 4;
        goto L55
    L75:
        r5 = -1;
        goto L55
    L41:
        if (r21.equals("linear") == true) goto L55;
        r5 = -1;
        goto L55
    L44:
        if (r21.equals("anticipate") == false) goto L77;
        r5 = 2;
        goto L55
    L77:
        r5 = -1;
        goto L55
    L48:
        if (r21.equals("decelerate") == false) goto L78;
        r5 = 1;
        goto L55
    L78:
        r5 = -1;
        goto L55
    L52:
        if (r21.equals("accelerate") == false) goto L79;
        r5 = 0;
        goto L55
    L79:
        r5 = -1;
        goto L55
    }

    public double a(double r5) {
        return r5;
    }

    public double b(double r5) {
        return 1.0d;
    }

    public float c(View r5, String r10) {
        HashMap r11 = (HashMap) this.f17145b;
        if (r11.containsKey(r5) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap r12 = (HashMap) r11.get(r5);
        if (r12 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r12.containsKey(r10) == false) goto L17;
        float[] r13 = (float[]) r12.get(r10);
        if (r13 != null) goto L14;
        return Float.NaN;
    L14:
        if (r13.length <= 0) goto L17;
        return r13[0];
    }

    public String toString() {
        switch(this.f17144a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return (String) this.f17145b;
    }
}
