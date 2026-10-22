package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/c;", "", "<init>", "()V", "", "", "a", "Ljava/util/List;", "getWorkerJsFileMd5CheckList", "()Ljava/util/List;", "setWorkerJsFileMd5CheckList", "(Ljava/util/List;)V", "workerJsFileMd5CheckList", "", "b", "Ljava/util/Map;", "getEnableBlankDetectConfig", "()Ljava/util/Map;", "setEnableBlankDetectConfig", "(Ljava/util/Map;)V", "enableBlankDetectConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("worker_js_file_md5_check_list")
    private List<String> f5196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("enable_blank_detect_config")
    private Map<String, String> f5197b;

    public c() {
        this.f5196a = CollectionsKt.listOf("84c1a41d47b9a3b566656c5d0fd24703");
        this.f5197b = new LinkedHashMap();
    }
}
