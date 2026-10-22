package com.bytedance.android.live.browser.jsbridge.protobuf;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/protobuf/AbstractChanneledRepo;", "T", "", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AbstractChanneledRepo<T> {
    public final ConcurrentHashMap<String, T> a;
    public final String b;
    public final String c;
    public final Function2<String, BufferedReader, T> d;

    public final void a() {
        if (this.c.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Map<String, BufferedReader> r1 = FileContentUtilKt.a(this.c);
    L10:
        if (r1.isEmpty() == false) goto L12;
        r1 = FileContentUtilKt.a(this.b);
    L12:
        Iterator r2 = MapsKt.asSequence(r1).iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        BufferedReader r5 = (BufferedReader) r3.getValue();
        this.a.put(r4, (T) this.d.invoke(r4, r5));
        goto L14
    L16:
        return;
    L8:
        r1 = FileContentUtilKt.a(this.b);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChanneledRepo(String r2, String r3, Function2<? super String, ? super BufferedReader, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r2, "relativePath");
        Intrinsics.checkNotNullParameter(r3, "relativePathV2");
        Intrinsics.checkNotNullParameter(r4, "createInstance");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ConcurrentHashMap();
    }
}
