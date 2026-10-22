package com.obric.assistant.view;

import com.larus.common_ui.dialog.p0;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i0 implements p0 {
    public final /* synthetic */ Function0<Unit> a;

    public final void confirm() {
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L5;
        JSONObject r1 = new JSONObject();
        r1.put("source", "stop_download");
        r1.put("popup_type", "stop_download");
        r1.put("action_type", "click_stop_download");
        Unit r2 = Unit.INSTANCE;
        r0.h("obric_upgrade_popup_click", r1);
    L5:
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    }

    public i0(f0 r1) {
        this.a = r1;
    }
}
