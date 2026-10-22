package com.larus.bot.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J)\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b\"\u00020\u0005H&¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bot/api/IBotPerfMonitorService;", "", "start", "", "trackerKey", "", "eventName", "end", "param", "key", "keyValues", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotPerfMonitorService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J*\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000b\"\u00020\u0007H\u0096\u0001¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/api/IBotPerfMonitorService$Companion;", "Lcom/larus/bot/api/IBotPerfMonitorService;", "<init>", "()V", "end", "", "trackerKey", "", "param", "key", "keyValues", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "start", "eventName", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBotPerfMonitorService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IBotPerfMonitorService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bot.api.IBotPerfMonitorService
        public final void a(String... r3) {
            Intrinsics.checkNotNullParameter("profile_upload_avatar", "key");
            Intrinsics.checkNotNullParameter(r3, "keyValues");
            this.b.a(r3);
        }

        @Override // com.larus.bot.api.IBotPerfMonitorService
        public final void end(String r2) {
            Intrinsics.checkNotNullParameter(r2, "trackerKey");
            this.b.end(r2);
        }

        @Override // com.larus.bot.api.IBotPerfMonitorService
        public final void start(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "trackerKey");
            Intrinsics.checkNotNullParameter(r3, "eventName");
            this.b.start(r2, r3);
        }

        private Companion() {
            this.b = (IBotPerfMonitorService) ServiceManager.get().getService(IBotPerfMonitorService.class);
        }
    }

    static {
        a = Companion.c;
    }

    void a(String... r1);

    void end(String r1);

    void start(String r1, String r2);
}
