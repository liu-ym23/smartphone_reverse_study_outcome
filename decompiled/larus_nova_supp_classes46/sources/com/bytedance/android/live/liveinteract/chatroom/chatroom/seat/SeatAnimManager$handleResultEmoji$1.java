package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SeatAnimManager$handleResultEmoji$1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ a b;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager$handleResultEmoji$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BaseControllerListener<Object> {
        public final /* synthetic */ SeatAnimManager$handleResultEmoji$1 a;
        public final /* synthetic */ ObservableEmitter b;

        public AnonymousClass1(SeatAnimManager$handleResultEmoji$1 r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r2, Throwable r3) {
            super.onFailure(r2, r3);
            ObservableEmitter r4 = this.b;
            if (r3 != null) goto L5;
            r3 = new Throwable("handleResultEmoji error!");
        L5:
            r4.onError(r3);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            je0.b.a((AnimatedDrawable2) r3, new SeatAnimManager$handleResultEmoji$1$1$onFinalImageSet$1(this));
            return;
        }
    }

    public SeatAnimManager$handleResultEmoji$1(HSImageView r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        this.a.setVisibility(0);
        this.a.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(this.b.a.b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).setControllerListener(new AnonymousClass1(this, r5)).build());
    }
}
