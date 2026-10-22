package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u0 implements z3c.a {
    public z3c.a a;

    public static final class a {
    }

    static {
    }

    public u0() {
    }

    public final z3c.a b() {
        z3c.a r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        IUserManager r1 = OfficeSDKProvider.INSTANCE.getInstance().getUserManager();
        if (r1 == null) goto L14;
        OfficeSDKUserApi r2 = r1.getUserApi();
        if (r2 == null) goto L14;
        p3c.a r3 = r2.getService(p3c.a.class);
        if (r3 == null) goto L14;
        com.ss.android.lark.search.doubao.a r4 = r3.O2();
        if (r4 == null) goto L14;
        this.a = r4;
        return r4;
    L14:
        return null;
    }

    public static ErrorResult a(String r1, String r2) {
        tt5.a.d("OfficeDocCollaboratorSearch", r1 + " failed, IOfficeDocCollaboratorSearchAPI unavailable, requestId=" + r2);
        return new ErrorResult("IOfficeDocCollaboratorSearchAPI unavailable");
    }

    public final void onLoadMore(String r2, SearchContext r3) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        z3c.a r4 = b();
        if (r4 != null) goto L6;
        tt5.a.d("OfficeDocCollaboratorSearch", "onLoadMore ignored, IOfficeDocCollaboratorSearchAPI unavailable, requestId=" + r2);
        return;
    L6:
        r4.onLoadMore(r2, null);
    }

    public final void onLoadMore(String r2, SearchContext r3, IGetDataCallback<SearchResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        z3c.a r0 = b();
        if (r0 == null) goto L5;
        r0.onLoadMore(r2, r3, r4);
        return;
    L5:
        r4.onError(a("onLoadMore", r2));
    }

    public final void onSearch(String r2, SearchContext r3, IGetDataCallback<SearchResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        z3c.a r0 = b();
        if (r0 == null) goto L5;
        r0.onSearch(r2, r3, r4);
        return;
    L5:
        r4.onError(a("onSearch", r2));
    }
}
