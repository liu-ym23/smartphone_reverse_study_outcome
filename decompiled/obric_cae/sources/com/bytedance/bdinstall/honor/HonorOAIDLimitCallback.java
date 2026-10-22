package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;
import java.util.Objects;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f3793a;

    public HonorOAIDLimitCallback() {
        this.f3793a = false;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public final void D0(int r8, Bundle r10) {
        Objects.toString(r10);
        int r11 = r.f13543a;
        if (r8 != 0) goto L7;
        if (r10 == null) goto L8;
        this.f3793a = r10.getBoolean("oa_id_limit_state");
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public final void k() {
    }
}
