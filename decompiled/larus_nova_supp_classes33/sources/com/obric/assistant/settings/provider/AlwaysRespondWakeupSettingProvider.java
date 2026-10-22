package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/settings/provider/AlwaysRespondWakeupSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "shouldHideMigratedSwitch", "", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlwaysRespondWakeupSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AlwaysRespondWakeupSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (ega.a.a() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r2.getHostContext() != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        return CollectionsKt.emptyList();
    L15:
        if (ega.a.a() == true) goto L19;
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(final com.obric.assistant.settings.spi.b r19, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r20) {
        if (ega.a.a() == false) goto L5;
        final Context r0 = r19.getHostContext();
        if (r0 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        return CollectionsKt.emptyList();
    L15:
        if (ega.a.a() == false) goto L17;
        final boolean r1 = com.obric.assistant.t1.a.b();
        if (r1 == false) goto L21;
        ArrayList r2 = new ArrayList();
        String r7 = r0.getString(2131912416);
        String r11 = r0.getString(2131912418);
        if (r1 == true) goto L25;
        int r3 = 2131912591;
    L26:
        String r16 = r0.getString(r3);
        r2.add(new com.obric.assistant.settings.spi.f("group_voice", "always_respond_wakeup", r7, 97, new b(), new c(r19), r11, new AlwaysRespondWakeupSettingProvider$getSettingItems$4(null), false, null, new d(r1, r0), r16, 3840));
        return r2;
    L25:
        r3 = 2131912417;
        goto L26
    L21:
        return CollectionsKt.emptyList();
    L17:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }
}
