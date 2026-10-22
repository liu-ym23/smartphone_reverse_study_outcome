package com.obric.memorydata.awareness.impl.location;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.sdk.awareness.model.LocationInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r*\u0004\u0018\u00010\u0001H\u0002J$\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationInfoValueConverter;", "", "<init>", "()V", "convert", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", EventBody.KEY_VALUE, "isValidLocationInfo", "", "locationInfo", "toAoiInfo", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "toObjectMap", "", "", "optionalString", "key", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8742a = null;

    static {
        f8742a = new d();
    }

    private d() {
    }

    private final String a(Map<String, ? extends Object> r2, String r3) {
        Object r1 = ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get(r3);
        if (r1 != null) goto L5;
    L12:
        return null;
    L5:
        if (r1 == JSONObject.NULL) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L11;
        return null;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    }

    private final boolean a(LocationInfo r1) {
        if (r1.getLocationType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final LocationInfo.AoiInfo b(Object r6) {
        Map<String, Object> r7 = c(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        String r1 = a(r7, "aoi_id");
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r3 = a(r7, "aoi_name");
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        String r5 = a(r7, "aoi_type");
        if (r5 == null) goto L17;
        r2 = r5;
    L17:
        return new LocationInfo.AoiInfo(r1, r3, r2);
    }

    private final Map<String, Object> c(Object r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7 != JSONObject.NULL) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L15;
        Iterator<String> r6 = ((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin")).keys();
        Intrinsics.checkNotNullExpressionValue(r6, "keys(...)");
        Sequence r8 = SequencesKt.asSequence(r6);
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L34;
        Object r2 = r9.next();
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r2, ((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin")).opt((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")));
        goto L11
    L34:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L35;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L18:
        if (r11.hasNext() == false) goto L26;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r4 = r3.getKey();
        Object r5 = r3.getValue();
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L22;
        Pair r12 = null;
    L23:
        if (r12 == null) goto L18;
        r1.add(r12);
        goto L18
    L22:
        r12 = TuplesKt.to(r4, r5);
        goto L23
    L26:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L35:
        return null;
    }

    public final LocationInfo a(Object r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, LocationInfo.class) == true) goto L8;
        Map<String, Object> r7 = c(r6);
        if (r7 != null) goto L16;
        return null;
    L16:
        String r2 = a(r7, "location_type");
        LocationInfo.AoiInfo r3 = b(r7.get("aoi_info"));
        String r5 = a(r7, "update_source");
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        LocationInfo r1 = new LocationInfo(r2, r3, r5);
        if (f8742a.a(r1) == true) goto L22;
        return null;
    L22:
        return r1;
    L8:
        if (f8742a.a((LocationInfo) ZeusTransformUtils.preCheckCast(r6, LocationInfo.class, "com.obric.memorydata.plugin")) == true) goto L12;
        r6 = null;
    L12:
        return (LocationInfo) ZeusTransformUtils.preCheckCast(r6, LocationInfo.class, "com.obric.memorydata.plugin");
    }
}
