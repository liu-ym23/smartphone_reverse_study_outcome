package com.ss.android.lark.inline.ai.creationai.editor;

import com.ss.android.lark.inline.ai.creationai.d0;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ CreationAIEditorWebview a;

    public i(CreationAIEditorWebview r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        int r0 = d0.b;
        if (r5 == null) goto L5;
        String r1 = r5.toString();
    L6:
        d0.a.a(404, r1, 0);
        Log.e(this.a.getMTag(), r5, true);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
