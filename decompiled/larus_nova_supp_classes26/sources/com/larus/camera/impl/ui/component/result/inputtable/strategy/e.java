package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends d {
    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d
    public final void k() {
        FLogger.a.e("ResultInputtableControlComponent", "updateSuggestedActionPosition EmptyStyleControlInputViewStrategy");
    }

    public e(ResultInputControlBinder.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inputComponentAbility");
        super(r2);
    }

    @Override // vx8.a
    public final CameraContainer.b d(CameraContainer.b r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        FLogger.a.e("ResultInputtableControlComponent", "createLayoutParams EmptyStyleControlInputViewStrategy");
        return r4;
    }

    @Override // vx8.a
    public final View f(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        FLogger.a.e("ResultInputtableControlComponent", "inflating EmptyStyleControlInputViewStrategy");
        return new View(r4.getContext());
    }
}
