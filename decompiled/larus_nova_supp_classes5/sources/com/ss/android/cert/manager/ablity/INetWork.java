package com.ss.android.cert.manager.ablity;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface INetWork {
    int checkResponseException(Throwable r1);

    String executeGet(String r1, Map<String, String> r2, Map<String, String> r3, Map<String, Object> r4) throws Exception;

    String executePost(String r1, Map<String, String> r2, String r3, Map<String, Object> r4) throws Exception;

    String executePost(String r1, Map<String, String> r2, Map<String, String> r3, Map<String, Object> r4) throws Exception;

    String executePostFile(String r1, Map<String, String> r2, Map<String, String> r3, Map<String, Pair<String, byte[]>> r4) throws Exception;

    int getExceptionStatusCode(Throwable r1);
}
