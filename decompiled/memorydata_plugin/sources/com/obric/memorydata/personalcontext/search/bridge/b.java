package com.obric.memorydata.personalcontext.search.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchConstants;", "", "<init>", "()V", "EMPTY_RESULT_ID", "", "EMPTY_RESULT", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "EMPTY_RESULT_WITH_PARAMS", "getEmptyResultBySearchOption", "searchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f12291b = null;
    private static final c c = null;

    static {
        f12290a = new b();
        f12291b = new c(0, null, 2, null);
        c = new c(0, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public final c a(e r1) {
        Intrinsics.checkNotNullParameter(r1, "searchOption");
        if (r1.b() == false) goto L7;
        return c;
    L7:
        return f12291b;
    }
}
