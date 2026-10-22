package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleon/TitlebarConfig;", "Ljava/io/Serializable;", "showTitlebar", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "titleType", "Lcom/ss/android/lark/chameleon/TitleType;", "<init>", "(ZLcom/ss/android/lark/chameleon/TitleType;)V", "getShowTitlebar", "()Z", "setShowTitlebar", "(Z)V", "getTitleType", "()Lcom/ss/android/lark/chameleon/TitleType;", "setTitleType", "(Lcom/ss/android/lark/chameleon/TitleType;)V", "copy", "toString", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "component1", "component2", "equals", "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public int hashCode() {
        if (this.showTitlebar == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        TitleType r2 = this.titleType;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final TitlebarConfig copy() {
        boolean r1 = this.showTitlebar;
        TitleType r2 = this.titleType;
        if (r2 == null) goto L5;
        TitleType r3 = r2.copy();
    L7:
        return new TitlebarConfig(r1, r3);
    L5:
        r3 = null;
        goto L7
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
