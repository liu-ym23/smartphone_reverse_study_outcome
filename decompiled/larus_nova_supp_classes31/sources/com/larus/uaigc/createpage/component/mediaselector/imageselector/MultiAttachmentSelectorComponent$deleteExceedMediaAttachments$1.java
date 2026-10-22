package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.Image;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {2746}, m = "invokeSuspend", n = {"iterator", "index"}, s = {"L$0", "I$0"})
public final class MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $count;
    final /* synthetic */ ResourceType $resourceType;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResourceItemBean $resourceItemBean;
        final /* synthetic */ String $resourceKey;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, String r2, ResourceItemBean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$resourceKey = r2;
            this.$resourceItemBean = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$resourceKey, this.$resourceItemBean, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r9);
            MultiAttachmentSelectorComponent r10 = this.this$0;
            String r0 = this.$resourceKey;
            Intrinsics.checkNotNull(r0);
            Image r1 = this.$resourceItemBean.getImage();
            if (r1 == null) goto L7;
            String r2 = r1.localResPath;
        L8:
            if (r2 != null) goto L10;
            r2 = "";
        L10:
            r10.w60(r0, r2, null);
            MutableLiveData<ry9.f> r11 = this.this$0.N;
            String r3 = this.$resourceKey;
            Intrinsics.checkNotNull(r3);
            r11.setValue(new ry9.f(r3, 0, null, UIStatus.STATUS_DELETE, 6));
            return Unit.INSTANCE;
        L7:
            r2 = null;
            goto L8
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1(MultiAttachmentSelectorComponent r1, int r2, ResourceType r3, Continuation<? super MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1> r4) {
        this.this$0 = r1;
        this.$count = r2;
        this.$resourceType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1(this.this$0, this.$count, this.$resourceType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0078 -> B:22:0x007b). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        Iterator r3 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r11);
        MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1 r12 = this;
    L22:
        r2 = r2 + 1;
    L10:
        if (r3.hasNext() == false) goto L24;
        if (r2 >= r12.$count) goto L24;
        String r4 = (String) ((Pair) r3.next()).getFirst();
        ResourceItemBean r5 = r12.this$0.y.get(r4);
        if (r5 == null) goto L16;
        ResourceType r7 = r5.getResourceType();
    L18:
        if (r7 != r12.$resourceType) goto L10;
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(r12.this$0, r4, r5, null);
        r12.L$0 = r3;
        r12.I$0 = r2;
        r12.label = 1;
        if (BuildersKt.withContext(r8, r9, r12) != r0) goto L22;
        return r0;
    L16:
        r7 = null;
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r2 = 0;
        r3 = CollectionsKt.reversed(MapsKt.toList(this.this$0.v)).iterator();
        r12 = this;
        goto L10
    }
}
