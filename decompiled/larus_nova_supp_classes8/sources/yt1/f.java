package yt1;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f<V extends View> {
    <T> void a(b<T, V> r1, Map<String, ? extends Object> r2);

    void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r1, com.bytedance.android.ecom.arch.slice.render.elements.g r2, int r3, int r4, int r5, int r6);

    V createView(Context r1);

    int getType();
}
