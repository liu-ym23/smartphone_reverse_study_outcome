package com.larus.doc.sdk.impl.v2.plugins.state;

import androidx.lifecycle.ViewModel;
import com.larus.doc.sdk.api.model.DocMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/DocStateModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_docMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/doc/sdk/api/model/DocMode;", "docMode", "Lkotlinx/coroutines/flow/StateFlow;", "getDocMode", "()Lkotlinx/coroutines/flow/StateFlow;", "setDocMode", "(Lkotlinx/coroutines/flow/StateFlow;)V", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocStateModel extends ViewModel {
    private z0<DocMode> _docMode;
    private i1<? extends DocMode> docMode;

    public DocStateModel() {
        StateFlowImpl r0 = j1.a(DocMode.READ_ONLY);
        this._docMode = r0;
        this.docMode = e.b(r0);
    }

    public final i1<DocMode> getDocMode() {
        return this.docMode;
    }

    public final void setDocMode(DocMode r2) {
        Intrinsics.checkNotNullParameter(r2, "docMode");
        this._docMode.tryEmit(r2);
    }

    public final void setDocMode(i1<? extends DocMode> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docMode = r2;
    }
}
