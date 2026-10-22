package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.base.databinding.PageSettingAboutObricPageBinding;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ObricAboutAppFragment$setupCheckUpdate$1$2", f = "ObricAboutAppFragment.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
final class ObricAboutAppFragment$setupCheckUpdate$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageSettingAboutObricPageBinding $this_apply;
    int label;
    final /* synthetic */ ObricAboutAppFragment this$0;

    public ObricAboutAppFragment$setupCheckUpdate$1$2(ObricAboutAppFragment r1, PageSettingAboutObricPageBinding r2, Continuation<? super ObricAboutAppFragment$setupCheckUpdate$1$2> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAboutAppFragment$setupCheckUpdate$1$2(this.this$0, this.$this_apply, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L14:
        if (((Boolean) r4).booleanValue() == true) goto L17;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L22;
        if (this.this$0.g == true) goto L22;
        this.$this_apply.b.i6(NameKeys.UnloadStrategy_No_Strategy);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IObricUpdateService r5 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r5 == null) goto L16;
        this.label = 1;
        r4 = r5.c(this);
        if (r4 != r0) goto L14;
        return r0;
    }
}
