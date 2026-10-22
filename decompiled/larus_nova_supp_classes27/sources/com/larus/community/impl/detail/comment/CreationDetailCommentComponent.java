package com.larus.community.impl.detail.comment;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0017J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/community/impl/detail/comment/CreationDetailCommentComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "<init>", "()V", "containerView", "Landroid/view/ViewGroup;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "commentCount", "", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "Lkotlin/Lazy;", "onAttach", "", "updateCommentCount", "count", "refreshCommentCountUI", "bindView", "initObserver", "creation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailCommentComponent extends Component implements a {
    public ViewGroup l;
    public long m;
    public final Lazy n;

    public final void L2() {
        ViewGroup r0 = this.l;
        if (r0 == null) goto L12;
        TextView r1 = (TextView) r0.findViewById(2131390374);
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.m > 0) goto L9;
        String r2 = r1.getResources().getString(2131900336);
    L10:
        r1.setText(r2);
        return;
    L9:
        StringBuilder r3 = new StringBuilder();
        r3.append(r1.getResources().getString(2131900336));
        r3.append(' ');
        int r4 = r5.a;
        r3.append(r5.a(r1.getContext(), this.m));
        r2 = r3.toString();
        goto L10
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public CreationDetailCommentComponent() {
        this.n = LazyKt.lazy(new b(this));
    }

    public final void F2(UserCreation r3) {
        ViewGroup r4 = this.l;
        if (r4 == null) goto L7;
        SimpleDraweeView r5 = r4.findViewById(2131367310);
        if (r5 == null) goto L7;
        ImageLoaderKt.u(r5, AccountService.a.s(), "creation_detail_user_avatar");
    L7:
        L2();
    }

    @Override // com.larus.community.impl.detail.comment.a
    public final void g4(long r1) {
        this.m = r1;
        L2();
    }

    @Override // com.larus.community.impl.detail.comment.a
    public final void s30(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "containerView");
        this.l = r8;
        SimpleDraweeView r0 = r8.findViewById(2131367310);
        if (r0 == null) goto L5;
        ImageLoaderKt.u(r0, AccountService.a.s(), "creation_detail_user_avatar");
    L5:
        e1.d(r8.findViewById(2131367371), new c(this));
        j29.c r9 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r9 == null) goto L8;
        UserCreation r10 = r9.a;
    L9:
        if (r10 == null) goto L11;
        F2(r10);
        return;
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailCommentComponent$initObserver$1(this, null), 3, null);
        return;
    L8:
        r10 = null;
        goto L9
    }
}
