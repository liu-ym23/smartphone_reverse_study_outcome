package com.bytedance.ai.applet.components.page;

import android.content.Context;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ar.a;
import com.bytedance.ai.applet.render.core.lynx.i;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.ai.lynx.k;
import com.bytedance.ai.model.p;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.utils.c;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
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
import kotlinx.coroutines.h0;
import org.json.JSONObject;
import t0.b;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/applet/components/page/RenderFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RenderFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderUrlData f1710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f1711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1712c;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.components.page.RenderFragment$onCreateView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.components.page.RenderFragment$onCreateView$2", f = "RenderFragment.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f1714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RenderFragment f1715c;

        public AnonymousClass2(i r5, RenderFragment r10, Continuation r11) {
            this.f1714b = r5;
            this.f1715c = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass2(this.f1714b, this.f1715c, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            i r11 = this.f1714b;
            RenderFragment r12 = this.f1715c;
            return new AnonymousClass2(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1713a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i r12 = this.f1714b;
            RenderUrlData r13 = this.f1715c.f1710a;
            if (r13 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("renderData");
            r13 = null;
        L11:
            String r14 = r13.d;
            this.f1713a = 1;
            if (r12.a(r14, new JSONObject(), this) != r10) goto L15;
            return r10;
        }
    }

    public RenderFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        RenderUrlData r10 = (RenderUrlData) requireArguments().getParcelable(Reflection.getOrCreateKotlinClass(RenderUrlData.class).getSimpleName());
        if (r10 == null) goto L11;
        this.f1710a = r10;
        StringBuilder r11 = new StringBuilder("onCreate: renderData = ");
        RenderUrlData r12 = this.f1710a;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r12 = null;
    L7:
        r11.append(r12);
        String r13 = r11.toString();
        Intrinsics.checkNotNullParameter("RenderFragment", "tag");
        d r14 = c.f2846a;
        if (r14 == null) goto L18;
        r14.d("RenderFragment", r13);
        return;
    L18:
        return;
    L11:
        Intrinsics.checkNotNullParameter("RenderFragment", "tag");
        d r15 = c.f2846a;
        if (r15 == null) goto L14;
        r15.e("RenderFragment", "onCreate: renderData arguments null");
    L14:
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L19;
        r16.finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(R$layout.applet_fragment_full_page, r11, false);
        RenderUrlData r14 = this.f1710a;
        if (r14 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r14 = null;
    L6:
        if (r14.f1718c == false) goto L8;
        r13.findViewById(R$id.title_bar).setVisibility(8);
        r13.findViewById(R$id.divider).setVisibility(8);
    L8:
        r13.findViewById(R$id.btn_close).setOnClickListener(new a(this, 4));
        LruCache r15 = e0.f2711a;
        this.f1712c = IIvyAIPackageResourceService.Companion.openSession(null);
        Context r16 = r13.getContext();
        String r5 = this.f1712c;
        String r17 = "";
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        i r18 = com.bytedance.ai.applet.components.view.c.a(r16, new q7.a(r5, null), null);
        u0.a r19 = s0.a.f21800c;
        if (r19 == null) goto L17;
        String r20 = r19.f22202m;
        if (r20 == null) goto L17;
        r17 = r20;
    L17:
        Map r21 = k.b(r17);
        b r22 = p.f2294c;
        if (r22 != null) goto L20;
    L22:
        String r23 = WidgetView.UI_MODE_LIGHT;
    L23:
        r21.put("appTheme", r23);
        RenderUrlData r24 = this.f1710a;
        if (r24 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("renderData");
        r24 = null;
    L26:
        r21.put("queryItems", r24.e);
        r18.setGlobalProperties(r21);
        ((LinearLayout) r13.findViewById(R$id.content_parent)).addView(r18, new ViewGroup.LayoutParams(-1, -1));
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new AnonymousClass2(r18, this, null), 3, null);
        this.f1711b = r18;
        return r13;
    L20:
        if (r22.isDarkMode() != true) goto L22;
        r23 = WidgetView.UI_MODE_DARK;
        goto L23
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        i r5 = this.f1711b;
        if (r5 == null) goto L5;
        r5.destroy();
        this.f1711b = null;
    L5:
        String r10 = this.f1712c;
        if (r10 == null) goto L8;
        e0.j(r10);
        this.f1712c = null;
    L8:
        super.onDestroyView();
    }
}
