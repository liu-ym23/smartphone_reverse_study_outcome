package com.bytedance.android.live.broadcast.perftools;

import com.bytedance.keva.Keva;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BroadcastKevaHelper {
    public static final Keva a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/perftools/BroadcastKevaHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", "ALL", "livebroadcast-shared-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("STRING", 0);
            STRING = r1;
            Type r2 = new Type("INTEGER", 1);
            INTEGER = r2;
            Type r3 = new Type("BOOLEAN", 2);
            BOOLEAN = r3;
            Type r4 = new Type("FLOAT", 3);
            FLOAT = r4;
            Type r5 = new Type("LONG", 4);
            LONG = r5;
            Type r6 = new Type("STRING_SET", 5);
            STRING_SET = r6;
            Type r7 = new Type("ALL", 6);
            ALL = r7;
            a = new Type[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        a = Keva.getRepo("live_broadcast_keva_sp", 0);
    }
}
