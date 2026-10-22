package com.larus.sheet.sdk.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.larus.office.base.plugins.media.BaseSelectMediaViewModel;
import com.larus.platform.service.n0;
import com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment;
import com.larus.sheet.sdk.impl.plugins.media.l0;
import com.larus.sheet.sdk.impl.plugins.media.m0;
import com.larus.utils.logger.FLogger;
import ew4.g0;
import kotlin.jvm.internal.Intrinsics;
import wm5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements g0 {
    public e() {
    }

    public final boolean O(int r4) {
        FLogger.a.d("SheetSdkServiceImplV2", "isMentionDetectEnabled, documentType=" + r4);
        return n0.a.b();
    }

    public final Fragment u1(PluginHost r5, int r6, final o r7) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r7, "closeToolbar");
        m0.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "pluginHost");
        Intrinsics.checkNotNullParameter(r7, "closeToolbar");
        FragmentActivity r0 = r5.getActivity();
        String r1 = SheetPhotoInsertFragment.class.getName();
        Bundle r2 = new Bundle();
        PluginHost.writePluginHostToBundle(r2, r5);
        r2.putInt("init_height", r6);
        Fragment r8 = Fragment.instantiate(r0, r1, r2);
        final BaseSelectMediaViewModel r9 = q.c(r5, BaseSelectMediaViewModel.class, null);
        r9.getHideContainer().observe(r8, new m0.a(new l0(r7, r9)));
        return r8;
    }
}
