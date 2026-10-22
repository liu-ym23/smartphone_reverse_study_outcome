package com.ss.android.lark.inline.ai.ui.imageviewer;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(ylb.b.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerImpl;", "Lcom/ss/android/lark/inline/ai/imageviewer/IImageViewer;", "<init>", "()V", "show", "", "ITEM_TYPE", "fm", "Landroidx/fragment/app/FragmentManager;", "config", "Lcom/ss/android/lark/inline/ai/imageviewer/ImageViewConfig;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageViewerImpl implements ylb.b {
    public ImageViewerImpl() {
    }

    @Override // ylb.b
    public <ITEM_TYPE> void show(FragmentManager r3, ylb.c<ITEM_TYPE> r4) {
        Intrinsics.checkNotNullParameter(r3, "fm");
        Intrinsics.checkNotNullParameter(r4, "config");
        ImageViewerFragment r0 = new ImageViewerFragment(r4);
        INVOKEVIRTUAL_com_ss_android_lark_inline_ai_ui_imageviewer_ImageViewerImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, r3, "ImageViewerFragment" + r0.hashCode());
    }

    public static void INVOKEVIRTUAL_com_ss_android_lark_inline_ai_ui_imageviewer_ImageViewerImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ImageViewerFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ImageViewerFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
