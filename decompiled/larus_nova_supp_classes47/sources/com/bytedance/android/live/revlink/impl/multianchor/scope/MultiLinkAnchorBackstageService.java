package com.bytedance.android.live.revlink.impl.multianchor.scope;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.livesdk.link.model.s;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLinkAnchorBackstageService implements o {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final f c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.scope.MultiLinkAnchorBackstageService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiLinkAnchorBackstageService r8) {
            super(1, r8, MultiLinkAnchorBackstageService.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r40) {
            final MultiLinkAnchorBackstageService r2 = (MultiLinkAnchorBackstageService) ((CallableReference) this).receiver;
            int r3 = MultiLinkAnchorBackstageService.e;
            r2.getClass();
            jy0.b.d("MultiLinkAnchorBackstageService", "receive message " + r40);
            if ((r40 instanceof s) == false) goto L12;
            s r1 = (s) r40;
            if (r1.getScene() == 17) goto L13;
            int r4 = l.b;
            v3 r5 = e21.b.b(r2.d.getClientAttachedInfoObj(), l.a.c, "connection", null, null, null, null, 124);
            com.bytedance.android.live.revenuelink.connect.f r6 = r2.d.Z0();
            if (r6 == null) goto L14;
            n r7 = r6.linkOutManager();
            if (r7 == null) goto L15;
            int r8 = r1.getScene();
            long r9 = IRoomKtKt.getId(r2.b.getRoomContext().getCommonRoom());
            long r10 = CastLongProtector.parseLong(r1.getToRoomId());
            int r12 = r1.getInviteType();
            int r13 = r1.getMatchType();
            String r14 = r1.getToRevUid();
            int r17 = r1.getBizType();
            int r23 = r1.getInviteSource();
            Intrinsics.checkNotNullParameter(r1, "$this$inviteeUserIds");
            r7.f(new d11.d(r8, r9, r10, r12, r13, r14, "", null, r17, null, 0, null, 0, r23, null, 0, StringsKt.split$default(r1.getToRevInviteeFollowedUserIds(), new String[]{","}, false, 0, 6, null), null, null, null, 0, 0, 0, null, w3.a(r5), null, null, null, 520019456), new MultiLinkAnchorBackstageService$onMessage$1(r2), MultiLinkAnchorBackstageService$onMessage$2.INSTANCE, null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        jy0.b.d("MultiLinkAnchorBackstageService", "register message");
        f r0 = this.c;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$ANCHOR_LINK_MIC_BACKSTAGE_INVITE_MESSAGE");
        Observable r3 = h.a.a(r0, (yh6.b) CommonMessageTypeKt.Q.getValue(), false, 6);
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new b(r4)), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public MultiLinkAnchorBackstageService(com.bytedance.android.livesdk.revenue.service.room.c r2, f r3, com.bytedance.android.live.revlink.impl.global.c r4) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "linkService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
    }
}
