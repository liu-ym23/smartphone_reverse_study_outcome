package com.ivy.ivykit.base.resource;

import android.app.Application;
import androidx.annotation.Keep;
import com.bytedance.ai.resource.core.net.a;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.settings.b;
import com.ivy.ivykit.api.plugin.IvyResourceService;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import df.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import jm.c;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ul.f;
import ul.g;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@ServiceImpl
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/ivy/ivykit/base/resource/IvyResourceServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IvyResourceService;", "<init>", "()V", "Landroid/app/Application;", "application", "", "deviceId", "Lul/d;", "geckoConfigs", "", "initGlobalConfig", "(Landroid/app/Application;Ljava/lang/String;Lul/d;)V", "host", "Lcom/bytedance/geckox/GeckoGlobalConfig$ENVType;", "env", "Lcom/bytedance/geckox/GeckoGlobalConfig;", "getGeckoGlobalConfig", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/geckox/GeckoGlobalConfig$ENVType;)Lcom/bytedance/geckox/GeckoGlobalConfig;", "registerGecko", "syncGlobalSettings", "Lul/f;", "geckoXNetImpl", "Lul/f;", "Companion", "ul/g", "ivy_base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IvyResourceServiceImpl implements IvyResourceService {
    public static final g Companion = null;
    private static final String TAG = "IvyResourceServiceImpl";
    private f geckoXNetImpl;

    static {
        Companion = new g();
    }

    public IvyResourceServiceImpl() {
    }

    public static /* synthetic */ void a(String r5, JSONObject r10) {
        getGeckoGlobalConfig$lambda$0(r5, r10);
    }

    private final GeckoGlobalConfig getGeckoGlobalConfig(Application r5, String r10, String r11, GeckoGlobalConfig.ENVType r12) {
        GeckoGlobalConfig.Builder r13 = new GeckoGlobalConfig.Builder(r5.getApplicationContext()).appId(0).appVersion(d.f18606k).deviceId(r10).host(r11).env(r12);
        f r14 = this.geckoXNetImpl;
        if (r14 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("geckoXNetImpl");
        r14 = null;
    L6:
        return r13.netStack(r14).statisticMonitor(new a(20)).build();
    }

    private static final void getGeckoGlobalConfig$lambda$0(String r5, JSONObject r10) {
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public void initGlobalConfig() {
        String r5 = d.f18610o;
        if (StringsKt.isBlank(r5) == false) goto L5;
        r5 = "0";
    L5:
        Application r10 = d.s;
        ul.d r11 = null;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r10 = null;
    L9:
        ul.d r12 = c.f18359c;
        if (r12 == null) goto L12;
        r11 = r12;
    L13:
        initGlobalConfig(r10, r5, r11);
        return;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");
        goto L13
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public void registerGecko() {
        ul.d r5 = c.f18359c;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");
        r5 = null;
    L6:
        Iterator r10 = r5.getAppRegisters().iterator();
    L8:
        if (r10.hasNext() == false) goto L16;
        IGeckoRegister r11 = (IGeckoRegister) r10.next();
        if (r11 == null) goto L8;
        df.c.f16652i.a();
        if (df.c.f16650c.get() == false) goto L14;
        e.a(r11, true);
        goto L8
    L14:
        GeckoLogger.a("register gecko,global gecko has not been initialized");
        e.f16656c.add(r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public void syncGlobalSettings() {
        GlobalConfigSettings r5 = com.bytedance.iesgurd.settings.d.f6692a;
        ReqType r10 = ReqType.NORMAL;
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new b(0, 0 == true ? 1 : 0, r10));
    }

    private final void initGlobalConfig(Application r5, String r10, ul.d r11) {
        if (d.f18611p == false) goto L5;
        CopyOnWriteArrayList r12 = GeckoLogger.f4756a;
    L5:
        Application r13 = d.s;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r13 = null;
    L9:
        String r14 = "";
        String r15 = r13.getSharedPreferences("gecko_settings", 0).getString("gecko_lane", "");
        if (r15 == null) goto L13;
        r14 = r15;
    L13:
        this.geckoXNetImpl = new f(r14, p.a());
        df.c.b(getGeckoGlobalConfig(r5, r10, r11.getHost(), p.a()));
    }
}
