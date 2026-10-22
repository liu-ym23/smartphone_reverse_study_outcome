package com.bytedance.android.live.core.tetris.layer.core.tetris.priority;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import eu2.a;
import eu2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/JatoOptFrameLayoutVisibilityProxy;", "Lcom/bytedance/common/jato/views/JatoOptFrameLayout;", "Leu2/a;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JatoOptFrameLayoutVisibilityProxy extends JatoOptFrameLayout implements a {
    public final c a;

    public JatoOptFrameLayoutVisibilityProxy(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public JatoOptFrameLayoutVisibilityProxy(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void T3(d80.c r3) {
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        c r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        r1.a.add(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r2) {
        if (this.a.a(this, r2) == true) goto L6;
        super/*android.widget.FrameLayout*/.setVisibility(r2);
        return;
    }

    public JatoOptFrameLayoutVisibilityProxy(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new c();
    }

    public /* synthetic */ JatoOptFrameLayoutVisibilityProxy(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
