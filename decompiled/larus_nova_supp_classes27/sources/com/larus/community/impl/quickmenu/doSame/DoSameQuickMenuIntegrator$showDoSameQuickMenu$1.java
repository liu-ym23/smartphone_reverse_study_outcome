package com.larus.community.impl.quickmenu.doSame;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.quickmenu.DismissReason;
import com.larus.community.impl.quickmenu.QuickMenuConfig;
import com.larus.community.impl.quickmenu.QuickMenuPanelFragment;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.Icon;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.creation.ICreationService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
import o29.i;
import o29.j;
import org.json.JSONObject;
import sq9.b0;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$showDoSameQuickMenu$1", f = "DoSameQuickMenuIntegrator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {79}, m = "invokeSuspend", n = {"itemIds", "tplDetailInfo", "iconUrl", "showIconBorder", "showHighlightItem", "showUsePictureItem", "isDarkMode", "hasAvatar"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0", "Z$1"})
final class DoSameQuickMenuIntegrator$showDoSameQuickMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<DismissReason, Unit> $onDismiss;
    final /* synthetic */ Function2<j, Integer, Unit> $onItemClick;
    final /* synthetic */ JSONObject $trackParams;
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
    public DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(UserCreation r1, FragmentActivity r2, JSONObject r3, Function2<? super j, ? super Integer, Unit> r4, Function1<? super DismissReason, Unit> r5, Continuation<? super DoSameQuickMenuIntegrator$showDoSameQuickMenu$1> r6) {
        this.$userCreation = r1;
        this.$activity = r2;
        this.$trackParams = r3;
        this.$onItemClick = r4;
        this.$onDismiss = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(this.$userCreation, this.$activity, this.$trackParams, this.$onItemClick, this.$onDismiss, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.community.impl.quickmenu.doSame.b, java.lang.Object] */
    public final Object invokeSuspend(Object r30) {
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
        ResultKt.throwOnFailure(r30);
        Object r5 = r30;
    L126:
        String r6 = (String) r5;
        if (r6 != null) goto L129;
    L132:
        boolean r14 = true;
    L133:
        if (r14 == false) goto L135;
        r6 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131241188";
    L136:
        boolean r15 = r3;
        boolean r16 = r4;
        int r17 = r7;
        Ref.BooleanRef r18 = r10;
        Ref.ObjectRef r110 = r9;
    L140:
        r110.element = r6;
        r13.add("replace_pic");
        final Ref.BooleanRef r22 = r18;
        final Ref.ObjectRef r20 = r11;
    L141:
        final Ref.ObjectRef r111 = r12;
        List r112 = r13;
        final boolean r21 = r16;
        final boolean r113 = r15;
        r112.add("use_picture");
        r112.add("use_prompt");
        FragmentActivity r23 = this.$activity;
        if (r8 == 0) goto L146;
        final boolean r114 = true;
    L147:
        if (r17 == 0) goto L149;
        final boolean r24 = true;
    L150:
        final UserCreation r25 = this.$userCreation;
        final Function2<j, Integer, Unit> r26 = this.$onItemClick;
        final JSONObject r27 = this.$trackParams;
        final Function1<DismissReason, Unit> r28 = this.$onDismiss;
        ?? r31 = new b(r114, r111, r20, r21, r22, r24, r25, r26, r113, r27, r28);
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Intrinsics.checkNotNullParameter(r31, "builder");
        int r32 = com.larus.community.impl.quickmenu.a.a;
        com.larus.community.impl.quickmenu.a.C0021a r33 = new com.larus.community.impl.quickmenu.a.C0021a();
        r31.invoke(r33);
        Intrinsics.checkNotNullParameter(r23, "activity");
        FragmentManager r34 = r23.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r34, "fragmentManager");
        i r35 = r33.a;
        r35.getClass();
        QuickMenuConfig r36 = new QuickMenuConfig(null, CollectionsKt.toList(r35.a), r35.b, r35.c, 1, null);
        Intrinsics.checkNotNullParameter(r34, "fragmentManager");
        Intrinsics.checkNotNullParameter(r36, "config");
        int r37 = QuickMenuPanelFragment.i;
        Intrinsics.checkNotNullParameter(r36, "config");
        QuickMenuPanelFragment r38 = new QuickMenuPanelFragment();
        r38.setArguments(new Bundle());
        r38.e = r36;
        LandscapeRestrictionOperation r40 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r38, "QuickMenuPanelFragment", r40);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r34, r38, r40) == false) goto L158;
    L155:
        Lazy r41 = e.a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(r112, this.$userCreation, r113, this.$trackParams, null), 3, null);
        return Unit.INSTANCE;
    L158:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L157
    L154:
        r38.show(r34, "QuickMenuPanelFragment");
        goto L155
    L149:
        r24 = false;
        goto L150
    L146:
        r114 = false;
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
        ResultKt.throwOnFailure(r30);
        r13 = new ArrayList();
        CreationDynamicInfo r42 = this.$userCreation.h;
        String r43 = null;
        if (r42 == null) goto L13;
        TplInfo r44 = r42.e;
        if (r44 == null) goto L13;
        TplDetail r45 = r44.b;
    L15:
        if (r45 == null) goto L33;
        if (r42 == null) goto L20;
        TplInfo r46 = r42.e;
        if (r46 == null) goto L20;
        TplDetail r47 = r46.c;
    L21:
        if (r47 == null) goto L33;
        List r48 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1)});
        CreationDynamicInfo r50 = this.$userCreation.h;
        if (r50 == null) goto L29;
        TplInfo r51 = r50.e;
        if (r51 == null) goto L29;
        TplDetail r52 = r51.b;
        if (r52 == null) goto L29;
        Integer r53 = r52.a;
    L31:
        if (CollectionsKt.contains(r48, r53) == false) goto L33;
        r8 = 1;
    L34:
        b0 r54 = e.a();
        if (r54 == null) goto L37;
        String r55 = r54.useImageShowName;
    L38:
        if (r55 != null) goto L40;
    L43:
        boolean r56 = true;
    L44:
        if (r56 == true) goto L79;
        b0 r57 = e.a();
        if (r57 == null) goto L48;
        String r58 = r57.useImageShowDesc;
    L49:
        if (r58 != null) goto L51;
    L54:
        boolean r60 = true;
    L55:
        if (r60 == true) goto L79;
        b0 r61 = e.a();
        if (r61 == null) goto L59;
        String r62 = r61.usePromptShowName;
    L60:
        if (r62 != null) goto L62;
    L65:
        boolean r63 = true;
    L66:
        if (r63 == true) goto L79;
        b0 r64 = e.a();
        if (r64 == null) goto L70;
        String r65 = r64.usePromptShowDesc;
    L71:
        if (r65 != null) goto L73;
    L76:
        boolean r66 = true;
    L77:
        if (r66 == true) goto L79;
        r17 = 1;
    L80:
        r12 = new Ref.ObjectRef();
        r110 = new Ref.ObjectRef();
        r110.element = "";
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        boolean r116 = h.a;
        r16 = h.b(this.$activity);
        r15 = IUgcAIGCService.a.v();
        if (r8 == 0) goto L142;
        if (r15 == false) goto L88;
        CreationDynamicInfo r67 = this.$userCreation.h;
        if (r67 == null) goto L93;
        TplInfo r68 = r67.e;
        if (r68 == null) goto L93;
        TplDetail r70 = r68.c;
    L94:
        r12.element = r70;
        if (r16 == false) goto L100;
        if (r70 == null) goto L104;
        Icon r71 = r70.f;
        if (r71 == null) goto L104;
        r43 = r71.b;
    L104:
        if (r43 != null) goto L106;
    L109:
        boolean r72 = true;
    L110:
        if (r72 == false) goto L139;
        TplDetail r73 = (TplDetail) r12.element;
        if (r73 == null) goto L119;
        Integer r74 = r73.a;
        if (r74 == null) goto L119;
        if (r74.intValue() != 2) goto L119;
        boolean r75 = true;
    L120:
        if (r75 == false) goto L138;
        if (r15 == false) goto L137;
        ICreationService.Companion r76 = ICreationService.a;
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = r110;
        this.L$3 = r115;
        this.L$4 = r110;
        this.I$0 = r8;
        this.I$1 = r17;
        this.Z$0 = r16;
        this.Z$1 = r15;
        this.label = 1;
        r5 = r76.a(this);
        if (r5 != r1) goto L125;
        return r1;
    L125:
        r7 = r17;
        r9 = r110;
        r4 = r16;
        r3 = r15;
        r10 = r115;
        r11 = r9;
        goto L126
    L137:
        r43 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131241188";
        goto L139
    L138:
        r115.element = true;
        r43 = this.$userCreation.e();
    L119:
        r75 = false;
    L139:
        r6 = r43;
        r18 = r115;
        r11 = r110;
        goto L140
    L106:
        if (StringsKt.isBlank(r43) == true) goto L109;
        r72 = false;
        goto L110
    L100:
        if (r70 == null) goto L104;
        Icon r77 = r70.f;
        if (r77 == null) goto L104;
        r43 = r77.a;
    L93:
        r70 = null;
        goto L94
    L88:
        CreationDynamicInfo r78 = this.$userCreation.h;
        if (r78 == null) goto L93;
        TplInfo r80 = r78.e;
        if (r80 == null) goto L93;
        r70 = r80.b;
        goto L94
    L142:
        r20 = r110;
        r22 = r115;
        goto L141
    L73:
        if (r65.length() == 0) goto L76;
        r66 = false;
        goto L77
    L70:
        r65 = null;
        goto L71
    L62:
        if (r62.length() == 0) goto L65;
        r63 = false;
        goto L66
    L59:
        r62 = null;
        goto L60
    L51:
        if (r58.length() == 0) goto L54;
        r60 = false;
        goto L55
    L48:
        r58 = null;
    L79:
        r17 = 0;
        goto L80
    L40:
        if (r55.length() == 0) goto L43;
        r56 = false;
        goto L44
    L37:
        r55 = null;
    L29:
        r53 = null;
    L20:
        r47 = null;
    L33:
        r8 = 0;
    L13:
        r45 = null;
        goto L15
    }
}
