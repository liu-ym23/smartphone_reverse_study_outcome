package com.obric.assistant.settings.provider;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.cocreationreview.IObricCocreationReviewService;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/settings/provider/CocreationReviewSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCocreationReviewEntryEnabled", "", "startCocreationReview", "", "context", "Landroid/content/Context;", "showJumpFailedToast", "activity", "Landroid/app/Activity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationReviewSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public CocreationReviewSettingProvider() {
    }

    public static void c(Activity r1) {
        if (r1 != null) goto L4;
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        r1 = r2.a().e();
    L4:
        if (r1 == null) goto L7;
        Handler r0 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r1, r1.getString(2131911975));
        return;
    }

    public static void d(Context r4) {
        Activity r1 = null;
        if ((r4 instanceof Activity) == false) goto L5;
        Activity r0 = (Activity) r4;
    L6:
        if (r0 == null) goto L8;
    L7:
        r4 = r0;
    L11:
        IObricCocreationReviewService.a.getClass();
        IObricCocreationReviewService r2 = (IObricCocreationReviewService) ServiceManager.get().getService(IObricCocreationReviewService.class, false, false);
        if (r2 != null) goto L18;
        FLogger.a.e("CocreationReviewSettingProvider", "Cocreation review service is unavailable");
        if ((r4 instanceof Activity) == false) goto L16;
        r1 = (Activity) r4;
    L16:
        c(r1);
        return;
    L18:
        r2.a(r4);
        return;
    L8:
        gd9.i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        r0 = r3.a().e();
        if (r0 == null) goto L11;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (r2.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        com.obric.assistant.settings.h.a.getClass();
        if (com.obric.assistant.settings.h.a().a == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_cocreation_review"));
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r18, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r19) {
        final Context r1 = r18.getHostContext();
        if (r1 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_cocreation_review", "cocreation_review", r1.getString(2131912471), 100, new n(this), new o(r1), null, new CocreationReviewSettingProvider$getSettingItems$4(this, null), null, true, null, null, 6976));
    }
}
