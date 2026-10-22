package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/UserInfoHitPoint;", "Ljava/io/Serializable;", "uid", "", "isChatUser", "", "<init>", "(Ljava/lang/String;Z)V", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "()Z", "component1", "component2", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UserInfoHitPoint implements Serializable {
    private final boolean isChatUser;
    private String uid;

    public static /* synthetic */ UserInfoHitPoint copy$default(UserInfoHitPoint r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isChatUser;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.uid;
    }

    public final boolean component2() {
        return this.isChatUser;
    }

    public final UserInfoHitPoint copy(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return new UserInfoHitPoint(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserInfoHitPoint) == true) goto L8;
        return false;
    L8:
        UserInfoHitPoint r6 = (UserInfoHitPoint) r5;
        if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L12;
        return false;
    L12:
        if (this.isChatUser == r6.isChatUser) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.uid.hashCode() * 31;
        if (this.isChatUser == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "UserInfoHitPoint(uid=" + this.uid + ", isChatUser=" + this.isChatUser + ')';
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean isChatUser() {
        return this.isChatUser;
    }

    public final void setUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uid = r2;
    }

    public UserInfoHitPoint(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.uid = r2;
        this.isChatUser = r3;
    }
}
