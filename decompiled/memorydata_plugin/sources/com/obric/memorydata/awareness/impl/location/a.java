package com.obric.memorydata.awareness.impl.location;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.sdk.awareness.model.GeoFenceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/CurrentGeoFencesValueConverter;", "", "<init>", "()V", "convert", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo;", "Lkotlin/collections/ArrayList;", EventBody.KEY_VALUE, "EventField", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8729a = null;

    static {
        f8729a = new a();
    }

    private a() {
    }

    public final ArrayList<GeoFenceInfo> a(Object r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L9;
        List r8 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"));
    L18:
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r9.hasNext() == false) goto L44;
        Object r3 = r9.next();
        if (ZeusTransformUtils.instanceOf(r3, GeoFenceInfo.class) == false) goto L25;
        String r4 = ((GeoFenceInfo) ZeusTransformUtils.preCheckCast(r3, GeoFenceInfo.class, "com.obric.memorydata.plugin")).getFenceId();
    L35:
        if (r4 == null) goto L36;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L43;
        if (Intrinsics.areEqual(r4, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L43;
        if (r0.add(r4) == true) goto L20;
    L43:
        return null;
    L36:
        return null;
    L25:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L30;
        Object r5 = ((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin")).opt("fence_id");
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L34;
    L28:
        r4 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L34:
        r4 = null;
        goto L35
    L30:
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == false) goto L34;
        r5 = ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).get("fence_id");
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L34;
    L44:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r6.iterator();
    L46:
        if (r11.hasNext() == false) goto L49;
        r10.add(new GeoFenceInfo((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin")));
        goto L46
    L49:
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    L9:
        if ((r7 instanceof Object[]) == false) goto L12;
        r8 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.memorydata.plugin"));
        goto L18
    L12:
        if (ZeusTransformUtils.instanceOf(r7, JSONArray.class) == false) goto L50;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin")).length()), Iterable.class, "com.obric.memorydata.plugin");
        JSONArray r12 = (JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        r13.add(r12.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r2, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));
        goto L15
    L17:
        r8 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        goto L18
    L50:
        return null;
    }
}
