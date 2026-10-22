package com.bytedance.android.livesdk.dislike.recommendlive;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.annie.util.i;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.utils.x0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/recommendlive/RecommendReasonInputDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendReasonInputDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int g = 0;
    public boolean d;
    public Function2<? super Boolean, ? super String, Unit> e;
    public boolean f;

    public static final class a {
    }

    public static final class b extends InputFilter.LengthFilter {
        public b() {
            super(50);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            CharSequence r7 = super.filter(r1, r2, r3, r4, r5, r6);
            if (r7 != null) goto L5;
        L7:
            return r7;
        L5:
            if (r7.length() >= (r3 - r2)) goto L7;
            f2.c("最多输入50字", 0);
            goto L7
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ Function0 a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
            this.a.invoke();
        }
    }

    static {
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setSoftInputMode(16);
        return;
    L9:
        return;
    }

    public RecommendReasonInputDialogFragment() {
    }

    public final void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        Dialog r2 = getDialog();
        if (r2 == null) goto L8;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L9;
        i.d(r3);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
        setNoTitleAndCancelOutside(true);
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r3);     // Catch: Throwable -> L9
        if (this.f == true) goto L7;
        Function2<? super Boolean, ? super String, Unit> r4 = this.e;     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        Unit r5 = (Unit) r4.invoke(Boolean.FALSE, null);     // Catch: Throwable -> L9
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        final EditText r7 = (EditText) r5.findViewById(2131371808);
        final TextView r0 = (TextView) r5.findViewById(2131364828);
        View r8 = r5.findViewById(2131364679);
        r7.setFilters(new b[]{new b()});
        Function0<Unit> r1 = new RecommendReasonInputDialogFragment$onViewCreated$updateSendButtonState$1(r0, r7);
        r7.addTextChangedListener(new c(r1));
        r1.invoke();
        r0.setOnClickListener(x0.a(new AnonymousClass3(this, r7)));
        if (r8 == null) goto L6;
        r8.setOnClickListener(x0.a(new AnonymousClass4(this)));
    L6:
        if (this.d == false) goto L11;
        String r9 = mm0.a.getValue().getFirstRecommendSuccessToast();
        if (r9 == null) goto L12;
        f2.c(r9, 0);
        return;
    L12:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565723, r3, false);
    }
}
