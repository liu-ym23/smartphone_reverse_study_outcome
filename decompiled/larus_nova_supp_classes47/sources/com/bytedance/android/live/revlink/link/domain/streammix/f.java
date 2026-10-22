package com.bytedance.android.live.revlink.link.domain.streammix;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.streaminteract.biz.StreamMixDescriptor;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.android.live.revlink.link.biz.service.a {
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a a;
    public final AnchorUILayoutManager b;
    public final IConfig.e c;
    public final Function1<String, Boolean> d;
    public final Function1<String, GridWindowType> e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.a;
    }

    public f(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, AnchorUILayoutManager r3, IConfig.e r4, Function1 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r5, "queryIsLiveTypeAudio");
        Intrinsics.checkNotNullParameter(r6, "queryWindowType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final d a(List r18, k41.b r19, Map r20, Map r22, StreamMixDescriptor r23) {
        Map r3 = r20;
        Intrinsics.checkNotNullParameter(r18, "regions");
        Intrinsics.checkNotNullParameter(r19, "mixStrategy");
        Intrinsics.checkNotNullParameter(r3, "seiRegionMap");
        Intrinsics.checkNotNullParameter(r22, "audienceSeiRegion");
        Intrinsics.checkNotNullParameter(r23, "descriptor");
        JSONArray r6 = new JSONArray();
        RectF r7 = r19.b;
        Object[] r1 = r18.toArray(new IRegion[0]);
        if (r1 == null) goto L58;
        ArraysKt.sortWith((IRegion[]) r1, e.a);
        List r2 = ArraysKt.toList(r1);
        Iterator r9 = r2.iterator();
    L6:
        if (r9.hasNext() == false) goto L31;
        IRegion r10 = (IRegion) r9.next();
        t51.b r12 = (t51.b) ((LinkedHashMap) r3).get(r10.getInteractId());
        if (r12 != null) goto L12;
        r12 = (t51.b) ((LinkedHashMap) r22).get(r10.getInteractId());
        if (r12 != null) goto L12;
        RectF r13 = null;
    L14:
        if (r13 == null) goto L30;
        if ((this.b.e instanceof o51.e.C0283e) == true) goto L20;
        float r14 = r13.left;
        float r15 = r23.c;
        float r8 = r13.top;
        float r16 = r23.b;
        r13 = r19.a(new RectF(r14 - r15, (r8 - r16) / 0.5625f, r13.right - r15, (r13.bottom - r16) / 0.5625f));
    L20:
        boolean r4 = ((Boolean) this.d.invoke(r10.getInteractId())).booleanValue();
        Intrinsics.checkNotNullParameter(r10, "$this$writeSeiInfo");
        Intrinsics.checkNotNullParameter(r6, "grids");
        Intrinsics.checkNotNullParameter(r13, "seiRectF");
        if (r10.d2() == false) goto L23;
    L25:
        RectF r17 = com.bytedance.android.live.revlink.impl.rtc.c.a(r13, r7);
        JSONObject r110 = new JSONObject();
        r110.put("type", r10.getMediaType().toSeiFormat());
        r110.put("alpha", 1);
        r110.put("w", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r17.width())));
        r110.put("h", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r17.height())));
        r110.put("x", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r17.left)));
        r110.put("y", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r17.top)));
        r110.put("account", 0);
        r110.put("uid", 0);
        r110.put("uid_str", r10.getInteractId());
        r110.put("zorder", 0);
        r110.put("stat", r10.getStatus().toSeiFormat());
        Intrinsics.checkNotNullParameter(r10, "$this$talkField");
        if (r10.z4() == true) goto L28;
        int r111 = 0;
    L29:
        r110.put("talk", r111);
        r110.put("talk_volume", r10.M4());
        r110.put("mute_audio", r10.C1() ? 1 : 0);
        r110.put("is_audio", r4 ? 1 : 0);
        r110.put("w_type", ((GridWindowType) this.e.invoke(r10.getInteractId())).ordinal());
        r6.put(r110);
        goto L30
    L28:
        r111 = 2;
        goto L29
    L23:
        if ((!Intrinsics.areEqual(r10.getInteractId(), getContext().Zl())) == false) goto L25;
    L30:
        r3 = r20;
    L12:
        r13 = o51.a.c(r12);
        goto L14
    L31:
        Iterator r5 = r2.iterator();
        int r112 = 0;
    L33:
        if (r5.hasNext() == false) goto L38;
        if (Intrinsics.areEqual(((IRegion) r5.next()).getInteractId(), getContext().Zl()) == true) goto L39;
        r112 = r112 + 1;
    L39:
        int r24 = RangesKt.coerceAtLeast(r112, 0);
        ArrayList r25 = new ArrayList();
        Iterator r26 = r2.iterator();
    L41:
        if (r26.hasNext() == false) goto L51;
        Object r27 = r26.next();
        IRegion r28 = (IRegion) r27;
        if (r28.d2() == false) goto L45;
    L48:
        boolean r29 = true;
    L49:
        if (r29 == false) goto L41;
        r25.add(r27);
        goto L41
    L45:
        if (Intrinsics.areEqual(r28.getInteractId(), getContext().Zl()) == true) goto L48;
        r29 = false;
        goto L49
    L51:
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator r32 = r25.iterator();
    L53:
        if (r32.hasNext() == false) goto L56;
        IRegion r33 = (IRegion) r32.next();
        Intrinsics.checkNotNullParameter(r33, "$this$rectF");
        r30.add(new RectF((float) r33.getX(), (float) r33.getY(), (float) (r33.getX() + r33.getWidth()), (float) (r33.getY() + r33.getHeight())));
        goto L53
    L56:
        return new d(r6, r24, o51.a.d(CollectionsKt.toList(r30)));
    L38:
        r112 = -1;
        goto L39
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
