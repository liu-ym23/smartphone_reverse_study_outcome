package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.w8;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements Runnable {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.a b;
    public final /* synthetic */ w8 c;

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ q a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.q$a$a, reason: collision with other inner class name */
        public static final class RunnableC0024a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0024a(a r1) {
                this.a = r1;
            }

            public final void a() {
                HSImageView r0 = this.a.a.a;
                if (r0 == null) goto L5;
                r0.setVisibility(8);
            L5:
                ViewParent r1 = this.a.a.a.getParent();
                if (r1 == null) goto L8;
                ((ViewGroup) r1).removeView(this.a.a.a);
            L8:
                com.bytedance.android.live.liveinteract.videotalk.emoji.model.i r2 = this.a.a.c.getDynamicEmoji();
                if ((r2 instanceof TalkRoomBaseDynamicEmoji) == false) goto L12;
                xs2.b.a().post(new wj0.e((TalkRoomBaseDynamicEmoji) r2));
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(q r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            AndroidSchedulers.mainThread().scheduleDirect(new RunnableC0024a(this), this.a.b.a.b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS);
        }
    }

    public q(HSImageView r1, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.a r2, w8 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        this.a.setVisibility(0);
        this.a.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(this.b.a.b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).setControllerListener(new a(this)).build());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
