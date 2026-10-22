package com.bytedance.bdinstall.dtrait.interfaces;

import com.bytedance.bdinstall.dtrait.manager.DTraitManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;

/* JADX INFO: loaded from: classes.dex */
public interface IDTraitService {
    DTraitManager getDTraitManager();

    DTraitNativeManager getDTraitNativeManager();
}
