package com.obric.memorydata.personalcontext.search.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\b\u0002\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR'\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "", "remoteResultId", "", "searchParamsList", "", "", "", "Lcom/obric/memorydata/personalcontext/search/bridge/SearchParamWrapper;", "<init>", "(JLjava/util/Map;)V", "getRemoteResultId", "()J", "getSearchParamsList", "()Ljava/util/Map;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<h>> f12293b;

    public c(long r3, Map<String, ? extends List<h>> r5) {
        Map<String, List<h>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f12292a = r3;
        this.f12293b = r6;
    }

    public /* synthetic */ c(long r2, Map r4, int r5, DefaultConstructorMarker r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r7);
    }

    public final long a() {
        return this.f12292a;
    }

    public final Map<String, List<h>> b() {
        return this.f12293b;
    }
}
