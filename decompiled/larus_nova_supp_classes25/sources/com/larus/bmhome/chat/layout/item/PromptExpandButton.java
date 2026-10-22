package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.suggest.impl.databinding.LarusWidgetPromptExpandButtonBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0015\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/PromptExpandButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/suggest/impl/databinding/LarusWidgetPromptExpandButtonBinding;", "init", "", "setImmersedBgColor", "immerseBgColor", "(Ljava/lang/Integer;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PromptExpandButton extends LinearLayout {
    public LarusWidgetPromptExpandButtonBinding a;

    public PromptExpandButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a(r2);
    }

    public final void a(Context r4) {
        LayoutInflater.from(r4).inflate(2131563265, this);
        int r5 = 2131383378;
        AppCompatTextView r0 = ViewBindings.findChildViewById(this, 2131383378);
        if (r0 == null) goto L9;
        r5 = 2131383385;
        AppCompatImageView r1 = ViewBindings.findChildViewById(this, 2131383385);
        if (r1 == null) goto L9;
        this.a = new LarusWidgetPromptExpandButtonBinding(this, r0, r1);
        setOrientation(0);
        setGravity(16);
        setPadding(i5.h(), i5.v0(), i5.h(), i5.v0());
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public final void setImmersedBgColor(Integer r7) {
        LarusWidgetPromptExpandButtonBinding r0 = null;
        if (r7 == null) goto L17;
        setBackground(ContextCompat.getDrawable(getContext(), 2131239438));
        LarusWidgetPromptExpandButtonBinding r8 = this.a;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L7:
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L10;
        r9.setColorFilter(ContextCompat.getColor(getContext(), 2131103298));
    L10:
        LarusWidgetPromptExpandButtonBinding r10 = this.a;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        AppCompatTextView r11 = r0.b;
        if (r11 == null) goto L31;
        r11.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L31:
        return;
    L13:
        r0 = r10;
        goto L14
    L17:
        setBackground(ContextCompat.getDrawable(getContext(), v19.c.b(2130970758, getContext(), 2131239436)));
        LarusWidgetPromptExpandButtonBinding r12 = this.a;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L20:
        AppCompatImageView r13 = r12.c;
        if (r13 == null) goto L23;
        r13.setColorFilter(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    L23:
        LarusWidgetPromptExpandButtonBinding r14 = this.a;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L27:
        AppCompatTextView r15 = r0.b;
        if (r15 == null) goto L33;
        r15.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        return;
    L33:
        return;
    L26:
        r0 = r14;
        goto L27
    }

    public PromptExpandButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a(r2);
    }

    public PromptExpandButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a(r2);
    }
}
