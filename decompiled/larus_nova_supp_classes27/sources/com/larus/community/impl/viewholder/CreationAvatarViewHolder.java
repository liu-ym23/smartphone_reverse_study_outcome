package com.larus.community.impl.viewholder;

import android.view.View;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationAvatarViewHolder;", "Lcom/larus/community/impl/viewholder/CreationImageViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getImageInfo", "Lcom/larus/platform/api/ImageInfo;", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAvatarViewHolder extends CreationImageViewHolder {
    public CreationAvatarViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.community.impl.viewholder.CreationImageViewHolder
    public final ImageInfo V3(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContent r3 = r2.e;
        if (r3 == null) goto L7;
        UserCreationUserAvatar r4 = r3.c;
        if (r4 == null) goto L7;
        return r4.a;
    L7:
        return null;
    }
}
