package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.android.ClipboardCompat;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "Lcom/bytedance/android/annie/debug/ui/BaseCommonDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsInfoDialogFragment extends BaseCommonDialogFragment {
    public static final /* synthetic */ int f = 0;
    public List<? extends DialogItem> e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AbsInfoDialogFragment a;

        public a(AbsInfoDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L12;
            com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ AbsInfoDialogFragment a;

        public b(AbsInfoDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r10) {
            AbsInfoDialogFragment r11 = this.a;
            int r0 = AbsInfoDialogFragment.f;
            r11.getClass();
            StringBuilder r1 = new StringBuilder();
            List<? extends DialogItem> r12 = r11.e;
            if (r12 == null) goto L16;
            Iterator<T> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L16;
            DialogItem r14 = (DialogItem) r13.next();
            if (r14.b == null) goto L6;
            StringBuilder r15 = new StringBuilder();
            String r16 = r14.a;
            if (r16 != null) goto L12;
            r16 = "";
        L12:
            r15.append(r16);
            r15.append(": ");
            String r17 = r14.b;
            if (r17 != null) goto L15;
            r17 = "";
        L15:
            r15.append(r17);
            r15.append(" \n");
            r1.append(r15.toString());
        L16:
            String r18 = r1.toString();
            AbsInfoDialogFragment r19 = this.a;
            if ((!StringsKt.isBlank(r18)) == false) goto L20;
            ClipboardCompat.setText(r19.requireContext(), "", r18);
            int r20 = a8.d.a;
            a8.d.a(r19.requireContext(), "复制成功");
            return true;
        L20:
            return false;
        }
    }

    public abstract List<DialogItem> S90();

    public abstract String T90();

    public boolean U90() {
        return this instanceof JsbWhiteListFragment;
    }

    @Override // com.bytedance.android.annie.debug.ui.BaseCommonDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L13;
        r1.setLayout(-1, -1);
        if (U90() == false) goto L9;
        int r10 = 2131954079;
    L10:
        r1.setWindowAnimations(r10);
        return;
    L9:
        r10 = 2131954080;
        goto L10
    L13:
        return;
    }

    public AbsInfoDialogFragment() {
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131558542, r11, false);
        RecyclerView r14 = r13.findViewById(2131384071);
        if (r14 == null) goto L6;
        r14.setLayoutManager(new LinearLayoutManager(getContext()));
        List<DialogItem> r15 = S90();
        this.e = r15;
        r14.setAdapter(new DialogAdapter(r15, getContext()));
    L6:
        if (U90() == false) goto L11;
        View r16 = r13.findViewById(2131363762);
        if (r16 == null) goto L11;
        r16.setVisibility(0);
        r16.setOnClickListener(new a(this));
    L11:
        if (T90().length() <= 0) goto L13;
        boolean r17 = true;
    L14:
        if (r17 == false) goto L18;
        TextView r18 = (TextView) r13.findViewById(2131379478);
        if (r18 == null) goto L18;
        r18.setVisibility(0);
        r18.setText(T90());
        r18.setOnLongClickListener(new b(this));
    L18:
        return r13;
    L13:
        r17 = false;
        goto L14
    }
}
