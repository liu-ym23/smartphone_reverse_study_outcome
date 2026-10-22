package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends ContextWrapper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f1386j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.b f1389c;
    public final ib.d d;
    public final List e;
    public final ArrayMap f;
    public final s g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bumptech.glide.request.c f1391i;

    static {
        a r5 = new a();
        r5.f1379a = o0.b.f20382a;
        f1386j = r5;
    }

    public c(Context r5, com.bumptech.glide.load.engine.bitmap_recycle.f r10, d r11, s6.b r12, ib.d r13, ArrayMap r14, List r15, s r16) {
        super(r5.getApplicationContext());
        this.f1387a = r10;
        this.f1388b = r11;
        this.f1389c = r12;
        this.d = r13;
        this.e = r15;
        this.f = r14;
        this.g = r16;
        this.f1390h = 4;
    }
}
