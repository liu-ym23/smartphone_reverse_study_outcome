package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.layout.widget.ScrollToRecyclerView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.view.FixHorizontalDisallowRecyclerView;
import com.larus.bmhome.chat.view.FlowTagLayout;
import com.larus.bmhome.databinding.LarusExpertCardBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemShowType;
import com.larus.im.bean.message.ItemType;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ExpertCardBox extends xc8.h {
    public static final Map<String, Boolean> t = null;
    public static final Map<String, Integer> u = null;
    public b p;
    public String q;
    public final LarusExpertCardBinding r;
    public final CubicBezierInterpolator s;

    public static final class ExpertTextCardAdapter extends ListAdapter<ItemData, RecyclerView.ViewHolder> {
        public final com.larus.bmhome.chat.api.q0 a;
        public final Message b;
        public final BotModel c;
        public final int d;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter$ExpertCardMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter;Landroid/view/View;)V", "buttonSearchMore", "getButtonSearchMore", "()Landroid/view/View;", "bind", "", "item", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        public final class ExpertCardMoreViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int c = 0;
            public final View a;
            public final /* synthetic */ ExpertTextCardAdapter b;

            public ExpertCardMoreViewHolder(ExpertTextCardAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.b = r2;
                super(r3);
                this.a = r3.findViewById(2131365048);
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J0\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter$ExpertCardTextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "getTextTitle", "()Landroid/widget/TextView;", "texCreator", "getTexCreator", "imageCreateAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageCreateAvatar", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bind", "", "item", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "position", "", "rowPosition", "bot", "Lcom/larus/im/bean/bot/BotModel;", "loadImage", "imageView", "url", "", "bizTag", "resizeWidth", "reSizeHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        public final class ExpertCardTextViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int e = 0;
            public final TextView a;
            public final TextView b;
            public final SimpleDraweeView c;
            public final /* synthetic */ ExpertTextCardAdapter d;

            public ExpertCardTextViewHolder(ExpertTextCardAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.d = r2;
                super(r3);
                this.a = (TextView) r3.findViewById(2131388514);
                this.b = (TextView) r3.findViewById(2131388418);
                this.c = r3.findViewById(2131374977);
            }
        }

        public final int getItemViewType(int r1) {
            return ((ItemData) getItem(r1)).getSearchItemType().getType();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r23, final int r24) {
            Intrinsics.checkNotNullParameter(r23, "holder");
            ItemData r3 = (ItemData) getItem(r24);
            com.larus.bmhome.chat.api.q0.a r10 = null;
            if ((r23 instanceof ExpertCardTextViewHolder) == false) goto L28;
            if ((r3 instanceof ArticleInfo) == false) goto L7;
            final ArticleInfo r7 = (ArticleInfo) r3;
        L8:
            if (r7 != null) goto L10;
            return;
        L10:
            final ExpertCardTextViewHolder r9 = (ExpertCardTextViewHolder) r23;
            final int r5 = this.d;
            final BotModel r8 = this.c;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r8, "bot");
            r9.a.setText(r7.getTitle());
            r9.b.setText(r7.getSiteName());
            String r4 = r7.getIconUrl();
            if (r4 != null) goto L13;
        L16:
            boolean r6 = true;
        L17:
            if (r6 == false) goto L19;
            com.larus.utils.e1.o(r9.c);
        L23:
            View r11 = ((RecyclerView.ViewHolder) r9).itemView;
            final ExpertTextCardAdapter r12 = r9.d;
            com.larus.utils.e1.d(r11, new e0(r12, r5, r24, r7, r8, r9));
            Message r14 = this.b;
            com.larus.bmhome.chat.api.q0 r15 = this.a;
            if (r15 == null) goto L26;
            r10 = r15.getProvider();
        L26:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r14, r15, r10, null, null, null, null, 120), r23.itemView);
            return;
        L19:
            com.larus.utils.e1.x(r9.c);
            final SimpleDraweeView r13 = r9.c;
            String r16 = r7.getIconUrl();
            if (r16 != null) goto L22;
            r16 = "";
        L22:
            final int r17 = i5.q();
            final int r18 = i5.q();
            ImageLoaderKt.y(r13, r16, "chat.expert_source_icon", new f0(r13, r17, r18), 4);
            goto L23
        L13:
            if (r4.length() == 0) goto L16;
            r6 = false;
            goto L17
        L7:
            r7 = null;
            goto L8
        L28:
            if ((r23 instanceof ExpertCardMoreViewHolder) == true) goto L30;
            return;
        L30:
            if ((r3 instanceof Extra) == false) goto L32;
            final Extra r19 = (Extra) r3;
        L33:
            if (r19 != null) goto L35;
            return;
        L35:
            final ExpertCardMoreViewHolder r2 = (ExpertCardMoreViewHolder) r23;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r19, "item");
            View r20 = r2.a;
            final ExpertTextCardAdapter r21 = r2.b;
            com.larus.utils.e1.d(r20, new d0(r19, r2, r21));
            Message r110 = this.b;
            com.larus.bmhome.chat.api.q0 r111 = this.a;
            if (r111 == null) goto L38;
            r10 = r111.getProvider();
        L38:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r110, r111, r10, null, null, null, null, 120), r23.itemView);
            return;
        L32:
            r19 = null;
            goto L33
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != ItemType.TYPE_CARD_IMAGE_TEXT.getType()) goto L5;
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562567, r3, false);
            Intrinsics.checkNotNull(r5);
            return new ExpertCardTextViewHolder(this, r5);
        L5:
            View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562565, r3, false);
            Intrinsics.checkNotNull(r6);
            return new ExpertCardMoreViewHolder(this, r6);
        }

        public ExpertTextCardAdapter(com.larus.bmhome.chat.api.q0 r2, Message r3, BotModel r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "bot");
            super(new AnonymousClass1());
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "Lcom/larus/im/bean/message/ItemData;", "searchUrl", "", "searchUrlApp", "stepTitleFailed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSearchUrl", "()Ljava/lang/String;", "setSearchUrl", "(Ljava/lang/String;)V", "getSearchUrlApp", "setSearchUrlApp", "getStepTitleFailed", "setStepTitleFailed", "getSearchUrlCompat", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Extra extends ItemData {
        public final transient ItemType a;

        @SerializedName("search_url")
        private String searchUrl;

        @SerializedName("search_url_app")
        private String searchUrlApp;

        @SerializedName("title_failed")
        private String stepTitleFailed;

        public Extra() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.searchUrl;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.searchUrlApp;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.stepTitleFailed;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.searchUrl;
        }

        public final String component2() {
            return this.searchUrlApp;
        }

        public final String component3() {
            return this.stepTitleFailed;
        }

        public final Extra copy(String r2, String r3, String r4) {
            return new Extra(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Extra) == true) goto L8;
            return false;
        L8:
            Extra r6 = (Extra) r5;
            if (Intrinsics.areEqual(this.searchUrl, r6.searchUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.searchUrlApp, r6.searchUrlApp) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.stepTitleFailed, r6.stepTitleFailed) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.searchUrl;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.searchUrlApp;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.stepTitleFailed;
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
            return "Extra(searchUrl=" + this.searchUrl + ", searchUrlApp=" + this.searchUrlApp + ", stepTitleFailed=" + this.stepTitleFailed + ')';
        }

        public final String getSearchUrlCompat() {
            String r0 = this.searchUrlApp;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            return this.searchUrl;
        L12:
            return this.searchUrlApp;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public String getId() {
            return this.searchUrl;
        }

        public ItemType getSearchItemType() {
            return this.a;
        }

        public final String getSearchUrl() {
            return this.searchUrl;
        }

        public final String getSearchUrlApp() {
            return this.searchUrlApp;
        }

        public final String getStepTitleFailed() {
            return this.stepTitleFailed;
        }

        public final void setSearchUrl(String r1) {
            this.searchUrl = r1;
        }

        public final void setSearchUrlApp(String r1) {
            this.searchUrlApp = r1;
        }

        public final void setStepTitleFailed(String r1) {
            this.stepTitleFailed = r1;
        }

        public Extra(String r1, String r2, String r3) {
            this.searchUrl = r1;
            this.searchUrlApp = r2;
            this.stepTitleFailed = r3;
            this.a = ItemType.TYPE_CARD_MORE;
        }

        public /* synthetic */ Extra(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    public static final class StepAdapter extends ListAdapter<c, RecyclerView.ViewHolder> {
        public final com.larus.bmhome.chat.api.q0 a;
        public final Message b;
        public final BotModel c;

        @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001aJ\u0018\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 H\u0002J0\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u000e\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020 H\u0002J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0AH\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u001aH\u0002J \u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020GH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$¨\u0006H"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepAdapter$ExpertCardNormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepAdapter;Landroid/view/View;)V", "textStepTitle", "Landroid/widget/TextView;", "getTextStepTitle", "()Landroid/widget/TextView;", "imageStepIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageStepIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "progressStepLoading", "getProgressStepLoading", "()Landroid/view/View;", "tagLayoutContent", "Lcom/larus/bmhome/chat/view/FlowTagLayout;", "getTagLayoutContent", "()Lcom/larus/bmhome/chat/view/FlowTagLayout;", "recyclerView", "Lcom/larus/bmhome/chat/layout/widget/ScrollToRecyclerView;", "getRecyclerView", "()Lcom/larus/bmhome/chat/layout/widget/ScrollToRecyclerView;", "currentRowPosition", "", "getCurrentRowPosition", "()I", "setCurrentRowPosition", "(I)V", "currentStepId", "", "getCurrentStepId", "()Ljava/lang/String;", "setCurrentStepId", "(Ljava/lang/String;)V", "currentMsgId", "getCurrentMsgId", "setCurrentMsgId", "bind", "", "item", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "message", "Lcom/larus/im/bean/message/Message;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "rowPosition", "generateVerticalTextView", "parent", "Landroid/view/ViewGroup;", ChatDraftItem.TYPE_TEXT, "loadImage", "imageView", "url", "bizTag", "resizeWidth", "reSizeHeight", "setFullVisibleStatus", "fullVisible", "", "setupCardScrollShowReporter", "id", "getExpertScrollOffsetRecorder", "", "handleExposeEndView", "lastExposePosition", "itemFirstShowAction", "position", "itemData", "Lcom/larus/im/bean/message/ItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        public final class ExpertCardNormalViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int j = 0;
            public final TextView a;
            public final SimpleDraweeView b;
            public final View c;
            public final FlowTagLayout d;
            public final ScrollToRecyclerView e;
            public int f;
            public String g;
            public String h;
            public final /* synthetic */ StepAdapter i;

            public final void V3(boolean r10) {
                if (r10 == true) goto L5;
                this.e.clearOnScrollListeners();
                this.e.setRecyclerScrollListener(new g0(this));
                return;
            L5:
                LinearLayoutManager r11 = this.e.getLayoutManager();
                if ((r11 instanceof LinearLayoutManager) == false) goto L8;
                LinearLayoutManager r12 = r11;
            L9:
                if (r12 != null) goto L11;
                return;
            L11:
                ListAdapter r0 = this.e.getAdapter();
                if ((r0 instanceof ListAdapter) == false) goto L14;
                ListAdapter r1 = r0;
            L15:
                if (r1 != null) goto L17;
                return;
            L17:
                Iterator r2 = r1.getCurrentList().iterator();
            L19:
                if (r2.hasNext() == false) goto L26;
                Object r3 = r2.next();
                if ((r3 instanceof ItemData) == false) goto L23;
                ItemData r4 = (ItemData) r3;
            L24:
                if (r4 == null) goto L19;
                r4.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_NONE);
                goto L19
            L23:
                r4 = null;
                goto L24
            L26:
                int r5 = r12.findFirstVisibleItemPosition();
                int r6 = r12.findLastVisibleItemPosition();
                if (r5 > r6) goto L46;
            L28:
                Object r7 = CollectionsKt.getOrNull(r1.getCurrentList(), r5);
                if ((r7 instanceof ItemData) == false) goto L31;
                ItemData r8 = (ItemData) r7;
            L32:
                if (r8 == null) goto L33;
                View r9 = r12.findViewByPosition(r5);
                if (r9 == null) goto L36;
                Rect r13 = new Rect();
                boolean r14 = r9.getGlobalVisibleRect(r13);
                float r15 = r13.width() / RangesKt.coerceAtLeast(r9.getWidth(), 0.1f);
                if (r14 == true) goto L40;
            L44:
                if (r5 == r6) goto L46;
                r5 = r5 + 1;
                goto L28
            L40:
                if (r15 < 0.5f) goto L44;
                if (r8.getItemShowType() != ItemShowType.ITEM_SHOW_TYPE_NONE) goto L44;
                r8.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_AUTO);
                U3(r5, this.f, r8);
                goto L44
            L36:
                return;
            L33:
                return;
            L31:
                r8 = null;
            L46:
                final String r16 = this.h + this.g;
                this.e.clearOnScrollListeners();
                this.e.setRecyclerScrollListener(new j0(this, r16));
                this.e.addOnScrollListener(new ExpertCardBox$StepAdapter$ExpertCardNormalViewHolder$setupCardScrollShowReporter$2(this));
                return;
            L14:
                r1 = null;
                goto L15
            L8:
                r12 = null;
                goto L9
            }

            public ExpertCardNormalViewHolder(StepAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                this.i = r2;
                super(r3);
                this.a = (TextView) r3.findViewById(2131388505);
                this.b = r3.findViewById(2131375075);
                this.c = r3.findViewById(2131383327);
                this.d = r3.findViewById(2131388108);
                this.e = (ScrollToRecyclerView) r3.findViewById(2131385014);
                this.f = -1;
            }

            public static final void T3(ExpertCardNormalViewHolder r2, int r3) {
                ListAdapter r4 = r2.e.getAdapter();
                ItemData r1 = null;
                if ((r4 instanceof ListAdapter) == false) goto L5;
                ListAdapter r5 = r4;
            L6:
                if (r5 == null) goto L18;
                Object r6 = CollectionsKt.getOrNull(r5.getCurrentList(), r3);
                if ((r6 instanceof ItemData) == false) goto L11;
                r1 = (ItemData) r6;
            L11:
                if (r1 == null) goto L19;
                ItemShowType r7 = r1.getItemShowType();
                ItemShowType r8 = ItemShowType.ITEM_SHOW_TYPE_NONE;
                if (r7 == r8) goto L20;
                r1.setItemShowType(r8);
                return;
            L20:
                return;
            L19:
                return;
            L18:
                return;
            L5:
                r5 = null;
                goto L6
            }

            public final void U3(int r19, int r20, ItemData r21) {
                int r1 = oi8.f.a;
                com.larus.bmhome.chat.api.q0 r2 = this.i.a;
                ChatParam r3 = null;
                if (r2 == null) goto L5;
                LruSet<String> r4 = r2.E7();
            L6:
                StepAdapter r5 = this.i;
                Message r6 = r5.b;
                com.larus.bmhome.chat.api.q0 r7 = r5.a;
                if (r7 == null) goto L9;
                r3 = r7.getChatParam();
            L9:
                ChatParam r8 = r3;
                String r9 = this.i.c.getBotId();
                if (r9 != null) goto L12;
                r9 = "";
            L12:
                oi8.f.k(r4, r6, r8, r20, r19, r21, null, "link", r9, "half", "expert", 0, 0, null, 14400);
                return;
            L5:
                r4 = null;
                goto L6
            }
        }

        public final int getItemViewType(int r1) {
            return ((c) getItem(r1)).b();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r21, int r22) {
            Intrinsics.checkNotNullParameter(r21, "holder");
            c r2 = (c) getItem(r22);
            if ((r21 instanceof ExpertCardNormalViewHolder) == false) goto L79;
            List r3 = getCurrentList();
            ArrayList r4 = new ArrayList();
            Iterator r5 = r3.iterator();
        L6:
            if (r5.hasNext() == false) goto L10;
            String r6 = ((c) r5.next()).e();
            if (r6 == null) goto L6;
            r4.add(r6);
            goto L6
        L10:
            int r7 = CollectionsKt.indexOf(r4, r2.e());
            final ExpertCardNormalViewHolder r8 = (ExpertCardNormalViewHolder) r21;
            Intrinsics.checkNotNull(r2);
            Message r9 = this.b;
            BotModel r10 = this.c;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r9, "message");
            Intrinsics.checkNotNullParameter(r10, "bot");
            r8.h = r9.getMessageId();
            r8.g = r2.e();
            r8.f = r7;
            TextView r11 = r8.a;
            if (r2.b == false) goto L16;
            Extra r12 = r2.a();
            if (r12 == null) goto L16;
            String r13 = r12.getStepTitleFailed();
            if (r13 == null) goto L16;
        L17:
            r11.setText(r13);
            if (r2.b == false) goto L21;
            com.larus.utils.e1.o(r8.c);
            com.larus.utils.e1.x(r8.b);
            r8.b.setImageResource(2131242677);
        L36:
            com.larus.bmhome.chat.api.q0.a r14 = null;
            if (r2.i() == false) goto L47;
            com.larus.utils.e1.o(r8.e);
            List<e> r15 = r2.h();
            ArrayList r16 = new ArrayList();
            Iterator r17 = ((ArrayList) r15).iterator();
        L40:
            if (r17.hasNext() == false) goto L45;
            String r18 = ((e) r17.next()).a();
            if (r18 != null) goto L44;
            r18 = "";
        L44:
            r16.add(new FlowTagLayout.a(r18, 0, null));
            goto L40
        L45:
            final FlowTagLayout r19 = r8.d;
            com.larus.utils.e1.x(r19);
            r19.setTagViewProvide(new h0(r8, r19));
            r19.a(r16, false);
        L61:
            Message r110 = this.b;
            com.larus.bmhome.chat.api.q0 r111 = this.a;
            if (r111 == null) goto L64;
            r14 = r111.getProvider();
        L64:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r110, r111, r14, new com.larus.bmhome.chat.layout.holder.helper.x2(), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r21.itemView);
            return;
        L47:
            if (r2.j() == false) goto L60;
            com.larus.utils.e1.o(r8.d);
            com.larus.utils.e1.x(r8.e);
            ExpertTextCardAdapter r20 = new ExpertTextCardAdapter(r8.i.a, r9, r10, r7);
            FixHorizontalDisallowRecyclerView r23 = r8.e;
            r23.setLayoutManager(new LinearLayoutManager(r23.getContext(), 0, false));
            r23.setAdapter(r20);
            ArrayList r24 = new ArrayList();
            List<d> r25 = r2.g();
            ArrayList r26 = new ArrayList();
            Iterator r27 = ((ArrayList) r25).iterator();
        L50:
            if (r27.hasNext() == false) goto L54;
            ArticleInfo r28 = ((d) r27.next()).a();
            if (r28 == null) goto L50;
            r26.add(r28);
            goto L50
        L54:
            r24.addAll(r26);
            Extra r29 = r2.a();
            if (r29 != null) goto L57;
        L59:
            r20.submitList(r24);
            r8.e.post(new i0(r8));
            goto L61
        L57:
            if (com.larus.utils.o0.d(r29.getSearchUrlCompat()) == false) goto L59;
            r24.add(r29);
            goto L59
        L60:
            com.larus.utils.e1.o(r8.d);
            com.larus.utils.e1.o(r8.e);
            goto L61
        L21:
            if (r2.a == false) goto L23;
            com.larus.utils.e1.x(r8.c);
            com.larus.utils.e1.o(r8.b);
            goto L36
        L23:
            com.larus.utils.e1.o(r8.c);
            com.larus.utils.e1.x(r8.b);
            String r30 = r2.d();
            if (r30 != null) goto L26;
        L29:
            boolean r31 = true;
        L30:
            if (r31 == false) goto L32;
            r8.b.setImageResource(r2.c());
            goto L36
        L32:
            final SimpleDraweeView r32 = r8.b;
            String r112 = r2.d();
            if (r112 != null) goto L35;
            r112 = "";
        L35:
            final int r113 = i5.A();
            final int r114 = i5.A();
            ImageLoaderKt.y(r32, r112, "chat.expert_step_icon", new k0(r32, r113, r114), 4);
            goto L36
        L26:
            if (r30.length() == 0) goto L29;
            r31 = false;
        L16:
            r13 = r2.f();
            goto L17
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562566, r3, false);
            Intrinsics.checkNotNull(r5);
            ExpertCardNormalViewHolder r6 = new ExpertCardNormalViewHolder(this, r5);
            r5.setTag(r6);
            return r6;
        }

        public StepAdapter(com.larus.bmhome.chat.api.q0 r2, Message r3, BotModel r4) {
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "bot");
            super(new AnonymousClass1());
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertCardData;", "", "expertStep", "", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "<init>", "(Ljava/util/List;)V", "getExpertStep", "()Ljava/util/List;", "setExpertStep", "isFold", "", "()Z", "setFold", "(Z)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b {
        public static final /* synthetic */ int b = 0;
        public transient boolean a;

        @SerializedName("copilot")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<c> expertStep;

        public static final class a {
            public static b a(String r5) {
                if (r5 != null) goto L4;
            L7:
                boolean r0 = true;
            L9:
                if (r0 == false) goto L16;
                return null;
            L16:
                return (b) new Gson().fromJson(r5, b.class);
            L13:
                e = move-exception;
                FLogger.a.e("ExpertCardBox", "convertDataBean:" + g2a.d.d(r5), e);
                return null;
            L4:
                if (r5.length() == 0) goto L7;
                r0 = false;
                goto L9
            }
        }

        static {
        }

        public b() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.expertStep, ((b) r4).expertStep) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<c> r0 = this.expertStep;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ExpertCardData(expertStep=" + this.expertStep + ')';
        }

        public final List<c> a() {
            return this.expertStep;
        }

        public b(Object r1) {
            this.expertStep = null;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0005J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001dJr\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000e\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\n8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\n8F¢\u0006\u0006\u001a\u0004\b.\u0010\u001a¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "", "stepId", "", "stepType", "", "stepTitle", "stepIcon", "stepContentType", "stepContents", "", "Lcom/google/gson/JsonElement;", "ext", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "isFinal", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;Ljava/lang/Boolean;)V", "getStepId", "()Ljava/lang/String;", "getStepType", "()I", "getStepTitle", "getStepIcon", "getStepContentType", "getStepContents", "()Ljava/util/List;", "getExt", "()Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "showLoading", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "showFail", "getShowFail", "setShowFail", "isContentTypeText", "isContentTypeTextCard", "textList", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextContent;", "getTextList", "textCardList", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextCardContent;", "getTextCardList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "equals", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c {
        public transient boolean a;
        public transient boolean b;

        @SerializedName("ext")
        private final Extra ext;

        @SerializedName("is_final")
        private final Boolean isFinal;

        @SerializedName("step_content_type")
        private final int stepContentType;

        @SerializedName("step_contents")
        private final List<JsonElement> stepContents;

        @SerializedName("step_icon")
        private final String stepIcon;

        @SerializedName("step_id")
        private final String stepId;

        @SerializedName("step_title")
        private final String stepTitle;

        @SerializedName("step_type")
        private final int stepType;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.stepId, r6.stepId) == true) goto L12;
            return false;
        L12:
            if (this.stepType == r6.stepType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.stepTitle, r6.stepTitle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.stepIcon, r6.stepIcon) == true) goto L21;
            return false;
        L21:
            if (this.stepContentType == r6.stepContentType) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.stepContents, r6.stepContents) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isFinal, r6.isFinal) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            String r0 = this.stepId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.stepType) * 31;
            String r4 = this.stepTitle;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.stepIcon;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.stepContentType) * 31;
            List<JsonElement> r10 = this.stepContents;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Extra r13 = this.ext;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Boolean r16 = this.isFinal;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
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
            return "ExpertStep(stepId=" + this.stepId + ", stepType=" + this.stepType + ", stepTitle=" + this.stepTitle + ", stepIcon=" + this.stepIcon + ", stepContentType=" + this.stepContentType + ", stepContents=" + this.stepContents + ", ext=" + this.ext + ", isFinal=" + this.isFinal + ')';
        }

        public final int c() {
            int r0 = this.stepType;
            if (r0 != 1) goto L5;
            return 2131242679;
        L5:
            if (r0 != 2) goto L7;
            return 2131242680;
        L7:
            if (r0 != 3) goto L9;
            return 2131242674;
        L9:
            if (r0 == 4) goto L11;
            return 2131242677;
        L11:
            return 2131242676;
        }

        public final List<d> g() {
            ArrayList r0 = new ArrayList();
            if (j() == false) goto L17;
            List<JsonElement> r1 = this.stepContents;
            if (r1 == null) goto L17;
            List r2 = CollectionsKt.filterNotNull(r1);
            if (r2 == null) goto L17;
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L17;
            JsonElement r4 = (JsonElement) r3.next();
            d r5 = (d) GsonProtectorUtils.fromJson(new Gson(), r4, d.class);     // Catch: JsonSyntaxException -> L14
        L15:
            if (r5 == null) goto L10;
            r0.add(r5);
        L14:
            r5 = null;
        L17:
            return r0;
        }

        public final List<e> h() {
            ArrayList r0 = new ArrayList();
            if (i() == false) goto L17;
            List<JsonElement> r1 = this.stepContents;
            if (r1 == null) goto L17;
            List r2 = CollectionsKt.filterNotNull(r1);
            if (r2 == null) goto L17;
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L17;
            JsonElement r4 = (JsonElement) r3.next();
            e r5 = (e) GsonProtectorUtils.fromJson(new Gson(), r4, e.class);     // Catch: JsonSyntaxException -> L14
        L15:
            if (r5 == null) goto L10;
            r0.add(r5);
        L14:
            r5 = null;
        L17:
            return r0;
        }

        public final boolean i() {
            if (this.stepContentType == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean j() {
            if (this.stepContentType != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public c() {
            this.stepId = null;
            this.stepType = 0;
            this.stepTitle = null;
            this.stepIcon = null;
            this.stepContentType = 0;
            this.stepContents = null;
            this.ext = null;
            this.isFinal = null;
        }

        public final Extra a() {
            return this.ext;
        }

        public final int b() {
            return this.stepContentType;
        }

        public final String d() {
            return this.stepIcon;
        }

        public final String e() {
            return this.stepId;
        }

        public final String f() {
            return this.stepTitle;
        }

        public final Boolean k() {
            return this.isFinal;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextCardContent;", "", "textCard", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "<init>", "(Lcom/larus/bmhome/chat/search/ArticleInfo;)V", "getTextCard", "()Lcom/larus/bmhome/chat/search/ArticleInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class d {

        @SerializedName("text_card")
        private final ArticleInfo textCard;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.textCard, ((d) r4).textCard) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            ArticleInfo r0 = this.textCard;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "StepTextCardContent(textCard=" + this.textCard + ')';
        }

        public d() {
            this.textCard = null;
        }

        public final ArticleInfo a() {
            return this.textCard;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextContent;", "", ChatDraftItem.TYPE_TEXT, "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class e {

        @SerializedName(ChatDraftItem.TYPE_TEXT)
        private final String text;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.text, ((e) r4).text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.text;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "StepTextContent(text=" + this.text + ')';
        }

        public e() {
            this.text = null;
        }

        public final String a() {
            return this.text;
        }
    }

    static {
        t = new LinkedHashMap();
        u = new LinkedHashMap();
    }

    private final Map<String, Boolean> getExpertCardFoldRecorder() {
        return t;
    }

    public ExpertCardBox(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        View r11 = LayoutInflater.from(r10).inflate(2131562330, this, false);
        addView(r11);
        int r0 = 2131365014;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r11, 2131365014);
        if (r4 == null) goto L17;
        r0 = 2131371932;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131371932)) == null) goto L17;
        r0 = 2131377490;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131377490);
        if (r5 == null) goto L17;
        r0 = 2131387334;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131387334);
        if (r6 == null) goto L17;
        r0 = 2131387336;
        AtMostHeightRecyclerView r7 = (AtMostHeightRecyclerView) ViewBindings.findChildViewById(r11, 2131387336);
        if (r7 == null) goto L17;
        r0 = 2131388432;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, 2131388432);
        if (r8 == null) goto L17;
        this.r = new LarusExpertCardBinding((LinearLayout) r11, r4, r5, r6, r7, r8);
        this.s = new CubicBezierInterpolator(0.0f, 0.0f, 0.58f);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    public static final /* synthetic */ Map n(ExpertCardBox r0) {
        return r0.getExpertCardFoldRecorder();
    }

    public final void o(boolean r2) {
        if (r2 == false) goto L4;
        this.r.b.setRotation(0.0f);
        com.larus.utils.e1.x(this.r.f);
        return;
    L4:
        this.r.b.setRotation(180.0f);
        com.larus.utils.e1.q(this.r.f);
    }

    public final void setFullVisibleStatus(boolean r6) {
        LinearLayoutManager r0 = this.r.e.getLayoutManager();
        ListAdapter r2 = null;
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        RecyclerView.Adapter r3 = this.r.e.getAdapter();
        if ((r3 instanceof ListAdapter) == false) goto L11;
        r2 = (ListAdapter) r3;
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        int r4 = r1.findFirstVisibleItemPosition();
        int r5 = r1.findLastVisibleItemPosition();
        if (r4 > r5) goto L23;
    L15:
        View r7 = r1.findViewByPosition(r4);
        if (r7 == null) goto L17;
        Object r8 = r7.getTag();
        if ((r8 instanceof StepAdapter.ExpertCardNormalViewHolder) == false) goto L21;
        ((StepAdapter.ExpertCardNormalViewHolder) r8).V3(r6);
    L21:
        if (r4 == r5) goto L26;
        r4 = r4 + 1;
        goto L15
    L26:
        return;
    L17:
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
