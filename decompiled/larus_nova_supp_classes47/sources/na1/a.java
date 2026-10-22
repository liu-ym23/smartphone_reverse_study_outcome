package na1;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.entrance.c;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b {
    public static final PublishSubject<IRotateEntrance> a = null;
    public static final PublishSubject b = null;
    public static final a c = null;

    public a() {
    }

    static {
        c = new a();
        PublishSubject<IRotateEntrance> r0 = PublishSubject.create();
        a = r0;
        b = r0;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.b
    public final void b() {
        c r0 = c.b;
        Intrinsics.checkNotNullParameter(r0, "entrance");
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d("EntranceVisibleNotify");
        r1.c("notifyVisibilityChange by entrance [" + r0 + ']');
        f81.a.a(r1.b());
        a.onNext(r0);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.b
    public final PublishSubject a() {
        return b;
    }
}
