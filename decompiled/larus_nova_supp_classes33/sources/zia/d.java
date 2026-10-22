package zia;

import com.obric.capabilitykit.search.IAppEntityChangeCallback;
import com.obric.capabilitykit.search.InAppSearchClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ IAppEntityChangeCallback a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ d(IAppEntityChangeCallback r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InAppSearchClient.c.a.c(this.a, this.b, this.c);
    }
}
