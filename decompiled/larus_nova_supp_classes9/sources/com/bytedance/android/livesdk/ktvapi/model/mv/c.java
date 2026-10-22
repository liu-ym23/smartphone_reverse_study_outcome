package com.bytedance.android.livesdk.ktvapi.model.mv;

import android.view.Surface;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    h<?> a();

    lb0.b b();

    void c(Surface r1);

    void f(boolean r1, com.bytedance.android.live.pushstream.d r2, boolean r3);

    void h(String r1);

    void i(RoomSongInfo r1, Function0<Unit> r2, Function1<? super Integer, Unit> r3);

    Float m();

    void release();

    void stop();
}
