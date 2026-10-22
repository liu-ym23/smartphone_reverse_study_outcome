package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.widget.WheelPicker;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPKTimeDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPKTimeDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int o = 0;
    public WheelPicker d;
    public final int[] e;
    public int f;
    public View g;
    public View h;
    public AnchorInteractSettingContract$View i;
    public boolean j;
    public boolean k;
    public x31.k l;
    public b m;
    public boolean n;

    public static final class a {
    }

    public interface b {
        void cS(int r1, int r2);
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ InteractPKTimeDialogFragment a;

        public c(InteractPKTimeDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            InteractPKTimeDialogFragment r4 = this.a;
            int r0 = InteractPKTimeDialogFragment.o;
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

    public InteractPKTimeDialogFragment() {
        this.e = new int[]{120, 300, 600, 900};
        v41.a r0 = v41.a.m;
        r0.getClass();
        if (((Boolean) v41.a.k.getValue(r0, v41.a.a[9])).booleanValue() == false) goto L6;
        this.e = new int[]{10, 30, 60, 90, 120, 180, 300, 600, 900};
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        Intrinsics.checkNotNull(r6);
        Window r7 = r6.getWindow();
        if (r7 == null) goto L11;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L9:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954726);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new c(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        View r5 = getView();
        View r6 = null;
        if (r5 == null) goto L5;
        View r0 = r5.findViewById(2131388660);
    L6:
        this.g = r0;
        if (r5 == null) goto L9;
        r6 = r5.findViewById(2131388661);
    L9:
        this.h = r6;
        View r7 = this.g;
        if (r7 == null) goto L12;
        r7.setOnClickListener(new g(this));
    L12:
        View r8 = this.h;
        if (r8 == null) goto L15;
        r8.setOnClickListener(new h(this));
    L15:
        HashMap r9 = new HashMap();
        if (this.k == false) goto L19;
        String r10 = "hint_bar";
    L22:
        r9.put("request_page", r10);
        mz0.n r12 = new mz0.n();
        Map<String, String> r1 = r12.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r1.putAll(r9);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_pk_time_setting_panel_show", r12.a, r12.b);
        return;
    L19:
        if (this.n == false) goto L21;
        r10 = "playmode_panel_setting";
        goto L22
    L21:
        r10 = "set_panel";
        goto L22
    L5:
        r0 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ArrayList r12 = new ArrayList();
        int[] r0 = this.e;
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L10;
        int r5 = r0[r3];
        if (r5 >= 60) goto L8;
        String r4 = s1.C(2131917856, new Object[]{Integer.valueOf(r5)});
    L9:
        r12.add(r4);
        r3 = r3 + 1;
        goto L4
    L8:
        r4 = s1.C(2131917855, new Object[]{Integer.valueOf(r5 / 60)});
        goto L9
    L10:
        int r2 = this.f;
        if (r2 >= 0) goto L13;
    L14:
        this.f = 1;
    L15:
        View r13 = r8.inflate(2131565703, r9, false);
        WheelPicker r14 = new WheelPicker(getContext());
        this.d = r14;
        Intrinsics.checkNotNull(r14);
        r14.setData(r12);
        WheelPicker r15 = this.d;
        Intrinsics.checkNotNull(r15);
        r15.setIndicator(true);
        WheelPicker r16 = this.d;
        Intrinsics.checkNotNull(r16);
        r16.setIndicatorSize(3);
        WheelPicker r17 = this.d;
        Intrinsics.checkNotNull(r17);
        r17.setItemTextSize((int) UIUtils.dip2Px(getContext(), 16));
        WheelPicker r18 = this.d;
        Intrinsics.checkNotNull(r18);
        r18.setSelectItemTextSize((int) UIUtils.dip2Px(getContext(), 18));
        WheelPicker r19 = this.d;
        Intrinsics.checkNotNull(r19);
        r19.setItemTextColor(ColorProtector.parseColor("#a0404040"));
        WheelPicker r20 = this.d;
        Intrinsics.checkNotNull(r20);
        r20.setSelectedItemTextColor(ColorProtector.parseColor("#161823"));
        WheelPicker r22 = this.d;
        Intrinsics.checkNotNull(r22);
        r22.setBackgroundColor(ColorProtector.parseColor("#FFFFFF"));
        WheelPicker r23 = this.d;
        Intrinsics.checkNotNull(r23);
        r23.g(this.f, false);
        WheelPicker r24 = this.d;
        Intrinsics.checkNotNull(r24);
        r24.setItemSpace(27);
        View r25 = r13.findViewById(2131393172);
        if (r25 == null) goto L20;
        ((FrameLayout) r25).addView(this.d);
        return r13;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L13:
        if (r2 < r12.size()) goto L15;
        goto L14
    }
}
