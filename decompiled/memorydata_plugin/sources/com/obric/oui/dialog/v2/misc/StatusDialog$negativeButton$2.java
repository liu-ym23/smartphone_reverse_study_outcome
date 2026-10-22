package com.obric.oui.dialog.v2.misc;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class StatusDialog$negativeButton$2 extends Lambda implements Function0<OButton> {
    final /* synthetic */ c this$0;

    StatusDialog$negativeButton$2(c r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final OButton invoke() {
        return (OButton) ZeusTransformUtils.preCheckCast(this.this$0.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, OaidModel.KEY_ID, "actionNegative")), OButton.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ OButton invoke() {
        return invoke();
    }
}
