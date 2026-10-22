package com.larus.dora.o.impl.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0015\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryHostFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "showingContent", "", "Ljava/lang/Boolean;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "onDestroyView", "envObserveListener", "com/larus/dora/o/impl/diary/ODiaryHostFragment$envObserveListener$1", "Lcom/larus/dora/o/impl/diary/ODiaryHostFragment$envObserveListener$1;", "selectDiaryDate", "date", "", "resolveDeviceMac", "refreshContent", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryHostFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public Boolean d;
    public final b e;

    public static final class a {
    }

    public static final class b implements u39.b {
        public final /* synthetic */ ODiaryHostFragment a;

        public b(ODiaryHostFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r1, EnvObserveChangeReason r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            View r4 = this.a.getView();
            if (r4 == null) goto L6;
            final ODiaryHostFragment r5 = this.a;
            r4.post(new o0(r5));
            return;
        }
    }

    static {
    }

    public final void S90() {
        int r0 = d0.a;
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("mac");
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L21;
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L20;
        DeviceService r6 = r5.device();
        if (r6 == null) goto L20;
        r2 = r6.k();
    L20:
        r2 = null;
    L21:
        if (r2 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L79;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L36;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L36;
        if (r9.i(r2) != 1) goto L36;
        boolean r10 = true;
    L38:
        if (r10 == true) goto L49;
        IDoraPageConfig r11 = d0.a();
        if (r11 != null) goto L42;
    L44:
        boolean r12 = false;
    L45:
        if (r12 == false) goto L79;
        FLogger.a.i("ODiaryEnvMark", "device not bound any more, clear stale diary env mark");
        IDoraPageConfig r13 = d0.a();
        if (r13 == null) goto L79;
        r13.h(r2);
        goto L79
    L42:
        if (r11.g(r2) != true) goto L44;
        r12 = true;
        goto L45
    L49:
        IDoraPageConfig r14 = d0.a();
        if (r14 != null) goto L52;
    L54:
        boolean r15 = false;
    L55:
        if (r15 == true) goto L78;
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L64;
        com.larus.dora.impl.serviceimpl.r r17 = r16.g1();
        if (r17 == null) goto L64;
        if (r17.b() != true) goto L64;
        boolean r18 = true;
    L65:
        IDoraService r20 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r20 == null) goto L72;
        DeviceService r21 = r20.device();
        if (r21 == null) goto L72;
        if (r21.K(r2) != true) goto L72;
        boolean r22 = true;
    L73:
        if (r18 == false) goto L79;
        if (r22 == false) goto L79;
        FLogger.a.i("ODiaryEnvMark", "env observe already on for connected device, mark diary as opened");
        IDoraPageConfig r23 = d0.a();
        if (r23 == null) goto L78;
        r23.c(r2);
    L72:
        r22 = false;
    L64:
        r18 = false;
    L78:
        boolean r24 = true;
    L81:
        if (Intrinsics.areEqual(this.d, Boolean.valueOf(r24)) == false) goto L83;
        return;
    L83:
        this.d = Boolean.valueOf(r24);
        if (r24 == false) goto L86;
        Fragment r25 = new ODiaryContentFragment();
    L87:
        Bundle r26 = getArguments();
        if (r26 != null) goto L90;
        r26 = new Bundle();
    L90:
        Bundle r27 = new Bundle(r26);
        Bundle r28 = getArguments();
        if (r28 != null) goto L93;
    L95:
        r27.putBoolean("dora_o_diary_show_back", r3);
        r25.setArguments(r27);
        FragmentTransaction r30 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r30, r25, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131369767) == true) goto L99;
        r30 = r30.replace(2131369767, r25);
    L99:
        r30.commitAllowingStateLoss();
        return;
    L93:
        if (r28.getBoolean("dora_o_diary_show_back") != true) goto L95;
        r3 = true;
        goto L95
    L86:
        r25 = new ODiaryAuthFragment();
        goto L87
    L52:
        if (r14.g(r2) != true) goto L54;
        r15 = true;
    L36:
        r10 = false;
    L79:
        r24 = false;
        goto L81
    L23:
        if (r2.length() == 0) goto L26;
        r7 = false;
        goto L27
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroyView() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        com.larus.dora.impl.serviceimpl.r r1 = r0.g1();
        if (r1 == null) goto L7;
        r1.d(this.e);
    L7:
        super.onDestroyView();
    }

    public ODiaryHostFragment() {
        this.e = new b(this);
    }

    public final void onResume() {
        super.onResume();
        S90();
    }

    public final void T90(String r5) {
        Intrinsics.checkNotNullParameter(r5, "date");
        Fragment r1 = getChildFragmentManager().findFragmentById(2131369767);
        if ((r1 instanceof ODiaryContentFragment) == false) goto L5;
        ODiaryContentFragment r2 = (ODiaryContentFragment) r1;
    L6:
        if (r2 == null) goto L17;
        Intrinsics.checkNotNullParameter(r5, "date");
        if (r5.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return;
    L13:
        if (r2.V90() == false) goto L19;
        FLogger.a.d("ODiaryContentFragment", "select diary date from entry: ".concat(r5));
        r2.U90().selectDateFromH5(r5);
        r2.Y90(r5);
        return;
    L19:
        return;
    L10:
        r0 = false;
        goto L11
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L7;
        com.larus.dora.impl.serviceimpl.r r6 = r5.g1();
        if (r6 == null) goto L7;
        r6.a(this.e);
    L7:
        getChildFragmentManager().setFragmentResultListener("dora_o_device_home_diary_data_changed", getViewLifecycleOwner(), new n0(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560144, r3, false);
    }
}
