package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.PublishParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b2 implements Runnable {
    public final /* synthetic */ PortraitQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ String c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b2 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.b2$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0091a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0091a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r25) {
                com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotShareDialogClick();
                IRoom r1 = this.a.a.a.f;
                if (r1 == null) goto L8;
                IRoomAuthStatus r2 = r1.getRoomAuthStatus();
                if (r2 == null) goto L8;
                if (r2.isDisableShare() != true) goto L8;
                return;
            L8:
                b2 r3 = this.a.a;
                Bitmap r4 = r3.b;
                if (r4 == null) goto L11;
                PortraitQuickShotLayerWidget.xq(r3.a, r4);
            L11:
                HashMap<String, String> r5 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().generateShareLogParams(((Widget) this.a.a.a).dataCenter, "screenshot");
                if (r5 != null) goto L14;
                r5 = new HashMap();
            L14:
                r5.put("picture_number", "1");
                r5.put("content_type", "screenshot");
                if ((((Widget) this.a.a.a).context instanceof FragmentActivity) == false) goto L25;
                vr1.q r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m();
                Context r7 = ((Widget) this.a.a.a).context;
                if (r7 == null) goto L23;
                FragmentActivity r8 = (FragmentActivity) r7;
                CollectionItem r9 = new CollectionItem();
                r9.setLocalImagePath(this.a.a.c);
                r9.setLocalPreviewTopTitle("已保存至本地");
                Unit r10 = Unit.INSTANCE;
                ArrayList r11 = CollectionsKt.arrayListOf(new CollectionItem[]{r9});
                VideoViewParams r12 = this.a.a.a.d;
                if (r12 != null) goto L21;
                Intrinsics.throwUninitializedPropertyAccessException("videoParam");
            L21:
                MatchShareParam r13 = new MatchShareParam("screenshot", "", "", r11, r12, this.a.a.a.f, 0, new PublishParam(UriProtector.parse(this.a.a.c).toString(), "2", 4, 0), "screenshot", r5, false, 0, 51136);
                CollectionItem r14 = new CollectionItem();
                r14.setLocalImagePath(this.a.a.c);
                r14.setLocalPreviewTopTitle("已保存至本地");
                r6.showShareDialog(r8, r13, r14);
                return;
            L23:
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Long r3 = (Long) r2;
                b2 r4 = this.a.a;
                Bitmap r0 = r4.b;
                if (r0 == null) goto L6;
                PortraitQuickShotLayerWidget.xq(r4.a, r0);
                return;
            }
        }

        public static final class c<T> implements Consumer {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
            }
        }

        public a(b2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            b2 r0 = this.a;
            if ((!Intrinsics.areEqual(r0.b, r0.a.e)) == false) goto L5;
            return;
        L5:
            View r1 = this.a.a.c;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
        L8:
            r1.setAlpha(r5.getAnimatedFraction());
            if (r5.getAnimatedFraction() != 1.0f) goto L11;
            ((Widget) this.a.a).contentView.setOnClickListener(new ViewOnClickListenerC0091a(this));
            Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
        L11:
            View r6 = this.a.a.c;
            if (r6 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
        L14:
            UtilityKotlinExtentionsKt.w(r6);
        }
    }

    public b2(PortraitQuickShotLayerWidget r1, Bitmap r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().allowQuickShotShare(), Boolean.TRUE) == false) goto L8;
        View r0 = this.a.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L7:
        r0.setVisibility(0);
        this.a.h.addUpdateListener(new a(this));
        this.a.h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.a.h.start();
        return;
    L8:
        Bitmap r1 = this.b;
        if (r1 == null) goto L13;
        PortraitQuickShotLayerWidget.xq(this.a, r1);
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
