package com.bytedance.android.bcm.api.model;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\r\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\rH\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0012J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J=\u0010\u0011\u001a\u00020\u00002.\u0010\u0015\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00140\u0013\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b\u0011\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J=\u0010\u001a\u001a\u00020\u00002.\u0010\u0015\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00140\u0013\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b\u001a\u0010\u0016J\u001e\u0010\u001a\u001a\u00020\u00002\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001bJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0002J\u0012\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\"\u001a\u00020\u0000J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040#J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u0002J\b\u0010'\u001a\u00020\u0002H\u0016R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040#8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/bytedance/android/bcm/api/model/BcmParams;", "Ljava/io/Serializable;", "", "key", "", "opt", "", "fallback", "optInt", "", "optLong", "", "optDouble", "", "optBoolean", "optString", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "put", "", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lcom/bytedance/android/bcm/api/model/BcmParams;", "putIfNull", "putOrRemove", "remove", "merge", "", "params", "bcmParams", "Lorg/json/JSONObject;", "trackParamsJSON", "trackParamsStr", "reset", "copy", "", "toMap", "toJSONObject", "toJSON", "toString", "map", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "<init>", "()V", "Companion", "a", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public class BcmParams implements Serializable {
    public static final a Companion = null;
    private final Map<String, Object> map;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BcmParams a(String r1) {
            return new BcmParams().merge(r1);
        }

        @JvmStatic
        public static BcmParams b(JSONObject r1) {
            return new BcmParams().merge(r1);
        }

        @JvmStatic
        public static BcmParams c(Map r1) {
            return new BcmParams().merge(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static BcmParams d(Map r10) {
            BcmParams r0 = new BcmParams();
            if (r10 == null) goto L10;
            Iterator r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) r11.next();
            Object r12 = r1.getValue();
            if (r12 == null) goto L6;
            r0.getMap().put(r1.getKey(), r12);
        L10:
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final BcmParams fromJSON(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @JvmStatic
    public static final BcmParams fromJSON(JSONObject r1) {
        Companion.getClass();
        return a.b(r1);
    }

    @JvmStatic
    public static final BcmParams fromMap(Map<String, ? extends Object> r1) {
        Companion.getClass();
        return a.c(r1);
    }

    @JvmStatic
    public static final BcmParams fromMapNew(Map<String, ? extends Object> r1) {
        Companion.getClass();
        return a.d(r1);
    }

    public final boolean optBoolean(String r10) {
        return optBoolean$default(this, r10, false, 2, null);
    }

    public final double optDouble(String r10) {
        return optDouble$default(this, r10, 0.0d, 2, null);
    }

    public final int optInt(String r10) {
        return optInt$default(this, r10, 0, 2, null);
    }

    public final long optLong(String r10) {
        return optLong$default(this, r10, 0, 2, null);
    }

    public final String optString(String r10) {
        return optString$default(this, r10, null, 2, null);
    }

    public final BcmParams copy() {
        BcmParams r0 = new BcmParams();
        Map<String, Object> r1 = this.map;
        monitor-enter(r1);
        r0.map.putAll(this.map);     // Catch: Throwable -> L7
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final JSONObject toJSONObject() {
        return cd.a.c(this.map);
    }

    public final Map<String, Object> toMap() {
        return new HashMap(this.map);
    }

    public BcmParams() {
        this.map = new ConcurrentHashMap();
    }

    public final String toJSON() {
        return toJSONObject().toString();
    }

    public String toString() {
        return toJSON();
    }

    public final Map<String, Object> getMap() {
        return this.map;
    }

    public final BcmParams merge(Map<String, ? extends Object> r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r0 = r11.next();
        put(r0.getKey(), r0.getValue());
        goto L6
    L8:
        return this;
    }

    public final Object opt(String r10) {
        return this.map.get(r10);
    }

    public final BcmParams put(Pair<String, ? extends Object>... r10) {
        int r0 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<String, ? extends Object> r11 = r10[r1];
        put((String) r11.getFirst(), r11.getSecond());
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public final BcmParams remove(String r10) {
        this.map.remove(r10);
        return this;
    }

    public final BcmParams reset(BcmParams r10) {
        this.map.clear();
        if (r10 == null) goto L5;
        this.map.putAll(r10.toMap());
    L5:
        return this;
    }

    public final BcmParams merge(JSONObject r10) {
        if (r10 != null) goto L12;
    L10:
        return this;
    L12:
        if (r10.length() <= 0) goto L10;
        Iterator<String> r0 = r10.keys();     // Catch: JSONException -> L11
    L7:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();     // Catch: JSONException -> L11
        put(r1, r10.get(r1));     // Catch: JSONException -> L11
        goto L7
    }

    public final BcmParams merge(String r10) {
        if (r10 != null) goto L4;
    L9:
        return this;
    L4:
        if (r10.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 != true) goto L9;
        merge(new JSONObject(r10));     // Catch: Exception -> L10
        goto L9
    L6:
        r0 = false;
        goto L7
    }

    public final BcmParams merge(Pair<String, ? extends Object>... r10) {
        int r0 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<String, ? extends Object> r11 = r10[r1];
        put((String) r11.getFirst(), r11.getSecond());
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public final BcmParams merge(BcmParams r1) {
        if (r1 == null) goto L4;
        merge(r1.map);
    L4:
        return this;
    }

    public final boolean optBoolean(String r10, boolean r11) {
        int r0 = c.a;
        Object r12 = this.map.get(r10);
        if ((r12 instanceof Boolean) == false) goto L6;
        Boolean r13 = (Boolean) r12;
    L14:
        if (r13 != null) goto L16;
        return r11;
    L16:
        return r13.booleanValue();
    L6:
        if ((r12 instanceof String) == false) goto L13;
        String r14 = (String) r12;
        if (StringsKt.equals("true", r14, true) == false) goto L11;
        r13 = Boolean.TRUE;
        goto L14
    L11:
        if (StringsKt.equals("false", r14, true) == false) goto L13;
        r13 = Boolean.FALSE;
    L13:
        r13 = null;
        goto L14
    }

    public final double optDouble(String r10, double r11) {
        int r0 = c.a;
        Object r12 = this.map.get(r10);
        if ((r12 instanceof Double) == false) goto L6;
        Double r13 = (Double) r12;
    L13:
        if (r13 != null) goto L15;
        return r11;
    L15:
        return r13.doubleValue();
    L6:
        if ((r12 instanceof Number) == false) goto L9;
        r13 = Double.valueOf(((Number) r12).doubleValue());
        goto L13
    L9:
        if ((r12 instanceof String) == true) goto L17;
    L12:
        r13 = null;
        goto L13
    L17:
        r13 = CastDoubleProtector.valueOf((String) r12);     // Catch: NumberFormatException -> L16
        goto L13
    }

    public final int optInt(String r10, int r11) {
        int r0 = c.a;
        Object r12 = this.map.get(r10);
        if ((r12 instanceof Integer) == false) goto L6;
        Integer r13 = (Integer) r12;
    L14:
        if (r13 != null) goto L16;
        return r11;
    L16:
        return r13.intValue();
    L6:
        if ((r12 instanceof Number) == false) goto L9;
        r13 = Integer.valueOf(((Number) r12).intValue());
        goto L14
    L9:
        if ((r12 instanceof String) == true) goto L18;
    L13:
        r13 = null;
        goto L14
    L18:
        r13 = 0;     // Catch: NumberFormatException -> L17
        goto L14
    }

    public final long optLong(String r10, long r11) {
        int r0 = c.a;
        Object r12 = this.map.get(r10);
        if ((r12 instanceof Long) == false) goto L6;
        Long r13 = (Long) r12;
    L14:
        if (r13 != null) goto L16;
        return r11;
    L16:
        return r13.longValue();
    L6:
        if ((r12 instanceof Number) == false) goto L9;
        r13 = Long.valueOf(((Number) r12).longValue());
        goto L14
    L9:
        if ((r12 instanceof String) == true) goto L18;
    L13:
        r13 = null;
        goto L14
    L18:
        r13 = 0L;     // Catch: NumberFormatException -> L17
        goto L14
    }

    public final String optString(String r10, String r11) {
        int r0 = c.a;
        Object r12 = this.map.get(r10);
        if ((r12 instanceof String) == false) goto L5;
        String r13 = (String) r12;
    L8:
        if (r13 != null) goto L10;
        return r11;
    L10:
        return r13;
    L5:
        if (r12 == null) goto L7;
        r13 = r12.toString();
        goto L8
    L7:
        r13 = null;
        goto L8
    }

    @Deprecated(message = "only basic types are supported")
    public final BcmParams put(String r10, Object r11) {
        if (r11 != null) goto L5;
    L23:
        return this;
    L5:
        if ((r11 instanceof String) == true) goto L13;
        if ((r11 instanceof Number) == true) goto L13;
        if ((r11 instanceof Boolean) == true) goto L13;
        if ((r11 instanceof JSONObject) == false) goto L20;
        this.map.put(r10, r11);
        goto L23
    L20:
        if ((r11 instanceof JSONArray) == false) goto L22;
        this.map.put(r10, r11);
        goto L23
    L22:
        this.map.put(r10, JSONObject.wrap(r11));
    L13:
        if (BtmSDK.INSTANCE.fixBcmValueNotConvert() == false) goto L15;
        this.map.put(r10, r11);
        goto L23
    L15:
        this.map.put(r10, r11.toString());
        goto L23
    }

    public final BcmParams putIfNull(String r10, Object r11) {
        Map<String, Object> r0 = this.map;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.map.get(r10) != null) goto L7;
        put(r10, r11);     // Catch: Throwable -> L10
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return this;
    }

    public final BcmParams putOrRemove(String r1, Object r10) {
        if (r10 != null) goto L4;
        remove(r1);
    L5:
        return this;
    L4:
        put(r1, r10);
        goto L5
    }

    public final BcmParams put(String r10, double r11) {
        this.map.put(r10, Double.valueOf(r11));
        return this;
    }

    public final BcmParams put(String r10, float r11) {
        this.map.put(r10, Float.valueOf(r11));
        return this;
    }

    public final BcmParams put(String r10, int r11) {
        this.map.put(r10, Integer.valueOf(r11));
        return this;
    }

    public final BcmParams put(String r10, long r11) {
        this.map.put(r10, Long.valueOf(r11));
        return this;
    }

    public final BcmParams put(String r10, String r11) {
        if (r11 == null) goto L4;
        this.map.put(r10, r11);
    L4:
        return this;
    }

    public static /* synthetic */ BcmParams reset$default(BcmParams r0, BcmParams r1, int r10, Object r11) {
        if (r11 != null) goto L9;
        if ((r10 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.reset(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reset");
    }

    public static /* synthetic */ boolean optBoolean$default(BcmParams r0, String r1, boolean r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = false;
    L7:
        return r0.optBoolean(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optBoolean");
    }

    public static /* synthetic */ double optDouble$default(BcmParams r0, String r1, double r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = Double.NaN;
    L7:
        return r0.optDouble(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optDouble");
    }

    public static /* synthetic */ int optInt$default(BcmParams r0, String r1, int r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = 0;
    L7:
        return r0.optInt(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optInt");
    }

    public static /* synthetic */ long optLong$default(BcmParams r0, String r1, long r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = 0;
    L7:
        return r0.optLong(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optLong");
    }

    public static /* synthetic */ String optString$default(BcmParams r0, String r1, String r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = null;
    L7:
        return r0.optString(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optString");
    }
}
