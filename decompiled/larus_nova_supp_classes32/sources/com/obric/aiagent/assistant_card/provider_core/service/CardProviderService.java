package com.obric.aiagent.assistant_card.provider_core.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/assistant_card/provider_core/service/CardProviderService;", "Landroid/app/Service;", "<init>", "()V", "lightContext", "Landroid/content/Context;", "getLightContext", "()Landroid/content/Context;", "lightContext$delegate", "Lkotlin/Lazy;", "nightContext", "getNightContext", "nightContext$delegate", "cardProvider", "com/obric/aiagent/assistant_card/provider_core/service/CardProviderService$cardProvider$2$1", "getCardProvider", "()Lcom/obric/aiagent/assistant_card/provider_core/service/CardProviderService$cardProvider$2$1;", "cardProvider$delegate", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "Companion", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardProviderService extends Service {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public CardProviderService() {
        this.a = LazyKt.lazy(new com.obric.aiagent.assistant_card.provider_core.service.a(this));
        this.b = LazyKt.lazy(new b(this));
        this.c = LazyKt.lazy(new c(this));
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        p9a.b.a("CardProviderService", "onCreate");
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r3) {
        e r0 = p9a.b.a;
        p9a.b.a("CardProviderService", "onBind: intent = " + r3);
        return (CardProviderService$cardProvider$2$1) this.c.getValue();
    }
}
