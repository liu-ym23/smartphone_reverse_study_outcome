package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tka.b;
import tka.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/sdk/awareness/ContextAwareness$registerFeature$remoteListener$1", "Lcom/obric/memorydata/sdk/awareness/IFeatureChangeListener$Stub;", "onFeatureChanged", "", "featureInfo", "Landroid/os/Bundle;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwareness$registerFeature$remoteListener$1 extends IFeatureChangeListener.Stub {
    public ContextAwareness$registerFeature$remoteListener$1() {
    }

    public void onFeatureChanged(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "featureInfo");
        r9.setClassLoader(ContextAwareness$registerFeature$remoteListener$1.class.getClassLoader());
        String r0 = r9.getString("feature_name");
        Object r1 = r9.get("old_value");
        Object r2 = r9.get("new_value");
        Bundle r10 = r9.getBundle("extras");
        if (r10 == null) goto L5;
        r10.setClassLoader(r10.getClass().getClassLoader());
        r10.keySet();
    L6:
        if (r0 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L32;
        if (r2 == null) goto L32;
        e.a.getClass();
        Set r5 = (Set) e.i.get(r0);
        if (r5 == null) goto L31;
        Iterator r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L40;
        j r7 = (j) r6.next();
        if ((r7 instanceof j) == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L26;
        if (r1 != null) goto L29;
        Object r8 = null;
    L30:
        r7.onFeatureChanged(r0, r8, r2, r10);
        goto L20
    L29:
        r8 = r1;
        goto L30
    L26:
        c.b("ContextAwareness", "listener is not match FeatureChangeListener<T> type", null);
        goto L20
    L40:
        return;
    L31:
        return;
    L32:
        b r11 = c.a;
        c.b("ContextAwareness", "invalid featureName: " + r0 + " or newValue: " + r2, null);
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r4 = false;
        goto L13
    L5:
        r10 = null;
        goto L6
    }
}
