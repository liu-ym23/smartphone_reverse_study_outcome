package com.larus.search.impl;

import android.content.Context;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarView;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/search/impl/LarkAvatarViewProvider;", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarViewProvider;", "<init>", "()V", "getView", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarView;", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LarkAvatarViewProvider implements ILarkAvatarViewProvider {
    public LarkAvatarViewProvider() {
    }

    public final ILarkAvatarView getView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LarkAvatarView(r5, null, 6, 0);
    }
}
