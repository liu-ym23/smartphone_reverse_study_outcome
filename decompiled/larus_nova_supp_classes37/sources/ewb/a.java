package ewb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {

    /* JADX INFO: renamed from: ewb.a$a, reason: collision with other inner class name */
    public static final class C0138a implements a {
        public static final C0138a a = null;

        static {
            a = new C0138a();
        }

        public C0138a() {
        }

        @Override // ewb.a
        public final void a(b r2, MmRecordingNotificationRepo r3, RecordingSessionType r4, CoroutineScope r5) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "notificationRepo");
            Intrinsics.checkNotNullParameter(r4, "sessionType");
            Intrinsics.checkNotNullParameter(r5, "scope");
        }

        @Override // ewb.a
        public final void clearAll() {
        }
    }

    void a(b r1, MmRecordingNotificationRepo r2, RecordingSessionType r3, CoroutineScope r4);

    void clearAll();
}
