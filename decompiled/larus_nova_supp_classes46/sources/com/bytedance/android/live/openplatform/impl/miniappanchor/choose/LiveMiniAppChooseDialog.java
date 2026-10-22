package com.bytedance.android.live.openplatform.impl.miniappanchor.choose;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.MiniAppChooseContainerFragment;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/LiveMiniAppChooseDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/a;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMiniAppChooseDialog extends LiveDialogFragment implements com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a {
    public final Lazy d;
    public c e;

    public static final class a {
    }

    static {
    }

    public LiveMiniAppChooseDialog() {
        this.d = InfraKotlinExtsKt.mainThreadLazy(new LiveMiniAppChooseDialog$chooseFragment$2(this));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a
    public final void close() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a
    public final c dE() {
        return this.e;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954738);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.addFlags(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
    L5:
        Window r1 = r4.getWindow();
        if (r1 == null) goto L8;
        r1.setStatusBarColor(s1.h(2131106784));
    L8:
        Window r2 = r4.getWindow();
        if (r2 == null) goto L11;
        r2.setNavigationBarColor(s1.h(2131100641));
    L11:
        Window r5 = r4.getWindow();
        if (r5 == null) goto L14;
        r5.setDimAmount(0.0f);
    L14:
        return r4;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        if (getChildFragmentManager().findFragmentByTag("MiniAppChooseContainerFragment") != null) goto L10;
        MiniAppChooseContainerFragment r7 = (MiniAppChooseContainerFragment) this.d.getValue();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "MiniAppChooseContainerFragment", 2131365676) == true) goto L8;
        r6.add(2131365676, r7, "MiniAppChooseContainerFragment");
    L8:
        r6.commitAllowingStateLoss();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566861, r3, false);
    }
}
