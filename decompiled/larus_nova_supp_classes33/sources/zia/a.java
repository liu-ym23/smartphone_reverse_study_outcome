package zia;

import com.obric.capabilitykit.search.InAppSearchClient;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public /* synthetic */ a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    L3:
        if ((!InAppSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L7;
        Function0 r0 = (Function0) InAppSearchClient.access$getPendingOperations$p().poll();
        if (r0 == null) goto L3;
        r0.invoke();
        goto L3
    }
}
