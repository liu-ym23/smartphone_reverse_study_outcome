package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/a;", "", "<init>", "()V", "", "a", "Ljava/lang/String;", "getConfigUrl", "()Ljava/lang/String;", "setConfigUrl", "(Ljava/lang/String;)V", "configUrl", "", "b", "Ljava/lang/Long;", "getPollInterval", "()Ljava/lang/Long;", "setPollInterval", "(Ljava/lang/Long;)V", "pollInterval", "Lorg/json/JSONArray;", "c", "Lorg/json/JSONArray;", "getRedirectInCurRouteWhiteList", "()Lorg/json/JSONArray;", "setRedirectInCurRouteWhiteList", "(Lorg/json/JSONArray;)V", "redirectInCurRouteWhiteList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("config_url")
    private String f5192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("poll_interval")
    private Long f5193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("android_redirect_in_cur_route_white_list")
    private JSONArray f5194c;

    public a() {
        this.f5193b = 0L;
    }
}
