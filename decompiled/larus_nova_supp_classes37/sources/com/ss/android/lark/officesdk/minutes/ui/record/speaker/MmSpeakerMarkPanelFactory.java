package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import rub.c;
import rub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSpeakerMarkPanelFactory {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final b r24) {
        Intrinsics.checkNotNullParameter(r24, "params");
        final FragmentManager r1 = r24.b;
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.SPEAKER;
        bwb.b.g(r3, "show", "show: source=" + r24.a.getClass().getSimpleName() + ", fm=" + r1.hashCode() + ", mode=" + r24.j, null, 8);
        DialogFragment r4 = r1.findFragmentByTag("MmSpeakerMarkPanel");
        if ((r4 instanceof DialogFragment) == false) goto L9;
        Dialog r5 = r4.getDialog();
        if (r5 != null) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L15;
        bwb.b.g(r3, "show", "show skip: panel showing", null, 8);
        return;
    L15:
        final MmSpeakerMarkViewModel r7 = new MmSpeakerMarkViewModel(r24.d, r24.e, r24.f, r24.g, r24.h, r24.i);
        r24.c.w(r1, new d("MmSpeakerMarkPanel", new MmSpeakerMarkPanelFactory$show$config$1(r7, r24, r1), new MmPanelHeightConfig.ScreenTopMargin(UIUtils.dp2px(r24.a.requireContext(), 114.0f), true), r24.j, new c.a(MmSpeakerMarkPanelFactory$show$config$2.INSTANCE), false, 7290));
        return;
    L7:
        if (r5.isShowing() != true) goto L11;
        r6 = true;
        goto L12
    L9:
        if (r4 == null) goto L11;
        r6 = r4.isAdded();
        goto L12
    }
}
