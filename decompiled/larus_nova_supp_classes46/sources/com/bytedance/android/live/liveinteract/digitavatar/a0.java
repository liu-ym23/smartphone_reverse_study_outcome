package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 {
    public long a;
    public final b0 b;
    public final Map<AvatarGender, y.a> c;
    public b d;

    public static final class a implements y.a {
        public final AvatarGender a;
        public final long b;
        public final b c;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r6) {
            Intrinsics.checkNotNullParameter(r6, "sticker");
            ALogger.i("KtvDigitAvatar", "预下载" + this.a + " avatar形象道具(stickId=" + this.a.getStickId() + ")success，耗时 " + (System.currentTimeMillis() - this.b) + "ms");
            b r0 = this.c;
            if (r0 == null) goto L6;
            r0.d(this.a, r6);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            ALogger.w("KtvDigitAvatar", "预下载" + this.a + " avatar形象道具(stickId=" + this.a.getStickId() + ")fail，耗时 " + (System.currentTimeMillis() - this.b) + "ms", r6);
            b r0 = this.c;
            if (r0 == null) goto L6;
            r0.a(this.a, r6);
            return;
        }

        public a(AvatarGender r2, long r3, b r5) {
            Intrinsics.checkNotNullParameter(r2, "gender");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public interface b {
        void a(AvatarGender r1, Exception r2);

        void b(Exception r1);

        void c(Sticker r1);

        void d(AvatarGender r1, Sticker r2);
    }

    public a0() {
        this.d = null;
        this.b = new b0(this);
        this.c = new LinkedHashMap();
    }

    public final void a(AvatarGender r5) {
        if (((LinkedHashMap) y.a).get(r5) != null) goto L5;
        ALogger.i("KtvDigitAvatar", "开始预下载" + r5 + " avatar形象道具(stickId=" + r5.getStickId() + ')');
        System.currentTimeMillis();
        a r0 = new a(r5, System.currentTimeMillis(), this.d);
        this.c.put(r5, r0);
        y.b(r5, r0);
        return;
    L5:
        ALogger.i("KtvDigitAvatar", r5 + " avatar形象道具(stickId=" + r5.getStickId() + ")已经下载好了，不需要预下载, stickId=" + r5.getStickId());
    }
}
