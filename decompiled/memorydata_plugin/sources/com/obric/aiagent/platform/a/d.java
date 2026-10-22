package com.obric.aiagent.platform.a;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J2\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend;", "", BaseSwitches.V, "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "d", "i", "w", "tr", "", "e", "isDebug", "", "getDirPath", "uploadAllLog", MemoryInfoSectionEditActivity.KIND_SCENE, "callback", "Lkotlin/Function3;", "", "Companion", "AndroidLogcat", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5954a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$AndroidLogcat;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", BaseSwitches.V, "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "d", "i", "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5955b = null;

        static {
            f5955b = new a();
        }

        private a() {
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.d(r1, r2);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.w(r1, r2, r3);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.i(r1, r2);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.e(r1, r2, r3);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.a.d
        public void c(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.w(r1, r2);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.a.d
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            if (com.obric.aiagent.platform.a.a.f5948a.f() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            Log.e(r1, r2);
            return;
        L5:
            if (com.obric.aiagent.platform.a.a.f5948a.e() == true) goto L6;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "getDirPath", "i", "isDebug", "", "uploadAllLog", MemoryInfoSectionEditActivity.KIND_SCENE, "callback", "Lkotlin/Function3;", "", BaseSwitches.V, "w", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ b f5956b = null;
        private final /* synthetic */ d c;

        static {
            f5956b = new b();
        }

        private b() {
            com.obric.aiagent.platform.b r0 = com.obric.aiagent.platform.a.f5946a.a();
            if (r0 == null) goto L6;
            d r1 = r0.c();
            if (r1 == null) goto L6;
        L9:
            this.c = r1;
            return;
        L6:
            r1 = (d) ZeusTransformUtils.preCheckCast(com.ss.android.ugc.aweme.framework.services.f.a().a(d.class, false, false), d.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L9;
            r1 = (d) ZeusTransformUtils.preCheckCast(a.f5955b, d.class, "com.obric.memorydata.plugin");
            goto L9
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.a(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void a(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.a(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.b(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void b(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.b(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.c(r2, r3);
        }

        @Override // com.obric.aiagent.platform.a.d
        public void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            this.c.d(r2, r3);
        }
    }

    static {
        f5954a = b.f5956b;
    }

    void a(String r1, String r2);

    void a(String r1, String r2, Throwable r3);

    void b(String r1, String r2);

    void b(String r1, String r2, Throwable r3);

    void c(String r1, String r2);

    void d(String r1, String r2);
}
