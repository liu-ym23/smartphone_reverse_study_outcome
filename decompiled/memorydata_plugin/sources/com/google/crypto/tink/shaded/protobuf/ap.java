package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class ap implements ao {
    ap() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> int b(int r4, Object r5, Object r6) {
        MapFieldLite r7 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r5, MapFieldLite.class, "com.obric.memorydata.plugin");
        an r8 = (an) ZeusTransformUtils.preCheckCast(r6, an.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r7.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r9 = r7.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2 = r2 + r8.a(r4, r0.getKey(), r0.getValue());
        goto L7
    L9:
        return r2;
    }

    private static <K, V> MapFieldLite<K, V> b(Object r2, Object r3) {
        MapFieldLite<K, V> r4 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
        MapFieldLite<K, V> r5 = (MapFieldLite) ZeusTransformUtils.preCheckCast(r3, MapFieldLite.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
    L8:
        return r4;
    L5:
        if (r4.isMutable() == true) goto L7;
        r4 = r4.mutableCopy();
    L7:
        r4.mergeFrom(r5);
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public int a(int r1, Object r2, Object r3) {
        return b(r1, r2, r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public Object a(Object r1, Object r2) {
        return b(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public Map<?, ?> a(Object r2) {
        return (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public Map<?, ?> b(Object r2) {
        return (MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public boolean c(Object r2) {
        return !((MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin")).isMutable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public Object d(Object r2) {
        ((MapFieldLite) ZeusTransformUtils.preCheckCast(r2, MapFieldLite.class, "com.obric.memorydata.plugin")).makeImmutable();
        return r2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public Object e(Object r1) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ao
    public an.a<?, ?> f(Object r2) {
        return ((an) ZeusTransformUtils.preCheckCast(r2, an.class, "com.obric.memorydata.plugin")).a();
    }
}
