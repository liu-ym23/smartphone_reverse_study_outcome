package com.obric.memorydata.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0004¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/ui/BaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "savedInstanceState", "Landroid/os/Bundle;", "safeViewPost", "", "targetView", "Landroid/view/View;", "action", "Lkotlin/Function0;", "isCurrentFragmentView", "", "fragmentView", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseFragment extends Fragment {
    public static final a Companion = null;
    public static final String TAG = "BaseFragment";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/BaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public BaseFragment() {
    }

    public static /* synthetic */ void lambda$UqzqMWTogA0WMGxtgzEym2xpxX8(BaseFragment r0, View r1, Function0 r2) {
        safeViewPost$lambda$0(r0, r1, r2);
    }

    private static final void safeViewPost$lambda$0(BaseFragment r2, View r3, Function0 r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (r2.isCurrentFragmentView(r3) == true) goto L5;
        return;
    L5:
        r5.invoke();
    }

    public final boolean isCurrentFragmentView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentView");
        return d.f13003a.a(isAdded(), r3, getView());
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onGetLayoutInflater ...", false, 4, null);
        LayoutInflater r11 = super.onGetLayoutInflater(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "onGetLayoutInflater(...)");
        String r0 = DeviceInfoState.INSTANCE.getDeviceModel();
        int r1 = r0.hashCode();
        if (r1 == (-2002884275)) goto L17;
        if (r1 == (-1048984789)) goto L13;
        if (r1 == 1328894480) goto L10;
    L18:
        int r2 = R.style.DeviceOverlay_Pacific;
        String r3 = "DeviceOverlay_Pacific";
    L19:
        int r4 = ZeusTransformUtils.mapRes(r2, "style", r3);
        LayoutInflater r9 = r11.cloneInContext((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4), Context.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "cloneInContext(...)");
        return r9;
    L10:
        if (r0.equals("nerida-lite") == false) goto L18;
    L15:
        r2 = R.style.DeviceOverlay_Nerida;
        r3 = "DeviceOverlay_Nerida";
        goto L19
    L13:
        if (r0.equals("nerida") == true) goto L15;
    L17:
        if (r0.equals("Genesis-R") == false) goto L18;
        r2 = R.style.DeviceOverlay_GenesisR;
        r3 = "DeviceOverlay_GenesisR";
        goto L19
    }

    public final void safeViewPost(View r3, Function0<Unit> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r5, "action");
        final View r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        r3.post(new $$Lambda$BaseFragment$UqzqMWTogA0WMGxtgzEym2xpxX8(this, r0, r5));
    }
}
