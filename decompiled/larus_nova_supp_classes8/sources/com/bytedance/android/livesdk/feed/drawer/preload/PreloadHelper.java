package com.bytedance.android.livesdk.feed.drawer.preload;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawer/preload/PreloadHelper;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadHelper implements LifecycleObserver {
    public static TabFeedViewModel a;
    public static LiveDrawerTabViewModel b;
    public static final e c = null;
    public static final a d = null;
    public static int e;
    public static final PreloadHelper f = null;

    public static final class a implements LiveDrawerFeedRepository.c {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
        public final String NX(String r2) {
            Intrinsics.checkNotNullParameter(r2, "backUrl");
            return r2;
        }

        @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
        public final Integer s40() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
        public final long u20() {
            return -1;
        }

        @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
        public final boolean VF() {
            PreloadHelper.f.getClass();
            if (PreloadHelper.c.getType() != 1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
        public final String mg(boolean r8) {
            if (r8 == false) goto L26;
            PreloadHelper.f.getClass();
            if (PreloadHelper.c.getType() == 1) goto L26;
            StringBuilder r9 = new StringBuilder();
            boolean r2 = x0.d;
            List<e> r3 = x0.a.a().c();
            if (r3 == null) goto L23;
            ArrayList r4 = new ArrayList();
            Iterator<T> r5 = r3.iterator();
        L9:
            boolean r6 = false;
            if (r5.hasNext() == false) goto L17;
            Object r7 = r5.next();
            if (((e) r7).getType() != 1) goto L14;
            r6 = true;
        L14:
            if (r6 == false) goto L9;
            r4.add(r7);
            goto L9
        L17:
            if ((true ^ r4.isEmpty()) == true) goto L20;
            r4 = null;
        L20:
            if (r4 == null) goto L23;
            e r1 = (e) ListProtector.get(r4, 0);
            if (r1 == null) goto L23;
        L24:
            r9.append(r1.j());
            r9.append("-drawer_cover");
            return r9.toString();
        L23:
            r1 = PreloadHelper.c;
        L26:
            StringBuilder r10 = new StringBuilder();
            PreloadHelper.f.getClass();
            r10.append(PreloadHelper.c.j());
            r10.append("-drawer_cover");
            return r10.toString();
        }
    }

    private PreloadHelper() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e = 0;
        a = null;
        b = null;
    }

    static {
        f = new PreloadHelper();
        boolean r0 = x0.d;
        c = (e) ListProtector.get(x0.a.a().c(), 0);
        d = new a();
    }
}
