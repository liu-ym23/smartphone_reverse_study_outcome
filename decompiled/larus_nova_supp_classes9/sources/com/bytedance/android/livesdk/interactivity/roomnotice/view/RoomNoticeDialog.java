package com.bytedance.android.livesdk.interactivity.roomnotice.view;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ya2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeDialog;", "Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeBaseDialog;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomNoticeDialog extends RoomNoticeBaseDialog {
    public static String h;
    public static String i;
    public static final a j = null;
    public Map<Integer, View> g;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final String U90() {
        return BuildConfig.FLAVOR;
    }

    static {
        j = new a();
        h = BuildConfig.FLAVOR;
        i = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void S90() {
        this.g.clear();
    }

    public RoomNoticeDialog() {
        this.g = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final View T90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.getAttributes().softInputMode = 16;
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, (TextView) T90(2131381017)) == false) goto L13;
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L34;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L34:
        return;
    L13:
        if (Intrinsics.areEqual(r4, (TextView) T90(2131381024)) == false) goto L22;
        b.b(h, i);
        getDialog();
        dismiss();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L43;
        d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L43:
        return;
    L22:
        if (Intrinsics.areEqual(r4, (TextView) T90(2131381029)) == true) goto L24;
        return;
    L24:
        if ((getContext() instanceof FragmentActivity) == false) goto L46;
        RoomNoticeTipDialog.a r7 = RoomNoticeTipDialog.e;
        FragmentActivity r0 = getContext();
        if (r0 == null) goto L33;
        FragmentActivity r1 = r0;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "activity");
        RoomNoticeTipDialog r8 = new RoomNoticeTipDialog();
        FragmentManager r2 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "RoomNoticeTipDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r8, r3) == true) goto L50;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L31:
        r8.show(r2, "RoomNoticeTipDialog");
        return;
    L50:
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
        RoomNoticeTipDialog.e.getClass();
        RoomNoticeTipDialog.a.a().subscribe();
        b.a(h, i);
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((TextView) T90(2131381024)).setText("保存");
        ((TextView) T90(2131381029)).setVisibility(0);
        ((TextView) T90(2131381029)).setOnClickListener(this);
        b.a(h, i);
    }
}
