package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSpokenLanguageView extends FrameLayout {
    public final MmRecordingViewModel a;
    public final MmRecordingUILaunchMode b;
    public final Function0<Unit> c;
    public final RecyclerView d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmRecordingSpokenLanguageView a;

        public a(MmRecordingSpokenLanguageView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.c;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this);
        if (r0 == null) goto L8;
        CoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        int r2 = b.a;
        b.g(MmUiLogScene.LANGUAGE, "onAttachedToWindow", "onAttachedToWindow scope=" + r1, null, 8);
        this.a.selectSubscribe(r1, MmRecordingSpokenLanguageView$onAttachedToWindow$1$1.INSTANCE, MmRecordingSpokenLanguageView$onAttachedToWindow$1$2.INSTANCE, new MmRecordingSpokenLanguageView$onAttachedToWindow$1$3(this, null));
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = b.a;
        b.g(MmUiLogScene.LANGUAGE, "onDetachedFromWindow", null, null, 12);
    }

    public MmRecordingSpokenLanguageView(Context r5, MmRecordingViewModel r6, MmRecordingUILaunchMode r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "uiLaunchMode");
        super(r5, null);
        this.a = r6;
        this.b = r7;
        this.c = r8;
        e.a.getClass();
        e.b(r7).getLayout().n(LayoutInflater.from(c.c(r5, r7)), this);
        MmTitleBarView r9 = (MmTitleBarView) findViewById(2131388775);
        RecyclerView r1 = findViewById(2131384908);
        this.d = r1;
        MmRecordingViewModel.trackPageView$default(r6, "speak_language_view", null, 2, null);
        r9.setCloseClickListener(new a(this));
        r1.setLayoutManager(new LinearLayoutManager(r5));
        int r10 = uvb.b.a;
        uvb.a.b(this, uvb.c.H);
        uvb.b.a(this, 2131375905, uvb.c.J);
        uvb.b.a(this, 2131384908, uvb.c.I);
    }
}
