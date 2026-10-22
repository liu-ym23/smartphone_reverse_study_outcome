package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.controller.BaseControllerListener;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends BaseControllerListener<Object> {
    public final /* synthetic */ FansRankListAnimationWidget a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b0 a;

        public a(b0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            View r4 = this.a.a.f;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
        L5:
            UIUtils.setViewVisibility(r4, 4);
            HSImageView r5 = this.a.a.g;
            if (r5 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
        L8:
            r5.clearAnimation();
        }
    }

    public b0(FansRankListAnimationWidget r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        View r4 = this.a.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L5:
        UIUtils.setViewVisibility(r4, 0);
        ((ObservableSubscribeProxy) Observable.timer(4000, TimeUnit.MILLISECONDS).as(this.a.autoDisposeWithTransformer())).subscribe(new a(this));
    }
}
