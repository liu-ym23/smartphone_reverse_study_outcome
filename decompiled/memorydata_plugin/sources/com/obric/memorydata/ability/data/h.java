package com.obric.memorydata.ability.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/ability/data/IStandardData;", "", "getDataId", "", "getDataVersion", "getDataTimestamp", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface h {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static long a(h r2) {
            h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
            return 0;
        }
    }

    int getDataId();
}
