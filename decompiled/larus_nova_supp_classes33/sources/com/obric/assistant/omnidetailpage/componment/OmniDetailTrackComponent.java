package com.obric.assistant.omnidetailpage.componment;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailTrackComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailTrackAbility;", "<init>", "()V", "traceInfo", "Landroid/os/Bundle;", "hasReportedShow", "", "omniParam", "Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "getOmniParam", "()Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "omniParam$delegate", "Lkotlin/Lazy;", "onAttach", "", "onParentViewCreated", "reportItemClick", "itemName", "", "reportStopClick", "reportShowEvent", "getTraceInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findCurrentMessage", "Lcom/larus/im/bean/message/Message;", "getInstructionType", "message", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailTrackComponent extends ComponentFeature implements e {
    public static final /* synthetic */ int k = 0;
    public Bundle h;
    public boolean i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final void B2() {
        if (this.i == true) goto L7;
        this.i = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportShowEvent$1(this, null), 3, null);
        return;
    }

    public final ifa.e P2() {
        return (ifa.e) this.j.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, e.class);
    }

    public OmniDetailTrackComponent() {
        this.j = LazyKt.lazy(new b0(this));
    }

    @Override // com.obric.assistant.omnidetailpage.componment.e
    public final void Hy() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportStopClick$1(this, null), 3, null);
    }

    public final Object L2(Continuation<? super Message> r5) {
        ifa.e r0 = P2();
        if (r0 == null) goto L17;
        String r1 = r0.e;
        if (r1 == null) goto L17;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L17;
        return BuildersKt.withContext(Dispatchers.getIO(), new OmniDetailTrackComponent$findCurrentMessage$2(r1, null), r5);
    L9:
        r2 = false;
    L17:
        return null;
    }

    public final String N2(Message r5) {
        ifa.e r0 = P2();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.h;
    L6:
        String r3 = "";
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        if (r2.length() != 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L28;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r6 == null) goto L20;
        String r7 = r6.getString("o_omni_instruction_type");
        if (r7 == null) goto L20;
        r3 = r7;
    L27:
        r2 = r3;
    L20:
        if (r5 == null) goto L24;
        Map r8 = r5.getExt();
        if (r8 == null) goto L24;
        r1 = (String) r8.get("o_omni_instruction_type");
    L24:
        if (r1 == null) goto L27;
        r3 = r1;
    L28:
        ifa.e r9 = P2();
        if (r9 == null) goto L31;
        r9.h = r2;
    L31:
        return r2;
    L12:
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.assistant.omnidetailpage.componment.e
    public final void ho(String r8) {
        Intrinsics.checkNotNullParameter(r8, "itemName");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportItemClick$1(this, r8, null), 3, null);
    }

    public static final Object F2(OmniDetailTrackComponent r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof OmniDetailTrackComponent$getTraceInfo$1) == false) goto L7;
        OmniDetailTrackComponent$getTraceInfo$1 r0 = (OmniDetailTrackComponent$getTraceInfo$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        String r7 = null;
        String r8 = "";
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r5 = (String) r0.L$3;
        String r6 = (String) r0.L$2;
        String r9 = (String) r0.L$1;
        Message r10 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L59:
        List r17 = (List) r16;
        if (r17 == null) goto L62;
        String r18 = (String) CollectionsKt.firstOrNull(r17);
        String r11 = r6;
        String r12 = r9;
        String r13 = r5;
    L64:
        if (r18 != null) goto L66;
        String r19 = "";
    L67:
        Message r110 = r10;
    L68:
        ifa.e r20 = r14.P2();
        if (r20 == null) goto L71;
        String r21 = r20.g;
    L72:
        if (r21 != null) goto L75;
        r21 = "";
    L75:
        if (r21.length() != 0) goto L77;
        r4 = true;
    L77:
        if (r4 == false) goto L85;
        if (r110 == null) goto L82;
        Map r22 = r110.getExt();
        if (r22 == null) goto L82;
        r21 = (String) r22.get("o_instruction_entry");
    L83:
        if (r21 != null) goto L85;
        r21 = "";
    L82:
        r21 = null;
    L85:
        r14.N2(r110);
        FLogger r23 = FLogger.a;
        r23.i("OmniDetailTrackComponent", "instructionId = " + r12);
        r23.i("OmniDetailTrackComponent", "referenceMessageId = " + r11);
        r23.i("OmniDetailTrackComponent", "botId = ".concat(r19));
        r23.i("OmniDetailTrackComponent", "enterMethod = ".concat(r21));
        StringBuilder r24 = new StringBuilder("extra = ");
        if (r110 == null) goto L90;
        Map r25 = r110.getExt();
        if (r25 == null) goto L90;
        String r26 = r25.toString();
    L91:
        r24.append(r26);
        r23.i("OmniDetailTrackComponent", r24.toString());
        Bundle r27 = new Bundle();
        if (r110 == null) goto L97;
        String r111 = com.larus.im.bean.message.a.x(r110);
        if (r111 == null) goto L97;
        r8 = r111;
    L97:
        r27.putString("log_id", r8);
        r27.putString("instruction_id", r12);
        r27.putString("message_id", r11);
        r27.putString("bot_id", r19);
        r27.putString("enter_method", r21);
        r27.putString("device_id", com.larus.platform.service.o.a.getDeviceId());
        ifa.e r112 = r14.P2();
        if (r112 == null) goto L100;
        r7 = r112.e;
    L100:
        r27.putString("cur_msg_id", r7);
        r27.putString("action_type", r13);
        r14.h = new Bundle(r27);
        return r27;
    L90:
        r26 = null;
        goto L91
    L71:
        r21 = null;
        goto L72
    L66:
        r19 = r18;
        goto L67
    L62:
        r110 = r10;
        r11 = r6;
        r12 = r9;
        r13 = r5;
    L63:
        r10 = r110;
        r18 = null;
        goto L64
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
    L22:
        r110 = (Message) r16;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Bundle r28 = com.larus.ui.arch.component.internal.attach.a.b(r14, r14).getArguments();
        if (r28 == null) goto L26;
        r12 = r28.getString("task_id");
        if (r12 == null) goto L26;
    L29:
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Bundle r113 = com.larus.ui.arch.component.internal.attach.a.b(r14, r14).getArguments();
        if (r113 == null) goto L33;
        r11 = r113.getString("o_reference_msg_id");
        if (r11 == null) goto L33;
    L36:
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Bundle r29 = com.larus.ui.arch.component.internal.attach.a.b(r14, r14).getArguments();
        if (r29 == null) goto L40;
        r13 = r29.getString("action_type");
        if (r13 == null) goto L40;
    L41:
        ifa.e r114 = r14.P2();
        if (r114 == null) goto L44;
        r19 = r114.f;
    L45:
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        if (r19.length() != 0) goto L50;
        boolean r115 = true;
    L51:
        if (r115 == false) goto L68;
        if (r110 == null) goto L63;
        String r116 = r110.getConversationId();
        if (r116 == null) goto L63;
        r0.L$0 = r110;
        r0.L$1 = r12;
        r0.L$2 = r11;
        r0.L$3 = r13;
        r0.label = 2;
        Object r30 = ic8.n.b(r116, r0);
        if (r30 == r2) goto L104;
        r5 = r13;
        r9 = r12;
        r6 = r11;
        r10 = r110;
        r16 = r30;
        goto L59
    L104:
        return r2;
    L50:
        r115 = false;
        goto L51
    L44:
        r19 = null;
    L40:
        r13 = "";
    L33:
        if (r110 == null) goto L35;
        r11 = com.obric.assistant.utils.k.a(r110);
        goto L36
    L35:
        r11 = "";
    L26:
        if (r110 == null) goto L28;
        r12 = com.obric.assistant.utils.k.b(r110);
        goto L29
    L28:
        r12 = "";
        goto L29
    L16:
        ResultKt.throwOnFailure(r16);
        Bundle r117 = r14.h;
        if (r117 != null) goto L102;
        r0.label = 1;
        r16 = r14.L2(r0);
        if (r16 != r2) goto L22;
        return r2;
    L102:
        return new Bundle(r117);
    L7:
        r0 = new OmniDetailTrackComponent$getTraceInfo$1(r14, r15);
        goto L8
    }
}
