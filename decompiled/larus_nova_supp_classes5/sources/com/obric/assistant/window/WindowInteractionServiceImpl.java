package com.obric.assistant.window;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IChatWindowActivity;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.window.IChatWindowService;
import com.obric.assistant.window.helpers.TransparentHelperActivity;
import com.obric.assistant.window.materials.tokens.DoubaoMaterialToken;
import com.obric.assistant.window.materials.tokens.DoubaoMaterialTokenV2;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/window/WindowInteractionServiceImpl;", "Lcom/obric/assistant/spi/window/IChatWindowService;", "<init>", "()V", "isWindowContext", "", "context", "Landroid/content/Context;", "stashWindow", "", "popWindow", "isChatWindowShowing", "isChatWindowStashed", "isWindowHelperActivity", "activity", "Landroid/app/Activity;", "className", "", "getChatFragment", "Landroidx/fragment/app/Fragment;", "registerWindowMaterials", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowInteractionServiceImpl implements IChatWindowService {

    public static final class a {
    }

    static {
    }

    public WindowInteractionServiceImpl() {
    }

    public final void b() {
        if (OMaterialHelper.f() < 4) goto L5;
        DoubaoMaterialTokenV2 r0 = DoubaoMaterialTokenV2.INSTANCE;
        MaterialToken.register(r0, true);
        MaterialToken.registerSet(r0, true);
        return;
    L5:
        DoubaoMaterialToken r1 = DoubaoMaterialToken.INSTANCE;
        MaterialToken.register(r1, true);
        MaterialToken.registerSet(r1, true);
    }

    public final boolean e() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isShowing());
    L6:
        FLogger.a.i("WindowInteractionServiceImpl", "isChatWindowShowing, isShowing=" + r1);
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    public final Fragment a(Activity r3) {
        if ((r3 instanceof IChatWindowActivity) == false) goto L5;
        IChatWindowActivity r4 = (IChatWindowActivity) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getChatFragment();
    L5:
        r4 = null;
        goto L6
    }

    public final boolean c(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return r2 instanceof TransparentHelperActivity;
    }

    public final boolean d(Context r5) {
        FLogger r0 = FLogger.a;
        r0.i("WindowInteractionServiceImpl", "isWindowContext, context = " + r5);
        if (r5 != null) goto L6;
        return false;
    L6:
        boolean r6 = IWindowContextKt.isWindowContext(r5);
        r0.i("WindowInteractionServiceImpl", "isWindowContext, isWindowContext=" + r6);
        return r6;
    }
}
