package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SimpleInputDialogFragment extends DialogFragment {
    public static final /* synthetic */ int p = 0;
    public final a d;
    public boolean e;
    public c f;
    public boolean g;
    public EditText h;
    public View i;
    public View j;
    public boolean k;
    public long l;
    public String m;
    public int n;
    public boolean o;

    public class a implements View.OnLayoutChangeListener {
        public float a;
        public final /* synthetic */ SimpleInputDialogFragment b;

        public a(SimpleInputDialogFragment r1) {
            this.b = r1;
            this.a = -1.0f;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            SimpleInputDialogFragment r10 = this.b;
            if (r10.j != null) goto L6;
            return;
        L6:
            if (this.a >= 0.0f) goto L9;
            Resources r11 = r10.getResources();
            this.a = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).heightPixels * 0.75f;
        L9:
            if (r5 >= this.a) goto L13;
            SimpleInputDialogFragment r12 = this.b;
            if (r12.e == true) goto L30;
            r12.e = true;
            r12.j.setVisibility(0);
            this.b.getClass();
            xs2.b.a().post(new zg1.i1(r9 - r5, true));
            return;
        L30:
            return;
        L13:
            SimpleInputDialogFragment r13 = this.b;
            if (r13.e == false) goto L32;
            r13.e = false;
            r13.j.setVisibility(4);
            this.b.dismiss();     // Catch: Exception -> L19
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L25
            Throwable r14 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L25
            if (r14 == null) goto L23;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L25
        L23:
            this.b.getClass();
            xs2.b.a().post(new zg1.i1(0, false));
            return;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ SimpleInputDialogFragment a;

        public b(SimpleInputDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            SimpleInputDialogFragment r4 = this.a;
            r4.e = false;
            r4.j.setVisibility(4);
            this.a.dismiss();     // Catch: Exception -> L6
        L13:
            goto L10
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L12
            Throwable r5 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L12
            if (r5 == null) goto L13;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L12
        L10:
            this.a.getClass();
            xs2.b.a().post(new zg1.i1(0, false));
        }
    }

    public interface c {
        void h4(String r1);

        void onConfirm(String r1);
    }

    public SimpleInputDialogFragment() {
        this.d = new a(this);
        this.e = false;
        this.f = null;
        this.g = false;
        this.m = null;
        this.n = 0;
        this.o = false;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.j.removeOnLayoutChangeListener(this.d);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.g == false) goto L7;
        this.g = false;
        EditText r0 = this.h;
        if (r0 == null) goto L9;
        r0.postDelayed(new j9(this, 200, 1, 5), 200);
        return;
    L9:
        return;
    L7:
        this.h.postDelayed(new g9(this), this.l);
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L9;
        r4.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (getArguments() == null) goto L6;
        this.m = getArguments().getString("live.intent.extra.HINT", null);
        this.n = getArguments().getInt("live.intent.extra.MAX_LENGTH", 0);
        this.o = getArguments().getBoolean("live.intent.extra.TOUCH_MODAL", false);
        this.k = getArguments().getBoolean("live.intent.extra.IS_BROADCASTER", false);
        this.l = getArguments().getLong("live.intent.extra.DELAY_TIME", 100);
        return;
    }

    public final Dialog onCreateDialog(Bundle r5) {
        Dialog r6 = super.onCreateDialog(r5);
        r6.setCanceledOnTouchOutside(false);
        Window r1 = r6.getWindow();
        if (r1 == null) goto L12;
        r1.setGravity(80);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setSoftInputMode(3);
        if (this.k == true) goto L10;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), true, false) == true) goto L10;
        r1.addFlags(1024);
    L10:
        if (this.o == true) goto L12;
        r1.addFlags(32);
        r1.clearFlags(2);
    L12:
        return r6;
    }

    public final void onDismiss(DialogInterface r2) {
        super.onDismiss(r2);     // Catch: Throwable -> L11
        if (this.f != null) goto L5;
    L9:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        if (this.h.getText() != null) goto L7;
        String r3 = "";
    L8:
        this.f.h4(r3);     // Catch: Throwable -> L11
        this.f = null;     // Catch: Throwable -> L11
        this.e = false;     // Catch: Throwable -> L11
        goto L9
    L7:
        r3 = this.h.getText().toString().trim();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.g = this.e;
    }

    public final void updateInput(String r2) {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        this.h.setText(r2);
        EditText r3 = this.h;
        r3.setSelection(r3.getText().length());
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r1, r2);
        if (getArguments() == null) goto L5;
        updateInput(getArguments().getString("live.intent.extra.INPUT"));
    L5:
        this.h.setOnEditorActionListener(new h9(this));
        this.i.setOnClickListener(new i9(this));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        int r0 = 0;
        View r6 = LayoutInflater.from(getContext()).inflate(2131566088, r4, false);
        this.j = r6;
        r6.addOnLayoutChangeListener(this.d);
        this.h = (EditText) this.j.findViewById(2131368637);
        this.i = this.j.findViewById(2131385911);
        KeyboardShadowView r7 = (KeyboardShadowView) this.j.findViewById(2131392587);
        if (getArguments() == null) goto L5;
        boolean r8 = getArguments().getBoolean("live.intent.extra.TOUCH_OUTSIDE_DISMISS");
    L7:
        if ((!r8) == false) goto L9;
        r7.setActivity(getActivity());
    L10:
        this.h.setHint(this.m);
        if (this.n <= 0) goto L23;
        InputFilter[] r9 = this.h.getFilters();
        if (r9 != null) goto L15;
    L21:
        InputFilter[] r10 = new InputFilter[1];
    L22:
        r10[r10.length - 1] = new InputFilter.LengthFilter(this.n);
        this.h.setFilters(r10);
        goto L23
    L15:
        if (r9.length == 0) goto L21;
        r10 = new InputFilter[r9.length + 1];
    L19:
        if (r0 >= r9.length) goto L22;
        r10[r0] = r9[r0];
        r0 = r0 + 1;
    L23:
        ViewGroup.LayoutParams r11 = this.j.findViewById(2131368638).getLayoutParams();
        Resources r12 = getResources();
        r11.width = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).widthPixels;
        return this.j;
    L9:
        r7.setOnClickListener(new b(this));
        goto L10
    L5:
        r8 = false;
        goto L7
    }

    public static SimpleInputDialogFragment S90(String r3, String r4, int r5, boolean r6) {
        SimpleInputDialogFragment r0 = new SimpleInputDialogFragment();
        Bundle r1 = new Bundle();
        r1.putString("live.intent.extra.INPUT", r3);
        r1.putString("live.intent.extra.HINT", r4);
        r1.putInt("live.intent.extra.MAX_LENGTH", r5);
        r1.putBoolean("live.intent.extra.TOUCH_MODAL", false);
        r1.putBoolean("live.intent.extra.IS_BROADCASTER", r6);
        r1.putLong("live.intent.extra.DELAY_TIME", 100);
        r0.setArguments(r1);
        return r0;
    }
}
