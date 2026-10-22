package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.message.model.jl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/XiaoAnSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XiaoAnSettingDialog extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public jl e;
    public DataCenter f;
    public final Map<Integer, Integer> g;
    public final Map<Integer, Integer> h;
    public Integer i;

    public static final class a {
        public static void a(XiaoAnSettingDialog r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PrivilegeSettingDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.showNow(r3, "PrivilegeSettingDialog");
        }

        @JvmStatic
        public static void b(DataCenter r2, Context r3, jl r4) {
            Intrinsics.checkNotNullParameter(r2, "dataCenter");
            Intrinsics.checkNotNullParameter(r3, "context");
            if ((r3 instanceof FragmentActivity) == false) goto L24;
            FragmentManager r5 = ((FragmentActivity) r3).getSupportFragmentManager();
            if ((r5.findFragmentByTag("PrivilegeSettingDialog") instanceof XiaoAnSettingDialog) == false) goto L14;
            XiaoAnSettingDialog r0 = r5.findFragmentByTag("PrivilegeSettingDialog");
            if (r0 == null) goto L13;
            XiaoAnSettingDialog r1 = r0;
            r1.setAnimationType("right");
            r1.setShouldUseNewPanel(true);
            r1.e = r4;
            r1.f = r2;
            if (r1.isAdded() == false) goto L11;
            return;
        L11:
            a(r1, r5);
        L15:
            com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
            HashMap r7 = new HashMap();
            IUserService r8 = jc1.k.f(IUserService.class);
            if (r8 == null) goto L21;
            com.bytedance.android.livesdk.user.f r9 = r8.user();
            if (r9 == null) goto L21;
            String r10 = r9.n();
            if (r10 == null) goto L21;
        L22:
            r7.put("anchor_id", r10);
            Unit r11 = Unit.INSTANCE;
            r6.sendLog("livesdk_anchor_setting_revenue_function_page_show", r7, new Object[0]);
            return;
        L21:
            r10 = "0";
            goto L22
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.anchorsetting.XiaoAnSettingDialog");
        L14:
            XiaoAnSettingDialog r13 = new XiaoAnSettingDialog();
            r13.e = r4;
            r13.f = r2;
            a(r13, r5);
            goto L15
        }
    }

    static {
    }

    public XiaoAnSettingDialog() {
        this.d = new LinkedHashMap();
        this.g = MapsKt.mapOf(new Pair[]{TuplesKt.to(2131383583, 3), TuplesKt.to(2131383584, 5), TuplesKt.to(2131383585, 1)});
        this.h = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, 2131383585), TuplesKt.to(3, 2131383583), TuplesKt.to(5, 2131383584)});
        this.i = 3;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
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

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954585);
        setAnimationType("bottom");
        setShouldUseNewPanel(true);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L5;
        r4.setCancelable(false);
    L5:
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        r5.setCanceledOnTouchOutside(false);
    L8:
        ((RadioGroup) S90(2131383606)).check(2131383583);
        ((RadioGroup) S90(2131383606)).setOnCheckedChangeListener(new z(this));
        if (this.e == null) goto L32;
        HSImageView r6 = S90(2131393370);
        if (r6 == null) goto L31;
        HSImageView r7 = r6;
        jl r8 = this.e;
        String r0 = null;
        if (r8 == null) goto L16;
        py.k r9 = r8.getTitleImage();
    L17:
        ImageLoader.bindImage(r7, r9);
        TextView r10 = (TextView) S90(2131393371);
        jl r11 = this.e;
        if (r11 == null) goto L20;
        String r13 = r11.getTitle();
    L21:
        r10.setText(r13);
        TextView r14 = (TextView) S90(2131393372);
        jl r15 = this.e;
        if (r15 == null) goto L24;
        String r16 = r15.getTopTip();
    L25:
        r14.setText(r16);
        TextView r17 = (TextView) S90(2131393368);
        jl r18 = this.e;
        if (r18 == null) goto L28;
        r0 = r18.getBottomTip();
    L28:
        r17.setText(r0);
        ((ImageView) S90(2131393369)).setOnClickListener(new a0(this));
        ((Button) S90(2131364673)).setOnClickListener(new b0(this));
        ((Button) S90(2131364830)).setOnClickListener(new c0(this));
        return;
    L24:
        r16 = null;
        goto L25
    L20:
        r13 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.widget.HSImageView");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565808, r3, false);
    }
}
