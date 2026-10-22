package com.larus.account.saas.ui.alert;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.saas.ui.AccountCommonAlertAction;
import com.larus.account.saas.ui.AccountCommonAlertData;
import com.larus.account.saas.ui.databinding.AccountSaasDialogCommonAlertVerticalBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/ui/alert/AccountCommonAlertDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class AccountCommonAlertDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public AccountCommonAlertData d;
    public boolean e;
    public Function1<? super AccountCommonAlertAction, Unit> f;
    public Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setBackgroundDrawable(ContextCompat.getDrawable(r1.getContext(), 2131231205));
        r1.setDimAmount(0.3f);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = getResources();
        r2.width = (int) (((double) WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels) * 0.7d);
        r2.height = -2;
        r1.setAttributes(r2);
        return;
    L9:
        return;
    }

    public AccountCommonAlertDialog() {
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        Function0<Unit> r3 = this.g;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        AccountCommonAlertData r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("key_data");
    L7:
        if ((r5 instanceof AccountCommonAlertData) == false) goto L9;
        r0 = (AccountCommonAlertData) r5;
    L9:
        this.d = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    public static void T90(TextView r1, String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r1.setVisibility(8);
        return;
    L10:
        r1.setText(r2);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void S90(TextView r5, final AccountCommonAlertAction r6) {
        r5.setText(r6.getTitle());
        Context r0 = r5.getContext();
        Integer r1 = r6.getStyle();
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L13:
        int r2 = 2131100119;
    L14:
        r5.setTextColor(ContextCompat.getColor(r0, r2));
        r5.setOnClickListener(new g48.a(this, r6));
        return;
    L11:
        if (r1.intValue() != 2) goto L13;
        r2 = 2131100125;
        goto L14
    L6:
        if (r1.intValue() != 1) goto L8;
        r2 = 2131100118;
        goto L14
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        AccountCommonAlertData r12 = this.d;
        if (r12 != null) goto L5;
        r12 = new AccountCommonAlertData(null, null, null, 7, null);
    L5:
        int r2 = 2131368971;
        if (r12.getActions().size() != 2) goto L21;
        View r13 = r9.inflate(2131558435, r10, false);
        TextView r0 = (TextView) ViewBindings.findChildViewById(r13, 2131364749);
        if (r0 == null) goto L18;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r13, 2131364818);
        if (r3 == null) goto L17;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r13, 2131368971);
        if (r14 == null) goto L20;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131368982);
        if (r4 == null) goto L16;
        LinearLayout r15 = (LinearLayout) r13;
        T90(r4, r12.getTitle());
        T90(r14, r12.getDescription());
        S90(r0, (AccountCommonAlertAction) ListProtector.get(r12.getActions(), 0));
        S90(r3, (AccountCommonAlertAction) ListProtector.get(r12.getActions(), 1));
        return r15;
    L16:
        r2 = 2131368982;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r2)));
    L17:
        r2 = 2131364818;
        goto L20
    L18:
        r2 = 2131364749;
        goto L20
    L21:
        View r16 = r9.inflate(2131558436, r10, false);
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131364692);
        if (r1 == null) goto L44;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r16, 2131368971);
        if (r17 == null) goto L46;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r16, 2131368982);
        if (r5 == null) goto L43;
        AccountSaasDialogCommonAlertVerticalBinding r6 = new AccountSaasDialogCommonAlertVerticalBinding((LinearLayout) r16, r1, r17, r5);
        T90(r5, r12.getTitle());
        T90(r17, r12.getDescription());
        Iterator<T> r19 = r12.getActions().iterator();
        int r110 = 0;
    L29:
        if (r19.hasNext() == false) goto L42;
        Object r7 = r19.next();
        int r8 = r110 + 1;
        if (r110 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        AccountCommonAlertAction r20 = (AccountCommonAlertAction) r7;
        TextView r21 = new TextView(requireContext());
        r21.setLayoutParams(new ViewGroup.LayoutParams(-1, r21.getResources().getDimensionPixelSize(2131165289)));
        r21.setGravity(17);
        r21.setTextSize(0, r21.getResources().getDimension(2131165275));
        r21.setTypeface(Typeface.create("sans-serif-medium", 0));
        if (r110 != CollectionsKt.getLastIndex(r12.getActions())) goto L36;
        int r22 = 2131231198;
    L37:
        r21.setBackgroundResource(r22);
        S90(r21, r20);
        r6.b.addView(r21);
        if (r110 == CollectionsKt.getLastIndex(r12.getActions())) goto L40;
        LinearLayout r111 = r6.b;
        View r23 = new View(requireContext());
        r23.setLayoutParams(new ViewGroup.LayoutParams(-1, r23.getResources().getDimensionPixelSize(2131165270)));
        r23.setBackgroundResource(2131231210);
        r111.addView(r23);
    L40:
        r110 = r8;
        goto L29
    L36:
        r22 = 2131231202;
        goto L37
    L42:
        return r6.a;
    L43:
        r2 = 2131368982;
    L46:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r2)));
    L44:
        r2 = 2131364692;
        goto L46
    }
}
