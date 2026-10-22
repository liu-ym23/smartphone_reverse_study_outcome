package com.obric.assistant.chat;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0097\u0001J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0097\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0097\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatContextServiceDelegate;", "Lcom/obric/assistant/chat/IObricChatContextService;", "<init>", "()V", "findChatHost", "Landroidx/fragment/app/FragmentActivity;", "getChatContext", "Lcom/larus/ui/arch/context/external/VContext;", "activity", "Landroid/app/Activity;", "getCurrentChatContext", "isChatActivity", NameKeys.UnloadStrategy_No_Strategy, "isChatHost", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatContextServiceDelegate implements IObricChatContextService {
    public static final ObricChatContextServiceDelegate b = null;
    public final /* synthetic */ IObricChatContextService a;

    static {
        b = new ObricChatContextServiceDelegate();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b b(Activity r2) {
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean c(Activity r2) {
        return this.a.c(r2);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final FragmentActivity d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean e(Activity r2) {
        return this.a.e(r2);
    }

    private ObricChatContextServiceDelegate() {
        this.a = (IObricChatContextService) ServiceManager.get().getService(IObricChatContextService.class);
    }
}
