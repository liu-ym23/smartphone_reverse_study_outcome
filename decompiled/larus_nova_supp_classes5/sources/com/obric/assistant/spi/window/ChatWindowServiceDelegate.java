package com.obric.assistant.spi.window;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/window/ChatWindowServiceDelegate;", "Lcom/obric/assistant/spi/window/IChatWindowService;", "<init>", "()V", "getChatFragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroid/app/Activity;", "isChatWindowShowing", "", "isChatWindowStashed", "isWindowContext", "context", "Landroid/content/Context;", "isWindowHelperActivity", "className", "", "popWindow", "", "registerWindowMaterials", "stashWindow", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowServiceDelegate implements IChatWindowService {
    public static final ChatWindowServiceDelegate b = null;
    public final /* synthetic */ IChatWindowService a;

    static {
        b = new ChatWindowServiceDelegate();
    }

    public final Fragment a(Activity r2) {
        return this.a.a(r2);
    }

    public final void b() {
        this.a.b();
    }

    public final boolean c(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return this.a.c(r2);
    }

    public final boolean d(Context r2) {
        return this.a.d(r2);
    }

    public final boolean e() {
        return this.a.e();
    }

    private ChatWindowServiceDelegate() {
        DefaultChatWindowServiceImpl r0 = (IChatWindowService) ServiceManager.get().getService(IChatWindowService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultChatWindowServiceImpl();
    L5:
        this.a = r0;
    }
}
