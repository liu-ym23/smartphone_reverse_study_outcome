package im;

import com.lynx.animax.util.AnimaXMetricsCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends f {
    @Override // im.f
    default void a(AnimaXMetricsCallback r5) {
        getPlayer().a(r5);
    }

    @Override // im.f
    default void b(float r5, float r10) {
        getPlayer().b(r5, r10);
    }

    f getPlayer();
}
