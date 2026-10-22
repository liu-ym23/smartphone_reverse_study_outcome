package com.bytedance.bdinstall.dtrait.extra_finger.impl;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.bytedance.bdinstall.dtrait.utils.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DM0Loader extends BaseExtraLoader {
    public DM0Loader(Context r3, JSONObject r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String getName() {
        return DTraitConstant.D_M0;
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String load() {
        MediaDrm r2 = null;
    L64:
        Throwable th = th;
    L66:
        if (Build.VERSION.SDK_INT < 28) goto L75;
        if (0 != 0) goto L92;
    L85:
        throw th;
    L92:
        r2.close();     // Catch: Exception -> L70
    L70:
        e = e;
        if (e.getCause() != null) goto L82;
    L83:
        String r0 = e.getMessage();
    L84:
        this.errorMsg = r0;
    L82:
        r0 = e.getCause().getMessage();
        goto L84
    L75:
        if (Build.VERSION.SDK_INT < 18) goto L85;
        if (0 == 0) goto L85;
        r2.release();     // Catch: Exception -> L79
    L79:
        e = e;
        if (e.getCause() == null) goto L83;
    L34:
        e = move-exception;
        MediaDrm r4 = null;
        Exception e = e;
    L37:
        if (e.getCause() == null) goto L40;
        String r3 = e.getCause().getMessage();     // Catch: Throwable -> L64
    L39:
        this.errorMsg = r3;     // Catch: Throwable -> L64
        if (Build.VERSION.SDK_INT < 28) goto L54;
        if (r4 == null) goto L102;
        r4.close();     // Catch: Exception -> L47
        return "";
    L47:
        e = e;
        if (e.getCause() == null) goto L51;
    L50:
        String r1 = e.getCause().getMessage();
    L52:
        this.errorMsg = r1;
        return "";
    L51:
        r1 = e.getMessage();
        goto L52
    L102:
        return "";
    L54:
        if (Build.VERSION.SDK_INT < 18) goto L104;
        if (r4 == null) goto L105;
        r4.release();     // Catch: Exception -> L58
        return "";
    L58:
        e = e;
        if (e.getCause() == null) goto L51;
    L105:
        return "";
    L104:
        return "";
    L40:
        r3 = e.getMessage();     // Catch: Throwable -> L64
    L32:
        th = move-exception;
        th = th;
        goto L66
    L4:
        if (Build.VERSION.SDK_INT < 18) goto L29;
        r4 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L32 Exception -> L34
        String r5 = Utils.bytesToHex(r4.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L26 Throwable -> L64
        if (Build.VERSION.SDK_INT < 28) goto L16;
        r4.close();     // Catch: Exception -> L11
    L25:
        return r5;
    L11:
        e = e;
        if (e.getCause() != null) goto L22;
    L23:
        String r6 = e.getMessage();
    L24:
        this.errorMsg = r6;
    L22:
        r6 = e.getCause().getMessage();
        goto L24
    L16:
        if (Build.VERSION.SDK_INT < 18) goto L25;
        r4.release();     // Catch: Exception -> L19
    L19:
        e = e;
        if (e.getCause() == null) goto L23;
    L26:
        e = e;
        goto L37
    L29:
        if (Build.VERSION.SDK_INT >= 28) goto L106;
        int r8 = Build.VERSION.SDK_INT;
        return "";
    L106:
        return "";
    }
}
