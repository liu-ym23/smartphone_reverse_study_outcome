package com.larus.uaigc.spring.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.impl.databinding.LarusFragmentSpringMainVenueBinding;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020\u0014H\u0002J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010-\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"J\f\u0010.\u001a\u00020\u0014*\u00020/H\u0002J\b\u00100\u001a\u00020\u0014H\u0002J\b\u00101\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u00062"}, d2 = {"Lcom/larus/uaigc/spring/page/SpringMainVenueFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "inputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentSpringMainVenueBinding;", "mainVenueLynxAbility", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "getMainVenueLynxAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "mainVenueLynxAbility$delegate", "Lkotlin/Lazy;", "mainVenueInputAbility", "Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "getMainVenueInputAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "mainVenueInputAbility$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "autoLogEnterPage", "", "fragmentOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCurrentPageName", "", "onBackPressed", "quitPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onUploadDigitalAvatarResult", "addSpringSpeakerView", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "bindToVContext", "attachComponent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMainVenueFragment extends TraceFragment {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentSpringMainVenueBinding e;
    public final Lazy f;
    public final Lazy g;

    public static final class a implements m {
        public final /* synthetic */ SpringMainVenueFragment a;

        public final Fragment getChatFragment() {
            return null;
        }

        public final l iX() {
            LarusFragmentSpringMainVenueBinding r0 = this.a.e;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new com.larus.uaigc.spring.page.a(r0);
        }

        public a(SpringMainVenueFragment r1) {
            this.a = r1;
        }
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "spring_guide_2026";
    }

    public SpringMainVenueFragment() {
        this.f = LazyKt.lazy(new b(this));
        this.g = LazyKt.lazy(new c(this));
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        IZLotteryService.a.q();
    }

    public final void onAttach(Context r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r19);
        de8.c r0 = new de8.c(getArguments(), getArguments(), true, null, null, false, null, null, null, null, false, false, null, 0, 32760);
        s1a.a.g(this).n(r0, de8.c.class);
        a0a.b r1 = new a0a.b(getArguments());
        s1a.a.g(this).n(r1, a0a.b.class);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new d(this));
        IZLotteryService.a.q();
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        LarusFragmentSpringMainVenueBinding r7 = LarusFragmentSpringMainVenueBinding.a(r4, r5);
        this.e = r7;
        ChatConstraintLayout r8 = r7.d;
        if (r8 == null) goto L7;
        ViewStub r9 = (ViewStub) r8.findViewById(2131375364);
        if (r9 == null) goto L7;
        InputViewCreatorDelegate.b.g(r9);
    L7:
        LarusFragmentSpringMainVenueBinding r10 = this.e;
        if (r10 == null) goto L12;
        ChatConstraintLayout r11 = r10.d;
        if (r11 == null) goto L12;
        View r12 = IAIChatUgcAIGCService.a.K(r11.getContext());
        r12.setId(2131387057);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = i5.h();
        r12.setLayoutParams(r1);
        e1.o(r12);
        r11.addView(r12);
        ConstraintSet r13 = new ConstraintSet();
        r13.clone(r11);
        r13.connect(2131387057, 4, 2131375324, 4);
        r13.applyTo(r11);
    L12:
        Context r14 = getContext();
        if (r14 == null) goto L19;
        LarusFragmentSpringMainVenueBinding r15 = this.e;
        if (r15 == null) goto L19;
        ChatConstraintLayout r16 = r15.d;
        if (r16 == null) goto L19;
        r16.k6(r14);
    L19:
        LarusFragmentSpringMainVenueBinding r17 = this.e;
        if (r17 == null) goto L24;
        ChatConstraintLayout r18 = r17.d;
        if (r18 == null) goto L24;
        r18.U5();
    L24:
        LarusFragmentSpringMainVenueBinding r19 = this.e;
        if (r19 == null) goto L33;
        ChatConstraintLayout r20 = r19.d;
        if (r20 == null) goto L33;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L32;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        r22.topMargin = 0;
        r22.bottomMargin = 0;
        r20.setLayoutParams(r22);
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L33:
        s1a.a.g(this).c(new a(this), m.class);
        LarusFragmentSpringMainVenueBinding r23 = this.e;
        if (r23 != null) goto L38;
        return null;
    L38:
        return r23.g;
    }
}
