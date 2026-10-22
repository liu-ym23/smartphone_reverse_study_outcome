package com.ss.android.lark.chameleonv2.lkapi.widget.picker;

import android.util.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FileInfo;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FilePickerCloseResult;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import itb.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements f {
    public final /* synthetic */ b a;

    public final void onCancel() {
        Callback r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        return;
    }

    public c(b r1) {
        this.a = r1;
    }

    public final void onError(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Callback r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.error(new LKAPIError(-1, r4));
        return;
    }

    public final void onSuccess(List<String> r9) {
        Intrinsics.checkNotNullParameter(r9, "filePaths");
        b r0 = this.a;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        Iterator<String> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        String r2 = r10.next();
        if (r2.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L4;
        VFSFile r4 = VFSFiles.b.i(r2);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        String[] r6 = FileUtils.a;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Long.valueOf(r4.length()));     // Catch: Throwable -> L13
    L16:
        if (Result.exceptionOrNull-impl(r7) == null) goto L19;
        r7 = Long.valueOf(new PolarisFileWrapper(r2).length());
    L19:
        long r8 = ((Number) r7).longValue();
        String r11 = FileUtils.l(r2);
        String r12 = r4.toUri().toString();
        Intrinsics.checkNotNull(r11);
        String r13 = String.valueOf(r8);
        LruCache<String, String> r14 = l0b.a.a;
        Intrinsics.checkNotNullParameter(r12, "value");
        String r15 = UUID.randomUUID().toString();
        l0b.a.a.put(r15, r12);
        r1.add(new IWidget$FileInfo(r15, r11, r13));
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L8:
        r3 = false;
        goto L9
    L20:
        Callback r17 = r0.a;
        if (r17 == null) goto L31;
        r17.success(new IWidget$FilePickerCloseResult(r1));
        return;
    }
}
