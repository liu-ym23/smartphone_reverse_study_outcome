package com.larus.dora.impl.dynamic.viewholder;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dora.annotation.ProductNameType;
import com.google.gson.annotations.SerializedName;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoBannerLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.util.b0;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\r\u001a\u00020\t*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoBannerHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoBannerLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoBannerLayoutBinding;)V", "data", "show", "", "bannerType", "", "productId", "openSodaVipApplet", "bind", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfoBannerHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int d = 0;
    public final LarusDoraDeviceInfoBannerLayoutBinding b;
    public c59.i c;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.DeviceInfoBannerHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoBannerHolder$Companion$DslBannerConfig;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "subTitle", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getSubTitle", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0068a {

            @SerializedName("action")
            private final c59.b action;

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("subtitle")
            private final c59.t subTitle;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0068a) == true) goto L8;
                return false;
            L8:
                C0068a r6 = (C0068a) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.action, r6.action) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.t r4 = this.subTitle;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                c59.b r7 = this.action;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                c59.u r10 = this.imageLink;
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
                return "DslBannerConfig(title=" + this.title + ", subTitle=" + this.subTitle + ", action=" + this.action + ", imageLink=" + this.imageLink + ')';
            }

            public C0068a() {
                this.title = null;
                this.subTitle = null;
                this.action = null;
                this.imageLink = null;
            }

            public final c59.t a() {
                return this.subTitle;
            }

            public final c59.t b() {
                return this.title;
            }
        }
    }

    static {
    }

    public DeviceInfoBannerHolder(LarusDoraDeviceInfoBannerLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r8, e59.b r9, d59.b r10) {
        c59.i r11 = r8;
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r9, "connectionState");
        final LarusDoraDeviceInfoBannerLayoutBinding r12 = this.b;
        if (r12 == null) goto L38;
        this.c = r11;
        Lazy r0 = c59.s.a;
        a.C0068a r13 = (a.C0068a) c59.s.c(r11.b, a.C0068a.class);
        String r1 = ILoginService.a.getAccountInfo().c;
        b0.a.getClass();
        RecyclerView r3 = null;
        if (b0.f(r1) == false) goto L27;
        e1.x(((RecyclerView.ViewHolder) this).itemView);
        RecyclerView.LayoutParams r2 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r4 = r2;
        ((ViewGroup.MarginLayoutParams) r4).width = -1;
        ((ViewGroup.MarginLayoutParams) r4).height = -2;
        r4.setMargins(i5.q(), 0, i5.q(), i5.q());
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(r4);
        AppCompatTextView r5 = r12.e;
        if (r13 == null) goto L11;
        c59.t r6 = r13.b();
        if (r6 == null) goto L11;
        CharSequence r7 = c59.p.b(r6);
    L12:
        r5.setText(r7);
        AppCompatTextView r14 = r12.d;
        if (r13 == null) goto L17;
        c59.t r15 = r13.a();
        if (r15 == null) goto L17;
        String r16 = c59.p.b(r15);
    L18:
        r14.setText(r16);
        e1.x(r12.c);
        if (r10 == null) goto L25;
        z49.b r17 = r10.a;
        if (r17 == null) goto L25;
        Integer r18 = r17.f();
        if (r18 == null) goto L25;
        final int r20 = r18.intValue();
    L26:
        Intrinsics.checkNotNullParameter(r12, "<this>");
        e1.x(r12.a);
        e1.d(r12.b, new com.larus.dora.impl.dynamic.viewholder.a(this, r12, r20));
        e1.d(r12.c, new b(this, r12));
    L28:
        ViewParent r21 = ((RecyclerView.ViewHolder) this).itemView.getParent();
        if ((r21 instanceof RecyclerView) == false) goto L31;
        r3 = (RecyclerView) r21;
    L31:
        if (r3 == null) goto L39;
        RecyclerView.Adapter r22 = r3.getAdapter();
        if (r22 == null) goto L40;
        int r23 = getAbsoluteAdapterPosition();
        if (r23 == (-1)) goto L41;
        r22.notifyItemChanged(r23);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L25:
        r20 = ProductNameType.DORA_LITE.id;
    L17:
        r16 = null;
    L11:
        r7 = null;
        goto L12
    L27:
        e1.o(((RecyclerView.ViewHolder) this).itemView);
        RecyclerView.LayoutParams r24 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r25 = r24;
        ((ViewGroup.MarginLayoutParams) r25).width = 0;
        ((ViewGroup.MarginLayoutParams) r25).height = 0;
        r25.setMargins(0, 0, 0, 0);
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(r25);
        goto L28
    }
}
