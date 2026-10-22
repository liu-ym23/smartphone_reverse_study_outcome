package com.larus.doc.impl.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.doc.impl.chat.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/impl/view/InterceptTouchFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chatContainerBounds", "Landroid/graphics/Rect;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "requestChatInputFocus", "", "isTouchInChatContainer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InterceptTouchFrameLayout extends FrameLayout {
    public final Rect a;

    public InterceptTouchFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InterceptTouchFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        boolean r0 = super.dispatchTouchEvent(r6);
        boolean r2 = false;
        if (r6 != null) goto L5;
    L7:
        if (r2 == true) goto L9;
    L21:
        return r0;
    L9:
        if (getId() != 2131369292) goto L11;
    L12:
        FLogger.a.i("[CORE_INPUT]", "dispatchTouchEvent: " + r6 + ", keyboard show");
        Fragment r3 = a.a();
        if (r3 == null) goto L21;
        b r4 = s1a.a.g(r3);
        if (r4 == null) goto L21;
        o r5 = r4.getAbility(o.class);
        if (r5 == null) goto L21;
        if (r5.hh() == true) goto L21;
        r5.CJ(true, r6, true);
        goto L21
    L11:
        if (getId() != 2131369293) goto L21;
    L5:
        if (r6.getActionMasked() != 0) goto L7;
        r2 = true;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (getId() != 2131369315) goto L20;
        if (r5 == null) goto L9;
        View r1 = getRootView().findViewById(2131369293);
        if (r1 == null) goto L9;
        r1.getGlobalVisibleRect(this.a);
        int[] r2 = new int[2];
        getLocationOnScreen(r2);
        boolean r3 = this.a.contains(r2[0] + ((int) r5.getX()), r2[1] + ((int) r5.getY()));
    L11:
        if (r3 == true) goto L20;
        FLogger.a.i("[CORE_INPUT]", "onInterceptTouchEvent: " + r5 + ", clear focus");
        Fragment r4 = a.a();
        if (r4 == null) goto L20;
        b r6 = s1a.a.g(r4);
        if (r6 == null) goto L20;
        o r7 = r6.getAbility(o.class);
        if (r7 == null) goto L20;
        r7.CJ(false, null, false);
    L9:
        r3 = false;
    L20:
        return super.onInterceptTouchEvent(r5);
    }

    public InterceptTouchFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Rect();
    }

    public /* synthetic */ InterceptTouchFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
