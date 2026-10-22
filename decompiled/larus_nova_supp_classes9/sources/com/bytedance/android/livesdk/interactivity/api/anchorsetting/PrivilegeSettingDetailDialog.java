package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.LivePrivilegeSettingApi;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.b1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/PrivilegeSettingDetailDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivilegeSettingDetailDialog extends LiveDialogFragment {
    public static final /* synthetic */ int l = 0;
    public Map<Integer, View> d;
    public final Map<Integer, Integer> e;
    public final Map<Integer, Integer> f;
    public final Map<Integer, Integer> g;
    public final Map<Integer, Integer> h;
    public final Map<Integer, Integer> i;
    public final Map<Integer, Integer> j;
    public View k;

    public static final class a {
        public static void a(PrivilegeSettingDetailDialog r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PrivilegeSettingDetailDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.showNow(r3, "PrivilegeSettingDetailDialog");
        }
    }

    static {
    }

    public PrivilegeSettingDetailDialog() {
        this.d = new LinkedHashMap();
        this.e = MapsKt.mapOf(new Pair[]{TuplesKt.to(2131373099, 0), TuplesKt.to(2131373100, 1), TuplesKt.to(2131373114, 2), TuplesKt.to(2131373111, 3), TuplesKt.to(2131373104, 7), TuplesKt.to(2131373110, 30)});
        this.f = MapsKt.mapOf(new Pair[]{TuplesKt.to(2131378421, 0), TuplesKt.to(2131378403, 1)});
        this.g = MapsKt.mapOf(new Pair[]{TuplesKt.to(2131372118, 0), TuplesKt.to(2131372080, 1), TuplesKt.to(2131372085, 3), TuplesKt.to(2131372086, 5), TuplesKt.to(2131372087, 9), TuplesKt.to(2131372081, 12), TuplesKt.to(2131372082, 15), TuplesKt.to(2131372083, 17), TuplesKt.to(2131372084, 20)});
        this.h = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, 2131373099), TuplesKt.to(1, 2131373100), TuplesKt.to(2, 2131373114), TuplesKt.to(3, 2131373111), TuplesKt.to(7, 2131373104), TuplesKt.to(30, 2131373110)});
        this.i = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, 2131378421), TuplesKt.to(1, 2131378403)});
        this.j = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, 2131372118), TuplesKt.to(1, 2131372080), TuplesKt.to(3, 2131372085), TuplesKt.to(5, 2131372086), TuplesKt.to(9, 2131372087), TuplesKt.to(12, 2131372081), TuplesKt.to(15, 2131372082), TuplesKt.to(17, 2131372083), TuplesKt.to(20, 2131372084)});
        setNoTitleAndCancelOutside(true);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public static final void T90(PrivilegeSettingDetailDialog r4) {
        r4.getClass();
        Integer r5 = (Integer) com.bytedance.android.livesdk.sharedpref.b.f1.getValue();
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.b.h1.getValue();
        Integer r1 = (Integer) com.bytedance.android.livesdk.sharedpref.b.g1.getValue();
        ((LivePrivilegeSettingApi) com.bytedance.android.live.network.c.b().e(LivePrivilegeSettingApi.class)).setPrivilegeBarrageSetting(true, r5.intValue(), r0.intValue(), r1.intValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(x.a, y.a);
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

    public final void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954585);
        setAnimationType("right");
        setShouldUseNewPanel(true);
    }

    public final Dialog onCreateDialog(Bundle r1) {
        return super.onCreateDialog(r1);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(final View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        int r4 = b1.a;
        b1.b(true, new PrivilegeSettingDetailDialog$initDialogUI$1(this, r2));
        ((LivePrivilegeSettingApi) com.bytedance.android.live.network.c.b().e(LivePrivilegeSettingApi.class)).getPrivilegeBarrageSetting().compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this), r.a);
        ((RadioGroup) S90(2131373959)).setOnCheckedChangeListener(new s(this));
        ((RadioGroup) S90(2131373972)).setOnCheckedChangeListener(new t(this));
        ((RadioGroup) S90(2131373957)).setOnCheckedChangeListener(new u(this));
        ((ImageView) S90(2131375966)).setOnClickListener(v.a);
        ((ImageView) S90(2131383068)).setOnClickListener(new w(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565710, r3, false);
        this.k = r5;
        return r5;
    }
}
