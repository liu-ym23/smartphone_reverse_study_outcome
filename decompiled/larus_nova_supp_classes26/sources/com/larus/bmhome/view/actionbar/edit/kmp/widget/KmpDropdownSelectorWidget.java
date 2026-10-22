package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import bt8.u;
import bt8.v;
import bt8.x;
import bt8.y;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.edit.component.DropdownItemAdapter;
import com.larus.bmhome.view.actionbar.edit.component.b1;
import com.larus.bmhome.view.actionbar.edit.kmp.p;
import com.larus.bmhome.view.screenmenu.d;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import cq8.a0;
import cq8.n;
import cq8.o;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u0000 P2\u00060\u0001j\u0002`\u0002:\u0001PB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00100\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u00102\u001a\u0002012\u0006\u0010 \u001a\u000203H\u0014J\u000e\u00104\u001a\u0002012\u0006\u0010 \u001a\u00020!J\b\u00105\u001a\u000201H\u0002J\u0017\u00106\u001a\u0002012\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00108J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u000201H\u0002J$\u0010;\u001a\u0002012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010>\u001a\u000201H\u0002J\u0018\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\bH\u0002J \u0010B\u001a\u0002012\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u0002012\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010I\u001a\u00020DH\u0002J\b\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020G2\u0006\u0010A\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020GH\u0002J\u0019\u00107\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0002\u0010OR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "balloon", "Lcom/skydoves/balloon/Balloon;", "dismissTimeMs", "", "spinnerLocation", "", "displayFrame", "Landroid/graphics/Rect;", "popupView", "Landroid/view/View;", "getPopupView", "()Landroid/view/View;", "popupView$delegate", "Lkotlin/Lazy;", "popupList", "Landroidx/recyclerview/widget/RecyclerView;", "getPopupList", "()Landroidx/recyclerview/widget/RecyclerView;", "popupList$delegate", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropdownSelectorDescriptor;", "dropdownBoxId", "optionList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "buttonShowReported", "", "pendingOriginalSelection", "Ljava/lang/Long;", "popupItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "popupTrackingBound", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget$itemSelectedCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "showPopupIfNeeded", "applySelection", "selectedOptionId", "(Ljava/lang/Long;)V", "renderSelectedText", "ensurePopupTracking", "reportDescriptorDrivenSelectionChange", "previousOptionList", "newOptionList", "consumePendingOriginalSelectionIfNeeded", "reportOptionShow", "option", "optionPosition", "reportOptionClick", "optionSource", "", "trackButtonShow", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "trackButtonClick", "currentPageForTrace", "buildMusicAppletOptionParams", "Lorg/json/JSONObject;", "calculateIsDefault", "dropdown", "calculateIsChooseRequired", "(Ljava/util/List;)Ljava/lang/Long;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDropdownSelectorWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int u = 0;
    public LarusItemActionbarDropdownListBinding f;
    public Balloon g;
    public long h;
    public final int[] i;
    public final Rect j;
    public final Lazy k;
    public final Lazy l;
    public o m;
    public int n;
    public List<w> o;
    public boolean p;
    public Long q;
    public DropdownItemAdapter r;
    public boolean s;
    public final b t;

    public static final class a {
    }

    public static final class b implements b1 {
        public final /* synthetic */ KmpDropdownSelectorWidget a;

        public b(KmpDropdownSelectorWidget r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r9, w r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "selectedSpinnerItem");
            Long r0 = r10.a;
            if (r0 == null) goto L5;
            long r1 = r0.longValue();
        L6:
            FLogger.a.i("KmpDropdownSelectorWidget", "[onItemSelected] selectedDropdownId:" + r9 + ", selectedId:" + r1);
            Iterator<w> r12 = this.a.o.iterator();
            boolean r2 = false;
            int r3 = 0;
        L8:
            if (r12.hasNext() == false) goto L19;
            Long r4 = r12.next().a;
            if (r4 != null) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == true) goto L20;
            r3 = r3 + 1;
        L20:
            Integer r13 = Integer.valueOf(r3);
            if (r13.intValue() < 0) goto L23;
            r2 = true;
        L23:
            if (r2 == true) goto L26;
            r13 = null;
        L26:
            if (r13 == null) goto L28;
            r11 = r13.intValue();
        L28:
            this.a.q = Long.valueOf(r1);
            this.a.n6(r10, r11, "original");
            Balloon r14 = this.a.g;
            if (r14 == null) goto L31;
            r14.h();
        L31:
            o r15 = this.a.m;
            if (r15 == null) goto L39;
            z r16 = r15.d;
            if (r16 == null) goto L39;
            String r17 = r15.c;
            if (r17 != null) goto L38;
            r17 = "";
        L38:
            r16.a(new n(r17, r1));
        L39:
            this.a.b6(Long.valueOf(r1));
            return;
        L13:
            if (r4.longValue() != r1) goto L15;
            r5 = true;
            goto L16
        L19:
            r3 = -1;
            goto L20
        L5:
            r1 = 0;
            goto L6
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    static {
    }

    public KmpDropdownSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpDropdownSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final RecyclerView getPopupList() {
        return (RecyclerView) this.l.getValue();
    }

    private final View getPopupView() {
        return (View) this.k.getValue();
    }

    public final void k6() {
        Iterator<T> r0 = this.o.iterator();
    L3:
        LarusItemActionbarDropdownListBinding r2 = null;
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        Integer r3 = ((w) r1).s;
        if (r3 == null) goto L11;
        boolean r4 = true;
        if (r3.intValue() != 1) goto L11;
    L12:
        if (r4 == false) goto L3;
    L15:
        w r5 = (w) r1;
        if (r5 != null) goto L22;
        LarusItemActionbarDropdownListBinding r6 = this.f;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        e1.o(r2.d);
        return;
    L20:
        r2 = r6;
        goto L21
    L22:
        LarusItemActionbarDropdownListBinding r7 = this.f;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L25:
        AppCompatTextView r8 = r7.d;
        String r9 = r5.b();
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        r8.setText(r9);
        LarusItemActionbarDropdownListBinding r10 = this.f;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        e1.x(r2.d);
        return;
    L31:
        r2 = r10;
    L11:
        r4 = false;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    public final JSONObject c6() {
        if (p.a(getVContext()) == false) goto L5;
        Fragment r0 = getFragment();
        String r1 = null;
        if (r0 == null) goto L9;
        Bundle r2 = r0.getArguments();
    L10:
        JSONObject r3 = new JSONObject();
        r3.put("app_enter_method", "action_bar");
        if (r2 == null) goto L14;
        String r4 = r2.getString("from_entrance");
        if (r4 == null) goto L14;
    L15:
        r3.put("from_entrance", r4);
        if (r2 == null) goto L19;
        String r5 = r2.getString("app_key");
        if (r5 == null) goto L19;
    L20:
        r3.put("app_key", r5);
        if (r2 == null) goto L24;
        String r6 = r2.getString("app_name");
        if (r6 == null) goto L24;
    L25:
        r3.put("app_name", r6);
        if (r2 == null) goto L34;
        String r7 = r2.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r7 == null) goto L34;
        if ((!StringsKt.isBlank(r7)) == false) goto L32;
        r1 = r7;
    L32:
        if (r1 == null) goto L34;
        r3.put("doubao_apps_message_id", r1);
    L34:
        return r3;
    L24:
        r6 = "AI 写歌";
    L19:
        r5 = MusicAppletPage.APP_ID;
    L14:
        r4 = "self";
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        return new JSONObject();
    }

    public final String i6() {
        if (p.a(getVContext()) == false) goto L5;
        return "template_page";
    L5:
        return "chat";
    }

    public static RecyclerView Y5(KmpDropdownSelectorWidget r1) {
        return r1.getPopupView().findViewById(2131382753);
    }

    public static Unit Z5(KmpDropdownSelectorWidget r2) {
        r2.h = SystemClock.elapsedRealtime();
        y6.i(r2.getPopupList());
        return Unit.INSTANCE;
    }

    public static Long o6(List r4) {
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Object r0 = r5.next();
        Integer r2 = ((w) r0).s;
        if (r2 == null) goto L11;
        boolean r3 = true;
        if (r2.intValue() != 1) goto L11;
    L12:
        if (r3 == false) goto L4;
    L15:
        w r1 = (w) r0;
        if (r1 != null) goto L18;
        return null;
    L18:
        return r1.a;
    L11:
        r3 = false;
        goto L12
    L14:
        r0 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.w>] */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r31) {
        a0 r1 = r31;
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        FLogger.a.i("KmpDropdownSelectorWidget", "[onDescriptorChanged] descriptor:" + r1);
        if ((r1 instanceof o) == true) goto L5;
        r1 = null;
    L5:
        o r2 = (o) r1;
        if (r2 == null) goto L112;
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        List<w> r3 = this.o;
        this.m = r2;
        h r4 = r2.f;
        if (r4 == null) goto L13;
        Integer r5 = r4.b;
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L14:
        this.n = r6;
        h r7 = r2.f;
        if (r7 == null) goto L22;
        List r8 = r7.e;
        if (r8 == null) goto L22;
        List r9 = r8;
        ?? r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L23;
        r10.add(w.a((w) r11.next(), null, null, null, null, null, null, 8388607));
    L23:
        if (r10 != 0) goto L26;
        r10 = CollectionsKt.emptyList();
    L26:
        if (r3.isEmpty() == false) goto L28;
    L51:
        this.o = r10;
        LarusItemActionbarDropdownListBinding r12 = this.f;
        if (r12 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L54:
        AppCompatTextView r13 = r12.c;
        h r14 = r2.f;
        if (r14 == null) goto L57;
        String r15 = r14.c;
    L58:
        if (r15 != null) goto L60;
        r15 = "";
    L60:
        r13.setText(r15);
        LarusItemActionbarDropdownListBinding r16 = this.f;
        if (r16 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L63:
        e1.x(r16.c);
        h r17 = r2.f;
        if (r17 != null) goto L66;
    L74:
        Long r18 = r2.h;
        if (r18 != null) goto L93;
        Iterator r19 = this.o.iterator();
    L78:
        if (r19.hasNext() == false) goto L88;
        Object r20 = r19.next();
        Integer r21 = ((w) r20).s;
        if (r21 != null) goto L83;
    L85:
        boolean r22 = false;
    L86:
        if (r22 == false) goto L78;
    L89:
        w r23 = (w) r20;
        if (r23 == null) goto L92;
        r18 = r23.a;
        goto L93
    L92:
        r18 = null;
        goto L93
    L83:
        if (r21.intValue() != 1) goto L85;
        r22 = true;
        goto L86
    L88:
        r20 = null;
    L93:
        b6(r18);
        Long r24 = this.q;
        if (r24 == null) goto L110;
        long r25 = r24.longValue();
        Long r26 = o6(this.o);
        if (r26 != null) goto L99;
        return;
    L99:
        if (r26.longValue() != r25) goto L111;
        this.q = null;
        return;
    L111:
        return;
    L110:
        return;
    L66:
        if (this.p == true) goto L74;
        this.p = true;
        o r27 = this.m;
        if (r27 == null) goto L74;
        z0 r28 = r27.i;
        if (r28 == null) goto L74;
        String r29 = r28.a;
        String r30 = r28.c;
        String r210 = i6();
        String r32 = r28.d;
        String r110 = r28.f;
        String r111 = r28.g;
        String r112 = r17.c;
        String r113 = String.valueOf(r17.b);
        int r33 = !Intrinsics.areEqual(r17.h, Boolean.TRUE) ? 1 : 0;
        String r114 = r28.h;
        Boolean r34 = r28.i;
        tx9.b.f(r29, r30, r32, r110, r111, null, null, r112, r113, 0, Integer.valueOf(r33), null, null, null, c6(), "chat", null, null, null, r210, r114, r34, 964704);
        goto L74
    L57:
        r15 = null;
        goto L58
    L28:
        if (r10.isEmpty() == true) goto L51;
        Long r35 = o6(r3);
        Long r36 = o6(r10);
        if (Intrinsics.areEqual(r35, r36) == true) goto L51;
        if (r36 == null) goto L51;
        if (Intrinsics.areEqual(this.q, r36) == true) goto L51;
        Iterator r37 = r10.iterator();
        int r38 = 0;
    L39:
        if (r37.hasNext() == false) goto L44;
        if (Intrinsics.areEqual(((w) r37.next()).a, r36) == true) goto L45;
        r38 = r38 + 1;
    L45:
        if (r38 < 0) goto L51;
        w r39 = (w) CollectionsKt.getOrNull(r10, r38);
        if (r39 == null) goto L51;
        n6(r39, r38, "use_template");
        goto L51
    L44:
        r38 = -1;
    L22:
        r10 = 0;
    L13:
        r6 = 0;
        goto L14
    }

    public final void b6(Long r12) {
        if (r12 != null) goto L5;
        k6();
        return;
    L5:
        List<w> r0 = this.o;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        w r3 = (w) r2.next();
        r1.add(w.a(r3, null, null, Integer.valueOf(Intrinsics.areEqual(r3.a, r12) ? 1 : 0), null, null, null, 8126463));
        goto L7
    L9:
        this.o = r1;
        k6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit V5(final KmpDropdownSelectorWidget r44, ConstraintLayout r45) {
        Intrinsics.checkNotNullParameter(r45, "it");
        if (r44.o.isEmpty() == true) goto L57;
        if ((SystemClock.elapsedRealtime() - r44.h) <= 500) goto L57;
        DropdownItemAdapter r1 = new DropdownItemAdapter(Integer.valueOf(r44.n), r44.t, null);
        r44.r = r1;
        r44.getPopupList().setAdapter(r1);
        if (r44.s == true) goto L12;
        r44.s = true;
        y6.d(r44.getPopupList(), new bt8.z(r44), null, null, new bt8.a0(r44), 13);
    L12:
        r1.submitList(r44.o);
        Iterator<w> r2 = r44.o.iterator();
        int r5 = 0;
    L14:
        if (r2.hasNext() == false) goto L25;
        Integer r6 = r2.next().s;
        if (r6 != null) goto L19;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L26;
        r5 = r5 + 1;
    L26:
        if (r5 < 0) goto L28;
        r44.getPopupList().scrollToPosition(r5);
    L28:
        r44.getLocationOnScreen(r44.i);
        r44.getRootView().getWindowVisibleDisplayFrame(r44.j);
        int r3 = r44.o.size() * i5.d0();
        Rect r8 = r44.j;
        int r9 = (r8.bottom - r8.top) - i5.d0();
        int r10 = r44.j.bottom - r44.i[1];
        if (r3 >= r9) goto L31;
        Integer r4 = null;
    L32:
        final boolean r11 = p.a(r44.getVContext());
        d r12 = d.a;
        LarusItemActionbarDropdownListBinding r13 = r44.f;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L35:
        ConstraintLayout r14 = r13.a;
        View r15 = r44.getPopupView();
        if (r4 == null) goto L38;
        int r16 = r10;
    L40:
        if (r4 != null) goto L42;
    L47:
        Integer r17 = null;
    L48:
        r44.g = r12.f(r14, r15, r16, false, r17, new x(r11), new y(r44));
        o r18 = r44.m;
        if (r18 == null) goto L57;
        h r19 = r18.f;
        if (r19 == null) goto L57;
        z0 r20 = r18.i;
        if (r20 == null) goto L57;
        String r21 = r20.a;
        String r22 = r20.c;
        String r27 = r44.i6();
        String r23 = r20.d;
        String r24 = r20.f;
        String r25 = r20.g;
        String r110 = r19.c;
        String r111 = String.valueOf(r19.b);
        int r26 = 1 ^ (Intrinsics.areEqual(r19.h, Boolean.TRUE) ? 1 : 0);
        String r28 = r20.h;
        Boolean r29 = r20.i;
        tx9.b.e(r21, r22, r23, r24, r25, null, null, r110, r111, 0, Integer.valueOf(r26), null, "select", null, null, null, r44.c6(), null, "chat", null, null, null, r27, r28, r29, null, null, null, null, null, null, null, null, null, null, null, null, -59316128, 127);
        goto L57
    L42:
        if (r4.intValue() <= 0) goto L44;
        boolean r30 = true;
    L45:
        if (r30 == false) goto L47;
        r17 = r4;
        goto L48
    L44:
        r30 = false;
        goto L45
    L38:
        r16 = 0;
        goto L40
    L31:
        r4 = Integer.valueOf((int) c7.d(Integer.valueOf(r9)));
        goto L32
    L19:
        if (r6.intValue() != 1) goto L21;
        r7 = true;
        goto L22
    L25:
        r5 = -1;
    L57:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        LarusItemActionbarDropdownListBinding r3 = LarusItemActionbarDropdownListBinding.b(LayoutInflater.from(r1), this, true);
        this.f = r3;
        e1.d(r3.a, new u(this));
    }

    public KmpDropdownSelectorWidget(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = new int[2];
        this.j = new Rect();
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.k = LazyKt.lazy(r5, new v(r2));
        this.l = LazyKt.lazy(r5, new bt8.w(this));
        this.o = CollectionsKt.emptyList();
        this.t = new b(this);
    }

    public final void n6(w r45, int r46, String r47) {
        o r3 = this.m;
        if (r3 != null) goto L5;
        return;
    L5:
        h r4 = r3.f;
        if (r4 != null) goto L8;
        return;
    L8:
        z0 r5 = r3.i;
        String r6 = r5.a;
        String r7 = r5.c;
        String r27 = i6();
        String r8 = r5.d;
        String r9 = r5.f;
        String r10 = r5.g;
        String r11 = r5.j;
        String r12 = r4.c;
        String r13 = r45.b;
        String r14 = String.valueOf(r45.a);
        Boolean r0 = r4.h;
        Boolean r15 = Boolean.TRUE;
        int r16 = 0;
        if (Intrinsics.areEqual(r0, r15) == true) goto L17;
        Integer r1 = r4.f;
        if (r1 == null) goto L17;
        if (r1.intValue() != r46) goto L17;
        r16 = 1;
    L17:
        int r2 = !Intrinsics.areEqual(r4.h, r15) ? 1 : 0;
        String r17 = r5.h;
        Boolean r18 = r5.i;
        JSONObject r21 = c6();
        tx9.b.e(r6, r7, r8, r9, r10, r11, r12, r13, r14, Integer.valueOf(r16), Integer.valueOf(r2), Integer.valueOf(r46 + 1), "select", null, null, null, r21, r47, "chat", null, null, null, r27, r17, r18, null, null, null, null, null, null, null, null, null, null, null, null, -59580416, 127);
    }

    public /* synthetic */ KmpDropdownSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
