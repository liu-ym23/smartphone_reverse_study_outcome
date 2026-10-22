package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Set;
import kc8.s0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.RichMediaItemActionDispatcher$openCreationPreview$1", f = "RichMediaItemActionDispatcher.kt", i = {}, l = {666}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaItemActionDispatcher$openCreationPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ CreationItem $clickItem;
    final /* synthetic */ List<CreationItem> $creationItems;
    final /* synthetic */ f0 $currentDependency;
    final /* synthetic */ Message $previewMessage;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ s0 $videoPlaybackSnapshot;
    int label;
    final /* synthetic */ u this$0;

    public RichMediaItemActionDispatcher$openCreationPreview$1(View r1, Message r2, List<CreationItem> r3, CreationItem r4, f0 r5, u r6, CoroutineScope r7, s0 r8, Continuation<? super RichMediaItemActionDispatcher$openCreationPreview$1> r9) {
        this.$anchor = r1;
        this.$previewMessage = r2;
        this.$creationItems = r3;
        this.$clickItem = r4;
        this.$currentDependency = r5;
        this.this$0 = r6;
        this.$scope = r7;
        this.$videoPlaybackSnapshot = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RichMediaItemActionDispatcher$openCreationPreview$1(this.$anchor, this.$previewMessage, this.$creationItems, this.$clickItem, this.$currentDependency, this.this$0, this.$scope, this.$videoPlaybackSnapshot, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        IRichMediaCreationClickService.Companion r2 = IRichMediaCreationClickService.a;
        View r3 = this.$anchor;
        Message r4 = this.$previewMessage;
        List<CreationItem> r5 = this.$creationItems;
        CreationItem r6 = this.$clickItem;
        String r7 = this.$currentDependency.getCurrentPage();
        String r8 = this.$currentDependency.b();
        u r16 = this.this$0;
        Set<Integer> r9 = u.i;
        Boolean r10 = Boxing.boxBoolean(r16.h());
        kc8.q r11 = this.$currentDependency.g();
        CoroutineScope r12 = this.$scope;
        s0 r13 = this.$videoPlaybackSnapshot;
        this.label = 1;
        if (r2.h(r3, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, this) != r0) goto L12;
        return r0;
    }
}
