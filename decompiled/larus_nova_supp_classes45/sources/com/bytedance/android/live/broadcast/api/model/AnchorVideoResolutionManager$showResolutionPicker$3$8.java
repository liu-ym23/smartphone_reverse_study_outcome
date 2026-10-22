package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorVideoResolutionManager$showResolutionPicker$3$8 extends Lambda implements Function0<String> {
    public static final AnchorVideoResolutionManager$showResolutionPicker$3$8 INSTANCE = null;

    static {
        INSTANCE = new AnchorVideoResolutionManager$showResolutionPicker$3$8();
    }

    public AnchorVideoResolutionManager$showResolutionPicker$3$8() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m47invoke() {
        return (String) ((Map) com.bytedance.android.livesdk.sharedpref.b.l2.getValue()).get(LiveMode.VIDEO.name());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m47invoke();
    }
}
