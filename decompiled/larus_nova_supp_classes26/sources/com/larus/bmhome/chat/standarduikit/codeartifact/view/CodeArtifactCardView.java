package com.larus.bmhome.chat.standarduikit.codeartifact.view;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.mainbot.impl.databinding.LarusCodeArtifactBlockItemFileBinding;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mj8.a;
import mj8.b;
import mj8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/codeartifact/view/CodeArtifactCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/codeartifact/view/CodeArtifactCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/codeartifact/view/CodeArtifactCardViewOutput;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCodeArtifactBlockItemFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCodeArtifactBlockItemFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeArtifactCardView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    private final LarusCodeArtifactBlockItemFileBinding getBinding() {
        return (LarusCodeArtifactBlockItemFileBinding) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CodeArtifactCardView(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(new a(r2, this));
        setBackgroundResource(2131239091);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(c r2, final nj8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "output");
        Integer r0 = r2.b;
        if (r0 == null) goto L5;
        setBackgroundResource(r0.intValue());
    L5:
        getBinding().c.setText(r2.a);
        e1.d(getBinding().a, new b(r3));
    }
}
