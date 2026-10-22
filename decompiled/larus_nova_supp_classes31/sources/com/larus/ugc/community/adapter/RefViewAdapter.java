package com.larus.ugc.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.AudioResource;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import f0a.a;
import f0a.c;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B,\u0012#\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0007J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R+\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/ugc/community/adapter/RefViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onRefViewClickListener", "Lkotlin/Function1;", "Lcom/larus/ugc/community/adapter/RefData;", "Lkotlin/ParameterName;", "name", "item", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "dataList", "", "getItemCount", "", "refreshData", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RefViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Function1<a, Unit> a;
    public List<a> b;

    public final int getItemCount() {
        return this.b.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RefViewAdapter(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onRefViewClickListener");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        if ((r10 instanceof RefViewHolder) == false) goto L29;
        final RefViewHolder r12 = (RefViewHolder) r10;
        final a r13 = (a) CollectionsKt.getOrNull(this.b, r11);
        r12.getClass();
        String r0 = null;
        if (r13 == null) goto L7;
        ResourceType r1 = r13.a;
    L8:
        String r3 = "";
        if (r1 != ResourceType.AUDIO) goto L19;
        e1.o(r12.c);
        r12.c.setOnClickListener(null);
        e1.x(r12.d);
        r12.e.setImageResource(2131240154);
        TextView r14 = r12.f;
        AudioResource r15 = r13.d;
        if (r15 == null) goto L15;
        Double r16 = r15.d;
        if (r16 == null) goto L15;
        long r2 = RangesKt.coerceAtLeast((long) r16.doubleValue(), 0);
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        long r5 = 60;
        r0 = String.format(Locale.ROOT, "%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2 / r5), Long.valueOf(r2 % r5)}, 2));
    L15:
        if (r0 == null) goto L18;
        r3 = r0;
    L18:
        r14.setText(r3);
        return;
    L19:
        e1.o(r12.d);
        e1.x(r12.c);
        SimpleDraweeView r4 = r12.c;
        if (r13 == null) goto L27;
        Image r6 = r13.b;
        if (r6 == null) goto L27;
        String r7 = r6.a;
        if (r7 == null) goto L27;
        r3 = r7;
    L27:
        ImageLoaderKt.u(r4, r3, "RefViewAdapter");
        e1.d(r12.c, new c(r12, r13));
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562633, r3, false);
        Function1<a, Unit> r0 = this.a;
        Intrinsics.checkNotNull(r5);
        return new RefViewHolder(r0, r5);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        onBindViewHolder(r2, r3);
    }
}
