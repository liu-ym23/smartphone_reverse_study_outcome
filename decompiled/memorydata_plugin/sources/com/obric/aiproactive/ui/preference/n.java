package com.obric.aiproactive.ui.preference;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fBI\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00062\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter$OptionViewHolder;", "onOptionClick", "Lkotlin/Function1;", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOption;", "", "onInputChanged", "Lkotlin/Function2;", "", "onInputFocusRequested", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "page", "Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "state", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "pendingFocusOptionId", "submitPage", "focusOptionId", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "OptionViewHolder", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f6780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<m, Unit> f6781b;
    private final Function2<m, String, Unit> c;
    private final Function1<View, Unit> d;
    private o e;
    private j f;
    private String g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter$Companion;", "", "<init>", "()V", "KEYBOARD_RETRY_DELAY_MS", "", "OPTION_ITEM_MARGIN_BOTTOM_DP", "", "OPTION_CONTAINER_MIN_HEIGHT_DP", "OPTION_CONTENT_PADDING_VERTICAL_DP", "SINGLE_SELECTION_CONTROL_WIDTH_DP", "SINGLE_SELECTION_CONTROL_HEIGHT_DP", "MULTIPLE_SELECTION_CONTROL_SIZE_DP", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter$OptionViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter;Landroid/view/View;)V", "container", "Landroidx/cardview/widget/CardView;", Params.CONTENT, "Landroid/widget/LinearLayout;", "optionRow", "title", "Landroid/widget/TextView;", "description", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "markView", "Landroid/widget/ImageView;", "inputView", "Landroid/widget/EditText;", "divider", "watcher", "Landroid/text/TextWatcher;", "bind", "", "option", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOption;", "selectionMode", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceSelectionMode;", "input", "", "isSelected", "", "showsInput", "showDivider", "focusInput", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b extends RecyclerView.v {
        private final View A;
        private TextWatcher B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CardView f6783b;
        private final LinearLayout t;
        private final LinearLayout u;
        private final TextView v;
        private final TextView w;
        private final OCheckBox x;
        private final ImageView y;
        private final EditText z;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter$OptionViewHolder$bind$7", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements TextWatcher {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f6784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ m f6785b;

            a(n r1, m r2) {
                this.f6784a = r1;
                this.f6785b = r2;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable r2) {
                Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
                CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
                Function2 r6 = n.a(this.f6784a);
                m r0 = this.f6785b;
                if (r5 == null) goto L5;
                String r7 = r5.toString();
            L6:
                if (r7 != null) goto L8;
                r7 = "";
            L8:
                r6.invoke(r0, r7);
                return;
            L5:
                r7 = null;
                goto L6
            }
        }

        public b(n r5, View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            this.f6782a = r5;
            super(r6);
            View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.option_container, OaidModel.KEY_ID, "option_container"));
            Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
            this.f6783b = (CardView) ZeusTransformUtils.preCheckCast(r7, CardView.class, "com.obric.memorydata.plugin");
            View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.option_content, OaidModel.KEY_ID, "option_content"));
            Intrinsics.checkNotNullExpressionValue(r8, "findViewById(...)");
            this.t = (LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.memorydata.plugin");
            View r9 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.option_row, OaidModel.KEY_ID, "option_row"));
            Intrinsics.checkNotNullExpressionValue(r9, "findViewById(...)");
            this.u = (LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.memorydata.plugin");
            View r10 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_option_title, OaidModel.KEY_ID, "tv_option_title"));
            Intrinsics.checkNotNullExpressionValue(r10, "findViewById(...)");
            this.v = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
            View r11 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_option_description, OaidModel.KEY_ID, "tv_option_description"));
            Intrinsics.checkNotNullExpressionValue(r11, "findViewById(...)");
            this.w = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
            View r12 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.cb_option, OaidModel.KEY_ID, "cb_option"));
            Intrinsics.checkNotNullExpressionValue(r12, "findViewById(...)");
            this.x = (OCheckBox) ZeusTransformUtils.preCheckCast(r12, OCheckBox.class, "com.obric.memorydata.plugin");
            View r13 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.iv_option_mark, OaidModel.KEY_ID, "iv_option_mark"));
            Intrinsics.checkNotNullExpressionValue(r13, "findViewById(...)");
            this.y = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.memorydata.plugin");
            View r14 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.input_option, OaidModel.KEY_ID, "input_option"));
            Intrinsics.checkNotNullExpressionValue(r14, "findViewById(...)");
            this.z = (EditText) ZeusTransformUtils.preCheckCast(r14, EditText.class, "com.obric.memorydata.plugin");
            View r15 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.option_divider, OaidModel.KEY_ID, "option_divider"));
            Intrinsics.checkNotNullExpressionValue(r15, "findViewById(...)");
            this.A = r15;
        }

        private static final void a(InputMethodManager r2, b r3) {
            if (r2 == null) goto L5;
            r2.showSoftInput((View) ZeusTransformUtils.preCheckCast(r3.z, View.class, "com.obric.memorydata.plugin"), 1);
            return;
        }

        private static final void a(final b r5, n r6) {
            r5.z.requestFocus();
            EditText r0 = r5.z;
            Editable r1 = r0.getText();
            if (r1 == null) goto L5;
            int r2 = r1.length();
        L6:
            r0.setSelection(r2);
            final InputMethodManager r3 = (InputMethodManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.z.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L9;
            r3.showSoftInput((View) ZeusTransformUtils.preCheckCast(r5.z, View.class, "com.obric.memorydata.plugin"), 1);
        L9:
            r5.z.postDelayed(new $$Lambda$n$b$u74lbss1PkTf40h3We0ws5ehctE(r3, r5), 120);
            n.c(r6).invoke(r5.z);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        private static final void a(b r0, n r1, View r2) {
            r0.z.requestFocus();
            n.c(r1).invoke(r0.z);
        }

        private static final void a(n r0, m r1, View r2) {
            n.b(r0).invoke(r1);
        }

        private static final void a(n r0, b r1, View r2, boolean r3) {
            if (r3 == false) goto L5;
            n.c(r0).invoke(r1.z);
            return;
        }

        private static final void b(n r0, m r1, View r2) {
            n.b(r0).invoke(r1);
        }

        private static final void c(n r0, m r1, View r2) {
            n.b(r0).invoke(r1);
        }

        /* JADX INFO: renamed from: lambda$20EMfOtTveF2j-AQUaIDYpYfE9U, reason: not valid java name */
        public static /* synthetic */ void m330lambda$20EMfOtTveF2jAQUaIDYpYfE9U(b r0, n r1) {
            a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$AggAlGqF8Dq5OF2qpZkzAY-a4Lo, reason: not valid java name */
        public static /* synthetic */ void m331lambda$AggAlGqF8Dq5OF2qpZkzAYa4Lo(b r0, n r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$L_I0VvQb6YnxmnOv2OV6dFzD6O4(n r0, m r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$QincAn9qyTKtaBKdWZJKfHTmrXQ(n r0, b r1, View r2, boolean r3) {
            a(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$j_q_6lVb5a6AOFOvVTtFsw28lVY(n r0, m r1, View r2) {
            c(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$lzRNT60vh0ni7b0nVwywB3_t-YU, reason: not valid java name */
        public static /* synthetic */ void m332lambda$lzRNT60vh0ni7b0nVwywB3_tYU(n r0, m r1, View r2) {
            b(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$u74lbss1PkTf40h3We0ws5ehctE(InputMethodManager r0, b r1) {
            a(r0, r1);
        }

        public final void a() {
            EditText r0 = this.z;
            final n r1 = this.f6782a;
            r0.post(new $$Lambda$n$b$20EMfOtTveF2jAQUaIDYpYfE9U(this, r1));
        }

        public final void a(final m r17, GuidedPreferenceSelectionMode r18, String r19, boolean r20, boolean r21, boolean r22) {
            Intrinsics.checkNotNullParameter(r17, "option");
            Intrinsics.checkNotNullParameter(r18, "selectionMode");
            Intrinsics.checkNotNullParameter(r19, "input");
            this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            String r5 = r17.c();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            this.w.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
            boolean r6 = !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
            TextView r7 = this.w;
            int r9 = 8;
            if (r6 == false) goto L8;
            int r11 = 0;
        L9:
            r7.setVisibility(r11);
            boolean r8 = !r6;
            float r12 = 0.0f;
            if (r6 == false) goto L12;
            float r10 = 10.0f;
        L13:
            this.f6783b.setMinimumHeight((int) com.obric.oui.common.util.h.a(48.0f));
            LinearLayout r13 = this.u;
            ViewGroup.LayoutParams r14 = r13.getLayoutParams();
            if (r8 == false) goto L16;
            int r15 = (int) com.obric.oui.common.util.h.a(48.0f);
        L17:
            r14.height = r15;
            r13.setLayoutParams(r14);
            this.u.setGravity(16);
            this.t.setGravity(0);
            LinearLayout r16 = this.t;
            r16.setPadding(r16.getPaddingLeft(), (int) com.obric.oui.common.util.h.a(r10), this.t.getPaddingRight(), (int) com.obric.oui.common.util.h.a(r10));
            ViewGroup.LayoutParams r23 = this.c.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r23, RecyclerView.LayoutParams.class) == false) goto L20;
            RecyclerView.LayoutParams r24 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r23, RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        L21:
            if (r24 == null) goto L25;
            if (r22 == false) goto L24;
            r12 = 4.0f;
        L24:
            r24.bottomMargin = (int) com.obric.oui.common.util.h.a(r12);
            this.c.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        L25:
            View r25 = this.A;
            if (r22 == false) goto L28;
            int r26 = 0;
        L29:
            r25.setVisibility(r26);
            if (r18 != GuidedPreferenceSelectionMode.SINGLE) goto L44;
            this.x.setVisibility(8);
            ImageView r2 = this.y;
            if (r20 == false) goto L34;
            int r27 = 0;
        L35:
            r2.setVisibility(r27);
            ImageView r3 = this.y;
            if (r3.getVisibility() != 0) goto L38;
            boolean r28 = true;
        L39:
            r3.setClickable(r28);
            ImageView r4 = this.y;
            if (r4.getVisibility() != 0) goto L42;
            boolean r29 = true;
        L43:
            r4.setFocusable(r29);
        L45:
            OCheckBox r30 = this.x;
            ViewGroup.LayoutParams r31 = r30.getLayoutParams();
            int r110 = (int) com.obric.oui.common.util.h.a(24.0f);
            r31.width = r110;
            r31.height = r110;
            r30.setLayoutParams(r31);
            ImageView r32 = this.y;
            ViewGroup.LayoutParams r33 = r32.getLayoutParams();
            r33.width = (int) com.obric.oui.common.util.h.a(32.0f);
            r33.height = (int) com.obric.oui.common.util.h.a(24.0f);
            r32.setLayoutParams(r33);
            this.x.setOnCheckedChangeListener(null);
            this.x.setChecked(r20);
            this.f6783b.setSelected(r20);
            EditText r34 = this.z;
            if (r21 == false) goto L48;
            r9 = 0;
        L48:
            r34.setVisibility(r9);
            EditText r35 = this.z;
            r35.setInputType(16385);
            r35.setSingleLine(true);
            r35.setMaxLines(1);
            r35.setMinLines(1);
            r35.setGravity(16);
            r35.setTextColor(Color.parseColor("#E5FFFFFF"));
            r35.setHintTextColor(Color.parseColor("#66FFFFFF"));
            r35.setHint((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r35.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.guided_preference_other_input_hint, TypedValues.Custom.S_STRING, "guided_preference_other_input_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
            r35.setTextSize(16.0f);
            r35.setIncludeFontPadding(false);
            r35.setPadding((int) com.obric.oui.common.util.h.a(12.0f), 0, (int) com.obric.oui.common.util.h.a(8.0f), 0);
            r35.setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)}, InputFilter[].class, "com.obric.memorydata.plugin"));
            r35.setFocusable(true);
            r35.setFocusableInTouchMode(true);
            r35.setBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r35.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.bg_guided_preference_input, "drawable", "bg_guided_preference_input")));
            TextWatcher r36 = this.B;
            if (r36 == null) goto L52;
            this.z.removeTextChangedListener(r36);
        L52:
            if (Intrinsics.areEqual(this.z.getText().toString(), r19) == true) goto L54;
            this.z.setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
        L54:
            TextWatcher r37 = (TextWatcher) ZeusTransformUtils.preCheckCast(new a(this.f6782a, r17), TextWatcher.class, "com.obric.memorydata.plugin");
            this.B = r37;
            this.z.addTextChangedListener(r37);
            CardView r38 = this.f6783b;
            final n r39 = this.f6782a;
            r38.setOnClickListener(new $$Lambda$n$b$L_I0VvQb6YnxmnOv2OV6dFzD6O4(r39, r17));
            OCheckBox r40 = this.x;
            final n r41 = this.f6782a;
            r40.setOnClickListener(new $$Lambda$n$b$lzRNT60vh0ni7b0nVwywB3_tYU(r41, r17));
            ImageView r42 = this.y;
            final n r43 = this.f6782a;
            r42.setOnClickListener(new $$Lambda$n$b$j_q_6lVb5a6AOFOvVTtFsw28lVY(r43, r17));
            EditText r1 = this.z;
            final n r44 = this.f6782a;
            r1.setOnFocusChangeListener(new $$Lambda$n$b$QincAn9qyTKtaBKdWZJKfHTmrXQ(r44, this));
            EditText r45 = this.z;
            final n r46 = this.f6782a;
            r45.setOnClickListener(new $$Lambda$n$b$AggAlGqF8Dq5OF2qpZkzAYa4Lo(this, r46));
            return;
        L42:
            r29 = false;
            goto L43
        L38:
            r28 = false;
            goto L39
        L34:
            r27 = 4;
            goto L35
        L44:
            this.y.setVisibility(8);
            this.x.setVisibility(0);
            this.x.setClickable(true);
            this.x.setFocusable(true);
            goto L45
        L28:
            r26 = 8;
            goto L29
        L20:
            r24 = null;
            goto L21
        L16:
            r15 = -2;
            goto L17
        L12:
            r10 = 0.0f;
            goto L13
        L8:
            r11 = 8;
            goto L9
        }
    }

    static {
        f6780a = new a(null);
    }

    public n(Function1<? super m, Unit> r3, Function2<? super m, ? super String, Unit> r4, Function1<? super View, Unit> r5) {
        Function1<m, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function2<m, String, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function1<View, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onOptionClick");
        Intrinsics.checkNotNullParameter(r7, "onInputChanged");
        Intrinsics.checkNotNullParameter(r8, "onInputFocusRequested");
        this.f6781b = r6;
        this.c = r7;
        this.d = r8;
    }

    public static final /* synthetic */ Function2 a(n r0) {
        return r0.c;
    }

    public static final /* synthetic */ Function1 b(n r0) {
        return r0.f6781b;
    }

    public static final /* synthetic */ Function1 c(n r0) {
        return r0.d;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(b r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        o r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        j r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        m r2 = (m) ZeusTransformUtils.preCheckCast(r0.d().get(r13), m.class, "com.obric.memorydata.plugin");
        boolean r7 = r1.c(r2.a());
        if (r7 == true) goto L11;
    L13:
        boolean r10 = false;
    L14:
        GuidedPreferenceSelectionMode r5 = r0.c();
        String r6 = r1.d(r2.a());
        if (r13 >= CollectionsKt.getLastIndex(r0.d())) goto L17;
        boolean r9 = true;
    L18:
        r12.a(r2, r5, r6, r7, r10, r9);
        if (r10 == true) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(this.g, r2.a()) == false) goto L25;
        this.g = null;
        r12.a();
        return;
    L25:
        return;
    L17:
        r9 = false;
        goto L18
    L11:
        if (r2.f() == false) goto L13;
        r10 = true;
        goto L14
    }

    public final void a(o r8, j r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "page");
        Intrinsics.checkNotNullParameter(r9, "state");
        o r2 = this.e;
        j r3 = this.f;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        List<Integer> r11 = d.f6768a.a(r2, r3, r8, r9, r10);
        if (r11 != null) goto L5;
        h();
        return;
    L5:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        e(((Number) ZeusTransformUtils.preCheckCast(r12.next(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public b b(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_guided_preference_option, "layout", "item_guided_preference_option"), r5, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r7);
        return new b(this, r7);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        o r0 = this.e;
        if (r0 == null) goto L7;
        List<m> r1 = r0.d();
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }
}
