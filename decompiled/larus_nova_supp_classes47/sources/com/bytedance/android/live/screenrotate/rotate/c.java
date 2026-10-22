package com.bytedance.android.live.screenrotate.rotate;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.room.api.screenrotation.rotate.a {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void a(com.bytedance.android.live.room.api.screenrotation.rotate.d r6, RotateInnerRequest r7) {
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "request");
        RoomContext r0 = r6.a();
        if (r0 == null) goto L20;
        z71.a r1 = z71.b.a(r0);
        if (r1 == null) goto L10;
        com.bytedance.android.live.room.api.screenrotation.rotate.c r2 = r1.getHandleRegistry();
        if (r2 == null) goto L10;
        List<com.bytedance.android.live.room.api.screenrotation.rotate.a> r3 = r2.b();
        if (r3 == null) goto L10;
    L11:
        Iterator r4 = CollectionsKt.plus(r3, (com.bytedance.android.live.room.api.screenrotation.rotate.a) r7.d.getValue()).iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        com.bytedance.android.live.room.api.screenrotation.rotate.a r5 = (com.bytedance.android.live.room.api.screenrotation.rotate.a) r4.next();
        if (r5 == null) goto L17;
        r5.a(r6, r7);
    L17:
        SimpleAlogArgsBuilder r8 = new SimpleAlogArgsBuilder();
        r8.d("ScreenRotateHandler");
        r8.c("beforeRotate for handler--" + r5);
        f81.a.a(r8.b());
        goto L13
    L18:
        return;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void c(com.bytedance.android.live.room.api.screenrotation.rotate.d r3, RotateInnerRequest r4) {
        Intrinsics.checkNotNullParameter(r3, "session");
        Intrinsics.checkNotNullParameter(r4, "request");
        RoomContext r0 = r3.a();
        if (r0 == null) goto L19;
        z71.a r1 = z71.b.a(r0);
        if (r1 == null) goto L10;
        com.bytedance.android.live.room.api.screenrotation.rotate.c r2 = r1.getHandleRegistry();
        if (r2 == null) goto L10;
        List<com.bytedance.android.live.room.api.screenrotation.rotate.a> r5 = r2.b();
        if (r5 == null) goto L10;
    L11:
        Iterator r6 = CollectionsKt.plus(r5, (com.bytedance.android.live.room.api.screenrotation.rotate.a) r4.d.getValue()).iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        com.bytedance.android.live.room.api.screenrotation.rotate.a r7 = (com.bytedance.android.live.room.api.screenrotation.rotate.a) r6.next();
        if (r7 == null) goto L13;
        r7.c(r3, r4);
        goto L13
    L17:
        return;
    L10:
        r5 = CollectionsKt.emptyList();
        goto L11
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final boolean g(com.bytedance.android.live.room.api.screenrotation.rotate.d r9, RotateInnerRequest r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        Intrinsics.checkNotNullParameter(r10, "request");
        RoomContext r0 = r9.a();
        if (r0 == null) goto L31;
        z71.a r1 = z71.b.a(r0);
        if (r1 == null) goto L10;
        com.bytedance.android.live.room.api.screenrotation.rotate.c r2 = r1.getHandleRegistry();
        if (r2 == null) goto L10;
        List<com.bytedance.android.live.room.api.screenrotation.rotate.a> r3 = r2.b();
        if (r3 == null) goto L10;
    L11:
        List r4 = CollectionsKt.plus(r3, (com.bytedance.android.live.room.api.screenrotation.rotate.a) r10.d.getValue());
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L38;
        com.bytedance.android.live.room.api.screenrotation.rotate.a r6 = (com.bytedance.android.live.room.api.screenrotation.rotate.a) r5.next();
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == false) goto L27;
        SimpleAlogArgsBuilder r8 = new SimpleAlogArgsBuilder();
        r8.d("ScreenRotateHandler");
        r8.c("force rotate by handler--" + r6);
        f81.a.a(r8.b());
    L27:
        if (r7 == false) goto L18;
        return true;
    L22:
        if (r6.g(r9, r10) != true) goto L24;
        r7 = true;
        goto L25
    L38:
        return false;
    L14:
        if (r4.isEmpty() == false) goto L16;
        return false;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void h(com.bytedance.android.live.room.api.screenrotation.rotate.d r6, RotateInnerRequest r7) {
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "request");
        RoomContext r0 = r6.a();
        if (r0 == null) goto L20;
        z71.a r1 = z71.b.a(r0);
        if (r1 == null) goto L10;
        com.bytedance.android.live.room.api.screenrotation.rotate.c r2 = r1.getHandleRegistry();
        if (r2 == null) goto L10;
        List<com.bytedance.android.live.room.api.screenrotation.rotate.a> r3 = r2.b();
        if (r3 == null) goto L10;
    L11:
        Iterator r4 = CollectionsKt.plus(r3, (com.bytedance.android.live.room.api.screenrotation.rotate.a) r7.d.getValue()).iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        com.bytedance.android.live.room.api.screenrotation.rotate.a r5 = (com.bytedance.android.live.room.api.screenrotation.rotate.a) r4.next();
        if (r5 == null) goto L17;
        r5.h(r6, r7);
    L17:
        SimpleAlogArgsBuilder r8 = new SimpleAlogArgsBuilder();
        r8.d("ScreenRotateHandler");
        r8.c("afterRotate for handler--" + r5);
        f81.a.a(r8.b());
        goto L13
    L18:
        return;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    }
}
