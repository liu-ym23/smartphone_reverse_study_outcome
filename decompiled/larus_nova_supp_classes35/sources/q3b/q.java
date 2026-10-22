package q3b;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.PageLoader;
import com.ss.android.lark.chatbase.BasePageStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q<PageData, T> implements PageLoader.IReceiver<PageData> {
    public final IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> a;
    public final com.ss.android.lark.chatbase.model.c<?, T, PageData, com.ss.android.lark.chat.core.model.d<T>> b;

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void b(Throwable r3) {
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(new ErrorResult(r3.getMessage()));
        return;
    }

    public q(BasePageStore r1, IGetDataCallback r2) {
        this.a = r2;
        this.b = r1;
    }

    @Override // com.ss.android.lark.chat.core.model.PageLoader.IReceiver
    public final void a(int r2, x4b.a r3) {
        if (r2 != 0) goto L5;
        this.b.e(r3);
    L8:
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<T>> r4 = this.a;
        if (r4 == null) goto L12;
        r4.onSuccess((com.ss.android.lark.chat.core.model.d) this.b.d());
        return;
    L12:
        return;
    L5:
        if (r2 != 1) goto L7;
        this.b.b(r3);
        goto L8
    L7:
        this.b.f(r3);
        goto L8
    }
}
