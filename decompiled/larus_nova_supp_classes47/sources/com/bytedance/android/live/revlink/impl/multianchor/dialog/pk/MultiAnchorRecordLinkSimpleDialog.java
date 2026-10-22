package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkTopViewConfirmationDialog;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorRecordLinkSimpleDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorRecordLinkSimpleDialog extends LinkCommonDialogFragment {
    public Map<Integer, View> e;
    public DataCenter f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorRecordLinkSimpleDialog a;

        public a(MultiAnchorRecordLinkSimpleDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            MultiAnchorRecordLinkSimpleDialog.T90(this.a, true);
            Context r5 = this.a.getContext();
            if (r5 == null) goto L23;
            DataCenter r1 = this.a.f;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
        L7:
            AnchorLinkTopViewConfirmationDialog r0 = new AnchorLinkTopViewConfirmationDialog(3, r1, r5);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L21;
            DialogLancet.handleBlockedDialogShow(r0);
            goto L23
        L21:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L11:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        L23:
            this.a.dismiss();     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L25;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorRecordLinkSimpleDialog a;

        public b(MultiAnchorRecordLinkSimpleDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MultiAnchorRecordLinkSimpleDialog.T90(this.a, false);
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorRecordLinkSimpleDialog a;

        public c(MultiAnchorRecordLinkSimpleDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public MultiAnchorRecordLinkSimpleDialog() {
        this.e = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.e).clear();
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final Dialog onCreateDialog(Bundle r6) {
        Dialog r7 = super.onCreateDialog(r6);
        if (r7 == null) goto L5;
        r7.setCanceledOnTouchOutside(true);
    L5:
        HashMap r0 = new HashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r1 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r2 = r1.rb();
    L9:
        String r3 = "";
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.m<Long> r4 = r2.getChannelId();
        if (r4 == null) goto L17;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L17;
        String r8 = String.valueOf(r5.longValue());
        if (r8 == null) goto L17;
    L18:
        r0.put("channel_id", r8);
        com.bytedance.android.live.revlink.impl.multianchor.service.a r9 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r9 == null) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.utils.m r10 = r9.X9();
        if (r10 == null) goto L26;
        String r12 = r10.a;
        if (r12 == null) goto L26;
        r3 = r12;
    L26:
        r0.put("connection_anchor_id", r3);
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L29;
        Map<String, String> r14 = r13.f();
    L30:
        r0.putAll(r14);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r16.putAll(r0);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        List<Object> r18 = r15.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_connection_game_tab_show", r15.a, r15.b);
        return r7;
    L29:
        r14 = MapsKt.emptyMap();
    L17:
        r8 = "";
        goto L18
    L8:
        r2 = null;
        goto L9
    }

    public static final void T90(MultiAnchorRecordLinkSimpleDialog r4, boolean r5) {
        r4.getClass();
        HashMap r6 = new HashMap();
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r1 = r0.rb();
    L6:
        String r2 = "";
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.m<Long> r3 = r1.getChannelId();
        if (r3 == null) goto L14;
        Long r7 = (Long) r3.getValue();
        if (r7 == null) goto L14;
        String r8 = String.valueOf(r7.longValue());
        if (r8 == null) goto L14;
    L15:
        r6.put("channel_id", r8);
        com.bytedance.android.live.revlink.impl.multianchor.service.a r9 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r9 == null) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.utils.m r10 = r9.X9();
        if (r10 == null) goto L23;
        String r12 = r10.a;
        if (r12 == null) goto L23;
        r2 = r12;
    L23:
        r6.put("connection_anchor_id", r2);
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L26;
        Map<String, String> r14 = r13.f();
    L27:
        r6.putAll(r14);
        if (r5 == false) goto L30;
        r6.put("button_type", "over");
    L31:
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r16.putAll(r6);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        List<Object> r18 = r15.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_connection_game_tab_click", r15.a, r15.b);
        return;
    L30:
        r6.put("button_type", "continue");
        goto L31
    L26:
        r14 = MapsKt.emptyMap();
    L14:
        r8 = "";
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r6 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r6 == null) goto L25;
        i11.b r7 = r6.getLinkUserCenter();
        if (r7 == null) goto L25;
        List<com.bytedance.android.livesdk.link.model.p> r8 = r7.getOnlineUserList();
        if (r8 == null) goto L25;
        Iterator<com.bytedance.android.livesdk.link.model.p> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L25;
        com.bytedance.android.livesdk.link.model.p r10 = r9.next();
        IBaseUser r0 = r10.getUser();
        String r1 = null;
        if (r0 == null) goto L14;
        String r2 = iz.a.a(r0);
    L15:
        IRoom r3 = u.a();
        if (r3 == null) goto L18;
        String r12 = r3.getOwnerUserIdString();
    L20:
        if ((!Intrinsics.areEqual(r2, r12)) == false) goto L10;
        TextView r13 = (TextView) S90(2131388772);
        Object[] r14 = new Object[1];
        IBaseUser r15 = r10.getUser();
        if (r15 == null) goto L24;
        r1 = r15.getNickName();
    L24:
        r14[0] = r1;
        r13.setText(s1.C(2131920548, r14));
        goto L10
    L18:
        r12 = null;
        goto L20
    L14:
        r2 = null;
    L25:
        ((Button) S90(2131366972)).setOnClickListener(new a(this));
        ((Button) S90(2131365114)).setOnClickListener(new b(this));
        S90(2131381758).setOnClickListener(new c(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567012, r3, false);
    }
}
