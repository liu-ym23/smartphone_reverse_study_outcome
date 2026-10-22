package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.common.databinding.LarusLayoutMessageRiskWarningTextBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/MessageRiskWarningTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutMessageRiskWarningTextBinding;", "bottomPadding", "reset", "", "setUrlVisible", "isVisible", "", "setTextVisible", "setWarningUrl", "textOfUrl", "", ShareType.URL, "setWarningText", ShareType.TEXT, "checkPadding", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageRiskWarningTextView extends ConstraintLayout {
    public final LarusLayoutMessageRiskWarningTextBinding a;
    public final int b;

    public MessageRiskWarningTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessageRiskWarningTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setTextVisible(boolean r2) {
        LarusLayoutMessageRiskWarningTextBinding r0 = this.a;
        if (r0 == null) goto L11;
        TextView r1 = r0.b;
        if (r1 == null) goto L12;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    L12:
        return;
    }

    public final void setUrlVisible(boolean r2) {
        LarusLayoutMessageRiskWarningTextBinding r0 = this.a;
        if (r0 == null) goto L11;
        TextView r1 = r0.c;
        if (r1 == null) goto L12;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    L12:
        return;
    }

    public final void setWarningText(String r2) {
        if (r2 == null) goto L9;
        LarusLayoutMessageRiskWarningTextBinding r0 = this.a;
        if (r0 == null) goto L10;
        TextView r1 = r0.b;
        if (r1 == null) goto L11;
        r1.setText(r2);
        return;
    L11:
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageRiskWarningTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.b = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        LayoutInflater.from(r3).inflate(2131562853, this);
        int r6 = 2131384660;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131384660);
        if (r7 == null) goto L9;
        r6 = 2131384661;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131384661);
        if (r8 == null) goto L9;
        this.a = new LarusLayoutMessageRiskWarningTextBinding(this, r7, r8);
        setVisibility(8);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }

    public /* synthetic */ MessageRiskWarningTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
