package com.larus.profile.impl.lynx.avatar;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002<=B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0007J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0007J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0007J\u0012\u0010#\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0007J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0007J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\u0018\u00100\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u000fH\u0002J$\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u000f2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000607H\u0002J\u0010\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0002J\u000e\u0010:\u001a\u0004\u0018\u00010;*\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/profile/impl/lynx/avatar/ProfileAvatarLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "params", "", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "root", "avatarView", "Lcom/larus/bmhome/view/RoundAvatarImageView;", "editIconView", "Landroid/widget/ImageView;", "avatarUrl", "", "isDefaultAvatar", "", "editable", "enablePreview", "enterFrom", "avatarSizeDp", "", "iconSizeDp", "localPreviewUri", "Landroid/net/Uri;", "localPreviewRemoteUrl", "createView", "Landroid/content/Context;", "setAvatarUrlProp", "", "value", "setIsDefaultAvatarProp", "setEditableProp", "setEnablePreviewProp", "setEnterFromProp", "setAvatarSizeProp", "setIconSizeProp", "applyLayoutParams", "applyEditable", "applyDefaultIcon", "applyPlaceholder", "applyAvatarUrl", "startEditFlow", "startPreviewFlow", "loadLocalPreview", "localUri", "emitTap", "emitAvatarChanged", "remoteUrl", "emitFail", "message", "emitEvent", "name", "detail", "", "dpToPx", "dp", "findFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "ProfileAvatarRendererHost", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileAvatarLynxUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int m = 0;
    public b a;
    public RoundAvatarImageView b;
    public ImageView c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;
    public int i;
    public int j;
    public Uri k;
    public String l;

    public static final class a {
    }

    public static final class b extends FrameLayout implements x6a.e {
        public x6a.i a;

        public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
            x6a.d.a(this, r1, r2);
        }

        public final /* synthetic */ void applyRendererOpacity(float r1) {
            x6a.d.b(this, r1);
        }

        public final /* synthetic */ void applyRendererTransform(float[] r1) {
            x6a.d.c(this, r1);
        }

        public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
            return x6a.d.d(this, r1);
        }

        public final /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        public final /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        public final /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        public final /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        public final View getView() {
            return this;
        }

        public final /* synthetic */ void invalidateForRenderer() {
            x6a.d.i(this);
        }

        public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
            return false;
        }

        public final /* synthetic */ void requestLayoutForRenderer() {
            x6a.d.j(this);
        }

        public final /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
            x6a.d.k(this, false);
        }

        public final /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
            x6a.d.l(this, false);
        }

        public final x6a.i getRenderer() {
            return this.a;
        }

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r2) {
            Intrinsics.checkNotNullParameter(r2, "canvas");
            super.dispatchDraw(r2);
            x6a.i r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // android.view.View
        public final void onDraw(Canvas r2) {
            Intrinsics.checkNotNullParameter(r2, "canvas");
            x6a.i r0 = this.a;
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        L6:
            super.onDraw(r2);
        }

        public final void setRenderer(x6a.i r2) {
            Intrinsics.checkNotNullParameter(r2, "renderer");
            this.a = r2;
        }

        public final x6a.i createRenderer(PlatformRendererContext r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "platformRendererContext");
            return new x6a.i(r2, r3);
        }

        @Override // android.view.ViewGroup
        public final boolean drawChild(Canvas r2, View r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "canvas");
            Intrinsics.checkNotNullParameter(r3, "child");
            x6a.i r0 = this.a;
            if (r0 == null) goto L5;
            r0.b(r2, r3);
        L5:
            boolean r5 = super.drawChild(r2, r3, r4);
            if (this.a == null) goto L8;
            r2.restore();
        L8:
            return r5;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
            x6a.i r0 = this.a;
            if (r0 == null) goto L7;
            LynxBaseUI r1 = r0.h;
            if (r1 == null) goto L7;
            r1.measure();
        L7:
            super.onLayout(r2, r3, r4, r5, r6);
        }
    }

    public static final class c implements ProfileAvatarEditHostFragment.a {
        public final /* synthetic */ ProfileAvatarLynxUI a;

        public c(ProfileAvatarLynxUI r1) {
            this.a = r1;
        }

        @Override // com.larus.profile.impl.lynx.avatar.ProfileAvatarEditHostFragment.a
        public final void onFail(String r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            ProfileAvatarLynxUI r1 = this.a;
            int r2 = ProfileAvatarLynxUI.m;
            r1.getClass();
            r1.Q("avatar_change_failed", MapsKt.mapOf(TuplesKt.to("message", r4)));
        }

        @Override // com.larus.profile.impl.lynx.avatar.ProfileAvatarEditHostFragment.a
        public final void a(Uri r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "localUri");
            Intrinsics.checkNotNullParameter(r11, "remoteUrl");
            ProfileAvatarLynxUI r2 = this.a;
            r2.k = r10;
            r2.l = r11;
            RoundAvatarImageView r3 = r2.b;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            r3 = null;
        L5:
            ImageLoaderKt.x(r3, r10, null, null, new j(), 6);
            ProfileAvatarLynxUI r4 = this.a;
            r4.e = false;
            r4.M();
            ProfileAvatarLynxUI r5 = this.a;
            String r12 = r10.toString();
            r5.getClass();
            r5.Q("avatar_changed", MapsKt.mapOf(new Pair[]{TuplesKt.to("localUri", r12), TuplesKt.to("remoteUrl", r11)}));
        }
    }

    static {
    }

    public final void M() {
        ImageView r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L8;
        int r1 = 2131240799;
    L9:
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
        r0 = null;
    L11:
        r0.setImageResource(r1);
        return;
    L8:
        r1 = 2131240883;
        goto L9
    }

    public final void N() {
        ImageView r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        ImageView r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
        r0 = null;
    L8:
        boolean r4 = false;
        if (this.f == false) goto L11;
        int r3 = 0;
    L12:
        r0.setVisibility(r3);
        ImageView r1 = this.b;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r1 = null;
    L16:
        if (this.f == false) goto L18;
    L19:
        r4 = true;
    L20:
        r1.setClickable(r4);
        ImageView r5 = this.c;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
    L24:
        r2.setClickable(this.f);
        return;
    L23:
        r2 = r5;
        goto L24
    L18:
        if (this.g == false) goto L20;
    L11:
        r3 = 8;
        goto L12
    }

    public final void O() {
        if (this.a != null) goto L5;
        return;
    L5:
        int r0 = P(this.i);
        int r1 = P(this.j);
        ImageView r2 = this.b;
        b r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r2 = null;
    L8:
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r0, r0);
        r4.gravity = 17;
        r2.setLayoutParams(r4);
        ImageView r5 = this.c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
        r5 = null;
    L11:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r1, r1);
        r6.gravity = 8388693;
        r5.setLayoutParams(r6);
        b r7 = this.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L15:
        r3.setLayoutParams(new ViewGroup.LayoutParams(r0, r0));
        return;
    L14:
        r3 = r7;
        goto L15
    }

    public final void S() {
        b r0 = this.a;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        Intrinsics.checkNotNull(r1);
        FragmentActivity r2 = R(r1);
        if (r2 != null) goto L10;
        Q("avatar_change_failed", MapsKt.mapOf(TuplesKt.to("message", "")));
        return;
    L10:
        int r3 = ProfileAvatarEditHostFragment.i;
        Intrinsics.checkNotNullParameter(r2, "activity");
        FragmentManager r4 = r2.getSupportFragmentManager();
        Fragment r5 = r4.findFragmentByTag("profile_avatar_edit_host_fragment");
        if ((r5 instanceof ProfileAvatarEditHostFragment) == false) goto L13;
        final ProfileAvatarEditHostFragment r6 = (ProfileAvatarEditHostFragment) r5;
    L14:
        if (r6 != null) goto L28;
        r6 = new ProfileAvatarEditHostFragment();
        FragmentTransaction r7 = r4.beginTransaction();     // Catch: Throwable -> L23
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "profile_avatar_edit_host_fragment", 0) == true) goto L21;
        r7 = r7.add(r6, "profile_avatar_edit_host_fragment");     // Catch: Throwable -> L23
    L21:
        r7.commitNow();     // Catch: Throwable -> L23
    L23:
        FragmentTransaction r8 = r4.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "profile_avatar_edit_host_fragment", 0) == true) goto L27;
        r8 = r8.add(r6, "profile_avatar_edit_host_fragment");
    L27:
        r8.commitNowAllowingStateLoss();
    L28:
        c r9 = new c(this);
        Intrinsics.checkNotNullParameter(r9, "callback");
        r6.d = r9;
        FragmentActivity r10 = r6.getActivity();
        if (r10 != null) goto L33;
        ProfileAvatarEditHostFragment.a r11 = r6.d;
        r6.d = null;
        if (r11 == null) goto L37;
        r11.onFail("");
        return;
    L37:
        return;
    L33:
        k2 r12 = k2.a;
        g3.a.a(null, r10, false, null, false, new e(r6), 29);
        return;
    L13:
        r6 = null;
        goto L14
    L5:
        r1 = getLynxContext();
        goto L6
    }

    public ProfileAvatarLynxUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, null);
        this.f = true;
        this.h = "setting";
        this.i = 110;
        this.j = 32;
    }

    public final int P(int r3) {
        b r0 = this.a;
        if (r0 == null) goto L5;
        Resources r1 = r0.getResources();
    L6:
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        if (r2 == null) goto L9;
        float r4 = r2.density;
    L11:
        return (int) ((r3 * r4) + 0.5f);
    L9:
        r4 = 1.0f;
        goto L11
    L5:
        r1 = getLynxContext().getResources();
        goto L6
    }

    public final FragmentActivity R(Context r3) {
    L3:
        if ((r3 instanceof FragmentActivity) == true) goto L5;
        if ((r3 instanceof ContextWrapper) == false) goto L9;
        ContextWrapper r0 = (ContextWrapper) r3;
    L10:
        if (r0 == null) goto L11;
        Context r1 = r0.getBaseContext();
        if (r1 == null) goto L14;
        if (r1 == r3) goto L16;
        r3 = r1;
        goto L3
    L16:
        return null;
    L14:
        return null;
    L11:
        return null;
    L9:
        r0 = null;
        goto L10
    L5:
        return (FragmentActivity) r3;
    }

    public final View createView(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        this.a = new b(r7);
        this.b = new RoundAvatarImageView(r7);
        this.c = new ImageView(r7);
        b r8 = this.a;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("root");
        r8 = null;
    L5:
        View r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r2 = null;
    L8:
        r8.addView(r2);
        b r9 = this.a;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("root");
        r9 = null;
    L11:
        ImageView r3 = this.c;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
        r3 = null;
    L14:
        r9.addView(r3);
        O();
        N();
        M();
        RoundAvatarImageView r10 = this.b;
        if (r10 == null) goto L20;
        GenericDraweeHierarchy r11 = r10.getHierarchy();
        if (r11 == null) goto L20;
        r11.setPlaceholderImage(2131240119);
    L20:
        View.OnClickListener r12 = new h(this);
        View.OnClickListener r4 = new i(this);
        View r5 = this.b;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r5 = null;
    L23:
        e1.c(r5, r12);
        ImageView r13 = this.c;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("editIconView");
        r13 = null;
    L26:
        e1.c(r13, r4);
        b r14 = this.a;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    L30:
        return r14;
    }

    @LynxProp(name = "avatarSize")
    public final void setAvatarSizeProp(int r1) {
        if (r1 > 0) goto L5;
        r1 = 110;
    L5:
        this.i = r1;
        O();
    }

    @LynxProp(name = "avatarUrl")
    public final void setAvatarUrlProp(String r8) {
        this.d = r8;
        RoundAvatarImageView r0 = null;
        if (Intrinsics.areEqual(r8, this.l) == true) goto L6;
        this.k = null;
        this.l = null;
    L6:
        if (this.b == null) goto L23;
        Uri r2 = this.k;
        if (r2 != null) goto L11;
    L16:
        RoundAvatarImageView r1 = this.b;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
    L20:
        RoundAvatarImageView.f(r0, this.d, "settings_edit.avatar_default", false, 12);
        return;
    L19:
        r0 = r1;
        goto L20
    L11:
        if (Intrinsics.areEqual(this.d, this.l) == false) goto L16;
        GenericDraweeView r3 = this.b;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r3 = null;
    L15:
        ImageLoaderKt.x(r3, r2, null, null, new j(), 6);
        return;
    }

    @LynxProp(name = "editable")
    public final void setEditableProp(boolean r1) {
        this.f = r1;
        N();
    }

    @LynxProp(name = "enablePreview")
    public final void setEnablePreviewProp(boolean r1) {
        this.g = r1;
        N();
    }

    @LynxProp(name = "enterFrom")
    public final void setEnterFromProp(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r2 = "setting";
    L10:
        this.h = r2;
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @LynxProp(name = "iconSize")
    public final void setIconSizeProp(int r1) {
        if (r1 > 0) goto L5;
        r1 = 32;
    L5:
        this.j = r1;
        O();
    }

    @LynxProp(name = "isDefaultAvatar")
    public final void setIsDefaultAvatarProp(boolean r1) {
        this.e = r1;
        M();
    }

    public final void Q(String r4, Map<String, ? extends Object> r5) {
        com.lynx.tasm.event.a r0 = new com.lynx.tasm.event.a(getSign(), r4);     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, ? extends Object>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L8
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r1 = r6.next();     // Catch: Throwable -> L8
        r0.a(r1.getKey(), r1.getValue());     // Catch: Throwable -> L8
        goto L4
    L6:
        getLynxContext().getEventEmitter().sendCustomEvent(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        FLogger.a.e("ProfileAvatarLynxUI", "emitEvent(" + r4 + ") error: " + th.getMessage());
    }
}
