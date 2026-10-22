package com.ss.android.lark.chameleon.pluginsystem.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PluginViewModelProviders {
    private static final String TAG = "PluginViewModelProviders";

    public PluginViewModelProviders() {
    }

    public static <T extends ViewModel> T viewModel(Fragment r1, Class<T> r2) {
        return (T) viewModel(r1, r2, null);
    }

    public static <T extends ViewModel> T viewModel(Plugin r1, Class<T> r2) {
        return (T) viewModel(r1, r2, null);
    }

    public static <T extends ViewModel> T viewModel(PluginHost r1, Class<T> r2) {
        return (T) viewModel(r1, r2, null);
    }

    public static <T extends ViewModel> T viewModel(Fragment r0, Class<T> r1, ViewModelProvider.Factory r2) {
        return (T) viewModel(PluginHost.fromFragment(r0), r1, r2);
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
        return r1.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T extends ViewModel> T viewModel(PluginHost r1, Class<T> r2, ViewModelProvider.Factory r3) {
        if (r3 != null) goto L5;
        r3 = new ViewModelProvider.NewInstanceFactory();
    L5:
        return (T) new ViewModelProvider(r1, r3).get(r2);
    }

    public static <T extends ViewModel> T viewModel(Plugin r0, Class<T> r1, ViewModelProvider.Factory r2) {
        return (T) viewModel(r0.getHost(), r1, r2);
    }
}
