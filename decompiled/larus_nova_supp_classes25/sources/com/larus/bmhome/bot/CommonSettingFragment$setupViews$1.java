package com.larus.bmhome.bot;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewGroupKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextMenu;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupViews$1", f = "CommonSettingFragment.kt", i = {0, 0, 1, 1}, l = {1296, 1304, 1412}, m = "invokeSuspend", n = {"$this$launch", "cvsId", "$this$launch", "cvsId"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class CommonSettingFragment$setupViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupViews$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$setupViews$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CommonSettingFragment$setupViews$1 r0 = new CommonSettingFragment$setupViews$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v23, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r4v56, types: [com.larus.bmhome.chat.manager.settings.p] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.larus.bmhome.bot.m5] */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.larus.bmhome.bot.n5] */
    /* JADX WARN: Type inference failed for: r8v12, types: [android.widget.TextView] */
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
    public final Object invokeSuspend(Object r24) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r5 = false;
        String r8 = "";
        if (r0 == 0) goto L13;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r24);
    L627:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CommonSettingFragment r1 = (CommonSettingFragment) this.L$2;
        String r12 = (String) this.L$1;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        CommonSettingFragment r4 = r1;
        Object r3 = r24;
    L146:
        BotModel r6 = (BotModel) r3;
        if (r6 != null) goto L150;
        CommonSettingFragment r7 = this.this$0;
        FLogger.a.e(r7.e, "Cannot find bot " + r12);
        return Unit.INSTANCE;
    L150:
        r4.s = r6;
        CommonSettingFragment r9 = this.this$0;
        if (r9.J == false) goto L159;
        BotModel r10 = r9.s;
        if (r10 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r10 = null;
    L155:
        String r11 = r10.getBotId();
        if (r11 != null) goto L158;
        r11 = "";
    L158:
        r9.S = r11;
    L159:
        BotServiceImpl r14 = com.larus.im.d.a();
        BotModel r15 = this.this$0.s;
        if (r15 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r15 = null;
    L162:
        String r16 = r15.getBotId();
        if (r16 != null) goto L165;
        r16 = "";
    L165:
        r14.registerBotChangeListener(r16, this.this$0.W);
        CommonSettingFragment r17 = this.this$0;
        Gson r18 = new Gson();
        CommonSettingFragment r19 = this.this$0;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L171
        BotModel r20 = r19.s;     // Catch: Throwable -> L171
        if (r20 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");     // Catch: Throwable -> L171
        r20 = null;
    L169:
        Object r21 = Result.constructor-impl((EditPos) r18.fromJson(r20.getEditPos(), EditPos.class));     // Catch: Throwable -> L171
    L174:
        if (Result.isFailure-impl(r21) == false) goto L176;
        r21 = null;
    L176:
        EditPos r22 = (EditPos) r21;
        if (r22 != null) goto L179;
        r22 = new EditPos(0);
    L179:
        r17.t = r22;
        String r23 = r12;
    L180:
        CommonSettingFragment r25 = this.this$0;
        BigDecimal r26 = CommonSettingFragment.k1;
        if (((lq9.k) r25.G.getValue()).a() == true) goto L184;
        FLogger.a.i(r25.e, "continue talk v2 not enable");
    L195:
        boolean r27 = false;
    L197:
        CommonSettingFragment r28 = this.this$0;
        com.larus.bmhome.setting.c r111 = r28.g;
        if (r111 == null) goto L200;
        r111.a = r27;
    L200:
        if (r27 == false) goto L202;
        CommonSettingFragment.Y90(r28);
    L202:
        CommonSettingFragment r29 = this.this$0;
        r29.u = r29.Ma0();
        final CommonSettingFragment r30 = this.this$0;
        com.larus.bmhome.setting.c r31 = r30.g;
        if (r31 == null) goto L238;
        NovaTitleBarEx r112 = r31.Y0();
        BotModel r113 = r30.s;
        if (r113 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r113 = null;
    L207:
        Integer r114 = r113.getBotStatus();
        if (r114 != null) goto L211;
    L212:
        NovaTitleBarEx.i6(r112, v19.c.b(2130971662, r112.getContext(), 2131240955), null, r30.getString(2131898833), new g2(r30), 6);
    L213:
        AppHost.Companion r32 = AppHost.a;
        if (r32.isOversea() == false) goto L238;
        if (r31.b1() == false) goto L238;
        if (r30.m == 1) goto L238;
        hq9.g0 r33 = com.larus.platform.service.z2.a.K1();
        if (r33 == null) goto L222;
        String r34 = r33.c;
    L224:
        if (com.larus.utils.o0.d(r34) == true) goto L227;
        FLogger.a.i(r30.e, "chat_title_use_default_official_url");
        r34 = r32.f();
    L227:
        BotModel r35 = r30.s;
        if (r35 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r35 = null;
    L230:
        String r36 = r35.getName();
        BotModel r37 = r30.s;
        if (r37 != null) goto L233;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r37 = null;
    L233:
        BotIconImage r38 = r37.getIconImage();
        if (r38 == null) goto L236;
        String r39 = r38.getOriginUrl();
    L237:
        r112.U5(r36, r34, r39);
        goto L238
    L236:
        r39 = null;
        goto L237
    L222:
        r34 = null;
        goto L224
    L211:
        if (r114.intValue() == (-10)) goto L213;
    L238:
        final CommonSettingFragment r40 = this.this$0;
        if (r40.g == null) goto L365;
        Integer r41 = r40.r;
        if (r41 != null) goto L244;
    L263:
        final com.larus.bmhome.setting.c r42 = r40.g;
        if (r42 == null) goto L365;
        BotModel r115 = r40.s;
        if (r115 != null) goto L268;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r115 = null;
    L268:
        Integer r116 = r115.getBotStatus();
        if (r116 != null) goto L272;
    L273:
        if (r116 != null) goto L276;
    L278:
        if (r116 != null) goto L281;
    L301:
        ItemGroup r117 = r42.M();
        if (r117 == null) goto L304;
        r117.setVisibility(8);
    L304:
        IFlowSettingThemeConfigProvider r118 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r118 == null) goto L307;
        r118.a(new h3(r42, r40), new i3(r42), AdaptThemeFeatureKey.SETTING_ITEM_DOUBAO_EDIT_BUSINESS_LOGIC);
    L307:
        ItemTextArrow r43 = r42.G();
        if (com.larus.platform.service.z2.a.q().d == false) goto L332;
        EditPos r119 = r40.t;
        if (r119 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r119 = null;
    L313:
        if (r119.i() == true) goto L331;
        EditPos r120 = r40.t;
        if (r120 != null) goto L318;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r120 = null;
    L318:
        if (r120.g() == true) goto L331;
        EditPos r121 = r40.t;
        if (r121 != null) goto L323;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r121 = null;
    L323:
        if (r121.e() == true) goto L331;
        EditPos r122 = r40.t;
        if (r122 != null) goto L328;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r122 = null;
    L328:
        if (r122.h() == true) goto L331;
        if (AuthModelDelegate.b.d() == false) goto L332;
    L331:
        boolean r123 = true;
    L333:
        if (r123 == false) goto L335;
        int r124 = 0;
    L336:
        r43.setVisibility(r124);
        r42.Z0().setStyle(r40.Da0() ? 1 : 0);
        ItemTextArrow r44 = r42.j0();
        if (r44 == null) goto L339;
        r44.setVisible(AuthModelDelegate.b.d());
    L339:
        ItemLongTextArrow r45 = r42.b();
        if (r45 == null) goto L342;
        r45.setVisibility(8);
    L342:
        ItemGroup r46 = r42.Q();
        if (r46 == null) goto L345;
        r46.setVisibility(0);
    L345:
        r42.N0().setVisibility(0);
        ItemTextView r47 = r42.z();
        if (r47 == null) goto L364;
        r47.setVisibility(8);
    L364:
        Unit r48 = Unit.INSTANCE;
        goto L365
    L335:
        r124 = 8;
    L332:
        r123 = false;
        goto L333
    L281:
        if (r116.intValue() != (-30)) goto L301;
        if (r40.an() == true) goto L301;
        ItemGroup r125 = r42.M();
        if (r125 == null) goto L287;
        r125.setVisibility(8);
    L287:
        ItemGroup r126 = r42.N();
        if (r126 == null) goto L290;
        r126.setVisibility(8);
    L290:
        ItemGroup r127 = r42.Q();
        if (r127 == null) goto L293;
        r127.setVisibility(0);
    L293:
        r42.N0().setVisibility(8);
        ItemTextView r128 = r42.z();
        if (r128 != null) goto L296;
    L300:
        r42.Y0().R5();
        goto L364
    L296:
        if ((!r40.p) == false) goto L298;
        int r49 = 0;
    L299:
        r128.setVisibility(r49);
        goto L300
    L298:
        r49 = 8;
        goto L299
    L276:
        if (r116.intValue() != (-40)) goto L278;
    L348:
        ItemGroup r129 = r42.M();
        if (r129 == null) goto L351;
        r129.setVisibility(8);
    L351:
        ItemGroup r130 = r42.N();
        if (r130 == null) goto L354;
        r130.setVisibility(8);
    L354:
        ItemGroup r131 = r42.Q();
        if (r131 == null) goto L357;
        r131.setVisibility(0);
    L357:
        r42.N0().setVisibility(8);
        ItemTextView r50 = r42.z();
        if (r50 == null) goto L364;
        if ((!r40.p) == false) goto L362;
        int r51 = 0;
    L363:
        r50.setVisibility(r51);
        goto L364
    L362:
        r51 = 8;
        goto L363
    L272:
        if (r116.intValue() == (-10)) goto L348;
    L244:
        if (r41.intValue() != 3) goto L263;
        com.larus.bmhome.setting.c r52 = r40.g;
        if (r52 == null) goto L365;
        ItemGroup r53 = r52.M();
        if (r53 == null) goto L250;
        r53.setVisibility(0);
    L250:
        ItemTextArrow r54 = r52.F();
        if (r54 == null) goto L253;
        r54.setVisibility(0);
    L253:
        ItemGroup r55 = r52.N();
        if (r55 == null) goto L256;
        r55.setVisibility(8);
    L256:
        ItemGroup r56 = r52.Q();
        if (r56 == null) goto L259;
        r56.setVisibility(0);
    L259:
        r52.N0().setVisibility(0);
        ItemTextView r57 = r52.z();
        if (r57 == null) goto L262;
        r57.setVisibility(8);
    L262:
        Unit r58 = Unit.INSTANCE;
    L365:
        final CommonSettingFragment r59 = this.this$0;
        r59.getClass();
        v19.o5.b(r59, "access_permission_request", new q3(r59));
        final CommonSettingFragment r60 = this.this$0;
        com.larus.bmhome.setting.c r61 = r60.g;
        if (r61 == null) goto L578;
        BotModel r62 = r60.s;
        if (r62 != null) goto L370;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r62 = null;
    L370:
        int r63 = ni8.a.b(r62);
        if (r63 == (-40)) goto L381;
        if (r63 == (-10)) goto L381;
        BotModel r64 = r60.s;
        if (r64 != null) goto L376;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r64 = null;
    L376:
        BotIconImage r65 = r64.getIconImage();
        if (r65 == null) goto L379;
        final String r66 = r65.getOriginUrl();
    L380:
        if (r66 == null) goto L381;
    L382:
        BotModel r132 = r60.s;
        if (r132 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r132 = null;
    L385:
        int r133 = ni8.a.b(r132);
        if (r133 == (-40)) goto L395;
        if (r133 == (-10)) goto L392;
        BotModel r134 = r60.s;
        if (r134 != null) goto L391;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r134 = null;
    L391:
        String r135 = r134.getName();
    L399:
        BotModel r136 = r60.s;
        if (r136 != null) goto L402;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r136 = null;
    L402:
        int r137 = ni8.a.b(r136);
        if (r137 == (-40)) goto L406;
        if (r137 == (-10)) goto L406;
        boolean r67 = true;
    L407:
        BotModel r138 = r60.s;
        if (r138 != null) goto L411;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r138 = null;
    L411:
        if (r138.getBgImgOpen() == false) goto L437;
        BotModel r139 = r60.s;
        if (r139 != null) goto L416;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r139 = null;
    L416:
        if (com.larus.utils.o0.d(r139.getBgImgUrl()) == false) goto L437;
        if (r60.Ca0() == false) goto L437;
        RoundAvatarImageView r68 = r61.k();
        if (r68 == null) goto L422;
        com.larus.utils.e1.o(r68);
    L422:
        View r69 = r61.l();
        if (r69 == null) goto L425;
        com.larus.utils.e1.x(r69);
    L425:
        SimpleDraweeView r70 = r61.l();
        if ((r70 instanceof SimpleDraweeView) == false) goto L428;
        SimpleDraweeView r71 = r70;
    L429:
        if (r71 == null) goto L434;
        BotModel r140 = r60.s;
        if (r140 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r140 = null;
    L433:
        ImageLoaderKt.u(r71, r140.getBgImgUrl(), "chat_settings_setup_chat_info");
    L434:
        View r72 = r61.l();
        if (r72 == null) goto L449;
        com.larus.utils.e1.d(r72, new r(r60));
    L449:
        BotModel r141 = r60.s;
        if (r141 != null) goto L452;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r141 = null;
    L452:
        r60.Sa0(r141);
        wc9.e r73 = r60.q;
        if (r73 == null) goto L460;
        Integer r74 = r73.v;
        if (r74 == null) goto L460;
        if (r74.intValue() != 2) goto L460;
        boolean r75 = true;
    L461:
        FeatureKitDelegate r142 = FeatureKitDelegate.b;
        if (r142.R().b() == false) goto L489;
        if (r75 == false) goto L489;
        BotModel r143 = r60.s;
        if (r143 != null) goto L467;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r143 = null;
    L467:
        String r144 = r143.getBio();
        if (r144 != null) goto L470;
    L473:
        boolean r145 = true;
    L474:
        if (r145 == true) goto L489;
        TextView r146 = r61.m();
        if (r146 == null) goto L479;
        r146.setVisibility(0);
    L479:
        TextView r147 = r61.m();
        if (r147 == null) goto L492;
        BotModel r148 = r60.s;
        if (r148 != null) goto L484;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r148 = null;
    L484:
        if (r148 == null) goto L488;
        String r149 = r148.getBio();
        if (r149 == null) goto L488;
        r8 = r149;
    L488:
        r147.setText(r8);
    L492:
        r60.bb0(r135);
        BotModel r76 = r60.s;
        if (r76 != null) goto L495;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r76 = null;
    L495:
        r60.cb0(r76.getTagList());
        if (r67 == false) goto L574;
        BotModel r77 = r60.s;
        if (r77 != null) goto L500;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r77 = null;
    L500:
        BotCreatorInfo r78 = r77.getBotCreatorInfo();
        if (r78 == null) goto L503;
        String r79 = r78.getName();
    L505:
        if (com.larus.utils.o0.d(r79) == false) goto L574;
        LinearLayout r80 = r61.q();
        if (r80 == null) goto L509;
        r80.setVisibility(0);
    L509:
        if (r75 == true) goto L511;
    L527:
        boolean r81 = false;
    L528:
        ?? r82 = r61.n();
        if (r82 == 0) goto L563;
        if (r81 == false) goto L551;
        BotModel r83 = r60.s;
        if (r83 != null) goto L534;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r83 = null;
    L534:
        if (r83 == null) goto L539;
        BotStatistic r150 = r83.getBotStatic();
        if (r150 == null) goto L539;
        String r151 = r150.getDisplayHeatScore();
        if (r151 == null) goto L539;
    L540:
        Context r152 = r60.getContext();
        String r153 = r83.getBotFeatureLabel();
        BotCreatorInfo r84 = r83.getBotCreatorInfo();
        if (r84 == null) goto L543;
        String r85 = r84.getName();
    L544:
        String r86 = com.larus.bmhome.utils.i.a(r152, r153, r85);
        ?? r154 = new StringBuilder();
        r154.append(r151);
        int r155 = r154.length();
        r154.append("·");
        r154.append(r86);
        SpannableStringBuilder r87 = new SpannableStringBuilder(r154);
        if (r87.length() != 0) goto L547;
        boolean r156 = true;
    L548:
        if (r156 == true) goto L562;
        r87.setSpan(new r19.a(v19.i5.Y(), v19.i5.j0()), r155, r155 + 1, 33);
        r154 = r87;
    L562:
        r82.setText(r154);
        goto L563
    L547:
        r156 = false;
        goto L548
    L543:
        r85 = null;
    L539:
        r151 = "0";
        goto L540
    L551:
        Context r88 = r60.getContext();
        BotModel r157 = r60.s;
        if (r157 != null) goto L554;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r157 = null;
    L554:
        String r158 = r157.getBotFeatureLabel();
        BotModel r159 = r60.s;
        if (r159 != null) goto L557;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r159 = null;
    L557:
        BotCreatorInfo r160 = r159.getBotCreatorInfo();
        if (r160 == null) goto L560;
        String r161 = r160.getName();
    L561:
        r154 = com.larus.bmhome.utils.i.a(r88, r158, r161);
        goto L562
    L560:
        r161 = null;
    L563:
        AppCompatImageView r89 = r61.W();
        if (r89 == null) goto L570;
        if (r81 == false) goto L567;
        int r90 = 0;
    L568:
        r89.setVisibility(r90);
        goto L570
    L567:
        r90 = 8;
    L570:
        if (r142.z0().b() == false) goto L577;
        TextView r91 = r61.n();
        if (r91 == null) goto L577;
        com.larus.utils.e1.d(r91, new u(r60));
    L577:
        Unit r92 = Unit.INSTANCE;
        goto L578
    L511:
        if (r142.b().b() == false) goto L527;
        BotModel r93 = r60.s;
        if (r93 != null) goto L515;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r93 = null;
    L515:
        BotStatistic r94 = r93.getBotStatic();
        if (r94 == null) goto L518;
        String r95 = r94.getDisplayHeatScore();
    L519:
        if (r95 != null) goto L521;
    L524:
        boolean r96 = true;
    L525:
        if (r96 == true) goto L527;
        r81 = true;
        goto L528
    L521:
        if (StringsKt.isBlank(r95) == true) goto L524;
        r96 = false;
        goto L525
    L518:
        r95 = null;
        goto L519
    L503:
        r79 = null;
    L574:
        LinearLayout r97 = r61.q();
        if (r97 == null) goto L577;
        r97.setVisibility(8);
        goto L577
    L470:
        if (StringsKt.isBlank(r144) == true) goto L473;
        r145 = false;
    L489:
        TextView r99 = r61.m();
        if (r99 == null) goto L492;
        r99.setVisibility(8);
    L460:
        r75 = false;
        goto L461
    L428:
        r71 = null;
    L437:
        RoundAvatarImageView r162 = r61.k();
        if (r162 == null) goto L440;
        com.larus.utils.e1.x(r162);
    L440:
        View r163 = r61.l();
        if (r163 == null) goto L443;
        com.larus.utils.e1.o(r163);
    L443:
        RoundAvatarImageView r164 = r61.k();
        if (r164 == null) goto L446;
        ImageLoaderKt.v(r164, r66, "bot_setting.avatar_default", null, new s());
    L446:
        RoundAvatarImageView r165 = r61.k();
        if (r165 == null) goto L449;
        com.larus.utils.e1.d(r165, new t(r60, r66));
    L406:
        r67 = false;
        goto L407
    L392:
        Context r166 = r60.getContext();
        if (r166 == null) goto L398;
        r135 = r166.getString(2131900208);
    L398:
        r135 = null;
        goto L399
    L395:
        Context r167 = r60.getContext();
        if (r167 == null) goto L398;
        r135 = r167.getString(2131900801);
        goto L399
    L379:
        r66 = null;
    L381:
        r66 = "";
    L578:
        CommonSettingFragment.ta0(this.this$0);
        CommonSettingFragment.ya0(this.this$0);
        CommonSettingFragment.va0(this.this$0);
        CommonSettingFragment.ga0(this.this$0);
        CommonSettingFragment.na0(this.this$0);
        CommonSettingFragment.ba0(this.this$0);
        CommonSettingFragment.ca0(this.this$0);
        CommonSettingFragment.da0(this.this$0);
        CommonSettingFragment r100 = this.this$0;
        com.larus.bmhome.setting.c r101 = r100.g;
        if (r101 == null) goto L581;
        CommonSettingFragment.Aa0(r100, r101.Z0());
    L581:
        CommonSettingFragment.sa0(this.this$0);
        this.this$0.mb0();
        CommonSettingFragment.ha0(this.this$0);
        CommonSettingFragment.Z90(this.this$0);
        CommonSettingFragment.ra0(this.this$0);
        CommonSettingFragment.pa0(this.this$0);
        com.larus.bmhome.setting.c r102 = this.this$0.g;
        if (r102 == null) goto L586;
        ItemTextMenu r103 = r102.K();
        if (r103 == null) goto L586;
        com.larus.utils.e1.o(r103);
    L586:
        CommonSettingFragment.ea0(this.this$0);
        CommonSettingFragment.aa0(this.this$0);
        CommonSettingFragment.ua0(this.this$0);
        CommonSettingFragment.ja0(this.this$0);
        CommonSettingFragment.fa0(this.this$0);
        CommonSettingFragment.ia0(this.this$0);
        this.this$0.yb0();
        CommonSettingFragment.la0(this.this$0);
        CommonSettingFragment.hb0(this.this$0);
        CommonSettingFragment.ka0(this.this$0);
        CommonSettingFragment.xa0(this.this$0);
        this.this$0.jb0();
        CommonSettingFragment.za0(this.this$0);
        CommonSettingFragment.qa0(this.this$0);
        CommonSettingFragment.X90(this.this$0);
        CommonSettingFragment.wa0(this.this$0);
        CommonSettingFragment.oa0(this.this$0);
        final CommonSettingFragment r104 = this.this$0;
        com.larus.bmhome.setting.c r105 = r104.g;
        if (r105 == null) goto L595;
        com.larus.bmhome.chat.manager.settings.p r106 = r104.Z;
        String r168 = r104.n;
        if (r168 != null) goto L591;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r168 = null;
    L591:
        List<? extends List<String>> r107 = com.larus.platform.service.w2.a.k();
        if (r107 != null) goto L594;
        r107 = CollectionsKt.emptyList();
    L594:
        r106.a(r168, r105, r107);
        r104.Z.b(new m5(), new n5(r104));
    L595:
        CommonSettingFragment.ma0(this.this$0);
        this.this$0.tb0();
        com.larus.bmhome.setting.c r108 = this.this$0.g;
        if (r108 == null) goto L621;
        ViewGroup r169 = r108.m0();
        if (r169 == null) goto L621;
        if (r169.getVisibility() != 0) goto L602;
        boolean r109 = true;
    L603:
        if (r109 == true) goto L616;
        Iterator r170 = ViewGroupKt.getChildren(r169).iterator();
    L606:
        if (r170.hasNext() == false) goto L613;
        if (((View) r170.next()).getVisibility() != 0) goto L610;
        boolean r171 = true;
    L611:
        if (r171 == false) goto L606;
        boolean r172 = true;
    L614:
        if (r172 == false) goto L616;
        r5 = true;
        goto L616
    L610:
        r171 = false;
        goto L611
    L613:
        r172 = false;
    L616:
        if (r5 == true) goto L619;
        r169 = null;
    L619:
        if (r169 == null) goto L621;
        com.larus.utils.e1.x(r169);
        goto L621
    L602:
        r109 = false;
    L621:
        CommonSettingFragment r173 = this.this$0;
        if (r173.A == true) goto L627;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (CommonSettingFragment.Ga0(r173, r23, true, this, 12) != r2) goto L627;
        return r2;
    L184:
        if (r25.Ta0() == false) goto L187;
        FLogger.a.i(r25.e, "is immersive style, not show continue group");
        goto L195
    L187:
        if (((lq9.k) r25.G.getValue()).f() == false) goto L189;
    L196:
        r27 = true;
        goto L197
    L189:
        if (com.larus.bmhome.utils.i.f(r25.q) == true) goto L196;
        FLogger r174 = FLogger.a;
        String r175 = r25.e;
        StringBuilder r176 = new StringBuilder("cur is ugc bot, and not allow ugc bot use continue talk. conv_id=");
        wc9.e r177 = r25.q;
        if (r177 == null) goto L193;
        String r178 = r177.a;
    L194:
        r176.append(r178);
        r174.i(r175, r176.toString());
        goto L195
    L193:
        r178 = null;
    L171:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L174
    L11:
        r23 = (String) this.L$1;
        CoroutineScope r180 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        Object r181 = r24;
    L12:
        CoroutineScope r210 = r180;
        r12 = r23;
        wc9.e r182 = (wc9.e) r181;
        if (r182 != null) goto L133;
        CommonSettingFragment r183 = this.this$0;
        FLogger.a.e(r183.e, "Cannot find conversation " + r12);
        return Unit.INSTANCE;
    L133:
        CommonSettingFragment r184 = this.this$0;
        r184.q = r182;
        String r185 = r182.c;
        if (r185 != null) goto L136;
        r185 = "";
    L136:
        r184.o = r185;
        Integer r186 = r182.f;
        if (r186 != null) goto L140;
    L142:
        boolean r187 = false;
    L143:
        r184.p = r187;
        r4 = this.this$0;
        r4.r = r182.v;
        this.L$0 = r210;
        this.L$1 = r12;
        this.L$2 = r4;
        this.label = 2;
        r3 = CommonSettingFragment.Ga0(r4, r12, false, this, 14);
        if (r3 != r2) goto L146;
        return r2;
    L140:
        if (r186.intValue() != 1) goto L142;
        r187 = true;
        goto L143
    L13:
        ResultKt.throwOnFailure(r24);
        r180 = (CoroutineScope) this.L$0;
        CommonSettingFragment r188 = this.this$0;
        com.larus.bmhome.setting.c r189 = r188.g;
        if (r189 == null) goto L88;
        ItemTextArrow r190 = r189.b0();
        com.larus.platform.service.z2 r191 = com.larus.platform.service.z2.a;
        if (r191.q().f == false) goto L25;
        com.larus.bmhome.chat.api.e0 r192 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r192 == null) goto L22;
        LaunchInfo r193 = r192.a;
        if (r193 == null) goto L22;
        boolean r194 = Intrinsics.areEqual(r193.N0(), Boxing.boxBoolean(true));
    L23:
        if (r194 == true) goto L25;
        boolean r195 = true;
    L26:
        if (r195 == false) goto L28;
        int r196 = 0;
    L29:
        r190.setVisibility(r196);
        boolean r197 = r191.q3();
        ItemGroup r198 = r189.T();
        if (r198 == null) goto L35;
        if (r197 == false) goto L33;
        int r199 = 0;
    L34:
        r198.setVisibility(r199);
        goto L35
    L33:
        r199 = 8;
    L35:
        ItemTextArrow r200 = r189.S0();
        if (r197 == false) goto L38;
        int r201 = 0;
    L39:
        r200.setVisibility(r201);
        r188.kb0();
        if (r188.J == false) goto L60;
        ItemTextArrow r202 = r189.C();
        if (r202 == null) goto L88;
        if (r191.f() == false) goto L55;
        IFlowSdkDepend r203 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r203 == null) goto L52;
        com.larus.home.impl.sdk.s r204 = r203.s0();
        if (r204 == null) goto L52;
        if (r204.I("[setupViews-isAppSettingPage]") != true) goto L52;
        boolean r205 = true;
    L53:
        if (r205 == true) goto L55;
        boolean r206 = true;
    L56:
        if (r206 == false) goto L58;
        int r207 = 0;
    L59:
        r202.setVisibility(r207);
        goto L88
    L58:
        r207 = 8;
    L52:
        r205 = false;
    L55:
        r206 = false;
        goto L56
    L60:
        ItemTextArrow r208 = r189.C();
        if (r208 == null) goto L88;
        if (AccountService.a.isLogin().booleanValue() == false) goto L83;
        IFlowSdkDepend r209 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r209 == null) goto L71;
        com.larus.home.impl.sdk.s r211 = r209.s0();
        if (r211 == null) goto L71;
        if (r211.H() != true) goto L71;
        boolean r212 = true;
    L72:
        if (r212 == false) goto L83;
        IFlowSdkDepend r213 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r213 == null) goto L80;
        com.larus.home.impl.sdk.s r214 = r213.s0();
        if (r214 == null) goto L80;
        if (r214.I("[setupViews]") != true) goto L80;
        boolean r215 = true;
    L81:
        if (r215 == true) goto L83;
        boolean r216 = true;
    L84:
        if (r216 == false) goto L86;
        int r217 = 0;
    L87:
        r208.setVisibility(r217);
        goto L88
    L86:
        r217 = 8;
    L80:
        r215 = false;
    L71:
        r212 = false;
    L83:
        r216 = false;
        goto L84
    L38:
        r201 = 8;
        goto L39
    L28:
        r196 = 8;
    L22:
        r194 = false;
    L25:
        r195 = false;
    L88:
        this.this$0.tb0();
        r23 = this.this$0.n;
        if (r23 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r23 = null;
    L91:
        CommonSettingFragment r218 = this.this$0;
        if (r23.length() != 0) goto L94;
        boolean r219 = true;
    L95:
        if (r219 == false) goto L98;
        r23 = r218.La0();
    L98:
        if (this.this$0.J == true) goto L100;
    L124:
        CommonSettingFragment r220 = this.this$0;
        if (r220.s != null) goto L180;
        this.L$0 = r180;
        this.L$1 = r23;
        this.label = 1;
        r181 = CommonSettingFragment.W90(r220, r23, this);
        if (r181 != r2) goto L12;
        return r2;
    L100:
        if (r23.length() != 0) goto L102;
        boolean r221 = true;
    L103:
        if (r221 == false) goto L124;
        if (this.this$0.Va0() == false) goto L124;
        if (com.larus.platform.exp.o.a() == false) goto L124;
        com.larus.bmhome.setting.c r222 = this.this$0.g;
        if (r222 == null) goto L122;
        com.larus.utils.e1.o(r222.X());
        com.larus.utils.e1.o(r222.G());
        com.larus.utils.e1.o(r222.Z0());
        com.larus.utils.e1.o(r222.b0());
        com.larus.utils.e1.o(r222.e0());
        ItemGroup r223 = r222.U0();
        if (r223 == null) goto L113;
        com.larus.utils.e1.o(r223);
    L113:
        ItemGroup r224 = r222.q0();
        if (r224 == null) goto L116;
        com.larus.utils.e1.o(r224);
    L116:
        ItemGroup r225 = r222.T();
        if (r225 == null) goto L119;
        com.larus.utils.e1.o(r225);
    L119:
        com.larus.utils.e1.o(r222.S0());
        ItemTextMenu r226 = r222.K();
        if (r226 == null) goto L122;
        com.larus.utils.e1.o(r226);
    L122:
        this.this$0.tb0();
        return Unit.INSTANCE;
    L102:
        r221 = false;
        goto L103
    L94:
        r219 = false;
        goto L95
    }
}
