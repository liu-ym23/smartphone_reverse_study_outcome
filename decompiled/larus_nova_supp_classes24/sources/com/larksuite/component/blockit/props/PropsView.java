package com.larksuite.component.blockit.props;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class PropsView extends SpannableTailTextView {
    public Map<String, Object> e;

    private void setConfig(e r1) {
    }

    public e getConfig() {
        return null;
    }

    public PropsView(Context r1) {
        super(r1);
    }

    public PropsView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(List r1, Map r2) {
        this.e = r2;
        setConfig(null);
        setText(c.a(r1, this.e));
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public PropsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
