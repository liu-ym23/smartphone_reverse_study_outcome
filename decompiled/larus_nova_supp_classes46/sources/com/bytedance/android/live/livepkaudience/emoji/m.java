package com.bytedance.android.live.livepkaudience.emoji;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements js0.b {
    public final /* synthetic */ LinkPKAudienceInteractDynamicEmojiDialog a;
    public final /* synthetic */ n b;

    @Override // js0.b
    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        if (((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService() == null) goto L15;
        n r5 = this.b;
        int r0 = InteractBeautyPreviewDialog.A;
        InteractBeautyPreviewDialog r6 = InteractBeautyPreviewDialog.a.a(r5, "", null);
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        if (r1 == null) goto L16;
        FragmentManager r2 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "InteractBeautyPreviewDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r6, r3) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r6.show(r2, "InteractBeautyPreviewDialog");
        return;
    L17:
        return;
    L16:
        return;
    }

    public m(LinkPKAudienceInteractDynamicEmojiDialog r1, n r2) {
        this.a = r1;
        this.b = r2;
    }
}
