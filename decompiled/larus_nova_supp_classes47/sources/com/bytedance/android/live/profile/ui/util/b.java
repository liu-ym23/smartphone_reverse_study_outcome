package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ py.k a;
    public final /* synthetic */ HSImageView b;

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            this.a.onComplete();
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            if (r3 == null) goto L4;
            r3.start();
        L4:
            this.a.onComplete();
        }
    }

    public b(py.k r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = d.a;
        AbstractDraweeController r1 = d.a(this.a);
        if (r1 == null) goto L5;
        r1.addControllerListener(new a(r3));
        this.b.setController(r1);
        return;
    L5:
        r3.onComplete();
    }
}
