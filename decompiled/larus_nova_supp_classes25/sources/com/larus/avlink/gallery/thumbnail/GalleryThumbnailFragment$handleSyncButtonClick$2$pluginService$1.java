package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/mirabridge/api/pluginservice/IDoraPluginService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1", f = "GalleryThumbnailFragment.kt", i = {}, l = {645}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IDoraPluginService>, Object> {
    final /* synthetic */ com.larus.avlink.gallery.plugin.g $pluginLoadingUI;
    int label;

    public GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1(com.larus.avlink.gallery.plugin.g r1, Continuation<? super GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1> r2) {
        this.$pluginLoadingUI = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1(this.$pluginLoadingUI, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super IDoraPluginService> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L27:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        com.larus.avlink.gallery.plugin.g r9 = this.$pluginLoadingUI;
        this.label = 1;
        IPluginService r2 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L16;
        IDoraPluginService r10 = (IDoraPluginService) ServiceManager.get().getService(IDoraPluginService.class);
        com.larus.avlink.gallery.plugin.f.b(r10);
        r8 = r10;
    L25:
        if (r8 != r0) goto L27;
        return r0;
    L16:
        kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        AtomicBoolean r3 = new AtomicBoolean(false);
        PluginLoadBuilder r6 = new PluginLoadBuilder();
        Intrinsics.checkNotNullParameter("com.larus.mira.dora", "packageName");
        r6.a = "com.larus.mira.dora";
        Intrinsics.checkNotNull(IDoraPluginService.class, "null cannot be cast to non-null type java.lang.Class<*>");
        r6.b = IDoraPluginService.class;
        PluginLoadBuilder.PluginLoadType r7 = PluginLoadBuilder.PluginLoadType.ASYNC;
        Intrinsics.checkNotNullParameter(r7, "type");
        r6.e = r7;
        PluginLoadBuilder.PluginLoadTime r11 = PluginLoadBuilder.PluginLoadTime.IMMEDIATE;
        Intrinsics.checkNotNullParameter(r11, "method");
        r6.d = r11;
        r6.g = 3000;
        com.larus.avlink.gallery.plugin.e r12 = new com.larus.avlink.gallery.plugin.e(r3, r5);
        Intrinsics.checkNotNullParameter(r12, "result");
        r6.f = r12;
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "loadingUI");
        r6.c = new WeakReference(r9);
    L19:
        PluginLoadBuilder.c r13 = r6.a();
        if (r2 == null) goto L22;
        r2.a(r13);
    L22:
        r5.i(new com.larus.avlink.gallery.plugin.d(r3));
        Object r14 = r5.B();
        r8 = r14;
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(this);
        r8 = r14;
        goto L25
    L11:
        if (r2.c(IDoraPluginService.class) != true) goto L13;
        r4 = true;
        goto L14
    }
}
