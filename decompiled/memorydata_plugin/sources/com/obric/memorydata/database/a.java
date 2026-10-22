package com.obric.memorydata.database;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/IAppEntityRawDbData;", "", "index", "", "isForceLazy", "delete", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.memorydata.database.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0451a {
        public static /* synthetic */ boolean a(a r2, boolean r3, int r4, Object r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r3 = false;
        L8:
            return r6.index(r3);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: index");
        }
    }

    boolean delete();

    boolean index(boolean r1);
}
