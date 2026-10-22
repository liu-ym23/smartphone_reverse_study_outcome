package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTranslatorV3Binding;
import com.larus.platform.service.AccountService;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003036\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u00108\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\u0012\u0010?\u001a\u0002092\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010B\u001a\u0002092\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010C\u001a\u0002092\b\u0010@\u001a\u0004\u0018\u00010AH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R#\u0010&\u001a\n \u0011*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0004\n\u0002\u00107¨\u0006E"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV3Binding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV3Binding;", "sourceLanguageBalloon", "Lcom/skydoves/balloon/Balloon;", "sourceLanguagePopupView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "sourceLanguageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sourceLanguageItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "targetLanguageBalloon", "targetLanguagePopupView", "targetLanguageRecyclerView", "targetLanguageItemAdapter", "modeBalloon", "modePopupView", "modeRecyclerView", "modeItemAdapter", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/TranslatorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/TranslatorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "cache", "Lcom/bytedance/keva/Keva;", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "targetOptionIdDefaultValue", "", "speakerModeDefaultValue", "sourceLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$sourceLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$sourceLanguageSelectedCallback$1;", "targetLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$targetLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$targetLanguageSelectedCallback$1;", "modeSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$modeSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV3$modeSelectedCallback$1;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "restoreTargetLanguageOptionId", "restoreTranslatorMode", "initModeSelector", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "initSourceLanguageSelector", "initTargetLanguageSelector", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslatorWidgetV3 extends AbsInstructionWidget {
    public static final String y = null;
    public static final String z = null;
    public LarusLayoutActionBarEditorWidgetTranslatorV3Binding f;
    public Balloon g;
    public final View h;
    public final RecyclerView i;
    public DropdownItemAdapter j;
    public Balloon k;
    public final View l;
    public final RecyclerView m;
    public DropdownItemAdapter n;
    public Balloon o;
    public final View p;
    public final RecyclerView q;
    public DropdownItemAdapter r;
    public final Lazy s;
    public final long t;
    public final String u;
    public final c v;
    public final d w;
    public final b x;

    public static final class a {
    }

    public static final class b implements b1 {
        public final /* synthetic */ TranslatorWidgetV3 a;

        public b(TranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r51, com.larus.bmhome.actionbar.model.w r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "selectedSpinnerItem");
            Balloon r2 = this.a.o;
            if (r2 == null) goto L5;
            r2.h();
        L5:
            this.a.getBinding().e.d.setText(r52.b());
            com.larus.bmhome.actionbar.model.l0 r3 = TranslatorWidgetV3.k6(this.a);
            List r4 = null;
            if (r3 == null) goto L84;
            com.larus.bmhome.actionbar.model.h r5 = r3.c;
            if (r5 == null) goto L84;
            List r6 = r5.e;
            if (r6 == null) goto L84;
            TranslatorWidgetV3 r7 = this.a;
            Iterator r8 = r6.iterator();
            int r9 = 0;
        L13:
            if (r8.hasNext() == false) goto L84;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r10;
            if (Intrinsics.areEqual(r12.a, r52.a) == false) goto L82;
            r12.s = 1;
            Keva r13 = TranslatorWidgetV3.i6(r7);
            String r14 = TranslatorWidgetV3.z;
            Map r15 = r12.q;
            if (r15 == null) goto L23;
            String r16 = (String) r15.get("speaker_mode");
            if (r16 == null) goto L23;
        L24:
            r13.storeString(r14, r16);
            com.larus.bmhome.view.actionbar.edit.c r17 = r7.getViewModel();
            if (r17 == null) goto L29;
            ChatParam r18 = r17.getChatParam();
            if (r18 == null) goto L29;
            String r19 = r18.b;
        L30:
            com.larus.bmhome.view.actionbar.edit.c r110 = r7.getViewModel();
            if (r110 == null) goto L35;
            ChatParam r111 = r110.getChatParam();
            if (r111 == null) goto L35;
            String r112 = r111.e;
        L36:
            com.larus.bmhome.view.actionbar.edit.c r113 = r7.getViewModel();
            if (r113 == null) goto L39;
            String r114 = r113.getTemplateType();
        L40:
            com.larus.bmhome.view.actionbar.edit.c r115 = r7.getViewModel();
            if (r115 == null) goto L43;
            String r116 = r115.getActionBarType();
        L44:
            com.larus.bmhome.view.actionbar.edit.c r117 = r7.getViewModel();
            if (r117 == null) goto L49;
            com.larus.bmhome.actionbar.model.z0 r118 = r117.getCurrentCustomActionBarItem();
            if (r118 == null) goto L49;
            String r119 = r118.b;
        L50:
            com.larus.bmhome.actionbar.model.u r120 = r7.getInstructionItem();
            if (r120 == null) goto L53;
            String r121 = r120.c;
        L54:
            com.larus.bmhome.actionbar.model.l0 r122 = TranslatorWidgetV3.k6(r7);
            if (r122 == null) goto L59;
            com.larus.bmhome.actionbar.model.h r123 = r122.b;
            if (r123 == null) goto L59;
            String r124 = r123.c;
        L60:
            String r125 = r12.b;
            String r126 = String.valueOf(r12.a);
            com.larus.bmhome.actionbar.model.l0 r20 = TranslatorWidgetV3.k6(r7);
            if (r20 == null) goto L70;
            com.larus.bmhome.actionbar.model.h r21 = r20.c;
            if (r21 == null) goto L70;
            Integer r22 = r21.f;
            if (r22 == null) goto L70;
            if (r22.intValue() != r9) goto L70;
            int r23 = 1;
        L71:
            Integer r24 = Integer.valueOf(r23);
            com.larus.bmhome.actionbar.model.l0 r25 = TranslatorWidgetV3.k6(r7);
            if (r25 == null) goto L76;
            com.larus.bmhome.actionbar.model.h r26 = r25.c;
            if (r26 == null) goto L76;
            boolean r27 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
        L77:
            Integer r28 = Integer.valueOf(!r27);
            Integer r29 = Integer.valueOf(r53 + 1);
            com.larus.bmhome.view.actionbar.edit.c r30 = r7.getViewModel();
            if (r30 == null) goto L80;
            Boolean r35 = r30.isCreationActionBar();
        L81:
            tx9.b.e(r19, r112, r114, r116, r119, r121, r124, r125, r126, r24, r28, r29, "select", null, null, null, null, "original", null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -33824768, 127);
        L83:
            r9 = r11;
            goto L13
        L80:
            r35 = null;
        L76:
            r27 = 0;
        L70:
            r23 = 0;
        L59:
            r124 = null;
            goto L60
        L53:
            r121 = null;
        L49:
            r119 = null;
            goto L50
        L43:
            r116 = null;
            goto L44
        L39:
            r114 = null;
        L35:
            r112 = null;
        L29:
            r19 = null;
        L23:
            r16 = r7.u;
            goto L24
        L82:
            r12.s = 0;
        L84:
            com.larus.bmhome.actionbar.model.l0 r1 = TranslatorWidgetV3.k6(this.a);
            if (r1 == null) goto L89;
            com.larus.bmhome.actionbar.model.h r31 = r1.c;
            if (r31 == null) goto L89;
            com.larus.bmhome.actionbar.model.h r32 = com.larus.bmhome.actionbar.model.h.a(r31, null, null, null, null, null, null, 4095);
        L90:
            DropdownItemAdapter r33 = this.a.r;
            if (r33 == null) goto L99;
            if (r32 == null) goto L94;
            r4 = r32.e;
        L94:
            r33.submitList(r4);
            return;
        L99:
            return;
        L89:
            r32 = null;
            goto L90
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public static final class c implements b1 {
        public final /* synthetic */ TranslatorWidgetV3 a;

        public c(TranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r51, com.larus.bmhome.actionbar.model.w r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "selectedSpinnerItem");
            Balloon r2 = this.a.g;
            if (r2 == null) goto L5;
            r2.h();
        L5:
            this.a.getBinding().c.d.setText(r52.b());
            com.larus.bmhome.actionbar.model.l0 r3 = TranslatorWidgetV3.k6(this.a);
            List r4 = null;
            if (r3 == null) goto L79;
            com.larus.bmhome.actionbar.model.h r5 = r3.a;
            if (r5 == null) goto L79;
            List r6 = r5.e;
            if (r6 == null) goto L79;
            TranslatorWidgetV3 r7 = this.a;
            Iterator r8 = r6.iterator();
            int r9 = 0;
        L13:
            if (r8.hasNext() == false) goto L79;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r10;
            if (Intrinsics.areEqual(r12.a, r52.a) == false) goto L77;
            r12.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r13 = r7.getViewModel();
            if (r13 == null) goto L24;
            ChatParam r14 = r13.getChatParam();
            if (r14 == null) goto L24;
            String r15 = r14.b;
        L25:
            com.larus.bmhome.view.actionbar.edit.c r16 = r7.getViewModel();
            if (r16 == null) goto L30;
            ChatParam r17 = r16.getChatParam();
            if (r17 == null) goto L30;
            String r18 = r17.e;
        L31:
            com.larus.bmhome.view.actionbar.edit.c r19 = r7.getViewModel();
            if (r19 == null) goto L34;
            String r110 = r19.getTemplateType();
        L35:
            com.larus.bmhome.view.actionbar.edit.c r111 = r7.getViewModel();
            if (r111 == null) goto L38;
            String r112 = r111.getActionBarType();
        L39:
            com.larus.bmhome.view.actionbar.edit.c r113 = r7.getViewModel();
            if (r113 == null) goto L44;
            com.larus.bmhome.actionbar.model.z0 r114 = r113.getCurrentCustomActionBarItem();
            if (r114 == null) goto L44;
            String r115 = r114.b;
        L45:
            com.larus.bmhome.actionbar.model.u r116 = r7.getInstructionItem();
            if (r116 == null) goto L48;
            String r117 = r116.c;
        L49:
            com.larus.bmhome.actionbar.model.l0 r118 = TranslatorWidgetV3.k6(r7);
            if (r118 == null) goto L54;
            com.larus.bmhome.actionbar.model.h r119 = r118.a;
            if (r119 == null) goto L54;
            String r120 = r119.c;
        L55:
            String r121 = r12.b;
            String r122 = String.valueOf(r12.a);
            com.larus.bmhome.actionbar.model.l0 r20 = TranslatorWidgetV3.k6(r7);
            if (r20 == null) goto L65;
            com.larus.bmhome.actionbar.model.h r21 = r20.a;
            if (r21 == null) goto L65;
            Integer r22 = r21.f;
            if (r22 == null) goto L65;
            if (r22.intValue() != r9) goto L65;
            int r23 = 1;
        L66:
            Integer r24 = Integer.valueOf(r23);
            com.larus.bmhome.actionbar.model.l0 r25 = TranslatorWidgetV3.k6(r7);
            if (r25 == null) goto L71;
            com.larus.bmhome.actionbar.model.h r26 = r25.a;
            if (r26 == null) goto L71;
            boolean r27 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
        L72:
            Integer r28 = Integer.valueOf(!r27);
            Integer r29 = Integer.valueOf(r53 + 1);
            com.larus.bmhome.view.actionbar.edit.c r30 = r7.getViewModel();
            if (r30 == null) goto L75;
            Boolean r35 = r30.isCreationActionBar();
        L76:
            tx9.b.e(r15, r18, r110, r112, r115, r117, r120, r121, r122, r24, r28, r29, "select", null, null, null, null, "original", null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -33824768, 127);
        L78:
            r9 = r11;
            goto L13
        L75:
            r35 = null;
        L71:
            r27 = 0;
        L65:
            r23 = 0;
        L54:
            r120 = null;
            goto L55
        L48:
            r117 = null;
        L44:
            r115 = null;
            goto L45
        L38:
            r112 = null;
            goto L39
        L34:
            r110 = null;
        L30:
            r18 = null;
        L24:
            r15 = null;
            goto L25
        L77:
            r12.s = 0;
        L79:
            com.larus.bmhome.actionbar.model.l0 r1 = TranslatorWidgetV3.k6(this.a);
            if (r1 == null) goto L84;
            com.larus.bmhome.actionbar.model.h r31 = r1.a;
            if (r31 == null) goto L84;
            com.larus.bmhome.actionbar.model.h r32 = com.larus.bmhome.actionbar.model.h.a(r31, null, null, null, null, null, null, 4095);
        L85:
            DropdownItemAdapter r33 = this.a.j;
            if (r33 == null) goto L94;
            if (r32 == null) goto L89;
            r4 = r32.e;
        L89:
            r33.submitList(r4);
            return;
        L94:
            return;
        L84:
            r32 = null;
            goto L85
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public static final class d implements b1 {
        public final /* synthetic */ TranslatorWidgetV3 a;

        public d(TranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r51, com.larus.bmhome.actionbar.model.w r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "selectedSpinnerItem");
            Balloon r2 = this.a.k;
            if (r2 == null) goto L5;
            r2.h();
        L5:
            this.a.getBinding().d.d.setText(r52.b());
            com.larus.bmhome.actionbar.model.l0 r3 = TranslatorWidgetV3.k6(this.a);
            if (r3 == null) goto L83;
            com.larus.bmhome.actionbar.model.h r4 = r3.b;
            if (r4 == null) goto L83;
            List r5 = r4.e;
            if (r5 == null) goto L83;
            TranslatorWidgetV3 r6 = this.a;
            Iterator r7 = r5.iterator();
            int r8 = 0;
        L13:
            if (r7.hasNext() == false) goto L83;
            Object r9 = r7.next();
            int r10 = r8 + 1;
            if (r8 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r11 = (com.larus.bmhome.actionbar.model.w) r9;
            if (Intrinsics.areEqual(r11.a, r52.a) == false) goto L81;
            r11.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r12 = r6.getViewModel();
            if (r12 == null) goto L24;
            ChatParam r13 = r12.getChatParam();
            if (r13 == null) goto L24;
            String r14 = r13.b;
        L25:
            com.larus.bmhome.view.actionbar.edit.c r15 = r6.getViewModel();
            if (r15 == null) goto L30;
            ChatParam r16 = r15.getChatParam();
            if (r16 == null) goto L30;
            String r17 = r16.e;
        L31:
            com.larus.bmhome.view.actionbar.edit.c r18 = r6.getViewModel();
            if (r18 == null) goto L34;
            String r19 = r18.getTemplateType();
        L35:
            com.larus.bmhome.view.actionbar.edit.c r110 = r6.getViewModel();
            if (r110 == null) goto L38;
            String r111 = r110.getActionBarType();
        L39:
            com.larus.bmhome.view.actionbar.edit.c r112 = r6.getViewModel();
            if (r112 == null) goto L44;
            com.larus.bmhome.actionbar.model.z0 r113 = r112.getCurrentCustomActionBarItem();
            if (r113 == null) goto L44;
            String r114 = r113.b;
        L45:
            com.larus.bmhome.actionbar.model.u r115 = r6.getInstructionItem();
            if (r115 == null) goto L48;
            String r116 = r115.c;
        L49:
            com.larus.bmhome.actionbar.model.l0 r117 = TranslatorWidgetV3.k6(r6);
            if (r117 == null) goto L54;
            com.larus.bmhome.actionbar.model.h r118 = r117.b;
            if (r118 == null) goto L54;
            String r119 = r118.c;
        L55:
            String r120 = r11.b;
            String r121 = String.valueOf(r11.a);
            com.larus.bmhome.actionbar.model.l0 r20 = TranslatorWidgetV3.k6(r6);
            if (r20 == null) goto L65;
            com.larus.bmhome.actionbar.model.h r21 = r20.b;
            if (r21 == null) goto L65;
            Integer r22 = r21.f;
            if (r22 == null) goto L65;
            if (r22.intValue() != r8) goto L65;
            int r23 = 1;
        L66:
            Integer r24 = Integer.valueOf(r23);
            com.larus.bmhome.actionbar.model.l0 r25 = TranslatorWidgetV3.k6(r6);
            if (r25 == null) goto L71;
            com.larus.bmhome.actionbar.model.h r26 = r25.b;
            if (r26 == null) goto L71;
            boolean r27 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
        L72:
            Integer r28 = Integer.valueOf(!r27);
            Integer r29 = Integer.valueOf(r53 + 1);
            com.larus.bmhome.view.actionbar.edit.c r30 = r6.getViewModel();
            if (r30 == null) goto L75;
            Boolean r35 = r30.isCreationActionBar();
        L76:
            tx9.b.e(r14, r17, r19, r111, r114, r116, r119, r120, r121, r24, r28, r29, "select", null, null, null, null, "original", null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -33824768, 127);
            Keva r31 = TranslatorWidgetV3.i6(r6);
            String r32 = TranslatorWidgetV3.y;
            Long r33 = r11.a;
            if (r33 == null) goto L79;
            long r34 = r33.longValue();
        L80:
            r31.storeLong(r32, r34);
        L82:
            r8 = r10;
            goto L13
        L79:
            r34 = r6.t;
            goto L80
        L75:
            r35 = null;
        L71:
            r27 = 0;
        L65:
            r23 = 0;
        L54:
            r119 = null;
            goto L55
        L48:
            r116 = null;
        L44:
            r114 = null;
            goto L45
        L38:
            r111 = null;
            goto L39
        L34:
            r19 = null;
        L30:
            r17 = null;
        L24:
            r14 = null;
            goto L25
        L81:
            r11.s = 0;
        L83:
            com.larus.bmhome.actionbar.model.l0 r1 = TranslatorWidgetV3.k6(this.a);
            if (r1 == null) goto L88;
            com.larus.bmhome.actionbar.model.h r36 = r1.b;
            if (r36 == null) goto L88;
            com.larus.bmhome.actionbar.model.h r37 = com.larus.bmhome.actionbar.model.h.a(r36, null, null, null, null, null, null, 4095);
        L89:
            DropdownItemAdapter r38 = this.a.n;
            if (r38 == null) goto L99;
            if (r37 == null) goto L93;
            List r39 = r37.e;
        L94:
            r38.submitList(r39);
            return;
        L93:
            r39 = null;
            goto L94
        L99:
            return;
        L88:
            r37 = null;
            goto L89
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    static {
        AccountService r0 = AccountService.a;
        y = r0.getUserId().concat("-selected_target_language");
        z = r0.getUserId().concat("-selected_translator_mode");
    }

    private final Keva getCache() {
        return (Keva) this.s.getValue();
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.u r1 = getInstructionItem();
        final int r2 = 0;
        if (r1 == null) goto L5;
        boolean r3 = Intrinsics.areEqual(r1.f, Boolean.TRUE);
    L6:
        if (r3 == false) goto L8;
        com.larus.utils.e1.x(getBinding().b);
    L8:
        com.larus.bmhome.actionbar.model.u r4 = getInstructionItem();
        List r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.c;
    L13:
        if (com.larus.utils.o0.d(r6) == false) goto L19;
        AppCompatTextView r7 = getBinding().f;
        com.larus.bmhome.actionbar.model.u r8 = getInstructionItem();
        if (r8 == null) goto L17;
        String r9 = r8.c;
    L18:
        r7.setText(r9);
        com.larus.utils.e1.x(getBinding().f);
        goto L19
    L17:
        r9 = null;
    L19:
        com.larus.bmhome.view.actionbar.edit.c r10 = getViewModel();
        if (r10 == null) goto L28;
        com.larus.bmhome.actionbar.model.z0 r11 = r10.getCurrentCustomActionBarItem();
        if (r11 == null) goto L28;
        com.larus.bmhome.actionbar.model.m0 r12 = r11.u;
        if (r12 == null) goto L28;
        if (TextUtils.isEmpty(r12.v) == true) goto L28;
        getBinding().f.setText(r12.v);
        com.larus.utils.e1.x(getBinding().f);
    L28:
        long r13 = getCache().getLong(y, this.t);
        if (r13 == this.t) goto L48;
        com.larus.bmhome.actionbar.model.l0 r14 = getCurrentBindData();
        if (r14 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r15 = r14.b;
        if (r15 == null) goto L48;
        List r16 = r15.e;
        if (r16 == null) goto L48;
        Iterator r17 = r16.iterator();
    L39:
        if (r17.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.w r18 = (com.larus.bmhome.actionbar.model.w) r17.next();
        Long r19 = r18.a;
        if (r19 != null) goto L44;
    L46:
        int r20 = 0;
    L47:
        r18.s = r20;
        goto L39
    L44:
        if (r19.longValue() != r13) goto L46;
        r20 = 1;
    L48:
        String r21 = getCache().getString(z, this.u);
        if (Intrinsics.areEqual(r21, this.u) == true) goto L69;
        com.larus.bmhome.actionbar.model.l0 r22 = getCurrentBindData();
        if (r22 == null) goto L69;
        com.larus.bmhome.actionbar.model.h r23 = r22.c;
        if (r23 == null) goto L69;
        List r24 = r23.e;
        if (r24 == null) goto L69;
        Iterator r25 = r24.iterator();
    L59:
        if (r25.hasNext() == false) goto L69;
        com.larus.bmhome.actionbar.model.w r26 = (com.larus.bmhome.actionbar.model.w) r25.next();
        Map r27 = r26.q;
        if (r27 == null) goto L63;
        String r28 = (String) r27.get("speaker_mode");
    L65:
        if (Intrinsics.areEqual(r28, r21) == false) goto L67;
        int r29 = 1;
    L68:
        r26.s = r29;
        goto L59
    L67:
        r29 = 0;
        goto L68
    L63:
        r28 = null;
    L69:
        com.larus.bmhome.actionbar.model.l0 r30 = getCurrentBindData();
        if (r30 == null) goto L72;
        final com.larus.bmhome.actionbar.model.h r31 = r30.a;
    L74:
        if (r31 == null) goto L80;
        List r32 = r31.e;
        if (r32 == null) goto L80;
        if (r32.size() != 1) goto L80;
        boolean r33 = true;
    L82:
        if (r33 == false) goto L84;
        getBinding().c.b.setVisibility(8);
    L84:
        int r34 = -1;
        if (r31 == null) goto L89;
        Integer r110 = r31.f;
        if (r110 == null) goto L89;
        int r111 = r110.intValue();
    L90:
        if (r31 == null) goto L103;
        List r112 = r31.e;
        if (r112 == null) goto L103;
        Iterator r113 = r112.iterator();
    L95:
        if (r113.hasNext() == false) goto L99;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r114).a, r31.g) == false) goto L95;
    L100:
        com.larus.bmhome.actionbar.model.w r115 = (com.larus.bmhome.actionbar.model.w) r114;
        if (r115 == null) goto L103;
        r115.s = 1;
    L104:
        if (r115 != null) goto L113;
        if (r111 < 0) goto L113;
        if (r31 == null) goto L110;
        List r116 = r31.e;
        if (r116 == null) goto L110;
        com.larus.bmhome.actionbar.model.w r117 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r116, r111);
    L111:
        if (r117 == null) goto L113;
        r117.s = 1;
    L110:
        r117 = null;
    L113:
        com.larus.utils.e1.o(getBinding().c.c);
        AppCompatTextView r35 = getBinding().c.d;
        if (r31 == null) goto L133;
        List r118 = r31.e;
        if (r118 == null) goto L133;
        Iterator r119 = r118.iterator();
    L119:
        if (r119.hasNext() == false) goto L129;
        Object r120 = r119.next();
        Integer r121 = ((com.larus.bmhome.actionbar.model.w) r120).s;
        if (r121 != null) goto L124;
    L126:
        boolean r122 = false;
    L127:
        if (r122 == false) goto L119;
    L130:
        com.larus.bmhome.actionbar.model.w r123 = (com.larus.bmhome.actionbar.model.w) r120;
        if (r123 == null) goto L133;
        String r124 = r123.b();
    L134:
        r35.setText(r124);
        if (r31 == null) goto L137;
        Integer r125 = r31.b;
    L138:
        this.j = new DropdownItemAdapter(r125, this.v, null);
        y6.d(this.i, null, null, null, new e3(this, r31), 15);
        DropdownItemAdapter r36 = this.j;
        if (r36 == null) goto L144;
        if (r31 == null) goto L142;
        List r126 = r31.e;
    L143:
        r36.submitList(r126);
        goto L144
    L142:
        r126 = null;
    L144:
        if (r31 == null) goto L148;
        List r37 = r31.e;
        if (r37 == null) goto L148;
        final int r38 = r37.size();
    L149:
        final Ref.LongRef r127 = new Ref.LongRef();
        com.larus.utils.e1.d(getBinding().c.a, new f3(r31, r38, this, r127));
        com.larus.bmhome.actionbar.model.l0 r39 = getCurrentBindData();
        if (r39 == null) goto L152;
        final com.larus.bmhome.actionbar.model.h r40 = r39.b;
    L154:
        if (r40 == null) goto L160;
        List r128 = r40.e;
        if (r128 == null) goto L160;
        if (r128.size() != 1) goto L160;
        boolean r129 = true;
    L161:
        if (r129 == false) goto L163;
        getBinding().d.b.setVisibility(8);
    L163:
        if (r40 == null) goto L167;
        Integer r130 = r40.f;
        if (r130 == null) goto L167;
        int r131 = r130.intValue();
    L168:
        if (r40 == null) goto L184;
        List r132 = r40.e;
        if (r132 == null) goto L184;
        ArrayList r133 = new ArrayList();
        Iterator r134 = r132.iterator();
    L173:
        if (r134.hasNext() == false) goto L183;
        Object r135 = r134.next();
        Integer r136 = ((com.larus.bmhome.actionbar.model.w) r135).s;
        if (r136 != null) goto L178;
    L180:
        boolean r137 = false;
    L181:
        if (r137 == false) goto L173;
        r133.add(r135);
        goto L173
    L178:
        if (r136.intValue() != 1) goto L180;
        r137 = true;
        goto L181
    L183:
        int r138 = r133.size();
    L185:
        if (r138 <= 0) goto L187;
        boolean r139 = true;
    L188:
        if (r40 == null) goto L201;
        List r140 = r40.e;
        if (r140 == null) goto L201;
        Iterator r141 = r140.iterator();
    L193:
        if (r141.hasNext() == false) goto L197;
        Object r142 = r141.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r142).a, r40.g) == false) goto L193;
    L198:
        com.larus.bmhome.actionbar.model.w r143 = (com.larus.bmhome.actionbar.model.w) r142;
        if (r143 == null) goto L201;
        r143.s = 1;
    L202:
        if (r143 != null) goto L212;
        if (r131 < 0) goto L212;
        if (r139 == true) goto L212;
        if (r40 == null) goto L209;
        List r144 = r40.e;
        if (r144 == null) goto L209;
        com.larus.bmhome.actionbar.model.w r145 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r144, r131);
    L210:
        if (r145 == null) goto L212;
        r145.s = 1;
    L209:
        r145 = null;
    L212:
        com.larus.utils.e1.o(getBinding().d.c);
        AppCompatTextView r41 = getBinding().d.d;
        if (r40 == null) goto L232;
        List r146 = r40.e;
        if (r146 == null) goto L232;
        Iterator r147 = r146.iterator();
    L218:
        if (r147.hasNext() == false) goto L228;
        Object r148 = r147.next();
        Integer r149 = ((com.larus.bmhome.actionbar.model.w) r148).s;
        if (r149 != null) goto L223;
    L225:
        boolean r150 = false;
    L226:
        if (r150 == false) goto L218;
    L229:
        com.larus.bmhome.actionbar.model.w r151 = (com.larus.bmhome.actionbar.model.w) r148;
        if (r151 == null) goto L232;
        String r152 = r151.b();
    L233:
        r41.setText(r152);
        if (r40 == null) goto L236;
        Integer r153 = r40.b;
    L237:
        this.n = new DropdownItemAdapter(r153, this.w, null);
        y6.d(this.m, null, null, null, new a3(this, r40), 15);
        DropdownItemAdapter r42 = this.n;
        if (r42 == null) goto L243;
        if (r40 == null) goto L241;
        List r154 = r40.e;
    L242:
        r42.submitList(r154);
        goto L243
    L241:
        r154 = null;
    L243:
        if (r40 == null) goto L247;
        List r43 = r40.e;
        if (r43 == null) goto L247;
        final int r44 = r43.size();
    L248:
        final Ref.LongRef r155 = new Ref.LongRef();
        com.larus.utils.e1.d(getBinding().d.a, new b3(r40, this, r44, r155));
        com.larus.bmhome.actionbar.model.l0 r45 = getCurrentBindData();
        if (r45 == null) goto L251;
        final com.larus.bmhome.actionbar.model.h r46 = r45.c;
    L252:
        if (r46 == null) goto L254;
        List r47 = r46.e;
    L255:
        List r48 = r47;
        if (r48 != null) goto L258;
    L261:
        boolean r49 = true;
    L262:
        if (r49 == false) goto L264;
        getBinding().e.a.setVisibility(8);
        getCache().storeString(z, "-1");
    L265:
        if (r46 == null) goto L269;
        Integer r50 = r46.f;
        if (r50 == null) goto L269;
        r34 = r50.intValue();
    L269:
        if (r46 == null) goto L285;
        List r51 = r46.e;
        if (r51 == null) goto L285;
        ArrayList r52 = new ArrayList();
        Iterator r53 = r51.iterator();
    L274:
        if (r53.hasNext() == false) goto L284;
        Object r156 = r53.next();
        Integer r157 = ((com.larus.bmhome.actionbar.model.w) r156).s;
        if (r157 != null) goto L279;
    L281:
        boolean r158 = false;
    L282:
        if (r158 == false) goto L274;
        r52.add(r156);
        goto L274
    L279:
        if (r157.intValue() != 1) goto L281;
        r158 = true;
        goto L282
    L284:
        int r54 = r52.size();
    L286:
        if (r54 <= 0) goto L288;
        boolean r55 = true;
    L290:
        if (com.larus.platform.service.z2.a.A2().getRecordStatus() == true) goto L305;
        if (r46 == null) goto L334;
        List r56 = r46.e;
        if (r56 == null) goto L334;
        Iterator r57 = r56.iterator();
    L296:
        if (r57.hasNext() == false) goto L334;
        com.larus.bmhome.actionbar.model.w r58 = (com.larus.bmhome.actionbar.model.w) r57.next();
        Map r59 = r58.q;
        if (r59 == null) goto L300;
        String r60 = (String) r59.get("speaker_mode");
    L302:
        if (Intrinsics.areEqual(r60, "1") == true) goto L303;
        r58.s = 0;
        goto L296
    L303:
        r58.s = 1;
        getCache().storeString(z, "1");
        goto L296
    L300:
        r60 = null;
    L334:
        com.larus.utils.e1.o(getBinding().e.c);
        AppCompatTextView r61 = getBinding().e.d;
        if (r46 == null) goto L354;
        List r62 = r46.e;
        if (r62 == null) goto L354;
        Iterator r63 = r62.iterator();
    L340:
        if (r63.hasNext() == false) goto L350;
        Object r64 = r63.next();
        Integer r65 = ((com.larus.bmhome.actionbar.model.w) r64).s;
        if (r65 != null) goto L345;
    L347:
        boolean r66 = false;
    L348:
        if (r66 == false) goto L340;
    L351:
        com.larus.bmhome.actionbar.model.w r67 = (com.larus.bmhome.actionbar.model.w) r64;
        if (r67 == null) goto L354;
        String r68 = r67.b();
    L355:
        r61.setText(r68);
        if (r46 == null) goto L358;
        Integer r69 = r46.b;
    L359:
        this.r = new DropdownItemAdapter(r69, this.x, null);
        y6.d(this.q, null, null, null, new c3(this, r46), 15);
        DropdownItemAdapter r70 = this.r;
        if (r70 == null) goto L364;
        if (r46 == null) goto L363;
        r5 = r46.e;
    L363:
        r70.submitList(r5);
    L364:
        if (r46 == null) goto L368;
        List r71 = r46.e;
        if (r71 == null) goto L368;
        r2 = r71.size();
    L368:
        final Ref.LongRef r72 = new Ref.LongRef();
        com.larus.utils.e1.d(getBinding().e.a, new d3(this, r2, r72));
        return;
    L358:
        r69 = null;
        goto L359
    L345:
        if (r65.intValue() != 1) goto L347;
        r66 = true;
        goto L348
    L350:
        r64 = null;
    L354:
        r68 = null;
        goto L355
    L305:
        if (r46 == null) goto L318;
        List r73 = r46.e;
        if (r73 == null) goto L318;
        Iterator r74 = r73.iterator();
    L310:
        if (r74.hasNext() == false) goto L314;
        Object r75 = r74.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r75).a, r46.g) == false) goto L310;
    L315:
        com.larus.bmhome.actionbar.model.w r76 = (com.larus.bmhome.actionbar.model.w) r75;
        if (r76 == null) goto L318;
        r76.s = 1;
    L319:
        if (r76 != null) goto L334;
        if (r34 < 0) goto L334;
        if (r55 == true) goto L334;
        if (r46 == null) goto L326;
        List r77 = r46.e;
        if (r77 == null) goto L326;
        com.larus.bmhome.actionbar.model.w r78 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r77, r34);
    L327:
        if (r78 == null) goto L334;
        r78.s = 1;
        Map r79 = r78.q;
        if (r79 == null) goto L332;
        String r80 = (String) r79.get("speaker_mode");
        if (r80 == null) goto L332;
    L333:
        getCache().storeString(z, r80);
    L332:
        r80 = this.u;
    L326:
        r78 = null;
        goto L327
    L314:
        r75 = null;
    L318:
        r76 = null;
        goto L319
    L288:
        r55 = false;
    L285:
        r54 = 0;
        goto L286
    L264:
        getBinding().e.a.setVisibility(0);
        goto L265
    L258:
        if (r48.isEmpty() == true) goto L261;
        r49 = false;
        goto L262
    L254:
        r47 = null;
        goto L255
    L251:
        r46 = null;
    L247:
        r44 = 0;
        goto L248
    L236:
        r153 = null;
        goto L237
    L223:
        if (r149.intValue() != 1) goto L225;
        r150 = true;
        goto L226
    L228:
        r148 = null;
    L232:
        r152 = null;
        goto L233
    L197:
        r142 = null;
    L201:
        r143 = null;
        goto L202
    L187:
        r139 = false;
    L184:
        r138 = 0;
    L167:
        r131 = -1;
    L160:
        r129 = false;
        goto L161
    L152:
        r40 = null;
    L148:
        r38 = 0;
        goto L149
    L137:
        r125 = null;
        goto L138
    L124:
        if (r121.intValue() != 1) goto L126;
        r122 = true;
        goto L127
    L129:
        r120 = null;
    L133:
        r124 = null;
        goto L134
    L99:
        r114 = null;
    L103:
        r115 = null;
    L89:
        r111 = -1;
    L80:
        r33 = false;
        goto L82
    L72:
        r31 = null;
        goto L74
    L11:
        r6 = null;
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    public final LarusLayoutActionBarEditorWidgetTranslatorV3Binding getBinding() {
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.p getController() {
        return (xs8.p) getController();
    }

    private final com.larus.bmhome.actionbar.model.l0 getCurrentBindData() {
        xs8.p r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public TranslatorWidgetV3(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 6, 0);
        View r0 = LayoutInflater.from(r5).inflate(2131562465, null);
        this.h = r0;
        this.i = r0.findViewById(2131382753);
        View r1 = LayoutInflater.from(r5).inflate(2131562465, null);
        this.l = r1;
        this.m = r1.findViewById(2131382753);
        View r6 = LayoutInflater.from(r5).inflate(2131562465, null);
        this.p = r6;
        this.q = r6.findViewById(2131382753);
        this.s = LazyKt.lazy(new z2());
        this.t = -1;
        this.u = "1";
        this.v = new c(this);
        this.w = new d(this);
        this.x = new b(this);
    }

    public static final /* synthetic */ Keva i6(TranslatorWidgetV3 r0) {
        return r0.getCache();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.l0 k6(TranslatorWidgetV3 r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetTranslatorV3Binding.a(LayoutInflater.from(r1), this);
    }
}
