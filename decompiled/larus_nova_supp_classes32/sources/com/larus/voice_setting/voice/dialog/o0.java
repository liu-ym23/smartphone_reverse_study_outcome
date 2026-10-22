package com.larus.voice_setting.voice.dialog;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class o0 implements Function1 {
    public final /* synthetic */ UgcVoiceInfoOptimizeDialog a;

    public /* synthetic */ o0(UgcVoiceInfoOptimizeDialog r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        UgcVoiceInfoOptimizeDialog r0 = this.a;
        boolean r5 = ((Boolean) r4).booleanValue();
        int r1 = UgcVoiceInfoOptimizeDialog.t;
        if (r5 == false) goto L17;
        k2 r6 = k2.a;
        ActivityResultLauncher r2 = null;
        if (r6.x() == false) goto L11;
        FragmentActivity r3 = r0.requireActivity();
        ActivityResultLauncher<Intent> r7 = r0.g;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("pickSDKLauncher");
    L10:
        AlbumSettingConfig.Companion.getClass();
        r6.h(r3, r2, AlbumSettingConfig.b.a());
        goto L17
    L9:
        r2 = r7;
        goto L10
    L11:
        ActivityResultLauncher<String> r8 = r0.f;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pickLauncher");
    L15:
        v19.b.a(r2, "image/*");
        goto L17
    L14:
        r2 = r8;
    L17:
        return Unit.INSTANCE;
    }
}
