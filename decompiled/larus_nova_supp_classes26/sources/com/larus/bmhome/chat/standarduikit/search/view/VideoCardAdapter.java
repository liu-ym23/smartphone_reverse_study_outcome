package com.larus.bmhome.chat.standarduikit.search.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.j0;
import hn8.a;
import hn8.b;
import hn8.c;
import hn8.d;
import hn8.e;
import hn8.j;
import hn8.k;
import hn8.l;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewData;", "Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoItemViewHolder;", "<init>", "()V", "videoCardViewCallback", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewCallback;", "adaptiveItemWidth", "", "updateAdaptiveItemWidth", "", "itemWidth", "setupCallBack", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCardAdapter extends ListAdapter<l, PureVideoItemViewHolder> {
    public k a;
    public int b;

    public VideoCardAdapter() {
        super(new VideoCardItemCallback());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, com.larus.bmhome.chat.standarduikit.search.view.PureVideoItemView, java.lang.Object] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r24, final int r25) {
        PureVideoItemViewHolder r2 = (PureVideoItemViewHolder) r24;
        Intrinsics.checkNotNullParameter(r2, "holder");
        final l r3 = (l) getItem(r25);
        if (r3 == null) goto L53;
        final k r4 = this.a;
        if (r4 == null) goto L54;
        int r5 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "callback");
        PureVideoItemView r8 = r2.a;
        if (r5 <= 0) goto L11;
        r8.e = r5;
    L12:
        ?? r6 = r2.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Function3<String, Integer, View, Unit> r7 = r4.a;
        if (r7 == null) goto L15;
        r7.invoke(r3.a.b, Integer.valueOf(r25), r6);
    L15:
        ExpandCardViewMode r9 = r3.b;
        int r10 = PureVideoItemView.g;
        PureVideoItemView.a r11 = PureVideoItemView.b.a(r9);
        int r12 = r6.e;
        boolean r13 = true;
        if (r12 <= 0) goto L19;
        r11 = new PureVideoItemView.a(r12, RangesKt.coerceAtLeast(MathKt.roundToInt(r11.b * (r12 / r11.a)), 1));
    L19:
        ViewGroup.LayoutParams r14 = r6.getLayoutParams();
        if (r14 == null) goto L50;
        r14.width = r11.a;
        r14.height = r11.b;
        r6.setLayoutParams(r14);
        r6.b.setText(r3.a.g);
        if (AppHost.a.isOversea() == true) goto L24;
        SimpleDraweeView r15 = r6.c;
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        int r17 = j0.a;
        r15.setContentDescription(String.format(j0.d(2131898847), Arrays.copyOf(new Object[]{r3.a.g}, 1)));
    L24:
        MessageImageLoader r18 = MessageImageLoader.a;
        String r19 = r3.d;
        MessageImageType r110 = MessageImageType.VIDEO;
        SimpleDraweeView r111 = r6.c;
        String r20 = r3.a.f;
        if (r20 != null) goto L27;
        r20 = "";
    L27:
        IMessageImageLoaderService.a.b(r18, r19, r110, r111, r20, "chat.searchlist_cover_thumb", Integer.valueOf(r11.a), Integer.valueOf(r11.b), new a(r4, r3, r25), new b(r4, r25), new c(r4, r3, r25), false, 1024);
        e1.d(r6.c, new d(r3, r4, r25));
        r6.c.setOnLongClickListener(new e(r4));
        boolean r1 = r3.c;
        j r21 = r3.a;
        String r22 = r21.e;
        if (r22 != null) goto L30;
    L33:
        boolean r23 = true;
    L34:
        if (r23 == false) goto L36;
        String r26 = r21.d;
    L37:
        String r112 = r26;
        String r27 = r3.a.c;
        String r113 = r3.d;
        if (r1 == false) goto L40;
        e1.o(r6.d);
        MarkdownSourceImageView.f(r6.f, r27, r112, null, 4);
        return;
    L40:
        if (r112 != null) goto L42;
    L45:
        if (r13 == false) goto L47;
        e1.o(r6.d);
        return;
    L47:
        e1.x(r6.d);
        IMessageImageLoaderService.a.b(r18, r113, MessageImageType.IMAGE, r6.d, r112, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        return;
    L42:
        if (r112.length() == 0) goto L45;
        r13 = false;
        goto L45
    L36:
        r26 = r21.e;
        goto L37
    L30:
        if (r22.length() == 0) goto L33;
        r23 = false;
        goto L34
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        r8.getClass();
        goto L12
    L54:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        PureVideoItemView r5 = new PureVideoItemView(r3.getContext(), null, 0);
        int r6 = this.b;
        if (r6 <= 0) goto L6;
        r5.e = r6;
    L6:
        return new PureVideoItemViewHolder(r5);
    }
}
