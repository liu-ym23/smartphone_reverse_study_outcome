package s8;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f12757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f12758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f12759e;

    public h() {
        this.f12757c = 128.19f;
        this.f12758d = 83.62f;
        this.f12759e = new b(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
    }

    @Override // s8.d
    public Path a(float r46, float r47, float r48, float r49, float r50) {
        Path r10 = new Path();
        float r11 = r48 - r46;
        float r12 = r49 - r47;
        float r13 = Math.min(r11, r12);
        if (r50 == 0.0f) goto L17;
        if (r50 >= (r13 * 0.5f)) goto L17;
        float r14 = r50 / (r13 / 2.0f);
        float r15 = 1.0f;
        if (r14 <= 0.5f) goto L10;
        float r16 = 1.0f - (Math.min(1.0f, (r14 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r14 <= 0.6f) goto L14;
        r15 = 1.0f + (Math.min(1.0f, (r14 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r17 = r50 / 100.0f;
        float r18 = (this.f12757c * r17) * r16;
        float r19 = (this.f12758d * r17) * r15;
        b r110 = new b(r17 * this.f12759e.e(), r17 * this.f12759e.d(), r17 * this.f12759e.c(), r17 * this.f12759e.f(), r17 * this.f12759e.a(), r17 * this.f12759e.b());
        float r20 = (r11 / 2.0f) + r46;
        e r21 = new e(r20, r47);
        float r111 = r48 - r18;
        e r22 = new e(Math.max(r20, r111), r47);
        float r112 = r48 - r19;
        e r113 = new e(r112, r47);
        e r114 = new e(r48 - r110.e(), r47 + r110.b());
        e r115 = new e(r48 - r110.d(), r47 + r110.a());
        e r116 = new e(r48 - r110.c(), r47 + r110.f());
        e r117 = new e(r48 - r110.f(), r47 + r110.c());
        e r118 = new e(r48 - r110.a(), r47 + r110.d());
        e r119 = new e(r48 - r110.b(), r47 + r110.e());
        float r120 = r47 + r19;
        e r121 = new e(r48, r120);
        float r23 = r12 / 2.0f;
        e r122 = new e(r48, r47 + Math.min(r23, r18));
        float r24 = r23 + r47;
        float r123 = r49 - r18;
        e r124 = new e(r48, Math.max(r24, r123));
        float r125 = r49 - r19;
        e r25 = new e(r48, r125);
        e r26 = new e(r48 - r110.b(), r49 - r110.e());
        e r27 = new e(r48 - r110.a(), r49 - r110.d());
        e r28 = new e(r48 - r110.f(), r49 - r110.c());
        e r29 = new e(r48 - r110.c(), r49 - r110.f());
        e r30 = new e(r48 - r110.d(), r49 - r110.a());
        e r31 = new e(r48 - r110.e(), r49 - r110.b());
        e r32 = new e(r112, r49);
        e r126 = new e(Math.max(r20, r111), r49);
        float r33 = r46 + r18;
        e r127 = new e(Math.min(r20, r33), r49);
        float r34 = r19 + r46;
        e r35 = new e(r34, r49);
        e r128 = new e(r46 + r110.e(), r49 - r110.b());
        e r129 = new e(r110.d() + r46, r49 - r110.a());
        e r130 = new e(r110.c() + r46, r49 - r110.f());
        e r131 = new e(r110.f() + r46, r49 - r110.c());
        e r132 = new e(r110.a() + r46, r49 - r110.d());
        e r133 = new e(r110.b() + r46, r49 - r110.e());
        e r36 = new e(r46, r125);
        e r134 = new e(r46, Math.max(r24, r123));
        e r135 = new e(r46, Math.min(r24, r47 + r18));
        e r136 = new e(r46, r120);
        e r137 = new e(r110.b() + r46, r110.e() + r47);
        e r37 = new e(r110.a() + r46, r47 + r110.d());
        e r38 = new e(r110.f() + r46, r47 + r110.c());
        e r39 = new e(r110.c() + r46, r47 + r110.f());
        e r40 = new e(r110.d() + r46, r47 + r110.a());
        e r41 = new e(r46 + r110.e(), r110.b() + r47);
        e r42 = new e(r34, r47);
        e r43 = new e(Math.min(r20, r33), r47);
        r10.moveTo(r21.c(), r21.d());
        r10.lineTo(r22.c(), r22.d());
        r10.cubicTo(r113.c(), r113.d(), r114.c(), r114.d(), r115.c(), r115.d());
        r10.cubicTo(r116.c(), r116.d(), r117.c(), r117.d(), r118.c(), r118.d());
        r10.cubicTo(r119.c(), r119.d(), r121.c(), r121.d(), r122.c(), r122.d());
        r10.lineTo(r124.c(), r124.d());
        r10.cubicTo(r25.c(), r25.d(), r26.c(), r26.d(), r27.c(), r27.d());
        r10.cubicTo(r28.c(), r28.d(), r29.c(), r29.d(), r30.c(), r30.d());
        r10.cubicTo(r31.c(), r31.d(), r32.c(), r32.d(), r126.c(), r126.d());
        r10.lineTo(r127.c(), r127.d());
        r10.cubicTo(r35.c(), r35.d(), r128.c(), r128.d(), r129.c(), r129.d());
        r10.cubicTo(r130.c(), r130.d(), r131.c(), r131.d(), r132.c(), r132.d());
        r10.cubicTo(r133.c(), r133.d(), r36.c(), r36.d(), r134.c(), r134.d());
        r10.lineTo(r135.c(), r135.d());
        r10.cubicTo(r136.c(), r136.d(), r137.c(), r137.d(), r37.c(), r37.d());
        r10.cubicTo(r38.c(), r38.d(), r39.c(), r39.d(), r40.c(), r40.d());
        r10.cubicTo(r41.c(), r41.d(), r42.c(), r42.d(), r43.c(), r43.d());
        r10.close();
        return r10;
    L10:
        r16 = 1.0f;
    L17:
        return b(r46, r47, r48, r49, r50);
    }

    @Override // s8.d
    public boolean c(float r10, float r11) {
        if (r10 >= (r11 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
