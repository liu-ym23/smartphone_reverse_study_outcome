package com.bytedance.android.live.ktv.common.music.control;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/bytedance/android/live/ktv/common/music/control/IMusicControlNode$OperationType;", "Lcom/bytedance/android/live/ktv/common/music/control/h;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MusicControlChain$interceptors$2 extends FunctionReferenceImpl implements Function0<Map<IMusicControlNode.OperationType, h>> {
    public static final MusicControlChain$interceptors$2 INSTANCE = null;

    static {
        INSTANCE = new MusicControlChain$interceptors$2();
    }

    public MusicControlChain$interceptors$2() {
        super(0, MapsKt.class, "mutableMapOf", "mutableMapOf()Ljava/util/Map;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Map<IMusicControlNode.OperationType, h> m1070invoke() {
        return new LinkedHashMap();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1070invoke();
    }
}
