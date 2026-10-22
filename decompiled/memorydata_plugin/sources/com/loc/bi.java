package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class bi extends bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5355b;
    private boolean d;
    private int e;
    private int f;
    private int g;

    public bi(Context r8, boolean r9, int r10, int r11, String r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        this.f5354a = "iKey";
        this.g = 0;
        a(r1, r9, r10, r11, r12, 0);
    }

    public bi(Context r8, boolean r9, int r10, int r11, String r12, int r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        this.f5354a = "iKey";
        this.g = 0;
        a(r1, r9, r10, r11, r12, r13);
    }

    private void a(Context r3, boolean r4, int r5, int r6, String r7, int r8) {
        this.f5355b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.f5354a = r7;
        this.g = r8;
    }

    @Override // com.loc.bl
    public final void a(int r6) {
        if (fp.j(this.f5355b) != 1) goto L5;
        return;
    L5:
        String r0 = fx.a(System.currentTimeMillis(), "yyyyMMdd");
        String r2 = o.a(this.f5355b, this.f5354a);
        if (TextUtils.isEmpty(r2) == true) goto L16;
        String[] r3 = r2.split("\\|");
        if (r3 != null) goto L10;
    L15:
        o.b(this.f5355b, this.f5354a);
        goto L16
    L10:
        if (r3.length < 2) goto L15;
        if (r0.equals(r3[0]) == false) goto L16;
        r6 = r6 + Integer.parseInt(r3[1]);
    L16:
        o.a(this.f5355b, this.f5354a, r0 + "|" + r6);
    }

    @Override // com.loc.bl
    public final boolean a() {
        if (fp.j(this.f5355b) != 1) goto L6;
        return true;
    L6:
        if (this.d == true) goto L8;
        return false;
    L8:
        String r0 = o.a(this.f5355b, this.f5354a);
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return true;
    L11:
        String[] r1 = r0.split("\\|");
        if (r1 != null) goto L14;
    L22:
        o.b(this.f5355b, this.f5354a);
        return true;
    L14:
        if (r1.length < 2) goto L22;
        String r3 = r1[0];
        if (fx.a(System.currentTimeMillis(), "yyyyMMdd").equals(r3) == true) goto L19;
    L21:
        return true;
    L19:
        if (Integer.parseInt(r1[1]) < this.f) goto L21;
        return false;
    }

    @Override // com.loc.bl
    public final int b() {
        int r1 = Integer.MAX_VALUE;
        if (fp.j(this.f5355b) == 1) goto L8;
        int r0 = this.e;
        if (r0 <= 0) goto L8;
    L7:
        r1 = r0;
    L13:
        if (this.c != null) goto L15;
        return r1;
    L15:
        return Math.max(r1, this.c.b());
    L8:
        r0 = this.g;
        if (r0 <= 0) goto L13;
        if (r0 >= Integer.MAX_VALUE) goto L13;
        goto L7
    }
}
