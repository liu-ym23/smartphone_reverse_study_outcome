package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends x {
    public static final /* synthetic */ int d = 0;
    public final CompositeDisposable b;
    public final o c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            final u22.l r5 = (u22.l) r4;
            r5.a.u1();
            v42.b r0 = (v42.b) this.a.getMessageLogicFacade().getValue();
            if (r0 != null) goto L5;
        L10:
            Boolean r1 = p.a;
            p.b(r5.a.getMessageMethod(), "gather_add", MapsKt.mapOf(TuplesKt.to("msg_show_type", "public_screen_similar_gather")));
            return;
        L5:
            if ((r0 instanceof com.bytedance.android.livesdk.interactivity.api.l) == true) goto L7;
            r0 = null;
        L7:
            com.bytedance.android.livesdk.interactivity.api.l r2 = (com.bytedance.android.livesdk.interactivity.api.l) r0;
            if (r2 == null) goto L10;
            r2.c(new TopAggregateMsgPlugin$onLoad$1$$special$$inlined$also$lambda$1(r5), TopAggregateMsgPlugin$onLoad$1$2$2.INSTANCE);
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        this.b.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r3) {
        Intrinsics.checkNotNullParameter(r3, "publicScreenContext");
        RxUtilKt.c(xs2.b.a().b(u22.l.class).subscribe(new b(r3)), this.b);
    }

    public h(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.c = r3;
        this.b = new CompositeDisposable();
    }
}
