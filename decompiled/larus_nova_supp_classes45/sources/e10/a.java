package e10;

import com.bytedance.android.live.broadcastgame.api.model.l;
import e10.a.C0226a;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a<DATA extends l, FILTER_CONTEXT extends C0226a> {

    /* JADX INFO: renamed from: e10.a$a, reason: collision with other inner class name */
    public static class C0226a {
        public C0226a() {
        }
    }

    List<DATA> filter(List<? extends DATA> r1);
}
