package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.multianchor.ui.i;
import com.bytedance.android.live.revlink.impl.pk.service.h;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements k {
    public final CompositeDisposable a;
    public final yz0.f b;
    public C0126a c;
    public final AnchorAudioPunishManager$punishMsgObserver$1 d;
    public final com.bytedance.android.live.revlink.impl.global.c e;
    public final boolean f;
    public final IRoom g;
    public final e h;
    public final i i;
    public final ld.a j;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.a$a, reason: collision with other inner class name */
    public static final class C0126a extends com.bytedance.android.live.countdown.a {
        public final /* synthetic */ a e;

        public final void b() {
        }

        public final void c(long r3) {
            long r4 = r3 / ((long) WebcastRedirectException.UNKNOWN);
            e r0 = this.e.h;
            if (r0 == null) goto L8;
            MutableLiveData<Long> r1 = r0.getAudioPunishRemainTime();
            if (r1 == null) goto L9;
            r1.setValue(Long.valueOf(r4));
            return;
        L9:
            return;
        }

        public C0126a(a r1, long r2) {
            this.e = r1;
            super(r2);
        }
    }

    public final void detach() {
        e r0 = this.h;
        if (r0 == null) goto L7;
        MutableLiveData<Long> r1 = r0.getAudioPunishRemainTime();
        if (r1 == null) goto L7;
        r1.setValue(0L);
    L7:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.e;
        c r3 = null;
        if (r2 == null) goto L10;
        c r4 = r2.Oj();
    L11:
        if (r4 == null) goto L15;
        LiveData<z> r5 = r4.getAudioPunishInfo();
        if (r5 == null) goto L15;
        r5.removeObserver(this.d);
    L15:
        com.bytedance.android.live.revlink.impl.global.c r6 = this.e;
        if (r6 == null) goto L18;
        r3 = r6.Oj();
    L18:
        if (r3 == null) goto L20;
        r3.reset();
    L20:
        C0126a r7 = this.c;
        if (r7 == null) goto L30;
        monitor-enter(r7);
        ((com.bytedance.android.live.countdown.a) r7).b = true;     // Catch: Throwable -> L27
        monitor-exit(r7);
    L27:
        th = move-exception;
        throw th;
    L30:
        this.a.dispose();
        return;
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.e;
    }

    public final void a(z r18) {
        String r0 = r18.getUserId();
        IRoom r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L7;
        IBaseUser r4 = r2.getOwnerKt();
        if (r4 == null) goto L7;
        String r5 = iz.a.a(r4);
    L8:
        boolean r6 = Intrinsics.areEqual(String.valueOf(r0), String.valueOf(r5));
        jy0.b.d("audio_punish", "handlePunish isSelfPunish = " + r6 + ", punishUserId = " + r0 + ", sec = " + r18.getRemainSeconds());
        if (r6 == false) goto L16;
        e r1 = this.h;
        if (r1 == null) goto L16;
        MutableLiveData<z> r7 = r1.getAudioPunishInfo();
        if (r7 == null) goto L16;
        r7.postValue(r18);
    L16:
        boolean r8 = this.f;
        String r9 = DataType.TRUE;
        boolean r10 = false;
        if (r8 == false) goto L71;
        jy0.b.d("audio_punish", "handlePunishForAnchor isSelfPunish = " + r6 + ", remainSeconds = " + r18.getRemainSeconds() + ", ");
        if (r6 == true) goto L21;
        com.bytedance.android.live.revlink.impl.global.c r12 = this.e;
        if (r12 == null) goto L54;
        h r13 = r12.V0();
        if (r13 == null) goto L54;
        LiveData<Boolean> r14 = r13.getGuestMuteState();
        if (r14 == null) goto L54;
        Boolean r15 = (Boolean) r14.getValue();
        if (r15 == null) goto L54;
    L55:
        boolean r16 = r15.booleanValue();
        if (r18.getRemainSeconds() <= 0) goto L60;
        if (r16 == true) goto L60;
        int r17 = ToastUtil.a;
        ToastUtil.b(r18.getContent(), 0);
    L60:
        if (r18.getRemainSeconds() > 0) goto L67;
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r19 = com.bytedance.android.live.revlink.link.biz.service.i.U(this);
        if (r19 == null) goto L98;
        if (r16 == true) goto L66;
        r9 = DataType.FALSE;
    L66:
        r19.b("double_mute_status", r9);
    L98:
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkUserCenter");
        i11.b r20 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).c8();
        if (r20 == null) goto L107;
        String r22 = r18.getUserId();
        if (r22 != null) goto L104;
        r22 = null;
    L104:
        p r23 = r20.getGuestInfo(r22, null);
        if (r23 == null) goto L107;
        r3 = r23.getLinkMicIdStr();
    L107:
        jy0.b.d("audio_punish", "handlePunishUsersLinkmicId punishUserLinkmicId = " + r3);
        if (Long.valueOf(r18.getRemainSeconds()).longValue() <= 0) goto L148;
        List r24 = r18.getPunishedLinkmicIdStrList();
        if (r24 == null) goto L132;
        List r25 = CollectionsKt.toList(r24);
        if (r25 == null) goto L132;
        Iterator r26 = r25.iterator();
    L115:
        if (r26.hasNext() == false) goto L132;
        String r27 = (String) r26.next();
        e r28 = this.h;
        if (r28 == null) goto L115;
        List<String> r29 = r28.getAudioPunishUserIds();
        if (r29 == null) goto L115;
        if (r29.contains(r27) == true) goto L115;
        if (r27.length() <= 0) goto L125;
        boolean r30 = true;
    L126:
        if (r30 == false) goto L115;
        e r32 = this.h;
        if (r32 == null) goto L115;
        List<String> r33 = r32.getAudioPunishUserIds();
        if (r33 == null) goto L115;
        r33.add(r27);
        goto L115
    L125:
        r30 = false;
    L132:
        if (r3 == null) goto L155;
        e r34 = this.h;
        if (r34 == null) goto L155;
        List<String> r35 = r34.getAudioPunishUserIds();
        if (r35 == null) goto L155;
        if (r35.contains(r3) == true) goto L155;
        if (r3.length() <= 0) goto L142;
        r10 = true;
    L142:
        if (r10 == false) goto L155;
        e r36 = this.h;
        if (r36 == null) goto L155;
        List<String> r37 = r36.getAudioPunishUserIds();
        if (r37 == null) goto L155;
        r37.add(r3);
    L155:
        if (this.f == false) goto L160;
        if (r6 == true) goto L160;
        i r38 = this.i;
        if (r38 == null) goto L160;
        r38.a();
    L160:
        com.bytedance.android.live.revenuelink.rtc.i r39 = com.bytedance.android.live.revlink.link.biz.service.i.g(this);
        if (r39 == null) goto L181;
        r39.f();
        return;
    L181:
        return;
    L148:
        if (r3 == null) goto L155;
        e r40 = this.h;
        if (r40 == null) goto L155;
        List<String> r42 = r40.getAudioPunishUserIds();
        if (r42 == null) goto L155;
        r42.remove(r3);
        goto L155
    L67:
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r43 = com.bytedance.android.live.revlink.link.biz.service.i.U(this);
        if (r43 == null) goto L98;
        r43.b("double_mute_status", "2");
    L54:
        r15 = Boolean.FALSE;
        goto L55
    L21:
        if (r18.getRemainSeconds() <= 0) goto L33;
        String r44 = r18.getSchemaUrl();
        if (r44 != null) goto L25;
    L30:
        c(r18.getRemainSeconds());
        com.bytedance.android.live.revenuelink.rtc.i r45 = com.bytedance.android.live.revlink.link.biz.service.i.g(this);
        if (r45 == null) goto L98;
        r45.p0(true, "start punish");
        goto L98
    L25:
        if (r44.length() <= 0) goto L27;
        boolean r46 = true;
    L28:
        if (r46 != true) goto L30;
        zz0.e.a(r44);
        goto L30
    L27:
        r46 = false;
        goto L28
    L33:
        int r47 = ToastUtil.a;
        ToastUtil.b(r18.getContent(), 0);
        C0126a r48 = this.c;
        if (r48 == null) goto L43;
        monitor-enter(r48);
        ((com.bytedance.android.live.countdown.a) r48).b = true;     // Catch: Throwable -> L39
        monitor-exit(r48);
    L39:
        th = move-exception;
        throw th;
    L43:
        com.bytedance.android.live.revenuelink.rtc.i r49 = com.bytedance.android.live.revlink.link.biz.service.i.g(this);
        if (r49 == null) goto L98;
        r49.p0(false, "end punish");
        goto L98
    L71:
        if (r18.getRemainSeconds() <= 0) goto L77;
        int r50 = ToastUtil.a;
        ToastUtil.b(r18.getContent(), 0);
        if (r6 == true) goto L98;
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r52 = com.bytedance.android.live.revlink.link.biz.service.i.U(this);
        if (r52 == null) goto L98;
        r52.b("double_mute_status", "2");
        goto L98
    L77:
        ld.a r53 = this.j;
        if (r53 == null) goto L82;
        NextLiveData r54 = r53.cn();
        if (r54 == null) goto L82;
        Boolean r55 = (Boolean) r54.getValue();
    L83:
        Boolean r56 = Boolean.TRUE;
        if (Intrinsics.areEqual(r55, r56) == false) goto L98;
        ld.a r57 = this.j;
        if (r57 == null) goto L90;
        NextLiveData r58 = r57.Jb();
        if (r58 == null) goto L90;
        Boolean r59 = (Boolean) r58.getValue();
    L92:
        if (Intrinsics.areEqual(r59, r56) == true) goto L95;
        r9 = DataType.FALSE;
    L95:
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r60 = com.bytedance.android.live.revlink.link.biz.service.i.U(this);
        if (r60 == null) goto L98;
        r60.b("double_mute_status", r9);
    L90:
        r59 = null;
    L82:
        r55 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final void b(z r6) {
        Intrinsics.checkNotNullParameter(r6, "audioPunishInfo");
        a(r6);
        if (r6.getRemainSeconds() <= 0) goto L17;
        String r0 = r6.getUserId();
        IRoom r1 = this.g;
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.getOwnerKt();
        if (r2 == null) goto L9;
        String r3 = iz.a.a(r2);
    L10:
        boolean r4 = Intrinsics.areEqual(String.valueOf(r0), String.valueOf(r3));
        if (r4 == true) goto L15;
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r5 = com.bytedance.android.live.revlink.link.biz.service.i.U(this);
        if (r5 == null) goto L15;
        r5.b("double_mute_status", "2");
    L15:
        jy0.b.d("audio_punish", "handleLinkmicListPunish isSelfPunish = " + r4 + ", remainSeconds = " + r6.getRemainSeconds());
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void c(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        e r0 = this.h;
        if (r0 == null) goto L10;
        MutableLiveData<Long> r1 = r0.getAudioPunishRemainTime();
        if (r1 == null) goto L10;
        r1.setValue(Long.valueOf(r4));
    L10:
        C0126a r2 = this.c;
        if (r2 == null) goto L20;
        monitor-enter(r2);
        ((com.bytedance.android.live.countdown.a) r2).b = true;     // Catch: Throwable -> L17
        monitor-exit(r2);
    L17:
        th = move-exception;
        throw th;
    L20:
        C0126a r3 = new C0126a(this, r4 * ((long) WebcastRedirectException.UNKNOWN));
        this.c = r3;
        r3.d();
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.revlink.impl.mergepk.pkbase.AnchorAudioPunishManager$punishMsgObserver$1] */
    public a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, boolean r3, IRoom r4, PkBaseDataContext r5, i r6, ld.a r7) {
        Intrinsics.checkNotNullParameter(r2, "linkInstanceService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.a = new CompositeDisposable();
        this.b = (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.f.class);
        this.d = new AnchorAudioPunishManager$punishMsgObserver$1(this);
    }
}
