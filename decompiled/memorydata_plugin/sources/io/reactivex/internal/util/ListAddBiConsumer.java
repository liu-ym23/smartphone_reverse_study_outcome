package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final enum ListAddBiConsumer extends Enum<ListAddBiConsumer> implements io.reactivex.b.c<List, Object, List> {
    private static final /* synthetic */ ListAddBiConsumer[] $VALUES = null;
    public static final ListAddBiConsumer INSTANCE = null;

    static {
        ListAddBiConsumer r0 = new ListAddBiConsumer("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new ListAddBiConsumer[]{r0};
    }

    private ListAddBiConsumer(String r1, int r2) {
        super(r1, r2);
    }

    public static <T> io.reactivex.b.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String r2) {
        return (ListAddBiConsumer) ZeusTransformUtils.preCheckCast(Enum.valueOf(ListAddBiConsumer.class, r2), ListAddBiConsumer.class, "com.obric.memorydata.plugin");
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ListAddBiConsumer[].class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.b.c
    public /* synthetic */ List apply(List r3, Object r4) {
        return apply2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List apply2(List r2, Object r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        r1.add(r3);
        return r1;
    }
}
