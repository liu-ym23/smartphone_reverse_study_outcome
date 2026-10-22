package com.larus.dora.impl.dynamic.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J<\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding;)V", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "generateFuncIntroSetView", "context", "Landroid/content/Context;", "doraDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "parentLayout", "Landroid/widget/LinearLayout;", "config", "Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder$Companion$DslFunctionIntroductionSet;", "starling", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FunctionIntroductionSetHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding b;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.FunctionIntroductionSetHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jb\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder$Companion$DslFunctionIntroductionItem;", "", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "tag", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "subtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/lang/Boolean;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;)V", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getTag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getSubtitle", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getPageInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/lang/Boolean;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;)Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder$Companion$DslFunctionIntroductionItem;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0073a {

            @SerializedName("action")
            private final c59.b action;

            @SerializedName("condition")
            private final c59.j condition;

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("page_info")
            private final c59.q pageInfo;

            @SerializedName("subtitle")
            private final c59.t subtitle;

            @SerializedName("tag")
            private final Boolean tag;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0073a) == true) goto L8;
                return false;
            L8:
                C0073a r6 = (C0073a) r5;
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
                c59.j r0 = this.condition;
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
                c59.t r7 = this.title;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                c59.t r10 = this.subtitle;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                c59.u r13 = this.imageLink;
                if (r13 != null) goto L21;
                int r14 = 0;
            L22:
                int r15 = (r12 + r14) * 31;
                c59.b r16 = this.action;
                if (r16 != null) goto L25;
                int r17 = 0;
            L26:
                int r18 = (r15 + r17) * 31;
                c59.q r20 = this.pageInfo;
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

            public C0073a() {
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

            public final c59.j b() {
                return this.condition;
            }

            public final c59.u c() {
                return this.imageLink;
            }

            public final c59.q d() {
                return this.pageInfo;
            }

            public final c59.t e() {
                return this.subtitle;
            }

            public final Boolean f() {
                return this.tag;
            }

            public final c59.t g() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder$Companion$DslFunctionIntroductionSet;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "items", "", "Lcom/larus/dora/impl/dynamic/viewholder/FunctionIntroductionSetHolder$Companion$DslFunctionIntroductionItem;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Ljava/util/List;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

            @SerializedName("items")
            private final List<C0073a> items;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.items, r6.items) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                List<C0073a> r4 = this.items;
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

            public b() {
                this.title = null;
                this.items = null;
            }

            public final List<C0073a> a() {
                return this.items;
            }

            public final c59.t b() {
                return this.title;
            }
        }
    }

    static {
    }

    public FunctionIntroductionSetHolder(LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r9, e59.b r10, d59.b r11) {
        c59.i r12 = r9;
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r10, "connectionState");
        LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding r13 = this.b;
        Lazy r0 = c59.s.a;
        a.b r14 = (a.b) c59.s.c(r12.b, a.b.class);
        if (r14 == null) goto L54;
        if (r11 == null) goto L55;
        final z49.b r15 = r11.a;
        if (r15 == null) goto L56;
        final Context r1 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        LinearLayout r16 = r13.b;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r15, "doraDevice");
        Intrinsics.checkNotNullParameter(r16, "parentLayout");
        Intrinsics.checkNotNullParameter(r14, "config");
        r16.removeViews(1, r16.getChildCount() - 1);
        c59.t r2 = r14.b();
        if (r2 == null) goto L12;
        CharSequence r3 = c59.p.b(r2);
        if (r3 == null) goto L12;
        ((DoraTextView) r16.findViewById(2131373378)).setText(r3);
    L12:
        List<a.C0073a> r17 = r14.a();
        if (r17 != null) goto L15;
        r17 = CollectionsKt.emptyList();
    L15:
        List r18 = CollectionsKt.filterNotNull(r17);
        ArrayList r4 = new ArrayList();
        Iterator r20 = r18.iterator();
    L17:
        if (r20.hasNext() == false) goto L21;
        Object r5 = r20.next();
        if (c59.p.c(((a.C0073a) r5).b(), r15.h(), r15.f(), r15.c(), null) == false) goto L17;
        r4.add(r5);
        goto L17
    L21:
        Iterator r21 = r4.iterator();
    L23:
        if (r21.hasNext() == false) goto L43;
        final a.C0073a r6 = (a.C0073a) r21.next();
        boolean r7 = false;
        ConstraintLayout r8 = LayoutInflater.from(r1).inflate(2131562151, r16, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        ConstraintLayout r22 = (RoundConstraintLayout) r8;
        Boolean r23 = r6.f();
        if (r23 == null) goto L27;
        r7 = r23.booleanValue();
    L27:
        ImageView r24 = (ImageView) r22.findViewById(2131377266);
        Intrinsics.checkNotNull(r24);
        if (r7 == false) goto L30;
        e1.x(r24);
    L31:
        SimpleDraweeView r25 = r22.findViewById(2131377265);
        Intrinsics.checkNotNull(r25);
        c59.u r26 = r6.c();
        int r27 = l59.a.a;
        c59.p.d(r25, r26, MapsKt.mapOf(TuplesKt.to("product", l59.a.d(r15.a))), r15.f());
        AppCompatTextView r28 = (DoraTextView) r22.findViewById(2131373374);
        AppCompatTextView r30 = (DoraTextView) r22.findViewById(2131373373);
        c59.t r31 = r6.g();
        CharSequence r32 = "";
        if (r31 == null) goto L36;
        CharSequence r33 = c59.p.b(r31);
        if (r33 == null) goto L36;
    L37:
        r28.setText(r33);
        c59.t r34 = r6.e();
        if (r34 == null) goto L42;
        CharSequence r35 = c59.p.b(r34);
        if (r35 == null) goto L42;
        r32 = r35;
    L42:
        r30.setText(r32);
        e1.d(r22, new p(r6, r1, r15));
        r16.addView(r22);
    L36:
        r33 = "";
        goto L37
    L30:
        e1.o(r24);
        goto L31
    L43:
        Unit r36 = Unit.INSTANCE;
        return;
    L56:
        return;
    L55:
        return;
    }
}
