package com.obric.oui.dialog.v2.misc;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/oui/progress/ODownloadProgressView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class StatusDialog$processView$2 extends Lambda implements Function0<ODownloadProgressView> {
    final /* synthetic */ c this$0;

    StatusDialog$processView$2(c r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ODownloadProgressView invoke() {
        return (ODownloadProgressView) ZeusTransformUtils.preCheckCast(this.this$0.findViewById(ZeusTransformUtils.mapRes(R.id.status_progress_view, OaidModel.KEY_ID, "status_progress_view")), ODownloadProgressView.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ODownloadProgressView invoke() {
        return invoke();
    }
}
