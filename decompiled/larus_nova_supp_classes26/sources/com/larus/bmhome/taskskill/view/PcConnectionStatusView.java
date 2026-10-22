package com.larus.bmhome.taskskill.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001cH\u0002J\u0014\u0010!\u001a\u00020\u0010*\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0002R7\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/taskskill/view/PcConnectionStatusView;", "Lcom/larus/bmhome/taskskill/view/ShimmerTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onActionClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/view/PcConnectionStatusAction;", "Lkotlin/ParameterName;", "name", "action", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "setOnActionClick", "(Lkotlin/jvm/functions/Function1;)V", "iconSpan", "Lcom/larus/bmhome/taskskill/view/InlineIconSpan;", "currentAction", "render", "uiModel", "Lcom/larus/bmhome/taskskill/view/PcConnectionStatusUiModel;", "buildContent", "", "createIconSpan", "createActionSpan", "Landroid/text/style/ClickableSpan;", "capDeviceName", "appendSpacer", "Landroid/text/SpannableStringBuilder;", "widthPx", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcConnectionStatusView extends ShimmerTextView {
    public Function1<? super PcConnectionStatusAction, Unit> o;
    public com.larus.bmhome.taskskill.view.a p;
    public PcConnectionStatusAction q;

    public static final class a {
    }

    static {
    }

    public PcConnectionStatusView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PcConnectionStatusView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function1<PcConnectionStatusAction, Unit> getOnActionClick() {
        return this.o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(p r10) {
        Intrinsics.checkNotNullParameter(r10, "uiModel");
        boolean r1 = false;
        if (r10.f == false) goto L5;
        int r0 = 0;
    L6:
        setVisibility(r0);
        this.q = r10.d;
        CharSequence r2 = null;
        if (r10.f == true) goto L11;
        setText(null);
        this.p = null;
        B();
        return;
    L11:
        if (r10.g == false) goto L13;
        CharSequence r3 = r10.b;
    L58:
        setText(r3);
        if (r10.e == false) goto L61;
        A();
        return;
    L61:
        B();
        return;
    L13:
        CharSequence r4 = r10.a;
        if (r4.length() != 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L20;
    L23:
        SpannableStringBuilder r6 = new SpannableStringBuilder();
        Drawable r7 = AppCompatResources.getDrawable(getContext(), 2131241518);
        if (r7 == null) goto L28;
        Drawable r8 = r7.mutate();
        if (r8 == null) goto L28;
        com.larus.bmhome.taskskill.view.a r9 = new com.larus.bmhome.taskskill.view.a(r8, i5.m());
    L30:
        if (r9 == null) goto L32;
        this.p = r9;
        int r11 = r6.length();
        r6.append("\u200b");
        r6.setSpan(r9, r11, r6.length(), 17);
        boolean r12 = true;
    L34:
        if (r4.length() <= 0) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == false) goto L41;
        if (r12 == false) goto L40;
        C(r6, i5.Y());
    L40:
        r6.append(r4);
        r12 = true;
    L41:
        if (r12 == false) goto L43;
        C(r6, i5.Y());
    L43:
        r6.append(r10.b);
        CharSequence r14 = r10.c;
        if (r14 != null) goto L46;
    L57:
        r3 = new SpannedString(r6);
        goto L58
    L46:
        if (r14.length() <= 0) goto L48;
        boolean r15 = true;
    L49:
        if (r15 == true) goto L51;
    L53:
        if (r1 == false) goto L55;
        r2 = r14;
    L55:
        if (r2 == null) goto L57;
        C(r6, i5.Y());
        r r16 = new r(this);
        int r17 = r6.length();
        r6.append(r2);
        r6.setSpan(r16, r17, r6.length(), 17);
        goto L57
    L51:
        if (r10.d == null) goto L53;
        r1 = true;
        goto L53
    L48:
        r15 = false;
        goto L49
    L36:
        r13 = false;
        goto L37
    L32:
        this.p = null;
        r12 = false;
    L28:
        r9 = null;
        goto L30
    L20:
        if (Character.codePointCount(r4, 0, r4.length()) <= 12) goto L23;
        int r18 = Character.offsetByCodePoints(r4, 0, 12);
        SpannableStringBuilder r19 = new SpannableStringBuilder();
        r19.append(r4.subSequence(0, r18));
        r19.append("…");
        r4 = new SpannedString(r19);
        goto L23
    L16:
        r5 = false;
        goto L17
    L5:
        r0 = 8;
        goto L6
    }

    public final void setOnActionClick(Function1<? super PcConnectionStatusAction, Unit> r1) {
        this.o = r1;
    }

    public static void C(SpannableStringBuilder r3, int r4) {
        x r0 = new x(r4);
        int r5 = r3.length();
        r3.append("\u200b");
        r3.setSpan(r0, r5, r3.length(), 17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PcConnectionStatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setMovementMethod(LinkMovementMethod.getInstance());
        setIconShimmerProgressListener(new q(this));
    }

    public /* synthetic */ PcConnectionStatusView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
