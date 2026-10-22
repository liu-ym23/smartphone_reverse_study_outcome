package com.bytedance.android.annie.service.network;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IAnnieNetworkService extends com.bytedance.android.annie.service.a {
    InputStream doPost(String r1, String r10, Map<String, String> r11, Map<String, Object> r12);

    c<d> downloadFile(boolean r1, int r10, String r11, List<Pair<String, String>> r12, Object r13) throws IOException;

    c<d> downloadFileStreaming(boolean r1, int r10, String r11, List<Pair<String, String>> r12, Object r13) throws IOException;

    c<d> get(String r1, List<Pair<String, String>> r10) throws IOException;

    c<d> get(String r1, List<Pair<String, String>> r10, Boolean r11) throws IOException;

    Map<String, String> getCommonParams();

    String getHostDomain();

    String getNetworkAccessType();

    void handleFetchError(View r1, String r10, String r11, Throwable r12);

    void handleStatusCodeInterception(JsonObject r1, Context r10);

    c<d> post(String r1, List<Pair<String, String>> r10, String r11, byte[] r12) throws IOException;

    c<d> post(String r1, List<Pair<String, String>> r10, String r11, byte[] r12, Boolean r13) throws IOException;

    c<d> uploadFile(int r1, String r10, List<Pair<String, String>> r11, String r12, byte[] r13, long r14, String r15) throws IOException;
}
