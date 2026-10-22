package com.larus.bmhome.chat.standarduikit.complextask.blockadapter.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ck8.b;
import ck8.c;
import ck8.d;
import ck8.g;
import ck8.h;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusComplexTaskColorCapsuleViewBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001dB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleViewInput;", "Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusComplexTaskColorCapsuleViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusComplexTaskColorCapsuleViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "defaultNameColors", "Landroid/content/res/ColorStateList;", "getDefaultNameColors", "()Landroid/content/res/ColorStateList;", "defaultNameColors$delegate", "bindData", "", "input", "output", "bindPill", "bindSummary", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskColorCapsuleView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    private final LarusComplexTaskColorCapsuleViewBinding getBinding() {
        return (LarusComplexTaskColorCapsuleViewBinding) this.a.getValue();
    }

    private final ColorStateList getDefaultNameColors() {
        return (ColorStateList) this.b.getValue();
    }

    public final void c() {
        getBinding().g.x();
    }

    public ComplexTaskColorCapsuleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static ColorStateList a(ComplexTaskColorCapsuleView r0) {
        return r0.getBinding().f.getTextColors();
    }

    public ComplexTaskColorCapsuleView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new ck8.a(r2, this));
        this.b = LazyKt.lazy(new b(this));
    }

    public final void b(final g r10, final h r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "output");
        ImageLoaderKt.u(getBinding().e, r10.a, "ComplexTaskColorCapsuleView");
        getBinding().f.setText(r10.b);
        we8.a.b(getBinding().f, i5.t(), false, null, null, 12);
        TextView r0 = getBinding().f;
        Integer r1 = r10.c;
        if (r1 == null) goto L6;
        ColorStateList r2 = ColorStateList.valueOf(r1.intValue());
        if (r2 == null) goto L6;
    L7:
        r0.setTextColor(r2);
        LinearLayout r3 = getBinding().d;
        Integer r4 = r10.d;
        boolean r5 = false;
        if (r4 == null) goto L10;
        int r6 = r4.intValue();
    L11:
        r3.setBackgroundTintList(ColorStateList.valueOf(r6));
        ShimmerTextView r7 = getBinding().g;
        r7.setText(r10.e);
        Intrinsics.checkNotNull(r7);
        we8.a.b(r7, i5.t(), false, null, null, 12);
        r7.setTypeface(Typeface.DEFAULT, 0);
        if (r10.f == false) goto L14;
        r7.z(false);
    L15:
        View r8 = getBinding().b;
        if (r10.g == false) goto L18;
        int r9 = 0;
    L19:
        r8.setVisibility(r9);
        LinearLayout r12 = getBinding().c;
        Integer r13 = r10.k;
        if (r13 == null) goto L22;
        int r14 = r13.intValue();
    L23:
        r12.setBackgroundResource(r14);
        Pair<Integer, Integer> r15 = r10.h;
        if (r15 == null) goto L26;
        int r16 = ((Number) r15.getFirst()).intValue();
    L27:
        Pair<Integer, Integer> r17 = r10.h;
        if (r17 == null) goto L30;
        int r18 = ((Number) r17.getSecond()).intValue();
    L31:
        setPaddingRelative(getPaddingStart(), r16, getPaddingEnd(), r18);
        View r19 = getBinding().a;
        final Function0<Unit> r20 = r11.b;
        if (r20 == null) goto L34;
        View.OnClickListener r21 = new c(r20);
    L35:
        r19.setOnClickListener(r21);
        View r22 = getBinding().a;
        if (r11.b == null) goto L38;
        boolean r23 = true;
    L39:
        r22.setClickable(r23);
        View r24 = getBinding().a;
        if (r11.b == null) goto L42;
        r5 = true;
    L42:
        r24.setFocusable(r5);
        ExposeXTrackerExtKt.b(this, new d(r10, r11));
        return;
    L38:
        r23 = false;
        goto L39
    L34:
        r21 = null;
        goto L35
    L30:
        r18 = 0;
        goto L31
    L26:
        r16 = 0;
        goto L27
    L22:
        r14 = R.color.transparent;
        goto L23
    L18:
        r9 = 8;
        goto L19
    L14:
        r7.x();
        goto L15
    L10:
        r6 = 0;
    L6:
        r2 = getDefaultNameColors();
        goto L7
    }
}
