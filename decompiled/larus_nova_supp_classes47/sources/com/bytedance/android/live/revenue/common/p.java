package com.bytedance.android.live.revenue.common;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class p {
    public final JsonObject a;

    public static final class a<T> implements ReadWriteProperty<p, T> {
        public final String a;
        public final KClass<?> b;
        public final T c;

        public final KClass<?> getType() {
            return this.b;
        }

        public a(String r2, KClass r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
            this.c = null;
        }

        public final T a(p r2, KProperty<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            JsonObject r4 = r2.a;
            if (r4.has(this.a) == false) goto L7;
            JsonElement r5 = r4.get(this.a);
            Intrinsics.checkNotNull(r5);
            KClass<?> r6 = this.b;
            return (T) GsonProtectorUtils.fromJson(l97.a.a, r5, JvmClassMappingKt.getJavaClass(r6));
        L7:
            return this.c;
        }

        public final /* bridge */ /* synthetic */ Object getValue(Object r1, KProperty r2) {
            return a((p) r1, r2);
        }

        public final void b(p r2, KProperty<?> r3, T r4) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            r2.a.add(this.a, GsonProtectorUtils.toJsonTree(l97.a.a, r4));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final /* bridge */ /* synthetic */ void setValue(Object r1, KProperty r2, Object r3) {
            b((p) r1, r2, r3);
        }
    }

    public p(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.a = r2;
    }
}
