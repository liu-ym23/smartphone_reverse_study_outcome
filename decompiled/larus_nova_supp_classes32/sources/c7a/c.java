package c7a;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.frame.UIFrame;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements UIBody.UIBodyView.a {
    public final WeakReference<LynxBaseUI> a;
    public final /* synthetic */ UIFrame b;

    public c(UIFrame r2) {
        this.b = r2;
        this.a = new WeakReference(this.b);
    }
}
