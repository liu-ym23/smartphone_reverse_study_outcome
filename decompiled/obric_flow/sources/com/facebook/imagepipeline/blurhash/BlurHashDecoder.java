package com.facebook.imagepipeline.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class BlurHashDecoder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f7997c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f7998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f7999b;

    static {
        List r5 = Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', Character.valueOf(Typography.dollar), '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'});
        HashMap r10 = new HashMap();
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L6;
        r10.put(r5.get(r11), Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        f7997c = r10;
    }

    public BlurHashDecoder() {
        this.f7998a = new SparseArray();
        this.f7999b = new SparseArray();
    }

    public final Bitmap a(String r24, int r25, int r26, float r27, boolean r28) {
        int r5 = r25;
        int r10 = 3;
        char r11 = 0;
        int r12 = 2;
        int r13 = 1;
        if (r24 == null) goto L75;
        int r14 = 6;
        if (r24.length() < 6) goto L75;
        int r15 = a(r24, 0, 1);
        int r16 = (r15 % 9) + 1;
        int r17 = (r15 / 9) + 1;
        if (r24.length() == (((r16 * 2) * r17) + 4)) goto L10;
        return null;
    L10:
        float r18 = (a(r24, 1, 2) + 1) / 166.0f;
        int r19 = r16 * r17;
        float[][] r110 = new float[r19][];
        int r111 = 0;
    L11:
        if (r111 >= r19) goto L16;
        if (r111 != 0) goto L14;
        int r20 = a(r24, r12, r14);
        float r112 = a(r20 >> 16);
        float r113 = a((r20 >> 8) & 255);
        float r21 = a(r20 & 255);
        float[] r22 = new float[r10];
        r22[r11] = r112;
        r22[r13] = r113;
        r22[2] = r21;
        r110[r111] = r22;
        int r23 = r13;
        int r29 = r10;
        int r30 = r23;
    L15:
        r111 = r111 + r30;
        r18 = r18;
        r19 = r19;
        r11 = 0;
        r12 = 2;
        r14 = 6;
        int r210 = r29;
        r13 = r30;
        r10 = r210;
        goto L11
    L14:
        int r31 = r111 * 2;
        int r32 = a(r24, r31 + 4, r31 + 6);
        float r33 = r18 * r27;
        float r114 = ((r32 / 361) - 9) / 9.0f;
        float r34 = (((r32 / 19) % 19) - 9) / 9.0f;
        float r35 = ((r32 % 19) - 9) / 9.0f;
        r29 = 3;
        r30 = 1;
        r110[r111] = new float[]{Math.copySign((float) Math.pow(r114, 2.0d), r114) * r33, Math.copySign((float) Math.pow(r34, 2.0d), r34) * r33, Math.copySign((float) Math.pow(r35, 2.0d), r35) * r33};
        goto L15
    L16:
        int[] r36 = new int[r5 * r26];
        if (r28 == true) goto L19;
    L22:
        boolean r115 = true;
    L23:
        if (r115 == false) goto L25;
        int r37 = r5 * r16;
        double[] r38 = new double[r37];
        this.f7998a.put(r37, r38);
    L29:
        if (r28 == true) goto L31;
    L34:
        boolean r39 = true;
    L35:
        if (r39 == false) goto L37;
        int r40 = r26 * r17;
        double[] r41 = new double[r40];
        this.f7999b.put(r40, r41);
    L41:
        if (r38 == null) goto L43;
        if (r41 == null) goto L43;
        int r42 = 0;
    L45:
        if (r42 >= r26) goto L65;
        int r43 = 0;
    L47:
        if (r43 >= r5) goto L63;
        float r44 = 0.0f;
        float r116 = 0.0f;
        float r117 = 0.0f;
        int r118 = 0;
    L49:
        if (r118 >= r17) goto L62;
        float r119 = r117;
        int r120 = 0;
    L51:
        if (r120 >= r16) goto L61;
        if (r115 == false) goto L56;
        r38[(r16 * r43) + r120] = Math.cos(((((double) r43) * 3.141592653589793d) * ((double) r120)) / ((double) r5));
    L56:
        double r45 = r38[(r16 * r43) + r120];
        if (r39 == false) goto L59;
        int r121 = (r17 * r42) + r118;
        r118 = r118;
        r41[r121] = Math.cos(((((double) r42) * 3.141592653589793d) * ((double) r118)) / ((double) r26));
    L60:
        float r46 = (float) (r45 * r41[(r17 * r42) + r118]);
        float[] r47 = r110[(r118 * r16) + r120];
        r44 = (r47[0] * r46) + r44;
        r119 = (r47[1] * r46) + r119;
        r116 = r116 + (r47[2] * r46);
        r120 = r120 + 1;
        r41 = r41;
        r5 = r25;
        r38 = r38;
        r39 = r39;
        r36 = r36;
        r110 = r110;
        goto L51
    L59:
        r118 = r118;
        goto L60
    L61:
        r118 = r118 + 1;
        r41 = r41;
        r5 = r25;
        r38 = r38;
        r39 = r39;
        r117 = r119;
        goto L49
    L62:
        int[] r122 = r36;
        int r48 = r5;
        r122[(r48 * r42) + r43] = Color.rgb(a(r44), a(r117), a(r116));
        r43 = r43 + 1;
        r41 = r41;
        r38 = r38;
        r39 = r39;
        r5 = r48;
        r36 = r122;
        goto L47
    L63:
        r42 = r42 + 1;
        r41 = r41;
        r38 = r38;
        r39 = r39;
        r36 = r36;
        goto L45
    L65:
        return Bitmap.createBitmap(r36, r5, r26, Bitmap.Config.ARGB_8888);
    L43:
        return null;
    L37:
        r41 = (double[]) this.f7999b.get(r26 * r17);
        if (r41 != null) goto L41;
        r41 = null;
        goto L41
    L31:
        if (this.f7999b.get(r26 * r17) == null) goto L34;
        r39 = false;
        goto L35
    L25:
        Object r49 = this.f7998a.get(r5 * r16);
        if (r49 == null) goto L28;
        r38 = (double[]) r49;
        goto L29
    L28:
        r38 = null;
        goto L29
    L19:
        if (this.f7998a.get(r26 * r17) == null) goto L22;
        r115 = false;
    L75:
        return null;
    }

    public static int a(String r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r10 >= r11) goto L11;
        Integer r13 = (Integer) f7997c.get(Character.valueOf(r5.charAt(r10)));
        if (r13 == null) goto L7;
        int r14 = r13.intValue();
    L8:
        if (r14 == (-1)) goto L10;
        r12 = (r12 * 83) + r14;
    L10:
        r10 = r10 + 1;
        goto L3
    L7:
        r14 = -1;
        goto L8
    L11:
        return r12;
    }

    public static float a(int r5) {
        float r10 = r5 / 255.0f;
        if (r10 > 0.04045f) goto L7;
        return r10 / 12.92f;
    L7:
        return (float) Math.pow((r10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int a(float r5) {
        float r10 = 0.0f;
        if (r5 >= 0.0f) goto L5;
    L4:
        r5 = r10;
    L9:
        if (r5 > 0.0031308f) goto L13;
        return (int) (((r5 * 12.92f) * 255.0f) + 0.5f);
    L13:
        return (int) ((((Math.pow(r5, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d) * 255.0d) + 0.5d);
    L5:
        r10 = 1.0f;
        if (r5 <= 1.0f) goto L9;
        goto L4
    }
}
