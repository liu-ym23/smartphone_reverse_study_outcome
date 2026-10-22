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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/provider/AutoGuiSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoGuiSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AutoGuiSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (r2.getHostContext() == null) goto L5;
        int r3 = com.obric.assistant.settings.autogui.d.a;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L14;
        return CollectionsKt.emptyList();
    L14:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_auto_gui_settings"));
    L9:
        r4 = false;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r19, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r20) {
        Context r0 = r19.getHostContext();
        if (r0 == null) goto L5;
        int r1 = com.obric.assistant.settings.autogui.d.a;
        if (Build.VERSION.SDK_INT < 23) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        ArrayList r3 = new ArrayList();
        final boolean r4 = com.obric.assistant.settings.autogui.d.b();
        String r7 = r0.getString(2131912430);
        String r16 = r0.getString(2131912500);
        r3.add(new com.obric.assistant.settings.spi.a("group_auto_gui_settings", "auto_gui", r7, 100, new g(), null, null, new AutoGuiSettingProvider$getSettingItems$3(null), null, true, new h(r4), r16, 864));
        return r3;
    L12:
        return CollectionsKt.emptyList();
    L9:
        r2 = false;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }
}
