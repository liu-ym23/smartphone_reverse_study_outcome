package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.message.model.jb;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleStarActivityGradeMedal;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.controller.BaseControllerListener;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 extends BaseControllerListener<Object> {
    public final /* synthetic */ FansRankListAnimationWidget a;
    public final /* synthetic */ jb b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c0 a;

        public a(c0 r1) {
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
            if (r5 == null) goto L10;
            r5.clearAnimation();
        L10:
            HSImageView r6 = this.a.a.h;
            if (r6 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
        L13:
            if (r6 == null) goto L16;
            r6.clearAnimation();
            return;
        }
    }

    public c0(FansRankListAnimationWidget r1, jb r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        View r4 = this.a.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L5:
        UIUtils.setViewVisibility(r4, 0);
        HSImageView r5 = this.a.h;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L8:
        jb r6 = this.b;
        if (r6 == null) goto L13;
        BattleStarActivityGradeMedal r7 = r6.getGradeMedal();
        if (r7 == null) goto L13;
        py.k r8 = r7.levelImage;
    L14:
        ImageLoader.bindImage(r5, r8);
        ((ObservableSubscribeProxy) Observable.timer(4000, TimeUnit.MILLISECONDS).as(this.a.autoDisposeWithTransformer())).subscribe(new a(this));
        return;
    L13:
        r8 = null;
        goto L14
    }
}
