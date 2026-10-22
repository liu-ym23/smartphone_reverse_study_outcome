package com.larus.agents.impl.service;

import android.content.Context;
import android.content.Intent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.agents.api.IOfficeTaskSettingsService;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.impl.settings.DefaultOfficeTaskPreferenceRepository;
import com.larus.agents.impl.settings.b;
import com.larus.agents.impl.ui.OfficeTaskSettingsActivity;
import com.larus.bmhome.bot.CommonSettingFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/agents/impl/service/OfficeTaskSettingsServiceImpl;", "Lcom/larus/agents/api/IOfficeTaskSettingsService;", "<init>", "()V", "repository", "Lcom/larus/agents/impl/settings/OfficeTaskPreferenceRepository;", "showSettingsPage", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "getPreferenceInstruction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePreferenceInstruction", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "instruction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskSettingsServiceImpl implements IOfficeTaskSettingsService {
    public final DefaultOfficeTaskPreferenceRepository a;

    public OfficeTaskSettingsServiceImpl() {
        this.a = new DefaultOfficeTaskPreferenceRepository(0);
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final void b(CommonSettingFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "hostFragment");
        Context r0 = r4.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        r4.startActivity(new Intent(r0, OfficeTaskSettingsActivity.class));
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object c(Continuation<? super String> r5) {
        if ((r5 instanceof OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1) == false) goto L7;
        OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1 r0 = (OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1) r5;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L18:
        return ((b) r6).a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        DefaultOfficeTaskPreferenceRepository r7 = this.a;
        r0.label = 1;
        r6 = r7.a(r0);
        if (r6 != r2) goto L18;
        return r2;
    L7:
        r0 = new OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1(this, r5);
        goto L8
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object a(String r2, Continuation<? super OfficeTaskPreferenceSaveResult> r3) {
        return this.a.b(r2, r3);
    }
}
