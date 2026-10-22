package com.bytedance.android.live.core.tetris.widgets;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements Widget.WidgetCallback {
    public static final x a = null;

    public x() {
    }

    public void startActivity(Intent r1) {
    }

    public void startActivity(Intent r1, Bundle r2) {
    }

    public void startActivityForResult(Intent r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "intent");
    }

    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "intent");
    }

    static {
        a = new x();
    }

    @Deprecated(message = "Deprecated in Java")
    public final Fragment getFragment() {
        return VoidWidgetManager.d;
    }

    public final WidgetManager getWidgetManager() {
        return VoidWidgetManager.d;
    }

    public final <T extends ViewModel> T getViewModel(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        return r3.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        return null;
    }

    public final <T extends ViewModel> T getViewModel(Class<T> r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "factory");
        return (T) r3.create(r2);
    }
}
