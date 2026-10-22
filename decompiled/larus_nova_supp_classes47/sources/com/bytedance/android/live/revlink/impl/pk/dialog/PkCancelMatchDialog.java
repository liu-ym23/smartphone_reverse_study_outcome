package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkCancelMatchDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkCancelMatchDialog extends LiveDialogFragment {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> d;
    public final IRoom e;
    public final com.bytedance.android.live.revenuelink.connect.f f;
    public final com.bytedance.android.live.revenuelink.connect.n g;
    public final a h;

    public static final class a extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ PkCancelMatchDialog a;

        public a(PkCancelMatchDialog r1) {
            this.a = r1;
        }

        public static void a(Dialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void q9(d11.c r1, long r2, ey.l r4) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            Dialog r3 = this.a.getDialog();
            if (r3 == null) goto L6;
            a(r3);
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void wh(d11.c r1, Throwable r2, long r3, ey.l r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            Dialog r4 = this.a.getDialog();
            if (r4 == null) goto L6;
            a(r4);
            return;
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkCancelMatchDialog a;

        public b(PkCancelMatchDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkCancelMatchDialog r4 = this.a;
            int r0 = PkCancelMatchDialog.i;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L18;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L9;
            View r6 = r5.getCurrentFocus();
        L10:
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L15;
            return;
        L15:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L9:
            r6 = null;
            goto L10
        L21:
            return;
        }
    }

    public PkCancelMatchDialog() {
        this.d = new LinkedHashMap();
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        com.bytedance.android.live.revenuelink.connect.n r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = r0.getRoom();
    L6:
        this.e = r2;
        this.f = com.bytedance.android.live.revlink.impl.global.b.a();
        com.bytedance.android.live.revlink.impl.pk.service.b r3 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r3 == null) goto L9;
        r1 = r3.getLinkOutManagerFn();
    L9:
        this.g = r1;
        this.h = new a(this);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        com.bytedance.android.live.revenuelink.connect.f r0 = this.f;
        if (r0 == null) goto L6;
        r0.removeLinkOutListener(1, this.h);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    L14:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(1, 2131954719);
        com.bytedance.android.live.revenuelink.connect.f r0 = this.f;
        if (r0 == null) goto L6;
        r0.addLinkOutListener(1, this.h);
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public static final void T90(PkCancelMatchDialog r2, String r3) {
        r2.getClass();
        HashMap r4 = new HashMap();
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L7;
        IRoom r1 = r0.k();
        if (r1 == null) goto L7;
        r4.put("invitee_id", String.valueOf(iz.a.a(r1.getOwner())));
    L7:
        r4.put("selection", r3);
        IPKLinkBizDataService r5 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r5 != null) goto L10;
    L12:
        r4.put("invite_mode", "routine_pk");
    L13:
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r7.putAll(r4);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r9 = r6.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_best_invite_recom_matching_selection", r6.a, r6.b);
        return;
    L10:
        if (r5.getIsInviteVote() != true) goto L12;
        r4.put("invite_mode", "vote");
        goto L13
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LinkCrossRoomDataHolder r4 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r4 != null) goto L5;
    L11:
        ((TextView) S90(2131388772)).setText(2131921391);
    L12:
        ((ImageView) S90(2131389502)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.a(this));
        ((Button) S90(2131389542)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.b(this));
        ((Button) S90(2131389494)).setOnClickListener(new c(this));
        return;
    L5:
        if (r4.i() != 0) goto L11;
        ((TextView) S90(2131388772)).setText(2131921388);
        IPKLinkBizDataService r5 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r5 == null) goto L12;
        if (r5.getIsInviteVote() != true) goto L12;
        ((TextView) S90(2131388772)).setText(s1.B(2131917506));
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565694, r3, false);
    }
}
