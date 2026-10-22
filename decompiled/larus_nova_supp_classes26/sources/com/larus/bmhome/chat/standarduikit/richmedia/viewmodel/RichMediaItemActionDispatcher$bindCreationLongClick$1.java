package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.util.Size;
import android.view.View;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.RichMediaItemActionDispatcher$bindCreationLongClick$1", f = "RichMediaItemActionDispatcher.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaItemActionDispatcher$bindCreationLongClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ f0 $currentDependency;
    final /* synthetic */ CreationItem $item;
    final /* synthetic */ int $itemPosition;
    final /* synthetic */ Size $itemSize;
    final /* synthetic */ fn8.c $uiItem;
    int label;
    final /* synthetic */ u this$0;

    public RichMediaItemActionDispatcher$bindCreationLongClick$1(View r1, u r2, CreationItem r3, int r4, Size r5, f0 r6, fn8.c r7, Continuation<? super RichMediaItemActionDispatcher$bindCreationLongClick$1> r8) {
        this.$anchor = r1;
        this.this$0 = r2;
        this.$item = r3;
        this.$itemPosition = r4;
        this.$itemSize = r5;
        this.$currentDependency = r6;
        this.$uiItem = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RichMediaItemActionDispatcher$bindCreationLongClick$1(this.$anchor, this.this$0, this.$item, this.$itemPosition, this.$itemSize, this.$currentDependency, this.$uiItem, r11);
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
        View r16 = this.$anchor;
        Message r3 = this.this$0.a;
        CreationItem r4 = this.$item;
        int r5 = this.$itemPosition;
        int r6 = this.$itemSize.getWidth();
        int r7 = this.$itemSize.getHeight();
        String r8 = this.$currentDependency.getCurrentPage();
        String r9 = this.$currentDependency.b();
        Boolean r10 = Boxing.boxBoolean(this.this$0.h());
        kc8.q r11 = this.$currentDependency.g();
        JSONObject r12 = this.this$0.p(this.$uiItem);
        this.label = 1;
        if (r2.d(r16, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, this) != r0) goto L12;
        return r0;
    }
}
