package com.larus.ugc.feed.impl.viewholder;

import android.view.View;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationUserAvatarKmp;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationAvatarViewHolder;", "Lcom/larus/ugc/feed/impl/viewholder/CreationImageViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getImageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationAvatarViewHolder extends CreationImageViewHolder {
    public CreationAvatarViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.ugc.feed.impl.viewholder.CreationImageViewHolder
    public final ImageInfoKmp U3(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContentKmp r3 = r2.getContent();
        if (r3 == null) goto L7;
        UserCreationUserAvatarKmp r4 = r3.getUserAvatarContent();
        if (r4 == null) goto L7;
        return r4.getImageInfo();
    L7:
        return null;
    }
}
