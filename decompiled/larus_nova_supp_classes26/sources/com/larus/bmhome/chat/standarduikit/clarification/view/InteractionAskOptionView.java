package com.larus.bmhome.chat.standarduikit.clarification.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.mainbot.impl.databinding.LarusInteractionAskOptionViewBinding;
import ij8.j;
import ij8.k;
import ij8.l;
import ij8.m;
import ij8.n;
import ij8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010&\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eJ\b\u0010-\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010.\u001a\u00020'2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'00J\b\u00101\u001a\u00020'H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u0019R\u001b\u0010#\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0019¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/clarification/view/InteractionAskOptionView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "optionCache", "Lcom/larus/im/bean/message/block/InteractionAskOption;", "markIndex", "selectedState", "", "showSelectedMarkState", "binding", "Lcom/larus/mainbot/impl/databinding/LarusInteractionAskOptionViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusInteractionAskOptionViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "markIndexView", "Landroid/widget/TextView;", "getMarkIndexView", "()Landroid/widget/TextView;", "markIndexView$delegate", "markCheckedView", "Landroidx/appcompat/widget/AppCompatImageView;", "getMarkCheckedView", "()Landroidx/appcompat/widget/AppCompatImageView;", "markCheckedView$delegate", "titleView", "getTitleView", "titleView$delegate", "descriptionView", "getDescriptionView", "descriptionView$delegate", "bind", "", "option", "index", "setSelectedState", "selected", "showSelectedMark", "boundOption", "setOnOptionClickListener", "listener", "Lkotlin/Function1;", "renderMark", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionAskOptionView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public InteractionAskOption a;
    public int b;
    public boolean c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public InteractionAskOptionView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InteractionAskOptionView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusInteractionAskOptionViewBinding getBinding() {
        return (LarusInteractionAskOptionViewBinding) this.e.getValue();
    }

    private final TextView getDescriptionView() {
        return (TextView) this.i.getValue();
    }

    private final AppCompatImageView getMarkCheckedView() {
        return (AppCompatImageView) this.g.getValue();
    }

    private final TextView getMarkIndexView() {
        return (TextView) this.f.getValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.h.getValue();
    }

    public final void f() {
        if (this.c == true) goto L5;
    L7:
        getMarkCheckedView().setVisibility(8);
        getMarkIndexView().setVisibility(0);
        getMarkIndexView().setText(String.valueOf(this.b + 1));
        return;
    L5:
        if (this.d == false) goto L7;
        getMarkCheckedView().setVisibility(0);
        getMarkIndexView().setVisibility(8);
    }

    public static TextView a(InteractionAskOptionView r0) {
        return r0.getBinding().d;
    }

    public static AppCompatImageView b(InteractionAskOptionView r0) {
        return r0.getBinding().c;
    }

    public static TextView c(InteractionAskOptionView r0) {
        return r0.getBinding().e;
    }

    public static TextView d(InteractionAskOptionView r0) {
        return r0.getBinding().b;
    }

    public final void setOnOptionClickListener(final Function1<? super InteractionAskOption, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        setOnClickListener(new j(this, r2));
    }

    public final void e(int r3, InteractionAskOption r4) {
        Intrinsics.checkNotNullParameter(r4, "option");
        this.b = r3;
        this.a = r4;
        TextView r5 = getTitleView();
        String r0 = r4.getLabel();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r5.setText(r0);
        String r6 = r4.getDescription();
        if (r6 == null) goto L10;
        r1 = r6;
    L10:
        if (StringsKt.isBlank(r1) == false) goto L12;
        getDescriptionView().setVisibility(8);
    L13:
        f();
        return;
    L12:
        getDescriptionView().setVisibility(0);
        getDescriptionView().setText(r1);
        goto L13
    }

    public InteractionAskOptionView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = LazyKt.lazy(new k(r2, this));
        this.f = LazyKt.lazy(new l(this));
        this.g = LazyKt.lazy(new m(this));
        this.h = LazyKt.lazy(new n(this));
        this.i = LazyKt.lazy(new o(this));
    }

    public /* synthetic */ InteractionAskOptionView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
