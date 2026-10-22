package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView;
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
public final class MmRecordingTranslateLanguageView extends FrameLayout {
    public final MmRecordingViewModel a;
    public final MmRecordingUILaunchMode b;
    public final Function0<Unit> c;
    public final RecyclerView d;
    public final MmNormalHintSwitchView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmRecordingTranslateLanguageView a;

        public a(MmRecordingTranslateLanguageView r1) {
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
        this.a.selectSubscribe(r1, MmRecordingTranslateLanguageView$onAttachedToWindow$1$1.INSTANCE, new MmRecordingTranslateLanguageView$onAttachedToWindow$1$2(this, null));
        this.a.selectSubscribe(r1, MmRecordingTranslateLanguageView$onAttachedToWindow$1$3.INSTANCE, MmRecordingTranslateLanguageView$onAttachedToWindow$1$4.INSTANCE, new MmRecordingTranslateLanguageView$onAttachedToWindow$1$5(this, null));
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

    public MmRecordingTranslateLanguageView(Context r7, MmRecordingViewModel r8, MmRecordingUILaunchMode r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        Intrinsics.checkNotNullParameter(r9, "uiLaunchMode");
        super(r7, null);
        this.a = r8;
        this.b = r9;
        this.c = r10;
        e.a.getClass();
        e.b(r9).getLayout().A(LayoutInflater.from(c.c(r7, r9)), this);
        MmTitleBarView r11 = (MmTitleBarView) findViewById(2131388775);
        RecyclerView r1 = findViewById(2131384908);
        this.d = r1;
        MmNormalHintSwitchView r3 = (MmNormalHintSwitchView) findViewById(2131380179);
        this.e = r3;
        ((LinearLayout) findViewById(2131380196)).setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r7).k(r7));
        MmRecordingViewModel.trackPageView$default(r8, "translation_language_view", null, 2, null);
        r11.setCloseClickListener(new a(this));
        r1.setLayoutManager(new LinearLayoutManager(r7));
        r3.setOnCheckedChangeListener(new AnonymousClass2(this));
        int r12 = uvb.b.a;
        uvb.a.b(this, uvb.c.K);
        uvb.b.a(this, 2131375905, uvb.c.M);
        uvb.b.a(this, 2131384908, uvb.c.L);
        View r13 = findViewById(2131380179);
        if (r13 == null) goto L6;
        uvb.b.a(r13, 2131386000, uvb.c.N);
        return;
    }
}
