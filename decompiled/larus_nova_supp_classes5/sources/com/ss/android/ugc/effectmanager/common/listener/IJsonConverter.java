package com.ss.android.ugc.effectmanager.common.listener;

import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IJsonConverter {
    <T> T convertJsonToObj(InputStream r1, Class<T> r2) throws Exception;

    <T> String convertObjToJson(T r1) throws Exception;
}
