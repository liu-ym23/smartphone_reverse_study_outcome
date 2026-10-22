package com.obric.aiagent.platform.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Companion", "Empty", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface f extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5958b = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "getDirPath", "i", "isDebug", "", "uploadAllLog", MemoryInfoSectionEditActivity.KIND_SCENE, "callback", "Lkotlin/Function3;", "", BaseSwitches.V, "w", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements f {
        static final /* synthetic */ a c = null;
        private final /* synthetic */ f d;

        static {
            c = new a();
        }

        private a() {
            com.obric.aiagent.platform.b r0 = com.obric.aiagent.platform.a.f5946a.a();
            if (r0 == null) goto L6;
            f r1 = r0.e();
            if (r1 == null) goto L6;
        L9:
            this.d = r1;
            return;
        L6:
            r1 = (f) ZeusTransformUtils.preCheckCast(com.ss.android.ugc.aweme.framework.services.f.a().a(f.class, false, false), f.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L9;
            r1 = (f) ZeusTransformUtils.preCheckCast(b.c, f.class, "com.obric.memorydata.plugin");
            goto L9
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.a(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.a(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.b(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.b(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.c(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.d.d(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Empty;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", BaseSwitches.V, "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "d", "i", "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b implements f {
        public static final b c = null;

        static {
            c = new b();
        }

        private b() {
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void c(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        }
    }

    static {
        f5958b = a.c;
    }
}
