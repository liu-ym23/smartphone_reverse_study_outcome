package com.obric.memorydata.middleware.api.appcontext;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0010H&J\b\u0010\u0016\u001a\u00020\u0010H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u0010H&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0018H&J\b\u0010\u001f\u001a\u00020\u0010H&J\b\u0010 \u001a\u00020\u0010H&J\b\u0010!\u001a\u00020\u0010H&J\b\u0010\"\u001a\u00020\u0010H&J\b\u0010#\u001a\u00020\u0010H&J\b\u0010$\u001a\u00020\u0010H&J\b\u0010%\u001a\u00020\u0010H&J\b\u0010&\u001a\u00020\u0018H&J\b\u0010'\u001a\u00020\u0018H&J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0018H&J\b\u0010*\u001a\u00020\u0018H&J\b\u0010+\u001a\u00020\u0018H&R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006,"}, d2 = {"Lcom/obric/memorydata/middleware/api/appcontext/IAppContext;", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig;", "Lcom/bytedance/news/common/service/manager/IService;", "topActivity", "Landroid/app/Activity;", "getTopActivity", "()Landroid/app/Activity;", "setTopActivity", "(Landroid/app/Activity;)V", "setApplicationContext", "", "application", "Landroid/app/Application;", "context", "Landroid/content/Context;", "getServerDeviceId", "", "getOsDeviceId", "onDidUpdated", "Lkotlin/Function1;", "getUserId", "getToken", "getUserName", "isLogin", "", "getContext", "getApplication", "getPackageName", "getPid", "", "isLocalTest", "getLanguage", "getRegion", "getIid", "getSecurityAid", "getPuiVersion", "getRomVersion", "getFlavor", "isObricFlavor", "isSsFlavor", "enableDebug", "debuggable", "isRoot", "isAllLogEnabled", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppContext extends IService, IAppConfig {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ String a(IAppContext r2, Function1 r3, int r4, Object r5) {
            IAppContext r6 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.memorydata.plugin");
            Function1<? super String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r7 = null;
        L8:
            return r6.getOsDeviceId(r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOsDeviceId");
        }

        public static boolean a(IAppContext r2) {
            return IAppConfig.a.a((IAppConfig) ZeusTransformUtils.preCheckCast((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.memorydata.plugin"), IAppConfig.class, "com.obric.memorydata.plugin"));
        }
    }

    void enableDebug(boolean r1);

    Application getApplication();

    Context getContext();

    String getFlavor();

    String getIid();

    String getLanguage();

    String getOsDeviceId(Function1<? super String, Unit> r1);

    String getPackageName();

    int getPid();

    String getPuiVersion();

    String getRegion();

    String getRomVersion();

    String getSecurityAid();

    String getServerDeviceId();

    String getToken();

    Activity getTopActivity();

    String getUserId();

    String getUserName();

    boolean isAllLogEnabled();

    boolean isLocalTest();

    boolean isLogin();

    boolean isObricFlavor();

    boolean isRoot();

    boolean isSsFlavor();

    void setApplicationContext(Application r1, Context r2);

    void setTopActivity(Activity r1);
}
