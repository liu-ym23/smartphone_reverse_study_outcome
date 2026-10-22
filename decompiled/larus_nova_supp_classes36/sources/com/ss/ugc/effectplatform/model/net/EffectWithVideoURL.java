package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.task.StrategyCacheClearTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectWithVideoURL;", "", StrategyCacheClearTask.RequestResourceInfo.TYPE_EFFECT, "Lcom/ss/ugc/effectplatform/model/Effect;", "simple_video_info", "Lcom/ss/ugc/effectplatform/model/net/SimpleVideoInfo;", "(Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/net/SimpleVideoInfo;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class EffectWithVideoURL {
    public Effect effect;
    public SimpleVideoInfo simple_video_info;

    public EffectWithVideoURL() {
        Effect r0 = null;
        this(r0, r0, 3, r0);
    }

    public EffectWithVideoURL(Effect r1, SimpleVideoInfo r2) {
        this.effect = r1;
        this.simple_video_info = r2;
    }

    public /* synthetic */ EffectWithVideoURL(Effect r2, SimpleVideoInfo r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
