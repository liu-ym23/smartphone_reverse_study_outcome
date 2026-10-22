package com.larus.bot.impl.feature.edit.feature.firstmet.sugget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewbinding.ViewBindings;
import bv8.h;
import bv8.i;
import bv8.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.bot.impl.databinding.LarusDialogBotSuggestsEditPanelBinding;
import com.larus.bot.impl.feature.edit.feature.firstmet.k;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013*\u0002\u001e!\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010%\u001a\u00020$H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0016J\u0018\u00101\u001a\u00020.2\u0006\u0010\n\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0019H\u0016J\u0010\u00103\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\"\u00104\u001a\u00020.2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u00105\u001a\u00020.H\u0016J\u0017\u00106\u001a\u0004\u0018\u00010.2\u0006\u00107\u001a\u00020\bH\u0002¢\u0006\u0002\u00108J)\u00109\u001a\u0004\u0018\u00010.2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010:J\u0017\u0010;\u001a\u0004\u0018\u00010.2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0002\u00108J\u0017\u0010<\u001a\u0004\u0018\u00010.2\u0006\u0010=\u001a\u00020\bH\u0002¢\u0006\u0002\u00108J\u000f\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRH\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/firstmet/sugget/BotSuggestsEditPanel;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/sugget/IBotSuggestsEditPanel;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBotSuggestsEditPanelBinding;", "useImeWatch", "", "value", "suggestSwitch", "getSuggestSwitch", "()Z", "setSuggestSwitch", "(Z)V", "Lkotlin/Triple;", "", "suggests", "getSuggests", "()Lkotlin/Triple;", "setSuggests", "(Lkotlin/Triple;)V", "isGenerating", "setGenerating", "suggestsChangeCallback", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/sugget/ISuggestsChangeCallback;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/firstmet/sugget/BotSuggestsEditPanel$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/sugget/BotSuggestsEditPanel$behaviorCallback$1;", "keyBoardPopListener", "com/larus/bot/impl/feature/edit/feature/firstmet/sugget/BotSuggestsEditPanel$keyBoardPopListener$1", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/sugget/BotSuggestsEditPanel$keyBoardPopListener$1;", "bottomPadding", "", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "init", "callback", "setIsGenerating", "updateSuggests", "onDestroyView", "updateSuggestsAlpha", ItemStyle.ITEM_STYLE_SWITCH, "(Z)Lkotlin/Unit;", "refreshSuggests", "(Lkotlin/Triple;)Lkotlin/Unit;", "refreshIsGenerating", "updateSuggestsFocusable", "focusable", "hideKeyboard", "()Ljava/lang/Boolean;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotSuggestsEditPanel extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDialogBotSuggestsEditPanelBinding d;
    public final boolean e;
    public j f;
    public BottomSheetBehavior<View> g;
    public final b h;
    public final c i;
    public final int j;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BotSuggestsEditPanel a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(BotSuggestsEditPanel r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.g;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public int a;
        public final /* synthetic */ BotSuggestsEditPanel b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LarusDialogBotSuggestsEditPanelBinding r0 = this.b.d;
            if (r0 == null) goto L15;
            WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(r0.a);
            if (r1 == null) goto L16;
            int r2 = r1.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int r3 = r2 + 1;
            int r4 = this.a;
            int r5 = ((Number) i5.y0.getValue()).intValue();
            if (r3 > r5) goto L10;
            if (r5 >= r4) goto L10;
            boolean r6 = true;
        L11:
            if (r6 == false) goto L13;
            r0.b.clearFocus();
            r0.c.clearFocus();
            r0.d.clearFocus();
        L13:
            this.a = r2;
            return;
        L10:
            r6 = false;
            goto L11
        L16:
            return;
        }

        public c(BotSuggestsEditPanel r1) {
            this.b = r1;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ BotSuggestsEditPanel a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(BotSuggestsEditPanel r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
            BotSuggestsEditPanel r11 = this.a;
            int r12 = BotSuggestsEditPanel.k;
            if (Intrinsics.areEqual(r7, r11.T90().getFirst()) == true) goto L16;
            Triple<String, String, String> r0 = this.a.T90();
            if (r7 == null) goto L8;
            String r13 = r7.toString();
        L9:
            if (r13 != null) goto L11;
            r13 = "";
        L11:
            Triple<String, String, String> r14 = Triple.copy$default(r0, r13, null, null, 6, null);
            this.a.Y90(r14);
            j r15 = this.a.f;
            if (r15 == null) goto L15;
            r15.b(r14);
            return;
        L15:
            return;
        L8:
            r13 = null;
            goto L9
        }
    }

    public static final class e implements TextWatcher {
        public final /* synthetic */ BotSuggestsEditPanel a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public e(BotSuggestsEditPanel r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
            BotSuggestsEditPanel r11 = this.a;
            int r12 = BotSuggestsEditPanel.k;
            if (Intrinsics.areEqual(r7, r11.T90().getSecond()) == true) goto L16;
            Triple<String, String, String> r0 = this.a.T90();
            if (r7 == null) goto L8;
            String r13 = r7.toString();
        L9:
            if (r13 != null) goto L11;
            r13 = "";
        L11:
            Triple<String, String, String> r14 = Triple.copy$default(r0, null, r13, null, 5, null);
            this.a.Y90(r14);
            j r15 = this.a.f;
            if (r15 == null) goto L15;
            r15.b(r14);
            return;
        L15:
            return;
        L8:
            r13 = null;
            goto L9
        }
    }

    public static final class f implements TextWatcher {
        public final /* synthetic */ BotSuggestsEditPanel a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public f(BotSuggestsEditPanel r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
            BotSuggestsEditPanel r11 = this.a;
            int r12 = BotSuggestsEditPanel.k;
            if (Intrinsics.areEqual(r7, r11.T90().getThird()) == true) goto L16;
            Triple<String, String, String> r0 = this.a.T90();
            if (r7 == null) goto L8;
            String r13 = r7.toString();
        L9:
            if (r13 != null) goto L11;
            r13 = "";
        L11:
            Triple<String, String, String> r14 = Triple.copy$default(r0, null, null, r13, 3, null);
            this.a.Y90(r14);
            j r15 = this.a.f;
            if (r15 == null) goto L15;
            r15.b(r14);
            return;
        L15:
            return;
        L8:
            r13 = null;
            goto L9
        }
    }

    public static final class g implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ View c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            this.a.removeOnAttachStateChangeListener(this);
            Ref.IntRef r4 = this.b;
            WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this.c);
            if (r0 == null) goto L7;
            Insets r1 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
            if (r1 == null) goto L7;
            int r2 = r1.bottom;
        L8:
            r4.element = r2;
            return;
        L7:
            r2 = this.b.element;
            goto L8
        }

        public g(View r1, Ref.IntRef r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final int getTheme() {
        if (this.e == false) goto L5;
        return 2131954331;
    L5:
        return 2131954332;
    }

    public BotSuggestsEditPanel() {
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        boolean r0 = true;
    L6:
        this.e = r0;
        this.h = new b(this);
        this.i = new c(this);
        this.j = c7.b(16);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean S90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.getBoolean("suggest_switch");
    }

    public final Triple<String, String, String> T90() {
        Bundle r0 = getArguments();
        Triple r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("suggests");
    L7:
        if ((r2 instanceof Triple) == false) goto L10;
        r1 = (Triple) r2;
    L10:
        return k.b(r1);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean U90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("is_generating");
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L9;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L9;
        r2.removeOnGlobalLayoutListener(this.i);
    L9:
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L8;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        int r2 = this.j;
        int r3 = r1.getPaddingStart();
        int r4 = r1.getPaddingTop();
        int r5 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r3 + ",top:" + r4 + ",end:" + r5 + ",bottom:" + r2);
        r1.setPaddingRelative(r3, r4, r5, r2);
        return;
    L9:
        return;
    }

    public final void V90(boolean r4) {
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L20;
        if (r4 == false) goto L6;
        String r1 = r0.a.getContext().getResources().getString(2131901137);
        r0.b.setHint(r1);
        r0.c.setHint(r1);
        r0.d.setHint(r1);
    L16:
        if (S90() == false) goto L18;
        aa0(!r4);
    L18:
        Unit r5 = Unit.INSTANCE;
        return;
    L6:
        Context r2 = getContext();
        if (r2 == null) goto L11;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L11;
        String r6 = r3.getString(2131901104);
    L12:
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r0.b.setHint(r6);
        r0.c.setHint(r6);
        r0.d.setHint(r6);
    L11:
        r6 = null;
        goto L12
    }

    public final void W90(Triple r4) {
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L6;
        r0.b.setText((CharSequence) r4.getFirst());
        r0.c.setText((CharSequence) r4.getSecond());
        r0.d.setText((CharSequence) r4.getThird());
        Unit r5 = Unit.INSTANCE;
        return;
    }

    public final void X90(boolean r3) {
        if (U90() != r3) goto L6;
        return;
    L6:
        if (getArguments() != null) goto L8;
        setArguments(new Bundle());
    L8:
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        r0.putBoolean("is_generating", r3);
    L11:
        V90(r3);
    }

    public final void Y90(Triple<String, String, String> r3) {
        if (getArguments() != null) goto L5;
        setArguments(new Bundle());
    L5:
        Bundle r0 = getArguments();
        if (r0 == null) goto L9;
        r0.putSerializable("suggests", r3);
        return;
    }

    public final void Z90(boolean r3) {
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L9;
        if (r3 == false) goto L6;
        r0.b.setAlpha(1.0f);
        r0.c.setAlpha(1.0f);
        r0.d.setAlpha(1.0f);
    L7:
        Unit r4 = Unit.INSTANCE;
        return;
    L6:
        r0.b.setAlpha(0.5f);
        r0.c.setAlpha(0.5f);
        r0.d.setAlpha(0.5f);
        goto L7
    }

    public final void aa0(boolean r6) {
        LarusDialogBotSuggestsEditPanelBinding r0 = this.d;
        if (r0 == null) goto L21;
        r0.b.setFocusableInTouchMode(r6);
        r0.c.setFocusableInTouchMode(r6);
        r0.d.setFocusableInTouchMode(r6);
        r0.b.setFocusable(r6);
        r0.c.setFocusable(r6);
        r0.d.setFocusable(r6);
        r0.b.setLongClickable(r6);
        r0.c.setLongClickable(r6);
        r0.d.setLongClickable(r6);
        if (r6 == false) goto L7;
        r0.b.setInputType(524288);
        r0.c.setInputType(524288);
        r0.d.setInputType(524288);
    L19:
        Unit r7 = Unit.INSTANCE;
        return;
    L7:
        LarusDialogBotSuggestsEditPanelBinding r8 = this.d;
        if (r8 == null) goto L18;
        Context r2 = getContext();
        InputMethodManager r3 = null;
        if (r2 == null) goto L12;
        Object r4 = r2.getSystemService("input_method");
    L14:
        if ((r4 instanceof InputMethodManager) == false) goto L16;
        r3 = (InputMethodManager) r4;
    L16:
        if (r3 == null) goto L18;
        r3.hideSoftInputFromWindow(r8.b.getWindowToken(), 0);
        goto L18
    L12:
        r4 = null;
    L18:
        r0.b.setInputType(0);
        r0.c.setInputType(0);
        r0.d.setInputType(0);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r12v8, types: [bv8.i] */
    public final void onViewCreated(final View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        final Ref.IntRef r4 = new Ref.IntRef();
        Dialog r13 = getDialog();
        if (r13 == null) goto L5;
        r13.setOnShowListener(new bv8.a(this, r4));
    L5:
        LarusDialogBotSuggestsEditPanelBinding r14 = this.d;
        if (r14 == null) goto L33;
        r14.e.getToggleView().setChecked(S90());
        r14.e.getToggleView().setOnCheckedChangeListener(new bv8.b(this));
        final Context r0 = getContext();
        boolean r1 = true;
        if (r0 == null) goto L10;
        r14.b.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r0.getResources().getInteger(2131427367), new bv8.c(this, r0))});
        r14.c.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r0.getResources().getInteger(2131427367), new bv8.d(this, r0))});
        r14.d.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r0.getResources().getInteger(2131427367), new bv8.e(this, r0))});
    L10:
        Z90(S90());
        if (S90() == true) goto L13;
    L15:
        r1 = false;
    L16:
        aa0(r1);
        W90(T90());
        r14.b.addTextChangedListener(new d(this));
        r14.c.addTextChangedListener(new e(this));
        r14.d.addTextChangedListener(new f(this));
        r14.b.setOnFocusChangeListener(new bv8.f(this));
        r14.c.setOnFocusChangeListener(new bv8.g(this));
        r14.d.setOnFocusChangeListener(new h(this));
        V90(U90());
        ViewTreeObserver r15 = r14.a.getViewTreeObserver();
        if (r15 == null) goto L20;
        r15.addOnGlobalLayoutListener(this.i);
    L20:
        if (this.e == false) goto L34;
        final Ref.IntRef r5 = new Ref.IntRef();
        final Ref.IntRef r6 = new Ref.IntRef();
        if (r11.isAttachedToWindow() == false) goto L30;
        WindowInsetsCompat r16 = ViewCompat.getRootWindowInsets(r11);
        if (r16 == null) goto L28;
        Insets r17 = r16.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r17 == null) goto L28;
        int r18 = r17.bottom;
    L29:
        r5.element = r18;
    L31:
        ViewExtKt.n(r11, null, new i(r11, this, r4, r5, r6), null, 5);
        return;
    L28:
        r18 = r5.element;
        goto L29
    L30:
        r11.addOnAttachStateChangeListener(new g(r11, r5, r11));
        goto L31
    L34:
        return;
    L13:
        if (U90() == true) goto L15;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562040, r8, false);
        int r11 = 2131387699;
        AppCompatEditText r2 = ViewBindings.findChildViewById(r10, 2131387699);
        if (r2 == null) goto L13;
        r11 = 2131387700;
        AppCompatEditText r3 = ViewBindings.findChildViewById(r10, 2131387700);
        if (r3 == null) goto L13;
        r11 = 2131387701;
        AppCompatEditText r4 = ViewBindings.findChildViewById(r10, 2131387701);
        if (r4 == null) goto L13;
        r11 = 2131387704;
        ItemTextToggle r5 = (ItemTextToggle) ViewBindings.findChildViewById(r10, 2131387704);
        if (r5 == null) goto L13;
        LinearLayout r12 = (LinearLayout) r10;
        this.d = new LarusDialogBotSuggestsEditPanelBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
