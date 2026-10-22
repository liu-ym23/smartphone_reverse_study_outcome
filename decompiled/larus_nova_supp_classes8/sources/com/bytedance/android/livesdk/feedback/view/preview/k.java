package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.config.u4;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends FrameLayout implements com.bytedance.android.livesdk.feedback.view.preview.d {
    public final GridLayout a;
    public final Map<Boolean, List<com.bytedance.android.livesdk.feedback.view.preview.c>> b;
    public boolean c;
    public Disposable d;
    public final int e;
    public List<RoomCardStruct> f;
    public final h g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            k r3 = (k) r2;
            r3.c = !r3.c;
            this.a.startPreview();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
        }
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public final void stopPreview() {
        this.c = true;
        Disposable r1 = this.d;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Map<Boolean, List<com.bytedance.android.livesdk.feedback.view.preview.c>> r2 = this.b;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        List r4 = (List) r3.get(Boolean.valueOf(this.c));
        if (r4 == null) goto L11;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        ((com.bytedance.android.livesdk.feedback.view.preview.c) r5.next()).stopPreview();
    L11:
        Map<Boolean, List<com.bytedance.android.livesdk.feedback.view.preview.c>> r6 = this.b;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        List r0 = (List) r7.get(Boolean.valueOf(true ^ this.c));
        if (r0 == null) goto L17;
        Iterator r8 = r0.iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        ((com.bytedance.android.livesdk.feedback.view.preview.c) r8.next()).stopPreview();
        goto L15
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public final void startPreview() {
        List r0 = (List) ((LinkedHashMap) this.b).get(Boolean.valueOf(this.c));
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.bytedance.android.livesdk.feedback.view.preview.c) r1.next()).startPreview();
    L8:
        List r2 = (List) ((LinkedHashMap) this.b).get(Boolean.valueOf(!this.c));
        if (r2 == null) goto L14;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ((com.bytedance.android.livesdk.feedback.view.preview.c) r3.next()).stopPreview();
    L14:
        Disposable r4 = this.d;
        if (r4 == null) goto L17;
        r4.dispose();
    L17:
        this.d = Observable.just(this).delay(this.e, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), b.a);
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public List<RoomCardStruct> getRoomInfo() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public final void a(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onFinish");
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        r0.setDuration(200);
        r0.addListener(new c(r4));
        r0.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public final void b(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onFinish");
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.7f, 1.0f});
        r0.setDuration(300);
        r0.addListener(new d(r4));
        r0.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.d
    public final void c(List<RoomCardStruct> r8) {
        Intrinsics.checkNotNullParameter(r8, "roomCardStructs");
        this.c = true;
        this.f = r8;
        ((LinkedHashMap) this.b).clear();
        this.a.removeAllViews();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        RoomCardStruct r2 = (RoomCardStruct) r9.next();
        r1.add(new n(getContext(), r2, this.g));
        goto L4
    L6:
        Iterator r10 = r1.iterator();
        int r3 = 0;
    L8:
        if (r10.hasNext() == false) goto L20;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        n r6 = (n) r4;
        this.a.addView(r6);
        if (r3 >= 2) goto L15;
        boolean r7 = true;
    L16:
        Map<Boolean, List<com.bytedance.android.livesdk.feedback.view.preview.c>> r11 = this.b;
        LinkedHashMap r12 = (LinkedHashMap) r11;
        List<com.bytedance.android.livesdk.feedback.view.preview.c> r13 = (List) r12.get(Boolean.valueOf(r7));
        if (r13 != null) goto L19;
        r13 = new ArrayList();
    L19:
        r13.add(r6);
        this.b.put(Boolean.valueOf(r7), r13);
        r3 = r5;
        goto L8
    L15:
        r7 = false;
        goto L16
    }

    public k(Context r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.g = r4;
        this.b = new LinkedHashMap();
        this.c = true;
        j5 r5 = u4.a.getValue();
        if (r5 == null) goto L7;
        Integer r6 = r5.smallCardPreviewTime;
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        this.e = r7;
        FrameLayout.inflate(r3, 2131567671, this);
        this.a = (GridLayout) findViewById(2131373899);
        return;
    L7:
        r7 = 5;
        goto L8
    }
}
