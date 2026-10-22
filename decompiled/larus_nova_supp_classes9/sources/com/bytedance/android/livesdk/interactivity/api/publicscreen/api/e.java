package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/e;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "emoji", "Ljava/lang/String;", BuildConfig.FLAVOR, "triggerWords", "Ljava/util/List;", BuildConfig.FLAVOR, "beginTime", "I", "endTime", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("begin_time")
    public int beginTime;

    @SerializedName("emoji")
    public String emoji;

    @SerializedName("end_time")
    public int endTime;

    @SerializedName("trigger_words")
    public List<String> triggerWords;

    public e() {
        this.emoji = BuildConfig.FLAVOR;
    }

    public e(am3.g r5) {
        this.triggerWords = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.emoji = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.triggerWords.add(am3.h.c(r5));
        goto L3
    L10:
        if (r2 != 10) goto L12;
        this.beginTime = (int) r5.j();
        goto L3
    L12:
        if (r2 != 11) goto L13;
        this.endTime = (int) r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.emoji != null) goto L37;
        this.emoji = BuildConfig.FLAVOR;
        return;
    }
}
