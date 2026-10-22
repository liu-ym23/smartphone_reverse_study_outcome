package com.larus.dora.impl.util;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.dialog.CommonDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraConnectChecker {
    public static final /* synthetic */ int e = 0;
    public final Fragment a;
    public ActivityResultLauncher<Intent> b;
    public CommonDialog c;
    public Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public DoraConnectChecker(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.d = new i();
    }

    public final void a(String r11, String r12, Function0<Unit> r13) {
        g49.d.d("DoraConnectChecker", "checkReady: " + r11 + " start");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new DoraConnectChecker$checkReady$1(r11, r13, this, r12, null), 3, null);
    }
}
