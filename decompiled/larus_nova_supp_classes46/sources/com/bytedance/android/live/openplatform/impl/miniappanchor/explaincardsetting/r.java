package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r3) {
        int r0 = qo0.a.a;
        qo0.a.b("ExplainCardTitleEditorDialog", "on title check fail, error: " + ((Throwable) r3), null);
        f2.b(2131921017, 0);
    }
}
