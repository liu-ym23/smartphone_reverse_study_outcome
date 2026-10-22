package com.larus.sheet.sdk.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.sheet.panel.oppanel.s;
import com.larus.office.base.plugins.media.BaseSelectMediaViewModel;
import com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertWithHeaderFragment;
import com.larus.sheet.sdk.impl.plugins.media.m0;
import ew4.f0;
import ew4.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements f0 {
    public d() {
    }

    public final Fragment v1(s r5, final k0 r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "request");
        m0.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "request");
        PluginHost r0 = r5.a();
        FragmentActivity r7 = r5.getActivity();
        int r1 = r6.c;
        Bundle r2 = new Bundle();
        if (r0 == null) goto L5;
        PluginHost.writePluginHostToBundle(r2, r0);
    L5:
        r2.putInt("init_height", r1);
        Fragment r8 = Fragment.instantiate(r7, SheetPhotoInsertWithHeaderFragment.class.getName(), r2);
        final BaseSelectMediaViewModel r3 = null;
        if (r0 == null) goto L8;
        r3 = (BaseSelectMediaViewModel) q.c(r0, BaseSelectMediaViewModel.class, null);
    L8:
        if (r3 == null) goto L12;
        LiveData r4 = r3.getHideContainer();
        if (r4 == null) goto L12;
        r4.observe(r8, new m0.a(new com.larus.sheet.sdk.impl.plugins.media.k0(r6, r3)));
    L12:
        return r8;
    }
}
