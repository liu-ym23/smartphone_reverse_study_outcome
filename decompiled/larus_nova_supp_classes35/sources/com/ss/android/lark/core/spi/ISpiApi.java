package com.ss.android.lark.core.spi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH&J6\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\nH&J%\u0010\u000b\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\fJ-\u0010\u000b\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\fJ/\u0010\u000e\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\rJ'\u0010\u000f\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\fJ/\u0010\u000f\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/core/spi/ISpiApi;", BuildConfig.FLAVOR, "registerLoader", BuildConfig.FLAVOR, "T", "c", "Ljava/lang/Class;", "loader", "Lcom/ss/android/lark/core/spi/ILoader;", "channel", BuildConfig.FLAVOR, "loadClass", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "getUserService", "getGlobalService", "core-component-api-internal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISpiApi {
    <T> T getGlobalService(Class<T> r1);

    <T> T getGlobalService(Class<T> r1, String r2);

    <T> T getUserService(Class<T> r1);

    <T> T getUserService(Class<T> r1, String r2);

    <T> T loadClass(Class<T> r1);

    <T> T loadClass(Class<T> r1, String r2);

    <T> void registerLoader(Class<T> r1, ILoader<T> r2);

    <T> void registerLoader(Class<T> r1, ILoader<T> r2, String r3);
}
