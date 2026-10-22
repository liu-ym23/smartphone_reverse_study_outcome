package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo;", "", "", "id", "J", "b", "()J", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Lpy/k;", "avatar", "Lpy/k;", "a", "()Lpy/k;", "population", "d", "", "user_in_group_status", "I", "e", "()I", "<init>", "()V", "UserInGroupStatus", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupInfo implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    @SerializedName("id")
    protected long id;

    @SerializedName("name")
    protected String name;

    @SerializedName("population")
    protected long population;

    @SerializedName("user_in_group_status")
    protected int user_in_group_status;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo$UserInGroupStatus;", "", "", "value", "I", "getValue", "()I", "Clear", "Applied", "Engaged", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum UserInGroupStatus extends Enum<UserInGroupStatus> {
        public static final UserInGroupStatus Applied = null;
        public static final UserInGroupStatus Clear = null;
        public static final UserInGroupStatus Engaged = null;
        public static final /* synthetic */ UserInGroupStatus[] a = null;
        private final int value;

        static {
            UserInGroupStatus r1 = new UserInGroupStatus("Clear", 0, 0);
            Clear = r1;
            UserInGroupStatus r2 = new UserInGroupStatus("Applied", 1, 1);
            Applied = r2;
            UserInGroupStatus r3 = new UserInGroupStatus("Engaged", 2, 2);
            Engaged = r3;
            a = new UserInGroupStatus[]{r1, r2, r3};
        }

        public static UserInGroupStatus valueOf(String r1) {
            return (UserInGroupStatus) r27.a.a(UserInGroupStatus.class, r1);
        }

        public static UserInGroupStatus[] values() {
            return (UserInGroupStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public UserInGroupStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public GroupInfo() {
        this.name = "";
    }

    public final py.k a() {
        return this.avatar;
    }

    public final long b() {
        return this.id;
    }

    public final String c() {
        return this.name;
    }

    public final long d() {
        return this.population;
    }

    public final int e() {
        return this.user_in_group_status;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public GroupInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.id = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.name = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.avatar = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.population = r5.j();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.user_in_group_status = r5.i();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.name != null) goto L43;
        this.name = "";
        return;
    }
}
