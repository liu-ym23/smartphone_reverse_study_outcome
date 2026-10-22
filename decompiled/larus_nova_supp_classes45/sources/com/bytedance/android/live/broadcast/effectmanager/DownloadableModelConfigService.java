package com.bytedance.android.live.broadcast.effectmanager;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService;
import com.bytedance.android.live.effect.api.LiveEffectBaseContext;
import com.bytedance.android.live.effect.utils.d;
import com.bytedance.android.live.effect.utils.l;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kjc.b;
import kjc.c;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/effectmanager/DownloadableModelConfigService;", "Lcom/bytedance/android/live/broadcast/effect/IDownloadableModelConfigService;", "()V", "getDownloadModelConfig", "Lcom/ss/android/ugc/effectmanager/DownloadableModelConfig;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DownloadableModelConfigService implements IDownloadableModelConfigService {
    public DownloadableModelConfigService() {
    }

    @Override // com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService
    public DownloadableModelConfig getDownloadModelConfig() {
        final a r0 = new a();
        IHostContext r1 = k.n(IHostContext.class);
        final Context r2 = r1.context();
        final DownloadableModelConfig.Builder r3 = new DownloadableModelConfig.Builder();
        c r4 = new c();
        com.bytedance.android.livesdk.paas.a.a(r4, new DownloadableModelProvider$getDLModelConfig$$inlined$call$lambda$1(r0, r3, r2));
        if (r4.b == true) goto L9;
        b r5 = r4.a;
        ArrayList r6 = new ArrayList();
        Iterator r7 = ((ArrayList) r0.a).iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.add(new Host((String) r7.next()));
        goto L6
    L8:
        List<Host> r8 = LiveEffectBaseContext.e;
        r3.setAccessKey("142710f02c3a11e8b42429f14557854a").setHosts(r6).setSdkVersion("16.5.0").setWorkspace(new PolarisFileWrapper(r2.getFilesDir(), "effect/").getAbsolutePath()).setEffectNetWorker(new d());
        r5.a = Unit.INSTANCE;
    L9:
        Object r9 = r4.a.a;
        r3.setContext(r2).setAssetManager(r2.getAssets()).setJsonConverter(new l()).setExclusionPattern("(?=^((?!tt_face|kws).)+)^((?!png|dat).)+").setAppId(String.valueOf(r1.appId())).setDeviceType(URLEncoder.encode(Build.MODEL)).setModelFileEnv(DownloadableModelConfig.ModelFileEnv.ONLINE).setExecutor(PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("effect_downloader", true)));
        return r3.build();
    }
}
