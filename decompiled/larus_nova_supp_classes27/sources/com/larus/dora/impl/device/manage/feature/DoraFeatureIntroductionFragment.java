package com.larus.dora.impl.device.manage.feature;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import c59.j;
import c59.q;
import c59.t;
import c59.u;
import com.bytedance.dora.device.DoraDevice;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraFeatureIntroductionFragmentBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.manage.x0;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.view.DoraTextView;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\nH\u0002J \u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraFeatureIntroductionFragmentBinding;", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "reportedItems", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "simpleDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitleBar", "fetchData", "setupPage", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslSimplePage;", "checkExposure", "getCardContentTypeByTag", "tag", "generateFuncIntroSetView", "context", "Landroid/content/Context;", "parentLayout", "Landroid/widget/LinearLayout;", "config", "Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionSet;", "getCardContentType", "item", "Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionItem;", "getCurrentPageName", "onDestroyView", "Companion", "DslFunctionIntroductionSet", "DslFunctionIntroductionItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraFeatureIntroductionFragment extends DoraBaseFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDoraFeatureIntroductionFragmentBinding f;
    public final com.larus.dora.impl.dynamic.loader.d g;
    public final HashSet<String> h;
    public z49.b i;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jb\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionItem;", "", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "tag", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "subtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/lang/Boolean;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;)V", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getTag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getSubtitle", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getPageInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/lang/Boolean;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;)Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionItem;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("action")
        private final c59.b action;

        @SerializedName("condition")
        private final j condition;

        @SerializedName("image_link")
        private final u imageLink;

        @SerializedName("page_info")
        private final q pageInfo;

        @SerializedName("subtitle")
        private final t subtitle;

        @SerializedName("tag")
        private final Boolean tag;

        @SerializedName("title")
        private final t title;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.condition, r6.condition) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.subtitle, r6.subtitle) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.action, r6.action) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.pageInfo, r6.pageInfo) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            j r0 = this.condition;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.tag;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            t r7 = this.title;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            t r10 = this.subtitle;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            u r13 = this.imageLink;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            c59.b r16 = this.action;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            q r20 = this.pageInfo;
            if (r20 == null) goto L31;
            r1 = r20.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DslFunctionIntroductionItem(condition=" + this.condition + ", tag=" + this.tag + ", title=" + this.title + ", subtitle=" + this.subtitle + ", imageLink=" + this.imageLink + ", action=" + this.action + ", pageInfo=" + this.pageInfo + ')';
        }

        public b() {
            Boolean r0 = Boolean.FALSE;
            this.condition = null;
            this.tag = r0;
            this.title = null;
            this.subtitle = null;
            this.imageLink = null;
            this.action = null;
            this.pageInfo = null;
        }

        public final c59.b a() {
            return this.action;
        }

        public final j b() {
            return this.condition;
        }

        public final u c() {
            return this.imageLink;
        }

        public final q d() {
            return this.pageInfo;
        }

        public final t e() {
            return this.subtitle;
        }

        public final Boolean f() {
            return this.tag;
        }

        public final t g() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionSet;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "items", "", "Lcom/larus/dora/impl/device/manage/feature/DoraFeatureIntroductionFragment$DslFunctionIntroductionItem;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Ljava/util/List;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("items")
        private final List<b> items;

        @SerializedName("title")
        private final t title;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.items, r6.items) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            t r0 = this.title;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<b> r4 = this.items;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DslFunctionIntroductionSet(title=" + this.title + ", items=" + this.items + ')';
        }

        public c() {
            this.title = null;
            this.items = null;
        }

        public final List<b> a() {
            return this.items;
        }
    }

    static {
    }

    public final String k() {
        return "DoraFunctionIntroductionSetFragment";
    }

    public final void W90() {
        LarusDoraFeatureIntroductionFragmentBinding r0 = this.f;
        if (r0 == null) goto L26;
        NestedScrollView r1 = r0.c;
        if (r1 == null) goto L33;
        LinearLayout r2 = r0.b;
        if (r2 == null) goto L34;
        Rect r3 = new Rect();
        r1.getHitRect(r3);
        int r4 = r2.getChildCount();
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L35;
        View r6 = r2.getChildAt(r5);
        if (r6.getLocalVisibleRect(r3) == false) goto L25;
        Object r7 = r6.getTag();
        if ((r7 instanceof String) == false) goto L17;
        String r8 = (String) r7;
    L18:
        if (r8 == null) goto L25;
        if (this.h.add(r8) == false) goto L25;
        String r9 = X90(r8);
        if (r9 == null) goto L25;
        com.larus.dora.impl.device.manage.b.b("feature_introduction", r9);
        goto L25
    L17:
        r8 = null;
    L25:
        r5 = r5 + 1;
        goto L11
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    public DoraFeatureIntroductionFragment() {
        this.g = new com.larus.dora.impl.dynamic.loader.d();
        this.h = new HashSet();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final String X90(String r6) {
        if (StringsKt.contains$default(r6, "diary", false, 2, null) == false) goto L6;
        return "diary";
    L6:
        if (StringsKt.contains$default(r6, "record_minutes", false, 2, null) == false) goto L9;
        return "record_minutes";
    L9:
        if (StringsKt.contains$default(r6, "note", false, 2, null) == false) goto L11;
        return "note";
    L11:
        if (StringsKt.contains$default(r6, "quick_note", false, 2, null) == false) goto L14;
        return "note";
    L14:
        if (StringsKt.contains$default(r6, "podcast", false, 2, null) == false) goto L17;
        return "podcast";
    L17:
        if (StringsKt.contains$default(r6, "natural_awaken", false, 2, null) == false) goto L20;
        return "natural_awaken";
    L20:
        if (StringsKt.contains$default(r6, "interpretation", false, 2, null) == false) goto L23;
        return "interpretation";
    L23:
        return null;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        g49.d.d("DoraFunctionIntroductionSetFragment", "onViewCreated");
        LarusDoraFeatureIntroductionFragmentBinding r13 = this.f;
        if (r13 == null) goto L7;
        AppCompatImageView r14 = r13.d;
        if (r14 == null) goto L7;
        r14.setOnClickListener(new com.larus.dora.impl.device.manage.feature.c(this));
    L7:
        DoraDevice r15 = DoraAdapterExtKt.h(kj4.a.g());
        x0.a.getClass();
        DoraDevice r0 = x0.a();
        final int r1 = -1;
        String r2 = null;
        if (r15 == null) goto L10;
        int r3 = r15.vendorId;
        z49.b r16 = n1.b(r15);
        this.i = r16;
        final String r7 = r16.d();
    L14:
        if (r3 == 4096) goto L17;
        int r17 = n1.a;
        r1 = n1.d(this.i);
    L17:
        StringBuilder r18 = new StringBuilder("fetchData vendorId: ");
        r18.append(r3);
        r18.append(", productId: ");
        r18.append(r1);
        r18.append(", model: ");
        r18.append(r7);
        r18.append(", mac: ");
        z49.b r4 = this.i;
        if (r4 == null) goto L20;
        r2 = r4.c();
    L20:
        r18.append(r2);
        r18.append(", pageKey: g_feature_intro_v1");
        g49.d.d("DoraFunctionIntroductionSetFragment", r18.toString());
        com.larus.dora.impl.dynamic.loader.d.b(this.g, LifecycleOwnerKt.getLifecycleScope(this), Integer.valueOf(r3), Integer.valueOf(r1), r7, "g_feature_intro_v1", new DoraFeatureIntroductionFragment$fetchData$1(this, r1, r7));
        return;
    L10:
        if (r0 == null) goto L12;
        int r110 = r0.vendorId;
        z49.b r5 = n1.b(r0);
        this.i = r5;
        r7 = r5.d();
        r3 = r110;
        goto L14
    L12:
        this.i = null;
        r7 = null;
        r3 = -1;
        goto L14
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562178, r8, false);
        int r11 = 2131365233;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131365233);
        if (r2 == null) goto L17;
        r11 = 2131385238;
        NestedScrollView r3 = ViewBindings.findChildViewById(r10, 2131385238);
        if (r3 == null) goto L17;
        r11 = 2131388801;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r10, 2131388801);
        if (r4 == null) goto L17;
        r11 = 2131388804;
        if (ViewBindings.findChildViewById(r10, 2131388804) == null) goto L17;
        r11 = 2131388843;
        if (ViewBindings.findChildViewById(r10, 2131388843) == null) goto L17;
        r11 = 2131388915;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131388915);
        if (r5 == null) goto L17;
        LinearLayout r12 = (LinearLayout) r10;
        this.f = new LarusDoraFeatureIntroductionFragmentBinding(r12, r2, r3, r4, r5);
        return r12;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
