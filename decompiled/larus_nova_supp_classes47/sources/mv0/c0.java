package mv0;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 extends qs0.a<IRoomService> implements qs0.v {

    public static final class a extends qs0.a<ILiveRecordService> {
        public final boolean k() {
            return ((ILiveRecordService) this.a).isClearScreen();
        }

        public final boolean l() {
            return ((ILiveRecordService) this.a).isRecording();
        }

        public a(ILiveRecordService r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }
    }

    public c0() {
        super(jc1.k.n(IRoomService.class));
    }

    @Override // qs0.v
    public final a getRecordService() {
        return new a(((IRoomService) this.a).getRecordService());
    }
}
