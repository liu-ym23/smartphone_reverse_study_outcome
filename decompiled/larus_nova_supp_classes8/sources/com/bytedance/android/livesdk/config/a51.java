package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/a51;", "", "", LiveEndPageData.TAG_NAME, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "max", "F", "c", "()F", "setMax", "(F)V", "min", "d", "setMin", "url", "f", "setUrl", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a51 {

    @SerializedName("max")
    private float max;

    @SerializedName("min")
    private float min;

    @SerializedName(LiveEndPageData.TAG_NAME)
    private String name;

    @SerializedName("url")
    private String url;

    public static final class a {
    }

    static {
    }

    public a51() {
        float r0 = 0.0f;
        String r2 = null;
        this(r2, r0, r0, 15);
    }

    @JvmStatic
    public static final List<a51> a() {
        ArrayList r0 = new ArrayList();
        StringBuilder r2 = new StringBuilder("https://");
        LiveCommonConstants r4 = LiveCommonConstants.INSTANCE;
        r2.append(r4.getObjectTosPath());
        r2.append("/obj/live-android/ttlive_ktv_score_rating_sss.webp");
        r0.add(new a51("sss", 1.0f, 0.95f, r2.toString()));
        r0.add(new a51("ss", 0.95f, 0.9f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_ss.webp"));
        r0.add(new a51("s", 0.9f, 0.85f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_s.webp"));
        r0.add(new a51("a", 0.85f, 0.7f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_a.webp"));
        r0.add(new a51("b", 0.7f, 0.5f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_b.webp"));
        r0.add(new a51("c", 0.5f, 0.3f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_c.webp"));
        r0.add(new a51("d", 0.3f, 0.0f, "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_ktv_score_rating_d.webp"));
        return r0;
    }

    @JvmStatic
    public static final List<a51> b() {
        ArrayList r0 = new ArrayList();
        float r4 = 95.0f;
        int r5 = 8;
        r0.add(new a51("perfect", 100.0f, r4, r5));
        float r3 = 80.0f;
        r0.add(new a51("great", r4, r3, r5));
        r0.add(new a51("good", r3, 60.0f, r5));
        return r0;
    }

    public final float c() {
        return this.max;
    }

    public final float d() {
        return this.min;
    }

    public final String e() {
        return this.name;
    }

    public final String f() {
        return this.url;
    }

    public /* synthetic */ a51(String r4, float r5, float r6, int r7) {
        String r1 = "";
        if ((r7 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = 0.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r6 = 0.0f;
    L12:
        if ((r7 & 8) != 0) goto L15;
        r1 = null;
    L15:
        this(r4, r5, r6, r1);
    }

    public a51(String r2, float r3, float r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r5, "url");
        this.name = r2;
        this.max = r3;
        this.min = r4;
        this.url = r5;
    }
}
