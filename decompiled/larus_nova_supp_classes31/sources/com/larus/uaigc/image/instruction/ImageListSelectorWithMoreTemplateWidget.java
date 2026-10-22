package com.larus.uaigc.image.instruction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001-\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u001a\u00103\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020'H\u0016J\b\u00107\u001a\u00020'H\u0014J\b\u00109\u001a\u00020'H\u0003J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\u001c\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000RW\u0010\u001d\u001aK\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u000e\u00108\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/uaigc/image/instruction/ImageListSelectorWithMoreTemplateWidget;", "Lcom/larus/uaigc/image/instruction/AbsTemplateListEditorWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "binding", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "bindFragment", "Landroidx/fragment/app/Fragment;", "getBindFragment", "()Landroidx/fragment/app/Fragment;", "controller", "Lcom/larus/uaigc/image/instruction/ImageListSelectorWithMoreTemplateController;", "getController", "()Lcom/larus/uaigc/image/instruction/ImageListSelectorWithMoreTemplateController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarImageTemplateInstructionTemplateV2;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarImageTemplateInstructionTemplateV2;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderV2Binding;", "showCover", "", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "itemClickCallback", "com/larus/uaigc/image/instruction/ImageListSelectorWithMoreTemplateWidget$itemClickCallback$1", "Lcom/larus/uaigc/image/instruction/ImageListSelectorWithMoreTemplateWidget$itemClickCallback$1;", "templateListView", "Landroidx/recyclerview/widget/RecyclerView;", "getTemplateListView", "()Landroidx/recyclerview/widget/RecyclerView;", "init", "attrs", "Landroid/util/AttributeSet;", "onBindView", "onDetachedFromWindow", "collectStarted", "bindObservers", "requestTemplateList", "goToImageTemplateList", "selectImageTemplateInternal", "item", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageListSelectorWithMoreTemplateWidget extends AbsTemplateListEditorWidget {
    public static final /* synthetic */ int o = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding h;
    public ImageSelectorWithMoreWidgetAdapter i;
    public LarusItemActionbarImageTemplateCoverHolderV2Binding j;
    public boolean k;
    public final g l;
    public final a m;
    public boolean n;

    public static final class a implements vz9.d {
        public final /* synthetic */ ImageListSelectorWithMoreTemplateWidget a;

        @Override // vz9.d
        public final void b(w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public a(ImageListSelectorWithMoreTemplateWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11, types: [int] */
        /* JADX WARN: Type inference failed for: r4v24 */
        @Override // vz9.d
        public final void a(w r54, int r55) {
            Intrinsics.checkNotNullParameter(r54, "item");
            ArrayList r2 = new ArrayList();
            n r3 = ImageListSelectorWithMoreTemplateWidget.o6(this.a);
            Object r6 = null;
            if (r3 == null) goto L87;
            List r4 = r3.a;
            if (r4 == null) goto L87;
            ImageListSelectorWithMoreTemplateWidget r8 = this.a;
            Iterator r5 = r4.iterator();
            int r9 = 0;
        L8:
            if (r5.hasNext() == false) goto L87;
            Object r10 = r5.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            w r12 = (w) r10;
            if (Intrinsics.areEqual(r12.a, r54.a) == false) goto L85;
            n r13 = ImageListSelectorWithMoreTemplateWidget.o6(r8);
            if (r13 == null) goto L17;
            boolean r14 = Intrinsics.areEqual(r13.c, Boolean.FALSE);
        L18:
            if (r14 == false) goto L25;
            Integer r15 = r12.s;
            if (r15 == null) goto L25;
            if (r15.intValue() != 1) goto L25;
            r12.s = 0;
        L27:
            if (r8.k == false) goto L29;
            r9 = r9 - 1;
            int r16 = r55 - 1;
        L30:
            com.larus.bmhome.view.actionbar.edit.c r17 = r8.getViewModel();
            if (r17 == null) goto L35;
            ChatParam r18 = r17.getChatParam();
            if (r18 == null) goto L35;
            String r19 = r18.b;
        L36:
            com.larus.bmhome.view.actionbar.edit.c r110 = r8.getViewModel();
            if (r110 == null) goto L41;
            ChatParam r111 = r110.getChatParam();
            if (r111 == null) goto L41;
            String r112 = r111.e;
        L42:
            com.larus.bmhome.view.actionbar.edit.c r113 = r8.getViewModel();
            if (r113 == null) goto L45;
            String r114 = r113.getTemplateType();
        L46:
            com.larus.bmhome.view.actionbar.edit.c r115 = r8.getViewModel();
            if (r115 == null) goto L49;
            String r116 = r115.getActionBarType();
        L50:
            com.larus.bmhome.view.actionbar.edit.c r117 = r8.getViewModel();
            if (r117 == null) goto L55;
            z0 r118 = r117.getCurrentCustomActionBarItem();
            if (r118 == null) goto L55;
            String r119 = r118.b;
        L56:
            u r120 = r8.getInstructionItem();
            if (r120 == null) goto L59;
            String r121 = r120.c;
        L60:
            String r122 = r54.b;
            String r22 = String.valueOf(r54.a);
            n r7 = ImageListSelectorWithMoreTemplateWidget.o6(r8);
            if (r7 == null) goto L68;
            Integer r20 = r7.b;
            if (r20 == null) goto L68;
            if (r9 != r20.intValue()) goto L68;
            int r21 = 1;
        L69:
            Integer r23 = Integer.valueOf(r21);
            n r24 = ImageListSelectorWithMoreTemplateWidget.o6(r8);
            if (r24 == null) goto L72;
            ?? r25 = Intrinsics.areEqual(r24.c, Boolean.TRUE);
        L73:
            Integer r26 = Integer.valueOf(r25);
            Integer r27 = Integer.valueOf(r16 + 1);
            Integer r28 = r12.s;
            if (r28 != null) goto L77;
        L79:
            String r29 = "cancel";
        L80:
            String r210 = r29;
            com.larus.bmhome.view.actionbar.edit.c r30 = r8.getViewModel();
            if (r30 == null) goto L83;
            Boolean r38 = r30.isCreationActionBar();
        L84:
            tx9.b.e(r19, r112, r114, r116, r119, r121, null, r122, r22, r23, r26, r27, r210, null, null, null, null, "original", null, null, null, null, null, null, r38, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
        L86:
            r2.add(r12);
            r9 = r11;
            goto L8
        L83:
            r38 = null;
            goto L84
        L77:
            if (r28.intValue() != 1) goto L79;
            r29 = "select";
            goto L80
        L72:
            r25 = 0;
        L68:
            r21 = 0;
            goto L69
        L59:
            r121 = null;
        L55:
            r119 = null;
            goto L56
        L49:
            r116 = null;
            goto L50
        L45:
            r114 = null;
        L41:
            r112 = null;
        L35:
            r19 = null;
            goto L36
        L29:
            r16 = r55;
        L25:
            r12.s = 1;
            goto L27
        L17:
            r14 = false;
            goto L18
        L85:
            r12.s = 0;
        L87:
            ImageSelectorWithMoreWidgetAdapter r1 = this.a.i;
            if (r1 == null) goto L90;
            Lazy<JSONObject> r31 = ImageSelectorWithMoreWidgetAdapter.e;
            r1.y2(r2, true);
        L90:
            com.larus.bmhome.view.actionbar.edit.c r32 = this.a.getViewModel();
            if (r32 == null) goto L93;
            r32.setCurImageList(r2);
        L93:
            n r33 = ImageListSelectorWithMoreTemplateWidget.o6(this.a);
            if (r33 == null) goto L110;
            List r34 = r33.a;
            if (r34 == null) goto L110;
            Iterator r35 = r34.iterator();
        L99:
            if (r35.hasNext() == false) goto L109;
            Object r36 = r35.next();
            Integer r37 = ((w) r36).s;
            if (r37 != null) goto L104;
        L106:
            boolean r39 = false;
        L107:
            if (r39 == false) goto L99;
            r6 = r36;
            goto L109
        L104:
            if (r37.intValue() != 1) goto L106;
            r39 = true;
        L109:
            r6 = (w) r6;
        L110:
            u r40 = this.a.getInstructionItem();
            if (r40 == null) goto L118;
            Integer r41 = r40.a;
            if (r41 == null) goto L118;
            if (r41.intValue() != 1) goto L118;
            boolean r42 = true;
        L119:
            if (r42 == false) goto L135;
            com.larus.bmhome.view.actionbar.edit.c r43 = this.a.getViewModel();
            if (r43 == null) goto L136;
            if (r6 == null) goto L124;
            boolean r44 = true;
        L125:
            r43.setImageStyleRadioSelected(r44);
            return;
        L124:
            r44 = false;
            goto L125
        L136:
            return;
        L135:
            return;
        L118:
            r42 = false;
            goto L119
        }
    }

    public final void Y5() {
        List r1 = null;
        if (this.n == true) goto L17;
        this.n = true;
        CoroutineScope r3 = getComponentScope();
        if (r3 == null) goto L8;
        BuildersKt.launch$default(r3, null, null, new ImageListSelectorWithMoreTemplateWidget$bindObservers$1(this, null), 3, null);
    L8:
        CoroutineScope r9 = getComponentScope();
        if (r9 == null) goto L11;
        BuildersKt.launch$default(r9, null, null, new ImageListSelectorWithMoreTemplateWidget$bindObservers$2(this, null), 3, null);
    L11:
        CoroutineScope r4 = getComponentScope();
        if (r4 == null) goto L14;
        BuildersKt.launch$default(r4, null, null, new ImageListSelectorWithMoreTemplateWidget$bindObservers$3(this, null), 3, null);
    L14:
        CoroutineScope r10 = getComponentScope();
        if (r10 == null) goto L17;
        BuildersKt.launch$default(r10, null, null, new ImageListSelectorWithMoreTemplateWidget$bindObservers$4(this, null), 3, null);
    L17:
        u r0 = getInstructionItem();
        if (r0 == null) goto L20;
        boolean r2 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L21:
        if (r2 == false) goto L23;
        e1.x(getBinding().b);
    L23:
        u r5 = getInstructionItem();
        if (r5 == null) goto L26;
        String r6 = r5.c;
    L28:
        if (o0.d(r6) == false) goto L34;
        TextView r7 = getBinding().e;
        u r8 = getInstructionItem();
        if (r8 == null) goto L32;
        String r11 = r8.c;
    L33:
        r7.setText(r11);
        e1.x(getBinding().e);
        goto L34
    L32:
        r11 = null;
    L34:
        n r12 = getCurrentBindData();
        if (r12 == null) goto L43;
        List r13 = r12.d;
        if (r13 == null) goto L43;
        w r14 = (w) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L43;
        if (r14.j != true) goto L43;
        boolean r15 = true;
    L44:
        this.k = r15;
        if (r15 == false) goto L47;
        this.i = new ImageSelectorWithMoreWidgetAdapter(this.m, new d(this));
    L48:
        y6.d(getBinding().c, new e(this), null, null, new f(this), 13);
        getBinding().c.setAdapter(this.i);
        getBinding().c.addItemDecoration(new ImageListSelectorWithMoreTemplateWidget$onBindView$4());
        n r16 = getCurrentBindData();
        int r17 = -1;
        if (r16 == null) goto L53;
        Integer r18 = r16.b;
        if (r18 == null) goto L53;
        int r19 = r18.intValue();
    L54:
        n r20 = getCurrentBindData();
        if (r20 == null) goto L70;
        List r21 = r20.a;
        if (r21 == null) goto L70;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L60:
        if (r23.hasNext() == false) goto L71;
        Object r24 = r23.next();
        Integer r25 = ((w) r24).s;
        if (r25 != null) goto L65;
    L67:
        boolean r26 = false;
    L68:
        if (r26 == false) goto L60;
        r22.add(r24);
        goto L60
    L65:
        if (r25.intValue() != 1) goto L67;
        r26 = true;
    L71:
        if (r22 != null) goto L73;
    L76:
        boolean r27 = true;
    L77:
        if (r27 == true) goto L101;
        n r28 = getCurrentBindData();
        if (r28 == null) goto L133;
        List r29 = r28.a;
        if (r29 == null) goto L133;
        Iterator r30 = r29.iterator();
        int r31 = 0;
    L84:
        if (r30.hasNext() == false) goto L96;
        Integer r32 = ((w) r30.next()).s;
        if (r32 != null) goto L89;
    L91:
        boolean r33 = false;
    L92:
        if (r33 == true) goto L93;
        r31 = r31 + 1;
        goto L84
    L93:
        r17 = r31;
        goto L96
    L89:
        if (r32.intValue() != 1) goto L91;
        r33 = true;
    L96:
        if (this.k == false) goto L98;
        r17 = r17 + 1;
    L98:
        this.f = Integer.valueOf(r17);
        com.larus.bmhome.view.actionbar.edit.c r34 = getViewModel();
        if (r34 == null) goto L133;
        r34.setImageStyleRadioSelected(true);
    L133:
        ImageSelectorWithMoreWidgetAdapter r35 = this.i;
        if (r35 == null) goto L142;
        n r36 = getCurrentBindData();
        if (r36 == null) goto L138;
        List<w> r37 = r36.a;
    L139:
        if (r37 != null) goto L141;
        r37 = CollectionsKt.emptyList();
    L141:
        Lazy<JSONObject> r38 = ImageSelectorWithMoreWidgetAdapter.e;
        r35.y2(r37, true);
        goto L142
    L138:
        r37 = null;
    L142:
        com.larus.bmhome.view.actionbar.edit.c r39 = getViewModel();
        if (r39 == null) goto L158;
        n r40 = getCurrentBindData();
        if (r40 == null) goto L147;
        r1 = r40.a;
    L147:
        r39.setCurImageList(r1);
        return;
    L158:
        return;
    L101:
        if (r19 < 0) goto L133;
        n r41 = getCurrentBindData();
        if (r41 == null) goto L107;
        List r42 = r41.a;
        if (r42 == null) goto L107;
        w r43 = (w) CollectionsKt.getOrNull(r42, r19);
    L108:
        if (r43 == null) goto L110;
        r43.s = 1;
    L110:
        n r44 = getCurrentBindData();
        if (r44 == null) goto L133;
        List r45 = r44.a;
        if (r45 == null) goto L133;
        Iterator r46 = r45.iterator();
        int r47 = 0;
    L116:
        if (r46.hasNext() == false) goto L128;
        Integer r48 = ((w) r46.next()).s;
        if (r48 != null) goto L121;
    L123:
        boolean r49 = false;
    L124:
        if (r49 == true) goto L125;
        r47 = r47 + 1;
        goto L116
    L125:
        r17 = r47;
        goto L128
    L121:
        if (r48.intValue() != 1) goto L123;
        r49 = true;
    L128:
        if (this.k == false) goto L130;
        r17 = r17 + 1;
    L130:
        this.f = Integer.valueOf(r17);
        com.larus.bmhome.view.actionbar.edit.c r50 = getViewModel();
        if (r50 == null) goto L133;
        r50.setImageStyleRadioSelected(true);
    L107:
        r43 = null;
        goto L108
    L73:
        if (r22.isEmpty() == true) goto L76;
        r27 = false;
    L70:
        r22 = null;
    L53:
        r19 = -1;
        goto L54
    L47:
        this.i = new ImageSelectorWithMoreWidgetAdapter(this.m, null);
    L43:
        r15 = false;
        goto L44
    L26:
        r6 = null;
        goto L28
    L20:
        r2 = false;
        goto L21
    }

    public final LarusLayoutActionBarEditorWidgetImageSelectorV2Binding getBinding() {
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final Fragment getBindFragment() {
        return getFragment();
    }

    private final c getController() {
        return (c) getController();
    }

    private final n getCurrentBindData() {
        c r0 = getController();
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
        Fragment r2 = getBindFragment();
        if (r2 == null) goto L7;
        Lifecycle r3 = r2.getLifecycle();
        if (r3 == null) goto L7;
        Lifecycle.State r4 = r3.getCurrentState();
    L8:
        r1.append(r4);
        r0.i("ImageListSelectorWithMoreTemplateWidget", r1.toString());
        return;
    L7:
        r4 = null;
        goto L8
    }

    public ImageListSelectorWithMoreTemplateWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.l = new g(this);
        this.m = new a(this);
    }

    public static final /* synthetic */ c n6(ImageListSelectorWithMoreTemplateWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ n o6(ImageListSelectorWithMoreTemplateWidget r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.h = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r1), this);
    }

    public static Unit i6(ImageListSelectorWithMoreTemplateWidget r10, TemplateInfo$TemplateInfo r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r11, "templateInfo");
        c r0 = r10.getController();
        String r1 = null;
        if (r0 == null) goto L5;
        r0.m = null;
    L5:
        n r2 = r10.getCurrentBindData();
        if (r2 == null) goto L22;
        List r3 = r2.a;
        if (r3 == null) goto L22;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        Long r6 = ((w) r5).a;
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L11;
    L21:
        w r8 = (w) r5;
    L23:
        if (r8 == null) goto L40;
        n r9 = r10.getCurrentBindData();
        if (r9 == null) goto L43;
        List r13 = r9.a;
        if (r13 == null) goto L43;
        Iterator r14 = r13.iterator();
    L30:
        if (r14.hasNext() == false) goto L43;
        w r15 = (w) r14.next();
        Long r16 = r15.a;
        if (r16 != null) goto L34;
    L36:
        boolean r17 = false;
    L37:
        if (r17 == true) goto L38;
        r15.s = 0;
        goto L30
    L38:
        r15.s = 1;
        goto L30
    L34:
        if (r16.longValue() != r11.a) goto L36;
        r17 = true;
    L43:
        Fragment r18 = r10.getFragment();
        if (r18 == null) goto L69;
        Bundle r19 = r18.getArguments();
        if (r19 == null) goto L69;
        UserCreation r20 = r11.j;
        Pair[] r21 = new Pair[6];
        if (r20 == null) goto L50;
        String r22 = r20.a;
    L51:
        r21[0] = TuplesKt.to("from_template_id", r22);
        if (r20 == null) goto L54;
        String r23 = zp9.d.d(r20);
    L55:
        r21[1] = TuplesKt.to("from_template_type", r23);
        if (r20 == null) goto L60;
        UserCreationTrackParams r24 = r20.n;
        if (r24 == null) goto L60;
        String r25 = r24.a;
    L61:
        r21[2] = TuplesKt.to("template_rec_req_id", r25);
        if (r20 == null) goto L64;
        String r26 = zp9.d.b(r20);
    L65:
        r21[3] = TuplesKt.to("from_template_source", r26);
        r21[4] = TuplesKt.to("is_from_template", "1");
        if (r20 == null) goto L68;
        r1 = r20.i;
    L68:
        r21[5] = TuplesKt.to("template_rec_extra", r1);
        r19.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r21)));
        goto L69
    L64:
        r26 = null;
    L60:
        r25 = null;
        goto L61
    L54:
        r23 = null;
        goto L55
    L50:
        r22 = null;
    L69:
        c r27 = r10.getController();
        if (r27 == null) goto L72;
        r27.m = r11;
    L72:
        com.larus.bmhome.view.actionbar.edit.c r110 = r10.getViewModel();
        if (r110 == null) goto L76;
        r110.onInstructionImageTemplateSelected(r11, r12);
    L76:
        return Unit.INSTANCE;
    L40:
        c r28 = r10.getController();
        if (r28 == null) goto L43;
        r28.m = r11;
        goto L43
    L15:
        if (r6.longValue() != r11.a) goto L17;
        r7 = true;
        goto L18
    L20:
        r5 = null;
    L22:
        r8 = null;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    public static void k6(ImageListSelectorWithMoreTemplateWidget r28, int r29, RecyclerView.ViewHolder r30) {
        Intrinsics.checkNotNullParameter(r30, "<unused var>");
        if (r28.k == false) goto L5;
        int r1 = r29 - 1;
    L6:
        ImageSelectorWithMoreWidgetAdapter r2 = r28.i;
        Boolean r3 = null;
        if (r2 == null) goto L11;
        List<w> r4 = r2.d;
        if (r4 == null) goto L11;
        w r5 = (w) CollectionsKt.getOrNull(r4, r1);
    L12:
        if (r5 == null) goto L60;
        com.larus.bmhome.view.actionbar.edit.c r6 = r28.getViewModel();
        if (r6 == null) goto L18;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L18;
        String r8 = r7.b;
    L19:
        com.larus.bmhome.view.actionbar.edit.c r9 = r28.getViewModel();
        if (r9 == null) goto L24;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L24;
        String r11 = r10.e;
    L25:
        com.larus.bmhome.view.actionbar.edit.c r12 = r28.getViewModel();
        if (r12 == null) goto L28;
        String r13 = r12.getTemplateType();
    L29:
        com.larus.bmhome.view.actionbar.edit.c r14 = r28.getViewModel();
        if (r14 == null) goto L32;
        String r15 = r14.getActionBarType();
    L33:
        com.larus.bmhome.view.actionbar.edit.c r16 = r28.getViewModel();
        if (r16 == null) goto L38;
        z0 r17 = r16.getCurrentCustomActionBarItem();
        if (r17 == null) goto L38;
        String r18 = r17.b;
    L39:
        u r19 = r28.getInstructionItem();
        if (r19 == null) goto L42;
        String r110 = r19.c;
    L43:
        String r111 = r5.b;
        String r112 = String.valueOf(r5.a);
        n r20 = r28.getCurrentBindData();
        ?? r21 = 0;
        if (r20 == null) goto L51;
        Integer r22 = r20.b;
        if (r22 == null) goto L51;
        if (r1 != r22.intValue()) goto L51;
        int r23 = 1;
    L52:
        Integer r24 = Integer.valueOf(r23);
        n r113 = r28.getCurrentBindData();
        if (r113 == null) goto L55;
        r21 = Intrinsics.areEqual(r113.c, Boolean.TRUE);
    L55:
        Integer r114 = Integer.valueOf(r21);
        Integer r115 = Integer.valueOf(r1 + 1);
        com.larus.bmhome.view.actionbar.edit.c r0 = r28.getViewModel();
        if (r0 == null) goto L58;
        r3 = r0.isCreationActionBar();
    L58:
        tx9.b.f(r8, r11, r13, r15, r18, r110, null, r111, r112, r24, r114, r115, null, null, null, null, null, null, null, null, null, r3, 4190272);
        return;
    L51:
        r23 = 0;
        goto L52
    L42:
        r110 = null;
    L38:
        r18 = null;
        goto L39
    L32:
        r15 = null;
        goto L33
    L28:
        r13 = null;
    L24:
        r11 = null;
    L18:
        r8 = null;
        goto L19
    L60:
        return;
    L11:
        r5 = null;
        goto L12
    L5:
        r1 = r29;
        goto L6
    }
}
