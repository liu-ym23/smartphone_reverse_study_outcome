package com.larus.bmhome.chat.doclink;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static IMessageDocPreviewService a() {
        return (IMessageDocPreviewService) ServiceManager.get().getService(IMessageDocPreviewService.class);
    }
}
