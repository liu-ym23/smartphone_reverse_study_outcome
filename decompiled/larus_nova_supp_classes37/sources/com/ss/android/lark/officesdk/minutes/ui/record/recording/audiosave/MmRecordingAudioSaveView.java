package com.ss.android.lark.officesdk.minutes.ui.record.recording.audiosave;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAudioSaveView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public final MmRecordingViewModel a;
    public final Function0<Unit> b;
    public final View c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public final View h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmRecordingAudioSaveView a;

        public a(MmRecordingAudioSaveView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.a.dispatchEvent(g.e.a);
        super.onDetachedFromWindow();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AUDIO_SAVE, "onDetachedFromWindow", null, null, 12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.dispatchEvent(g.f.a);
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this);
        if (r0 == null) goto L8;
        CoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AUDIO_SAVE, "onAttachedToWindow", "onAttachedToWindow scope=" + r1, null, 8);
        this.a.selectSubscribe(r1, MmRecordingAudioSaveView$onAttachedToWindow$1$1.INSTANCE, new MmRecordingAudioSaveView$onAttachedToWindow$1$2(this, null));
        return;
    L9:
        return;
    }

    public MmRecordingAudioSaveView(Context r4, MmRecordingViewModel r5, MmRecordingUILaunchMode r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "uiLaunchMode");
        super(r4, null);
        this.a = r5;
        this.b = r7;
        e.a.getClass();
        mwb.a r8 = e.b(r6).getLayout().w(LayoutInflater.from(c.c(r4, r6)), this);
        MmTitleBarView r9 = r8.b;
        View r0 = r8.c;
        this.c = r0;
        View r1 = r8.d;
        this.d = r1;
        this.e = r8.e;
        this.f = r8.f;
        this.g = r8.g;
        this.h = r8.h;
        int r10 = uvb.b.a;
        uvb.a.b(this, uvb.c.O);
        uvb.b.a(this, 2131375905, uvb.c.P);
        uvb.b.a(this, 2131363398, uvb.c.Q);
        uvb.b.a(this, 2131363395, uvb.c.R);
        uvb.b.a(this, 2131363391, uvb.c.S);
        uvb.b.a(this, 2131363389, uvb.c.T);
        if (r5.getState().r.isSave() == false) goto L5;
        String r11 = "true";
    L6:
        r5.trackPageView("keep_audio_set", MapsKt.mapOf(TuplesKt.to("keep_audio_status", r11)));
        r9.setCloseClickListener(new a(this));
        r0.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r4).r(r4));
        r1.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r4).n(r4));
        h.a(r0, new AnonymousClass2(this));
        h.a(r1, new AnonymousClass3(this));
        return;
    L5:
        r11 = "false";
        goto L6
    }
}
