package im0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.messagewindow.framework.process.card.AttachContainerPs;
import com.bytedance.android.live.messagewindow.framework.process.card.InterceptShowPs;
import com.bytedance.android.live.messagewindow.framework.process.card.PkPs;
import com.bytedance.android.live.messagewindow.framework.process.card.ShowDebouncePs;
import com.bytedance.android.live.messagewindow.framework.process.card.TransitionAnimPs;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends im0.a {
    public final com.bytedance.android.live.messagewindow.framework.process.a e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.messagewindow.framework.process.card.a a;
        public final /* synthetic */ e b;
        public final /* synthetic */ i c;

        public a(com.bytedance.android.live.messagewindow.framework.process.card.a r1, e r2, i r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.messagewindow.framework.process.card.a.c r9 = (com.bytedance.android.live.messagewindow.framework.process.card.a.c) r8;
            if (r9.a != 2) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L42;
            String r1 = "卡片 " + this.b.e.c.j + " 展示失败，失败节点为: " + this.a.b().name();
            i r4 = this.c;
            if (r4 == null) goto L11;
            CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
            r5.c(r1);
            Unit r6 = Unit.INSTANCE;
            r4.d(r5.b());
        L11:
            com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_show_action_interrupt");
            r7.a(this.b.e.c.j);
            r7.b(r1);
            i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r2 == null) goto L14;
            r2.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
        L14:
            i r3 = this.c;
            if (r3 == null) goto L39;
            com.bytedance.android.live.room.api.messagewindow.monitor.c r10 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_show_fail");
            r10.c(new Pair[]{TuplesKt.to("card_id", this.b.e.c.j), TuplesKt.to("reason", this.a.b().name())});
            com.bytedance.android.live.messagewindow.framework.process.card.a.b r11 = null;
            if ((r9 instanceof com.bytedance.android.live.messagewindow.framework.process.card.a.c.f) == true) goto L20;
            r9 = null;
        L20:
            com.bytedance.android.live.messagewindow.framework.process.card.a.c.f r12 = (com.bytedance.android.live.messagewindow.framework.process.card.a.c.f) r9;
            if (r12 == null) goto L38;
            com.bytedance.android.live.messagewindow.framework.process.card.a.b r13 = r12.a();
            if (r13 == null) goto L38;
            if ((true ^ r13.b.isEmpty()) == false) goto L27;
            r11 = r13;
        L27:
            if (r11 == null) goto L35;
            Map<String, String> r14 = r11.b;
            if (r14 == null) goto L35;
            JSONObject r15 = new JSONObject();
            Iterator r16 = ((LinkedHashMap) r14).entrySet().iterator();
        L32:
            if (r16.hasNext() == false) goto L34;
            Map.Entry r17 = (Map.Entry) r16.next();
            r15.put((String) r17.getKey(), r17.getValue());
            goto L32
        L34:
            Unit r18 = Unit.INSTANCE;
            r10.b("extra_msg", r15.toString());
        L35:
            p71.a r19 = r13.c;
            if (r19 == null) goto L38;
            this.b.e.c.H(r19);
        L38:
            Unit r20 = Unit.INSTANCE;
            r3.b(r10.a());
        L39:
            this.b.a(3);
            return;
        L42:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class b<T> implements SingleOnSubscribe {
        public final /* synthetic */ e a;
        public final /* synthetic */ i b;

        public b(e r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(SingleEmitter<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            i r5 = this.b;
            if (r5 == null) goto L7;
            com.bytedance.android.live.room.api.messagewindow.monitor.c r0 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_request_show");
            r0.b("card_id", this.a.e.c.j);
            Unit r1 = Unit.INSTANCE;
            r5.b(r0.a());
            return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.c("—————— 卡片 " + this.e.c.j + " 处理展示流程 ——————");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        com.bytedance.android.live.messagewindow.framework.process.a r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "action");
        r3.a = this;
        List r4 = CollectionsKt.listOf(new com.bytedance.android.live.messagewindow.framework.process.card.a[]{new ShowDebouncePs(), new com.bytedance.android.live.messagewindow.framework.process.card.i(), new InterceptShowPs(), new PkPs(), new com.bytedance.android.live.messagewindow.framework.process.card.b(), new AttachContainerPs(), new TransitionAnimPs(true), new com.bytedance.android.live.messagewindow.framework.process.card.d(), new com.bytedance.android.live.messagewindow.framework.process.card.e()});
        i r5 = this.e.b.monitor();
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        com.bytedance.android.live.messagewindow.framework.process.card.a r7 = (com.bytedance.android.live.messagewindow.framework.process.card.a) r6.next();
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r7.c).subscribe(new a(r7, this, r5)), this.d);
        goto L8
    L10:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_show_action_start");
        r8.a(this.e.c.j);
        i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L13;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L13:
        Single.create(new b(this, r5)).subscribeOn(Schedulers.io()).subscribe();
        new hm0.b(this.e, r4).a(this.e);
    }

    public e(com.bytedance.android.live.messagewindow.framework.process.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(j71.a.d.b);
        this.e = r2;
    }
}
