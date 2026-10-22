package com.larus.community.impl.publish;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishFragmentLayoutBinding;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010-H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/impl/publish/ability/ICreationPublishAbility;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishFragmentLayoutBinding;", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "publisherTrackParams", "Lcom/larus/platform/api/creation/PublisherTrackParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "autoLogEnterPage", "", "getCurrentPageName", "", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "updateInset", "publish", "getCreationTaskId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePublishSuccess", "it", "Lcom/larus/platform/api/creation/UserCreation;", "findRouteActivityBelowPublish", "Landroidx/fragment/app/FragmentActivity;", "currentActivity", "Landroid/app/Activity;", "hideKeyboard", "activity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishFragment extends TraceFragment implements n29.a {
    public static final /* synthetic */ int h = 0;
    public LarusCommunityCreationPublishFragmentLayoutBinding e;
    public final Lazy f;
    public PublisherTrackParams g;

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "publish_creation_page";
    }

    @Override // n29.a
    public final void Hb() {
        LarusCommunityCreationPublishFragmentLayoutBinding r0 = this.e;
        if (r0 == null) goto L8;
        ChatConstraintLayout r1 = r0.b;
        if (r1 == null) goto L9;
        r1.post(new e(this));
        return;
    L9:
        return;
    }

    public final CreationPublishViewModel V90() {
        return (CreationPublishViewModel) this.f.getValue();
    }

    public CreationPublishFragment() {
        final Function0<Fragment> r0 = new CreationPublishFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CreationPublishViewModel.class), new CreationPublishFragment$special$$inlined$viewModels$default$2(r0), new CreationPublishFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    @Override // n29.a
    public final void JM() {
        n29.c r0 = (n29.c) s1a.a.g(this).getAbility(n29.c.class);
        int r1 = 1;
        if (r0 == null) goto L5;
        ?? r6 = r0.d30();
    L6:
        n29.c r2 = (n29.c) s1a.a.g(this).getAbility(n29.c.class);
        String r3 = null;
        if (r2 == null) goto L9;
        Integer r8 = r2.o30();
    L10:
        n29.b r4 = (n29.b) s1a.a.g(this).getAbility(n29.b.class);
        if (r4 == null) goto L14;
        String r5 = r4.CY();
        if (r5 == null) goto L14;
    L15:
        String r7 = r5;
        n29.b r9 = (n29.b) s1a.a.g(this).getAbility(n29.b.class);
        if (r9 == null) goto L18;
        int r10 = r9.Uy();
    L19:
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L30;
        View r12 = r11.getCurrentFocus();
        if (r12 == null) goto L30;
        Object r13 = r11.getSystemService("input_method");
        if ((r13 instanceof InputMethodManager) == false) goto L27;
        InputMethodManager r14 = (InputMethodManager) r13;
    L28:
        if (r14 == null) goto L30;
        r14.hideSoftInputFromWindow(r12.getWindowToken(), 0);
        goto L30
    L27:
        r14 = null;
    L30:
        V90().publish(r6, r7);
        com.larus.community.impl.publish.viewmodel.h r15 = (com.larus.community.impl.publish.viewmodel.h) V90().getPublisherCreationFlow().getValue();
        if (r15 == null) goto L33;
        PublisherCreation r16 = r15.a;
    L34:
        if (r16 == null) goto L38;
        Integer r17 = r16.getCreationType();
        if (r17 == null) goto L38;
        String r18 = zp9.y.a(r17.intValue());
    L39:
        if (r16 == null) goto L41;
        String r20 = r16.getCreationId();
    L42:
        if (r16 == null) goto L44;
        boolean r110 = Intrinsics.areEqual(r16.getCanvasMode(), Boolean.TRUE);
    L45:
        if (r110 == false) goto L47;
        String r111 = String.valueOf(r16.getCanvasSubId());
    L50:
        if (r16 == null) goto L54;
        Integer r112 = r16.getCreationType();
        if (r112 == null) goto L54;
        r3 = zp9.y.b(r112.intValue());
    L54:
        boolean r113 = o0.d(r7);
        Integer r114 = Integer.valueOf(r10);
        JSONObject r115 = new JSONObject();
        Intrinsics.checkNotNullParameter(r115, "params");
        r115.putOpt("sub_type", r18);     // Catch: JSONException -> L63
        r115.putOpt("creation_id", r20);     // Catch: JSONException -> L63
        r115.putOpt("message_id", r111);     // Catch: JSONException -> L63
        r115.putOpt("type", r3);     // Catch: JSONException -> L63
        if (r113 == true) goto L59;
        r1 = 0;
    L59:
        r115.putOpt("is_has_caption", Integer.valueOf(r1));     // Catch: JSONException -> L63
        r115.putOpt("caption_length", r114);     // Catch: JSONException -> L63
        r115.putOpt("is_image_reference_public", Integer.valueOf(r6));     // Catch: JSONException -> L63
        if (r8 == null) goto L65;
        r115.put("image_reference_cnt", r8.intValue());     // Catch: JSONException -> L63
    L65:
        TrackParams r21 = new TrackParams().merge(r115);
        by7.a r22 = new by7.a("complete_public_creation");
        r22.a.merge(r21);
        r22.b();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishFragment$publish$1(this, r16, r7, r6, r10, r8, null), 3, null);
        return;
    L63:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobCompletePublicCreation " + e.getLocalizedMessage());
        goto L65
    L47:
        if (r16 == null) goto L49;
        r111 = r16.getMessageId();
        goto L50
    L49:
        r111 = null;
        goto L50
    L44:
        r110 = false;
        goto L45
    L41:
        r20 = null;
    L38:
        r18 = null;
        goto L39
    L33:
        r16 = null;
        goto L34
    L18:
        r10 = 0;
    L14:
        r5 = "";
        goto L15
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = 1;
        goto L6
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        PublisherTrackParams r0 = this.g;
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r20) {
        super.onCreate(r20);
        CreationPublishViewModel r0 = V90();
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        PublisherCreation r2 = (PublisherCreation) r1.getParcelable("key_publish_creation");
        if (r2 == null) goto L6;
    L7:
        r0.initialize(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        PublisherTrackParams r4 = (PublisherTrackParams) r3.getParcelable("key_publish_tracker_params");
    L11:
        this.g = r4;
        return;
    L10:
        r4 = null;
    L6:
        r2 = new PublisherCreation(null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
        goto L7
    }

    public static final Object U90(CreationPublishFragment r6, Continuation r7) {
        r6.getClass();
        if ((r7 instanceof CreationPublishFragment$getCreationTaskId$1) == false) goto L7;
        CreationPublishFragment$getCreationTaskId$1 r0 = (CreationPublishFragment$getCreationTaskId$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PublisherCreation r9 = (PublisherCreation) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L37:
        String r10 = (String) r8;
        if (r10 == null) goto L41;
        r4 = r10;
    L41:
        Iterator r11 = ((LinkedHashMap) DataConverterKt.d(r4)).entrySet().iterator();
    L43:
        if (r11.hasNext() == false) goto L51;
        Object r5 = r11.next();
        String r12 = ((UserCreationFromIM) ((Map.Entry) r5).getValue()).getCreationId();
        if (r9 == null) goto L47;
        String r13 = r9.getCreationId();
    L49:
        if (Intrinsics.areEqual(r12, r13) == false) goto L43;
    L52:
        Map.Entry r14 = (Map.Entry) r5;
        if (r14 == null) goto L56;
        return (String) r14.getKey();
    L56:
        return null;
    L47:
        r13 = null;
        goto L49
    L51:
        r5 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        com.larus.community.impl.publish.viewmodel.h r15 = (com.larus.community.impl.publish.viewmodel.h) r6.V90().getPublisherCreationFlow().getValue();
        if (r15 == null) goto L17;
        r9 = r15.a;
    L18:
        if (r9 == null) goto L20;
        String r16 = r9.getTaskId();
    L21:
        if (r16 != null) goto L23;
    L26:
        boolean r17 = true;
    L27:
        if (r17 == false) goto L60;
        IChatRepoService r18 = RepoDispatcherDelegate.b.e();
        if (r9 == null) goto L33;
        String r20 = r9.getMessageId();
        if (r20 == null) goto L33;
    L34:
        r0.L$0 = r9;
        r0.label = 1;
        r8 = r18.w1(r20, r0);
        if (r8 != r2) goto L37;
        return r2;
    L33:
        r20 = "";
        goto L34
    L60:
        return r9.getTaskId();
    L23:
        if (r16.length() == 0) goto L26;
        r17 = false;
        goto L27
    L20:
        r16 = null;
        goto L21
    L17:
        r9 = null;
    L7:
        r0 = new CreationPublishFragment$getCreationTaskId$1(r6, r7);
        goto L8
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Context r9 = getContext();
        if (r9 == null) goto L19;
        LarusCommunityCreationPublishFragmentLayoutBinding r10 = this.e;
        if (r10 == null) goto L9;
        ChatConstraintLayout r11 = r10.a;
        if (r11 == null) goto L9;
        r11.setDisableTopPadding(true);
    L9:
        LarusCommunityCreationPublishFragmentLayoutBinding r12 = this.e;
        if (r12 == null) goto L14;
        ChatConstraintLayout r13 = r12.a;
        if (r13 == null) goto L14;
        r13.setDisableBottomPadding(true);
    L14:
        LarusCommunityCreationPublishFragmentLayoutBinding r14 = this.e;
        if (r14 == null) goto L19;
        ChatConstraintLayout r15 = r14.a;
        if (r15 == null) goto L19;
        r15.k6(r9);
    L19:
        s1a.a.a(this, this, n29.a.class);
        k1a.b.a(this, new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishFragment$initView$2(this, null), 3, null);
        LarusCommunityCreationPublishFragmentLayoutBinding r16 = this.e;
        if (r16 == null) goto L25;
        ChatConstraintLayout r17 = r16.b;
        if (r17 == null) goto L26;
        e1.d(r17, new d());
        return;
    L26:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ChatConstraintLayout r7 = getLayoutInflater().inflate(2131561965, r5, false);
        int r8 = 2131364480;
        if (ViewBindings.findChildViewById(r7, 2131364480) == null) goto L22;
        ChatConstraintLayout r9 = r7;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131368232);
        if (r0 == null) goto L20;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131368267);
        if (r1 != null) goto L9;
        r8 = 2131368267;
        goto L22
    L9:
        if (((ImageAdjustView) ViewBindings.findChildViewById(r7, 2131368271)) != null) goto L11;
        r8 = 2131368271;
        goto L22
    L11:
        if (ViewBindings.findChildViewById(r7, 2131383423) != null) goto L13;
        r8 = 2131383423;
        goto L22
    L13:
        if (ViewBindings.findChildViewById(r7, 2131388881) == null) goto L16;
        this.e = new LarusCommunityCreationPublishFragmentLayoutBinding(r9, r9, r0, r1);
        return r9;
    L16:
        r8 = 2131388881;
        goto L22
    L20:
        r8 = 2131368232;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
