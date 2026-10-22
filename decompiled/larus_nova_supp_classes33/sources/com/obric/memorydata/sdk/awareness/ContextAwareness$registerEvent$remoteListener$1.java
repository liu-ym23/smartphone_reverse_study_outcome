package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/sdk/awareness/ContextAwareness$registerEvent$remoteListener$1", "Lcom/obric/memorydata/sdk/awareness/IEventChangeListener$Stub;", "onEventChanged", "", "event", "", "extras", "Landroid/os/Bundle;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwareness$registerEvent$remoteListener$1 extends IEventChangeListener.Stub {
    public ContextAwareness$registerEvent$remoteListener$1() {
    }

    public void onEventChanged(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r3 == null) goto L5;
        r3.setClassLoader(r3.getClass().getClassLoader());
        r3.keySet();
    L5:
        e.a.getClass();
        Set r4 = (Set) e.k.get(r2);
        if (r4 == null) goto L11;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        ((i) r5.next()).a();
        goto L9
    L13:
        return;
    }
}
