package com.obric.memorydata.recommend.guide;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppRow;", "", "<init>", "()V", "CategoryHeader", "App", "CategoryDesc", "Lcom/obric/memorydata/recommend/guide/GuideAppRow$App;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow$CategoryDesc;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow$CategoryHeader;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppRow$App;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow;", "data", "Lcom/obric/memorydata/recommend/settings/AppSettingItem;", "index", "", LBSLightLocationTraceLogger.TOTAL, "<init>", "(Lcom/obric/memorydata/recommend/settings/AppSettingItem;II)V", "getData", "()Lcom/obric/memorydata/recommend/settings/AppSettingItem;", "getIndex", "()I", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.recommend.settings.c f12518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12519b;
        private final int c;

        public a(com.obric.memorydata.recommend.settings.c r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super(null);
            this.f12518a = r2;
            this.f12519b = r3;
            this.c = r4;
        }

        public final com.obric.memorydata.recommend.settings.c a() {
            return this.f12518a;
        }

        public final int b() {
            return this.f12519b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12518a, r6.f12518a) == true) goto L12;
            return false;
        L12:
            if (this.f12519b == r6.f12519b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12518a.hashCode() * 31) + Integer.hashCode(this.f12519b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "App(data=" + this.f12518a + ", index=" + this.f12519b + ", total=" + this.c + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppRow$CategoryDesc;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0672b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12520a;

        public C0672b(String r2) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            super(null);
            this.f12520a = r2;
        }

        public final String a() {
            return this.f12520a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0672b.class) == true) goto L8;
            return false;
        L8:
            C0672b r6 = (C0672b) ZeusTransformUtils.preCheckCast(r5, C0672b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12520a, r6.f12520a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f12520a.hashCode();
        }

        public String toString() {
            return "CategoryDesc(text=" + this.f12520a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppRow$CategoryHeader;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow;", ActivityLifecycle.NAME, "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12521a;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            super(null);
            this.f12521a = r2;
        }

        public final String a() {
            return this.f12521a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12521a, r6.f12521a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f12521a.hashCode();
        }

        public String toString() {
            return "CategoryHeader(name=" + this.f12521a + ')';
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker r1) {
        this();
    }
}
