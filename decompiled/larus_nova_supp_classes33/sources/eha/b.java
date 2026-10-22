package eha;

import bha.a;
import com.obric.assistant.state.impl.v2.ObricStateImpl;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Runnable {
    public /* synthetic */ b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((ArrayList) ObricStateImpl.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a();
        goto L4
    }
}
