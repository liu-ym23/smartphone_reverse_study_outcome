package com.bytedance.android.live.effect;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.soundeffect.LiveSoundAdapter;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.live.effect.soundeffect.SoundItemDecoration;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/LiveSoundEffectDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSoundEffectDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int g = 0;
    public Map<Integer, View> d;
    public final LiveEffectContextFactoryDelegate$Type e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public LiveSoundEffectDialogFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f = LazyKt.lazy(new LiveSoundEffectDialogFragment$soundAdapter$2(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        LiveSoundAdapter r0 = (LiveSoundAdapter) this.f.getValue();
        LiveSoundEffectHelper r1 = r0.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r0, "callback");
        if (r1.b.contains(r0) == false) goto L7;
        r1.b.remove(r0);
    L7:
        r0.e.removeCallbacksAndMessages(null);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LiveSoundAdapter r0 = (LiveSoundAdapter) this.f.getValue();
        LiveSoundEffectHelper r1 = r0.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r0, "callback");
        if (r1.b.contains(r0) == true) goto L9;
        r1.b.add(r0);
        return;
    L9:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setGravity(80);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setSoftInputMode(3);
        return;
    L9:
        return;
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

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L7;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L7;
        r4.setLayout(-1, -1);
    L7:
        Dialog r5 = getDialog();
        if (r5 == null) goto L12;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L12;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r6.addFlags(Integer.MIN_VALUE);
    L12:
        Dialog r7 = getDialog();
        if (r7 == null) goto L18;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L19;
        r8.setStatusBarColor(0);
        return;
    L19:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954665);
        setCancelable(true);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        return r3;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        View r6 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r6.setOnClickListener(new o(this));
        S90(2131387005).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r6).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        S90(2131387005).showLoading();
        S90(2131392564).setOnClickListener(new p(this));
        S90(2131385012).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131385012).addItemDecoration(new SoundItemDecoration());
        S90(2131385012).setAdapter((LiveSoundAdapter) this.f.getValue());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565860, r3, false);
    }
}
