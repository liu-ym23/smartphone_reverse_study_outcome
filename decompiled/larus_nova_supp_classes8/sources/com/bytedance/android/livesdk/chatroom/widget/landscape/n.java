package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.PublishParam;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements Runnable {
    public final /* synthetic */ LandscapeQuickShotObserveWidget a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ n a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.n$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0106a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0106a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r22) {
                bs1.b r1 = this.a.a.a.h;
                if (r1 == null) goto L13;
                String r2 = r1.c;
                if (r2 == null) goto L14;
                IMatchShareService r3 = jc1.k.f(IMatchShareService.class);
                if (r3 == null) goto L15;
                Context r4 = ((Widget) this.a.a.a).context;
                CollectionItem r8 = new CollectionItem();
                r8.setLocalImagePath(r2);
                r8.setLocalPreviewTopTitle("已保存至本地");
                Unit r9 = Unit.INSTANCE;
                ArrayList r10 = CollectionsKt.arrayListOf(new CollectionItem[]{r8});
                VideoViewParams r11 = this.a.a.a.e;
                if (r11 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("videoParam");
            L11:
                r3.launchMatchShare(r4, true, new MatchShareParam("screenshot", "", "", r10, r11, this.a.a.a.f, 0, new PublishParam(UriProtector.parse(r2).toString(), "2", 4, 0), "screenshot", null, true, 0, 42944));
                return;
            L15:
                return;
            L14:
                return;
            }
        }

        public a(n r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            View r0 = this.a.a.d;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
        L5:
            r0.setAlpha(r4.getAnimatedFraction());
            ((Widget) this.a.a).contentView.setOnClickListener(new ViewOnClickListenerC0106a(this));
            LandscapeQuickShotObserveWidget r5 = this.a.a;
            r5.getClass();
            Observable.timer(3000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r5), l.a);
        }
    }

    public n(LandscapeQuickShotObserveWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.d;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");     // Catch: Throwable -> L7
    L5:
        r0.setVisibility(0);     // Catch: Throwable -> L7
        this.a.j.addUpdateListener(new a(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
