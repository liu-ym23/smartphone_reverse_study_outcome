package com.obric.assistant.spi.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.obric.ObricChatActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jga.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/chat/ObricInteractionServiceDelegate;", "Lcom/obric/assistant/spi/chat/IObricInteractionService;", "<init>", "()V", "adaptSlideBarFragmentArguments", "Landroid/os/Bundle;", "page", "", "arguments", "getOChatContainer", "", "getOrionChatExtensionUtilsCallback", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "activity", "Landroidx/fragment/app/FragmentActivity;", "prepareSideBarMainChatForActivation", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionServiceDelegate implements IObricInteractionService {
    public static final ObricInteractionServiceDelegate b = null;
    public final /* synthetic */ IObricInteractionService a;

    static {
        b = new ObricInteractionServiceDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final String a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final void b(FragmentActivity r2) {
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final Bundle c(int r2, Bundle r3) {
        return this.a.c(r2, r3);
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final a d(ObricChatActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return this.a.d(r2);
    }

    private ObricInteractionServiceDelegate() {
        IObricInteractionService r0 = (IObricInteractionService) ServiceManager.get().getService(IObricInteractionService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricInteractionServiceImpl();
    L5:
        this.a = r0;
    }
}
