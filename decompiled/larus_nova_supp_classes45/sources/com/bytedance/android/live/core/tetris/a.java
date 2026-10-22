package com.bytedance.android.live.core.tetris;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.componentx.ComponentManager;
import com.bytedance.android.live.core.tetris.layer.view.LayerManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final IComponentManager c(FrameLayout r9, LifecycleOwner r11, com.bytedance.android.live.core.tetris.layer.view.a r12, DataCenter r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "masterView");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r14, "scene");
        if (ComponentManagerABHelper.INSTANCE.enableOtherScene() == true) goto L7;
        LayerManager r0 = new LayerManager(r9, r11);
        r0.b(r12, r13);
        return r0;
    L7:
        return new ComponentManager(b(this, r9.getContext(), new b(r9), r11, r12, r13, r14));
    }

    public static ComponentManagerFactory$config$1 a(Context r9, f70.a r11, LifecycleOwner r12, com.bytedance.android.live.core.tetris.layer.view.a r13, DataCenter r14, String r15, List r16) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "masterViewProvider");
        Intrinsics.checkNotNullParameter(r12, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r15, "scene");
        return new ComponentManagerFactory$config$1(r12, r13, r9, r15, r14, r11, r16);
    }

    public static /* synthetic */ ComponentManagerFactory$config$1 b(a r7, Context r8, f70.a r9, LifecycleOwner r11, com.bytedance.android.live.core.tetris.layer.view.a r12, DataCenter r13, String r14) {
        r7.getClass();
        return a(r8, r9, r11, r12, r13, r14, null);
    }
}
