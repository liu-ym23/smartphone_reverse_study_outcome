package com.larus.audio.ttsV2;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.d4;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"com/larus/audio/ttsV2/TtsInterrupter$initInterruptParams$cachingLive$1", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "fragmentRef", "Ljava/lang/ref/SoftReference;", "Landroidx/fragment/app/Fragment;", "onPause", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TtsInterrupter$initInterruptParams$cachingLive$1 extends SafeLifecycleObserver {
    public final SoftReference<Fragment> a;
    public final /* synthetic */ String b;

    public final void onDestroy(LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r7, "owner");
        g0 r0 = g0.a;
        r0.getClass();
        boolean r1 = false;
        g0.c = false;
        r0.getClass();
        int r2 = System.identityHashCode(r7);
        Map<String, Map<Integer, g0.a>> r3 = g0.b;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Map r5 = (Map) r4.get(this.b);
        if (r5 == null) goto L7;
        g0.a r6 = (g0.a) r5.get(Integer.valueOf(r2));
        if (r6 == null) goto L7;
        r6.a.removeObservers(r7);
        r7.getLifecycle().removeObserver(r6.c);
    L7:
        if (r5 == null) goto L9;
        g0.a r8 = (g0.a) r5.remove(Integer.valueOf(r2));
    L9:
        if (r5 != null) goto L11;
    L13:
        if (r1 == false) goto L16;
        r3.remove(this.b);
        return;
    L16:
        return;
    L11:
        if (r5.isEmpty() != true) goto L13;
        r1 = true;
        goto L13
    }

    public final void onPause(LifecycleOwner r6) {
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r6, "owner");
        g0 r0 = g0.a;
        String r1 = this.b;
        r0.getClass();
        int r7 = System.identityHashCode(r6);
        Map r2 = (Map) ((LinkedHashMap) g0.b).get(r1);
        boolean r3 = false;
        if (r2 != null) goto L5;
    L21:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L26;
        FLogger.a.i("TtsInterrupter", "onPause blocked, has resumed owner for cvsId=" + this.b);
        return;
    L26:
        Fragment r9 = this.a.get();
        if (r9 == null) goto L33;
        FragmentActivity r10 = r9.getActivity();
        if (r10 == null) goto L33;
        if (r10.isFinishing() != true) goto L33;
        r3 = true;
    L33:
        if (r3 == false) goto L35;
    L38:
        FLogger r11 = FLogger.a;
        StringBuilder r4 = new StringBuilder("activity isFinishing stopAndRemoveAllTask, enableTtsStateCheckBeforeCancel: ");
        z2 r5 = z2.a;
        r4.append(r5.enableTtsStateCheckBeforeCancel());
        r4.append(" , ttsState: ");
        IFlowTtsClientService.a.getClass();
        r4.append(IFlowTtsClientService.a.a().m().name());
        r11.i("TtsInterrupter", r4.toString());
        if (r5.enableTtsStateCheckBeforeCancel() == false) goto L44;
        if (IFlowTtsClientService.a.a().m() != PlayStateEnum.PLAY_STATE_PLAYING) goto L44;
        IAIChatAudioService.a.cancel();
        return;
    L44:
        if (r5.enableTtsStateCheckBeforeCancel() == true) goto L54;
        IAIChatAudioService.a.cancel();
        return;
    L54:
        return;
    L35:
        if (ObricTtsControlDelegate.b.f() == true) goto L38;
        g0.a.getClass();
        if (ITtsBackgroundPlayControlService.a.a() == true) goto L38;
        return;
    L5:
        if (r2.isEmpty() == true) goto L18;
        Iterator r12 = r2.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        int r14 = ((Number) r13.getKey()).intValue();
        g0.a r15 = (g0.a) r13.getValue();
        if (r14 != r7) goto L13;
    L15:
        boolean r16 = false;
    L16:
        if (r16 == false) goto L9;
        boolean r17 = true;
    L19:
        if (r17 != true) goto L21;
        r8 = true;
        goto L23
    L13:
        if (r15.b.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L15;
        r16 = true;
    L18:
        r17 = false;
        goto L19
    }

    public final void onStop(final LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Fragment r0 = this.a.get();
        boolean r1 = false;
        if (r0 == null) goto L9;
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L9;
        if (r2.isFinishing() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("TtsInterrupter", "activity isFinishing，just retur");
        return;
    L12:
        Fragment r3 = this.a.get();
        FragmentActivity r4 = null;
        if (r3 == null) goto L15;
        FragmentActivity r6 = r3.getActivity();
    L16:
        if (r6 == null) goto L25;
        AppHost.Companion r7 = AppHost.a;
        Activity r8 = r7.a().getCurrentActivity();
        Fragment r9 = this.a.get();
        if (r9 == null) goto L21;
        r4 = r9.getActivity();
    L21:
        if (Intrinsics.areEqual(r8, r4) == true) goto L25;
        if ((r7.a().getCurrentActivity() instanceof d4) == false) goto L25;
        return;
    L25:
        final String r10 = this.b;
        t0.d(new h0(r5, this, r10), 100);
        return;
    L15:
        r6 = null;
        goto L16
    }

    public TtsInterrupter$initInterruptParams$cachingLive$1(Fragment r1, String r2) {
        this.b = r2;
        this.a = new SoftReference(r1);
    }
}
