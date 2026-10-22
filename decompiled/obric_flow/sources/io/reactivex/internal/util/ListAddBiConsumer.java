package io.reactivex.internal.util;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final enum ListAddBiConsumer extends Enum<ListAddBiConsumer> implements pt.c {
    public static final ListAddBiConsumer INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListAddBiConsumer[] f18167a = null;

    static {
        ListAddBiConsumer r5 = new ListAddBiConsumer("INSTANCE", 0);
        INSTANCE = r5;
        f18167a = new ListAddBiConsumer[]{r5};
    }

    public static <T> pt.c instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String r5) {
        return (ListAddBiConsumer) Enum.valueOf(ListAddBiConsumer.class, r5);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) f18167a.clone();
    }

    @Override // pt.c
    public /* bridge */ /* synthetic */ Object apply(Object r5, Object r10) throws Exception {
        return apply((List) r5, r10);
    }

    public List apply(List r5, Object r10) throws Exception {
        r5.add(r10);
        return r5;
    }
}
