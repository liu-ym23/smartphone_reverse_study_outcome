package com.bytedance.android.live.room.incentiveinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fRN\u0010\u0016\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/IncentiveInfoLayout;", "", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getDisplayView", "Lx81/b;", "Lu81/d;", "h", "Lx81/b;", "getItemHolderPool", "()Lx81/b;", "setItemHolderPool", "(Lx81/b;)V", "itemHolderPool", "Lu81/c;", "value", "j", "Lu81/c;", "getAdapter", "()Lu81/c;", "setAdapter", "(Lu81/c;)V", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "LayoutParams", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncentiveInfoLayout extends FrameLayout {
    public boolean a;
    public int b;
    public WeakReference<View> c;
    public u81.f d;
    public Disposable e;
    public e f;
    public final CarouselAnimController g;
    public x81.b<u81.d> h;
    public final b i;
    public u81.c<? extends Object, ? extends u81.d> j;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/IncentiveInfoLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public u81.d a;
        public Object b;

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
        }

        public LayoutParams(Context r2, AttributeSet r3) {
            Intrinsics.checkNotNullParameter(r2, "c");
            super(r2, r3);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.room.incentiveinfo.datamonitor.d<Object> {
        public final /* synthetic */ IncentiveInfoLayout a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.d
        public final void onChange() {
            WeakReference<View> r0 = this.a.c;
            if (r0 == null) goto L5;
            View r1 = r0.get();
        L6:
            u81.c<? extends Object, ? extends u81.d> r2 = this.a.getAdapter();
            if ((r2 instanceof u81.c) == true) goto L9;
            r2 = null;
        L9:
            int r3 = 0;
            if (r2 == null) goto L12;
            int r4 = r2.getItemSize();
        L13:
            if (r1 == null) goto L85;
            LayoutParams r5 = x81.a.a(r1);
            if (r5 == null) goto L86;
            Object r6 = r5.b;
            if (r6 != 0) goto L19;
            return;
        L19:
            u81.d r7 = r5.a;
            if (r7 != null) goto L23;
            return;
        L23:
            if (r2 == null) goto L25;
            int r8 = r2.getDataPosition(r6);
        L27:
            if (r8 >= 0) goto L68;
            IncentiveInfoLayout r9 = this.a;
            r9.a();
            r9.d = null;
            if (r4 > 0) goto L58;
            ALogger.d("IncentiveInfoLayout", "carousel stop, item size is 0");
            IncentiveInfoLayout r10 = this.a;
            r10.c = null;
            r10.b = -1;
            Iterator r12 = UtilityKotlinExtentionsKt.g(r10).iterator();
        L32:
            if (r12.hasNext() == false) goto L41;
            ((View) r12.next()).clearAnimation();     // Catch: Exception -> L36
        L36:
            e = move-exception;
            ALogger.e("IncentiveInfoLayout", e);
            if (v.a() == false) goto L32;
            throw e;
        L41:
            IncentiveInfoLayout r13 = this.a;
            r13.getClass();
            Iterator r14 = UtilityKotlinExtentionsKt.g(r13).iterator();
        L43:
            if (r14.hasNext() == false) goto L57;
            View r15 = (View) r14.next();
            LayoutParams r16 = x81.a.a(r15);
            if (r16 == null) goto L56;
            u81.d r17 = r16.a;
            if (r17 == null) goto L56;
            x81.b<u81.d> r18 = r13.h;
            if (r18 == null) goto L56;
            Intrinsics.checkNotNullParameter(r17, "instance");
            LayoutParams r19 = x81.a.a(r17.a());
            if (r19 == null) goto L53;
            r19.a = null;
            r19.b = null;
        L53:
            int r20 = r18.a(r17.getItemType(), r17.b());
            if (r20 == (-1)) goto L56;
            r18.a[r20] = 0;
        L56:
            r15.clearAnimation();
            goto L43
        L57:
            r13.removeAllViews();
            return;
        L58:
            IncentiveInfoLayout r22 = this.a;
            int r23 = r22.b + 1;
            if (r23 < 0) goto L67;
            u81.c<? extends Object, ? extends u81.d> r24 = r22.getAdapter();
            if (r24 == null) goto L63;
            int r25 = r24.getItemSize();
        L64:
            if (r23 >= r25) goto L67;
            r3 = r23;
            goto L67
        L63:
            r25 = 0;
        L67:
            r22.c(r3, true);
            return;
        L68:
            if (r8 != 0) goto L89;
            if (r4 != 1) goto L90;
            r7.d();
            return;
        L90:
            return;
        L89:
            return;
        L25:
            r8 = -1;
            goto L27
        L86:
            return;
        L85:
            return;
        L12:
            r4 = 0;
            goto L13
        L5:
            r1 = null;
            goto L6
        }

        public b(IncentiveInfoLayout r1) {
            this.a = r1;
        }
    }

    static {
    }

    public IncentiveInfoLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IncentiveInfoLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        u81.f r0 = this.d;
        if (r0 == null) goto L20;
        int r3 = r0.a();
        if (r3 <= 0) goto L11;
        if (r3 != 1) goto L15;
        e r4 = this.f;
        if (r4 == null) goto L15;
        if (r0.b(r4) == true) goto L11;
    L15:
        e r5 = this.f;
        if (r5 == null) goto L18;
        r0.c(r5);
    L19:
        if (r5 == null) goto L20;
        return;
    L18:
        r5 = null;
    L11:
        Disposable r6 = this.e;
        if (r6 == null) goto L14;
        r6.dispose();
    L14:
        this.e = null;
    L20:
        Disposable r1 = this.e;
        if (r1 != null) goto L23;
    L28:
        this.e = null;
        Unit r2 = Unit.INSTANCE;
        return;
    L23:
        if ((true ^ r1.isDisposed()) == true) goto L26;
        r1 = null;
    L26:
        if (r1 == null) goto L28;
        r1.dispose();
        goto L28
    }

    public View getDisplayView() {
        WeakReference<View> r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public u81.c<? extends Object, ? extends u81.d> getAdapter() {
        return this.j;
    }

    public final x81.b<u81.d> getItemHolderPool() {
        return this.h;
    }

    public final boolean b(Object r2) {
        WeakReference<View> r0 = this.c;
        if (r0 == null) goto L13;
        View r1 = r0.get();
        if (r1 == null) goto L13;
        LayoutParams r3 = x81.a.a(r1);
        if (r3 == null) goto L13;
        u81.d r4 = r3.a;
        if (r4 == null) goto L11;
        w81.a r5 = x81.a.c(r4);
    L15:
        return Intrinsics.areEqual(r5, r2);
    L11:
        r5 = null;
    L13:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public final void d(int r3) {
        ALogger.d("IncentiveInfoLayout", "updateCurItemStatus, position is " + r3);
        u81.c<? extends Object, ? extends u81.d> r0 = getAdapter();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getItemSize() > 0) goto L8;
        return;
    L8:
        w81.a r1 = r0.getData(r3);
        r0.getItemViewType(r3);
        if (b(r1) == true) goto L11;
        return;
    L11:
        this.b = r3;
        WeakReference<View> r2 = this.c;
        if (r2 == null) goto L21;
        View r4 = r2.get();
        if (r4 == null) goto L22;
        LayoutParams r5 = x81.a.a(r4);
        if (r5 == null) goto L23;
        u81.d r6 = r5.a;
        if (r6 == null) goto L24;
        r0.a(r6, r3);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L6:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L9:
        return new ViewGroup.LayoutParams(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdapter(u81.c<? extends Object, ? extends u81.d> r5) {
        if ((!Intrinsics.areEqual(this.j, r5)) == false) goto L29;
        u81.c<? extends Object, ? extends u81.d> r0 = this.j;
        if ((r0 instanceof u81.c) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        r0.b(null);
    L9:
        removeAllViews();
        x81.b<u81.d> r1 = this.h;
        if (r1 == null) goto L21;
        int r2 = 0;
    L13:
        if (r2 >= 99) goto L21;
        Pair r3 = r1.a[r2];
        if (r3 == null) goto L20;
        u81.d r4 = (u81.d) r3.getSecond();
        if (r4 == null) goto L19;
        r4.onDestroy();
    L19:
        r1.a[r2] = 0;
    L20:
        r2 = r2 + 1;
    L21:
        a();
        this.d = null;
        this.c = null;
        this.b = -1;
        this.j = r5;
        if (r5 != null) goto L24;
        return;
    L24:
        r5.b(this.i);
        return;
    }

    public final void setItemHolderPool(x81.b<u81.d> r1) {
        this.h = r1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public final void c(int r17, boolean r18) {
        u81.c<? extends Object, ? extends u81.d> r5 = getAdapter();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getItemSize() > 0) goto L8;
        return;
    L8:
        this.b = r17;
        w81.a r6 = r5.getData(r17);
        int r1 = r5.getItemViewType(r17);
        c r9 = null;
        if (r5.getItemSize() <= 1) goto L17;
        if ((r6 instanceof w81.a) == true) goto L13;
        w81.a r2 = null;
    L14:
        if (r2 == null) goto L17;
        r2.b = Boolean.FALSE;
        goto L17
    L13:
        r2 = r6;
    L17:
        if (b(r6) == true) goto L161;
        ALogger.d("IncentiveInfoLayout", "obtain view holder, holder type is " + r1);
        x81.b<u81.d> r3 = this.h;
        if (r3 == null) goto L28;
        if (r6 == null) goto L22;
        Intrinsics.checkNotNullParameter(r6, "$this$incentiveData");
        Integer r12 = r6.d;
    L23:
        int r13 = r3.a(r1, r12);
        if (r13 == (-1)) goto L28;
        Pair r4 = r3.a[r13];
        if (r4 == null) goto L28;
        u81.d r7 = (u81.d) r4.getSecond();
    L30:
        if ((r6 instanceof w81.a) == true) goto L32;
        w81.a r14 = null;
    L33:
        if (r14 == null) goto L35;
        String r15 = r14.c;
    L37:
        if (r7 != null) goto L57;
        if (r6 == null) goto L40;
        Intrinsics.checkNotNullParameter(r6, "$this$incentiveData");
        Integer r8 = r6.d;
    L41:
        r7 = r5.c(this, r1, r8);
        r7.onInit();
        r7.f(r15);
        x81.b<u81.d> r10 = this.h;
        if (r10 == null) goto L59;
        Intrinsics.checkNotNullParameter(r7, "instance");
        int r16 = r7.getItemType();
        if (r10.a(r16, r7.b()) != (-1)) goto L59;
        int r19 = 0;
    L47:
        if (r19 >= 99) goto L59;
        Object[] r110 = r10.a;
        if (r110[r19] == null) goto L50;
        r19 = r19 + 1;
        goto L47
    L50:
        int r20 = r16 * 10;
        Integer r111 = r7.b();
        if (r111 == null) goto L53;
        int r112 = r111.intValue();
    L54:
        r110[r19] = new Pair(Integer.valueOf(r20 + r112), r7);
        goto L59
    L53:
        r112 = 0;
    L59:
        u81.d r113 = r7;
        View r22 = r113.a();
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 != null) goto L63;
        r23 = generateDefaultLayoutParams();
        r22.setLayoutParams(r23);
    L66:
        if ((r23 instanceof LayoutParams) == true) goto L68;
        r23 = null;
    L68:
        LayoutParams r24 = (LayoutParams) r23;
        if (r24 == null) goto L71;
        r24.b = r6;
        r24.a = r113;
        ALogger.d("IncentiveInfoLayout", "bind holder itemView's layout params data.the itemView:" + r113.a() + ".the itemData:" + r6 + '.');
    L71:
        WeakReference<View> r25 = this.c;
        if (r25 == null) goto L78;
        View r26 = r25.get();
        if (r26 == null) goto L78;
        LayoutParams r27 = x81.a.a(r26);
        if (r27 == null) goto L78;
        u81.d r114 = r27.a;
    L79:
        View r28 = r113.a();
        ViewParent r29 = r28.getParent();
        if ((r29 instanceof ViewGroup) == true) goto L82;
        r29 = null;
    L82:
        ViewGroup r30 = (ViewGroup) r29;
        if (r30 == null) goto L91;
        if ((!Intrinsics.areEqual(r30, this)) == true) goto L88;
        r30 = null;
    L88:
        if (r30 == null) goto L91;
        r30.removeView(r28);
    L91:
        if (r28.getParent() != null) goto L94;
        addView(r28);
    L98:
        Iterator r32 = UtilityKotlinExtentionsKt.g(this).iterator();
    L100:
        if (r32.hasNext() == false) goto L119;
        View r33 = (View) r32.next();
        if (r114 == null) goto L104;
        View r115 = r114.a();
    L106:
        if ((!Intrinsics.areEqual(r33, r115)) == false) goto L100;
        if ((!Intrinsics.areEqual(r33, r28)) == false) goto L100;
        StringBuilder r116 = new StringBuilder("extra view gone and its data is :");
        ViewGroup.LayoutParams r117 = r33.getLayoutParams();
        if ((r117 instanceof LayoutParams) == true) goto L112;
        r117 = null;
    L112:
        LayoutParams r118 = (LayoutParams) r117;
        if (r118 == null) goto L115;
        Object r119 = r118.b;
    L116:
        r116.append(r119);
        ALogger.d("IncentiveInfoLayout", r116.toString());
        UtilityKotlinExtentionsKt.t(r33);
        InterceptFrameLayout r34 = x81.a.b(r33);
        if (r34 == null) goto L100;
        r34.setIntercept(true);
        goto L100
    L115:
        r119 = null;
        goto L116
    L104:
        r115 = null;
        goto L106
    L119:
        if (r18 == false) goto L135;
        CarouselAnimController r35 = this.g;
        u81.b r36 = new u81.b(r5.getItemSize(), r17, r114, r113);
        r35.getClass();
        Intrinsics.checkNotNullParameter(r36, "params");
        List r37 = (List) r35.a.getValue();
        if ((r37 instanceof Collection) == true) goto L123;
    L125:
        Iterator r38 = r37.iterator();
    L127:
        if (r38.hasNext() == false) goto L131;
        if (((u81.a) r38.next()).a(r36) == false) goto L127;
        boolean r39 = true;
    L133:
        if ((!r39) == false) goto L135;
        boolean r40 = true;
    L136:
        ALogger.d("IncentiveInfoLayout", "showItemWithCarousel, position: " + r17 + ", isShowingWithAnim: " + r40);
        a();
        a();
        this.d = null;
        if (this.a == false) goto L139;
        v81.b r42 = r113.e();
        e r43 = new e(r42, this, r28);
        r42.d(r43);
        Unit r120 = Unit.INSTANCE;
        this.f = r43;
        this.d = r42;
        this.e = r42.f();
    L139:
        r5.a(r113, r17);
        CarouselAnimController r0 = this.g;
        if (r40 == true) goto L143;
        r0 = null;
    L143:
        if (r0 == null) goto L154;
        this.c = new WeakReference(r28);
        this.a = true;
        f r121 = new f(r28, this, r113, r114, r5, r6);
        Intrinsics.checkNotNullParameter(r113, "nextHolder");
        Intrinsics.checkNotNullParameter(r121, "listener");
        com.bytedance.android.live.room.incentiveinfo.b r44 = new com.bytedance.android.live.room.incentiveinfo.b(r114, r121, r113);
        if (r114 == null) goto L147;
        View r45 = r114.a();
    L148:
        View r46 = r113.a();
        if (r114 == null) goto L151;
        r9 = r114.c();
    L151:
        c r47 = r113.c();
        if (r47 == null) goto L177;
        r47.e(r46, r44);
        CarouselAnimController.a(false, r45, r9, r44);
        CarouselAnimController.a(true, r46, r47, r44);
        return;
    L177:
        return;
    L147:
        r45 = null;
        goto L148
    L154:
        if (r114 == null) goto L160;
        View r48 = r114.a();
        if (r48 == null) goto L160;
        UtilityKotlinExtentionsKt.t(r48);
        InterceptFrameLayout r49 = x81.a.b(r48);
        if (r49 == null) goto L160;
        r49.setIntercept(true);
    L160:
        this.c = new WeakReference(r28);
        this.a = true;
        return;
    L131:
        r39 = false;
        goto L133
    L123:
        if (r37.isEmpty() == false) goto L125;
    L135:
        r40 = false;
        goto L136
    L94:
        if (Intrinsics.areEqual(r28.getParent(), this) == false) goto L98;
        UtilityKotlinExtentionsKt.w(r28);
        InterceptFrameLayout r50 = x81.a.b(r28);
        if (r50 == null) goto L98;
        r50.setIntercept(false);
    L78:
        r114 = null;
        goto L79
    L63:
        if ((r23 instanceof LayoutParams) == true) goto L66;
        r23 = generateLayoutParams(r23);
        r22.setLayoutParams(r23);
        goto L66
    L40:
        r8 = null;
        goto L41
    L57:
        if (StringsKt.equals$default(r7.getIconUrl(), r15, false, 2, null) == true) goto L59;
        r7.f(r15);
        goto L59
    L35:
        r15 = null;
        goto L37
    L32:
        r14 = r6;
        goto L33
    L22:
        r12 = null;
    L28:
        r7 = null;
        goto L30
    L161:
        d(r17);
    }

    public IncentiveInfoLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = -1;
        this.g = new CarouselAnimController();
        this.i = new b(this);
    }

    public /* synthetic */ IncentiveInfoLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
