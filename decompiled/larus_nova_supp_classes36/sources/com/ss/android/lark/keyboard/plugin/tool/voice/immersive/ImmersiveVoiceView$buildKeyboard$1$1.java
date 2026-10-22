package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin.VoiceFaceKBPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/keyboard2/IKeyboardMenu;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImmersiveVoiceView$buildKeyboard$1$1 extends Lambda implements Function1<com.ss.android.lark.keyboard.keyboard2.d, Unit> {
    final /* synthetic */ IVoiceFaceDependency $faceKBPluginDependency;
    final /* synthetic */ FragmentActivity $hostActivity;
    final /* synthetic */ Fragment $hostFragment;
    final /* synthetic */ ImmersiveVoiceView this$0;

    public ImmersiveVoiceView$buildKeyboard$1$1(ImmersiveVoiceView r1, FragmentActivity r2, IVoiceFaceDependency r3, Fragment r4) {
        this.this$0 = r1;
        this.$hostActivity = r2;
        this.$faceKBPluginDependency = r3;
        this.$hostFragment = r4;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceView] */
    public final void invoke(com.ss.android.lark.keyboard.keyboard2.d r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$buildKeyboardMenu");
        ?? r0 = this.this$0;
        if (r0.f.a == false) goto L9;
        FragmentActivity r1 = this.$hostActivity;
        IVoiceFaceDependency r2 = this.$faceKBPluginDependency;
        Fragment r3 = this.$hostFragment;
        if (((Boolean) r0.e.invoke()).booleanValue() == false) goto L7;
        FragmentManager r4 = r1.getSupportFragmentManager();
    L8:
        Intrinsics.checkNotNull(r4);
        r6.G(new VoiceFaceKBPlugin(h18.f.a(r0.getContext()), r4, r2));
        goto L9
    L7:
        r4 = r3.getChildFragmentManager();
    L9:
        ImmersiveVoiceView r5 = this.this$0;
        if (r5.f.b == false) goto L12;
        r6.G(ImmersiveVoiceView.R5(r5));
    L12:
        com.ss.android.lark.keyboard.keyboard2.g.a.getClass();
        r6.q(com.ss.android.lark.keyboard.keyboard2.g.a.c);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.ss.android.lark.keyboard.keyboard2.d) r1);
        return Unit.INSTANCE;
    }
}
