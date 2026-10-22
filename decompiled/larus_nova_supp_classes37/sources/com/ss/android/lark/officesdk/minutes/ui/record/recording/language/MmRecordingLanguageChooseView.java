package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
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
public final class MmRecordingLanguageChooseView extends FrameLayout {
    public final MmRecordingViewModel a;
    public final Function0<Unit> b;
    public final Fragment c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public final MmNormalHintSwitchView f;
    public final MmNormalHintSwitchView g;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this);
        if (r0 == null) goto L8;
        CoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        int r2 = b.a;
        b.g(MmUiLogScene.LANGUAGE, "onAttachedToWindow", "onAttachedToWindow scope=" + r1, null, 8);
        this.a.selectSubscribe(r1, MmRecordingLanguageChooseView$onAttachedToWindow$1$1.INSTANCE, new MmRecordingLanguageChooseView$onAttachedToWindow$1$2(this, null));
        this.a.selectSubscribe(r1, MmRecordingLanguageChooseView$onAttachedToWindow$1$3.INSTANCE, new MmRecordingLanguageChooseView$onAttachedToWindow$1$4(this, null));
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

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView] */
    public MmRecordingLanguageChooseView(Context r4, MmRecordingViewModel r5, MmRecordingUILaunchMode r6, Function0 r7, Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "uiLaunchMode");
        super(r4, null);
        this.a = r5;
        this.b = r7;
        this.c = null;
        this.d = r8;
        this.e = r9;
        e.a.getClass();
        e.b(r6).getLayout().b(LayoutInflater.from(c.c(r4, r6)), this);
        MmTitleBarView r10 = (MmTitleBarView) findViewById(2131388775);
        LinearLayout r11 = (LinearLayout) findViewById(2131377145);
        ?? r12 = (MmNormalHintSwitchView) findViewById(2131380189);
        this.f = r12;
        ?? r1 = (MmNormalHintSwitchView) findViewById(2131380197);
        this.g = r1;
        r11.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r4).k(r4));
        r10.setCloseClickListener(new a(this));
        h.a(r12, new AnonymousClass2(this));
        h.a(r1, new AnonymousClass3(this));
        int r13 = uvb.b.a;
        uvb.b.a(this, 2131377145, uvb.c.x);
        uvb.b.a(this, 2131375905, uvb.c.y);
        View r14 = findViewById(2131380189);
        if (r14 == null) goto L5;
        uvb.b.a(r14, 2131385988, uvb.c.z);
        uvb.b.a(r14, 2131385991, uvb.c.A);
    L5:
        View r15 = findViewById(2131380197);
        if (r15 == null) goto L9;
        uvb.b.a(r15, 2131385988, uvb.c.D);
        uvb.b.a(r15, 2131385991, uvb.c.E);
        return;
    }
}
