package com.larus.uaigc.avatar.template;

import ab8.a;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.crash.d;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import gy9.b;
import gy9.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/uaigc/avatar/template/DigitalAvatarTemplateListDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "avatarTemplateChoose", "Lkotlin/Function1;", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "botId", "", "chatType", "recommendFrom", "cvsId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setDigitalAvatarFragmentV2", "view", "setup", "digitalAvatarTemplateModel", "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DigitalAvatarTemplateListDialogFragment extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public Function1<? super a, Unit> d;
    public String e;
    public String f;
    public String g;

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -1);
    L7:
        Dialog r2 = getDialog();
        if (r2 == null) goto L13;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L14;
        r3.setWindowAnimations(2131954386);
        return;
    L14:
        return;
    }

    public DigitalAvatarTemplateListDialogFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131953344);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = new Dialog(requireContext(), 2131953344);
        r4.requestWindowFeature(1);
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        return r4;
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        if (r15 != null) goto L34;
    L10:
        View r16 = r13.inflate(2131563160, r14, false);
        Intrinsics.checkNotNull(r16);
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L13;
        r17.w();
        final Fragment r18 = k1.a.m(new c(this), null);
    L14:
        if (r18 == null) goto L33;
        Pair[] r1 = new Pair[14];
        r1[0] = TuplesKt.to("argBotId", this.e);
        r1[1] = TuplesKt.to("key_current_page_name", "image_generate");
        Boolean r2 = Boolean.FALSE;
        r1[2] = TuplesKt.to("key_is_multi_tab", r2);
        r1[3] = TuplesKt.to("argPreviousPage", "chat");
        r1[4] = TuplesKt.to("key_creation_recommend_type", 3);
        r1[5] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r1[6] = TuplesKt.to("key_show_user_info", Boolean.valueOf(z2.a.H()));
        r1[7] = TuplesKt.to("recommend_from", "action_bar_template");
        r1[8] = TuplesKt.to("arg_chat_type", this.f);
        r1[9] = TuplesKt.to("action_bar_template_id", 11);
        r1[10] = TuplesKt.to("enter_from", "template_list");
        String r5 = this.g;
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        r1[11] = TuplesKt.to("argConversationId", r5);
        r1[12] = TuplesKt.to("key_template_list_top_padding", 0);
        if (getActivity() == null) goto L25;
        IAIChatUgcAIGCService r3 = (IAIChatUgcAIGCService) ServiceManager.get().getService(IAIChatUgcAIGCService.class);
        if (r3 == null) goto L24;
        FragmentActivity r4 = getActivity();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        r2 = Boolean.valueOf(r3.s0(r4));
        goto L25
    L24:
        r2 = null;
    L25:
        r1[13] = TuplesKt.to("key_is_chat_double_page", r2);
        r18.setArguments(BundleKt.bundleOf(r1));
        NovaTitleBarEx r6 = new NovaTitleBarEx(requireContext());
        r6.setBackgroundResource(v19.c.b(2130970529, getContext(), 2131102529));
        NovaTitleBarEx.Y5(r6, getResources().getString(2131906382), null, new gy9.a(r18), 2);
        NovaTitleBarEx.b6(r6, v19.c.b(2130971749, getContext(), 2131241477), false, null, null, new b(this), 14);
        LinearLayout r7 = (LinearLayout) r16.findViewById(2131378837);
        if (r7 == null) goto L28;
        r7.addView(r6, 0, new LinearLayout.LayoutParams(-1, -2));
    L28:
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L32;
        r0 = r0.replace(2131373275, r18);
    L32:
        r0.commit();
    L33:
        return r16;
    L13:
        r18 = null;
        goto L14
    L34:
        dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L10;
        d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
