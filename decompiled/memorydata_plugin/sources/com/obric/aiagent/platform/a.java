package com.obric.aiagent.platform;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.ugc.aweme.framework.services.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/AIAgentPlatform;", "", "<init>", "()V", WsConstants.KEY_PLATFORM, "Lcom/obric/aiagent/platform/IAIAgentPlatform;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "get", "get$platform_release", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f5947b;

    static {
        f5946a = new a();
    }

    private a() {
    }

    public final b a() {
        b r2 = f5947b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (b) ZeusTransformUtils.preCheckCast(f.a().a(b.class), b.class, "com.obric.memorydata.plugin");
    }

    public final void a(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, WsConstants.KEY_PLATFORM);
        f5947b = r1;
    }
}
