package com.bumptech.glide.load.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u<DataT> implements o<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o<Integer, DataT> f642b;

    private static final class a implements p<Uri, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f643a;

        a(Context r3) {
            this.f643a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, AssetFileDescriptor> a(s r4) {
            return new u(this.f643a, r4.a(Integer.class, AssetFileDescriptor.class));
        }
    }

    private static final class b implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f644a;

        b(Context r3) {
            this.f644a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, InputStream> a(s r4) {
            return new u(this.f644a, r4.a(Integer.class, InputStream.class));
        }
    }

    u(Context r3, o<Integer, DataT> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        o<Integer, DataT> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
        this.f641a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f642b = r6;
    }

    public static p<Uri, InputStream> a(Context r2) {
        return new b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private o.a<DataT> b(Uri r6, int r7, int r8, com.bumptech.glide.load.e r9) {
        List<String> r0 = r6.getPathSegments();
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin");
        int r2 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this.f641a, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.memorydata.plugin"), r1, this.f641a.getPackageName(), "com.obric.memorydata.plugin");
        if (r2 != 0) goto L10;
        if (Log.isLoggable("ResourceUriLoader", 5) == false) goto L11;
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + r6);
        return null;
    L11:
        return null;
    L10:
        return this.f642b.a(Integer.valueOf(r2), r7, r8, r9);
    }

    public static p<Uri, AssetFileDescriptor> b(Context r2) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private o.a<DataT> c(Uri r7, int r8, int r9, com.bumptech.glide.load.e r10) {
        int r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r7.getPathSegments().get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L11
        if (r3 != 0) goto L10;
        if (Log.isLoggable("ResourceUriLoader", 5) == false) goto L8;
        Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + r7);     // Catch: NumberFormatException -> L11
    L8:
        return null;
    L10:
        return this.f642b.a(Integer.valueOf(r3), r8, r9, r10);
    L11:
        e = move-exception;
        if (Log.isLoggable("ResourceUriLoader", 5) == false) goto L15;
        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + r7, e);
    L15:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<DataT> a2(Uri r4, int r5, int r6, com.bumptech.glide.load.e r7) {
        List<String> r0 = r4.getPathSegments();
        if (r0.size() != 1) goto L7;
        return c(r4, r5, r6, r7);
    L7:
        if (r0.size() != 2) goto L11;
        return b(r4, r5, r6, r7);
    L11:
        if (Log.isLoggable("ResourceUriLoader", 5) == false) goto L15;
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + r4);
        return null;
    L15:
        return null;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r3) {
        if ("android.resource".equals(r3.getScheme()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f641a.getPackageName().equals(r3.getAuthority()) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
