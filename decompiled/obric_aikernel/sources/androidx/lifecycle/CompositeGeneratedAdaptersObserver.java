package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] r10) {
        Intrinsics.checkNotNullParameter(r10, "generatedAdapters");
        this.generatedAdapters = r10;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
        MethodCallsLogger r12 = new MethodCallsLogger();
        GeneratedAdapter[] r13 = this.generatedAdapters;
        int r14 = r13.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L5;
        r13[r16].callMethods(r10, r11, false, r12);
        r16 = r16 + 1;
        goto L3
    L5:
        GeneratedAdapter[] r17 = this.generatedAdapters;
        int r18 = r17.length;
    L6:
        if (r15 >= r18) goto L8;
        r17[r15].callMethods(r10, r11, true, r12);
        r15 = r15 + 1;
        goto L6
    }
}
