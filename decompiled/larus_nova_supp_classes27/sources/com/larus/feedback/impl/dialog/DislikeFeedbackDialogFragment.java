package com.larus.feedback.impl.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.larus.feedback.api.view.FlowTagLayout;
import com.larus.feedback.impl.databinding.FlowDialogfragDislikeFeedbackBinding;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.spi.feedback.ObricFeedbackPanelServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s99.c;
import s99.e;
import s99.f;
import t19.s;
import yc9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J4\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\u001e\u0010*\u001a\u00020\u000b2\u0014\u0010+\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u0012\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010%H\u0002J\b\u0010/\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/feedback/impl/dialog/DislikeFeedbackDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "config", "Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "binding", "Lcom/larus/feedback/impl/databinding/FlowDialogfragDislikeFeedbackBinding;", "experiencePlanProvider", "Lcom/obric/assistant/spi/feedback/IObricExperiencePlanFeedbackProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "initViews", "close", "submit", "setResult", "manualDismiss", "", "isSubmit", "selectedTags", "", "Lcom/larus/feedback/api/view/FlowTagLayout$TagBean;", "inputContent", "", "directReport", "result", "Lcom/larus/feedback/api/model/FlowDislikeFeedbackResult;", "copyFeedbackID", "getFeedbackID", "callback", "Lkotlin/Function1;", "doOnCopy", "logID", "hideIme", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DislikeFeedbackDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public FlowDislikePanelConfig d;
    public FlowDialogfragDislikeFeedbackBinding e;
    public nga.a f;

    public static final class a {
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ Function1<String, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            Function1<String, Unit> r0 = this.a;
            Map r5 = r4.getExt();
            if (r5 == null) goto L5;
            String r6 = (String) r5.get("inner_log_id");
        L6:
            r0.invoke(r6);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public final void close() {
        setResult(true, false, CollectionsKt.emptyList(), null);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.f = null;
        this.e = null;
    }

    public DislikeFeedbackDialogFragment() {
    }

    public static void S90(DislikeFeedbackDialogFragment r3) {
        FlowDialogfragDislikeFeedbackBinding r0 = r3.e;
        String r1 = null;
        if (r0 == null) goto L7;
        FlowTagLayout r2 = r0.g;
        if (r2 == null) goto L7;
        List<FlowTagLayout.b> r4 = r2.getSelectedTagBeans();
    L8:
        if (r4 != null) goto L10;
        r4 = CollectionsKt.emptyList();
    L10:
        FlowDialogfragDislikeFeedbackBinding r5 = r3.e;
        if (r5 == null) goto L17;
        NestedScrollEditText r6 = r5.e;
        if (r6 == null) goto L17;
        Editable r7 = r6.getText();
        if (r7 == null) goto L17;
        r1 = r7.toString();
    L17:
        nga.a r8 = r3.f;
        if (r8 == null) goto L20;
        r8.b();
    L20:
        r3.setResult(true, true, r4, r1);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void T90(Function1<? super String, Unit> r4) {
        FlowDislikePanelConfig r0 = this.d;
        if (r0 == null) goto L7;
        Bundle r1 = r0.d;
        if (r1 == null) goto L7;
        String r2 = r1.getString("message_log_id");
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r4.invoke(r2);
        return;
    L17:
        FlowDislikePanelConfig r5 = this.d;
        if (r5 == null) goto L22;
        Bundle r6 = r5.d;
        if (r6 == null) goto L22;
        String r7 = r6.getString("message_id");
    L23:
        if (r7 != null) goto L26;
        r4.invoke(null);
        return;
    L26:
        d.e().m(r7, new b(r4));
        return;
    L22:
        r7 = null;
        goto L23
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r3);
        setResult(false, false, CollectionsKt.emptyList(), null);
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        setStyle(2, 2131953744);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        FlowDislikePanelConfig r4 = (FlowDislikePanelConfig) r3.getParcelable("arg_config");
    L6:
        this.d = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.FrameLayout, com.larus.feedback.api.view.FlowTagLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.larus.common_ui.widget.roundlayout.RoundTextView] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.widget.TextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        BottomSheetDialog r11 = getDialog();
        ArrayList<FeedbackMeta> r0 = null;
        if ((r11 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r12 = r11;
    L6:
        if (r12 == null) goto L8;
        View r13 = r12.findViewById(2131368870);
    L9:
        if (r13 == null) goto L11;
        BottomSheetBehavior r14 = BottomSheetBehavior.from(r13);
        r14.setSkipCollapsed(true);
        r14.setState(3);
    L11:
        FlowDialogfragDislikeFeedbackBinding r15 = this.e;
        if (r15 == null) goto L70;
        r15.d.setOnClickListener(new s99.b());
        r15.h.setOnClickListener(new c(this));
        r15.c.setOnClickListener(new s99.d(this));
        FlowDislikePanelConfig r16 = this.d;
        boolean r1 = false;
        if (r16 == null) goto L18;
        Bundle r17 = r16.d;
        if (r17 == null) goto L18;
        boolean r18 = r17.getBoolean("disable_copy_button", false);
    L20:
        if (z2.a.L1() == false) goto L24;
        if (r18 == true) goto L24;
        r15.b.setOnClickListener(new e(this));
    L25:
        r15.a.setOnClickListener(new f(this));
        FlowDislikePanelConfig r110 = this.d;
        if (r110 == null) goto L32;
        Bundle r111 = r110.d;
        if (r111 == null) goto L32;
        String r112 = r111.getString("feedback_title");
        if (r112 == null) goto L32;
        r15.i.setText(r112);
    L32:
        FlowDislikePanelConfig r113 = this.d;
        if (r113 == null) goto L35;
        r0 = r113.b;
    L35:
        CharSequence r114 = "";
        if (r0 == null) goto L64;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L39:
        if (r3.hasNext() == false) goto L44;
        FeedbackMeta r4 = (FeedbackMeta) r3.next();
        String r5 = r4.b();
        if (r5 != null) goto L43;
        r5 = "";
    L43:
        r2.add(new FlowTagLayout.b(r5, r4.a(), r4));
        goto L39
    L44:
        final ?? r6 = r15.g;
        int r7 = FlowTagLayout.v;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "tags");
        ((ArrayList) r6.p).clear();
        ((ArrayList) r6.p).addAll(r2);
        r6.a();
        r6.removeAllViews();
        Iterator r8 = ((ArrayList) r6.p).iterator();
    L46:
        if (r8.hasNext() == false) goto L54;
        final FlowTagLayout.b r20 = (FlowTagLayout.b) r8.next();
        String r21 = r20.a;
        Function1<? super String, ? extends TextView> r22 = r6.u;
        if (r22 == null) goto L52;
        ?? r23 = (TextView) r22.invoke(r21);
        if (r23 == 0) goto L52;
    L53:
        r23.setTag(r20);
        r23.setOnClickListener(new r99.a(r6, r20));
        r6.addView(r23, new FrameLayout.LayoutParams(-2, -2));
    L52:
        r23 = new RoundTextView(r6.getContext());
        r23.setMinHeight(r6.h);
        r23.setTextColor(r6.n);
        r23.setTextSize(0, r6.e);
        int r24 = r6.c;
        int r25 = r6.d;
        r23.setPadding(r24, r25, r24, r25);
        r23.setText(r21);
        r23.setGravity(8388627);
        c29.a r26 = r23.getDelegate();
        r26.j(r6.n);
        r26.e(r6.f);
        r26.i(r6.g);
        r26.g(r6.l);
        r26.h(r6.l);
        r26.a(r6.i);
        r26.b(r6.j);
        goto L53
    L54:
        r6.b();
        FlowDislikePanelConfig r27 = this.d;
        if (r27 == null) goto L59;
        Bundle r28 = r27.d;
        if (r28 == null) goto L59;
        r1 = r28.getBoolean("is_multiple_selection", false);
    L59:
        FlowTagLayout r30 = r15.g;
        if (r1 == false) goto L62;
        FlowTagLayout.SelectionMode r31 = FlowTagLayout.SelectionMode.MULTI;
    L63:
        r30.setSelectionMode(r31);
        goto L64
    L62:
        r31 = FlowTagLayout.SelectionMode.SINGLE;
    L64:
        AppCompatEditText r32 = r15.e;
        FlowDislikePanelConfig r33 = this.d;
        if (r33 == null) goto L69;
        CharSequence r34 = r33.c;
        if (r34 == null) goto L69;
        r114 = r34;
    L69:
        r32.setHint(r114);
    L24:
        r15.b.setVisibility(8);
    L18:
        r18 = false;
    L70:
        nga.a r35 = ObricFeedbackPanelServiceDelegate.b.b();
        this.f = r35;
        if (r35 == null) goto L85;
        FlowDialogfragDislikeFeedbackBinding r115 = this.e;
        if (r115 == null) goto L86;
        FrameLayout r116 = r115.f;
        if (r116 == null) goto L87;
        r35.a(r116, getViewLifecycleOwner());
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131561139, r12, false);
        int r15 = 2131364696;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r14, 2131364696);
        if (r2 == null) goto L28;
        r15 = 2131364848;
        RoundTextView r3 = (RoundTextView) ViewBindings.findChildViewById(r14, 2131364848);
        if (r3 == null) goto L28;
        r15 = 2131367771;
        RoundLinearLayout r4 = (RoundLinearLayout) ViewBindings.findChildViewById(r14, 2131367771);
        if (r4 == null) goto L28;
        r15 = 2131371800;
        NestedScrollEditText r5 = (NestedScrollEditText) ViewBindings.findChildViewById(r14, 2131371800);
        if (r5 == null) goto L28;
        r15 = 2131371918;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131371918);
        if (r6 == null) goto L28;
        r15 = 2131373037;
        FlowTagLayout r7 = (FlowTagLayout) ViewBindings.findChildViewById(r14, 2131373037);
        if (r7 == null) goto L28;
        r15 = 2131375355;
        if (((RoundFrameLayout) ViewBindings.findChildViewById(r14, 2131375355)) == null) goto L28;
        r15 = 2131376107;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r14, 2131376107);
        if (r8 == null) goto L28;
        r15 = 2131391606;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r14, 2131391606);
        if (r9 == null) goto L28;
        FrameLayout r16 = (FrameLayout) r14;
        FlowDialogfragDislikeFeedbackBinding r17 = new FlowDialogfragDislikeFeedbackBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        Dialog r18 = getDialog();
        if (r18 == null) goto L25;
        Window r110 = r18.getWindow();
        if (r110 == null) goto L25;
        r110.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L25:
        this.e = r17;
        return r16;
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    private final void setResult(boolean r24, boolean r25, List<FlowTagLayout.b> r26, String r27) {
        List<FlowTagLayout.b> r2 = r26;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(Integer.valueOf(((FlowTagLayout.b) r4.next()).b));
        goto L4
    L6:
        final q99.a r5 = new q99.a(r25, r3, r27, 4);
        Integer r6 = (Integer) CollectionsKt.firstOrNull(r3);
        boolean r7 = true;
        InputMethodManager r8 = null;
        if (r6 == null) goto L25;
        int r9 = r6.intValue();
        FlowDislikePanelConfig r10 = this.d;
        if (r10 == null) goto L11;
        List r11 = r10.b;
    L12:
        if (r11 != null) goto L14;
        r11 = CollectionsKt.emptyList();
    L14:
        Iterator r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L23;
        Object r13 = r12.next();
        if (((FeedbackMeta) r13).a() != r9) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L16;
    L24:
        FeedbackMeta r15 = (FeedbackMeta) r13;
    L26:
        Bundle r16 = new Bundle();
        r16.putBoolean("is_submit", r5.a);
        FlowDislikePanelConfig r17 = this.d;
        if (r17 == null) goto L29;
        Bundle r18 = r17.d;
    L30:
        r16.putBundle("extra_data", r18);
        if (r6 == null) goto L33;
        int r20 = r6.intValue();
    L34:
        r16.putInt("selected_code", r20);
        r16.putIntArray("selected_code_list", CollectionsKt.toIntArray(r3));
        r16.putParcelable("selected_tag", r15);
        String r21 = r5.d;
        if (r21 != null) goto L37;
        r21 = "";
    L37:
        r16.putString("input_txt", r21);
        FlowDislikePanelConfig r22 = this.d;
        if (r22 == null) goto L42;
        String r23 = r22.a;
        if (r23 == null) goto L42;
        getParentFragmentManager().setFragmentResult(r23, r16);
    L42:
        FlowDislikePanelConfig r28 = this.d;
        if (r28 != null) goto L45;
    L47:
        r7 = false;
    L48:
        if (r7 == false) goto L71;
        if (r28 == null) goto L53;
        Bundle r30 = r28.d;
        if (r30 == null) goto L53;
        final String r31 = r30.getString("message_id");
    L54:
        if (r31 != null) goto L56;
        r31 = "";
    L56:
        MsgFeedbackType r110 = MsgFeedbackType.MsgFeedbackTypeDislike;
        Integer r32 = (Integer) CollectionsKt.firstOrNull(r5.b);
        if (r32 == null) goto L59;
        int r111 = r32.intValue();
    L60:
        List<Integer> r112 = r5.b;
        String r33 = r5.d;
        if (r33 != null) goto L63;
        String r113 = "";
    L64:
        FlowDislikePanelConfig r34 = this.d;
        if (r34 == null) goto L67;
        Integer r114 = r34.e;
    L68:
        d.e().t(new m(null, r31, r110, r111, r112, r113, null, null, null, null, r114, true, null, 5057), null);
        T90(new s99.a(this, r5, r31));
        if (r25 == false) goto L71;
        s r0 = s.a;
        Context r35 = getContext();
        r0.getClass();
        s.o(r35, 2131901665, false);
        goto L71
    L67:
        r114 = null;
        goto L68
    L63:
        r113 = r33;
        goto L64
    L59:
        r111 = 0;
    L53:
        r31 = null;
    L71:
        Context r1 = getContext();
        if (r1 == null) goto L74;
        Object r36 = r1.getSystemService("input_method");
    L76:
        if ((r36 instanceof InputMethodManager) == false) goto L78;
        r8 = (InputMethodManager) r36;
    L78:
        FlowDialogfragDislikeFeedbackBinding r37 = this.e;
        if (r37 == null) goto L86;
        AppCompatEditText r38 = r37.e;
        if (r38 == null) goto L86;
        IBinder r40 = r38.getWindowToken();
        if (r40 == null) goto L86;
        if (r8 == null) goto L86;
        r8.hideSoftInputFromWindow(r40, 0);
    L86:
        if (r24 == false) goto L102;
        dismissAllowingStateLoss();     // Catch: Exception -> L89
        return;
    L89:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r41 = DialogFragmentLancet.sLastShowStack;
        if (r41 == null) goto L103;
        com.bytedance.crash.d.d(r41, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L103:
        return;
    L102:
        return;
    L74:
        r36 = null;
        goto L76
    L45:
        if (r28.f != true) goto L47;
    L33:
        r20 = 0;
        goto L34
    L29:
        r18 = null;
        goto L30
    L20:
        r14 = false;
        goto L21
    L23:
        r13 = null;
        goto L24
    L11:
        r11 = null;
        goto L12
    L25:
        r15 = null;
        goto L26
    }
}
