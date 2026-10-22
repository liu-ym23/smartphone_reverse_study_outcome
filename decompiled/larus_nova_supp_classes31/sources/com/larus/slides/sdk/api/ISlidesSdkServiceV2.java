package com.larus.slides.sdk.api;

import android.content.Context;
import com.bytedance.ee.bear.container.f;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.larus.office.h;
import com.larus.slides.operation.download.a;
import com.tencent.open.log.TraceLevel;
import fo9.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH¦@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H&Jj\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152*\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00100\u001bH&J\b\u0010\u001e\u001a\u00020\u0010H&J\u000e\u0010\u001f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/larus/slides/sdk/api/ISlidesSdkServiceV2;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "openAndGetSlidesFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "", "tryPrefetchData", "", "startDocExport", "fileName", "", "fileType", "type", "token", "eventSource", "callback", "Lkotlin/Function4;", "Landroid/net/Uri;", "", "cancelDocExport", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ISlidesSdkServiceV2 extends ISdkLifecycleV2 {
    Object a(Continuation<? super Unit> r1);

    boolean c(OfficeInputParam r1);

    void cancelDocExport();

    void j(OfficeInputParam r1);

    Object s(OfficeInputParam r1, b r2, h r3, f r4, Continuation r5);

    void y(Context r1, String r2, String r3, String r4, String r5, a r6);
}
