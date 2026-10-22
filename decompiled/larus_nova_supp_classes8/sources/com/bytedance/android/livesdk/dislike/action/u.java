package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends OptionAction {
    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.k.c;
    }

    public u(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        FragmentActivity r3 = ContextUtil.contextToFragmentActivity(r2.getContext());
        if (r3 == null) goto L6;
        jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal().g(r3);
        return;
    }
}
