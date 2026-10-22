package com.bytedance.android.live.messagewindow.business.presenter;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class AbsCommonCardPresenter<T> extends q46.b<a> {
    public final CompositeDisposable b;
    public final Lazy c;
    public final DataCenter d;

    public interface a extends q46.a {
        void CA();

        void IG(int r1, String r2);

        void bi(String r1);

        void gG(JsEventType r1, Map<String, ? extends Object> r2);

        void yA();
    }

    public final y61.a c0() {
        return (y61.a) this.c.getValue();
    }

    public abstract String d0();

    public final void detachView() {
        ((q46.b) this).a = null;
        this.b.clear();
    }

    public AbsCommonCardPresenter(DataCenter r1) {
        this.d = r1;
        this.b = new CompositeDisposable();
        this.c = LazyKt.lazy(new AbsCommonCardPresenter$commonCardContext$2(this));
    }

    public final void e0(HybridCard r3) {
        y61.a r0 = c0();
        if (r0 == null) goto L7;
        Pair r1 = r0.provideShowJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$1(this));
        if (r1 == null) goto L7;
        r3.registerMethod((String) r1.getFirst(), (g) r1.getSecond());
    L7:
        y61.a r2 = c0();
        if (r2 == null) goto L12;
        Pair r4 = r2.provideHideJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$2(this));
        if (r4 == null) goto L12;
        r3.registerMethod((String) r4.getFirst(), (g) r4.getSecond());
    L12:
        y61.a r5 = c0();
        if (r5 == null) goto L17;
        Pair r6 = r5.provideCloseJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$3(this));
        if (r6 == null) goto L17;
        r3.registerMethod((String) r6.getFirst(), (g) r6.getSecond());
    L17:
        y61.a r7 = c0();
        if (r7 == null) goto L23;
        Pair r8 = r7.provideWRDSJsMethod();
        if (r8 == null) goto L24;
        r3.registerMethod((String) r8.getFirst(), (f.b) r8.getSecond());
        return;
    L24:
        return;
    }

    public final void f0(HybridCard r5, boolean r6) {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d(d0());
        r2.c("sendCardShowStateChangedEvent");
        r2.a("cardState", Integer.valueOf(r6 ? 1 : 0));
        Unit r3 = Unit.INSTANCE;
        r0.d(r2.b());
    L6:
        if (r5 == null) goto L9;
        JSONObject r1 = new JSONObject();
        r1.put("cardState", r6 ? 1 : 0);
        Unit r7 = Unit.INSTANCE;
        r5.sendJsEvent("commonCardShowStateChanged", r1);
        return;
    }

    public final void g0(HybridCard r7, String r8, String r9) {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L14;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.d(d0());
        r3.c("sendUpdateJsEvent");
        String r4 = "";
        if (r8 != null) goto L8;
        String r5 = "";
    L9:
        r3.a("containerPayload", r5);
        if (r9 == null) goto L13;
        r4 = r9;
    L13:
        r3.a("extra", r4);
        Unit r6 = Unit.INSTANCE;
        r0.d(r3.b());
        goto L14
    L8:
        r5 = r8;
    L14:
        if (r7 == null) goto L22;
        JSONObject r1 = new JSONObject();
        if (r8 == null) goto L18;
        r1.put("containerPayload", r8);
    L18:
        if (r9 == null) goto L20;
        r1.put("extra", r9);
    L20:
        Unit r10 = Unit.INSTANCE;
        r7.sendJsEvent("updateBottomRightCard", r1);
        return;
    }
}
