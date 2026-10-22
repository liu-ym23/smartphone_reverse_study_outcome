package com.bytedance.android.live.lynx.open;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/lynx/open/OpenAvatar;", "Lcom/lynx/tasm/ui/image/UIImage;", "Lcom/lynx/tasm/ui/image/FrescoImageView;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAvatar extends UIImage<FrescoImageView> {
    public OpenAvatar(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setSource(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        IInteractGameService r0 = k.f(IInteractGameService.class);
        if (r0 == null) goto L7;
        String r3 = r0.decryptUserInfo(r2);
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        r3 = "res:///2131233768";
    L16:
        super.setSource(r3);
        return;
    L10:
        if (r3.length() == 0) goto L13;
        r1 = false;
        goto L14
    L7:
        r3 = null;
        goto L8
    }
}
