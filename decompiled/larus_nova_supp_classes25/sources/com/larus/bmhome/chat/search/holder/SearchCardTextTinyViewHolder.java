package com.larus.bmhome.chat.search.holder;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\bJ8\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardTextTinyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "indicator", "", "abVersion", "useDetailBox", "", "<init>", "(Landroid/view/View;IIZ)V", "getIndicator", "()I", "getAbVersion", "getUseDetailBox", "()Z", "textTitle", "Landroid/widget/TextView;", "getTextTitle", "()Landroid/widget/TextView;", "retryTimes", "getRetryTimes", "setRetryTimes", "(I)V", "texCreator", "imageCreateAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageMask", "imageCover", "rootView", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "bind", "", "position", "item", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "usePicture", "loadImage", "imageView", "url", "", "bizTag", "resizeWidth", "reSizeHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchCardTextTinyViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int k = 0;
    public final int a;
    public final int b;
    public final boolean c;
    public final TextView d;
    public int e;
    public final TextView f;
    public final SimpleDraweeView g;
    public final SimpleDraweeView h;
    public final SimpleDraweeView i;
    public final RoundFrameLayout j;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ SearchCardTextTinyViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SimpleDraweeView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public final void onFinalImageSet(String r8, Object r9, Animatable r10) {
            ImageInfo r11 = (ImageInfo) r9;
            Intrinsics.checkNotNullParameter(r8, "id");
            if (r11 == null) goto L10;
            SearchCardTextTinyViewHolder r12 = this.a;
            int r13 = r12.e;
            if (r13 > 3) goto L9;
            r12.e = r13 + 1;
            this.a.T3(this.b, this.c, this.d, this.e, this.f, this.g);
            return;
        L9:
            return;
        }

        public b(SearchCardTextTinyViewHolder r1, int r2, SimpleDraweeView r3, String r4, String r5, int r6, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    public SearchCardTextTinyViewHolder(View r1, int r2, int r3, boolean r4) {
        super(r1);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = (TextView) r1.findViewById(2131388514);
        this.f = (TextView) r1.findViewById(2131388418);
        this.g = r1.findViewById(2131374977);
        this.h = r1.findViewById(2131375021);
        this.i = r1.findViewById(2131374973);
        this.j = r1.findViewById(2131373275);
    }

    public final void T3(int r10, final SimpleDraweeView r11, String r12, String r13, final int r14, final int r15) {
        final b r8 = new b(this, r10, r11, r12, r13, r14, r15);
        ImageLoaderKt.v(r11, r12, r13, null, new qi8.b(r11, r14, r15, r8));
    }
}
