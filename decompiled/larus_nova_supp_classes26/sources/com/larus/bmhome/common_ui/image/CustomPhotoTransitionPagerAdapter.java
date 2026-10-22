package com.larus.bmhome.common_ui.image;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.gallery.VideoVH;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.bmhome.video.bean.VideoType;
import com.larus.bmhome.viewholder.LifeViewHolder;
import com.larus.bmhome.viewholder.PhotoVH;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.image.loader.b0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l19.f;
import uo8.b;
import yt8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007J\u0014\u0010>\u001a\u00020\u001b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100@J\u0018\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0007H\u0016J\u000e\u0010E\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0007J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u0002H\u0016J\u001a\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u00022\b\b\u0001\u0010:\u001a\u00020\u0007H\u0016J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0016J\b\u0010J\u001a\u00020\u0007H\u0016R:\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u000703¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u000703¢\u0006\b\n\u0000\u001a\u0004\b8\u00105¨\u0006M"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "Lcom/larus/bmhome/viewholder/LifeViewHolder;", "<init>", "()V", "validMapUrl", "Ljava/util/LinkedHashMap;", "", "Landroid/net/Uri;", "Lkotlin/collections/LinkedHashMap;", "getValidMapUrl", "()Ljava/util/LinkedHashMap;", "setValidMapUrl", "(Ljava/util/LinkedHashMap;)V", "urls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "thumbUrls", "", "getThumbUrls", "setThumbUrls", "onImageLoadSuccess", "Lkotlin/Function1;", "", "getOnImageLoadSuccess", "()Lkotlin/jvm/functions/Function1;", "setOnImageLoadSuccess", "(Lkotlin/jvm/functions/Function1;)V", "onImageLongPressListener", "Lkotlin/Function0;", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "transitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "currentSelectedPosition", "_unselectedPosition", "Landroidx/lifecycle/MutableLiveData;", "unselectedPosition", "Landroidx/lifecycle/LiveData;", "getUnselectedPosition", "()Landroidx/lifecycle/LiveData;", "_selectedPosition", "selectedPosition", "getSelectedPosition", "getValidUri", "position", "getPreviewUri", "getDownloadUri", "getMediaType", "refreshData", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "onViewDetachedFromWindow", "holder", "onBindViewHolder", "getItemViewType", "getItemCount", "Companion", "DiffCallback", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomPhotoTransitionPagerAdapter extends TransitionPagerAdapter<LifeViewHolder> {
    public static final /* synthetic */ int v = 0;
    public final LinkedHashMap<Integer, Uri> j;
    public List<n1> k;
    public List<String> l;
    public Function1<? super Integer, Unit> m;
    public Function0<Unit> n;
    public Function0<Unit> o;
    public f p;
    public int q;
    public final MutableLiveData<Integer> r;
    public final MutableLiveData s;
    public final MutableLiveData<Integer> t;
    public final MutableLiveData u;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getStableId", "", "item", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<n1> a;
        public final List<n1> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public static String a(n1 r4) {
            String r0 = r4.c;
            if (r0 == null) goto L6;
            String r1 = StringsKt.substringAfterLast$default(r0, "/", null, 2, null);
            if (r1 == null) goto L6;
            return r1;
        L6:
            String r2 = r4.a;
            if (r2 == null) goto L10;
            return StringsKt.substringAfterLast$default(r2, "/", null, 2, null);
        L10:
            return String.valueOf(r4.hashCode());
        }

        public DiffCallback(List<n1> r2, List<n1> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            n1 r6 = (n1) CollectionsKt.getOrNull(this.a, r4);
            n1 r7 = (n1) CollectionsKt.getOrNull(this.b, r5);
            if (r6 == null) goto L12;
            if (r7 != null) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(r6.c, r7.c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(r6.a, r7.a) == false) goto L14;
            return true;
        L14:
            return false;
        L12:
            return false;
        }

        public final boolean areItemsTheSame(int r4, int r5) {
            n1 r6 = (n1) CollectionsKt.getOrNull(this.a, r4);
            n1 r7 = (n1) CollectionsKt.getOrNull(this.b, r5);
            if (r6 == null) goto L18;
            if (r7 == null) goto L21;
            t1 r0 = r6.b;
            String r1 = null;
            if (r0 == null) goto L9;
            String r2 = r0.g();
        L10:
            t1 r3 = r7.b;
            if (r3 == null) goto L13;
            r1 = r3.g();
        L13:
            if (r2 == null) goto L17;
            if (r1 == null) goto L17;
            return Intrinsics.areEqual(r2, r1);
        L17:
            return Intrinsics.areEqual(a(r6), a(r7));
        L9:
            r2 = null;
            goto L10
        L21:
            return false;
        L18:
            return false;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.k.size();
    }

    public CustomPhotoTransitionPagerAdapter() {
        this.j = new LinkedHashMap();
        this.k = new ArrayList();
        this.m = new uo8.a();
        this.q = -1;
        MutableLiveData<Integer> r0 = new MutableLiveData();
        this.r = r0;
        this.s = r0;
        MutableLiveData<Integer> r1 = new MutableLiveData();
        this.t = r1;
        this.u = r1;
    }

    public final Uri A2(int r5) {
        List<n1> r0 = this.k;
        String r1 = null;
        if (r0 == null) goto L26;
        n1 r2 = (n1) CollectionsKt.getOrNull(r0, r5);
        if (r2 != null) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(r2.a, r2.c) == false) goto L28;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(this.j.get(Integer.valueOf(r5)));     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r4) == null) goto L23;
        List<n1> r6 = this.k;
        if (r6 == null) goto L21;
        n1 r7 = (n1) ListProtector.get(r6, r5);
        if (r7 == null) goto L21;
        r1 = r7.a;
    L21:
        r4 = b0.a(r1, "common.photo_dialog_preview", false, true, 2);
    L23:
        return (Uri) r4;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L28:
        return b0.a(r2.c, "common.photo_dialog_download", false, false, 6);
    L26:
        return null;
    }

    public final void B2(List<n1> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        DiffUtil.calculateDiff(new DiffCallback(this.k, r0)).dispatchUpdatesTo(this);     // Catch: Exception -> L8
    L10:
        this.k = r0;
        return;
    L8:
        e = move-exception;
        FLogger.a.e("CustomPhotoTransitionPagerAdapter", "diffResult.dispatchUpdatesTo error e=" + e.getMessage());
        goto L10
    }

    public final void C2(int r3) {
        int r0 = this.q;
        if (r3 != r0) goto L6;
        return;
    L6:
        if (r0 == (-1)) goto L8;
        this.r.setValue(Integer.valueOf(r0));
    L8:
        this.t.setValue(Integer.valueOf(r3));
        this.q = r3;
    }

    public final int getItemViewType(int r4) {
        String r5 = ((n1) ListProtector.get(this.k, r4)).c;
        String r1 = null;
        if (r5 == null) goto L14;
        String r6 = StringsKt.substringBefore$default(r5, "?", null, 2, null);
        if (r6 == null) goto L14;
        String r7 = StringsKt.substringBefore$default(r6, "#", null, 2, null);
        if (r7 == null) goto L14;
        String r8 = StringsKt.substringAfterLast$default(r7, "/", null, 2, null);
        if (r8 == null) goto L14;
        String r9 = r8.toLowerCase(Locale.ROOT);
        if (r9 == null) goto L14;
        r1 = StringsKt.substringAfterLast$default(r9, ".", null, 2, null);
    L14:
        if (Intrinsics.areEqual(r1, VideoType.MP4) == true) goto L18;
        return 1;
    L18:
        return 2;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        LifeViewHolder r3 = (LifeViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.z2(r3);
        r3.W3();
    }

    public final void z2(TransitionViewHolder r2) {
        LifeViewHolder r3 = (LifeViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.z2(r3);
        r3.W3();
    }

    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.lifecycle.Observer, java.lang.Object, yt8.c] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.lifecycle.Observer, java.lang.Object, yt8.b] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final LifeViewHolder r11 = (LifeViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        n1 r1 = (n1) ListProtector.get(this.k, r10);
        List<String> r0 = this.l;
        LifecycleOwner r7 = null;
        if (r0 == null) goto L5;
        String r2 = (String) CollectionsKt.getOrNull(r0, r10);
    L6:
        r11.X3(r1, r2, this.m, this.n, this.o, new b(this));
        MutableLiveData r12 = this.s;
        MutableLiveData r3 = this.u;
        Intrinsics.checkNotNullParameter(r12, "unselectedLiveData");
        Intrinsics.checkNotNullParameter(r3, "selectedLiveData");
        Context r4 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
        if ((r4 instanceof LifecycleOwner) == false) goto L9;
        r7 = (LifecycleOwner) r4;
    L9:
        if (r7 == null) goto L19;
        yt8.b r5 = r11.c;
        if (r5 == null) goto L14;
        r12.removeObserver(r5);
    L14:
        ?? r6 = new yt8.b(r11);
        r11.c = r6;
        Intrinsics.checkNotNull(r6);
        r12.observe(r7, r6);
        c r13 = r11.b;
        if (r13 == null) goto L17;
        r3.removeObserver(r13);
    L17:
        ?? r14 = new c(r11);
        r11.b = r14;
        Intrinsics.checkNotNull(r14);
        r3.observe(r7, r14);
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 == 1) goto L18;
        if (r6 != 2) goto L19;
        IDoraEService r7 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r7 == null) goto L10;
        VideoVH r8 = r7.c(r5);
    L12:
        if ((r8 instanceof LifeViewHolder) == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L21;
        return r8;
    L21:
        return new PhotoVH(LayoutInflater.from(r5.getContext()).inflate(2131562458, r5, false));
    L10:
        r8 = null;
        goto L12
    L19:
        return new PhotoVH(LayoutInflater.from(r5.getContext()).inflate(2131562458, r5, false));
    L18:
        return new PhotoVH(LayoutInflater.from(r5.getContext()).inflate(2131562458, r5, false));
    }
}
