package com.ss.android.lark.contact.base.contact_list.mvp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ExternalContactPresenter2.b a;
    public final /* synthetic */ w8b.a b;

    public /* synthetic */ a(ExternalContactPresenter2.b r1, w8b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExternalContactPresenter2.b r0 = this.a;
        w8b.a r1 = this.b;
        ((m) r0.a.getView()).p4(r1);
    }
}
