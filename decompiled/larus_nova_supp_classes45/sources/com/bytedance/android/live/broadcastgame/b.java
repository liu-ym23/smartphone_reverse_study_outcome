package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.message.model.mh;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ a a;
    public final /* synthetic */ ToolbarMatchInterface b;
    public final /* synthetic */ boolean c;

    public b(a r1, ToolbarMatchInterface r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.livesdk.message.model.e0> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        String r0 = this.b.getComponentExtra();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"receive toolbar message, " + r0});
        Object r2 = null;
        if (this.c == false) goto L54;
        this.a.getClass();
        Type r3 = new f().getType();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl((List) GsonHelper.get().fromJson(r0, r3));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        List r7 = (List) r5;
        if (r7 != null) goto L15;
        r7 = CollectionsKt.emptyList();
    L15:
        RoomStampInfo r8 = (RoomStampInfo) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L48;
        com.bytedance.android.livesdk.message.model.e0 r9 = new com.bytedance.android.livesdk.message.model.e0();
        r9.appId = r8.getId();
        Gson r11 = GsonHelper.get();     // Catch: Throwable -> L26
        String r12 = r8.getEntrances();     // Catch: Throwable -> L26
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        com.bytedance.android.livesdk.message.model.e0 r13 = (com.bytedance.android.livesdk.message.model.e0) r11.fromJson(r12, com.bytedance.android.livesdk.message.model.e0.class);     // Catch: Throwable -> L26
        com.bytedance.android.livesdk.message.model.e0 r14 = r13;
        if (r13 != null) goto L24;
        r14 = r9;
    L24:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L26
    L28:
        Object r16 = r9;
        if (Result.isFailure-impl(r15) == true) goto L32;
        r16 = r15;
    L32:
        r2 = (com.bytedance.android.livesdk.message.model.e0) r16;
    L26:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        if (r2 == null) goto L50;
        r6.onNext(r2);
        return;
    L50:
        r6.onError(new Exception("invalid extras, " + r0));
        return;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L54:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        mh r21 = (mh) GsonHelper.get().fromJson(r0, mh.class);     // Catch: Throwable -> L41
        if (r21 == null) goto L38;
        List r22 = r21.entrances;     // Catch: Throwable -> L41
        if (r22 == null) goto L38;
        com.bytedance.android.livesdk.message.model.e0 r23 = (com.bytedance.android.livesdk.message.model.e0) CollectionsKt.firstOrNull(r22);     // Catch: Throwable -> L41
    L39:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r24) == true) goto L47;
        r2 = r24;
    L47:
        r2 = (com.bytedance.android.livesdk.message.model.e0) r2;
    L38:
        r23 = null;
    L41:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    }
}
