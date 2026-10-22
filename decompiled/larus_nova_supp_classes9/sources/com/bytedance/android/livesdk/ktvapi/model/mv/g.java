package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.od;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface g extends c {
    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    h<?> a();

    void d(od r1, k r2, boolean r3);

    void e(k r1, String r2, int r3, boolean r4);

    void g(List<MusicPanel> r1, Function1<? super Long, Boolean> r2);

    void j(vlc.d r1, boolean r2);

    od k();

    f l(long r1, String r3);

    int n();

    void o(k r1, boolean r2);
}
