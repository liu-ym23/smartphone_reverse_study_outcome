package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.IHomeApi;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/settings/provider/DesktopIconSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "currentAppIconId", "", "Ljava/lang/Integer;", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DesktopIconSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int b = 0;
    public final Integer a;

    public static final class a {
    }

    static {
    }

    public DesktopIconSettingProvider() {
        IHomeApi r0 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r0 == null) goto L5;
        Integer r1 = r0.H(AppHost.a.getApplication());
    L6:
        this.a = r1;
        return;
    L5:
        r1 = null;
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
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_desktop_icon"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(final com.obric.assistant.settings.spi.b r18, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r19) {
        Context r0 = r18.getHostContext();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        ArrayList r1 = new ArrayList();
        r1.add(new com.obric.assistant.settings.spi.f("group_desktop_icon", "add_desktop_icon", r0.getString(2131912609), 100, new u0(), new v0(this, r18), null, new DesktopIconSettingProvider$getSettingItems$4(null), false, null, null, null, 16192));
        return r1;
    L9:
        return CollectionsKt.emptyList();
    }
}
