package androidx.lifecycle;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    public ProcessLifecycleInitializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public LifecycleOwner create(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AppInitializer r11 = AppInitializer.getInstance(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "getInstance(context)");
        if (r11.isEagerlyInitialized(ProcessLifecycleInitializer.class) == false) goto L7;
        LifecycleDispatcher.init(r10);
        ProcessLifecycleOwner.Companion r12 = ProcessLifecycleOwner.Companion;
        r12.init$lifecycle_process_release(r10);
        return r12.get();
    L7:
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ LifecycleOwner create(Context r10) {
        return create(r10);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}
