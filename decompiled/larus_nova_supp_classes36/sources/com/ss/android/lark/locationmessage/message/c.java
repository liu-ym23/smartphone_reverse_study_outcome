package com.ss.android.lark.locationmessage.message;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements ListenerParams.b {
    public final /* synthetic */ LocationMessageCell.LocationMessageViewHolder a;

    public c(LocationMessageCell.LocationMessageViewHolder r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void a(Exception r2) {
        this.a.mLoadingProgress.setVisibility(8);
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
        this.a.mLoadingProgress.setVisibility(8);
    }
}
