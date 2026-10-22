package com.obric.memorydata.recommend.b;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getShortMemoryEntityId", "", OaidModel.KEY_ID, "", EventBody.KEY_CATEGORY, "", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final String a(long r1, int r3) {
        return new StringBuilder().append(r3).append('_').append(r1).toString();
    }
}
