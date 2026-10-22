package com.ss.android.lark.filedetail.impl.detail;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.chat.entity.message.content.FileContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements DecryptFileProcessor.b {
    public final /* synthetic */ FileContent a;
    public final /* synthetic */ p b;

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void c() {
        UICallbackExecutor.execute(new k(this));
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void a(final String r2) {
        UICallbackExecutor.execute(new l(this, r2));
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void b(final String r4) {
        ((DecryptFileProcessor) DecryptFileProcessor.e.getValue()).c(r4);
        final FileContent r0 = this.a;
        final FileTransmissionPresenter.b r1 = this.b.b;
        UICallbackExecutor.execute(new m(this, r0, r4, r1));
    }

    public n(p r1, FileContent r2) {
        this.b = r1;
        this.a = r2;
    }
}
