package com.bytedance.android.live.effect.sticker.api.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.MultiAnchorEffect")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/model/b;", "", "", "anchorId", "J", "a", "()J", "setAnchorId", "(J)V", "", "effectIds", "Ljava/util/List;", "b", "()Ljava/util/List;", "setEffectIds", "(Ljava/util/List;)V", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("anchor_id")
    protected long anchorId;

    @SerializedName("effect_ids")
    protected List<Long> effectIds;

    public b() {
    }

    public final long a() {
        return this.anchorId;
    }

    public final List<Long> b() {
        return this.effectIds;
    }

    public b(g r6) {
        this.effectIds = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.anchorId = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.effectIds.add(Long.valueOf(r6.j()));
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r0);
    }
}
