package com.larus.platform.api;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J \u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\b\u0010\r\u001a\u00020\u000eH\u0016J<\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0019\u0012\u0004\u0012\u00020\f0\u0018H&¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/api/IOfficeUrlPreviewHostService;", "", "openPreview", "", "request", "Lcom/larus/platform/api/OfficeUrlPreviewHostOpenRequest;", "ensureReady", "Lcom/larus/platform/api/IOfficeUrlPreviewHostReadyHandle;", "source", "", "onReady", "Lkotlin/Function0;", "", "getInitState", "Lcom/larus/platform/api/OfficeSdkInitState;", "createPage", "Lcom/larus/platform/api/IOfficeUrlPreviewHostPage;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "renderConfigProvider", "Lcom/larus/platform/api/IOfficeUrlPreviewHostRenderConfigProvider;", "onPreviewUpdated", "Lkotlin/Function1;", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IOfficeUrlPreviewHostService {
    q4 a();

    kc9.d b(Context r1, LifecycleOwner r2, com.larus.office.card.urlpreview.v1 r3, Function1 r4);

    boolean c(r4 r1);

    FlowOfficeUrlPreviewHostService.a d(Function0 r1);
}
