package mq1;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a0 {

    public static final class a {
        public static /* synthetic */ void a(a0 r8, String r9, String r10, String r11, DataCenter r12) {
            r8.logReport(false, r9, "", r10, r11, r12, null);
        }
    }

    void a(Long r1, long r2, long r4, String r6, String r7, long r8, String r10, String r11, DataCenter r12, Context r13);

    boolean c(Episode r1, Context r2, String r3, boolean r4, vk1.a r5, IBaseUser r6, DataCenter r7);

    void logReport(boolean r1, String r2, String r3, String r4, String r5, ViewModel r6, String r7);
}
