package com.bytedance.android.live.livelink.guestlink.media;

import com.bytedance.live.kmp.util.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/livelink/guestlink/media/GuestLinkMediaManager$mRtcListener$2$1", "invoke", "()Lcom/bytedance/android/live/livelink/guestlink/media/GuestLinkMediaManager$mRtcListener$2$1;"}, k = 3, mv = {1, 5, 1})
final class GuestLinkMediaManager$mRtcListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ GuestLinkMediaManager this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.livelink.guestlink.media.GuestLinkMediaManager$mRtcListener$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ii6.a {
        public final /* synthetic */ GuestLinkMediaManager$mRtcListener$2 a;

        public AnonymousClass1(GuestLinkMediaManager$mRtcListener$2 r1) {
            this.a = r1;
        }

        public final void H(ei6.a r1, final int r2, long r3, Exception r5) {
            d.b(0, false, new GuestLinkMediaManager$mRtcListener$2$1$onError$1(this, r2), 7);
        }

        public final void M(ei6.a r1, final int r2, long r3, final Object... r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            d.b(0, false, new GuestLinkMediaManager$mRtcListener$2$1$onInfo$1(this, r2, r5), 7);
        }
    }

    public GuestLinkMediaManager$mRtcListener$2(GuestLinkMediaManager r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m418invoke() {
        return invoke();
    }
}
