package gc2;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdk.interactivity.square.common.j;
import com.bytedance.android.livesdk.message.model.vh;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends j {
    public vh n;

    public a(MessageModelType r2, MessageBinderType r3, MessagePluginType r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "modelType");
        Intrinsics.checkNotNullParameter(r3, "binderType");
        Intrinsics.checkNotNullParameter(r4, "pluginType");
        super(r2, r3, r4, r5);
    }
}
