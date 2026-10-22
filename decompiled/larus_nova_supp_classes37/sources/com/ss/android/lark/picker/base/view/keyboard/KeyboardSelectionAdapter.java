package com.ss.android.lark.picker.base.view.keyboard;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.fg.PickerFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005:\u0001%B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0016J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000bJ\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0002J\u0006\u0010$\u001a\u00020\u0015R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Data", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelperAware;", "<init>", "()V", "isItemSelectable", "", "position", "", "helper", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionHelper;", "_selectedPosition", "findFirstSelectablePosition", "selectedPosition", "getSelectedPosition", "()I", "getHelper", "setHelper", "", "onBindViewHolder", "holder", "payloads", "", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "updateSelectedState", "direction", "calculateNewPosition", "current", "updateItemStyle", "itemView", "Landroid/view/View;", "isSelected", "resetSelectPosition", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class KeyboardSelectionAdapter<VH extends RecyclerView.ViewHolder, Data> extends LarkRecyclerViewBaseAdapter<VH, Data> implements KeyboardSelectionHelperAware {
    public static final Companion Companion = null;
    private static boolean FG_DISABLE_SELECT_BG = false;
    private static final String TAG = "KeyboardSelectionAdapter";
    private int _selectedPosition;
    private KeyboardSelectionHelper helper;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter$Companion;", "", "<init>", "()V", "TAG", "", "FG_DISABLE_SELECT_BG", "", "getFG_DISABLE_SELECT_BG", "()Z", "setFG_DISABLE_SELECT_BG", "(Z)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean getFG_DISABLE_SELECT_BG() {
            return KeyboardSelectionAdapter.access$getFG_DISABLE_SELECT_BG$cp();
        }

        public final void setFG_DISABLE_SELECT_BG(boolean r1) {
            KeyboardSelectionAdapter.access$setFG_DISABLE_SELECT_BG$cp(r1);
        }
    }

    public abstract boolean isItemSelectable(int r1);

    public final void resetSelectPosition() {
        this._selectedPosition = -1;
    }

    static {
        Companion = new Companion(null);
        FG_DISABLE_SELECT_BG = true;
    }

    public final int getSelectedPosition() {
        int r0 = this._selectedPosition;
        if (r0 >= 0) goto L6;
        return 0;
    L6:
        return r0;
    }

    public KeyboardSelectionAdapter() {
        FG_DISABLE_SELECT_BG = PickerFgUtils.INSTANCE.isDisableItemSelectBg();
        this._selectedPosition = -1;
    }

    private final int findFirstSelectablePosition() {
        int r0 = getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (isItemSelectable(r1) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        Log.i(TAG, "findFirstSelectablePosition: " + r1);
        return r1;
    L9:
        return -1;
    }

    public static final /* synthetic */ boolean access$getFG_DISABLE_SELECT_BG$cp() {
        return FG_DISABLE_SELECT_BG;
    }

    @Override // com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperAware
    public KeyboardSelectionHelper getHelper() {
        return this.helper;
    }

    public static final /* synthetic */ void access$setFG_DISABLE_SELECT_BG$cp(boolean r0) {
        FG_DISABLE_SELECT_BG = r0;
    }

    @Override // com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperAware
    public void setHelper(KeyboardSelectionHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "helper");
        this.helper = r2;
    }

    public final void updateSelectedState(int r6) {
        int r0 = this._selectedPosition;
        int r1 = getItemCount();
        int r2 = 0;
        int r3 = r0;
    L3:
        if (r2 >= r1) goto L8;
        r3 = calculateNewPosition(r3, r6);
        if (isItemSelectable(r3) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        this._selectedPosition = r3;
    L8:
        int r7 = Math.min(r0, this._selectedPosition);
        int r4 = Math.max(r0, this._selectedPosition);
        Log.i(TAG, "updateSelectedState: " + r7 + ", " + r4);
        notifyItemRangeChanged(r7, (r4 - r7) + 1, "selection_update");
    }

    private final int calculateNewPosition(int r1, int r2) {
        int r3 = r1 + r2;
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        if (r3 >= getItemCount()) goto L8;
        return r3;
    L8:
        return getItemCount() - 1;
    }

    private final void updateItemStyle(View r1, boolean r2) {
        r1.setSelected(r2);
    }

    public void onBindViewHolder(VH r6, int r7, List<Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        boolean r1 = false;
        if (this._selectedPosition >= 0) goto L15;
        Integer r0 = Integer.valueOf(findFirstSelectablePosition());
        if (r0.intValue() >= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        this._selectedPosition = r0.intValue();
        goto L15
    L13:
        return;
    L7:
        r3 = false;
    L15:
        if ((!r8.isEmpty()) == false) goto L24;
        View r9 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r7 != getSelectedPosition()) goto L19;
        boolean r2 = true;
    L20:
        r9.setSelected(r2);
        View r10 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r7 != getSelectedPosition()) goto L23;
        r1 = true;
    L23:
        updateItemStyle(r10, r1);
        Log.i(TAG, "onBindViewHolder payloads : " + r7);
        return;
    L19:
        r2 = false;
        goto L20
    L24:
        Log.i(TAG, "onBindViewHolder no payloads: " + r7);
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r6, r7, r8);
        View r11 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r7 != getSelectedPosition()) goto L27;
        r1 = true;
    L27:
        updateItemStyle(r11, r1);
    }
}
