package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.dao.AutoMemoryProDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.ActivityMemorySearchBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$onResumeChecked$1$1$1", f = "MemorySearchActivity.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
final class MemorySearchActivity$onResumeChecked$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.ae<cu> $metaInfo;
    int label;
    final /* synthetic */ MemorySearchActivity this$0;

    MemorySearchActivity$onResumeChecked$1$1$1(kotlinx.coroutines.flow.ae<cu> r3, MemorySearchActivity r4, Continuation<? super MemorySearchActivity$onResumeChecked$1$1$1> r5) {
        kotlinx.coroutines.flow.ae<cu> r6 = (kotlinx.coroutines.flow.ae) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.ae.class, "com.obric.memorydata.plugin");
        MemorySearchActivity r7 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$metaInfo = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$onResumeChecked$1$1$1(this.$metaInfo, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((MemorySearchActivity$onResumeChecked$1$1$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemorySearchActivity$onResumeChecked$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        if (this.$metaInfo.c() == null) goto L51;
        cu r12 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r12);
        int r13 = ((cu) ZeusTransformUtils.preCheckCast(r12, cu.class, "com.obric.memorydata.plugin")).getType();
        if (r13 != (-403)) goto L16;
        AutoMemoryProDao r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao();
        cu r3 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r3);
        if (r14.queryByEntityId(((cu) ZeusTransformUtils.preCheckCast(r3, cu.class, "com.obric.memorydata.plugin")).a()) != null) goto L38;
    L23:
        r2 = false;
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySearchActivity", "memoryExist: " + r2, false, 4, null);
        if (r2 == true) goto L51;
        ActivityMemorySearchBinding r15 = MemorySearchActivity.access$getBinding$p(this.this$0);
        if (r15 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L44:
        if (r15.rvMemoryList.getItemAnimator() != null) goto L49;
        ActivityMemorySearchBinding r16 = MemorySearchActivity.access$getBinding$p(this.this$0);
        if (r16 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L48:
        r16.rvMemoryList.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.h(), RecyclerView.e.class, "com.obric.memorydata.plugin"));
    L49:
        SearchViewModel r17 = this.this$0.getViewModel();
        cu r4 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r4);
        r17.removeByMetaInfo((cu) ZeusTransformUtils.preCheckCast(r4, cu.class, "com.obric.memorydata.plugin"));
        this.$metaInfo.b(null);
        goto L51
    L16:
        if (r13 != (-401)) goto L18;
        SemanticMemoryDao r18 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        cu r5 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r5);
        if (r18.queryByEntityId(((cu) ZeusTransformUtils.preCheckCast(r5, cu.class, "com.obric.memorydata.plugin")).a()) == null) goto L23;
    L18:
        if (r13 != (-306)) goto L20;
        EpisodicMemoryDao r19 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        cu r6 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r6);
        if (r19.queryByEntityId(((cu) ZeusTransformUtils.preCheckCast(r6, cu.class, "com.obric.memorydata.plugin")).a()) == null) goto L23;
    L20:
        if (r13 != (-303)) goto L22;
        EpisodicMemoryDao r110 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        cu r7 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r7);
        if (r110.queryByEntityId(((cu) ZeusTransformUtils.preCheckCast(r7, cu.class, "com.obric.memorydata.plugin")).a()) == null) goto L23;
    L22:
        if (r13 != 502) goto L23;
        AuditoryRecordingRawDbDao r111 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao();
        cu r8 = this.$metaInfo.c();
        Intrinsics.checkNotNull(r8);
        if (r111.queryByEntityId(((cu) ZeusTransformUtils.preCheckCast(r8, cu.class, "com.obric.memorydata.plugin")).a()) == null) goto L23;
    L51:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Continuation r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.au.a(100, r112) != r0) goto L12;
        return r0;
    }
}
