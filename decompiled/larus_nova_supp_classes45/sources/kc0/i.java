package kc0;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(p11.i r2, String r3) {
            r2.enableRenderFilter(r3, true, false);
        }
    }

    void clearStreamRegion();

    void enableRenderFilter(String r1, boolean r2, boolean r3);

    Map<String, String> getUidToStreamRegionKeyMap();

    void notifyStreamRegionUpdate();

    void registerRegionObserver(Observer<Map<String, pc0.c>> r1);

    void unRegisterRegionObserver(Observer<Map<String, pc0.c>> r1);

    boolean updateStreamRegion(String r1, RectF r2);
}
