package com.bytedance.android.live.liveinteract.voicechat;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r2, String r3, boolean r4, MediaOperation.a r5, int r6) {
            boolean r1 = false;
            if ((r6 & 2) == 0) goto L6;
            r4 = false;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r1 = true;
        L11:
            r2.d(r3, r4, r5, r1);
        }
    }

    void a(VoiceChatMuteManager.a r1);

    void b(String r1, MediaOperation.a r2);

    void c(LifecycleOwner r1, Observer<Boolean> r2);

    void d(String r1, boolean r2, MediaOperation.a r3, boolean r4);

    boolean e(boolean r1);

    void f(String r1, MediaOperation.a r2);

    void g(VoiceChatMuteManager.a r1);

    void h(String r1);

    boolean i();

    boolean isMute();
}
