package com.obric.capabilitykit.search;

import android.os.Handler;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zia.f;
import zia.g;
import zia.h;
import zia.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$startAppSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IInAppSearchCallback$Stub;", "onCompleted", "", "onError", "errorCode", "", "errorMsg", "", "onSearchResult", WindowEvent.Params.RESULT, "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchClient$d$a extends IInAppSearchCallback.Stub {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ IAppSearchCallback c;

    public InAppSearchClient$d$a(String r1, long r2, IAppSearchCallback r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    private static final void a(String r1, long r2, IAppSearchCallback r4) {
        Intrinsics.checkNotNullParameter(r1, "$businessName");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
        r4.onCompleted();
        InAppSearchClient.access$getBusinessMap$p().remove(r1);
        return;
    }

    private static final void a(String r1, long r2, IAppSearchCallback r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r1, "$businessName");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        Intrinsics.checkNotNullParameter(r6, "$errorMsg");
        if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
        r4.onError(r5, r6);
        InAppSearchClient.access$getBusinessMap$p().remove(r1);
        return;
    }

    private static final void a(String r1, long r2, IAppSearchCallback r4, InAppSearchResult r5) {
        Intrinsics.checkNotNullParameter(r1, "$businessName");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        Intrinsics.checkNotNullParameter(r5, "$result");
        if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
        r4.onSearchResult(r5);
        return;
    }

    private static final void a(String r1, long r2, IAppSearchCallback r4, InAppSearchResultWithoutEntity r5) {
        Intrinsics.checkNotNullParameter(r1, "$businessName");
        Intrinsics.checkNotNullParameter(r4, "$callback");
        Intrinsics.checkNotNullParameter(r5, "$result");
        if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
        r4.onSearchResultWithoutEntity(r5);
        return;
    }

    public static /* synthetic */ void b(String r0, long r1, IAppSearchCallback r3, int r4, String r5) {
        a(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ void c(String r0, long r1, IAppSearchCallback r3) {
        a(r0, r1, r3);
    }

    public static /* synthetic */ void d(String r0, long r1, IAppSearchCallback r3, InAppSearchResultWithoutEntity r4) {
        a(r0, r1, r3, r4);
    }

    public static /* synthetic */ void e(String r0, long r1, IAppSearchCallback r3, InAppSearchResult r4) {
        a(r0, r1, r3, r4);
    }

    public void onCompleted() {
        Logger.INSTANCE.d("InAppSearchClient", "onCompleted");
        Handler r0 = InAppSearchClient.access$getMainHandler$p();
        final String r1 = this.a;
        final long r2 = this.b;
        final IAppSearchCallback r4 = this.c;
        r0.post(new i(r1, r2, r4));
    }

    public void onError(final int r10, final String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        Logger.INSTANCE.w("InAppSearchClient", "onError: " + r10 + ' ' + r11);
        Handler r0 = InAppSearchClient.access$getMainHandler$p();
        final String r2 = this.a;
        final long r3 = this.b;
        final IAppSearchCallback r5 = this.c;
        r0.post(new h(r2, r3, r5, r10, r11));
    }

    public void onSearchResult(final InAppSearchResult r9) {
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.RESULT);
        Logger.INSTANCE.d("InAppSearchClient", "onSearchResult: " + r9);
        Handler r0 = InAppSearchClient.access$getMainHandler$p();
        final String r2 = this.a;
        final long r3 = this.b;
        final IAppSearchCallback r5 = this.c;
        r0.post(new f(r2, r3, r5, r9));
    }

    public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r9) {
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.RESULT);
        Logger.INSTANCE.d("InAppSearchClient", "onSearchResultWithoutEntity");
        Handler r0 = InAppSearchClient.access$getMainHandler$p();
        final String r2 = this.a;
        final long r3 = this.b;
        final IAppSearchCallback r5 = this.c;
        r0.post(new g(r2, r3, r5, r9));
    }
}
