package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f1330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f1331i;

    public static class a extends c {
        public a() {
        }
    }

    public static class b extends a {
        public b() {
        }
    }

    public static class c {
        public c() {
        }
    }

    static {
        new RectF();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public z(TextView r8) {
        this.f1323a = 0;
        this.f1324b = false;
        this.f1325c = -1.0f;
        this.f1326d = -1.0f;
        this.f1327e = -1.0f;
        this.f1328f = new int[0];
        this.f1329g = false;
        this.f1330h = r8;
        this.f1331i = r8.getContext();
        new b();
    }

    public static int[] a(int[] r8) {
        int r10 = r8.length;
        if (r10 != 0) goto L5;
        return r8;
    L5:
        Arrays.sort(r8);
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L14;
        int r14 = r8[r13];
        if (r14 <= 0) goto L12;
        if (Collections.binarySearch(r11, Integer.valueOf(r14)) >= 0) goto L12;
        r11.add(Integer.valueOf(r14));
    L12:
        r13 = r13 + 1;
        goto L6
    L14:
        if (r10 != r11.size()) goto L16;
        return r8;
    L16:
        int r15 = r11.size();
        int[] r16 = new int[r15];
    L17:
        if (r12 >= r15) goto L19;
        r16[r12] = ((Integer) r11.get(r12)).intValue();
        r12 = r12 + 1;
        goto L17
    L19:
        return r16;
    }

    public final boolean b() {
        int r8 = 0;
        if (d() == true) goto L5;
    L15:
        this.f1324b = false;
    L17:
        return this.f1324b;
    L5:
        if (this.f1323a != 1) goto L15;
        if (this.f1329g == true) goto L9;
    L10:
        int r10 = ((int) Math.floor((this.f1327e - this.f1326d) / this.f1325c)) + 1;
        int[] r11 = new int[r10];
    L11:
        if (r8 >= r10) goto L13;
        r11[r8] = Math.round((r8 * this.f1325c) + this.f1326d);
        r8 = r8 + 1;
        goto L11
    L13:
        this.f1328f = a(r11);
    L14:
        this.f1324b = true;
        goto L17
    L9:
        if (this.f1328f.length != 0) goto L14;
        goto L10
    }

    public final boolean c() {
        int[] r8 = this.f1328f;
        int r10 = r8.length;
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.f1329g = r11;
        if (r11 == false) goto L9;
        this.f1323a = 1;
        this.f1326d = r8[0];
        this.f1327e = r8[r10 - 1];
        this.f1325c = -1.0f;
    L9:
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    public final boolean d() {
        return !(this.f1330h instanceof AppCompatEditText);
    }

    public final void e(float r8, float r10, float r11) {
        if (r8 <= 0.0f) goto L15;
        if (r10 <= r8) goto L13;
        if (r11 <= 0.0f) goto L11;
        this.f1323a = 1;
        this.f1326d = r8;
        this.f1327e = r10;
        this.f1325c = r11;
        this.f1329g = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r11 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r10 + "px) is less or equal to minimum auto-size text size (" + r8 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r8 + "px) is less or equal to (0px)");
    }
}
