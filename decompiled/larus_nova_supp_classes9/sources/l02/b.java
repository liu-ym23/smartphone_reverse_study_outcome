package l02;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.scope.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements o, dy0.c {
    public final Map<Long, Integer> a;
    public final a b;
    public final j c;

    public static final class a implements IAssetsManager.b {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r8) {
            Intrinsics.checkNotNullParameter(r8, "assetsModels");
            if (this.a.a.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator<T> r9 = r8.iterator();
        L7:
            if (r9.hasNext() == false) goto L19;
            long r2 = ((com.bytedance.android.live.core.resources.e) r9.next()).getId();
            if (((LinkedHashMap) this.a.a).keySet().contains(Long.valueOf(r2)) == false) goto L7;
            b r0 = this.a;
            Map<Long, Integer> r1 = r0.a;
            LinkedHashMap r3 = (LinkedHashMap) r1;
            Integer r4 = (Integer) r3.get(Long.valueOf(r2));
            if (r4 == null) goto L13;
            int r5 = r4.intValue();
        L14:
            Intrinsics.checkNotNullParameter("JSB", "source");
            if (r5 != 1008) goto L17;
            AssetDownloadPriority r6 = AssetDownloadPriority.NORMAL;
        L18:
            AssetDownloadPriority r7 = r6;
            r0.c.r0(r2, new l02.a(r0), r5, r7);
            goto L7
        L17:
            r6 = AssetDownloadPriority.JSB_PLAY;
            goto L18
        L13:
            r5 = IAssetsManager.DownloadAssetsSource.SOURCE_JSB_PRELOADING;
            goto L14
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.c.l0(this.b);
        ((LinkedHashMap) this.a).clear();
    }

    public b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsManager");
        this.c = r2;
        this.a = new LinkedHashMap();
        this.b = new a(this);
    }
}
