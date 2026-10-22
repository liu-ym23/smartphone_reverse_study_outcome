package com.bytedance.android.annie.service.network;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r extends b {
    public final /* synthetic */ Ref.ObjectRef<String> a;
    public final /* synthetic */ Ref.IntRef b;

    public final Integer a() {
        return Integer.valueOf(this.b.element);
    }

    public final String b() {
        return (String) this.a.element;
    }

    public r(LinkedHashMap<String, String> r1, Ref.IntRef r10, Ref.ObjectRef<String> r11, Ref.ObjectRef<String> r12, Ref.ObjectRef<Throwable> r13, Ref.IntRef r14) {
        this.a = r11;
        this.b = r14;
    }
}
