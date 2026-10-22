package com.larus.bmhome.view;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusLayoutLeftAvatarBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class NovaTitleBarEx$avatarAreaViewStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutLeftAvatarBinding> {
    public static final NovaTitleBarEx$avatarAreaViewStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new NovaTitleBarEx$avatarAreaViewStub$2$1();
    }

    public NovaTitleBarEx$avatarAreaViewStub$2$1() {
        super(1, LarusLayoutLeftAvatarBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/common_res/common_ui/databinding/LarusLayoutLeftAvatarBinding;", 0);
    }

    public final LarusLayoutLeftAvatarBinding invoke(View r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        int r0 = 2131363623;
        TitleAvatarImageView r1 = ViewBindings.findChildViewById(r5, 2131363623);
        if (r1 == null) goto L11;
        r0 = 2131387625;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r5, 2131387625);
        if (r2 == null) goto L11;
        r0 = 2131388772;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r5, 2131388772);
        if (r3 == null) goto L11;
        return new LarusLayoutLeftAvatarBinding((ConstraintLayout) r5, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
