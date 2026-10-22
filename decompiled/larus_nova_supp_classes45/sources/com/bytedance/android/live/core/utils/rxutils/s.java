package com.bytedance.android.live.core.utils.rxutils;

import android.view.View;
import androidx.core.view.ViewCompat;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s<T> implements ObservableOnSubscribe {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    public static final class a implements ttc.c {
        public final /* synthetic */ s a;
        public final /* synthetic */ b b;

        public a(s r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            this.a.a.removeOnAttachStateChangeListener(this.b);
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.onNext(Boolean.TRUE);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.onNext(Boolean.FALSE);
        }
    }

    public s(View r1) {
        this.a = r1;
        this.b = true;
    }

    public final void subscribe(ObservableEmitter<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        if (this.b == true) goto L5;
    L7:
        b r0 = new b(r3);
        this.a.addOnAttachStateChangeListener(r0);
        r3.setCancellable(new a(this, r0));
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(this.a) == false) goto L7;
        r3.onNext(Boolean.TRUE);
        goto L7
    }
}
