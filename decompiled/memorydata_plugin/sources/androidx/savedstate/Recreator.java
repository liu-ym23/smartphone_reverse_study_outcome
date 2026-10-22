package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "onStateChanged", "", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "reflectiveNew", "className", "", "Companion", "SavedStateProvider", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = null;
    private final SavedStateRegistryOwner owner;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/savedstate/Recreator$Companion;", "", "()V", "CLASSES_KEY", "", "COMPONENT_KEY", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "(Landroidx/savedstate/SavedStateRegistry;)V", "classes", "", "", "add", "", "className", "saveState", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes;

        public SavedStateProvider(SavedStateRegistry r4) {
            Intrinsics.checkNotNullParameter(r4, "registry");
            this.classes = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            r4.registerSavedStateProvider(Recreator.COMPONENT_KEY, (SavedStateRegistry.SavedStateProvider) ZeusTransformUtils.preCheckCast(this, SavedStateRegistry.SavedStateProvider.class, "com.obric.memorydata.plugin"));
        }

        public final void add(String r2) {
            Intrinsics.checkNotNullParameter(r2, "className");
            this.classes.add(r2);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            Bundle r0 = new Bundle();
            r0.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.classes, Collection.class, "com.obric.memorydata.plugin")));
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Recreator(SavedStateRegistryOwner r3) {
        SavedStateRegistryOwner r4 = (SavedStateRegistryOwner) ZeusTransformUtils.wrapperContextForParams(r3, SavedStateRegistryOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "owner");
        this.owner = r4;
    }

    private final void reflectiveNew(String r6) {
        Class<? extends U> r2 = Class.forName(r6, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);     // Catch: ClassNotFoundException -> L15
        Intrinsics.checkNotNullExpressionValue(r2, "{\n                Class.…class.java)\n            }");     // Catch: ClassNotFoundException -> L15
        Constructor r0 = r2.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L12
        r0.setAccessible(true);
        Object r1 = r0.newInstance(new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r1, "{\n                constr…wInstance()\n            }");     // Catch: Exception -> L9
        ((SavedStateRegistry.AutoRecreated) ZeusTransformUtils.preCheckCast(r1, SavedStateRegistry.AutoRecreated.class, "com.obric.memorydata.plugin")).onRecreated(this.owner);
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to instantiate " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        e = move-exception;
        throw new IllegalStateException("Class " + r2.getSimpleName() + " must have default constructor in order to be automatically recreated", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        e = move-exception;
        throw new RuntimeException("Class " + r6 + " wasn't found", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4 != Lifecycle.Event.ON_CREATE) goto L17;
        r5.getLifecycle().removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        Bundle r6 = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (r6 != null) goto L7;
        return;
    L7:
        ArrayList<String> r7 = r6.getStringArrayList(CLASSES_KEY);
        if (r7 == null) goto L15;
        Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        reflectiveNew((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        return;
    L15:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L17:
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
