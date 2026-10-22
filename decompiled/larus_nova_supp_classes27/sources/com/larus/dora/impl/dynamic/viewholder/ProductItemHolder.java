package com.larus.dora.impl.dynamic.viewholder;

import android.net.Uri;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.databinding.LarusDoraDynamicListItemBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/ProductItemHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDynamicListItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDynamicListItemBinding;)V", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProductItemHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int b = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.ProductItemHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/ProductItemHolder$Companion$DslProductItem;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "subtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "deviceType", "", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Ljava/lang/String;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getSubtitle", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getDeviceType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0074a {

            @SerializedName("action")
            private final c59.b action;

            @SerializedName("device_type")
            private final String deviceType;

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("subtitle")
            private final c59.t subtitle;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0074a) == true) goto L8;
                return false;
            L8:
                C0074a r6 = (C0074a) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.subtitle, r6.subtitle) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.action, r6.action) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.deviceType, r6.deviceType) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.t r4 = this.subtitle;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                c59.u r7 = this.imageLink;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                c59.b r10 = this.action;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.deviceType;
                if (r13 == null) goto L23;
                r1 = r13.hashCode();
            L23:
                return r12 + r1;
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
                return "DslProductItem(title=" + this.title + ", subtitle=" + this.subtitle + ", imageLink=" + this.imageLink + ", action=" + this.action + ", deviceType=" + this.deviceType + ')';
            }

            public C0074a() {
                this.title = null;
                this.subtitle = null;
                this.imageLink = null;
                this.action = null;
                this.deviceType = "";
            }

            public final c59.b a() {
                return this.action;
            }

            public final c59.u b() {
                return this.imageLink;
            }

            public final c59.t c() {
                return this.subtitle;
            }

            public final c59.t d() {
                return this.title;
            }
        }
    }

    static {
    }

    public ProductItemHolder(LarusDoraDynamicListItemBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r5, e59.b r6, final d59.b r7) {
        c59.i r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r6, "connectionState");
        Lazy r9 = c59.s.a;
        final a.C0074a r10 = (a.C0074a) c59.s.c(r8.b, a.C0074a.class);
        if (r10 == null) goto L13;
        c59.b r0 = r10.a();
        if (r0 == null) goto L13;
        String r1 = r0.e();
        if (r1 == null) goto L13;
        Uri r2 = UriProtector.parse(r1);
        if (r2 == null) goto L13;
        String r3 = UriProtector.getQueryParameter(r2, "product_id");
        if (r3 == null) goto L13;
        Integer r4 = StringsKt.toIntOrNull(r3);
    L14:
        TextView r11 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390494);
        String r12 = "";
        if (r10 == null) goto L20;
        c59.t r13 = r10.d();
        if (r13 == null) goto L20;
        String r14 = c59.p.b(r13);
        if (r14 == null) goto L20;
    L21:
        r11.setText(r14);
        r11.setContentDescription(r14);
        TextView r15 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390492);
        if (r10 == null) goto L29;
        c59.t r16 = r10.c();
        if (r16 == null) goto L29;
        String r17 = c59.p.b(r16);
        if (r17 == null) goto L29;
        r12 = r17;
    L29:
        r15.setText(r12);
        r15.setContentDescription(r12);
        final SimpleDraweeView r18 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374973);
        r18.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        Intrinsics.checkNotNull(r18);
        if (r10 == null) goto L32;
        c59.u r20 = r10.b();
    L33:
        c59.p.e(r18, r20, null, r4, 2);
        e1.d(r18, new v(r10, r18, r7));
        return;
    L32:
        r20 = null;
    L20:
        r14 = "";
    L13:
        r4 = null;
        goto L14
    }
}
