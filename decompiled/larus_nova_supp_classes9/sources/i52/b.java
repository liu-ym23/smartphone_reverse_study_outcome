package i52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.square.h;
import com.bytedance.android.livesdk.interactivity.square.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b implements l52.c {
    public final List<l52.c.b> a;
    public final a b;
    public final C0236b c;
    public final List<String> d;
    public final List<MessageModelType> e;
    public final List<l52.c.a> f;
    public final vlc.d g;
    public final l h;

    public static final class a implements vlc.l {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void onMessage(tlc.d r1) {
        }
    }

    /* JADX INFO: renamed from: i52.b$b, reason: collision with other inner class name */
    public static final class C0236b implements p {
        public final /* synthetic */ b a;

        public C0236b(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.p
        public final void a(h52.d r3) {
            Intrinsics.checkNotNullParameter(r3, "source");
            Iterator<T> r0 = this.a.f.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            if (((l52.c.a) r0.next()).a(r3) == false) goto L4;
            return;
        L8:
            Iterator<T> r1 = this.a.a.iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            ((l52.c.b) r1.next()).a(r3);
            goto L10
        }
    }

    @Override // l52.c
    public final void c() {
        ((ArrayList) ((h) this).e).add(MessageModelType.Square);
        if ((!((ArrayList) this.d).isEmpty()) == false) goto L11;
        vlc.d r0 = this.g;
        if (r0 == null) goto L11;
        List<String> r3 = this.d;
        a r4 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r3, "methods");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Iterator r5 = ((ArrayList) r3).iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r0.addMessageListener((String) r5.next(), r4);
    L11:
        if ((!((ArrayList) this.e).isEmpty()) == false) goto L16;
        g r1 = (g) this.h.getMessageSourceManager().getValue();
        List<MessageModelType> r6 = this.e;
        C0236b r7 = this.c;
        Intrinsics.checkNotNullParameter(r1, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r6, "sources");
        Intrinsics.checkNotNullParameter(r7, "listener");
        Iterator r2 = ((ArrayList) r6).iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        r1.b((MessageModelType) r2.next(), r7);
        goto L14
    L19:
        return;
    }

    @Override // l52.c
    public final void a() {
        vlc.d r0 = this.g;
        if (r0 == null) goto L8;
        List<String> r3 = this.d;
        a r4 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$this$removeMessageListenerByType");
        Intrinsics.checkNotNullParameter(r3, "methods");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Iterator r5 = ((ArrayList) r3).iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.removeMessageListener((String) r5.next(), r4);
    L8:
        g r1 = (g) this.h.getMessageSourceManager().getValue();
        List<MessageModelType> r6 = this.e;
        C0236b r7 = this.c;
        Intrinsics.checkNotNullParameter(r1, "$this$removeMessageListenerByType");
        Intrinsics.checkNotNullParameter(r6, "sources");
        Intrinsics.checkNotNullParameter(r7, "listener");
        Iterator r2 = ((ArrayList) r6).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r1.a((MessageModelType) r2.next(), r7);
        goto L10
    }

    @Override // l52.c
    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.a).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r2);
    }

    @Override // l52.c
    public final void d(i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.a).remove(r2);
    }

    public b(DataCenter r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        this.h = r4;
        this.a = new ArrayList();
        this.b = a.a;
        this.c = new C0236b(this);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = CollectionsKt.mutableListOf(new l52.c.a[]{new j52.c()});
        this.g = (vlc.d) r3.get("data_message_manager");
    }
}
