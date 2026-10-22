package com.obric.memorydata.awareness.cae;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fJ*\u0010 \u001a\u00020!*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J`\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lcom/obric/memorydata/awareness/cae/PoiObservation;", "", "poiId", "", "poiName", "aoiId", "aoiName", "categoryL1", "categoryL2", "categoryL3", "sourceTimestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getPoiId", "()Ljava/lang/String;", "getPoiName", "getAoiId", "getAoiName", "getCategoryL1", "getCategoryL2", "getCategoryL3", "getSourceTimestampMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "hasPoi", "", "getHasPoi", "()Z", "identity", "toEventExtras", "", "putIfNotBlank", "", "", "key", EventBody.KEY_VALUE, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/awareness/cae/PoiObservation;", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8601b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final Long h;

    public i() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public i(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Long r9) {
        Intrinsics.checkNotNullParameter(r2, "poiId");
        Intrinsics.checkNotNullParameter(r3, "poiName");
        Intrinsics.checkNotNullParameter(r4, "aoiId");
        Intrinsics.checkNotNullParameter(r5, "aoiName");
        Intrinsics.checkNotNullParameter(r6, "categoryL1");
        Intrinsics.checkNotNullParameter(r7, "categoryL2");
        Intrinsics.checkNotNullParameter(r8, "categoryL3");
        this.f8600a = r2;
        this.f8601b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ i(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Long r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = "";
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = "";
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = "";
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private final void a(Map<String, Object> r2, String r3, String r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        r1.put(r3, r4);
        return;
    }

    public final String a() {
        return this.f8600a;
    }

    public final String b() {
        return this.f8601b;
    }

    public final Long c() {
        return this.h;
    }

    public final boolean d() {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.f8600a, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.f8601b, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return false;
    L10:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String e() {
        if (d() == true) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.f8600a, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        String[] r0 = new String[3];
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.c, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L13;
        r4 = this.d;
    L13:
        r0[0] = r4;
        r0[1] = this.f8601b;
        r0[2] = this.g;
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r0), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u001f", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L9:
        return "id:" + this.f8600a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8600a, r6.f8600a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8601b, r6.f8601b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final Map<String, Object> f() {
        LinkedHashMap r0 = new LinkedHashMap();
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "poi_id", this.f8600a);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "poi_name", this.f8601b);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "aoi_id", this.c);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "aoi_name", this.d);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "category_l1", this.e);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "category_l2", this.f);
        a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), "category_l3", this.g);
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f8600a.hashCode() * 31) + this.f8601b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Long r2 = this.h;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiObservation(poiId=" + this.f8600a + ", poiName=" + this.f8601b + ", aoiId=" + this.c + ", aoiName=" + this.d + ", categoryL1=" + this.e + ", categoryL2=" + this.f + ", categoryL3=" + this.g + ", sourceTimestampMs=" + this.h + ')';
    }
}
