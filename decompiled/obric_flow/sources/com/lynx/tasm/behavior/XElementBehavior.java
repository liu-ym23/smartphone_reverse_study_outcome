package com.lynx.tasm.behavior;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class XElementBehavior implements b {
    public static final HashSet<String> GENERATOR_FILE_NAME_SETS = null;
    private static final String TAG = "XElementBehavior";
    private static volatile List<a> sCacheBehaviors;

    static {
        GENERATOR_FILE_NAME_SETS = new AnonymousClass1();
    }

    public XElementBehavior() {
    }

    private List<a> getModuleBehaviors(String r5) {
        return (List) Class.forName(r5 + ".BehaviorGenerator").getMethod("getBehaviors", null).invoke(null, null);
    L5:
        return new ArrayList();
    }

    @Override // com.lynx.tasm.behavior.b
    public List<a> create() {
        monitor-enter(XElementBehavior.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sCacheBehaviors != null) goto L7;
    L13:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L11
        Iterator<String> r10 = GENERATOR_FILE_NAME_SETS.iterator();     // Catch: Throwable -> L11
    L15:
        if (r10.hasNext() == false) goto L17;
        r5.addAll(getModuleBehaviors(r10.next()));     // Catch: Throwable -> L11
        goto L15
    L17:
        sCacheBehaviors = r5;     // Catch: Throwable -> L11
        ArrayList r11 = new ArrayList(r5);     // Catch: Throwable -> L11
        monitor-exit(XElementBehavior.class);     // Catch: Throwable -> L11
        return r11;
    L7:
        if (sCacheBehaviors.isEmpty() == true) goto L13;
        ArrayList r12 = new ArrayList(sCacheBehaviors);     // Catch: Throwable -> L11
        monitor-exit(XElementBehavior.class);     // Catch: Throwable -> L11
        return r12;
    }
}
