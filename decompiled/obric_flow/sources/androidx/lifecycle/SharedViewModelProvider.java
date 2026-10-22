package androidx.lifecycle;

import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt$getAISharedViewModel$1$1;
import com.bytedance.ai.viewmodel.AISharedViewModel;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/lifecycle/SharedViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider;", "ClearUselessViewModelObserver", "SharedViewModel_release"}, k = 1, mv = {1, 4, 0})
public final class SharedViewModelProvider extends ViewModelProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewModelStore f546c = null;
    public static final HashMap d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelStore f547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f548b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/SharedViewModelProvider$ClearUselessViewModelObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "SharedViewModel_release"}, k = 1, mv = {1, 4, 0})
    public static final class ClearUselessViewModelObserver implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewModelStore f551c;
        public final HashMap d;

        public ClearUselessViewModelObserver(Lifecycle r5, String r10, ViewModelStore r11, HashMap r12) {
            this.f549a = r5;
            this.f550b = r10;
            this.f551c = r11;
            this.d = r12;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
            if (r10 != Lifecycle.Event.ON_DESTROY) goto L12;
            Object r11 = this.d.get(this.f550b);
            if (r11 != null) goto L8;
            r11 = new LinkedHashSet();
        L8:
            Set r12 = (Set) r11;
            r12.remove(this.f549a);
            if (r12.isEmpty() == false) goto L13;
            this.f551c.put(this.f550b, FakeViewModel.f545a);
            this.d.remove(this.f550b);
            return;
        L13:
            return;
        }
    }

    static {
        f546c = new ViewModelStore();
        d = new HashMap();
    }

    public SharedViewModelProvider(SharedViewModelExtKt$getAISharedViewModel$1$1 r5) {
        ViewModelStore r10 = f546c;
        super(r10, r5);
        this.f547a = r10;
        this.f548b = d;
    }

    public final ViewModel a(Lifecycle r5, String r10) {
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L13;
        ViewModel r11 = super.get(r10, AISharedViewModel.class);
        Object r12 = this.f548b.get(r10);
        if (r12 != null) goto L8;
        r12 = new LinkedHashSet();
    L8:
        Set r13 = (Set) r12;
        this.f548b.put(r10, r13);
        if (r13.contains(r5) == true) goto L11;
        r13.add(r5);
        r5.addObserver(new ClearUselessViewModelObserver(r5, r10, this.f547a, this.f548b));
    L11:
        return r11;
    L13:
        throw new IllegalStateException("Could not get viewmodel when lifecycle was destroyed");
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public final ViewModel get(Class r5) {
        throw new IllegalAccessException("Unsupport get viewmodel without lifecycle, please use method get(Lifecycle,Class) or get(Lifecycle,String,Class) instead");
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public final ViewModel get(String r5, Class r10) {
        throw new IllegalAccessException("Unsupport get viewmodel without lifecycle, please use method get(Lifecycle,Class) or get(Lifecycle,String,Class) instead");
    }
}
