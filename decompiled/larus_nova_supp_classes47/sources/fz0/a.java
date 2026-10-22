package fz0;

import ca0.m;
import com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType;
import com.bytedance.android.live.revenue.platform.interacteffect.api.Scene;
import com.bytedance.revenue.platform.api.core.rx.o;
import ez0.b;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b, za0.a {
    public final List<m> a;
    public final PublishSubject<JSONObject> b;
    public final PublishSubject<ez0.a> c;

    /* JADX INFO: renamed from: fz0.a$a, reason: collision with other inner class name */
    public static final class C0241a {
        public C0241a() {
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((m) r0.next()).b();
        goto L4
    L6:
        ((ArrayList) this.a).clear();
    }

    public a() {
        this.a = new ArrayList();
        new C0241a();
        int r0 = o.a;
        this.b = PublishSubject.create();
        this.c = PublishSubject.create();
    }

    @Override // ez0.b
    public final Observable<ez0.a> observeEffectMessage() {
        return this.c;
    }

    @Override // ez0.b
    public final Observable<JSONObject> observeGiftMsgContent() {
        return this.b;
    }

    @Override // ez0.b
    public final void p2(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.b.onNext(r2);
    }

    @Override // ez0.b
    public final void Vf(MessageType r1, Scene r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "messageType");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Iterator r5 = ((ArrayList) this.a).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        m r6 = (m) r5.next();
        r1.getValue();
        r2.getValue();
        r6.a();
        goto L4
    }
}
