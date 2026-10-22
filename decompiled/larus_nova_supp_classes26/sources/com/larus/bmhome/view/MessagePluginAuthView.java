package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusViewMessagePluginAuthBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ3\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u001eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/MessagePluginAuthView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/auth/IAuthorizationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusViewMessagePluginAuthBinding;", "showAuthButton", "", "vertical", "", "immersiveColor", "clickListener", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/auth/model/PluginAuthType;", "(ZLjava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "hideAuthButton", "updateButtonGroup", "setSelectedListener", "getAuthAlwaysButton", "Landroid/widget/TextView;", "getAuthOnceButton", "getAuthDenyButton", "setButtonStyle", "(ZLjava/lang/Integer;)V", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessagePluginAuthView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusViewMessagePluginAuthBinding a;

    public MessagePluginAuthView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessagePluginAuthView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagePluginAuthView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        LayoutInflater.from(r12).inflate(2131563213, this);
        int r15 = 2131363541;
        RoundTextView r2 = ViewBindings.findChildViewById(this, 2131363541);
        if (r2 == null) goto L23;
        r15 = 2131363542;
        RoundTextView r3 = ViewBindings.findChildViewById(this, 2131363542);
        if (r3 == null) goto L23;
        r15 = 2131363547;
        ConstraintLayout r4 = ViewBindings.findChildViewById(this, 2131363547);
        if (r4 == null) goto L23;
        r15 = 2131363548;
        ConstraintLayout r5 = ViewBindings.findChildViewById(this, 2131363548);
        if (r5 == null) goto L23;
        r15 = 2131363551;
        RoundTextView r6 = ViewBindings.findChildViewById(this, 2131363551);
        if (r6 == null) goto L23;
        r15 = 2131363552;
        RoundTextView r7 = ViewBindings.findChildViewById(this, 2131363552);
        if (r7 == null) goto L23;
        r15 = 2131363561;
        RoundTextView r8 = ViewBindings.findChildViewById(this, 2131363561);
        if (r8 == null) goto L23;
        r15 = 2131363562;
        RoundTextView r9 = ViewBindings.findChildViewById(this, 2131363562);
        if (r9 == null) goto L23;
        r15 = 2131369197;
        View r10 = ViewBindings.findChildViewById(this, 2131369197);
        if (r10 == null) goto L23;
        this.a = new LarusViewMessagePluginAuthBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r15)));
    }

    public /* synthetic */ MessagePluginAuthView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
