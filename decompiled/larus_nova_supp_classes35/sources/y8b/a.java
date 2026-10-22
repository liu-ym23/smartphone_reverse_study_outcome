package y8b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.contact.base.common_ui.InvErrorView;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment$initView$1$1;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment$initView$1$2;
import com.ss.android.lark.contact.base.contact_mobile_invite.invite.InviteExternalContactInviteFragment;
import com.ss.android.lark.contact.base.contact_mobile_invite.using.InviteExternalContactUsingFragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.service.InvRequestUtils;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$localCallback$1;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.s;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.contact.base.utils.InvRouterParam$From;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.q;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements InvRequestUtils.a<a9b.b> {
    public final /* synthetic */ InviteExternalContactV2Fragment a;

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void c() {
        ViewUtils.c r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment] */
    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void onShowLoading() {
        ?? r0 = this.a;
        InvErrorView r1 = r0.j;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iecErrorView");
        r1 = null;
    L5:
        r1.setVisibility(8);
        if (r0.d != null) goto L8;
        ViewUtils.c r2 = ViewUtils.createPageLoadingDialog(r0.getContext());
        ((ViewUtils.b) r2).g = new f(r0);
        r0.d = r2;
    L8:
        ViewUtils.c r3 = r0.d;
        if (r3 == null) goto L12;
        r3.h();
        return;
    }

    public a(InviteExternalContactV2Fragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void a(InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Log.i(InviteExternalContactV2Fragment.S90(this.a), "start load local data");
        s.a(true, r3);
    }

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final boolean d(a9b.b r2) {
        a9b.b r3 = r2;
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        return !r3.a.isEmpty();
    }

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void e(InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Log.i(InviteExternalContactV2Fragment.S90(this.a), "start load server data");
        s.a(false, r3);
    }

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void f(ErrorResult r20) {
        InvErrorView r2 = this.a.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iecErrorView");
        r2 = null;
    L5:
        r2.setVisibility(0);
        if (r20 == null) goto L9;
        InvApmUtils.c("contact_opt_contact_list_fetch_fail", null, r20);
        ConcurrentHashMap<String, Long> r3 = a0.a;
        Intrinsics.checkNotNullParameter(r20, "err");
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Contact, Event.show_address_book, ErrorType.SDK, ErrorLevel.Fatal, r20.getErrorCode(), "GET_ADDRESS_BOOK_CONTACT_LIST", "InviteExternalContactView", r20.getMessage(), Boolean.TRUE, null, null, MapsKt.mapOf(TuplesKt.to("source_type", 1)), 3072, null));
        return;
    }

    @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
    public final void b(boolean r7, a9b.b r8) {
        a9b.b r9 = r8;
        InviteExternalContactInviteFragment r10 = null;
        String r11 = null;
        if (r9 != null) goto L5;
        f(null);
        return;
    L5:
        final InviteExternalContactV2Fragment r0 = this.a;
        InvInviteExternalContactV2ViewBinding r1 = r0.i;
        if (r1 == null) goto L10;
        RelativeLayout r2 = r1.f;
        if (r2 == null) goto L10;
        r2.setVisibility(0);
    L10:
        InvInviteExternalContactV2ViewBinding r3 = r0.i;
        if (r3 == null) goto L16;
        FrameLayout r4 = r3.b;
        if (r4 == null) goto L16;
        r4.setVisibility(0);
    L16:
        if (r0.e.size() != 0) goto L67;
        int r5 = InviteExternalContactUsingFragment.h;
        List<a9b.b.C0005b> r6 = r9.a;
        Intrinsics.checkNotNullParameter(r6, "cpFeishuUsers");
        InviteExternalContactUsingFragment r12 = new InviteExternalContactUsingFragment();
        r12.d = r6;
        r0.l = r12;
        com.ss.android.lark.base.fragment.a r13 = new com.ss.android.lark.base.fragment.a(r12, UIHelper.mustacheFormat(2131892435));
        int r14 = InviteExternalContactInviteFragment.f;
        List<ContactMobileBean> r15 = r9.b;
        Intrinsics.checkNotNullParameter(r15, "beans");
        InviteExternalContactInviteFragment r16 = new InviteExternalContactInviteFragment();
        r16.d = r15;
        r0.m = r16;
        com.ss.android.lark.base.fragment.a r17 = new com.ss.android.lark.base.fragment.a(r16, UIHelper.mustacheFormat(2131892432));
        r0.e.add(r13);
        r0.e.add(r17);
        InvInviteExternalContactV2ViewBinding r18 = r0.i;
        if (r18 == null) goto L22;
        SearchEditText r19 = r18.e;
        if (r19 == null) goto L22;
        r19.setTextWithoutSpaceChangedListener(b.a);
    L22:
        InvInviteExternalContactV2ViewBinding r20 = r0.i;
        if (r20 == null) goto L27;
        SearchEditText r21 = r20.e;
        if (r21 == null) goto L27;
        r21.addTextChangedListener(new c(r0));
    L27:
        InvInviteExternalContactV2ViewBinding r22 = r0.i;
        if (r22 == null) goto L32;
        SearchEditText r23 = r22.e;
        if (r23 == null) goto L32;
        r23.setOnFocusChangeListener(d.a);
    L32:
        View[] r24 = new View[1];
        InvInviteExternalContactV2ViewBinding r25 = r0.i;
        if (r25 == null) goto L35;
        ImageView r26 = r25.d;
    L36:
        r24[0] = r26;
        q.b(r24);
        InvInviteExternalContactV2ViewBinding r27 = r0.i;
        if (r27 == null) goto L41;
        ImageView r28 = r27.d;
        if (r28 == null) goto L41;
        r28.setOnClickListener(new e(r0));
    L41:
        InvInviteExternalContactV2ViewBinding r29 = r0.i;
        if (r29 == null) goto L76;
        final ViewPager r30 = r29.i;
        if (r30 == null) goto L76;
        r30.addOnPageChangeListener(new InviteExternalContactV2Fragment$initView$1$1(r0, r30));
        final FragmentManager r31 = r0.getFragmentManager();
        Intrinsics.checkNotNull(r31);
        r30.setAdapter(new InviteExternalContactV2Fragment$initView$1$2(r0, r31));
        InvInviteExternalContactV2ViewBinding r32 = r0.i;
        if (r32 == null) goto L48;
        UDTabLayout r33 = r32.c;
    L49:
        if (r33 == null) goto L51;
        UDTabLayoutCoordinator r34 = new UDTabLayoutCoordinator(r33, r30);
    L52:
        if (r34 == null) goto L55;
        r34.attach();
    L55:
        if (r0.e.size() <= 1) goto L76;
        if (r9.a.isEmpty() == true) goto L59;
    L60:
        String r35 = r0.g;
        if (r35 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("from");
    L65:
        if (Intrinsics.areEqual(InvRouterParam$From.ONBOARDING, r11) == false) goto L76;
    L66:
        r30.setCurrentItem(1);
        goto L76
    L63:
        r11 = r35;
        goto L65
    L59:
        if ((!r9.b.isEmpty()) == true) goto L66;
    L51:
        r34 = null;
        goto L52
    L48:
        r33 = null;
    L76:
        if (r0.h == false) goto L80;
        r0.h = false;
        a0.f(false);
        return;
    L80:
        return;
    L35:
        r26 = null;
        goto L36
    L67:
        InviteExternalContactUsingFragment r36 = r0.l;
        if (r36 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("usingFragment");
        r36 = null;
    L70:
        r36.update(r9.a);
        InviteExternalContactInviteFragment r37 = r0.m;
        if (r37 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("inviteFragment");
    L74:
        r10.update(r9.b);
        goto L76
    L73:
        r10 = r37;
        goto L74
    }
}
