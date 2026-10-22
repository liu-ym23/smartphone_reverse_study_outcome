package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import com.ss.android.lark.chameleon.api.TitleType;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuConfigModel;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "titleType", "Lcom/ss/android/lark/chameleon/api/TitleType;", "leftItems", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuItemSrc;", "Lkotlin/collections/ArrayList;", "rightItems", "(Lcom/ss/android/lark/chameleon/api/TitleType;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getLeftItems", "()Ljava/util/ArrayList;", "getRightItems", "getTitleType", "()Lcom/ss/android/lark/chameleon/api/TitleType;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuConfigModel implements NonProguard {
    private final ArrayList<MenuItemSrc> leftItems;
    private final ArrayList<MenuItemSrc> rightItems;
    private final TitleType titleType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MenuConfigModel copy$default(MenuConfigModel r0, TitleType r1, ArrayList r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.titleType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.leftItems;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.rightItems;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final TitleType component1() {
        return this.titleType;
    }

    public final ArrayList<MenuItemSrc> component2() {
        return this.leftItems;
    }

    public final ArrayList<MenuItemSrc> component3() {
        return this.rightItems;
    }

    public final MenuConfigModel copy(TitleType r2, ArrayList<MenuItemSrc> r3, ArrayList<MenuItemSrc> r4) {
        return new MenuConfigModel(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MenuConfigModel) == true) goto L8;
        return false;
    L8:
        MenuConfigModel r6 = (MenuConfigModel) r5;
        if (Intrinsics.areEqual(this.titleType, r6.titleType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftItems, r6.leftItems) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rightItems, r6.rightItems) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        TitleType r0 = this.titleType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<MenuItemSrc> r4 = this.leftItems;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<MenuItemSrc> r7 = this.rightItems;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MenuConfigModel(titleType=" + this.titleType + ", leftItems=" + this.leftItems + ", rightItems=" + this.rightItems + ')';
    }

    public final ArrayList<MenuItemSrc> getLeftItems() {
        return this.leftItems;
    }

    public final ArrayList<MenuItemSrc> getRightItems() {
        return this.rightItems;
    }

    public final TitleType getTitleType() {
        return this.titleType;
    }

    public MenuConfigModel(TitleType r1, ArrayList<MenuItemSrc> r2, ArrayList<MenuItemSrc> r3) {
        this.titleType = r1;
        this.leftItems = r2;
        this.rightItems = r3;
    }
}
