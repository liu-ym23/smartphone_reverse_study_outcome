package com.larus.ugc.feed.impl.quickmenu;

import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import x0a.b;
import x0a.c;
import x0a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuConfig;", "", "title", "", "menuItems", "", "Lcom/larus/ugc/feed/impl/quickmenu/QuickMenuItem;", "onItemClickListener", "Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuItemClickListener;", "onDismissListener", "Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuDismissListener;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuItemClickListener;Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuDismissListener;)V", "getTitle", "()Ljava/lang/String;", "getMenuItems", "()Ljava/util/List;", "getOnItemClickListener", "()Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuItemClickListener;", "getOnDismissListener", "()Lcom/larus/ugc/feed/impl/quickmenu/OnQuickMenuDismissListener;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class QuickMenuConfig {
    public static final int $stable = 8;
    private final List<j> menuItems;
    private final b onDismissListener;
    private final c onItemClickListener;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuickMenuConfig copy$default(QuickMenuConfig r0, String r1, List r2, c r3, b r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.menuItems;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.onItemClickListener;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.onDismissListener;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.title;
    }

    public final List<j> component2() {
        return this.menuItems;
    }

    public final c component3() {
        return this.onItemClickListener;
    }

    public final b component4() {
        return this.onDismissListener;
    }

    public final QuickMenuConfig copy(String r2, List<j> r3, c r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        return new QuickMenuConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QuickMenuConfig) == true) goto L8;
        return false;
    L8:
        QuickMenuConfig r6 = (QuickMenuConfig) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.menuItems, r6.menuItems) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onItemClickListener, r6.onItemClickListener) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.onDismissListener, r6.onDismissListener) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.menuItems.hashCode()) * 31;
        c r4 = this.onItemClickListener;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.onDismissListener;
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
        return "QuickMenuConfig(title=" + this.title + ", menuItems=" + this.menuItems + ", onItemClickListener=" + this.onItemClickListener + ", onDismissListener=" + this.onDismissListener + ')';
    }

    public final List<j> getMenuItems() {
        return this.menuItems;
    }

    public final b getOnDismissListener() {
        return this.onDismissListener;
    }

    public final c getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final String getTitle() {
        return this.title;
    }

    public QuickMenuConfig(String r2, List<j> r3, c r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        this.title = r2;
        this.menuItems = r3;
        this.onItemClickListener = r4;
        this.onDismissListener = r5;
    }

    public /* synthetic */ QuickMenuConfig(String r2, List r3, c r4, b r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
