package h52;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdk.interactivity.square.common.k;
import com.bytedance.android.livesdk.interactivity.square.plugin.SquareModelSpanClickListener;
import h52.c;
import h52.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a<O extends d, M extends c> {
    boolean a(O r1);

    SquareModelSpanClickListener b();

    k c();

    gc2.a d(d r1);

    MessagePluginType getPluginType();

    void onLoad();

    void onUnload();
}
