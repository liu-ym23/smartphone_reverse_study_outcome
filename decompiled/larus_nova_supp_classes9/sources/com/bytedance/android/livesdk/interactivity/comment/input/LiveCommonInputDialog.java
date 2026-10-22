package com.bytedance.android.livesdk.interactivity.comment.input;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.InputPanelLayout;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.PanelType;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.t2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/LiveCommonInputDialog;", "Landroidx/fragment/app/DialogFragment;", "Lt22/c;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonInputDialog extends DialogFragment implements t22.c {
    public static final int p = 0;
    public CommonInputParams d;
    public EditText e;
    public MeasureLinearLayout f;
    public InputPanelLayout g;
    public ImageView h;
    public View i;
    public com.bytedance.android.livesdk.interactivity.comment.utils.j j;
    public t22.d k;
    public final List<TextWatcher> l;
    public final j m;
    public final b n;
    public final d o;

    public static final class a {
    }

    public static final class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ LiveCommonInputDialog a;

        public b(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L15;
            Editable r4 = LiveCommonInputDialog.S90(this.a).getText();
            if (r4 != null) goto L7;
        L10:
            boolean r5 = true;
        L11:
            if (r5 == false) goto L13;
            return false;
        L13:
            LiveCommonInputDialog.T90(this.a);
            return true;
        L7:
            if (StringsKt.isBlank(r4) == true) goto L10;
            r5 = false;
            goto L11
        L15:
            return false;
        }
    }

    public static final class c implements v62.a.InterfaceC0287a {
        public final /* synthetic */ LiveCommonInputDialog a;

        @Override // v62.a.InterfaceC0287a
        public final void a() {
            KeyEvent r0 = new KeyEvent(0, 67);
            LiveCommonInputDialog.S90(this.a).dispatchKeyEvent(r0);
        }

        @Override // v62.a.InterfaceC0287a
        public final void dismissDialog() {
            LiveCommonInputDialog r0 = this.a;
            int r1 = LiveCommonInputDialog.p;
            r0.dismissDialog();
        }

        public c(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // v62.a.InterfaceC0287a
        public final void c(BaseEmoji r4, String r5) {
            if (r4 != null) goto L4;
            return;
        L4:
            com.bytedance.android.livesdk.interactivity.comment.utils.j r6 = this.a.j;
            if (r6 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("inputSizeChecker");
        L7:
            int r7 = r6.b + 1;
            LiveCommonInputDialog r1 = this.a;
            int r2 = r1.d.e;
            if (r7 <= r2) goto L11;
            f2.c(r1.getString(2131917443, new Object[]{Integer.valueOf(r2)}), 1);
            return;
        L11:
            if (TextUtils.isEmpty(r4.getDescription()) == false) goto L13;
            return;
        L13:
            LiveCommonInputDialog.S90(this.a).getText().insert(LiveCommonInputDialog.S90(this.a).getSelectionStart(), ab2.a.f(r4.getDescription(), LiveCommonInputDialog.p));
        }
    }

    public static final class d extends d2 {
        public final /* synthetic */ LiveCommonInputDialog a;

        public d(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        public final void afterTextChanged(Editable r3) {
            Iterator<T> r0 = this.a.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((TextWatcher) r0.next()).afterTextChanged(r3);
            goto L4
        }

        public final void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
            Iterator<T> r0 = this.a.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((TextWatcher) r0.next()).beforeTextChanged(r3, r4, r5, r6);
            goto L4
        }

        public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            Iterator<T> r0 = this.a.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((TextWatcher) r0.next()).onTextChanged(r3, r4, r5, r6);
            goto L4
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ LiveCommonInputDialog a;

        public e(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveCommonInputDialog.S90(this.a).requestFocus();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnFocusChangeListener {
        public final /* synthetic */ LiveCommonInputDialog a;

        public static final class a implements Runnable {
            public final /* synthetic */ f a;

            public a(f r1) {
                this.a = r1;
            }

            public final void a() {
                if (this.a.a.isAdded() == true) goto L6;
                return;
            L6:
                if (this.a.a.getActivity() == null) goto L12;
                FragmentActivity r0 = this.a.a.getActivity();
                if (r0 == null) goto L12;
                Window r1 = r0.getWindow();
                if (r1 == null) goto L12;
                r1.setSoftInputMode(48);
            L12:
                t2.b(this.a.a.getContext(), LiveCommonInputDialog.S90(this.a.a));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            r3.postDelayed(new a(this), 100);
            LiveCommonInputDialog.S90(this.a).setOnFocusChangeListener(null);
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ LiveCommonInputDialog a;

        public g(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveCommonInputDialog.S90(this.a).setSelection(this.a.d.d.length());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ LiveCommonInputDialog a;

        public h(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveCommonInputDialog r3 = this.a;
            int r0 = LiveCommonInputDialog.p;
            r3.dismissDialog();
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ LiveCommonInputDialog a;

        public i(LiveCommonInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            InputPanelLayout r4 = this.a.g;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L5:
            PanelType r5 = r4.getCurrentPanelType();
            PanelType r1 = PanelType.EMOJI;
            if (r5 != r1) goto L11;
            InputPanelLayout r6 = this.a.g;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L10:
            r6.b(PanelType.KEYBOARD, LiveCommonInputDialog.S90(this.a));
            return;
        L11:
            InputPanelLayout r7 = this.a.g;
            if (r7 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L14:
            r7.b(r1, LiveCommonInputDialog.S90(this.a));
        }
    }

    public static final class j extends u62.b {
        public final /* synthetic */ LiveCommonInputDialog b;

        @Override // u62.b
        public final void b() {
        }

        @Override // u62.b
        public final int d() {
            InputPanelLayout r0 = this.b.g;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L6:
            if (r0.getKeyboardHeight() == 0) goto L8;
            InputPanelLayout r1 = this.b.g;
            if (r1 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
        L16:
            return r1.getKeyboardHeight();
        L8:
            if (f() == false) goto L10;
            Integer r2 = (Integer) l42.a.k.getValue();
        L17:
            return r2.intValue();
        L10:
            r2 = (Integer) l42.a.l.getValue();
            goto L17
        }

        @Override // u62.b
        public final void e() {
            LiveCommonInputDialog.T90(this.b);
        }

        public final boolean f() {
            return this.b.d.a;
        }

        @Override // u62.b
        public Activity getActivity() {
            return this.b.getActivity();
        }

        public final void g(v62.c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ((ArrayList) this.b.l).add(r2);
        }

        public j(LiveCommonInputDialog r1, c r2) {
            this.b = r1;
            super(r2);
        }
    }

    static {
        p = s1.f(18.0f);
    }

    public final void dismissDialog() {
        InputPanelLayout r0 = this.g;     // Catch: Exception -> L16
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");     // Catch: Exception -> L16
    L5:
        PanelType r1 = PanelType.NONE;     // Catch: Exception -> L16
        EditText r2 = this.e;     // Catch: Exception -> L16
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");     // Catch: Exception -> L16
    L8:
        r0.b(r1, r2);     // Catch: Exception -> L16
        dismissAllowingStateLoss();     // Catch: Exception -> L11
    L24:
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L16
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L16
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L16
        return;
    L23:
        return;
    L16:
        e = move-exception;
        i40.h.a("dismiss input dialog exception: " + e.getMessage());
    }

    public LiveCommonInputDialog() {
        this.d = new CommonInputParams(false, false, null, null, 31, 0);
        this.l = new ArrayList();
        this.m = new j(this, new c(this));
        this.n = new b(this);
        this.o = new d(this);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        MeasureLinearLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        i40.b r1 = r0.getKeyBoardObservable();
        InputPanelLayout r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L8:
        r1.b(r2);
        i40.h.a("registerKeyboardListener with keyBoardObservable");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        MeasureLinearLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        i40.b r1 = r0.getKeyBoardObservable();
        InputPanelLayout r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L8:
        r1.b(r2);
        i40.h.a("registerKeyboardListener with keyBoardObservable");
        EditText r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L11:
        r3.post(new e(this));
        EditText r4 = this.e;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L14:
        r4.setOnFocusChangeListener(new f(this));
    }

    public static final /* synthetic */ EditText S90(LiveCommonInputDialog r1) {
        EditText r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        return r2;
    }

    public static final void T90(LiveCommonInputDialog r2) {
        EditText r0 = r2.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        String r1 = r0.getText().toString();
        if (r1 == null) goto L13;
        String r3 = StringsKt.trim(r1).toString();
        t22.d r4 = r2.k;
        if (r4 == null) goto L10;
        r4.a(r3);
    L10:
        r2.dismissDialog();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
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

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        setStyle(1, 2131954667);
        Bundle r9 = getArguments();
        if (r9 == null) goto L9;
        CommonInputParams r10 = (CommonInputParams) r9.getParcelable("common_input_params");
        if (r10 != null) goto L7;
        r10 = new CommonInputParams(false, false, null, null, 31, 0);
    L7:
        this.d = r10;
        return;
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        r5.setCanceledOnTouchOutside(false);
        Window r1 = r5.getWindow();
        if (r1 == null) goto L5;
        r1.setGravity(80);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setSoftInputMode(19);
        r1.addFlags(32);
        r1.clearFlags(2);
    L5:
        return r5;
    }

    public final void onDismiss(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.f.d().c = false;     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.f.d().f();     // Catch: Throwable -> L5
        xs2.b.a().post(new i1(0, false));     // Catch: Throwable -> L5
        super.onDismiss(r4);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        EditText r7 = this.e;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        r7.addTextChangedListener(this.o);
        EditText r8 = this.e;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L8:
        r8.setOnEditorActionListener(this.n);
        EditText r9 = this.e;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L11:
        r9.setHint(this.d.c);
        if (this.d.d.length() <= 0) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L23;
        EditText r11 = this.e;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L19:
        r11.setText(this.d.d);
        EditText r13 = this.e;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L22:
        r13.post(new g(this));
    L23:
        EditText r14 = this.e;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L26:
        r14.setImeOptions(268435460);
        EditText r15 = this.e;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L29:
        r15.setInputType(1);
        this.f = r5.findViewById(2131384840);
        View r16 = this.i;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L32:
        r16.setOnClickListener(new h(this));
        ImageView r17 = this.h;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L35:
        r17.setOnClickListener(new i(this));
        HashSet r18 = new HashSet();
        r18.add(PanelType.EMOJI);
        r18.add(PanelType.KEYBOARD);
        InputPanelLayout r19 = this.g;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L38:
        r19.setPanelLayoutName("BottomPanelLayout");
        InputPanelLayout r20 = this.g;
        if (r20 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L41:
        r20.setSupportPanels(r18);
        InputPanelLayout r21 = this.g;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L44:
        r21.setIsPortrait(this.d.a);
        InputPanelLayout r23 = this.g;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L47:
        j r24 = this.m;
        v62.a r1 = new v62.a();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "panelBridge");
        Intrinsics.checkNotNullParameter(r1, "panelProvider");
        PanelType r2 = r1.a;
        if (r23.g.contains(r2) == true) goto L51;
    L57:
        InputPanelLayout r25 = this.g;
        if (r25 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L60:
        com.bytedance.android.livesdk.interactivity.comment.input.f r26 = new com.bytedance.android.livesdk.interactivity.comment.input.f(this);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "onPanelSwitchListener");
        r25.f.add(r26);
        return;
    L51:
        if (r23.d.get(r2) != null) goto L57;
        View r27 = r1.d(r24);
        if (r27 == null) goto L57;
        r23.e.put(r2, r1);
        r23.d.put(r2, r27);
        r23.addView(r27);
        r27.setVisibility(8);
        goto L57
    L14:
        r10 = false;
        goto L15
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        com.bytedance.android.livesdk.f.d().c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "common input dialog show");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r3, r4);
        goto L7
    }

    public final void show(Activity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "tag");
        FragmentManager r4 = ((FragmentActivity) r2).getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r4, r3);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = LayoutInflater.from(getContext()).inflate(2131565434, r3, false);
        this.e = (EditText) r5.findViewById(2131371815);
        this.g = (InputPanelLayout) r5.findViewById(2131364474);
        this.h = (ImageView) r5.findViewById(2131374799);
        this.i = r5.findViewById(2131371607);
        EditText r6 = this.e;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
    L5:
        this.j = new com.bytedance.android.livesdk.interactivity.comment.utils.j(r6, this.d);
        return r5;
    }
}
