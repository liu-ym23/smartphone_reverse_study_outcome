package com.bytedance.android.livesdk.interactivity.like;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T, R> implements Function {
    public final /* synthetic */ d a;

    public i(d r1) {
        this.a = r1;
    }

    public final Object apply(Object r14) {
        Integer r15 = (Integer) r14;
        Intrinsics.checkNotNullParameter(r15, "it");
        com.bytedance.android.livesdk.interactivity.like.api.a r0 = this.a.c;
        Long r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a();
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L9;
        String r9 = "linkmic_guest_like";
    L14:
        if (Intrinsics.areEqual(r9, "linkmic_guest_like") == false) goto L16;
        String r10 = this.a.e;
    L18:
        if ((!Intrinsics.areEqual(r9, "linkmic_guest_like")) == false) goto L20;
        String r11 = this.a.e;
    L21:
        DiggApi r3 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
        long r4 = this.a.d;
        int r6 = r15.intValue();
        nm1.m r16 = pm1.f.l();
        long r7 = 0;
        if (r16 == null) goto L36;
        RoomContext.a r5 = RoomContext.Companion;
        RoomContext r13 = RoomContext.a.c(r5, null, 0, 3);
        if (r13 == null) goto L28;
        com.bytedance.live.datacontext.m r17 = r13.getRoom();
        if (r17 == null) goto L28;
        Room r18 = (Room) r17.getValue();
    L29:
        RoomContext r8 = RoomContext.a.c(r5, null, 0, 3);
        if (r8 == null) goto L34;
        com.bytedance.live.datacontext.m r19 = r8.getCameraId();
        if (r19 == null) goto L34;
        r1 = (Long) r19.getValue();
    L34:
        r7 = r16.k(r18, r1);
    L28:
        r18 = null;
    L36:
        return r3.digg(r4, r6, r7, r9, r10, r11);
    L20:
        r11 = null;
        goto L21
    L16:
        r10 = null;
        goto L18
    L9:
        com.bytedance.android.livesdk.interactivity.like.api.a r20 = this.a.c;
        if (r20 == null) goto L12;
        r9 = r20.a();
        goto L14
    L12:
        r9 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
