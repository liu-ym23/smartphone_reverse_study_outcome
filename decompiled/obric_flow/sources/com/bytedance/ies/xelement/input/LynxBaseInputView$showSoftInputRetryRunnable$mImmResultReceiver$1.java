package com.bytedance.ies.xelement.input;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.lynx.base.log.LynxLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/ies/xelement/input/LynxBaseInputView$showSoftInputRetryRunnable$mImmResultReceiver$1", "Landroid/os/ResultReceiver;", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxBaseInputView$showSoftInputRetryRunnable$mImmResultReceiver$1 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r5, Bundle r10) {
        if (r5 != 0) goto L5;
        LynxLog.b(2, "LynxBaseInputView", "input call keyboard with RESULT_UNCHANGED_SHOWN");
        return;
    L5:
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L8;
        LynxLog.b(2, "LynxBaseInputView", "input call keyboard with RESULT_SHOWN");
        return;
    L8:
        if (r5 == 3) goto L10;
        return;
    L10:
        LynxLog.b(2, "LynxBaseInputView", "input call keyboard with RESULT_HIDDEN");
        return;
    L14:
        LynxLog.b(2, "LynxBaseInputView", "input call keyboard with RESULT_UNCHANGED_HIDDEN");
    }
}
