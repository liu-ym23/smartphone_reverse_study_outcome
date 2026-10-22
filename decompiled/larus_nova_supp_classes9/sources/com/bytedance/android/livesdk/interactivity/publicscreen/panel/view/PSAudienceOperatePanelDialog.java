package com.bytedance.android.livesdk.interactivity.publicscreen.panel.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/view/PSAudienceOperatePanelDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/v;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSAudienceOperatePanelDialog extends DialogFragment implements View.OnClickListener, v {
    public static final /* synthetic */ int m = 0;
    public List<? extends k> d;
    public t e;
    public boolean f;
    public final b g;
    public LinearLayout h;
    public ImageView i;
    public View j;
    public final int k;
    public e l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PSAudienceOperatePanelDialog a;

        public b(PSAudienceOperatePanelDialog r1) {
            this.a = r1;
        }

        public final void a() {
            View r0 = this.a.j;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isAttachedToWindow() != true) goto L30;
            int[] r1 = new int[2];
            View r2 = this.a.j;
            if (r2 == null) goto L9;
            r2.getLocationOnScreen(r1);
        L9:
            View r3 = this.a.j;
            if (r3 == null) goto L12;
            int r4 = r3.getWidth();
        L13:
            if (r4 == 0) goto L27;
        L21:
            Dialog r5 = this.a.getDialog();
            if (r5 == null) goto L31;
            Window r6 = r5.getWindow();
            if (r6 == null) goto L32;
            WindowManager.LayoutParams r7 = r6.getAttributes();
            r7.y = ((r1[1] - s1.j(2131168494)) - s1.j(2131168493)) - s1.j(2131168488);
            r6.setAttributes(r7);
            return;
        L32:
            return;
        L31:
            return;
        L27:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L17
        L17:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L21;
            d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L21
        L12:
            r4 = 0;
            goto L13
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

    static {
    }

    public PSAudienceOperatePanelDialog() {
        this.d = new ArrayList();
        this.g = new b(this);
        this.k = UtilityKotlinExtentionsKt.i(12);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        MainThreadPostUtils.d(this.g);
        LinearLayout r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        Iterator<T> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((k) r1.next()).onDestroyView();
        goto L7
    L9:
        this.e = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        S90(this);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        int[] r0 = new int[2];
        View r1 = this.j;
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r0);
    L5:
        View r2 = this.j;
        if (r2 == null) goto L8;
        int r3 = r2.getWidth();
    L9:
        if (r3 != 0) goto L11;
        S90(this);
    L11:
        MainThreadPostUtils.c(this.g, 200);
        Dialog r4 = getDialog();
        if (r4 == null) goto L16;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L16;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        r6.gravity = 51;
        r6.width = -2;
        r6.height = -2;
        r6.x = this.k;
        r6.y = ((r0[1] - s1.j(2131168494)) - s1.j(2131168493)) - s1.j(2131168488);
        r5.setAttributes(r6);
    L16:
        int r7 = Math.max((int) ((r3 - s1.j(2131168495)) * 0.5f), this.k);
        ImageView r8 = this.i;
        if (r8 == null) goto L19;
        a1.m(r8, r7);
    L19:
        List<? extends k> r9 = this.d;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L21:
        if (r11.hasNext() == false) goto L23;
        r10.add(Long.valueOf(((k) r11.next()).a().getId()));
        goto L21
    L23:
        String r13 = CollectionsKt.joinToString$default(r10, "|", null, null, 0, null, null, 62, null);
        int r14 = g.a;
        Map r15 = g.a(this.e);
        t r16 = this.e;
        if (r16 == null) goto L27;
        String r17 = String.valueOf(r16.getMessageId());
        if (r17 == null) goto L27;
    L28:
        g.c(r17, "main", r13, r15);
        return;
    L27:
        r17 = BuildConfig.FLAVOR;
        goto L28
    L8:
        r3 = 0;
        goto L9
    }

    public static void S90(PSAudienceOperatePanelDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v
    public final void l20(boolean r1) {
        this.f = r1;
        S90(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        k r1 = (k) r0.next();
        if (r5 == null) goto L8;
        Object r2 = r5.getTag();
    L10:
        if (r2 != r1.a()) goto L4;
        r1.onClick(r5);
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        S90(this);
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954771);
        super.onCreate(r3);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L8
        super.onDismiss(r2);     // Catch: Throwable -> L8
        e r3 = this.l;     // Catch: Throwable -> L8
        if (r3 == null) goto L5;
        r3.a(this.f);     // Catch: Throwable -> L8
    L5:
        this.l = null;     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        int r0 = 0;
        View r8 = r5.inflate(2131565168, r6, false);
        this.h = (LinearLayout) r8.findViewById(2131375718);
        this.i = (ImageView) r8.findViewById(2131389384);
        int r9 = this.d.size();
    L3:
        if (r0 >= r9) goto L8;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(s1.j(2131168489), s1.j(2131168488));
        r10.gravity = 17;
        LinearLayout r1 = this.h;
        if (r1 == null) goto L7;
        r1.addView(((k) ListProtector.get(this.d, r0)).getView(getContext()), r10);
    L7:
        r0 = r0 + 1;
        goto L3
    L8:
        Iterator<T> r11 = this.d.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        k r13 = (k) r11.next();
        View r2 = r13.getView(getContext());
        if (r2 == null) goto L14;
        r2.setOnClickListener(this);
    L14:
        t r3 = this.e;
        if (r3 == null) goto L10;
        r13.b(r3, this);
        goto L10
    L17:
        return r8;
    }
}
