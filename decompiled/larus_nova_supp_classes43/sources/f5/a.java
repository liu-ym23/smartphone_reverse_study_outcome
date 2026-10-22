package f5;

import android.view.ViewGroup;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.applet.impl.WidgetRenderServiceImpl;
import h5.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends k {
    public final String p;

    @Override // h5.k
    public final String b() {
        return this.p;
    }

    public a(String r18, String r19, String r20, String r21, String r22, WidgetInfo r23, ViewGroup r24, WidgetRenderServiceImpl.d r25, int r26, int r27, Map r28, Map r29, boolean r30, Map r31, String r32) {
        Intrinsics.checkNotNullParameter(r18, "messageId");
        super(r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, null, 49152);
        this.p = r32;
    }
}
