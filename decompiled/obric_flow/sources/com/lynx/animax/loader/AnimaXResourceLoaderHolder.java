package com.lynx.animax.loader;

import am.d;
import androidx.annotation.RestrictTo;
import bm.a;
import com.lynx.animax.UIAnimaX;
import com.lynx.animax.g;
import com.lynx.animax.util.AnimaXLog;
import em.b;
import em.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXResourceLoaderHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f9637c;

    public AnimaXResourceLoaderHolder(g r10) {
        ArrayList r5 = new ArrayList();
        this.f9636b = r5;
        this.f9637c = null;
        this.f9635a = nativeCreate();
        long r11 = this.f9635a;
        a r12 = new a(3);
        r12.f960b = r11;
        this.f9637c = new d(this, r12);
        AnimaXLoader r13 = AnimaXLoader.create(new em.a(0));
        r5.add(r13);
        nativeRegisterLoaderForScheme(this.f9635a, r13, 0);
        AnimaXLoader r14 = AnimaXLoader.create(new em.a(2));
        r5.add(r14);
        nativeRegisterLoaderForScheme(this.f9635a, r14, 1);
        AnimaXLoader r15 = AnimaXLoader.create(new em.a(1));
        r5.add(r15);
        nativeRegisterLoaderForScheme(this.f9635a, r15, 3);
        if (r10 != null) goto L6;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXResourceLoaderHolder", "resourceFactory is null");
        return;
    L6:
        UIAnimaX r16 = r10.f9616a;
        List r17 = Collections.singletonList(new c(r16.f9559b, r16.f9558a));
        if (r17 != null) goto L10;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXResourceLoaderHolder", "loaders is null");
        return;
    L10:
        Iterator r18 = r17.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        b r19 = (b) r18.next();
        AnimaXLoader r20 = AnimaXLoader.create(r19);
        this.f9636b.add(r20);
        nativeRegisterLoaderForScheme(this.f9635a, r20, r19.a().ordinal());
        goto L12
    }

    public static /* synthetic */ void a(long r5) {
        nativeDestroy(r5);
    }

    private static native long nativeCreate();

    private static native void nativeDestroy(long r5);

    private static native void nativeRegisterLoaderForScheme(long r5, AnimaXLoader r10, int r11);
}
