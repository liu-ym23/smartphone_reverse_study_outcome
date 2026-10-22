package com.bumptech.glide.load.resource.bitmap;

import ai.j0;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.d0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1606b;

    public /* synthetic */ e(l r5, int r10) {
        this.f1605a = r10;
        this.f1606b = r5;
    }

    @Override // z.g
    public final boolean a(Object r5, z.f r10) {
        switch(this.f1605a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        ParcelFileDescriptor r11 = (ParcelFileDescriptor) r5;
        return true;
    L8:
        ByteBuffer r12 = (ByteBuffer) r5;
        return true;
    L5:
        return ((Uri) r5).getScheme().equals("android.resource");
    }

    @Override // z.g
    public final d0 b(Object r10, int r11, int r12, z.f r13) {
        Object r5 = this.f1606b;
        switch(this.f1605a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        l r14 = (l) r5;
        return r14.a(new com.google.common.reflect.w((ParcelFileDescriptor) r10, r14.d, r14.f1623c), r11, r12, r13, l.f1618k);
    L8:
        int r15 = q0.b.f21445a;
        q0.a r16 = new q0.a((ByteBuffer) r10);
        wc.f r17 = l.f1618k;
        l r18 = (l) r5;
        ArrayList r19 = r18.d;
        return r18.a(new com.google.common.reflect.w(r18.f1623c, r16, r19), r11, r12, r13, r17);
    L5:
        return c((Uri) r10);
    }

    public d0 c(Uri r10) {
        String r5 = r10.getAuthority();
        Context r11 = (Context) this.f1606b;
        if (r5.equals(r11.getPackageName()) == false) goto L35;
    L4:
        Context r12 = r11;
    L11:
        List<String> r13 = r10.getPathSegments();
        if (r13.size() != 2) goto L21;
        List<String> r14 = r10.getPathSegments();
        String r15 = r10.getAuthority();
        String r16 = r14.get(0);
        String r17 = r14.get(1);
        int r18 = r12.getResources().getIdentifier(r17, r16, r15);
        if (r18 != 0) goto L16;
        r18 = Resources.getSystem().getIdentifier(r17, r16, "android");
    L16:
        if (r18 == 0) goto L19;
    L24:
        Drawable r19 = td.c.h(r11, r12, r18, null);
        if (r19 != null) goto L27;
        return null;
    L27:
        return new h0.b(r19);
    L19:
        throw new IllegalArgumentException(j0.i(r10, "Failed to find resource id for: "));
    L21:
        if (r13.size() != 1) goto L32;
        r18 = Integer.parseInt(r10.getPathSegments().get(0));     // Catch: NumberFormatException -> L28
    L28:
        e = move-exception;
        throw new IllegalArgumentException(j0.i(r10, "Unrecognized Uri format: "), e);
    L32:
        throw new IllegalArgumentException(j0.i(r10, "Unrecognized Uri format: "));
    L35:
        r12 = r11.createPackageContext(r5, 0);     // Catch: PackageManager.NameNotFoundException -> L7
    L7:
        e = move-exception;
        if (r5.contains(r11.getPackageName()) == true) goto L4;
        throw new IllegalArgumentException(j0.i(r10, "Failed to obtain context or unrecognized Uri format for: "), e);
    }

    public e(Context r5) {
        this.f1605a = 2;
        this.f1606b = r5.getApplicationContext();
    }
}
