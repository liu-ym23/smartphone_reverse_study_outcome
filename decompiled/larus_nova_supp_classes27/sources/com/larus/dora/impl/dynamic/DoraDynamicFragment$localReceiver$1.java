package com.larus.dora.impl.dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/dynamic/DoraDynamicFragment$localReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDynamicFragment$localReceiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ DoraDynamicFragment a;

    public DoraDynamicFragment$localReceiver$1(DoraDynamicFragment r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r7, final Intent r8) {
        String r9 = "";
        if (r8 == null) goto L6;
        String r0 = r8.getAction();
        if (r0 == null) goto L6;
    L8:
        switch(r0.hashCode()) {
            case -1789750617: goto L36;
            case -1400478214: goto L27;
            case 1157480080: goto L19;
            case 1330375556: goto L11;
            default: goto L84;
        };
    L84:
        g49.d.d("DoraDynamicFragment", "onReceive : unknown action : ".concat(r0));
        return;
    L11:
        if (r0.equals("action.DEVICE_ENTER_SIMUL_INTERPRET") == false) goto L84;
        final DoraDynamicFragment r10 = this.a;
        LarusDoraPageDynamicListBinding r11 = r10.f;
        if (r11 == null) goto L86;
        ConstraintLayout r12 = r11.a;
        if (r12 == null) goto L87;
        r12.post(new g0(r10));
        return;
    L87:
        return;
    L86:
        return;
    L19:
        if (r0.equals("action.DEVICE_UPDATE_NAME") == false) goto L84;
        final DoraDynamicFragment r13 = this.a;
        LarusDoraPageDynamicListBinding r1 = r13.f;
        if (r1 == null) goto L89;
        ConstraintLayout r2 = r1.a;
        if (r2 == null) goto L90;
        r2.post(new f0(r8, r13));
        return;
    L90:
        return;
    L89:
        return;
    L27:
        if (r0.equals("action.DEVICE_UPDATE_DYNAMIC") == false) goto L84;
        DoraDevice r14 = i.b();
        if (r14 != null) goto L34;
        FragmentActivity r15 = this.a.getActivity();
        if (r15 == null) goto L92;
        r15.finish();
        return;
    L92:
        return;
    L34:
        DoraDynamicFragment r16 = this.a;
        String r17 = r14.mac;
        int r3 = DoraDynamicFragment.C;
        r16.da0(r17, "action:ACTION_DEVICE_UPDATE_DYNAMIC");
        return;
    L36:
        if (r0.equals("action.DEVICE_UNBIND") == false) goto L84;
        if (r8 == null) goto L41;
        String r18 = r8.getStringExtra("mac");
    L42:
        g49.d.d("DoraDynamicFragment", "onReceive : device unbind action. intentMac : " + r18);
        if (r18 == null) goto L95;
        DoraDynamicFragment r4 = this.a;
        int r5 = DoraDynamicFragment.C;
        r4.ba0().updateRemoveBarData(r18);
        DoraDevice r6 = r4.p;
        if (r6 == null) goto L51;
        String r20 = r6.mac;
        if (r20 == null) goto L51;
        r9 = r20;
    L51:
        if (TextUtils.equals(r18, r9) == false) goto L96;
        DoraDevice r21 = i.b();
        StringBuilder r22 = new StringBuilder("onReceive : ACTION_DEVICE_UNBIND, lastDevice is null =");
        boolean r23 = false;
        if (r21 != null) goto L55;
        boolean r24 = true;
    L56:
        r22.append(r24);
        g49.d.d("DoraDynamicFragment", r22.toString());
        if (r21 != null) goto L81;
        FragmentActivity r25 = r4.getActivity();
        if (r25 != null) goto L61;
    L63:
        boolean r26 = false;
    L64:
        if (r26 == false) goto L66;
        g49.d.d("DoraDynamicFragment", "onReceive : device unbind action. lastDevice is empty, but activity is finishing");
        return;
    L66:
        DoraDevice r27 = r4.p;
        if (r27 != null) goto L69;
    L71:
        if (r23 == false) goto L77;
        IFlowSdkDepend r28 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r28 == null) goto L77;
        com.larus.home.impl.sdk.s r30 = r28.s0();
        if (r30 == null) goto L77;
        r30.N(null);
    L77:
        FragmentActivity r31 = r4.getActivity();
        if (r31 == null) goto L98;
        r31.finish();
        return;
    L98:
        return;
    L69:
        if (o59.a.l(r27) == true) goto L71;
        r23 = true;
        goto L71
    L61:
        if (r25.isFinishing() != true) goto L63;
        r26 = true;
        goto L64
    L81:
        if (o59.a.l(r21) == false) goto L83;
        DoraDynamicFragment.X90(r4, r21);
        return;
    L83:
        r4.da0(r21.mac, "action:ACTION_DEVICE_UNBIND");
        return;
    L55:
        r24 = false;
        goto L56
    L96:
        return;
    L95:
        return;
    L41:
        r18 = null;
    L6:
        r0 = "";
        goto L8
    }
}
