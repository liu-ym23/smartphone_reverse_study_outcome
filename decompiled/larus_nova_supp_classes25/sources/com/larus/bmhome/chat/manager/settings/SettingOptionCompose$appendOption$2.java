package com.larus.bmhome.chat.manager.settings;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.im.bean.bot.BotModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionCompose$appendOption$2", f = "SettingOptionCompose.kt", i = {}, l = {76, 78, 79}, m = "invokeSuspend", n = {}, s = {})
final class SettingOptionCompose$appendOption$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<List<String>> $configGroups;
    final /* synthetic */ LinearLayout $container;
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ o this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingOptionCompose$appendOption$2(o r1, LinearLayout r2, String r3, List<? extends List<String>> r4, Continuation<? super SettingOptionCompose$appendOption$2> r5) {
        this.this$0 = r1;
        this.$container = r2;
        this.$conversationId = r3;
        this.$configGroups = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SettingOptionCompose$appendOption$2(this.this$0, this.$container, this.$conversationId, this.$configGroups, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        SettingOptionCompose$appendOption$2 r0 = this;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Context r7 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        o r3 = (o) r0.L$0;
        ResultKt.throwOnFailure(r17);
        Object r4 = r17;
    L41:
        BotModel r5 = (BotModel) r4;
        o r6 = r3;
    L43:
        r6.d = r5;
    L44:
        SettingOptionViewModel r8 = r0.this$0.a;
        if (r8 == null) goto L47;
        r8.updateUserConfigs();
    L47:
        Iterator<List<String>> r9 = r0.$configGroups.iterator();
    L49:
        if (r9.hasNext() == false) goto L137;
        List<String> r10 = r9.next();
        if (r10.isEmpty() == true) goto L49;
        r0.this$0.getClass();
        if (r10.contains("suggest_prompt") == false) goto L56;
    L69:
        boolean r11 = true;
    L70:
        if (r11 == false) goto L49;
        t r12 = r0.this$0.b;
        LinearLayout r14 = r0.$container;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "container");
        ItemGroup r13 = new ItemGroup(r14.getContext());
        r13.setBackgroundResource(v19.c.b(2130970593, r13.getContext(), 2131238744));
        r14.addView(r13);
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        r16.width = -1;
        r16.height = -1;
        r16.topMargin = i5.E();
        final o r18 = r0.this$0;
        r18.getClass();
        Iterator<String> r19 = r10.iterator();
    L74:
        if (r19.hasNext() == false) goto L135;
        String r20 = r19.next();
        switch(r20.hashCode()) {
            case -1412013699: goto L127;
            case -1286187950: goto L112;
            case -305517953: goto L102;
            case 374609234: goto L99;
            case 926873033: goto L95;
            case 942867471: goto L87;
            case 1886324560: goto L79;
            default: goto L74;
        };
    L87:
        if (r20.equals("input_suggest") == false) goto L134;
        t r21 = r18.b;
        int r22 = v19.c.b(2130971743, null, 2131241446);
        r21.getClass();
        final ItemTextToggle r23 = t.b(r13, 2131910921, r22);
        final SettingOptionViewModel r24 = r18.a;
        if (r24 == null) goto L134;
        r23.getToggleView().setChecked(r24.isInputSuggestEnable());
        r23.getToggleView().setOnClickListener(new b(r24, r23));
        LifecycleOwner r25 = ViewTreeLifecycleOwner.get(r23);
        if (r25 == null) goto L134;
        r24.getInputSuggestEnableLiveData().observe(r25, new o.a(new c(r23, r24)));
    L134:
        r7 = null;
        goto L74
    L95:
        if (r20.equals("privacy_policy") == false) goto L134;
        r18.b.getClass();
        final ItemTextArrow r26 = t.a(r13, 2131908512, 2131241771);
        r26.setOnClickListener(new l(r26));
        goto L134
    L99:
        if (r20.equals("use_agreement") == false) goto L134;
        t r27 = r18.b;
        Context r110 = null;
        int r28 = v19.c.b(2130971887, null, 2131242256);
        r27.getClass();
        final ItemTextArrow r29 = t.a(r13, 2131910461, r28);
        r29.setOnClickListener(new e(r29));
    L110:
        r7 = r110;
        goto L74
    L102:
        r110 = r7;
        if (r20.equals("suggest_prompt") == false) goto L110;
        r18.b.getClass();
        final ItemTextToggle r30 = t.b(r13, 2131909389, 2131241775);
        final SettingOptionViewModel r31 = r18.a;
        if (r31 == null) goto L110;
        r30.getToggleView().setChecked(r31.isPromptEnabled());
        r30.getToggleView().setOnClickListener(new a(r31, r30));
        LifecycleOwner r32 = ViewTreeLifecycleOwner.get(r30);
        if (r32 == null) goto L110;
        r31.getAnswerWithSuggestLiveData().observe(r32, new o.a(new d(r30, r31)));
        goto L134
    L112:
        if (r20.equals("message_push") == false) goto L134;
        if (r18.d == null) goto L134;
        r18.b.getClass();
        final ItemTextToggle r33 = t.b(r13, 2131899733, 2131240826);
        final SettingOptionViewModel r34 = r18.a;
        if (r34 == null) goto L134;
        CustomSwitchCompat r35 = r33.getToggleView();
        BotModel r111 = r18.d;
        if (r111 == null) goto L122;
        boolean r112 = Intrinsics.areEqual(r111.getMessagePush(), Boolean.TRUE);
    L123:
        r35.setChecked(r112);
        r33.getToggleView().setOnClickListener(new f(r33, r18, r34));
        final LifecycleOwner r36 = ViewTreeLifecycleOwner.get(r33);
        if (r36 == null) goto L134;
        r34.getMessagePushLiveData().observe(r36, new o.a(new g(r36, r18, r34, r33)));
        goto L134
    L122:
        r112 = false;
        goto L123
    L127:
        if (r20.equals("personal_recommend") == false) goto L134;
        r18.b.getClass();
        final ItemTextToggle r37 = t.b(r13, 2131910233, 2131241711);
        final SettingOptionViewModel r38 = r18.a;
        if (r38 == null) goto L134;
        r37.getToggleView().setChecked(r38.isPersonalizedRecommendEnable());
        r37.getToggleView().setOnClickListener(new h(r37, r38));
        LifecycleOwner r39 = ViewTreeLifecycleOwner.get(r37);
        if (r39 == null) goto L134;
        r38.getPersonalizedRecommendLiveData().observe(r39, new o.a(new i(r37, r38)));
        goto L134
    L79:
        if (r20.equals("high_light_word") == false) goto L74;
        t r40 = r18.b;
        int r113 = v19.c.b(2130971733, r7, 2131241409);
        r40.getClass();
        final ItemTextToggle r41 = t.b(r13, 2131906282, r113);
        final SettingOptionViewModel r114 = r18.a;
        if (r114 == null) goto L74;
        r41.getToggleView().setChecked(r114.isHighlightEnabled());
        r41.getToggleView().setOnClickListener(new j(r114, r41));
        LifecycleOwner r42 = ViewTreeLifecycleOwner.get(r41);
        if (r42 == null) goto L134;
        r114.getHighlightEngineEnableLiveData().observe(r42, new o.a(new k(r41, r114)));
        goto L134
    L135:
        r0 = this;
        goto L49
    L56:
        if (r10.contains("input_suggest") == true) goto L69;
        if (r10.contains("high_light_word") == true) goto L69;
        if (r10.contains("message_push") == true) goto L69;
        if (r10.contains("use_agreement") == true) goto L69;
        if (r10.contains("privacy_policy") == true) goto L69;
        if (r10.contains("personal_recommend") == true) goto L69;
        r11 = false;
        goto L70
    L137:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r6 = (o) r0.L$0;
        ResultKt.throwOnFailure(r17);
        Object r43 = r17;
    L33:
        String r44 = (String) CollectionsKt.firstOrNull((List) r43);
        if (r44 == null) goto L44;
        SettingOptionViewModel r45 = r6.a;
        if (r45 == null) goto L42;
        r0.L$0 = r6;
        r0.label = 3;
        r4 = r45.findBot(r44, r0);
        if (r4 != r1) goto L40;
        return r1;
    L40:
        r3 = r6;
        goto L41
    L42:
        r5 = null;
        goto L43
    L11:
        o r46 = (o) r0.L$0;
        ResultKt.throwOnFailure(r17);
        Object r47 = r17;
    L26:
        wc9.e r48 = (wc9.e) r47;
    L28:
        r46.c = r48;
        r6 = r0.this$0;
        wc9.e r49 = r6.c;
        if (r49 == null) goto L44;
        r0.L$0 = r6;
        r0.label = 2;
        r43 = ic8.n.c(r49, r0);
        if (r43 != r1) goto L33;
        return r1;
    L12:
        ResultKt.throwOnFailure(r17);
        o r50 = r0.this$0;
        ViewModelStoreOwner r51 = ViewTreeViewModelStoreOwner.get(r0.$container);
        r50.getClass();
        if (r51 != null) goto L15;
        SettingOptionViewModel r52 = null;
    L16:
        r50.a = r52;
        if (r0.$conversationId.length() <= 0) goto L19;
        boolean r53 = true;
    L20:
        if (r53 == false) goto L44;
        r46 = r0.this$0;
        SettingOptionViewModel r54 = r46.a;
        if (r54 == null) goto L27;
        String r55 = r0.$conversationId;
        r0.L$0 = r46;
        r0.label = 1;
        r47 = r54.findConversation(r55, r0);
        if (r47 != r1) goto L26;
        return r1;
    L27:
        r48 = null;
        goto L28
    L19:
        r53 = false;
        goto L20
    L15:
        r52 = new ViewModelProvider(r51).get(SettingOptionViewModel.class);
        goto L16
    }
}
