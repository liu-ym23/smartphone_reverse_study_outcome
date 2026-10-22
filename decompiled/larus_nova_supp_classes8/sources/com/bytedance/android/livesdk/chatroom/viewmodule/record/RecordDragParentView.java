package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.DragContainer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/RecordDragParentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/d;", "Ld42/b;", "callback", "", "setDragCallback", "", "getAreaWidth", "getAreaHeight", "getAreaMarginLeft", "getAreaMarginRight", "getAreaMarginTop", "getAreaMarginBottom", "Lkotlin/Function0;", "", "h", "Lkotlin/jvm/functions/Function0;", "getOnOtherAreaTouchListener", "()Lkotlin/jvm/functions/Function0;", "setOnOtherAreaTouchListener", "(Lkotlin/jvm/functions/Function0;)V", "onOtherAreaTouchListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordDragParentView extends FrameLayout implements d {
    public View a;
    public d42.b b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Function0<Boolean> h;
    public boolean i;

    public final void d(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "deleteView");
    }

    public final void j(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "forbiddenView");
    }

    public int getAreaHeight() {
        return getHeight();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaWidth() {
        return getWidth();
    }

    public int getAreaMarginBottom() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaMarginLeft() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaMarginRight() {
        return this.f;
    }

    public int getAreaMarginTop() {
        return this.e;
    }

    public final Function0<Boolean> getOnOtherAreaTouchListener() {
        return this.h;
    }

    public RecordDragParentView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "dragView");
        addView(r3, new FrameLayout.LayoutParams(-2, -2));
        this.a = r3;
        r3.setX(this.d);
        r3.setY(this.e);
    }

    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "draggingView");
        d42.b r3 = this.b;
        if (r3 == null) goto L5;
        r3.Op(false);
    L5:
        this.c = true;
    }

    public final void f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "draggingView");
        d42.b r3 = this.b;
        if (r3 == null) goto L5;
        r3.Op(false);
    L5:
        this.c = true;
    }

    public final void g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "draggingView");
        if (this.c == false) goto L9;
        d42.b r3 = this.b;
        if (r3 == null) goto L7;
        r3.onDragStart();
    L7:
        this.c = false;
        return;
    }

    public final Pair h(DragContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "dragView");
        Float r3 = Float.valueOf(0.0f);
        return TuplesKt.to(r3, r3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        View r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r8.getAction();
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L10;
    L12:
        requestDisallowInterceptTouchEvent(false);
    L23:
        return super.onInterceptTouchEvent(r8);
    L10:
        if (r1 == 3) goto L12;
    L13:
        float r2 = r8.getX();
        float r3 = r8.getY();
        float r4 = r0.getX();
        float r5 = r0.getX() + r0.getWidth();
        if (r2 < r4) goto L23;
        if (r2 > r5) goto L23;
        float r6 = r0.getY();
        float r7 = r0.getY() + r0.getHeight();
        if (r3 < r6) goto L23;
        if (r3 > r7) goto L23;
        requestDisallowInterceptTouchEvent(true);
        goto L23
    L5:
        return super.onTouchEvent(r8);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        View r0 = this.a;
        if (r0 != null) goto L7;
        return super.onTouchEvent(r8);
    L7:
        if (r8.getAction() != 0) goto L26;
        float r1 = r8.getX();
        float r3 = r8.getY();
        float r4 = r0.getX();
        float r5 = r0.getX() + r0.getWidth();
        if (r1 >= r4) goto L12;
    L18:
        Function0<Boolean> r2 = this.h;
        if (r2 == null) goto L23;
        Boolean r6 = (Boolean) r2.invoke();
        if (r6 == null) goto L23;
        boolean r7 = r6.booleanValue();
    L24:
        this.i = r7;
    L23:
        r7 = false;
        goto L24
    L12:
        if (r1 > r5) goto L18;
        float r9 = r0.getY();
        float r10 = r0.getY() + r0.getHeight();
        if (r3 < r9) goto L18;
        if (r3 > r10) goto L18;
    L26:
        if (this.i == false) goto L28;
    L29:
        return true;
    L28:
        if (super.onTouchEvent(r8) == true) goto L29;
        return false;
    }

    public void setDragCallback(d42.b r1) {
        this.b = r1;
    }

    public final void setOnOtherAreaTouchListener(Function0<Boolean> r1) {
        this.h = r1;
    }

    public RecordDragParentView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final boolean e(float r2, float r3) {
        if (r2 >= this.d) goto L5;
    L7:
        return false;
    L5:
        if ((r2 + r3) > (getWidth() - this.f)) goto L7;
        return true;
    }

    public final boolean i(float r2, float r3) {
        if (r2 >= this.e) goto L5;
    L7:
        return false;
    L5:
        if ((r2 + r3) > (getHeight() - this.g)) goto L7;
        return true;
    }

    public RecordDragParentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        this.d = UtilityKotlinExtentionsKt.i(12);
        this.e = UtilityKotlinExtentionsKt.i(128);
        this.f = UtilityKotlinExtentionsKt.i(12);
        this.g = UtilityKotlinExtentionsKt.i(320);
    }

    public final void a(int r1, int r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = 0;
    }
}
