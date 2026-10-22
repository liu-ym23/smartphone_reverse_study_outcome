package com.obric.memorydata.ability;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/ability/IStorageCollectData;", "", "collectNewData", "", "getDatabaseItemId", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface m {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static long a(m r2) {
            m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
            return 0;
        }
    }

    long collectNewData();
}
