package com.obric.assistant.component;

import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricIntercomComponent$f implements com.obric.assistant.view.listening.f.b {
    public final /* synthetic */ ObricIntercomComponent a;

    @Override // com.obric.assistant.view.listening.f.b
    public final void a() {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        r0.X3().f(ObricListeningViewState.d);
        boolean r2 = false;
        this.a.B4(false);
        com.obric.audio.continuous_talk.b r3 = this.a.H3();
        if (r3 != null) goto L5;
    L7:
        if (r2 == true) goto L10;
        this.a.X3().animate().cancel();
        this.a.X3().setAlpha(0.0f);
        this.a.X3().setVisibility(8);
        this.a.U.setValue(Boolean.FALSE);
        return;
    L10:
        return;
    L5:
        if (r3.m0() != true) goto L7;
        r2 = true;
        goto L7
    }

    @Override // com.obric.assistant.view.listening.f.b
    public final void c() {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        r0.B4(true);
        this.a.e4();
    }

    @Override // com.obric.assistant.view.listening.f.b
    public final boolean isAvailable() {
        ObricIntercomComponent r0 = this.a;
        if (r0.W == false) goto L5;
    L7:
        return false;
    L5:
        if (IWindowContextKt.isWindowContext(r0.getContext()) == false) goto L7;
        return true;
    }

    public ObricIntercomComponent$f(ObricIntercomComponent r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.view.listening.f.b
    public final void b(ArrayList<Double> r5) {
        Intrinsics.checkNotNullParameter(r5, "sampleData");
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        boolean r2 = false;
        if (r0.W3().getParent() == null) goto L11;
        if (r0.W3().getVisibility() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        r0.W3().setAudioData(r5);
        goto L11
    L7:
        r3 = false;
    L11:
        if (r0.d4().getParent() == null) goto L19;
        if (r0.d4().getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        ((AudioContinueGradientView) r0.P0.getValue()).setAudioData(r5);
        goto L19
    L15:
        r4 = false;
    L19:
        if (r0.X3().getParent() != null) goto L21;
        return;
    L21:
        if (r0.X3().getVisibility() != 0) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L27;
        r0.X3().setAudioData(r5);
        return;
    }
}
