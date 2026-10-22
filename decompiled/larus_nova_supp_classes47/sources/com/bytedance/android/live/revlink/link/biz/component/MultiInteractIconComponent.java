package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiInteractIconComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a c;
    public final MultiPKContextHolder d;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiInteractIconComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(MultiInteractIconComponent r8) {
            super(1, r8, MultiInteractIconComponent.class, "handleInteractIconClick", "handleInteractIconClick(Ljava/lang/Integer;)V", 0);
        }

        public final void invoke(Integer r9) {
            MultiInteractIconComponent r0 = (MultiInteractIconComponent) ((CallableReference) this).receiver;
            if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(r0.getContext()) == false) goto L8;
            Intrinsics.checkNotNullParameter(r0, "$this$pkService");
            com.bytedance.android.live.revlink.impl.pk.service.h r1 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r0).V0();
            if (r1 == null) goto L84;
            com.bytedance.android.live.revlink.impl.pk.service.h.a.a(r1, r9, 1);
            return;
        L84:
            return;
        L8:
            if (r9 == null) goto L10;
            int r10 = r9.intValue();
        L11:
            PkBaseDataContext r3 = r0.d.c.getBasePKContext();
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("channel_id", String.valueOf(r0.getContext().G()));
            if (r3.isInBreakThrough() == false) goto L15;
            String r5 = "pve";
        L18:
            r4.put("room_status", r5);
            r4.put("anchor_cnt", String.valueOf(((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r0).a).size()));
            r4.put("anchor_connect_status", String.valueOf(((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r0).a).size()));
            r4.put("pk_id", String.valueOf(r3.getPkId()));
            r4.putAll(com.bytedance.android.live.revlink.link.biz.service.i.T(r0).f());
            LiveMode r6 = IRoomKtKt.getStreamType(r0.getContext().getRoom());
            LiveMode r7 = LiveMode.SCREEN_RECORD;
            if (r6 != r7) goto L21;
            String r8 = DataType.TRUE;
        L22:
            r4.put("is_game", r8);
            mz0.n r12 = new mz0.n();
            Map<String, String> r13 = r12.a;
            Intrinsics.checkNotNullParameter(r13, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r13.putAll(r4);
            mz0.m r14 = new mz0.m();
            r14.b(LogCommon.ROOM);
            ((ArrayList) r12.b).addAll(r14.a);
            cy0.e.a.getClass();
            cy0.j r15 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r16);
            ((mz0.i) ((f80.a) r16)).w3("livesdk_interact_icon_click", r12.a, r12.b);
            if (IRoomKtKt.getStreamType(r0.getContext().getRoom()) != r7) goto L26;
            r0.getContext().ko().f();
            return;
        L26:
            if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.link.biz.service.i.K(r0)) == false) goto L44;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r17 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r17 != null) goto L30;
        L34:
            com.bytedance.android.live.revlink.impl.multianchor.match.a r18 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r18 != null) goto L37;
        L41:
            com.bytedance.android.live.revlink.impl.multianchor.service.c r19 = com.bytedance.android.live.revlink.link.biz.service.i.D(r0);
            if (r19 == null) goto L91;
            r19.Da();
            return;
        L91:
            return;
        L37:
            if (r18.po() != true) goto L41;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r20 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r20 == null) goto L89;
            r20.Wd();
            return;
        L89:
            return;
        L30:
            if (r17.Yj() != true) goto L34;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r22 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r22 == null) goto L87;
            r22.Wd();
            return;
        L87:
            return;
        L44:
            com.bytedance.android.live.revlink.impl.multianchor.match.a r23 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r23 != null) goto L47;
        L51:
            List<i11.d> r24 = r0.getContext().getAnchorLinkUserCenter().s();
            Iterator<T> r25 = r24.iterator();
        L53:
            if (r25.hasNext() == false) goto L57;
            Object r26 = r25.next();
            if (Intrinsics.areEqual(((i11.d) r26).b, "team_pk_invite") == false) goto L53;
        L58:
            if (r26 == null) goto L60;
            boolean r27 = true;
        L62:
            if ((!r24.isEmpty()) == false) goto L70;
            if (r27 == false) goto L67;
            com.bytedance.android.live.revlink.impl.multianchor.service.c r28 = com.bytedance.android.live.revlink.link.biz.service.i.D(r0);
            if (r28 == null) goto L95;
            r28.r6();
            return;
        L95:
            return;
        L67:
            com.bytedance.android.live.revlink.impl.multianchor.service.c r29 = com.bytedance.android.live.revlink.link.biz.service.i.D(r0);
            if (r29 == null) goto L97;
            r29.Da();
            return;
        L97:
            return;
        L70:
            com.bytedance.android.live.revlink.impl.multianchor.service.a r30 = com.bytedance.android.live.revlink.link.biz.service.i.w(r0);
            if (r30 == null) goto L77;
            MultiAnchorRelinkService r32 = r30.Fa();
            if (r32 == null) goto L77;
            if ((r32.k() instanceof com.bytedance.android.live.revlink.impl.multianchor.connect.n.b) != true) goto L77;
            r0.getContext().ko().d();
            return;
        L77:
            com.bytedance.android.live.revlink.impl.multianchor.service.c r2 = com.bytedance.android.live.revlink.link.biz.service.i.D(r0);
            if (r2 == null) goto L100;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r2, r10, 0, "icon_click", 2);
            return;
        L100:
            return;
        L60:
            r27 = false;
            goto L62
        L57:
            r26 = null;
            goto L58
        L47:
            if (r23.po() != true) goto L51;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r33 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r33 == null) goto L93;
            r33.Wd();
            return;
        L93:
            return;
        L21:
            r8 = DataType.FALSE;
            goto L22
        L15:
            if (r3.getCurPKBaseState().b() == true) goto L17;
            r5 = "npk";
            goto L18
        L17:
            r5 = "connection";
            goto L18
        L10:
            r10 = 0;
            goto L11
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Integer) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().ko().c(), new AnonymousClass1(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.c;
    }

    public MultiInteractIconComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, MultiPKContextHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkContextHolder");
        this.c = r2;
        this.d = r3;
        this.a = "MultiInteractIconComponent";
        this.b = new CompositeDisposable();
    }
}
