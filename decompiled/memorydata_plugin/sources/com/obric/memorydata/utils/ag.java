package com.obric.memorydata.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/utils/OnClickCallback;", "", "onBefore", "", "keyword", "", "data", "onAfter", "", "success", "onError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ag {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static void a(ag r2, String r3, String r4, Exception r5) {
            ag r6 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "keyword");
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r5, "error");
        }
    }

    void a(String r1, String r2, Exception r3);

    void a(String r1, String r2, boolean r3);

    boolean a(String r1, String r2);
}
