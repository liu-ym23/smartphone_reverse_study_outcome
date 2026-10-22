package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ List b;

    public a0(b0 r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    L23:
        return;
    L3:
        if (this.b == null) goto L17;
        MultiLinkCommonVoiceFeedPreview r0 = this.a.a;     // Catch: Throwable -> L14
        if (r0.m == null) goto L21;
        LinkFeedTypeConstant.Companion r1 = LinkFeedTypeConstant.Companion;     // Catch: Throwable -> L14
        IPreviewMultiLinkOuterConfigProvider r2 = r0.b;     // Catch: Throwable -> L14
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");     // Catch: Throwable -> L14
    L11:
        if (r1.isDouyinFullScreen(r2.getShowFrom()) == false) goto L22;
        qb r3 = r0.m;     // Catch: Throwable -> L14
        r0.m = null;     // Catch: Throwable -> L14
        r0.Q(r3);     // Catch: Throwable -> L14
        return;
    L22:
        return;
    L21:
        return;
    }
}
