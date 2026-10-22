package com.ss.android.lark.chat.entity.wallpaper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ThemeListItem;", "Ljava/io/Serializable;", "pos", BuildConfig.FLAVOR, "themeId", "themeName", BuildConfig.FLAVOR, "<init>", "(JJLjava/lang/String;)V", "getPos", "()J", "setPos", "(J)V", "getThemeId", "setThemeId", "getThemeName", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "component1", "component2", "component3", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeListItem implements Serializable {
    private long pos;
    private long themeId;
    private final String themeName;

    public static /* synthetic */ ThemeListItem copy$default(ThemeListItem r6, long r7, long r9, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.pos;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.themeId;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.themeName;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.pos;
    }

    public final long component2() {
        return this.themeId;
    }

    public final String component3() {
        return this.themeName;
    }

    public final ThemeListItem copy(long r8, long r10, String r12) {
        return new ThemeListItem(r8, r10, r12);
    }

    public int hashCode() {
        long r0 = this.pos;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.themeId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.themeName;
        if (r4 == null) goto L5;
        int r5 = r4.hashCode();
    L7:
        return r2 + r5;
    L5:
        r5 = 0;
        goto L7
    }

    public String toString() {
        return "ThemeListItem(pos=" + this.pos + ", themeId=" + this.themeId + ", themeName='" + this.themeName + "')";
    }

    public final long getPos() {
        return this.pos;
    }

    public final long getThemeId() {
        return this.themeId;
    }

    public final String getThemeName() {
        return this.themeName;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(ThemeListItem.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.wallpaper.ThemeListItem");
        ThemeListItem r9 = (ThemeListItem) r8;
        if (this.pos == r9.pos) goto L16;
        return false;
    L16:
        if (this.themeId == r9.themeId) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.themeName, r9.themeName) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setPos(long r1) {
        this.pos = r1;
    }

    public final void setThemeId(long r1) {
        this.themeId = r1;
    }

    public ThemeListItem(long r1, long r3, String r5) {
        this.pos = r1;
        this.themeId = r3;
        this.themeName = r5;
    }

    public /* synthetic */ ThemeListItem(long r7, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r9, r11);
    }
}
