package com.obric.assistant.block.search.local.adapter;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.OSearchEntityImage;
import com.larus.im.bean.message.block.OSearchEntityVideo;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.utils.AppEntityEx;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.search.local.adapter.SearchLocalRowAdapter$showAll$1", f = "SearchLocalRowAdapter.kt", i = {}, l = {164, 182}, m = "invokeSuspend", n = {}, s = {})
public final class SearchLocalRowAdapter$showAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $mustShowTarget;
    final /* synthetic */ AppEntityEx.a $targetKey;
    int label;
    final /* synthetic */ SearchLocalRowAdapter this$0;

    /* JADX INFO: renamed from: com.obric.assistant.block.search.local.adapter.SearchLocalRowAdapter$showAll$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.block.search.local.adapter.SearchLocalRowAdapter$showAll$1$1", f = "SearchLocalRowAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PhotoEntity[] $photoEntityList;
        final /* synthetic */ Ref.IntRef $targetIndex;
        int label;

        public AnonymousClass1(PhotoEntity[] r1, Ref.IntRef r2, Continuation<? super AnonymousClass1> r3) {
            this.$photoEntityList = r1;
            this.$targetIndex = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$photoEntityList, this.$targetIndex, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            IAgentAppIntentIDL r4 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r4 == null) goto L8;
            r4.showPhoto(this.$photoEntityList, this.$targetIndex.element);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SearchLocalRowAdapter$showAll$1(SearchLocalRowAdapter r1, AppEntityEx.a r2, boolean r3, Continuation<? super SearchLocalRowAdapter$showAll$1> r4) {
        this.this$0 = r1;
        this.$targetKey = r2;
        this.$mustShowTarget = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SearchLocalRowAdapter$showAll$1(this.this$0, this.$targetKey, this.$mustShowTarget, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L64:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L27:
        ArrayList r2 = new ArrayList();
        Iterator r15 = ((Iterable) r14).iterator();
    L29:
        if (r15.hasNext() == false) goto L33;
        Object r5 = r15.next();
        if ((r5 instanceof PhotoEntity) == false) goto L29;
        r2.add(r5);
        goto L29
    L33:
        AppEntity[] r3 = (PhotoEntity[]) r2.toArray(new PhotoEntity[0]);
        FLogger.a.i("SearchLocalRowAdapter", "showAll: photoEntityList.size = " + r3.length);
        if (r3.length != 0) goto L36;
        boolean r6 = true;
    L38:
        if ((!r6) == false) goto L64;
        Ref.IntRef r7 = new Ref.IntRef();
        AppEntityEx.a r8 = this.$targetKey;
        if (r8 != null) goto L42;
        int r9 = 0;
    L54:
        r7.element = r9;
        if (r9 >= 0) goto L60;
        FLogger.a.w("SearchLocalRowAdapter", "showAll: not found " + this.$targetKey + ", mustShowTarget = " + this.$mustShowTarget);
        r7.element = 0;
        if (this.$mustShowTarget == false) goto L60;
        s.a.g(AppHost.a.getApplication(), 2131912068, false);
        return Unit.INSTANCE;
    L60:
        CoroutineDispatcher r16 = Dispatchers.getIO();
        AnonymousClass1 r4 = new AnonymousClass1(r3, r7, null);
        this.label = 2;
        if (BuildersKt.withContext(r16, r4, this) != r0) goto L64;
        return r0;
    L42:
        int r10 = r3.length;
        r9 = 0;
    L43:
        if (r9 >= r10) goto L53;
        AppEntity r11 = r3[r9];
        if (Intrinsics.areEqual(String.valueOf(r11.getType()), r8.getType()) == true) goto L47;
    L49:
        boolean r12 = false;
    L50:
        if (r12 == true) goto L54;
        r9 = r9 + 1;
        goto L43
    L47:
        if (Intrinsics.areEqual(r11.getId(), r8.a()) == false) goto L49;
        r12 = true;
        goto L50
    L53:
        r9 = -1;
        goto L54
    L36:
        r6 = false;
        goto L38
    L10:
        ResultKt.throwOnFailure(r14);
        List<OSearchReferenceInCollection> r17 = this.this$0.a;
        ArrayList r13 = new ArrayList();
        Iterator r18 = ((ArrayList) r17).iterator();
    L12:
        if (r18.hasNext() == false) goto L24;
        OSearchReferenceInCollection r19 = (OSearchReferenceInCollection) r18.next();
        OSearchEntityImage r20 = r19.getOEntityImage();
        if (r20 == null) goto L16;
        AppEntityEx.a r21 = new AppEntityEx.a(r20.getEntityPackageName(), r20.getEntityType(), r20.getEntityId());
    L20:
        if (r21 != null) goto L22;
        r21 = null;
    L22:
        if (r21 == null) goto L12;
        r13.add(r21);
        goto L12
    L16:
        OSearchEntityVideo r22 = r19.getOEntityVideo();
        if (r22 == null) goto L19;
        r21 = new AppEntityEx.a(r22.getEntityPackageName(), r22.getEntityType(), r22.getEntityId());
        goto L20
    L19:
        r21 = null;
        goto L20
    L24:
        int r110 = AppEntityEx.a;
        this.label = 1;
        r14 = AppEntityEx.b(r13, this);
        if (r14 != r0) goto L27;
        return r0;
    }
}
