package zia;

import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.search.IAppEntityChangeCallback;
import com.obric.capabilitykit.search.InAppSearchClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ IAppEntityChangeCallback a;
    public final /* synthetic */ EntityChangeResult b;

    public /* synthetic */ c(IAppEntityChangeCallback r1, EntityChangeResult r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InAppSearchClient.c.a.b(this.a, this.b);
    }
}
