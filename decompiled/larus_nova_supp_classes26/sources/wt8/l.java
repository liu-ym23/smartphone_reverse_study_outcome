package wt8;

import com.larus.bmhome.view.title.ChatTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ ChatTitle a;

    public /* synthetic */ l(ChatTitle r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getBinding().n.setVisibility(0);
    }
}
