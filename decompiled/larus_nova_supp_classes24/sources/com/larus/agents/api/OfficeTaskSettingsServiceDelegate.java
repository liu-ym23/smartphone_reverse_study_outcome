package com.larus.agents.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/larus/agents/api/OfficeTaskSettingsServiceDelegate;", "Lcom/larus/agents/api/IOfficeTaskSettingsService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/agents/api/IOfficeTaskSettingsService;", "showSettingsPage", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "getPreferenceInstruction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePreferenceInstruction", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "instruction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskSettingsServiceDelegate implements IOfficeTaskSettingsService {
    public static final OfficeTaskSettingsServiceDelegate a = null;

    static {
        a = new OfficeTaskSettingsServiceDelegate();
    }

    private OfficeTaskSettingsServiceDelegate() {
    }

    public static IOfficeTaskSettingsService d() {
        IOfficeTaskSettingsService r0 = (IOfficeTaskSettingsService) ServiceManager.get().getService(IOfficeTaskSettingsService.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new OfficeTaskSettingsServiceNoop();
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final void b(CommonSettingFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        d().b(r2);
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object c(Continuation<? super String> r2) {
        return d().c(r2);
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object a(String r2, Continuation<? super OfficeTaskPreferenceSaveResult> r3) {
        return d().a(r2, r3);
    }
}
