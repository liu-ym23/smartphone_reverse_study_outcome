package com.larus.platform.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.VideoParam;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface r2 {

    public interface a {
        View a(String r1);
    }

    void a(Context r1, Uri r2);

    void b(String r1, String r2);

    void c(List r1);

    v4 d(v r1, boolean r2);

    void e(Context r1, ArticleParam r2, Integer r3);

    String f(String r1);

    void g(PrefetchRecommendVideoParam r1);

    List<pr9.a> h(String r1, Integer r2);

    boolean i(String r1);

    boolean j(Uri r1);

    void k(String r1);

    void l(Context r1);

    void m(Context r1, ArticleParam r2, View r3);

    Object n(List r1);

    void o(k r1, boolean r2);

    void p(Context r1, String r2, VideoParam r3);

    int q();

    void r(Context r1, VideoParam r2, View r3, a r4);
}
