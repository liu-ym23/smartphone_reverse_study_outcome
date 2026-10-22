package com.bytedance.ies.xelement;

import ai.j0;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.vo.a;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.a0;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.z;
import en.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oe.f;
import oe.g;
import oe.h;
import oe.i;
import oe.j;
import oe.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u001c\u001d\u001e\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\bJ\u0019\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xelement/LynxScrollView;", "Lcom/lynx/tasm/behavior/ui/scroll/AbsLynxUIScroll;", "Lcom/bytedance/ies/xelement/BounceLayout;", "Lcom/lynx/tasm/behavior/u0;", "", "enable", "", "enableLoadMore", "(Z)V", "Lcom/lynx/react/bridge/ReadableMap;", "param", "Lcom/lynx/react/bridge/Callback;", "callback", "scrollToIndex", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "", "id", "scrollToId", "(Ljava/lang/String;)V", MessageIndication.CONTENT_TYPE_TEXT, "overflowText", "setBounces", "setPageEnable", "direction", "setLayoutDirection", "setUnifiedNotifyItemChanged", "value", "setEnableCustomHittest", "oe/f", "en/b", "oe/g", "oe/h", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxScrollView extends AbsLynxUIScroll<BounceLayout> implements u0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f6363l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6366c;
    public LynxScrollView$createView$1$3 d;
    public LynxBounceView e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f6368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet f6369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashSet f6370k;

    public LynxScrollView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f6364a = "LynxScrollView";
        this.f6368i = new ArrayList();
        this.f6369j = new HashSet();
        this.f6370k = new HashSet();
    }

    public static final /* synthetic */ View j(LynxScrollView r5) {
        return r5.mView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void b(LynxBaseUI r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r12, "block");
        Intrinsics.checkNotNullParameter(r13, "inline");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r12, "block");
        Intrinsics.checkNotNullParameter(r13, "inline");
        LynxBaseUI r5 = r10;
    L4:
        if (r5.getParent() == this) goto L10;
        a0 r14 = r5.getParent();
        if (r14 == null) goto L9;
        r5 = (LynxBaseUI) r14;
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L10:
        int r15 = this.mChildren.indexOf(r5);
        LynxScrollView$createView$1$3 r16 = this.d;
        Integer r17 = null;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r16 = null;
    L13:
        RecyclerView.LayoutManager r18 = r16.getLayoutManager();
        if ((r18 instanceof LinearLayoutManager) == false) goto L16;
        LinearLayoutManager r19 = (LinearLayoutManager) r18;
    L17:
        if (r19 == null) goto L19;
        r17 = Integer.valueOf(r19.getOrientation());
    L19:
        int r20 = 0;
        if (r17 == null) goto L37;
        if (r17.intValue() != 1) goto L37;
        if (Intrinsics.areEqual("center", r12) == false) goto L28;
        r20 = (((BounceLayout) getView()).getHeight() - r10.getHeight()) / 2;
    L30:
        if (r10 == r5) goto L48;
        r20 = r20 - r10.getTop();
        a0 r110 = r10.getParent();
        if (r110 == null) goto L35;
        r10 = (LynxBaseUI) r110;
        goto L30
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L48:
        if (r11 == true) goto L51;
        if (r19 == null) goto L63;
        r19.scrollToPositionWithOffset(r15, r20);
        return;
    L63:
        return;
    L51:
        LynxContext r21 = this.mContext;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r21, "context");
        h r111 = new h(r21);
        r111.setTargetPosition(r15);
        if (r19 == null) goto L65;
        r19.startSmoothScroll(r111);
        return;
    L65:
        return;
    L28:
        if (Intrinsics.areEqual("end", r12) == false) goto L30;
        r20 = ((BounceLayout) getView()).getHeight() - r10.getHeight();
    L37:
        if (Intrinsics.areEqual("center", r13) == false) goto L40;
        r20 = (((BounceLayout) getView()).getWidth() - r10.getWidth()) / 2;
    L42:
        if (r10 == r5) goto L48;
        r20 = r20 - r10.getLeft();
        a0 r112 = r10.getParent();
        if (r112 == null) goto L47;
        r10 = (LynxBaseUI) r112;
        goto L42
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L40:
        if (Intrinsics.areEqual("end", r13) == false) goto L42;
        r20 = ((BounceLayout) getView()).getWidth() - r10.getWidth();
        goto L42
    L16:
        r19 = null;
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void c(boolean r5) {
        LinearLayoutManager r10 = null;
        if (r5 == false) goto L14;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.d);
        LynxScrollView$createView$1$3 r11 = this.d;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r11 = null;
    L7:
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L10;
        r10 = (LinearLayoutManager) r12;
    L10:
        if (r10 == null) goto L24;
        r10.setOrientation(0);
        return;
    L24:
        return;
    L14:
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.f6357b);
        LynxScrollView$createView$1$3 r13 = this.d;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r13 = null;
    L17:
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if ((r14 instanceof LinearLayoutManager) == false) goto L20;
        r10 = (LinearLayoutManager) r14;
    L20:
        if (r10 != null) goto L22;
        return;
    L22:
        r10.setOrientation(1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean canHaveFlattenChild() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, com.bytedance.ies.xelement.LynxScrollView$createView$1$3] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(final Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        BounceLayout r5 = new BounceLayout(r10);
        Log.d("Django", "createView");
        r5.setOnScrollToEndListener(new i(this));
        r5.setOnBounceScrollListener(new j(this));
        r5.setMScrollDirection(BounceLayout.ScrollDirection.f6357b);
        ?? r11 = new LynxScrollView$createView$1$3(r10);
        f r12 = new f();
        new HashSet();
        r11.setAdapter(r12);
        r11.setLayoutDirection(0);
        Intrinsics.checkNotNullParameter(r10, "context");
        g r13 = new g(r10);
        r13.setOrientation(1);
        r11.setLayoutManager(r13);
        r11.addOnScrollListener(new b());
        r11.setClipToPadding(false);
        this.d = r11;
        r5.setMContentView(r11);
        LynxScrollView$createView$1$3 r14 = this.d;
        LynxScrollView$createView$1$3 r15 = null;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r14 = null;
    L5:
        r14.setClipChildren(false);
        LynxScrollView$createView$1$3 r16 = this.d;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L9:
        l9.g r17 = new l9.g(2);
        Intrinsics.checkNotNullParameter(r15, "recyclerView");
        r15.addOnScrollListener((RecyclerItemStatusHelper$recyclerScrollListener$1) r17.e);
        Intrinsics.checkNotNullParameter(r15, "recyclerView");
        r17.d = new k(r15, r17);
        ViewTreeObserver r18 = r15.getViewTreeObserver();
        if (r18 == null) goto L12;
        r18.addOnScrollChangedListener((k) r17.d);
    L12:
        r5.setClipChildren(false);
        return r5;
    L8:
        r15 = r16;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        if (this.f6367h == false) goto L6;
        this.f6368i.clear();
        return;
    }

    @c0(defaultBoolean = true, name = "enable-load-more")
    public final void enableLoadMore(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        LynxScrollView$createView$1$3 r5 = this.d;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r5 = null;
    L6:
        return r5.computeHorizontalScrollOffset();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        LynxScrollView$createView$1$3 r5 = this.d;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r5 = null;
    L6:
        return r5.computeVerticalScrollOffset();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void i(boolean r5) {
        LinearLayoutManager r10 = null;
        if (r5 == true) goto L14;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.d);
        LynxScrollView$createView$1$3 r11 = this.d;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r11 = null;
    L7:
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L10;
        r10 = (LinearLayoutManager) r12;
    L10:
        if (r10 == null) goto L24;
        r10.setOrientation(0);
        return;
    L24:
        return;
    L14:
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.f6357b);
        LynxScrollView$createView$1$3 r13 = this.d;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r13 = null;
    L17:
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if ((r14 instanceof LinearLayoutManager) == false) goto L20;
        r10 = (LinearLayoutManager) r14;
    L20:
        if (r10 != null) goto L22;
        return;
    L22:
        r10.setOrientation(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        LynxLog.b(1, this.f6364a, "insertChild " + r5 + " at index = " + r10 + " withunifiedNotifyItemChanged = " + this.f6367h);
        if ((r5 instanceof LynxBounceView) == false) goto L30;
        LynxBounceView r11 = (LynxBounceView) r5;
        String r12 = r11.f6359a;
        int r13 = r12.hashCode();
        if (r13 == (-1383228885)) goto L25;
        if (r13 == 115029) goto L21;
        if (r13 == 3317767) goto L17;
        if (r13 == 108511772) goto L14;
    L28:
        this.e = r11;
        ((BounceLayout) this.mView).setMBounceView(r11.getView());
    L40:
        r5.setParent(this);
        return;
    L14:
        if (r12.equals("right") == false) goto L28;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.d);
        goto L28
    L17:
        if (r12.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L28;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.f6358c);
        goto L28
    L21:
        if (r12.equals("top") == false) goto L28;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.f6356a);
        goto L28
    L25:
        if (r12.equals("bottom") == false) goto L28;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.f6357b);
        goto L28
    L30:
        if ((r5 instanceof LynxUI) == false) goto L40;
        this.mChildren.add(r10, r5);
        if (this.f6367h == false) goto L34;
        this.f6369j.add(Integer.valueOf(r10));
        goto L40
    L34:
        LynxScrollView$createView$1$3 r14 = this.d;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r14 = null;
    L37:
        RecyclerView.Adapter r15 = r14.getAdapter();
        if (r15 == null) goto L40;
        r15.notifyItemInserted(r10);
        goto L40
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isCustomHittest() {
        return this.f6366c;
    }

    public final boolean k(int r5, boolean r10) {
        if (r5 >= 0) goto L5;
        return false;
    L5:
        LynxScrollView$createView$1$3 r11 = this.d;
        LinearLayoutManager r12 = null;
        LynxScrollView$createView$1$3 r13 = null;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r11 = null;
    L9:
        if (r11.getAdapter() != null) goto L11;
        return false;
    L11:
        LynxScrollView$createView$1$3 r14 = this.d;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r14 = null;
    L14:
        RecyclerView.Adapter r15 = r14.getAdapter();
        Intrinsics.checkNotNull(r15);
        if (r15.getItemCount() > r5) goto L17;
        return false;
    L17:
        if (r10 == false) goto L23;
        LynxScrollView$createView$1$3 r16 = this.d;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L22:
        r13.smoothScrollToPosition(r5);
        return true;
    L21:
        r13 = r16;
        goto L22
    L23:
        LynxScrollView$createView$1$3 r17 = this.d;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r17 = null;
    L26:
        RecyclerView.LayoutManager r18 = r17.getLayoutManager();
        if ((r18 instanceof LinearLayoutManager) == false) goto L29;
        r12 = (LinearLayoutManager) r18;
    L29:
        if (r12 == null) goto L34;
        r12.scrollToPositionWithOffset(r5, 0);
        return true;
    L34:
        return true;
    }

    public final void l(int r10) {
        LynxScrollView$createView$1$3 r5 = this.d;
        LynxScrollView$createView$1$3 r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r5 = null;
    L5:
        int r12 = r5.computeHorizontalScrollRange();
        LynxScrollView$createView$1$3 r13 = this.d;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r13 = null;
    L8:
        int r14 = r13.computeVerticalScrollRange();
        if (r12 <= 0) goto L19;
        LynxScrollView$createView$1$3 r15 = this.d;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r15 = null;
    L13:
        int r16 = r10 - r15.computeHorizontalScrollOffset();
        LynxScrollView$createView$1$3 r17 = this.d;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L17:
        r11.scrollBy(r16, 0);
        return;
    L16:
        r11 = r17;
        goto L17
    L19:
        if (r14 <= 0) goto L29;
        LynxScrollView$createView$1$3 r18 = this.d;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r18 = null;
    L23:
        int r19 = r10 - r18.computeVerticalScrollOffset();
        LynxScrollView$createView$1$3 r20 = this.d;
        if (r20 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L27:
        r11.scrollBy(0, r19);
        return;
    L26:
        r11 = r20;
        goto L27
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void measureChildren() {
        super.measureChildren();
        LynxBounceView r5 = this.e;
        if (r5 == null) goto L5;
        r5.measure();
    L5:
        View r10 = ((BounceLayout) this.mView).getMBounceView();
        LinearLayoutManager r11 = null;
        if (r10 == null) goto L8;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
    L9:
        if (r12 == null) goto L16;
        LynxBounceView r13 = this.e;
        if (r13 == null) goto L14;
        Integer r14 = Integer.valueOf(r13.getWidth());
    L15:
        r12.width = r14.intValue();
        goto L16
    L14:
        r14 = null;
    L16:
        View r15 = ((BounceLayout) this.mView).getMBounceView();
        if (r15 == null) goto L19;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
    L20:
        if (r16 == null) goto L27;
        LynxBounceView r17 = this.e;
        if (r17 == null) goto L25;
        Integer r18 = Integer.valueOf(r17.getHeight());
    L26:
        r16.height = r18.intValue();
        goto L27
    L25:
        r18 = null;
    L27:
        LynxBounceView r19 = this.e;
        if (r19 == null) goto L30;
        r19.layout();
    L30:
        this.f = getWidth();
        this.g = getHeight();
        if (this.mChildren.isEmpty() == true) goto L50;
        LynxScrollView$createView$1$3 r20 = this.d;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r20 = null;
    L35:
        RecyclerView.LayoutManager r21 = r20.getLayoutManager();
        if ((r21 instanceof LinearLayoutManager) == false) goto L38;
        r11 = (LinearLayoutManager) r21;
    L38:
        Intrinsics.checkNotNull(r11);
        if (r11.canScrollHorizontally() == false) goto L47;
        if (this.mLynxDirection != 2) goto L44;
        this.f = (((LynxBaseUI) j0.e(this.mChildren, 1)).getMarginLeft() + (getWidth() - ((LynxBaseUI) j0.e(this.mChildren, 1)).getLeft())) + this.mPaddingLeft;
        return;
    L44:
        this.f = (((LynxBaseUI) j0.e(this.mChildren, 1)).getMarginRight() + (((LynxBaseUI) j0.e(this.mChildren, 1)).getWidth() + ((LynxBaseUI) j0.e(this.mChildren, 1)).getLeft())) + this.mPaddingLeft;
        return;
    L47:
        if (r11.canScrollVertically() == false) goto L51;
        this.g = (((LynxBaseUI) j0.e(this.mChildren, 1)).getMarginBottom() + (((LynxBaseUI) j0.e(this.mChildren, 1)).getHeight() + ((LynxBaseUI) j0.e(this.mChildren, 1)).getTop())) + this.mPaddingBottom;
        return;
    L51:
        return;
    L50:
        return;
    L19:
        r16 = null;
        goto L20
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        LynxScrollView$createView$1$3 r13 = this.d;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r13 = null;
    L5:
        r13.setPadding(r5, r11, r10, r12);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        l(0);
    }

    @c0(name = "overflow-text")
    public final void overflowText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        LynxLog.b(1, this.f6364a, "removeChild " + r5 + " with unifiedNotifyItemChanged = " + this.f6367h);
        if (this.f6367h == false) goto L9;
        int r10 = this.f6368i.indexOf(r5);
        if (r10 < 0) goto L7;
        this.f6370k.add(Integer.valueOf(r10));
    L7:
        this.mChildren.remove(r5);
        return;
    L9:
        int r11 = this.mChildren.indexOf(r5);
        if (this.mChildren.remove(r5) == false) goto L18;
        LynxScrollView$createView$1$3 r12 = this.d;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r12 = null;
    L14:
        RecyclerView.Adapter r13 = r12.getAdapter();
        if (r13 == null) goto L19;
        r13.notifyItemRemoved(r11);
        return;
    L19:
        return;
    }

    @c0(name = "scroll-to-id")
    public final void scrollToId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Iterator<T> r10 = this.mChildren.iterator();
    L3:
        LynxScrollView$createView$1$3 r11 = null;
        if (r10.hasNext() == false) goto L8;
        Object r12 = r10.next();
        if (Intrinsics.areEqual(((LynxBaseUI) r12).getName(), r5) == false) goto L3;
    L9:
        LynxBaseUI r13 = (LynxBaseUI) r12;
        if (r13 == null) goto L32;
        int r14 = this.mChildren.indexOf(r13);
        LynxScrollView$createView$1$3 r15 = this.d;
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r15 = null;
    L15:
        if (r15.getAdapter() == null) goto L33;
        LynxScrollView$createView$1$3 r16 = this.d;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r16 = null;
    L20:
        RecyclerView.Adapter r17 = r16.getAdapter();
        Intrinsics.checkNotNull(r17);
        if (r17.getItemCount() <= r14) goto L34;
        LynxScrollView$createView$1$3 r18 = this.d;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L27:
        r11.smoothScrollToPosition(r14);
        return;
    L26:
        r11 = r18;
        goto L27
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r5) {
        k(r5, false);
    }

    @c0(defaultBoolean = false, name = "bounce")
    public final void setBounces(boolean r5) {
        ((BounceLayout) this.mView).setMEnableBounce(r5);
    }

    @c0(name = "enable-custom-hittest")
    public final void setEnableCustomHittest(boolean r5) {
        this.f6366c = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        Log.d("Django", "setEvents: " + r5);
        if (r5 == null) goto L6;
        r5.containsKey("scrolltolower");
        r5.containsKey("scrolltoupper");
        r5.containsKey("scroll");
        this.f6365b = r5.containsKey("scrolltobounce");
        r5.containsKey("dragend");
        return;
    }

    @RequiresApi(17)
    @c0(name = "layout-direction")
    public final void setLayoutDirection(String r5) {
        Intrinsics.checkNotNullParameter(r5, "direction");
        LynxScrollView$createView$1$3 r10 = null;
        if (Intrinsics.areEqual(r5, "ltr") == false) goto L11;
        LynxScrollView$createView$1$3 r11 = this.d;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r10.setLayoutDirection(0);
        return;
    L7:
        r10 = r11;
        goto L8
    L11:
        if (Intrinsics.areEqual(r5, "rtl") == false) goto L18;
        LynxScrollView$createView$1$3 r12 = this.d;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L16:
        r10.setLayoutDirection(1);
        return;
    L15:
        r10 = r12;
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r5) {
        this.mLynxDirection = r5;
        LynxScrollView$createView$1$3 r10 = null;
        if (r5 != 2) goto L10;
        LynxScrollView$createView$1$3 r11 = this.d;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r10.setLayoutDirection(1);
        return;
    L7:
        r10 = r11;
        goto L8
    L10:
        LynxScrollView$createView$1$3 r12 = this.d;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L14:
        r10.setLayoutDirection(0);
        return;
    L13:
        r10 = r12;
        goto L14
    }

    @c0(defaultBoolean = false, name = "page-enable")
    public final void setPageEnable(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r5) {
        LynxScrollView$createView$1$3 r10 = null;
        if (((BounceLayout) this.mView).getMScrollDirection() != BounceLayout.ScrollDirection.f6357b) goto L5;
    L19:
        LynxScrollView$createView$1$3 r11 = this.d;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L23:
        r10.setVerticalScrollBarEnabled(r5);
        return;
    L22:
        r10 = r11;
        goto L23
    L5:
        if (((BounceLayout) this.mView).getMScrollDirection() == BounceLayout.ScrollDirection.f6356a) goto L19;
        if (((BounceLayout) this.mView).getMScrollDirection() != BounceLayout.ScrollDirection.f6358c) goto L10;
    L13:
        LynxScrollView$createView$1$3 r12 = this.d;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L17:
        r10.setHorizontalScrollBarEnabled(r5);
        return;
    L16:
        r10 = r12;
        goto L17
    L10:
        if (((BounceLayout) this.mView).getMScrollDirection() == BounceLayout.ScrollDirection.d) goto L13;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r5) {
        l(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r5) {
        l(r5);
    }

    @c0(defaultBoolean = false, name = "android-unified-notify-item-changed")
    public final void setUnifiedNotifyItemChanged(boolean r5) {
        this.f6367h = r5;
        if (r5 == false) goto L9;
        LynxScrollView$createView$1$3 r10 = this.d;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r10 = null;
    L7:
        r10.setItemAnimator(null);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r5) {
    }

    @f0
    public final void scrollToIndex(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r10, "callback");
        JavaOnlyMap r11 = new JavaOnlyMap();
    L7:
        th = move-exception;
        r11.put("error", th.getMessage());
        r10.invoke(new Object[]{4, r11});
        return;
    L4:
        if (k(r5.getInt("index", 0), r5.getBoolean("smooth", false)) == false) goto L9;
        r10.invoke(new Object[]{0, r11});     // Catch: Throwable -> L7
        return;
    L9:
        r10.invoke(new Object[]{1, r11});     // Catch: Throwable -> L7
    }

    @Override // com.lynx.tasm.behavior.u0
    public final void b() {
        if (this.f6367h == true) goto L5;
        return;
    L5:
        ArrayList r5 = new ArrayList();
        HashSet r10 = this.f6370k;
        r5.addAll(r10);
        CollectionsKt.sortWith(r5, new a(5));
        Iterator r11 = r5.iterator();
    L6:
        boolean r12 = r11.hasNext();
        LynxScrollView$createView$1$3 r13 = null;
        String r14 = this.f6364a;
        if (r12 == false) goto L17;
        Integer r15 = (Integer) r11.next();
        if (r15.intValue() < 0) goto L6;
        LynxLog.b(1, r14, "onPatchFinish: notifyItemRemoved = " + r15.intValue());
        LynxScrollView$createView$1$3 r16 = this.d;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L14:
        RecyclerView.Adapter r17 = r13.getAdapter();
        if (r17 == null) goto L6;
        r17.notifyItemRemoved(r15.intValue());
        goto L6
    L13:
        r13 = r16;
        goto L14
    L17:
        ArrayList r18 = new ArrayList();
        HashSet r19 = this.f6369j;
        r18.addAll(r19);
        CollectionsKt.sortWith(r18, new a(6));
        Iterator r20 = r18.iterator();
    L19:
        if (r20.hasNext() == false) goto L28;
        Integer r21 = (Integer) r20.next();
        if (r21.intValue() < 0) goto L19;
        LynxLog.b(1, r14, "onPatchFinish: notifyItemInserted = " + r21.intValue());
        LynxScrollView$createView$1$3 r22 = this.d;
        if (r22 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r22 = null;
    L25:
        RecyclerView.Adapter r23 = r22.getAdapter();
        if (r23 == null) goto L19;
        r23.notifyItemInserted(r21.intValue());
        goto L19
    L28:
        ArrayList r24 = this.f6368i;
        r24.clear();
        r24.addAll(this.mChildren);
        r19.clear();
        r10.clear();
    }
}
