package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAvatar;", "Ljava/io/Serializable;", "avatarKey", "", "avatarUrl", "userId", "fakeNameId", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getAvatarUrl", "getUserId", "getFakeNameId", "getType", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowAvatar implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_LARK_USER = "lark_user";
    public static final String TYPE_SPEAKER = "speaker";
    private final String avatarKey;
    private final String avatarUrl;
    private final String fakeNameId;
    private final String type;
    private final String userId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmEndWindowAvatar() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MmEndWindowAvatar copy$default(MmEndWindowAvatar r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.avatarKey;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.avatarUrl;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.userId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.fakeNameId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.type;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.fakeNameId;
    }

    public final String component5() {
        return this.type;
    }

    public final MmEndWindowAvatar copy(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "avatarKey");
        Intrinsics.checkNotNullParameter(r9, "avatarUrl");
        Intrinsics.checkNotNullParameter(r10, "userId");
        Intrinsics.checkNotNullParameter(r11, "fakeNameId");
        Intrinsics.checkNotNullParameter(r12, "type");
        return new MmEndWindowAvatar(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmEndWindowAvatar) == true) goto L8;
        return false;
    L8:
        MmEndWindowAvatar r6 = (MmEndWindowAvatar) r5;
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fakeNameId, r6.fakeNameId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.avatarKey.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.fakeNameId.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MmEndWindowAvatar(avatarKey='" + this.avatarKey + "', avatarUrl=" + this.avatarUrl + "', userId='" + this.userId + "', fakeNameId='" + this.fakeNameId + "', type='" + this.type + "')";
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getFakeNameId() {
        return this.fakeNameId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public MmEndWindowAvatar(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "fakeNameId");
        Intrinsics.checkNotNullParameter(r6, "type");
        this.avatarKey = r2;
        this.avatarUrl = r3;
        this.userId = r4;
        this.fakeNameId = r5;
        this.type = r6;
    }

    public /* synthetic */ MmEndWindowAvatar(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = "";
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
