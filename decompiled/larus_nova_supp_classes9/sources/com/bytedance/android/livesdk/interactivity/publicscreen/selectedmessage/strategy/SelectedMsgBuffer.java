package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.common.utils.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.SelectedMsgViewManager;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SelectedMsgBuffer {
    public final List<a> a;
    public final Deque<f<?>> b;
    public final Queue<f<?>> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/strategy/SelectedMsgBuffer$DropReason;", BuildConfig.FLAVOR, "OVER_TIME", "BUFFER_SIZE_LIMIT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DropReason extends Enum<DropReason> {
        public static final DropReason BUFFER_SIZE_LIMIT = null;
        public static final DropReason OVER_TIME = null;
        public static final /* synthetic */ DropReason[] a = null;

        static {
            DropReason r1 = new DropReason("OVER_TIME", 0);
            OVER_TIME = r1;
            DropReason r2 = new DropReason("BUFFER_SIZE_LIMIT", 1);
            BUFFER_SIZE_LIMIT = r2;
            a = new DropReason[]{r1, r2};
        }

        public static DropReason valueOf(String r1) {
            return (DropReason) r27.a.a(DropReason.class, r1);
        }

        public static DropReason[] values() {
            return (DropReason[]) a.clone();
        }

        public DropReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(f<?> r1, DropReason r2);

        void b(f<?> r1, int r2);
    }

    public SelectedMsgBuffer(SelectedMsgViewManager r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedDataSource");
        this.a = new ArrayList();
        this.b = new ArrayDeque();
        this.c = new PriorityQueue(11, new d());
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer$pollWithAiMessage$1] */
    public final List<f<?>> a(c r4) {
        Intrinsics.checkNotNullParameter(r4, "updateInfo");
        final ArrayList r0 = new ArrayList();
        int r5 = r4.a;
        final Ref.IntRef r1 = new Ref.IntRef();
        r1.element = r5;
        if (r5 <= 0) goto L22;
        ?? r6 = new SelectedMsgBuffer$pollWithAiMessage$1(r0, r1);
        f r2 = (f) ((PriorityQueue) this.c).poll();
        if (r2 == null) goto L9;
        r6.invoke(r2);
    L9:
        if (r1.element <= 0) goto L16;
        if ((!((ArrayDeque) this.b).isEmpty()) == false) goto L16;
        f r3 = (f) ((ArrayDeque) this.b).poll();
        if (r3 == null) goto L9;
        r6.invoke(r3);
    L16:
        if (r1.element <= 0) goto L22;
        if ((!this.c.isEmpty()) == false) goto L22;
        f r7 = (f) ((PriorityQueue) this.c).poll();
        if (r7 == null) goto L16;
        r6.invoke(r7);
    L22:
        return r0;
    }

    public final void b(f<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        int r0 = SelectedMsgABHelper.b().messageBufferSize;
        k.a(this.b, r0, r4, new SelectedMsgBuffer$push$1(this));
    }
}
