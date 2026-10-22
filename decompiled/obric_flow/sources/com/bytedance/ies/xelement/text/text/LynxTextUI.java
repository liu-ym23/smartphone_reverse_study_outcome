package com.bytedance.ies.xelement.text.text;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.UIText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/text/text/LynxTextUI;", "Lcom/lynx/tasm/behavior/ui/text/UIText;", "x-element-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxTextUI extends UIText {
    @Override // com.lynx.tasm.behavior.ui.text.UIText, com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new AndroidText(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.text.UIText
    public final AndroidText j(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new AndroidText(r5);
    }
}
