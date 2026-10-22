package com.larus.agents.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.bot.CommonSettingFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/agents/api/OfficeTaskSettingsServiceNoop;", "Lcom/larus/agents/api/IOfficeTaskSettingsService;", "<init>", "()V", "showSettingsPage", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "getPreferenceInstruction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePreferenceInstruction", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "instruction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskSettingsServiceNoop implements IOfficeTaskSettingsService {
    public OfficeTaskSettingsServiceNoop() {
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final void b(CommonSettingFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object c(Continuation<? super String> r1) {
        return "";
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object a(String r1, Continuation<? super OfficeTaskPreferenceSaveResult> r2) {
        return OfficeTaskPreferenceSaveResult.FAILURE;
    }
}
