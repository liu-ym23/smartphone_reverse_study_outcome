package com.obric.assistant.component;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$checkUpdateBannerNeedShow$1", f = "ObricUpdateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateComponent$checkUpdateBannerNeedShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$checkUpdateBannerNeedShow$1(ObricUpdateComponent r1, Continuation<? super ObricUpdateComponent$checkUpdateBannerNeedShow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricUpdateComponent$checkUpdateBannerNeedShow$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L72;
        ResultKt.throwOnFailure(r24);
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        FrameLayout r2 = null;
        if (r0 == null) goto L7;
        Integer r1 = Boxing.boxInt(r0.l());
    L8:
        boolean r3 = false;
        if (r1 != null) goto L12;
    L13:
        boolean r5 = true;
    L15:
        ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
        ObricUpdateComponent r7 = this.this$0;
        int r8 = ObricUpdateComponent.F;
        ObricFloatChatPageState r9 = r7.getPageState();
        r6.getClass();
        boolean r10 = r9 instanceof vda.b;
        this.this$0.getClass();
        boolean r11 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
        if (IWindowContextKt.isWindowContext(this.this$0.getContext()) == true) goto L18;
    L20:
        boolean r12 = false;
    L21:
        ObricUpdateComponent r13 = this.this$0;
        if (r13.z == true) goto L32;
        com.larus.bmhome.a0 r14 = r13.y;
        if (r14 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == true) goto L32;
        boolean r16 = false;
    L33:
        FLogger r17 = FLogger.a;
        r17.i("ObricUpdateComponent", "checkUpdateBannerNeedShow, hostId=" + this.this$0.w + ", currentState=" + r1 + ", showUpdateBanner=" + r5 + ", pageDismissed=" + r10 + ", screenLocked=" + r11 + ", blockByWindowAnimation=" + r12 + ", blockBySideBar=" + r16);
        if (r5 == false) goto L68;
        if (r10 == true) goto L68;
        if (r11 == true) goto L68;
        if (r12 == true) goto L68;
        if (r16 == true) goto L68;
        ObricUpdateComponent r4 = this.this$0;
        Map r18 = MapsKt.emptyMap();
        r4.getClass();
        r17.i("ObricUpdateComponent", "realShowUpdateBanner, hostId=" + r4.w);     // Catch: Exception -> L66
        FragmentActivity r19 = r4.getContext();     // Catch: Exception -> L66
        if ((r19 instanceof FragmentActivity) == false) goto L43;
        FragmentActivity r20 = r19;     // Catch: Exception -> L66
    L44:
        va8.l r21 = (va8.l) r4.v.getValue();     // Catch: Exception -> L66
        if (r21 == null) goto L47;
        r2 = r21.getTitleContainer();     // Catch: Exception -> L66
    L47:
        if (r20 == null) goto L57;
        if (r2 == null) goto L57;
        if (r2.isAttachedToWindow() == true) goto L54;
        r17.i("ObricUpdateComponent", "realShowUpdateBanner return, anchor not attached, hostId=" + r4.w + ", anchor=" + ObricUpdateComponent.E3(r2));     // Catch: Exception -> L66
    L70:
        return Unit.INSTANCE;
    L54:
        r17.i("ObricUpdateComponent", "realShowUpdateBanner show, hostId=" + r4.w + ", activity=" + r20.getClass().getSimpleName() + ", lifecycle=" + ((BaseComponentFeatureInternal) r4).a.getCurrentState() + ", pageState=" + r4.getPageState() + ", anchor=" + ObricUpdateComponent.E3(r2));     // Catch: Exception -> L66
        IObricBannerService r22 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);     // Catch: Exception -> L66
        if (r22 == null) goto L70;
        r22.f(r20, r2, new tba.b(1, "", "", r18, new l4(), new m4(), null, 64), r4.w);     // Catch: Exception -> L66
    L57:
        JSONObject r23 = new JSONObject();     // Catch: Exception -> L66
        r23.put("banner_host_id", r4.w);     // Catch: Exception -> L66
        if (r20 != null) goto L60;
        boolean r25 = true;
    L61:
        r23.put("activity_null", r25);     // Catch: Exception -> L66
        if (r2 != null) goto L64;
        r3 = true;
    L64:
        r23.put("title_container_null", r3);     // Catch: Exception -> L66
        Unit r26 = Unit.INSTANCE;     // Catch: Exception -> L66
        ObricUpdateComponent.D3("blocked", "context is null", r23);     // Catch: Exception -> L66
        goto L70
    L60:
        r25 = false;
        goto L61
    L43:
        r20 = null;
    L66:
        e = move-exception;
        FLogger.a.i("ObricUpdateComponent", "realShowUpdateBanner: " + e);
    L68:
        ObricUpdateComponent r27 = this.this$0;
        JSONObject r28 = new JSONObject();
        ObricUpdateComponent r29 = this.this$0;
        r28.put("screen_locked", String.valueOf(r11));
        r28.put("update_state", r1);
        r28.put("page_dismissed", r10);
        r28.put("banner_host_id", r29.w);
        r28.put("block_by_window_animation", r12);
        r28.put("block_by_side_bar", r16);
        Unit r30 = Unit.INSTANCE;
        r27.getClass();
        ObricUpdateComponent.D3("blocked", "banner_need_show_check_fail", r28);
        goto L70
    L26:
        if (r14.Ga() != true) goto L28;
        r15 = true;
    L32:
        r16 = true;
        goto L33
    L18:
        if (this.this$0.x == false) goto L20;
        r12 = true;
        goto L21
    L12:
        if (r1.intValue() != (-1)) goto L13;
        r5 = false;
        goto L15
    L7:
        r1 = null;
        goto L8
    L72:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
