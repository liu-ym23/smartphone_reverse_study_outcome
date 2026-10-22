package vq0;

import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements IEventListener {
    public final MiniAppContext a;

    public a(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        this.a = r2;
    }
}
