package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.content.Context;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/IResourceFetcher;", BuildConfig.FLAVOR, "asyncGetResource", BuildConfig.FLAVOR, "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "context", "Landroid/content/Context;", "session", "getTemplateDir", "syncGetResource", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IResourceFetcher {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String asyncGetResource$default(IResourceFetcher r0, ChameleonConfig r1, Context r2, String r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = null;
        L7:
            return r0.asyncGetResource(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncGetResource");
        }

        public static /* synthetic */ String syncGetResource$default(IResourceFetcher r0, ChameleonConfig r1, Context r2, String r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = null;
        L7:
            return r0.syncGetResource(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncGetResource");
        }
    }

    String asyncGetResource(ChameleonConfig r1, Context r2, String r3);

    String getTemplateDir(ChameleonConfig r1);

    String syncGetResource(ChameleonConfig r1, Context r2, String r3);
}
