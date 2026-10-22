package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/utils/RoomChatChannelCreator;", "Ls22/e$c;", "Lcom/bytedance/android/livesdk/chatroom/n;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomChatChannelCreator implements s22.e.c, com.bytedance.android.livesdk.chatroom.n, Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public CompositeDisposable a;
    public Disposable b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public boolean i;
    public final RoomContext j;
    public final DataCenter k;
    public final Context l;

    public static final class a {
    }

    static {
    }

    @Override // s22.e.c
    public final void Df() {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Oo() {
    }

    @Override // s22.e.c
    public final void Y9(long r1) {
    }

    @Override // s22.e.c
    public final void p6(long r1) {
    }

    @Override // s22.e.c
    public final void t9(long r1) {
    }

    public final s22.e b() {
        com.bytedance.android.livesdk.interactivity.api.f r0 = com.bytedance.android.livesdk.interactivity.api.g.a(this.j);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<s22.e> r1 = r0.getChatChannelManager();
        if (r1 == null) goto L7;
        return (s22.e) r1.getValue();
    L7:
        return null;
    }

    public final void a() {
        s22.e r0 = b();
        if (r0 == null) goto L5;
        r0.onRoomDestroy("room creator");
    L5:
        this.k.removeObserver(this);
        CompositeDisposable r1 = this.a;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.b;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.i = false;
    }

    @Override // s22.e.c
    public final void Dm(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void Va(long r4) {
        Long r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4 != r0.longValue()) goto L9;
        k.b("quit failed while quit and join");
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        return;
    }

    @Override // s22.e.c
    public final void W5(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void c(long r6) {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L17;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L17;
        if (r1.isLogin() == true) goto L17;
        Bundle r2 = new Bundle();
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L21;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L22;
        Context r5 = this.l;
        com.bytedance.android.livesdk.user.l.a r7 = new com.bytedance.android.livesdk.user.l.a();
        r7.e = BuildConfig.FLAVOR;
        r7.h = r2;
        Observable r8 = r4.login(r5, new com.bytedance.android.livesdk.user.l(r7));
        if (r8 == null) goto L23;
        Disposable r9 = r8.subscribe(new r(this, r6), s.a);
        if (r9 == null) goto L24;
        RxUtilKt.c(r9, this.a);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L17:
        s22.e r10 = b();
        if (r10 == null) goto L26;
        r10.joinChannel(r6);
        return;
    }

    @Override // s22.e.c
    public final void d8(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void e(Room r7) {
        RoomContext r0 = this.j;
        com.bytedance.android.livesdk.interactivity.api.f r1 = com.bytedance.android.livesdk.interactivity.api.g.a(r0);
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.i == false) goto L8;
        return;
    L8:
        RoomChatChannelCreator$tryInitChatChannel$1 r2 = new RoomChatChannelCreator$tryInitChatChannel$1(this, r7, r0, r1);
        RoomChannelData r3 = r7.roomChannel;
        if (r3 != null) goto L11;
    L13:
        RoomAuthStatus r4 = r7.getMRoomAuthStatus();
        if (r4 != null) goto L16;
    L32:
        r2.invoke(null);
        return;
    L16:
        if (r4.isEnableRoomChannel() != true) goto L32;
        com.bytedance.android.live.network.c r5 = com.bytedance.android.live.network.c.b();
        if (r5 == null) goto L28;
        RoomRetrofitApi r6 = (RoomRetrofitApi) r5.e(RoomRetrofitApi.class);
        if (r6 == null) goto L28;
        Observable r8 = r6.getRoomInfoByScene(r7.id, "enter_room_channel");
        if (r8 == null) goto L28;
        Observable r9 = r8.map(z.a);
        if (r9 == null) goto L28;
        Observable r10 = r9.subscribeOn(Schedulers.io());
        if (r10 == null) goto L28;
        Observable r11 = r10.observeOn(AndroidSchedulers.mainThread());
    L29:
        if (r11 == null) goto L31;
        RxUtilKt.c(r11.subscribe(new x(r2), new y(r2)), this.a);
        return;
    L31:
        r2.invoke(null);
        return;
    L28:
        r11 = null;
        goto L29
    L11:
        if (r3.getStatus() != 1) goto L13;
        r2.invoke(r3);
    }

    @Override // s22.e.c
    public final void gf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "channels");
        Intrinsics.checkNotNullParameter(r2, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-1741164106)) goto L12;
        return;
    L12:
        if (r1.equals("data_user_in_room") == false) goto L34;
        IUser r8 = (IUser) r7.getData();
        if (r8 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.api.h r2 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r2 == null) goto L24;
        com.bytedance.live.datacontext.j<Long> r3 = r2.getUserFansCountOnStart();
        if (r3 == null) goto L24;
        py.j r4 = r8.getFollowInfoExt();
        if (r4 == null) goto L22;
        long r5 = r4.getFollowerCount();
    L23:
        r3.d(Long.valueOf(r5));
        goto L24
    L22:
        r5 = 0;
    L24:
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r0 == null) goto L36;
        com.bytedance.live.datacontext.j<Integer> r9 = r0.getUserHonorLevelOnStart();
        if (r9 == null) goto L37;
        py.d r10 = r8.getUserHonor();
        if (r10 == null) goto L31;
        int r11 = r10.getLevel();
    L32:
        r9.d(Integer.valueOf(r11));
        return;
    L31:
        r11 = 0;
        goto L32
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // s22.e.c
    public final void vg(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void D9(s22.a r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Intrinsics.checkNotNullParameter(r1, "channel");
    }

    @Override // s22.e.c
    public final void Gh(s22.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Intrinsics.checkNotNullParameter(r1, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r8, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Long r11 = this.c;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r8 != r11.longValue()) goto L21;
        this.c = null;
        Long r9 = this.d;
        if (r9 == null) goto L11;
        long r13 = r9.longValue();
        this.d = null;
        c(r13);
        return;
    L11:
        Long r14 = this.e;
        if (r14 == null) goto L22;
        long r1 = r14.longValue();
        s22.e r0 = b();
        if (r0 == null) goto L23;
        Long r15 = this.f;
        if (r15 == null) goto L18;
        long r16 = r15.longValue();
    L19:
        r0.joinAnchorFansChannel(r1, r16, this.g, this.h);
        return;
    L18:
        r16 = 0;
        goto L19
    L23:
        return;
    L22:
        return;
    }

    @Override // s22.e.c
    public final void a3(long r13, Throwable r14) {
        boolean r0 = r14 instanceof ApiServerException;
        if (r0 == true) goto L5;
        Throwable r2 = null;
    L6:
        ApiServerException r3 = (ApiServerException) r2;
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L26;
        s22.e r15 = b();
        if (r15 == null) goto L22;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r16 = r15.getCurrentChannel();
        if (r16 == null) goto L22;
        sh6.b r17 = (sh6.b) r16.getValue();
        if (r17 == null) goto L22;
        s22.a r18 = (s22.a) sh6.c.b(r17);
        if (r18 == null) goto L22;
        Long r19 = Long.valueOf(r18.getChannelId());
    L23:
        if (r19 == null) goto L25;
        d(this, r19.longValue(), Long.valueOf(r13), null, null, null, null, 60);
        return;
    L25:
        k.b("join failed because hasJoinChannel is true. but no channelId available");
        this.c = null;
        this.d = null;
        return;
    L22:
        r19 = null;
        goto L23
    L26:
        if (r0 == true) goto L28;
        r14 = null;
    L28:
        ApiServerException r110 = (ApiServerException) r14;
        if (r110 == null) goto L36;
        String r111 = r110.getPrompt();
        if (r111 == null) goto L37;
        f2.c(r111, 0);
        return;
    L37:
        return;
    L36:
        return;
    L9:
        if (r3.getErrorCode() != 4003129) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = r14;
        goto L6
    }

    public RoomChatChannelCreator(RoomContext r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }

    @Override // s22.e.c
    public final void Ij(long r15, long r17, Long r19, Long r20, Throwable r21) {
        Throwable r2 = r21;
        boolean r3 = r2 instanceof ApiServerException;
        Long r4 = null;
        if (r3 == true) goto L5;
        Throwable r5 = null;
    L6:
        ApiServerException r6 = (ApiServerException) r5;
        if (r6 == null) goto L9;
        Integer r7 = Integer.valueOf(r6.getErrorCode());
    L11:
        if (r7 != null) goto L14;
    L54:
        if (r7 != null) goto L57;
    L63:
        if (r7 != null) goto L66;
    L70:
        if (r3 == true) goto L72;
        r2 = null;
    L72:
        ApiServerException r8 = (ApiServerException) r2;
        if (r8 == null) goto L99;
        String r9 = r8.getPrompt();
        if (r9 == null) goto L100;
        f2.c(r9, 0);
        s22.e r10 = b();
        if (r10 == null) goto L101;
        s22.a r0 = r10.getChannel(r15);
        if (r0 == null) goto L102;
        PropertyOwner<String> r1 = r0.r();
        if (r1 == null) goto L103;
        r1.a(r9);
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L66:
        if (r7.intValue() != 4003215) goto L70;
        f2.b(2131915699, 0);
        s22.e r11 = b();
        if (r11 == null) goto L97;
        r11.deleteAnchorFansChannel(r15);
        return;
    L97:
        return;
    L57:
        if (r7.intValue() != 4003123) goto L63;
        s22.e r13 = b();
        if (r13 == null) goto L94;
        s22.a r14 = r13.getChannel(r15);
        if (r14 == null) goto L95;
        r14.r().a(s1.B(2131915760));
        return;
    L95:
        return;
    L94:
        return;
    L14:
        if (r7.intValue() != 4003129) goto L54;
        s22.e r16 = b();
        if (r16 == null) goto L30;
        List<s22.a> r18 = r16.getAllChannel();
        if (r18 == null) goto L30;
        Iterator<T> r23 = r18.iterator();
    L21:
        if (r23.hasNext() == false) goto L29;
        s22.a r24 = (s22.a) r23.next();
        if (r24.y() != 0) goto L25;
        boolean r25 = true;
    L26:
        if (r25 == false) goto L21;
        Long r26 = Long.valueOf(r24.getChannelId());
    L31:
        if (r26 != null) goto L45;
        s22.e r27 = b();
        if (r27 == null) goto L44;
        List<s22.a> r28 = r27.getAllChannel();
        if (r28 == null) goto L44;
        Iterator<T> r29 = r28.iterator();
    L38:
        if (r29.hasNext() == false) goto L43;
        s22.a r30 = (s22.a) r29.next();
        if (r30.s() == false) goto L38;
        r4 = Long.valueOf(r30.getChannelId());
        goto L44
    L43:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L44:
        r26 = r4;
    L45:
        if (r26 == null) goto L92;
        s22.e r31 = b();
        if (r31 == null) goto L53;
        s22.a r33 = r31.getChannel(r15);
        if (r33 == null) goto L53;
        PropertyOwner<String> r34 = r33.r();
        if (r34 == null) goto L53;
        r34.a(s1.B(2131915759));
    L53:
        d(this, r26.longValue(), null, Long.valueOf(r15), Long.valueOf(r17), r19, r20, 2);
        return;
    L92:
        return;
    L25:
        r25 = false;
        goto L26
    L29:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L30:
        r26 = null;
        goto L31
    L9:
        r7 = null;
        goto L11
    L5:
        r5 = r2;
        goto L6
    }

    public static void d(RoomChatChannelCreator r13, long r14, Long r16, Long r17, Long r18, Long r19, Long r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        Long r6 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        Long r7 = null;
    L11:
        if ((r21 & 8) == 0) goto L13;
        Long r8 = null;
    L15:
        if ((r21 & 16) == 0) goto L17;
        Long r9 = null;
    L19:
        if ((r21 & 32) == 0) goto L21;
        Long r10 = null;
    L22:
        r13.getClass();
        x0.b r0 = new x0.b(r13.l, 0);
        r0.a.a = 4;
        r0.setCornerRadius(2.0f);
        r0.l(2131915733);
        r0.i(1, 2131915734, v.a);
        r0.i(0, 2131915735, new w(r13, r14, r6, r7, r8, r9, r10));
        r0.a.k = false;
        r0.n();
        return;
    L21:
        r10 = r20;
        goto L22
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
