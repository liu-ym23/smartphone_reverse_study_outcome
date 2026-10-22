package com.larus.ugc.feed.impl.quickmenu.doSame;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.Icon;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.uaigc.creation.ICreationService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ugc.feed.impl.quickmenu.DismissReason;
import com.larus.ugc.feed.impl.quickmenu.QuickMenuConfig;
import com.larus.ugc.feed.impl.quickmenu.QuickMenuPanelFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import sq9.b0;
import v19.h;
import x0a.i;
import x0a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$showDoSameQuickMenu$1", f = "DoSameQuickMenuIntegrator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {85}, m = "invokeSuspend", n = {"itemIds", "tplDetailInfo", "iconUrl", "showIconBorder", "showHighlightItem", "showUsePictureItem", "isDarkMode", "hasAvatar"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0", "Z$1"})
final class DoSameQuickMenuIntegrator$showDoSameQuickMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<DismissReason, Unit> $onDismiss;
    final /* synthetic */ Function2<j, Integer, Unit> $onItemClick;
    final /* synthetic */ String $recommendFrom;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ o0a.a $tracker;
    final /* synthetic */ UserCreation $userCreation;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(UserCreation r1, FragmentActivity r2, o0a.a r3, String r4, String r5, Function2<? super j, ? super Integer, Unit> r6, Function1<? super DismissReason, Unit> r7, Continuation<? super DoSameQuickMenuIntegrator$showDoSameQuickMenu$1> r8) {
        this.$userCreation = r1;
        this.$activity = r2;
        this.$tracker = r3;
        this.$recommendFrom = r4;
        this.$showFrom = r5;
        this.$onItemClick = r6;
        this.$onDismiss = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(this.$userCreation, this.$activity, this.$tracker, this.$recommendFrom, this.$showFrom, this.$onItemClick, this.$onDismiss, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r8v17, types: [com.larus.ugc.feed.impl.quickmenu.doSame.b, java.lang.Object] */
    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        boolean r3 = this.Z$1;
        boolean r4 = this.Z$0;
        int r7 = this.I$1;
        int r8 = this.I$0;
        Ref.ObjectRef r9 = (Ref.ObjectRef) this.L$4;
        Ref.BooleanRef r10 = (Ref.BooleanRef) this.L$3;
        Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$2;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$1;
        List r13 = (List) this.L$0;
        ResultKt.throwOnFailure(r31);
        Object r5 = r31;
    L126:
        String r6 = (String) r5;
        if (r6 != null) goto L129;
    L132:
        boolean r14 = true;
    L133:
        if (r14 == false) goto L135;
        r6 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131241189";
    L136:
        boolean r15 = r3;
        boolean r16 = r4;
        int r17 = r7;
        Ref.BooleanRef r18 = r10;
        Ref.ObjectRef r19 = r9;
    L140:
        r19.element = r6;
        r13.add(DoSameQuickMenuType.REPLACE_PIC);
        final Ref.BooleanRef r21 = r18;
        final Ref.ObjectRef r110 = r11;
    L141:
        final Ref.ObjectRef r111 = r12;
        final boolean r20 = r16;
        r13.add(DoSameQuickMenuType.USE_PICTURE);
        r13.add("use_prompt");
        FragmentActivity r22 = this.$activity;
        if (r8 == 0) goto L146;
        final boolean r112 = true;
    L147:
        if (r17 == 0) goto L149;
        final boolean r23 = true;
    L150:
        final UserCreation r24 = this.$userCreation;
        final Function2<j, Integer, Unit> r25 = this.$onItemClick;
        final o0a.a r26 = this.$tracker;
        final String r27 = this.$recommendFrom;
        final String r28 = this.$showFrom;
        final Function1<DismissReason, Unit> r29 = this.$onDismiss;
        final boolean r210 = r15;
        ?? r30 = new b(r112, r111, r110, r20, r21, r23, r24, r25, r26, r27, r28, r210, r29);
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter(r30, "builder");
        int r32 = com.larus.ugc.feed.impl.quickmenu.a.a;
        com.larus.ugc.feed.impl.quickmenu.a.C0047a r33 = new com.larus.ugc.feed.impl.quickmenu.a.C0047a();
        r30.invoke(r33);
        Intrinsics.checkNotNullParameter(r22, "activity");
        FragmentManager r34 = r22.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r34, "fragmentManager");
        i r35 = r33.a;
        r35.getClass();
        QuickMenuConfig r113 = new QuickMenuConfig(null, CollectionsKt.toList(r35.a), r35.b, r35.c, 1, null);
        Intrinsics.checkNotNullParameter(r34, "fragmentManager");
        Intrinsics.checkNotNullParameter(r113, "config");
        int r36 = QuickMenuPanelFragment.i;
        Intrinsics.checkNotNullParameter(r113, "config");
        QuickMenuPanelFragment r37 = new QuickMenuPanelFragment();
        r37.setArguments(new Bundle());
        r37.e = r113;
        LandscapeRestrictionOperation r38 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r37, "QuickMenuPanelFragment", r38);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r34, r37, r38) == false) goto L158;
    L155:
        Lazy r39 = e.a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(r13, this.$tracker, this.$recommendFrom, this.$userCreation, this.$showFrom, r15, null), 3, null);
        return Unit.INSTANCE;
    L158:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L157
    L154:
        r37.show(r34, "QuickMenuPanelFragment");
        goto L155
    L149:
        r23 = false;
        goto L150
    L146:
        r112 = false;
        goto L147
    L135:
        r10.element = true;
        goto L136
    L129:
        if (StringsKt.isBlank(r6) == true) goto L132;
        r14 = false;
        goto L133
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        r13 = new ArrayList();
        CreationDynamicInfo r40 = this.$userCreation.h;
        String r41 = null;
        if (r40 == null) goto L13;
        TplInfo r42 = r40.e;
        if (r42 == null) goto L13;
        TplDetail r43 = r42.b;
    L15:
        if (r43 == null) goto L33;
        if (r40 == null) goto L20;
        TplInfo r44 = r40.e;
        if (r44 == null) goto L20;
        TplDetail r45 = r44.c;
    L21:
        if (r45 == null) goto L33;
        List r46 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1)});
        CreationDynamicInfo r47 = this.$userCreation.h;
        if (r47 == null) goto L29;
        TplInfo r48 = r47.e;
        if (r48 == null) goto L29;
        TplDetail r49 = r48.b;
        if (r49 == null) goto L29;
        Integer r50 = r49.a;
    L31:
        if (CollectionsKt.contains(r46, r50) == false) goto L33;
        r8 = 1;
    L34:
        b0 r51 = e.a();
        if (r51 == null) goto L37;
        String r52 = r51.useImageShowName;
    L38:
        if (r52 != null) goto L40;
    L43:
        boolean r53 = true;
    L44:
        if (r53 == true) goto L79;
        b0 r54 = e.a();
        if (r54 == null) goto L48;
        String r55 = r54.useImageShowDesc;
    L49:
        if (r55 != null) goto L51;
    L54:
        boolean r56 = true;
    L55:
        if (r56 == true) goto L79;
        b0 r57 = e.a();
        if (r57 == null) goto L59;
        String r58 = r57.usePromptShowName;
    L60:
        if (r58 != null) goto L62;
    L65:
        boolean r59 = true;
    L66:
        if (r59 == true) goto L79;
        b0 r60 = e.a();
        if (r60 == null) goto L70;
        String r61 = r60.usePromptShowDesc;
    L71:
        if (r61 != null) goto L73;
    L76:
        boolean r62 = true;
    L77:
        if (r62 == true) goto L79;
        r17 = 1;
    L80:
        r12 = new Ref.ObjectRef();
        r19 = new Ref.ObjectRef();
        r19.element = "";
        Ref.BooleanRef r114 = new Ref.BooleanRef();
        boolean r115 = h.a;
        r16 = h.b(this.$activity);
        r15 = IUgcAIGCService.a.v();
        if (r8 == 0) goto L142;
        if (r15 == false) goto L88;
        CreationDynamicInfo r63 = this.$userCreation.h;
        if (r63 == null) goto L93;
        TplInfo r64 = r63.e;
        if (r64 == null) goto L93;
        TplDetail r65 = r64.c;
    L94:
        r12.element = r65;
        if (r16 == false) goto L100;
        if (r65 == null) goto L104;
        Icon r66 = r65.f;
        if (r66 == null) goto L104;
        r41 = r66.b;
    L104:
        if (r41 != null) goto L106;
    L109:
        boolean r67 = true;
    L110:
        if (r67 == false) goto L139;
        TplDetail r68 = (TplDetail) r12.element;
        if (r68 == null) goto L119;
        Integer r69 = r68.a;
        if (r69 == null) goto L119;
        if (r69.intValue() != 2) goto L119;
        boolean r70 = true;
    L120:
        if (r70 == false) goto L138;
        if (r15 == false) goto L137;
        ICreationService.Companion r71 = ICreationService.a;
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = r19;
        this.L$3 = r114;
        this.L$4 = r19;
        this.I$0 = r8;
        this.I$1 = r17;
        this.Z$0 = r16;
        this.Z$1 = r15;
        this.label = 1;
        r5 = r71.a(this);
        if (r5 != r1) goto L125;
        return r1;
    L125:
        r7 = r17;
        r9 = r19;
        r4 = r16;
        r3 = r15;
        r10 = r114;
        r11 = r9;
        goto L126
    L137:
        r41 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131241189";
        goto L139
    L138:
        r114.element = true;
        r41 = this.$userCreation.e();
    L119:
        r70 = false;
    L139:
        r6 = r41;
        r18 = r114;
        r11 = r19;
        goto L140
    L106:
        if (StringsKt.isBlank(r41) == true) goto L109;
        r67 = false;
        goto L110
    L100:
        if (r65 == null) goto L104;
        Icon r72 = r65.f;
        if (r72 == null) goto L104;
        r41 = r72.a;
    L93:
        r65 = null;
        goto L94
    L88:
        CreationDynamicInfo r73 = this.$userCreation.h;
        if (r73 == null) goto L93;
        TplInfo r74 = r73.e;
        if (r74 == null) goto L93;
        r65 = r74.b;
        goto L94
    L142:
        r110 = r19;
        r21 = r114;
        goto L141
    L73:
        if (r61.length() == 0) goto L76;
        r62 = false;
        goto L77
    L70:
        r61 = null;
        goto L71
    L62:
        if (r58.length() == 0) goto L65;
        r59 = false;
        goto L66
    L59:
        r58 = null;
        goto L60
    L51:
        if (r55.length() == 0) goto L54;
        r56 = false;
        goto L55
    L48:
        r55 = null;
    L79:
        r17 = 0;
        goto L80
    L40:
        if (r52.length() == 0) goto L43;
        r53 = false;
        goto L44
    L37:
        r52 = null;
    L29:
        r50 = null;
    L20:
        r45 = null;
    L33:
        r8 = 0;
    L13:
        r43 = null;
        goto L15
    }
}
