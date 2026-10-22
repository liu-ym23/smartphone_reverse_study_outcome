package com.bytedance.android.livesdk.interactivity.base.im;

import amc.f;
import android.content.Context;
import c62.c;
import c62.n;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.bytedance.android.livesdk.message.interceptor.i;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s22.d;
import vlc.j;
import vlc.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomChannelIMManager implements d, k {
    public final b a;
    public final Set<Long> b;
    public final d62.b c;
    public final c62.b d;
    public final c62.a e;
    public final com.ss.ugc.live.sdk.msg.d f;
    public final Set<n> g;
    public final Set<c> h;
    public final Context i;
    public final long j;

    public static final class a implements Action {
        public final /* synthetic */ RoomChannelIMManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ l c;

        public a(RoomChannelIMManager r1, int r2, l r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            this.a.f.removeMessageListener(this.b, this.c);
        }
    }

    public final void f() {
        b r0 = this.a;
        long r1 = this.j;
        r0.getClass();
        r0.b("stop fetch message, roomId is " + r1);
        this.f.r(true);
    }

    public final Context getContext() {
        return this.i;
    }

    @Override // s22.d
    public final void removeMessageListener(l r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        com.ss.ugc.live.sdk.msg.d r0 = this.f;
        Iterator<T> r1 = this.g.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((n) r2).b, r5) == false) goto L4;
    L9:
        n r3 = (n) r2;
        if (r3 == null) goto L12;
        r5 = r3;
    L12:
        r0.removeMessageListener(r5);
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // s22.d
    public final Disposable a(int r2, l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.addMessageListener(r2, r3);
        return Disposables.fromAction(new a(this, r2, r3));
    }

    @Override // s22.d
    public final <T extends RoomDataSyncModel> T d(long r2, Function0<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        T r5 = (T) r4.invoke();
        r5.bindManager(this.c.b(r2));
        return r5;
    }

    @Override // s22.d
    public final void e(long r7, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        c r2 = (c) r1;
        if (r2.a == r7) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L14:
        c r4 = (c) r1;
        if (r4 != null) goto L17;
        r4 = new c(r7, r9);
        this.h.add(r4);
    L17:
        this.f.n(r4);
        return;
    L8:
        if (Intrinsics.areEqual(r2.b, r9) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public RoomChannelIMManager(Context r15, long r16, boolean r18) {
        Intrinsics.checkNotNullParameter(r15, "context");
        this.i = r15;
        this.j = r16;
        b r10 = new b();
        this.a = r10;
        this.b = new LinkedHashSet();
        d62.b r11 = new d62.b(r16);
        this.c = r11;
        c62.b r5 = new c62.b(this);
        this.d = r5;
        c62.a r6 = new c62.a(new RoomChannelIMManager$messageBuffer$1(this), new RoomChannelIMManager$messageBuffer$2(this));
        this.e = r6;
        List r7 = CollectionsKt.mutableListOf(new vlc.b[]{r5, r6});
        Map<String, Class<?>> r8 = com.bytedance.android.livesdk.interactivity.base.im.a.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r10, "logger");
        Intrinsics.checkNotNullParameter(r11, "wrdsManager");
        Intrinsics.checkNotNullParameter(r7, "outerInterceptors");
        j r13 = jc1.k.n(ILiveSdkProjectModeService.class).getMsgInterceptor();
        String r9 = jc1.k.n(IUserService.class).user().n();
        ArrayList r14 = new ArrayList();
        r14.addAll(r7);
        r14.add(new i("room_channel_message"));
        if (r13 == null) goto L5;
        r14.add(r13);
    L5:
        ArrayList r17 = new ArrayList();
        if ((r13 instanceof j) == false) goto L8;
        r17.add(r13);
    L8:
        c62.d r19 = new c62.d(r15, r16, r9, r18, r14, r17, r10);
        if ((r13 instanceof ylc.c) == false) goto L13;
        ylc.c r110 = (ylc.c) r13;
        Intrinsics.checkNotNullParameter(r110, "listener");
        if (r11.b.contains(r110) == true) goto L13;
        r11.b.add(r110);
    L13:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(com.bytedance.android.livesdk.interactivity.base.im.a.a);
        Map r2 = jc1.k.n(IInteractService.class).getChannelWRDSDataMap();
        if (r2 == null) goto L16;
        r1.putAll(r2);
    L16:
        Iterator r3 = r1.entrySet().iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) r3.next();
        dc2.a.a((String) r4.getKey(), (Class) r4.getValue());
        goto L18
    L20:
        ArrayList r20 = new ArrayList();
        r20.add(new d62.c(MessageType.ROOM_DATA_SYNC_MESSAGE.getIntType(), new com.bytedance.android.livesdk.wrds.a(), r11, r10));
        this.f = f.b(r19, r20);
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        b r21 = this.a;
        long r23 = this.j;
        r21.getClass();
        r21.b("create, roomId is " + r23);
    }

    @Override // s22.d
    public final void c(long r7, int r9, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        n r2 = (n) r1;
        if (r2.a == r7) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L14:
        n r4 = (n) r1;
        if (r4 != null) goto L17;
        r4 = new n(r7, r10);
        this.g.add(r4);
    L17:
        this.f.addMessageListener(r9, r4);
        return;
    L8:
        if (Intrinsics.areEqual(r2.b, r10) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public final void b(long r1, int r3, int r4, long r5) {
        b r6 = this.a;
        r6.getClass();
        r6.b("message duplicated, messageId is " + r1);
    }
}
