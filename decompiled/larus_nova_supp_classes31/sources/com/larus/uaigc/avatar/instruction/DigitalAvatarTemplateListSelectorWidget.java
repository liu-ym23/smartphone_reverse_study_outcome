package com.larus.uaigc.avatar.instruction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.u3;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003*\u0002\u001b\"\u0018\u00002\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001eH\u0014J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#¨\u00060"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;", "setBinding", "(Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;)V", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderV2Binding;", "adapter", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter;", "controller", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorController;", "getController", "()Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateInstructionTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateInstructionTemplate;", "collected", "", "digitalAvatarTemplateDialogCallback", "com/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$digitalAvatarTemplateDialogCallback$1", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$digitalAvatarTemplateDialogCallback$1;", "selectDigitalAvatarTemplateInfo", "", "templateInfo", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "itemClickCallback", "com/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$itemClickCallback$1;", "init", "attrs", "Landroid/util/AttributeSet;", "onDetachedFromWindow", "onBindView", "bindObservers", "requestTemplateList", "reportCreationRecommendOpCounter", "templatePrimaryKey", "", "goToDigitalAvatarTemplateList", "CountOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DigitalAvatarTemplateListSelectorWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int l = 0;
    public LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding f;
    public LarusItemActionbarImageTemplateCoverHolderV2Binding g;
    public DigitalAvatarSelectorWidgetAdapter h;
    public boolean i;
    public final a j;
    public final b k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$CountOption;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CountOption {
        public static final a Companion = null;
        public static final int DECR = 2;
        public static final int INCR = 1;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public final /* synthetic */ DigitalAvatarTemplateListSelectorWidget a;

        public a(DigitalAvatarTemplateListSelectorWidget r1) {
            this.a = r1;
        }
    }

    public static final class b implements e {
        public final /* synthetic */ DigitalAvatarTemplateListSelectorWidget a;

        public b(DigitalAvatarTemplateListSelectorWidget r1) {
            this.a = r1;
        }

        @Override // com.larus.uaigc.avatar.instruction.e
        public final void a(com.larus.bmhome.actionbar.model.f r43, int r44) {
            Intrinsics.checkNotNullParameter(r43, "item");
            i r2 = DigitalAvatarTemplateListSelectorWidget.o6(this.a);
            if (r2 == null) goto L5;
            r2.m = null;
        L5:
            com.larus.bmhome.actionbar.model.e r3 = DigitalAvatarTemplateListSelectorWidget.s6(this.a);
            if (r3 == null) goto L20;
            List r4 = r3.c;
            if (r4 == null) goto L20;
            Iterator r5 = r4.iterator();
        L11:
            if (r5.hasNext() == false) goto L18;
            Object r6 = r5.next();
            if (((com.larus.bmhome.actionbar.model.f) r6).a != r43.a) goto L15;
            boolean r7 = true;
        L16:
            if (r7 == false) goto L11;
        L19:
            com.larus.bmhome.actionbar.model.f r8 = (com.larus.bmhome.actionbar.model.f) r6;
        L21:
            if (r8 == null) goto L33;
            com.larus.bmhome.actionbar.model.e r9 = DigitalAvatarTemplateListSelectorWidget.s6(this.a);
            if (r9 == null) goto L36;
            List r10 = r9.c;
            if (r10 == null) goto L36;
            Iterator r11 = r10.iterator();
        L28:
            if (r11.hasNext() == false) goto L36;
            com.larus.bmhome.actionbar.model.f r12 = (com.larus.bmhome.actionbar.model.f) r11.next();
            if (r12.a == r43.a) goto L31;
            r12.h = 0;
            goto L28
        L31:
            r12.h = 1;
        L36:
            com.larus.bmhome.view.actionbar.edit.c r13 = this.a.getViewModel();
            if (r13 == null) goto L44;
            ChatParam r14 = r13.getChatParam();
            if (r14 == null) goto L44;
            String r15 = r14.b;
            if (r15 == null) goto L44;
            String r16 = r15;
        L45:
            String r17 = String.valueOf(r43.a);
            com.larus.bmhome.view.actionbar.edit.c r18 = this.a.getViewModel();
            if (r18 == null) goto L53;
            ChatParam r19 = r18.getChatParam();
            if (r19 == null) goto L53;
            String r20 = r19.e;
            if (r20 == null) goto L53;
            String r21 = r20;
        L54:
            u3.l(r16, r17, "chat_action_bar", r21, "replica", "avatar2image", "default", null, Integer.valueOf(r44), null, null, 4, null, null, null, "action_bar_template", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -140416, 31);
            DigitalAvatarTemplateListSelectorWidget r22 = this.a;
            long r23 = r43.a;
            r22.getClass();
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1(r23, null), 2, null);
            com.larus.bmhome.view.actionbar.edit.c r24 = this.a.getViewModel();
            if (r24 == null) goto L69;
            r24.onInstructionDigitalAvatarTemplateSelected(r43);
            return;
        L69:
            return;
        L53:
            r21 = "";
        L44:
            r16 = "";
            goto L45
        L33:
            i r25 = DigitalAvatarTemplateListSelectorWidget.o6(this.a);
            if (r25 == null) goto L36;
            r25.m = r43;
            goto L36
        L15:
            r7 = false;
            goto L16
        L18:
            r6 = null;
        L20:
            r8 = null;
            goto L21
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.uaigc.avatar.instruction.q] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.uaigc.avatar.instruction.p] */
        @Override // com.larus.uaigc.avatar.instruction.e
        public final void b(com.larus.bmhome.actionbar.model.f r39, int r40, View r41) {
            Intrinsics.checkNotNullParameter(r39, "item");
            Intrinsics.checkNotNullParameter(r41, "view");
            com.larus.bmhome.actionbar.model.e r2 = DigitalAvatarTemplateListSelectorWidget.s6(this.a);
            String r3 = null;
            if (r2 == null) goto L22;
            List r4 = r2.c;
            if (r4 == null) goto L22;
            List r5 = r4;
            ?? r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L23;
            com.larus.bmhome.actionbar.model.f r8 = (com.larus.bmhome.actionbar.model.f) r7.next();
            String r9 = String.valueOf(r8.a);
            int r10 = 3;
            Integer r11 = null;
            g1 r12 = r8.e;
            if (r12 == null) goto L12;
            Image r15 = gy9.d.b(r12);
        L13:
            g1 r13 = r8.f;
            if (r13 == null) goto L16;
            Image r14 = gy9.d.b(r13);
        L17:
            g1 r16 = r8.g;
            if (r16 == null) goto L20;
            Image r17 = gy9.d.b(r16);
        L21:
            r6.add(new UserCreation(r9, r10, r11, new UserCreationContent(new UserCreationUserAvatar(new ImageInfo(r14, r15, r17, null, null, null, null, null, null, 1016), r8.c, 26), 59), 131052));
            goto L8
        L20:
            r17 = null;
            goto L21
        L16:
            r14 = null;
            goto L17
        L12:
            r15 = null;
        L23:
            final ?? r18 = r6;
            i r19 = DigitalAvatarTemplateListSelectorWidget.o6(this.a);
            if (r19 == null) goto L28;
            boolean r20 = true;
            if (r19.l != true) goto L28;
        L29:
            if (r20 == false) goto L31;
            final int r21 = r40 - 1;
        L32:
            IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r22 == null) goto L39;
            r22.w();
            k1 r23 = k1.a;
            Fragment r24 = this.a.getFragment();
            if (r24 == null) goto L37;
            FragmentManager r25 = r24.getParentFragmentManager();
        L38:
            final DigitalAvatarTemplateListSelectorWidget r26 = this.a;
            r23.n(r25, r18, r21, new p(r18, r26), new q(r21, r26));
            goto L39
        L37:
            r25 = null;
        L39:
            String r27 = String.valueOf(r39.a);
            com.larus.bmhome.view.actionbar.edit.c r1 = this.a.getViewModel();
            if (r1 == null) goto L44;
            ChatParam r28 = r1.getChatParam();
            if (r28 == null) goto L44;
            String r29 = r28.b;
        L45:
            com.larus.bmhome.view.actionbar.edit.c r30 = this.a.getViewModel();
            if (r30 == null) goto L50;
            ChatParam r31 = r30.getChatParam();
            if (r31 == null) goto L50;
            r3 = r31.e;
        L50:
            u3.g(r29, r27, "replica", "avatar2image", null, "default", null, null, null, "click_action_bar", "action_bar_template", Integer.valueOf(r40), r3, 11, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -30256, 7);
            return;
        L44:
            r29 = null;
            goto L45
        L31:
            r21 = r40;
        L28:
            r20 = false;
        L22:
            r6 = CollectionsKt.emptyList();
            goto L23
        }
    }

    public final LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding getBinding() {
        LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final i getController() {
        return (i) getController();
    }

    private final com.larus.bmhome.actionbar.model.e getCurrentBindData() {
        i r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.n;
    }

    public final void Y5() {
        u r0 = getInstructionItem();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L6:
        if (r2 == false) goto L8;
        e1.x(getBinding().b);
    L8:
        u r3 = getInstructionItem();
        if (r3 == null) goto L11;
        String r4 = r3.c;
    L13:
        if (o0.d(r4) == false) goto L19;
        TextView r5 = getBinding().e;
        u r6 = getInstructionItem();
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        r5.setText(r7);
        e1.x(getBinding().e);
        goto L19
    L17:
        r7 = null;
    L19:
        i r8 = getController();
        if (r8 != null) goto L22;
    L24:
        if (r1 == false) goto L26;
        this.h = new DigitalAvatarSelectorWidgetAdapter(this.k, new j(this));
    L27:
        getBinding().c.setAdapter(this.h);
        getBinding().c.addItemDecoration(new DigitalAvatarTemplateListSelectorWidget$onBindView$2());
        y6.f(getBinding().c, new k(this), new l(this), 0.0f, new m(this), 57);
        DigitalAvatarSelectorWidgetAdapter r9 = this.h;
        if (r9 == null) goto L35;
        com.larus.bmhome.actionbar.model.e r10 = getCurrentBindData();
        if (r10 == null) goto L32;
        List r11 = r10.c;
    L33:
        r9.submitList(r11);
        goto L35
    L32:
        r11 = null;
    L35:
        if (this.i == true) goto L42;
        this.i = true;
        CoroutineScope r12 = getComponentScope();
        if (r12 == null) goto L41;
        BuildersKt.launch$default(r12, null, null, new DigitalAvatarTemplateListSelectorWidget$bindObservers$1(this, null), 3, null);
        return;
    L41:
        return;
    L42:
        return;
    L26:
        this.h = new DigitalAvatarSelectorWidgetAdapter(this.k, null);
        goto L27
    L22:
        if (r8.l != true) goto L24;
        r1 = true;
        goto L24
    L11:
        r4 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDetachedFromWindow ,current state is ");
        Fragment r2 = getFragment();
        if (r2 == null) goto L7;
        Lifecycle r3 = r2.getLifecycle();
        if (r3 == null) goto L7;
        Lifecycle.State r4 = r3.getCurrentState();
    L8:
        r1.append(r4);
        r0.i("DigitalAvatarTemplateListSelectorWidget", r1.toString());
        return;
    L7:
        r4 = null;
        goto L8
    }

    public DigitalAvatarTemplateListSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.j = new a(this);
        this.k = new b(this);
    }

    public static final /* synthetic */ i o6(DigitalAvatarTemplateListSelectorWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.e s6(DigitalAvatarTemplateListSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    public final void setBinding(LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void u6(ab8.a r15) {
        i r0 = getController();
        com.larus.bmhome.actionbar.model.f r1 = null;
        if (r0 == null) goto L5;
        r0.m = null;
    L5:
        i r2 = getController();
        if (r2 == null) goto L24;
        com.larus.bmhome.actionbar.model.e r4 = getCurrentBindData();
        if (r4 == null) goto L22;
        List r5 = r4.c;
        if (r5 == null) goto L22;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        if (((com.larus.bmhome.actionbar.model.f) r7).a != r15.a()) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L13;
    L21:
        com.larus.bmhome.actionbar.model.f r9 = (com.larus.bmhome.actionbar.model.f) r7;
    L23:
        r2.m = r9;
        goto L24
    L17:
        r8 = false;
        goto L18
    L20:
        r7 = null;
    L22:
        r9 = null;
    L24:
        i r3 = getController();
        if (r3 == null) goto L27;
        com.larus.bmhome.actionbar.model.f r10 = r3.m;
    L28:
        if (r10 == null) goto L40;
        com.larus.bmhome.actionbar.model.e r11 = getCurrentBindData();
        if (r11 == null) goto L43;
        List r12 = r11.c;
        if (r12 == null) goto L43;
        Iterator r13 = r12.iterator();
    L35:
        if (r13.hasNext() == false) goto L43;
        com.larus.bmhome.actionbar.model.f r14 = (com.larus.bmhome.actionbar.model.f) r13.next();
        if (r14.a == r15.a()) goto L38;
        r14.h = 0;
        goto L35
    L38:
        r14.h = 1;
    L43:
        com.larus.bmhome.view.actionbar.edit.c r16 = getViewModel();
        if (r16 == null) goto L72;
        ChatParam r17 = r16.getChatParam();
        if (r17 == null) goto L72;
        String r18 = r17.a;
        if (r18 == null) goto L72;
        IAIChatRenderTraceService.Companion r19 = IAIChatRenderTraceService.a;
        Pair[] r20 = new Pair[6];
        UserCreation r21 = r15.a;
        if (r21 == null) goto L52;
        String r22 = r21.a;
    L53:
        r20[0] = TuplesKt.to("from_template_id", r22);
        UserCreation r23 = r15.a;
        if (r23 == null) goto L56;
        String r24 = zp9.d.d(r23);
    L57:
        r20[1] = TuplesKt.to("from_template_type", r24);
        UserCreation r25 = r15.a;
        if (r25 == null) goto L62;
        UserCreationTrackParams r26 = r25.n;
        if (r26 == null) goto L62;
        String r27 = r26.a;
    L63:
        r20[2] = TuplesKt.to("template_rec_req_id", r27);
        UserCreation r28 = r15.a;
        if (r28 == null) goto L66;
        String r29 = zp9.d.b(r28);
    L67:
        r20[3] = TuplesKt.to("from_template_source", r29);
        r20[4] = TuplesKt.to("is_from_template", "1");
        UserCreation r110 = r15.a;
        if (r110 == null) goto L70;
        String r111 = r110.i;
    L71:
        r20[5] = TuplesKt.to("template_rec_extra", r111);
        r19.c(r18, MapsKt.mapOf(r20));
        goto L72
    L70:
        r111 = null;
        goto L71
    L66:
        r29 = null;
    L62:
        r27 = null;
        goto L63
    L56:
        r24 = null;
        goto L57
    L52:
        r22 = null;
    L72:
        com.larus.bmhome.view.actionbar.edit.c r112 = getViewModel();
        if (r112 == null) goto L90;
        i r30 = getController();
        if (r30 == null) goto L77;
        r1 = r30.m;
    L77:
        r112.onInstructionDigitalAvatarTemplateSelected(r1);
        return;
    L90:
        return;
    L40:
        i r31 = getController();
        if (r31 == null) goto L43;
        r31.m = new com.larus.bmhome.actionbar.model.f(r15.a(), r15.e(), r15.d(), r15.b(), r15.c(), null, 138);
        goto L43
    L27:
        r10 = null;
        goto L28
    }

    public static Object i6(DigitalAvatarTemplateListSelectorWidget r2, int r3) {
        com.larus.bmhome.actionbar.model.e r4 = r2.getCurrentBindData();
        if (r4 == null) goto L7;
        List r5 = r4.c;
        if (r5 == null) goto L7;
        com.larus.bmhome.actionbar.model.f r6 = (com.larus.bmhome.actionbar.model.f) CollectionsKt.getOrNull(r5, r3);
    L8:
        StringBuilder r7 = new StringBuilder();
        if (r6 == null) goto L11;
        long r0 = r6.a;
    L12:
        r7.append(r0);
        r7.append('_');
        if (r6 == null) goto L16;
        String r8 = r6.c;
        if (r8 == null) goto L16;
    L17:
        r7.append(r8);
        return r7.toString();
    L16:
        r8 = "";
        goto L17
    L11:
        r0 = 0;
    L7:
        r6 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        LayoutInflater.from(r7).inflate(2131562713, this);
        int r9 = 2131364451;
        View r2 = ViewBindings.findChildViewById(this, 2131364451);
        if (r2 == null) goto L13;
        r9 = 2131369113;
        RecyclerView r3 = ViewBindings.findChildViewById(this, 2131369113);
        if (r3 == null) goto L13;
        r9 = 2131386070;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131386070);
        if (r4 == null) goto L13;
        r9 = 2131390504;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131390504);
        if (r5 == null) goto L13;
        setBinding(new LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding(this, r2, r3, r4, r5));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r9)));
    }

    public static boolean k6(DigitalAvatarTemplateListSelectorWidget r1, int r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        i r4 = r1.getController();
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        if (r2 != 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r4.l != true) goto L7;
        r5 = true;
        goto L8
    }

    public static void n6(DigitalAvatarTemplateListSelectorWidget r35, int r36, RecyclerView.ViewHolder r37) {
        int r0 = r36;
        Intrinsics.checkNotNullParameter(r37, "<unused var>");
        com.larus.bmhome.actionbar.model.e r1 = r35.getCurrentBindData();
        String r2 = null;
        if (r1 == null) goto L7;
        List r3 = r1.c;
        if (r3 == null) goto L7;
        com.larus.bmhome.actionbar.model.f r4 = (com.larus.bmhome.actionbar.model.f) CollectionsKt.getOrNull(r3, r0);
    L8:
        com.larus.bmhome.view.actionbar.edit.c r5 = r35.getViewModel();
        if (r5 == null) goto L13;
        ChatParam r6 = r5.getChatParam();
        if (r6 == null) goto L13;
        String r7 = r6.b;
    L14:
        if (r4 == null) goto L16;
        Long r8 = Long.valueOf(r4.a);
    L17:
        String r9 = String.valueOf(r8);
        i r10 = r35.getController();
        if (r10 == null) goto L22;
        boolean r11 = true;
        if (r10.l != true) goto L22;
    L23:
        if (r11 == true) goto L26;
        r0 = r0 + 1;
    L26:
        String r15 = String.valueOf(r0);
        com.larus.bmhome.view.actionbar.edit.c r12 = r35.getViewModel();
        if (r12 == null) goto L31;
        ChatParam r13 = r12.getChatParam();
        if (r13 == null) goto L31;
        r2 = r13.e;
    L31:
        u3.k(r7, r9, "replica", "avatar2image", null, null, null, null, null, "action_bar", "chat", r15, null, r2, null, null, null, null, null, "create_button_panel", null, null, null, false, null, null, null, null, null, null, -536080);
        return;
    L22:
        r11 = false;
        goto L23
    L16:
        r8 = null;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }
}
