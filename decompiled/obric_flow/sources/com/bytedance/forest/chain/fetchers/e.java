package com.bytedance.forest.chain.fetchers;

import android.util.Pair;
import com.bytedance.geckox.model.LocalPackageModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends pa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GeckoFetcher f4288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f4289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4290c;
    public final /* synthetic */ String d;

    public e(GeckoFetcher r5, m r10, String r11, String r12) {
        this.f4288a = r5;
        this.f4289b = r10;
        this.f4290c = r11;
        this.d = r12;
    }

    @Override // pa.a
    public final void b(final LocalPackageModel r10) {
        com.bytedance.forest.utils.d.c(this.f4288a.getContext$forest_release().g, 6, GeckoXAdapter.TAG, null, null, new GeckoFetcher$checkUpdate$updateListener$1$onLocalNewestVersion$1(r10), 28);
        r10.getChannelPath();
        Long r11 = Long.valueOf(r10.getLatestVersion());
        this.f4289b.a(this.f4290c, r11);
    }

    @Override // pa.a
    public final void c(Throwable r10) {
        com.bytedance.forest.utils.d.c(this.f4288a.getContext$forest_release().g, 6, GeckoXAdapter.TAG, r10, null, new GeckoFetcher$checkUpdate$updateListener$1$onCheckServerVersionFail$1(), 20);
        this.f4289b.a(this.f4290c, r10);
    }

    @Override // pa.a
    public final void d(final Map r10, final HashMap r11) {
        com.bytedance.forest.utils.d.c(this.f4288a.getContext$forest_release().g, 4, GeckoXAdapter.TAG, null, null, new GeckoFetcher$checkUpdate$updateListener$1$onCheckServerVersionSuccess$1(r10, r11), 28);
        String r5 = this.d;
        String r12 = this.f4290c;
        Object r13 = null;
        if (r10 == null) goto L14;
        List r14 = (List) r10.get(r5);
        if (r14 == null) goto L14;
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if (Intrinsics.areEqual((String) ((Pair) r16).first, r12) == false) goto L8;
    L13:
        Pair r17 = (Pair) r16;
    L15:
        if (r17 != null) goto L34;
        List r18 = (List) r11.get(r5);
        if (r18 == null) goto L25;
        Iterator r19 = r18.iterator();
    L20:
        if (r19.hasNext() == false) goto L24;
        Object r110 = r19.next();
        if (Intrinsics.areEqual(((sa.a) r110).f21882a, r12) == false) goto L20;
        r13 = r110;
    L24:
        r13 = (sa.a) r13;
    L25:
        if (r13 != null) goto L35;
        this.f4289b.a(r12, new Throwable("invalid channel"));
        return;
    L35:
        return;
    L34:
        return;
    L12:
        r16 = null;
    L14:
        r17 = null;
        goto L15
    }

    @Override // pa.a
    public final void e(sa.a r10, long r11) {
        com.bytedance.forest.utils.d r5 = this.f4288a.getContext$forest_release().g;
        StringBuilder r12 = new StringBuilder("onUpdateSuccess:channel:");
        if (r10 == null) goto L5;
        String r13 = r10.f21882a;
    L6:
        r12.append(r13);
        r12.append(" version:");
        r12.append(r11);
        com.bytedance.forest.utils.d.b(r5, 4, GeckoXAdapter.TAG, r12.toString(), false, null, null, 56);
        Long r14 = Long.valueOf(r11);
        this.f4289b.a(this.f4290c, r14);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // pa.a
    public final void f(sa.a r5, Exception r10) {
        this.f4289b.a(this.f4290c, r10);
    }
}
