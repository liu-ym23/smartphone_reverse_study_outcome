package com.larus.dora.impl.dynamic.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoDuoGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.dynamic.dsl.DslEnableCondition;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JL\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DuoGroupHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoDuoGroupLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoDuoGroupLayoutBinding;)V", "FIXED_COLUMN_COUNT", "", "ITEM_SPACING", "ITEM_PADDING", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "generateGridItems", "context", "Landroid/content/Context;", "doraDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "parentGrid", "Landroid/widget/GridLayout;", "items", "", "Lcom/larus/dora/impl/dynamic/viewholder/DuoGroupHolder$Companion$DslDuoItem;", "starling", "", "", "connectState", "createGridItemLayoutParams", "Landroid/widget/GridLayout$LayoutParams;", "itemIndex", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DuoGroupHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceInfoDuoGroupLayoutBinding b;
    public final int c;
    public final int d;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.DuoGroupHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DuoGroupHolder$Companion$DslDuoGroup;", "", "items", "", "Lcom/larus/dora/impl/dynamic/viewholder/DuoGroupHolder$Companion$DslDuoItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0072a {

            @SerializedName("items")
            private final List<b> items;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0072a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.items, ((C0072a) r4).items) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                List<b> r0 = this.items;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "DslDuoGroup(items=" + this.items + ')';
            }

            public C0072a() {
                this.items = null;
            }

            public final List<b> a() {
                return this.items;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DuoGroupHolder$Companion$DslDuoItem;", "", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslAction;)V", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

            @SerializedName("action")
            private final c59.b action;

            @SerializedName("condition")
            private final c59.j condition;

            @SerializedName("image_link")
            private final c59.u imageLink;

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
                if (Intrinsics.areEqual(this.condition, r6.condition) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.action, r6.action) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                c59.j r0 = this.condition;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.u r4 = this.imageLink;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                c59.t r7 = this.title;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                c59.b r10 = this.action;
                if (r10 == null) goto L19;
                r1 = r10.hashCode();
            L19:
                return r9 + r1;
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
                return "DslDuoItem(condition=" + this.condition + ", imageLink=" + this.imageLink + ", title=" + this.title + ", action=" + this.action + ')';
            }

            public b() {
                this.condition = null;
                this.imageLink = null;
                this.title = null;
                this.action = null;
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

            public final c59.t d() {
                return this.title;
            }
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslActionType.values().length];
            r0[DslActionType.INTERNAL_JUMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[DslActionType.JUMP_OWEN_AND_CHECK_SHOW_TOAST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[DslActionType.INTERNAL_JUMP_TTS_SPEAKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[DslActionType.EXTERNAL_JUMP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[DslActionType.JUMP_DYNAMIC_DATA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public DuoGroupHolder(LarusDoraDeviceInfoDuoGroupLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.c = 2;
        this.d = i5.q();
        i5.h();
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r18, e59.b r110, d59.b r20) {
        DuoGroupHolder r0 = this;
        c59.i r3 = r18;
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r110, "connectionState");
        LarusDoraDeviceInfoDuoGroupLayoutBinding r4 = r0.b;
        Lazy r5 = c59.s.a;
        a.C0072a r6 = (a.C0072a) c59.s.c(r3.b, a.C0072a.class);
        if (r6 == null) goto L5;
        List<a.b> r7 = r6.a();
    L6:
        if (r7 != null) goto L8;
        r7 = CollectionsKt.emptyList();
    L8:
        List r8 = CollectionsKt.filterNotNull(r7);
        if (r8.isEmpty() == true) goto L62;
        if (r20 == null) goto L12;
        z49.b r9 = r20.a;
    L13:
        if (r9 == null) goto L62;
        g49.d.d("DuoGroupHolder", "generateGridItems, cardContext.device: " + r20.a + ", items.size: " + r8.size());
        final z49.b r2 = r20.a;
        if (r2 == null) goto L72;
        final Context r10 = ((RecyclerView.ViewHolder) r0).itemView.getContext();
        GridLayout r11 = r4.b;
        r11.removeAllViews();
        r11.setColumnCount(r0.c);
        int r12 = r0.d / 2;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r8.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if (c59.p.c(((a.b) r15).b(), r2.h(), r2.f(), r2.c(), null) == false) goto L19;
        r13.add(r15);
        goto L19
    L23:
        Iterator r16 = r13.iterator();
        boolean r17 = false;
        int r111 = 0;
    L25:
        if (r16.hasNext() == false) goto L73;
        Object r112 = r16.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        final a.b r114 = (a.b) r112;
        View r115 = LayoutInflater.from(r10).inflate(2131562150, r11, r17);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundFrameLayout");
        RoundFrameLayout r116 = (RoundFrameLayout) r115;
        AppCompatTextView r117 = (DoraTextView) r116.findViewById(2131370392);
        SimpleDraweeView r118 = (SimpleDraweeView) r116.findViewById(2131370391);
        ViewGroup.LayoutParams r21 = r116.getLayoutParams();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.widget.GridLayout.LayoutParams");
        GridLayout.LayoutParams r22 = (GridLayout.LayoutParams) r21;
        int r23 = r0.c;
        int r119 = r111 / r23;
        int r120 = r111 % r23;
        r22.rowSpec = GridLayout.spec(r119);
        r22.columnSpec = GridLayout.spec(r120);
        Resources r24 = r10.getResources();
        r22.width = (WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics()).widthPixels - (i5.q() * 3)) / 2;
        if (r120 != 0) goto L32;
        int r25 = 0;
    L34:
        if (r120 != 1) goto L36;
        int r121 = 0;
    L37:
        r22.setMargins(r25, 0, r121, r0.d);
        r116.setLayoutParams(r22);
        c59.j r26 = r114.b();
        if (r26 == null) goto L45;
        List<DslEnableCondition> r27 = r26.b();
        if (r27 == null) goto L45;
        if (r27.contains(DslEnableCondition.DEVICE_CONNECTED) != true) goto L45;
        boolean r28 = true;
    L46:
        if (r28 == true) goto L48;
    L50:
        final boolean r30 = false;
    L51:
        c59.t r31 = r114.d();
        if (r31 == null) goto L56;
        CharSequence r32 = c59.p.b(r31);
        if (r32 == null) goto L56;
    L57:
        r117.setText(r32);
        Intrinsics.checkNotNull(r118);
        c59.p.e(r118, r114.c(), null, r2.f(), 2);
        if (r30 == false) goto L60;
        r117.setAlpha(0.3f);
        r118.setAlpha(0.3f);
    L61:
        e1.d(r116, new o(r114, r30, r2, r10));
        r11.addView(r116);
        r111 = r113;
        r17 = false;
        r0 = this;
        goto L25
    L60:
        r117.setAlpha(1.0f);
        r118.setAlpha(1.0f);
    L56:
        r32 = "";
        goto L57
    L48:
        if ((r110 instanceof e59.b.a) == true) goto L50;
        r30 = true;
    L45:
        r28 = false;
        goto L46
    L36:
        r121 = r12;
        goto L37
    L32:
        r25 = r12;
        goto L34
    L73:
        return;
    L72:
        return;
    L12:
        r9 = null;
    L62:
        r4.b.removeAllViews();
        return;
    L5:
        r7 = null;
        goto L6
    }
}
