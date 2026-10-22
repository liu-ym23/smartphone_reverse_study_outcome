package com.bytedance.android.live.impl.service;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePortraitCenterService$getGroupPortraits$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ConcurrentHashMap $result;

    public LivePortraitCenterService$getGroupPortraits$1(ConcurrentHashMap r1) {
        this.$result = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m967invoke() {
        return "LivePortraitCenterService configGroupPortraits()= " + this.$result;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m967invoke();
    }
}
