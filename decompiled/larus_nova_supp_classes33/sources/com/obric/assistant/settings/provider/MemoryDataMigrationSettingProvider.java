package com.obric.assistant.settings.provider;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.larus.account.base.api.ILoginService;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/settings/provider/MemoryDataMigrationSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnterpriseAccount", "", "openMemoryDataMigrationPage", "", "context", "Landroid/content/Context;", "showJumpFailedToast", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemoryDataMigrationSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public MemoryDataMigrationSettingProvider() {
    }

    public static void c(Context r1) {
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L6:
        if (r2 != null) goto L8;
        gd9.i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        r2 = r3.a().e();
    L8:
        if (r2 == null) goto L11;
        Handler r0 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r2, r2.getString(2131911975));
        return;
    L11:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (r2.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_preference"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r18, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r19) {
        final Context r0 = r18.getHostContext();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        ILoginService r1 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r1 == null) goto L17;
        q38.a r2 = r1.getAccountInfo();
        if (r2 == null) goto L17;
        final boolean r3 = true;
        if (r2.g != true) goto L17;
    L18:
        String r6 = r0.getString(2131912489);
        String r15 = r0.getString(2131912500);
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_preference", "memory_data_migration", r6, 70, new b1(this, r0), new c1(r0), null, new MemoryDataMigrationSettingProvider$getSettingItems$4(null), null, false, new d1(r3), r15, 1856));
    L17:
        r3 = false;
        goto L18
    L9:
        return CollectionsKt.emptyList();
    }
}
