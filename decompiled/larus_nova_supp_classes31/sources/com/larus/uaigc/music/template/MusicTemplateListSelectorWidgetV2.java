package com.larus.uaigc.music.template;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.uaigc.image.instruction.AbsTemplateListEditorWidget;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderBinding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorBinding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.uaigc.music.applet.MusicTemplateAppletFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kr8.b0;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0018\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0014J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020&2\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020&H\u0002J\n\u00108\u001a\u0004\u0018\u00010*H\u0002J\b\u00109\u001a\u00020:H\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dRB\u0010$\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110*¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001f0%j\u0002`,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateListSelectorWidgetV2;", "Lcom/larus/uaigc/image/instruction/AbsTemplateListEditorWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorBinding;", "binding", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorBinding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderBinding;", "controller", "Lcom/larus/uaigc/music/controller/MusicTemplateListSelectorController;", "getController", "()Lcom/larus/uaigc/music/controller/MusicTemplateListSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarMusicTemplateInstructionTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarMusicTemplateInstructionTemplate;", "itemClickCallback", "com/larus/uaigc/music/template/MusicTemplateListSelectorWidgetV2$itemClickCallback$1", "Lcom/larus/uaigc/music/template/MusicTemplateListSelectorWidgetV2$itemClickCallback$1;", "templateListView", "Landroidx/recyclerview/widget/RecyclerView;", "getTemplateListView", "()Landroidx/recyclerview/widget/RecyclerView;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "onDetachedFromWindow", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "enterFrom", "Lcom/larus/uaigc/music/template/TemplateChooseCallback;", "collectStarted", "", "startObserveTemplateChoose", "requestTemplateList", "goToMusicTemplateList", "data", "Lcom/larus/uaigc/music/template/MusicTemplateModel;", "selectMusicTemplateInternal", "item", "submitTemplateCount", "template", "musicAppletCurrentPage", "buildMusicAppletOptionParams", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateListSelectorWidgetV2 extends AbsTemplateListEditorWidget {
    public static final /* synthetic */ int n = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorBinding h;
    public ImageSelectorWidgetAdapter i;
    public LarusItemActionbarImageTemplateCoverHolderBinding j;
    public final a k;
    public final p l;
    public boolean m;

    public static final class a implements vz9.d {
        public final /* synthetic */ MusicTemplateListSelectorWidgetV2 a;

        @Override // vz9.d
        public final void b(com.larus.bmhome.actionbar.model.w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public a(MusicTemplateListSelectorWidgetV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v7, types: [int] */
        @Override // vz9.d
        public final void a(com.larus.bmhome.actionbar.model.w r53, int r54) {
            com.larus.bmhome.actionbar.model.w r1 = r53;
            Intrinsics.checkNotNullParameter(r1, "item");
            ArrayList r2 = new ArrayList();
            d0 r3 = MusicTemplateListSelectorWidgetV2.o6(this.a);
            int r7 = 1;
            if (r3 == null) goto L83;
            List r4 = r3.a;
            if (r4 == null) goto L83;
            MusicTemplateListSelectorWidgetV2 r8 = this.a;
            Iterator r5 = r4.iterator();
            int r9 = 0;
        L8:
            if (r5.hasNext() == false) goto L83;
            Object r10 = r5.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r10;
            if (Intrinsics.areEqual(r12.a, r1.a) == false) goto L81;
            d0 r13 = MusicTemplateListSelectorWidgetV2.o6(r8);
            if (r13 == null) goto L17;
            boolean r14 = Intrinsics.areEqual(r13.c, Boolean.FALSE);
        L18:
            if (r14 == false) goto L25;
            Integer r15 = r12.s;
            if (r15 == null) goto L25;
            if (r15.intValue() != r7) goto L25;
            r12.s = 0;
        L26:
            MusicTemplateListSelectorWidgetV2.n6(r8);
            com.larus.bmhome.view.actionbar.edit.c r16 = r8.getViewModel();
            if (r16 == null) goto L31;
            ChatParam r17 = r16.getChatParam();
            if (r17 == null) goto L31;
            String r18 = r17.b;
        L32:
            com.larus.bmhome.view.actionbar.edit.c r19 = r8.getViewModel();
            if (r19 == null) goto L37;
            ChatParam r110 = r19.getChatParam();
            if (r110 == null) goto L37;
            String r111 = r110.e;
        L38:
            com.larus.bmhome.view.actionbar.edit.c r112 = r8.getViewModel();
            if (r112 == null) goto L41;
            String r113 = r112.getTemplateType();
        L42:
            com.larus.bmhome.view.actionbar.edit.c r114 = r8.getViewModel();
            if (r114 == null) goto L45;
            String r115 = r114.getActionBarType();
        L46:
            com.larus.bmhome.view.actionbar.edit.c r116 = r8.getViewModel();
            if (r116 == null) goto L51;
            z0 r117 = r116.getCurrentCustomActionBarItem();
            if (r117 == null) goto L51;
            String r118 = r117.b;
        L52:
            com.larus.bmhome.actionbar.model.u r119 = r8.getInstructionItem();
            if (r119 == null) goto L55;
            String r120 = r119.c;
        L56:
            String r121 = r1.b;
            String r21 = String.valueOf(r1.a);
            d0 r6 = MusicTemplateListSelectorWidgetV2.o6(r8);
            if (r6 == null) goto L64;
            Integer r20 = r6.b;
            if (r20 == null) goto L64;
            if (r9 != r20.intValue()) goto L64;
            int r22 = 1;
        L65:
            d0 r23 = MusicTemplateListSelectorWidgetV2.o6(r8);
            if (r23 == null) goto L68;
            ?? r24 = Intrinsics.areEqual(r23.c, Boolean.TRUE);
        L69:
            int r25 = r54 + 1;
            Integer r26 = r12.s;
            if (r26 != null) goto L73;
        L75:
            String r27 = "cancel";
        L76:
            String r28 = r27;
            com.larus.bmhome.view.actionbar.edit.c r29 = r8.getViewModel();
            if (r29 == null) goto L79;
            Boolean r37 = r29.isCreationActionBar();
        L80:
            String r35 = r8.u6();
            JSONObject r210 = r8.s6();
            tx9.b.e(r18, r111, r113, r115, r118, r120, null, r121, r21, Integer.valueOf(r22), Integer.valueOf(r24), Integer.valueOf(r25), r28, null, null, null, r210, "original", null, null, null, null, r35, null, r37, null, null, null, null, null, null, null, null, null, null, null, null, -42278848, 127);
        L82:
            r2.add(r12);
            r1 = r53;
            r9 = r11;
            r7 = 1;
            goto L8
        L79:
            r37 = null;
            goto L80
        L73:
            if (r26.intValue() != 1) goto L75;
            r27 = "select";
            goto L76
        L68:
            r24 = 0;
        L64:
            r22 = 0;
            goto L65
        L55:
            r120 = null;
        L51:
            r118 = null;
            goto L52
        L45:
            r115 = null;
            goto L46
        L41:
            r113 = null;
        L37:
            r111 = null;
        L31:
            r18 = null;
        L25:
            r12.s = Integer.valueOf(r7);
            goto L26
        L17:
            r14 = false;
            goto L18
        L81:
            r12.s = 0;
        L83:
            ImageSelectorWidgetAdapter r30 = this.a.i;
            if (r30 == null) goto L86;
            r30.submitList(r2);
        L86:
            d0 r31 = MusicTemplateListSelectorWidgetV2.o6(this.a);
            if (r31 == null) goto L104;
            List r32 = r31.a;
            if (r32 == null) goto L104;
            Iterator r33 = r32.iterator();
        L92:
            if (r33.hasNext() == false) goto L102;
            Object r34 = r33.next();
            Integer r36 = ((com.larus.bmhome.actionbar.model.w) r34).s;
            if (r36 != null) goto L97;
        L99:
            boolean r38 = false;
        L100:
            if (r38 == false) goto L92;
            Object r39 = r34;
        L103:
            com.larus.bmhome.actionbar.model.w r40 = (com.larus.bmhome.actionbar.model.w) r39;
        L105:
            com.larus.bmhome.actionbar.model.u r41 = this.a.getInstructionItem();
            if (r41 == null) goto L114;
            Integer r42 = r41.a;
            if (r42 == null) goto L114;
            if (r42.intValue() != 1) goto L114;
            boolean r43 = true;
        L115:
            if (r43 == false) goto L131;
            com.larus.bmhome.view.actionbar.edit.c r44 = this.a.getViewModel();
            if (r44 == null) goto L132;
            if (r40 == null) goto L120;
            boolean r45 = true;
        L121:
            r44.setImageStyleRadioSelected(r45);
            return;
        L120:
            r45 = false;
            goto L121
        L132:
            return;
        L131:
            return;
        L114:
            r43 = false;
            goto L115
        L97:
            if (r36.intValue() != 1) goto L99;
            r38 = true;
            goto L100
        L102:
            r39 = null;
        L104:
            r40 = null;
            goto L105
        }
    }

    public final void Y5() {
        List<com.larus.bmhome.actionbar.model.w> r1 = null;
        if (this.m == true) goto L8;
        this.m = true;
        CoroutineScope r3 = getComponentScope();
        if (r3 == null) goto L8;
        BuildersKt.launch$default(r3, null, null, new MusicTemplateListSelectorWidgetV2$startObserveTemplateChoose$1(this, null), 3, null);
    L8:
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        boolean r4 = false;
        if (r0 == null) goto L11;
        boolean r2 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L12:
        if (r2 == false) goto L14;
        e1.x(getBinding().b);
    L14:
        com.larus.bmhome.actionbar.model.u r5 = getInstructionItem();
        if (r5 == null) goto L17;
        String r6 = r5.c;
    L19:
        if (o0.d(r6) == false) goto L25;
        TextView r7 = getBinding().e;
        com.larus.bmhome.actionbar.model.u r8 = getInstructionItem();
        if (r8 == null) goto L23;
        String r9 = r8.c;
    L24:
        r7.setText(r9);
        e1.x(getBinding().e);
        goto L25
    L23:
        r9 = null;
    L25:
        wz9.a r10 = getController();
        if (r10 != null) goto L28;
    L30:
        boolean r11 = false;
    L31:
        if (r11 == false) goto L33;
        this.i = new ImageSelectorWidgetAdapter(this.k, new q(this));
    L34:
        y6.d(getBinding().c, null, null, null, new r(this), 15);
        getBinding().c.setAdapter(this.i);
        getBinding().c.addItemDecoration(new MusicTemplateListSelectorWidgetV2$onBindView$3());
        d0 r12 = getCurrentBindData();
        if (r12 == null) goto L39;
        Integer r13 = r12.b;
        if (r13 == null) goto L39;
        int r14 = r13.intValue();
    L40:
        this.f = Integer.valueOf(r14);
        if (r14 < 0) goto L50;
        d0 r15 = getCurrentBindData();
        if (r15 == null) goto L47;
        List r16 = r15.a;
        if (r16 == null) goto L47;
        com.larus.bmhome.actionbar.model.w r17 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r16, r14);
    L48:
        if (r17 == null) goto L50;
        r17.s = 1;
    L47:
        r17 = null;
    L50:
        d0 r18 = getCurrentBindData();
        if (r18 == null) goto L66;
        List r19 = r18.a;
        if (r19 == null) goto L66;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L56:
        if (r21.hasNext() == false) goto L67;
        Object r22 = r21.next();
        Integer r23 = ((com.larus.bmhome.actionbar.model.w) r22).s;
        if (r23 != null) goto L61;
    L63:
        boolean r24 = false;
    L64:
        if (r24 == false) goto L56;
        r20.add(r22);
        goto L56
    L61:
        if (r23.intValue() != 1) goto L63;
        r24 = true;
    L67:
        if (r20 != null) goto L69;
    L72:
        boolean r25 = true;
    L73:
        if (r25 == true) goto L86;
        com.larus.bmhome.actionbar.model.u r26 = getInstructionItem();
        if (r26 == null) goto L82;
        Integer r27 = r26.a;
        if (r27 == null) goto L82;
        if (r27.intValue() != 1) goto L82;
        r4 = true;
    L82:
        if (r4 == false) goto L86;
        com.larus.bmhome.view.actionbar.edit.c r28 = getViewModel();
        if (r28 == null) goto L86;
        r28.setImageStyleRadioSelected(true);
    L86:
        ImageSelectorWidgetAdapter r29 = this.i;
        if (r29 == null) goto L98;
        d0 r30 = getCurrentBindData();
        if (r30 == null) goto L91;
        r1 = r30.a;
    L91:
        r29.submitList(r1);
        return;
    L98:
        return;
    L69:
        if (r20.isEmpty() == true) goto L72;
        r25 = false;
    L66:
        r20 = null;
    L39:
        r14 = -1;
        goto L40
    L33:
        this.i = new ImageSelectorWidgetAdapter(this.k, null);
        goto L34
    L28:
        if (r10.n != true) goto L30;
        r11 = true;
        goto L31
    L17:
        r6 = null;
        goto L19
    L11:
        r2 = false;
        goto L12
    }

    public final LarusLayoutActionBarEditorWidgetImageSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final wz9.a getController() {
        return (wz9.a) getController();
    }

    private final d0 getCurrentBindData() {
        wz9.a r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    @Override // com.larus.uaigc.image.instruction.AbsTemplateListEditorWidget
    public RecyclerView getTemplateListView() {
        return getBinding().c;
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
        r0.i("LyricsToSongBox", r1.toString());
        Fragment r5 = getFragment();
        if (r5 == null) goto L13;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L13;
        Lifecycle.State r7 = r6.getCurrentState();
    L15:
        if (r7 == Lifecycle.State.RESUMED) goto L18;
        MusicTemplateRepository r8 = MusicTemplateRepository.a;
        MusicTemplateRepository.c = false;
        MusicTemplateRepository.d = null;
        return;
    L18:
        return;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final JSONObject s6() {
        if ((getFragment() instanceof MusicTemplateAppletFragment) == false) goto L10;
        kr8.n r0 = kr8.n.a;
        Fragment r1 = getFragment();
        if (r1 == null) goto L7;
        Bundle r2 = r1.getArguments();
    L11:
        return kr8.n.d(kr8.n.a(r2, null, null, null, null, null, 62), null, true);
    L7:
        r2 = null;
        goto L11
    L10:
        return new JSONObject();
    }

    public final String u6() {
        if ((getFragment() instanceof MusicTemplateAppletFragment) == false) goto L5;
        return "template_page";
    L5:
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.uaigc.music.template.p] */
    public MusicTemplateListSelectorWidgetV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.k = new a(this);
        this.l = new p(this);
    }

    public static final /* synthetic */ wz9.a n6(MusicTemplateListSelectorWidgetV2 r0) {
        return r0.getController();
    }

    public static final /* synthetic */ d0 o6(MusicTemplateListSelectorWidgetV2 r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.h = LarusLayoutActionBarEditorWidgetImageSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public static void i6(MusicTemplateListSelectorWidgetV2 r30, int r31, RecyclerView.ViewHolder r32) {
        Intrinsics.checkNotNullParameter(r32, "<unused var>");
        wz9.a r0 = r30.getController();
        ?? r1 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        int r3 = r31 - 1;
    L11:
        ImageSelectorWidgetAdapter r4 = r30.i;
        Boolean r5 = null;
        if (r4 == null) goto L16;
        List<com.larus.bmhome.actionbar.model.w> r6 = r4.c;
        if (r6 == null) goto L16;
        com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r6, r3);
    L17:
        if (r7 == null) goto L65;
        com.larus.bmhome.view.actionbar.edit.c r8 = r30.getViewModel();
        if (r8 == null) goto L23;
        ChatParam r9 = r8.getChatParam();
        if (r9 == null) goto L23;
        String r10 = r9.b;
    L24:
        com.larus.bmhome.view.actionbar.edit.c r11 = r30.getViewModel();
        if (r11 == null) goto L29;
        ChatParam r12 = r11.getChatParam();
        if (r12 == null) goto L29;
        String r13 = r12.e;
    L30:
        com.larus.bmhome.view.actionbar.edit.c r14 = r30.getViewModel();
        if (r14 == null) goto L33;
        String r15 = r14.getTemplateType();
    L34:
        com.larus.bmhome.view.actionbar.edit.c r16 = r30.getViewModel();
        if (r16 == null) goto L37;
        String r17 = r16.getActionBarType();
    L38:
        com.larus.bmhome.view.actionbar.edit.c r18 = r30.getViewModel();
        if (r18 == null) goto L43;
        z0 r19 = r18.getCurrentCustomActionBarItem();
        if (r19 == null) goto L43;
        String r110 = r19.b;
    L44:
        com.larus.bmhome.actionbar.model.u r20 = r30.getInstructionItem();
        if (r20 == null) goto L47;
        String r111 = r20.c;
    L48:
        String r112 = r7.b;
        String r113 = String.valueOf(r7.a);
        d0 r21 = r30.getCurrentBindData();
        if (r21 == null) goto L56;
        Integer r22 = r21.b;
        if (r22 == null) goto L56;
        if (r3 != r22.intValue()) goto L56;
        int r23 = 1;
    L57:
        d0 r24 = r30.getCurrentBindData();
        if (r24 == null) goto L60;
        r1 = Intrinsics.areEqual(r24.c, Boolean.TRUE);
    L60:
        int r25 = r3 + 1;
        com.larus.bmhome.view.actionbar.edit.c r26 = r30.getViewModel();
        if (r26 == null) goto L63;
        r5 = r26.isCreationActionBar();
    L63:
        String r27 = r30.u6();
        JSONObject r28 = r30.s6();
        tx9.b.f(r10, r13, r15, r17, r110, r111, null, r112, r113, Integer.valueOf(r23), Integer.valueOf(r1), Integer.valueOf(r25), null, null, r28, null, null, null, null, r27, null, r5, 3125312);
        return;
    L56:
        r23 = 0;
        goto L57
    L47:
        r111 = null;
    L43:
        r110 = null;
        goto L44
    L37:
        r17 = null;
        goto L38
    L33:
        r15 = null;
    L29:
        r13 = null;
    L23:
        r10 = null;
        goto L24
    L65:
        return;
    L16:
        r7 = null;
        goto L17
    L10:
        r3 = r31;
        goto L11
    L5:
        if (r0.n != true) goto L7;
        r2 = true;
        goto L8
    }

    public static Unit k6(MusicTemplateListSelectorWidgetV2 r9, bq8.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "template");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        wz9.a r0 = r9.getController();
        if (r0 == null) goto L5;
        r0.m = r10;
    L5:
        com.larus.bmhome.view.actionbar.edit.c r1 = r9.getViewModel();
        if (r1 == null) goto L8;
        r1.onInstructionMusicTemplateSelected(r10);
    L8:
        com.larus.bmhome.view.actionbar.edit.c r2 = r9.getViewModel();
        if (r2 == null) goto L16;
        ChatParam r3 = r2.getChatParam();
        if (r3 == null) goto L16;
        String r4 = r3.b;
        if (r4 == null) goto L16;
        String r6 = r4;
    L17:
        String r5 = String.valueOf(r10.a);
        com.larus.bmhome.view.actionbar.edit.c r12 = r9.getViewModel();
        if (r12 == null) goto L25;
        ChatParam r13 = r12.getChatParam();
        if (r13 == null) goto L25;
        String r14 = r13.e;
        if (r14 == null) goto L25;
        String r7 = r14;
    L26:
        kr8.l.a.b(new b0(r11, r5, "music", r6, r7, 1), null, 3);
        MusicTemplateRepository r15 = MusicTemplateRepository.a;
        MusicTemplateRepository.a(r10.a);
        return Unit.INSTANCE;
    L25:
        r7 = "";
    L16:
        r6 = "";
        goto L17
    }
}
