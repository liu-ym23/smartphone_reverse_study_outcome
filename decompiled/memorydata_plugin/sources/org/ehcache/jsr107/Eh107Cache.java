package org.ehcache.jsr107;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.cache.Cache;

/* JADX INFO: loaded from: classes7.dex */
class Eh107Cache<K, V> implements Cache<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f18101b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18102a;

    private static final enum MutableEntryOperation extends Enum<MutableEntryOperation> {
        private static final /* synthetic */ MutableEntryOperation[] $VALUES = null;
        public static final MutableEntryOperation ACCESS = null;
        public static final MutableEntryOperation CREATE = null;
        public static final MutableEntryOperation LOAD = null;
        public static final MutableEntryOperation NONE = null;
        public static final MutableEntryOperation REMOVE = null;
        public static final MutableEntryOperation UPDATE = null;

        static {
            MutableEntryOperation r0 = new MutableEntryOperation("NONE", 0);
            NONE = r0;
            MutableEntryOperation r1 = new MutableEntryOperation("ACCESS", 1);
            ACCESS = r1;
            MutableEntryOperation r3 = new MutableEntryOperation("CREATE", 2);
            CREATE = r3;
            MutableEntryOperation r5 = new MutableEntryOperation("LOAD", 3);
            LOAD = r5;
            MutableEntryOperation r7 = new MutableEntryOperation("REMOVE", 4);
            REMOVE = r7;
            MutableEntryOperation r9 = new MutableEntryOperation("UPDATE", 5);
            UPDATE = r9;
            $VALUES = new MutableEntryOperation[]{r0, r1, r3, r5, r7, r9};
        }

        private MutableEntryOperation(String r1, int r2) {
            super(r1, r2);
        }

        public static MutableEntryOperation valueOf(String r2) {
            return (MutableEntryOperation) ZeusTransformUtils.preCheckCast(Enum.valueOf(MutableEntryOperation.class, r2), MutableEntryOperation.class, "com.obric.memorydata.plugin");
        }

        public static MutableEntryOperation[] values() {
            return (MutableEntryOperation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MutableEntryOperation[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f18101b = new Object();
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f18102a + "]";
    }
}
