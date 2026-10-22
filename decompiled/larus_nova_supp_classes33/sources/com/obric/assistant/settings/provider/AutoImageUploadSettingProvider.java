package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.larus.account.base.api.ILoginService;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/settings/provider/AutoImageUploadSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnterpriseAccount", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoImageUploadSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AutoImageUploadSettingProvider() {
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
    public final Object b(final com.obric.assistant.settings.spi.b r19, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r20) {
        Context r0 = r19.getHostContext();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        ArrayList r1 = new ArrayList();
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r2 == null) goto L17;
        q38.a r3 = r2.getAccountInfo();
        if (r3 == null) goto L17;
        final boolean r4 = true;
        if (r3.g != true) goto L17;
    L18:
        String r7 = r0.getString(2131912521);
        String r11 = r0.getString(2131912520);
        String r16 = r0.getString(2131912500);
        r1.add(new com.obric.assistant.settings.spi.f("group_preference", "auto_image_upload", r7, 95, new i(), new j(r19), r11, new AutoImageUploadSettingProvider$getSettingItems$4(null), false, null, new k(r4), r16, 3840));
        return r1;
    L17:
        r4 = false;
        goto L18
    L9:
        return CollectionsKt.emptyList();
    }
}
