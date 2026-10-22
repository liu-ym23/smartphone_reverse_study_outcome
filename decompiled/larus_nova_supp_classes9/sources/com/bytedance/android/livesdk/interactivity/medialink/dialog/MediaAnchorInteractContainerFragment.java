package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorInteractContainerFragment extends MediaInteractDialogFragmentBaseContract$View<t82.e> {
    public static final /* synthetic */ int h = 0;
    public ViewGroup g;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return BuildConfig.FLAVOR;
    }

    public MediaAnchorInteractContainerFragment() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        return this.g;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        View r8 = r5.inflate(2131566905, r6, false);
        FragmentTransaction r9 = getFragmentManager().beginTransaction();
        t82.f r10 = this.d;
        MediaAnchorLinkUserListFragment r1 = new MediaAnchorLinkUserListFragment();
        r1.f = new u82.h(r1);
        r1.d = r10;
        r1.n = 4;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131378084) == true) goto L6;
        r9.add(2131378084, r1);
    L6:
        r9.commitAllowingStateLoss();
        this.g = (ViewGroup) LayoutInflater.from(getContext()).inflate(2131566906, null);
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        if (com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a().Np().d().isEmpty() == true) goto L9;
        ImageView r11 = (ImageView) this.g.findViewById(2131363762);
        r11.setOnClickListener(new a(this));
        this.g.findViewById(2131387986).setVisibility(8);
        this.g.findViewById(2131385953).setVisibility(8);
        r11.setVisibility(0);
        this.g.findViewById(2131388838).setVisibility(0);
    L10:
        return r8;
    L9:
        this.g.findViewById(2131385953).setOnClickListener(new b(this));
        r3.a(this.g.findViewById(2131385953), s1.B(2131922469));
        goto L10
    }
}
