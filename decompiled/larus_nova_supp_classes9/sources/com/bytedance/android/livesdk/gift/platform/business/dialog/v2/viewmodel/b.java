package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.live.datacontext.EventMember;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Function1<GiftStateMachineConfig.Event, Boolean> {
    public final Map<Class<? extends GiftStateMachineConfig.g>, Set<GiftStateMachineConfig.Event.LazyEvent>> a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            b.a(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.b$b, reason: collision with other inner class name */
    public static final class C0039b<T> implements Observer {
        public final /* synthetic */ b a;

        public C0039b(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            b.a(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            b.a(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            b.a(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public b() {
        this.a = new LinkedHashMap();
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        k<GiftStateMachineConfig.Event> r1 = r0.getGiftActionManager();
        if (r1 == null) goto L9;
        EventMember.InterceptorSet r2 = r1.b();
        if (r2 == null) goto L9;
        r2.b(this);
    L9:
        com.bytedance.android.livesdk.gift.util.b.d("GiftListViewModel", null, new a(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftTabViewModel", null, new C0039b(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", null, new c(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftComboViewModel", null, new d(this), true);
    }

    public final Object invoke(Object r5) {
        GiftStateMachineConfig.Event r6 = (GiftStateMachineConfig.Event) r5;
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof GiftStateMachineConfig.Event.LazyEvent) == false) goto L14;
        GiftStateMachineConfig.Event.LazyEvent r0 = (GiftStateMachineConfig.Event.LazyEvent) r6;
        if (r0.b != GiftStateMachineConfig.Event.LazyEvent.LazyEventState.INITIALIZE) goto L17;
        if (((LinkedHashMap) this.a).get(r0.d) != null) goto L9;
        this.a.put(r0.d, SetsKt.mutableSetOf(new GiftStateMachineConfig.Event.LazyEvent[]{r0}));
    L18:
        return Boolean.TRUE;
    L9:
        Set r1 = (Set) ((LinkedHashMap) this.a).get(r0.d);
        if (r1 == null) goto L18;
        r1.add(r6);
    L17:
        return Boolean.FALSE;
    L14:
        if ((r6 instanceof GiftStateMachineConfig.Event.g0) == false) goto L17;
        ((LinkedHashMap) this.a).clear();
        goto L17
    }

    public static final void a(b r2, GiftStateMachineConfig.g r3) {
        if (r3 == null) goto L11;
        Map<Class<? extends GiftStateMachineConfig.g>, Set<GiftStateMachineConfig.Event.LazyEvent>> r0 = r2.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Set r4 = (Set) r1.get(r3.getClass());
        r2.a.remove(r3.getClass());
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L19;
        GiftStateMachineConfig.Event.LazyEvent r6 = (GiftStateMachineConfig.Event.LazyEvent) r5.next();
        GiftStateMachineConfig.Event.LazyEvent.LazyEventState r7 = r6.b;
        GiftStateMachineConfig.Event.LazyEvent.LazyEventState r8 = GiftStateMachineConfig.Event.LazyEvent.LazyEventState.FINISH;
        if (r7 == r8) goto L7;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r6.b = r8;
        com.bytedance.android.livesdk.gift.util.b.f(r6.c);
        goto L7
    L19:
        return;
    L18:
        return;
    L11:
        r2.getClass();
    }
}
