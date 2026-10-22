package com.bytedance.android.livesdk.interactivity.publicscreen.panel.view;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.f;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/view/PSAudienceOperateSubPanelDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/v;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSAudienceOperateSubPanelDialog extends LiveDialogFragment implements View.OnClickListener, v {
    public static final /* synthetic */ int i = 0;
    public List<? extends k> d;
    public LinearLayout e;
    public TextView f;
    public t g;
    public f h;

    public static final class a {
    }

    static {
    }

    public PSAudienceOperateSubPanelDialog() {
        this.d = new ArrayList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LinearLayout r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.h = null;
        Iterator<T> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((k) r1.next()).onDestroyView();
        goto L7
    L9:
        this.g = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v
    public final void l20(boolean r2) {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L11;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
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
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954772);
        super.onCreate(r3);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        f r3 = this.h;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r14 = r10.inflate(2131567216, r11, false);
        this.f = (TextView) r14.findViewById(2131388414);
        t r15 = this.g;
        if ((r15 instanceof h0) == true) goto L5;
        r15 = null;
    L5:
        h0 r16 = (h0) r15;
        if (r16 == null) goto L12;
        String r17 = r16.getChatContent();
        if (r17 == null) goto L12;
        float r18 = UtilityKotlinExtentionsKt.h(14);
        SpannableString r1 = new SpannableString(r17);
        ab2.a.e(r1, (int) r18);
        TextView r19 = this.f;
        if (r19 == null) goto L12;
        r19.setText(r1);
    L12:
        this.e = (LinearLayout) r14.findViewById(2131375813);
        int r110 = this.d.size();
        int r111 = this.d.size();
        int r2 = 0;
    L13:
        if (r2 >= r111) goto L25;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, s1.j(2131168491));
        r3.weight = 1.0f;
        LinearLayout r4 = this.e;
        if (r4 == null) goto L18;
        r4.addView(((k) ListProtector.get(this.d, r2)).getView(getContext()), r3);
    L18:
        if (r110 <= 1) goto L24;
        if (r2 >= (r110 - 1)) goto L24;
        LinearLayout r5 = this.e;
        if (r5 == null) goto L24;
        TextView r6 = new TextView(getContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.j(2131168490)));
        r6.setBackgroundColor(0);
        Unit r7 = Unit.INSTANCE;
        r5.addView(r6);
    L24:
        r2 = r2 + 1;
        goto L13
    L25:
        Iterator<T> r112 = this.d.iterator();
    L27:
        if (r112.hasNext() == false) goto L34;
        k r113 = (k) r112.next();
        View r0 = r113.getView(getContext());
        if (r0 == null) goto L31;
        r0.setOnClickListener(this);
    L31:
        t r8 = this.g;
        if (r8 == null) goto L27;
        r113.b(r8, this);
        goto L27
    L34:
        List<? extends k> r114 = this.d;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r115 = r114.iterator();
    L36:
        if (r115.hasNext() == false) goto L38;
        r9.add(Long.valueOf(((k) r115.next()).a().getId()));
        goto L36
    L38:
        String r116 = CollectionsKt.joinToString$default(r9, "|", null, null, 0, null, null, 62, null);
        int r117 = g.a;
        Map r118 = g.a(this.g);
        t r20 = this.g;
        if (r20 == null) goto L42;
        String r21 = String.valueOf(r20.getMessageId());
        if (r21 == null) goto L42;
    L43:
        g.c(r21, "secondary", r116, r118);
        return r14;
    L42:
        r21 = BuildConfig.FLAVOR;
        goto L43
    }
}
