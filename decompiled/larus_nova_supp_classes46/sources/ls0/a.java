package ls0;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.portrait.PortraitShareAdapter;
import com.bytedance.android.livesdk.chatroom.view.PreviewType;
import com.bytedance.android.livesdk.chatroom.view.f;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ PortraitShareAdapter a;
    public final /* synthetic */ int b;

    public a(PortraitShareAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Iterator r0 = ((LinkedHashMap) this.a.a).entrySet().iterator();
    L3:
        boolean r2 = false;
        if (r0.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) r0.next();
        int r4 = ((Number) r1.getKey()).intValue();
        f r3 = (f) r1.getValue();
        PortraitShareAdapter r5 = this.a;
        if (r4 != r5.d) goto L7;
        if (r5.f == false) goto L19;
        List r6 = r5.c.d;
        if (r6 == null) goto L16;
        CollectionItem r7 = (CollectionItem) CollectionsKt.getOrNull(r6, this.b);
        if (r7 == null) goto L16;
        String r8 = r7.getCollectionId();
        if (r8 == null) goto L16;
    L17:
        int r9 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r8, "collectionId");
        g r10 = u.l();
        Map r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("highlights_group_id", r8)});
        x r12 = new x();
        r12.a = "live";
        r12.e = "show";
        r12.b = "live_detail";
        r10.h("sjb_highlights_client_show", r11, new Object[]{r12, Room.class});
    L16:
        r8 = "";
    L19:
        if (r3.i != PreviewType.VIDEO) goto L3;
        SimpleMediaView r13 = r3.b;
        if (r13 == null) goto L23;
        r13.setLoop(true);
    L23:
        r3.a(false);
        goto L3
    L7:
        r3.b();
        goto L3
    L24:
        PortraitShareAdapter r14 = this.a;
        if (r14.f == false) goto L27;
        return;
    L27:
        if (TextUtils.isEmpty(r14.c.c) == false) goto L47;
        PortraitShareAdapter r15 = this.a;
        MatchShareParam r16 = r15.c;
        if (r16.f != null) goto L33;
        if (r16.g != null) goto L33;
    L35:
        if (r2 == false) goto L48;
        PortraitShareAdapter.f(r15, this.b);
        this.a.f = true;
        return;
    L48:
        return;
    L33:
        if (r16.j != null) goto L35;
        r2 = true;
        goto L35
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
