package com.bytedance.frameworks.baselib.network.http.cookie;

import android.util.Pair;
import java.net.URI;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public interface a {
        void onCookieGet(e r1);
    }

    String a(URI r1);

    boolean a();

    boolean a(e r1);

    boolean a(URI r1, String r2, boolean r3);

    Pair<String, Map<String, Set<e>>> b(URI r1);
}
