package com.obric.update.api.v2;

import coa.a;
import com.larus.home.impl.t;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\u000e\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0011H&J$\u0010\u0017\u001a\u00020\u00032\u001a\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a0\u0019H&J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J0\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001eH&J\n\u0010$\u001a\u0004\u0018\u00010\nH&J\b\u0010%\u001a\u00020\bH&J\b\u0010&\u001a\u00020\bH&J\b\u0010'\u001a\u00020(H&J\n\u0010)\u001a\u0004\u0018\u00010\nH&J\b\u0010*\u001a\u00020+H&¨\u0006,"}, d2 = {"Lcom/obric/update/api/v2/IObricUpdateService;", "", "init", "", "context", "Landroid/content/Context;", "checkUpdate", "isAutoCheck", "", "scene", "", "isUpdateAvailable", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLatestApkDownloadUrl", "checkForceUpdateForRomUnmatched", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUpdateState", "", "addUpdateListener", "listener", "Lcom/obric/update/api/v2/ObricUpdateListener;", "removeUpdateListener", "action", "setRequestTagHeaderProvider", "provider", "Lkotlin/Function0;", "Landroid/util/Pair;", "reportUpdateEventLog", "event", "params", "Lorg/json/JSONObject;", "reportPipelineEvent", "stage", "result", "reason", DBDefinition.EXTRA, "triggerUpdateType", "isAutoDownloadInterferedByUser", "isObricChannel", "getPackageSizeInBytes", "", "versionName", "getBannerType", "Lcom/obric/update/api/v2/ObricBannerType;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricUpdateService {
    void a(String r1, String r2, JSONObject r3);

    void b(t r1);

    Object c(Continuation r1);

    void d(boolean r1, String r2);

    boolean e();

    void f(a r1);

    Object g(Continuation<? super Boolean> r1);

    ObricBannerType getBannerType();

    void h(String r1, JSONObject r2);

    void i(a r1);

    void init();

    boolean j();

    void k(@ObricUpdateAction int r1);

    int l();

    String m();

    Object n(Continuation r1);

    long o();

    String versionName();
}
