package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.x1;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0017\u0010&\u001a\u00020\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleInputBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleInputBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "rule", "Lcom/larus/dora/api/entity/NotificationRule;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeViewModel", "initUI", "updateCharCount", "length", "", "updateBtnState", "text", "", "saveEditedRule", "newName", "resetErrorState", "showErrorState", "errorResId", "(Ljava/lang/Integer;)V", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddRuleInputFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraFragmentAddRuleInputBinding d;
    public CustomBroadcastRulesViewModel e;
    public x1 f;
    public NotificationRule g;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        x1 r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.d = null;
    }

    public AddRuleInputFragment() {
    }

    public final void S90(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        LarusDoraFragmentAddRuleInputBinding r0 = this.d;
        if (r0 == null) goto L11;
        LinearLayoutCompat r1 = r0.f;
        if (r1 == null) goto L11;
        r1.setEnabled(!r4);
    L11:
        LarusDoraFragmentAddRuleInputBinding r2 = this.d;
        if (r2 == null) goto L20;
        LinearLayoutCompat r5 = r2.f;
        if (r5 == null) goto L21;
        if (r4 == false) goto L17;
        float r6 = 0.3f;
    L18:
        r5.setAlpha(r6);
        return;
    L17:
        r6 = 1.0f;
        goto L18
    L21:
        return;
    L20:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void T90(int r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        LarusDoraFragmentAddRuleInputBinding r1 = this.d;
        if (r1 == null) goto L11;
        TextView r2 = r1.c;
        if (r2 == null) goto L11;
        r2.setText(r5 + "/100");
    L11:
        if (r5 < 100) goto L17;
        SpannableString r3 = new SpannableString(r5 + "/100");
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r0, 2131102650)), 0, String.valueOf(r5).length(), 33);
        LarusDoraFragmentAddRuleInputBinding r6 = this.d;
        if (r6 == null) goto L23;
        TextView r7 = r6.c;
        if (r7 == null) goto L24;
        r7.setText(r3);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        LarusDoraFragmentAddRuleInputBinding r8 = this.d;
        if (r8 == null) goto L26;
        TextView r9 = r8.c;
        if (r9 == null) goto L27;
        r9.setTextColor(ContextCompat.getColor(r0, v19.c.b(2130972080, r0, 2131103140)));
        return;
    L27:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        NotificationRule r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("arg_rule");
    L7:
        if ((r5 instanceof NotificationRule) == false) goto L9;
        r0 = (NotificationRule) r5;
    L9:
        this.g = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        FragmentActivity r16 = getActivity();
        if (r16 != null) goto L5;
        return;
    L5:
        this.e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r16).get(CustomBroadcastRulesViewModel.class);
        LarusDoraFragmentAddRuleInputBinding r17 = this.d;
        if (r17 == null) goto L10;
        AppCompatEditText r18 = r17.i;
        if (r18 == null) goto L10;
        this.f = new x1(r18);
    L10:
        int r110 = 0;
        if (this.g == null) goto L13;
        final boolean r111 = true;
    L14:
        String r0 = "";
        if (r111 == false) goto L67;
        if (getContext() == null) goto L28;
        LarusDoraFragmentAddRuleInputBinding r1 = this.d;
        if (r1 == null) goto L23;
        TextView r2 = r1.k;
        if (r2 == null) goto L23;
        r2.setText(getString(2131902252));
    L23:
        LarusDoraFragmentAddRuleInputBinding r3 = this.d;
        if (r3 == null) goto L28;
        AppCompatTextView r4 = r3.e;
        if (r4 == null) goto L28;
        r4.setText(getString(2131902220));
    L28:
        LarusDoraFragmentAddRuleInputBinding r5 = this.d;
        if (r5 == null) goto L33;
        TextView r6 = r5.j;
        if (r6 == null) goto L33;
        r6.setVisibility(8);
    L33:
        LarusDoraFragmentAddRuleInputBinding r7 = this.d;
        if (r7 == null) goto L43;
        AppCompatEditText r8 = r7.i;
        if (r8 == null) goto L43;
        NotificationRule r9 = this.g;
        if (r9 == null) goto L41;
        String r10 = r9.getRuleDesc();
        if (r10 == null) goto L41;
    L42:
        r8.setText(r10);
    L41:
        r10 = "";
    L43:
        LarusDoraFragmentAddRuleInputBinding r11 = this.d;
        if (r11 == null) goto L54;
        AppCompatEditText r12 = r11.i;
        if (r12 == null) goto L54;
        NotificationRule r13 = this.g;
        if (r13 == null) goto L52;
        String r20 = r13.getRuleDesc();
        if (r20 == null) goto L52;
        int r21 = r20.length();
    L53:
        r12.setSelection(r21);
    L52:
        r21 = 0;
    L54:
        NotificationRule r22 = this.g;
        if (r22 == null) goto L59;
        String r23 = r22.getRuleDesc();
        if (r23 == null) goto L59;
        r110 = r23.length();
    L59:
        T90(r110);
        NotificationRule r112 = this.g;
        if (r112 == null) goto L65;
        String r113 = r112.getRuleDesc();
        if (r113 == null) goto L65;
        r0 = r113;
    L65:
        S90(r0);
    L84:
        LarusDoraFragmentAddRuleInputBinding r114 = this.d;
        if (r114 == null) goto L89;
        AppCompatEditText r115 = r114.i;
        if (r115 == null) goto L89;
        r115.addTextChangedListener(new h(this));
    L89:
        LarusDoraFragmentAddRuleInputBinding r116 = this.d;
        if (r116 == null) goto L94;
        AppCompatTextView r117 = r116.b;
        if (r117 == null) goto L94;
        e1.d(r117, new f(this));
    L94:
        LarusDoraFragmentAddRuleInputBinding r118 = this.d;
        if (r118 == null) goto L99;
        LinearLayoutCompat r119 = r118.f;
        if (r119 == null) goto L99;
        e1.d(r119, new g(this, r111));
    L99:
        Lifecycle.State r120 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r120, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r120, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r120, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r120, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r120, null, this), 3, null);
        return;
    L67:
        if (getContext() == null) goto L78;
        LarusDoraFragmentAddRuleInputBinding r24 = this.d;
        if (r24 == null) goto L73;
        TextView r25 = r24.k;
        if (r25 == null) goto L73;
        r25.setText(getString(2131902212));
    L73:
        LarusDoraFragmentAddRuleInputBinding r26 = this.d;
        if (r26 == null) goto L78;
        AppCompatTextView r27 = r26.e;
        if (r27 == null) goto L78;
        r27.setText(getString(2131902226));
    L78:
        LarusDoraFragmentAddRuleInputBinding r28 = this.d;
        if (r28 == null) goto L83;
        TextView r30 = r28.j;
        if (r30 == null) goto L83;
        r30.setVisibility(0);
    L83:
        S90("");
        goto L84
    L13:
        r111 = false;
        goto L14
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131562181, r14, false);
        int r17 = 2131364692;
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131364692)) == null) goto L29;
        r17 = 2131365123;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131365123);
        if (r2 == null) goto L29;
        r17 = 2131365490;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r16, 2131365490);
        if (r3 == null) goto L29;
        r17 = 2131371775;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r16, 2131371775);
        if (r4 == null) goto L29;
        r17 = 2131373625;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131373625);
        if (r5 == null) goto L29;
        r17 = 2131373626;
        LinearLayoutCompat r6 = ViewBindings.findChildViewById(r16, 2131373626);
        if (r6 == null) goto L29;
        r17 = 2131373627;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r16, 2131373627);
        if (r7 == null) goto L29;
        r17 = 2131375355;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r16, 2131375355);
        if (r8 == null) goto L29;
        r17 = 2131375389;
        if (ViewBindings.findChildViewById(r16, 2131375389) == null) goto L29;
        r17 = 2131384889;
        AppCompatEditText r9 = ViewBindings.findChildViewById(r16, 2131384889);
        if (r9 == null) goto L29;
        r17 = 2131387553;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131387553);
        if (r10 == null) goto L29;
        r17 = 2131388772;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r16, 2131388772);
        if (r11 == null) goto L29;
        ConstraintLayout r18 = r16;
        this.d = new LarusDoraFragmentAddRuleInputBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
