package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/RecordDragContainer;", "Landroid/widget/FrameLayout;", "", "Ld42/d;", "dragParentView", "", "setDragParentView", "", "enable", "setEnableDrag", "Lkotlin/Function1;", "", "l", "Lkotlin/jvm/functions/Function1;", "getOnMoveToSideListener", "()Lkotlin/jvm/functions/Function1;", "setOnMoveToSideListener", "(Lkotlin/jvm/functions/Function1;)V", "onMoveToSideListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordDragContainer extends FrameLayout {
    public d a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public final int i;
    public boolean j;
    public boolean k;
    public Function1<? super Integer, Unit> l;
    public q4.b m;
    public final Interpolator n;

    public static final class a {
    }

    static {
    }

    public final Function1<Integer, Unit> getOnMoveToSideListener() {
        return this.l;
    }

    public RecordDragContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.j = true;
        this.n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.j == false) goto L5;
        int r0 = r6.getAction();
        if (r0 != 0) goto L9;
        getTranslationX();
        getTranslationY();
        this.b = r6.getRawX();
        float r1 = r6.getRawY();
        this.c = r1;
        this.d = this.b;
        this.e = r1;
    L64:
        return super.dispatchTouchEvent(r6);
    L9:
        if (r0 == 1) goto L37;
        if (r0 != 2) goto L12;
        this.h = Math.abs(r6.getRawX() - this.d);
        float r2 = Math.abs(r6.getRawY() - this.e);
        float r3 = this.h;
        float r4 = this.i;
        if (r3 <= r4) goto L23;
    L24:
        this.k = true;
        this.f = r6.getRawX() - this.b;
        this.g = r6.getRawY() - this.c;
        d r5 = this.a;
        if (r5 != null) goto L27;
    L34:
        if (this.k == false) goto L64;
        return true;
    L27:
        if (r5.e(getX() + this.f, getWidth()) == false) goto L30;
        this.b = r6.getRawX();
        setX(getX() + this.f);
    L30:
        if (r5.i(getY() + this.g, getHeight()) == false) goto L32;
        this.c = r6.getRawY();
        setY(getY() + this.g);
    L32:
        r5.g(this);
        goto L34
    L23:
        if (r2 <= r4) goto L34;
    L12:
        if (r0 != 3) goto L64;
        if (this.k == false) goto L64;
        this.k = false;
        d r7 = this.a;
        if (r7 == null) goto L19;
        r7.c(this);
    L19:
        return true;
    L37:
        if (this.k == false) goto L64;
        this.k = false;
        final d r8 = this.a;
        if (r8 != null) goto L42;
    L58:
        d r9 = this.a;
        if (r9 == null) goto L61;
        r9.f(this);
    L61:
        return true;
    L42:
        if ((getX() + (getWidth() / 2)) > (r8.getAreaWidth() / 2)) goto L44;
        boolean r10 = true;
    L45:
        final float r11 = getX();
        if (r10 == false) goto L51;
        Function1<? super Integer, Unit> r12 = this.l;
        if (r12 == null) goto L50;
        Unit r13 = (Unit) r12.invoke(0);
    L50:
        this.m = u4.c(new RecordDragContainer$tryMoveToSide$1(this, r11, r8));
    L55:
        q4.b r14 = this.m;
        if (r14 == null) goto L58;
        r14.c();
        goto L58
    L51:
        Function1<? super Integer, Unit> r15 = this.l;
        if (r15 == null) goto L54;
        Unit r16 = (Unit) r15.invoke(1);
    L54:
        this.m = u4.c(new RecordDragContainer$tryMoveToSide$2(this, r11, r8));
        goto L55
    L44:
        r10 = false;
        goto L45
    L5:
        return super.dispatchTouchEvent(r6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        if (this.j == false) goto L9;
        q4.b r2 = this.m;
        if (r2 == null) goto L9;
        if (r2.b() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public void setDragParentView(d42.d r2) {
        if ((r2 instanceof d) == true) goto L5;
        r2 = null;
    L5:
        this.a = (d) r2;
    }

    public void setEnableDrag(boolean r1) {
        this.j = r1;
    }

    public final void setOnMoveToSideListener(Function1<? super Integer, Unit> r1) {
        this.l = r1;
    }

    public RecordDragContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0);
        this.j = true;
        this.n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public RecordDragContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = true;
        this.n = PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
