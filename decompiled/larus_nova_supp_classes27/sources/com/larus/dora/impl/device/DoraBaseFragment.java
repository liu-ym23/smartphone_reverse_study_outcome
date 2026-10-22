package com.larus.dora.impl.device;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ixigua.lib.track.TrackParams;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0017J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/device/DoraBaseFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "doraLinkCallback", "com/larus/dora/impl/device/DoraBaseFragment$doraLinkCallback$1", "Lcom/larus/dora/impl/device/DoraBaseFragment$doraLinkCallback$1;", "onStart", "", "onStop", "loadConnectState", "onDoraConnectStateChanged", "isConnected", "", "getPageMaskView", "Landroid/view/View;", "autoLogEnterPage", "logEnterPage", "next", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraBaseFragment extends TraceFragment {
    public final DoraBaseFragment$doraLinkCallback$1 e;

    public static final class a {
    }

    static {
    }

    public boolean S90() {
        return !(this instanceof DoraObricDeviceHomeFragment);
    }

    public View U90() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.device.DoraBaseFragment$doraLinkCallback$1] */
    public DoraBaseFragment() {
        this.e = new DoraBaseFragment$doraLinkCallback$1(this);
    }

    public void T90() {
        String r0 = k();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L22;
        DoraBuryPointManager r4 = DoraBuryPointManager.a;
        Pair[] r5 = new Pair[3];
        r5[0] = TuplesKt.to("current_page", r0);
        TrackParams r1 = by7.h.e(this);
        if (r1 == null) goto L17;
        HashMap r2 = r1.getParams();
        if (r2 == null) goto L17;
        Object r6 = r2.get("current_page");
        if (r6 == null) goto L17;
        String r7 = r6.toString();
    L18:
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r5[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r7);
        r5[2] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        r4.L("enter_page", MapsKt.mapOf(r5));
        return;
    L17:
        r7 = null;
        goto L18
    L22:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        kj4.a.g().registerDoraLinkCallback(this.e);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraBaseFragment$loadConnectState$1(this, null), 2, null);
    }

    public void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        kj4.a.g().unregisterDoraLinkCallback(this.e);
    }

    public void V90(boolean r3) {
        Context r0 = getContext();
        if (r0 == null) goto L18;
        View r1 = U90();
        if (r1 == null) goto L19;
        if (r3 == false) goto L12;
        e1.o(r1);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L20;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L21;
        r5.setNavigationBarColor(Color.argb(1, 255, 255, 255));
        return;
    L21:
        return;
    L20:
        return;
    L12:
        e1.x(r1);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L23;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L24;
        r7.setNavigationBarColor(r0.getResources().getColor(2131103066));
        return;
    L24:
        return;
    L23:
        return;
    L19:
        return;
    }
}
