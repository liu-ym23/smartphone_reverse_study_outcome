package com.larus.community.impl.detail.header;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.image.d;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.prompt.a;
import com.larus.community.impl.detail.video.CreationDetailVideoView;
import com.larus.platform.model.comment.api.AbsCustomCommentHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/detail/header/CreationDetailCommentViewHolder;", "Lcom/larus/platform/model/comment/api/AbsCustomCommentHolder;", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailPromptAbility", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "creationDetailFullImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "creationDetailCommentAbility", "Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;Landroid/view/View;)V", "onBindViewHolder", "", "position", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailCommentViewHolder extends AbsCustomCommentHolder {
    public final d a;
    public final a b;
    public final com.larus.community.impl.detail.image.a c;
    public final com.larus.community.impl.detail.video.a d;
    public final com.larus.community.impl.detail.comment.a e;

    public final void T3() {
        a r0 = this.b;
        if (r0 == null) goto L5;
        r0.ut((CreationDetailPromptView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368238));
    L5:
        d r1 = this.a;
        if (r1 == null) goto L8;
        r1.P9((CreationDetailImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368236));
    L8:
        com.larus.community.impl.detail.image.a r2 = this.c;
        if (r2 == null) goto L11;
        r2.P9((CreationDetailImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368236));
    L11:
        com.larus.community.impl.detail.video.a r3 = this.d;
        if (r3 == null) goto L14;
        r3.jG((CreationDetailVideoView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368239));
    L14:
        com.larus.community.impl.detail.comment.a r4 = this.e;
        if (r4 == null) goto L18;
        r4.s30((ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368235));
        return;
    }

    public CreationDetailCommentViewHolder(d r2, a r3, com.larus.community.impl.detail.image.a r4, com.larus.community.impl.detail.video.a r5, com.larus.community.impl.detail.comment.a r6, View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        super(r7);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
