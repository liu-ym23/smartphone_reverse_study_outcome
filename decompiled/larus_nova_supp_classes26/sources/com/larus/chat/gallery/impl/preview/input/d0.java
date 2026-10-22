package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.provider.w0;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface d0 {
    String a();

    com.larus.chat.gallery.api.o b();

    boolean c(ChildResultMode r1);

    com.larus.chat.gallery.api.o d(String r1);

    void detach();

    boolean e();

    boolean f(CameraResultRoute r1);

    void g();

    com.larus.chat.gallery.api.q getSession();

    boolean h(CameraOutputContext r1, xy8.d r2);

    int i(String r1);

    void j(w0 r1);

    boolean k(String r1);

    List<com.larus.chat.gallery.api.o> l();
}
