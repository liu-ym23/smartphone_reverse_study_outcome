package com.bytedance.ai.applet.render.core.relax;

import android.os.Looper;
import androidx.annotation.Keep;
import com.relax.RelaxView;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/bytedance/ai/applet/render/core/relax/RelaxViewAIBridgePort$RTSInterface", "", "<init>", "()V", "Lcom/relax/RelaxView;", "relaxView", "", "initialize", "(Lcom/relax/RelaxView;)V", "release", "Ljava/util/WeakHashMap;", "Lcom/bytedance/ai/applet/render/core/relax/RelaxBridgeModule;", "relaxViewToRelaxBridgeModule", "Ljava/util/WeakHashMap;", "getRelaxViewToRelaxBridgeModule", "()Ljava/util/WeakHashMap;", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxViewAIBridgePort$RTSInterface {
    public static final RelaxViewAIBridgePort$RTSInterface INSTANCE = null;
    private static final WeakHashMap<RelaxView, RelaxBridgeModule> relaxViewToRelaxBridgeModule = null;

    static {
        INSTANCE = new RelaxViewAIBridgePort$RTSInterface();
        relaxViewToRelaxBridgeModule = new WeakHashMap();
    }

    private RelaxViewAIBridgePort$RTSInterface() {
    }

    public static /* synthetic */ void a(RelaxView r5) {
        release$lambda$1(r5);
    }

    @JvmStatic
    public static final void initialize(RelaxView r10) {
        Intrinsics.checkNotNullParameter(r10, "relaxView");
        boolean r5 = Intrinsics.areEqual(c1.b.c().getLooper(), Looper.myLooper());
        if (r5 == true) goto L5;
        Intrinsics.checkNotNullParameter("ThreadUtils", "tag");
        Intrinsics.checkNotNullParameter("checkMainThread not in main thread", "msg");
        a1.a.f43a.e("ThreadUtils", "checkMainThread not in main thread", null);
    L5:
        if (r5 == true) goto L8;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("RTSInterface initialize must be called on main thread", "msg");
        a1.a.f43a.e("ai_bridge", "RTSInterface initialize must be called on main thread", null);
        return;
    L8:
        WeakHashMap<RelaxView, RelaxBridgeModule> r11 = relaxViewToRelaxBridgeModule;
        if (r11.get(r10) == null) goto L11;
        return;
    L11:
        RelaxBridgeModule r12 = new RelaxBridgeModule();
        r10.registerBridgeModule("AppletBridgeModule", r12);
        r11.put(r10, r12);
    }

    @JvmStatic
    public static final void release(RelaxView r5) {
        Intrinsics.checkNotNullParameter(r5, "relaxView");
        c1.b.b(new androidx.fragment.app.d(r5, 9));
    }

    private static final void release$lambda$1(RelaxView r5) {
        relaxViewToRelaxBridgeModule.remove(r5);
    }

    public final WeakHashMap<RelaxView, RelaxBridgeModule> getRelaxViewToRelaxBridgeModule() {
        return relaxViewToRelaxBridgeModule;
    }
}
