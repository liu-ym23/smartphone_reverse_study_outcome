package com.obric.audio.enroll;

import android.content.Context;
import com.obric.audio.enroll.view.EnrollStageView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/obric/audio/enroll/IEnrollService;", "", "createSamiHandle", "", "context", "Landroid/content/Context;", "deviceSn", "", "isDoraEnroll", "", "createPhoneSamiHandle", "startRecord", "taskId", "callback", "Lcom/obric/audio/enroll/EnrollAsrCallback;", "wakeupId", "stopRecord", "release", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IEnrollService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static IEnrollService a() {
            return (IEnrollService) ServiceManager.get().getService(IEnrollService.class, false, false);
        }
    }

    static {
        a = a.a;
    }

    void a(String r1);

    void b(Context r1, String r2, boolean r3);

    void c(Context r1);

    void d(String r1, EnrollStageView r2);

    void e(String r1, com.obric.audio.enroll.a r2, String r3);

    void release();
}
