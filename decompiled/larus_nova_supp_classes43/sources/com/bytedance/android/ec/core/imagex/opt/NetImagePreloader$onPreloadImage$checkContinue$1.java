package com.bytedance.android.ec.core.imagex.opt;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class NetImagePreloader$onPreloadImage$checkContinue$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ int $limitSize;
    final /* synthetic */ Set $preloadList;

    public NetImagePreloader$onPreloadImage$checkContinue$1(Set r1, int r10) {
        this.$preloadList = r1;
        this.$limitSize = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1356invoke() {
        if (this.$preloadList.size() <= (this.$limitSize - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1356invoke());
    }
}
