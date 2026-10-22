package com.obric.assistant.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.lang.ref.SoftReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class StartActivityForResultHelper {
    public static final StartActivityForResultHelper a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0017J\b\u0010'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRN\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u000b0\u000b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/obric/assistant/util/StartActivityForResultHelper$PermissionPuppetFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "attached", "", "getAttached", "()Z", "setAttached", "(Z)V", "targetIntent", "Landroid/content/Intent;", "getTargetIntent", "()Landroid/content/Intent;", "setTargetIntent", "(Landroid/content/Intent;)V", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", WindowEvent.Params.RESULT, "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "startActivityForResult", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "getStartActivityForResult", "()Landroidx/activity/result/ActivityResultLauncher;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "activity", "Landroid/app/Activity;", "onDetach", "onDestroy", "requestAttach", "fm", "Landroidx/fragment/app/FragmentManager;", "requestDetach", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionPuppetFragment extends Fragment {
        public static final /* synthetic */ int h = 0;
        public boolean d;
        public Intent e;
        public Function2<? super Integer, ? super Intent, Unit> f;
        public final ActivityResultLauncher<Intent> g;

        public static final class a {
        }

        static {
        }

        public final void S90() {
            FLogger.a.i("StartActivityForResultHelper", "requestDetach " + hashCode());
            if (this.d == false) goto L6;
            requireActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        }

        public final void onDestroy() {
            FLogger.a.i("StartActivityForResultHelper", "onDestroy " + hashCode());
            super.onDestroy();
            this.f = null;
        }

        public final void onDetach() {
            FLogger.a.i("StartActivityForResultHelper", "onDetach " + hashCode());
            super.onDetach();
            this.d = false;
            this.f = null;
        }

        public PermissionPuppetFragment() {
            this.g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new o2(this));
        }

        @Deprecated(message = "Deprecated in Java")
        public final void onAttach(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            FLogger r0 = FLogger.a;
            r0.i("StartActivityForResultHelper", "onAttach " + hashCode());
            super.onAttach(r4);
            this.d = true;
            Intent r5 = this.e;
            if (r5 != null) goto L6;
            r0.e("StartActivityForResultHelper", "targetIntent is null in onAttach, cannot launch");
            final Function2<? super Integer, ? super Intent, Unit> r6 = this.f;
            SoftReference r1 = com.larus.utils.y.a;
            Runnable r2 = new n2(r6);
            Intrinsics.checkNotNullParameter(r2, "action");
            com.larus.utils.y.c(r2);
            S90();
            return;
        L6:
            this.g.launch(r5);
        }

        public final void onCreate(Bundle r1) {
            super.onCreate(r1);
            setRetainInstance(true);
        }
    }

    static {
        a = new StartActivityForResultHelper();
    }

    public StartActivityForResultHelper() {
    }

    public final void startActivityForResult(Intent r5, Function2<? super Integer, ? super Intent, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r6, "onSucceeded");
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L5;
    L21:
        FLogger.a.i("StartActivityForResultHelper", "top activity is not suitable");
        if (r7 == null) goto L27;
        r7.invoke();
        return;
    L27:
        return;
    L5:
        if ((r0 instanceof FragmentActivity) == false) goto L21;
        FLogger r8 = FLogger.a;
        r8.i("StartActivityForResultHelper", "startActivityForResult " + r6);
        FragmentManager r1 = r0.getSupportFragmentManager();
        int r2 = PermissionPuppetFragment.h;
        PermissionPuppetFragment r3 = (PermissionPuppetFragment) r1.findFragmentByTag("start_activity_for_result_helper_puppet");
        if (r3 != null) goto L10;
        r3 = new PermissionPuppetFragment();
    L10:
        r3.e = r5;
        r3.f = r6;
        if (r3.d == true) goto L19;
        r8.i("StartActivityForResultHelper", "not attached");
        Intrinsics.checkNotNullParameter(r1, "fm");
        r8.i("StartActivityForResultHelper", "requestAttach " + r3.hashCode());
        if (r3.d == true) goto L25;
        FragmentTransaction r9 = r1.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "start_activity_for_result_helper_puppet", 0) == true) goto L18;
        r9 = r9.add(r3, "start_activity_for_result_helper_puppet");
    L18:
        r9.commitAllowingStateLoss();
        return;
    L25:
        return;
    L19:
        r8.i("StartActivityForResultHelper", "already attached");
        r3.g.launch(r5);
    }
}
