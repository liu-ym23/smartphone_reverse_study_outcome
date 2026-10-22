package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkMuteCheckDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkMuteCheckDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public View d;
    public View e;
    public View f;
    public View g;
    public AppCompatRadioButton h;
    public TextView i;
    public String j;
    public Boolean k;
    public View.OnClickListener l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkMuteCheckDialogFragment a;

        public b(PkMuteCheckDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkMuteCheckDialogFragment r4 = this.a;
            int r0 = PkMuteCheckDialogFragment.m;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L16;
            if (r2 == null) goto L19;
            Dialog r5 = r4.getDialog();
            Intrinsics.checkNotNull(r5);
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L20;
            Object r7 = r2.getSystemService("input_method");
            if (r7 == null) goto L15;
            InputMethodManager r8 = (InputMethodManager) r7;
            if (r8.isActive() == false) goto L17;
            r8.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L17:
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        L20:
            return;
        L19:
            return;
        }
    }

    static {
    }

    public PkMuteCheckDialogFragment() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        Intrinsics.checkNotNull(r4);
        Window r5 = r4.getWindow();
        if (r5 == null) goto L10;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        b03.a r1 = b03.a.a;
        if (PadConfigUtils.a() == false) goto L7;
        int r2 = -2;
    L8:
        r0.height = r2;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L7:
        r2 = s1.f(180.0f);
        goto L8
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        View r8 = getView();
        Intrinsics.checkNotNull(r8);
        this.d = r8.findViewById(2131389494);
        this.f = r8.findViewById(2131389542);
        this.e = r8.findViewById(2131389502);
        this.g = r8.findViewById(2131383718);
        this.h = r8.findViewById(2131383716);
        this.i = (TextView) r8.findViewById(2131391606);
        View r9 = this.d;
        if (r9 == null) goto L5;
        r9.setOnClickListener(new f(this));
    L5:
        View.OnClickListener r10 = this.l;
        if (r10 == null) goto L10;
        View r12 = this.f;
        if (r12 == null) goto L10;
        r12.setOnClickListener(r10);
    L10:
        View r13 = this.e;
        if (r13 == null) goto L13;
        r13.setOnClickListener(new g(this));
    L13:
        View r14 = this.g;
        if (r14 == null) goto L16;
        r14.setOnClickListener(new h(this));
    L16:
        View r15 = this.e;
        if (r15 == null) goto L19;
        r15.setVisibility(8);
    L19:
        TextView r16 = this.i;
        if (r16 == null) goto L22;
        r16.setText(s1.C(2131917695, new Object[]{this.j}));
    L22:
        Boolean r17 = this.k;
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r17, r0) == false) goto L27;
        TextView r18 = this.i;
        if (r18 == null) goto L27;
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        int r2 = w11.a.a;
        r18.setText(com.bytedance.live.kmp.util.c.a(2131917696, new Object[0]));
    L27:
        HashMap r19 = new HashMap();
        r19.put("action_type", "show");
        d31.d r3 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r3 == null) goto L30;
        String r4 = r3.c();
    L31:
        r19.put("connection_type", r4);
        r19.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        r19.put("is_mention_again", DataType.FALSE);
        long r5 = 0;
        LinkCrossRoomDataHolder r20 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r20 == null) goto L40;
        if (r20.i() != 0) goto L40;
        LinkCrossRoomDataHolder r22 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r22 == null) goto L38;
        r5 = r22.f();
        goto L40
    L38:
        r5 = 0;
    L40:
        if (Intrinsics.areEqual(this.k, r0) == false) goto L42;
        String r23 = "livesdk_connection_mute_all_window";
    L43:
        mz0.n r24 = new mz0.n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r25.putAll(r19);
        mz0.m r26 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r27 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r27, "linkInfoLog");
        r27.c(r5);
        ((ArrayList) r26.a).add(r27.a);
        LinkCrossRoomDataHolder.a r28 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r26);
        r26.b(LogCommon.ROOM);
        ((ArrayList) r24.b).addAll(r26.a);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r30);
        ((mz0.i) ((f80.a) r30)).w3(r23, r24.a, r24.b);
        return;
    L42:
        r23 = "livesdk_connection_mute_window";
        goto L43
    L30:
        r4 = "";
        goto L31
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565532, r3, false);
    }
}
