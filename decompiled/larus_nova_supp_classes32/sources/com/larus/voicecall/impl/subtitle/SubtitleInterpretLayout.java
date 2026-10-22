package com.larus.voicecall.impl.subtitle;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutSubtitleInterpretBinding;
import com.larus.voicecall.impl.databinding.LarusSubtitleInterpretDropdownListBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0002$'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"J\u0018\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u000fJ\u0012\u00101\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\u0012\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0012\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(¨\u0006B"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleInterpretLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "binding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutSubtitleInterpretBinding;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "setCurrentBindData", "(Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;)V", "sourceLanguageBalloon", "Lcom/skydoves/balloon/Balloon;", "sourceLanguagePopupView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "sourceLanguageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sourceLanguageItemAdapter", "Lcom/larus/voicecall/impl/subtitle/DropdownItemAdapter;", "targetLanguageBalloon", "targetLanguagePopupView", "targetLanguageRecyclerView", "targetLanguageItemAdapter", "languageSelectorUpdateCallback", "Lcom/larus/voicecall/impl/subtitle/LanguageSelectorUpdateCallback;", "sourceLanguageSelectedCallback", "com/larus/voicecall/impl/subtitle/SubtitleInterpretLayout$sourceLanguageSelectedCallback$1", "Lcom/larus/voicecall/impl/subtitle/SubtitleInterpretLayout$sourceLanguageSelectedCallback$1;", "targetLanguageSelectedCallback", "com/larus/voicecall/impl/subtitle/SubtitleInterpretLayout$targetLanguageSelectedCallback$1", "Lcom/larus/voicecall/impl/subtitle/SubtitleInterpretLayout$targetLanguageSelectedCallback$1;", "registerLanguageSelectorUpdateCallback", NameKeys.UnloadStrategy_No_Strategy, "callback", "updateLanguageDropdownHeight", "recyclerView", "itemCount", "onBindView", "selectedSceneItem", "assignLanguageListsBasedOnCurrentTargetLanguage", "swapTargetAndSourceLanguage", "sendInterpretLanguageSettingEvent", "clickFrom", "clearAllSelectionStates", "restoreInterpretSelector", "updateInterpretArrow", "initSourceLanguageSelector", LynxResourceModule.DATA_KEY, "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "initTargetLanguageSelector", "updateInterpretItemMarginStart", "view", "marginStart", "getDisplayText", "selectedSpinnerItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleInterpretLayout extends ConstraintLayout {
    public static final /* synthetic */ int o = 0;
    public final String a;
    public final LarusLayoutSubtitleInterpretBinding b;
    public com.larus.bmhome.actionbar.model.l0 c;
    public Balloon d;
    public final View e;
    public final RecyclerView f;
    public DropdownItemAdapter g;
    public Balloon h;
    public final View i;
    public final RecyclerView j;
    public DropdownItemAdapter k;
    public j l;
    public final a m;
    public final b n;

    public static final class a implements e {
        public final /* synthetic */ SubtitleInterpretLayout a;

        public a(SubtitleInterpretLayout r1) {
            this.a = r1;
        }

        @Override // com.larus.voicecall.impl.subtitle.e
        public final void a(com.larus.bmhome.actionbar.model.w r10) {
            Intrinsics.checkNotNullParameter(r10, "selectedSpinnerItem");
            Balloon r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.h();
        L5:
            SubtitleInterpretLayout r1 = this.a;
            r1.b.c.e.setText(r1.R5(r10));
            com.larus.bmhome.actionbar.model.l0 r2 = this.a.getCurrentBindData();
            if (r2 == null) goto L25;
            com.larus.bmhome.actionbar.model.h r3 = r2.a;
            if (r3 == null) goto L25;
            List r4 = r3.e;
            if (r4 == null) goto L25;
            Iterator r5 = r4.iterator();
            int r6 = 0;
        L13:
            if (r5.hasNext() == false) goto L25;
            Object r7 = r5.next();
            int r8 = r6 + 1;
            if (r6 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r9 = (com.larus.bmhome.actionbar.model.w) r7;
            if (Intrinsics.areEqual(r9.a, r10.a) == false) goto L23;
            r9.s = 1;
            String r11 = u3a.f.a;
            String r12 = r9.k;
            if (r12 != null) goto L22;
            r12 = NameKeys.UnloadStrategy_No_Strategy;
        L22:
            u3a.f.f(r12);
        L24:
            r6 = r8;
            goto L13
        L23:
            r9.s = 0;
        L25:
            com.larus.bmhome.actionbar.model.l0 r13 = this.a.getCurrentBindData();
            List r14 = null;
            if (r13 == null) goto L30;
            com.larus.bmhome.actionbar.model.h r15 = r13.a;
            if (r15 == null) goto L30;
            com.larus.bmhome.actionbar.model.h r16 = com.larus.bmhome.actionbar.model.h.a(r15, null, null, null, null, null, null, 4095);
        L31:
            DropdownItemAdapter r17 = this.a.g;
            if (r17 == null) goto L36;
            if (r16 == null) goto L35;
            r14 = r16.e;
        L35:
            r17.submitList(r14);
        L36:
            this.a.b6();
            j r18 = this.a.l;
            if (r18 == null) goto L39;
            r18.a();
        L39:
            this.a.getClass();
            SubtitleInterpretLayout.Y5("source_language");
            return;
        L30:
            r16 = null;
            goto L31
        }
    }

    public static final class b implements e {
        public final /* synthetic */ SubtitleInterpretLayout a;

        public b(SubtitleInterpretLayout r1) {
            this.a = r1;
        }

        @Override // com.larus.voicecall.impl.subtitle.e
        public final void a(com.larus.bmhome.actionbar.model.w r10) {
            Intrinsics.checkNotNullParameter(r10, "selectedSpinnerItem");
            Balloon r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.h();
        L5:
            SubtitleInterpretLayout r1 = this.a;
            r1.b.d.e.setText(r1.R5(r10));
            com.larus.bmhome.actionbar.model.l0 r2 = this.a.getCurrentBindData();
            if (r2 == null) goto L25;
            com.larus.bmhome.actionbar.model.h r3 = r2.b;
            if (r3 == null) goto L25;
            List r4 = r3.e;
            if (r4 == null) goto L25;
            Iterator r5 = r4.iterator();
            int r6 = 0;
        L13:
            if (r5.hasNext() == false) goto L25;
            Object r7 = r5.next();
            int r8 = r6 + 1;
            if (r6 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r9 = (com.larus.bmhome.actionbar.model.w) r7;
            if (Intrinsics.areEqual(r9.a, r10.a) == false) goto L23;
            r9.s = 1;
            String r11 = u3a.f.a;
            String r12 = r9.k;
            if (r12 != null) goto L22;
            r12 = NameKeys.UnloadStrategy_No_Strategy;
        L22:
            u3a.f.g(r12);
        L24:
            r6 = r8;
            goto L13
        L23:
            r9.s = 0;
        L25:
            com.larus.bmhome.actionbar.model.l0 r13 = this.a.getCurrentBindData();
            List r14 = null;
            if (r13 == null) goto L30;
            com.larus.bmhome.actionbar.model.h r15 = r13.b;
            if (r15 == null) goto L30;
            com.larus.bmhome.actionbar.model.h r16 = com.larus.bmhome.actionbar.model.h.a(r15, null, null, null, null, null, null, 4095);
        L31:
            DropdownItemAdapter r17 = this.a.k;
            if (r17 == null) goto L36;
            if (r16 == null) goto L35;
            r14 = r16.e;
        L35:
            r17.submitList(r14);
        L36:
            this.a.b6();
            j r18 = this.a.l;
            if (r18 == null) goto L39;
            r18.a();
        L39:
            this.a.getClass();
            SubtitleInterpretLayout.Y5("source_language");
            return;
        L30:
            r16 = null;
            goto L31
        }
    }

    public SubtitleInterpretLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SubtitleInterpretLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b6() {
        com.larus.bmhome.actionbar.model.l0 r0 = this.c;
        if (r0 == null) goto L8;
        com.larus.bmhome.actionbar.model.h r1 = r0.b;
        if (r1 == null) goto L8;
        List r2 = r1.e;
        if (r2 == null) goto L8;
    L9:
        List r3 = r2;
        com.larus.bmhome.actionbar.model.l0 r4 = this.c;
        if (r4 == null) goto L16;
        com.larus.bmhome.actionbar.model.h r5 = r4.a;
        if (r5 == null) goto L16;
        List r6 = r5.e;
        if (r6 == null) goto L16;
    L17:
        Iterator r7 = CollectionsKt.plus(r3, r6).iterator();
        boolean r8 = false;
        boolean r9 = false;
    L19:
        if (r7.hasNext() == false) goto L27;
        com.larus.bmhome.actionbar.model.w r10 = (com.larus.bmhome.actionbar.model.w) r7.next();
        if (Intrinsics.areEqual(r10.k, u3a.f.c()) == false) goto L24;
        r8 = Intrinsics.areEqual(r10.n, Boolean.TRUE);
    L24:
        if (Intrinsics.areEqual(r10.k, u3a.f.d()) == false) goto L19;
        r9 = Intrinsics.areEqual(r10.n, Boolean.TRUE);
        goto L19
    L27:
        if (z2.a.getRealtimeCallTranslatorConfig().c() == false) goto L68;
        com.larus.bmhome.actionbar.model.l0 r11 = this.c;
        if (r11 == null) goto L44;
        com.larus.bmhome.actionbar.model.h r12 = r11.a;
        if (r12 == null) goto L44;
        List r13 = r12.e;
        if (r13 == null) goto L44;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L40;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r15).k, u3a.f.c()) == false) goto L36;
    L41:
        com.larus.bmhome.actionbar.model.w r16 = (com.larus.bmhome.actionbar.model.w) r15;
        if (r16 == null) goto L44;
        String r17 = r16.o;
    L46:
        if (Intrinsics.areEqual(r17, "source") == false) goto L56;
        AppCompatImageView r18 = this.b.b;
        if (r18 == null) goto L50;
        r18.setImageResource(2131243234);
    L50:
        AppCompatImageView r19 = this.b.b;
        if (r19 == null) goto L53;
        r19.setOnClickListener(null);
    L53:
        AppCompatImageView r20 = this.b.b;
        if (r20 == null) goto L86;
        r20.setClickable(false);
        return;
    L86:
        return;
    L56:
        if (r8 == false) goto L61;
        if (r9 == false) goto L61;
        AppCompatImageView r21 = this.b.b;
        if (r21 == null) goto L64;
        r21.setImageResource(v19.c.b(2130972160, r21.getContext(), 2131243229));
    L64:
        AppCompatImageView r22 = this.b.b;
        if (r22 == null) goto L67;
        r22.setClickable(true);
    L67:
        com.larus.utils.e1.d(this.b.b, new j1(this));
        return;
    L61:
        AppCompatImageView r23 = this.b.b;
        if (r23 == null) goto L64;
        r23.setImageResource(2131243235);
        goto L64
    L40:
        r15 = null;
    L44:
        r17 = null;
        goto L46
    L68:
        if (r8 == false) goto L73;
        if (r9 == false) goto L73;
        AppCompatImageView r24 = this.b.b;
        if (r24 == null) goto L76;
        r24.setImageResource(v19.c.b(2130972160, r24.getContext(), 2131243229));
    L76:
        com.larus.utils.e1.d(this.b.b, new k1(this));
        return;
    L73:
        AppCompatImageView r25 = this.b.b;
        if (r25 == null) goto L76;
        r25.setImageResource(v19.c.b(2130972161, r25.getContext(), 2131243232));
    L16:
        r6 = CollectionsKt.emptyList();
    L8:
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    public final void V5() {
        String r0 = u3a.f.c();
        if (TextUtils.isEmpty(r0) == true) goto L21;
        com.larus.bmhome.actionbar.model.l0 r1 = this.c;
        if (r1 == null) goto L21;
        com.larus.bmhome.actionbar.model.h r2 = r1.a;
        if (r2 == null) goto L21;
        List r3 = r2.e;
        if (r3 == null) goto L21;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        com.larus.bmhome.actionbar.model.w r5 = (com.larus.bmhome.actionbar.model.w) r4.next();
        if (Intrinsics.areEqual(r5.k, r0) == false) goto L19;
        String r6 = u3a.f.a;
        String r7 = r5.k;
        if (r7 != null) goto L18;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        u3a.f.f(r7);
        Integer r8 = 1;
    L20:
        r5.s = r8;
        goto L12
    L19:
        r8 = 0;
    L21:
        String r9 = u3a.f.d();
        if (TextUtils.isEmpty(r9) == true) goto L40;
        com.larus.bmhome.actionbar.model.l0 r10 = this.c;
        if (r10 == null) goto L47;
        com.larus.bmhome.actionbar.model.h r11 = r10.b;
        if (r11 == null) goto L48;
        List r12 = r11.e;
        if (r12 == null) goto L49;
        Iterator r13 = r12.iterator();
    L31:
        if (r13.hasNext() == false) goto L50;
        com.larus.bmhome.actionbar.model.w r14 = (com.larus.bmhome.actionbar.model.w) r13.next();
        if (Intrinsics.areEqual(r14.k, r9) == false) goto L38;
        String r15 = u3a.f.a;
        String r16 = r14.k;
        if (r16 != null) goto L37;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        u3a.f.g(r16);
        Integer r17 = 1;
    L39:
        r14.s = r17;
        goto L31
    L38:
        r17 = 0;
        goto L39
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void Z5() {
        String r0 = u3a.f.d();
        String r1 = u3a.f.c();
        u3a.f.f(r0);
        u3a.f.g(r1);
        com.larus.bmhome.actionbar.model.l0 r2 = this.c;
        if (r2 == null) goto L47;
        com.larus.bmhome.actionbar.model.h r3 = r2.a;
        Long r4 = null;
        if (r3 == null) goto L7;
        List r5 = r3.e;
    L8:
        if (r3 == null) goto L14;
        com.larus.bmhome.actionbar.model.h r6 = r2.b;
        if (r6 == null) goto L12;
        List r7 = r6.e;
    L13:
        r3.e = r7;
        goto L14
    L12:
        r7 = null;
    L14:
        com.larus.bmhome.actionbar.model.h r8 = r2.b;
        if (r8 == null) goto L17;
        r8.e = r5;
    L17:
        if (r3 == null) goto L19;
        Long r9 = r3.g;
    L20:
        if (r3 == null) goto L24;
        if (r8 == null) goto L23;
        r4 = r8.g;
    L23:
        r3.g = r4;
    L24:
        if (r8 == null) goto L26;
        r8.g = r9;
    L26:
        com.larus.bmhome.actionbar.model.h r10 = r2.a;
        if (r10 == null) goto L34;
        List r11 = r10.e;
        if (r11 == null) goto L34;
        Iterator r12 = r11.iterator();
    L32:
        if (r12.hasNext() == false) goto L34;
        ((com.larus.bmhome.actionbar.model.w) r12.next()).s = 0;
    L34:
        com.larus.bmhome.actionbar.model.l0 r13 = this.c;
        if (r13 == null) goto L44;
        com.larus.bmhome.actionbar.model.h r14 = r13.b;
        if (r14 == null) goto L44;
        List r15 = r14.e;
        if (r15 == null) goto L44;
        Iterator r16 = r15.iterator();
    L42:
        if (r16.hasNext() == false) goto L44;
        ((com.larus.bmhome.actionbar.model.w) r16.next()).s = 0;
    L44:
        V5();
        S5(r2.a);
        T5(r2.b);
        b6();
        j r17 = this.l;
        if (r17 == null) goto L47;
        r17.a();
        goto L47
    L19:
        r9 = null;
        goto L20
    L7:
        r5 = null;
    L47:
        Y5("switch");
    }

    public final com.larus.bmhome.actionbar.model.l0 getCurrentBindData() {
        return this.c;
    }

    public static void Y5(String r2) {
        JSONObject r0 = new JSONObject();
        r0.put("click_from", r2);
        r0.put("from_language", u3a.f.c());
        r0.put("to_language", u3a.f.d());
        com.larus.platform.service.o.a.reportEvent("language_setting", r0);
    }

    public final String R5(com.larus.bmhome.actionbar.model.w r1) {
        if (r1 == null) goto L5;
        String r2 = r1.b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void S5(final com.larus.bmhome.actionbar.model.h r13) {
        boolean r0 = true;
        int r2 = 0;
        if (r13 == null) goto L9;
        List r3 = r13.e;
        if (r3 == null) goto L9;
        if (r3.size() != 1) goto L9;
    L10:
        if (r0 == false) goto L12;
        this.b.c.b.setVisibility(8);
        c6(this.b.c.c, j19.c.c(12));
    L13:
        if (r13 == null) goto L17;
        Integer r1 = r13.f;
        if (r1 == null) goto L17;
        int r4 = r1.intValue();
    L18:
        if (r13 == null) goto L25;
        List r5 = r13.e;
        if (r5 == null) goto L25;
        Iterator r6 = r5.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        ((com.larus.bmhome.actionbar.model.w) r6.next()).s = 0;
    L25:
        boolean r7 = TextUtils.isEmpty(u3a.f.c());
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        List r9 = null;
        if (r7 == true) goto L52;
        if (r13 == null) goto L38;
        List r10 = r13.e;
        if (r10 == null) goto L38;
        Iterator r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L36;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r12).k, u3a.f.c()) == false) goto L32;
    L37:
        com.larus.bmhome.actionbar.model.w r14 = (com.larus.bmhome.actionbar.model.w) r12;
    L39:
        if (r14 == null) goto L41;
        r14.s = 1;
        this.b.c.e.setText(R5(r14));
    L86:
        com.larus.utils.e1.o(this.b.c.d);
        if (r13 == null) goto L89;
        Integer r15 = r13.b;
    L90:
        this.g = new DropdownItemAdapter(r15, this.m);
        y6.d(this.f, null, null, null, new n1(this), 15);
        DropdownItemAdapter r16 = this.g;
        if (r16 == null) goto L95;
        if (r13 == null) goto L94;
        r9 = r13.e;
    L94:
        r16.submitList(r9);
    L95:
        if (r13 == null) goto L99;
        List r17 = r13.e;
        if (r17 == null) goto L99;
        r2 = r17.size();
    L99:
        i6(this.f, r2);
        final Ref.LongRef r18 = new Ref.LongRef();
        com.larus.utils.e1.d(this.b.c.a, new o1(this, r13, r18));
        return;
    L89:
        r15 = null;
        goto L90
    L41:
        if (r13 == null) goto L45;
        List r19 = r13.e;
        if (r19 == null) goto L45;
        com.larus.bmhome.actionbar.model.w r20 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r19);
    L46:
        if (r20 == null) goto L86;
        r20.s = 1;
        String r21 = u3a.f.a;
        String r22 = r20.k;
        if (r22 == null) goto L51;
        r8 = r22;
    L51:
        u3a.f.f(r8);
        this.b.c.e.setText(R5(r20));
    L45:
        r20 = null;
        goto L46
    L36:
        r12 = null;
    L38:
        r14 = null;
        goto L39
    L52:
        if (r13 == null) goto L65;
        List r23 = r13.e;
        if (r23 == null) goto L65;
        Iterator r24 = r23.iterator();
    L57:
        if (r24.hasNext() == false) goto L61;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r25).a, r13.g) == false) goto L57;
    L62:
        com.larus.bmhome.actionbar.model.w r26 = (com.larus.bmhome.actionbar.model.w) r25;
        if (r26 == null) goto L65;
        r26.s = 1;
    L66:
        if (r26 != null) goto L79;
        if (r4 < 0) goto L79;
        if (r13 == null) goto L72;
        List r27 = r13.e;
        if (r27 == null) goto L72;
        com.larus.bmhome.actionbar.model.w r28 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r27, r4);
    L73:
        if (r28 == null) goto L86;
        String r29 = u3a.f.a;
        String r30 = r28.k;
        if (r30 == null) goto L78;
        r8 = r30;
    L78:
        u3a.f.f(r8);
        r28.s = 1;
        this.b.c.e.setText(R5(r28));
    L72:
        r28 = null;
    L79:
        String r31 = u3a.f.a;
        if (r26 == null) goto L85;
        String r32 = r26.k;
        if (r32 == null) goto L85;
        r8 = r32;
    L85:
        u3a.f.f(r8);
        this.b.c.e.setText(R5(r26));
        goto L86
    L61:
        r25 = null;
    L65:
        r26 = null;
    L17:
        r4 = -1;
        goto L18
    L12:
        this.b.c.b.setVisibility(0);
        c6(this.b.c.c, j19.c.c(16));
    L9:
        r0 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.ArrayList] */
    public final void T5(final com.larus.bmhome.actionbar.model.h r15) {
        int r2 = 0;
        if (r15 == null) goto L9;
        List r3 = r15.e;
        if (r3 == null) goto L9;
        if (r3.size() != 1) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        this.b.d.b.setVisibility(8);
        c6(this.b.d.c, j19.c.c(12));
    L13:
        if (r15 == null) goto L17;
        Integer r5 = r15.f;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
    L18:
        if (r15 == null) goto L34;
        List r7 = r15.e;
        if (r7 == null) goto L34;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L23:
        if (r9.hasNext() == false) goto L33;
        Object r10 = r9.next();
        Integer r11 = ((com.larus.bmhome.actionbar.model.w) r10).s;
        if (r11 != null) goto L28;
    L30:
        boolean r12 = false;
    L31:
        if (r12 == false) goto L23;
        r8.add(r10);
        goto L23
    L28:
        if (r11.intValue() != 1) goto L30;
        r12 = true;
        goto L31
    L33:
        int r13 = r8.size();
    L35:
        if (r13 <= 0) goto L37;
        boolean r14 = true;
    L38:
        if (r15 == null) goto L45;
        List r16 = r15.e;
        if (r16 == null) goto L45;
        Iterator r17 = r16.iterator();
    L43:
        if (r17.hasNext() == false) goto L45;
        ((com.larus.bmhome.actionbar.model.w) r17.next()).s = 0;
    L45:
        boolean r18 = TextUtils.isEmpty(u3a.f.d());
        String r19 = NameKeys.UnloadStrategy_No_Strategy;
        ?? r20 = 0;
        r20 = 0;
        r20 = 0;
        if (r18 == true) goto L75;
        if (r15 == null) goto L58;
        List r21 = r15.e;
        if (r21 == null) goto L58;
        Iterator r22 = r21.iterator();
    L52:
        if (r22.hasNext() == false) goto L56;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r23).k, u3a.f.d()) == false) goto L52;
    L57:
        com.larus.bmhome.actionbar.model.w r24 = (com.larus.bmhome.actionbar.model.w) r23;
    L59:
        if (r24 == null) goto L61;
        r24.s = 1;
        this.b.d.e.setText(R5(r24));
    L110:
        com.larus.utils.e1.o(this.b.d.d);
        if (r15 == null) goto L113;
        Integer r25 = r15.b;
    L114:
        this.k = new DropdownItemAdapter(r25, this.n);
        y6.d(this.j, null, null, null, new l1(this), 15);
        if (z2.a.getRealtimeCallTranslatorConfig().c() == false) goto L125;
        if (r15 == null) goto L127;
        List r1 = r15.e;
        if (r1 == null) goto L127;
        r20 = new ArrayList();
        Iterator r26 = r1.iterator();
    L121:
        if (r26.hasNext() == false) goto L127;
        Object r27 = r26.next();
        if ((!Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r27).o, "source")) == false) goto L121;
        r20.add(r27);
    L127:
        DropdownItemAdapter r0 = this.k;
        if (r0 == null) goto L130;
        r0.submitList(r20);
    L130:
        if (r20 == 0) goto L132;
        r2 = r20.size();
    L132:
        i6(this.j, r2);
        final Ref.LongRef r28 = new Ref.LongRef();
        com.larus.utils.e1.d(this.b.d.a, new m1(this, r15, r28));
        return;
    L125:
        if (r15 == null) goto L127;
        r20 = r15.e;
        goto L127
    L113:
        r25 = null;
        goto L114
    L61:
        if (r15 == null) goto L65;
        List r29 = r15.e;
        if (r29 == null) goto L65;
        com.larus.bmhome.actionbar.model.w r30 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r29);
    L66:
        if (r30 == null) goto L110;
        r30.s = 1;
        String r31 = u3a.f.a;
        String r32 = r30.k;
        if (r32 != null) goto L70;
        r32 = NameKeys.UnloadStrategy_No_Strategy;
    L70:
        u3a.f.g(r32);
        this.b.d.e.setText(R5(r30));
        String r33 = r30.k;
        if (r33 == null) goto L74;
        r19 = r33;
    L74:
        u3a.f.g(r19);
    L65:
        r30 = null;
        goto L66
    L56:
        r23 = null;
    L58:
        r24 = null;
        goto L59
    L75:
        if (r15 == null) goto L88;
        List r34 = r15.e;
        if (r34 == null) goto L88;
        Iterator r35 = r34.iterator();
    L80:
        if (r35.hasNext() == false) goto L84;
        Object r36 = r35.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r36).a, r15.g) == false) goto L80;
    L85:
        com.larus.bmhome.actionbar.model.w r37 = (com.larus.bmhome.actionbar.model.w) r36;
        if (r37 == null) goto L88;
        r37.s = 1;
    L89:
        if (r37 != null) goto L103;
        if (r6 < 0) goto L103;
        if (r14 == true) goto L103;
        if (r15 == null) goto L96;
        List r38 = r15.e;
        if (r38 == null) goto L96;
        com.larus.bmhome.actionbar.model.w r39 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r38, r6);
    L97:
        if (r39 == null) goto L110;
        String r40 = u3a.f.a;
        String r41 = r39.k;
        if (r41 == null) goto L102;
        r19 = r41;
    L102:
        u3a.f.g(r19);
        r39.s = 1;
        this.b.d.e.setText(R5(r39));
    L96:
        r39 = null;
    L103:
        String r42 = u3a.f.a;
        if (r37 == null) goto L109;
        String r43 = r37.k;
        if (r43 == null) goto L109;
        r19 = r43;
    L109:
        u3a.f.g(r19);
        this.b.d.e.setText(R5(r37));
        goto L110
    L84:
        r36 = null;
    L88:
        r37 = null;
        goto L89
    L37:
        r14 = false;
    L34:
        r13 = 0;
    L17:
        r6 = -1;
        goto L18
    L12:
        this.b.d.b.setVisibility(0);
        c6(this.b.d.c, j19.c.c(16));
    L9:
        r4 = false;
        goto L10
    }

    public final void U5(com.larus.bmhome.actionbar.model.l0 r15) {
        FLogger.a.i(this.a, "onBindView : " + r15);
        if (r15 == null) goto L82;
        this.c = r15;
        String r0 = u3a.f.d();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        com.larus.bmhome.actionbar.model.h r4 = null;
        if (r3 == true) goto L56;
        com.larus.bmhome.actionbar.model.h r5 = r15.b;
        if (r5 == null) goto L29;
        List r6 = r5.e;
        if (r6 == null) goto L29;
        List r7 = r6;
        if ((r7 instanceof Collection) == true) goto L21;
    L23:
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r8.next()).k, r0) == false) goto L25;
        boolean r9 = true;
    L30:
        com.larus.bmhome.actionbar.model.h r10 = r15.a;
        if (r10 == null) goto L45;
        List r11 = r10.e;
        if (r11 == null) goto L45;
        List r12 = r11;
        if ((r12 instanceof Collection) == true) goto L37;
    L39:
        Iterator r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L45;
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r13.next()).k, r0) == false) goto L41;
        r1 = true;
        goto L45
    L37:
        if (r12.isEmpty() == false) goto L39;
    L45:
        if (r9 == true) goto L55;
        if (r1 == false) goto L55;
        com.larus.bmhome.actionbar.model.h r14 = r15.a;
        com.larus.bmhome.actionbar.model.h r16 = r15.b;
        if (r16 == null) goto L50;
        com.larus.bmhome.actionbar.model.h r2 = com.larus.bmhome.actionbar.model.h.a(r16, null, null, null, null, null, null, 4095);
    L51:
        if (r14 == null) goto L53;
        com.larus.bmhome.actionbar.model.h r17 = com.larus.bmhome.actionbar.model.h.a(r14, null, null, null, null, null, null, 4095);
    L54:
        this.c = com.larus.bmhome.actionbar.model.l0.d(r15, r2, r17, null, 28);
        FLogger.a.i(this.a, "Swapped source and target lists because target language '" + r0 + "' was in original source list");
        goto L56
    L53:
        r17 = null;
        goto L54
    L50:
        r2 = null;
    L55:
        this.c = r15;
        FLogger.a.i(this.a, "Kept original list assignment, target language '" + r0 + "' is in appropriate list");
        goto L56
    L21:
        if (r7.isEmpty() == false) goto L23;
    L29:
        r9 = false;
    L56:
        this.g = new DropdownItemAdapter(1, this.m);
        this.k = new DropdownItemAdapter(2, this.n);
        this.f.setAdapter(this.g);
        this.j.setAdapter(this.k);
        DropdownItemAdapter r18 = this.g;
        if (r18 == null) goto L65;
        com.larus.bmhome.actionbar.model.l0 r19 = this.c;
        if (r19 == null) goto L63;
        com.larus.bmhome.actionbar.model.h r20 = r19.a;
        if (r20 == null) goto L63;
        List r21 = r20.e;
    L64:
        r18.submitList(r21);
    L63:
        r21 = null;
    L65:
        DropdownItemAdapter r110 = this.k;
        if (r110 == null) goto L74;
        com.larus.bmhome.actionbar.model.l0 r22 = this.c;
        if (r22 == null) goto L72;
        com.larus.bmhome.actionbar.model.h r23 = r22.b;
        if (r23 == null) goto L72;
        List r24 = r23.e;
    L73:
        r110.submitList(r24);
    L72:
        r24 = null;
    L74:
        V5();
        com.larus.bmhome.actionbar.model.l0 r111 = this.c;
        if (r111 == null) goto L77;
        com.larus.bmhome.actionbar.model.h r112 = r111.a;
    L78:
        S5(r112);
        com.larus.bmhome.actionbar.model.l0 r113 = this.c;
        if (r113 == null) goto L81;
        r4 = r113.b;
    L81:
        T5(r4);
        b6();
        return;
    L77:
        r112 = null;
        goto L78
    L7:
        if (r0.length() == 0) goto L10;
        r3 = false;
        goto L11
    L82:
        u3a.f.e = NameKeys.UnloadStrategy_No_Strategy;
        u3a.f.f = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void setCurrentBindData(com.larus.bmhome.actionbar.model.l0 r1) {
        this.c = r1;
    }

    public static void c6(View r2, int r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getMarginStart() == r3) goto L12;
        r1.setMarginStart(r3);
        r2.setLayoutParams(r1);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void i6(RecyclerView r1, int r2) {
        if (r2 <= 8) goto L5;
        int r3 = i5.d0() * 8;
    L6:
        r1.setVerticalScrollBarEnabled(false);
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.height = r3;
        r1.setLayoutParams(r0);
        r1.requestLayout();
        r1.invalidateItemDecorations();
        return;
    L5:
        r3 = -2;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubtitleInterpretLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = "SubtitleInterpretLayout";
        LayoutInflater.from(r3).inflate(2131562892, this);
        int r6 = 2131375564;
        AppCompatImageView r7 = ViewBindings.findChildViewById(this, 2131375564);
        if (r7 == null) goto L12;
        r6 = 2131375566;
        View r0 = ViewBindings.findChildViewById(this, 2131375566);
        if (r0 == null) goto L12;
        LarusSubtitleInterpretDropdownListBinding r8 = LarusSubtitleInterpretDropdownListBinding.a(r0);
        View r1 = ViewBindings.findChildViewById(this, 2131375567);
        if (r1 == null) goto L10;
        this.b = new LarusLayoutSubtitleInterpretBinding(this, r7, r8, LarusSubtitleInterpretDropdownListBinding.a(r1));
        View r9 = LayoutInflater.from(r3).inflate(2131562875, null);
        this.e = r9;
        RecyclerView r10 = r9.findViewById(2131382753);
        this.f = r10;
        View r11 = LayoutInflater.from(r3).inflate(2131562875, null);
        this.i = r11;
        RecyclerView r12 = r11.findViewById(2131382753);
        this.j = r12;
        r10.addItemDecoration(new i());
        r12.addItemDecoration(new i());
        this.m = new a(this);
        this.n = new b(this);
        return;
    L10:
        r6 = 2131375567;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }

    public /* synthetic */ SubtitleInterpretLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
