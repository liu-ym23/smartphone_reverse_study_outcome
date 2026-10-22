package com.bytedance.android.live.liveinteract.videotalk.emoji;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements js0.b {
    public final /* synthetic */ VideoTalkDynamicEmojiDialog a;
    public final /* synthetic */ b0 b;
    public final /* synthetic */ String c;

    @Override // js0.b
    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        int r5 = InteractBeautyPreviewDialog.A;
        InteractBeautyPreviewDialog r6 = InteractBeautyPreviewDialog.a.a(this.b, this.c, null);
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        if (r0 == null) goto L13;
        FragmentManager r1 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "InteractBeautyPreviewDialog", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r6, r2) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r6.show(r1, "InteractBeautyPreviewDialog");
        return;
    L14:
        return;
    }

    public a0(VideoTalkDynamicEmojiDialog r1, b0 r2) {
        this.a = r1;
        this.b = r2;
        this.c = "link_interaction_panel_beauty";
    }
}
