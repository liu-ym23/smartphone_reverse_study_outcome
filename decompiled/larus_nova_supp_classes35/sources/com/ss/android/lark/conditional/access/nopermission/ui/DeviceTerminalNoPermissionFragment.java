package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceTerminalNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceTerminalNoPermissionFragment extends Hilt_DeviceTerminalNoPermissionFragment {

    public static final class a {
    }

    static {
    }

    public DeviceTerminalNoPermissionFragment() {
        super(NoPermissionType.DEVICE_TERMINAL);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ScsLogger.d("SecurityPolicy_DeviceTerminalNoPermissionFragment", "onViewCreated");
        S90().h.setText(requireContext().getText(2131890508));
        S90().i.setText(requireContext().getText(2131890514));
        S90().g.setText(requireContext().getText(2131890513));
        UDButton r5 = S90().d;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L7;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        r7.topMargin = UIUtils.dp2px(requireContext(), 24.0f);
        r5.setLayoutParams(r7);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
