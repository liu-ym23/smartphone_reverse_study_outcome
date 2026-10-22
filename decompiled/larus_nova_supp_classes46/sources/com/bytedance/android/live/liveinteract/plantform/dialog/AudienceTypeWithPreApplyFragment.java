package com.bytedance.android.live.liveinteract.plantform.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.videotalk.fragment.VideoRoomPreApplyFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yf0.e;
import yf0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dialog/AudienceTypeWithPreApplyFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/InteractDialogFragmentBaseContract$View;", "Lyf0/e;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceTypeWithPreApplyFragment extends InteractDialogFragmentBaseContract$View<e<?>> implements Observer<KVData> {
    public static final /* synthetic */ int k = 0;
    public AudienceTypeFragment g;
    public VideoRoomPreApplyFragment h;
    public DataCenter i;
    public IRoom j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        AudienceTypeFragment r0 = this.g;
        float r1 = 0.0f;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        float r2 = r0.T90();
    L6:
        DataCenter r3 = this.i;
        if (r3 == null) goto L14;
        boolean r4 = us1.e.a;
        if (us1.e.c(r3, this.j, true) == false) goto L14;
        VideoRoomPreApplyFragment r5 = this.h;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        r1 = 240.0f;
    L14:
        return r2 + r1;
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        AudienceTypeFragment r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.W90();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void onDestroy() {
        super.onDestroy();
        DataCenter r0 = this.i;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public AudienceTypeWithPreApplyFragment() {
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3.getKey(), "live_audience_type_dialog_dismiss") == false) goto L11;
        g r4 = this.d;
        if (r4 == null) goto L12;
        r4.dismiss();
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        AudienceTypeFragment r7 = this.g;
        if (r7 != null) goto L5;
    L10:
        DataCenter r8 = this.i;
        if (r8 == null) goto L22;
        boolean r0 = us1.e.a;
        if (us1.e.c(r8, this.j, true) == false) goto L22;
        VideoRoomPreApplyFragment r9 = this.h;
        if (r9 == null) goto L22;
        if (r9.isAdded() == true) goto L22;
        VideoRoomPreApplyFragment r10 = this.h;
        Intrinsics.checkNotNull(r10);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "pre_apply", 2131382837) == true) goto L22;
        r6.add(2131382837, r10, "pre_apply");
    L22:
        r6.commitAllowingStateLoss();
        DataCenter r11 = this.i;
        if (r11 == null) goto L26;
        r11.observe("live_audience_type_dialog_dismiss", this);
        return;
    L26:
        return;
    L5:
        if (r7.isAdded() == true) goto L10;
        AudienceTypeFragment r12 = this.g;
        Intrinsics.checkNotNull(r12);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "audience_type", 2131363381) == true) goto L10;
        r6.add(2131363381, r12, "audience_type");
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565791, r3, false);
    }
}
