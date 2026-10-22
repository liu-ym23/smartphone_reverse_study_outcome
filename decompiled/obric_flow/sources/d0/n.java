package d0;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class n implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16562b;

    public n(Context r5, int r10) {
        this.f16561a = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        this.f16562b = r5;
        return;
    L6:
        this.f16562b = r5.getApplicationContext();
        return;
    L8:
        this.f16562b = r5.getApplicationContext();
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        switch(this.f16561a) {
            case 0: goto L19;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        Uri r10 = (Uri) r5;
        if (av.i.s(r10) == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.getPathSegments().contains("video") == false) goto L9;
        return true;
    L11:
        Uri r11 = (Uri) r5;
        if (av.i.s(r11) == true) goto L14;
    L16:
        return false;
    L14:
        if (r11.getPathSegments().contains("video") == true) goto L16;
        return true;
    L19:
        return av.i.s((Uri) r5);
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        switch(this.f16561a) {
            case 0: goto L28;
            case 1: goto L18;
            default: goto L4;
        };
    L4:
        Uri r13 = (Uri) r5;
        if (r10 == Integer.MIN_VALUE) goto L16;
        if (r11 == Integer.MIN_VALUE) goto L16;
        if (r10 > 512) goto L16;
        if (r11 > 384) goto L16;
        Long r14 = (Long) r12.c(com.bumptech.glide.load.resource.bitmap.z.d);
        if (r14 == null) goto L16;
        if (r14.longValue() != (-1)) goto L16;
        p0.b r15 = new p0.b(r13);
        Context r16 = this.f16562b;
        a0.a r17 = new a0.a(r16.getContentResolver(), 1);
        com.bumptech.glide.load.engine.bitmap_recycle.f r18 = com.bumptech.glide.b.b(r16).e;
        a0.d r19 = new a0.d(com.bumptech.glide.b.b(r16).d.e(), r17, r18, r16.getContentResolver());
        return new q(r15, new a0.b(0, r13, r19));
    L16:
        return null;
    L18:
        Uri r20 = (Uri) r5;
        if (r10 == Integer.MIN_VALUE) goto L26;
        if (r11 == Integer.MIN_VALUE) goto L26;
        if (r10 > 512) goto L26;
        if (r11 > 384) goto L26;
        p0.b r21 = new p0.b(r20);
        Context r22 = this.f16562b;
        a0.a r23 = new a0.a(r22.getContentResolver(), 0);
        com.bumptech.glide.load.engine.bitmap_recycle.f r24 = com.bumptech.glide.b.b(r22).e;
        a0.d r25 = new a0.d(com.bumptech.glide.b.b(r22).d.e(), r23, r24, r22.getContentResolver());
        return new q(r21, new a0.b(0, r20, r25));
    L26:
        return null;
    L28:
        Uri r26 = (Uri) r5;
        return new q(new p0.b(r26), new m(0, this.f16562b, r26));
    }
}
