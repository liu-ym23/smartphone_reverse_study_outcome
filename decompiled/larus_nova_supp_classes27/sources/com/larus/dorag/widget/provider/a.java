package com.larus.dorag.widget.provider;

import com.larus.dorag.widget.f;
import com.larus.dorag.widget.model.DoraWidgetEntryContent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ DoraWidgetEntryContent a;

    public /* synthetic */ a(DoraWidgetEntryContent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        DoraWidgetEntryContent r0 = this.a;
        DoraWidgetDiaryProvider$a.a r1 = DoraWidgetDiaryProvider.a;
        return "applyDeviceStatus, isConnected=" + r0.isConnected() + ", isConnectedAfterLogin=" + f.b;
    }
}
