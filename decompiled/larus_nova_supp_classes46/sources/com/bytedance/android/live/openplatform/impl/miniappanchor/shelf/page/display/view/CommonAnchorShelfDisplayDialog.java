package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.CommonAnchorShelfDisplayViewModel;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/CommonAnchorShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/BaseAnchorShelfDisplayDialog;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonAnchorShelfDisplayDialog extends BaseAnchorShelfDisplayDialog {
    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final CommonShelfDisplayViewModel Z90() {
        return (CommonAnchorShelfDisplayViewModel) ViewModelProviders.of(this).get(CommonAnchorShelfDisplayViewModel.class);
    }

    public CommonAnchorShelfDisplayDialog() {
    }
}
