package com.bytedance.android.live.base;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.live.base.model.g {
    public final Episode a;

    @Override // com.bytedance.android.live.base.model.Item
    public final List<Object> getDislikeReason() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getVideoUrl() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final ImageModel cover() {
        ImageModel r0 = (ImageModel) m.b(this.a.cover(), ImageModel.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ImageModel();
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final long getId() {
        return this.a.getIdExt();
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getMixId() {
        return this.a.getMixId();
    }

    @Override // com.bytedance.android.live.base.model.g
    public final User getOwner() {
        return (User) m.b(this.a.getOwner(), User.class);
    }

    @Override // com.bytedance.android.live.base.model.g
    public final String getRequestId() {
        return this.a.getRequestId();
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String subtitle() {
        return this.a.title;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String title() {
        return this.a.title;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final IUser author() {
        User r0 = getOwner();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new User();
    }

    public a(Episode r2) {
        Intrinsics.checkNotNullParameter(r2, "episode");
        this.a = r2;
    }
}
