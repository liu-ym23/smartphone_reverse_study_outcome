package com.larus.bmhome.chat.standarduikit.computerusetool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.mainbot.impl.databinding.LarusLayoutComputerUseToolResultBlockViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultBlockInput;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultBlockOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusLayoutComputerUseToolResultBlockViewBinding;", "imageBindToken", "addCodeView", "", "codeView", "Landroid/view/View;", "bindData", "input", "output", "currentToolTitle", "", "refreshControlGroup", "isFold", "", "hasImage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComputerUseToolResultView extends ConstraintLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusLayoutComputerUseToolResultBlockViewBinding a;
    public int b;

    public ComputerUseToolResultView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComputerUseToolResultView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComputerUseToolResultView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LayoutInflater.from(r8).inflate(2131562786, this);
        int r11 = 2131367580;
        DeepThinkCommonToolHeader r2 = ViewBindings.findChildViewById(this, 2131367580);
        if (r2 == null) goto L15;
        r11 = 2131367625;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131367625);
        if (r3 == null) goto L15;
        r11 = 2131367626;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(this, 2131367626);
        if (r4 == null) goto L15;
        r11 = 2131367627;
        ShimmerMaskView r5 = ViewBindings.findChildViewById(this, 2131367627);
        if (r5 == null) goto L15;
        r11 = 2131367628;
        View r6 = ViewBindings.findChildViewById(this, 2131367628);
        if (r6 == null) goto L15;
        this.a = new LarusLayoutComputerUseToolResultBlockViewBinding(this, r2, r3, r4, r5, r6);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public /* synthetic */ ComputerUseToolResultView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
