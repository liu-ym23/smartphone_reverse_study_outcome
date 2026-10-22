package com.larus.agents.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.bot.CommonSettingFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/agents/api/IOfficeTaskSettingsService;", "", "showSettingsPage", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "getPreferenceInstruction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePreferenceInstruction", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "instruction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IOfficeTaskSettingsService {
    Object a(String r1, Continuation<? super OfficeTaskPreferenceSaveResult> r2);

    void b(CommonSettingFragment r1);

    Object c(Continuation<? super String> r1);
}
