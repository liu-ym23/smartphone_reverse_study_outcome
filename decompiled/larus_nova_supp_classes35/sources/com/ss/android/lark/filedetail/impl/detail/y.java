package com.ss.android.lark.filedetail.impl.detail;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.chat.entity.message.content.FileContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements DecryptFileProcessor.b {
    public final /* synthetic */ FileContent a;
    public final /* synthetic */ FileTransmissionPresenter b;

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void c() {
        UICallbackExecutor.execute(new v(this));
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void a(final String r2) {
        UICallbackExecutor.execute(new x(this, r2));
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor.b
    public final void b(final String r3) {
        ((DecryptFileProcessor) DecryptFileProcessor.e.getValue()).c(r3);
        final FileContent r0 = this.a;
        UICallbackExecutor.execute(new w(this, r3, r0));
    }

    public y(FileTransmissionPresenter r1, FileContent r2) {
        this.b = r1;
        this.a = r2;
    }
}
