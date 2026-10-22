package b81;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.c;
import com.bytedance.android.live.room.api.screenrotation.entrance.judge.JudgeInit;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends EntranceChecker {

    /* JADX INFO: renamed from: b81.a$a, reason: collision with other inner class name */
    public static final class C0005a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0005a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IRotateEntrance r4 = (IRotateEntrance) r3;
            if (r4.getType() == IRotateEntrance.Type.UI) goto L5;
            return;
        L5:
            if ((r4 instanceof c) == false) goto L9;
            boolean r5 = this.a.a(r4);
            this.a.a.b(Boolean.valueOf(r5));
            return;
        }
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final void f() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final void e() {
        RxUtilKt.c(((IScreenRotateService) k.n(IScreenRotateService.class)).entranceVisibleNotify().a().subscribe(new C0005a(this)), this.c);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final List<com.bytedance.android.live.room.api.screenrotation.entrance.a> g() {
        return JudgeInit.a(this.e, this.f);
    }

    public a(RoomContext r1, DataCenter r2) {
        super(r1, r2);
    }
}
