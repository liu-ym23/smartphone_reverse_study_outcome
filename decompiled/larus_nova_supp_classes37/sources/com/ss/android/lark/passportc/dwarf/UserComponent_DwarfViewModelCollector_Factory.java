package com.ss.android.lark.passportc.dwarf;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import e0c.n;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserComponent_DwarfViewModelCollector_Factory implements Factory<n> {
    private final Provider<Map<String, Object>> assistedFactoriesProvider;
    private final Provider<Map<String, Provider<ViewModel>>> factoriesProvider;

    public n get() {
        return newInstance((Map) this.factoriesProvider.get(), (Map) this.assistedFactoriesProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m699get() {
        return get();
    }

    public UserComponent_DwarfViewModelCollector_Factory(Provider<Map<String, Provider<ViewModel>>> r1, Provider<Map<String, Object>> r2) {
        this.factoriesProvider = r1;
        this.assistedFactoriesProvider = r2;
    }

    public static UserComponent_DwarfViewModelCollector_Factory create(Provider<Map<String, Provider<ViewModel>>> r1, Provider<Map<String, Object>> r2) {
        return new UserComponent_DwarfViewModelCollector_Factory(r1, r2);
    }

    public static n newInstance(Map<String, Provider<ViewModel>> r1, Map<String, Object> r2) {
        return new n(r1, r2);
    }
}
