package com.bytedance.android.live.browser;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.annie.resource.AnnieGeckoClient;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.wj1;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.uicomponent.compoundbutton.TranslucentSwitch;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/HybridDebugFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugFragment extends LiveDialogFragment {
    public static final /* synthetic */ int k = 0;
    public String d;
    public Boolean e;
    public String f;
    public final w g;
    public TextView h;
    public TextView i;
    public TranslucentSwitch j;

    public static final class a {
    }

    static {
    }

    public HybridDebugFragment() {
        this.e = Boolean.FALSE;
        this.g = (w) jc1.k.f(w.class);
    }

    public final void onActivityCreated(Bundle r5) {
        Dialog r0 = getDialog();
        if (r0 != null) goto L25;
    L9:
        if (r0 == null) goto L11;
        r0.setCanceledOnTouchOutside(true);
    L11:
        super.onActivityCreated(r5);
        if (r0 == null) goto L14;
        Window r6 = r0.getWindow();
    L15:
        if (r6 == null) goto L27;
        int r1 = t6.c(getContext());
        int r2 = t6.b(getContext());
        r6.setBackgroundDrawable(new ColorDrawable(0));
        if (isVertical() == false) goto L19;
        r6.setGravity(16);
        r6.setLayout(r1, r2);
    L23:
        r6.setFlags(RomUtils.SZ, RomUtils.SZ);
        WindowManager.LayoutParams r3 = r6.getAttributes();
        r3.dimAmount = 0.0f;
        r6.setAttributes(r3);
        return;
    L19:
        r6.setGravity(8388629);
        r6.setLayout(-1, -1);
        WindowManager.LayoutParams r4 = r6.getAttributes();
        if (getContext() == null) goto L22;
        r4.horizontalMargin = t6.a(getContext(), 8.0f) / t6.b(getContext());
    L22:
        r6.setAttributes(r4);
        goto L23
    L27:
        return;
    L14:
        r6 = null;
        goto L15
    L25:
        r0.requestWindowFeature(1);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.e("LiveDialogUtil", e);
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Bundle r6 = getArguments();
        String r7 = null;
        if (r6 == null) goto L5;
        String r0 = r6.getString(LiveSlardarConstants.EXTRA_KEY_URL);
    L6:
        this.d = r0;
        boolean r1 = false;
        if (r6 == null) goto L9;
        Boolean r2 = Boolean.valueOf(r6.getBoolean("is_lynx", false));
    L10:
        this.e = r2;
        if (r6 == null) goto L13;
        r7 = r6.getString("origin_schema", null);
    L13:
        this.f = r7;
        this.h = (TextView) requireView().findViewById(2131368353);
        this.i = (TextView) requireView().findViewById(2131381924);
        this.j = requireView().findViewById(2131379285);
        TextView r8 = this.h;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("current_url");
    L16:
        r8.setText(this.f);
        URL r9 = new URL(this.d);     // Catch: MalformedURLException -> L25
        TextView r3 = this.i;     // Catch: MalformedURLException -> L25
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("params_tv");     // Catch: MalformedURLException -> L25
    L20:
        r3.setText(r9.getQuery());     // Catch: MalformedURLException -> L25
        TextView r11 = this.h;     // Catch: MalformedURLException -> L25
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("current_url");     // Catch: MalformedURLException -> L25
    L23:
        r11.setText(r9.getProtocol() + "://" + r9.getHost() + r9.getPath());     // Catch: MalformedURLException -> L25
    L26:
        boolean r12 = true;
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == false) goto L37;
        if (((Boolean) LiveConfigSettingKeys.ENABLE_LYNX_OFFLINE.getValue()).booleanValue() == false) goto L44;
        int r13 = p20.c.a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L34;
        r12 = ((Boolean) AnnieConfigSettingKeys.OFFLINE_SWITCH.a()).booleanValue();
    L34:
        if (r12 == false) goto L44;
        AnnieGeckoClient r14 = com.bytedance.android.annie.resource.i.a;
        com.bytedance.android.annie.resource.i.a(this.d);
    L44:
        TranslucentSwitch r15 = this.j;
        if (r15 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("lynx_devtool_switch");
    L47:
        w r16 = this.g;
        if (r16 == null) goto L50;
        r1 = r16.isEnableDevtoolDebug();
    L50:
        r15.setChecked(r1);
        TranslucentSwitch r17 = this.j;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("lynx_devtool_switch");
    L53:
        r17.setOnCheckedChangeListener(new s(this));
        return;
    L37:
        if (((Boolean) wj1.a.getValue()).booleanValue() == false) goto L44;
        int r18 = p20.c.a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L42;
        r12 = ((Boolean) AnnieConfigSettingKeys.OFFLINE_SWITCH.a()).booleanValue();
    L42:
        if (r12 == false) goto L44;
        AnnieGeckoClient r19 = com.bytedance.android.annie.resource.i.a;
        com.bytedance.android.annie.resource.i.a(this.d);
        goto L44
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566048, r3, false);
    }
}
