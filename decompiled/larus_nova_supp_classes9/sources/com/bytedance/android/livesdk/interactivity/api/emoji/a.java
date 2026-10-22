package com.bytedance.android.livesdk.interactivity.api.emoji;

import am3.g;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/emoji/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", BuildConfig.FLAVOR, "idStr", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "name", "d", "setName", "Lpy/k;", "emoji", "Lpy/k;", "a", "()Lpy/k;", "setEmoji", "(Lpy/k;)V", "desc", "getDesc", "setDesc", BuildConfig.FLAVOR, "originEmojiList", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a implements h {
    public long a;

    @SerializedName("desc")
    protected String desc;

    @SerializedName("emoji")
    protected k emoji;

    @SerializedName("id")
    protected Long id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("name")
    protected String name;

    @SerializedName("origin_emoji")
    protected List<String> originEmojiList;

    public a() {
        this.id = 0L;
    }

    public final k a() {
        return this.emoji;
    }

    public final Long b() {
        return this.id;
    }

    public final String c() {
        return this.idStr;
    }

    public final String d() {
        return this.name;
    }

    public final List<String> e() {
        return this.originEmojiList;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public a(g r5) {
        this.originEmojiList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.originEmojiList.add(am3.h.c(r5));
        goto L3
    L8:
        this.desc = am3.h.c(r5);
        goto L3
    L9:
        this.emoji = vh7.f.a(r5, k.class);
        goto L3
    L10:
        this.name = am3.h.c(r5);
        goto L3
    L11:
        this.idStr = am3.h.c(r5);
        goto L3
    L12:
        this.id = Long.valueOf(r5.j());
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
        if (this.id != null) goto L33;
        this.id = 0L;
        return;
    }
}
