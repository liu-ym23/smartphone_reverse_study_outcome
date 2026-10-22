package com.bytedance.android.live.messagewindow.business.card;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends v61.a {
    public final DataCenter m;

    public static final class a implements t71.a {
        public final /* synthetic */ c a;

        public final Single<Boolean> a() {
            return null;
        }

        public final Object getIdentity() {
            return null;
        }

        public final void onIntercept() {
        }

        public a(c r1) {
            this.a = r1;
        }

        public final boolean b(v61.a r2) {
            Intrinsics.checkNotNullParameter(r2, "msgWindow");
            DataCenter r3 = this.a.m;
            if (r3 == null) goto L11;
            IRoom r4 = a0.n(r3);
            if (r4 == null) goto L11;
            IRoomAuthStatus r5 = r4.getRoomAuthStatus();
            if (r5 == null) goto L11;
            if (r5.enableBanner() == true) goto L11;
            return true;
        L11:
            return false;
        }
    }

    public final void I() {
        t(new am0.a(null));
        i(new a(this));
    }

    public final x61.h<?, ?> content() {
        x61.h.a.getClass();
        return x61.a.b;
    }

    public final DataCenter getDataCenter() {
        return this.m;
    }

    public c(DataCenter r3) {
        CardTypeAndPriority r0 = CardTypeAndPriority.Banner;
        super(r3, r0.getType(), r0.getPriority());
        this.m = r3;
    }
}
