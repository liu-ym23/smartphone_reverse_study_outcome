package com.larus.bmhome.model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.bot.AppSettingModel;
import com.larus.bmhome.chat.model.api.DefaultActiveModelSettingItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuConfig;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchModeConfig;
import com.larus.bmhome.databinding.LarusPageModelSettingsBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.platform.service.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J&\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/model/ModelSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusPageModelSettingsBinding;", "appSettingModel", "Lcom/larus/bmhome/bot/AppSettingModel;", "getAppSettingModel", "()Lcom/larus/bmhome/bot/AppSettingModel;", "appSettingModel$delegate", "Lkotlin/Lazy;", "modelAdapter", "Lcom/larus/bmhome/model/ModelSettingsAdapter;", "isSavingSelection", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitle", "renderModelSettings", "menuConfig", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "initialSelections", "", "", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItem;", "saveSelection", "mode", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "model", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public LarusPageModelSettingsBinding d;
    public final Lazy e;
    public ModelSettingsAdapter f;
    public boolean g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.model.ModelSettingsFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<DefaultReplySwitchMenuMode, DefaultReplySwitchMenuItem, Unit> {
        public AnonymousClass1(Object r8) {
            super(2, r8, ModelSettingsFragment.class, "saveSelection", "saveSelection(Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;)V", 0);
        }

        public final void invoke(DefaultReplySwitchMenuMode r13, DefaultReplySwitchMenuItem r14) {
            Intrinsics.checkNotNullParameter(r13, "p0");
            Intrinsics.checkNotNullParameter(r14, "p1");
            ModelSettingsFragment r2 = (ModelSettingsFragment) ((CallableReference) this).receiver;
            int r0 = ModelSettingsFragment.h;
            r2.getClass();
            String r4 = r13.getModeId();
            if (r4 == null) goto L48;
            String r5 = r14.getModelItemKey();
            if (r5 == null) goto L49;
            Map r1 = r2.S90().getDefaultActiveModelSettingItem();
            if (r1 != null) goto L12;
            r1 = MapsKt.emptyMap();
        L12:
            if (r2.g == true) goto L45;
            DefaultActiveModelSettingItem r3 = (DefaultActiveModelSettingItem) r1.get(r4);
            String r6 = null;
            if (r3 == null) goto L16;
            String r7 = r3.getCurrentModelItemKey();
        L18:
            if (Intrinsics.areEqual(r7, r5) == true) goto L50;
            z1 r15 = r14.getSubscribeConfig();
            if (r15 == null) goto L23;
            boolean r8 = Intrinsics.areEqual(r15.b, Boolean.TRUE);
        L24:
            String r9 = "";
            if (r8 == false) goto L33;
            Context r16 = r2.getContext();
            String r10 = r15.a;
            if (r10 == null) goto L30;
            r9 = r10;
        L30:
            SmartRouter.buildRoute(r16, r9).d();
            ICommerceMembershipService.a.getClass();
            ICommerceMembershipService r17 = ICommerceMembershipService.a.a();
            if (r17 == null) goto L46;
            r17.w(r15.a, r5);
            return;
        L46:
            return;
        L33:
            int r18 = com.larus.bmhome.model.a.a;
            String r19 = r13.getName();
            if (r19 == null) goto L37;
            r9 = r19;
        L37:
            Intrinsics.checkNotNullParameter(r9, "conversationMode");
            Intrinsics.checkNotNullParameter("model", "selectItemType");
            Intrinsics.checkNotNullParameter(r5, "modelItemKey");
            Intrinsics.checkNotNullParameter(r4, "modeId");
            o r110 = o.a;
            JSONObject r11 = new JSONObject();
            r11.put("conversation_mode", r9);
            r11.put("select_item_type", "model");
            r11.put("model_item_key", r5);
            r11.put("mode_id", r4);
            Unit r111 = Unit.INSTANCE;
            r110.reportEvent("click_default_new_chat_model_switch", r11);
            DefaultActiveModelSettingItem r112 = (DefaultActiveModelSettingItem) r1.get(r4);
            if (r112 == null) goto L40;
            r6 = r112.getCurrentModelItemKey();
        L40:
            DefaultActiveModelSettingItem r113 = new DefaultActiveModelSettingItem(r6, r5);
            Map r12 = MapsKt.toMutableMap(r1);
            r12.put(r4, r113);
            r2.g = true;
            ModelSettingsAdapter r114 = r2.f;
            if (r114 == null) goto L43;
            r114.z2(r4, r5, true);
        L43:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner()), null, null, new ModelSettingsFragment$saveSelection$1(r2, r12, r4, r5, null), 3, null);
            return;
        L23:
            r8 = false;
            goto L24
        L50:
            return;
        L16:
            r7 = null;
            goto L18
        L45:
            return;
        L49:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((DefaultReplySwitchMenuMode) r1, (DefaultReplySwitchMenuItem) r2);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final AppSettingModel S90() {
        return (AppSettingModel) this.e.getValue();
    }

    public final void onDestroyView() {
        LarusPageModelSettingsBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.f = null;
        this.d = null;
        super.onDestroyView();
    }

    public ModelSettingsFragment() {
        final Function0<Fragment> r0 = new ModelSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppSettingModel.class), new ModelSettingsFragment$special$$inlined$viewModels$default$2(r0), new ModelSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void T90(DefaultReplyMenuConfigV2 r10, Map<String, DefaultActiveModelSettingItem> r11) {
        if (r10 == null) goto L7;
        DefaultReplySwitchModeConfig r12 = r10.getModeList();
        if (r12 == null) goto L7;
        List r13 = r12.getItemList();
    L8:
        if (r13 != null) goto L10;
        r13 = CollectionsKt.emptyList();
    L10:
        ArrayList r1 = new ArrayList();
        Iterator r14 = r13.iterator();
    L11:
        boolean r3 = false;
        if (r14.hasNext() == false) goto L66;
        DefaultReplySwitchMenuMode r2 = (DefaultReplySwitchMenuMode) r14.next();
        if (r2 != null) goto L16;
    L15:
        ModelSettingsAdapter.b r4 = null;
    L63:
        if (r4 == null) goto L11;
        r1.add(r4);
        goto L11
    L16:
        String r5 = r2.getModeId();
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L15;
        DefaultReplySwitchMenuConfig r7 = r2.getModelList();
        if (r7 == null) goto L28;
        List r8 = r7.getItemList();
    L29:
        if (r8 != null) goto L31;
        r8 = CollectionsKt.emptyList();
    L31:
        ArrayList r9 = new ArrayList();
        Iterator r15 = r8.iterator();
    L33:
        if (r15.hasNext() == false) goto L60;
        DefaultReplySwitchMenuItem r16 = (DefaultReplySwitchMenuItem) r15.next();
        if (r16 == null) goto L56;
        String r17 = r16.getModelItemKey();
        if (r17 != null) goto L39;
    L42:
        boolean r18 = true;
    L43:
        if (r18 == true) goto L53;
        String r19 = r16.getName();
        if (r19 != null) goto L47;
    L50:
        boolean r20 = true;
    L51:
        if (r20 == true) goto L53;
        boolean r21 = true;
    L54:
        if (r21 == false) goto L56;
    L57:
        if (r16 == null) goto L33;
        r9.add(r16);
        goto L33
    L47:
        if (StringsKt.isBlank(r19) == true) goto L50;
        r20 = false;
    L53:
        r21 = false;
        goto L54
    L39:
        if (StringsKt.isBlank(r17) == true) goto L42;
        r18 = false;
    L56:
        r16 = null;
        goto L57
    L60:
        if (r9.isEmpty() == true) goto L15;
        r4 = new ModelSettingsAdapter.b(r2, r9, false);
        goto L63
    L28:
        r8 = null;
        goto L29
    L19:
        if (StringsKt.isBlank(r5) == true) goto L22;
        r6 = false;
        goto L23
    L66:
        if (r1.size() <= 1) goto L68;
        r3 = true;
    L68:
        ModelSettingsAdapter r110 = this.f;
        if (r110 == null) goto L92;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r23 = r1.iterator();
    L72:
        if (r23.hasNext() == false) goto L74;
        ModelSettingsAdapter.b r24 = (ModelSettingsAdapter.b) r23.next();
        DefaultReplySwitchMenuMode r25 = r24.a;
        List<DefaultReplySwitchMenuItem> r26 = r24.b;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "mode");
        Intrinsics.checkNotNullParameter(r26, "models");
        r22.add(new ModelSettingsAdapter.b(r25, r26, r3));
        goto L72
    L74:
        LinkedHashMap r27 = new LinkedHashMap(MapsKt.mapCapacity(r11.size()));
        Iterator<T> r111 = r11.entrySet().iterator();
    L76:
        if (r111.hasNext() == false) goto L78;
        Map.Entry r28 = (Map.Entry) r111.next();
        r27.put(r28.getKey(), ((DefaultActiveModelSettingItem) r28.getValue()).getCurrentModelItemKey());
        goto L76
    L78:
        Intrinsics.checkNotNullParameter(r22, "newGroups");
        Intrinsics.checkNotNullParameter(r27, "initialSelectedKeys");
        ((ArrayList) r110.b).clear();
        ((ArrayList) r110.b).addAll(r22);
        ((LinkedHashMap) r110.c).clear();
        r110.c.putAll(r27);
        r110.d = null;
        r110.notifyDataSetChanged();
        return;
    L92:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusPageModelSettingsBinding r10 = this.d;
        DefaultReplyMenuConfigV2 r11 = null;
        if (r10 == null) goto L7;
        NovaTitleBarEx r12 = r10.c;
        if (r12 == null) goto L7;
        NovaTitleBarEx.Y5(r12, getString(2131907844), null, null, 6);
        NovaTitleBarEx.b6(r12, v19.c.b(2130971749, requireContext(), 2131241477), false, null, getString(2131898805), new c(this), 6);
        r12.R5();
    L7:
        this.f = new ModelSettingsAdapter(new AnonymousClass1(this));
        LarusPageModelSettingsBinding r13 = this.d;
        if (r13 == null) goto L12;
        RecyclerView r14 = r13.b;
        if (r14 == null) goto L12;
        r14.setLayoutManager(new LinearLayoutManager(requireContext()));
        r14.setAdapter(this.f);
    L12:
        DefaultReplyMenuDataV2 r15 = S90().getDefaultActiveModelMenu();
        if (r15 == null) goto L15;
        r11 = r15.getMenuConfV2();
    L15:
        Map<String, DefaultActiveModelSettingItem> r16 = S90().getDefaultActiveModelSettingItem();
        if (r16 != null) goto L18;
        r16 = MapsKt.emptyMap();
    L18:
        T90(r11, r16);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563052, r3, false);
        int r6 = 2131380248;
        RecyclerView r7 = ViewBindings.findChildViewById(r5, 2131380248);
        if (r7 == null) goto L9;
        r6 = 2131388772;
        NovaTitleBarEx r0 = (NovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L9;
        LinearLayout r8 = (LinearLayout) r5;
        this.d = new LarusPageModelSettingsBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
