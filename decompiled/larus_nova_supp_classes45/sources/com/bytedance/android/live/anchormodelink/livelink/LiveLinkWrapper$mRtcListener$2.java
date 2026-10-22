package com.bytedance.android.live.anchormodelink.livelink;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/anchormodelink/livelink/LiveLinkWrapper$mRtcListener$2$1", "invoke", "()Lcom/bytedance/android/live/anchormodelink/livelink/LiveLinkWrapper$mRtcListener$2$1;"}, k = 3, mv = {1, 5, 1})
public final class LiveLinkWrapper$mRtcListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ LiveLinkWrapper this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.anchormodelink.livelink.LiveLinkWrapper$mRtcListener$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ii6.a {
        public final /* synthetic */ LiveLinkWrapper$mRtcListener$2 a;

        public AnonymousClass1(LiveLinkWrapper$mRtcListener$2 r1) {
            this.a = r1;
        }

        public final void H(ei6.a r7, final int r8, final long r9, final Exception r11) {
            com.bytedance.live.kmp.util.d.b(0, false, new LiveLinkWrapper$mRtcListener$2$1$onError$1(this, r8, r9, r11), 7);
        }

        public final void M(ei6.a r7, int r8, long r9, Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "params");
            com.bytedance.live.kmp.util.d.b(0, false, new LiveLinkWrapper$mRtcListener$2$1$onInfo$1(this, r8, r9, r11), 7);
        }
    }

    public LiveLinkWrapper$mRtcListener$2(LiveLinkWrapper r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m20invoke() {
        return invoke();
    }
}
