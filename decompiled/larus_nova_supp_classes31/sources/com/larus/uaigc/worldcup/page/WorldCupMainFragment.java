package com.larus.uaigc.worldcup.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.impl.databinding.LarusFragmentSpringMainVenueBinding;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u000fJ\b\u0010!\u001a\u00020\u000fH\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\f\u0010(\u001a\u00020\u000f*\u00020)H\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Lcom/larus/uaigc/worldcup/page/WorldCupMainFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "inputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentSpringMainVenueBinding;", "mainVenueLynxAbility", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "getMainVenueLynxAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "mainVenueLynxAbility$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "autoLogEnterPage", "", "fragmentOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCurrentPageName", "", "onBackPressed", "quitPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "addSpringSpeakerView", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "bindToVContext", "attachComponent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WorldCupMainFragment extends TraceFragment {
    public static final /* synthetic */ int g = 0;
    public LarusFragmentSpringMainVenueBinding e;
    public final Lazy f;

    public static final class a implements m {
        public final /* synthetic */ WorldCupMainFragment a;

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

        public a(WorldCupMainFragment r1) {
            this.a = r1;
        }
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "world_cup_2026";
    }

    public WorldCupMainFragment() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onAttach(Context r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r19);
        de8.c r0 = new de8.c(getArguments(), getArguments(), true, null, null, false, null, null, null, null, false, false, null, 0, 32760);
        s1a.a.g(this).n(r0, de8.c.class);
        com.larus.uaigc.worldcup.component.a r1 = new com.larus.uaigc.worldcup.component.a(getArguments());
        s1a.a.g(this).n(r1, com.larus.uaigc.worldcup.component.a.class);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new com.larus.uaigc.worldcup.page.a(this));
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentSpringMainVenueBinding r4 = LarusFragmentSpringMainVenueBinding.a(r1, r2);
        this.e = r4;
        ChatConstraintLayout r5 = r4.d;
        if (r5 == null) goto L7;
        ViewStub r6 = (ViewStub) r5.findViewById(2131375364);
        if (r6 == null) goto L7;
        InputViewCreatorDelegate.b.g(r6);
    L7:
        s1a.a.g(this).c(new a(this), m.class);
        LarusFragmentSpringMainVenueBinding r7 = this.e;
        if (r7 != null) goto L12;
        return null;
    L12:
        return r7.g;
    }
}
