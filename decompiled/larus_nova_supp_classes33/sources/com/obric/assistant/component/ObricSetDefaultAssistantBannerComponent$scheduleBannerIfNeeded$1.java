package com.obric.assistant.component;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1", f = "ObricSetDefaultAssistantBannerComponent.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricSetDefaultAssistantBannerComponent this$0;

    public ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1(ObricSetDefaultAssistantBannerComponent r1, Continuation<? super ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r14v0, types: [com.obric.assistant.component.z3] */
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L11:
        final ObricSetDefaultAssistantBannerComponent r4 = this.this$0;
        r4.s = null;
        laa.d r5 = r4.m3();
        if (r5 == null) goto L14;
        ObricFloatChatPageState r6 = r5.getPageState();
    L16:
        if (r4.Y2(r6) == true) goto L18;
        FLogger.a.i("ObricSetDefaultAssistantBannerComponent", "showBannerIfNeeded blocked, pageState=" + r6);
    L41:
        return Unit.INSTANCE;
    L18:
        FragmentActivity r7 = r4.getContext();
        if ((r7 instanceof FragmentActivity) == false) goto L21;
        final FragmentActivity r8 = r7;
    L22:
        if (r8 != null) goto L24;
        FLogger.a.i("ObricSetDefaultAssistantBannerComponent", "showBannerIfNeeded blocked, activity is null");
        goto L41
    L24:
        va8.m r9 = (va8.m) r4.m.getValue();
        if (r9 == null) goto L39;
        va8.l r10 = r9.iX();
        if (r10 == null) goto L39;
        FrameLayout r11 = r10.getTitleContainer();
        if (r11 == null) goto L39;
        IObricBannerService r12 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r12 != null) goto L34;
    L36:
        r3 = false;
    L37:
        if (r3 == false) goto L41;
        BuildersKt.launch$default(ObricSetDefaultAssistantBannerComponent.t, null, null, new ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1(null), 3, null);
        goto L41
    L34:
        if (r12.f(r8, r11, new tba.b(2, r8.getString(2131912408), r8.getString(2131912404), null, new x3(r4), new y3(r4, r8), new z3(r4), 8), "default") != true) goto L36;
    L39:
        FLogger.a.i("ObricSetDefaultAssistantBannerComponent", "showBannerIfNeeded blocked, titleContainer is null");
        goto L41
    L21:
        r8 = null;
        goto L22
    L14:
        r6 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r1) goto L11;
        return r1;
    }
}
