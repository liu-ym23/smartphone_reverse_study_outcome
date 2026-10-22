package com.bytedance.android.api;

import android.content.Context;
import kotlin.Metadata;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/api/IShoppingPluginAbility;", "", "Lyj/t;", "getLynxHostService", "", "mainInitializerInit", "mainInitializerPreloadServiceMap", "service", "getHostCommerceServiceLive", "Landroid/content/Context;", "context", "iesJsBridge", "provideHostMethodsIECHostHybridUtil", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShoppingPluginAbility {
    Object getHostCommerceServiceLive(Object r1);

    t getLynxHostService();

    void mainInitializerInit();

    void mainInitializerPreloadServiceMap();

    Object provideHostMethodsIECHostHybridUtil(Context r1, Object r10);
}
