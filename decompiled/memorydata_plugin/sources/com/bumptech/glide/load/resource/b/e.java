package com.bumptech.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bumptech.glide.load.f<Uri, Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Resources.Theme> f833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f834b;

    static {
        f833a = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    }

    public e(Context r3) {
        this.f834b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private int a(Context r4, Uri r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List<String> r0 = r5.getPathSegments();
        if (r0.size() != 2) goto L7;
        return b(r6, r5);
    L7:
        if (r0.size() != 1) goto L11;
        return a(r5);
    L11:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r5);
    }

    private int a(Uri r4) {
        return Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r4.getPathSegments().get(0), String.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Unrecognized Uri format: " + r4, e);
    }

    private Context a(Uri r4, String r5) {
        if (r5.equals(this.f834b.getPackageName()) == true) goto L5;
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f834b.createPackageContext(r5, 0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L8:
        e = move-exception;
        if (r5.contains(this.f834b.getPackageName()) == false) goto L14;
        return this.f834b;
    L14:
        throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + r4, e);
    L5:
        return this.f834b;
    }

    private int b(Context r5, Uri r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List<String> r7 = r6.getPathSegments();
        String r1 = r6.getAuthority();
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.memorydata.plugin");
        int r9 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), r8, r2, r1, "com.obric.memorydata.plugin");
        if (r9 != 0) goto L5;
        r9 = ZeusTransformUtils.getIdentifier(Resources.getSystem(), r8, r2, "android", "com.obric.memorydata.plugin");
    L5:
        if (r9 == 0) goto L8;
        return r9;
    L8:
        throw new IllegalArgumentException("Failed to find resource id for: " + r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public s<Drawable> a2(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        String r7 = r3.getAuthority();
        if (TextUtils.isEmpty(r7) == true) goto L15;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(r3, r7), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r9 = a(r8, r3);
        if (((String) ZeusTransformUtils.preCheckCast(j.a(r7), String.class, "com.obric.memorydata.plugin")).equals(this.f834b.getPackageName()) == false) goto L7;
        Resources.Theme r10 = (Resources.Theme) ZeusTransformUtils.preCheckCast(r6.b(f833a), Resources.Theme.class, "com.obric.memorydata.plugin");
    L8:
        Context r2 = this.f834b;
        if (r10 != null) goto L11;
        Drawable r11 = b.a(r2, r8, r9);
    L13:
        return d.a(r11);
    L11:
        r11 = b.a(r2, r9, r10);
        goto L13
    L7:
        r10 = null;
        goto L8
    L15:
        throw new IllegalStateException("Package name for " + r3 + " is null or empty");
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<Drawable> a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1, com.bumptech.glide.load.e r2) {
        String r0 = r1.getScheme();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals("android.resource") == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(Uri r3, com.bumptech.glide.load.e r4) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4);
    }
}
