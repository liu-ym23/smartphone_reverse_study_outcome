package com.larus.uaigc.template;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.GridSpacingItemDecoration;
import com.larus.bmhome.chat.WrapStaggeredGridLayoutManager;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateRecommendRelatedData;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateType;
import com.larus.uaigc.impl.databinding.LarusPageTemplateDetailBinding;
import com.larus.utils.o0;
import com.larus.utils.u;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010&\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/uaigc/template/ImageTemplateDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusPageTemplateDetailBinding;", "adapter", "Lcom/larus/uaigc/template/ImageAdapter;", "offset", "", "hasRequestOffset", "", "", "hasMore", "spanCount", "botId", "", "chatType", "conversationId", "previousPage", "recommendedFrom", "position", "Ljava/lang/Integer;", "onConversationChangedObserver", "Landroidx/lifecycle/Observer;", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "goChatAndSetText", "context", "Landroid/content/Context;", "requestTemplateRelatedList", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageTemplateDetailFragment extends Fragment {
    public static final /* synthetic */ int q = 0;
    public LarusPageTemplateDetailBinding d;
    public ImageAdapter e;
    public int f;
    public final Map<Integer, Boolean> g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public Integer o;
    public final o p;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.uaigc.template.ImageTemplateDetailFragment$onViewCreated$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.template.ImageTemplateDetailFragment$onViewCreated$6", f = "ImageTemplateDetailFragment.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImageTemplateDetailFragment this$0;

        public AnonymousClass6(ImageTemplateDetailFragment r1, Continuation<? super AnonymousClass6> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass6(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L18:
            y r2 = (com.larus.network.http.a) r1;
            boolean r3 = false;
            if ((r2 instanceof y) == false) goto L38;
            ImageTemplateDetailFragment r4 = this.this$0;
            r4.g.put(Boxing.boxInt(r4.f), Boxing.boxBoolean(true));
            y r5 = r2;
            TemplateInfo$TemplateRecommendRelatedData r6 = (TemplateInfo$TemplateRecommendRelatedData) ((com.larus.network.http.a) r5).b;
            if (r6 == null) goto L26;
            List<TemplateInfo$TemplateInfo> r7 = r6.a;
            if (r7 == null) goto L26;
            List<TemplateInfo$TemplateInfo> r8 = CollectionsKt.filterNotNull(r7);
            if (r8 == null) goto L26;
        L27:
            ImageTemplateDetailFragment r9 = this.this$0;
            r9.f++;
            TemplateInfo$TemplateRecommendRelatedData r10 = (TemplateInfo$TemplateRecommendRelatedData) ((com.larus.network.http.a) r5).b;
            if (r10 == null) goto L32;
            Boolean r11 = r10.d;
            if (r11 == null) goto L32;
            r3 = r11.booleanValue();
        L32:
            r9.h = r3;
            ImageAdapter r12 = this.this$0.e;
            if (r12 == null) goto L35;
            r12.y2(r8);
        L35:
            ImageTemplateDetailFragment r14 = this.this$0;
            ImageAdapter r15 = r14.e;
            if (r15 == null) goto L43;
            r15.i = r14.h;
        L43:
            return Unit.INSTANCE;
        L26:
            r8 = CollectionsKt.emptyList();
            goto L27
        L38:
            ImageTemplateDetailFragment r17 = this.this$0;
            ImageAdapter r18 = r17.e;
            if (r18 == null) goto L41;
            r18.i = false;
        L41:
            r17.g.remove(Boxing.boxInt(r17.f));
            goto L43
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            JSONObject r19 = new JSONObject();
            ImageTemplateDetailFragment r20 = this.this$0;
            r19.put("enter_time", System.currentTimeMillis() / ((long) 1000));
            Bundle r21 = r20.getArguments();
            if (r21 == null) goto L11;
            Long r22 = Boxing.boxLong(r21.getLong("template_id"));
        L12:
            r19.put("template_id", r22);
            r19.put("template_type", TemplateInfo$TemplateType.AI_ARTIST);
            r19.put("offset", r20.f);
            r19.put("size", 20);
            if (o0.d(r20.j) == false) goto L15;
            r19.put("bot_id", r20.j);
        L15:
            Unit r23 = Unit.INSTANCE;
            this.label = 1;
            r1 = HttpExtKt.k("Social", TemplateInfo$TemplateRecommendRelatedData.class, "/alice/template/recommend_related", r19, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L18;
            return r13;
        L11:
            r22 = null;
            goto L12
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.uaigc.template.o] */
    public ImageTemplateDetailFragment() {
        this.g = new LinkedHashMap();
        this.i = 2;
        this.p = new o(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        zh8.a.a.H1().removeObserver(this.p);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LarusPageTemplateDetailBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.e = null;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        String r6 = r5.getString("template_detail_bot_id");
        if (r6 == null) goto L6;
    L7:
        this.j = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L11;
        String r8 = r7.getString("template_detail_chat_type");
        if (r8 == null) goto L11;
    L12:
        this.k = r8;
        Bundle r9 = getArguments();
        Integer r1 = null;
        if (r9 == null) goto L15;
        String r10 = r9.getString("argConversationId");
    L16:
        this.l = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L20;
        String r12 = r11.getString("argPreviousPage", "");
        if (r12 == null) goto L20;
    L21:
        this.m = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L24;
        String r14 = r13.getString("recommend_from", "");
    L25:
        this.n = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L28;
        r1 = Integer.valueOf(r15.getInt("position"));
    L28:
        this.o = r1;
        Transformations.distinctUntilChanged(zh8.a.a.H1()).observeForever(this.p);
        return;
    L24:
        r14 = null;
    L20:
        r12 = "";
        goto L21
    L15:
        r10 = null;
    L11:
        r8 = "";
    L6:
        r6 = "";
        goto L7
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        LarusPageTemplateDetailBinding r14 = this.d;
        if (r14 == null) goto L9;
        FrameLayout r15 = r14.b;
        Intrinsics.checkNotNull(r15);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        int r1 = u.c(r0);
    L8:
        r15.setPaddingRelative(r15.getPaddingStart(), r1, r15.getPaddingEnd(), r15.getPaddingBottom());
        goto L9
    L7:
        r1 = 0;
    L9:
        this.f = 0;
        ((LinkedHashMap) this.g).clear();
        LarusPageTemplateDetailBinding r16 = this.d;
        if (r16 == null) goto L14;
        ImageView r17 = r16.c;
        if (r17 == null) goto L14;
        r17.setOnClickListener(new k(this));
    L14:
        LarusPageTemplateDetailBinding r18 = this.d;
        if (r18 == null) goto L19;
        FrameLayout r19 = r18.d;
        if (r19 == null) goto L19;
        r19.setOnClickListener(new l(this));
    L19:
        Context r110 = getContext();
        if (r110 == null) goto L22;
        float r111 = c7.d(Integer.valueOf(com.larus.utils.i.d(r110)));
    L24:
        if (r111 <= 500.0f) goto L26;
        this.i = 3;
    L26:
        final WrapStaggeredGridLayoutManager r112 = new WrapStaggeredGridLayoutManager(this.i, 1);
        LarusPageTemplateDetailBinding r113 = this.d;
        if (r113 == null) goto L33;
        RecyclerView r114 = r113.e;
        if (r114 == null) goto L33;
        RecyclerView.ItemAnimator r115 = r114.getItemAnimator();
        if (r115 == null) goto L33;
        r115.setChangeDuration(0);
    L33:
        LarusPageTemplateDetailBinding r116 = this.d;
        if (r116 == null) goto L38;
        RecyclerView r117 = r116.e;
        if (r117 == null) goto L38;
        r117.setLayoutManager(r112);
    L38:
        LarusPageTemplateDetailBinding r118 = this.d;
        if (r118 == null) goto L43;
        RecyclerView r119 = r118.e;
        if (r119 == null) goto L43;
        r119.addItemDecoration(new GridSpacingItemDecoration(this.i, i5.z()));
    L43:
        ImageAdapter r120 = new ImageAdapter(new ArrayList(), this, getArguments(), this.j, this.k, this.m);
        this.e = r120;
        r120.l = new m(this);
        r120.k = new n(this);
        r120.i = true;
        LarusPageTemplateDetailBinding r2 = this.d;
        if (r2 == null) goto L48;
        RecyclerView r3 = r2.e;
        if (r3 == null) goto L48;
        r3.setAdapter(r120);
    L48:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass6(this, null), 3, null);
        LarusPageTemplateDetailBinding r121 = this.d;
        if (r121 == null) goto L54;
        RecyclerView r122 = r121.e;
        if (r122 == null) goto L55;
        r122.addOnScrollListener(new AnonymousClass7(r112, this));
        return;
    L55:
        return;
    L54:
        return;
    L22:
        r111 = 200.0f;
        goto L24
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131563078, r8, false);
        int r11 = 2131363775;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131363775);
        if (r2 == null) goto L13;
        r11 = 2131388325;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r10, 2131388325);
        if (r3 == null) goto L13;
        r11 = 2131388326;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131388326);
        if (r4 == null) goto L13;
        r11 = 2131388336;
        RecyclerView r5 = ViewBindings.findChildViewById(r10, 2131388336);
        if (r5 == null) goto L13;
        ConstraintLayout r12 = r10;
        this.d = new LarusPageTemplateDetailBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
