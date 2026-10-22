package com.obric.matrix.platform.sdk.ones.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/CrashProvider;", "", "()V", "TAG", "", "crashPortraitList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "provideCrashPortraits", "", "refreshJson", "", "json", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.bytedance.platform.godzilla.common.b> f8103b = null;

    static {
        f8102a = new b();
        f8103b = new CopyOnWriteArrayList();
    }

    private b() {
    }

    public final List<com.bytedance.platform.godzilla.common.b> a() {
        return (List) ZeusTransformUtils.preCheckCast(f8103b, List.class, "com.obric.memorydata.plugin");
    }
}
