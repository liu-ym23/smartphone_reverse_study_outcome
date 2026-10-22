package com.bytedance.crash.upload;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;
import org.json.JSONObject;
import t.b0;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements z8.a, b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4136a;

    @Override // z8.a
    public void a(JSONObject r5) {
        sj.k r10 = sj.k.g();
        if (this.f4136a != 1) goto L5;
        String r11 = b.i(com.bytedance.crash.n.f4062j.getEventUploadUrl(), r5.optJSONObject("header"));
    L6:
        r10.getClass();
        if (mh.e.n(r5) == true) goto L19;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        return;
    L10:
        if (b.b(r11, r5.toString(), true).c() == false) goto L18;
        io.reactivex.exceptions.a.i("upload event success");     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L19:
        return;
    L5:
        r11 = b.i(com.bytedance.crash.n.f4062j.getExceptionUploadUrl(), r5.optJSONObject("header"));
        goto L6
    }

    @Override // t.b0
    public Object a(com.airbnb.lottie.parser.moshi.a r20, float r21) {
        ArrayList r5 = new ArrayList();
        if (r20.J() != JsonReader$Token.BEGIN_ARRAY) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        r20.b();
    L9:
        if (r20.g() == false) goto L11;
        r5.add(Float.valueOf((float) r20.n()));
        goto L9
    L11:
        if (r10 == false) goto L14;
        r20.e();
    L14:
        if (this.f4136a != (-1)) goto L16;
        this.f4136a = r5.size() / 4;
    L16:
        int r11 = this.f4136a;
        float[] r12 = new float[r11];
        int[] r13 = new int[r11];
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L17:
        int r17 = this.f4136a * 4;
        if (r14 >= r17) goto L31;
        int r18 = r14 / 4;
        double r19 = ((Float) r5.get(r14)).floatValue();
        int r110 = r14 % 4;
        if (r110 == 0) goto L29;
        if (r110 == 1) goto L28;
        if (r110 != 2) goto L24;
        r16 = (int) (r19 * 255.0d);
    L30:
        r14 = r14 + 1;
        goto L17
    L24:
        if (r110 != 3) goto L30;
        r13[r18] = Color.argb(255, r15, r16, (int) (r19 * 255.0d));
        goto L30
    L28:
        r15 = (int) (r19 * 255.0d);
        goto L30
    L29:
        r12[r18] = (float) r19;
        goto L30
    L31:
        q.c r22 = new q.c(r12, r13);
        if (r5.size() <= r17) goto L54;
        int r23 = (r5.size() - r17) / 2;
        double[] r24 = new double[r23];
        double[] r25 = new double[r23];
        int r26 = 0;
    L36:
        if (r17 >= r5.size()) goto L42;
        if ((r17 % 2) != 0) goto L40;
        r24[r26] = ((Float) r5.get(r17)).floatValue();
    L41:
        r17 = r17 + 1;
        goto L36
    L40:
        r25[r26] = ((Float) r5.get(r17)).floatValue();
        r26 = r26 + 1;
        goto L41
    L42:
        int r27 = 0;
    L43:
        int[] r28 = r22.f21395b;
        if (r27 >= r28.length) goto L54;
        int r29 = r28[r27];
        double r30 = r22.f21394a[r27];
        int r111 = 1;
    L46:
        if (r111 >= r23) goto L52;
        int r112 = r111 - 1;
        double r113 = r24[r112];
        double r114 = r24[r111];
        if (r114 >= r30) goto L49;
        r111 = r111 + 1;
        goto L46
    L49:
        double r115 = r25[r112];
        double r116 = r25[r111];
        PointF r117 = u.e.f22190a;
        double r31 = (((r116 - r115) * ((r30 - r113) / (r114 - r113))) + r115) * 255.0d;
    L53:
        r28[r27] = Color.argb((int) r31, Color.red(r29), Color.green(r29), Color.blue(r29));
        r27 = r27 + 1;
        goto L43
    L52:
        r31 = r25[r23 - 1] * 255.0d;
    L54:
        return r22;
    L5:
        r10 = false;
        goto L6
    }
}
