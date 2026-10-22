package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.gamesticker.t01.anim.TaskState;
import com.bytedance.android.livesdk.gamesticker.t01.anim.e;
import com.bytedance.android.livesdk.gamesticker.t01.anim.f;
import com.bytedance.android.livesdk.gamesticker.t01.anim.g;
import com.bytedance.android.livesdk.gamesticker.t01.anim.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u001e¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameStickerView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "visibility", "", "onChange", "setVisibilityChangeListener", "Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", "a", "Lkotlin/Lazy;", "getFirstRoleView", "()Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", "firstRoleView", "b", "getSecondRoleView", "secondRoleView", "Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "c", "getFirstLiveView", "()Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameLiveView;", "firstLiveView", "d", "getSecondLiveView", "secondLiveView", "Landroid/view/View;", "e", "getStickerBgView", "()Landroid/view/View;", "stickerBgView", "f", "getContainerView", "containerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameStickerView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public int g;
    public Function1<? super Integer, Unit> h;
    public final b i;
    public final g j;

    public static final class a implements f {
        public final /* synthetic */ T01GameStickerView a;

        public a(T01GameStickerView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.f
        public final void a(com.bytedance.android.livesdk.gamesticker.t01.anim.b r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            T01GameStickerView r0 = this.a;
            r3.e();
            int r4 = T01GameStickerView.k;
            r0.getClass();
            this.a.g();
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.f
        public final void b(com.bytedance.android.livesdk.gamesticker.t01.anim.b r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            T01GameStickerView r0 = this.a;
            r3.e();
            int r4 = T01GameStickerView.k;
            r0.getClass();
        }
    }

    public static final class b implements i {
        public final /* synthetic */ T01GameStickerView a;

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final View V2() {
            return T01GameStickerView.a(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameRoleView a() {
            return T01GameStickerView.e(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameLiveView b() {
            return T01GameStickerView.d(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameLiveView c() {
            return T01GameStickerView.b(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final T01GameRoleView d() {
            return T01GameStickerView.c(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.i
        public final float getHeight() {
            if (this.a.getHeight() == 0) goto L8;
            int r0 = this.a.getHeight();
        L6:
            return r0;
        L8:
            if (this.a.getMeasuredHeight() == 0) goto L10;
            r0 = this.a.getMeasuredHeight();
            goto L6
        L10:
            r0 = s1.f(28.0f);
            goto L6
        }

        public b(T01GameStickerView r1) {
            this.a = r1;
        }
    }

    public T01GameStickerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public T01GameStickerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getContainerView() {
        return (View) this.f.getValue();
    }

    private final T01GameLiveView getFirstLiveView() {
        return (T01GameLiveView) this.c.getValue();
    }

    private final T01GameRoleView getFirstRoleView() {
        return (T01GameRoleView) this.a.getValue();
    }

    private final T01GameLiveView getSecondLiveView() {
        return (T01GameLiveView) this.d.getValue();
    }

    private final T01GameRoleView getSecondRoleView() {
        return (T01GameRoleView) this.b.getValue();
    }

    private final View getStickerBgView() {
        return (View) this.e.getValue();
    }

    public final void f() {
        if (this.j.a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r0 = this.j.a.peek();
        if (r0 != null) goto L9;
        return;
    L9:
        Iterator<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r2 = null;
        if (Intrinsics.areEqual(r0.e(), "ShowContainerTask") == false) goto L12;
    L13:
        TaskState r1 = r0.a;
        if (r1 != TaskState.CREATE) goto L17;
        r0.e();
        r0.a();
    L19:
        g r3 = this.j;
        T01GameStickerView$clearAboutContainerTask$1 r4 = T01GameStickerView$clearAboutContainerTask$1.INSTANCE;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "filter");
        LinkedList<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r5 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "filter");
        if (r5 == null) goto L22;
        r2 = r5.iterator();
    L22:
        if (r2 == null) goto L34;
        if (r2.hasNext() != true) goto L35;
        if (((Boolean) r4.invoke(r2.next())).booleanValue() == false) goto L22;
        r2.remove();
        return;
    L35:
        return;
    L34:
        return;
    L17:
        if (r1 != TaskState.END) goto L19;
        g r6 = this.j;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        r0.b = null;
        r0.c = null;
        r6.a.remove(r0);
        goto L19
    L12:
        if (Intrinsics.areEqual(r0.e(), "HideContainerTask") == false) goto L19;
    }

    public final void g() {
        if (this.j.a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r0 = this.j.a.peek();
        if (r0 != null) goto L9;
        return;
    L9:
        r0.e();
        Objects.toString(r0.a);
        TaskState r1 = r0.a;
        if (r1 != TaskState.CREATE) goto L13;
        r0.d();
        return;
    L13:
        if (r1 != TaskState.END) goto L17;
        g r2 = this.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        r0.b = null;
        r0.c = null;
        r2.a.remove(r0);
        g();
        return;
    L17:
        return;
    }

    public final void j() {
        g r0 = this.j;
        Iterator<com.bytedance.android.livesdk.gamesticker.t01.anim.b> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gamesticker.t01.anim.b r2 = r1.next();
        r2.b = null;
        r2.c = null;
        r2.a();
        goto L4
    L6:
        r0.a.clear();
        getFirstRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getFirstLiveView().setLiveInfo(null);
        getSecondLiveView().setLiveInfo(null);
        this.h = null;
    }

    public static final /* synthetic */ View a(T01GameStickerView r0) {
        return r0.getContainerView();
    }

    public static final /* synthetic */ T01GameLiveView b(T01GameStickerView r0) {
        return r0.getFirstLiveView();
    }

    public static final /* synthetic */ T01GameRoleView c(T01GameStickerView r0) {
        return r0.getFirstRoleView();
    }

    public static final /* synthetic */ T01GameLiveView d(T01GameStickerView r0) {
        return r0.getSecondLiveView();
    }

    public static final /* synthetic */ T01GameRoleView e(T01GameStickerView r0) {
        return r0.getSecondRoleView();
    }

    public final void h(boolean r3) {
        if (this.i.V2().getVisibility() != 8) goto L6;
        f();
        return;
    L6:
        if (r3 == false) goto L8;
        this.j.a(new com.bytedance.android.livesdk.gamesticker.t01.anim.a(new T01GameStickerView$hideContainerView$1(this)));
    L11:
        g();
        return;
    L8:
        f();
        this.i.V2().setVisibility(8);
        Function1<? super Integer, Unit> r4 = this.h;
        if (r4 == null) goto L11;
        Unit r5 = (Unit) r4.invoke(8);
        goto L11
    }

    public final void i(int r3) {
        if (this.g == r3) goto L5;
    L7:
        View r0 = getStickerBgView();
        if (r3 != 0) goto L10;
        Drawable r1 = s1.m(2131249230);
    L11:
        r0.setBackground(r1);
        this.g = r3;
        return;
    L10:
        r1 = s1.m(2131249229);
        goto L11
    L5:
        if (getStickerBgView().getBackground() == null) goto L7;
    }

    public final void k(boolean r3) {
        if (this.i.V2().getVisibility() != 0) goto L6;
        f();
        return;
    L6:
        if (r3 == false) goto L8;
        this.j.a(new e(new T01GameStickerView$showContainerView$1(this)));
    L11:
        g();
        return;
    L8:
        f();
        this.i.V2().setTranslationY(0.0f);
        this.i.V2().setVisibility(0);
        Function1<? super Integer, Unit> r4 = this.h;
        if (r4 == null) goto L11;
        Unit r5 = (Unit) r4.invoke(0);
        goto L11
    }

    public final void setVisibilityChangeListener(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        this.h = r2;
    }

    public T01GameStickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new T01GameStickerView$firstRoleView$2(this));
        this.b = LazyKt.lazy(new T01GameStickerView$secondRoleView$2(this));
        this.c = LazyKt.lazy(new T01GameStickerView$firstLiveView$2(this));
        this.d = LazyKt.lazy(new T01GameStickerView$secondLiveView$2(this));
        this.e = LazyKt.lazy(new T01GameStickerView$stickerBgView$2(this));
        this.f = LazyKt.lazy(new T01GameStickerView$containerView$2(this));
        b r5 = new b(this);
        this.i = r5;
        this.j = new g(new a(this), r5);
        LayoutInflater.from(r2).inflate(2131566111, this);
        getFirstRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getFirstLiveView().setLiveInfo(null);
        getSecondLiveView().setLiveInfo(null);
    }

    public /* synthetic */ T01GameStickerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
