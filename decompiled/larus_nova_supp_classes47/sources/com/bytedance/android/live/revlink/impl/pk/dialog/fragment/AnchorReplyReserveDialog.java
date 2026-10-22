package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/AnchorReplyReserveDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorReplyReserveDialog extends CommonBottomDialog {
    public final CompositeDisposable a;
    public final o b;
    public String c;
    public final Function1<Boolean, Unit> d;
    public final Function1<Integer, Unit> e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorReplyReserveDialog a;

        public b(AnchorReplyReserveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Function1<Integer, Unit> r3 = this.a.e;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke(0);
        L5:
            AnchorReplyReserveDialog.M0(this.a, 1);
            AnchorReplyReserveDialog.N0(this.a, "accept");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AnchorReplyReserveDialog a;

        public c(AnchorReplyReserveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Function1<Integer, Unit> r3 = this.a.e;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke(1);
        L5:
            AnchorReplyReserveDialog.M0(this.a, 2);
            AnchorReplyReserveDialog.N0(this.a, "reject");
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorReplyReserveDialog a;

        public d(AnchorReplyReserveDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Function1<Boolean, Unit> r3 = this.a.d;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke(Boolean.FALSE);
        L5:
            AnchorReplyReserveDialog.N0(this.a, "cancel");
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566061;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        this.a.dispose();
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setCanceledOnTouchOutside(false);
        TextView r0 = (TextView) findViewById(2131391606);
        if (r0 != null) goto L5;
    L12:
        View r6 = findViewById(2131390090);
        if (r6 == null) goto L15;
        r6.setOnClickListener(new b(this));
    L15:
        View r7 = findViewById(2131391268);
        if (r7 == null) goto L18;
        r7.setOnClickListener(new c(this));
    L18:
        View r8 = findViewById(2131390273);
        if (r8 == null) goto L21;
        r8.setOnClickListener(new d(this));
    L21:
        O0("livesdk_pk_invited_popup_show", new LinkedHashMap());
        return;
    L5:
        if (this.c.length() <= 6) goto L11;
        StringBuilder r1 = new StringBuilder();
        String r3 = this.c;
        if (r3 == null) goto L10;
        r1.append(r3.substring(0, 6));
        r1.append("...");
        this.c = r1.toString();
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        int r4 = w11.a.a;
        r0.setText(com.bytedance.live.kmp.util.c.a(2131921537, new Object[]{this.c}));
        goto L12
    }

    public static final void M0(AnchorReplyReserveDialog r12, int r13) {
        r12.getClass();
        r31.a r1 = r31.b.a(r31.a.a);
        o r0 = r12.b;
        Observable<ExtraResponse<Object, Extra>> r14 = r1.F(r13, r0.a, r0.b, r0.c, r0.d, r0.f, r0.g);
        if (r14 == null) goto L7;
        Disposable r15 = r14.subscribe(new com.bytedance.android.live.revlink.impl.pk.dialog.fragment.a(r12), com.bytedance.android.live.revlink.impl.pk.dialog.fragment.b.a);
        if (r15 == null) goto L7;
        r12.a.add(r15);
    L7:
        Function1<Boolean, Unit> r16 = r12.d;
        if (r16 == null) goto L11;
        Unit r17 = (Unit) r16.invoke(Boolean.FALSE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N0(AnchorReplyReserveDialog r2, String r3) {
        r2.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("selection", r3);
        r2.O0("livesdk_pk_invited_popup_click", r0);
        Handler r4 = DialogLancet.resolveDialogHandler(r2);
        if (r4 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r5 == null) goto L16;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r4.getLooper()) goto L7;
        r4.post(DialogLancet.createDismissRunnable(r2));
    }

    public final void O0(String r5, Map<String, String> r6) {
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r1 == null) goto L8;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L8;
        String r3 = r2.getAnchorId();
        if (r3 == null) goto L8;
    L9:
        r6.put("anchor_id", r3);
        yz0.k r4 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r4 == null) goto L15;
        IRoom r7 = r4.getRoom();
        if (r7 == null) goto L15;
        String r8 = String.valueOf(r7.getId());
        if (r8 == null) goto L15;
    L16:
        r6.put("room_id", r8);
        r6.put("anchor_connect_status", DataType.FALSE);
        r6.put("request_id", "");
        r6.put("channel_id", "");
        r6.put("pk_id", DataType.FALSE);
        r6.put("source", "pk_invite_record");
        r6.put("inviter_room_status", "2");
        r6.put("inviter_id", this.b.b.toString());
        r6.put("inviter_room_id", String.valueOf(this.b.c));
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r10.putAll(r6);
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        List<Object> r13 = r9.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3(r5, r9.a, r9.b);
        return;
    L15:
        r8 = "";
    L8:
        r3 = "";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorReplyReserveDialog(Context r2, o r3, String r4, Function1<? super Boolean, Unit> r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "replayParams");
        Intrinsics.checkNotNullParameter(r4, "userName");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = new CompositeDisposable();
    }
}
