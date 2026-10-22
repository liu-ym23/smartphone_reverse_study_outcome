package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.likeegg.LikeEggSyncDataModel;
import com.bytedance.bdlocation.BuildConfig;
import dc2.e;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "likeEggSyncDataModel", "Lcom/bytedance/android/livesdk/chatroom/likeegg/LikeEggSyncDataModel;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LikeEggManager$init$1 extends Lambda implements Function1<LikeEggSyncDataModel, Unit> {
    final /* synthetic */ c this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LikeEggManager$init$1 a;

        public a(LikeEggManager$init$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.livesdk.chatroom.likeegg.a r6 = (com.bytedance.android.livesdk.chatroom.likeegg.a) r5;
            if (r6 == null) goto L5;
            String r1 = r6.toString();
        L6:
            ALogger.d("LikeEggManager", String.valueOf(r1));
            c r2 = this.a.this$0;
            int r3 = c.f;
            r2.getClass();
            if (r6 != null) goto L10;
            return;
        L10:
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == true) goto L13;
            ALogger.i("LikeEggManager", "block show digg egg");
            return;
        L13:
            throw null;
        L5:
            r1 = null;
            goto L6
        }
    }

    public LikeEggManager$init$1(c r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(LikeEggSyncDataModel r3) {
        Disposable r0 = this.this$0.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        c r1 = this.this$0;
        if (r3 == null) goto L12;
        dc2.c r4 = r3.getLikeEggMessage();
        if (r4 == null) goto L12;
        Observable r5 = r4.a.filter(dc2.d.a).observeOn(AndroidSchedulers.mainThread()).map(e.a);
        if (r5 == null) goto L12;
        Disposable r6 = r5.subscribe(new a(this));
    L13:
        r1.c = r6;
        return;
    L12:
        r6 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LikeEggSyncDataModel) r1);
        return Unit.INSTANCE;
    }
}
