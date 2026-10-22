package com.obric.oui.dialog.v2.selection;

import android.view.ViewGroup;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSelectionDialogModal$bodyContainerView$2 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ b this$0;

    OSelectionDialogModal$bodyContainerView$2(b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        return (ViewGroup) ZeusTransformUtils.preCheckCast(this.this$0.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_body_container, OaidModel.KEY_ID, "selection_dialog_body_container")), ViewGroup.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }
}
