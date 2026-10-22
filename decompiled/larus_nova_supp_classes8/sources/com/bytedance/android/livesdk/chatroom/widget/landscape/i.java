package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
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
public final class i implements Runnable {
    public final /* synthetic */ LandscapeQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ String c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ i a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.i$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0105a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0105a(a r1) {
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
                i r3 = this.a.a;
                LandscapeQuickShotLayerWidget.wq(r3.a, r3.b);
                HashMap<String, String> r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().generateShareLogParams(((Widget) this.a.a.a).dataCenter, "screenshot");
                if (r4 != null) goto L11;
                r4 = new HashMap();
            L11:
                r4.put("picture_number", "1");
                r4.put("content_type", "screenshot");
                vr1.q r5 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m();
                Context r6 = ((Widget) this.a.a.a).context;
                CollectionItem r9 = new CollectionItem();
                int r10 = bs1.a.a;
                r9.setLocalImagePath(this.a.a.c);
                r9.setLocalPreviewTopTitle("已保存至本地");
                r9.setLocalImagePreviewBitmap(this.a.a.b);
                Unit r11 = Unit.INSTANCE;
                ArrayList r12 = CollectionsKt.arrayListOf(new CollectionItem[]{r9});
                VideoViewParams r13 = this.a.a.a.d;
                if (r13 != null) goto L14;
                Intrinsics.throwUninitializedPropertyAccessException("videoParam");
            L14:
                r5.launchMatchShare(r6, true, new MatchShareParam("screenshot", "", "", r12, r13, this.a.a.a.f, 0, new PublishParam(UriProtector.parse(this.a.a.c).toString(), "2", 4, 0), "screenshot", r4, false, this.a.a.a.h, 18368));
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Long r3 = (Long) r2;
                i r4 = this.a.a;
                LandscapeQuickShotLayerWidget.wq(r4.a, r4.b);
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

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            i r0 = this.a;
            if ((!Intrinsics.areEqual(r0.b, r0.a.e)) == false) goto L5;
            return;
        L5:
            View r1 = this.a.a.c;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
        L8:
            r1.setAlpha(r5.getAnimatedFraction());
            if (r5.getAnimatedFraction() != 1.0f) goto L11;
            ((Widget) this.a.a).contentView.setOnClickListener(new ViewOnClickListenerC0105a(this));
            Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
        L11:
            View r6 = this.a.a.c;
            if (r6 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
        L14:
            UtilityKotlinExtentionsKt.w(r6);
        }
    }

    public i(LandscapeQuickShotLayerWidget r1, Bitmap r2, String r3) {
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
        this.a.j.addUpdateListener(new a(this));
        this.a.j.setInterpolator(new AccelerateDecelerateInterpolator());
        this.a.j.start();
        return;
    L8:
        LandscapeQuickShotLayerWidget.wq(this.a, this.b);
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
