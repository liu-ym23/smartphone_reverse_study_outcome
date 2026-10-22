package pja;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public AlphaVideoViewType a;
    public final Context b;
    public final LifecycleOwner c;

    public final Context getContext() {
        return this.b;
    }

    public a(Context r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.b = r2;
        this.c = r3;
        this.a = AlphaVideoViewType.GL_SURFACE_VIEW;
    }
}
