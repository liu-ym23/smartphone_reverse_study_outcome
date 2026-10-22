package com.obric.assistant.settings.memory;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.SelectableToggleItem;
import com.obric.assistant.settings.ToggleName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1", f = "ObricPersonalContextSettingFragment.kt", i = {0, 0}, l = {399}, m = "invokeSuspend", n = {"safeContext", "toggleList"}, s = {"L$0", "L$1"})
final class ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceRefresh;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricPersonalContextSettingFragment this$0;

    public ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1(ObricPersonalContextSettingFragment r1, boolean r2, Continuation<? super ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1> r3) {
        this.this$0 = r1;
        this.$forceRefresh = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1 r0 = new ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1(this.this$0, this.$forceRefresh, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.settings.memory.u] */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        List r3 = (List) this.L$1;
        Context r4 = (Context) this.L$0;
        ResultKt.throwOnFailure(r12);
        List r5 = r3;
    L28:
        if (((Boolean) r12).booleanValue() != true) goto L30;
        final List r13 = r5;
        r2 = true;
    L31:
        if (r2 == false) goto L35;
        ObricPersonalContextSettingFragment r6 = this.this$0;
        int r7 = ObricPersonalContextSettingFragment.l;
        ObricPersonalContextSettingApiDelegate r8 = r6.U90();
        ToggleName r9 = ToggleName.AI_DIARY;
        if (r8.o(r9) == true) goto L35;
        r13.add(new SelectableToggleItem(r9, r4.getString(2131912146), r4.getString(2131912129), null, 24));
    L35:
        ObricPersonalContextSettingFragment r10 = this.this$0;
        int r11 = ObricPersonalContextSettingFragment.l;
        ObricPersonalContextSettingApiDelegate r14 = r10.U90();
        ToggleName r15 = ToggleName.GLOBAL_MEMORY;
        if (r14.o(r15) == true) goto L39;
        r13.add(new SelectableToggleItem(r15, r4.getString(2131912160), r4.getString(2131912137), null, 24));
    L39:
        if (r13.isEmpty() == true) goto L41;
        FragmentActivity r16 = this.this$0.getActivity();
        if (r16 == null) goto L51;
        final ObricPersonalContextSettingFragment r17 = this.this$0;
        LiveData r18 = r17.U90().k(r16, r13);
        if (r18 == null) goto L51;
        r18.observe(r16, new ObricPersonalContextSettingFragment.c(new u(r13, r17)));
    L51:
        return Unit.INSTANCE;
    L41:
        if (this.$forceRefresh == false) goto L44;
        this.this$0.V90().refresh();
    L44:
        return Unit.INSTANCE;
    L30:
        r13 = r5;
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        r4 = this.this$0.getContext();
        if (r4 != null) goto L12;
        FLogger.a.w("ObricPersonalContextSettingFragment", "tryRequestMultiCustomPermission, fragment is detached");
        return Unit.INSTANCE;
    L12:
        ArrayList r110 = new ArrayList();
        ObricPersonalContextSettingFragment r20 = this.this$0;
        int r21 = ObricPersonalContextSettingFragment.l;
        ObricPersonalContextSettingApiDelegate r22 = r20.U90();
        ToggleName r23 = ToggleName.NOTES;
        if (r22.o(r23) == true) goto L15;
        String r24 = tga.b.a();
        r110.add(new SelectableToggleItem(r23, r24, this.this$0.getString(2131912139, new Object[]{r24}), null, 24));
    L15:
        ObricPersonalContextSettingApiDelegate r25 = this.this$0.U90();
        ToggleName r26 = ToggleName.CLOCK;
        if (r25.o(r26) == true) goto L18;
        r110.add(new SelectableToggleItem(r26, r4.getString(2131912152), r4.getString(2131912134), null, 24));
    L18:
        ObricPersonalContextSettingApiDelegate r27 = this.this$0.U90();
        ToggleName r28 = ToggleName.RECORD;
        if (r27.o(r28) == true) goto L21;
        r110.add(new SelectableToggleItem(r28, r4.getString(2131912170), r4.getString(2131912140), null, 24));
    L21:
        IAILabService r29 = (IAILabService) this.this$0.g.getValue();
        r13 = r110;
        if (r29 == null) goto L31;
        AILabSettingItem r30 = AILabSettingItem.ScreenMemory;
        this.L$0 = r4;
        this.L$1 = r110;
        this.label = 1;
        Object r31 = r29.b(r30, this);
        if (r31 != r0) goto L26;
        return r0;
    L26:
        r5 = r110;
        r12 = r31;
        goto L28
    }
}
