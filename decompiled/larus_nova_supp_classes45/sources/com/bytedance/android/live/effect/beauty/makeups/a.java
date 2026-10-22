package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.makeups.a$a, reason: collision with other inner class name */
    public static final class C0185a {
        public static /* synthetic */ void a(a r1, Sticker r2, String r3) {
            ((d) r1).a(r2, r3, false);
        }
    }

    public interface b {
        void a(Sticker r1);

        void onError();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r1);
    }
}
