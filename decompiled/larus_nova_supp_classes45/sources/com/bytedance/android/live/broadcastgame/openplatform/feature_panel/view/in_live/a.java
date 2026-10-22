package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.LiveOpenFeatureSearchFragmentV3;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseFragment a;

    public a(LiveOpenFeatureChooseFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        Boolean r12 = (Boolean) r11;
        Integer r4 = null;
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L45;
        LiveOpenFeatureChooseFragment r13 = this.a;
        boolean r5 = LiveOpenFeatureChooseFragment.i;
        FragmentManager r6 = r13.getChildFragmentManager();
        if (r6 == null) goto L7;
        FragmentTransaction r7 = r6.beginTransaction();
    L8:
        LiveOpenFeatureSearchFragmentV3 r8 = new LiveOpenFeatureSearchFragmentV3();
        r13.d = r8;
        ft0 r9 = ft0.a;
        if (((k81) r9.getValue()).f() == false) goto L15;
        if (r7 == null) goto L23;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131372183) == true) goto L23;
        r7.add(2131372183, r8);
    L23:
        if (((k81) r9.getValue()).a() == false) goto L42;
        AbsLiveOpenFeatureChooseFragment r0 = r13.e;
        if (r0 == null) goto L27;
        View r1 = r0.getView();
    L28:
        if (r1 == null) goto L35;
        AbsLiveOpenFeatureChooseFragment r14 = r13.e;
        if (r14 == null) goto L35;
        View r15 = r14.getView();
        if (r15 == null) goto L35;
        r15.setImportantForAccessibility(4);
    L35:
        if (r8.getView() == null) goto L42;
        View r16 = r8.getView();
        if (r16 == null) goto L39;
        r16.setImportantForAccessibility(1);
    L39:
        View r17 = r8.getView();
        if (r17 == null) goto L42;
        r17.sendAccessibilityEvent(8);
        goto L42
    L27:
        r1 = null;
    L42:
        if (r7 == null) goto L44;
        r4 = Integer.valueOf(r7.commitAllowingStateLoss());
    L44:
        r4.intValue();
        return;
    L15:
        if (r7 != null) goto L17;
    L20:
        if (r7 == null) goto L23;
        r7.addToBackStack(null);
        goto L23
    L17:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372183) == true) goto L20;
        r7.replace(2131372183, r8);
        goto L20
    L7:
        r7 = null;
        goto L8
    L45:
        LiveOpenFeatureChooseFragment r18 = this.a;
        boolean r19 = LiveOpenFeatureChooseFragment.i;
        FragmentManager r21 = r18.getChildFragmentManager();
        if (r21 == null) goto L48;
        FragmentTransaction r22 = r21.beginTransaction();
    L49:
        LiveOpenFeatureSearchFragment r23 = new LiveOpenFeatureSearchFragment();
        r18.d = r23;
        ft0 r24 = ft0.a;
        if (((k81) r24.getValue()).f() == false) goto L56;
        if (r22 == null) goto L64;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r22, r23, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131372183) == true) goto L64;
        r22.add(2131372183, r23);
    L64:
        if (((k81) r24.getValue()).a() == false) goto L83;
        AbsLiveOpenFeatureChooseFragment r2 = r18.e;
        if (r2 == null) goto L68;
        View r3 = r2.getView();
    L69:
        if (r3 == null) goto L76;
        AbsLiveOpenFeatureChooseFragment r110 = r18.e;
        if (r110 == null) goto L76;
        View r111 = r110.getView();
        if (r111 == null) goto L76;
        r111.setImportantForAccessibility(4);
    L76:
        if (r23.getView() == null) goto L83;
        View r112 = r23.getView();
        if (r112 == null) goto L80;
        r112.setImportantForAccessibility(1);
    L80:
        View r113 = r23.getView();
        if (r113 == null) goto L83;
        r113.sendAccessibilityEvent(8);
        goto L83
    L68:
        r3 = null;
    L83:
        if (r22 == null) goto L85;
        r4 = Integer.valueOf(r22.commitAllowingStateLoss());
    L85:
        r4.intValue();
        return;
    L56:
        if (r22 != null) goto L58;
    L61:
        if (r22 == null) goto L64;
        r22.addToBackStack(null);
        goto L64
    L58:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r22, r23, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372183) == true) goto L61;
        r22.replace(2131372183, r23);
        goto L61
    L48:
        r22 = null;
        goto L49
    }
}
