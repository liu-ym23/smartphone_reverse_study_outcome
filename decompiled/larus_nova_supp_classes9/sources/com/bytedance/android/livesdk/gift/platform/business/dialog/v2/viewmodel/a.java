package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a {
    public final NextLiveData<GiftStateMachineConfig.g> a;
    public final Disposable b;
    public final CompositeDisposable c;
    public final LifecycleOwner d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0038a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0038a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a r0 = this.a;
            r0.d((GiftStateMachineConfig.Event) r2);
        }
    }

    public abstract void d(GiftStateMachineConfig.Event r1);

    public void a() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        this.c.clear();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.b.dispose();
        goto L7
    }

    public a(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.d = r2;
        this.a = new NextLiveData();
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L9;
        k<GiftStateMachineConfig.Event> r4 = r3.getGiftActionManager();
        if (r4 == null) goto L9;
        PublishSubject r5 = r4.onEvent();
        if (r5 == null) goto L9;
        Disposable r6 = r5.subscribe(new C0038a(this));
    L10:
        this.b = r6;
        this.c = new CompositeDisposable();
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final GiftStateMachineConfig.g c(LifecycleOwner r2, Observer<GiftStateMachineConfig.g> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        NextLiveData<GiftStateMachineConfig.g> r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.d;
    L5:
        r0.observe(r2, r3);
        return (GiftStateMachineConfig.g) this.a.getValue();
    }
}
