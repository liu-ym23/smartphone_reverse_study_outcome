package com.obric.memorydata.personalcontext.search.bridge;

import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/SearchParamWrapper;", "", "inAppSearchEntityParam", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "isWideRecall", "", "<init>", "(Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;Z)V", "getInAppSearchEntityParam", "()Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "setInAppSearchEntityParam", "(Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;)V", "()Z", "setWideRecall", "(Z)V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InAppSearchEntityParam f12298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12299b;

    public h(InAppSearchEntityParam r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "inAppSearchEntityParam");
        this.f12298a = r2;
        this.f12299b = r3;
    }

    public /* synthetic */ h(InAppSearchEntityParam r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public final InAppSearchEntityParam a() {
        return this.f12298a;
    }

    public final void a(boolean r1) {
        this.f12299b = r1;
    }

    public final boolean b() {
        return this.f12299b;
    }
}
