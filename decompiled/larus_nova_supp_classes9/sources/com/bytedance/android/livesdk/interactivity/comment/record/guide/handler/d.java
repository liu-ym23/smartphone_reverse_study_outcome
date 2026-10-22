package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.RecordGuideContext;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.comment.record.guide.a {
    public final String b;
    public final Map<Long, String> c;
    public final Map<Long, Observable<String>> d;
    public final List<String> e;

    public d() {
        this.b = "DownloadHandler";
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.a, com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void b() {
        super.b();
        int r0 = e72.c.a;
        e72.c.a(this.e);
        e72.c.a(CollectionsKt.toMutableList(((LinkedHashMap) this.c).values()));
        ((LinkedHashMap) this.d).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.a, com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void a(RecordGuideContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        ((LinkedHashMap) this.d).clear();
    }

    public final Observable<String> c(com.bytedance.android.livesdk.interactivity.comment.record.guide.n r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        String r0 = (String) ((LinkedHashMap) this.c).get(Long.valueOf(r10.c.e()));
        if (r0 != null) goto L5;
    L11:
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r3 = r10.c;
        Observable<String> r1 = (Observable) ((LinkedHashMap) this.d).get(Long.valueOf(r3.e()));
        if (r1 != null) goto L17;
        long r7 = r3.e();
        Observable<String> r11 = Observable.create(new c(this, r3, r10, r7)).subscribeOn(Schedulers.io());
        this.d.put(Long.valueOf(r7), r11);
        return r11;
    L17:
        return r1;
    L5:
        if ((!FileUtils.isFileEmpty(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        Observable<String> r2 = Observable.just(r0);
        if (r2 == null) goto L11;
        return r2;
    }
}
