package com.obric.memorydata.database.index;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityRawFileTextDbDao;
import com.obric.memorydata.database.entity.ge;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.index.EntityIndexHelper$processFileIndex$1", f = "EntityIndexHelper.kt", i = {}, l = {2587}, m = "invokeSuspend", n = {}, s = {})
final class EntityIndexHelper$processFileIndex$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.obric.memorydata.database.entity.e $entity;
    final /* synthetic */ String $fileExtension;
    final /* synthetic */ String $fileString;
    final /* synthetic */ int $fileTextEntityType;
    final /* synthetic */ String[] $ignoreExtensionList;
    final /* synthetic */ boolean $isFileEntityJson;
    int label;

    EntityIndexHelper$processFileIndex$1(boolean r3, String r4, com.obric.memorydata.database.entity.e r5, String r6, String[] r7, int r8, Continuation<? super EntityIndexHelper$processFileIndex$1> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$isFileEntityJson = r3;
        this.$fileString = r4;
        this.$entity = r5;
        this.$fileExtension = r6;
        this.$ignoreExtensionList = r7;
        this.$fileTextEntityType = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$processFileIndex$1(this.$isFileEntityJson, this.$fileString, this.$entity, this.$fileExtension, this.$ignoreExtensionList, this.$fileTextEntityType, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
        return ((EntityIndexHelper$processFileIndex$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityIndexHelper$processFileIndex$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        com.obric.memorydata.database.util.file_utils.j r13 = (com.obric.memorydata.database.util.file_utils.j) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.database.util.file_utils.j.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L18;
        this.$entity.a(r13.d());
        EntityIndexEngine r2 = s.a();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r3 = r2.getRawDaoByEntityType(this.$entity.getType());
        if (r3 == null) goto L22;
        Boxing.boxInt(r3.update(this.$entity));
    L22:
        IAppEntityRawFileTextDbDao<com.obric.memorydata.database.entity.f> r4 = r2.getRawFileTextDaoByEntityType(this.$fileTextEntityType);
        if (r4 != null) goto L27;
        return Boxing.boxBoolean(false);
    L27:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.queryByParentEntityId(this.$entity.getEntityId()), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Update file text entity, deleted " + r4.deleteByParentId(this.$entity.getEntityId()) + " file fragments.", false, 4, null);
    L29:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.util.file_utils.s.a(com.obric.memorydata.database.util.file_utils.s.f9665a, r13, 0, 2, null), Iterable.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.e r11 = this.$entity;
        Iterator r15 = r14.iterator();
    L31:
        if (r15.hasNext() == false) goto L34;
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r11.a((com.obric.memorydata.database.util.file_utils.s.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.util.file_utils.s.a.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        EntityManager.INSTANCE.launchIndexTask();
        goto L31
    L34:
        return Boxing.boxBoolean(true);
    L18:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (this.$isFileEntityJson == false) goto L11;
        FileEntity r16 = com.obric.memorydata.personalcontext.util.f.b(this.$fileString);
    L12:
        com.obric.memorydata.database.util.file_utils.m r5 = com.obric.memorydata.database.util.file_utils.m.f9660a;
        String r6 = this.$fileExtension;
        String[] r7 = this.$ignoreExtensionList;
        Continuation<? super com.obric.memorydata.database.util.file_utils.j> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = r5.a(r16, r6, r7, r8);
        if (r12 != r0) goto L15;
        return r0;
    L11:
        com.obric.memorydata.database.entity.e r17 = this.$entity;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.obric.memorydata.database.entity.RawFileEntity");
        AppEntity r18 = ((ge) ZeusTransformUtils.preCheckCast(r17, ge.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.FileEntity");
        r16 = (FileEntity) ZeusTransformUtils.preCheckCast(r18, FileEntity.class, "com.obric.memorydata.plugin");
        goto L12
    }
}
