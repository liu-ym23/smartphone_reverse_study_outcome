package androidx.savedstate;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = null;
    private final SavedStateRegistryOwner owner;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes;

        public SavedStateProvider(SavedStateRegistry r10) {
            Intrinsics.checkNotNullParameter(r10, "registry");
            this.classes = new LinkedHashSet();
            r10.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(String r10) {
            Intrinsics.checkNotNullParameter(r10, "className");
            this.classes.add(r10);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            Bundle r10 = new Bundle();
            r10.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList(this.classes));
            return r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Recreator(SavedStateRegistryOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.owner = r10;
    }

    private final void reflectiveNew(String r10) {
        Class<? extends U> r11 = Class.forName(r10, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);     // Catch: ClassNotFoundException -> L15
        Intrinsics.checkNotNullExpressionValue(r11, "{\n                Class.…class.java)\n            }");     // Catch: ClassNotFoundException -> L15
        Constructor r12 = r11.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L12
        r12.setAccessible(true);
        Object r13 = r12.newInstance(new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r13, "{\n                constr…wInstance()\n            }");     // Catch: Exception -> L9
        ((SavedStateRegistry.AutoRecreated) r13).onRecreated(this.owner);
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to instantiate " + r10, e);
    L12:
        e = move-exception;
        throw new IllegalStateException("Class " + r11.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L15:
        e = move-exception;
        throw new RuntimeException("Class " + r10 + " wasn't found", e);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
        if (r11 != Lifecycle.Event.ON_CREATE) goto L17;
        r10.getLifecycle().removeObserver(this);
        Bundle r12 = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (r12 != null) goto L7;
        return;
    L7:
        ArrayList<String> r13 = r12.getStringArrayList(CLASSES_KEY);
        if (r13 == null) goto L15;
        Iterator<String> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        reflectiveNew(r14.next());
        goto L11
    L13:
        return;
    L15:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L17:
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
