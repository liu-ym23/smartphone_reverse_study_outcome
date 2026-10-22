package com.larus.bmhome.view.actionbar.custom.router;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements b {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUrl");
        PinBotShortcutLinkProcessor.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "uriString");
        return StringsKt.contains$default(r5, "//flow/pin_shortcut", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r8, String r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "schemaUrl");
        Intrinsics.checkNotNullParameter(r10, "commonArgs");
        if (r8 == null) goto L9;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r8);
        if (r1 == null) goto L10;
        BuildersKt.launch$default(r1, null, null, new PinBotShortcutRouterProcessor$handleRoute$1(r9, r8, null), 3, null);
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
