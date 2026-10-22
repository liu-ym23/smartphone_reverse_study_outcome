package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import cy0.j;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import mz0.o;
import p11.h;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/AnchorLinkTopViewConfirmationDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "l", "I", "getType", "()I", "setType", "(I)V", "type", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkTopViewConfirmationDialog extends CommonBottomDialog {
    public static final /* synthetic */ int m = 0;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a a;
    public final com.bytedance.android.live.revlink.impl.pk.service.b b;
    public final IRoom c;
    public final Animation d;
    public final Animation e;
    public final Animation f;
    public final Animation g;
    public final l h;
    public final CompositeDisposable i;
    public final IBaseUser j;
    public final boolean k;
    public final int l;

    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ AnchorLinkTopViewConfirmationDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(AnchorLinkTopViewConfirmationDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkTopViewConfirmationDialog a;

        public b(AnchorLinkTopViewConfirmationDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(AnchorLinkTopViewConfirmationDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r24) {
            AnchorLinkTopViewConfirmationDialog r1 = this.a;
            int r2 = AnchorLinkTopViewConfirmationDialog.m;
            r1.P0("yes", "quit");
            int r3 = this.a.getType();
            long r10 = 0;
            if (r3 != 1) goto L5;
            HashMap r4 = new HashMap();
            if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L60;
            com.bytedance.android.live.revlink.impl.multianchor.service.d r5 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r5 == null) goto L58;
            i11.b r6 = r5.getLinkUserCenter();
            if (r6 == null) goto L58;
            Integer r7 = Integer.valueOf(r6.c());
        L59:
            r4.put("anchor_connect_status", String.valueOf(r7));
        L58:
            r7 = null;
        L60:
            r4.put("connection_type", "anchor");
            LinkCrossRoomDataHolder r8 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r8 == null) goto L63;
            Long r9 = Long.valueOf(r8.c());
        L64:
            r4.put("channel_id", String.valueOf(r9));
            LinkCrossRoomDataHolder r12 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r12 == null) goto L67;
            String r13 = x.f(r12.i());
        L68:
            r4.put("match_type", r13);
            n r14 = new n();
            o r15 = new o(r14.a);
            p0.a r16 = p0.Companion;
            MultiPkMatchContext r17 = com.bytedance.android.live.revlink.impl.global.b.G();
            if (r17 == null) goto L73;
            com.bytedance.live.datacontext.n<String> r18 = r17.getBattleAttachedInfo();
            if (r18 == null) goto L73;
            String r19 = (String) r18.getValue();
        L74:
            e21.c.e(r15, e21.c.c(r16, r19));
            r15.b(r4);
            m r20 = new m();
            LinkCrossRoomDataHolder.a r22 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.a(r20);
            r20.b(LogCommon.ROOM);
            ((ArrayList) r14.b).addAll(r20.a);
            cy0.e.a.getClass();
            j r23 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r25 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r25);
            ((i) ((f80.a) r25)).w3("livesdk_match_cancel_click", r14.a, r14.b);
            com.bytedance.android.live.revlink.impl.service.internal.a r26 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r26 != null) goto L77;
        L89:
            com.bytedance.android.live.revlink.impl.multianchor.service.a r27 = this.a.a;
            if (r27 != null) goto L92;
        L115:
            a(this.a);
            return;
        L92:
            if ((!r27.getLinkUserCenter().getInviteeList().isEmpty()) == false) goto L115;
            AnchorLinkTopViewConfirmationDialog r28 = this.a;
            if (r28.j == null) goto L105;
            Iterator<IBaseUser> r29 = r28.a.getLinkUserCenter().getInviteeList().iterator();
        L97:
            if (r29.hasNext() == false) goto L115;
            IBaseUser r30 = r29.next();
            if (TextUtils.equals(com.bytedance.android.live.base.model.user.o.a(this.a.j), com.bytedance.android.live.base.model.user.o.a(r30)) == false) goto L97;
            com.bytedance.android.live.revenuelink.connect.n r32 = this.a.a.getLinkOutManagerFn();
            LinkCrossRoomDataHolder r33 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r33 == null) goto L103;
            long r110 = r33.c();
        L104:
            long r111 = r30.getLiveRoomId();
            String r112 = iz.a.a(r30);
            Intrinsics.checkNotNullParameter(r30, "$this$secUidExt");
            r32.e(new d11.c(17, r110, r111, r112, r30.getCastSecUid(), 0, "ceiling_view_canel_individual"), null);
            goto L97
        L103:
            r110 = 0;
            goto L104
        L105:
            Iterator<IBaseUser> r34 = r28.a.getLinkUserCenter().getInviteeList().iterator();
        L107:
            if (r34.hasNext() == false) goto L115;
            IBaseUser r35 = r34.next();
            AnchorLinkTopViewConfirmationDialog r36 = this.a;
            if (r36.c == null) goto L107;
            com.bytedance.android.live.revenuelink.connect.n r37 = r36.a.getLinkOutManagerFn();
            LinkCrossRoomDataHolder r38 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r38 == null) goto L113;
            long r113 = r38.c();
        L114:
            long r114 = r35.getLiveRoomId();
            String r115 = iz.a.a(r35);
            Intrinsics.checkNotNullParameter(r35, "$this$secUidExt");
            r37.e(new d11.c(7, r113, r114, r115, r35.getCastSecUid(), 0, "ceiling_view_cancel_all"), null);
            goto L107
        L113:
            r113 = 0;
            goto L114
        L77:
            if (v.a(r26.getCurrentMode(), 4) == false) goto L89;
            AnchorLinkTopViewConfirmationDialog r39 = this.a;
            if (r39.j == null) goto L89;
            com.bytedance.android.live.revlink.impl.pk.service.b r40 = r39.b;
            if (r40 == null) goto L89;
            com.bytedance.android.live.revenuelink.connect.n r42 = r40.getLinkOutManagerFn();
            if (r42 == null) goto L89;
            LinkCrossRoomDataHolder r43 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r43 == null) goto L87;
            long r116 = r43.c();
        L88:
            r42.e(new d11.c(1, r116, this.a.j.getLiveRoomId(), iz.a.a(this.a.j), com.bytedance.android.live.base.model.user.o.a(this.a.j), 0, "ceiling_view_canel_individual"), null);
            goto L89
        L87:
            r116 = 0;
        L73:
            r19 = null;
            goto L74
        L67:
            r13 = "";
            goto L68
        L63:
            r9 = null;
            goto L64
        L5:
            if (r3 != 2) goto L7;
            HashMap r44 = new HashMap();
            if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L36;
            com.bytedance.android.live.revlink.impl.multianchor.service.d r45 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r45 == null) goto L34;
            i11.b r46 = r45.getLinkUserCenter();
            if (r46 == null) goto L34;
            Integer r47 = Integer.valueOf(r46.c());
        L35:
            r44.put("anchor_connect_status", String.valueOf(r47));
        L34:
            r47 = null;
        L36:
            r44.put("connection_type", "anchor");
            LinkCrossRoomDataHolder r48 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r48 == null) goto L39;
            Long r49 = Long.valueOf(r48.c());
        L40:
            r44.put("channel_id", String.valueOf(r49));
            n r50 = new n();
            Map<String, String> r52 = r50.a;
            Intrinsics.checkNotNullParameter(r52, "map");
            Intrinsics.checkNotNullParameter(r44, "map");
            r52.putAll(r44);
            m r53 = new m();
            LinkCrossRoomDataHolder.a r54 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.a(r53);
            r53.b(LogCommon.ROOM);
            ((ArrayList) r50.b).addAll(r53.a);
            cy0.e.a.getClass();
            j r55 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r56 = com.bytedance.android.scope.m.b(r55).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r56);
            ((i) ((f80.a) r56)).w3("livesdk_connectapplycancel_click", r50.a, r50.b);
            com.bytedance.android.live.revlink.impl.multianchor.service.a r57 = this.a.a;
            if (r57 != null) goto L43;
        L50:
            a(this.a);
            return;
        L43:
            if ((!r57.getLinkUserCenter().n().isEmpty()) == false) goto L50;
            IBaseUser r58 = (IBaseUser) ListProtector.get(this.a.a.getLinkUserCenter().n(), 0);
            AnchorLinkTopViewConfirmationDialog r59 = this.a;
            if (r59.c == null) goto L50;
            com.bytedance.android.live.revenuelink.connect.n r60 = r59.a.getLinkOutManagerFn();
            LinkCrossRoomDataHolder r62 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r62 == null) goto L49;
            r10 = r62.c();
        L49:
            long r117 = r58.getLiveRoomId();
            String r118 = iz.a.a(r58);
            Intrinsics.checkNotNullParameter(r58, "$this$secUidExt");
            r60.e(new d11.c(7, r10, r117, r118, r58.getCastSecUid(), 1, "ceiling_view_cancel_apply"), null);
            goto L50
        L39:
            r49 = null;
            goto L40
        L7:
            if (r3 == 3) goto L17;
            if (r3 != 4) goto L130;
            h r63 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
            if (r63 == null) goto L13;
            r63.H(false);
        L13:
            com.bytedance.android.live.revlink.impl.multianchor.match.a r64 = com.bytedance.android.live.revlink.impl.global.b.I();
            if (r64 == null) goto L16;
            r64.ni(0, "quit_link");
        L16:
            a(this.a);
            return;
        L130:
            return;
        L17:
            AnchorLinkTopViewConfirmationDialog.M0(this.a, "quit");
            com.bytedance.android.live.revlink.impl.multianchor.service.b r65 = com.bytedance.android.live.revlink.impl.global.b.w();
            if (r65 == null) goto L20;
            r65.setAnchorLinkFinisher(true);
        L20:
            com.bytedance.android.live.revlink.impl.multianchor.service.a r66 = this.a.a;
            if (r66 == null) goto L23;
            r66.finishMultiAnchor(7, null, false, "ceiling_view_leave", true);
        L23:
            com.bytedance.android.live.revlink.impl.multianchor.match.a r67 = com.bytedance.android.live.revlink.impl.global.b.I();
            if (r67 == null) goto L26;
            r67.ni(0, "quit_link");
        L26:
            a(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkTopViewConfirmationDialog a;

        public c(AnchorLinkTopViewConfirmationDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            AnchorLinkTopViewConfirmationDialog.M0(this.a, "continue");
            this.a.P0("no", "quit");
            this.a.O0();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkTopViewConfirmationDialog a;

        public d(AnchorLinkTopViewConfirmationDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            AnchorLinkTopViewConfirmationDialog r3 = this.a;
            int r0 = AnchorLinkTopViewConfirmationDialog.m;
            r3.O0();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorLinkTopViewConfirmationDialog a;

        public e(AnchorLinkTopViewConfirmationDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            zg1.d r5 = (zg1.d) sh6.c.b((sh6.b) r4);
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.b == false) goto L7;
        L9:
            boolean r6 = false;
        L10:
            if (r6 != true) goto L32;
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L14;
        L16:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L19 Exception -> L21
        L25:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L21:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
            if (r1 == null) goto L25;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L14:
            if (Looper.myLooper() == r0.getLooper()) goto L16;
            r0.post(DialogLancet.createDismissRunnable(r7));
            return;
        L32:
            return;
        L7:
            if (r5.c == true) goto L9;
            r6 = true;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkTopViewConfirmationDialog$onAttachedToWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(AnchorLinkTopViewConfirmationDialog r8) {
            super(1, r8, AnchorLinkTopViewConfirmationDialog.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Dialog, com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkTopViewConfirmationDialog, java.lang.Object] */
        public final void invoke(yh6.c r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            ?? r0 = (AnchorLinkTopViewConfirmationDialog) ((CallableReference) this).receiver;
            int r1 = AnchorLinkTopViewConfirmationDialog.m;
            r0.getClass();
            if ((r4 instanceof h1) == false) goto L18;
            i6 r5 = ((h1) r4).castTo(i6.class);
            if (((int) r5.getScene()) != 7) goto L7;
        L9:
            int r6 = (int) r5.getType2();
            if (r6 == 5) goto L15;
            if (r6 == 8) goto L15;
            return;
        L15:
            if (r0.isShowing() == false) goto L19;
            r0.O0();
            return;
        L19:
            return;
        L7:
            if (((int) r5.getScene()) == 2) goto L9;
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public final int getLayoutId() {
        return 2131565377;
    }

    public static Map N0() {
        HashMap r0 = new HashMap();
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        if (r2 == null) goto L8;
        r0.put("anchor_id", String.valueOf(iz.a.a(r2.getOwner())));
    L8:
        r0.put("room_status", "connection");
        r0.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final void O0() {
        this.g.setDuration(250);
        Animation r0 = this.g;
        if (r0 == null) goto L5;
        ((LinearLayout) findViewById(2131364442)).startAnimation(r0);
    L5:
        this.g.setAnimationListener(new a(this));
        Animation r1 = this.e;
        if (r1 == null) goto L9;
        findViewById(2131381758).startAnimation(r1);
        return;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        l r0 = this.h;
        if (r0 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r1 = yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        if (r1 == null) goto L11;
        final AnonymousClass1 r2 = new AnonymousClass1(this);
        Disposable r3 = r1.subscribe(new f(r2));
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.i);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.clear();
    }

    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.l != 3) goto L10;
        Map<? extends String, ? extends String> r0 = N0();
        ((HashMap) r0).put("action_type", "show");
        n r3 = new n();
        Map<String, String> r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r4.putAll(r0);
        m r1 = new m();
        r1.b(LogCommon.ROOM);
        ((ArrayList) r3.b).addAll(r1.a);
        cy0.e.a.getClass();
        j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r5 = com.bytedance.android.scope.m.b(r2).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r5);
        ((i) ((f80.a) r5)).w3("livesdk_connection_quit_window", r3.a, r3.b);
    L10:
        int r6 = this.l;
        if (r6 == 3) goto L13;
        if (r6 == 4) goto L13;
        return;
    L13:
        HashMap r7 = new HashMap();
        LinkCrossRoomDataHolder r8 = com.bytedance.android.live.revlink.impl.global.b.j();
        Integer r9 = null;
        if (r8 == null) goto L16;
        Long r10 = Long.valueOf(r8.c());
    L17:
        r7.put("channel_id", String.valueOf(r10));
        w31.c r12 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r12 == null) goto L20;
        Long r13 = Long.valueOf(r12.i());
    L21:
        r7.put("pk_id", String.valueOf(r13));
        com.bytedance.android.live.revlink.impl.service.internal.a r14 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r14 == null) goto L24;
        int r15 = r14.getCurrentMode();
    L26:
        if (v.a(r15, 4) == false) goto L28;
        r9 = 2;
    L33:
        r7.put("anchor_connect_status", String.valueOf(r9));
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r16 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r16 == null) goto L37;
        String r17 = r16.a;
        if (r17 == null) goto L37;
    L38:
        r7.put("source", r17);
        n r18 = new n();
        Map<String, String> r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r19.putAll(r7);
        m r20 = new m();
        r20.b(LogCommon.ROOM);
        ((ArrayList) r18.b).addAll(r20.a);
        cy0.e.a.getClass();
        j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r23);
        ((i) ((f80.a) r23)).w3("livesdk_connection_quit_comfirm_show", r18.a, r18.b);
        return;
    L37:
        r17 = "";
        goto L38
    L28:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r24 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r24 == null) goto L33;
        i11.b r25 = r24.getLinkUserCenter();
        if (r25 == null) goto L33;
        r9 = Integer.valueOf(r25.c());
        goto L33
    L24:
        r15 = 0;
        goto L26
    L20:
        r13 = null;
        goto L21
    L16:
        r10 = null;
        goto L17
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public final int getType() {
        return this.l;
    }

    public final void onBackPressed() {
        O0();
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        int r12 = this.l;
        if (r12 == 1) goto L12;
        if (r12 != 2) goto L6;
        ((TextView) findViewById(2131390381)).setText(2131914745);
    L13:
        ((TextView) findViewById(2131390381)).setOnClickListener(new b(this));
        y41.f r13 = y41.f.N;
        r13.getClass();
        if (((Boolean) y41.f.y.getValue(r13, y41.f.a[23])).booleanValue() == false) goto L70;
        b0 r1 = com.bytedance.android.live.revlink.impl.global.b.L();
        int r3 = 0;
        if (r1 == null) goto L25;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = r1.b();
        if (r4 == null) goto L25;
        if (r4.isBattleShow() != true) goto L25;
        if (r1.d() != PlayMode.TEAM_PK) goto L25;
        boolean r2 = true;
    L26:
        float r5 = 0.4f;
        if (r2 == false) goto L58;
        b0 r6 = com.bytedance.android.live.revlink.impl.global.b.L();
        if (r6 == null) goto L33;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r7 = r6.a();
        if (r7 == null) goto L33;
        Pair<List<String>, List<String>> r8 = r7.getTeamPkUids();
    L34:
        if (r8 != null) goto L36;
        r8 = TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L36:
        List r9 = (List) r8.component1();
        List r14 = (List) r8.component2();
        if (CollectionsKt.contains(r9, u.e()) == true) goto L44;
        if (CollectionsKt.contains(r14, u.e()) == false) goto L42;
        r9 = r14;
        goto L44
    L42:
        r9 = CollectionsKt.emptyList();
    L44:
        if (r9.size() > 2) goto L46;
    L48:
        boolean r15 = false;
    L50:
        if (r9.size() <= 1) goto L58;
        if (r15 == true) goto L58;
        UtilityKotlinExtentionsKt.w(findViewById(2131369233));
        UtilityKotlinExtentionsKt.w(findViewById(2131383578));
        TextView r16 = (TextView) findViewById(2131383578);
        if (this.k == false) goto L55;
        float r17 = 0.4f;
    L56:
        r16.setAlpha(r17);
        ((TextView) findViewById(2131383578)).setOnClickListener(x0.a(new AnchorLinkTopViewConfirmationDialog$initRelinkOptions$1(this)));
        goto L58
    L55:
        r17 = 1.0f;
        goto L56
    L46:
        if (r13.a() == false) goto L48;
        r15 = true;
    L33:
        r8 = null;
    L58:
        if (y.c() == false) goto L70;
        i11.b r18 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r18 == null) goto L64;
        List<p> r19 = r18.getOnlineUserList();
        if (r19 == null) goto L64;
        r3 = r19.size();
    L64:
        if (r3 <= 2) goto L70;
        UtilityKotlinExtentionsKt.w(findViewById(2131369234));
        UtilityKotlinExtentionsKt.w(findViewById(2131385812));
        TextView r0 = (TextView) findViewById(2131385812);
        if (this.k == true) goto L69;
        r5 = 1.0f;
    L69:
        r0.setAlpha(r5);
        ((TextView) findViewById(2131385812)).setOnClickListener(x0.a(new AnchorLinkTopViewConfirmationDialog$initRelinkOptions$2(this)));
    L25:
        r2 = false;
    L70:
        this.f.setDuration(250);
        Animation r110 = this.f;
        if (r110 == null) goto L73;
        ((LinearLayout) findViewById(2131364442)).startAnimation(r110);
    L73:
        Animation r111 = this.d;
        if (r111 == null) goto L76;
        findViewById(2131381758).startAnimation(r111);
    L76:
        this.d.setFillAfter(true);
        ((TextView) findViewById(2131390273)).setOnClickListener(new c(this));
        findViewById(2131381758).setOnClickListener(new d(this));
        ld.a r112 = ld.d.a();
        if (r112 == null) goto L86;
        NextLiveData r113 = r112.so();
        if (r113 == null) goto L87;
        Observable r114 = ld.c.a(r113);
        if (r114 == null) goto L88;
        Disposable r115 = r114.subscribe(new e(this));
        if (r115 == null) goto L89;
        this.i.add(r115);
        return;
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L6:
        if (r12 != 3) goto L8;
    L10:
        ((TextView) findViewById(2131390381)).setText(2131920594);
        goto L13
    L8:
        if (r12 == 4) goto L10;
    L12:
        ((TextView) findViewById(2131390381)).setText(2131914746);
        goto L13
    }

    public static final void M0(AnchorLinkTopViewConfirmationDialog r3, String r4) {
        if (r3.l != 3) goto L6;
        Map<? extends String, ? extends String> r5 = N0();
        HashMap r0 = (HashMap) r5;
        r0.put("action_type", "click");
        r0.put("click_content", r4);
        n r6 = new n();
        Map<String, String> r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.putAll(r5);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        List<Object> r2 = r6.b;
        ArrayList r8 = (ArrayList) r2;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((i) ((f80.a) r10)).w3("livesdk_connection_quit_window", r6.a, r6.b);
        return;
    }

    public final void P0(String r8, String r9) {
        int r0 = this.l;
        if (r0 == 3) goto L5;
        if (r0 == 4) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        LiveMode r3 = null;
        if (r2 == null) goto L8;
        Long r4 = Long.valueOf(r2.c());
    L9:
        r1.put("channel_id", String.valueOf(r4));
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r6 = false;
        if (r5 == null) goto L12;
        int r7 = r5.getCurrentMode();
    L14:
        if (v.a(r7, 4) == false) goto L16;
        Integer r10 = 2;
    L22:
        r1.put("anchor_connect_status", String.valueOf(r10));
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r12 = com.bytedance.android.live.revlink.impl.global.b.l();
        String r13 = "";
        if (r12 == null) goto L26;
        String r14 = r12.a;
        if (r14 == null) goto L26;
    L27:
        r1.put("source", r14);
        r1.put("selection", r8);
        r1.put("disconnect_scene", r9);
        if (this.l != 4) goto L36;
        String r15 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService().D();
        if (r15 != null) goto L32;
    L33:
        r6 = true;
    L34:
        if (r6 == true) goto L36;
        r1.put("transform_reason", String.valueOf(r15));
        goto L36
    L32:
        if (r15.length() != 0) goto L34;
    L36:
        d31.d r16 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r16 == null) goto L39;
        String r17 = r16.c();
    L40:
        r1.put("connection_type", r17);
        d31.d r18 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r18 == null) goto L43;
        r13 = r18.f();
    L43:
        r1.put("invite_mode", r13);
        w31.c r19 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r19 == null) goto L46;
        Long r20 = Long.valueOf(r19.i());
    L47:
        r1.put("pk_id", String.valueOf(r20));
        IRoom r22 = u.a();
        if (r22 == null) goto L51;
        r3 = r22.getStreamType();
    L51:
        if (r3 != LiveMode.SCREEN_RECORD) goto L53;
        r1.put("source", "connection");
    L53:
        n r23 = new n();
        Map<String, String> r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r24.putAll(r1);
        m r25 = new m();
        r25.b(LogCommon.ROOM);
        ((ArrayList) r23.b).addAll(r25.a);
        cy0.e.a.getClass();
        j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r27);
        ((i) ((f80.a) r27)).w3("livesdk_connection_quit_comfirm", r23.a, r23.b);
        return;
    L46:
        r20 = null;
        goto L47
    L39:
        r17 = "";
    L26:
        r14 = "";
        goto L27
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r28 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r28 == null) goto L21;
        i11.b r29 = r28.getLinkUserCenter();
        if (r29 == null) goto L21;
        r10 = Integer.valueOf(r29.c());
    L21:
        r10 = null;
        goto L22
    L12:
        r7 = 0;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public AnchorLinkTopViewConfirmationDialog(int r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.l = r2;
        this.a = com.bytedance.android.live.revlink.impl.global.b.t();
        this.b = com.bytedance.android.live.revlink.impl.global.b.N();
        com.bytedance.android.live.revenue.core.util.j.a r5 = com.bytedance.android.live.revenue.core.util.j.C0;
        k r6 = (k) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), k.class);
        if (r6 == null) goto L5;
        IRoom r7 = r6.getRoom();
    L6:
        this.c = r7;
        this.d = AnimationUtils.loadAnimation(r4, 2130772675);
        this.e = AnimationUtils.loadAnimation(r4, 2130772676);
        this.f = AnimationUtils.loadAnimation(r4, 2130772677);
        this.g = AnimationUtils.loadAnimation(r4, 2130772678);
        this.h = (l) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), l.class);
        this.i = new CompositeDisposable();
        this.j = null;
        boolean r8 = false;
        if (r41.f.a == false) goto L16;
        w r9 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r9 == null) goto L16;
        if (r9.i() <= 4) goto L13;
        boolean r10 = true;
    L14:
        if (r10 != true) goto L16;
        r8 = true;
        goto L16
    L13:
        r10 = false;
    L16:
        this.k = r8;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
