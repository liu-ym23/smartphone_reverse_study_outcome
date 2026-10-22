package com.obric.memorydata.personalcontext.collector;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.collector.MediaFileContentObserver$onChange$1", f = "MediaFileContentObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaFileContentObserver$onChange$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    MediaFileContentObserver$onChange$1(Uri r3, Continuation<? super MediaFileContentObserver$onChange$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$uri = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MediaFileContentObserver$onChange$1(this.$uri, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MediaFileContentObserver$onChange$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MediaFileContentObserver$onChange$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        Uri r11 = this.$uri;
        if (r11 == null) goto L15;
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        String r1 = f.f12067a.a().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        if (StringsKt.startsWith$default(r12, r1, false, 2, null) == false) goto L15;
        String r13 = this.$uri.getQueryParameter("changeType");
        long r0 = ContentUris.parseId(this.$uri);
        if (Intrinsics.areEqual(r13, "delete") == false) goto L11;
        IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), CollectionsKt.listOf(String.valueOf(r0)), EntityType.FILE, BuildConfig.LIBRARY_PACKAGE_NAME, null, 8, null);
        goto L15
    L11:
        h r9 = h.f12071a;
        ContentResolver r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r4, "getContentResolver(...)");
        List<FileEntity> r14 = r9.a(r4, CollectionsKt.listOf(Boxing.boxLong(r0)));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r14, null, 2, null);
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
