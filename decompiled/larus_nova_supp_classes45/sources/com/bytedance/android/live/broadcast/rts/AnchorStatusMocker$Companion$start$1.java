package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.m;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorStatusMocker$Companion$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2 $onStatusPanelMessage;

    public AnchorStatusMocker$Companion$start$1(Function2 r1) {
        this.$onStatusPanelMessage = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m71invoke() {
        LinkedHashMap r0 = new LinkedHashMap();
        m.e(r0, "tab_key", "some_tab_key_panel_msg");
        m.e(r0, "content", "some_content_panel_msg");
        this.$onStatusPanelMessage.invoke("tab-1", r0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m71invoke();
        return Unit.INSTANCE;
    }
}
