package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiteInteractionPlugin extends x implements com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.b {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable b;
    public final Lazy c;
    public final DataCenter d;
    public final o e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiteInteractionPlugin a;

        public b(LiteInteractionPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            t42.a r10 = (t42.a) r9;
            if (r10 == null) goto L32;
            int r0 = k.a;
            k.a("LiteInteractionPlugin receive event: " + r10);
            LiteInteractionPlugin r1 = this.a;
            com.bytedance.android.live.base.model.liteinteraction.b r2 = r10.b.a.a();
            r1.getClass();
            if (r2 == null) goto L22;
            List r3 = r2.a();
            if (r3 == null) goto L31;
            Iterator<T> r4 = r3.iterator();
        L11:
            if (r4.hasNext() == false) goto L33;
            com.bytedance.android.live.base.model.liteinteraction.a r5 = (com.bytedance.android.live.base.model.liteinteraction.a) r4.next();
            Iterator<T> r6 = ((List) r1.c.getValue()).iterator();
        L14:
            if (r6.hasNext() == false) goto L18;
            T r7 = r6.next();
            if (((com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a) r7).b(r5.a()) == false) goto L14;
        L19:
            com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a r8 = r7;
            if (r8 == null) goto L11;
            int r11 = k.a;
            k.a("processor " + r8.a() + " match");
            r8.c(r10, r5, r1.b);
            goto L11
        L18:
            r7 = (T) null;
            goto L19
        L33:
            return;
        L31:
            return;
        L22:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        k.a("LiteInteractionPlugin onUnload");
        this.b.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        k.a("LiteInteractionPlugin onLoad");
        Disposable r3 = xs2.b.a().b(t42.a.class).subscribe(new b(this));
        if (r3 == null) goto L6;
        RxUtilKt.c(r3, this.b);
        return;
    }

    public LiteInteractionPlugin(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.d = r2;
        this.e = r3;
        this.b = new CompositeDisposable();
        this.c = LazyKt.lazy(new LiteInteractionPlugin$processors$2(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.b
    public final void c(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r3, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Intrinsics.checkNotNullParameter(r4, "action");
        l r0 = o();
        if (r0 == null) goto L15;
        j<? extends v42.b> r1 = r0.getMessageLogicFacade();
        if (r1 == null) goto L16;
        v42.b r2 = (v42.b) r1.getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.l) == true) goto L11;
        r2 = null;
    L11:
        com.bytedance.android.livesdk.interactivity.api.l r5 = (com.bytedance.android.livesdk.interactivity.api.l) r2;
        if (r5 == null) goto L18;
        r5.c(r3, r4);
        return;
    L18:
        return;
    L16:
        return;
    }
}
