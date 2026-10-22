package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bt8.q;
import bt8.r;
import bt8.s;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.i;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.edit.kmp.p;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;
import com.larus.utils.e1;
import cq8.a0;
import cq8.m;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0004;<=>B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0019H\u0014J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J \u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J*\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00122\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J \u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J0\u0010/\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u000205H\u0002J \u00106\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H\u0002J\f\u00109\u001a\u000202*\u00020\u0013H\u0002J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u0013H\u0002¢\u0006\u0002\u0010:R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/DropdownBoxListAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropdownListSelectorDescriptor;", "dropdownBoxList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "pendingOriginalSelection", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$PendingSelection;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "applySelection", "dropdownId", "selectedOptionId", "", "captureScrollAnchor", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$ScrollAnchor;", "restoreScrollAnchor", "scrollAnchor", "newDropdownBoxList", "renderWidgetChrome", "reportDescriptorDrivenSelectionChanges", "previousDropdownBoxList", "findSelectionChanges", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$SelectionChange;", "consumePendingOriginalSelectionIfNeeded", "reportOptionShow", "dropdown", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "optionPosition", "reportOptionClick", "showPosition", "optionSource", "", "currentPageForTrace", "buildMusicAppletOptionParams", "Lorg/json/JSONObject;", "calculateIsDefault", "calculateIsChooseRequired", "deepCopyDropdownBox", "trackKey", "(Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;)Ljava/lang/Long;", "PendingSelection", "SelectionChange", "ScrollAnchor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDropdownListSelectorWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int k = 0;
    public LarusLayoutActionBarEditorWidgetDropdownSelectorBinding f;
    public DropdownBoxListAdapter g;
    public m h;
    public List<h> i;
    public b j;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PendingSelection(dropdownId=" + this.a + ", optionId=" + this.b + ')';
        }

        public b(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.b) * 31) + this.c;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ScrollAnchor(dropdownKey=" + this.a + ", position=" + this.b + ", offset=" + this.c + ')';
        }

        public c(String r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d {
        public final h a;
        public final w b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "SelectionChange(dropdown=" + this.a + ", option=" + this.b + ", optionPosition=" + this.c + ", dropdownPosition=" + this.d + ')';
        }

        public d(h r2, w r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "dropdown");
            Intrinsics.checkNotNullParameter(r3, "option");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public KmpDropdownListSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpDropdownListSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final c Y5() {
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r0 = this.f;
        String r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayoutManager r1 = r0.c.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r3 = r1;
    L9:
        if (r3 != null) goto L11;
        return null;
    L11:
        int r4 = r3.findFirstVisibleItemPosition();
        if (r4 != (-1)) goto L14;
        return null;
    L14:
        View r5 = r3.findViewByPosition(r4);
        if (r5 == null) goto L17;
        int r6 = r5.getLeft();
    L21:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r7 = this.f;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L24:
        int r8 = r6 - r7.c.getPaddingLeft();
        h r9 = (h) CollectionsKt.getOrNull(this.i, r4);
        if (r9 == null) goto L28;
        r2 = i6(r9);
    L28:
        return new c(r2, r4, r8);
    L17:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r10 = this.f;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L20:
        r6 = r10.c.getPaddingLeft();
        goto L21
    L8:
        r3 = null;
        goto L9
    }

    public final JSONObject V5() {
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

    public static Long c6(h r4) {
        List r5 = r4.e;
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L17;
        Object r0 = r6.next();
        Integer r2 = ((w) r0).s;
        if (r2 == null) goto L14;
        boolean r3 = true;
        if (r2.intValue() != 1) goto L14;
    L15:
        if (r3 == false) goto L7;
    L18:
        w r1 = (w) r0;
        if (r1 != null) goto L21;
        return null;
    L21:
        return r1.a;
    L14:
        r3 = false;
        goto L15
    L17:
        r0 = null;
        goto L18
    }

    public static String i6(h r3) {
        String r0 = r3.a;
        String r1 = null;
        if (r0 != null) goto L5;
    L12:
        Integer r4 = r3.b;
        if (r4 == null) goto L15;
        r1 = r4.toString();
    L15:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L12;
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.h>] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r23) {
        a0 r0 = r23;
        Intrinsics.checkNotNullParameter(r0, "descriptor");
        if ((r0 instanceof m) == true) goto L5;
        r0 = null;
    L5:
        m r1 = (m) r0;
        if (r1 == null) goto L200;
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        List<h> r2 = this.i;
        i r3 = r1.f;
        if (r3 == null) goto L25;
        List r4 = r3.a;
        if (r4 == null) goto L25;
        List r5 = r4;
        ?? r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L26;
        h r8 = (h) r7.next();
        List r9 = r8.e;
        if (r9 == null) goto L21;
        List r10 = r9;
        ?? r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L22;
        r12.add(w.a((w) r11.next(), null, null, null, null, null, null, 8388607));
    L22:
        if (r12 != 0) goto L24;
        r12 = CollectionsKt.emptyList();
    L24:
        r6.add(h.a(r8, null, null, null, r12, null, null, 4079));
        goto L14
    L21:
        r12 = 0;
    L26:
        if (r6 != 0) goto L28;
        r6 = CollectionsKt.emptyList();
    L28:
        ?? r13 = r6;
        final c r14 = Y5();
        this.h = r1;
        String r15 = r1.i;
        boolean r16 = true;
        if (r15 != null) goto L31;
    L33:
        r15 = null;
    L35:
        if (r15 != null) goto L40;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r17 = this.f;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L39:
        e1.o(r17.d);
    L48:
        if (r1.j == false) goto L53;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r18 = this.f;
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L52:
        e1.x(r18.b);
    L58:
        if (r2.isEmpty() == false) goto L60;
    L140:
        this.i = r13;
        DropdownBoxListAdapter r19 = this.g;
        if (r19 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r19 = null;
    L143:
        r19.submitList(this.i, new bt8.p(this, r14));
        b r20 = this.j;
        if (r20 == null) goto L201;
        Iterator r21 = this.i.iterator();
    L148:
        if (r21.hasNext() == false) goto L158;
        Object r22 = r21.next();
        Integer r24 = ((h) r22).b;
        int r25 = r20.a;
        if (r24 != null) goto L153;
    L155:
        boolean r26 = false;
    L156:
        if (r26 == false) goto L148;
    L159:
        h r27 = (h) r22;
        if (r27 == null) goto L167;
        Long r28 = c6(r27);
        long r29 = r20.b;
        if (r28 == null) goto L167;
        if (r28.longValue() != r29) goto L167;
    L168:
        if (r16 == false) goto L199;
        this.j = null;
        return;
    L199:
        return;
    L167:
        r16 = false;
        goto L168
    L153:
        if (r24.intValue() != r25) goto L155;
        r26 = true;
        goto L156
    L158:
        r22 = null;
        goto L159
    L201:
        return;
    L60:
        if (r13.isEmpty() == true) goto L140;
        ArrayList r30 = new ArrayList();
        Iterator r31 = ((Iterable) r13).iterator();
        int r32 = 0;
    L64:
        if (r31.hasNext() == false) goto L123;
        Object r33 = r31.next();
        int r110 = r32 + 1;
        if (r32 >= 0) goto L68;
        CollectionsKt.throwIndexOverflow();
    L68:
        h r34 = (h) r33;
        String r111 = i6(r34);
        Iterator r112 = r2.iterator();
    L70:
        if (r112.hasNext() == false) goto L74;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(i6((h) r113), r111) == false) goto L70;
    L75:
        h r114 = (h) r113;
        if (r114 == null) goto L119;
        List r115 = r114.e;
        if (r115 != null) goto L81;
        r115 = CollectionsKt.emptyList();
    L81:
        List r116 = r115;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L83:
        if (r118.hasNext() == false) goto L85;
        r117.add(((w) r118.next()).a);
        goto L83
    L85:
        List r119 = r34.e;
        if (r119 != null) goto L88;
        r119 = CollectionsKt.emptyList();
    L88:
        List r120 = r119;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator r35 = r120.iterator();
    L90:
        if (r35.hasNext() == false) goto L93;
        r121.add(((w) r35.next()).a);
        goto L90
    L93:
        if (Intrinsics.areEqual(r117, r121) == false) goto L119;
        Long r36 = c6(r114);
        Long r122 = c6(r34);
        if (Intrinsics.areEqual(r36, r122) == true) goto L119;
        if (r122 == null) goto L119;
        List r37 = r34.e;
        if (r37 != null) goto L102;
        r37 = CollectionsKt.emptyList();
    L102:
        Iterator r38 = r37.iterator();
        int r123 = 0;
    L104:
        if (r38.hasNext() == false) goto L109;
        if (Intrinsics.areEqual(((w) r38.next()).a, r122) == true) goto L110;
        r123 = r123 + 1;
    L110:
        if (r123 < 0) goto L119;
        List r39 = r34.e;
        if (r39 != null) goto L115;
        r39 = CollectionsKt.emptyList();
    L115:
        w r40 = (w) CollectionsKt.getOrNull(r39, r123);
        if (r40 == null) goto L119;
        d r124 = new d(r34, r40, r123, r32);
    L120:
        if (r124 == null) goto L122;
        r30.add(r124);
    L122:
        r32 = r110;
        goto L64
    L109:
        r123 = -1;
    L119:
        r124 = null;
        goto L120
    L74:
        r113 = null;
        goto L75
    L123:
        Iterator r41 = r30.iterator();
    L125:
        if (r41.hasNext() == false) goto L140;
        d r42 = (d) r41.next();
        b r43 = this.j;
        if (r43 == null) goto L139;
        int r44 = r43.a;
        Integer r45 = r42.a.b;
        if (r45 == null) goto L139;
        if (r44 != r45.intValue()) goto L139;
        long r46 = r43.b;
        Long r47 = r42.b.a;
        if (r47 == null) goto L139;
        if (r46 == r47.longValue()) goto L125;
    L139:
        Z5(r42.a, r42.b, r42.c, r42.d + 1, "use_template");
        goto L125
    L53:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r48 = this.f;
        if (r48 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r48 = null;
    L56:
        e1.o(r48.b);
        goto L58
    L40:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r49 = this.f;
        if (r49 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r49 = null;
    L43:
        r49.d.setText(r15);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r50 = this.f;
        if (r50 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L46:
        e1.x(r50.d);
        goto L48
    L31:
        if ((!StringsKt.isBlank(r15)) == false) goto L33;
    L25:
        r6 = 0;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [bt8.r] */
    /* JADX WARN: Type inference failed for: r1v0, types: [bt8.s] */
    /* JADX WARN: Type inference failed for: r4v2, types: [bt8.q] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = LarusLayoutActionBarEditorWidgetDropdownSelectorBinding.a(LayoutInflater.from(r3), this);
        this.g = new DropdownBoxListAdapter(new q(this), new r(this), new s(this));
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r5 = this.f;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        RecyclerView r6 = r5.c;
        RecyclerView.Adapter r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L8:
        r6.setAdapter(r1);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r7 = this.f;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        r7.c.setItemAnimator(null);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r8 = this.f;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r0.c.addItemDecoration(new KmpDropdownListSelectorWidget$init$4());
        return;
    L14:
        r0 = r8;
        goto L15
    }

    public final void b6(c r9, List<h> r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L47;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r0 = this.f;
        Integer r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        LinearLayoutManager r2 = r0.c.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L12;
        LinearLayoutManager r3 = r2;
    L13:
        if (r3 != null) goto L15;
        return;
    L15:
        String r4 = r9.a;
        boolean r5 = true;
        int r6 = 0;
        if (r4 == null) goto L34;
        Iterator<h> r7 = r10.iterator();
        int r8 = 0;
    L19:
        if (r7.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(i6(r7.next()), r4) == true) goto L25;
        r8 = r8 + 1;
    L25:
        Integer r11 = Integer.valueOf(r8);
        if (r11.intValue() < 0) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L31;
        r1 = r11;
    L31:
        if (r1 == null) goto L34;
        r6 = r1.intValue();
    L42:
        r3.scrollToPositionWithOffset(r6, r9.c);
        return;
    L28:
        r12 = false;
        goto L29
    L24:
        r8 = -1;
    L34:
        if (r9.a != null) goto L42;
        int r13 = r10.size();
        int r14 = r9.b;
        if (r14 < 0) goto L39;
        if (r14 >= r13) goto L39;
    L40:
        if (r5 == false) goto L42;
        r6 = r14;
    L39:
        r5 = false;
        goto L40
    L12:
        r3 = null;
        goto L13
    }

    public KmpDropdownListSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = CollectionsKt.emptyList();
    }

    public /* synthetic */ KmpDropdownListSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void Z5(h r44, w r45, int r46, int r47, String r48) {
        m r3 = this.h;
        if (r3 != null) goto L5;
        return;
    L5:
        z0 r4 = r3.k;
        String r5 = r4.a;
        String r6 = r4.c;
        String r7 = r4.d;
        String r8 = r4.f;
        String r9 = r4.g;
        String r10 = r4.j;
        String r11 = r44.c;
        String r12 = r45.b;
        String r13 = String.valueOf(r45.a);
        Boolean r1 = r44.h;
        Boolean r14 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r14) == true) goto L14;
        Integer r2 = r44.f;
        if (r2 == null) goto L14;
        if (r2.intValue() != r46) goto L14;
        int r15 = 1;
    L15:
        int r0 = !Intrinsics.areEqual(r44.h, r14) ? 1 : 0;
        String r16 = r4.h;
        Boolean r17 = r4.i;
        if (p.a(getVContext()) == false) goto L18;
        String r18 = "template_page";
    L19:
        String r26 = r18;
        JSONObject r20 = V5();
        tx9.b.e(r5, r6, r7, r8, r9, r10, r11, r12, r13, Integer.valueOf(r15), Integer.valueOf(r0), Integer.valueOf(r47), "select", null, null, null, r20, r48, null, null, null, null, r26, r16, r17, null, null, null, null, null, null, null, null, null, null, null, null, -59056128, 127);
        return;
    L18:
        r18 = "chat";
    L14:
        r15 = 0;
        goto L15
    }
}
