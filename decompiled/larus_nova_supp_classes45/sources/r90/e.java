package r90;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ Ref.ObjectRef a;

    public e(Ref.ObjectRef r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        com.bytedance.android.live.emoji.utils.a r0 = com.bytedance.android.live.emoji.utils.a.a();
        ArrayList r1 = (ArrayList) this.a.element;
        r0.getClass();
        Gson r2 = com.bytedance.android.live.emoji.utils.d.a;
        Intrinsics.checkNotNullParameter(r1, "o");
        String r3 = GsonProtectorUtils.toJson(com.bytedance.android.live.emoji.utils.d.a, r1);
        r0.a.edit().putString("recent_system_small_emojis", r3).commit();
        r4.onNext(Unit.INSTANCE);
        r4.onComplete();
    }
}
