package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0003()*B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0007J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bJ\u0017\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0013H\u0007J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\bH\u0007J\u0018\u0010#\u001a\u00020\u00182\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "()V", "attached", "", "components", "Landroidx/arch/core/internal/SafeIterableMap;", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "isAllowingSavingState", "isAllowingSavingState$savedstate_release", "()Z", "setAllowingSavingState$savedstate_release", "(Z)V", "<set-?>", "isRestored", "recreatorProvider", "Landroidx/savedstate/Recreator$SavedStateProvider;", "restoredState", "Landroid/os/Bundle;", "consumeRestoredStateForKey", "key", "getSavedStateProvider", "performAttach", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "performAttach$savedstate_release", "performRestore", "savedState", "performRestore$savedstate_release", "performSave", "outBundle", "registerSavedStateProvider", "provider", "runOnNextRecreation", "clazz", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "unregisterSavedStateProvider", "AutoRecreated", "Companion", "SavedStateProvider", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateRegistry {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private final SafeIterableMap<String, SavedStateProvider> components;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private Recreator.SavedStateProvider recreatorProvider;
    private Bundle restoredState;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner r1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$Companion;", "", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "saveState", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SavedStateProvider {
        Bundle saveState();
    }

    static {
        Companion = new Companion(null);
    }

    public SavedStateRegistry() {
        this.components = new SafeIterableMap();
        this.isAllowingSavingState = true;
    }

    /* JADX INFO: renamed from: lambda$AUDDdpkzZrJMhBj0r-_9pI-j6hA, reason: not valid java name */
    public static /* synthetic */ void m63lambda$AUDDdpkzZrJMhBj0r_9pIj6hA(SavedStateRegistry r0, LifecycleOwner r1, Lifecycle.Event r2) {
        performAttach$lambda$4(r0, r1, r2);
    }

    private static final void performAttach$lambda$4(SavedStateRegistry r2, LifecycleOwner r3, Lifecycle.Event r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4 != Lifecycle.Event.ON_START) goto L7;
        boolean r6 = true;
    L5:
        r2.isAllowingSavingState = r6;
        return;
    L7:
        if (r4 != Lifecycle.Event.ON_STOP) goto L10;
        r6 = false;
        goto L5
    }

    public final Bundle consumeRestoredStateForKey(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (this.isRestored == false) goto L22;
        Bundle r0 = this.restoredState;
        if (r0 == null) goto L20;
        if (r0 == null) goto L8;
        Bundle r1 = r0.getBundle(r4);
    L9:
        Bundle r2 = this.restoredState;
        if (r2 == null) goto L12;
        r2.remove(r4);
    L12:
        Bundle r5 = this.restoredState;
        boolean r3 = false;
        if (r5 != null) goto L15;
    L17:
        if (r3 == true) goto L19;
        this.restoredState = null;
    L19:
        return r1;
    L15:
        if (r5.isEmpty() == true) goto L17;
        r3 = true;
        goto L17
    L8:
        r1 = null;
        goto L9
    L20:
        return null;
    L22:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider getSavedStateProvider(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> r4 = this.components.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "components");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        SavedStateProvider r2 = (SavedStateProvider) ZeusTransformUtils.preCheckCast(r0.getValue(), SavedStateProvider.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r1, r5) == false) goto L4;
        return r2;
    L8:
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    public final boolean isRestored() {
        return this.isRestored;
    }

    public final void performAttach$savedstate_release(Lifecycle r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        if ((!this.attached) == false) goto L7;
        r5.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new $$Lambda$SavedStateRegistry$AUDDdpkzZrJMhBj0r_9pIj6hA(this), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        this.attached = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void performRestore$savedstate_release(Bundle r3) {
        if (this.attached == false) goto L14;
        if ((!this.isRestored) == false) goto L12;
        if (r3 == null) goto L8;
        Bundle r4 = r3.getBundle(SAVED_COMPONENTS_KEY);
    L9:
        this.restoredState = r4;
        this.isRestored = true;
        return;
    L8:
        r4 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    public final void performSave(Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "outBundle");
        Bundle r0 = new Bundle();
        Bundle r1 = this.restoredState;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions r5 = this.components.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(r5, "this.components.iteratorWithAdditions()");
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r5, Iterator.class, "com.obric.memorydata.plugin");
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.putBundle((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), ((SavedStateProvider) ZeusTransformUtils.preCheckCast(r2.getValue(), SavedStateProvider.class, "com.obric.memorydata.plugin")).saveState());
        goto L7
    L10:
        if (r0.isEmpty() == true) goto L14;
        r6.putBundle(SAVED_COMPONENTS_KEY, r0);
        return;
    }

    public final void registerSavedStateProvider(String r3, SavedStateProvider r4) {
        SavedStateProvider r5 = (SavedStateProvider) ZeusTransformUtils.wrapperContextForParams(r4, SavedStateProvider.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "provider");
        if (((SavedStateProvider) ZeusTransformUtils.preCheckCast(this.components.putIfAbsent(r3, r5), SavedStateProvider.class, "com.obric.memorydata.plugin")) != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void runOnNextRecreation(Class<? extends AutoRecreated> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        if (this.isAllowingSavingState == false) goto L17;
        Recreator.SavedStateProvider r0 = this.recreatorProvider;
        if (r0 != null) goto L7;
        r0 = new Recreator.SavedStateProvider(this);
    L7:
        this.recreatorProvider = r0;
        r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L13
        Recreator.SavedStateProvider r3 = this.recreatorProvider;
        if (r3 == null) goto L20;
        String r5 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "clazz.name");
        r3.add(r5);
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r4.getSimpleName() + " must have default constructor in order to be automatically recreated", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void setAllowingSavingState$savedstate_release(boolean r1) {
        this.isAllowingSavingState = r1;
    }

    public final void unregisterSavedStateProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.components.remove(r2);
    }
}
