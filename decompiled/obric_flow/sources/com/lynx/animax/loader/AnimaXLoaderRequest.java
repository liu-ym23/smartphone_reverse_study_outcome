package com.lynx.animax.loader;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXLoaderRequest implements IAnimaXLoaderRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimaXLoaderScheme f9626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JavaOnlyMap f9627c;

    public AnimaXLoaderRequest(String r5, JavaOnlyMap r10) {
        this.f9625a = r5;
        this.f9627c = r10;
        if (r10 != null) goto L5;
    L8:
        this.f9626b = null;
        return;
    L5:
        if (r10.get("scheme") == null) goto L8;
        this.f9626b = AnimaXLoaderScheme.values()[((Integer) r10.get("scheme")).intValue()];
    }

    @CalledByNative
    public static AnimaXLoaderRequest createRequest(String r5) {
        return new AnimaXLoaderRequest(r5, null);
    }

    @CalledByNative
    public static AnimaXLoaderRequest createRequestWithParams(String r5, JavaOnlyMap r10) {
        return new AnimaXLoaderRequest(r5, r10);
    }

    public final String a() {
        String r5 = null;
        String r10 = this.f9625a;
        if (r10 != null) goto L5;
        Uri r11 = null;
    L6:
        if (r11 != null) goto L8;
        String r12 = null;
    L10:
        if ("asset".equals(r12) == true) goto L35;
        if (r11 != null) goto L13;
        String r13 = null;
    L15:
        if ("file".equals(r13) == true) goto L35;
        if (r11 == null) goto L20;
        r5 = r11.getScheme();
    L20:
        if (IIvyAIPackageResourceService.SCHEMA.equals(r5) == true) goto L35;
        if ("http".equals(r5) == true) goto L35;
        AnimaXLoaderScheme r14 = this.f9626b;
        if (r14 == null) goto L35;
        if (r14 != AnimaXLoaderScheme.f9632a) goto L32;
        return new Uri.Builder().scheme("asset").authority("").path(r10).build().toString();
    L32:
        if (r14 != AnimaXLoaderScheme.f9633b) goto L35;
        return new Uri.Builder().scheme("file").authority("").path(r10).build().toString();
    L13:
        r13 = r11.getScheme();
    L35:
        return r10;
    L8:
        r12 = r11.getScheme();
        goto L10
    L5:
        r11 = Uri.parse(r10);
        goto L6
    }
}
