package com.lynx.xelement.input;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = false, needProcessDirection = true, tagName = {"x-input-ng"})
@LynxGeneratorName(packageName = "com.lynx.xelement.input")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/input/LynxUIInputNG;", "Lcom/lynx/xelement/input/LynxUIInput;", "Input_release"}, k = 1, mv = {1, 6, 0})
public final class LynxUIInputNG extends LynxUIInput {
    @Override // com.lynx.xelement.input.LynxUIInput, com.lynx.xelement.input.LynxUIBaseInput
    public final LynxEditTextView Q(Context r3) {
        Intrinsics.checkNotNull(r3);
        return super.Q(new ContextThemeWrapper(r3, 2131952486));
    }

    @Override // com.lynx.xelement.input.LynxUIInput, com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return Q(r1);
    }

    public LynxUIInputNG(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
