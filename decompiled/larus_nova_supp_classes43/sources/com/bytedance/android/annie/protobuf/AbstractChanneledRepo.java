package com.bytedance.android.annie.protobuf;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/protobuf/AbstractChanneledRepo;", "T", "", "annie-protobuf_release"}, k = 1, mv = {1, 4, 3})
public class AbstractChanneledRepo<T> {
    public final String a;
    public final String b;
    public final Function2<String, BufferedReader, T> c;
    public final ConcurrentHashMap<String, T> d;
    public final com.bytedance.android.annie.service.prefetch.b e;

    public final void a() {
        Map r0 = c.a(this.e, this.a);
        Map r1 = c.a(this.e, this.b);
        if (AnnieConfigSettingKeys.ENABLE_LATCH_PB_COMPLETE.a().booleanValue() == false) goto L8;
        Iterator r10 = MapsKt.asSequence(MapsKt.plus(r0, r1)).iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        BufferedReader r13 = (BufferedReader) r11.getValue();
        this.d.put(r12, (T) this.c.invoke(r12, r13));
        goto L6
    L12:
        return;
    L8:
        Iterator r14 = MapsKt.asSequence(r0).iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        BufferedReader r17 = (BufferedReader) r15.getValue();
        this.d.put(r16, (T) this.c.invoke(r16, r17));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChanneledRepo(String r10, String r11, Function2<? super String, ? super BufferedReader, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "relativePath");
        Intrinsics.checkNotNullParameter(r11, "relativePathV2");
        Intrinsics.checkNotNullParameter(r12, "createInstance");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = new ConcurrentHashMap();
        this.e = new com.bytedance.android.annie.service.prefetch.b(0);
    }
}
