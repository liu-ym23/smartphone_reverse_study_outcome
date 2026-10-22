package com.bytedance.android.live.profit.livepet;

import com.bytedance.android.live.profit.livepet.utils.CachedEvent;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.livesdk.message.model.p7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.g;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LivePetMessageDispatcher implements o {
    public final CompositeDisposable a;
    public final CachedEvent<cb> b;
    public final g c;
    public final f d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.LivePetMessageDispatcher$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/p7;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/p7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<p7, Unit> {
        public AnonymousClass1(LivePetMessageDispatcher r8) {
            super(1, r8, LivePetMessageDispatcher.class, "onMessage", "onMessage(Lcom/bytedance/android/livesdk/message/model/IGiftPlayEventMessage;)V", 0);
        }

        public final void invoke(p7 r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            LivePetMessageDispatcher r0 = (LivePetMessageDispatcher) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "message");
            if (r4.getBizType() != 1) goto L9;
            Iterator r5 = r4.getPetEffectInfo().iterator();
        L7:
            if (r5.hasNext() == false) goto L11;
            r0.a((cb) r5.next(), "IM");
            goto L7
        L11:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((p7) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        jy0.b.a("LivePet/MessageDispatcher", "roomId = " + IRoomKtKt.getId(this.c.mo444getRoom()));
        f r0 = this.d;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$GIFT_PLAY_EVENT_MESSAGE");
        Observable r3 = h.a.a(r0, (yh6.b) CommonMessageTypeKt.V.getValue(), false, 6);
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new b(r4)), this.a);
    }

    public final void onStop() {
        this.b.a.clear();
        this.a.dispose();
    }

    public LivePetMessageDispatcher(g r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "roomMessageService");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = new CachedEvent("PetEffectInfo");
    }

    public final void a(cb r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "petEffectInfo");
        Intrinsics.checkNotNullParameter(r4, "source");
        jy0.b.d("LivePet/MessageDispatcher", "dispatch pet effect info, source = " + r4 + ", actionType = " + r3.getActionType() + ", actionExtra = " + r3.getActionExtra() + ", petMeta = " + r3.getPetMeta());
        this.b.b(r3);
    }
}
