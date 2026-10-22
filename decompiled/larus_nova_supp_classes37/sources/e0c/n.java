package e0c;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements DwarfViewModelFactory.DwarfViewModelCollector {
    public final Map<String, Provider<ViewModel>> a;
    public final Map<String, Object> b;

    public final Map<String, Object> getDwarfViewModelAssistedMap() {
        return this.b;
    }

    public final Map<String, Provider<ViewModel>> getDwarfViewModelMap() {
        return this.a;
    }

    @Inject
    public n(Map<String, Provider<ViewModel>> r1, Map<String, Object> r2) {
        this.a = r1;
        this.b = r2;
    }
}
