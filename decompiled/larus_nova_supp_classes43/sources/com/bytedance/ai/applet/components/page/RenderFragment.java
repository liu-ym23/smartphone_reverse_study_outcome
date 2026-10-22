package com.bytedance.ai.applet.components.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.applet.components.view.RenderViewFactory;
import com.bytedance.ai.applet.render.core.lynx.LynxRenderView;
import com.bytedance.ai.lynx.q;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/applet/components/page/RenderFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "renderData", "Lcom/bytedance/ai/applet/components/page/RenderUrlData;", "renderView", "Lcom/bytedance/ai/applet/render/core/RenderView;", "sessionId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public RenderUrlData d;
    public LynxRenderView e;
    public String f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.components.page.RenderFragment$onCreateView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.components.page.RenderFragment$onCreateView$2", f = "RenderFragment.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ w2.a $renderView;
        int label;
        final /* synthetic */ RenderFragment this$0;

        public AnonymousClass2(w2.a r1, RenderFragment r10, Continuation<? super AnonymousClass2> r11) {
            this.$renderView = r1;
            this.this$0 = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$renderView, this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            w2.a r11 = this.$renderView;
            RenderUrlData r12 = this.this$0.d;
            if (r12 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("renderData");
            r12 = null;
        L11:
            String r13 = r12.d;
            this.label = 1;
            if (r11.f(r13, new JSONObject(), this) != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public final void onDestroyView() {
        LynxRenderView r0 = this.e;
        if (r0 == null) goto L5;
        r0.destroy();
        this.e = null;
    L5:
        String r1 = this.f;
        if (r1 == null) goto L8;
        AppletResourceTool.a.getClass();
        AppletResourceTool.a(r1);
        this.f = null;
    L8:
        super.onDestroyView();
    }

    public RenderFragment() {
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        RenderUrlData r11 = (RenderUrlData) requireArguments().getParcelable(Reflection.getOrCreateKotlinClass(RenderUrlData.class).getSimpleName());
        if (r11 == null) goto L8;
        this.d = r11;
        g r12 = g.a;
        StringBuilder r1 = new StringBuilder("onCreate: renderData = ");
        RenderUrlData r13 = this.d;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r13 = null;
    L7:
        r1.append(r13);
        r12.d("RenderFragment", r1.toString());
        return;
    L8:
        g.a.e("RenderFragment", "onCreate: renderData arguments null");
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L13;
        r14.finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.view.View, com.bytedance.ai.applet.render.core.lynx.LynxRenderView, w2.a] */
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        boolean r0 = false;
        View r13 = r10.inflate(2131558715, r11, false);
        RenderUrlData r14 = this.d;
        if (r14 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r14 = null;
    L6:
        if (r14.c == false) goto L8;
        r13.findViewById(2131388807).setVisibility(8);
        r13.findViewById(2131369197).setVisibility(8);
    L8:
        r13.findViewById(2131364679).setOnClickListener(new b(this));
        this.f = AppletResourceTool.s(AppletResourceTool.a);
        int r15 = RenderViewFactory.a;
        Context r16 = r13.getContext();
        String r17 = this.f;
        String r18 = "";
        if (r17 != null) goto L11;
        r17 = "";
    L11:
        ?? r19 = RenderViewFactory.a(r16, new q2.c(r17, false, null, null), null);
        h2.a r20 = f2.b.c;
        if (r20 == null) goto L17;
        String r21 = r20.m;
        if (r21 == null) goto L17;
        r18 = r21;
    L17:
        q r22 = q.a;
        Map r23 = q.c(r18);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r24 = AppletRuntimeManager.d;
        if (r24 != null) goto L20;
    L22:
        if (r0 == false) goto L24;
        String r1 = "dark";
    L25:
        r23.put("appTheme", r1);
        RenderUrlData r25 = this.d;
        if (r25 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r25 = null;
    L28:
        r23.put("queryItems", r25.e);
        r19.setGlobalProperties(r23);
        ((LinearLayout) r13.findViewById(2131367845)).addView(r19, new ViewGroup.LayoutParams(-1, -1));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new AnonymousClass2(r19, this, null), 3, null);
        this.e = r19;
        return r13;
    L24:
        r1 = "light";
        goto L25
    L20:
        if (r24.v(r13.getContext()) != true) goto L22;
        r0 = true;
        goto L22
    }
}
