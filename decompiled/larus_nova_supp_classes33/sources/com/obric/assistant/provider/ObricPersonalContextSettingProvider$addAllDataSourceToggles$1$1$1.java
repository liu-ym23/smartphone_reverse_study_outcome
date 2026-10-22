package com.obric.assistant.provider;

import android.database.MatrixCursor;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1", f = "ObricPersonalContextSettingProvider.kt", i = {0}, l = {159, 168}, m = "invokeSuspend", n = {"aiLabService"}, s = {"L$0"})
final class ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricPersonalContextSettingApiDelegate $it;
    final /* synthetic */ boolean $oldMemorySwitch;
    final /* synthetic */ MatrixCursor $this_apply;
    Object L$0;
    int label;

    public ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1(MatrixCursor r1, ObricPersonalContextSettingApiDelegate r2, boolean r3, Continuation<? super ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1> r4) {
        this.$this_apply = r1;
        this.$it = r2;
        this.$oldMemorySwitch = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1(this.$this_apply, this.$it, this.$oldMemorySwitch, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L27:
        if (((Boolean) r11).booleanValue() != true) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L32;
        MatrixCursor r13 = this.$this_apply;
        ToggleName r2 = ToggleName.HEARING_MEMORY;
        r13.addRow(new String[]{r2.getToggleName(), String.valueOf(this.$it.j(r2, this.$oldMemorySwitch))});
    L34:
        return Unit.INSTANCE;
    L32:
        this.$this_apply.addRow(new String[]{ToggleName.HEARING_MEMORY.getToggleName(), "false"});
    L29:
        r12 = false;
        goto L30
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        IAILabService r3 = (IAILabService) this.L$0;
        ResultKt.throwOnFailure(r11);
    L16:
        if (((Boolean) r11).booleanValue() != true) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L21;
        MatrixCursor r15 = this.$this_apply;
        ToggleName r7 = ToggleName.SCREEN_MEMORY;
        r15.addRow(new String[]{r7.getToggleName(), String.valueOf(this.$it.j(r7, this.$oldMemorySwitch))});
        MatrixCursor r16 = this.$this_apply;
        ToggleName r8 = ToggleName.AI_DIARY;
        r16.addRow(new String[]{r8.getToggleName(), String.valueOf(this.$it.j(r8, true))});
    L22:
        if (r3 == null) goto L29;
        AILabSettingItem r17 = AILabSettingItem.VoiceMemory;
        this.L$0 = null;
        this.label = 2;
        r11 = r3.b(r17, this);
        if (r11 != r0) goto L27;
        return r0;
    L21:
        this.$this_apply.addRow(new String[]{ToggleName.SCREEN_MEMORY.getToggleName(), "false"});
        this.$this_apply.addRow(new String[]{ToggleName.AI_DIARY.getToggleName(), "false"});
    L18:
        r14 = false;
        goto L19
    L10:
        ResultKt.throwOnFailure(r11);
        r3 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        MatrixCursor r18 = this.$this_apply;
        ToggleName r9 = ToggleName.GLOBAL_MEMORY;
        r18.addRow(new String[]{r9.getToggleName(), String.valueOf(this.$it.j(r9, false))});
        if (r3 == null) goto L18;
        AILabSettingItem r19 = AILabSettingItem.ScreenMemory;
        this.L$0 = r3;
        this.label = 1;
        r11 = r3.b(r19, this);
        if (r11 != r0) goto L16;
        return r0;
    }
}
