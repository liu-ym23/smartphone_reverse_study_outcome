package com.obric.oui.push;

import ai.j0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R.\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\"\u00105\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,¨\u00066"}, d2 = {"Lcom/obric/oui/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "value", "b", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "parent", "Landroidx/customview/widget/ViewDragHelper;", "c", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", "viewDragHelper", "", "d", "Z", "getDismissSettling", "()Z", "setDismissSettling", "(Z)V", "dismissSettling", "e", "getOpenSettling", "setOpenSettling", "openSettling", "h", "getInterceptingEvents", "setInterceptingEvents", "interceptingEvents", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationLabel extends CardView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f14256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewDragHelper f14257c;
    public boolean d;
    public boolean e;
    public View.OnClickListener f;
    public final NotificationLabel$dragCallback$1 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f14259i;

    @JvmOverloads
    public NotificationLabel(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r5 = this.f14257c;
        if (r5 == null) goto L21;
        Intrinsics.checkNotNull(r5);
        boolean r10 = r5.continueSettling(true);
        String r11 = this.f14255a;
        if (r10 == false) goto L7;
        Log.d(r11, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(r11, "settled");
        boolean r12 = this.d;
        ArrayList r13 = this.f14259i;
        if (r12 == false) goto L15;
        this.d = false;
        Log.i(r11, "onDrag dismiss");
        Iterator r14 = r13.iterator();
        if (r14.hasNext() == false) goto L24;
        j0.A(r14.next());
        throw null;
    L24:
        return;
    L15:
        if (this.e == false) goto L23;
        this.e = false;
        Log.i(r11, "onDrag open");
        Iterator r15 = r13.iterator();
        if (r15.hasNext() == false) goto L25;
        j0.A(r15.next());
        throw null;
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.d;
    }

    public final boolean getInterceptingEvents() {
        return this.f14258h;
    }

    public final boolean getOpenSettling() {
        return this.e;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.f14256b;
    }

    public final String getTAG() {
        return this.f14255a;
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.f14257c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        boolean r5 = this.f14258h;
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        int r12 = (int) r10.getX();
        int r13 = (int) r10.getY();
        Intrinsics.checkNotNullParameter(this, "child");
        Rect r14 = new Rect();
        ViewGroupUtils.getDescendantRect(this.f14256b, this, r14);
        r5 = r14.contains(r12, r13);
        this.f14258h = r5;
        String r15 = Intrinsics.stringPlus("intercept: ", Boolean.valueOf(r5));
        Log.i(this.f14255a, r15);
    L11:
        if (r5 == false) goto L18;
        ViewGroup r16 = this.f14256b;
        if (this.f14257c != null) goto L16;
        if (r16 == null) goto L16;
        this.f14257c = ViewDragHelper.create(r16, 1.0f, this.g);
    L16:
        ViewDragHelper r17 = this.f14257c;
        Intrinsics.checkNotNull(r17);
        return r17.shouldInterceptTouchEvent(r10);
    L18:
        return false;
    L5:
        if (r11 != 1) goto L7;
    L9:
        this.f14258h = false;
        goto L11
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        ViewDragHelper r10 = this.f14257c;
        if (r10 == null) goto L9;
        if (r10 == null) goto L11;
        r10.processTouchEvent(r5);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public final void setDismissSettling(boolean r5) {
        this.d = r5;
    }

    public final void setInterceptingEvents(boolean r5) {
        this.f14258h = r5;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r5) {
        this.f = r5;
    }

    public final void setOpenSettling(boolean r5) {
        this.e = r5;
    }

    public final void setParent(ViewGroup r5) {
        this.f14256b = r5;
        if (this.f14257c != null) goto L7;
        if (r5 == null) goto L8;
        this.f14257c = ViewDragHelper.create(r5, 1.0f, this.g);
        return;
    L8:
        return;
    }

    public final void setViewDragHelper(ViewDragHelper r5) {
        this.f14257c = r5;
    }

    @JvmOverloads
    public NotificationLabel(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ NotificationLabel(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.push.NotificationLabel$dragCallback$1] */
    @JvmOverloads
    public NotificationLabel(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14255a = "NotificationLabel";
        this.g = new NotificationLabel$dragCallback$1(this);
        this.f14259i = new ArrayList();
    }
}
