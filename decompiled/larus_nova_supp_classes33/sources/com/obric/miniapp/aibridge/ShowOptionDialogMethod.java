package com.obric.miniapp.aibridge;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/ShowOptionDialogMethod;", "Lcom/obric/miniapp/aibridge/AbsShowOptionDialogMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsShowOptionDialogMethodIDL$ShowOptionDialogParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsShowOptionDialogMethodIDL$ShowOptionDialogResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowOptionDialogMethod extends AbsShowOptionDialogMethodIDL {
    public ShowOptionDialogMethod() {
    }

    public final void handle(e3.d r10, ParamModel r11, final f3.h r12) {
        AbsShowOptionDialogMethodIDL.a r13 = (AbsShowOptionDialogMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Activity r14 = AppHost.a.a().getCurrentActivity();
        if ((r14 instanceof Context) == true) goto L7;
        r14 = null;
    L7:
        if (r14 != null) goto L10;
        f3.h.a.a(r12, "No available activity context", null, null, 14);
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 30) goto L12;
        f3.h.a.a(r12, "System API Version is less than 30", null, null, 14);
        return;
    L12:
        if (r13.getOptions().isEmpty() == false) goto L14;
        f3.h.a.a(r12, "optionList is Empty", null, null, 14);
        return;
    L14:
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r13.getOptions().iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        r0.add(new fla.a(OActionSheet.Companion.ItemStyle.LIST_BUTTON, null, (String) r1.next(), new b0(r12), 10));
        goto L16
    L18:
        WeakReference<OActionSheet> r2 = fla.g.a;
        String r15 = r13.getTitle();
        if (r15 != null) goto L21;
        r15 = r14.getString(2131911814);
    L21:
        fla.g.b(r14, r0, r15, OInsetSheet.PanelWidth.NARROW_WIDTH, new c0(r12));
    }
}
