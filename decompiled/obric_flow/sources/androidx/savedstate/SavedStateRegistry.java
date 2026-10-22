package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0003()*B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0007J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bJ\u0017\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0013H\u0007J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\bH\u0007J\u0018\u0010#\u001a\u00020\u00182\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "()V", "attached", "", "components", "Landroidx/arch/core/internal/SafeIterableMap;", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "isAllowingSavingState", "isAllowingSavingState$savedstate_release", "()Z", "setAllowingSavingState$savedstate_release", "(Z)V", "<set-?>", "isRestored", "recreatorProvider", "Landroidx/savedstate/Recreator$SavedStateProvider;", "restoredState", "Landroid/os/Bundle;", "consumeRestoredStateForKey", STGroup.DICT_KEY, "getSavedStateProvider", "performAttach", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "performAttach$savedstate_release", "performRestore", "savedState", "performRestore$savedstate_release", "performSave", "outBundle", "registerSavedStateProvider", "provider", "runOnNextRecreation", "clazz", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "unregisterSavedStateProvider", "AutoRecreated", "Companion", "SavedStateProvider", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
@SourceDebugExtension({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
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
        void onRecreated(SavedStateRegistryOwner r5);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$Companion;", "", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
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

    public static /* synthetic */ void a(SavedStateRegistry r5, LifecycleOwner r10, Lifecycle.Event r11) {
        performAttach$lambda$4(r5, r10, r11);
    }

    private static final void performAttach$lambda$4(SavedStateRegistry r5, LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r11 != Lifecycle.Event.ON_START) goto L6;
        r5.isAllowingSavingState = true;
        return;
    L6:
        if (r11 != Lifecycle.Event.ON_STOP) goto L10;
        r5.isAllowingSavingState = false;
        return;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (this.isRestored == false) goto L21;
        Bundle r10 = this.restoredState;
        if (r10 == null) goto L19;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle(r5);
    L9:
        Bundle r12 = this.restoredState;
        if (r12 == null) goto L12;
        r12.remove(r5);
    L12:
        Bundle r13 = this.restoredState;
        if (r13 != null) goto L15;
    L17:
        this.restoredState = null;
    L18:
        return r11;
    L15:
        if (r13.isEmpty() == true) goto L17;
    L8:
        r11 = null;
        goto L9
    L19:
        return null;
    L21:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final SavedStateProvider getSavedStateProvider(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Iterator<Map.Entry<String, SavedStateProvider>> r10 = this.components.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, SavedStateProvider> r11 = r10.next();
        String r12 = r11.getKey();
        SavedStateProvider r13 = r11.getValue();
        if (Intrinsics.areEqual(r12, r5) == false) goto L4;
        return r13;
    L8:
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(Lifecycle r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        if (this.attached == true) goto L7;
        r5.addObserver(new a(this));
        this.attached = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle r5) {
        if (this.attached == false) goto L14;
        if (this.isRestored == true) goto L12;
        if (r5 == null) goto L8;
        Bundle r10 = r5.getBundle(SAVED_COMPONENTS_KEY);
    L9:
        this.restoredState = r10;
        this.isRestored = true;
        return;
    L8:
        r10 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
    }

    @MainThread
    public final void performSave(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outBundle");
        Bundle r10 = new Bundle();
        Bundle r11 = this.restoredState;
        if (r11 == null) goto L5;
        r10.putAll(r11);
    L5:
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions r12 = this.components.iteratorWithAdditions();
    L7:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = r12.next();
        r10.putBundle((String) r13.getKey(), ((SavedStateProvider) r13.getValue()).saveState());
        goto L7
    L10:
        if (r10.isEmpty() == true) goto L14;
        r5.putBundle(SAVED_COMPONENTS_KEY, r10);
        return;
    }

    @MainThread
    public final void registerSavedStateProvider(String r5, SavedStateProvider r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "provider");
        if (this.components.putIfAbsent(r5, r10) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (this.isAllowingSavingState == false) goto L17;
        Recreator.SavedStateProvider r10 = this.recreatorProvider;
        if (r10 != null) goto L7;
        r10 = new Recreator.SavedStateProvider(this);
    L7:
        this.recreatorProvider = r10;
        r5.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L13
        Recreator.SavedStateProvider r11 = this.recreatorProvider;
        if (r11 == null) goto L20;
        r11.add(r5.getName());
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r5.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public final void setAllowingSavingState$savedstate_release(boolean r5) {
        this.isAllowingSavingState = r5;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        this.components.remove(r5);
    }
}
