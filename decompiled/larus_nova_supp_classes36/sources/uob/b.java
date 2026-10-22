package uob;

import android.view.View;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ SCAppCompatEditText b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.setCursorVisible(false);
        this.b.setCursorVisible(true);
        this.b.setOnTouchListener(com.ss.android.lark.keyboard.plugin.tool.voice.vote.b.a);
    }

    public b(SCAppCompatEditText r1, SCAppCompatEditText r2) {
        this.a = r1;
        this.b = r2;
    }
}
