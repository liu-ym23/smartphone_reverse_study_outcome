package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static final IRoom a = null;
    public static final Episode b = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            this.a.invoke();
        }
    }

    static {
        a = vh7.f.c(IRoom.class);
        b = new Episode();
    }

    public static final Episode a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$episode");
        return (Episode) r2.get("data_vs_episode_data", b);
    }

    public static final boolean c(DataCenter r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMergeVSRoom");
        return e(r1).isMergeVSRoom();
    }

    public static final IRoom e(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        return (IRoom) r2.get("data_room", a);
    }

    public static final Episode g(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$vsCompatRoomSafety");
        return (Episode) r2.get("data_vs_episode_data", null);
    }

    public static final Disposable b(DataCenter r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        vr1.u r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r2, null, 2);
        if (r4 != null) goto L5;
        return null;
    L5:
        com.bytedance.live.datacontext.n<?> r1 = r4.g();
        if (r1 == null) goto L8;
        Object r5 = r1.getValue();
    L9:
        if (r5 == null) goto L11;
        r3.invoke();
        return null;
    L11:
        r3.invoke();
        com.bytedance.live.datacontext.n<?> r6 = r4.g();
        if (r6 == null) goto L18;
        Observable r7 = r6.a();
        if (r7 != null) goto L16;
        return null;
    L16:
        return r7.subscribe(new a(r3));
    L18:
        return null;
    L8:
        r5 = null;
        goto L9
    }

    public static final boolean d(DataCenter r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isPortrait");
        return ((Boolean) r1.get("data_is_portrait", Boolean.valueOf(r2))).booleanValue();
    }

    public static final void f(DataCenter r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Object r0 = null;
        vr1.u r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r2, null, 2);
        if (r4 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.n<?> r1 = r4.g();
        if (r1 == null) goto L8;
        r0 = r1.getValue();
    L8:
        if (r0 == null) goto L10;
        r3.invoke();
        return;
    L10:
        com.bytedance.live.datacontext.n<?> r5 = r4.g();
        if (r5 == null) goto L17;
        Observable r6 = r5.a();
        if (r6 == null) goto L18;
        r6.subscribe(new i(r3));
        return;
    L18:
        return;
    }
}
