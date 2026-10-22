package com.ss.android.agilelogger;

import com.bytedance.android.alog.ILibLoader;

/* JADX INFO: loaded from: classes2.dex */
class d implements ILibLoader {
    d() {
    }

    @Override // com.bytedance.android.alog.ILibLoader
    public void loadLibrary(String r10) {
        com.bytedance.librarian.a.a("alog", ALog.sConfig.e());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("alog");
    }
}
