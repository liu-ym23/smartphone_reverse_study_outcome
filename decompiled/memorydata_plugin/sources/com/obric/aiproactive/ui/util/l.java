package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0003J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\tH\u0002¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/ui/util/ProactiveSelectableText;", "", "<init>", "()V", "forwardTapToCard", "", "textView", "Landroid/widget/TextView;", "card", "Landroid/view/View;", "clearCardTapForwarding", "preserveLinksAndSelection", "installTouchRouting", "onPlainTap", "Lkotlin/Function0;", "ensureNativeSelection", "hasSelectedRange", "", "clickableSpanAt", "Landroid/text/style/ClickableSpan;", "event", "Landroid/view/MotionEvent;", "findParentRecyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f6890a = null;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/util/ProactiveSelectableText$installTouchRouting$1", "Landroid/view/ActionMode$Callback;", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f6891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f6892b;
        final /* synthetic */ Ref.ObjectRef<RecyclerView> c;
        final /* synthetic */ Ref.ObjectRef<Integer> d;

        a(Ref.BooleanRef r1, TextView r2, Ref.ObjectRef<RecyclerView> r3, Ref.ObjectRef<Integer> r4) {
            this.f6891a = r1;
            this.f6892b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r1, "item");
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r5, Menu r6) {
            Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r6, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "mode");
            Intrinsics.checkNotNullParameter(r7, "menu");
            this.f6891a.element = true;
            ViewParent r8 = this.f6892b.getParent();
            if (r8 == null) goto L5;
            r8.requestDisallowInterceptTouchEvent(true);
        L5:
            Ref.ObjectRef<RecyclerView> r9 = this.c;
            RecyclerView r0 = l.a(l.f6890a, (View) ZeusTransformUtils.preCheckCast(this.f6892b, View.class, "com.obric.memorydata.plugin"));
            if (r0 == null) goto L8;
            Ref.ObjectRef<Integer> r4 = this.d;
            r4.element = Integer.valueOf(r0.getOverScrollMode());
            r0.setOverScrollMode(2);
            T r1 = r0;
        L9:
            r9.element = r1;
            return true;
        L8:
            r1 = 0;
            goto L9
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r4) {
            Intrinsics.checkNotNullParameter(r4, "mode");
            RecyclerView r5 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.c.element, RecyclerView.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L7;
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.d.element, Integer.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            r5.setOverScrollMode(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue());
        L7:
            this.c.element = null;
            this.d.element = null;
            this.f6891a.element = false;
            ViewParent r3 = this.f6892b.getParent();
            if (r3 == null) goto L11;
            r3.requestDisallowInterceptTouchEvent(false);
            return;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r1, "menu");
            return true;
        }
    }

    static {
        f6890a = new l();
    }

    private l() {
    }

    private final ClickableSpan a(TextView r6, MotionEvent r7) {
        CharSequence r5 = r6.getText();
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == false) goto L5;
        Spanned r8 = (Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 != null) goto L8;
        return null;
    L8:
        Layout r0 = r6.getLayout();
        if (r0 != null) goto L11;
        return null;
    L11:
        int r3 = (((int) r7.getX()) - r6.getTotalPaddingLeft()) + r6.getScrollX();
        int r9 = (((int) r7.getY()) - r6.getTotalPaddingTop()) + r6.getScrollY();
        if (r3 < 0) goto L24;
        if (r9 < 0) goto L24;
        if (r9 > r0.getHeight()) goto L24;
        int r10 = r0.getLineForVertical(r9);
        float r11 = r3;
        if (r11 < r0.getLineLeft(r10)) goto L24;
        if (r11 > r0.getLineRight(r10)) goto L24;
        int r12 = r0.getOffsetForHorizontal(r10, r11);
        Object[] r13 = r8.getSpans(r12, r12, ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(r13, "getSpans(...)");
        return (ClickableSpan) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r13), ClickableSpan.class, "com.obric.memorydata.plugin");
    L24:
        return null;
    L5:
        r8 = null;
        goto L6
    }

    private final RecyclerView a(View r2) {
        ViewParent r1 = r2.getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, RecyclerView.class) == true) goto L8;
        r1 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L8:
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r1, RecyclerView.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    public static final /* synthetic */ RecyclerView a(l r0, View r1) {
        return r0.a(r1);
    }

    private static final void a(TextView r2, ClickableSpan r3, ClickableSpan r4, Function0 r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if (f6890a.c(r2) == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r3 != r4) goto L8;
        r3.onClick((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        if (r3 != null) goto L14;
        if (r4 != null) goto L15;
        if (r6 == null) goto L16;
        r6.invoke();
        return;
    L16:
        return;
    L15:
        return;
    }

    private final void a(final TextView r16, Function0<Unit> r17) {
        final Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        final int r7 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final long r9 = ViewConfiguration.getLongPressTimeout();
        final Ref.FloatRef r2 = new Ref.FloatRef();
        final Ref.FloatRef r3 = new Ref.FloatRef();
        final Ref.LongRef r4 = new Ref.LongRef();
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r16.setCustomSelectionActionModeCallback((ActionMode.Callback) ZeusTransformUtils.preCheckCast(new a(r8, r16, new Ref.ObjectRef(), new Ref.ObjectRef()), ActionMode.Callback.class, "com.obric.memorydata.plugin"));
        r16.setOnClickListener(null);
        r16.setOnTouchListener(new $$Lambda$l$3KVnuL2ToWNagw6qE89pHvuCHQ(r16, r2, r3, r4, r5, r6, r7, r8, r9, r11));
        b(r16);
        r16.post(new $$Lambda$l$spIQXv02cWLMenJtYbs8tNNKNCY(r16));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.text.style.ClickableSpan] */
    private static final boolean a(final TextView r16, Ref.FloatRef r17, Ref.FloatRef r18, Ref.LongRef r19, Ref.ObjectRef r20, Ref.BooleanRef r21, int r22, Ref.BooleanRef r23, long r24, Function0 r26, View r27, MotionEvent r28) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
        int r10 = r28.getActionMasked();
        if (r10 != 0) goto L5;
        l r6 = f6890a;
        r6.b(r16);
        ViewParent r9 = r16.getParent();
        if (r9 == null) goto L52;
        r9.requestDisallowInterceptTouchEvent(true);
    L52:
        r16.onTouchEvent(r28);
        r17.element = r28.getX();
        r18.element = r28.getY();
        r19.element = r28.getEventTime();
        Intrinsics.checkNotNull(r28);
        r20.element = r6.a(r16, r28);
    L17:
        r21.element = false;
        return true;
    L5:
        if (r10 != 1) goto L7;
        r16.onTouchEvent(r28);
        if ((r28.getEventTime() - r19.element) >= r24) goto L32;
        boolean r1 = true;
    L34:
        if (r23.element == false) goto L36;
    L39:
        boolean r2 = true;
    L40:
        if (r2 == true) goto L44;
        ViewParent r3 = r16.getParent();
        if (r3 == null) goto L44;
        r3.requestDisallowInterceptTouchEvent(false);
    L44:
        final ClickableSpan r4 = (ClickableSpan) ZeusTransformUtils.preCheckCast(r20.element, ClickableSpan.class, "com.obric.memorydata.plugin");
        r20.element = null;
        if (r21.element == true) goto L60;
        if (r1 == false) goto L61;
        if (r2 == true) goto L62;
        l r5 = f6890a;
        Intrinsics.checkNotNull(r28);
        final ClickableSpan r7 = r5.a(r16, r28);
        r16.post(new $$Lambda$l$kZbBbeHTolqd5GGOQR8nn5psWLY(r16, r4, r7, r8));
        return true;
    L62:
        return true;
    L61:
        return true;
    L60:
        return true;
    L36:
        if (f6890a.c(r16) == true) goto L39;
        r2 = false;
        goto L40
    L32:
        r1 = false;
        goto L34
    L7:
        if (r10 != 2) goto L9;
        r16.onTouchEvent(r28);
        float r11 = r22;
        if (Math.abs(r28.getX() - r17.element) <= r11) goto L21;
    L22:
        r21.element = true;
        if (r23.element == false) goto L25;
        return true;
    L25:
        if (f6890a.c(r16) == true) goto L57;
        ViewParent r0 = r16.getParent();
        if (r0 == null) goto L58;
        r0.requestDisallowInterceptTouchEvent(false);
        return true;
    L58:
        return true;
    L57:
        return true;
    L21:
        if (Math.abs(r28.getY() - r18.element) > r11) goto L22;
        return true;
    L9:
        if (r10 != 3) goto L53;
        r16.onTouchEvent(r28);
        if (r23.element == true) goto L16;
        ViewParent r12 = r16.getParent();
        if (r12 == null) goto L16;
        r12.requestDisallowInterceptTouchEvent(false);
    L16:
        r20.element = null;
        goto L17
    L53:
        return r16.onTouchEvent(r28);
    }

    private static final Unit b(View r0) {
        r0.performClick();
        return Unit.INSTANCE;
    }

    private final void b(TextView r1) {
        r1.setTextIsSelectable(true);
        r1.setClickable(true);
        r1.setLongClickable(true);
    }

    private final boolean c(TextView r1) {
        int r0 = r1.getSelectionStart();
        int r2 = r1.getSelectionEnd();
        if (r0 < 0) goto L7;
        if (r2 < 0) goto L7;
        if (r0 == r2) goto L7;
        return true;
    L7:
        return false;
    }

    private static final void d(TextView r1) {
        f6890a.b(r1);
    }

    /* JADX INFO: renamed from: lambda$3KV-nuL2ToWNagw6qE89pHvuCHQ, reason: not valid java name */
    public static /* synthetic */ boolean m352lambda$3KVnuL2ToWNagw6qE89pHvuCHQ(TextView r0, Ref.FloatRef r1, Ref.FloatRef r2, Ref.LongRef r3, Ref.ObjectRef r4, Ref.BooleanRef r5, int r6, Ref.BooleanRef r7, long r8, Function0 r10, View r11, MotionEvent r12) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12);
    }

    public static /* synthetic */ void lambda$kZbBbeHTolqd5GGOQR8nn5psWLY(TextView r0, ClickableSpan r1, ClickableSpan r2, Function0 r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$spIQXv02cWLMenJtYbs8tNNKNCY(TextView r0) {
        d(r0);
    }

    /* JADX INFO: renamed from: lambda$tJP-j8Whv5W3THZLzyWnxXUjE5s, reason: not valid java name */
    public static /* synthetic */ Unit m353lambda$tJPj8Whv5W3THZLzyWnxXUjE5s(View r0) {
        return b(r0);
    }

    public final void a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        a(r2, null);
    }

    public final void a(TextView r2, final View r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "card");
        a(r2, new $$Lambda$l$tJPj8Whv5W3THZLzyWnxXUjE5s(r3));
    }
}
