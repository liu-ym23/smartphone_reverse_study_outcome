package com.larus.community.impl.publish;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishOpsLayoutBinding;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishOpsComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "fragmentViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getFragmentViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "fragmentViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishOpsLayoutBinding;", "onViewCreated", "", "view", "Landroid/view/View;", "initView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishOpsComponent extends BaseContentWidget {
    public static final /* synthetic */ int o = 0;
    public final Lazy m;
    public LarusCommunityCreationPublishOpsLayoutBinding n;

    public CreationPublishOpsComponent() {
        this.m = LazyKt.lazy(new l(this));
    }

    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        View r10 = F2();
        if ((r10 instanceof ViewGroup) == false) goto L5;
        ViewGroup r11 = (ViewGroup) r10;
    L6:
        if (r11 == null) goto L16;
        LayoutInflater.from(getContext()).inflate(2131561966, r11);
        int r0 = 2131365061;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131365061);
        if (r2 == null) goto L15;
        r0 = 2131383428;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131383428);
        if (r3 == null) goto L15;
        r0 = 2131383431;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131383431);
        if (r4 == null) goto L15;
        this.n = new LarusCommunityCreationPublishOpsLayoutBinding(r11, r2, r3, r4);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    L16:
        int r12 = w0.a;
        Resources r13 = getContext().getResources();
        if (r13 == null) goto L19;
        Integer r14 = Integer.valueOf(r13.getColor(2131103203));
    L20:
        F2().setBackground(w0.b(r14, Float.valueOf(i5.q()), 0.0f, Integer.valueOf(ContextCompat.getColor(getContext(), 2131103159)), 4));
        e1.d(F2(), new k(this));
        boolean r15 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L27;
        LarusCommunityCreationPublishOpsLayoutBinding r16 = this.n;
        if (r16 == null) goto L32;
        ProgressBar r17 = r16.d;
        if (r17 == null) goto L32;
        r17.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), 2131241078));
    L32:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishOpsComponent$initView$2(this, null), 3, null);
        return;
    L27:
        LarusCommunityCreationPublishOpsLayoutBinding r18 = this.n;
        if (r18 == null) goto L32;
        ProgressBar r20 = r18.d;
        if (r20 == null) goto L32;
        r20.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), 2131240146));
        goto L32
    L19:
        r14 = null;
        goto L20
    L5:
        r11 = null;
        goto L6
    }
}
