package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u0012\u0010\u000bR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u0011\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/d;", "", "<init>", "()V", "", "", "a", "Ljava/util/List;", "e", "()Ljava/util/List;", "setDisallowListWeb", "(Ljava/util/List;)V", "disallowListWeb", "b", "d", "setDisallowListLynx", "disallowListLynx", "c", "setAllowListWeb", "allowListWeb", "setAllowListLynx", "allowListLynx", "", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "g", "(Ljava/lang/Boolean;)V", "enableSession", "Ljava/lang/String;", "()Ljava/lang/String;", "setBufferMode", "(Ljava/lang/String;)V", "bufferMode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("disallow_list_web")
    private List<String> f5198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("disallow_list_lynx")
    private List<String> f5199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("allow_list_web")
    private List<String> f5200c;

    @SerializedName("allow_list_lynx")
    private List<String> d;

    @SerializedName("enable_session")
    private Boolean e;

    @SerializedName("buffer_mode")
    private String f;

    public d() {
        this.f5198a = CollectionsKt.emptyList();
        this.f5199b = CollectionsKt.emptyList();
        this.f5200c = CollectionsKt.emptyList();
        this.d = CollectionsKt.emptyList();
        this.e = Boolean.TRUE;
        this.f = "normal";
    }

    public final List a() {
        return this.d;
    }

    public final List b() {
        return this.f5200c;
    }

    public final String c() {
        return this.f;
    }

    public final List d() {
        return this.f5199b;
    }

    public final List e() {
        return this.f5198a;
    }

    public final Boolean f() {
        return this.e;
    }

    public final void g() {
        this.e = Boolean.TRUE;
    }
}
