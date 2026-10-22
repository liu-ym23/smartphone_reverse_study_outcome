package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.obric.assistant.interaction.api.window.IWindowContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/AssistantWindowContext;", "Landroid/view/ContextThemeWrapper;", "Lcom/obric/assistant/interaction/api/window/IWindowContext;", "base", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "updateWindowWidthPixels", "", "width", "updateWindowWidthPixels$impl_mainlandRelease", "(Ljava/lang/Integer;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantWindowContext extends ContextThemeWrapper implements IWindowContext {
    public final void updateWindowWidthPixels$impl_mainlandRelease(Integer r4) {
        Resources r0 = getResources();
        if (r4 != null) goto L5;
    L10:
        r4 = null;
    L11:
        WindowDisplayMetricsOverride.update(r0, r4);
        return;
    L5:
        if (r4.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L7:
        r2 = false;
        goto L8
    }

    public AssistantWindowContext(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2, r3);
    }
}
