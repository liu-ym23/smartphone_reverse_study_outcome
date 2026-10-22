package me0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.api.IComponentService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkPanelService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a<T extends IComponentService> {
    public T a;
    public final LifecycleOwner b;

    /* JADX INFO: renamed from: me0.a$a, reason: collision with other inner class name */
    public static final class C0237a {
    }

    static {
    }

    public abstract LinkPanelService a();

    public a(MultiComponentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.b = r2;
    }
}
