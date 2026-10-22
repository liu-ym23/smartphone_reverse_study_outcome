package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/api/ILocationSnapshot;", "Lcom/bytedance/news/common/service/manager/IService;", "getLocation", "", "", "effectiveTimeInterval", "", "getCachedLocation", "isRequesting", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILocationSnapshot extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ List a(ILocationSnapshot r2, long r3, int r5, Object r6) {
            ILocationSnapshot r4 = (ILocationSnapshot) ZeusTransformUtils.wrapperContextForParams(r2, ILocationSnapshot.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = 1000;
        L8:
            return r4.getLocation(r3);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLocation");
        }

        public static /* synthetic */ List b(ILocationSnapshot r2, long r3, int r5, Object r6) {
            ILocationSnapshot r4 = (ILocationSnapshot) ZeusTransformUtils.wrapperContextForParams(r2, ILocationSnapshot.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = 1000;
        L8:
            return r4.getCachedLocation(r3);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCachedLocation");
        }
    }

    List<Double> getCachedLocation(long r1);

    List<Double> getLocation(long r1);

    boolean isRequesting();
}
