package yrb;

import com.bytedance.lark.pb.basic.v1.MoltenInvokeMeta;
import com.bytedance.lark.view_flow_wrapper.e;
import com.bytedance.lark.view_flow_wrapper.k;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements e {
    public a() {
    }

    public final byte[] a(k r6) {
        Intrinsics.checkNotNullParameter(r6, "info");
        String r2 = k0.a(10);     // Catch: Throwable -> L5
        byte[] r3 = MoltenInvokeMeta.ADAPTER.encode(new MoltenInvokeMeta.Builder().context_id(r2).build());     // Catch: Throwable -> L5
        Log.i("MoltenFFIContextHook", "onInvoke context_id:" + r2 + ", info:" + r6);     // Catch: Throwable -> L5
        return r3;
    L5:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvoke failed, info:" + r6 + ", error: " + th.getMessage());
        return null;
    }

    public final void onInvokeeEnd(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "invokeeObj");
    L10:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvokeeEnd failed, error: " + th.getMessage());
        return;
    L4:
        if ((r4 instanceof MoltenInvokeMeta) == false) goto L6;
        MoltenInvokeMeta r5 = (MoltenInvokeMeta) r4;     // Catch: Throwable -> L10
    L7:
        if (r5 == null) goto L15;
        Log.i("MoltenFFIContextHook", "onInvokeeEnd context_id:" + r5.context_id);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L6:
        r5 = null;
        goto L7
    }

    public final MoltenInvokeMeta onInvokeeStart(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "hookBuf");
        Object r7 = MoltenInvokeMeta.ADAPTER.decode(r6);     // Catch: Throwable -> L9
        MoltenInvokeMeta r3 = (MoltenInvokeMeta) r7;     // Catch: Throwable -> L9
        StringBuilder r4 = new StringBuilder("onInvokeeStart context_id:");     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r1 = r3.context_id;     // Catch: Throwable -> L9
    L7:
        r4.append(r1);     // Catch: Throwable -> L9
        Log.i("MoltenFFIContextHook", r4.toString());     // Catch: Throwable -> L9
        return (MoltenInvokeMeta) r7;
    L6:
        r1 = null;
    L9:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvokeeStart failed, error: " + th.getMessage());
        return null;
    }
}
