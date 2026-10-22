package com.larus.bmhome.chat.standarduikit.browsercontrol.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.mainbot.impl.databinding.LarusLayoutBrowserControlBlockViewBinding;
import com.larus.utils.e1;
import fj8.b;
import fj8.d;
import fj8.e;
import fj8.f;
import fj8.g;
import fj8.h;
import fj8.i;
import fj8.j;
import fj8.k;
import fj8.l;
import fj8.m;
import fj8.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlBlockInput;", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlBlockOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusLayoutBrowserControlBlockViewBinding;", "toolHeader", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "getToolHeader", "()Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "toolHeader$delegate", "Lkotlin/Lazy;", "btnLeft", "Landroid/widget/FrameLayout;", "getBtnLeft", "()Landroid/widget/FrameLayout;", "btnLeft$delegate", "btnRight", "getBtnRight", "btnRight$delegate", "browserControlCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBrowserControlCover", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "browserControlCover$delegate", "browserControlCoverMask", "Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "getBrowserControlCoverMask", "()Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "browserControlCoverMask$delegate", "bindData", "", "input", "output", "currentToolTitle", "", "processButtonStatus", "buttonStatus", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/ButtonStatus;", "refreshControlGroup", "isFold", "", "hideControlGroup", "showControlGroup", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserControlView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final LarusLayoutBrowserControlBlockViewBinding a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ButtonStatus.values().length];
            r0[ButtonStatus.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ButtonStatus.ENABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ButtonStatus.HIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public BrowserControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BrowserControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final SimpleDraweeView getBrowserControlCover() {
        return (SimpleDraweeView) this.e.getValue();
    }

    private final ShimmerMaskView getBrowserControlCoverMask() {
        return (ShimmerMaskView) this.f.getValue();
    }

    private final FrameLayout getBtnLeft() {
        return (FrameLayout) this.c.getValue();
    }

    private final FrameLayout getBtnRight() {
        return (FrameLayout) this.d.getValue();
    }

    private final DeepThinkCommonToolHeader getToolHeader() {
        return (DeepThinkCommonToolHeader) this.b.getValue();
    }

    public static Unit R5(BrowserControlView r1) {
        ShimmerMaskView r0 = r1.getBrowserControlCoverMask();
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        ShimmerMaskView r2 = r1.getBrowserControlCoverMask();
        if (r2 == null) goto L9;
        r2.a();
    L9:
        return Unit.INSTANCE;
    }

    public static Unit S5(BrowserControlView r1) {
        ShimmerMaskView r0 = r1.getBrowserControlCoverMask();
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        ShimmerMaskView r2 = r1.getBrowserControlCoverMask();
        if (r2 == null) goto L9;
        r2.a();
    L9:
        return Unit.INSTANCE;
    }

    public static Unit T5(BrowserControlView r1) {
        ShimmerMaskView r0 = r1.getBrowserControlCoverMask();
        if (r0 == null) goto L5;
        e1.x(r0);
    L5:
        ShimmerMaskView r2 = r1.getBrowserControlCoverMask();
        if (r2 == null) goto L9;
        r2.c();
    L9:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(fj8.a r20, final b r21) {
        Intrinsics.checkNotNullParameter(r20, "input");
        Intrinsics.checkNotNullParameter(r21, "output");
        ToolType r5 = ToolType.BrowserControl;
        DeepThinkCommonToolHeader r3 = getToolHeader();
        if (r3 == null) goto L5;
        r3.b(r5, r20.b, r20.h, r20.g);
    L5:
        DeepThinkCommonToolHeader r4 = getToolHeader();
        if (r4 == null) goto L16;
        String r6 = r20.e;
        boolean r7 = r20.a;
        Boolean r8 = Boolean.valueOf(r20.b);
        Function0 r9 = null;
        if (r8.booleanValue() == false) goto L10;
        Boolean r10 = r8;
    L12:
        if (r20.c == true) goto L15;
        r9 = new j(r21);
    L15:
        r4.d(r5, r6, r7, r10, r9);
        goto L16
    L10:
        r10 = null;
    L16:
        DeepThinkCommonToolHeader r11 = getToolHeader();
        if (r11 == null) goto L19;
        r11.setBackgroundResource(R.color.transparent);
    L19:
        final String r12 = r20.f;
        SimpleDraweeView r13 = getBrowserControlCover();
        if (r13 != null) goto L22;
    L27:
        boolean r14 = true;
        ShimmerMaskView r15 = getBrowserControlCoverMask();
        if (r15 == null) goto L30;
        e1.x(r15);
    L30:
        ShimmerMaskView r16 = getBrowserControlCoverMask();
        if (r16 == null) goto L33;
        r16.c();
    L33:
        e1.d(getBtnRight(), new n(r21));
        if (r20.a == false) goto L53;
        LarusLayoutBrowserControlBlockViewBinding r17 = this.a;
        if (r17 == null) goto L40;
        SimpleDraweeView r18 = r17.b;
        if (r18 == null) goto L40;
        e1.o(r18);
    L40:
        LarusLayoutBrowserControlBlockViewBinding r19 = this.a;
        if (r19 == null) goto L45;
        View r22 = r19.d;
        if (r22 == null) goto L45;
        e1.o(r22);
    L45:
        LarusLayoutBrowserControlBlockViewBinding r23 = this.a;
        if (r23 == null) goto L50;
        ShimmerMaskView r24 = r23.c;
        if (r24 == null) goto L50;
        e1.o(r24);
    L50:
        ShimmerMaskView r25 = getBrowserControlCoverMask();
        if (r25 == null) goto L63;
        r25.a();
    L63:
        int r1 = a.a[r20.d.ordinal()];
        if (r1 != r14) goto L66;
        FrameLayout r2 = getBtnRight();
        if (r2 == null) goto L120;
        r2.setClickable(false);
    L120:
        FrameLayout r26 = getBtnLeft();
        if (r26 == null) goto L123;
        r26.setClickable(false);
    L123:
        int r27 = ContextCompat.getColor(getContext(), c.b(2130972081, getContext(), 2131103143));
        LarusLayoutBrowserControlBlockViewBinding r28 = this.a;
        if (r28 == null) goto L128;
        TextView r29 = r28.i;
        if (r29 == null) goto L128;
        r29.setTextColor(r27);
    L128:
        LarusLayoutBrowserControlBlockViewBinding r30 = this.a;
        if (r30 == null) goto L133;
        TextView r31 = r30.k;
        if (r31 == null) goto L133;
        r31.setTextColor(r27);
    L133:
        LarusLayoutBrowserControlBlockViewBinding r32 = this.a;
        if (r32 == null) goto L138;
        AppCompatImageView r33 = r32.h;
        if (r33 == null) goto L138;
        r33.setColorFilter(r27);
    L138:
        LarusLayoutBrowserControlBlockViewBinding r34 = this.a;
        if (r34 == null) goto L143;
        AppCompatImageView r35 = r34.j;
        if (r35 == null) goto L143;
        r35.setColorFilter(r27);
    L143:
        e1.d(getBtnLeft(), new d(this));
        e1.d(getBrowserControlCover(), new e(r21, r12));
        return;
    L66:
        if (r1 != 2) goto L68;
        FrameLayout r36 = getBtnRight();
        if (r36 == null) goto L84;
        r36.setClickable(r14);
    L84:
        FrameLayout r37 = getBtnLeft();
        if (r37 == null) goto L87;
        r37.setClickable(r14);
    L87:
        LarusLayoutBrowserControlBlockViewBinding r38 = this.a;
        if (r38 == null) goto L92;
        FrameLayout r39 = r38.f;
        if (r39 == null) goto L92;
        e1.x(r39);
    L92:
        LarusLayoutBrowserControlBlockViewBinding r40 = this.a;
        if (r40 == null) goto L97;
        FrameLayout r41 = r40.e;
        if (r41 == null) goto L97;
        e1.x(r41);
    L97:
        int r42 = ContextCompat.getColor(getContext(), c.b(2130972079, getContext(), 2131103136));
        LarusLayoutBrowserControlBlockViewBinding r43 = this.a;
        if (r43 == null) goto L102;
        TextView r44 = r43.i;
        if (r44 == null) goto L102;
        r44.setTextColor(r42);
    L102:
        LarusLayoutBrowserControlBlockViewBinding r45 = this.a;
        if (r45 == null) goto L107;
        TextView r46 = r45.k;
        if (r46 == null) goto L107;
        r46.setTextColor(r42);
    L107:
        LarusLayoutBrowserControlBlockViewBinding r47 = this.a;
        if (r47 == null) goto L112;
        AppCompatImageView r48 = r47.h;
        if (r48 == null) goto L112;
        r48.setColorFilter(r42);
    L112:
        LarusLayoutBrowserControlBlockViewBinding r49 = this.a;
        if (r49 == null) goto L143;
        AppCompatImageView r50 = r49.j;
        if (r50 == null) goto L143;
        r50.setColorFilter(r42);
        goto L143
    L68:
        if (r1 != 3) goto L80;
        LarusLayoutBrowserControlBlockViewBinding r51 = this.a;
        if (r51 == null) goto L74;
        FrameLayout r52 = r51.f;
        if (r52 == null) goto L74;
        e1.o(r52);
    L74:
        LarusLayoutBrowserControlBlockViewBinding r53 = this.a;
        if (r53 == null) goto L143;
        FrameLayout r54 = r53.e;
        if (r54 == null) goto L143;
        e1.o(r54);
        goto L143
    L80:
        throw new NoWhenBranchMatchedException();
    L53:
        LarusLayoutBrowserControlBlockViewBinding r55 = this.a;
        if (r55 == null) goto L58;
        SimpleDraweeView r56 = r55.b;
        if (r56 == null) goto L58;
        e1.x(r56);
    L58:
        LarusLayoutBrowserControlBlockViewBinding r57 = this.a;
        if (r57 == null) goto L63;
        View r58 = r57.d;
        if (r58 == null) goto L63;
        e1.x(r58);
        goto L63
    L22:
        if (r12.length() <= 0) goto L24;
        boolean r59 = true;
    L25:
        if (r59 == false) goto L27;
        r14 = true;
        IMessageImageLoaderService.a.b(MessageImageLoader.a, null, MessageImageType.IMAGE, r13, r12, "BrowserControlCover", null, null, new k(this), new l(this), new m(this), false, 1120);
        goto L33
    L24:
        r59 = false;
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BrowserControlView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        this.b = LazyKt.lazy(new fj8.c(this));
        this.c = LazyKt.lazy(new f(this));
        this.d = LazyKt.lazy(new g(this));
        this.e = LazyKt.lazy(new h(this));
        this.f = LazyKt.lazy(new i(this));
        LayoutInflater.from(r13).inflate(2131562762, this);
        int r16 = 2131364582;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131364582);
        if (r2 == null) goto L25;
        r16 = 2131364583;
        ShimmerMaskView r3 = ViewBindings.findChildViewById(this, 2131364583);
        if (r3 == null) goto L25;
        r16 = 2131364584;
        View r4 = ViewBindings.findChildViewById(this, 2131364584);
        if (r4 == null) goto L25;
        r16 = 2131364749;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(this, 2131364749);
        if (r5 == null) goto L25;
        r16 = 2131364818;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(this, 2131364818);
        if (r6 == null) goto L25;
        r16 = 2131367580;
        DeepThinkCommonToolHeader r7 = ViewBindings.findChildViewById(this, 2131367580);
        if (r7 == null) goto L25;
        r16 = 2131377739;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131377739);
        if (r8 == null) goto L25;
        r16 = 2131377741;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131377741);
        if (r9 == null) goto L25;
        r16 = 2131384560;
        AppCompatImageView r10 = ViewBindings.findChildViewById(this, 2131384560);
        if (r10 == null) goto L25;
        r16 = 2131384562;
        TextView r11 = (TextView) ViewBindings.findChildViewById(this, 2131384562);
        if (r11 == null) goto L25;
        this.a = new LarusLayoutBrowserControlBlockViewBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r16)));
    }

    public /* synthetic */ BrowserControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
