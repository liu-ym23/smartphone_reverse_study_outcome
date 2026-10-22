package com.larus.bmhome.chat.layout.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.databinding.LarusItemAwemePostListBinding;
import com.larus.bmhome.searchmixedmedia.MixedMediaAdapter;
import com.larus.bmhome.searchmixedmedia.MixedMediaDecorationGridItemDecoration;
import com.larus.bmhome.searchmixedmedia.RatioMode;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.im.bean.message.Message;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.api.InnerVideoPreloadScene;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends LinearLayout {
    public final LarusItemAwemePostListBinding a;
    public Message b;
    public List<Content> c;
    public Function1<? super Content, Unit> d;
    public Function3<? super Content, ? super Integer, ? super Integer, Unit> e;
    public MixedMediaAdapter f;
    public final a g;

    public static final class a implements pr8.f {
        public final /* synthetic */ f a;
        public final /* synthetic */ Context b;

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public a(f r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(View r3, final int r4, final int r5, final String r6) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            final f r0 = this.a;
            ExposeXTrackerExtKt.b(r3, new d(r6, r0, r4, r5));
        }

        public final void c(View r27, int r28, int r29, pr8.c r30) {
            Intrinsics.checkNotNullParameter(r27, "anchor");
            Intrinsics.checkNotNullParameter(r30, "item");
            List<Content> r2 = this.a.c;
            ArrayList r3 = null;
            if (r2 == null) goto L12;
            Iterator<T> r4 = r2.iterator();
        L6:
            if (r4.hasNext() == false) goto L10;
            Object r5 = r4.next();
            if (Intrinsics.areEqual(((Content) r5).getItemId(), r30.a) == false) goto L6;
        L11:
            Content r6 = (Content) r5;
        L13:
            if (r6 == null) goto L50;
            f r13 = this.a;
            Context r7 = this.b;
            List<Content> r8 = r13.c;
            if (r8 == null) goto L51;
            Iterator<Content> r9 = r8.iterator();
            int r10 = 0;
        L18:
            if (r9.hasNext() == false) goto L23;
            if (Intrinsics.areEqual(r9.next().getItemId(), r30.a) == true) goto L21;
            r10 = r10 + 1;
            goto L18
        L21:
            int r17 = r10;
        L24:
            if (r17 >= 0) goto L26;
            return;
        L26:
            int r1 = com.larus.bmhome.double_post.utils.h.a;
            Message r11 = r13.b;
            if (r11 == null) goto L29;
            String r19 = r11.getMessageId();
        L30:
            com.larus.bmhome.double_post.utils.h.a r12 = new com.larus.bmhome.double_post.utils.h.a(r19, null, null, null, null, null, 126);
            List<Content> r14 = r13.c;
            if (r14 == null) goto L38;
            r3 = new ArrayList();
            Iterator<T> r15 = r14.iterator();
        L34:
            if (r15.hasNext() == false) goto L38;
            String r16 = ((Content) r15.next()).getItemId();
            if (r16 == null) goto L34;
            r3.add(r16);
        L38:
            int r18 = r17 % r29;
            com.larus.bmhome.double_post.utils.h.a(r7, r27, r6, r17, "wcb_first_card", r12, r3, Integer.valueOf(r17 / r29), Integer.valueOf(r18), InnerVideoPreloadScene.WCBFirstCard.getSceneValue());
            int r20 = qr8.a.a;
            qr8.a.b(r6.getItemType(), r6.getItemId(), r6.getRequestId(), r17, r18, r13.b, true, r6.getRequestId(), 320);
            return;
        L29:
            r19 = null;
            goto L30
        L23:
            r17 = -1;
            goto L24
        L51:
            return;
        L50:
            return;
        L10:
            r5 = null;
            goto L11
        L12:
            r6 = null;
            goto L13
        }
    }

    private final Pair<Integer, Integer> getCountConfig() {
        Lazy r0 = com.larus.bmhome.video.b.a;
        return com.larus.bmhome.video.b.a();
    }

    private final int getScreenWidth() {
        if (com.larus.platform.service.e2.a.isPad() == false) goto L6;
        return com.larus.platform.api.f3.a.a();
    L6:
        return com.larus.utils.i.d(getContext());
    }

    public final void b() {
        RecyclerView r0 = this.a.b;
        int r1 = getScreenWidth();
        if (r0.getLayoutParams() != null) goto L5;
        r0.setLayoutParams(new ViewGroup.LayoutParams(r1, -2));
        return;
    L5:
        r0.getLayoutParams().width = r1;
        r0.requestLayout();
    }

    public f(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        LayoutInflater.from(r5).inflate(2131562497, this);
        int r0 = 2131384070;
        RecyclerView r1 = ViewBindings.findChildViewById(this, 2131384070);
        if (r1 == null) goto L9;
        r0 = 2131388741;
        GradientTextView r2 = ViewBindings.findChildViewById(this, 2131388741);
        if (r2 == null) goto L9;
        this.a = new LarusItemAwemePostListBinding(this, r1, r2);
        this.g = new a(this, r5);
        setOrientation(1);
        Lazy r3 = com.larus.bmhome.video.b.a;
        int r6 = com.larus.bmhome.video.b.b(true);
        int r4 = i5.q() - r6;
        r2.setPadding(r2.getPaddingLeft(), r2.getPaddingTop(), r2.getPaddingRight(), r4);
        r2.setText(com.larus.bmhome.video.b.e());
        b();
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    private final void setupRecycler(final pr8.e r5) {
        if (this.f != null) goto L5;
        this.f = new MixedMediaAdapter(new com.larus.bmhome.chat.layout.item.a(this, r5), new b(this), new c(this, r5));
        RecyclerView r0 = this.a.b;
        r0.setLayoutManager(new GridLayoutManager(r0.getContext(), r5.b));
        r0.setAdapter(this.f);
        r0.addItemDecoration(new MixedMediaDecorationGridItemDecoration());
        Intrinsics.checkNotNull(r0);
    L11:
        MixedMediaAdapter r1 = this.f;
        if (r1 == null) goto L15;
        List r2 = r5.c;
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r5, "input");
        r1.d = r5;
        r1.submitList(r2);
        return;
    L15:
        return;
    L5:
        GridLayoutManager r3 = this.a.b.getLayoutManager();
        if ((r3 instanceof GridLayoutManager) == false) goto L8;
        GridLayoutManager r4 = r3;
    L9:
        if (r4 == null) goto L11;
        r4.setSpanCount(r5.b);
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (com.larus.platform.service.e2.a.a(r1, r3) == false) goto L14;
        b();
        List<Content> r4 = this.c;
        if (r4 == null) goto L15;
        a(this.b, r4);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setOnClickListener(Function1<? super Content, Unit> r1) {
        this.d = r1;
    }

    public final void setOnShowAction(Function3<? super Content, ? super Integer, ? super Integer, Unit> r1) {
        this.e = r1;
    }

    public final void a(Message r7, List<Content> r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        this.b = r7;
        this.c = r8;
        List<Content> r9 = r8;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add(pr8.d.a((Content) r10.next()));
        goto L4
    L6:
        List r11 = CollectionsKt.take(r0, ((Number) getCountConfig().getFirst()).intValue());
        if (r11 != null) goto L9;
        r11 = CollectionsKt.emptyList();
    L9:
        List r3 = r11;
        if (r3.isEmpty() == false) goto L12;
        com.larus.utils.e1.o(this);
    L13:
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r8.iterator();
    L15:
        if (r13.hasNext() == false) goto L34;
        Content r1 = (Content) r13.next();
        String r2 = r1.getItemId();
        boolean r4 = false;
        if (r2 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        pr9.a r6 = null;
    L32:
        if (r6 == null) goto L15;
        r12.add(r6);
        goto L15
    L25:
        Integer r14 = r1.getItemType();
        int r15 = ItemType.ARTICLE.getValue();
        if (r14 != null) goto L29;
    L31:
        r6 = new pr9.a(r2, r4, 12);
        goto L32
    L29:
        if (r14.intValue() != r15) goto L31;
        r4 = true;
        goto L31
    L19:
        if (r2.length() == 0) goto L22;
        r5 = false;
        goto L23
    L34:
        qr9.c r16 = VideoFeedProviderDelegate.b.b();
        if (r16 == null) goto L44;
        r16.b(r12);
        return;
    L44:
        return;
    L12:
        com.larus.utils.e1.x(this);
        setupRecycler(new pr8.e(RatioMode.FIXED, ((Number) getCountConfig().getSecond()).intValue(), r3, ExpandCardViewMode.NORMAL, null));
        goto L13
    }
}
