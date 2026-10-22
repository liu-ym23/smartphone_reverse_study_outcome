package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o2 implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment a;

    public o2(Fragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return this.a.getDefaultViewModelProviderFactory();
    }
}
