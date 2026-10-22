package p8a;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.xelement.markdown.LynxUIMarkdownShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ ShadowNode a;
    public final /* synthetic */ m7a.a b;

    public /* synthetic */ f(LynxUIMarkdownShadowNode r1, m7a.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ShadowNode r0 = this.a;
        m7a.a r1 = this.b;
        r0.getContext().getEventEmitter().sendCustomEvent(r1);
    }
}
