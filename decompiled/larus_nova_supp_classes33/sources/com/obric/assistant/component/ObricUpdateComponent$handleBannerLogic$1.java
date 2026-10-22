package com.obric.assistant.component;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$handleBannerLogic$1", f = "ObricUpdateComponent.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUpdateComponent$handleBannerLogic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$handleBannerLogic$1(ObricUpdateComponent r1, Continuation<? super ObricUpdateComponent$handleBannerLogic$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricUpdateComponent$handleBannerLogic$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.assistant.component.t4] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        ObricUpdateComponent r12 = this.this$0;
        if (r12.z == true) goto L22;
        com.larus.bmhome.a0 r13 = r12.y;
        if (r13 != null) goto L16;
    L18:
        boolean r14 = false;
    L19:
        if (r14 == true) goto L22;
        boolean r15 = false;
    L24:
        if (r15 == false) goto L27;
        FLogger.a.i("ObricUpdateComponent", "handleBannerLogic blocked by side bar, hostId=" + this.this$0.w);
        ObricUpdateComponent r16 = this.this$0;
        JSONObject r3 = new JSONObject();
        r3.put("banner_host_id", this.this$0.w);
        Unit r4 = Unit.INSTANCE;
        r16.getClass();
        ObricUpdateComponent.D3("blocked", "side_bar_open", r3);
        return Unit.INSTANCE;
    L27:
        ObricFloatChatPageState r17 = this.this$0.getPageState();
        ObricUpdateComponent r5 = this.this$0;
        com.larus.bmhome.chat.component.collection.o r6 = (com.larus.bmhome.chat.component.collection.o) r5.o.getValue();
        if (r6 != null) goto L30;
    L32:
        boolean r7 = false;
    L33:
        Object r8 = null;
        if (r7 == true) goto L94;
        com.larus.bmhome.chat.component.showcase.x r9 = (com.larus.bmhome.chat.component.showcase.x) r5.p.getValue();
        if (r9 != null) goto L38;
    L40:
        boolean r10 = false;
    L41:
        if (r10 == true) goto L94;
        de8.c r18 = (de8.c) r5.q.getValue();
        if (r18 == null) goto L46;
        Bundle r19 = r18.b;
    L47:
        if (r19 != null) goto L49;
    L51:
        boolean r20 = false;
    L52:
        if (r20 == false) goto L54;
        FLogger.a.i("ObricUpdateComponent", "is create sub cvs, not main bot");
    L102:
        boolean r21 = false;
    L103:
        ObricFloatChatPageData.Companion.getClass();
        boolean r22 = r17 instanceof vda.a;
        int r23 = com.obric.assistant.util.m2.b + 10;
        if (r17.getHeight() >= r23) goto L106;
        boolean r24 = true;
    L107:
        if (r21 == false) goto L111;
        if (r22 == true) goto L111;
        if (r24 == false) goto L111;
    L112:
        FLogger.a.i("ObricUpdateComponent", "handleBannerLogic, hostId=" + this.this$0.w + ", shouldShowBanner=" + r2 + ", isMainBot=" + r21 + ", isChatWindow=" + r22 + ", pageState=" + r17 + ", height=" + r17.getHeight() + ", heightThreshold=" + r23);
        if (r2 == true) goto L117;
        ObricUpdateComponent r25 = this.this$0;
        JSONObject r26 = new JSONObject();
        ObricUpdateComponent r27 = this.this$0;
        r26.put("is_main_bot", r21);
        r26.put("is_chat_window", r22);
        r26.put("height", r17.getHeight());
        r26.put("height_threshold", r23);
        r26.put("banner_host_id", r27.w);
        Unit r110 = Unit.INSTANCE;
        r25.getClass();
        ObricUpdateComponent.D3("blocked", "banner_page_state_check_fail", r26);
        return Unit.INSTANCE;
    L117:
        if (com.obric.assistant.o.a == false) goto L119;
        MutableLiveData r111 = com.obric.assistant.h.a;
        final ObricUpdateComponent r28 = this.this$0;
        r111.observe(r28, new ObricUpdateComponent.d(new t4(r28)));
    L121:
        return Unit.INSTANCE;
    L119:
        ObricUpdateComponent.h3(this.this$0);
    L111:
        r2 = false;
        goto L112
    L106:
        r24 = false;
        goto L107
    L54:
        de8.c r29 = (de8.c) r5.q.getValue();
        if (r29 == null) goto L59;
        Bundle r30 = r29.b;
        if (r30 == null) goto L59;
        String r31 = r30.getString("argConversationId");
    L60:
        if (r31 != null) goto L62;
    L65:
        boolean r32 = true;
    L66:
        if (r32 == false) goto L69;
        r31 = null;
    L69:
        if (r31 != null) goto L76;
        de8.c r33 = (de8.c) r5.q.getValue();
        if (r33 == null) goto L75;
        Bundle r34 = r33.a;
        if (r34 == null) goto L75;
        r31 = r34.getString("argConversationId");
    L75:
        r31 = null;
    L76:
        IAuthModelService r35 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r35 == null) goto L81;
        LiveData r36 = r35.y();
        if (r36 == null) goto L81;
        wc9.e r37 = (wc9.e) r36.getValue();
    L82:
        if (r31 != null) goto L84;
    L87:
        boolean r38 = true;
    L88:
        if (r38 == true) goto L93;
        if (r37 == null) goto L92;
        r8 = r37.a;
    L92:
        if (Intrinsics.areEqual(r31, r8) == false) goto L102;
    L93:
        r21 = true;
        goto L103
    L84:
        if (r31.length() == 0) goto L87;
        r38 = false;
    L81:
        r37 = null;
        goto L82
    L62:
        if (r31.length() == 0) goto L65;
        r32 = false;
    L59:
        r31 = null;
        goto L60
    L49:
        if (r19.getBoolean("is_create_sub_conversation") != true) goto L51;
        r20 = true;
        goto L52
    L46:
        r19 = null;
        goto L47
    L38:
        if (r9.e6() != true) goto L40;
        r10 = true;
    L94:
        FLogger r39 = FLogger.a;
        StringBuilder r40 = new StringBuilder("is collect mode ");
        com.larus.bmhome.chat.component.collection.o r41 = (com.larus.bmhome.chat.component.collection.o) r5.o.getValue();
        if (r41 == null) goto L97;
        Boolean r42 = Boolean.valueOf(r41.i0());
    L98:
        r40.append(r42);
        r40.append(", is showcase mode ");
        com.larus.bmhome.chat.component.showcase.x r43 = (com.larus.bmhome.chat.component.showcase.x) r5.p.getValue();
        if (r43 == null) goto L101;
        r8 = Boolean.valueOf(r43.e6());
    L101:
        r40.append(r8);
        r39.i("ObricUpdateComponent", r40.toString());
        goto L102
    L97:
        r42 = null;
        goto L98
    L30:
        if (r6.i0() != true) goto L32;
        r7 = true;
        goto L33
    L16:
        if (r13.Ga() != true) goto L18;
        r14 = true;
    L22:
        r15 = true;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
