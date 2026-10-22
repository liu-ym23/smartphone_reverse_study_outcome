package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/u0;", "", "", "schema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/broadcast/api/model/u0$a;", "icon", "Lcom/bytedance/android/live/broadcast/api/model/u0$a;", "d", "()Lcom/bytedance/android/live/broadcast/api/model/u0$a;", "setIcon", "(Lcom/bytedance/android/live/broadcast/api/model/u0$a;)V", "title", "g", "setTitle", "cover", "b", "setCover", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "appName", "a", "setAppName", "mpLiveChannel", "e", "h", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("app_name")
    @Expose
    private String appName;

    @SerializedName("cover_url")
    @Expose
    private a cover;

    @SerializedName("extra")
    @Expose
    private JsonObject extra;

    @SerializedName("icon")
    @Expose
    private a icon;

    @SerializedName("mp_live_channel")
    @Expose
    private String mpLiveChannel;

    @SerializedName("path")
    @Expose
    private String schema;

    @SerializedName("title")
    @Expose
    private String title;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/u0$a;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "uri", "a", "setUri", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("uri")
        @Expose
        private String uri;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        @Expose
        private String url;

        public a() {
            this.url = "";
            this.uri = "";
        }

        public final String a() {
            return this.uri;
        }

        public final String b() {
            return this.url;
        }
    }

    public u0() {
        this.schema = "";
        this.title = "";
    }

    public final String a() {
        return this.appName;
    }

    public final a b() {
        return this.cover;
    }

    public final JsonObject c() {
        return this.extra;
    }

    public final a d() {
        return this.icon;
    }

    public final String e() {
        return this.mpLiveChannel;
    }

    public final String f() {
        return this.schema;
    }

    public final String g() {
        return this.title;
    }

    public final void h(String r1) {
        this.mpLiveChannel = r1;
    }
}
