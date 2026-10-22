package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class EntityResourceViewHolder$parseFailedStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusFileResourceParseFailedLayoutBinding> {
    public static final EntityResourceViewHolder$parseFailedStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new EntityResourceViewHolder$parseFailedStub$2$1();
    }

    public EntityResourceViewHolder$parseFailedStub$2$1() {
        super(1, LarusFileResourceParseFailedLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusFileResourceParseFailedLayoutBinding;", 0);
    }

    public final LarusFileResourceParseFailedLayoutBinding invoke(View r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        LinearLayout r0 = (LinearLayout) r5;
        int r1 = 2131372436;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r5, 2131372436);
        if (r2 == null) goto L9;
        r1 = 2131372438;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r5, 2131372438);
        if (r3 == null) goto L9;
        return new LarusFileResourceParseFailedLayoutBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r1)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
