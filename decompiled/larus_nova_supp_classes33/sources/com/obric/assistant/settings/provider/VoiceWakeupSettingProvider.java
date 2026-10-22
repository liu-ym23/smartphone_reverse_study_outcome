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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/settings/provider/VoiceWakeupSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "shouldHideMigratedSwitch", "", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVoiceWakeupChange", "", "context", "Landroid/content/Context;", "isChecked", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceWakeupSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public VoiceWakeupSettingProvider() {
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
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(final com.obric.assistant.settings.spi.b r18, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r19) {
        final Context r0 = r18.getHostContext();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (ega.a.a() == false) goto L13;
        ArrayList r1 = new ArrayList();
        String r6 = r0.getString(2131912592);
        String r10 = r0.getString(2131912593);
        r1.add(new com.obric.assistant.settings.spi.f("group_voice", "voice_wakeup", r6, 100, new x1(), new y1(this, r0, r18), r10, new VoiceWakeupSettingProvider$getSettingItems$4(null), false, null, null, null, 16128));
        return r1;
    L13:
        return CollectionsKt.emptyList();
    }
}
