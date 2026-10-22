package tq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.vs_base.api.ReplayListApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ mq1.a b;

    public c(b r1, mq1.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        this.a.g.setValue(Boolean.FALSE);
        NextLiveData<List<EpisodeGroup>> r0 = this.a.a;
        List r1 = (List) r0.getValue();
        if (r1 != null) goto L5;
        r1 = new ArrayList();
    L5:
        ReplayListApi.a r10 = (ReplayListApi.a) ((ExtraResponse) r9).data;
        if (r10.b() == null) goto L24;
        List<n0> r2 = r10.b();
        if (r2 != null) goto L10;
    L12:
        EpisodeGroup r3 = new EpisodeGroup();
        r3.groupName = r10.c();
        r3.extra = r10.a();
        List<n0> r11 = r10.b();
        if (r11 == null) goto L23;
        Iterator<T> r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L23;
        List r5 = ((n0) r12.next()).a();
        if (r5 == null) goto L16;
        List r6 = r3.episodes;
        if (r6 == null) goto L21;
        r6.addAll(r5);
        goto L16
    L21:
        r3.episodes = r5;
    L23:
        Unit r13 = Unit.INSTANCE;
        r1.add(r3);
        this.a.i = true;
        ALogger.e("ReplayListDataProvider", "fetch series success");
    L28:
        Unit r14 = Unit.INSTANCE;
        r0.setValue(r1);
        return;
    L10:
        if (r2.isEmpty() != true) goto L12;
    L24:
        mq1.a r15 = this.b;
        if (r15 == null) goto L27;
        r15.a();
    L27:
        ALogger.e("ReplayListDataProvider", "fetch series none data------ tryloadingmore now");
        goto L28
    }
}
