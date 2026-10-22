package com.larksuite.component.card.plugin;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ShowSelectMenuPlugin extends OPPlugin {
    public static final String MULTI_SELECT_PERSON = "multi_select_person";
    public static final String MULTI_SELECT_STATIC = "multi_select_static";
    public static final String OVERFLOW = "overflow";
    public static final String SELECT_PERSON = "select_person";
    public static final String SELECT_STATIC = "select_static";
    public static final String TAG = "ShowSelectMenuPlugin";

    public static /* synthetic */ String e(ShowSelectMenuPlugin r0, com.larksuite.component.card.cardcontainer.c r1, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2, String r3) {
        return r0.lambda$showMultiSelectStaticPanel$3(r1, r2, r3);
    }

    public static /* synthetic */ Unit f(com.larksuite.component.card.cardcontainer.c r0, LKEvent r1, j18.f r2, List r3) {
        return lambda$showMultiSelectStaticPanel$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit g(com.larksuite.component.card.cardcontainer.c r0, LKEvent r1, j18.f r2, UniversalCardShowSelectMenuPluginModel$OptionsItemModel r3) {
        return lambda$showSelectStaticPanel$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void h(ShowSelectMenuPlugin r0, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r1, LKEvent r2, com.larksuite.component.card.cardcontainer.c r3, j18.f r4) {
        r0.lambda$showSelectMenu$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ String i(ShowSelectMenuPlugin r0, com.larksuite.component.card.cardcontainer.c r1, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2, String r3) {
        return r0.lambda$showSelectStaticPanel$1(r1, r2, r3);
    }

    public ShowSelectMenuPlugin() {
    }

    private static com.larksuite.component.card.cardcontainer.c getUniversalCardShareData(LKEvent r2) {
        Object r3 = r2.h;
        if ((r3 instanceof ILynxBridgeContext) == false) goto L13;
        ILynxContainerContext r4 = ((ILynxBridgeContext) r3).getContainerContext();
        if (r4 == null) goto L13;
        if (r4.getBizExtra() == null) goto L13;
        if (r4.getBizExtra().get("card_share_data") == null) goto L13;
        if ((r4.getBizExtra().get("card_share_data") instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L13;
        return (com.larksuite.component.card.cardcontainer.c) r4.getBizExtra().get("card_share_data");
    L13:
        return null;
    }

    private static CardAttachment getJsonAttachment(boolean r0, com.larksuite.component.card.cardcontainer.c r1) {
        if (r0 == false) goto L7;
        if (r1.b.getTranslateContent() == null) goto L7;
        return r1.b.getTranslateContent().getAttachment();
    L7:
        return r1.b.getCardContent().getAttachment();
    }

    private String getOptionItemIcon(com.larksuite.component.card.cardcontainer.c r1, boolean r2, String r3) {
        CardAttachment r4 = getJsonAttachment(r2, r1);
        if (r4.getImages() == null) goto L8;
        RichTextElement.ImageProperty r5 = r4.getImages().get(r3);
        CardDataUtils.a.getClass();
        Image r6 = CardDataUtils.d(r5, 1);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.getKey();
    L8:
        return null;
    }

    private static void initSelectedValues(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r3, com.larksuite.component.card.cardcontainer.c r4, List<String> r5) {
        ArrayList<String> r0 = r3.initialOptions;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L22;
        CardAttachment r6 = getJsonAttachment(r3.isTranslateElement, r4);
        if (r6.getOptionUsers() == null) goto L16;
        int r1 = 0;
    L10:
        if (r1 >= r3.initialOptions.size()) goto L23;
        OptionUser r2 = r6.getOptionUsers().get(ListProtector.get(r3.initialOptions, r1));
        if (r2 == null) goto L14;
        r5.add(r2.getUserId());
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r5.add((String) ListProtector.get(r3.initialOptions, r1));
        goto L15
    L23:
        return;
    L16:
        r5.addAll(r3.initialOptions);
        return;
    }

    private /* synthetic */ String lambda$showMultiSelectStaticPanel$3(com.larksuite.component.card.cardcontainer.c r1, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2, String r3) {
        return getOptionItemIcon(r1, r2.isTranslateElement, r3);
    }

    private /* synthetic */ String lambda$showSelectStaticPanel$1(com.larksuite.component.card.cardcontainer.c r1, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2, String r3) {
        return getOptionItemIcon(r1, r2.isTranslateElement, r3);
    }

    @LKPluginFunction(async = true, eventName = {"universalCardShowSelectMenu"})
    public void showSelectMenu(final LKEvent r8, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r9, final j18.f<LKBaseResponseModel> r10) {
        final com.larksuite.component.card.cardcontainer.c r4 = getUniversalCardShareData(r8);
        mz7.b.a(new f(this, r9, r8, r4, r10));
    }

    private static void initOptions(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2, ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r3, com.larksuite.component.card.cardcontainer.c r4, List<String> r5) {
        CardAttachment r6 = getJsonAttachment(r2.isTranslateElement, r4);
        if (r6.getOptionUsers() == null) goto L12;
        int r7 = 0;
    L6:
        if (r7 >= r3.size()) goto L16;
        OptionUser r0 = r6.getOptionUsers().get(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r3, r7)).value);
        if (r0 == null) goto L10;
        r5.add(r0.getUserId());
    L11:
        r7 = r7 + 1;
        goto L6
    L10:
        r5.add(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r3, r7)).value);
        goto L11
    L16:
        return;
    }

    private static Unit lambda$showMultiSelectStaticPanel$4(com.larksuite.component.card.cardcontainer.c r5, LKEvent r6, j18.f r7, List r8) {
        if (r5 == null) goto L5;
        r5.b.getCardID();
    L5:
        if (r5 != null) goto L7;
        return null;
    L7:
        com.larksuite.component.card.monitor.a.a(r5.b.getVersion(), MULTI_SELECT_STATIC, r5.c.getMonitorData(), r5.b.getCardID(), r5.b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r9 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r1 = new ArrayList();
        Iterator r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r2 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r10.next();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r3 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r3.text = r2.text;
        r3.value = r2.value;
        r1.add(r3);
        goto L9
    L11:
        r9.selectedValues = r1;
        k.c(r6, r9, r7);
        return null;
    }

    private /* synthetic */ void lambda$showSelectMenu$0(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r9, LKEvent r10, com.larksuite.component.card.cardcontainer.c r11, j18.f r12) {
        if (SELECT_STATIC.equals(r9.type) == true) goto L12;
        if (MULTI_SELECT_STATIC.equals(r9.type) == true) goto L12;
        if (CollectionUtils.isEmpty(r9.options) == false) goto L10;
        showGroupMenu(r10, SELECT_PERSON.equals(r9.type), r9, r11, r12);
        return;
    L10:
        showTargetMenu(r10, SELECT_PERSON.equals(r9.type), r9, r11, r12);
        return;
    L12:
        if (CollectionUtils.isEmpty(r9.options) == false) goto L16;
        Log.w(TAG, "options is empty");
        return;
    L16:
        if (SELECT_STATIC.equals(r9.type) == false) goto L18;
        showSelectStaticPanel(r10, r9, r11, r12);
        return;
    L18:
        showMultiSelectStaticPanel(r10, r9, r11, r12);
    }

    private static Unit lambda$showSelectStaticPanel$2(com.larksuite.component.card.cardcontainer.c r5, LKEvent r6, j18.f r7, UniversalCardShowSelectMenuPluginModel$OptionsItemModel r8) {
        if (r5 == null) goto L5;
        r5.b.getCardID();
    L5:
        if (r5 != null) goto L7;
        return null;
    L7:
        com.larksuite.component.card.monitor.a.a(r5.b.getVersion(), SELECT_STATIC, r5.c.getMonitorData(), r5.b.getCardID(), r5.b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r9 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r1 = new ArrayList();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r2 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r2.text = r8.text;
        r2.value = r8.value;
        r1.add(r2);
        r9.selectedValues = r1;
        k.c(r6, r9, r7);
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.plugin.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larksuite.component.card.plugin.c] */
    private void showMultiSelectStaticPanel(final LKEvent r3, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r4, final com.larksuite.component.card.cardcontainer.c r5, final j18.f<LKBaseResponseModel> r6) {
        com.larksuite.component.card.plugin.select.i.a(r3, r4, new b(this, r5, r4), new c(r5, r3, r6));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.plugin.d] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larksuite.component.card.plugin.e] */
    private void showSelectStaticPanel(final LKEvent r3, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r4, final com.larksuite.component.card.cardcontainer.c r5, final j18.f<LKBaseResponseModel> r6) {
        com.larksuite.component.card.plugin.select.j.c(r3, r4, new d(this, r5, r4), new e(r5, r3, r6));
    }

    private void showGroupMenu(final LKEvent r14, final boolean r15, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r16, final com.larksuite.component.card.cardcontainer.c r17, final j18.f<LKBaseResponseModel> r19) {
        if (r17 != null) goto L6;
        Log.w(TAG, "card share data is null");
        return;
    L6:
        final String r3 = r17.b.getCardID();
        ArrayList r7 = new ArrayList();
        initSelectedValues(r16, r17, r7);
        CardActionDependencyData r2 = r17.c.getCardActionDependencyData();
        if (TextUtils.isEmpty(r2.getSelectPersonCurrentChatId()) == true) goto L9;
        String r4 = r2.getSelectPersonCurrentChatId();
    L10:
        String r8 = r4;
        if ((r14.getContext() instanceof Activity) == false) goto L14;
        Activity r5 = (Activity) r14.getContext();
    L19:
        Activity r9 = r5;
        if (r9 != null) goto L22;
        Log.w(TAG, "showTargetMenu Activity is null");
    L22:
        ty7.a.a().pickGroupMember(r9, r8, r7, r15, r16.title, new AnonymousClass2(this, r14, r3, r15, r17, r19));
        return;
    L14:
        if ((r14.getContext() instanceof dwa.e) == true) goto L16;
    L18:
        r5 = null;
        goto L19
    L16:
        if ((r14.getContext().getBaseContext() instanceof Activity) == false) goto L18;
        r5 = (Activity) r14.getContext().getBaseContext();
        goto L19
    L9:
        r4 = "";
        goto L10
    }

    private void showTargetMenu(final LKEvent r14, final boolean r15, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r16, final com.larksuite.component.card.cardcontainer.c r17, final j18.f<LKBaseResponseModel> r19) {
        if (r17 != null) goto L6;
        Log.w(TAG, "card share data is null");
        return;
    L6:
        final String r3 = r17.b.getCardID();
        ArrayList r7 = new ArrayList();
        initOptions(r16, r16.options, r17, r7);
        ArrayList r8 = new ArrayList();
        initSelectedValues(r16, r17, r8);
        if ((r14.getContext() instanceof Activity) == false) goto L10;
        Activity r2 = (Activity) r14.getContext();
    L15:
        Activity r9 = r2;
        if (r9 != null) goto L18;
        Log.w(TAG, "showTargetMenu Activity is null");
    L18:
        ty7.a.a().pickTargetMember(r9, r7, r8, r15, r16.title, new AnonymousClass1(this, r14, r3, r15, r17, r19));
        return;
    L10:
        if ((r14.getContext() instanceof dwa.e) == true) goto L12;
    L14:
        r2 = null;
        goto L15
    L12:
        if ((r14.getContext().getBaseContext() instanceof Activity) == false) goto L14;
        r2 = (Activity) r14.getContext().getBaseContext();
        goto L15
    }

    private void handleCallBack(LKEvent r3, String r4, boolean r5, List<ChatChatter> r6, com.larksuite.component.card.cardcontainer.c r7, j18.f<LKBaseResponseModel> r8) {
        String r9 = r7.b.getVersion();
        if (r5 == false) goto L5;
        String r10 = SELECT_PERSON;
    L6:
        com.larksuite.component.card.monitor.a.a(r9, r10, r7.c.getMonitorData(), r7.b.getCardID(), r7.b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r11 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r12 = new ArrayList();
        Iterator<ChatChatter> r13 = r6.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ChatChatter r14 = r13.next();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r0 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r0.text = r14.getLocalizedName();
        r0.value = r14.getId();
        r12.add(r0);
        goto L8
    L10:
        r11.selectedValues = r12;
        k.c(r3, r11, r8);
        return;
    L5:
        r10 = MULTI_SELECT_PERSON;
        goto L6
    }

    public static /* synthetic */ void access$000(ShowSelectMenuPlugin r0, LKEvent r1, String r2, boolean r3, List r4, com.larksuite.component.card.cardcontainer.c r5, j18.f r6) {
        r0.handleCallBack(r1, r2, r3, r4, r5, r6);
    }
}
