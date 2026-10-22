package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.profile.ui.base.k {
    public static final int i = 0;
    public View b;
    public HSImageView c;
    public TextView d;
    public final Lazy e;
    public final c f;
    public boolean g;
    public final com.bytedance.android.live.profile.ui.base.h h;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a$a, reason: collision with other inner class name */
    public static final class C0015a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(a r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView r0 = this.a.d;     // Catch: Throwable -> L6
            int r7 = ColorProtector.parseColor(this.b);     // Catch: Throwable -> L6
            int r8 = ColorProtector.parseColor(this.c);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.getPaint().setShader(new LinearGradient(0.0f, r0.getHeight(), 0.0f, 0.0f, r7, r8, Shader.TileMode.CLAMP));     // Catch: Throwable -> L6
            r0.invalidate();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    static {
        i = UtilityKotlinExtentionsKt.i(30);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        com.bytedance.android.live.profile.ui.base.m r0 = com.bytedance.android.live.profile.ui.base.i.n(this.h);
        if (r0 == null) goto L5;
        r0.a(this.f);
    L5:
        this.g = false;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.MyLiveAvatarNameComponent.INSTANCE;
    }

    public a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.h = r2;
        this.e = LazyKt.lazy(new ProfileMyLiveAvatarNameComponent$panelAvatar$2(this));
        this.f = new c(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567185, true);
        this.b = i(2131384813);
        this.c = i(2131363623);
        this.d = (TextView) i(2131380593);
        com.bytedance.android.live.profile.ui.base.m r4 = com.bytedance.android.live.profile.ui.base.i.n(this.h);
        if (r4 == null) goto L6;
        r4.d(this.f);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r5, "user");
        BaseProfileInfo r0 = r5.baseProfileInfo;
        if (r0 == null) goto L7;
        py.k r1 = r0.avatarThumb;
        if (r1 == null) goto L7;
        ImageLoader.bindImage(this.c, r1, UtilityKotlinExtentionsKt.i(24), UtilityKotlinExtentionsKt.i(24));
    L7:
        TextView r2 = this.d;
        if (r2 == null) goto L10;
        r2.setText(r5.getDisplayName());
    L10:
        ProfileSkin r3 = r5.mProfileSkin;
        String r4 = null;
        if (r3 == null) goto L19;
        ProfileCustomSkin r6 = r3.skin;
        if (r6 == null) goto L19;
        ProfileCustomSkin.BgUI r7 = r6.bgSkin;
        if (r7 == null) goto L19;
        ProfileCustomSkin.GradientColor r8 = r7.bgColor;
        if (r8 == null) goto L19;
        String r9 = r8.from;
    L20:
        View r10 = this.b;
        if (r10 == null) goto L55;
        com.bytedance.android.live.profile.ui.util.m.f(r10, r9);
    L55:
        ProfileSkin r12 = r5.mProfileSkin;     // Catch: Exception -> L52
        if (r12 == null) goto L28;
        ProfileCustomSkin r13 = r12.skin;     // Catch: Exception -> L52
        if (r13 == null) goto L28;
        ProfileCustomSkin.GradientColor r14 = r13.nickNameColor;     // Catch: Exception -> L52
    L29:
        if (r14 == null) goto L31;
        String r15 = r14.from;     // Catch: Exception -> L52
    L32:
        if (r14 == null) goto L34;
        r4 = r14.to;     // Catch: Exception -> L52
    L34:
        boolean r16 = true;
        if (r15 != null) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == true) goto L57;
        if (r4 != null) goto L44;
    L47:
        if (r16 == true) goto L58;
        TextView r18 = this.d;     // Catch: Exception -> L52
        if (r18 == null) goto L59;
        r18.post(new b(this, r15, r4));     // Catch: Exception -> L52
        return;
    L59:
        return;
    L58:
        return;
    L44:
        if (r4.length() == 0) goto L47;
        r16 = false;
        goto L47
    L57:
        return;
    L37:
        if (r15.length() == 0) goto L40;
        r17 = false;
        goto L41
    L31:
        r15 = null;
    L28:
        r14 = null;
    L52:
        e = move-exception;
        ALogger.e("ProfileMyLiveAvatarNameComponent", "load name color error: " + e.getMessage());
        return;
    L19:
        r9 = null;
        goto L20
    }
}
