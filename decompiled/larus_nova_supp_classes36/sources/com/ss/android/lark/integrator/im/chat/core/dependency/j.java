package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements w4b.s {
    public j() {
    }

    public final Observable a(final Context r8, final String r9, boolean r10, final boolean r11, final OnUpdateProgressListener r12, final Biz r13, final Scene r14) {
        if (r12 == null) goto L5;
        r12.onUpdateProgress(100, 0, 0);
    L5:
        final VFSFile r0 = VFSFiles.b.i(r9);
        return Observable.just(Boolean.valueOf(r10)).flatMap(new com.ss.android.lark.image.c(r0, r8, r13, r14)).flatMap(new com.ss.android.lark.image.d(r12, r11)).map(new com.ss.android.lark.image.e(r12, r9)).map(new i());
    }
}
