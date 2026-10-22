package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObserveEarliestTimeStore$1 extends AdaptedFunctionReference implements Function0<Long> {
    public static final ObserveEarliestTimeStore$1 INSTANCE = null;

    static {
        INSTANCE = new ObserveEarliestTimeStore$1();
    }

    public ObserveEarliestTimeStore$1() {
        super(0, i0.class, "startOfTodayMillis", "startOfTodayMillis(J)J", 1);
    }

    public final Long invoke() {
        return Long.valueOf(i0.b(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m418invoke() {
        return invoke();
    }
}
