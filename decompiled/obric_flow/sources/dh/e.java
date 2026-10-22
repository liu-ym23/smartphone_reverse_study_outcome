package dh;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    default Map getRequestHeaders() {
        return null;
    }

    Uri getUrl();

    default boolean isForMainFrame() {
        return false;
    }
}
