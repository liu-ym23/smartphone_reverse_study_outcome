package com.larus.community.impl.publish.viewmodel;

import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.ui.arch.vm.ComponentViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageState;", "<init>", "()V", "isPrivate", "", "privateImageUrls", "", "Lcom/larus/ugc/community/adapter/RefData;", "normalImageUrls", "initImageData", "", "publisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "updateChecked", "checked", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishShowImageViewModel extends ComponentViewModel<CreationPublishShowImageState> {
    private boolean isPrivate;
    private List<f0a.a> normalImageUrls;
    private List<f0a.a> privateImageUrls;

    /* JADX INFO: renamed from: com.larus.community.impl.publish.viewmodel.CreationPublishShowImageViewModel$initImageData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.viewmodel.CreationPublishShowImageViewModel$initImageData$1", f = "CreationPublishShowImageViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PublisherCreation $publisherCreation;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CreationPublishShowImageViewModel this$0;

        public AnonymousClass1(CreationPublishShowImageViewModel r1, PublisherCreation r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$publisherCreation = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$publisherCreation, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$1;
            Iterator r3 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r12);
        L10:
            if (r3.hasNext() == false) goto L27;
            Image r13 = ((f0a.a) r3.next()).b;
            if (r13 == null) goto L10;
            String r14 = r13.a;
            if (r14 == null) goto L10;
            if (r14.length() <= 0) goto L18;
            boolean r4 = true;
        L19:
            if (r4 == true) goto L22;
            r14 = null;
        L22:
            String r5 = r14;
            if (r5 == null) goto L10;
            this.L$0 = r3;
            this.L$1 = r5;
            this.label = 1;
            if (ImageLoaderKt.A(r5, "CreationPublishShowImageViewModel", null, null, null, this, 60) != r0) goto L10;
            return r0;
        L18:
            r4 = false;
            goto L19
        L27:
            final CreationPublishShowImageViewModel r15 = this.this$0;
            final PublisherCreation r6 = this.$publisherCreation;
            CreationPublishShowImageViewModel.access$setState(r15, new d(r6, r15));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CreationPublishShowImageViewModel.access$setPrivateImageUrls$p(this.this$0, f0a.b.a(this.$publisherCreation.getRefContentBean(), false));
            CreationPublishShowImageViewModel.access$setNormalImageUrls$p(this.this$0, f0a.b.a(this.$publisherCreation.getRefContentBean(), true));
            r3 = CreationPublishShowImageViewModel.access$getPrivateImageUrls$p(this.this$0).iterator();
            goto L10
        }
    }

    public static /* synthetic */ CreationPublishShowImageState No(PublisherCreation r0, CreationPublishShowImageState r1) {
        return initImageData$lambda$0(r0, r1);
    }

    public static /* synthetic */ CreationPublishShowImageState Oo(ArrayList r0, CreationPublishShowImageState r1) {
        return updateChecked$lambda$1(r0, r1);
    }

    public CreationPublishShowImageViewModel() {
        this.privateImageUrls = CollectionsKt.emptyList();
        this.normalImageUrls = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ List access$getNormalImageUrls$p(CreationPublishShowImageViewModel r0) {
        return r0.normalImageUrls;
    }

    public static final /* synthetic */ List access$getPrivateImageUrls$p(CreationPublishShowImageViewModel r0) {
        return r0.privateImageUrls;
    }

    public static final /* synthetic */ boolean access$isPrivate$p(CreationPublishShowImageViewModel r0) {
        return r0.isPrivate;
    }

    public final void initImageData(final PublisherCreation r8) {
        Intrinsics.checkNotNullParameter(r8, "publisherCreation");
        if (r8.hasRefResource() == false) goto L5;
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
        return;
    L5:
        setState(new b(r8));
    }

    public final void updateChecked(boolean r2) {
        this.isPrivate = !r2;
        final ArrayList r3 = new ArrayList();
        if (this.isPrivate == false) goto L5;
        r3.addAll(this.privateImageUrls);
    L6:
        setState(new c(r3));
        return;
    L5:
        r3.addAll(this.normalImageUrls);
        goto L6
    }

    public static final /* synthetic */ void access$setNormalImageUrls$p(CreationPublishShowImageViewModel r0, List r1) {
        r0.normalImageUrls = r1;
    }

    public static final /* synthetic */ void access$setPrivateImageUrls$p(CreationPublishShowImageViewModel r0, List r1) {
        r0.privateImageUrls = r1;
    }

    public static final /* synthetic */ void access$setState(CreationPublishShowImageViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private static final CreationPublishShowImageState initImageData$lambda$0(PublisherCreation r2, CreationPublishShowImageState r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$setState");
        String r0 = r2.getImageUrl();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return r3.copy(r0, new ArrayList(), r2.isVideo());
    }

    private static final CreationPublishShowImageState updateChecked$lambda$1(ArrayList r7, CreationPublishShowImageState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        return CreationPublishShowImageState.copy$default(r8, null, r7, false, 5, null);
    }
}
