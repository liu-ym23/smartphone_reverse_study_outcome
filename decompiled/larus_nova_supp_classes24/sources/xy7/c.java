package xy7;

import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends com.lynx.tasm.behavior.a {
    public c() {
        super("x-textarea-ng");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new LynxTextAreaView(r2);
    }
}
