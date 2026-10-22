package p8a;

import com.lynx.markdown.ServalMarkdownView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends ServalMarkdownView {
    public final ShadowNode a;

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public final void requestAlign() {
        super.requestAlign();
        ShadowNode r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.q();
    }

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public final void requestMeasure() {
        super.requestMeasure();
        ShadowNode r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.q();
    }

    public d(LynxContext r1, ShadowNode r2) {
        super(r1);
        this.a = r2;
    }
}
