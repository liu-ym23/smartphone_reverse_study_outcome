package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.wschannel.heartbeat.model.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends com.bytedance.common.wschannel.heartbeat.model.a> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f2114a;

    public a(T r3) {
        this.f2114a = (T) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.heartbeat.model.a.class, "com.obric.memorydata.plugin");
    }

    public abstract void a(c r1, Handler r2);
}
