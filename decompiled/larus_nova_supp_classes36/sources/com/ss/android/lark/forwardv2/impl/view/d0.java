package com.ss.android.lark.forwardv2.impl.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.choosechat.PreSelectedPair;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import com.ss.android.lark.forwardv2.impl.model.packer.ForwardTargetParser;
import com.ss.android.lark.forwardv2.impl.statistics.AppreciablePerformance;
import com.ss.android.lark.forwardv2.impl.statistics.ForwardHitpointExtraParams$Scene;
import com.ss.android.lark.forwardv2.impl.utils.ForwardUtil$ReceiveAuthorizationState;
import com.ss.android.lark.forwardv2.impl.view.adapter.ForwardSendDialogAdapter;
import com.ss.android.lark.forwardv3.dialogfragment.ForwardDialogFragment;
import com.ss.android.lark.forwardv3.plugins.ForwardAtPlugin;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.EntityType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.widget.ChatPicker;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0 extends BaseForwardView implements iib.d {
    public final ForwardTemplate h;
    public final boolean i;
    public final ForwardEnhancedView j;
    public final boolean k;
    public final int l;
    public Bundle m;
    public final com.ss.android.lark.forwardv3.plugins.f n;
    public final RecentForwardAdapterV3 o;
    public boolean p;
    public final boolean q;
    public final long r;
    public LKUIDialog s;
    public boolean t;
    public final Map<String, String> u;
    public rib.b v;

    @Override // iib.d
    public final void y8() {
    }

    public final void k() {
        this.mChatPicker.defaultMode(false);
    }

    @Override // iib.d
    public final List<SearchBaseInfo> m8() {
        rib.b r0 = this.v;
        if (r0 == null) goto L7;
        return r0.a;
    L7:
        return Collections.emptyList();
    }

    @Override // iib.c
    public final void onCancelClick() {
        this.o.y2();
        t8();
    }

    @Override // iib.c
    public final void t8() {
        boolean r1 = true;
        int r0 = (this.f + 1) % 2;
        this.f = r0;
        ChatPicker r2 = this.mChatPicker;
        if (r0 == 1) goto L6;
        r1 = false;
    L6:
        r2.switchMultipleStatus(r1);
        this.h.c.a();
    }

    @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView
    public final void destroy() {
        super.destroy();
        com.ss.android.lark.forwardv3.plugins.f r0 = this.n;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // iib.c
    public final void G4(List<SearchBaseInfo> r2) {
        this.mChatPicker.resetSelectedData(r2);
    }

    @Override // iib.d
    public final void f1(com.ss.android.lark.forwardv2.impl.c r7) {
        this.mChatPicker.a.showSkeleton();
        ChatPicker r0 = this.mChatPicker;
        q r1 = new q(this, r7);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "dataPuller");
        r0.b = r1;
        r0.self().attachComplete();
        ChatPicker r8 = this.mChatPicker;
        ArrayList<PreSelectedPair> r2 = this.h.c.a;
        ArrayList r3 = new ArrayList();
        if (r2 != null) goto L5;
    L18:
        r8.updatePreSelectedListByIds(r3);
        return;
    L5:
        if (r2.isEmpty() == true) goto L18;
        Iterator<PreSelectedPair> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        PreSelectedPair r5 = r4.next();
        String r6 = r5.a;
        EntityType.a r9 = EntityType.Companion;
        String r10 = r5.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "value");
        if (Intrinsics.areEqual(r10, Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL) == false) goto L14;
        EntityType r11 = EntityType.CHATTER;
    L17:
        r3.add(new Pair(r6, r11));
        goto L9
    L14:
        if (Intrinsics.areEqual(r10, Conf$StickerSetManagerPosition.STICKER_SET_SHOP) == false) goto L16;
        r11 = EntityType.CHAT;
        goto L17
    L16:
        r11 = EntityType.UNKNOWN;
        goto L17
    }

    @Override // iib.c
    public final void k8(List<SearchBaseInfo> r2) {
        s(r2, "");
    }

    @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView, iib.c
    public final void z6(List<SearchBaseInfo> r6) {
        if (CollectionUtils.isEmpty(r6) == true) goto L5;
        int r0 = r6.size();
    L7:
        if (this.f != 1) goto L12;
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        if (CollectionUtils.isEmpty(r6) == false) goto L11;
        C(UIUtils.getString(this.a, 2131892187), 2131106622, false, r0);
        return;
    L11:
        C(UIHelper.mustacheFormat(2131892073, "count", Integer.toString(r6.size())), 2131105548, false, r0);
        return;
    L12:
        this.mTitleBar.setLeftText("");
        this.mTitleBar.setLeftImageResource(CommonTitleBarConstants.ICON_CLOSE);
        C(UIUtils.getString(this.a, 2131892181), 2131106622, true, r0);
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public static boolean h(d0 r4, SearchBaseInfo r5) {
        boolean r1 = false;
        if (p(r5, r4.h) == false) goto L5;
    L15:
        boolean r0 = true;
    L16:
        if (r0 == true) goto L18;
        return false;
    L18:
        if (r4.f == 1) goto L20;
    L24:
        if (r1 == false) goto L26;
        LKUIToast.show(r4.a, UIHelper.mustacheFormat(2131892185, "select_count", Integer.toString(r4.l)));
    L36:
        return true;
    L26:
        int r2 = lib.a.a;
        if (lib.a.a(r5, r4.h.b) == true) goto L30;
        LKUIToast.show(r4.a, 2131892225);
        goto L36
    L30:
        if (o(r5, r4.h) == false) goto L36;
        BusinessRecentVisitEnableConfig.a r6 = (BusinessRecentVisitEnableConfig.a) r4.h.b.a();
        r6.getClass();
        r6.a.b.showSomeToast();     // Catch: RemoteException -> L34
    L34:
        e = move-exception;
        Log.e("BusinessRecentVisitEnableConfig", "showSomeToast", e);
        goto L36
    L20:
        if (r5.isSelected() == true) goto L24;
        if (r4.d.H2(r4.l) == false) goto L24;
        r1 = true;
        goto L24
    L5:
        if (r4.f == 1) goto L7;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L15;
        r0 = false;
        goto L16
    L7:
        if (r5.isSelected() == true) goto L11;
        if (r4.d.H2(r4.l) == false) goto L11;
        r3 = true;
        goto L12
    }

    public static boolean o(SearchBaseInfo r2, ForwardTemplate r3) {
        if (r3.b.a() == null) goto L14;
        com.ss.android.lark.forwardv2.dto.template.a r4 = r3.b.a();
        ForwardTarget r5 = ForwardTargetParser.a(r2);
        BusinessRecentVisitEnableConfig.a r6 = (BusinessRecentVisitEnableConfig.a) r4;
        r6.getClass();
        boolean r7 = r6.a.b.disableHandle(r5);     // Catch: RemoteException -> L7
    L9:
        if (r7 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        e = move-exception;
        Log.e("BusinessRecentVisitEnableConfig", "disableHandle", e);
        r7 = false;
        goto L9
    L14:
        return false;
    }

    public static boolean p(SearchBaseInfo r1, ForwardTemplate r2) {
        int r0 = lib.a.a;
        if (lib.a.a(r1, r2.b) == true) goto L5;
    L8:
        return true;
    L5:
        if (o(r1, r2) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.forwardv2.impl.view.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // iib.d
    public final void L3(final List<ForwardTarget> r2, final RichText r3) {
        ?? r0 = new e(this, r2, r3);
        if (this.i == true) goto L5;
    L7:
        r0.a();
        return;
    L5:
        if (this.j.D1(r2) == false) goto L7;
        this.j.d0(r0);
    }

    @Override // iib.c
    public final void U3(com.ss.android.lark.forwardv2.impl.model.b r9, List r10) {
        Log.i("TemplateForwardView", "on finishForward");
        KeyboardUtils.hideKeyboard(this.a);
        String r2 = AppreciablePerformance.a;
        if (r2 == null) goto L5;
        AppreciableKit.Companion.getInstance().end(r2, "ForwardPickFragment", null, null, null, null);
    L5:
        AppreciablePerformance.a = null;
        AppreciablePerformance.b = 0;
        if (this.p == false) goto L13;
        if (CollectionUtils.isNotEmpty(r10) == false) goto L13;
        if (((ForwardTarget) ListProtector.get(r10, 0)).a == null) goto L13;
        BaseForwardView.c r1 = this.c;
        r1.a(r1.getContext(), ((ForwardTarget) ListProtector.get(r10, 0)).a);
    L13:
        if (CollectionUtils.isEmpty(this.u) == false) goto L17;
        if (r9 != null) goto L26;
        this.c.finish();
        return;
    L26:
        Lazy r11 = ForsetiConfig.a;
        if (ForsetiConfig.a(this.a) == false) goto L29;
        this.c.d(r9.a, r9.b);
        return;
    L29:
        this.c.setResult(r9.a, r9.b);
        this.c.finish();
        return;
    L17:
        if (r9 != null) goto L19;
    L20:
        r9 = new com.ss.android.lark.forwardv2.impl.model.b();
        r9.a = -1;
        r9.b = new Intent();
    L21:
        Intent r12 = r9.b;
        Bundle r0 = new Bundle();
        Iterator r3 = ((HashMap) this.u).entrySet().iterator();
    L23:
        if (r3.hasNext() == false) goto L25;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.putString((String) r4.getKey(), (String) r4.getValue());
        goto L23
    L25:
        r12.putExtras(r0);
        goto L26
    L19:
        if (r9.b != null) goto L21;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [lib.g] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View, android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    public final void s(final List<SearchBaseInfo> r27, String r28) {
        Log.i("TemplateForwardView", "on showForwardDialog");
        if (r28 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.p = r1;
        List<ForwardTarget> r12 = ForwardTargetParser.b(r27);
        if (this.i == false) goto L12;
        this.j.y1();
    L12:
        if (r27.isEmpty() == true) goto L220;
        RichText r13 = null;
        if (this.h.e.i == true) goto L18;
        qqb.c.c(new k(this, r27, r13));
        goto L220
    L18:
        s5c.d r2 = z2.g;
        if (r28.equals(((s5c.a) r2).b) == false) goto L21;
        s5c.d r5 = r2;
    L22:
        s5c.d r14 = kib.c.a(this.h);
        r5.getClass();
        s5c.d r0 = s5c.d.b.b(r5, r14);
        int r3 = zib.e.a;
        Intrinsics.checkNotNullParameter(r0, "param");
        Statistics.sendEvent("im_msg_send_confirm_view", r0.plus(ChatParamUtils.e()).toJson());
        Statistics.sendEvent("public_send_to_view");
        ForwardViewDependency r4 = this.h.e;
        String r15 = r4.d;
        String r6 = r4.g;
        String r7 = r4.h;
        this.t = r4.j;
        if (TextUtils.isEmpty(r6) == true) goto L25;
    L28:
        String r8 = r6;
        if (TextUtils.isEmpty(r7) == false) goto L31;
        r7 = UIUtils.getString(this.a, 2131891541);
    L31:
        String r9 = r7;
        ForwardTemplate r10 = this.h;
        ForwardFeature r11 = r10.c;
        final boolean r16 = r11.f;
        boolean r17 = r11.j;
        int r18 = r10.h.a;
        if (r16 == false) goto L36;
        if (r17 == false) goto L36;
        this.n.c("forward_at_plugin", new ForwardAtPlugin(new com.ss.android.lark.forwardv3.plugins.a(this.n.a, new f(r27))));
    L36:
        final FragmentActivity r19 = this.a;
        Fragment r110 = this.b;
        final g r111 = new g(this, r17, r16, r27, r5, r14);
        h r20 = new h(r14);
        final i r21 = new i(this);
        boolean r22 = this.t;
        Log.i("TemplateForwardView", "forward init btn state: " + r22);
        if (r22 == false) goto L39;
        int r23 = 2131105542;
    L40:
        jib.b r24 = new jib.b(r8, r23, new m(this));
        Intrinsics.checkNotNullParameter(r9, "btnText");
        com.ss.android.lark.forwardv3.plugins.f r25 = this.n;
        com.larksuite.component.ui.dialog.d r26 = new com.larksuite.component.ui.dialog.d(r19);
        if (y0.d(r15) == false) goto L43;
        r15 = UIUtils.getString(r19, 2131891587);
    L43:
        r26.k(r15);
        r26.c.titleGravity(3);
        View r29 = LayoutInflater.from(r19).inflate(2131561156, null, false);
        r29.setBackgroundColor(UIUtils.getColor(r19, 2131100557));
        View r30 = r29.findViewById(2131384536);
        final ?? r31 = (KeyboardFunctionEditText) r29.findViewById(2131362277);
        if (r16 == false) goto L46;
        r31.setVisibility(0);
        r31.setOnTouchListener(new lib.k(r31));
    L47:
        r30.setVisibility(0);
        if (r25.b("forward_at_plugin") == null) goto L50;
        r25.b("forward_at_plugin").b(r19, r110, r31).e(ForwardDataUtils.d(r27));
    L50:
        final y1b.a r32 = (y1b.a) PluginServiceLoader.loadFirstOrNull(y1b.a.class);
        if (r27.size() != 1) goto L76;
        ImageView r33 = (ImageView) r29.findViewById(2131386679);
        TextView r112 = (TextView) r29.findViewById(2131386681);
        RecyclerView r113 = r29.findViewById(2131380441);
        LKUIRoundedImageView r114 = r29.findViewById(2131372256);
        View r34 = r29.findViewById(2131386680);
        final SearchReplyInThreadInfo r35 = (SearchBaseInfo) ListProtector.get(r27, 0);
        r113.setVisibility(8);
        r34.setVisibility(0);
        r112.setText(r35.getTitle());
        boolean r36 = r35 instanceof SearchReplyInThreadInfo;
        if (r36 == false) goto L55;
        int r115 = 0;
    L56:
        r114.setBorderColor(r115);
        if (r36 == false) goto L59;
        float r116 = 0.0f;
    L60:
        r114.setBorderWidthDP(r116);
        if (r36 == false) goto L63;
    L66:
        int r117 = 0;
    L67:
        r114.setVisibility(r117);
        if (r36 == false) goto L70;
        r33.setImageResource(2131237551);
        String r37 = r35.getAvatarKey();
        String r38 = r35.getEntityId();
        int r118 = UIHelper.dp2px(15.0f);
        int r119 = UIHelper.dp2px(15.0f);
        LoadParams r120 = new LoadParams();
        r120.a = r118;
        r120.b = r119;
        ImageModule.a(r19, r114, r37, r38, r120);
    L75:
        r34.setOnClickListener(new lib.i(r19, r32, r35));
    L77:
        r26.c.contentLayout(r29);
        r26.c.onDismissListener(new lib.f(r21));
        ?? r39 = new lib.g(r16, r19, r31, r111);
        jib.b r40 = r24;
        String r41 = r40.a;
        lib.l r42 = new lib.l(r40, r39);
        int r43 = r40.b;
        if (r43 != 0) goto L81;
        r43 = 0;
    L81:
        UDBaseDialogBuilder.ActionBuilder r44 = new UDBaseDialogBuilder.ActionBuilder();
        r44.actionResId(com.larksuite.component.ui.dialog.d.e.get(2131391777, 2131391777));
        r44.text(0);
        r44.text(r41);
        r44.textSize(0);
        r44.textColorRes(r43);
        r44.textColor(0);
        r44.bgColorRes(0);
        r44.bgDrawableRes(0);
        r44.onClickListener(r42);
        r26.c.addActionButton(r44);
        r26.b(2131378550, r9, new lib.n(r16, r19, r31, r20));
        r26.c.autoDismiss(false);
        View r45 = r29.findViewById(2131367665);
        final ConstraintLayout r46 = r29.findViewById(2131368412);
        ConstraintLayout r47 = r29.findViewById(2131364446);
        AppCompatEditText r48 = r29.findViewById(2131362277);
        if (this.i == true) goto L84;
    L96:
        GifImageView r49 = r45.findViewById(2131367671);
        ImageView r50 = (ImageView) r45.findViewById(2131367670);
        TextView r51 = (TextView) r45.findViewById(2131367668);
        TextView r121 = (TextView) r45.findViewById(2131367666);
        TextView r122 = (TextView) r45.findViewById(2131367667);
        if (this.i == true) goto L99;
    L101:
        BasicDialogContent r123 = this.h.e.e;
        Bundle r52 = this.m;
        if (r52 != null) goto L104;
        Message r53 = null;
    L105:
        if (r123 == null) goto L161;
        if (r53 == null) goto L109;
        ValidateIMFileResult r54 = r53.getValidateIMFileResult();
    L110:
        if (r54 != null) goto L112;
        IMFileResult r124 = null;
    L113:
        if (r124 != null) goto L115;
        ForwardUtil$ReceiveAuthorizationState r55 = ForwardUtil$ReceiveAuthorizationState.NORMAL_STATE;
    L116:
        int r56 = lib.p.a[r55.ordinal()];
        if (r56 == 1) goto L120;
        if (r56 == 2) goto L120;
        boolean r57 = false;
    L121:
        if (r57 == false) goto L128;
        r49.setVisibility(0);
        r49.setImageResource(2131244040);
        r50.setVisibility(8);
        if (r55 != ForwardUtil$ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L125;
        r122.setText(2131891244);
    L126:
        r122.setVisibility(0);
        goto L161
    L125:
        r122.setText("");
        goto L126
    L128:
        hib.d r58 = com.ss.android.lark.forwardv2.e.a;
        com.ss.android.lark.forwardv2.e.a.a().f();
        if (r123.e <= 0) goto L132;
        r49.setVisibility(0);
        r49.setImageResource(r123.e);
        BasicDialogContent r125 = r123;
    L140:
        int r59 = 8;
    L143:
        if (r49.getVisibility() != r59) goto L145;
    L147:
        int r60 = 0;
    L149:
        if (TextUtils.isEmpty(r125.b) == true) goto L151;
        r51.setText(r125.b);
        r51.setVisibility(r60);
        int r61 = 8;
    L153:
        if (TextUtils.isEmpty(r125.c) == true) goto L155;
        r121.setText(r125.c);
        r121.setVisibility(r60);
    L157:
        if (TextUtils.isEmpty(r125.d) == true) goto L159;
        r122.setText(r125.d);
        r122.setVisibility(r60);
        goto L161
    L159:
        r122.setVisibility(r61);
        goto L161
    L155:
        r121.setVisibility(r61);
        goto L157
    L151:
        r61 = 8;
        r51.setVisibility(8);
        goto L153
    L145:
        if (r125.i <= 0) goto L147;
        r60 = 0;
        r50.setVisibility(0);
        r50.setImageResource(r125.i);
        goto L149
    L132:
        if (r123.g == null) goto L134;
        r49.setVisibility(0);
        r125 = r123;
        w(this.a, r49, r123.j, r123.g, false, true);
        goto L140
    L134:
        r125 = r123;
        if (r125.f == null) goto L138;
        r49.setVisibility(0);
        w(this.a, r49, r125.j, r125.f, true, false);
        goto L140
    L138:
        if (r125.h == null) goto L141;
        r49.setVisibility(0);
        com.ss.android.lark.forwardv2.e.a.a().c(this.a, r49, r125.h);
        goto L140
    L141:
        r59 = 8;
        r49.setVisibility(8);
    L120:
        r57 = true;
        goto L121
    L115:
        r55 = ForwardUtil$ReceiveAuthorizationState.valueOf(r124.getValue());
        goto L116
    L112:
        r124 = r54.getResultType();
        goto L113
    L109:
        r54 = null;
    L161:
        if (r49.getVisibility() != 0) goto L163;
        boolean r126 = true;
    L165:
        if (r51.getVisibility() != 0) goto L167;
        boolean r62 = true;
    L169:
        if (r121.getVisibility() != 0) goto L171;
        boolean r63 = true;
    L173:
        if (r122.getVisibility() != 0) goto L175;
        boolean r127 = true;
    L176:
        int r64 = UIUtils.dp2px(this.a, 10.0f);
        int r65 = UIUtils.dp2px(this.a, 5.0f);
        if (r126 == false) goto L180;
        if (r62 == false) goto L180;
        ConstraintLayout.LayoutParams r66 = (ConstraintLayout.LayoutParams) r51.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r66).leftMargin = r64;
        r51.setLayoutParams(r66);
    L180:
        if (r63 == false) goto L189;
        ConstraintLayout.LayoutParams r67 = (ConstraintLayout.LayoutParams) r121.getLayoutParams();
        if (r126 == false) goto L184;
        ((ViewGroup.MarginLayoutParams) r67).leftMargin = r64;
    L184:
        if (r62 == false) goto L186;
        ((ViewGroup.MarginLayoutParams) r67).topMargin = r65;
        r121.setTextColor(UIUtils.getColor(this.a, 2131106620));
        r121.setMaxLines(2);
    L186:
        if (r127 == false) goto L188;
        ((ViewGroup.MarginLayoutParams) r67).bottomMargin = r65;
    L188:
        r121.setLayoutParams(r67);
    L189:
        if (r127 == false) goto L192;
        if (r126 == false) goto L192;
        ConstraintLayout.LayoutParams r68 = (ConstraintLayout.LayoutParams) r122.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r68).leftMargin = r64;
        r122.setLayoutParams(r68);
    L192:
        if (r126 == true) goto L197;
        if (r62 == true) goto L197;
        if (r63 == true) goto L197;
        if (r127 == true) goto L197;
        r45.setVisibility(8);
    L197:
        int r69 = DesktopUtil.a;
        LKUIDialog r70 = r26.c();
        if (r70.getWindow() == null) goto L200;
        r70.getWindow().setDimAmount(0.3f);
    L200:
        hib.d r71 = com.ss.android.lark.forwardv2.e.a;
        com.ss.android.lark.forwardv2.e.a.a().h(r70);
        if (r16 == false) goto L203;
        com.ss.android.lark.forwardv2.e.a.a().isEnterSendEnabled();
    L203:
        int r72 = com.ss.android.lark.forwardv3.utils.n.a;
        if (com.ss.android.lark.forwardv3.utils.n.f(r110.getContext()) == false) goto L211;
        ForwardDialogFragment r73 = new ForwardDialogFragment();
        r73.d = r70;
        FragmentTransaction r74 = r110.getChildFragmentManager().beginTransaction();
        r74.setCustomAnimations(0, 0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r74, r73, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "forward_dialog_v2", 0) == true) goto L209;
        r74.add(r73, "forward_dialog_v2");
    L209:
        r74.commitAllowingStateLoss();
    L215:
        this.s = r70;
        return;
    L211:
        if (DialogLancet.shouldBlockDialogShow(r70) == false) goto L218;
        DialogLancet.handleBlockedDialogShow(r70);
        goto L215
    L218:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L217
    L214:
        DialogLancet.beforeDialogShow(r70);
        r70.show();
        DialogLancet.afterDialogShow(r70);
        goto L215
    L175:
        r127 = false;
        goto L176
    L171:
        r63 = false;
        goto L173
    L167:
        r62 = false;
        goto L169
    L163:
        r126 = false;
        goto L165
    L104:
        r53 = r52.getSerializable("key_message");
        goto L105
    L99:
        if (this.j.y() == false) goto L101;
        this.j.V(r49, r51, r121, this.m);
        goto L161
    L84:
        if (this.j.A() == false) goto L96;
        r45.setVisibility(8);
        r46.setVisibility(0);
        ForwardEnhancedView r75 = this.j;
        if ((r75 instanceof ForwardClickableEnhancedView) == false) goto L95;
        Log.i("TemplateForwardView", "forward preview v2");
        ForwardClickableEnhancedView r76 = (ForwardClickableEnhancedView) this.j;
        BasicDialogContent r77 = this.h.e.e;
        r76.l(new l(this, r46), new b(this));
        r76.f(this.a, r46, r77);
        r46.setOnClickListener(new n(this, r77, r12));
        if (r76.e0() == false) goto L91;
        r47.setVisibility(0);
        r76.t1(this.a, r47);
    L91:
        if (this.h.c.f == false) goto L197;
        if (r76.n0() == false) goto L197;
        r48.addTextChangedListener(new o(r76));
        goto L197
    L95:
        r75.q0();
        goto L197
    L70:
        String r78 = r35.getAvatarKey();
        if ((r35 instanceof SearchThreadInfo) == false) goto L73;
        String r128 = ((SearchThreadInfo) r35).getChannel().getId();
    L74:
        int r129 = UIHelper.dp2px(40.0f);
        int r130 = UIHelper.dp2px(40.0f);
        LoadParams r79 = new LoadParams();
        r79.a = r129;
        r79.b = r130;
        ImageModule.a(r19, r33, r78, r128, r79);
        r114.setImageResource(2131235361);
        goto L75
    L73:
        r128 = r35.getId();
        goto L74
    L63:
        if ((r35 instanceof SearchThreadInfo) == true) goto L66;
        r117 = 8;
        goto L67
    L59:
        r116 = 1.5f;
        goto L60
    L55:
        r115 = UIUtils.getColor(r19, 2131106521);
        goto L56
    L76:
        r24 = r24;
        RecyclerView r80 = r29.findViewById(2131380441);
        View r81 = r29.findViewById(2131386680);
        r80.setVisibility(0);
        r81.setVisibility(8);
        DesktopUtil.a(r19);
        r80.setLayoutManager(new GridLayoutManager(r19, 5));
        ForwardSendDialogAdapter r82 = new ForwardSendDialogAdapter();
        r80.addItemDecoration(new lib.o(r19));
        r82.addAll(r27);
        r82.b = new lib.j(r19, r32);
        r80.setAdapter(r82);
        goto L77
    L46:
        r31.setVisibility(8);
        goto L47
    L39:
        r23 = 2131106610;
        goto L40
    L25:
        if (this.f != 1) goto L27;
        r6 = UIHelper.mustacheFormat(2131891134, "num", Integer.toString(r27.size()));
        goto L28
    L27:
        r6 = y9c.d.i(this.a, 2131892196);
        goto L28
    L21:
        r5 = z2.h;
    L220:
        return;
    L5:
        if (r28.equals(ForwardHitpointExtraParams$Scene.GROUP_CREATE_FROM_FORWARD.getValue()) == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void C(String r3, int r4, boolean r5, int r6) {
        if (this.e == null) goto L9;
        if (TextUtils.isEmpty(r3) == false) goto L7;
        this.e.setVisibility(8);
        goto L9
    L7:
        this.e.setVisibility(0);
        this.e.setText(r3);
        this.e.setTextColor(UIUtils.getColor(this.a, r4));
    L9:
        if (this.c == null) goto L12;
        Bundle r7 = new Bundle();
        r7.putString("actionName", r3);
        r7.putBoolean("isSingleSelect", r5);
        r7.putInt("selectedCount", r6);
        this.c.f(r7);
        return;
    }

    public d0(long r5, FragmentActivity r7, Fragment r8, ForwardPickFragment.a r9, ForwardTemplate r10, com.ss.android.lark.forwardv3.plugins.f r11) {
        super(r7, r8, r9);
        this.p = false;
        this.r = 0;
        boolean r0 = true;
        this.t = true;
        this.u = new HashMap();
        this.v = null;
        this.o = new RecentForwardAdapterV3(r7, new r(this), new s(this));
        this.r = r5;
        this.h = r10;
        this.n = r11;
        ForwardEnhancedView r6 = r10.e.f;
        this.j = r6;
        if (r6 == null) goto L5;
        boolean r12 = true;
    L6:
        this.i = r12;
        this.m = r10.g;
        ForwardFeature r13 = r10.c;
        this.k = r13.d;
        this.l = r13.e;
        this.q = !r13.a.isEmpty();
        FragmentActivity r14 = r9.g();
        if (r14 != null) goto L9;
    L11:
        r0 = false;
    L12:
        Log.i("TemplateForwardView", "penetrationReport isResponsive:" + r0);
        s5c.d r15 = kib.c.a(r10).plus(s5c.c.a("is_responsive", Boolean.toString(r0)));
        int r16 = zib.e.a;
        Intrinsics.checkNotNullParameter(r15, "iParam");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new zib.f(false, r15));
        return;
    L9:
        if (com.ss.android.lark.ui.component_container.a.e(r14) == false) goto L11;
    L5:
        r12 = false;
        goto L6
    }

    public static void w(Context r6, GifImageView r7, boolean r8, Image r9, boolean r10, boolean r11) {
        int r0 = lib.b.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "imageView");
        Log.i("ContentUtils", "start load image");
        if (r8 == false) goto L5;
        int r12 = 2131100556;
    L6:
        if (r9 == null) goto L26;
        String r2 = r9.getKey();
        if (TextUtils.isEmpty(r2) == false) goto L17;
        Log.i("ContentUtils", "load local image");
        List<String> r3 = r9.getUrls();
        if (CollectionUtils.isEmpty(r3) == true) goto L17;
        r2 = (String) ListProtector.get(r3, 0);
        if (URLUtil.isNetworkUrl(r2) == true) goto L17;
        if (new PolarisFileWrapper(r2).exists() == false) goto L17;
        ImageLoader.with(r6).placeholder(2131100556).error(r12).load(r2).dontAnimate(false).override(UIHelper.dp2px(80.0f), UIHelper.dp2px(80.0f)).into(r7);
        return;
    L17:
        if (TextUtils.isEmpty(r2) == true) goto L25;
        if (r10 == false) goto L20;
        Object r13 = new EncryptImage(r9);
    L21:
        IRequestCreator r14 = ImageLoader.with(r6).load(r13).placeholder(2131100556).dontAnimate(false).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(r12).centerCrop();
        if (r11 == false) goto L24;
        r14.transform(new CropCircleTransformation());
    L24:
        Log.i("ContentUtils", "do load image from net - isCircle:" + r11);
        r14.into(r7);
        return;
    L20:
        r13 = AvatarImage.Builder.obtain(r2, r9.getToken(), 0, 0).build();
        goto L21
    L25:
        Log.i("ContentUtils", "do load image from net key is null");
        ImageLoader.with(r6).load(Integer.valueOf(r12)).centerCrop().dontAnimate(false).into(r7);
        return;
    L26:
        Log.i("ContentUtils", "imageView display by placeholder");
        r7.setImageResource(2131100556);
        return;
    L5:
        r12 = 2131233586;
        goto L6
    }
}
