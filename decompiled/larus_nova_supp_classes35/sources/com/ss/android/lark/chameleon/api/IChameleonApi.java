package com.ss.android.lark.chameleon.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.idependency.IDependency;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/api/IChameleonApi;", BuildConfig.FLAVOR, "getChameleonFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "bizPlugins", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "init", BuildConfig.FLAVOR, "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "open", "preloadWebview", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IChameleonApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fragment getChameleonFragment$default(IChameleonApi r0, Context r1, ChameleonConfig r2, List r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = null;
        L7:
            return r0.getChameleonFragment(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChameleonFragment");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void open$default(IChameleonApi r0, Context r1, ChameleonConfig r2, List r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.open(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }
    }

    Fragment getChameleonFragment(Context r1, ChameleonConfig r2, List<? extends AbsChameleonPlugin> r3);

    void init(IDependency r1);

    void open(Context r1, ChameleonConfig r2, List<? extends AbsChameleonPlugin> r3);

    void preloadWebview(ChameleonConfig r1);
}
