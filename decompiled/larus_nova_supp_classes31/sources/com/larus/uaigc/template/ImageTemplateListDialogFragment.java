package com.larus.uaigc.template;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0085\u0001\u0010\u0013\u001a\u00020\u000e2Q\u0010\u0004\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001bH\u0002RY\u0010\u0004\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/uaigc/template/ImageTemplateListDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "botId", "chatType", "recommendFrom", "cvsId", "setUp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setImageTemplateListFragmentV2", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageTemplateListDialogFragment extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public Function3<? super TemplateInfo$TemplateInfo, ? super String, ? super Uri, Unit> d;
    public String e;
    public String f;
    public String g;
    public String h;

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

    public ImageTemplateListDialogFragment() {
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

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        if (r20 != null) goto L48;
    L10:
        View r0 = r18.inflate(2131563160, r19, false);
        Intrinsics.checkNotNull(r0);
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L13;
        r2.w();
        final Fragment r3 = k1.a.m(new s(this), null);
    L14:
        if (r3 == null) goto L47;
        Pair[] r5 = new Pair[15];
        String r6 = this.e;
        String r7 = "";
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r5[0] = TuplesKt.to("argBotId", r6);
        boolean r8 = true;
        r5[1] = TuplesKt.to("key_current_page_name", "image_generate");
        r5[2] = TuplesKt.to("key_is_multi_tab", Boolean.FALSE);
        r5[3] = TuplesKt.to("key_show_user_info", Boolean.valueOf(z2.a.R2()));
        r5[4] = TuplesKt.to("key_creation_recommend_type", 2);
        r5[5] = TuplesKt.to("key_creation_use_cache", Boolean.TRUE);
        r5[6] = TuplesKt.to("recommend_from", this.g);
        String r9 = this.f;
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r5[7] = TuplesKt.to("arg_chat_type", r9);
        r5[8] = TuplesKt.to("action_bar_template_id", 4);
        r5[9] = TuplesKt.to("enter_from", "template_list");
        String r10 = this.h;
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r5[10] = TuplesKt.to("argConversationId", r10);
        String r11 = this.h;
        if (r11 == null) goto L29;
        r7 = r11;
    L29:
        r5[11] = TuplesKt.to("argConversationId", r7);
        r5[12] = TuplesKt.to("key_template_list_top_padding", 0);
        r5[13] = TuplesKt.to("key_template_list_bottom_padding", 0);
        if (o0.d(this.e) == false) goto L38;
        String r12 = this.e;
        i1 r13 = LaunchCacheDelegate.b.e();
        if (r13 == null) goto L34;
        String r14 = r13.c;
    L36:
        if (Intrinsics.areEqual(r12, r14) == true) goto L38;
    L39:
        r5[14] = TuplesKt.to("key_is_chat_double_page", Boolean.valueOf(r8));
        r3.setArguments(BundleKt.bundleOf(r5));
        NovaTitleBarEx r15 = new NovaTitleBarEx(requireContext());
        NovaTitleBarEx.Y5(r15, getResources().getString(2131906382), null, new q(r3), 2);
        r15.setBackgroundResource(v19.c.b(2130970529, getContext(), 2131102529));
        NovaTitleBarEx.b6(r15, v19.c.b(2130971749, getContext(), 2131241477), false, null, null, new r(this), 14);
        LinearLayout r16 = (LinearLayout) r0.findViewById(2131378837);
        if (r16 == null) goto L42;
        r16.addView(r15, 0, new LinearLayout.LayoutParams(-1, -2));
    L42:
        FragmentTransaction r4 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L46;
        r4 = r4.replace(2131373275, r3);
    L46:
        r4.commit();
        goto L47
    L34:
        r14 = null;
    L38:
        r8 = false;
    L47:
        return r0;
    L13:
        r3 = null;
        goto L14
    L48:
        dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
