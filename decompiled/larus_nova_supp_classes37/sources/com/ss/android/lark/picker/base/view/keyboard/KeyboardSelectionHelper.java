package com.ss.android.lark.picker.base.view.keyboard;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010\u001c\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper;", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText$KeyboardSelectionDependency;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "editText", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;Lcom/suite/lark/emm/autofocus/AutoFocusEditText;)V", "editTextRef", "Ljava/lang/ref/WeakReference;", "value", "getEditText", "()Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "setEditText", "(Lcom/suite/lark/emm/autofocus/AutoFocusEditText;)V", "onNext", "", "onPrev", "onSelect", "setupKeyboardNavigation", "reset", "", "handleScroll", "delta", "", "triggerItemClick", "cleanup", "Companion", "GlobalKeyboardDispatcher", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class KeyboardSelectionHelper implements AutoFocusEditText.b {
    public static final Companion Companion = null;
    private static final int DEFAULT_VISIBLE_THRESHOLD = 1;
    private static final String TAG = "KeyboardSelectionHelper";
    private static WeakReference<AutoFocusEditText> currentActiveEditText;
    private static WeakReference<KeyboardSelectionHelper> currentActiveHelper;
    private static GlobalKeyboardDispatcher globalKeyboardDispatcher;
    private final KeyboardSelectionAdapter<?, ?> adapter;
    private WeakReference<AutoFocusEditText> editTextRef;
    private RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_VISIBLE_THRESHOLD", "", "currentActiveHelper", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper;", "currentActiveEditText", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "globalKeyboardDispatcher", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$GlobalKeyboardDispatcher;", "getInstance", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "editText", "setActiveHelper", "", "helper", "getCurrentActiveHelper", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KeyboardSelectionHelper getCurrentActiveHelper() {
            WeakReference r0 = KeyboardSelectionHelper.access$getCurrentActiveHelper$cp();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (KeyboardSelectionHelper) r0.get();
        }

        private final void setActiveHelper(KeyboardSelectionHelper r4, AutoFocusEditText r5) {
            WeakReference r0 = KeyboardSelectionHelper.access$getCurrentActiveEditText$cp();
            if (r0 == null) goto L5;
            AutoFocusEditText r1 = (AutoFocusEditText) r0.get();
        L6:
            WeakReference r2 = KeyboardSelectionHelper.access$getCurrentActiveHelper$cp();
            if (r2 == null) goto L10;
            KeyboardSelectionHelper r3 = (KeyboardSelectionHelper) r2.get();
        L10:
            if (r1 == null) goto L13;
            if (r1 == r5) goto L13;
            KeyboardSelectionHelperKt.disableKeyboardSelection(r1);
            Log.d(KeyboardSelectionHelper.TAG, "disable previous KeyboardSelection");
        L13:
            KeyboardSelectionHelper.access$setCurrentActiveHelper$cp(new WeakReference(r4));
            KeyboardSelectionHelper.access$setCurrentActiveEditText$cp(new WeakReference(r5));
            if (r1 == r5) goto L16;
            KeyboardSelectionHelper.access$setGlobalKeyboardDispatcher$cp(new GlobalKeyboardDispatcher());
            r5.a(KeyboardSelectionHelper.access$getGlobalKeyboardDispatcher$cp());
            Log.d(KeyboardSelectionHelper.TAG, "enable new KeyboardSelection");
        L16:
            Log.d(KeyboardSelectionHelper.TAG, "KeyboardSelection is update");
            return;
        L5:
            r1 = null;
            goto L6
        }

        public static final /* synthetic */ void access$setActiveHelper(Companion r0, KeyboardSelectionHelper r1, AutoFocusEditText r2) {
            r0.setActiveHelper(r1, r2);
        }

        @JvmStatic
        public final KeyboardSelectionHelper getInstance(RecyclerView r4, KeyboardSelectionAdapter<?, ?> r5, AutoFocusEditText r6) {
            Intrinsics.checkNotNullParameter(r4, "recyclerView");
            Intrinsics.checkNotNullParameter(r5, "adapter");
            KeyboardSelectionHelper r0 = r5.getHelper();
            if (r0 == null) goto L10;
            Log.d(KeyboardSelectionHelper.TAG, "get existing helper");
            if (Intrinsics.areEqual(r0.getEditText(), r6) == true) goto L7;
            r0.setEditText(r6);
            r0.setupKeyboardNavigation(false);
        L7:
            if (r6 == null) goto L9;
            setActiveHelper(r0, r6);
            Log.d(KeyboardSelectionHelper.TAG, "existing helper active");
        L9:
            return r0;
        L10:
            Log.d(KeyboardSelectionHelper.TAG, "create new helper");
            KeyboardSelectionHelper r1 = new KeyboardSelectionHelper(r4, r5, r6, null);
            r5.setHelper(r1);
            if (r6 == null) goto L13;
            Log.d(KeyboardSelectionHelper.TAG, "new helper active");
            KeyboardSelectionHelper.Companion.setActiveHelper(r1, r6);
        L13:
            return r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper$GlobalKeyboardDispatcher;", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText$KeyboardSelectionDependency;", "<init>", "()V", "onNext", "", "onPrev", "onSelect", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class GlobalKeyboardDispatcher implements AutoFocusEditText.b {
        public GlobalKeyboardDispatcher() {
        }

        public void onNext() {
            KeyboardSelectionHelper r0 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r0 == null) goto L6;
            r0.onNext();
            return;
        }

        public void onPrev() {
            KeyboardSelectionHelper r0 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r0 == null) goto L6;
            r0.onPrev();
            return;
        }

        public void onSelect() {
            KeyboardSelectionHelper r0 = KeyboardSelectionHelper.Companion.getCurrentActiveHelper();
            if (r0 == null) goto L6;
            r0.onSelect();
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KeyboardSelectionHelper(RecyclerView r1, KeyboardSelectionAdapter r2, AutoFocusEditText r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    @JvmStatic
    public static final KeyboardSelectionHelper getInstance(RecyclerView r1, KeyboardSelectionAdapter<?, ?> r2, AutoFocusEditText r3) {
        return Companion.getInstance(r1, r2, r3);
    }

    public void onNext() {
        handleScroll(1);
    }

    public void onPrev() {
        handleScroll(-1);
    }

    private final void triggerItemClick() {
        Log.i(TAG, "handleKeyEvent : triggerItemClick");
        int r0 = this.adapter.getSelectedPosition();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.adapter.getItemCount()) goto L16;
        RecyclerView.ViewHolder r1 = this.recyclerView.findViewHolderForAdapterPosition(r0);
        if (r1 == null) goto L10;
        View r2 = r1.itemView;
    L11:
        if (r2 == null) goto L15;
        r2.performClick();
        return;
    L15:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void cleanup() {
        WeakReference<KeyboardSelectionHelper> r0 = currentActiveHelper;
        if (r0 == null) goto L5;
        KeyboardSelectionHelper r1 = r0.get();
    L6:
        if (r1 != this) goto L13;
        WeakReference<AutoFocusEditText> r2 = currentActiveEditText;
        if (r2 == null) goto L12;
        AutoFocusEditText r3 = r2.get();
        if (r3 == null) goto L12;
        KeyboardSelectionHelperKt.disableKeyboardSelection(r3);
    L12:
        currentActiveHelper = null;
        currentActiveEditText = null;
        globalKeyboardDispatcher = null;
    L13:
        setEditText(null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final AutoFocusEditText getEditText() {
        return this.editTextRef.get();
    }

    public static final /* synthetic */ WeakReference access$getCurrentActiveEditText$cp() {
        return currentActiveEditText;
    }

    public static final /* synthetic */ WeakReference access$getCurrentActiveHelper$cp() {
        return currentActiveHelper;
    }

    public static final /* synthetic */ GlobalKeyboardDispatcher access$getGlobalKeyboardDispatcher$cp() {
        return globalKeyboardDispatcher;
    }

    public void onSelect() {
        triggerItemClick();
    }

    public static final /* synthetic */ void access$setCurrentActiveEditText$cp(WeakReference r0) {
        currentActiveEditText = r0;
    }

    public static final /* synthetic */ void access$setCurrentActiveHelper$cp(WeakReference r0) {
        currentActiveHelper = r0;
    }

    public static final /* synthetic */ void access$setGlobalKeyboardDispatcher$cp(GlobalKeyboardDispatcher r0) {
        globalKeyboardDispatcher = r0;
    }

    private final void handleScroll(int r7) {
        this.adapter.updateSelectedState(r7);
        LinearLayoutManager r0 = this.recyclerView.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        if (r1 == null) goto L25;
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
        Log.d("KeyboardNav", "Visible threshold set to: 1");
        if (this.adapter.getSelectedPosition() > r2) goto L12;
        Log.d("KeyboardNav", "Case: Before first visible");
    L10:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        this.recyclerView.smoothScrollToPosition(this.adapter.getSelectedPosition());
        return;
    L17:
        if (r7 == (-1)) goto L21;
        if (r7 == 1) goto L20;
        int r8 = this.adapter.getSelectedPosition();
    L22:
        Log.d("KeyboardNav", "Adjusting to target position: " + r8);
        this.recyclerView.smoothScrollToPosition(r8);
        return;
    L20:
        r8 = Math.max(0, this.adapter.getSelectedPosition() + 1);
        goto L22
    L21:
        r8 = Math.max(0, this.adapter.getSelectedPosition() - 1);
        goto L22
    L12:
        if (this.adapter.getSelectedPosition() <= (r3 - 1)) goto L14;
        Log.d("KeyboardNav", "Case: At/After threshold position");
        goto L10
    L14:
        Log.d("KeyboardNav", "Case: Within safe zone");
        r4 = false;
        goto L15
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setEditText(AutoFocusEditText r2) {
        this.editTextRef = new WeakReference(r2);
    }

    public final void setupKeyboardNavigation(boolean r3) {
        AutoFocusEditText r0 = getEditText();
        if (r0 == null) goto L5;
        Companion.access$setActiveHelper(Companion, this, r0);
    L5:
        if (r3 == false) goto L8;
        this.adapter.resetSelectPosition();
        return;
    }

    private KeyboardSelectionHelper(RecyclerView r1, KeyboardSelectionAdapter<?, ?> r2, AutoFocusEditText r3) {
        this.recyclerView = r1;
        this.adapter = r2;
        this.editTextRef = new WeakReference(r3);
        setupKeyboardNavigation(true);
    }
}
