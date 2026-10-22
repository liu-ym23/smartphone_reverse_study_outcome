package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/DynamicEmojiView;", "Landroid/widget/FrameLayout;", "", "getResourceLayout", "Lcom/bytedance/android/livesdk/chatroom/ui/f6;", "listener", "", "setOnEmojiAnimationListener", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "callback", "setEmojiAnimCallback", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getRandomEmojiView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicEmojiView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> a;
    public final wj0.d b;
    public final CompositeDisposable c;
    public Disposable d;
    public Disposable e;
    public e6 f;
    public Animatable g;
    public Function0<Unit> h;
    public final HSImageView i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DynamicEmojiView a;

        public a(DynamicEmojiView r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            Pair r12 = (Pair) r11;
            wj0.c r0 = (wj0.c) r12.component1();
            wj0.c.d r13 = (wj0.c) r12.component2();
            DynamicEmojiView r1 = this.a;
            int r2 = DynamicEmojiView.j;
            r1.getClass();
            if ((r13 instanceof wj0.c.d) == false) goto L15;
            e6 r3 = r1.f;
            if (r3 == null) goto L7;
            r3.c(new d6.c(r13.a));
        L7:
            wj0.b r14 = r13.a;
            if (r14.b.isRandomEmoji == false) goto L11;
            r1.b.b(new wj0.a.b(r14));
            return;
        L11:
            if (((Boolean) j40.o1.a.getValue()).booleanValue() == true) goto L13;
            r1.d = Observable.timer(r14.b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new w5(r1, r14));
        L13:
            r1.a(2131371543).setVisibility(8);
            r1.a(2131371521).setVisibility(0);
            r1.a(2131371521).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r14.b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).setControllerListener(new x5(r1, r14)).build());
            return;
        L15:
            if ((r13 instanceof wj0.c.c) == false) goto L18;
            wj0.b r15 = ((wj0.c.c) r13).a;
            r1.d = Observable.timer(r15.b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y5(r1, r15));
            r1.a(2131371543).setVisibility(8);
            r1.a(2131371521).setVisibility(0);
            r1.a(2131371521).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r15.b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).build());
            ImageLoader.preload(r1.getContext(), r15.c);
            return;
        L18:
            if ((r13 instanceof wj0.c.e) == false) goto L24;
            e6 r4 = r1.f;
            if (r4 == null) goto L22;
            r4.c(new d6.b(((wj0.c.e) r13).a));
        L22:
            wj0.b r16 = ((wj0.c.e) r13).a;
            r1.e = Observable.timer(r16.b.getEmojiResultShowDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new z5(r1, r16));
            r1.a(2131371543).setVisibility(0);
            r1.a(2131371521).setVisibility(8);
            r1.a(2131371543).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r16.c, -1)).setControllerListener(new a6(r1, r16)).build());
            return;
        L24:
            if ((r13 instanceof wj0.c.a) == false) goto L32;
            e6 r5 = r1.f;
            if (r5 == null) goto L28;
            r5.c(new d6.a(((wj0.c.a) r13).a));
        L28:
            Function0<Unit> r6 = r1.h;
            if (r6 == null) goto L31;
            r6.invoke();
        L31:
            xs2.b.a().post(new wj0.e(((wj0.c.a) r13).a.b));
            r1.c();
            return;
        L32:
            boolean r17 = r13 instanceof wj0.c.b;
        }
    }

    public DynamicEmojiView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DynamicEmojiView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getResourceLayout() {
        return 2131567653;
    }

    @Deprecated(message = "监听动画进度方式替换，为了扩展监听多个动画节点", replaceWith = @ReplaceWith(expression = "DynamicEmoji.setEmojiAnimCallback()", imports = {}))
    public final void setOnEmojiAnimationListener(f6 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void c() {
        this.b.b(new wj0.a.c());
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.e;
        if (r1 == null) goto L13;
        if (r1.isDisposed() == true) goto L13;
        r1.dispose();
    L13:
        if (a(2131371521).getVisibility() != 0) goto L16;
        a(2131371521).setVisibility(8);
    L16:
        if (a(2131371543).getVisibility() != 0) goto L19;
        a(2131371543).setVisibility(8);
        return;
    L19:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.add(RxUtilKt.e(this.b.b).subscribe(new a(this)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        this.c.clear();
    }

    public final HSImageView getRandomEmojiView() {
        return this.i;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setEmojiAnimCallback(e6 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.f = r2;
    }

    public final void b(wj0.b r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "emojiMessage");
        Intrinsics.checkNotNullParameter(r5, "taskEnd");
        Intrinsics.checkNotNullParameter(r4, "emojiMessage");
        wj0.d r0 = this.b;
        if ((r0.a instanceof wj0.c.b) == true) goto L7;
        wj0.b r1 = r0.a();
        if (r1 == null) goto L7;
        this.b.b(new wj0.a.a(r1));
    L7:
        this.b.b(new wj0.a.d(r4));
        this.h = r5;
    }

    public DynamicEmojiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = new wj0.d();
        this.c = new CompositeDisposable();
        LayoutInflater.from(r2).inflate(getResourceLayout(), this, true);
        HSImageView r5 = findViewById(2131383625);
        this.i = r5;
        if (r5 == null) goto L6;
        r5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return;
    }

    public /* synthetic */ DynamicEmojiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
