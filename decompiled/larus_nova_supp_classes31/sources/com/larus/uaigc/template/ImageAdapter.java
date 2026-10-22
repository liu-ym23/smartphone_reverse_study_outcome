package com.larus.uaigc.template;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004CDEFBo\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010+\u001a\u00020\u001f2:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bJl\u0010,\u001a\u00020\u001f2d\u0010 \u001a`\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f\u0018\u00010!J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#H\u0016J\u001a\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00022\b\b\u0001\u0010$\u001a\u00020#H\u0016J\b\u00103\u001a\u00020#H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\u0016\u00105\u001a\u00020\u001f2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000107J\u0006\u00108\u001a\u00020\u001fJ\u000e\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\rJ\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0002J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020AH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000Rl\u0010 \u001a`\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/uaigc/template/ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "templateInfoList", "", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "fragment", "Landroidx/fragment/app/Fragment;", "arguments", "Landroid/os/Bundle;", "botId", "", "isNewStyle", "", "chatType", "previousPage", "compatDoubleTabMargin", "recommendFrom", "<init>", "(Ljava/util/List;Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getTemplateInfoList", "()Ljava/util/List;", "setTemplateInfoList", "(Ljava/util/List;)V", "hasMore", "conversationId", "imageTemplateChoose", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "templatePrompt", "", "imageTemplateDetailClick", "Lkotlin/Function4;", "templateInfo", "", "position", "Landroid/view/View;", "itemView", "itemWidth", "onConversationChangedObserver", "Landroidx/lifecycle/Observer;", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "setImageTemplateChoose", "setImageTemplateDetailClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "getItemViewType", "appendDataList", "appendTempInfoList", "", "refreshData", "setHasMore", "isHasMore", "goChatAndSetText", "context", "Landroid/content/Context;", "text", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "ImageViewHolder", "LoadingHolder", "HeaderHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int o = 0;
    public final List<TemplateInfo$TemplateInfo> a;
    public final Fragment b;
    public final Bundle c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final boolean h;
    public boolean i;
    public String j;
    public Function2<? super TemplateInfo$TemplateInfo, ? super String, Unit> k;
    public Function4<? super TemplateInfo$TemplateInfo, ? super Integer, ? super View, ? super String, Unit> l;
    public final int m;
    public final h n;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/template/ImageAdapter$HeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "templateImageDetail", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTemplateImageDetail", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "templateDetailText", "Landroid/widget/TextView;", "getTemplateDetailText", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class HeaderHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;

        public HeaderHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131388329);
            this.b = (TextView) r2.findViewById(2131388327);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/template/ImageAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconTemplate", "getIconTemplate", "()Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class ImageViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final View b;

        public ImageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131375775);
            this.b = r2.findViewById(2131374803);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/template/ImageAdapter$LoadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class LoadingHolder extends RecyclerView.ViewHolder {
        public LoadingHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public b(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            FLogger.a.i("ImageAdapter", "cover image failed");
            super.onFailure(r4, r5);
        }

        public final void onSubmit(String r4, Object r5) {
            FLogger.a.i("ImageAdapter", "cover image submit");
            super.onSubmit(r4, r5);
            e1.o(((ImageViewHolder) this.a).b);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            FLogger.a.i("ImageAdapter", "cover image set");
            e1.x(((ImageViewHolder) this.a).b);
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public c() {
        }
    }

    static {
    }

    public ImageAdapter() {
        throw null;
    }

    public final int getItemCount() {
        return this.a.size() + 2;
    }

    public final int getItemViewType(int r3) {
        if (r3 == (this.a.size() + 1)) goto L5;
        if (r3 != 0) goto L10;
        return 3;
    L10:
        return 0;
    L5:
        if (this.i == true) goto L14;
        return 2;
    L14:
        return 1;
    }

    public final void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onAttachedToRecyclerView(r3);
        FLogger.a.d("ImageAdapter", "onAttachedToRecyclerView");
        Transformations.distinctUntilChanged(zh8.a.a.H1()).observeForever(this.n);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onDetachedFromRecyclerView(r3);
        FLogger.a.d("ImageAdapter", "onDetachedFromRecyclerView");
        zh8.a.a.H1().removeObserver(this.n);
    }

    public final void y2(List<TemplateInfo$TemplateInfo> r3) {
        List<TemplateInfo$TemplateInfo> r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        notifyItemChanged(getItemCount() - 1);
        return;
    L12:
        int r0 = this.a.size();
        this.a.addAll(r4);
        notifyItemRangeChanged(r0, getItemCount() - r0);
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        Long r2 = null;
        Long r3 = null;
        String r4 = null;
        if ((r11 instanceof ImageViewHolder) == false) goto L49;
        if ((this.b instanceof ImageTemplateDetailFragment) == false) goto L7;
        final int r0 = r12 - 1;
    L8:
        TemplateInfo$TemplateImage r5 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r0)).d;
        if (r5 == null) goto L11;
        Long r6 = Long.valueOf(r5.c);
    L12:
        TemplateInfo$TemplateImage r7 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r0)).d;
        if (r7 == null) goto L15;
        Long r8 = Long.valueOf(r7.b);
    L17:
        if (this.e == false) goto L43;
        ImageViewHolder r9 = (ImageViewHolder) r11;
        SimpleDraweeView r10 = r9.a;
        TemplateInfo$TemplateImage r13 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r0)).d;
        if (r13 == null) goto L21;
        String r14 = r13.a;
    L22:
        ImageLoaderKt.y(r10, r14, "template_item_photo", new com.larus.uaigc.template.b(r11), 4);
        if (r8 == null) goto L47;
        if (r6 == null) goto L47;
        if (((int) r8.longValue()) == 0) goto L47;
        int r1 = this.m;
        if (r1 == (-1)) goto L47;
        int r15 = (int) ((((long) r1) * r6.longValue()) / r8.longValue());
        ViewGroup.LayoutParams r16 = r9.a.getLayoutParams();
        int r17 = this.m;
        int r18 = (r17 * 16) / 9;
        if (r15 <= r18) goto L32;
        r15 = r18;
    L35:
        r16.height = r15;
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("position is ");
        r20.append(r12);
        r20.append(" ; template width is ");
        TemplateInfo$TemplateImage r21 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r12)).d;
        if (r21 == null) goto L38;
        Long r22 = Long.valueOf(r21.b);
    L39:
        r20.append(r22);
        r20.append(" height is ");
        TemplateInfo$TemplateImage r110 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r12)).d;
        if (r110 == null) goto L42;
        r3 = Long.valueOf(r110.c);
    L42:
        r20.append(r3);
        r20.append(" ; itemWidth is ");
        r20.append(this.m);
        r20.append(" height is ");
        r20.append(r9.a.getLayoutParams().height);
        r19.i("ImageAdapter", r20.toString());
        r9.a.requestLayout();
        goto L47
    L38:
        r22 = null;
        goto L39
    L32:
        int r23 = (r17 * 9) / 16;
        if (r15 >= r23) goto L35;
        r15 = r23;
    L47:
        ImageViewHolder r111 = (ImageViewHolder) r11;
        r111.a.setOnClickListener(new com.larus.uaigc.template.c(this, r0, r11));
        r111.b.setOnClickListener(new d(this, r0));
        return;
    L21:
        r14 = null;
        goto L22
    L43:
        SimpleDraweeView r112 = ((ImageViewHolder) r11).a;
        TemplateInfo$TemplateImage r24 = ((TemplateInfo$TemplateInfo) ListProtector.get(this.a, r0)).d;
        if (r24 == null) goto L46;
        r4 = r24.a;
    L46:
        ImageLoaderKt.u(r112, r4, "template_item_photo");
        goto L47
    L15:
        r8 = null;
        goto L17
    L11:
        r6 = null;
        goto L12
    L7:
        r0 = r12;
        goto L8
    L49:
        if ((r11 instanceof HeaderHolder) == false) goto L71;
        StaggeredGridLayoutManager.LayoutParams r113 = r11.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        r113.setFullSpan(true);
        HeaderHolder r114 = (HeaderHolder) r11;
        SimpleDraweeView r115 = r114.a;
        Bundle r25 = this.c;
        if (r25 == null) goto L53;
        String r26 = r25.getString("image_detail_url");
    L54:
        if (r26 != null) goto L56;
        r26 = "";
    L56:
        ImageLoaderKt.y(r115, r26, "template_head_photo", new e(), 4);
        TextView r116 = r114.b;
        Bundle r27 = this.c;
        if (r27 == null) goto L59;
        String r28 = r27.getString("template_show_text");
    L60:
        r116.setText(r28);
        Bundle r117 = this.c;
        if (r117 == null) goto L63;
        r2 = Long.valueOf(r117.getLong("image_detail_width"));
    L63:
        Bundle r118 = this.c;
        if (r118 == null) goto L66;
        long r29 = r118.getLong("image_detail_height");
    L67:
        if (r2 == null) goto L69;
        float r119 = r2.longValue() / r29;
    L70:
        r114.a.setAspectRatio(r119);
        r114.a.setOnClickListener(new f(this));
        final String r120 = r114.b.getText().toString();
        r114.b.setOnClickListener(new g(this, r120));
        return;
    L69:
        r119 = 1.0f;
        goto L70
    L66:
        r29 = 1;
        goto L67
    L59:
        r28 = null;
        goto L60
    L53:
        r26 = null;
        goto L54
    L71:
        StaggeredGridLayoutManager.LayoutParams r121 = r11.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        r121.setFullSpan(true);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L5;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562692, r3, false);
        w0.e(r5, j19.c.c(8));
        Intrinsics.checkNotNull(r5);
        return new ImageViewHolder(r5);
    L5:
        if (r4 != 1) goto L7;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562690, r3, false);
        Intrinsics.checkNotNull(r6);
        return new LoadingHolder(r6);
    L7:
        if (r4 == 2) goto L11;
        View r7 = LayoutInflater.from(r3.getContext()).inflate(2131563159, r3, false);
        Intrinsics.checkNotNull(r7);
        return new HeaderHolder(r7);
    L11:
        if (this.h == false) goto L13;
        View r8 = LayoutInflater.from(r3.getContext()).inflate(2131562689, r3, false);
    L14:
        Intrinsics.checkNotNull(r8);
        return new LoadingHolder(r8);
    L13:
        r8 = LayoutInflater.from(r3.getContext()).inflate(2131562688, r3, false);
        goto L14
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.uaigc.template.h] */
    public ImageAdapter(List r2, Fragment r3, Bundle r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "templateInfoList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        boolean r8 = false;
        this.e = false;
        this.f = r6;
        this.g = r7;
        this.h = false;
        this.m = -1;
        this.n = new h(this);
        if (r3 == null) goto L7;
        Bundle r9 = r3.getArguments();
        if (r9 == null) goto L7;
        String r10 = r9.getString("argConversationId");
    L8:
        this.j = r10;
        if (r3 == null) goto L13;
        Context r11 = r3.getContext();
        if (r11 == null) goto L13;
        float r12 = c7.d(Integer.valueOf(com.larus.utils.i.d(r11)));
    L15:
        if (r12 <= 500.0f) goto L17;
        int r13 = 3;
    L19:
        if (r12 != (-1.0f)) goto L21;
        r8 = true;
    L21:
        if (r8 == true) goto L23;
        this.m = ((c7.b(Float.valueOf(r12)) - c7.b(24)) - ((r13 - 1) * c7.b(2))) / r13;
    L23:
        FLogger.a.i("ImageAdapter", "screenWidth is " + c7.b(Float.valueOf(r12)) + " itemWidth is " + this.m);
        return;
    L17:
        r13 = 2;
    L13:
        r12 = -1.0f;
    L7:
        r10 = null;
        goto L8
    }
}
