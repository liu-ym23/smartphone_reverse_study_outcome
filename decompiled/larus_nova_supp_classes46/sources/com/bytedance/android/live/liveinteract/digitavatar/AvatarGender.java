package com.bytedance.android.live.liveinteract.digitavatar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/AvatarGender;", "", "", "getStickId", "Male", "Female", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract enum AvatarGender extends Enum<AvatarGender> {

    @SerializedName("Female")
    public static final AvatarGender Female = null;

    @SerializedName("Male")
    public static final AvatarGender Male = null;
    public static final /* synthetic */ AvatarGender[] a = null;

    static {
        final String r2 = "Male";
        final int r3 = 0;
        AvatarGender r1 = new Male(r2, r3);
        Male = r1;
        final String r4 = "Female";
        final int r5 = 1;
        AvatarGender r6 = new Female(r4, r5);
        Female = r6;
        a = new AvatarGender[]{r1, r6};
    }

    public AvatarGender() {
        throw null;
    }

    public static AvatarGender valueOf(String r1) {
        return (AvatarGender) r27.a.a(AvatarGender.class, r1);
    }

    public static AvatarGender[] values() {
        return (AvatarGender[]) a.clone();
    }

    public abstract String getStickId();

    public AvatarGender(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
