package com.larus.community.impl.update;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.community.impl.databinding.LarusCommunityDialogCreationLlmUpdateBinding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.settings.provider.creation.BackgroundConfig;
import com.larus.settings.provider.creation.ButtonConfig;
import com.larus.settings.provider.creation.ColorConfig;
import com.larus.settings.provider.creation.CreationUpdateDialogItemConfig;
import com.larus.settings.provider.creation.DescriptionConfig;
import com.larus.settings.provider.creation.MediaConfig;
import com.larus.settings.provider.creation.TitleConfig;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.w0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u001d\u001a\u00020\u001426\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fJ\u0010\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\u001a\u00100\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010'2\u0006\u00101\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/community/impl/update/CreationLLMUpdateDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityDialogCreationLlmUpdateBinding;", "configItem", "Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "clickButtonDoNothing", "", "enterMethod", "", "botId", "clickFrom", "clickOpenCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "enterAlbum", "prompt", "", "clickListener", "Lcom/larus/platform/api/creation/ICreationUpdateDialogListener;", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "Lkotlin/Lazy;", "setClickOpenCallback", "callback", "setClickListener", "listener", "getTheme", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "checkDialog", "checkWidth", "setClipViewTopCornerRadius", "radius", "initView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onResume", "onPause", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isMute", "initMuteIcon", "showMute", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLLMUpdateDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusCommunityDialogCreationLlmUpdateBinding d;
    public CreationUpdateDialogItemConfig e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public final Lazy j;
    public boolean k;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BottomSheetBehavior<ViewGroup> a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(BottomSheetBehavior<ViewGroup> r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L6;
            this.a.setState(4);
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public CreationLLMUpdateDialog() {
        this.g = "";
        this.h = "";
        this.i = "white";
        this.j = LazyKt.lazy(new d());
        this.k = true;
    }

    public final void S90() {
        BottomSheetDialog r0 = getDialog();
        String r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        ViewGroup r3 = (ViewGroup) r1.findViewById(2131368870);
    L9:
        int r4 = m0.a;
        int r5 = m0.a(getContext());
        i0.a.getClass();
        int r6 = (r5 - i0.g()) - i0.e();
        if (r3 == null) goto L12;
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
        r7.height = r6;
        r3.setLayoutParams(r7);
        BottomSheetBehavior r8 = BottomSheetBehavior.from(r3);
        r3.setBackgroundResource(R.color.transparent);
        r8.setState(3);
        r8.setPeekHeight(r6);
        r8.setBottomSheetCallback(new b(r8));
    L12:
        CreationUpdateDialogItemConfig r9 = this.e;
        if (r9 == null) goto L42;
        boolean r10 = v19.h.a;
        if (v19.h.a(null) == false) goto L29;
        BackgroundConfig r11 = r9.a();
        if (r11 == null) goto L24;
        ColorConfig r12 = r11.a();
        if (r12 == null) goto L24;
        String r13 = r12.a();
        if (r13 == null) goto L24;
        r2 = r13;
    L34:
        if (r2 == null) goto L36;
        int r14 = ColorProtector.parseColor(r2);
    L37:
        if (r1 == null) goto L43;
        Window r15 = r1.getWindow();
        if (r15 == null) goto L44;
        r15.setNavigationBarColor(r14);
        r15.addFlags(Integer.MIN_VALUE);
        r15.clearFlags(134217728);
        return;
    L44:
        return;
    L43:
        return;
    L36:
        r14 = ContextCompat.getColor(AppHost.a.getApplication(), 2131102539);
    L24:
        BackgroundConfig r16 = r9.a();
        if (r16 == null) goto L34;
        ColorConfig r17 = r16.a();
        if (r17 == null) goto L34;
        r2 = r17.b();
        goto L34
    L29:
        BackgroundConfig r18 = r9.a();
        if (r18 == null) goto L34;
        ColorConfig r20 = r18.a();
        if (r20 == null) goto L34;
        r2 = r20.b();
        goto L34
    L42:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void T90() {
        Context r0 = getContext();
        if (r0 == null) goto L87;
        float r1 = c7.d(Integer.valueOf(com.larus.utils.i.d(r0)));
        boolean r2 = m29.a.a;
        m29.a.c("CreationLLMUpdateDialog", "screenWidth dp: " + r1);
        CreationUpdateDialogItemConfig r3 = this.e;
        if (r3 == null) goto L11;
        MediaConfig r4 = r3.g();
        if (r4 == null) goto L11;
        Float r5 = r4.e();
        if (r5 == null) goto L11;
        float r6 = r5.floatValue();
    L12:
        ConstraintLayout r7 = null;
        if (r1 > 480.0f) goto L15;
        LarusCommunityDialogCreationLlmUpdateBinding r8 = this.d;
        if (r8 == null) goto L63;
        ConstraintLayout r9 = r8.d;
        if (r9 == null) goto L63;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof FrameLayout.LayoutParams) == false) goto L58;
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
    L59:
        if (r11 == null) goto L61;
        r11.width = -1;
        r11.gravity = 80;
    L62:
        r9.setLayoutParams(r11);
        goto L63
    L61:
        r11 = null;
        goto L62
    L58:
        r11 = null;
    L63:
        LarusCommunityDialogCreationLlmUpdateBinding r12 = this.d;
        if (r12 == null) goto L75;
        VideoPlayView r13 = r12.j;
        if (r13 == null) goto L75;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L70;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
    L71:
        if (r15 == null) goto L73;
        int r16 = m0.a;
        AppHost.Companion r17 = AppHost.a;
        ((ViewGroup.MarginLayoutParams) r15).width = m0.c(r17.getApplication());
        ((ViewGroup.MarginLayoutParams) r15).height = (int) (m0.c(r17.getApplication()) / r6);
    L74:
        r13.setLayoutParams(r15);
        goto L75
    L73:
        r15 = null;
        goto L74
    L70:
        r15 = null;
    L75:
        LarusCommunityDialogCreationLlmUpdateBinding r18 = this.d;
        if (r18 == null) goto L80;
        SimpleDraweeView r20 = r18.f;
        if (r20 == null) goto L80;
        r20.setAspectRatio(r6);
    L80:
        LarusCommunityDialogCreationLlmUpdateBinding r21 = this.d;
        if (r21 == null) goto L83;
        r7 = r21.d;
    L83:
        int r22 = i5.q();
        if (r7 == null) goto L89;
        r7.setOutlineProvider(new g(r22));
        r7.setClipToOutline(true);
        return;
    L89:
        return;
    L15:
        if (r1 <= c7.d(Integer.valueOf(com.larus.utils.i.c(r0)))) goto L17;
        float r23 = 0.8f;
    L18:
        LarusCommunityDialogCreationLlmUpdateBinding r24 = this.d;
        if (r24 == null) goto L30;
        ConstraintLayout r25 = r24.d;
        if (r25 == null) goto L30;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if ((r26 instanceof FrameLayout.LayoutParams) == false) goto L25;
        FrameLayout.LayoutParams r27 = (FrameLayout.LayoutParams) r26;
    L26:
        if (r27 == null) goto L28;
        int r28 = CircleProgressBarView.k;
        r27.width = (int) CircleProgressBarView.a.a(r0, r23 * 480.0f);
        r27.gravity = 17;
    L29:
        r25.setLayoutParams(r27);
        goto L30
    L28:
        r27 = null;
        goto L29
    L25:
        r27 = null;
    L30:
        LarusCommunityDialogCreationLlmUpdateBinding r30 = this.d;
        if (r30 == null) goto L42;
        VideoPlayView r31 = r30.j;
        if (r31 == null) goto L42;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if ((r32 instanceof ConstraintLayout.LayoutParams) == false) goto L37;
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
    L38:
        if (r33 == null) goto L40;
        int r34 = CircleProgressBarView.k;
        float r35 = r23 * 480.0f;
        ((ViewGroup.MarginLayoutParams) r33).width = (int) CircleProgressBarView.a.a(r0, r35);
        ((ViewGroup.MarginLayoutParams) r33).height = (int) (CircleProgressBarView.a.a(r0, r35) / r6);
    L41:
        r31.setLayoutParams(r33);
        goto L42
    L40:
        r33 = null;
        goto L41
    L37:
        r33 = null;
    L42:
        LarusCommunityDialogCreationLlmUpdateBinding r36 = this.d;
        if (r36 == null) goto L47;
        SimpleDraweeView r37 = r36.f;
        if (r37 == null) goto L47;
        r37.setAspectRatio(r6);
    L47:
        LarusCommunityDialogCreationLlmUpdateBinding r38 = this.d;
        if (r38 == null) goto L50;
        r7 = r38.d;
    L50:
        w0.e(r7, i5.q());
        return;
    L17:
        r23 = 1.0f;
    L11:
        r6 = 1.21875f;
        goto L12
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        CreationUpdateDialogItemConfig r0 = this.e;
        if (r0 == null) goto L33;
        boolean r1 = v19.h.a;
        String r2 = null;
        if (v19.h.a(null) == false) goto L19;
        BackgroundConfig r3 = r0.a();
        if (r3 == null) goto L14;
        ColorConfig r4 = r3.a();
        if (r4 == null) goto L14;
        String r5 = r4.a();
        if (r5 == null) goto L14;
        r2 = r5;
    L24:
        if (r2 == null) goto L26;
        int r6 = ColorProtector.parseColor(r2);
    L27:
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L34;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L35;
        r8.setNavigationBarColor(r6);
        return;
    L35:
        return;
    L34:
        return;
    L26:
        r6 = ContextCompat.getColor(AppHost.a.getApplication(), 2131102539);
    L14:
        BackgroundConfig r9 = r0.a();
        if (r9 == null) goto L24;
        ColorConfig r10 = r9.a();
        if (r10 == null) goto L24;
        r2 = r10.b();
        goto L24
    L19:
        BackgroundConfig r11 = r0.a();
        if (r11 == null) goto L24;
        ColorConfig r12 = r11.a();
        if (r12 == null) goto L24;
        r2 = r12.b();
        goto L24
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void U90(DialogInterface r7) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        String r0 = this.g;
        CreationUpdateDialogItemConfig r1 = this.e;
        if (r1 == null) goto L7;
        Integer r2 = r1.e();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L8:
        String r4 = this.h;
        String r5 = this.i;
        JSONObject r6 = new JSONObject();
        r6.putOpt(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r0);     // Catch: JSONException -> L11
        r6.putOpt("action_bar_template_id", r3);     // Catch: JSONException -> L11
        r6.putOpt("bot_id", r4);     // Catch: JSONException -> L11
        r6.putOpt("click_from", r5);     // Catch: JSONException -> L11
    L13:
        TrackParams r8 = new TrackParams().merge(r6);
        by7.a r9 = new by7.a("ai_creation_guidance_window_click");
        r9.a.merge(r8);
        r9.b();
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r7);
        return;
    L11:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobAICreationGuidanceWindowClick " + e.getLocalizedMessage());
    L7:
        r3 = null;
        goto L8
    }

    public final void V90(boolean r2) {
        if (r2 == false) goto L22;
        LarusCommunityDialogCreationLlmUpdateBinding r3 = this.d;
        if (r3 == null) goto L8;
        ImageView r4 = r3.g;
        if (r4 == null) goto L8;
        e1.x(r4);
    L8:
        LarusCommunityDialogCreationLlmUpdateBinding r5 = this.d;
        if (r5 == null) goto L17;
        ImageView r6 = r5.g;
        if (r6 == null) goto L17;
        if (this.k == false) goto L15;
        int r0 = 2131240161;
    L16:
        r6.setImageResource(r0);
        goto L17
    L15:
        r0 = 2131240162;
    L17:
        LarusCommunityDialogCreationLlmUpdateBinding r7 = this.d;
        if (r7 == null) goto L28;
        ImageView r8 = r7.g;
        if (r8 == null) goto L29;
        e1.d(r8, new f(this));
        return;
    L29:
        return;
    L28:
        return;
    L22:
        LarusCommunityDialogCreationLlmUpdateBinding r9 = this.d;
        if (r9 == null) goto L31;
        ImageView r10 = r9.g;
        if (r10 == null) goto L32;
        e1.o(r10);
        return;
    L32:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        LarusCommunityDialogCreationLlmUpdateBinding r3 = this.d;
        if (r3 == null) goto L8;
        FrameLayout r4 = r3.h;
        if (r4 == null) goto L9;
        r4.post(new e(this));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        CreationUpdateDialogItemConfig r0 = null;
        if (r4 == null) goto L5;
        CreationUpdateDialogItemConfig r5 = (CreationUpdateDialogItemConfig) r4.getParcelable("key_update_config_item");
    L7:
        if ((r5 instanceof CreationUpdateDialogItemConfig) == false) goto L9;
        r0 = r5;
    L9:
        this.e = r0;
        Bundle r6 = getArguments();
        if (r6 == null) goto L12;
        boolean r7 = r6.getBoolean("key_click_button_do_nothing");
    L13:
        this.f = r7;
        Bundle r8 = getArguments();
        String r1 = "";
        if (r8 == null) goto L17;
        String r9 = r8.getString("key_enter_method");
        if (r9 == null) goto L17;
    L18:
        this.g = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L24;
        String r11 = r10.getString("key_bot_id");
        if (r11 == null) goto L24;
        r1 = r11;
    L24:
        this.h = r1;
        return;
    L17:
        r9 = "";
        goto L18
    L12:
        r7 = false;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public final void onDismiss(DialogInterface r2) {
        U90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r110);
        S90();
        T90();
        LarusCommunityDialogCreationLlmUpdateBinding r0 = this.d;
        if (r0 == null) goto L7;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L7;
        e1.d(r1, new com.larus.community.impl.update.a(this));
    L7:
        final CreationUpdateDialogItemConfig r2 = this.e;
        String r3 = null;
        if (r2 == null) goto L274;
        boolean r4 = v19.h.a;
        if (v19.h.a(null) == false) goto L22;
        BackgroundConfig r5 = r2.a();
        if (r5 == null) goto L17;
        ColorConfig r6 = r5.a();
        if (r6 == null) goto L17;
        String r7 = r6.a();
        if (r7 == null) goto L17;
    L28:
        if (r7 == null) goto L30;
        int r8 = ColorProtector.parseColor(r7);
    L31:
        LarusCommunityDialogCreationLlmUpdateBinding r9 = this.d;
        if (r9 == null) goto L36;
        ConstraintLayout r10 = r9.d;
        if (r10 == null) goto L36;
        r10.setBackgroundColor(r8);
    L36:
        MediaConfig r11 = r2.g();
        boolean r12 = false;
        if (r11 != null) goto L39;
    L41:
        boolean r13 = false;
    L42:
        if (r13 == false) goto L69;
        LarusCommunityDialogCreationLlmUpdateBinding r14 = this.d;
        if (r14 == null) goto L63;
        SimpleDraweeView r15 = r14.f;
        if (r15 == null) goto L63;
        if (v19.h.a(null) == false) goto L56;
        MediaConfig r16 = r2.g();
        if (r16 == null) goto L53;
        String r17 = r16.a();
        if (r17 == null) goto L53;
    L60:
        if (r17 != null) goto L62;
        r17 = r2.d();
    L62:
        ImageLoaderKt.y(r15, r17, "CreationLLMUpdateDialog", new com.larus.community.impl.update.b(), 4);
    L53:
        MediaConfig r20 = r2.g();
        if (r20 == null) goto L59;
        r17 = r20.c();
    L59:
        r17 = null;
        goto L60
    L56:
        MediaConfig r21 = r2.g();
        if (r21 == null) goto L59;
        r17 = r21.c();
    L63:
        LarusCommunityDialogCreationLlmUpdateBinding r22 = this.d;
        if (r22 == null) goto L68;
        VideoPlayView r23 = r22.j;
        if (r23 == null) goto L68;
        e1.o(r23);
    L68:
        V90(false);
    L134:
        LarusCommunityDialogCreationLlmUpdateBinding r24 = this.d;
        if (r24 == null) goto L175;
        TextView r25 = r24.i;
        if (r25 == null) goto L175;
        TitleConfig r26 = r2.h();
        if (r26 == null) goto L141;
        String r27 = r26.c();
    L142:
        r25.setText(r27);
        TitleConfig r28 = r2.h();
        if (r28 == null) goto L153;
        int r30 = r28.a();
        if (r30 == 0) goto L151;
        if (r30 == 1) goto L150;
        if (r30 == 2) goto L149;
        r25.setGravity(17);
        goto L153
    L149:
        r25.setGravity(8388613);
        goto L153
    L150:
        r25.setGravity(17);
        goto L153
    L151:
        r25.setGravity(8388611);
    L153:
        if (v19.h.a(null) == false) goto L165;
        TitleConfig r31 = r2.h();
        if (r31 == null) goto L160;
        ColorConfig r32 = r31.b();
        if (r32 == null) goto L160;
        String r33 = r32.a();
        if (r33 == null) goto L160;
    L171:
        if (r33 == null) goto L173;
        int r34 = ColorProtector.parseColor(r33);
    L174:
        r25.setTextColor(r34);
        goto L175
    L173:
        r34 = ContextCompat.getColor(AppHost.a.getApplication(), 2131103136);
    L160:
        TitleConfig r35 = r2.h();
        if (r35 == null) goto L170;
        ColorConfig r36 = r35.b();
        if (r36 == null) goto L170;
        r33 = r36.b();
    L170:
        r33 = null;
        goto L171
    L165:
        TitleConfig r37 = r2.h();
        if (r37 == null) goto L170;
        ColorConfig r38 = r37.b();
        if (r38 == null) goto L170;
        r33 = r38.b();
        goto L171
    L141:
        r27 = null;
    L175:
        LarusCommunityDialogCreationLlmUpdateBinding r40 = this.d;
        if (r40 == null) goto L216;
        TextView r41 = r40.e;
        if (r41 == null) goto L216;
        DescriptionConfig r42 = r2.c();
        if (r42 == null) goto L182;
        String r43 = r42.c();
    L183:
        r41.setText(r43);
        DescriptionConfig r44 = r2.c();
        if (r44 == null) goto L194;
        int r45 = r44.a();
        if (r45 == 0) goto L192;
        if (r45 == 1) goto L191;
        if (r45 == 2) goto L190;
        r41.setGravity(17);
        goto L194
    L190:
        r41.setGravity(8388613);
        goto L194
    L191:
        r41.setGravity(17);
        goto L194
    L192:
        r41.setGravity(8388611);
    L194:
        if (v19.h.a(null) == false) goto L206;
        DescriptionConfig r46 = r2.c();
        if (r46 == null) goto L201;
        ColorConfig r47 = r46.b();
        if (r47 == null) goto L201;
        String r48 = r47.a();
        if (r48 == null) goto L201;
    L212:
        if (r48 == null) goto L214;
        int r50 = ColorProtector.parseColor(r48);
    L215:
        r41.setTextColor(r50);
        goto L216
    L214:
        r50 = ContextCompat.getColor(AppHost.a.getApplication(), 2131103146);
    L201:
        DescriptionConfig r51 = r2.c();
        if (r51 == null) goto L211;
        ColorConfig r52 = r51.b();
        if (r52 == null) goto L211;
        r48 = r52.b();
    L211:
        r48 = null;
        goto L212
    L206:
        DescriptionConfig r53 = r2.c();
        if (r53 == null) goto L211;
        ColorConfig r54 = r53.b();
        if (r54 == null) goto L211;
        r48 = r54.b();
        goto L212
    L182:
        r43 = null;
    L216:
        LarusCommunityDialogCreationLlmUpdateBinding r55 = this.d;
        if (r55 == null) goto L269;
        TextView r56 = r55.b;
        if (r56 == null) goto L269;
        ButtonConfig r57 = r2.b();
        if (r57 == null) goto L223;
        String r58 = r57.b();
    L224:
        r56.setText(r58);
        if (v19.h.a(null) == false) goto L237;
        ButtonConfig r60 = r2.b();
        if (r60 == null) goto L232;
        ColorConfig r61 = r60.c();
        if (r61 == null) goto L232;
        String r62 = r61.a();
        if (r62 == null) goto L232;
    L243:
        if (r62 == null) goto L245;
        int r63 = ColorProtector.parseColor(r62);
    L246:
        r56.setTextColor(r63);
        if (v19.h.a(null) == false) goto L259;
        ButtonConfig r64 = r2.b();
        if (r64 == null) goto L254;
        ColorConfig r65 = r64.a();
        if (r65 == null) goto L254;
        String r66 = r65.a();
        if (r66 == null) goto L254;
    L265:
        if (r66 == null) goto L267;
        int r67 = ColorProtector.parseColor(r66);
    L268:
        int r68 = w0.a;
        r56.setBackground(w0.b(Integer.valueOf(r67), Float.valueOf(i5.q()), 0.0f, null, 12));
        e1.d(r56, new c(this, r2));
        goto L269
    L267:
        r67 = ContextCompat.getColor(AppHost.a.getApplication(), 2131103203);
    L254:
        ButtonConfig r70 = r2.b();
        if (r70 == null) goto L264;
        ColorConfig r71 = r70.a();
        if (r71 == null) goto L264;
        r66 = r71.b();
    L264:
        r66 = null;
        goto L265
    L259:
        ButtonConfig r72 = r2.b();
        if (r72 == null) goto L264;
        ColorConfig r73 = r72.a();
        if (r73 == null) goto L264;
        r66 = r73.b();
        goto L265
    L245:
        r63 = ContextCompat.getColor(AppHost.a.getApplication(), 2131103298);
    L232:
        ButtonConfig r74 = r2.b();
        if (r74 == null) goto L242;
        ColorConfig r75 = r74.c();
        if (r75 == null) goto L242;
        r62 = r75.b();
    L242:
        r62 = null;
        goto L243
    L237:
        ButtonConfig r76 = r2.b();
        if (r76 == null) goto L242;
        ColorConfig r77 = r76.c();
        if (r77 == null) goto L242;
        r62 = r77.b();
        goto L243
    L223:
        r58 = null;
    L269:
        CreationUpdateDialogItemConfig r78 = this.e;
        if (r78 == null) goto L274;
        Integer r80 = r78.e();
        if (r80 == null) goto L274;
        IAIChatUgcAIGCService.a.A0(r80.intValue());
        goto L274
    L69:
        LarusCommunityDialogCreationLlmUpdateBinding r81 = this.d;
        if (r81 == null) goto L123;
        VideoPlayView r82 = r81.j;
        if (r82 == null) goto L123;
        r82.setIsMuted(true);
        r82.setBackgroundColor(r8);
        r82.setEnabled(false);
        r82.setBanInnerDismiss(true);
        if (v19.h.a(null) == false) goto L82;
        MediaConfig r83 = r2.g();
        if (r83 == null) goto L79;
        String r84 = r83.a();
        if (r84 == null) goto L79;
    L87:
        if (v19.h.a(null) == false) goto L95;
        MediaConfig r85 = r2.g();
        if (r85 == null) goto L92;
        String r86 = r85.b();
        if (r86 == null) goto L92;
    L98:
        String r87 = r86;
    L100:
        VideoPlayView.e(r82, (IVideoController) this.j.getValue(), r87, null, null, null, null, 60);
        LarusCommunityDialogCreationLlmUpdateBinding r88 = this.d;
        if (r88 == null) goto L107;
        VideoPlayView r90 = r88.j;
        if (r90 == null) goto L107;
        ViewGroup.LayoutParams r91 = r90.getLayoutParams();
        if (r91 == null) goto L107;
        Integer r111 = Integer.valueOf(r91.width);
    L108:
        LarusCommunityDialogCreationLlmUpdateBinding r92 = this.d;
        if (r92 == null) goto L115;
        VideoPlayView r93 = r92.j;
        if (r93 == null) goto L115;
        ViewGroup.LayoutParams r94 = r93.getLayoutParams();
        if (r94 == null) goto L115;
        Integer r112 = Integer.valueOf(r94.height);
    L116:
        VideoPlayView.p(r82, r84, r84, null, r112, r111, null, null, null, 228);
        MediaConfig r95 = r2.g();
        if (r95 == null) goto L121;
        Boolean r96 = r95.h();
        if (r96 == null) goto L121;
        boolean r97 = r96.booleanValue();
    L122:
        this.k = r97;
        r82.setIsMuted(r97);
        r82.M();
    L121:
        r97 = true;
    L115:
        r112 = null;
    L107:
        r111 = null;
    L92:
        MediaConfig r98 = r2.g();
        if (r98 == null) goto L99;
        r86 = r98.d();
    L99:
        r87 = null;
        goto L100
    L95:
        MediaConfig r100 = r2.g();
        if (r100 == null) goto L99;
        r86 = r100.d();
    L79:
        MediaConfig r101 = r2.g();
        if (r101 == null) goto L85;
        r84 = r101.c();
    L85:
        r84 = null;
        goto L87
    L82:
        MediaConfig r102 = r2.g();
        if (r102 == null) goto L85;
        r84 = r102.c();
    L123:
        LarusCommunityDialogCreationLlmUpdateBinding r103 = this.d;
        if (r103 == null) goto L128;
        SimpleDraweeView r104 = r103.f;
        if (r104 == null) goto L128;
        e1.o(r104);
    L128:
        MediaConfig r105 = r2.g();
        if (r105 == null) goto L133;
        Boolean r106 = r105.g();
        if (r106 == null) goto L133;
        r12 = r106.booleanValue();
    L133:
        V90(r12);
        goto L134
    L39:
        if (r11.getType() != 0) goto L41;
        r13 = true;
        goto L42
    L30:
        r8 = ContextCompat.getColor(AppHost.a.getApplication(), 2131102539);
    L17:
        BackgroundConfig r107 = r2.a();
        if (r107 == null) goto L27;
        ColorConfig r108 = r107.a();
        if (r108 == null) goto L27;
        r7 = r108.b();
    L27:
        r7 = null;
        goto L28
    L22:
        BackgroundConfig r109 = r2.a();
        if (r109 == null) goto L27;
        ColorConfig r113 = r109.a();
        if (r113 == null) goto L27;
        r7 = r113.b();
    L274:
        String r114 = this.g;
        CreationUpdateDialogItemConfig r115 = this.e;
        if (r115 == null) goto L279;
        Integer r116 = r115.e();
        if (r116 == null) goto L279;
        r3 = r116.toString();
    L279:
        String r117 = this.h;
        JSONObject r118 = new JSONObject();
        r118.putOpt(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r114);     // Catch: JSONException -> L282
        r118.putOpt("action_bar_template_id", r3);     // Catch: JSONException -> L282
        r118.putOpt("bot_id", r117);     // Catch: JSONException -> L282
    L284:
        TrackParams r119 = new TrackParams().merge(r118);
        by7.a r120 = new by7.a("ai_creation_guidance_window_show");
        r120.a.merge(r119);
        r120.b();
        return;
    L282:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobAICreationGuidanceWindowShow " + e.getLocalizedMessage());
        goto L284
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r15 = r12.inflate(2131561968, r13, false);
        int r16 = 2131365061;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r15, 2131365061);
        if (r2 == null) goto L26;
        r16 = 2131366984;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r15, 2131366984);
        if (r3 == null) goto L26;
        r16 = 2131367754;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r15, 2131367754);
        if (r4 == null) goto L26;
        r16 = 2131367862;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, 2131367862);
        if (r5 == null) goto L26;
        r16 = 2131375091;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r15, 2131375091);
        if (r6 == null) goto L26;
        r16 = 2131380532;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r15, 2131380532);
        if (r7 == null) goto L26;
        FrameLayout r17 = (FrameLayout) r15;
        if (((ScrollView) ViewBindings.findChildViewById(r15, 2131385238)) == null) goto L24;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131388924);
        if (r9 == null) goto L23;
        VideoPlayView r10 = (VideoPlayView) ViewBindings.findChildViewById(r15, 2131392404);
        if (r10 == null) goto L22;
        this.d = new LarusCommunityDialogCreationLlmUpdateBinding(r17, r2, r3, r4, r5, r6, r7, r17, r9, r10);
        return r17;
    L22:
        r16 = 2131392404;
        goto L26
    L23:
        r16 = 2131388924;
        goto L26
    L24:
        r16 = 2131385238;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
