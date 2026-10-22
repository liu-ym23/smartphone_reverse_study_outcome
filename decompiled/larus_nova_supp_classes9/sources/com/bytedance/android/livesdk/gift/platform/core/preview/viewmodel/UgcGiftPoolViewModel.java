package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.gift.platform.core.preview.InteractGiftRepository;
import com.bytedance.android.livesdk.gift.platform.core.preview.RequestTimer;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class UgcGiftPoolViewModel implements o {
    public final PropertyOwner<a> a;
    public final PropertyOwner b;
    public final Lazy c;
    public final d d;

    public final InteractGiftRepository c() {
        return (InteractGiftRepository) this.c.getValue();
    }

    public final void onStart() {
        c().e(this.d.getSourceFrom(), 1, new UgcGiftPoolViewModel$fetchUgcGift$1(this));
    }

    public final void onStop() {
        InteractGiftRepository r0 = c();
        r0.e.clear();
        RequestTimer r1 = r0.f;
        Disposable r2 = r1.a;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        r1.a = null;
    }

    public UgcGiftPoolViewModel(d r6) {
        Intrinsics.checkNotNullParameter(r6, "scope");
        this.d = r6;
        PropertyOwner<a> r7 = new PropertyOwner(new a(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        this.a = r7;
        this.b = r7;
        new PropertyOwner(PanelOperationState.UNKNOWN);
        this.c = LazyKt.lazy(UgcGiftPoolViewModel$repository$2.INSTANCE);
    }

    public final void a(List<Long> r4, List<Long> r5, final PanelOperationState r6) {
        Intrinsics.checkNotNullParameter(r4, "topList");
        Intrinsics.checkNotNullParameter(r5, "dislikeList");
        Intrinsics.checkNotNullParameter(r6, "action");
        c().c(r4, r5, this.d.getSourceFrom(), new UgcGiftPoolViewModel$changeUgcGift$1(this, r6));
    }
}
