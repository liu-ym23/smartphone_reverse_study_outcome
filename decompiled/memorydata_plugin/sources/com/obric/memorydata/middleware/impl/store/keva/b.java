package com.obric.memorydata.middleware.impl.store.keva;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.keva.KevaMonitor;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J8\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0014J8\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/middleware/impl/store/keva/MemoryKevaMonitor;", "Lcom/bytedance/keva/KevaMonitor;", "<init>", "()V", "TAG", "", "onLoadRepo", "", "repoName", "mode", "", "reportWarning", "action", "key", EventBody.KEY_VALUE, "", NotificationCompat.CATEGORY_MESSAGE, "reportThrowable", "throwable", "", "logDebug", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends KevaMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11872a;

    public b() {
        this.f11872a = "MemoryKevaMonitor";
    }

    @Override // com.bytedance.keva.KevaMonitor
    public void logDebug(String r4) {
        RunLog.INSTANCE.debug(this.f11872a, "msg: " + r4);
    }

    @Override // com.bytedance.keva.KevaMonitor
    public void onLoadRepo(String r1, int r2) {
        super.onLoadRepo(r1, r2);
    }

    @Override // com.bytedance.keva.KevaMonitor
    public void reportThrowable(int r7, String r8, String r9, Object r10, Throwable r11) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11872a, "action: " + r7 + ", repoName: " + r8 + ", key: " + r9 + ", throwable: " + r11, null, 4, null);
    }

    @Override // com.bytedance.keva.KevaMonitor
    public void reportWarning(int r7, String r8, String r9, Object r10, String r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11872a, "action: " + r7 + ", repoName: " + r8 + ", key: " + r9 + ", msg: " + r11, null, 4, null);
    }
}
