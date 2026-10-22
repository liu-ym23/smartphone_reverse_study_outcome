package com.ss.android.lark.integrator.im.impl.preview;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larus.feishu.office.im.impl.docpreview.MessageDocPreviewServiceImpl;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKGlobalScope
public final class b implements sza.c {
    public final Lazy<UrlPreviewService> a;
    public final Lazy<com.ss.android.lark.chat.preview.service.d> b;

    @Inject
    public b(Lazy<UrlPreviewService> r2, Lazy<com.ss.android.lark.chat.preview.service.d> r3) {
        Intrinsics.checkNotNullParameter(r2, "lazyUrlPreviewService");
        Intrinsics.checkNotNullParameter(r3, "lazyUrlPreviewPush");
        this.a = r2;
        this.b = r3;
    }

    public final void a(List r2, SyncDataStrategy r3, MessageDocPreviewServiceImpl.getPreviewEntities.1 r4) {
        Intrinsics.checkNotNullParameter(r2, "previewIds");
        Intrinsics.checkNotNullParameter(r3, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((UrlPreviewService) this.a.get()).getClass();
        UrlPreviewService.c(r2, r3, r4);
    }

    public final OfficeUrlPreviewPageServiceImpl b(Context r9, LifecycleOwner r10, kc9.a r11, FlowOfficeUrlPreviewHostService.b r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r11, "renderConfigProvider");
        return new OfficeUrlPreviewPageServiceImpl(r10, new OfficeUrlPreviewSessionImpl((UrlPreviewService) this.a.get(), (com.ss.android.lark.chat.preview.service.d) this.b.get(), r11, r12, r10, r9));
    }
}
