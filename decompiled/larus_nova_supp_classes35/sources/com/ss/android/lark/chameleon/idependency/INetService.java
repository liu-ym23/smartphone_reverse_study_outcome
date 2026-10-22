package com.ss.android.lark.chameleon.idependency;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/INetService;", BuildConfig.FLAVOR, "httpGet", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "headers", BuildConfig.FLAVOR, "callback", "Lcom/ss/android/lark/chameleon/idependency/INetCallback;", "httpPost", "body", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface INetService {
    void httpGet(String r1, Map<String, String> r2, INetCallback r3);

    void httpPost(String r1, Map<String, String> r2, String r3, INetCallback r4);
}
