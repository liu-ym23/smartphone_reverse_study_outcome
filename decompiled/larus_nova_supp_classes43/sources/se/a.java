package se;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.adapter.impl.converter.c;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import wd.e;
import wd.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f {
    public final IExternalViewGroup a;

    public a(IExternalViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "liveViewGroup");
        this.a = r10;
    }

    @Override // wd.f
    public final void a(StartLivePromotionButton r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        IExternalViewGroup r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.add(c.C0114c.b.a(r10));
    }

    @Override // wd.f
    public final void addListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        IExternalViewGroup r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.addListener(c.d.b.a(r10));
    }

    @Override // wd.f
    public final void b(StartLivePromotionButton r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        IExternalViewGroup r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.remove(c.C0114c.b.b(r10));
    }

    @Override // wd.f
    public final void removeListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        IExternalViewGroup r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.removeListener(c.d.b.b(r10));
    }
}
