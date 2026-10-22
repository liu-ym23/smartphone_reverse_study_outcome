package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class EntityResourceViewHolder$inspectFailedStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusFileResourceInspectFailedLayoutBinding> {
    public static final EntityResourceViewHolder$inspectFailedStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new EntityResourceViewHolder$inspectFailedStub$2$1();
    }

    public EntityResourceViewHolder$inspectFailedStub$2$1() {
        super(1, LarusFileResourceInspectFailedLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusFileResourceInspectFailedLayoutBinding;", 0);
    }

    public final LarusFileResourceInspectFailedLayoutBinding invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        FrameLayout r0 = (FrameLayout) r4;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r4, 2131372434);
        if (r2 == null) goto L7;
        return new LarusFileResourceInspectFailedLayoutBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131372434)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
