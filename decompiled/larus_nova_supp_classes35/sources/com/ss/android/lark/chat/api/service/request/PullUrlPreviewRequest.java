package com.ss.android.lark.chat.api.service.request;

import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PullUrlPreviewRequest {
    public static final /* synthetic */ int c = 0;
    public final Map<String, List<UrlPreviewHangPoint>> a;
    public final Lazy b;

    public static final class a {
        public final Map<String, List<UrlPreviewHangPoint>> a;

        public a() {
            this.a = new LinkedHashMap();
        }

        public final void a(String r2, UrlPreviewHangPoint r3) {
            Intrinsics.checkNotNullParameter(r2, "sourceId");
            Intrinsics.checkNotNullParameter(r3, "hangPoint");
            List<UrlPreviewHangPoint> r0 = (List) ((LinkedHashMap) this.a).get(r2);
            if (r0 != null) goto L5;
            r0 = new ArrayList();
        L5:
            r0.add(r3);
            this.a.put(r2, r0);
        }

        public final void b(String r2, List r3) {
            Intrinsics.checkNotNullParameter(r2, "sourceId");
            Intrinsics.checkNotNullParameter(r3, "hangPoints");
            List<UrlPreviewHangPoint> r0 = (List) ((LinkedHashMap) this.a).get(r2);
            if (r0 != null) goto L5;
            r0 = new ArrayList();
        L5:
            r0.addAll(r3);
            this.a.put(r2, r0);
        }
    }

    public static final class b {
        public b() {
        }

        public static final String a(Map r3, String r4) {
            int r0 = PullUrlPreviewRequest.c;
            String r5 = r4.concat(": ");
            Iterator r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            Map.Entry r1 = (Map.Entry) r6.next();
            r5 = r5 + "| msgId: " + ((String) r1.getKey());
            Iterator r2 = ((Iterable) r1.getValue()).iterator();
        L7:
            if (r2.hasNext() == false) goto L4;
            r5 = r5 + " previewId : " + ((UrlPreviewHangPoint) r2.next()).preview_id + ' ';
            goto L7
        L9:
            return r5;
        }
    }

    static {
        new b();
    }

    public PullUrlPreviewRequest() {
        throw null;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return (String) this.b.getValue();
    }

    public PullUrlPreviewRequest(Map r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new PullUrlPreviewRequest$logMessage$2(this));
    }

    public final boolean equals(Object r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof PullUrlPreviewRequest) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.a, ((PullUrlPreviewRequest) r3).a);
    }
}
