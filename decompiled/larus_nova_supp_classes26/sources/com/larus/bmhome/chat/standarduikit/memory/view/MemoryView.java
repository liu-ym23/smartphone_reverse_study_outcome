package com.larus.bmhome.chat.standarduikit.memory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdMemoryWidgetBinding;
import com.larus.utils.e1;
import jm8.d;
import jm8.e;
import jm8.f;
import jm8.g;
import jm8.h;
import jm8.j;
import jm8.k;
import jm8.m;
import jm8.n;
import km8.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 72\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u00017B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0004H\u0016J\u001a\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u001f\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryViewInput;", "Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdMemoryWidgetBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusMdMemoryWidgetBinding;", "binding$delegate", "Lkotlin/Lazy;", "isShowing", "", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "icon$delegate", "root", "Landroid/widget/LinearLayout;", "getRoot", "()Landroid/widget/LinearLayout;", "root$delegate", "memoryVcOut", "bindData", "", "input", "output", "sizeThatFits", "Landroid/util/Size;", "preferredMaxWidth", "", "updatePadding", "flowMemoryInput", "setupIconImage", "setupTitle", "setupFullView", "mobCardShow", "getCardId", "", "messageId", "cardIndex", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "tryShowTip", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemoryView extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public n f;

    public static final class a {
    }

    static {
    }

    private final LarusMdMemoryWidgetBinding getBinding() {
        return (LarusMdMemoryWidgetBinding) this.a.getValue();
    }

    private final SimpleDraweeView getIcon() {
        return (SimpleDraweeView) this.d.getValue();
    }

    private final LinearLayout getRoot() {
        return (LinearLayout) this.e.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.c.getValue();
    }

    public MemoryView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static SimpleDraweeView a(MemoryView r0) {
        return r0.getBinding().b;
    }

    public static TextView b(MemoryView r0) {
        return r0.getBinding().c;
    }

    public static LinearLayout c(MemoryView r0) {
        return r0.getBinding().a;
    }

    private final void setupFullView(final m r3) {
        if (Intrinsics.areEqual(r3.i, Boolean.TRUE) == true) goto L6;
        e1.d(getRoot(), new g(this, r3));
        ExposeXTrackerExtKt.b(this, new h(this, r3));
        return;
    }

    private final void setupIconImage(m r5) {
        boolean r0 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L7;
        String r6 = r5.f;
        if (r6 == null) goto L9;
    L10:
        GenericDraweeHierarchy r1 = getIcon().getHierarchy();
        if (r1 == null) goto L13;
        r1.setPlaceholderImage(c.b(2130972054, null, 2131243013));
    L13:
        ImageLoaderKt.u(getIcon(), r6, "markdown.media_source_icon");
        return;
    L9:
        r6 = "";
        goto L10
    L7:
        r6 = r5.g;
        if (r6 != null) goto L10;
        goto L9
    }

    private final void setupTitle(m r2) {
        TextView r0 = getTitle();
        String r3 = r2.h;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.setText(r3);
    }

    public MemoryView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new jm8.a(r2, this));
        this.c = LazyKt.lazy(new d(this));
        this.d = LazyKt.lazy(new e(this));
        this.e = LazyKt.lazy(new f(this));
    }

    public final void e(m r3, i.a r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "output");
        this.f = r4;
        if (Intrinsics.areEqual(r3.e, Boolean.TRUE) == false) goto L6;
        setVisibility(8);
        return;
    L6:
        setupIconImage(r3);
        setupTitle(r3);
        setupFullView(r3);
        Pair<Integer, Integer> r5 = r3.b;
        int r0 = 0;
        if (r5 == null) goto L9;
        int r6 = ((Number) r5.getFirst()).intValue();
    L10:
        Pair<Integer, Integer> r7 = r3.b;
        if (r7 == null) goto L13;
        r0 = ((Number) r7.getSecond()).intValue();
    L13:
        setPaddingRelative(getPaddingStart(), r6, getPaddingEnd(), r0);
        return;
    L9:
        r6 = 0;
        goto L10
    }

    public final Size f(m r3, int r4) {
        if (r3 != null) goto L7;
        return new Size(0, 0);
    L7:
        if (Intrinsics.areEqual(r3.e, Boolean.TRUE) == true) goto L9;
        getRoot().measure(0, 0);
        int r5 = getPaddingTop() + getPaddingBottom();
        return new Size(r4, getRoot().getMeasuredHeight() + r5);
    L9:
        return new Size(r4, 0);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [jm8.j] */
    public static Unit d(final MemoryView r30, m r31, LinearLayout r32) {
        Intrinsics.checkNotNullParameter(r32, "it");
        if (r30.b == true) goto L36;
        int[] r2 = new int[2];
        r30.getBinding().a.getLocationOnScreen(r2);
        if (r2[1] <= (i5.w0() + com.larus.utils.i.e(r30.getContext()))) goto L8;
        AutoOffsetPopupWindow.WindowGravity r3 = AutoOffsetPopupWindow.WindowGravity.TOP;
    L9:
        AutoOffsetPopupWindow.WindowGravity r12 = r3;
        n r4 = r30.f;
        if (r4 != null) goto L12;
    L14:
        final boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        String r6 = r30.getContext().getString(2131908115);
    L21:
        String r7 = r6;
    L22:
        Intrinsics.checkNotNull(r7);
        Integer r8 = null;
        if (r5 == false) goto L25;
        Integer r24 = Integer.valueOf(c.b(2130972057, null, 2131243026));
    L26:
        if (r5 == false) goto L28;
        r8 = Integer.valueOf(c.b(2130972123, null, 2131103203));
    L28:
        Integer r9 = r8;
        String r10 = r31.k;
        if (r10 != null) goto L31;
        String r11 = "";
    L32:
        int r13 = AutoOffsetPopupWindow.a;
        final PopupWindow r14 = AutoOffsetPopupWindow.a(r30.getContext(), r30.getBinding().a, r7, r9, r11, i5.h(), i5.h(), i5.j0(), r12, i5.h(), 0, null, new jm8.i(r30), 0, 0, null, new j(r5, r30), null, false, false, r24, i5.e0(), null, false, null, 59698176);
        long r15 = r31.c;
        if (r15 <= 0) goto L35;
        r30.postDelayed(new k(r14), r15);
    L35:
        r30.b = true;
        goto L36
    L31:
        r11 = r10;
        goto L32
    L25:
        r24 = null;
        goto L26
    L18:
        r6 = r31.j;
        if (r6 != null) goto L21;
        r7 = "";
        goto L22
    L12:
        if (r4.a() != true) goto L14;
        r5 = true;
        goto L16
    L8:
        r3 = AutoOffsetPopupWindow.WindowGravity.BOTTOM;
    L36:
        n r0 = r30.f;
        if (r0 == null) goto L40;
        r0.b();
    L40:
        return Unit.INSTANCE;
    }
}
