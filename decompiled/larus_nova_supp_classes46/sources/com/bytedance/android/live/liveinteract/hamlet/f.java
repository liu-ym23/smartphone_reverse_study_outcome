package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public f(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r17) {
        if (((Boolean) r17).booleanValue() == false) goto L102;
        HamletAvatarContext r1 = this.a.f;
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isMultiAvatarMode();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L11;
        boolean r4 = r3.booleanValue();
    L12:
        Function0<hg6.g> r5 = this.a.R;
        if (r5 == null) goto L31;
        hg6.g r6 = (hg6.g) r5.invoke();
        if (r6 == null) goto L31;
        ei6.a r7 = r6.V0();
        if (r7 == null) goto L31;
        if (ff0.c.b() == false) goto L23;
        ff0.d r8 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "enable_audio_vad_report", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interval", String.valueOf(vm2.d.I().getVadInterval()))}), 12);
        ri6.b r9 = r7.r();
        if (r9 == null) goto L23;
        r9.h(vm2.d.I().getVadInterval());
    L23:
        if (r4 == false) goto L29;
        HamletAvatarWidget r10 = this.a;
        Disposable r11 = r10.x;
        if (r11 == null) goto L27;
        r11.dispose();
    L27:
        r10.x = du2.a.b(0, vm2.d.I().getAudioStreamInfoSendInterval(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new f0(r10));
    L29:
        if (HamletAvatarWidget.wq(this.a) == false) goto L31;
        HamletAvatarWidget.xq(this.a);
    L31:
        HamletAvatarContext r12 = this.a.f;
        if (r12 == null) goto L36;
        com.bytedance.live.datacontext.n<Long> r13 = r12.getCurrentSelectAvatarID();
        if (r13 == null) goto L36;
        Long r14 = (Long) r13.getValue();
    L37:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r15 = this.a.g;
        if (r15 == null) goto L40;
        Long r16 = Long.valueOf(r15.getLastVersion());
    L41:
        ALogger.i("HamletAvatar", "observe: streamRending&isRtcClientInitialized&isSelfCPosition, currentSelectAvatarId=" + r14 + ", version=" + r16);
        if (r14 == null) goto L103;
        if (r16 == null) goto L104;
        long r18 = r16.longValue();
        long r19 = r14.longValue();
        HamletAvatarContext r20 = this.a.f;
        if (r20 == null) goto L50;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.isMultiAvatarMode();
        if (r21 == null) goto L50;
        if (((Boolean) r21.getValue()).booleanValue() != true) goto L50;
    L96:
        this.a.Jf(0);
        this.a.Qq(0);
        return;
    L50:
        HamletAvatarWidget r110 = this.a;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r22 = r110.g;
        if (r22 == null) goto L55;
        List<T> r23 = r22.getOnlineUserList();
        if (r23 == 0) goto L55;
        ILinkPlayerInfoBridge r24 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r23);
    L56:
        int r25 = -1;
        if (r24 != null) goto L59;
    L77:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r26 = r110.g;
        if (r26 == null) goto L93;
        List<T> r27 = r26.getOnlineUserList();
        if (r27 == 0) goto L93;
        Iterator r28 = r27.iterator();
        int r29 = 0;
    L83:
        if (r28.hasNext() == false) goto L92;
        IBaseUser r111 = ((ILinkPlayerInfoBridge) r28.next()).getUser();
        if (r111 == null) goto L87;
        String r112 = r111.getIdString();
    L89:
        if (Intrinsics.areEqual(r112, gh0.a.c()) == true) goto L90;
        r29 = r29 + 1;
        goto L83
    L90:
        r25 = r29;
        goto L92
    L87:
        r112 = null;
    L92:
        long r30 = r25;
    L94:
        long r31 = r30 - 1;
    L95:
        r110.Mq(r19, r18, Long.valueOf(r31));
        this.a.eh(false);
    L93:
        r30 = 1;
        goto L94
    L59:
        if (r24.isEnlarged() == false) goto L77;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r32 = r110.g;
        if (r32 == null) goto L76;
        List<T> r33 = r32.getOnlineUserList();
        if (r33 == 0) goto L76;
        Iterator r34 = r33.iterator();
        int r35 = 0;
    L66:
        if (r34.hasNext() == false) goto L75;
        IBaseUser r36 = ((ILinkPlayerInfoBridge) r34.next()).getUser();
        if (r36 == null) goto L70;
        String r37 = r36.getIdString();
    L72:
        if (Intrinsics.areEqual(r37, gh0.a.c()) == true) goto L73;
        r35 = r35 + 1;
        goto L66
    L73:
        r25 = r35;
        goto L75
    L70:
        r37 = null;
    L75:
        r31 = r25;
    L76:
        r31 = 0;
    L55:
        r24 = null;
        goto L56
    L104:
        return;
    L103:
        return;
    L40:
        r16 = null;
    L36:
        r14 = null;
    L11:
        r4 = false;
        goto L12
    }
}
