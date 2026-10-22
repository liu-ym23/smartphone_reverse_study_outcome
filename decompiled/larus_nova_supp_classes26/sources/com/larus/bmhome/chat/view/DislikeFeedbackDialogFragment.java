package com.larus.bmhome.chat.view;

import android.R;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.databinding.LarusDialogfragDislikeFeedbackBinding;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.x1;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import po8.g;
import po8.h;
import po8.i;
import po8.j;
import po8.k;
import t19.s;
import v19.o5;
import yc9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J0\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010 H\u0002J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/view/DislikeFeedbackDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogfragDislikeFeedbackBinding;", "conversationType", "", "Ljava/lang/Integer;", "directReportReason", "", "Ljava/lang/Boolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "close", "setResult", "manualDismiss", "isSubmit", "selectedTag", "Lcom/larus/bmhome/chat/view/FlowTagLayout$TagBean;", "inputContent", "", "submit", "copyFeedbackID", "doOnCopy", "logID", "onDestroyView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DislikeFeedbackDialogFragment extends DialogFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDialogfragDislikeFeedbackBinding d;
    public Integer e;
    public Boolean f;

    public static final class a {
    }

    static {
    }

    public final void close() {
        setResult(true, false, null, null);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public DislikeFeedbackDialogFragment() {
    }

    public static void S90(DislikeFeedbackDialogFragment r3) {
        LarusDialogfragDislikeFeedbackBinding r0 = r3.d;
        String r1 = null;
        if (r0 == null) goto L7;
        FlowTagLayout r2 = r0.f;
        if (r2 == null) goto L7;
        FlowTagLayout.a r4 = r2.getCurSelectedTagBean();
    L8:
        LarusDialogfragDislikeFeedbackBinding r5 = r3.d;
        if (r5 == null) goto L15;
        NestedScrollEditText r6 = r5.e;
        if (r6 == null) goto L15;
        Editable r7 = r6.getText();
        if (r7 == null) goto L15;
        r1 = r7.toString();
    L15:
        r3.setResult(true, true, r4, r1);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void T90(String r4) {
        ClipData r5 = ClipData.newPlainText("message_log_id", r4);
        Context r0 = getContext();
        if (r0 == null) goto L9;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L7;
        r1.d0();
        i1 r2 = i1.a;
        Intrinsics.checkNotNull(r5);
        r2.i(r0, r5, "bpea-user-report-message");
    L7:
        s r6 = s.a;
        Context r3 = getContext();
        r6.getClass();
        s.o(r3, 2131910467, false);
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        setResult(false, false, null, null);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 2131953744);
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDialogfragDislikeFeedbackBinding r10 = this.d;
        if (r10 == null) goto L54;
        r10.d.setOnClickListener(new g());
        r10.g.setOnClickListener(new h(this));
        r10.c.setOnClickListener(new i(this));
        Bundle r11 = getArguments();
        boolean r1 = false;
        if (r11 == null) goto L10;
        Bundle r12 = r11.getBundle("extra_data");
        if (r12 == null) goto L10;
        r1 = r12.getBoolean("disable_copy_button", false);
    L10:
        if (z2.a.L1() == false) goto L14;
        if (r1 == true) goto L14;
        r10.b.setOnClickListener(new j(this));
    L15:
        r10.a.setOnClickListener(new k(this));
        Bundle r13 = getArguments();
        if (r13 == null) goto L22;
        Bundle r14 = r13.getBundle("extra_data");
        if (r14 == null) goto L22;
        String r15 = r14.getString("feedback_title");
        if (r15 == null) goto L22;
        r10.h.setText(r15);
    L22:
        Bundle r16 = getArguments();
        Integer r0 = null;
        if (r16 == null) goto L25;
        ArrayList r17 = r16.getParcelableArrayList("unlike_feedback_meta_list");
    L26:
        String r2 = "";
        if (r17 == null) goto L36;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r18 = r17.iterator();
    L30:
        if (r18.hasNext() == false) goto L35;
        FeedbackMeta r4 = (FeedbackMeta) r18.next();
        String r5 = r4.b();
        if (r5 != null) goto L34;
        r5 = "";
    L34:
        r3.add(new FlowTagLayout.a(r5, r4.a(), r4));
        goto L30
    L35:
        FlowTagLayout r19 = r10.f;
        int r6 = FlowTagLayout.t;
        r19.a(r3, true);
    L36:
        Bundle r20 = getArguments();
        if (r20 == null) goto L42;
        String r21 = r20.getString("unlike_feedback_placeholder");
        if (r21 == null) goto L42;
        r2 = r21;
    L42:
        r10.e.setHint(r2);
        Bundle r22 = getArguments();
        if (r22 == null) goto L45;
        r0 = Integer.valueOf(r22.getInt("conversation_type"));
    L45:
        this.e = r0;
        Bundle r23 = getArguments();
        if (r23 == null) goto L48;
        Boolean r24 = Boolean.valueOf(r23.getBoolean("direct_report_reason"));
    L49:
        this.f = r24;
        return;
    L48:
        r24 = Boolean.FALSE;
        goto L49
    L25:
        r17 = null;
    L14:
        r10.b.setVisibility(8);
        goto L15
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131562111, r11, false);
        int r14 = 2131364696;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r13, 2131364696);
        if (r2 == null) goto L26;
        r14 = 2131364848;
        RoundTextView r3 = ViewBindings.findChildViewById(r13, 2131364848);
        if (r3 == null) goto L26;
        r14 = 2131367771;
        RoundLinearLayout r4 = ViewBindings.findChildViewById(r13, 2131367771);
        if (r4 == null) goto L26;
        r14 = 2131371800;
        NestedScrollEditText r5 = ViewBindings.findChildViewById(r13, 2131371800);
        if (r5 == null) goto L26;
        r14 = 2131373037;
        FlowTagLayout r6 = (FlowTagLayout) ViewBindings.findChildViewById(r13, 2131373037);
        if (r6 == null) goto L26;
        r14 = 2131375355;
        if (ViewBindings.findChildViewById(r13, 2131375355) == null) goto L26;
        r14 = 2131376107;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r13, 2131376107);
        if (r7 == null) goto L26;
        r14 = 2131391606;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r13, 2131391606);
        if (r8 == null) goto L26;
        FrameLayout r15 = (FrameLayout) r13;
        LarusDialogfragDislikeFeedbackBinding r16 = new LarusDialogfragDislikeFeedbackBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        Dialog r17 = getDialog();
        if (r17 == null) goto L23;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L23;
        r18.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L23:
        this.d = r16;
        return r15;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    private final void setResult(boolean r25, boolean r26, FlowTagLayout.a r27, String r28) {
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        Bundle r4 = r3.getBundle("extra_data");
    L6:
        if (r4 == null) goto L9;
        String r6 = r4.getString("feedback_request_key");
        if (r6 == null) goto L9;
    L10:
        Bundle r7 = new Bundle();
        r7.putBoolean("is_submit", r26);
        r7.putBundle("extra_data", r4);
        if (r27 == null) goto L13;
        int r8 = r27.b;
    L14:
        r7.putInt("selected_code", r8);
        if (r27 == null) goto L17;
        Object r9 = r27.c;
    L19:
        if ((r9 instanceof FeedbackMeta) == false) goto L22;
        r7.putParcelable("selected_tag", (Parcelable) r27.c);
    L22:
        if (r28 != null) goto L24;
        String r10 = "";
    L25:
        r7.putString("input_txt", r10);
        Unit r11 = Unit.INSTANCE;
        o5.a(this, r6, r7);
        if (Intrinsics.areEqual(this.f, Boolean.TRUE) == false) goto L47;
        Bundle r12 = getArguments();
        if (r12 == null) goto L32;
        Bundle r5 = r12.getBundle("extra_data");
        if (r5 == null) goto L32;
        String r13 = r5.getString(MusicAppletPage.KEY_MESSAGE_ID);
    L33:
        if (r13 != null) goto L35;
        String r14 = "";
    L36:
        MsgFeedbackType r15 = MsgFeedbackType.MsgFeedbackTypeDislike;
        if (r27 == null) goto L39;
        int r16 = r27.b;
    L41:
        if (r28 != null) goto L43;
        String r17 = "";
    L44:
        d.e().t(new m(null, r14, r15, r16, null, r17, null, null, null, null, this.e, true, null, 5073), null);
        if (r26 == false) goto L47;
        s r0 = s.a;
        Context r2 = getContext();
        r0.getClass();
        s.o(r2, 2131901665, false);
        goto L47
    L43:
        r17 = r28;
        goto L44
    L39:
        r16 = 0;
        goto L41
    L35:
        r14 = r13;
    L32:
        r13 = null;
    L47:
        LarusDialogfragDislikeFeedbackBinding r1 = this.d;
        if (r1 == null) goto L52;
        NestedScrollEditText r18 = r1.e;
        if (r18 == null) goto L52;
        new x1(r18).a(false);
    L52:
        if (r25 == false) goto L62;
        dismissAllowingStateLoss();     // Catch: Exception -> L55
        return;
    L55:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L63;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L63:
        return;
    L62:
        return;
    L24:
        r10 = r28;
        goto L25
    L17:
        r9 = null;
        goto L19
    L13:
        r8 = 0;
    L9:
        r6 = "dislikeDialogClose";
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
