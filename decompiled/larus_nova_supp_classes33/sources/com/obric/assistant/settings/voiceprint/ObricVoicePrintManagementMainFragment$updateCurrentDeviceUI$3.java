package com.obric.assistant.settings.voiceprint;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentVoicePrintManagementBinding;
import com.obric.assistant.spi.dora.ObricVendorBluetoothQueryDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceTypeEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueProductIdEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.oui.lisitem.OCardListItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3", f = "ObricVoicePrintManagementMainFragment.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {535, 573}, m = "invokeSuspend", n = {"vb", "context", "vb", "context", "macId", "deviceName", "blueDeviceType", "blueProductId", "currentDeviceIconRes"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"})
final class ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ObricVoicePrintManagementMainFragment this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$1", f = "ObricVoicePrintManagementMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r5);
            AtomicBoolean r6 = a.a;
            CoWakeupApi r7 = uha.a.a();
            boolean r0 = true;
            if (r7 != null) goto L7;
        L9:
            boolean r8 = false;
        L10:
            if (r8 == false) goto L12;
            a.b.set(null);
            a.a.set(false);
        L26:
            return Unit.INSTANCE;
        L12:
            lga.a r9 = ObricVendorBluetoothQueryDelegate.b.a();
            a.b.set(r9);
            AtomicBoolean r2 = a.a;
            if (r9 != null) goto L15;
        L23:
            r0 = false;
        L24:
            r2.set(r0);
            goto L26
        L15:
            if (r9.b == false) goto L17;
        L20:
            boolean r10 = true;
        L21:
            if (r10 != true) goto L23;
        L17:
            if (r9.c == true) goto L20;
            r10 = false;
            goto L21
        L7:
            if (r7.b() != true) goto L9;
            r8 = true;
            goto L10
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3(ObricVoicePrintManagementMainFragment r1, Continuation<? super ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Activity r5 = null;
        boolean r6 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$2;
        int r4 = this.I$1;
        int r7 = this.I$0;
        String r8 = (String) this.L$3;
        final String r9 = (String) this.L$2;
        Context r10 = (Context) this.L$1;
        ObricFragmentVoicePrintManagementBinding r11 = (ObricFragmentVoicePrintManagementBinding) this.L$0;
        ResultKt.throwOnFailure(r26);
        final int r12 = r4;
        Context r13 = r10;
        ObricFragmentVoicePrintManagementBinding r14 = r11;
        final int r15 = r7;
        final String r16 = r8;
        Object r17 = r26;
    L109:
        Boolean r18 = (Boolean) r17;
        IBluetoothHeadSetAPI r19 = tha.c.a();
        if (r19 == null) goto L112;
        int r20 = r19.j();
    L113:
        IBluetoothHeadSetAPI r21 = tha.c.a();
        if (r21 == null) goto L116;
        boolean r22 = r21.b();
    L117:
        if (r20 <= 1) goto L120;
        if (r22 == true) goto L120;
        boolean r23 = true;
    L122:
        if (Intrinsics.areEqual(r18, Boxing.boxBoolean(true)) == true) goto L147;
        if (r9 == null) goto L147;
        if (r16 != null) goto L126;
    L129:
        boolean r24 = true;
    L130:
        if (r24 == true) goto L147;
        if (r23 == true) goto L147;
        if (Intrinsics.areEqual(this.this$0.g, Boxing.boxBoolean(true)) == true) goto L136;
    L139:
        this.this$0.g = Boxing.boxBoolean(true);
        this.this$0.h = r9;
        Boxing.boxInt(r3);
        r14.f.setVisibility(0);
        r14.c.removeAllViews();
        Intrinsics.checkNotNull(r13);
        View r25 = new OCardListItem(r13, null, 6, 0);
        final ObricVoicePrintManagementMainFragment r27 = this.this$0;
        r25.setTitle(r16);
        r25.setIcon(r3);
        r25.p(true);
        r25.setCardType(0);
        OCardListItem.h(r25, 0);
        if (r27.k == true) goto L142;
        rda.a.a(r25, 0);
    L142:
        r25.q(false);
        r25.r(false);
        r25.setCustomEndView(LayoutInflater.from(r13).inflate(2131561715, null));
        View r28 = r25.getCustomEndView();
        if (r28 == null) goto L145;
        r28.setOnClickListener(new q(r27, r9, r16, r15, r12));
    L145:
        r25.m(true);
        r14.c.addView(r25);
        return Boxing.boxBoolean(true);
    L136:
        if (Intrinsics.areEqual(this.this$0.h, r9) == false) goto L139;
        return Boxing.boxBoolean(true);
    L126:
        if (r16.length() == 0) goto L129;
        r24 = false;
    L147:
        if (r23 == false) goto L157;
        Activity r29 = this.this$0.getActivity();
        if (r29 == null) goto L152;
        r5 = r29;
    L154:
        if (r5 == null) goto L156;
        com.obric.oui.toast.f r30 = new com.obric.oui.toast.f(r5, r5.getString(2131912697), 0, false, null, 0, 60);
        r30.g.f = 3500;
        r30.c();
    L156:
        FLogger.a.i("ObricVoicePrintManagementMainFragment", "get bluetooth headset count " + r20);
        goto L157
    L152:
        if ((r13 instanceof Activity) == false) goto L154;
        r5 = (Activity) r13;
    L157:
        if (r16 != null) goto L159;
    L162:
        if (r6 == false) goto L164;
        FLogger.a.i("ObricVoicePrintManagementMainFragment", "get bluetooth headset name failed");
    L164:
        if (r9 != null) goto L167;
        FLogger.a.i("ObricVoicePrintManagementMainFragment", "get bluetooth headset address failed");
    L167:
        if (Intrinsics.areEqual(this.this$0.g, Boxing.boxBoolean(false)) == true) goto L169;
        ObricVoicePrintManagementMainFragment.V90(this.this$0, r14);
        return Boxing.boxBoolean(false);
    L169:
        return Boxing.boxBoolean(false);
    L159:
        if (r16.length() == 0) goto L162;
        r6 = false;
    L120:
        r23 = false;
        goto L122
    L116:
        r22 = false;
        goto L117
    L112:
        r20 = 0;
        goto L113
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Context r31 = (Context) this.L$1;
        ObricFragmentVoicePrintManagementBinding r32 = (ObricFragmentVoicePrintManagementBinding) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object r33 = r26;
        Context r110 = r31;
        ObricFragmentVoicePrintManagementBinding r111 = r32;
    L18:
        boolean r34 = ((Boolean) r33).booleanValue();
        IBluetoothHeadSetAPI r35 = tha.c.a();
        if (r35 != null) goto L21;
    L23:
        boolean r36 = false;
    L24:
        if (r36 == false) goto L27;
        if (r34 == false) goto L27;
        boolean r37 = true;
    L28:
        if (r37 == false) goto L30;
        BuildersKt.launch$default(ObricVoicePrintManagementMainFragment.l, null, null, new AnonymousClass1(null), 3, null);
        IBluetoothHeadSetAPI r38 = tha.c.a();
        if (r38 == null) goto L38;
        BluetoothDevice r39 = r38.g();
    L39:
        this.this$0.getClass();
        IDoraService r40 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r40 == null) goto L42;
        DeviceService r41 = r40.device();
    L43:
        if (r41 == null) goto L47;
        String r42 = r41.n();
        if ((!StringsKt.isBlank(r42)) == false) goto L47;
    L48:
        if (r39 == null) goto L50;
        String r112 = r39.getAddress();
    L51:
        boolean r43 = StringsKt.equals(r42, r112, true);
        if (r41 != null) goto L54;
    L56:
        boolean r113 = false;
    L57:
        if (r41 != null) goto L59;
    L61:
        boolean r44 = false;
    L62:
        FLogger r114 = FLogger.a;
        r114.i("ObricVoicePrintManagementMainFragment", "isDoraGWearOnDevice isDoraG=" + r113 + ", isDoraGWearOn=" + r44 + ", isSameDevice=" + r43);
        if (r113 == false) goto L67;
        if (r44 == false) goto L67;
        if (r43 == false) goto L67;
        boolean r45 = true;
    L68:
        if (r45 == false) goto L75;
        r114.i("ObricVoicePrintManagementMainFragment", "hide current device because current active device is worn Dora-G");
        if (Intrinsics.areEqual(this.this$0.g, Boxing.boxBoolean(false)) == true) goto L72;
        ObricVoicePrintManagementMainFragment.V90(this.this$0, r111);
        return Boxing.boxBoolean(false);
    L72:
        return Boxing.boxBoolean(false);
    L75:
        IBluetoothHeadSetAPI r46 = tha.c.a();
        if (r46 == null) goto L85;
        if (r39 == null) goto L83;
        String r47 = r39.getAddress();
        if (r47 == null) goto L83;
        if ((!StringsKt.isBlank(r47)) == false) goto L83;
    L84:
        r9 = r46.s(r47);
    L86:
        if (r39 == null) goto L92;
        String r48 = r39.getName();
        if (r48 == null) goto L92;
        if ((!StringsKt.isBlank(r48)) == false) goto L92;
    L93:
        IBluetoothHeadSetAPI r115 = tha.c.a();
        if (r115 == null) goto L98;
        BlueDeviceTypeEnum r116 = r115.e(r39);
        if (r116 == null) goto L98;
        int r117 = r116.getValue();
    L99:
        IBluetoothHeadSetAPI r118 = tha.c.a();
        if (r118 == null) goto L104;
        BlueProductIdEnum r49 = r118.q(r39);
        if (r49 == null) goto L104;
        int r50 = r49.getValue();
    L105:
        StringBuilder r119 = new StringBuilder("currentDevice blueDeviceType=");
        BlueDeviceTypeEnum.Companion.getClass();
        r119.append(BlueDeviceTypeEnum.a.a(r117).name());
        r119.append('(');
        r119.append(r117);
        r119.append(") blueProductId=");
        BlueProductIdEnum.Companion.getClass();
        r119.append(BlueProductIdEnum.a.a(r50).name());
        r119.append('(');
        r119.append(r50);
        r119.append(") ");
        r114.i("ObricVoicePrintManagementMainFragment", r119.toString());
        this.this$0.getClass();
        int r51 = ObricVoicePrintManagementMainFragment.X90(r117, r50);
        CoroutineDispatcher r120 = Dispatchers.getIO();
        ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1 r121 = new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1(r9, null);
        this.L$0 = r111;
        this.L$1 = r110;
        this.L$2 = r9;
        this.L$3 = r48;
        this.I$0 = r117;
        this.I$1 = r50;
        this.I$2 = r51;
        this.label = 2;
        r17 = BuildersKt.withContext(r120, r121, this);
        if (r17 != r1) goto L108;
        return r1;
    L108:
        r3 = r51;
        r14 = r111;
        r15 = r117;
        r12 = r50;
        r13 = r110;
        r16 = r48;
    L104:
        r50 = 0;
    L98:
        r117 = 0;
    L92:
        r48 = null;
    L83:
        r47 = null;
        goto L84
    L85:
        r9 = null;
    L67:
        r45 = false;
        goto L68
    L59:
        if (r41.S() != true) goto L61;
        r44 = true;
        goto L62
    L54:
        if (r41.M() != true) goto L56;
        r113 = true;
        goto L57
    L50:
        r112 = null;
    L47:
        r42 = null;
        goto L48
    L42:
        r41 = null;
        goto L43
    L38:
        r39 = null;
        goto L39
    L30:
        if (Intrinsics.areEqual(this.this$0.g, Boxing.boxBoolean(false)) == true) goto L32;
        ObricVoicePrintManagementMainFragment.V90(this.this$0, r111);
        return Boxing.boxBoolean(false);
    L32:
        return Boxing.boxBoolean(false);
    L27:
        r37 = false;
        goto L28
    L21:
        if (r35.a() != true) goto L23;
        r36 = true;
        goto L24
    L10:
        ResultKt.throwOnFailure(r26);
        ObricFragmentVoicePrintManagementBinding r52 = this.this$0.e;
        if (r52 == null) goto L13;
        Context r53 = r52.a.getContext();
        CoroutineDispatcher r54 = Dispatchers.getIO();
        ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$voicePrintExisted$1 r122 = new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$voicePrintExisted$1(null);
        this.L$0 = r52;
        this.L$1 = r53;
        this.label = 1;
        r33 = BuildersKt.withContext(r54, r122, this);
        if (r33 != r1) goto L17;
        return r1;
    L17:
        r111 = r52;
        r110 = r53;
        goto L18
    L13:
        return Boxing.boxBoolean(false);
    }
}
