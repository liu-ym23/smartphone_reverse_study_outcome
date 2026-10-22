package com.obric.oui.window.listener;

import androidx.lifecycle.ViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "m/b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowConfigChangeListener extends ViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f14902c = null;
    public static final ConcurrentHashMap d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData f14903b;

    static {
        f14902c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        this.f14903b = new NextLiveData();
    }
}
