package com.ss.android.lark.chatbase.model;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.PageLoader;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements PageLoader.a<x4b.a<Object>> {
    public final /* synthetic */ IGetDataCallback a;
    public final /* synthetic */ FirstScreenLoader b;

    @Override // com.ss.android.lark.chat.core.model.PageLoader.a
    public final void a(final x4b.a r4) {
        Executor r0 = this.b.c;
        final IGetDataCallback r1 = this.a;
        r0.execute(new a(this, r4, r1));
    }

    @Override // com.ss.android.lark.chat.core.model.PageLoader.a
    public final void onError(Throwable r3) {
        IGetDataCallback r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof ErrorResult) == false) goto L9;
        r0.onError((ErrorResult) r3);
        return;
    }

    public b(FirstScreenLoader r1, IGetDataCallback r2) {
        this.b = r1;
        this.a = r2;
    }
}
