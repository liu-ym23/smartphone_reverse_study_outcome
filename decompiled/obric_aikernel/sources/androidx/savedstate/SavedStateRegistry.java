package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
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

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner r10);
    }

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

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

    public static /* synthetic */ void a(SavedStateRegistry r10, LifecycleOwner r11, Lifecycle.Event r12) {
        performAttach$lambda$4(r10, r11, r12);
    }

    private static final void performAttach$lambda$4(SavedStateRegistry r10, LifecycleOwner r11, Lifecycle.Event r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_EVENT);
        if (r12 != Lifecycle.Event.ON_START) goto L7;
        boolean r13 = true;
    L5:
        r10.isAllowingSavingState = r13;
        return;
    L7:
        if (r12 != Lifecycle.Event.ON_STOP) goto L10;
        r13 = false;
        goto L5
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.isRestored == false) goto L22;
        Bundle r11 = this.restoredState;
        if (r11 == null) goto L20;
        if (r11 == null) goto L8;
        Bundle r12 = r11.getBundle(r10);
    L9:
        Bundle r13 = this.restoredState;
        if (r13 == null) goto L12;
        r13.remove(r10);
    L12:
        Bundle r14 = this.restoredState;
        boolean r15 = false;
        if (r14 != null) goto L15;
    L17:
        if (r15 == true) goto L19;
        this.restoredState = null;
    L19:
        return r12;
    L15:
        if (r14.isEmpty() == true) goto L17;
        r15 = true;
        goto L17
    L8:
        r12 = null;
        goto L9
    L20:
        return null;
    L22:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider getSavedStateProvider(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> r11 = this.components.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, SavedStateProvider> r12 = r11.next();
        Intrinsics.checkNotNullExpressionValue(r12, "components");
        String r13 = r12.getKey();
        SavedStateProvider r14 = r12.getValue();
        if (Intrinsics.areEqual(r13, r10) == false) goto L4;
        return r14;
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
    public final void performAttach$savedstate_release(Lifecycle r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        if ((!this.attached) == false) goto L7;
        r10.addObserver(new a(this));
        this.attached = true;
        return;
    L7:
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle r10) {
        if (this.attached == false) goto L14;
        if ((!this.isRestored) == false) goto L12;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle(SAVED_COMPONENTS_KEY);
    L9:
        this.restoredState = r11;
        this.isRestored = true;
        return;
    L8:
        r11 = null;
        goto L9
    L12:
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    L14:
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    @MainThread
    public final void performSave(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outBundle");
        Bundle r11 = new Bundle();
        Bundle r12 = this.restoredState;
        if (r12 == null) goto L5;
        r11.putAll(r12);
    L5:
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions r13 = this.components.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(r13, "this.components.iteratorWithAdditions()");
    L7:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = r13.next();
        r11.putBundle((String) r14.getKey(), ((SavedStateProvider) r14.getValue()).saveState());
        goto L7
    L10:
        if (r11.isEmpty() == true) goto L14;
        r10.putBundle(SAVED_COMPONENTS_KEY, r11);
        return;
    }

    @MainThread
    public final void registerSavedStateProvider(String r10, SavedStateProvider r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "provider");
        if (this.components.putIfAbsent(r10, r11) != null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    L5:
        r12 = false;
        goto L6
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        if (this.isAllowingSavingState == false) goto L17;
        Recreator.SavedStateProvider r11 = this.recreatorProvider;
        if (r11 != null) goto L7;
        r11 = new Recreator.SavedStateProvider(this);
    L7:
        this.recreatorProvider = r11;
        r10.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L13
        Recreator.SavedStateProvider r12 = this.recreatorProvider;
        if (r12 == null) goto L20;
        String r13 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "clazz.name");
        r12.add(r13);
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r10.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void setAllowingSavingState$savedstate_release(boolean r10) {
        this.isAllowingSavingState = r10;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.components.remove(r10);
    }
}
