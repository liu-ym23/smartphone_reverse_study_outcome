package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", "Ljava/io/Serializable;", "showTitlebar", BuildConfig.FLAVOR, "titleType", "Lcom/ss/android/lark/chameleon/api/TitleType;", "(ZLcom/ss/android/lark/chameleon/api/TitleType;)V", "getShowTitlebar", "()Z", "setShowTitlebar", "(Z)V", "getTitleType", "()Lcom/ss/android/lark/chameleon/api/TitleType;", "setTitleType", "(Lcom/ss/android/lark/chameleon/api/TitleType;)V", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TitlebarConfig implements Serializable {
    private boolean showTitlebar;
    private TitleType titleType;

    public TitlebarConfig() {
        TitleType r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ TitlebarConfig copy$default(TitlebarConfig r0, boolean r1, TitleType r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.showTitlebar;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.titleType;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.showTitlebar;
    }

    public final TitleType component2() {
        return this.titleType;
    }

    public final TitlebarConfig copy(boolean r2, TitleType r3) {
        return new TitlebarConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TitlebarConfig) == true) goto L8;
        return false;
    L8:
        TitlebarConfig r6 = (TitlebarConfig) r5;
        if (this.showTitlebar == r6.showTitlebar) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleType, r6.titleType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r0 = this.showTitlebar;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        TitleType r3 = this.titleType;
        if (r3 != null) goto L8;
        int r4 = 0;
    L10:
        return r2 + r4;
    L8:
        r4 = r3.hashCode();
        goto L10
    }

    public String toString() {
        return "TitlebarConfig(showTitlebar=" + this.showTitlebar + ", titleType=" + this.titleType + ')';
    }

    public final boolean getShowTitlebar() {
        return this.showTitlebar;
    }

    public final TitleType getTitleType() {
        return this.titleType;
    }

    public final void setShowTitlebar(boolean r1) {
        this.showTitlebar = r1;
    }

    public final void setTitleType(TitleType r1) {
        this.titleType = r1;
    }

    public TitlebarConfig(boolean r1, TitleType r2) {
        this.showTitlebar = r1;
        this.titleType = r2;
    }

    public /* synthetic */ TitlebarConfig(boolean r1, TitleType r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
