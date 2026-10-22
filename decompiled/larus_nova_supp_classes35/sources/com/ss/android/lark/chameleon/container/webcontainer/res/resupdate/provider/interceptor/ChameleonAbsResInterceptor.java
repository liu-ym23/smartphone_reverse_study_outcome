package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor;

import android.content.Context;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor;", BuildConfig.FLAVOR, "()V", "defaultResFetcher", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonDefaultResFetcher;", "getDefaultResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", "context", "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "sync", BuildConfig.FLAVOR, "session", BuildConfig.FLAVOR, "getResource", "shouldIntercept", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ChameleonAbsResInterceptor {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_ChameleonAbsResInterceptor";
    private final ChameleonDefaultResFetcher defaultResFetcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract ChameleonResource getResource(Context r1, ChameleonConfig r2, boolean r3, String r4);

    public abstract boolean shouldIntercept(Context r1, ChameleonConfig r2);

    public ChameleonAbsResInterceptor() {
        this.defaultResFetcher = new ChameleonDefaultResFetcher();
    }

    public ChameleonResource getDefaultResource(Context r1, ChameleonConfig r2, boolean r3, String r4) {
        if (r3 == false) goto L4;
        String r5 = this.defaultResFetcher.syncGetResource(r2, r1, r4);
    L6:
        if (r2 == null) goto L10;
        ResConfig r6 = r2.getResConfig();
        if (r6 == null) goto L10;
        String r7 = r6.getResVersion();
    L12:
        return new ChameleonResource(r5, r7);
    L10:
        r7 = null;
        goto L12
    L4:
        r5 = this.defaultResFetcher.asyncGetResource(r2, r1, r4);
        goto L6
    }

    public static /* synthetic */ ChameleonResource getDefaultResource$default(ChameleonAbsResInterceptor r0, Context r1, ChameleonConfig r2, boolean r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = null;
    L7:
        return r0.getDefaultResource(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDefaultResource");
    }

    public static /* synthetic */ ChameleonResource getResource$default(ChameleonAbsResInterceptor r0, Context r1, ChameleonConfig r2, boolean r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = null;
    L7:
        return r0.getResource(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResource");
    }
}
