package com.ss.android.lark.forwardv3.plugins;

import android.R;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.component_container.ResponsiveBaseFragment;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardCreateGroupChatPlugin implements i {
    public final ForwardTemplateNew a;
    public final a b;
    public final Lazy c;
    public ForwardCreateGroupChatFragment d;

    public interface a {
        void a(String r1);

        void onBack();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ForwardCreateGroupChatPlugin a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ Fragment c;

        public static final class a implements a {
            public final /* synthetic */ FragmentActivity a;
            public final /* synthetic */ ForwardCreateGroupChatPlugin b;
            public final /* synthetic */ Fragment c;

            @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
            public final void onBack() {
                KeyboardUtils.hideKeyboard(this.a);
                ForwardCreateGroupChatPlugin.f(this.b, this.a, this.c);
                this.b.b.onBack();
            }

            @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
            public final void a(String r4) {
                Intrinsics.checkNotNullParameter(r4, "chatId");
                KeyboardUtils.hideKeyboard(this.a);
                ForwardCreateGroupChatPlugin.f(this.b, this.a, this.c);
                this.b.b.a(r4);
            }

            public a(FragmentActivity r1, ForwardCreateGroupChatPlugin r2, Fragment r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public b(ForwardCreateGroupChatPlugin r1, FragmentActivity r2, Fragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            if (((com.ss.android.lark.forwardv3.utils.e) this.a.c.getValue()).a() == false) goto L80;
            ForwardCreateGroupChatPlugin r13 = this.a;
            ForwardCreateGroupChatPlugin r1 = this.a;
            r13.d = new ForwardCreateGroupChatFragment(r1.a, new a(this.b, r1, this.c));
            ForwardCreateGroupChatPlugin r14 = this.a;
            FragmentActivity r0 = this.b;
            Fragment r2 = this.c;
            if (r0 == null) goto L78;
            ForwardCreateGroupChatFragment r3 = r14.d;
            boolean r4 = true;
            if (r3 != null) goto L9;
        L11:
            boolean r5 = false;
        L12:
            if (r5 == true) goto L81;
            if (r2 == null) goto L87;
            Log.i("NewForward", "start create group chat");
            s5c.a r6 = r.m;
            s5c.a r7 = p3.f;
            int r8 = zib.e.a;
            r6.getClass();
            zib.e.a.c(s5c.d.b.b(r6, r7));
            boolean r9 = ForsetiFGHelpers.d();
            int r10 = R.id.content;
            if (r9 == true) goto L18;
        L57:
            ForwardCreateGroupChatFragment r15 = r14.d;
            if (r15 == null) goto L85;
            sua.a r11 = (sua.a) ApiUtils.getApi(sua.a.class);
            if (r11 == null) goto L64;
            FragmentManager r16 = r11.getFragmentManagerInForseti(r0, r15);
            if (r16 == null) goto L64;
        L65:
            FragmentTransaction r17 = r16.beginTransaction();
            r17.setCustomAnimations(2130772644, 2130772645);
            if (ForsetiConfig.a(r0) == false) goto L73;
            sua.a r18 = (sua.a) ApiUtils.getApi(sua.a.class);
            if (r18 == null) goto L72;
            Integer r19 = r18.getResumedChainRootFragmentContainerId(r0);
            if (r19 == null) goto L72;
            r10 = r19.intValue();
        L72:
            r10 = 2131373226;
        L73:
            String r20 = ForwardCreateGroupChatFragment.class.getName();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r20, r10) == true) goto L77;
            r17.add(r10, r15, r20);
        L77:
            r17.commitAllowingStateLoss();
            return;
        L64:
            r16 = r0.getSupportFragmentManager();
            goto L65
        L85:
            return;
        L18:
            if (ForsetiConfig.a(r0) == true) goto L57;
            if (ForwardCreateGroupChatPlugin.g(r2) == false) goto L57;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            Fragment r21 = r0.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
            if (r21 == null) goto L24;
            FragmentManager r22 = r21.getChildFragmentManager();
        L25:
            if (r22 == null) goto L27;
            FragmentTransaction r23 = r22.beginTransaction();
        L28:
            ForwardCreateGroupChatFragment r110 = r14.d;
            if (r110 == null) goto L82;
            if (r23 == null) goto L51;
            FragmentTransaction r24 = r23.setCustomAnimations(2130772644, 2130772335);
            if (r24 == null) goto L51;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            ResponsiveBaseFragment r25 = r0.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
            if ((r25 instanceof ResponsiveBaseFragment) == false) goto L36;
            ResponsiveBaseFragment r26 = r25;
        L37:
            StringBuilder r27 = new StringBuilder("getContainerId containerFragment is null: ");
            if (r26 == null) goto L41;
            r4 = false;
        L41:
            r27.append(r4);
            Log.i("ResponsiveBaseFragment", r27.toString());
            if (r26 == null) goto L48;
            FrameLayout r28 = r26.f;
            if (r28 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("shadowContainerChild");
            r28 = null;
        L46:
            r10 = r28.getId();
        L48:
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r24, r110, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r10) == true) goto L51;
            r24.add(r10, r110);
            goto L51
        L36:
            r26 = null;
        L51:
            boolean r111 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_hide_source", false);
            Log.i("FGUtils", "FG key: core.forward.create_group_hide_source: " + r111);
            if (r111 == true) goto L55;
            if (r23 == null) goto L55;
            r23.hide(r2);
        L55:
            if (r23 == null) goto L83;
            r23.commitAllowingStateLoss();
            return;
        L83:
            return;
        L82:
            return;
        L27:
            r23 = null;
            goto L28
        L24:
            r22 = null;
            goto L25
        L87:
            return;
        L81:
            return;
        L9:
            if (r3.isAdded() != true) goto L11;
            r5 = true;
            goto L12
        L78:
            r14.getClass();
            return;
        }
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r1) {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
        this.d = null;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public static boolean g(Fragment r3) {
        boolean r0 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_container_judge", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_container_judge: " + r0);
        if (r0 == false) goto L7;
        return true;
    L7:
        return r3.getParentFragment() instanceof ResponsiveBaseFragment;
    }

    public ForwardCreateGroupChatPlugin(ForwardTemplateNew r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "forwardTemplate");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ForwardCreateGroupChatPlugin$clickThrottle$2.INSTANCE);
    }

    public static final void f(ForwardCreateGroupChatPlugin r3, FragmentActivity r4, Fragment r5) {
        if (r4 == null) goto L39;
        ForwardCreateGroupChatFragment r0 = r3.d;
        if (r0 == null) goto L8;
        boolean r2 = true;
        if (r0.isAdded() != true) goto L8;
    L9:
        if (r2 == false) goto L41;
        if (r5 != null) goto L13;
        return;
    L13:
        if (ForsetiFGHelpers.d() == true) goto L15;
    L36:
        ForwardCreateGroupChatFragment r6 = r3.d;
        if (r6 == null) goto L46;
        FragmentTransaction r7 = ((sua.a) ApiUtils.getApi(sua.a.class)).getFragmentManagerInForseti(r4, r6).beginTransaction();
        r7.setCustomAnimations(2130772644, 2130772645);
        r7.remove(r6).commitAllowingStateLoss();
        return;
    L46:
        return;
    L15:
        if (ForsetiConfig.a(r4) == true) goto L36;
        if (g(r5) == false) goto L36;
        ForwardCreateGroupChatFragment r8 = r3.d;
        if (r8 == null) goto L42;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Fragment r9 = r4.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
        FragmentTransaction r1 = null;
        if (r9 == null) goto L23;
        FragmentManager r10 = r9.getChildFragmentManager();
    L24:
        if (r10 == null) goto L26;
        r1 = r10.beginTransaction();
    L26:
        if (r1 == null) goto L28;
        r1.setCustomAnimations(2130772335, 2130772645);
    L28:
        boolean r11 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_hide_source", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_hide_source: " + r11);
        if (r11 == true) goto L32;
        if (r1 == null) goto L32;
        r1.show(r5);
    L32:
        if (r1 == null) goto L43;
        FragmentTransaction r12 = r1.remove(r8);
        if (r12 == null) goto L44;
        r12.commitAllowingStateLoss();
        return;
    L44:
        return;
    L43:
        return;
    L23:
        r10 = null;
        goto L24
    L42:
        return;
    L41:
        return;
    L8:
        r2 = false;
        goto L9
    L39:
        r3.getClass();
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r2, Fragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginTarget");
        r4.setOnClickListener(new b(this, r2, r3));
        return this;
    }
}
