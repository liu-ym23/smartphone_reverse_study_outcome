package com.bytedance.android.btm.api.model;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.btm.api.BtmPage;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J'\u0010\u000e\u001a\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\r\"\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u000e\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0007J\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0007J\u0014\u0010\u0014\u001a\u00020\u00002\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0007J\u001c\u0010\u001a\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0007J&\u0010\u001f\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\tH\u0007J\b\u0010!\u001a\u00020\u0000H\u0007J\b\u0010#\u001a\u00020\"H\u0007J\b\u0010$\u001a\u00020\tH\u0007J\b\u0010%\u001a\u00020\tH\u0007J\b\u0010'\u001a\u00020&H\u0007J\b\u0010(\u001a\u00020\u0015H\u0007R\u0014\u0010)\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "setAddBtmChain", "", "setBtmChainLength", "setUseTopPageWhenNotFindPage", "setEnterPage", "", "key", "internalSetUnitParams", "setEnterPageTimes", "", "setTargetPagesBtm", "([Ljava/lang/String;)Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "", "pages", "Landroid/view/View;", "withView", "withBtmPage", "Lcom/bytedance/android/btm/api/model/PageFinder;", "withPageFinder", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "curPosition", "withViewPager", "Lcom/bytedance/android/btm/api/j;", "getFragmentListener", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "withGetFragmentListener", "btm", "copy", "Lcom/bytedance/android/btm/api/model/c;", "build", "createBtmId", "obtainEventBtmParams", "", "willJumpToNextPage", "getPageFinder", "item", "Lcom/bytedance/android/btm/api/model/c;", "enterPage", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BtmItemBuilder {
    private final c item;

    /* JADX WARN: Multi-variable type inference failed */
    public BtmItemBuilder() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final c build() {
        BtmSDK r0 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.inner.g r1 = r0.getService().getMonitor();
        boolean r10 = true;
        if (this.item.a.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        r1.b(r11, AnonymousClass1.INSTANCE);
        com.bytedance.android.btm.api.inner.g r12 = r0.getService().getMonitor();
        if (this.item.e.isEmpty() == false) goto L11;
        c r13 = this.item;
        if (r13.f != null) goto L11;
        r13.getClass();
        r10 = false;
    L11:
        r12.b(r10, AnonymousClass2.INSTANCE);
        return this.item;
    L5:
        r11 = false;
        goto L6
    }

    public final BtmItemBuilder copy() {
        return copy(this.item.a);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "obtainEventBtmParams || willJumpToNextPage", imports = {}))
    public final String createBtmId() {
        return BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final PageFinder getPageFinder() {
        return this.item.e;
    }

    public final String obtainEventBtmParams() {
        c r0 = this.item;
        r0.b = Boolean.FALSE;
        return BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final void willJumpToNextPage() {
        c r0 = this.item;
        r0.b = Boolean.TRUE;
        BtmSDK.INSTANCE.createBtmId(copy().build());
    }

    public final BtmItemBuilder copy(String r10) {
        BtmItemBuilder r11 = new BtmItemBuilder(r10, this.item.b).setEnterPageTimes(this.item.c);
        c r0 = this.item;
        ViewPager r1 = r0.f;
        if (r1 == null) goto L5;
        r11.withViewPager(r1, r0.g);
    L5:
        this.item.getClass();
        c r12 = r11.item;
        c r13 = this.item;
        r12.e = r13.e;
        r12.j = r13.j;
        r12.k = r13.k;
        return r11;
    }

    public final BtmItemBuilder setAddBtmChain(boolean r10) {
        this.item.h = r10;
        return this;
    }

    public final BtmItemBuilder setBtmChainLength(int r10) {
        this.item.i = r10;
        return this;
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "createJumpSourceBtmToken / createReportParams", imports = {}))
    public final BtmItemBuilder setEnterPage(boolean r10) {
        c r0 = this.item;
        r0.b = Boolean.valueOf(r10);
        return this;
    }

    public final BtmItemBuilder setEnterPageTimes(int r10) {
        this.item.c = r10;
        return this;
    }

    public final BtmItemBuilder setTargetPagesBtm(String... r10) {
        ((ArrayList) this.item.d).clear();
        int r0 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L14;
        String r12 = r10[r11];
        if (r12 != null) goto L7;
    L10:
        boolean r13 = true;
    L11:
        if (r13 == true) goto L13;
        ((ArrayList) this.item.d).add(r12);
    L13:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r12.length() == 0) goto L10;
        r13 = false;
        goto L11
    L14:
        return this;
    }

    public final BtmItemBuilder setUseTopPageWhenNotFindPage(boolean r10) {
        this.item.k = r10;
        return this;
    }

    public final BtmItemBuilder withBtmPage(@BtmPage final Object r10) {
        com.bytedance.android.btm.api.inner.g r0 = BtmSDK.INSTANCE.getService().getMonitor();
        if (cd.b.a(r10) == null) goto L5;
        boolean r1 = true;
    L6:
        r0.b(r1, new C02251(r10));
        this.item.e.page = r10;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    public final BtmItemBuilder withPageFinder(PageFinder r10) {
        if (r10 == null) goto L4;
        this.item.e = r10;
    L4:
        return this;
    }

    public final BtmItemBuilder withView(View r10) {
        this.item.e.view = r10;
        return this;
    }

    public final BtmItemBuilder setTargetPagesBtm(List<String> r10) {
        ((ArrayList) this.item.d).clear();
        ArrayList r0 = (ArrayList) this.item.d;
        r0.addAll(r10);
        return this;
    }

    public BtmItemBuilder(String r10, Boolean r11) {
        c r0 = new c();
        this.item = r0;
        r0.a = r10;
        r0.b = r11;
    }

    public final BtmItemBuilder internalSetUnitParams(String r10, Object r11) {
        if (r10 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        if (r11 == null) goto L12;
        this.item.j.put(r10, r11);
    L12:
        return this;
    L4:
        if (r10.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final BtmItemBuilder withViewPager(ViewPager r10, int r11) {
        c r0 = this.item;
        r0.f = r10;
        r0.g = r11;
        return this;
    }

    public final BtmItemBuilder withGetFragmentListener(j r1, int r10, FragmentManager r11) {
        this.item.getClass();
        this.item.g = r10;
        return this;
    }

    public /* synthetic */ BtmItemBuilder(String r1, Boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }

    public static /* synthetic */ BtmItemBuilder withViewPager$default(BtmItemBuilder r0, ViewPager r1, int r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = -1;
    L6:
        return r0.withViewPager(r1, r10);
    }

    public static /* synthetic */ BtmItemBuilder withGetFragmentListener$default(BtmItemBuilder r0, j r1, int r10, FragmentManager r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = -1;
    L6:
        return r0.withGetFragmentListener(r1, r10, r11);
    }
}
