package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelStore {
    private final Map<String, ViewModel> map;

    public ViewModelStore() {
        this.map = new LinkedHashMap();
    }

    public final void clear() {
        Iterator<ViewModel> r10 = this.map.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().clear();
        goto L4
    L6:
        this.map.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.map.get(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(String r10, ViewModel r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        ViewModel r12 = this.map.put(r10, r11);
        if (r12 == null) goto L6;
        r12.onCleared();
        return;
    }
}
