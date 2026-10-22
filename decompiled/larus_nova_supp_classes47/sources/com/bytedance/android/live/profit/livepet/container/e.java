package com.bytedance.android.live.profit.livepet.container;

import android.view.ViewGroup;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o {
    public final CompositeDisposable a;
    public ViewGroup b;
    public final n c;
    public final k d;
    public final PublishSubject<com.bytedance.android.live.profit.livepet.container.a> e;
    public final PublishSubject f;
    public final yz0.k g;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.dispose();
        this.b = null;
    }

    public e(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.g = r2;
        this.a = new CompositeDisposable();
        n r3 = new n();
        this.c = r3;
        this.d = new k(r3);
        PublishSubject<com.bytedance.android.live.profit.livepet.container.a> r4 = PublishSubject.create();
        this.e = r4;
        this.f = r4;
    }

    public static final void a(e r3, com.bytedance.android.live.profit.livepet.container.a r4) {
        if (Intrinsics.areEqual(r4, r3.c) == false) goto L6;
        jy0.b.a("LivePet/LayoutManager", "petContainerRegion: " + m.a(r4));
    L8:
        r3.e.onNext(r4);
        return;
    L6:
        if (Intrinsics.areEqual(r4, r3.d) == false) goto L8;
        jy0.b.a("LivePet/LayoutManager", "interactAreaRegion: " + m.a(r3.d));
        goto L8
    }
}
