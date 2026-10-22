package com.larus.bmhome.chat.markdown.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusDeepThinkCommonToolHeaderBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import po8.z;
import sh8.b;
import v19.c;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J*\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0013JE\u0010!\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010'¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\b\u0010*\u001a\u0004\u0018\u00010\u0013J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0006\u00102\u001a\u00020\u0010J\u0010\u00103\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "swipeTextViewList", "", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepThinkCommonToolHeaderBinding;", "switcherAdapter", "Lcom/larus/bmhome/chat/view/SearchSwitcherAdapter;", "refreshSearchViewSearchIng", "", "switcherList", "", "", "refreshSearchViewSearchEnd", "startSwipeLight", "stopSwipeLight", "updateSwitcherVisible", "visible", "", "setUpTextSwitcher", "refreshIcon", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "hideArrow", "lightIcon", "darkIcon", "updateSearchTitleWhenSearched", "isUserFold", "searchedTitle", "isFold", "forceHideArrow", "onClick", "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/markdown/reference/ToolType;ZLjava/lang/String;ZLjava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "refreshArrow", "currentTitle", "setArrow", "setSearchTitle", "title", "setArrowRotation", "resolveTextColor", "", "tryInitSwitchAdapter", "onRecycle", "takeNonEmpty", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkCommonToolHeader extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final List<ShimmerTextView> a;
    public final LarusDeepThinkCommonToolHeaderBinding b;
    public z c;

    public static final class a {
    }

    static {
    }

    public DeepThinkCommonToolHeader(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setArrow(boolean r1) {
        setArrowRotation(r1);
    }

    private final void setArrowRotation(boolean r2) {
        View r0 = this.b.b;
        if (r2 == false) goto L5;
        int r3 = 2131242202;
    L6:
        r0.setBackgroundResource(r3);
        return;
    L5:
        r3 = 2131242201;
        goto L6
    }

    private final void setSearchTitle(String r8) {
        TextView r0 = this.b.e;
        r0.setTextColor(c.a(2130972082, getContext(), 2131103146));
        Intrinsics.checkNotNull(r0);
        we8.a.b(r0, i5.t(), false, null, null, 12);
        r0.setSingleLine(true);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setGravity(16);
        r0.setIncludeFontPadding(false);
        r0.setText(r8);
        r0.setTypeface(Typeface.DEFAULT, 0);
    }

    private final void setUpTextSwitcher(final Context r3) {
        this.b.d.setFactory(new sh8.a(r3, this));
    }

    public final void c(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "switcherList");
        this.b.f.setOnClickListener(null);
        this.b.f.setClickable(false);
        if (this.c != null) goto L8;
        setUpTextSwitcher(getContext());
        z r0 = new z(this.b.d, r4);
        this.c = r0;
        r0.a(getContext());
        z r5 = this.c;
        if (r5 == null) goto L7;
        r5.c();
    L7:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L17;
        Iterator r7 = ((ArrayList) this.a).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ShimmerTextView r1 = (ShimmerTextView) r7.next();
        int r2 = ShimmerTextView.h;
        r1.z(false);
        goto L12
    L14:
        this.b.d.setVisibility(0);
        return;
    L17:
        return;
    L8:
        r6 = false;
        goto L9
    }

    public DeepThinkCommonToolHeader(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.a = new ArrayList();
        LayoutInflater.from(r8).inflate(2131562024, this);
        int r10 = 2131363236;
        View r2 = ViewBindings.findChildViewById(this, 2131363236);
        if (r2 == null) goto L15;
        r10 = 2131385294;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(this, 2131385294);
        if (r3 == null) goto L15;
        r10 = 2131385562;
        TextSwitcher r4 = (TextSwitcher) ViewBindings.findChildViewById(this, 2131385562);
        if (r4 == null) goto L15;
        r10 = 2131385563;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131385563);
        if (r5 == null) goto L15;
        r10 = 2131385299;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(this, 2131385299);
        if (r6 == null) goto L15;
        this.b = new LarusDeepThinkCommonToolHeaderBinding(this, r2, r3, r4, r5, r6);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public final void a(ToolType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "toolType");
        View r0 = this.b.b;
        if (r.d(r2) == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        setArrow(r3);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final void b(ToolType r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "toolType");
        if (r.d(r2) == true) goto L5;
        e1.o(this.b.b);
    L8:
        boolean r6 = h.a;
        if (h.a(null) == false) goto L12;
        r4 = r5;
    L12:
        if (o0.d(r4) == false) goto L14;
        this.b.c.setBackgroundResource(0);
        ImageLoaderKt.u(this.b.c, r4, "DeepThinkCommonToolHeader");
        return;
    L14:
        SimpleDraweeView r7 = this.b.c;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(i5.E(), i5.E());
        r8.gravity = 16;
        r8.setMargins(0, 0, i5.Y(), 0);
        r7.setLayoutParams(r8);
        SimpleDraweeView r9 = this.b.c;
        if (r9 == null) goto L19;
        r9.setBackgroundResource(c.b(2130971835, r9.getContext(), 2131241990));
        return;
    L19:
        return;
    L5:
        if (r3 == false) goto L7;
        e1.o(this.b.b);
        goto L8
    L7:
        e1.x(this.b.b);
        goto L8
    }

    public final void d(final ToolType r4, String r5, final boolean r6, Boolean r7, final Function0 r8) {
        Intrinsics.checkNotNullParameter(r4, "toolType");
        Intrinsics.checkNotNullParameter(r5, "searchedTitle");
        z r0 = this.c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        Iterator r1 = ((ArrayList) this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((ShimmerTextView) r1.next()).x();
        goto L7
    L9:
        int r2 = 8;
        this.b.d.setVisibility(8);
        View r3 = this.b.b;
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L12;
        boolean r9 = false;
    L13:
        if (r9 == false) goto L15;
        r2 = 0;
    L15:
        r3.setVisibility(r2);
        setSearchTitle(r5);
        setArrow(r6);
        this.b.f.setOnClickListener(null);
        this.b.f.setClickable(false);
        if (r8 == null) goto L20;
        e1.d(this.b.f, new b(r6, r4, r8));
        return;
    L20:
        return;
    L12:
        r9 = r.d(r4);
        goto L13
    }
}
