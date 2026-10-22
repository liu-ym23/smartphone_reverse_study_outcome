package com.larus.bmhome.chat.markdown.vlm;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusVlmImageItemViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u0001:\u00018B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u001bH\u0002J\"\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010&\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001bH\u0002J\u001a\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%0.0-H\u0002J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001900H\u0002J\u001c\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010*2\b\u00103\u001a\u0004\u0018\u00010\u001bH\u0002J\u001e\u00104\u001a\b\u0012\u0004\u0012\u0002050-2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010-H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/VlmImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "vlmImageAdapter", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageAdapter;", "markdownDataManager", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewBinding;", "vlmWidgetService", "Lcom/larus/bmhome/chat/markdown/vlm/IVlmImageWidgetService;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/larus/bmhome/chat/markdown/vlm/VlmImageAdapter;Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewBinding;Lcom/larus/bmhome/chat/markdown/vlm/IVlmImageWidgetService;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getVlmImageAdapter", "()Lcom/larus/bmhome/chat/markdown/vlm/VlmImageAdapter;", "getMarkdownDataManager", "()Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewBinding;", "bindView", "", "position", "", "vlmImageRenderInfo", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageRenderInfo;", "setUpLoadMainImage", "setUpSourceImage", "setUpMoreImageIcon", "setUpVideoCaptionView", "setUpVideoIcon", "setUpLayout", "setUpLayoutClick", "mobCardClick", "view", "Landroid/view/View;", "index", "videoItem", "openVideoActivity", "context", "Landroid/content/Context;", "data", "generateImageViews", "", "Lkotlin/Pair;", "generateImageIndexToViewHolderIndex", "", "openImagePageList", "contextParams", "vlmImageRenderInfoParams", "getBigImageInfoList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "images", "Lcom/larus/im/bean/message/VLMImage;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VlmImageViewHolder extends RecyclerView.ViewHolder {
    public final LarusVlmImageItemViewBinding a;

    public static final class a {
    }

    static {
    }

    public VlmImageViewHolder(VlmImageAdapter r2, LarusVlmImageItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "vlmImageAdapter");
        Intrinsics.checkNotNullParameter(null, "markdownDataManager");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(null, "vlmWidgetService");
        super(r3.a);
        this.a = r3;
    }
}
