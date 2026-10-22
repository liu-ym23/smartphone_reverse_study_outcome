package com.obric.memorydata.awareness.impl.producer;

import com.google.android.material.timepicker.TimeModel;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R$\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/DateTimeFeatureProducer;", "Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "<init>", "()V", "features", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatures", "()Ljava/util/HashSet;", "needCacheFeatures", "getNeedCacheFeatures", "getFeature", "", "featureName", "getDayTypeInfo", "getTimeZone", "Lorg/json/JSONArray;", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.awareness.impl.producer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8745b = null;
    private final HashSet<String> c;
    private final HashSet<String> d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/DateTimeFeatureProducer$Companion;", "", "<init>", "()V", "TAG", "", "DayTypeEnum", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8745b = new a(null);
    }

    public b() {
        this.c = SetsKt.hashSetOf(new String[]{"today_day_type", "current_time_zone"});
        this.d = SetsKt.hashSetOf(new String[]{""});
    }

    private final String d() {
        return f.a(f.f8749a, 0, 1, null);
    }

    private final JSONArray e() {
        TimeZone r8 = Calendar.getInstance().getTimeZone();
        int r0 = r8.getRawOffset();
        JSONArray r1 = new JSONArray();
        long r2 = r0;
        int r3 = (int) (r2 / ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        int r4 = (int) ((r2 % ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) / ((long) 60000));
        StringBuilder r5 = new StringBuilder().append("UTC");
        if (r3 < 0) goto L5;
        String r6 = Marker.ANY_NON_NULL_MARKER;
    L6:
        StringBuilder r7 = r5.append(r6);
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r10 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(r3))}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(...)");
        StringBuilder r11 = r7.append(r10).append(':');
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        String r13 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(r4))}, 1));
        Intrinsics.checkNotNullExpressionValue(r13, "format(...)");
        String r14 = r11.append(r13).toString();
        r1.put(r8.getDisplayName());
        r1.put(r8.getID());
        r1.put(r14);
        return r1;
    L5:
        r6 = "-";
        goto L6
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a
    public /* synthetic */ Set b() {
        return (Set) ZeusTransformUtils.preCheckCast(c(), Set.class, "com.obric.memorydata.plugin");
    }

    public HashSet<String> c() {
        return this.c;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        if (Intrinsics.areEqual(r2, "today_day_type") == false) goto L6;
        return d();
    L6:
        if (Intrinsics.areEqual(r2, "current_time_zone") == true) goto L11;
        return null;
    L11:
        return e();
    }
}
