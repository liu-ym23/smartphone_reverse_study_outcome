package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 extends com.bytedance.android.livesdk.feed.tab.repository.l {
    public static final boolean d = false;

    public static final class a {
        public static NewTabRepository a() {
            return (NewTabRepository) NewTabRepository.d.getValue();
        }

        public static com.bytedance.android.livesdk.feed.tab.repository.l b() {
            if (x0.d == false) goto L6;
            return (NewTabRepository) NewTabRepository.d.getValue();
        L6:
            return com.bytedance.android.livesdk.feed.tab.repository.p.f();
        }
    }

    static {
        d = ((Boolean) l3.a.getValue()).booleanValue();
    }
}
