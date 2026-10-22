package com.bytedance.android.annie.service.network;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.google.gson.JsonObject;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DefaultAnnieNetworkService implements IAnnieNetworkService {
    public final Lazy a;

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final InputStream doPost(String r10, String r11, Map<String, String> r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "contentType");
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "params");
        return null;
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final String getHostDomain() {
        return "";
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final String getNetworkAccessType() {
        return "";
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final void handleFetchError(View r1, String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "method");
        Intrinsics.checkNotNullParameter(r12, "throwable");
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final void handleStatusCodeInterception(JsonObject r1, Context r10) {
    }

    public final c<d> H1() {
        return (c) this.a.getValue();
    }

    public DefaultAnnieNetworkService() {
        this.a = LazyKt.lazy(DefaultAnnieNetworkService$emptyCall$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final Map<String, String> getCommonParams() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> get(String r10, List<Pair<String, String>> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "headers");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> get(String r1, List<Pair<String, String>> r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> post(String r10, List<Pair<String, String>> r11, String r12, byte[] r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r12, "mediaType");
        Intrinsics.checkNotNullParameter(r13, "body");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> downloadFile(boolean r1, int r10, String r11, List<Pair<String, String>> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "extraInfo");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> downloadFileStreaming(boolean r1, int r10, String r11, List<Pair<String, String>> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "extraInfo");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> post(String r1, List<Pair<String, String>> r10, String r11, byte[] r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> uploadFile(int r1, String r10, List<Pair<String, String>> r11, String r12, byte[] r13, long r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r12, "mediaType");
        Intrinsics.checkNotNullParameter(r13, "body");
        Intrinsics.checkNotNullParameter(r15, "md5Stub");
        return H1();
    }
}
