package com.obric.memorydata.personalcontext.external.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.external.file.ExternalFileObserver$syncData$getDeleteIdsDeferred$1", f = "ExternalFileObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExternalFileObserver$syncData$getDeleteIdsDeferred$1 extends SuspendLambda implements Function2<al, Continuation<? super Set<String>>, Object> {
    int label;
    final /* synthetic */ e this$0;

    ExternalFileObserver$syncData$getDeleteIdsDeferred$1(e r3, Continuation<? super ExternalFileObserver$syncData$getDeleteIdsDeferred$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExternalFileObserver$syncData$getDeleteIdsDeferred$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Set<String>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Set<String>> r4) {
        return ((ExternalFileObserver$syncData$getDeleteIdsDeferred$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExternalFileObserver$syncData$getDeleteIdsDeferred$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, java.lang.Long] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r18);
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        String r4 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().e();
    L5:
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r6 = s.a().getRawDaoByEntityType(EntityType.FILE);
        if (r6 == null) goto L8;
        Cursor r7 = r6.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r4, 2000, (Long) ZeusTransformUtils.preCheckCast(r2.element, Long.class, "com.obric.memorydata.plugin"));
    L9:
        Ref.IntRef r14 = new Ref.IntRef();
        if (r7 == null) goto L25;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L14:
        if (r10.moveToNext() == false) goto L16;
        String r11 = r10.getString(r10.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L18
        r2.element = Boxing.boxLong(r10.getLong(r10.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L18
        r5.add(r11);     // Catch: Throwable -> L18
        r14.element++;     // Catch: Throwable -> L18
        goto L14
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r8, null);
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L25:
        if (r5.isEmpty() == true) goto L35;
        b r12 = b.f12130a;
        ContentResolver r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r13, "getContentResolver(...)");
        Set r15 = b.a(r12, r13, r5, 0, 0, 12, null);
        Iterator r16 = r5.iterator();
    L29:
        if (r16.hasNext() == false) goto L34;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r15.contains(r17) == true) goto L29;
        r1.add(r17);
        goto L29
    L34:
        if (r14.element >= 2000) goto L5;
    L35:
        return r1;
    L8:
        r7 = null;
        goto L9
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
