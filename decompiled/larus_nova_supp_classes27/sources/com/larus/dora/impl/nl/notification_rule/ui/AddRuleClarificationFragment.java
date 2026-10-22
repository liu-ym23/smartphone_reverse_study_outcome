package com.larus.dora.impl.nl.notification_rule.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleClarificationBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleClarificationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleClarificationBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleClarificationBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "userInput", "", "clarifiedDesc", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeViewModel", "initUI", "onDestroyView", "Companion", "PreviewViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddRuleClarificationFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraFragmentAddRuleClarificationBinding d;
    public CustomBroadcastRulesViewModel e;
    public String f;
    public List<String> g;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleClarificationFragment$PreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "name", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreviewViewHolder extends RecyclerView.ViewHolder {
        public PreviewViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public AddRuleClarificationFragment() {
        this.f = "";
        this.g = CollectionsKt.emptyList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        String r4 = r3.getString("user_input");
        if (r4 == null) goto L6;
    L7:
        this.f = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L12;
        List<String> r6 = r5.getStringArrayList("clarified_desc");
        if (r6 == null) goto L12;
    L13:
        this.g = r6;
        return;
    L12:
        r6 = CollectionsKt.emptyList();
    L6:
        r4 = "";
        goto L7
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        FragmentActivity r13 = getActivity();
        if (r13 != null) goto L5;
        return;
    L5:
        this.e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r13).get(CustomBroadcastRulesViewModel.class);
        LarusDoraFragmentAddRuleClarificationBinding r14 = this.d;
        if (r14 == null) goto L11;
        TextView r15 = r14.e;
        if (r15 == null) goto L11;
        r15.setText(this.f);
    L11:
        if (getContext() == null) goto L17;
        LarusDoraFragmentAddRuleClarificationBinding r16 = this.d;
        if (r16 == null) goto L17;
        TextView r17 = r16.d;
        if (r17 == null) goto L17;
        r17.setText(getString(2131902233, new Object[]{String.valueOf(this.g.size())}));
    L17:
        LarusDoraFragmentAddRuleClarificationBinding r18 = this.d;
        if (r18 == null) goto L22;
        MaxHeightRecyclerView r110 = r18.f;
        if (r110 == null) goto L22;
        r110.setLayoutManager(new LinearLayoutManager(r110.getContext()));
        int r0 = r110.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        int r1 = ((r0 * 2) + r110.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462))) + ((int) (((double) r110.getResources().getDimensionPixelSize(v19.c.b(2130972273, null, 2131167616))) * 1.5d));
        r110.setMaxHeight(r1 * 3);
        r110.setMinimumHeight(r1);
        r110.setAdapter(new AddRuleClarificationFragment$initUI$2$1(this));
    L22:
        LarusDoraFragmentAddRuleClarificationBinding r111 = this.d;
        if (r111 == null) goto L27;
        AppCompatTextView r112 = r111.g;
        if (r112 == null) goto L27;
        e1.d(r112, new com.larus.dora.impl.nl.notification_rule.ui.a(this));
    L27:
        LarusDoraFragmentAddRuleClarificationBinding r113 = this.d;
        if (r113 == null) goto L32;
        LinearLayoutCompat r114 = r113.b;
        if (r114 == null) goto L32;
        e1.d(r114, new b(this));
    L32:
        Lifecycle.State r115 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r115, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r115, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r115, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562180, r10, false);
        int r13 = 2131364692;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131364692)) == null) goto L27;
        r13 = 2131367641;
        if (((DoraTextView) ViewBindings.findChildViewById(r12, 2131367641)) == null) goto L27;
        r13 = 2131367642;
        LinearLayoutCompat r2 = ViewBindings.findChildViewById(r12, 2131367642);
        if (r2 == null) goto L27;
        r13 = 2131367643;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131367643);
        if (r3 == null) goto L27;
        r13 = 2131373628;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131373628);
        if (r4 == null) goto L27;
        r13 = 2131381683;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131381683)) == null) goto L27;
        r13 = 2131381684;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131381684);
        if (r5 == null) goto L27;
        r13 = 2131382949;
        MaxHeightRecyclerView r6 = ViewBindings.findChildViewById(r12, 2131382949);
        if (r6 == null) goto L27;
        r13 = 2131383729;
        DoraTextView r7 = (DoraTextView) ViewBindings.findChildViewById(r12, 2131383729);
        if (r7 == null) goto L27;
        r13 = 2131387553;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131387553)) == null) goto L27;
        r13 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131388772)) == null) goto L27;
        ConstraintLayout r14 = r12;
        this.d = new LarusDoraFragmentAddRuleClarificationBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
