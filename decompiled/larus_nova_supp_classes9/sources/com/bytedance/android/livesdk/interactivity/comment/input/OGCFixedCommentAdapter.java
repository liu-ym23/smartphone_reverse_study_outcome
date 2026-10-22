package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedCommentAdapter extends RecyclerView.Adapter<OGCFixedCommentViewHolder> {
    public final List<Pair<Integer, String>> a;
    public final Lazy b;
    public final Lazy c;
    public final int d;
    public final int e;
    public final d0 f;
    public final DataCenter g;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public OGCFixedCommentAdapter(d0 r14, DataCenter r15) {
        Intrinsics.checkNotNullParameter(r14, "actionHandler");
        this.f = r14;
        this.g = r15;
        this.a = new ArrayList();
        this.b = LazyKt.lazy(new OGCFixedCommentAdapter$skinNormal$2(this));
        this.c = LazyKt.lazy(new OGCFixedCommentAdapter$skinSelect$2(this));
        this.d = ColorProtector.parseColor("#161823");
        this.e = ColorProtector.parseColor("#161823");
        com.bytedance.android.livesdk.interactivity.api.h r16 = com.bytedance.android.livesdk.interactivity.api.i.a(null, r15);
        if (r16 == null) goto L57;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r17 = r16.getQuickCommentManager();
        if (r17 == null) goto L58;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r18 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r17.getValue();
        if (r18 == null) goto L59;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r19 = r18.getOGCFixedChatInfo();
        if (r19 == null) goto L60;
        List<String> r0 = r19.fixedChatList;
        boolean r1 = false;
        if (r0 == null) goto L36;
        List<String> r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L14:
        if (r4.hasNext() == false) goto L30;
        String r7 = (String) r4.next();
        if (StringsKt.contains$default(r7, "%v", false, 2, null) == false) goto L29;
        IRoomContextService r5 = jc1.k.f(IRoomContextService.class);
        if (r5 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r5, this.g, 0, 2);
        if (r6 == null) goto L27;
        com.bytedance.live.datacontext.m r8 = r6.K2();
        if (r8 == null) goto L27;
        String r9 = (String) r8.getValue();
        if (r9 == null) goto L27;
        String r10 = r9;
    L28:
        r7 = StringsKt.replace$default(r7, "%v", r10, false, 4, null);
        ALogger.i("OGCFixedCommentAdapter", "replace cityName: result = " + r7);
    L27:
        r10 = BuildConfig.FLAVOR;
    L29:
        r3.add(TuplesKt.to(1, r7));
        goto L14
    L30:
        ((ArrayList) this.a).clear();
        int r110 = 0;
    L31:
        if (r110 >= 2) goto L33;
        ((ArrayList) this.a).add(TuplesKt.to(2, BuildConfig.FLAVOR));
        r110 = r110 + 1;
        goto L31
    L33:
        ((ArrayList) this.a).addAll(r3);
        int r111 = 0;
    L34:
        if (r111 >= 2) goto L36;
        ((ArrayList) this.a).add(TuplesKt.to(2, BuildConfig.FLAVOR));
        r111 = r111 + 1;
    L36:
        String r112 = r19.textSelectedColor;
        if (r112 != null) goto L39;
    L44:
        String r113 = r19.textDefaultColor;
        if (r113 != null) goto L47;
        return;
    L47:
        if (r113.length() <= 0) goto L49;
        r1 = true;
    L49:
        if (r1 != true) goto L62;
        this.d = ColorProtector.parseColor(r19.textDefaultColor);
        return;
    L62:
        return;
    L39:
        if (r112.length() <= 0) goto L41;
        boolean r114 = true;
    L42:
        if (r114 != true) goto L44;
        this.e = ColorProtector.parseColor(r19.textSelectedColor);
        goto L44
    L41:
        r114 = false;
        goto L42
    L60:
        return;
    L59:
        return;
    L58:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        OGCFixedCommentViewHolder r6 = (OGCFixedCommentViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Pair r7 = (Pair) ListProtector.get(this.a, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "text");
        r6.a = ((Number) r7.getFirst()).intValue();
        r6.T3(false);
        int r1 = r6.a;
        if (r1 != 1) goto L5;
        View r0 = (View) r6.b.getValue();
        if (r0 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r0);
    L16:
        View r2 = (View) r6.b.getValue();
        if (r2 == null) goto L19;
        r2.setClickable(true);
    L19:
        TextView r8 = (TextView) r6.e.getValue();
        if (r8 == null) goto L25;
        r8.setText((CharSequence) r7.getSecond());
        return;
    L25:
        return;
    L5:
        if (r1 != 2) goto L26;
        View r9 = (View) r6.b.getValue();
        if (r9 == null) goto L10;
        UtilityKotlinExtentionsKt.u(r9);
    L10:
        View r10 = (View) r6.b.getValue();
        if (r10 == null) goto L23;
        r10.setClickable(false);
        return;
    L23:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r3 = LayoutInflater.from(r9.getContext()).inflate(2131567792, r9, false);
        if (PadConfigUtils.c() == false) goto L5;
        ViewGroup.LayoutParams r11 = r3.getLayoutParams();
        r11.height = s1.f(65.0f);
        r3.setLayoutParams(r11);
    L5:
        OGCFixedCommentViewHolder r13 = new OGCFixedCommentViewHolder(r3, (py.k) this.b.getValue(), (py.k) this.c.getValue(), Integer.valueOf(this.d), Integer.valueOf(this.e));
        ((RecyclerView.ViewHolder) r13).itemView.setOnClickListener(new g(this, r13));
        return r13;
    }
}
