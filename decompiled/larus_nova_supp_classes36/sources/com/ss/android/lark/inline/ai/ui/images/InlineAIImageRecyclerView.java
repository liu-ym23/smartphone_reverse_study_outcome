package com.ss.android.lark.inline.ai.ui.images;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.ImageData;
import com.ss.android.lark.inline.ai.api.ui.Images;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import wlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0004%&'(B'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mAdapter", "Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter;", "onHeightChangeListener", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider$OnHeightChangedListener;", "setData", "", "images", "Lcom/ss/android/lark/inline/ai/api/ui/Images;", "setImagesCallback", "callback", "Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter$IImagesCallback;", "locateDynamicCheckbox", "locateFirstLineVisibleCheckbox", "view", "Landroid/view/View;", "locateSecondLineVisibleCheckbox", "getViewHeight", "setOnHeightChangeListener", "listener", "onSizeChanged", "w", "h", "oldw", "oldh", "Companion", "ImageAdapter", "DiffCallback", "ImageStatus", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIImageRecyclerView extends RecyclerView implements g {
    public final AnonymousClass1 a;
    public final ImageAdapter b;
    public g.a c;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "newList", "oldCheckList", "", "newCheckList", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<ImageData> a;
        public final List<ImageData> b;
        public final List<String> c;
        public final List<String> d;

        public final int getNewListSize() {
            List<ImageData> r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getOldListSize() {
            List<ImageData> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final boolean areContentsTheSame(int r5, int r6) {
            List<String> r0 = this.c;
            String r1 = "";
            Integer r2 = null;
            if (r0 == null) goto L12;
            List<ImageData> r3 = this.a;
            if (r3 == null) goto L10;
            ImageData r7 = (ImageData) CollectionsKt.getOrNull(r3, r5);
            if (r7 == null) goto L10;
            String r8 = r7.getId();
            if (r8 == null) goto L10;
        L11:
            Integer r9 = Integer.valueOf(r0.indexOf(r8));
        L13:
            List<String> r4 = this.d;
            if (r4 == null) goto L25;
            List<ImageData> r10 = this.b;
            if (r10 == null) goto L23;
            ImageData r11 = (ImageData) CollectionsKt.getOrNull(r10, r6);
            if (r11 == null) goto L23;
            String r12 = r11.getId();
            if (r12 == null) goto L23;
            r1 = r12;
        L23:
            r2 = Integer.valueOf(r4.indexOf(r1));
        L25:
            return Intrinsics.areEqual(r9, r2);
        L10:
            r8 = "";
            goto L11
        L12:
            r9 = null;
            goto L13
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            List<ImageData> r5 = this.a;
            String r0 = null;
            if (r5 == null) goto L7;
            ImageData r6 = (ImageData) CollectionsKt.getOrNull(r5, r3);
            if (r6 == null) goto L7;
            String r7 = r6.getUrl();
        L8:
            List<ImageData> r1 = this.b;
            if (r1 == null) goto L14;
            ImageData r8 = (ImageData) CollectionsKt.getOrNull(r1, r3);
            if (r8 == null) goto L14;
            r0 = r8.getUrl();
        L14:
            return Intrinsics.areEqual(r7, r0);
        L7:
            r7 = null;
            goto L8
        }

        public final Object getChangePayload(int r6, int r7) {
            Bundle r0 = new Bundle();
            List<String> r1 = this.c;
            Object r2 = "";
            Integer r3 = null;
            if (r1 == null) goto L11;
            List<ImageData> r4 = this.a;
            if (r4 == null) goto L9;
            Object r8 = (ImageData) CollectionsKt.getOrNull(r4, r6);
            if (r8 == null) goto L9;
        L10:
            Integer r9 = Integer.valueOf(CollectionsKt.indexOf(r1, r8));
        L12:
            List<String> r5 = this.d;
            if (r5 == null) goto L21;
            List<ImageData> r10 = this.b;
            if (r10 == null) goto L19;
            ImageData r11 = (ImageData) CollectionsKt.getOrNull(r10, r7);
            if (r11 == null) goto L19;
            r2 = r11;
        L19:
            r3 = Integer.valueOf(CollectionsKt.indexOf(r5, r2));
        L21:
            if (Intrinsics.areEqual(r9, r3) == false) goto L23;
            r0.putInt("checkStatus", 1);
        L23:
            return r0;
        L9:
            r8 = "";
            goto L10
        L11:
            r9 = null;
            goto L12
        }

        public DiffCallback(List<ImageData> r1, List<ImageData> r2, List<String> r3, List<String> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000278B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001b\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u001c\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\u001c\u0010$\u001a\u00020\u00172\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u000bH\u0016J*\u0010$\u001a\u00020\u00172\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\bH\u0016J\u001c\u0010)\u001a\u00020\u00172\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0002J$\u0010+\u001a\u00020\u00172\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\t2\u0006\u0010-\u001a\u00020.H\u0002JH\u0010/\u001a\u00020\u00172\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001cH\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0013H\u0016J\u0014\u00106\u001a\u00020\u00172\n\u0010%\u001a\u00060\u0002R\u00020\u0000H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter$ImageViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mData", "", "Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "mStatus", "", "mCheckList", "", "mGlide", "Lcom/bumptech/glide/RequestManager;", "mImageStatusMap", "Ljava/util/concurrent/ConcurrentHashMap;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mIImagesCallback", "Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter$IImagesCallback;", "setData", "", "images", "Lcom/ss/android/lark/inline/ai/api/ui/Images;", "setDataInternal", "downloadImages", "", "setImagesCallback", "callback", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "bindCheck", "imageData", "bindImageView", "itemCheckChange", "checked", "", "diffRefresh", "oldList", "newList", "oldCheckList", "newCheckList", "onAttachedToRecyclerView", "recyclerView", "bindEmptyData", "ImageViewHolder", "IImagesCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        public final Context a;
        public final List<ImageData> b;
        public int c;
        public final List<String> d;
        public final RequestManager e;
        public final ConcurrentHashMap<String, Integer> f;
        public RecyclerView g;
        public a h;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/inline/ai/ui/images/InlineAIImageRecyclerView$ImageAdapter;Landroid/view/View;)V", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "selectedRegion", "Landroid/view/ViewGroup;", "getSelectedRegion", "()Landroid/view/ViewGroup;", "selected", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getSelected", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "sideLength", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public final class ImageViewHolder extends RecyclerView.ViewHolder {
            public final AppCompatImageView a;
            public final ViewGroup b;
            public final AppCompatCheckBox c;

            public ImageViewHolder(ImageAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                super(r3);
                RecyclerView r4 = r2.g;
                if (r4 == null) goto L7;
                RecyclerView.LayoutManager r5 = r4.getLayoutManager();
                if (r5 == null) goto L7;
                int r6 = (int) ((r5.getWidth() - (f0.a(8) * 3)) / 2.0f);
            L8:
                ViewGroup.LayoutParams r0 = r3.getLayoutParams();
                r0.width = r6;
                r0.height = r6;
                r3.setLayoutParams(r0);
                this.a = r3.findViewById(2131375091);
                this.b = (ViewGroup) r3.findViewById(2131392178);
                this.c = r3.findViewById(2131392177);
                return;
            L7:
                r6 = f0.a(160);
                goto L8
            }
        }

        public interface a {
            void c(String r1, boolean r2);

            void d();

            void e(Map<String, Boolean> r1);
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ImageViewHolder a;

            public b(ImageViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.c.performClick();
            }
        }

        public static final class c implements View.OnClickListener {
            public final /* synthetic */ ImageAdapter a;
            public final /* synthetic */ ImageData b;
            public final /* synthetic */ boolean c;

            public c(ImageAdapter r1, ImageData r2, boolean r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                ImageAdapter.y2(this.a, this.b, !this.c);
            }
        }

        public final int getItemCount() {
            if (this.c == 1) goto L7;
            return 4;
        L7:
            return ((ArrayList) this.b).size();
        }

        public ImageAdapter(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = new ArrayList();
            this.d = new ArrayList();
            this.e = Glide.with(r2);
            this.f = new ConcurrentHashMap();
        }

        public static void A2(ImageViewHolder r3) {
            r3.a.setTag(null);
            r3.a.setImageResource(0);
            r3.a.setOnClickListener(null);
            r3.b.setVisibility(8);
        }

        public final void C2(Images r3) {
            ((ArrayList) this.b).clear();
            ArrayList<ImageData> r0 = r3.getData();
            if (r0 == null) goto L5;
            ((ArrayList) this.b).addAll(r0);
        L5:
            ((ArrayList) this.d).clear();
            ArrayList<String> r1 = r3.getCheckList();
            if (r1 == null) goto L8;
            ((ArrayList) this.d).addAll(r1);
        L8:
            this.c = r3.getStatus();
        }

        public final void onAttachedToRecyclerView(RecyclerView r2) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            this.g = r2;
        }

        public final void B2(ImageViewHolder r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "holder");
            if (this.c != 1) goto L18;
            final ImageData r0 = (ImageData) CollectionsKt.getOrNull(this.b, r6);
            if (r0 != null) goto L8;
            Log.e("ImageRecyclerView", "onBindViewHolder, imageData is null! position = " + r6 + ", data size = " + ((ArrayList) this.b).size());
            A2(r5);
            return;
        L8:
            z2(r5, r0);
            String r7 = r0.getUrl();
            String r1 = r0.getId();
            r5.a.setTag(r7);
            Integer r2 = this.f.get(r1);
            if (r2 != null) goto L12;
        L17:
            r5.a.setImageResource(2131238142);
            r5.a.setScaleType(ImageView.ScaleType.CENTER);
            r5.a.setOnClickListener(null);
            return;
        L12:
            if (r2.intValue() != 2) goto L17;
            r5.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e.load(r7).placeholder(2131231236).error(2131231236).into(r5.a);
            if (r0.getCheckable() == false) goto L16;
            r5.a.setOnClickListener(new InlineAIImageRecyclerView$ImageAdapter$bindImageView$1(r0, this));
            return;
        L16:
            r5.a.setOnClickListener(null);
            return;
        L18:
            A2(r5);
        }

        public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            B2((ImageViewHolder) r1, r2);
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new ImageViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131561544, r4, false));
        }

        public final void z2(ImageViewHolder r5, ImageData r6) {
            if (this.c != 1) goto L21;
            Integer r0 = this.f.get(r6.getId());
            if (r0 == null) goto L21;
            if (r0.intValue() != 2) goto L21;
            if (r6.getCheckable() == false) goto L21;
            boolean r2 = false;
            r5.b.setVisibility(0);
            List<String> r1 = this.d;
            ArrayList r3 = (ArrayList) r1;
            int r4 = r3.indexOf(r6.getId());
            if (r4 < 0) goto L15;
            r2 = true;
        L15:
            r5.c.setChecked(r2);
            AppCompatCheckBox r7 = r5.c;
            if (r2 == false) goto L18;
            String r8 = String.valueOf(r4 + 1);
        L19:
            r7.setText(r8);
            r5.b.setOnClickListener(new b(r5));
            r5.c.setOnClickListener(new c(this, r6, r2));
            return;
        L18:
            r8 = null;
        L21:
            r5.b.setVisibility(8);
        }

        public static final void y2(ImageAdapter r4, ImageData r5, boolean r6) {
            r4.getClass();
            ArrayList r0 = new ArrayList();
            r0.addAll(r4.d);
            if (r6 == false) goto L5;
            List<String> r1 = r4.d;
            ArrayList r2 = (ArrayList) r1;
            r2.add(r5.getId());
        L6:
            List<ImageData> r3 = r4.b;
            DiffUtil.calculateDiff(new DiffCallback(r3, r3, r0, r4.d), false).dispatchUpdatesTo(r4);
            a r7 = r4.h;
            if (r7 == null) goto L10;
            r7.c(r5.getId(), r6);
            return;
        L10:
            return;
        L5:
            List<String> r8 = r4.d;
            ArrayList r9 = (ArrayList) r8;
            r9.remove(r5.getId());
            goto L6
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List r6) {
            ImageViewHolder r7 = (ImageViewHolder) r4;
            Intrinsics.checkNotNullParameter(r7, "holder");
            Intrinsics.checkNotNullParameter(r6, "payloads");
            if ((!r6.isEmpty()) == true) goto L5;
        L12:
            B2(r7, r5);
            return;
        L5:
            if ((ListProtector.get(r6, 0) instanceof Bundle) == false) goto L12;
            ImageData r2 = (ImageData) CollectionsKt.getOrNull(this.b, r5);
            if (r2 != null) goto L9;
            Log.e("ImageRecyclerView", "onBindViewHolder, imageData is null! position = " + r5 + ", data size = " + ((ArrayList) this.b).size() + ", payloads.size = " + r6.size());
            A2(r7);
            return;
        L9:
            Object r8 = ListProtector.get(r6, 0);
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.os.Bundle");
            if (((Bundle) r8).getInt("checkStatus") != 1) goto L15;
            z2(r7, r2);
            return;
        }
    }

    public static final class a {
    }

    static {
    }

    public InlineAIImageRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InlineAIImageRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wlb.g
    public int getViewHeight() {
        return getWidth() - (f0.a(8) * 2);
    }

    public static final void r(InlineAIImageRecyclerView r7) {
        int r0 = r7.a.findFirstVisibleItemPosition();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= r7.b.getItemCount()) goto L31;
        int r1 = r0 + 4;
        int r2 = r0;
    L8:
        if (r2 >= r1) goto L32;
        if (r2 >= r7.b.getItemCount()) goto L33;
        View r3 = r7.a.findViewByPosition(r2);
        if ((r2 - r0) >= 2) goto L19;
        if (r3 == null) goto L22;
        RelativeLayout r4 = (RelativeLayout) r3.findViewById(2131392178);
        Rect r5 = new Rect();
        if (r3.getLocalVisibleRect(r5) == false) goto L22;
        r4.offsetTopAndBottom(Math.min(r5.top, r3.getHeight() - r4.getHeight()) - ((int) r4.getY()));
    L22:
        r2 = r2 + 1;
        goto L8
    L19:
        if (r3 == null) goto L22;
        RelativeLayout r6 = (RelativeLayout) r3.findViewById(2131392178);
        r6.offsetTopAndBottom(-((int) r6.getY()));
        goto L22
    L33:
        return;
    L32:
        return;
    }

    public final void setData(Images r10) {
        Intrinsics.checkNotNullParameter(r10, "images");
        ImageAdapter r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "images");
        int r2 = 0;
        if (r10.getStatus() != 0) goto L16;
        if (r1.c != 0) goto L16;
        ArrayList<ImageData> r11 = r10.getData();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((!r11.isEmpty()) == false) goto L23;
        Integer r0 = r1.f.get(((ImageData) ListProtector.get(r11, 0)).getId());
        if (r0 == null) goto L13;
        r2 = r0.intValue();
    L13:
        if (r2 > 0) goto L24;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new InlineAIImageRecyclerView$ImageAdapter$downloadImages$1(r11, r1, null), 2, null);
        return;
    L24:
        return;
    L23:
        return;
    L16:
        if (r10.getStatus() == 1) goto L18;
    L20:
        r1.C2(r10);
        r1.notifyDataSetChanged();
        return;
    L18:
        if (r1.c != 1) goto L20;
        DiffUtil.calculateDiff(new DiffCallback(r1.b, r10.getData(), r1.d, r10.getCheckList()), false).dispatchUpdatesTo(r1);
        r1.C2(r10);
    }

    public final void setImagesCallback(ImageAdapter.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b.h = r2;
    }

    @Override // wlb.g
    public void setOnHeightChangeListener(g.a r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineAIImageRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ImageAdapter r5 = new ImageAdapter(getContext());
        this.b = r5;
        RecyclerView.LayoutManager r6 = new AnonymousClass1(r2, this);
        this.a = r6;
        setLayoutManager(r6);
        addItemDecoration(new AnonymousClass2());
        setAdapter(r5);
        addOnScrollListener(new AnonymousClass3(this));
        setItemAnimator(null);
    }

    public /* synthetic */ InlineAIImageRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L8;
        g.a r5 = this.c;
        if (r5 == null) goto L9;
        r5.b(r1 - (f0.a(8) * 2));
        return;
    L9:
        return;
    }
}
