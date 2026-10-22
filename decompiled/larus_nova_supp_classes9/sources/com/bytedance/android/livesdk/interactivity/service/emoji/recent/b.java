package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "description", "Ljava/lang/String;", "b", "()Ljava/lang/String;", BuildConfig.FLAVOR, "latestUseTime", "J", "getLatestUseTime", "()J", "e", "(J)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/a;", "latestUseCount", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("description")
    private final String description;

    @SerializedName("latest_use_count")
    private final ArrayList<a> latestUseCount;

    @SerializedName("latest_use_time")
    private long latestUseTime;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L12;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.description, r7.description) == true) goto L8;
        return false;
    L8:
        if (this.latestUseTime == r7.latestUseTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.latestUseCount, r7.latestUseCount) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.description;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.latestUseTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        ArrayList<a> r5 = this.latestUseCount;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RecentEmoji(description=" + this.description + ", latestUseTime=" + this.latestUseTime + ", latestUseCount=" + this.latestUseCount + ")";
    }

    public b() {
        this(null, 0, new ArrayList());
    }

    public final long d() {
        ArrayList<a> r0 = this.latestUseCount;
        long r1 = 0;
        if (r0 == null) goto L8;
        Iterator<a> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1 = r1 + r2.next().a();
    L8:
        return r1;
    }

    public final String b() {
        return this.description;
    }

    public final ArrayList<a> c() {
        return this.latestUseCount;
    }

    public final void e(long r1) {
        this.latestUseTime = r1;
    }

    public b(String r1, long r2, ArrayList<a> r4) {
        this.description = r1;
        this.latestUseTime = r2;
        this.latestUseCount = r4;
    }

    public final float a(long r15, int r17, db2.b r18) {
        Intrinsics.checkNotNullParameter(r18, "shortcutEmojiParams");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        float r1 = r18.a();     // Catch: Throwable -> L10
        float r3 = r18.b();     // Catch: Throwable -> L10
        float r4 = r18.c();     // Catch: Throwable -> L10
        float r2 = r18.d();     // Catch: Throwable -> L10
        return (float) (Math.pow((r1 * ((float) ((0.4f + (0.6f * Math.exp(((((System.currentTimeMillis() - this.latestUseTime) / 1000.0f) / 3600.0f) / 24.0f) * (-0.5f)))) * ((double) ((d() - 0.0f) / (r15 - 0.0f)))))) + 1.0f, r4) * Math.pow(1 + (r3 * (r17 / 100.0f)), r2));
    L8:
        th = th;
    L12:
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return 1.0f;
    L10:
        th = th;
        goto L12
    }
}
