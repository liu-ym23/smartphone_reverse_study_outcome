package com.ss.android.lark.newemoji.larkemoji;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements a {
    public final String a;
    public final LiveData<String> b;
    public final List<String> c;

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final Bitmap a() {
        return g(this.a);
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final Bitmap d() {
        return g((String) this.b.getValue());
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final int getHeight() {
        qsb.a r0 = qsb.b.a().Q1().get(this.a);
        if (r0 != null) goto L7;
        return 32;
    L7:
        return r0.a();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final int getWidth() {
        qsb.a r0 = qsb.b.a().Q1().get(this.a);
        if (r0 != null) goto L7;
        return 32;
    L7:
        return r0.c();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final String b() {
        return this.a;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final List<String> e() {
        return this.c;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final LiveData<String> f() {
        return this.b;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final String getId() {
        return this.a;
    }

    public static Bitmap g(String r2) {
        ConcurrentHashMap<String, qsb.a> r0 = qsb.b.a().Q1();
        if (r2 != null) goto L5;
        String r1 = "";
    L6:
        qsb.a r3 = r0.get(r1);
        if (r3 == null) goto L9;
        Bitmap r4 = r3.b();
    L10:
        if (r4 != null) goto L13;
        if (r2 == null) goto L13;
        qsb.b.a().sb(r2);
    L13:
        return r4;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = r2;
        goto L6
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final boolean c(boolean r5) {
        if (g(this.a) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r5 == true) goto L8;
        return r0;
    L8:
        qsb.a r6 = qsb.b.a().Q1().get(this.a);
        if (r6 != null) goto L11;
        return false;
    L11:
        Iterator<String> r7 = r6.f.iterator();
    L13:
        if (r7.hasNext() == false) goto L20;
        String r2 = r7.next();
        qsb.a r3 = qsb.b.a().Q1().get(r2);
        if (r3 == null) goto L17;
        Bitmap r4 = r3.b();
    L18:
        if (r4 != null) goto L13;
        return false;
    L17:
        r4 = null;
        goto L18
    L20:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof b) == true) goto L5;
        return false;
    L5:
        b r5 = (b) r4;
        if (Intrinsics.areEqual(this.a, r5.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r5.b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public b(String r2, MutableLiveData r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "skinedReactionKey");
        this.a = r2;
        this.b = r3;
        qsb.a r4 = qsb.b.a().Q1().get(r2);
        if (r4 == null) goto L7;
        List<String> r5 = r4.f;
        if (r5 == null) goto L7;
    L8:
        this.c = r5;
        return;
    L7:
        r5 = CollectionsKt.emptyList();
        goto L8
    }
}
