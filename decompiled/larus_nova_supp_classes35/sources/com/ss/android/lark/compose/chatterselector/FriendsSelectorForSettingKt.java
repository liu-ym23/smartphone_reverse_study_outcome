package com.ss.android.lark.compose.chatterselector;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.flow.chat.creategroup.data.f;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FriendsSelectorForSettingKt {

    public static final class a extends BasePicker.IOnPickNotify {
        public final /* synthetic */ State<Function2<String, SearchBaseInfo, Unit>> a;
        public final /* synthetic */ State<Function2<String, SearchBaseInfo, Unit>> b;
        public final /* synthetic */ State<Function2<List<String>, List<? extends SearchBaseInfo>, Unit>> c;

        public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            Intrinsics.checkNotNullParameter(r3, "infoList");
            ((Function2) this.c.getValue()).invoke(r2, r3);
        }

        public final void onDeSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
            ((Function2) this.b.getValue()).invoke(r2, r3);
        }

        public final void onSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
            ((Function2) this.a.getValue()).invoke(r2, r3);
        }

        public a(State<? extends Function2<? super String, ? super SearchBaseInfo, Unit>> r1, State<? extends Function2<? super String, ? super SearchBaseInfo, Unit>> r2, State<? extends Function2<? super List<String>, ? super List<? extends SearchBaseInfo>, Unit>> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements f {
        public final /* synthetic */ String a;

        public final Long getChatId() {
            if (this.a.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L12;
            return null;
        L12:
            return Long.valueOf(CastLongProtector.parseLong(this.a));
        L14:
            return null;
        L5:
            r0 = false;
            goto L7
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static final void a(final FragmentActivity r22, Modifier r23, FragmentManager r24, final String r25, List<? extends SearchBaseInfo> r26, Function2<? super String, ? super SearchBaseInfo, Unit> r27, Function2<? super String, ? super SearchBaseInfo, Unit> r28, Function2<? super List<String>, ? super List<? extends SearchBaseInfo>, Unit> r29, String r30, Composer r31, final int r32, final int r33) {
        Intrinsics.checkNotNullParameter(r22, "activity");
        Intrinsics.checkNotNullParameter(r25, "chatId");
        Composer r2 = r31.startRestartGroup(-1402910757);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L13:
        int r6 = r33 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r32 & 384) == 0) goto L27;
        FragmentManager r8 = r24;
    L36:
        if ((r33 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        int r9 = r33 & 16;
        if (r9 == 0) goto L49;
        r3 = r3 | 24576;
    L55:
        final List<? extends SearchBaseInfo> r13 = r26;
    L56:
        int r14 = r33 & 32;
        if (r14 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        Function2<? super String, ? super SearchBaseInfo, Unit> r15 = r27;
    L67:
        int r16 = r33 & 64;
        if (r16 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        int r12 = r33 & 128;
        if (r12 == 0) goto L81;
        r3 = r3 | 12582912;
    L87:
        int r0 = r33 & 256;
        if (r0 == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((r3 & 38347923) == 38347922) goto L100;
    L103:
        r2.startDefaults();
        if ((r32 & 1) != 0) goto L106;
    L112:
        if (r6 == 0) goto L114;
        Modifier r5 = Modifier.Companion;
    L116:
        if ((r33 & 4) == 0) goto L118;
        FragmentManager r7 = r22.getSupportFragmentManager();
        r3 = r3 & (-897);
    L119:
        if (r9 == 0) goto L121;
        r13 = null;
    L121:
        if (r14 == 0) goto L126;
        r2.startReplaceGroup(1849434622);
        Object r10 = r2.rememberedValue();
        if (r10 != Composer.Companion.getEmpty()) goto L125;
        r10 = FriendsSelectorForSettingKt$FriendsSelectorForSetting$1$1.INSTANCE;
        r2.updateRememberedValue(r10);
    L125:
        Function2<? super String, ? super SearchBaseInfo, Unit> r11 = (Function2) r10;
        r2.endReplaceGroup();
    L127:
        if (r16 == 0) goto L132;
        r2.startReplaceGroup(1849434622);
        Object r17 = r2.rememberedValue();
        if (r17 != Composer.Companion.getEmpty()) goto L131;
        r17 = FriendsSelectorForSettingKt$FriendsSelectorForSetting$2$1.INSTANCE;
        r2.updateRememberedValue(r17);
    L131:
        Function2<? super String, ? super SearchBaseInfo, Unit> r18 = (Function2) r17;
        r2.endReplaceGroup();
    L133:
        if (r12 == 0) goto L138;
        r2.startReplaceGroup(1849434622);
        Object r19 = r2.rememberedValue();
        if (r19 != Composer.Companion.getEmpty()) goto L137;
        r19 = FriendsSelectorForSettingKt$FriendsSelectorForSetting$3$1.INSTANCE;
        r2.updateRememberedValue(r19);
    L137:
        Function2<? super List<String>, ? super List<? extends SearchBaseInfo>, Unit> r110 = (Function2) r19;
        r2.endReplaceGroup();
    L139:
        if (r0 == 0) goto L141;
        final String r1 = null;
    L142:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventStart(-1402910757, r3, -1, "com.ss.android.lark.compose.chatterselector.FriendsSelectorForSetting (FriendsSelectorForSetting.kt:46)");
    L145:
        State r20 = SnapshotStateKt.rememberUpdatedState(r11, r2, (r3 >> 15) & 14);
        State r111 = SnapshotStateKt.rememberUpdatedState(r18, r2, (r3 >> 18) & 14);
        State r112 = SnapshotStateKt.rememberUpdatedState(r110, r2, (r3 >> 21) & 14);
        Function2<? super String, ? super SearchBaseInfo, Unit> r113 = r11;
        r2.startReplaceGroup(1849434622);
        Object r21 = r2.rememberedValue();
        Composer.Companion r210 = Composer.Companion;
        Function2<? super String, ? super SearchBaseInfo, Unit> r211 = r18;
        if (r21 != r210.getEmpty()) goto L148;
        r21 = new a(r20, r111, r112);
        r2.updateRememberedValue(r21);
    L148:
        final a r34 = (a) r21;
        r2.endReplaceGroup();
        final b r35 = new b(r25);
        r2.startReplaceGroup(-1224400529);
        boolean r36 = (r2.changed(r22) | r2.changed(r7)) | r2.changed(r34);
        if ((r3 & 7168) != 2048) goto L151;
        boolean r114 = true;
    L152:
        boolean r37 = r36 | r114;
        if ((r3 & 234881024) != 67108864) goto L155;
        boolean r4 = true;
    L156:
        boolean r38 = r4 | r37;
        Object r39 = r2.rememberedValue();
        if (r38 == true) goto L160;
        Object r40 = r39;
        if (r39 == r210.getEmpty()) goto L160;
    L161:
        final PickerConfig r41 = (PickerConfig) r40;
        r2.endReplaceGroup();
        r2.startReplaceGroup(1849434622);
        Object r42 = r2.rememberedValue();
        if (r42 != r210.getEmpty()) goto L164;
        int r43 = 2;
        SnapshotMutationPolicy r115 = null;
        r42 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r2.updateRememberedValue(r42);
    L165:
        final MutableState r44 = (MutableState) r42;
        r2.endReplaceGroup();
        r2.startReplaceGroup(1849434622);
        Object r45 = r2.rememberedValue();
        if (r45 != r210.getEmpty()) goto L168;
        r45 = SnapshotStateKt.mutableStateOf$default(r115, r115, r43, r115);
        r2.updateRememberedValue(r45);
    L168:
        final MutableState r46 = (MutableState) r45;
        r2.endReplaceGroup();
        String r116 = r1;
        Modifier r47 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, r115).then(r5);
        r2.startReplaceGroup(-1224400529);
        boolean r48 = (r2.changedInstance(r22) | r2.changedInstance(r41)) | r2.changedInstance(r13);
        Object r117 = r2.rememberedValue();
        if (r48 == false) goto L171;
    L172:
        final List<? extends SearchBaseInfo> r212 = r13;
        r117 = new FriendsSelectorForSettingKt$FriendsSelectorForSetting$4$1(r22, r41, r212, r44, r46);
        r2.updateRememberedValue(r117);
    L173:
        Function1 r49 = (Function1) r117;
        r2.endReplaceGroup();
        r2.startReplaceGroup(-1633490746);
        boolean r50 = r2.changedInstance(r13);
        Object r118 = r2.rememberedValue();
        if (r50 == false) goto L176;
    L177:
        r118 = new FriendsSelectorForSettingKt$FriendsSelectorForSetting$5$1(r13, r46);
        r2.updateRememberedValue(r118);
    L178:
        r2.endReplaceGroup();
        AndroidView_androidKt.AndroidView(r49, r47, (Function1) r118, r2, 0, 0);
        Unit r51 = Unit.INSTANCE;
        r2.startReplaceGroup(5004770);
        Object r52 = r2.rememberedValue();
        if (r52 != r210.getEmpty()) goto L181;
        r52 = new FriendsSelectorForSettingKt$FriendsSelectorForSetting$6$1(r44);
        r2.updateRememberedValue(r52);
    L181:
        r2.endReplaceGroup();
        EffectsKt.DisposableEffect(r51, (Function1) r52, r2, 54);
        if (ComposerKt.isTraceInProgress() == false) goto L184;
        ComposerKt.traceEventEnd();
    L184:
        final Function2<? super String, ? super SearchBaseInfo, Unit> r53 = r211;
        final FragmentManager r54 = r7;
        final Function2<? super List<String>, ? super List<? extends SearchBaseInfo>, Unit> r55 = r110;
        final String r56 = r116;
        final Function2<? super String, ? super SearchBaseInfo, Unit> r57 = r113;
    L185:
        ScopeUpdateScope r119 = r2.endRestartGroup();
        if (r119 == null) goto L189;
        final Modifier r58 = r5;
        final List<? extends SearchBaseInfo> r59 = r13;
        r119.updateScope(new FriendsSelectorForSettingKt$FriendsSelectorForSetting$7(r22, r58, r54, r25, r59, r57, r53, r55, r56, r32, r33));
        return;
    L189:
        return;
    L176:
        if (r118 != r210.getEmpty()) goto L178;
    L171:
        if (r117 != r210.getEmpty()) goto L173;
    L164:
        r43 = 2;
        r115 = null;
    L160:
        PickerConfig r60 = new PickerConfig(new Dependency(r22, r7), new Permissions(CollectionsKt.listOf(ActionType.INVITE_SAME_CHAT)));
        r60.extra(new FriendsSelectorForSettingKt$FriendsSelectorForSetting$pickerConfig$1$1$1(r34, r1));
        r60.searcher(new FriendsSelectorForSettingKt$FriendsSelectorForSetting$pickerConfig$1$1$2(r25));
        r60.recommendList(new FriendsSelectorForSettingKt$FriendsSelectorForSetting$pickerConfig$1$1$3(r35));
        r2.updateRememberedValue(r60);
        r40 = r60;
        goto L161
    L155:
        r4 = false;
        goto L156
    L151:
        r114 = false;
        goto L152
    L141:
        r1 = r30;
        goto L142
    L138:
        r110 = r29;
        goto L139
    L132:
        r18 = r28;
        goto L133
    L126:
        r11 = r15;
        goto L127
    L118:
        r7 = r8;
        goto L119
    L114:
        r5 = r23;
        goto L116
    L106:
        if (r2.getDefaultsInvalid() == true) goto L112;
        r2.skipToGroupEnd();
        if ((r33 & 4) == 0) goto L111;
        r3 = r3 & (-897);
    L111:
        r5 = r23;
        r18 = r28;
        r110 = r29;
        r1 = r30;
        r7 = r8;
        r11 = r15;
        goto L142
    L100:
        if (r2.getSkipping() == false) goto L103;
        r2.skipToGroupEnd();
        r5 = r23;
        r53 = r28;
        r56 = r30;
        r54 = r8;
        r57 = r15;
        r55 = r29;
        goto L185
    L91:
        if ((r32 & 100663296) != 0) goto L98;
        if (r2.changed(r30) == false) goto L95;
        int r213 = 67108864;
    L96:
        r3 = r3 | r213;
        goto L98
    L95:
        r213 = 33554432;
        goto L96
    L81:
        if ((r32 & 12582912) != 0) goto L87;
        if (r2.changedInstance(r29) == false) goto L85;
        int r120 = 8388608;
    L86:
        r3 = r3 | r120;
        goto L87
    L85:
        r120 = 4194304;
        goto L86
    L71:
        if ((r32 & 1572864) != 0) goto L77;
        if (r2.changedInstance(r28) == false) goto L75;
        int r121 = 1048576;
    L76:
        r3 = r3 | r121;
        goto L77
    L75:
        r121 = 524288;
        goto L76
    L60:
        if ((196608 & r32) != 0) goto L66;
        r15 = r27;
        if (r2.changedInstance(r15) == false) goto L64;
        int r122 = 131072;
    L65:
        r3 = r3 | r122;
        goto L67
    L64:
        r122 = 65536;
        goto L65
    L49:
        if ((r32 & 24576) != 0) goto L55;
        r13 = r26;
        if (r2.changedInstance(r13) == false) goto L53;
        int r123 = 16384;
    L54:
        r3 = r3 | r123;
        goto L56
    L53:
        r123 = 8192;
        goto L54
    L39:
        if ((r32 & 3072) != 0) goto L45;
        if (r2.changed(r25) == false) goto L43;
        int r61 = 2048;
    L44:
        r3 = r3 | r61;
        goto L45
    L43:
        r61 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L44
    L27:
        if ((r33 & 4) != 0) goto L31;
        r8 = r24;
        if (r2.changedInstance(r8) == false) goto L32;
        int r62 = 256;
    L33:
        r3 = r3 | r62;
    L32:
        r62 = 128;
        goto L33
    L31:
        r8 = r24;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L25;
        if (r2.changed(r23) == false) goto L21;
        int r63 = 32;
    L22:
        r3 = r3 | r63;
        goto L25
    L21:
        r63 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L13
    L8:
        if (r2.changedInstance(r22) == false) goto L10;
        int r64 = 4;
    L11:
        r3 = r64 | r32;
        goto L13
    L10:
        r64 = 2;
        goto L11
    }
}
