package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x5 extends BaseControllerListener<Object> {
    public final /* synthetic */ DynamicEmojiView a;
    public final /* synthetic */ wj0.b b;

    public static final class a extends BaseAnimationListener {
        public final /* synthetic */ x5 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.x5$a$a, reason: collision with other inner class name */
        public static final class C0030a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0030a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Long r4 = (Long) r3;
                x5 r5 = this.a.a;
                r5.a.b.b(new wj0.a.a(r5.b));
            }
        }

        public a(x5 r1) {
            this.a = r1;
        }

        public final void onAnimationStart(AnimatedDrawable2 r4) {
            x5 r5 = this.a;
            DynamicEmojiView r0 = r5.a;
            r0.d = Observable.timer(r5.b.b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0030a(this));
        }
    }

    public x5(DynamicEmojiView r1, wj0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r2, Throwable r3) {
        super.onFailure(r2, r3);
        if (((Boolean) j40.o1.a.getValue()).booleanValue() == false) goto L6;
        this.a.b.b(new wj0.a.a(this.b));
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        this.a.g = r3;
        if (((Boolean) j40.o1.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if ((r3 instanceof AnimatedDrawable2) == false) goto L9;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this));
        return;
    }
}
