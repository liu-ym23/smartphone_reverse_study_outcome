package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0<T, R> implements Function {
    public final /* synthetic */ x0 a;

    public y0(x0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r6) {
        Response r7 = (Response) r6;
        Intrinsics.checkNotNullParameter(r7, "response");
        com.bytedance.android.livesdk.interactivity.like.api.b r8 = (com.bytedance.android.livesdk.interactivity.like.api.b) ((BaseResponse) r7).data;
        if (r8 == null) goto L36;
        List<ImageModel> r9 = r8.a();
        if (r9 == null) goto L36;
        List<ImageModel> r10 = r9;
        List r0 = CollectionsKt.plus(r10, this.a.e);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        T r3 = r2.next();
        String r4 = ((ImageModel) r3).mUri;
        Object r5 = r1.get(r4);
        if (r5 != null) goto L12;
        r5 = new ArrayList();
        r1.put(r4, r5);
    L12:
        ((List) r5).add(r3);
        goto L8
    L13:
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r13 = r1.entrySet().iterator();
    L14:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L23;
        Map.Entry r15 = (Map.Entry) r13.next();
        if (((List) r15.getValue()).size() == 1) goto L20;
        r14 = false;
    L20:
        if (r14 == false) goto L14;
        r11.put(r15.getKey(), r15.getValue());
        goto L14
    L23:
        if ((!r11.isEmpty()) == false) goto L33;
        Set<Bitmap> r16 = this.a.i;
        Iterator<T> r17 = r16.iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        ((Bitmap) r17.next()).recycle();
        goto L26
    L28:
        r16.clear();
        ArrayList<ImageModel> r18 = this.a.e;
        r18.clear();
        r18.addAll(r10);
        ArrayList<ImageModel> r19 = this.a.e;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<ImageModel> r21 = r19.iterator();
    L30:
        if (r21.hasNext() == false) goto L32;
        r20.add(com.bytedance.android.livesdk.chatroom.utils.a1.k(r21.next()));
        goto L30
    L32:
        Observable r23 = Observable.merge(r20);
    L34:
        if (r23 == null) goto L36;
        return r23;
    L33:
        r23 = Observable.empty();
    L36:
        Set<Bitmap> r24 = this.a.i;
        Iterator<T> r25 = r24.iterator();
    L38:
        if (r25.hasNext() == false) goto L40;
        ((Bitmap) r25.next()).recycle();
        goto L38
    L40:
        r24.clear();
        this.a.e.clear();
        return Observable.empty();
    }
}
