package x4b;

import com.ss.android.lark.chat.core.model.PageLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ PageLoader a;
    public final /* synthetic */ PageLoader.b b;
    public final /* synthetic */ PageLoader.IReceiver c;

    public /* synthetic */ l(com.ss.android.lark.chat.core.model.a r1, com.ss.android.lark.chat.core.model.c r2, PageLoader.IReceiver r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageLoader r0 = this.a;
        PageLoader.b r1 = this.b;
        PageLoader.IReceiver r2 = this.c;
        r0.getClass();
        PageLoader.d r8 = new PageLoader.d(r2, 0);
        com.ss.android.lark.chat.core.model.a r3 = (com.ss.android.lark.chat.core.model.a) r0;
        com.ss.android.lark.chat.core.model.c r4 = (com.ss.android.lark.chat.core.model.c) r1;
        int r5 = r4.a.getPosition();
        int r6 = r4.b;
        r3.e(r4.c, r5, r6, r4.d, r8);
    }
}
