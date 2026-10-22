package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResourceItemBean>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ Uri $uri;
    int label;

    public MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(Uri r1, String r2, Continuation<? super MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1> r3) {
        this.$uri = r1;
        this.$identifier = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(this.$uri, this.$identifier, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ResourceItemBean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        ResourceItemBean r5 = com.larus.uaigc.helper.o0.c(this.$uri, this.$identifier);
        if (r5 == null) goto L13;
        if (r5.getResourceType() != ResourceType.VIDEO) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return r5;
    L9:
        r1 = false;
    L13:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
