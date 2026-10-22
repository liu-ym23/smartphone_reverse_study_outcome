package lr0;

import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements IEventListener {
    public final MiniGameContext a;

    public a(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        this.a = r2;
    }
}
