package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.i a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ long h;
    public final /* synthetic */ ca0.w i;
    public final /* synthetic */ ReceiverType j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ List l;
    public final /* synthetic */ Integer m;
    public final /* synthetic */ long n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ IEpisode q;
    public final /* synthetic */ long r;
    public final /* synthetic */ boolean s;
    public final /* synthetic */ String t;

    public m(com.bytedance.android.livesdk.gift.platform.core.model.i r4, boolean r5, long r6, long r8, boolean r10, int r11, int r13, int r14, long r15, ca0.w r16, ReceiverType r17, long r18, boolean r20, List r21, Integer r23, long r24, String r25, String r26, IEpisode r27, long r28, boolean r30, String r31) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r8;
        this.e = r11;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r20;
        this.l = r21;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
        this.s = r30;
        this.t = r31;
    }

    public final void accept(Object r29) {
        Disposable r1 = (Disposable) r29;
        GiftListRepo.a(GiftListRepo.k, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L5;
        Object r3 = com.bytedance.android.scope.m.e.d(r2, f1.class);
    L6:
        f1 r4 = (f1) r3;
        if (r4 == null) goto L15;
        JSONObject r5 = new JSONObject();
        r5.putOpt("version", 2);     // Catch: JSONException -> L12
        r5.putOpt("room_id", Long.valueOf(r4.j.getRoom().getRoomId()));     // Catch: JSONException -> L12
        r5.putOpt("gift_list_data_change", Boolean.TRUE);     // Catch: JSONException -> L12
    L10:
        vh6.c.b(rq2.a.class).triggerGiftAsyncSort(r5);
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
