package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a {
    public final Context a;
    public final ViewGroup b;
    public final Fragment c;
    public final Function0<Boolean> d;
    public final String e;
    public final ImmersiveVoiceView f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final Pair<Integer, Integer> getLayoutParamAttributes() {
        return new Pair(-1, -1);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final View getContentView() {
        return this.f;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final void t5(Function0<Unit> r1) {
        r1.invoke();
    }

    public static final void a(b0 r5, int r6) {
        Context r0 = r5.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        FlowToast.a r1 = FlowToast.a(r0);
        r1.e(r6);
        r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131254921));
        View r7 = r5.f.findViewById(2131385901);
        if (r7 != null) goto L6;
    L11:
        int r8 = 0;
    L12:
        r1.c(80, 0, r8);
        r1.a().show();
        return;
    L6:
        if (r7.getHeight() <= 0) goto L11;
        if (r5.b.getHeight() <= 0) goto L11;
        int[] r3 = new int[2];
        int[] r2 = new int[2];
        r7.getLocationOnScreen(r3);
        r5.b.getLocationOnScreen(r2);
        r8 = RangesKt.coerceAtLeast(((r2[1] + r5.b.getHeight()) - r3[1]) + UIUtils.dp2px(r5.a, 8.0f), 0);
        goto L12
    }

    public static final void b(b0 r2, int r3) {
        Context r4 = r2.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        FlowToast.a r0 = FlowToast.a(r4);
        r0.e(r3);
        r0.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r4, 2131254921));
        r0.c(17, 0, 0);
        r0.a().show();
    }

    public b0(Context r13, AudioPopupWindowImpl.b r14, Fragment r15, FragmentActivity r16, Float r17, IVoiceFaceDependency r18, Function0 r19, a0 r20) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "decorView");
        Intrinsics.checkNotNullParameter(r19, "isContainerRootView");
        Intrinsics.checkNotNullParameter(r20, "keyboardMenuConfig");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r19;
        this.e = "ImmersiveVoicePopupView";
        this.f = new ImmersiveVoiceView(r13, r14, r15, r16, r17, r18, r19, r20);
        Lazy r1 = LazyKt.lazy(new ImmersiveVoicePopupView$immersiveVoiceViewModel$2(this));
        this.g = r1;
        ImmersiveVoiceViewModel r2 = (ImmersiveVoiceViewModel) r1.getValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r2.getVoiceRecordTooShort().observe(r15, new c0(this));
        r2.getShouldShowAsrWaitingPoorNetTips().observe(r15, new d0(this));
        r2.getShouldShowPoorNetTips().observe(r15, new e0(this));
        r2.getRecordingOccurException().observe(r15, new f0(this));
    }
}
