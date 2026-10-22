package og0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineTimerView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends jg0.b<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a d;
    public HSImageView e;
    public LinkMicQuickInteractView f;
    public SelfDisciplineTimerView g;
    public AnchorPauseTipsView h;
    public ViewGroup i;
    public final g j;

    /* JADX INFO: renamed from: og0.a$a, reason: collision with other inner class name */
    public static final class C0246a {
    }

    static {
    }

    @Override // jg0.b
    public final int b() {
        return 2131566614;
    }

    @Override // jg0.f
    public final void onDetach() {
        this.d = null;
        ViewGroup r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L5:
        UtilityKotlinExtentionsKt.t(r0);
        SelfDisciplineTimerView r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L8:
        r1.b();
        HSImageView r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L11:
        r2.setVisibility(8);
    }

    @Override // jg0.b
    public final String c() {
        return VerticalNitaInflate.Tag.MultiLinkMicSelfDisciplineLayer.name();
    }

    public final boolean g() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L11;
        e r2 = r0.k;
        if (r2 == null) goto L11;
        ILinkPlayerInfoBridge r3 = r2.a;
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L11;
        String r5 = r4.getIdString();
    L12:
        m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L18;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L18;
        r1 = r7.getOwnerUserIdString();
    L18:
        return Intrinsics.areEqual(r5, r1);
    L11:
        r5 = null;
        goto L12
    }

    public final void h() {
        SelfDisciplineContext.a r0 = SelfDisciplineContext.Companion;
        boolean r3 = true;
        if (r0.e() == false) goto L74;
        LinkMicQuickInteractView r1 = this.f;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L7:
        r1.setVisibility(8);
        if (this.b == 0) goto L10;
        return;
    L10:
        if (g() == true) goto L99;
        AnchorPauseTipsView r2 = this.h;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("leaveView");
    L15:
        if (r2.getVisibility() == 0) goto L100;
        MultiLinkGuestViewBinder.a r4 = this.d;
        Integer r5 = null;
        if (r4 == null) goto L25;
        e r6 = r4.k;
        if (r6 == null) goto L25;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L25;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
    L27:
        if ((!Intrinsics.areEqual(r9, je0.d.b0())) == false) goto L29;
    L30:
        ViewGroup r10 = this.i;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L33:
        UtilityKotlinExtentionsKt.w(r10);
        SelfDisciplineTimerView r11 = this.g;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L36:
        r11.setVisibility(0);
        MultiLinkGuestViewBinder.a r12 = this.d;
        if (r12 == null) goto L102;
        e r13 = r12.k;
        if (r13 == null) goto L103;
        ILinkPlayerInfoBridge r14 = r13.a;
        if (r14 == null) goto L104;
        SelfDisciplineTimerView r15 = this.g;
        if (r15 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L45:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "playerInfo");
        r15.c = r14;
        IBaseUser r16 = r14.getUser();
        Intrinsics.checkNotNull(r16);
        String r17 = r16.getIdString();
        long r18 = r14.getSelfDisciplineDuration();
        if (r15.b.containsKey(r17) == false) goto L58;
        Long r19 = r15.b.get(r17);
        if (r19 != null) goto L50;
    L59:
        TextView r20 = (TextView) r15.a(2131391592);
        if (r20 == null) goto L63;
        r5 = Integer.valueOf(r20.getVisibility());
    L63:
        if (r5.intValue() == 0) goto L70;
        TextView r21 = (TextView) r15.a(2131391592);
        if (r21 == null) goto L67;
        r21.setVisibility(0);
    L67:
        TextView r22 = (TextView) r15.a(2131391592);
        if (r22 == null) goto L70;
        r22.setText(SelfDisciplineTimerView.d(0));
    L70:
        Disposable r23 = r15.d;
        if (r23 == null) goto L73;
        r23.dispose();
    L73:
        r15.d = Observable.interval(0, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.a(r15, r17));
        return;
    L50:
        if (r18 > r19.longValue()) goto L53;
        r3 = false;
    L53:
        if (r3 == true) goto L56;
        r19 = null;
    L56:
        if (r19 == null) goto L59;
        r15.b.put(r17, Long.valueOf(r18));
        goto L59
    L58:
        r15.b.put(r17, Long.valueOf(r18));
        goto L59
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L29:
        if (r0.f() == false) goto L30;
        return;
    L25:
        r9 = null;
        goto L27
    L100:
        return;
    L99:
        return;
    L74:
        ViewGroup r24 = this.i;
        if (r24 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L78:
        if (r24.getVisibility() != 0) goto L106;
        ViewGroup r25 = this.i;
        if (r25 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L82:
        UtilityKotlinExtentionsKt.t(r25);
        SelfDisciplineTimerView r26 = this.g;
        if (r26 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("timerView");
    L85:
        r26.b();
        MultiLinkGuestViewBinder.a r27 = this.d;
        if (r27 == null) goto L107;
        e r28 = r27.k;
        if (r28 == null) goto L108;
        ILinkPlayerInfoBridge r29 = r28.a;
        if (r29 != null) goto L92;
        return;
    L92:
        if (r29.isOpenSendGift() != true) goto L110;
        LinkMicQuickInteractView r30 = this.f;
        if (r30 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L96:
        r30.setVisibility(0);
        return;
    L110:
        return;
    L108:
        return;
    L107:
        return;
    }

    @Override // jg0.b, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        View r3 = this.j.m(2131389576);
        if (r3 == null) goto L26;
        this.f = (LinkMicQuickInteractView) r3;
        AnchorPauseTipsView r4 = this.j.m(2131389641);
        if (r4 == null) goto L24;
        this.h = r4;
        HSImageView r5 = this.j.m(2131389766);
        if (r5 == null) goto L22;
        this.e = r5;
        View r6 = this.j.m(2131389767);
        if (r6 == null) goto L20;
        this.g = (SelfDisciplineTimerView) r6;
        View r7 = this.j.m(2131385873);
        if (r7 == null) goto L18;
        this.i = (ViewGroup) r7;
        HSImageView r8 = this.e;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L15:
        r8.setVisibility(8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineTimerView");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.widget.HSImageView");
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.common.AnchorPauseTipsView");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView");
    }

    public a(MultiLinkCommonGuestMicSeatBasicLayer r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "basicLayer");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r3);
        this.j = r2;
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r1;
        Intrinsics.checkNotNullParameter(r3, "itemData");
        this.d = r3;
        h();
    }

    @Override // jg0.f
    public final void k(Object r6, int r7, Bundle r8) {
        MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r6;
        Intrinsics.checkNotNullParameter(r9, "itemData");
        Intrinsics.checkNotNullParameter(r8, "payload");
        this.d = r9;
        if (SelfDisciplineContext.Companion.e() == false) goto L8;
        LinkMicQuickInteractView r10 = this.f;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L7:
        r10.setVisibility(8);
    L8:
        Iterator<String> r11 = r8.keySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L83;
        String r12 = r11.next();
        if (r12 == null) goto L10;
        int r13 = r12.hashCode();
        if (r13 != (-1417529401)) goto L17;
        if (r12.equals("payload_key_self_discipline_duration_update") == false) goto L10;
        h();
        goto L10
    L17:
        if (r13 != (-1010189482)) goto L10;
        if (r12.equals("payload_key_background_status_update") == false) goto L10;
        MultiLinkGuestViewBinder.a r14 = this.d;
        boolean r15 = false;
        if (r14 == null) goto L30;
        e r16 = r14.k;
        if (r16 == null) goto L30;
        ILinkPlayerInfoBridge r17 = r16.a;
        if (r17 == null) goto L30;
        if (r17.isBackground() != true) goto L30;
        boolean r18 = true;
    L31:
        MultiLinkGuestViewBinder.a r1 = this.d;
        if (r1 == null) goto L10;
        e r2 = r1.k;
        if (r2 == null) goto L10;
        ILinkPlayerInfoBridge r3 = r2.a;
        if (r3 == null) goto L10;
        if (r3.getSilenceStatus() == 0) goto L41;
        r15 = true;
    L41:
        IBaseUser r4 = r3.getUser();
        String r5 = null;
        if (r4 == null) goto L44;
        String r19 = r4.getIdString();
    L45:
        m r20 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r20 == null) goto L50;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L50;
        r5 = r21.getOwnerUserIdString();
    L50:
        boolean r22 = Intrinsics.areEqual(r19, r5);
        if (je0.d.D() == true) goto L61;
        l.n2.getClass();
        l r23 = l.a.a();
        if (r23 != null) goto L55;
    L57:
        if (r18 == false) goto L59;
        LayerBackgroundStatus r24 = LayerBackgroundStatus.Leave;
    L68:
        int r25 = b.a[r24.ordinal()];
        if (r25 == 1) goto L79;
        if (r25 == 2) goto L79;
        if (r25 != 3) goto L10;
        ViewGroup r26 = this.i;
        if (r26 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("selfDisciplineContainer");
    L78:
        UtilityKotlinExtentionsKt.t(r26);
    L79:
        h();
        goto L10
    L59:
        r24 = LayerBackgroundStatus.Normal;
        goto L68
    L55:
        if (r23.isEngineOn() != true) goto L57;
    L61:
        if (r3.isSelfBackground() == true) goto L63;
        r24 = LayerBackgroundStatus.Normal;
        goto L68
    L63:
        if (r15 == true) goto L67;
        if (r22 == true) goto L67;
        r24 = LayerBackgroundStatus.Audio;
    L67:
        r24 = LayerBackgroundStatus.Leave;
        goto L68
    L44:
        r19 = null;
    L30:
        r18 = false;
        goto L31
    }
}
