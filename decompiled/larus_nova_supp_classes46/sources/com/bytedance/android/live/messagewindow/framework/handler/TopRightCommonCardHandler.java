package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.j3;
import com.bytedance.android.livesdkapi.depend.model.live.DslTypeInt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m71.e;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TopRightCommonCardHandler extends a<i3> {
    public Map<Integer, i3> b;
    public final String c;
    public final WeakReference<Context> d;
    public final DataCenter e;
    public final q71.a f;
    public final y61.a g;
    public final Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> h;

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void h() {
        super.h();
        y61.a r0 = this.g;
        if (r0 == null) goto L9;
        Map<Integer, i3> r1 = r0.getTopRightCardData();
        if (r1 == null) goto L9;
        if ((!r1.isEmpty()) == false) goto L9;
        this.b = r1;
    L9:
        y61.a r2 = this.g;
        if (r2 == null) goto L12;
        r2.setTopRightCardData(this.b);
    L12:
        int r3 = e.a;
        if (((n71.a) m71.b.a.getValue()).d() == true) goto L26;
        y61.a r4 = this.g;
        if (r4 == null) goto L21;
        Map r5 = r4.getCardMapV2();
        if (r5 == null) goto L21;
        Map<Integer, Pair<v61.a, g71.b>> r6 = (Map) r5.get(MsgWindowPosition.TOP_RIGHT);
        if (r6 == null) goto L21;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.a = r6;
    L21:
        y61.a r7 = this.g;
        if (r7 == null) goto L50;
        Map r8 = r7.getCardMapV2();
        if (r8 == null) goto L51;
        Map r9 = (Map) r8.put(MsgWindowPosition.TOP_RIGHT, this.a);
        return;
    L51:
        return;
    L50:
        return;
    L26:
        y61.a r10 = this.g;
        String r11 = null;
        if (r10 == null) goto L39;
        Map r12 = r10.getCardMapV3();
        if (r12 == null) goto L39;
        DataCenter r13 = this.e;
        if (r13 == null) goto L35;
        IRoom r14 = a0.n(r13);
        if (r14 == null) goto L35;
        String r15 = r14.getIdStr();
    L36:
        Map<Integer, Pair<v61.a, g71.b>> r16 = (Map) r12.get(new w61.b(r15, MsgWindowPosition.TOP_RIGHT));
        if (r16 == null) goto L39;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.a = r16;
    L35:
        r15 = null;
    L39:
        y61.a r17 = this.g;
        if (r17 == null) goto L53;
        Map r18 = r17.getCardMapV3();
        if (r18 == null) goto L54;
        DataCenter r19 = this.e;
        if (r19 == null) goto L48;
        IRoom r20 = a0.n(r19);
        if (r20 == null) goto L48;
        r11 = r20.getIdStr();
    L48:
        Map r21 = (Map) r18.put(new w61.b(r11, MsgWindowPosition.TOP_RIGHT), this.a);
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final String c() {
        return this.c;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void g() {
        super.g();
    }

    public final y61.a getCommonCardContext() {
        return this.g;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public WeakReference<Context> getContext() {
        return this.d;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void a(final z61.a r4) {
        Intrinsics.checkNotNullParameter(r4, "commonCardEvent");
        super.a(r4);
        Map<Integer, i3> r0 = this.b;
        if (r0 == null) goto L5;
        i3 r1 = r0.get(Integer.valueOf(r4.b.getType()));
    L6:
        if (r1 == null) goto L22;
        Pair<v61.a, g71.b> r2 = this.a.get(Integer.valueOf(r4.b.getType()));
        if (r2 == null) goto L20;
        v61.a r3 = (v61.a) r2.getFirst();
        if (r3 == null) goto L20;
        if (this.h.get(r3) != null) goto L20;
        this.h.put(r3, r4.b);
        y61.a r5 = this.g;
        if (r5 == null) goto L20;
        final CompositeDisposable r6 = r5.registerCardCallback(r3, r4.b.getType(), r4);
        if (r6 == null) goto L20;
        if (((Boolean) ny0.a.getValue()).booleanValue() == false) goto L20;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r7 = r4.b;
        r7.a = new TopRightCommonCardHandler$combineTypeCardRefresh$$inlined$let$lambda$1(r6, this, r4);
    L20:
        f(Integer.valueOf(r4.b.getType()));
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void b(i3 r3) {
        i3 r4 = r3;
        super.b(r4);
        Integer r5 = r4.type;
        if (r5 == null) goto L25;
        int r6 = r5.intValue();
        Pair<v61.a, g71.b> r0 = this.a.get(Integer.valueOf(r6));
        if (r0 == null) goto L9;
        g71.b r1 = (g71.b) r0.getSecond();
        if (r1 == null) goto L9;
        r1.reset();
    L9:
        Pair<v61.a, g71.b> r2 = this.a.get(Integer.valueOf(r6));
        if (r2 == null) goto L14;
        v61.a r7 = (v61.a) r2.getFirst();
        if (r7 == null) goto L14;
        r7.dismiss();
    L14:
        this.a.remove(Integer.valueOf(r6));
        this.b.remove(Integer.valueOf(r6));
        Pair<v61.a, g71.b> r8 = this.a.get(Integer.valueOf(r6));
        if (r8 == null) goto L26;
        v61.a r9 = (v61.a) r8.getFirst();
        if (r9 != null) goto L19;
        return;
    L19:
        if (e.b() == false) goto L23;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r10 = this.h.get(r9);
        if (r10 == null) goto L23;
        r10.a();
    L23:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r11 = this.h.remove(r9);
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void e(i3 r17, CommonCardInitScene r18) {
        i3 r9 = r17;
        Intrinsics.checkNotNullParameter(r18, "initScene");
        super.e(r9, r18);
        Pair<v61.a, g71.b> r2 = this.a.get(r9.type);
        if (r2 == null) goto L37;
        v61.a r3 = (v61.a) r2.getFirst();
        if (r3 == null) goto L37;
        ICardLifecycle.State r4 = r3.A();
        if (r4 == null) goto L37;
        if (r4.isShowOrHide() != true) goto L37;
        j3 r1 = r9.cardDisplayInfo;
        if (r1 == null) goto L15;
        LiveDSLModel r5 = r1.dslDetail;
        if (r5 == null) goto L15;
        Long r6 = Long.valueOf(r5.getDslType());
    L16:
        long r7 = DslTypeInt.DslTypeSlice.getValue();
        if (r6 != null) goto L20;
    L22:
        long r8 = DslTypeInt.DslTypeLynxAir.getValue();
        if (r6 != null) goto L26;
    L32:
        Pair<v61.a, g71.b> r10 = this.a.get(r9.type);
        if (r10 == null) goto L76;
        v61.a r11 = (v61.a) r10.getFirst();
        if (r11 == null) goto L76;
        r11.e(r9, null);
    L76:
        Integer r12 = r9.type;
        if (r12 == null) goto L80;
        i3 r13 = this.b.put(Integer.valueOf(r12.intValue()), r9);
        return;
    L80:
        return;
    L26:
        if (r6.longValue() != r8) goto L32;
    L27:
        Pair<v61.a, g71.b> r14 = this.a.get(r9.type);
        if (r14 == null) goto L76;
        v61.a r15 = (v61.a) r14.getFirst();
        if (r15 == null) goto L76;
        r15.R(r9);
        goto L76
    L20:
        if (r6.longValue() != r7) goto L22;
    L15:
        r6 = null;
    L37:
        Pair<v61.a, g71.b> r16 = this.a.get(r9.type);
        if (r16 == null) goto L42;
        g71.b r19 = (g71.b) r16.getSecond();
        if (r19 == null) goto L42;
        r19.reset();
    L42:
        Intrinsics.checkNotNullParameter(r18, "initScene");
        d(r9, r18);
        Integer r20 = r9.type;
        int r110 = 0;
        if (r20 == null) goto L68;
        int r111 = r20.intValue();
        gm0.c r112 = new gm0.c(r9, this.e);
        d r21 = new d(this);
        Intrinsics.checkNotNullParameter(r21, "showCardCallback");
        r112.b = r21;
        Context r22 = getContext().get();
        if (r22 == null) goto L52;
        Map<Integer, Pair<v61.a, g71.b>> r113 = this.a;
        Integer r114 = Integer.valueOf(r111);
        DataCenter r23 = this.e;
        Integer r24 = r9.priority;
        if (r24 == null) goto L49;
        int r25 = r24.intValue();
    L50:
        r113.put(r114, TuplesKt.to(new com.bytedance.android.live.messagewindow.business.card.e(r9, r23, r111, r25, r22, r18), r112));
        goto L52
    L49:
        r25 = 0;
    L52:
        if (e.b() == false) goto L67;
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r26 = this.h;
        if (r26 == null) goto L67;
        Pair<v61.a, g71.b> r27 = this.a.get(Integer.valueOf(r111));
        if (r27 == null) goto L58;
        v61.a r28 = (v61.a) r27.getFirst();
    L59:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r29 = r26.get(r28);
        if (r29 == null) goto L62;
        r29.a();
    L62:
        Pair<v61.a, g71.b> r30 = this.a.get(Integer.valueOf(r111));
        if (r30 == null) goto L65;
        v61.a r115 = (v61.a) r30.getFirst();
    L66:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r31 = (com.bytedance.android.live.room.api.messagewindow.builder.card.b) TypeIntrinsics.asMutableMap(r26).remove(r115);
        goto L67
    L65:
        r115 = null;
        goto L66
    L58:
        r28 = null;
    L67:
        r112.c();
    L68:
        q71.a r32 = this.f;
        if (r32 == null) goto L76;
        q71.d r33 = r32.c(r9.combineType, MsgWindowPosition.TOP_RIGHT);
        if (r33 == null) goto L76;
        int r34 = f.d;
        Integer r35 = r9.type;
        if (r35 == null) goto L75;
        r110 = r35.intValue();
    L75:
        r33.b(f.a.a(r110, CardDataState.SHOW, r18));
        goto L76
    }

    public TopRightCommonCardHandler(WeakReference r2, DataCenter r3, q71.a r4, y61.a r5, Map r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "cardLifecycleMap");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.b = new LinkedHashMap();
        this.c = "TopRightCommonCardHandler";
    }
}
