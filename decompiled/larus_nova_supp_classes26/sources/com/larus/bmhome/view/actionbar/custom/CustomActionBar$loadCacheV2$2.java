package com.larus.bmhome.view.actionbar.custom;

import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$loadCacheV2$2", f = "CustomActionBar.kt", i = {}, l = {2654}, m = "invokeSuspend", n = {}, s = {})
final class CustomActionBar$loadCacheV2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.model.n $chatDraft;
    final /* synthetic */ BaseContentWidget $component;
    final /* synthetic */ Function1<com.larus.bmhome.actionbar.model.z0, Boolean> $filter;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBar$loadCacheV2$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$loadCacheV2$2$1", f = "CustomActionBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<com.larus.bmhome.actionbar.model.z0> $cacheData;
        final /* synthetic */ com.larus.bmhome.chat.model.n $chatDraft;
        final /* synthetic */ BaseContentWidget $component;
        int label;
        final /* synthetic */ CustomActionBar this$0;

        public AnonymousClass1(List<com.larus.bmhome.actionbar.model.z0> r1, CustomActionBar r2, BaseContentWidget r3, com.larus.bmhome.chat.model.n r4, Continuation<? super AnonymousClass1> r5) {
            this.$cacheData = r1;
            this.this$0 = r2;
            this.$component = r3;
            this.$chatDraft = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$cacheData, this.this$0, this.$component, this.$chatDraft, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            List<com.larus.bmhome.actionbar.model.z0> r5 = this.$cacheData;
            if (r5 == null) goto L8;
            CustomActionBar.u(this.this$0, this.$component, this.$chatDraft, r5);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CustomActionBar$loadCacheV2$2(CustomActionBar r1, String r2, Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r3, BaseContentWidget r4, com.larus.bmhome.chat.model.n r5, Continuation<? super CustomActionBar$loadCacheV2$2> r6) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$filter = r3;
        this.$component = r4;
        this.$chatDraft = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CustomActionBar$loadCacheV2$2(this.this$0, this.$scene, this.$filter, this.$component, this.$chatDraft, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CustomActionBarViewModel r3 = this.this$0.o;
        if (r3 == null) goto L11;
        int r12 = CustomActionBar.c0;
        List r13 = CustomActionBarViewModel.getCacheConfig$default(r3, CustomActionBar.b.a(), null, this.$scene, this.$filter, 2, null);
    L12:
        List r4 = r13;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.this$0, this.$component, this.$chatDraft, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L16;
        return r0;
    L11:
        r13 = null;
        goto L12
    }
}
