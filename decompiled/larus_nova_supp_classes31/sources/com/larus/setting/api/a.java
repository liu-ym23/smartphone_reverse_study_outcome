package com.larus.setting.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.platform.api.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d0 {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.larus.platform.api.d0
    public final void d() {
        SettingService.a.i();
    }

    @Override // com.larus.platform.api.d0
    public final void c(Fragment r2, View r3, String r4, by7.e r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        SettingService.a.c(r2, r3, r4, r5);
    }

    @Override // com.larus.platform.api.d0
    public final void b(Context r10, String r11, by7.e r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        SettingService.a.b(r10, r11, r12, r13, r14, r15, r16);
    }
}
