package com.obric.oui.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001KB'\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\b¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u000f\u0010\u001a\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0014R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001c\u0010<\u001a\u00020;8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R&\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00140@j\b\u0012\u0004\u0012\u00020\u0014`A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006L"}, d2 = {"Lcom/obric/oui/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "Landroid/view/ViewGroup;", "parent", "", "ensureViewDragHelper", "Landroid/view/View;", "child", "", "x", "y", "", "isPointInChildBounds", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onInterceptTouchEvent", "onTouchEvent", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "Lcom/obric/oui/push/NotificationLabel$a;", "dragDismissListener", "addOnDragDismissListener", "removeOnDragDismissListener", "removeAllListeners$OUI_standardRelease", "()V", "removeAllListeners", "computeScroll", "onAttachedToWindow", "openSettling", "Z", "getOpenSettling", "()Z", "setOpenSettling", "(Z)V", "dismissSettling", "getDismissSettling", "setDismissSettling", "Landroidx/customview/widget/ViewDragHelper;", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", EventBody.KEY_VALUE, "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "mOnClickListener", "Landroid/view/View$OnClickListener;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "dragCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "interceptingEvents", "getInterceptingEvents", "setInterceptingEvents", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dragDismissListeners", "Ljava/util/ArrayList;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationLabel extends CardView {
    private final String TAG;
    private boolean dismissSettling;
    private final ViewDragHelper.Callback dragCallback;
    private final ArrayList<a> dragDismissListeners;
    private boolean interceptingEvents;
    private View.OnClickListener mOnClickListener;
    private boolean openSettling;
    private ViewGroup parent;
    private ViewDragHelper viewDragHelper;

    public interface a {
        void a();

        void b();
    }

    @JvmOverloads
    public NotificationLabel(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public NotificationLabel(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public NotificationLabel(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.TAG = "NotificationLabel";
        this.dragCallback = new NotificationLabel$dragCallback$1(this);
        this.dragDismissListeners = new ArrayList();
    }

    public /* synthetic */ NotificationLabel(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ View.OnClickListener access$getMOnClickListener$p(NotificationLabel r10) {
        return r10.mOnClickListener;
    }

    public static final /* synthetic */ void access$setMOnClickListener$p(NotificationLabel r10, View.OnClickListener r11) {
        r10.mOnClickListener = r11;
    }

    private final void ensureViewDragHelper(ViewGroup r10) {
        if (this.viewDragHelper != null) goto L7;
        if (r10 == null) goto L8;
        this.viewDragHelper = ViewDragHelper.create(r10, 1.0f, this.dragCallback);
        return;
    L8:
        return;
    }

    public final void addOnDragDismissListener(a r10) {
        Intrinsics.checkNotNullParameter(r10, "dragDismissListener");
        this.dragDismissListeners.add(r10);
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r10 = this.viewDragHelper;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNull(r10);
        if (r10.continueSettling(true) == false) goto L7;
        Log.d(this.TAG, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(this.TAG, "settled");
        if (this.dismissSettling == false) goto L14;
        this.dismissSettling = false;
        Log.i(this.TAG, "onDrag dismiss");
        Iterator<T> r11 = this.dragDismissListeners.iterator();
    L11:
        if (r11.hasNext() == false) goto L24;
        ((a) r11.next()).a();
        goto L11
    L24:
        return;
    L14:
        if (this.openSettling == false) goto L23;
        this.openSettling = false;
        Log.i(this.TAG, "onDrag open");
        Iterator<T> r12 = this.dragDismissListeners.iterator();
    L17:
        if (r12.hasNext() == false) goto L25;
        ((a) r12.next()).b();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.dismissSettling;
    }

    public final boolean getInterceptingEvents() {
        return this.interceptingEvents;
    }

    public final boolean getOpenSettling() {
        return this.openSettling;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.parent;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    @SuppressLint({"RestrictedApi"})
    public final boolean isPointInChildBounds(View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "child");
        Rect r13 = new Rect();
        ViewGroupUtils.getDescendantRect(this.parent, r10, r13);
        return r13.contains(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        boolean r11 = this.interceptingEvents;
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L5;
        r11 = isPointInChildBounds(this, (int) r10.getX(), (int) r10.getY());
        this.interceptingEvents = r11;
        Log.i(this.TAG, "intercept: " + this.interceptingEvents);
    L11:
        if (r11 == false) goto L14;
        ensureViewDragHelper(this.parent);
        ViewDragHelper r13 = this.viewDragHelper;
        Intrinsics.checkNotNull(r13);
        return r13.shouldInterceptTouchEvent(r10);
    L14:
        return false;
    L5:
        if (r12 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r12 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        ViewDragHelper r11 = this.viewDragHelper;
        if (r11 == null) goto L8;
        if (r11 == null) goto L10;
        r11.processTouchEvent(r10);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final void removeAllListeners$OUI_standardRelease() {
        this.dragDismissListeners.clear();
    }

    public final void removeOnDragDismissListener(a r10) {
        Intrinsics.checkNotNullParameter(r10, "dragDismissListener");
        this.dragDismissListeners.remove(r10);
    }

    public final void setDismissSettling(boolean r10) {
        this.dismissSettling = r10;
    }

    public final void setInterceptingEvents(boolean r10) {
        this.interceptingEvents = r10;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        this.mOnClickListener = r10;
    }

    public final void setOpenSettling(boolean r10) {
        this.openSettling = r10;
    }

    public final void setParent(ViewGroup r10) {
        this.parent = r10;
        ensureViewDragHelper(r10);
    }

    public final void setViewDragHelper(ViewDragHelper r10) {
        this.viewDragHelper = r10;
    }
}
