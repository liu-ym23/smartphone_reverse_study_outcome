package com.obric.memorydata.middleware.impl;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.BuildTypeFlavor;
import com.obric.memorydata.middleware.api.IDataInterceptor;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.settings.IDataUploadSettings;
import com.obric.memorydata.middleware.api.settings.LogFilterConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/impl/DataInterceptorImpl;", "Lcom/obric/memorydata/middleware/api/IDataInterceptor;", "<init>", "()V", "TAG", "", "getInst", "interceptLog", "", LocationMonitorConst.TAG, "level", "", NotificationCompat.CATEGORY_MESSAGE, "interceptTracker", "eventName", "jsonObject", "Lorg/json/JSONObject;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataInterceptorImpl implements IDataInterceptor {
    public static final DataInterceptorImpl INSTANCE = null;
    public static final String TAG = "DataInterceptor";

    static {
        INSTANCE = new DataInterceptorImpl();
    }

    private DataInterceptorImpl() {
    }

    @JvmStatic
    public static final DataInterceptorImpl getInst() {
        return INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.middleware.api.IDataInterceptor
    public boolean interceptLog(String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = false;
        if (AppSettingsManager.INSTANCE.hasInited() == true) goto L5;
        return false;
    L5:
        IDataUploadSettings r7 = AppSettingsManager.INSTANCE.getDataUploadSettings();
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
    L11:
        Object[] r1 = true;
    L12:
        if (r1 == false) goto L14;
    L16:
        List<LogFilterConfig> r2 = r7.getLogBlacklist();
        LogFilterConfig r3 = null;
        Object r4 = null;
        if (r2 == null) goto L25;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((LogFilterConfig) ZeusTransformUtils.preCheckCast(r6, LogFilterConfig.class, "com.obric.memorydata.plugin")).getTag(), r8) == false) goto L20;
        r4 = r6;
    L24:
        r3 = (LogFilterConfig) ZeusTransformUtils.preCheckCast(r4, LogFilterConfig.class, "com.obric.memorydata.plugin");
    L25:
        if (r3 == null) goto L35;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getRegexFilter(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L30;
    L31:
        r0 = true;
    L32:
        if (r0 == false) goto L34;
        r0 = true;
        goto L35
    L34:
        String r12 = r3.getRegexFilter();
        Intrinsics.checkNotNull(r12);
        r0 = new Regex(r12).containsMatchIn((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L35
    L30:
        if (r11.length() != 0) goto L32;
    L35:
        if (r0 == false) goto L37;
    L41:
        return r0;
    L37:
        if (r9 < r7.getLogLowestLevel()) goto L41;
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L41;
        BuildTypeFlavor.INSTANCE.checkPrivacyData(r8, r10);
        goto L41
    L14:
        if (r7.getLogLowestLevel() <= r9) goto L16;
        return true;
    L8:
        if (AppContext.INSTANCE.isAllLogEnabled() == true) goto L11;
        r1 = false;
        goto L12
    }

    @Override // com.obric.memorydata.middleware.api.IDataInterceptor
    public boolean interceptTracker(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        if (AppSettingsManager.INSTANCE.hasInited() == true) goto L5;
        return false;
    L5:
        IDataUploadSettings r2 = AppSettingsManager.INSTANCE.getDataUploadSettings();
        if (r2.getPrivacyTrackerSwitch() == false) goto L15;
        List<String> r0 = r2.getPrivacyEventGroupList();
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
        return true;
    L10:
        if (r0.contains(r3) != true) goto L12;
        r1 = true;
    L15:
        List<String> r5 = r2.getTrackerBlackList();
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L23;
        return true;
    L23:
        return false;
    L18:
        if (r5.contains(r3) != true) goto L20;
        r6 = true;
        goto L21
    }
}
