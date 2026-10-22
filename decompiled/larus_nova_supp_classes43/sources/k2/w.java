package k2;

import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w implements AppletPopup.b {
    public final /* synthetic */ AppletPopupSchemaParam a;

    public w(AppletPopupSchemaParam r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.view.popup.AppletPopup.b
    public final void a(AppletPopup r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        com.bytedance.ai.utils.g.a.d("WebViewPopupPageV2", "onFragmentCreated");
        AppletPopupSchemaParam r0 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "schemaParam");
        r10.m = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r0 = null;
    L5:
        r10.K = r0.getShowMask();
    }
}
