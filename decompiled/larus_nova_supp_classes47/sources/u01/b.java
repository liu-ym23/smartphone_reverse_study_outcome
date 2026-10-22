package u01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.platformplayer.layout.p1;
import com.bytedance.android.livesdkapi.service.IFeedRevenueContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements kc0.d {
    public final MediatorLiveData a;
    public final IFeedRevenueContext b;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MediatorLiveData a;

        public a(MediatorLiveData r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            com.bytedance.android.live.platformplayer.layout.e r12 = (com.bytedance.android.live.platformplayer.layout.e) r10;
            if ((r12 instanceof p1) == true) goto L5;
            r12 = null;
        L5:
            p1 r13 = (p1) r12;
            if (r13 == null) goto L10;
            this.a.setValue(new rc0.c(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f));
            return;
        }
    }

    public final boolean getInnerMovePlayer() {
        return this.b.getInnerMovePlayer();
    }

    public final MediatorLiveData getPlayerEvent() {
        return this.a;
    }

    public b(IFeedRevenueContext r3) {
        Intrinsics.checkNotNullParameter(r3, "base");
        this.b = r3;
        LiveData r4 = r3.getPlayerEvent();
        if (r4 == null) goto L5;
        MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r4, new a(r0));
    L6:
        this.a = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }
}
