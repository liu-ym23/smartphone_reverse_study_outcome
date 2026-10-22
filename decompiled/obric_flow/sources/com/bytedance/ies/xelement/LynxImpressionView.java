package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/LynxImpressionView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/ui/view/b;", "", "index", "", "impressionPercent", "(I)V", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxImpressionView extends UISimpleView<b> {
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Log.d("LynxImpressionView", "createView");
        return new b(r5);
    }

    @c0(defaultInt = 0, name = "impression-percent")
    public void impressionPercent(int r5) {
        Log.d("LynxImpressionView", "impressionPercent: " + r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        Log.d("LynxImpressionView", "setEvents: " + r5);
        if (r5 == null) goto L6;
        r5.containsKey("impression");
        r5.containsKey("exit");
        return;
    }
}
