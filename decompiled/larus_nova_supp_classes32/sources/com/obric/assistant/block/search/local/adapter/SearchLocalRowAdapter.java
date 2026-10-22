package com.obric.assistant.block.search.local.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.block.OSearchEntityImage;
import com.larus.im.bean.message.block.OSearchEntityVideo;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchItemWithRowImageBinding;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.assistant.card.utils.AppEntityEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001e\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/block/search/local/adapter/SearchLocalRowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/block/search/local/adapter/SearchLocalRowAdapter$RowImageViewHolder;", "<init>", "()V", "list", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/message/block/OSearchReferenceInCollection;", "isSubBlock", NameKeys.UnloadStrategy_No_Strategy, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "onBindViewHolder", NameKeys.UnloadStrategy_No_Strategy, "holder", "position", "getItemCount", "setData", "newList", NameKeys.UnloadStrategy_No_Strategy, "showAll", "targetKey", "Lcom/obric/assistant/card/utils/AppEntityEx$QueryEntityKey;", "mustShowTarget", "Companion", "RowImageViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchLocalRowAdapter extends RecyclerView.Adapter<RowImageViewHolder> {
    public static final /* synthetic */ int c = 0;
    public final List<OSearchReferenceInCollection> a;
    public boolean b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/block/search/local/adapter/SearchLocalRowAdapter$RowImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/assistant/card/databinding/ObricBlockLocalSearchItemWithRowImageBinding;", "<init>", "(Lcom/obric/assistant/card/databinding/ObricBlockLocalSearchItemWithRowImageBinding;)V", "getBinding", "()Lcom/obric/assistant/card/databinding/ObricBlockLocalSearchItemWithRowImageBinding;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RowImageViewHolder extends RecyclerView.ViewHolder {
        public final ObricBlockLocalSearchItemWithRowImageBinding a;

        public RowImageViewHolder(ObricBlockLocalSearchItemWithRowImageBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return RangesKt.coerceAtMost(((ArrayList) this.a).size(), 11);
    }

    public SearchLocalRowAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        RowImageViewHolder r13 = (RowImageViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        OSearchReferenceInCollection r0 = (OSearchReferenceInCollection) ListProtector.get(this.a, r12);
        RoundRelativeLayout r1 = r13.a.a;
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L7:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L10:
        boolean r4 = true;
        if (r3 == null) goto L27;
        if (r12 == 0) goto L14;
        int r5 = i5.r0();
    L18:
        r3.leftMargin = r5;
        if (r12 == (getItemCount() - 1)) goto L21;
        int r6 = 0;
    L25:
        r3.rightMargin = r6;
        goto L27
    L21:
        if (this.b == false) goto L23;
        r6 = i5.h();
        goto L25
    L23:
        r6 = i5.q();
        goto L25
    L14:
        if (this.b == false) goto L16;
        r5 = i5.h();
        goto L18
    L16:
        r5 = i5.q();
    L27:
        if (r0.getOEntityVideo() == null) goto L29;
        boolean r7 = true;
    L30:
        OSearchEntityVideo r8 = r0.getOEntityVideo();
        final String r9 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 == null) goto L56;
        OSearchEntityVideo r10 = r0.getOEntityVideo();
        if (r10 == null) goto L35;
        String r14 = r10.getResUri();
    L36:
        if (r14 != null) goto L38;
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L38:
        OSearchEntityVideo r15 = r0.getOEntityVideo();
        if (r15 == null) goto L41;
        final String r16 = r15.getEntityPackageName();
    L42:
        if (r16 != null) goto L44;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L44:
        OSearchEntityVideo r17 = r0.getOEntityVideo();
        if (r17 == null) goto L47;
        final String r18 = r17.getEntityType();
    L48:
        if (r18 != null) goto L50;
        r18 = NameKeys.UnloadStrategy_No_Strategy;
    L50:
        OSearchEntityVideo r19 = r0.getOEntityVideo();
        if (r19 == null) goto L53;
        String r20 = r19.getEntityId();
    L54:
        if (r20 == null) goto L82;
    L80:
        r9 = r20;
    L82:
        if (r12 < 10) goto L84;
        e1.o(r13.a.b);
        e1.o(r13.a.d);
        e1.x(r13.a.c);
        r13.a.c.setText("+" + (((ArrayList) this.a).size() - 10));
        we8.a.b(r13.a.c, (float) i5.k(), false, null, null, 12);
        e1.d(r13.a.c, new c(this, r16, r18, r9));
        return;
    L84:
        FLogger.a.i("SearchLocalRowAdapter", "resUri = " + r14 + ", packageName = " + r16 + ", isVideo = " + r7 + ", entityType = " + r18 + ", entityId = " + r9);
        if (r14.length() != 0) goto L87;
        boolean r110 = true;
    L88:
        if (r110 == false) goto L91;
        r13.a.b.setImageResource(0);
    L97:
        if (r7 == false) goto L99;
        e1.x(r13.a.d);
    L100:
        e1.x(r13.a.b);
        e1.o(r13.a.c);
        SimpleDraweeView r111 = r13.a.b;
        if (r111 == null) goto L105;
        e1.d(r111, new d(this, r16, r18, r9));
        return;
    L105:
        return;
    L99:
        e1.o(r13.a.d);
        goto L100
    L91:
        if (r16.length() == 0) goto L94;
        r4 = false;
    L94:
        if (r4 == false) goto L96;
        ImageLoaderKt.u(r13.a.b, r14, null);
        goto L97
    L96:
        SimpleDraweeView r112 = r13.a.b;
        int r21 = PrivilegedUriProvider.b;
        ImageLoaderKt.s(r112, PrivilegedUriProvider.a.a(UriProtector.parse(r14), r16, r7, r7), "obric_chat.cards");
        goto L97
    L87:
        r110 = false;
        goto L88
    L53:
        r20 = null;
        goto L54
    L47:
        r18 = null;
        goto L48
    L41:
        r16 = null;
        goto L42
    L35:
        r14 = null;
        goto L36
    L56:
        OSearchEntityImage r22 = r0.getOEntityImage();
        if (r22 == null) goto L59;
        r14 = r22.getResUri();
    L60:
        if (r14 != null) goto L62;
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L62:
        OSearchEntityImage r23 = r0.getOEntityImage();
        if (r23 == null) goto L65;
        r16 = r23.getEntityPackageName();
    L66:
        if (r16 != null) goto L68;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L68:
        OSearchEntityImage r24 = r0.getOEntityImage();
        if (r24 == null) goto L71;
        r18 = r24.getEntityType();
    L72:
        if (r18 != null) goto L74;
        r18 = NameKeys.UnloadStrategy_No_Strategy;
    L74:
        OSearchEntityImage r25 = r0.getOEntityImage();
        if (r25 == null) goto L77;
        r20 = r25.getEntityId();
    L78:
        if (r20 != null) goto L80;
    L77:
        r20 = null;
        goto L78
    L71:
        r18 = null;
        goto L72
    L65:
        r16 = null;
        goto L66
    L59:
        r14 = null;
        goto L60
    L29:
        r7 = false;
        goto L30
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        RoundRelativeLayout r7 = LayoutInflater.from(r5.getContext()).inflate(2131563943, r5, false);
        int r0 = 2131374718;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r7, 2131374718);
        if (r1 == null) goto L11;
        r0 = 2131389991;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r7, 2131389991);
        if (r2 == null) goto L11;
        r0 = 2131392382;
        View r3 = ViewBindings.findChildViewById(r7, 2131392382);
        if (r3 == null) goto L11;
        return new RowImageViewHolder(new ObricBlockLocalSearchItemWithRowImageBinding(r7, r1, r2, r3));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    public final void y2(List<OSearchReferenceInCollection> r8, boolean r9) {
        ((ArrayList) this.a).clear();
        this.b = r9;
        if (r8 == null) goto L19;
        List<OSearchReferenceInCollection> r10 = this.a;
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L18;
        Object r1 = r11.next();
        OSearchReferenceInCollection r2 = (OSearchReferenceInCollection) r1;
        if (r2.getOEntityImage() == null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        FLogger.a.w("SearchLocalRowAdapter", "item not contain image or video, item = " + r2);
    L16:
        if (r3 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        if (r2.getOEntityVideo() != null) goto L13;
        r3 = false;
        goto L14
    L18:
        ((ArrayList) r10).addAll(r0);
    L19:
        notifyDataSetChanged();
    }

    public final void z2(AppEntityEx.a r7, boolean r8) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new SearchLocalRowAdapter$showAll$1(this, r7, r8, null), 3, null);
    }
}
