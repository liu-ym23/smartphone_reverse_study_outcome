package com.larus.uaigc.createpage.component.inspiration;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.network.http.HttpExtKt;
import com.larus.uaigc.createpage.component.inspiration.adapter.ImgInspirationListAdapter;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ny9.u;
import org.json.JSONException;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020;H\u0016J\u001c\u0010>\u001a\u00020;2\b\b\u0001\u0010?\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020\rH\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0011H\u0016J\n\u0010E\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001b\u001a\u0004\b7\u00108¨\u0006G"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/ImgInspirationListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/uaigc/bean/createpage/component/inspiration/IImgInspirationListAbility;", "<init>", "()V", "imgInspireRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "imgInspireAdapter", "Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationListAdapter;", "currentMediaSelectorStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus;", "currentDetectFaceState", "", "Ljava/lang/Boolean;", "isInspirationScrolled", "imgInspirationSupportInstructionTypes", "", "", "isInitialized", "currentImgInspirePrompts", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "Lkotlin/Lazy;", "imgInspirationAbility", "Lcom/larus/uaigc/createpage/component/inspiration/ICreativityInspirationAbility;", "getImgInspirationAbility", "()Lcom/larus/uaigc/createpage/component/inspiration/ICreativityInspirationAbility;", "imgInspirationAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "mediaSelectorContainerAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "getMediaSelectorContainerAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "mediaSelectorContainerAbility$delegate", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "multiActionBarItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getMultiActionBarItem", "()Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "multiActionBarItem$delegate", "botId", "", "getBotId", "()Ljava/lang/String;", "botId$delegate", "onAttach", "", "observeEvents", "onCreate", "requestCreativityInspiration", "scene", "faceDetected", "addImgInspirationListView", "container", "Landroid/widget/LinearLayout;", "collectInstructionItemData", "collectImgInspirationText", "getImgInspirationSupportInstructionTypeList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImgInspirationListComponent extends ComponentFeature implements qy9.a {
    public RecyclerView h;
    public ImgInspirationListAdapter i;
    public ry9.j j;
    public Boolean k;
    public boolean l;
    public List<Integer> m;
    public boolean n;
    public volatile List<fq8.e> o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;

    public static final class a implements kz9.b {
        public final /* synthetic */ ImgInspirationListComponent a;

        public a(ImgInspirationListComponent r1) {
            this.a = r1;
        }

        @Override // kz9.b
        public final void a(fq8.e r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "item");
            this.a.N2().setChosenImgInspirePrompt(r10);
            this.a.N2().onImgInspirationClick(r10);
            ImgInspirationListAdapter r12 = this.a.i;
            String r0 = null;
            if (r12 == null) goto L5;
            fq8.e r13 = (fq8.e) CollectionsKt.getOrNull(r12.b, r11);
        L6:
            boolean r1 = true;
            int r14 = r11 + 1;
            String r2 = String.valueOf((String) this.a.v.getValue());
            u r3 = this.a.F2();
            if (r3 == null) goto L9;
            String r4 = r3.getChatType();
        L10:
            String r5 = String.valueOf(r4);
            if (r13 == null) goto L13;
            Long r6 = Long.valueOf(r13.c());
        L14:
            String r7 = String.valueOf(r6);
            if (r13 == null) goto L17;
            String r8 = r13.d();
        L18:
            String r9 = String.valueOf(r8);
            if (r13 != null) goto L21;
        L23:
            boolean r15 = false;
        L24:
            if (r15 == false) goto L26;
            String r16 = "image2image";
        L27:
            u r17 = this.a.F2();
            if (r17 == null) goto L30;
            r0 = r17.getEnterMethod();
        L30:
            String r18 = String.valueOf(r0);
            RecyclerView r19 = this.a.h;
            if (r19 != null) goto L33;
        L35:
            r1 = false;
        L36:
            if (r1 == false) goto L38;
            String r20 = "1";
        L39:
            JSONObject r21 = new JSONObject();
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r5, "chatType");
            Intrinsics.checkNotNullParameter(r7, "itemId");
            Intrinsics.checkNotNullParameter(r9, "title");
            Intrinsics.checkNotNullParameter(r16, "suggestType");
            Intrinsics.checkNotNullParameter(r18, "enterMethod");
            Intrinsics.checkNotNullParameter(r20, "keyboardStatus");
            Intrinsics.checkNotNullParameter(r21, "params");
            r21.put("bot_id", r2);     // Catch: JSONException -> L42
            r21.put("prompt_position", r14);     // Catch: JSONException -> L42
            r21.put("chat_type", r5);     // Catch: JSONException -> L42
            r21.put("item_id", r7);     // Catch: JSONException -> L42
            r21.put("title", r9);     // Catch: JSONException -> L42
            r21.put("suggest_type", r16);     // Catch: JSONException -> L42
            r21.put("enter_method", r18);     // Catch: JSONException -> L42
            r21.put("keyboard_status", r20);     // Catch: JSONException -> L42
        L44:
            TrackParams r110 = new TrackParams().merge(r21);
            by7.a r111 = new by7.a("image_gen_suggest_prompt_click");
            r111.a.merge(r110);
            r111.b();
            return;
        L42:
            e = move-exception;
            FLogger.a.e("InspirationEventHelper", "error in InspirationEventHelper chatActionBarShow " + e.getLocalizedMessage());
            goto L44
        L38:
            r20 = "0";
            goto L39
        L33:
            if (ViewExtKt.h(r19) != true) goto L35;
        L26:
            r16 = "text2image";
            goto L27
        L21:
            if (r13.e() != 2) goto L23;
            r15 = true;
            goto L24
        L17:
            r8 = null;
            goto L18
        L13:
            r6 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r13 = null;
            goto L6
        }
    }

    public final u F2() {
        return (u) this.t.getValue();
    }

    public final f L2() {
        return (f) this.q.getValue();
    }

    public final com.larus.bmhome.view.actionbar.edit.c N2() {
        return (com.larus.bmhome.view.actionbar.edit.c) this.p.getValue();
    }

    public final void onCreate() {
        this.i = new ImgInspirationListAdapter(new a(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImgInspirationListComponent$observeEvents$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImgInspirationListComponent$observeEvents$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImgInspirationListComponent$observeEvents$3(this, null), 3, null);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, qy9.a.class);
    }

    public ImgInspirationListComponent() {
        this.n = true;
        this.o = new ArrayList();
        this.p = LazyKt.lazy(new k(this));
        this.q = LazyKt.lazy(new l(this));
        this.r = LazyKt.lazy(new m(this));
        this.s = LazyKt.lazy(new n(this));
        this.t = LazyKt.lazy(new o(this));
        this.u = LazyKt.lazy(new p(this));
        this.v = LazyKt.lazy(new q(this));
    }

    @Override // qy9.a
    public final String Kw() {
        if (N2().getChosenImgInspirePrompt() != null) goto L6;
        return "";
    L6:
        fq8.e r0 = N2().getChosenImgInspirePrompt();
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.a();
    }

    @Override // qy9.a
    public final List<Integer> OJ() {
        if (N2().getChosenImgInspirePrompt() != null) goto L7;
        return null;
    L7:
        return this.m;
    }

    @Override // qy9.a
    public final List<com.larus.bmhome.actionbar.model.u> di() {
        if (N2().getChosenImgInspirePrompt() == null) goto L5;
        b0 r0 = new b0(0);
        ArrayList r1 = new ArrayList();
        fq8.e r2 = N2().getChosenImgInspirePrompt();
        if (r2 == null) goto L13;
        fq8.a r3 = r2.b();
        if (r3 == null) goto L13;
        long r4 = r3.a();
        if (r4 < 0) goto L13;
        ArrayList r5 = new ArrayList();
        r5.add(new w(Long.valueOf(r4), null, r3.b(), null, 0, null, 1, 8126454));
        Unit r6 = Unit.INSTANCE;
        r1.add(new c0(2, 3, GsonProtectorUtils.toJson(HttpExtKt.f, new com.larus.bmhome.actionbar.model.h(r5, 4079))));
    L13:
        r0.a = r1;
        com.larus.bmhome.actionbar.model.u r7 = (com.larus.bmhome.actionbar.model.u) this.u.getValue();
        if (r7 == null) goto L16;
        Integer r8 = r7.a;
    L18:
        return CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.u(r8, 8, null, GsonProtectorUtils.toJson(HttpExtKt.f, r0), null, null, null, 244));
    L16:
        r8 = null;
        goto L18
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // qy9.a
    public final void lk(LinearLayout r11) {
        Intrinsics.checkNotNullParameter(r11, "container");
        boolean r2 = false;
        View r0 = LayoutInflater.from(r11.getContext()).inflate(2131562831, r11, false);
        int r1 = 2131364451;
        if (ViewBindings.findChildViewById(r0, 2131364451) == null) goto L20;
        r1 = 2131375152;
        RecyclerView r3 = ViewBindings.findChildViewById(r0, 2131375152);
        if (r3 == null) goto L20;
        r11.addView((LinearLayout) r0);
        this.h = r3;
        r3.setItemAnimator(null);
        r3.setAdapter(this.i);
        List<fq8.e> r12 = this.o;
        if (r12 != null) goto L9;
    L10:
        r2 = true;
    L11:
        if (r2 == false) goto L15;
        RecyclerView r13 = this.h;
        if (r13 == null) goto L15;
        e1.o(r13);
    L15:
        r3.addItemDecoration(new ImgInspirationListComponent$addImgInspirationListView$1$1());
        r3.addOnScrollListener(new ImgInspirationListComponent$addImgInspirationListView$1$2(this));
        RecyclerView r4 = this.h;
        if (r4 == null) goto L21;
        y6.f(r4, new i(this), null, 0.1f, new j(this), 53);
        return;
    L21:
        return;
    L9:
        if (r12.isEmpty() == false) goto L11;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
