package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.chat.common.databinding.LarusLayoutTextMessageMultiActionButtonBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import rs8.o;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/view/TextAnswerMultiActionButton;", "Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageMultiActionButtonBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageMultiActionButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "config", "", "action", "Lcom/larus/bmhome/view/actionbar/IAction;", "useSubscribedColor", "", "compact", "getRoot", "Landroid/view/ViewGroup;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextAnswerMultiActionButton extends BaseTextAnswerActionButton {
    public static final /* synthetic */ int d = 0;
    public final Lazy b;
    public final Lazy c;

    public TextAnswerMultiActionButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TextAnswerMultiActionButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public ViewGroup getRoot() {
        return this;
    }

    private final LarusLayoutTextMessageMultiActionButtonBinding getBinding() {
        return (LarusLayoutTextMessageMultiActionButtonBinding) this.b.getValue();
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) this.c.getValue();
    }

    public TextAnswerMultiActionButton(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new i4(r2, this));
        this.c = LazyKt.lazy(new j4());
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public final void a(final rs8.g r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "action");
        super.a(r6, r7, r8);
        if ((r6 instanceof o) == true) goto L5;
        return;
    L5:
        final LarusLayoutTextMessageMultiActionButtonBinding r0 = getBinding();
        if (r8 == false) goto L8;
        int r1 = i5.T();
    L9:
        if (r8 == false) goto L11;
        int r9 = i5.j0();
    L12:
        AppCompatImageView r2 = r0.d;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.width = r1;
        r3.height = r1;
        r2.setLayoutParams(r3);
        r0.d.setPadding(r9, r9, r9, r9);
        com.larus.utils.e1.x(r0.b);
        o r10 = (o) r6;
        com.larus.utils.e1.x(r0.g);
        com.larus.utils.e1.o(r0.f);
        r0.g.setText(null);
        Integer r11 = c(r7);
        if (r11 == null) goto L15;
        int r12 = r11.intValue();
        r0.g.setTextColor(r12);
    L15:
        if (r7 == false) goto L17;
        r0.c.setBackgroundColor(ContextCompat.getColor(getContext(), v19.c.b(2130968762, null, 2131100143)));
    L17:
        ColorFilter r13 = b(r7);
        if (r13 == null) goto L20;
        r0.d.setColorFilter(r13);
    L20:
        com.larus.utils.e1.d(r0.g, new k4(r6));
        com.larus.utils.e1.d(r0.e, new l4(r6, r0, this));
        return;
    L11:
        r9 = i5.n0();
        goto L12
    L8:
        r1 = i5.W();
        goto L9
    }

    public /* synthetic */ TextAnswerMultiActionButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
