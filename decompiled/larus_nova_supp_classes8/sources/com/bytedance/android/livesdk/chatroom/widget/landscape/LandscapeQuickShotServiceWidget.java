package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Llt2/a;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotServiceWidget extends LiveRecyclableWidget {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LandscapeQuickShotServiceWidget a;

        public a(LandscapeQuickShotServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            lt2.a r3 = (lt2.a) r2;
            if (r3 == null) goto L6;
            this.a.onEvent(r3);
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public LandscapeQuickShotServiceWidget() {
    }

    public final void onEvent(lt2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (m50.a.getValue().q() == false) goto L8;
        long r5 = System.currentTimeMillis();
        bs1.b r0 = new bs1.b(((Widget) this).contentView, null, r8.a, r5);
        nm1.t r9 = pm1.f.q();
        if (r9 == null) goto L9;
        r9.j(((Widget) this).dataCenter, r0);
        return;
    L9:
        return;
    }

    public final void onLoad(Object[] r3) {
        z.o(((Widget) this).dataCenter);
        a r0 = new a(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(lt2.a.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r0);
    }
}
