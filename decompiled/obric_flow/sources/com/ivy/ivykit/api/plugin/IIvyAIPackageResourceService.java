package com.ivy.ivykit.api.plugin;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 &2\u00020\u0001:\u0003\u0006'\u001cJS\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJS\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyAIPackageResourceService;", "", "", "sessionId", "url", "Lkotlin/Function1;", "Lcom/ivy/ivykit/api/plugin/b;", "", "resolve", "", "reject", "", "transformToString", "loadResourceAsync", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "loadAIPackageResourceAsync", "bid", "getImageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "closeSession", "(Ljava/lang/String;)V", "openSession", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Application;", "application", "saveDir", "Lcom/ivy/ivykit/api/plugin/h;", "pluginConfig", "Lcom/ivy/ivykit/api/plugin/d;", "containerConfig", "initContainer", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/ivy/ivykit/api/plugin/h;Lcom/ivy/ivykit/api/plugin/d;)V", "getBid", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "ensureInitLynx", "(Landroid/content/Context;)V", "Companion", "com/ivy/ivykit/api/plugin/c", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IIvyAIPackageResourceService {
    public static final c Companion = null;
    public static final String HOST = "app.aisdk.local";
    public static final String QUERY_BID = "bid";
    public static final String QUERY_INTERCEPT_REQUEST = "intercept_request";
    public static final String QUERY_STORE_DIR = "storeDir";
    public static final String SCHEMA = "https";
    public static final String SHOULD_INTERCEPT_REQUEST = "1";

    static {
        Companion = c.f9482a;
    }

    void closeSession(String r5);

    void ensureInitLynx(Context r5);

    String getBid();

    String getImageUrl(String r5, String r10, String r11);

    void initContainer(Application r5, String r10, String r11, h r12, d r13);

    void loadAIPackageResourceAsync(String r5, String r10, Function1<? super b, Unit> r11, Function1<? super Throwable, Unit> r12, boolean r13);

    void loadResourceAsync(String r5, String r10, Function1<? super b, Unit> r11, Function1<? super Throwable, Unit> r12, boolean r13);

    String openSession(String r5);
}
