package xv0;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.deal.d;
import com.bytedance.android.live.recharge.deal.e;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.j;
import com.bytedance.android.live.recharge.platform.core.keyboard.LiveRechargeKeyBoardView;
import com.bytedance.android.live.recharge.viewmodel.CustomRechargeViewModel;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements dx0.a {
    public EditText a;
    public com.bytedance.android.live.recharge.core.b b;
    public final CustomRechargeViewModel c;
    public final RechargeDialogContext d;

    @Override // dx0.a
    public final void onDelete() {
        EditText r0 = this.a;
        if (r0 == null) goto L9;
        int r1 = r0.getSelectionEnd();
        if (r1 > 0) goto L7;
        return;
    L7:
        r0.getText().delete(r1 - 1, r1);
        return;
    }

    @Override // dx0.a
    public final void onDone() {
        EditText r0 = this.a;
        if (r0 == null) goto L25;
        d r2 = null;
        if (TextUtils.isEmpty(r0.getText()) == false) goto L8;
        this.c.getSelectedCustomDeal().postValue(null);
        return;
    L8:
        Editable r1 = r0.getText();
        if (r1 == null) goto L13;
        String r3 = r1.toString();
        if (r3 == null) goto L13;
        long r4 = (long) (CastLongProtector.parseLong(r3) * 100.0f);
    L14:
        RechargeDialogContext r5 = this.d;
        if (r5 == null) goto L23;
        a0 r6 = r5.getRepository();
        if (r6 == null) goto L23;
        PropertyOwner r7 = r6.C;
        if (r7 == null) goto L23;
        i r8 = (i) r7.a;
        if (r8 == null) goto L23;
        r2 = j.a(r8, r4, false, 6);
    L23:
        this.c.getSelectedCustomDeal().postValue(r2);
        return;
    L13:
        r4 = 0;
        goto L14
    }

    @Override // dx0.a
    public final void a() {
        Context r0 = s1.getContext();
        if (r0 == null) goto L5;
        Object r1 = r0.getSystemService("vibrator");
    L6:
        if (r1 == null) goto L10;
        ((Vibrator) r1).vibrate(15);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L5:
        r1 = null;
        goto L6
    }

    @Override // dx0.a
    public final void onInput(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        EditText r0 = this.a;
        if (r0 == null) goto L6;
        int r1 = r0.getSelectionEnd();
        r0.getText().insert(r1, r3);
        return;
    }

    public c(CustomRechargeViewModel r2, RechargeDialogContext r3) {
        Intrinsics.checkNotNullParameter(r2, "mViewModel");
        this.c = r2;
        this.d = r3;
    }

    public final void b(LiveRechargeKeyBoardView r7, EditText r8) {
        if (r7 == null) goto L4;
        r7.setKeyboardListener(this);
    L4:
        this.a = r8;
        if (r8 == null) goto L7;
        r8.requestFocus();
    L7:
        EditText r9 = this.a;
        if (r9 == null) goto L10;
        r9.setLongClickable(false);
    L10:
        int r10 = com.bytedance.android.live.recharge.util.b.a;
        EditText r12 = this.a;
        IBinder r0 = null;
        if (r12 == null) goto L13;
        Context r1 = r12.getContext();
    L14:
        FragmentActivity r2 = ContextUtil.contextToActivity(r1);
        if (r2 == null) goto L40;
        FragmentActivity r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "activity");
        r3.getWindow().setSoftInputMode(3);
        Method r4 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L19
        r4.setAccessible(true);     // Catch: Exception -> L19
        r4.invoke(r12, new Object[]{Boolean.FALSE});     // Catch: Exception -> L19
    L21:
        EditText r13 = this.a;
        if (r13 == null) goto L24;
        Context r14 = r13.getContext();
    L25:
        Activity r15 = ContextUtil.contextToActivity(r14);
        if (r15 == null) goto L28;
        Object r16 = r15.getSystemService("input_method");
    L30:
        if ((r16 instanceof InputMethodManager) == false) goto L35;
        InputMethodManager r17 = (InputMethodManager) r16;
        EditText r5 = this.a;
        if (r5 == null) goto L34;
        r0 = r5.getWindowToken();
    L34:
        r17.hideSoftInputFromWindow(r0, 0);
    L35:
        long r18 = e.b((Iterable) this.c.getCustomChargeDeals().getValue());
        EditText r6 = this.a;
        if (r6 == null) goto L43;
        r6.addTextChangedListener(new b(r6, this, r18));
        return;
    L43:
        return;
    L28:
        r16 = null;
        goto L30
    L24:
        r14 = null;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L13:
        r1 = null;
        goto L14
    }
}
