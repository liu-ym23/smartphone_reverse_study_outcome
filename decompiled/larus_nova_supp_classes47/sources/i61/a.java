package i61;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements b {
    public final CompositeDisposable a;
    public final d61.a b;

    public abstract String a();

    @Override // i61.b
    public void onRelease() {
        this.a.clear();
    }

    public final d61.a getContext() {
        return this.b;
    }

    public a(PlatformExpRoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.a = new CompositeDisposable();
    }

    public final void b(n61.a r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.c(a() + " 生产source:" + r4);
        ExpOptLog.d(r0.b());
        this.b.getWorkshop().processSource(r4);
    }
}
