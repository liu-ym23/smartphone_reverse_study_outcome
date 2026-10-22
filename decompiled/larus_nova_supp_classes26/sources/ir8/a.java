package ir8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final ConcurrentHashMap<String, Object> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, MusicAppletPage.KEY_PATH);
        return r1 + ':' + UUID.randomUUID();
    }
}
