package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.link.biz.service.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class MultiAudienceSeiComponent$logUILayoutChange$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $enlargeID;
    final /* synthetic */ UILayout $uiLayout;
    final /* synthetic */ MultiAudienceSeiComponent this$0;

    public MultiAudienceSeiComponent$logUILayoutChange$2(MultiAudienceSeiComponent r1, UILayout r2, String r3) {
        this.this$0 = r1;
        this.$uiLayout = r2;
        this.$enlargeID = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m870invoke() {
        MultiAudienceSeiComponent r0 = this.this$0;
        if (r0.i == true) goto L5;
        return;
    L5:
        i.B(r0).C(this.$uiLayout, this.$enlargeID, null);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m870invoke();
        return Unit.INSTANCE;
    }
}
