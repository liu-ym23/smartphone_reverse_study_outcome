package com.larus.search.impl.global.view.aggregate.kmp;

import android.app.Activity;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.SearchAccountPayload;
import com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpSearchAccountActionHandlerServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchActionHandlerService;", "<init>", "()V", "onSearchItemClick", "", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpSearchAccountActionHandlerServiceImpl implements SearchActionHandlerService {

    public static final class a {
    }

    static {
    }

    public KmpSearchAccountActionHandlerServiceImpl() {
    }

    public final boolean V(FlowSearchData r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (Intrinsics.areEqual(r6.a, "search_account") == true) goto L5;
        return false;
    L5:
        SearchAccountPayload r7 = r6.c;
        ktb.a r2 = null;
        if ((r7 instanceof SearchAccountPayload) == false) goto L8;
        SearchAccountPayload r8 = r7;
    L9:
        if (r8 != null) goto L11;
        return false;
    L11:
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L14;
        return false;
    L14:
        Object r3 = xp9.o.a;
        if ((r3 instanceof OfficeSDKUserApi) == false) goto L17;
        OfficeSDKUserApi r4 = (OfficeSDKUserApi) r3;
    L18:
        if (r4 == null) goto L20;
        r2 = (ktb.a) r4.getService(ktb.a.class);
    L20:
        if (r2 != null) goto L23;
        FLogger.a.w("SearchAccountActionHandler", "onSearchItemClick: IContactOfficeApi unavailable");
        return false;
    L23:
        r2.U8(r0, new mtb.e(r8.i));
        return true;
    L17:
        r4 = null;
        goto L18
    L8:
        r8 = null;
        goto L9
    }
}
