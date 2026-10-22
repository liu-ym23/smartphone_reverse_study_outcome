package com.ss.ugc.effectplatform.task;

import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.StrategyCacheClearModel;
import com.ss.ugc.effectplatform.model.net.StrategyCacheClearResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StrategyCacheClearTask extends BaseNetworkTask<StrategyCacheClearModel, StrategyCacheClearResponse> {
    public final EffectConfig n;
    public final List<a> o;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/task/StrategyCacheClearTask$CacheInfo;", "", "", "component1", "component2", TabAppInfo.IMAGE_JSON_KEY, "last_time", "copy", "toString", "", "hashCode", INotificationHitPoint.NoticeType.OTHER, "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getLast_time", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final class CacheInfo {
        public static final a Companion = null;
        private final String key;
        private final String last_time;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ CacheInfo copy$default(CacheInfo r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.key;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.last_time;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.last_time;
        }

        public final CacheInfo copy(String r2, String r3) {
            return new CacheInfo(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CacheInfo) == false) goto L10;
            CacheInfo r4 = (CacheInfo) r3;
            if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.last_time, r4.last_time) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.key;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.last_time;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "CacheInfo(key=" + this.key + ", last_time=" + this.last_time + ")";
        }

        public final String getKey() {
            return this.key;
        }

        public final String getLast_time() {
            return this.last_time;
        }

        public CacheInfo(String r1, String r2) {
            this.key = r1;
            this.last_time = r2;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0081\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u0019\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J7\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/effectplatform/task/StrategyCacheClearTask$RequestResourceInfo;", "", "", "component1", "component2", "Ljava/util/ArrayList;", "Lcom/ss/ugc/effectplatform/task/StrategyCacheClearTask$CacheInfo;", "Lkotlin/collections/ArrayList;", "component3", "type", "panel", "resources", "copy", "toString", "", "hashCode", INotificationHitPoint.NoticeType.OTHER, "", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "getPanel", "Ljava/util/ArrayList;", "getResources", "()Ljava/util/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "Companion", "a", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final class RequestResourceInfo {
        public static final a Companion = null;
        public static final String TYPE_EFFECT = "effect";
        private final String panel;
        private final ArrayList<CacheInfo> resources;
        private final String type;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestResourceInfo copy$default(RequestResourceInfo r0, String r1, String r2, ArrayList r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.panel;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.resources;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.panel;
        }

        public final ArrayList<CacheInfo> component3() {
            return this.resources;
        }

        public final RequestResourceInfo copy(String r2, String r3, ArrayList<CacheInfo> r4) {
            return new RequestResourceInfo(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof RequestResourceInfo) == false) goto L12;
            RequestResourceInfo r4 = (RequestResourceInfo) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.panel, r4.panel) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.resources, r4.resources) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.panel;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            ArrayList<CacheInfo> r7 = this.resources;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "RequestResourceInfo(type=" + this.type + ", panel=" + this.panel + ", resources=" + this.resources + ")";
        }

        public final String getPanel() {
            return this.panel;
        }

        public final ArrayList<CacheInfo> getResources() {
            return this.resources;
        }

        public final String getType() {
            return this.type;
        }

        public RequestResourceInfo(String r1, String r2, ArrayList<CacheInfo> r3) {
            this.type = r1;
            this.panel = r2;
            this.resources = r3;
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final long c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof a) == false) goto L12;
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r6.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            long r6 = this.c;
            return r5 + ((int) (r6 ^ (r6 >>> 32)));
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "EffectCacheInfo(effectId=" + this.a + ", panel=" + this.b + ", lastAccessTime=" + this.c + ")";
        }

        public a(String r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final NetRequest f() {
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("ck_resource_sdk_version", "1.2.0");
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        r5.put("base_info", com.ss.ugc.effectplatform.util.g.b(this.n, 6));
        r5.put("use_level", 0);
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = this.o.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        a r3 = (a) r2.next();
        Iterator r4 = r1.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((RequestResourceInfo) r6).getPanel(), r3.b) == false) goto L7;
    L12:
        RequestResourceInfo r7 = (RequestResourceInfo) r6;
        if (r7 != null) goto L14;
        String r8 = r3.b;
        CacheInfo.Companion.getClass();
        r1.add(new RequestResourceInfo(RequestResourceInfo.TYPE_EFFECT, r8, CollectionsKt.arrayListOf(new CacheInfo[]{new CacheInfo(r3.a, String.valueOf(r3.c))})));
        goto L4
    L14:
        ArrayList<CacheInfo> r9 = r7.getResources();
        CacheInfo.Companion.getClass();
        r9.add(new CacheInfo(r3.a, String.valueOf(r3.c)));
        goto L4
    L11:
        r6 = null;
        goto L12
    L16:
        r5.put("local_resource_list", r1);
        return new NetRequest(Intrinsics.stringPlus(this.n.E, "/material/resource/api/management"), null, HTTPMethod.POST, null, r5, "application/json", false, null, 202, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (StrategyCacheClearResponse) r2.a.convertJsonToObj(r3, StrategyCacheClearResponse.class);
    }

    public StrategyCacheClearTask(EffectConfig r8, List<a> r9, String r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
    }
}
