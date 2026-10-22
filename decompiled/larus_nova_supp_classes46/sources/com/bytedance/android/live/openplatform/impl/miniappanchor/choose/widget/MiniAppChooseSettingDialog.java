package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.widget;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/widget/MiniAppChooseSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSettingDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> d;
    public so0.a e;
    public MemoryStatus f;
    public boolean g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Object[] r0 = new Object[1];
            if (this.a != 1) goto L5;
            String r4 = s1.B(2131920395);
        L6:
            r0[0] = r4;
            f2.c(s1.C(2131920397, r0), 0);
            return;
        L5:
            r4 = "";
            goto L6
        }
    }

    public static final class c implements LiveSwitchButton.e {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void d0(LiveSwitchButton r2, boolean r3) {
            if (r3 == false) goto L4;
            int r4 = 2131920390;
        L5:
            f2.b(r4, 0);
            ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).updateMemoryStatus(1, r3);
            return;
        L4:
            r4 = 2131920388;
            goto L5
        }
    }

    public static final class d implements LiveSwitchButton.e {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void d0(LiveSwitchButton r2, boolean r3) {
            if (r3 == false) goto L4;
            int r4 = 2131921073;
        L5:
            f2.b(r4, 0);
            ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).updateMemoryStatus(2, r3);
            if (r3 == false) goto L9;
            ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).reportDefaultOpenFirstExplainCardOn("", "panel_setting");
            return;
        L9:
            return;
        L4:
            r4 = 2131921072;
            goto L5
        }
    }

    public static final class e implements LiveSwitchButton.e {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void d0(LiveSwitchButton r2, boolean r3) {
            if (r3 == false) goto L4;
            int r4 = 2131921084;
        L5:
            f2.b(r4, 0);
            ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).updateMemoryStatus(3, r3);
            return;
        L4:
            r4 = 2131921083;
            goto L5
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ MiniAppChooseSettingDialog a;

        public f(MiniAppChooseSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public MiniAppChooseSettingDialog() {
        this.d = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r3) {
        Dialog r0 = getDialog();
        super.onActivityCreated(r3);
        if (r0 == null) goto L8;
        Window r4 = r0.getWindow();
        if (r4 == null) goto L9;
        r4.setGravity(80);
        r4.setLayout(-1, -2);
        r4.setBackgroundDrawable(new ColorDrawable(0));
        r4.getAttributes().windowAnimations = 2131954739;
        return;
    L9:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        LiveSwitchButton r8 = S90(2131379876);
        MemoryStatus r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryStatus");
    L5:
        int r1 = r0.a;
        boolean r2 = false;
        if (r1 != 1) goto L8;
    L11:
        boolean r3 = true;
    L12:
        r8.setChecked(r3);
        if (this.g == false) goto L15;
        ((TextView) S90(2131388178)).setVisibility(0);
    L15:
        S90(2131379876).setOnCheckedChangeListener(c.a);
        LiveSwitchButton r9 = S90(2131381510);
        MemoryStatus r4 = this.f;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("memoryStatus");
    L18:
        r9.setChecked(r4.b());
        so0.a r10 = this.e;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L21:
        int r11 = r10.getCoexistComponent();
        if (r11 == 0) goto L24;
        RelativeLayout r5 = (RelativeLayout) S90(2131381511);
        r5.setAlpha(0.4f);
        r5.setOnClickListener(new b(r11));
        S90(2131381510).setEnabled(false);
    L24:
        S90(2131381510).setOnCheckedChangeListener(d.a);
        if (((uc1) ee0.a.getValue()).u() != 1) goto L33;
        S90(2131369199).setVisibility(0);
        ((RelativeLayout) S90(2131386393)).setVisibility(0);
        LiveSwitchButton r12 = S90(2131386392);
        MemoryStatus r13 = this.f;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("memoryStatus");
    L30:
        if (r13.c != 1) goto L32;
        r2 = true;
    L32:
        r12.setChecked(r2);
        S90(2131386392).setOnCheckedChangeListener(e.a);
    L34:
        ((ImageButton) S90(2131366984)).setOnClickListener(new f(this));
        return;
    L33:
        S90(2131369199).setVisibility(8);
        ((RelativeLayout) S90(2131386393)).setVisibility(8);
        goto L34
    L8:
        if (r1 == 2) goto L11;
        r3 = false;
        goto L12
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (isAdded() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.f.d().a();
        JavaCalls.setField(this, "mDismissed", Boolean.FALSE);
        JavaCalls.setField(this, "mShownByMe", Boolean.TRUE);
        FragmentTransaction r5 = r3.beginTransaction();
        if (r5 != null) goto L9;
        return;
    L9:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L12;
        r5.add(this, r4);
    L12:
        r5.commitAllowingStateLoss();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566947, r3, false);
    }
}
