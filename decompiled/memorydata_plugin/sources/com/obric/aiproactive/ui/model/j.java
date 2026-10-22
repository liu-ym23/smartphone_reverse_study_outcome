package com.obric.aiproactive.ui.model;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0006\u0007\b\t\n\u000b\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "", "stableId", "", "getStableId", "()J", "Tip", "NowProcessed", "GuidedPreferenceEntry", "DayHeader", "MinuteHeader", "Recommendation", "End", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$End;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$GuidedPreferenceEntry;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$MinuteHeader;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$NowProcessed;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Tip;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface j {

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "dayKey", "", "date", "Ljava/time/LocalDate;", "title", CommonConsts.COUNT_TYPE, "", "expanded", "", "<init>", "(Ljava/lang/String;Ljava/time/LocalDate;Ljava/lang/String;IZ)V", "getDayKey", "()Ljava/lang/String;", "getDate", "()Ljava/time/LocalDate;", "getTitle", "getCount", "()I", "getExpanded", "()Z", "stableId", "", "getStableId", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LocalDate f6732b;
        private final String c;
        private final int d;
        private final boolean e;
        private final long f;

        public a(String r2, LocalDate r3, String r4, int r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "dayKey");
            Intrinsics.checkNotNullParameter(r3, "date");
            Intrinsics.checkNotNullParameter(r4, "title");
            this.f6731a = r2;
            this.f6732b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = ("day:" + r2).hashCode();
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.f;
        }

        public final String b() {
            return this.f6731a;
        }

        public final LocalDate c() {
            return this.f6732b;
        }

        public final String d() {
            return this.c;
        }

        public final int e() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6731a, r6.f6731a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6732b, r6.f6732b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final boolean f() {
            return this.e;
        }

        public int hashCode() {
            return (((((((this.f6731a.hashCode() * 31) + this.f6732b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "DayHeader(dayKey=" + this.f6731a + ", date=" + this.f6732b + ", title=" + this.c + ", count=" + this.d + ", expanded=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$End;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "stableId", "", "getStableId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6734b;

        public b(String r3) {
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f6733a = r3;
            this.f6734b = Long.MAX_VALUE;
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.f6734b;
        }

        public final String b() {
            return this.f6733a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6733a, r6.f6733a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6733a.hashCode();
        }

        public String toString() {
            return "End(text=" + this.f6733a + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$GuidedPreferenceEntry;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "<init>", "()V", "stableId", "", "getStableId", "()J", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6735a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f6736b = 0;

        static {
            f6735a = new c();
            f6736b = -812023163;
        }

        private c() {
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return f6736b;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
            return false;
        L9:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return 278340523;
        }

        public String toString() {
            return "GuidedPreferenceEntry";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$MinuteHeader;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "minuteKey", "", "timeText", "", "<init>", "(JLjava/lang/String;)V", "getMinuteKey", "()J", "getTimeText", "()Ljava/lang/String;", "stableId", "getStableId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6738b;
        private final long c;

        public d(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "timeText");
            this.f6737a = r2;
            this.f6738b = r4;
            this.c = ("minute:" + r2).hashCode();
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.c;
        }

        public final String b() {
            return this.f6738b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f6737a == r10.f6737a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6738b, r10.f6738b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f6737a) * 31) + this.f6738b.hashCode();
        }

        public String toString() {
            return "MinuteHeader(minuteKey=" + this.f6737a + ", timeText=" + this.f6738b + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$NowProcessed;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "stableId", "", "getStableId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6740b;

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.f6740b;
        }

        public final String b() {
            return this.f6739a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6739a, r6.f6739a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6739a.hashCode();
        }

        public String toString() {
            return "NowProcessed(text=" + this.f6739a + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JZ\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "dto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "dayKey", "", "timeText", "title", "subtitle", "primaryActionText", "primaryActionIcon", "", "<init>", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDto", "()Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "getDayKey", "()Ljava/lang/String;", "getTimeText", "getTitle", "getSubtitle", "getPrimaryActionText", "getPrimaryActionIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "stableId", "", "getStableId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "equals", "", "other", "", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProactiveRecommendationDto f6741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6742b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final Integer g;
        private final long h;

        public f(ProactiveRecommendationDto r2, String r3, String r4, String r5, String r6, String r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r2, "dto");
            Intrinsics.checkNotNullParameter(r4, "timeText");
            Intrinsics.checkNotNullParameter(r5, "title");
            Intrinsics.checkNotNullParameter(r7, "primaryActionText");
            this.f6741a = r2;
            this.f6742b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = l.b(r2).hashCode();
        }

        public /* synthetic */ f(ProactiveRecommendationDto r10, String r11, String r12, String r13, String r14, String r15, Integer r16, int r17, DefaultConstructorMarker r18) {
            if ((r17 & 2) == 0) goto L5;
            String r3 = null;
        L6:
            this(r10, r3, r12, r13, r14, r15, r16);
            return;
        L5:
            r3 = r11;
            goto L6
        }

        public static /* synthetic */ f a(f r5, ProactiveRecommendationDto r6, String r7, String r8, String r9, String r10, String r11, Integer r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.f6741a;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.f6742b;
        L8:
            String r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.c;
        L11:
            String r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.d;
        L14:
            String r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.e;
        L17:
            String r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.f;
        L20:
            String r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.g;
        L23:
            ProactiveRecommendationDto r16 = r6;
            return r5.a(r16, r15, r0, r1, r2, r3, r12);
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.h;
        }

        public final f a(ProactiveRecommendationDto r9, String r10, String r11, String r12, String r13, String r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r9, "dto");
            Intrinsics.checkNotNullParameter(r11, "timeText");
            Intrinsics.checkNotNullParameter(r12, "title");
            Intrinsics.checkNotNullParameter(r14, "primaryActionText");
            return new f(r9, r10, r11, r12, r13, r14, r15);
        }

        public final ProactiveRecommendationDto b() {
            return this.f6741a;
        }

        public final String c() {
            return this.f6742b;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6741a, r6.f6741a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6742b, r6.f6742b) == true) goto L15;
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
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public int hashCode() {
            int r0 = this.f6741a.hashCode() * 31;
            String r1 = this.f6742b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + this.f.hashCode()) * 31;
            Integer r8 = this.g;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Recommendation(dto=" + this.f6741a + ", dayKey=" + this.f6742b + ", timeText=" + this.c + ", title=" + this.d + ", subtitle=" + this.e + ", primaryActionText=" + this.f + ", primaryActionIcon=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveListItem$Tip;", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "stableId", "", "getStableId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6744b;

        public g(String r3) {
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f6743a = r3;
            this.f6744b = Long.MIN_VALUE;
        }

        @Override // com.obric.aiproactive.ui.model.j
        public long a() {
            return this.f6744b;
        }

        public final String b() {
            return this.f6743a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6743a, r6.f6743a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6743a.hashCode();
        }

        public String toString() {
            return "Tip(text=" + this.f6743a + ')';
        }
    }

    long a();
}
