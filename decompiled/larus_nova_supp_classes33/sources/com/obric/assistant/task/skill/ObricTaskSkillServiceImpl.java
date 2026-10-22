package com.obric.assistant.task.skill;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.api.DefaultReplyExposedConfig;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemIcon;
import com.larus.bmhome.chat.model.api.DefaultReplyModelItemIndex;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuConfig;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchModeConfig;
import com.larus.im.FlowRuntime;
import com.larus.platform.service.x1;
import com.larus.utils.o0;
import com.obric.assistant.actionbar.ConversationModeChangeTipHelper;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.spi.task.IObricTaskSkillService;
import com.obric.assistant.t1;
import com.obric.assistant.task.ObricOmniModelItem;
import com.obric.assistant.task.ObricOmniModelItems;
import com.obric.assistant.util.r2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\nH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016J.\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0019H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010.\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001c\u00101\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0016J\u0016\u00105\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020%07H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0016H\u0016¨\u00069"}, d2 = {"Lcom/obric/assistant/task/skill/ObricTaskSkillServiceImpl;", "Lcom/obric/assistant/spi/task/IObricTaskSkillService;", "<init>", "()V", "extendObricActionBarWhiteItems", "", "itemsConfig", "", "", "selectedDeepThinkStatus", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "injectObricDefaultReplyModeMenuInfo", "", "menuInfo", "resolveDefaultReplyMode", "", "serverDefaultReplyMode", "(I)Ljava/lang/Integer;", "resolveDefaultModelItemKey", "defaultModelItemKey", "defaultReplyMode", "resolveDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "defaultReplyOption", "saveObricDefaultReplyModeIfNeeded", "", "itemId", "(I)Ljava/lang/Boolean;", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Boolean;", "isObricDefaultReplyModeAvailable", "getPhoneOperationModeIdIfSupportModel", "modelIdentity", "getModelItemsJson", "getDefaultModelItemJson", "getPhoneOperationModeSupportModel", "selectedMode", "Lcom/larus/bmhome/actionbar/model/ActiveSwitchMenuMode;", "isPhoneOperationMode", "modeId", "getBlueTagTextByOption", "modeKey", "modelKey", "menuSection", "isFromSettingPage", "getCurrentDisplayModel", "onSettingModelChanged", "activity", "Landroid/app/Activity;", "onActionBarModelChanged", "storeIsUsingMenuConfV2", "isUsingMenuConfV2", "useModeModelList", "markQuickModeModelsSize", "modeList", "", "getObricDefaultReplyOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskSkillServiceImpl implements IObricTaskSkillService {
    public ObricTaskSkillServiceImpl() {
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String f() {
        ObricOmniModelConfigManager.a.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        ObricOmniModelItems r1 = (ObricOmniModelItems) ObricOmniModelConfigManager.g.get();     // Catch: Throwable -> L8
        if (r1 != null) goto L13;
        Result.constructor-impl(null);     // Catch: Throwable -> L8
    L10:
        return "";
    L13:
        return ((Gson) ObricOmniModelConfigManager.b.getValue()).toJson(r1);
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String getCurrentDisplayModel() {
        ObricOmniModelConfigManager.a.getClass();
        String r0 = ((Keva) ObricOmniModelConfigManager.c.getValue()).getString("current_display_model", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        if (r0 != null) goto L6;
        return IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L6:
        return r0;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String i() {
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r0 = ObricOmniModelConfigManager.c();
        Iterator<T> r1 = a.a(r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        ObricOmniModel r2 = (ObricOmniModel) r1.next();
        vea.k r3 = r2.getModelItemIndex();
        String r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.a();
    L9:
        vea.k r6 = r0.getDefaultModel();
        if (r6 == null) goto L12;
        String r7 = r6.a();
    L14:
        if (Intrinsics.areEqual(r5, r7) == false) goto L4;
        if (r3 == null) goto L17;
        String r8 = r3.b();
    L18:
        vea.k r9 = r0.getDefaultModel();
        if (r9 == null) goto L22;
        r4 = r9.b();
    L22:
        if (Intrinsics.areEqual(r8, r4) == false) goto L4;
        ObricOmniModelItem r10 = new ObricOmniModelItem(r2.getDisplayModel(), r2.getModel());
    L25:
        com.obric.assistant.e r11 = com.obric.assistant.e.a;
        String r12 = r10.getDisplayModel();
        String r13 = "";
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        String r14 = r10.getModel();
        if (r14 == null) goto L32;
        r13 = r14;
    L32:
        r11.getClass();
        return com.obric.assistant.e.b(r12, r13);
    L17:
        r8 = null;
        goto L18
    L12:
        r7 = null;
        goto L14
    L8:
        r5 = null;
        goto L9
    L24:
        r10 = new ObricOmniModelItem("Seed 2.1 Lite", "doubao-2.0-sft-omni-agent.0706");
        goto L25
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption m() {
        AtomicBoolean r0 = m.a;
        if (m.m() == false) goto L7;
        Object r1 = t1.a.z0();
        if ((r1 instanceof ReplyOption) == true) goto L12;
        return null;
    L12:
        return (ReplyOption) r1;
    L7:
        Integer r2 = t1.a.v();
        if (r2 == null) goto L13;
        int r3 = r2.intValue();
        return new ReplyOption(new ModelItemIdentity(j(String.valueOf(r3), r3), Integer.valueOf(r3)), "", null);
    L13:
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Object b(Object r56) {
        boolean r1 = r56 instanceof DefaultReplyMenuData;
        int r5 = 2;
        DefaultReplyExposedConfig r6 = null;
        if (r1 == false) goto L47;
        AtomicBoolean r7 = m.a;
        if (r1 == false) goto L7;
        DefaultReplyMenuData r2 = (DefaultReplyMenuData) r56;
    L8:
        if (r2 == null) goto L198;
        List r0 = r2.getItemList();
        if (r0 != null) goto L13;
        r0 = CollectionsKt.emptyList();
    L13:
        ArrayList r8 = new ArrayList();
        Iterator r3 = r0.iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Object r9 = r3.next();
        if ((r9 instanceof DefaultReplyMenuItem) == false) goto L15;
        r8.add(r9);
        goto L15
    L19:
        ArrayList r4 = new ArrayList();
        Iterator r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L28;
        Object r11 = r10.next();
        AtomicBoolean r12 = m.a;
        ModelItemIdentity r13 = ((DefaultReplyMenuItem) r11).getIdentity();
        if (r13 == null) goto L25;
        boolean r14 = m.j(Integer.valueOf(r13.getDeprecatedItemId()));
    L26:
        if (r14 == true) goto L21;
        r4.add(r11);
        goto L21
    L25:
        r14 = false;
        goto L26
    L28:
        List r15 = CollectionsKt.toMutableList(r4);
        int r16 = t1.a.getAutoGuiEnabledScene();
        if (r16 == 1) goto L32;
        if (r16 == 2) goto L32;
    L34:
        boolean r17 = false;
    L35:
        if (r17 == false) goto L195;
        DefaultReplyMenuItem r18 = (DefaultReplyMenuItem) CollectionsKt.firstOrNull(r15);
        if (r18 == null) goto L39;
        String r19 = r18.getSubTitleName();
    L40:
        boolean r20 = o0.d(r19);
        String r21 = m.d();
        if (r20 == false) goto L43;
        String r22 = FlowRuntime.a().getApplication().getString(2131912556);
    L44:
        String r110 = m.c();
        String r111 = r22;
        m.a(r15, CollectionsKt.listOf(new DefaultReplyMenuItem[]{new DefaultReplyMenuItem(10000, m.b(2131911923), r111, new DefaultReplyMenuItemIcon(null, r21, 1, null), new DefaultReplyMenuItemIcon(null, r110, 1, null), null, m.b(2131911923), null, null, null, null, 1952, null), new DefaultReplyMenuItem(100001, m.b(2131911928), r111, new DefaultReplyMenuItemIcon(null, r21, 1, null), new DefaultReplyMenuItemIcon(null, r110, 1, null), null, m.b(2131911928), null, null, null, null, 1952, null)}), new h());
        goto L195
    L43:
        r22 = null;
        goto L44
    L39:
        r19 = null;
    L195:
        return DefaultReplyMenuData.copy$default(r2, r15, null, 2, null);
    L32:
        if (x1.a.a() == true) goto L34;
        r17 = true;
        goto L35
    L198:
        return r56;
    L7:
        r2 = null;
        goto L8
    L47:
        if ((r56 instanceof DefaultReplyMenuDataV2) == false) goto L196;
        AtomicBoolean r23 = m.a;
        DefaultReplyMenuDataV2 r24 = (DefaultReplyMenuDataV2) r56;
        if (Intrinsics.areEqual(r24.getUseMenuConfV2(), Boolean.TRUE) == false) goto L197;
        if (m.l() == false) goto L197;
        DefaultReplyMenuConfigV2 r25 = r24.getMenuConfV2();
        if (r25 == null) goto L197;
        DefaultReplySwitchModeConfig r26 = r25.getModeList();
        if (r26 == null) goto L62;
        List r27 = r26.getItemList();
        if (r27 == null) goto L62;
        List r28 = CollectionsKt.toMutableList(r27);
    L63:
        DefaultReplySwitchMenuConfig r29 = r25.getModelList();
        if (r29 == null) goto L68;
        List r30 = r29.getItemList();
        if (r30 == null) goto L68;
        List r31 = CollectionsKt.toMutableList(r30);
    L69:
        if (r28 == null) goto L71;
        CollectionsKt.removeAll(r28, new j());
    L71:
        DefaultReplyMenuItemIcon r112 = new DefaultReplyMenuItemIcon(null, m.d(), 1, null);
        DefaultReplyMenuItemIcon r32 = new DefaultReplyMenuItemIcon(null, m.c(), 1, null);
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r33 = ObricOmniModelConfigManager.c();
        String r113 = m.b(2131911923);
        String r210 = m.b(2131911923);
        int r34 = AgentMode.CHAT.getValue();
        vea.k r114 = r33.getDefaultModel();
        if (r114 == null) goto L74;
        String r115 = r114.a();
    L75:
        vea.k r116 = r33.getDefaultModel();
        if (r116 == null) goto L78;
        String r117 = r116.b();
    L79:
        DefaultReplyModelItemIndex r118 = new DefaultReplyModelItemIndex(r115, r117);
        List<ObricOmniModel> r119 = a.a(r33);
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator<T> r121 = r119.iterator();
    L81:
        if (r121.hasNext() == false) goto L92;
        ObricOmniModel r122 = (ObricOmniModel) r121.next();
        vea.k r123 = r122.getModelItemIndex();
        if (r123 == null) goto L85;
        String r35 = r123.a();
    L86:
        vea.k r124 = r122.getModelItemIndex();
        if (r124 == null) goto L89;
        String r125 = r124.b();
    L90:
        r120.add(new DefaultReplyModelItemIndex(r35, r125));
        goto L81
    L89:
        r125 = null;
        goto L90
    L85:
        r35 = null;
        goto L86
    L92:
        if (Intrinsics.areEqual(r25.getUseModeModelList(), Boolean.TRUE) == false) goto L126;
        DefaultReplySwitchMenuConfig r36 = r25.getModelList();
        if (r36 == null) goto L126;
        if (r31 != null) goto L97;
        List r37 = CollectionsKt.emptyList();
    L98:
        List r38 = CollectionsKt.filterNotNull(r37);
        ArrayList r126 = new ArrayList();
        Iterator r39 = r38.iterator();
    L100:
        if (r39.hasNext() == false) goto L125;
        DefaultReplySwitchMenuItem r310 = (DefaultReplySwitchMenuItem) r39.next();
        Iterator<T> r127 = a.a(r33).iterator();
    L103:
        if (r127.hasNext() == false) goto L117;
        Object r128 = r127.next();
        ObricOmniModel r129 = (ObricOmniModel) r128;
        if (Intrinsics.areEqual(r129.isSupportedModel(), Boolean.TRUE) == false) goto L113;
        vea.k r40 = r129.getModelItemIndex();
        if (r40 == null) goto L109;
        String r41 = r40.b();
    L111:
        if (Intrinsics.areEqual(r41, r310.getModelItemKey()) == false) goto L113;
        boolean r42 = true;
    L114:
        if (r42 == false) goto L103;
    L118:
        ObricOmniModel r130 = (ObricOmniModel) r128;
        if (r130 != null) goto L121;
        DefaultReplySwitchMenuItem r43 = null;
    L122:
        if (r43 == null) goto L124;
        r126.add(r43);
    L124:
        r5 = 2;
        r6 = null;
        goto L100
    L121:
        r43 = DefaultReplySwitchMenuItem.copy$default(r310, null, r130.getDisplayModel(), null, null, null, null, null, null, null, null, r130.getDisplayModel(), null, null, null, null, null, null, null, null, null, 1047549, null);
        goto L122
    L109:
        r41 = null;
    L113:
        r42 = false;
        goto L114
    L117:
        r128 = null;
        goto L118
    L125:
        DefaultReplySwitchMenuConfig r211 = DefaultReplySwitchMenuConfig.copy$default(r36, r126, r6, r5, r6);
    L127:
        DefaultReplySwitchMenuMode r44 = new DefaultReplySwitchMenuMode("10000", r113, r112, r32, r112, r32, null, null, null, Integer.valueOf(r34), r210, null, r118, r120, null, null, Boolean.FALSE, r211, 51648, null);
        if (r28 == null) goto L130;
        m.a(r28, CollectionsKt.listOf(r44), new k());
    L130:
        ArrayList r45 = new ArrayList();
        if (r31 == null) goto L155;
        Iterator r46 = r31.iterator();
    L134:
        if (r46.hasNext() == false) goto L155;
        DefaultReplySwitchMenuItem r47 = (DefaultReplySwitchMenuItem) r46.next();
        Iterator<T> r48 = a.a(r33).iterator();
    L137:
        if (r48.hasNext() == false) goto L148;
        Object r49 = r48.next();
        vea.k r50 = ((ObricOmniModel) r49).getModelItemIndex();
        if (r50 == null) goto L141;
        String r51 = r50.b();
    L142:
        if (r47 == null) goto L144;
        String r52 = r47.getModelItemKey();
    L146:
        if (Intrinsics.areEqual(r51, r52) == false) goto L137;
    L149:
        ObricOmniModel r53 = (ObricOmniModel) r49;
        if (r53 == null) goto L153;
        if (r47 == null) goto L153;
        r45.add(DefaultReplySwitchMenuItem.copy$default(r47, null, r53.getDisplayModel(), null, null, null, null, null, null, null, null, r53.getDisplayModel(), null, null, null, null, null, null, null, null, null, 1047549, null));
    L153:
        if (r47 == null) goto L134;
        r45.add(r47);
        goto L134
    L144:
        r52 = null;
        goto L146
    L141:
        r51 = null;
        goto L142
    L148:
        r49 = null;
    L155:
        DefaultReplySwitchModeConfig r54 = r25.getModeList();
        if (r54 == null) goto L158;
        DefaultReplySwitchModeConfig r55 = r54.copy(r28, null);
    L159:
        DefaultReplySwitchMenuConfig r57 = r25.getModelList();
        if (r57 == null) goto L162;
        DefaultReplySwitchMenuConfig r131 = DefaultReplySwitchMenuConfig.copy$default(r57, r45, null, 2, null);
    L164:
        return DefaultReplyMenuDataV2.copy$default(r24, DefaultReplyMenuConfigV2.copy$default(r25, r55, r131, null, null, 12, null), null, null, null, null, 30, null);
    L162:
        r131 = null;
        goto L164
    L158:
        r55 = null;
        goto L159
    L97:
        r37 = r31;
    L126:
        r211 = null;
        goto L127
    L78:
        r117 = null;
        goto L79
    L74:
        r115 = null;
    L68:
        r31 = null;
    L62:
        r28 = null;
    L197:
        return r24;
    L196:
        return r56;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean c(ReplyOption r1) {
        return n.b(r1);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean d(String r2) {
        AtomicBoolean r0 = m.a;
        return m.k(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void h(List<t0> r5) {
        Intrinsics.checkNotNullParameter(r5, "modeList");
        AtomicBoolean r1 = m.a;
        Intrinsics.checkNotNullParameter(r5, "modeList");
        if (m.b.get() == false) goto L22;
        Iterator<T> r6 = r5.iterator();
    L6:
        int r2 = 0;
        if (r6.hasNext() == false) goto L16;
        t0 r0 = (t0) r6.next();
        String r3 = r0.a;
        AtomicBoolean r4 = m.a;
        if (Intrinsics.areEqual(r3, m.e(ObricOmniModeTag.QUICK)) == false) goto L6;
        a2 r7 = r0.r;
        if (r7 == null) goto L15;
        ArrayList r8 = r7.a;
        if (r8 == null) goto L15;
        r2 = r8.size();
    L15:
        m.c = r2;
        return;
    L16:
        m.c = 0;
        return;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Integer n(int r2) {
        Integer r3 = t1.a.v();
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if (q(r3.intValue()) == false) goto L7;
        return r3;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean o(int r3) {
        AtomicBoolean r0 = m.a;
        if (m.j(Integer.valueOf(r3)) == true) goto L8;
        t1 r4 = t1.a;
        if (r4.v() == null) goto L7;
        r4.C0(null);
    L7:
        return null;
    L8:
        t1.a.C0(Integer.valueOf(r3));
        return Boolean.TRUE;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean p(ReplyOption r3) {
        Intrinsics.checkNotNullParameter(r3, "replyOption");
        if (n.b(r3) == true) goto L8;
        t1 r4 = t1.a;
        if (r4.z0() == null) goto L7;
        r4.O1(null);
    L7:
        return null;
    L8:
        t1.a.O1(r3);
        return Boolean.TRUE;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean q(int r4) {
        AtomicBoolean r0 = m.a;
        if (m.j(Integer.valueOf(r4)) == false) goto L15;
        int r5 = t1.a.getAutoGuiEnabledScene();
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L16;
        return true;
    L16:
        return false;
    L9:
        if (x1.a.a() == true) goto L11;
        r6 = true;
        goto L12
    L15:
        return false;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption s(ReplyOption r3) {
        Object r4 = t1.a.z0();
        if ((r4 instanceof ReplyOption) == false) goto L5;
        ReplyOption r5 = (ReplyOption) r4;
    L7:
        if (n.b(r5) == true) goto L9;
        return null;
    L9:
        return r5;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String e(ReplyOption r4, ModelItemIdentity r5) {
        Intrinsics.checkNotNullParameter(r5, "modelIdentity");
        AtomicBoolean r1 = m.a;
        Intrinsics.checkNotNullParameter(r5, "modelIdentity");
        if (r4 == null) goto L5;
        String r6 = r4.getModeId();
    L7:
        if (m.k(r6) == false) goto L22;
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r7 = ObricOmniModelConfigManager.c();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        List r8 = r7.getSupportModels();
        if (r8 != null) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        Iterator r9 = CollectionsKt.filterNotNull(r8).iterator();
    L14:
        if (r9.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((vea.k) r9.next()).b(), r5.getKey()) == false) goto L14;
        return "10000";
    L23:
        return null;
    L22:
        return null;
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ModelItemIdentity g(ModelItemIdentity r4, t0 r5) {
        Intrinsics.checkNotNullParameter(r5, "selectedMode");
        if (r4 == null) goto L5;
        String r1 = r4.getKey();
    L6:
        if (r1 == null) goto L19;
        AtomicBoolean r2 = m.a;
        if (m.k(r5.a) == false) goto L19;
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r6 = ObricOmniModelConfigManager.c();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List r7 = r6.getSupportModels();
        if (r7 != null) goto L13;
        r7 = CollectionsKt.emptyList();
    L13:
        Iterator r8 = CollectionsKt.filterNotNull(r7).iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((vea.k) r8.next()).b(), r4.getKey()) == false) goto L15;
        return r4;
    L19:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String j(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "defaultModelItemKey");
        AtomicBoolean r1 = m.a;
        Intrinsics.checkNotNullParameter(r3, "defaultModelItemKey");
        if (m.j(Integer.valueOf(r4)) == true) goto L7;
        return null;
    L7:
        return String.valueOf(r4);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void k(Set<String> r3, ModelItemIdentity r4) {
        Intrinsics.checkNotNullParameter(r3, "itemsConfig");
        AtomicBoolean r1 = m.a;
        Intrinsics.checkNotNullParameter(r3, "itemsConfig");
        CopyOnWriteArraySet<f.a> r0 = f.a;
        if (n.b(f.c.get()) == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L13;
        r3.add("-626");
        r3.add("-628");
        r3.add("-627");
        r3.addAll(f.e);
        return;
    L13:
        return;
    L5:
        if (n.a(r4) == true) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void l(ReplyOption r2, FragmentActivity r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        CoroutineScope r0 = ConversationModeChangeTipHelper.a;
        ConversationModeChangeTipHelper.c(ConversationModeChangeTipHelper.Source.SETTING, r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void r(boolean r3, boolean r4) {
        m.a.compareAndSet(!r3, r3);
        m.b.compareAndSet(!r4, r4);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void t(ReplyOption r2, Activity r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        CoroutineScope r0 = ConversationModeChangeTipHelper.a;
        ConversationModeChangeTipHelper.c(ConversationModeChangeTipHelper.Source.ACTION_BAR, r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String a(String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "menuSection");
        AtomicBoolean r1 = m.a;
        Intrinsics.checkNotNullParameter(r6, "menuSection");
        if (r4 != null) goto L6;
        if (r5 != null) goto L6;
        return null;
    L6:
        b r2 = r2.a();
        if (r2 == null) goto L11;
        y r3 = r2.o(Reflection.getOrCreateKotlinClass(y.class));
        if (r3 == null) goto L11;
        wc9.e r8 = r3.h();
    L12:
        if (r7 == true) goto L17;
        if (r8 == null) goto L17;
        if (com.larus.bmhome.utils.i.h(r8) == true) goto L17;
        return null;
    L17:
        ObricOmniModelConfigManager.a.getClass();
        String r9 = ObricOmniModelConfigManager.c().getOmniTaskTagText();
        if (r9 != null) goto L21;
        r9 = m.b(2131911920);
    L21:
        if (Intrinsics.areEqual(r6, "mode") == false) goto L43;
        if (m.b.get() == false) goto L30;
        if (m.c < 2) goto L27;
    L34:
        boolean r10 = false;
    L36:
        if (r4 != null) goto L39;
        r4 = r5;
    L39:
        if (m.k(r4) == true) goto L58;
        if (r10 == true) goto L58;
        return null;
    L58:
        return r9;
    L27:
        if (Intrinsics.areEqual(r4, m.e(ObricOmniModeTag.QUICK)) == false) goto L34;
    L35:
        r10 = true;
        goto L36
    L30:
        if (Intrinsics.areEqual(r5, m.f(ObricOmniModelTag.QUICK)) == true) goto L35;
        if (Intrinsics.areEqual(r4, m.e(ObricOmniModeTag.QUICK)) == false) goto L34;
    L43:
        if (Intrinsics.areEqual(r6, "model") == false) goto L60;
        if (r5 == null) goto L48;
        r4 = r5;
    L48:
        if (m.k(r4) == true) goto L58;
        if (m.b.get() == true) goto L52;
        return null;
    L52:
        if (m.c >= 2) goto L54;
        return null;
    L54:
        if (Intrinsics.areEqual(r5, m.f(ObricOmniModelTag.QUICK)) == true) goto L56;
        return null;
    L56:
        if (f.d() == false) goto L58;
        return null;
    L60:
        return null;
    L11:
        r8 = null;
        goto L12
    }
}
