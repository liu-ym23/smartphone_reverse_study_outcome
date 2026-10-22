package com.bytedance.android.livesdk.dynamicstrategy.api;

import iu1.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class DynamicFactor<T> {
    public a<T> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor$Type;", "", "LOCAL", "PLATFORM", "SMART_MIX", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type LOCAL = null;
        public static final Type PLATFORM = null;
        public static final Type SMART_MIX = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("LOCAL", 0);
            LOCAL = r1;
            Type r2 = new Type("PLATFORM", 1);
            PLATFORM = r2;
            Type r3 = new Type("SMART_MIX", 2);
            SMART_MIX = r3;
            a = new Type[]{r1, r2, r3};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public DynamicFactor() {
    }

    public abstract T b();

    public abstract String c();

    public abstract void d();

    public abstract void e();

    public Type getType() {
        return Type.LOCAL;
    }

    public final void update(T r2) {
        a<T> r0 = this.a;
        if (r0 == null) goto L6;
        r0.update(r2);
        return;
    }
}
