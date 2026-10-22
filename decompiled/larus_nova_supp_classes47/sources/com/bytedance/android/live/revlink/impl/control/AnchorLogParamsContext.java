package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/AnchorLogParamsContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/control/d;", "", "requestId", "", "setRequestId", "getRequestId", "reset", "mRequestId", "Ljava/lang/String;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "getMultiLinkUtil", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "multiLinkUtil", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLogParamsContext extends DataContext implements d {
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private String mRequestId;

    public static final class a implements Action {
        public final /* synthetic */ AnchorLogParamsContext a;

        public a(AnchorLogParamsContext r1) {
            this.a = r1;
        }

        public final void run() {
            AnchorLogParamsContext.access$getCd$p(this.a).dispose();
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.control.d
    public void reset() {
        this.mRequestId = null;
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.utils.w getMultiLinkUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.d
    public String getRequestId() {
        return this.mRequestId;
    }

    public AnchorLogParamsContext(com.bytedance.android.live.revlink.impl.global.c r3) {
        this.linkFakeGlobalService = r3;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r4);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(AnchorLogParamsContext r0) {
        return r0.cd;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.d
    public void setRequestId(String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestId");
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = getMultiLinkUtil();
        if (r0 == null) goto L13;
        boolean r1 = true;
        if (r0.c() != true) goto L13;
        if (r4.length() == 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L13;
        jy0.b.f("AnchorLogParamsContext", "request id is empty when linking", null, 4);
        return;
    L13:
        this.mRequestId = r4;
        mz0.e<?> r2 = mz0.d.b(LogCommon.ROOM);
        if (r2 == null) goto L17;
        ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r2).i("request_id", r4);
        return;
    }
}
