package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId;
    private int mVirtualDescendantId;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COLLAPSE = null;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COPY = null;
        public static final AccessibilityActionCompat ACTION_CUT = null;
        public static final AccessibilityActionCompat ACTION_DISMISS = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_DROP = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final AccessibilityActionCompat ACTION_PASTE = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = null;
        public static final AccessibilityActionCompat ACTION_SELECT = null;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS = null;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_SET_TEXT = null;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction r10 = null;
            ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            ACTION_SELECT = new AccessibilityActionCompat(4, null);
            ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            ACTION_CLICK = new AccessibilityActionCompat(16, null);
            ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
            ACTION_COPY = new AccessibilityActionCompat(16384, null);
            ACTION_PASTE = new AccessibilityActionCompat(32768, null);
            ACTION_CUT = new AccessibilityActionCompat(65536, null);
            ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
            ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
            ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, AccessibilityViewCommand.SetTextArguments.class);
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 23) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        L6:
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(r12, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (r11 < 23) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        L10:
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(r13, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (r11 < 23) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        L14:
            ACTION_SCROLL_UP = new AccessibilityActionCompat(r14, R.id.accessibilityActionScrollUp, null, null, null);
            if (r11 < 23) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        L18:
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(r15, R.id.accessibilityActionScrollLeft, null, null, null);
            if (r11 < 23) goto L21;
            AccessibilityNodeInfo.AccessibilityAction r16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        L22:
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(r16, R.id.accessibilityActionScrollDown, null, null, null);
            if (r11 < 23) goto L25;
            AccessibilityNodeInfo.AccessibilityAction r17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        L26:
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(r17, R.id.accessibilityActionScrollRight, null, null, null);
            if (r11 < 29) goto L29;
            AccessibilityNodeInfo.AccessibilityAction r18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        L30:
            ACTION_PAGE_UP = new AccessibilityActionCompat(r18, R.id.accessibilityActionPageUp, null, null, null);
            if (r11 < 29) goto L33;
            AccessibilityNodeInfo.AccessibilityAction r19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        L34:
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(r19, R.id.accessibilityActionPageDown, null, null, null);
            if (r11 < 29) goto L37;
            AccessibilityNodeInfo.AccessibilityAction r20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        L38:
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(r20, R.id.accessibilityActionPageLeft, null, null, null);
            if (r11 < 29) goto L41;
            AccessibilityNodeInfo.AccessibilityAction r110 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        L42:
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(r110, R.id.accessibilityActionPageRight, null, null, null);
            if (r11 < 23) goto L45;
            AccessibilityNodeInfo.AccessibilityAction r21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        L46:
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(r21, R.id.accessibilityActionContextClick, null, null, null);
            if (r11 < 24) goto L49;
            AccessibilityNodeInfo.AccessibilityAction r111 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        L50:
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(r111, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (r11 < 26) goto L53;
            AccessibilityNodeInfo.AccessibilityAction r22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        L54:
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(r22, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (r11 < 28) goto L57;
            AccessibilityNodeInfo.AccessibilityAction r112 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        L58:
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(r112, R.id.accessibilityActionShowTooltip, null, null, null);
            if (r11 < 28) goto L61;
            AccessibilityNodeInfo.AccessibilityAction r23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        L62:
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(r23, R.id.accessibilityActionHideTooltip, null, null, null);
            if (r11 < 30) goto L65;
            AccessibilityNodeInfo.AccessibilityAction r113 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        L66:
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(r113, R.id.accessibilityActionPressAndHold, null, null, null);
            if (r11 < 30) goto L69;
            AccessibilityNodeInfo.AccessibilityAction r24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        L70:
            ACTION_IME_ENTER = new AccessibilityActionCompat(r24, R.id.accessibilityActionImeEnter, null, null, null);
            if (r11 < 32) goto L73;
            AccessibilityNodeInfo.AccessibilityAction r114 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L74:
            ACTION_DRAG_START = new AccessibilityActionCompat(r114, R.id.accessibilityActionDragStart, null, null, null);
            if (r11 < 32) goto L77;
            AccessibilityNodeInfo.AccessibilityAction r25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L78:
            ACTION_DRAG_DROP = new AccessibilityActionCompat(r25, R.id.accessibilityActionDragDrop, null, null, null);
            if (r11 < 32) goto L81;
            AccessibilityNodeInfo.AccessibilityAction r115 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L82:
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(r115, R.id.accessibilityActionDragCancel, null, null, null);
            if (r11 < 33) goto L85;
            r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L85:
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(r10, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            return;
        L81:
            r115 = null;
            goto L82
        L77:
            r25 = null;
            goto L78
        L73:
            r114 = null;
            goto L74
        L69:
            r24 = null;
            goto L70
        L65:
            r113 = null;
            goto L66
        L61:
            r23 = null;
            goto L62
        L57:
            r112 = null;
            goto L58
        L53:
            r22 = null;
            goto L54
        L49:
            r111 = null;
            goto L50
        L45:
            r21 = null;
            goto L46
        L41:
            r110 = null;
            goto L42
        L37:
            r20 = null;
            goto L38
        L33:
            r19 = null;
            goto L34
        L29:
            r18 = null;
            goto L30
        L25:
            r17 = null;
            goto L26
        L21:
            r16 = null;
            goto L22
        L17:
            r15 = null;
            goto L18
        L13:
            r14 = null;
            goto L14
        L9:
            r13 = null;
            goto L10
        L5:
            r12 = null;
            goto L6
        }

        public AccessibilityActionCompat(int r10, CharSequence r11) {
            this(null, r10, r11, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int r10, CharSequence r11, AccessibilityViewCommand r12) {
            this(null, r10, r11, r12, null);
        }

        private AccessibilityActionCompat(int r10, CharSequence r11, Class<? extends AccessibilityViewCommand.CommandArguments> r12) {
            this(null, r10, r11, null, r12);
        }

        AccessibilityActionCompat(Object r10) {
            this(r10, 0, null, null, null);
        }

        AccessibilityActionCompat(Object r10, int r11, CharSequence r12, AccessibilityViewCommand r13, Class<? extends AccessibilityViewCommand.CommandArguments> r14) {
            this.mId = r11;
            this.mCommand = r13;
            if (Build.VERSION.SDK_INT < 21) goto L6;
            if (r10 != null) goto L6;
            r10 = new AccessibilityNodeInfo.AccessibilityAction(r11, r12);
        L6:
            this.mAction = r10;
            this.mViewCommandArgumentClass = r14;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence r10, AccessibilityViewCommand r11) {
            return new AccessibilityActionCompat(null, this.mId, r10, r11, this.mViewCommandArgumentClass);
        }

        public boolean equals(@Nullable Object r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            if ((r10 instanceof AccessibilityActionCompat) == true) goto L8;
            return false;
        L8:
            AccessibilityActionCompat r11 = (AccessibilityActionCompat) r10;
            Object r12 = this.mAction;
            if (r12 != null) goto L14;
            if (r11.mAction == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r12.equals(r11.mAction) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public int getId() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return null;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object r10 = this.mAction;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View r10, Bundle r11) {
            if (this.mCommand == null) goto L19;
            AccessibilityViewCommand.CommandArguments r12 = null;
            Class<? extends AccessibilityViewCommand.CommandArguments> r13 = this.mViewCommandArgumentClass;
            if (r13 == null) goto L18;
            AccessibilityViewCommand.CommandArguments r14 = r13.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
            r14.setBundle(r11);     // Catch: Exception -> L9
            r12 = r14;
        L9:
            e = e;
            r12 = r14;
        L12:
            Class<? extends AccessibilityViewCommand.CommandArguments> r15 = this.mViewCommandArgumentClass;
            if (r15 != null) goto L15;
            String r16 = "null";
        L16:
            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + r16, e);
            goto L18
        L15:
            r16 = r15.getName();
        L11:
            e = e;
        L18:
            return this.mCommand.perform(r10, r12);
        L19:
            return false;
        }

        @NonNull
        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("AccessibilityActionCompat: ");
            String r11 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (r11.equals("ACTION_UNKNOWN") == true) goto L5;
        L7:
            r10.append(r11);
            return r10.toString();
        L5:
            if (getLabel() == null) goto L7;
            r11 = getLabel().toString();
            goto L7
        }
    }

    @RequiresApi(19)
    private static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static Bundle getExtras(AccessibilityNodeInfo r10) {
            return r10.getExtras();
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo r10) {
            return r10.getExtraRenderingInfo();
        }

        @DoNotInline
        public static boolean isTextSelectable(AccessibilityNodeInfo r10) {
            return r10.isTextSelectable();
        }

        @DoNotInline
        public static void setTextSelectable(AccessibilityNodeInfo r10, boolean r11) {
            r10.setTextSelectable(r11);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object r10) {
            this.mInfo = r10;
        }

        public static CollectionInfoCompat obtain(int r10, int r11, boolean r12) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r10, r11, r12));
        L7:
            return new CollectionInfoCompat(null);
        }

        public static CollectionInfoCompat obtain(int r10, int r11, boolean r12, int r13) {
            int r14 = Build.VERSION.SDK_INT;
            if (r14 < 21) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r10, r11, r12, r13));
        L7:
            if (r14 < 19) goto L11;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r10, r11, r12));
        L11:
            return new CollectionInfoCompat(null);
        }

        public int getColumnCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        CollectionItemInfoCompat(Object r10) {
            this.mInfo = r10;
        }

        public static CollectionItemInfoCompat obtain(int r10, int r11, int r12, int r13, boolean r14) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r10, r11, r12, r13, r14));
        L7:
            return new CollectionItemInfoCompat(null);
        }

        public static CollectionItemInfoCompat obtain(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
            int r16 = Build.VERSION.SDK_INT;
            if (r16 < 21) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r10, r11, r12, r13, r14, r15));
        L7:
            if (r16 < 19) goto L11;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r10, r11, r12, r13, r14));
        L11:
            return new CollectionItemInfoCompat(null);
        }

        public int getColumnIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public int getRowIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Deprecated
        public boolean isHeading() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object r10) {
            this.mInfo = r10;
        }

        public static RangeInfoCompat obtain(int r10, float r11, float r12, float r13) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r10, r11, r12, r13));
        L7:
            return new RangeInfoCompat(null);
        }

        public float getCurrent() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo r10) {
            this.mInfo = r10;
        }

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> r10) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r10);
            return;
        L5:
            this.mInfo = null;
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int r10) {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return null;
        L5:
            return this.mInfo.getRegionAt(r10);
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return 0;
        L5:
            return this.mInfo.getRegionCount();
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region r10) {
            if (Build.VERSION.SDK_INT < 29) goto L8;
            AccessibilityNodeInfo r11 = this.mInfo.getTargetForRegion(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return AccessibilityNodeInfoCompat.wrap(r11);
        L8:
            return null;
        }
    }

    static {
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r10) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r10;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object r10) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) r10;
    }

    private void addSpanLocationToExtras(ClickableSpan r10, Spanned r11, int r12) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(r11.getSpanStart(r10)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(r11.getSpanEnd(r10)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(r11.getSpanFlags(r10)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(r12));
    }

    private void clearExtrasSpans() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.getExtras(this.mInfo).remove(SPANS_START_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_END_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_FLAGS_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_ID_KEY);
        return;
    }

    private List<Integer> extrasIntList(String r10) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        ArrayList<Integer> r11 = Api19Impl.getExtras(this.mInfo).getIntegerArrayList(r10);
        if (r11 != null) goto L10;
        ArrayList<Integer> r12 = new ArrayList();
        Api19Impl.getExtras(this.mInfo).putIntegerArrayList(r10, r12);
        return r12;
    L10:
        return r11;
    L5:
        return new ArrayList();
    }

    static String getActionSymbolicName(int r10) {
        if (r10 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r10 == 2) goto L90;
        switch(r10) {
            case 4: goto L88;
            case 8: goto L86;
            case 16: goto L84;
            case 32: goto L82;
            case 64: goto L80;
            case 128: goto L78;
            case 256: goto L76;
            case 512: goto L74;
            case 1024: goto L72;
            case 2048: goto L70;
            case 4096: goto L68;
            case 8192: goto L66;
            case 16384: goto L64;
            case 32768: goto L62;
            case 65536: goto L60;
            case 131072: goto L58;
            case 262144: goto L56;
            case 524288: goto L54;
            case 2097152: goto L52;
            case 16908354: goto L50;
            default: goto L7;
        };
    L7:
        switch(r10) {
            case 16908342: goto L48;
            case 16908343: goto L46;
            case 16908344: goto L44;
            case 16908345: goto L42;
            case 16908346: goto L40;
            case 16908347: goto L38;
            case 16908348: goto L36;
            case 16908349: goto L34;
            default: goto L8;
        };
    L8:
        switch(r10) {
            case 16908356: goto L32;
            case 16908357: goto L30;
            case 16908358: goto L28;
            case 16908359: goto L26;
            case 16908360: goto L24;
            case 16908361: goto L22;
            case 16908362: goto L20;
            default: goto L9;
        };
    L9:
        switch(r10) {
            case 16908372: goto L18;
            case 16908373: goto L16;
            case 16908374: goto L14;
            case 16908375: goto L12;
            default: goto L10;
        };
    L10:
        return "ACTION_UNKNOWN";
    L12:
        return "ACTION_DRAG_CANCEL";
    L14:
        return "ACTION_DRAG_DROP";
    L16:
        return "ACTION_DRAG_START";
    L18:
        return "ACTION_IME_ENTER";
    L20:
        return "ACTION_PRESS_AND_HOLD";
    L22:
        return "ACTION_PAGE_RIGHT";
    L24:
        return "ACTION_PAGE_LEFT";
    L26:
        return "ACTION_PAGE_DOWN";
    L28:
        return "ACTION_PAGE_UP";
    L30:
        return "ACTION_HIDE_TOOLTIP";
    L32:
        return "ACTION_SHOW_TOOLTIP";
    L34:
        return "ACTION_SET_PROGRESS";
    L36:
        return "ACTION_CONTEXT_CLICK";
    L38:
        return "ACTION_SCROLL_RIGHT";
    L40:
        return "ACTION_SCROLL_DOWN";
    L42:
        return "ACTION_SCROLL_LEFT";
    L44:
        return "ACTION_SCROLL_UP";
    L46:
        return "ACTION_SCROLL_TO_POSITION";
    L48:
        return "ACTION_SHOW_ON_SCREEN";
    L50:
        return "ACTION_MOVE_WINDOW";
    L52:
        return "ACTION_SET_TEXT";
    L54:
        return "ACTION_COLLAPSE";
    L56:
        return "ACTION_EXPAND";
    L58:
        return "ACTION_SET_SELECTION";
    L60:
        return "ACTION_CUT";
    L62:
        return "ACTION_PASTE";
    L64:
        return "ACTION_COPY";
    L66:
        return "ACTION_SCROLL_BACKWARD";
    L68:
        return "ACTION_SCROLL_FORWARD";
    L70:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L72:
        return "ACTION_NEXT_HTML_ELEMENT";
    L74:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L76:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L80:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_LONG_CLICK";
    L84:
        return "ACTION_CLICK";
    L86:
        return "ACTION_CLEAR_SELECTION";
    L88:
        return "ACTION_SELECT";
    L90:
        return "ACTION_CLEAR_FOCUS";
    }

    private boolean getBooleanProperty(int r10) {
        Bundle r11 = getExtras();
        if (r11 != null) goto L6;
        return false;
    L6:
        if ((r11.getInt(BOOLEAN_PROPERTY_KEY, 0) & r10) != r10) goto L9;
        return true;
    L9:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence r10) {
        if ((r10 instanceof Spanned) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ((Spanned) r10).getSpans(0, r10.length(), ClickableSpan.class);
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View r10) {
        SparseArray<WeakReference<ClickableSpan>> r11 = getSpansFromViewTags(r10);
        if (r11 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r12 = new SparseArray();
        r10.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, r12);
        return r12;
    L6:
        return r11;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View r10) {
        return (SparseArray) r10.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan r10, SparseArray<WeakReference<ClickableSpan>> r11) {
        if (r11 == null) goto L11;
        int r12 = 0;
    L5:
        if (r12 >= r11.size()) goto L11;
        if (r10.equals(r11.valueAt(r12).get()) == true) goto L9;
        r12 = r12 + 1;
        goto L5
    L9:
        return r11.keyAt(r12);
    L11:
        int r13 = sClickableSpanId;
        sClickableSpanId = r13 + 1;
        return r13;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View r10) {
        return wrap(AccessibilityNodeInfo.obtain(r10));
    }

    public static AccessibilityNodeInfoCompat obtain(View r10, int r11) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r10, r11));
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r10) {
        return wrap(AccessibilityNodeInfo.obtain(r10.mInfo));
    }

    private void removeCollectedSpans(View r10) {
        SparseArray<WeakReference<ClickableSpan>> r11 = getSpansFromViewTags(r10);
        if (r11 == null) goto L14;
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r11.size()) goto L12;
        if (r11.valueAt(r14).get() != null) goto L10;
        r12.add(Integer.valueOf(r14));
    L10:
        r14 = r14 + 1;
    L12:
        if (r13 >= r12.size()) goto L19;
        r11.remove(((Integer) r12.get(r13)).intValue());
        r13 = r13 + 1;
        goto L12
    L19:
        return;
    }

    private void setBooleanProperty(int r10, boolean r11) {
        Bundle r12 = getExtras();
        if (r12 == null) goto L10;
        int r13 = r12.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~r10);
        if (r11 == true) goto L8;
        r10 = 0;
    L8:
        r12.putInt(BOOLEAN_PROPERTY_KEY, r10 | r13);
        return;
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo r10) {
        return new AccessibilityNodeInfoCompat(r10);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r10);
    }

    public void addAction(int r10) {
        this.mInfo.addAction(r10);
    }

    public void addAction(AccessibilityActionCompat r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) r10.mAction);
        return;
    }

    public void addChild(View r10) {
        this.mInfo.addChild(r10);
    }

    public void addChild(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.addChild(r10, r11);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence r10, View r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 19) goto L5;
        return;
    L5:
        if (r12 >= 26) goto L16;
        clearExtrasSpans();
        removeCollectedSpans(r11);
        ClickableSpan[] r13 = getClickableSpans(r10);
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.length <= 0) goto L18;
        getExtras().putInt(SPANS_ACTION_ID_KEY, androidx.core.R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> r14 = getOrCreateSpansFromViewTags(r11);
        int r15 = 0;
    L12:
        if (r15 >= r13.length) goto L19;
        int r16 = idForClickableSpan(r13[r15], r14);
        r14.put(r16, new WeakReference(r13[r15]));
        addSpanLocationToExtras(r13[r15], (Spanned) r10, r16);
        r15 = r15 + 1;
        goto L12
    L19:
        return;
    L18:
        return;
    }

    public boolean canOpenPopup() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof AccessibilityNodeInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r11 = (AccessibilityNodeInfoCompat) r10;
        AccessibilityNodeInfo r12 = this.mInfo;
        if (r12 != null) goto L17;
        if (r11.mInfo == null) goto L20;
        return false;
    L20:
        if (this.mVirtualDescendantId == r11.mVirtualDescendantId) goto L23;
        return false;
    L23:
        if (this.mParentVirtualDescendantId == r11.mParentVirtualDescendantId) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r12.equals(r11.mInfo) == true) goto L20;
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r10) {
        ArrayList r11 = new ArrayList();
        List<AccessibilityNodeInfo> r12 = this.mInfo.findAccessibilityNodeInfosByText(r10);
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(wrap(r12.get(r14)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r10) {
        if (Build.VERSION.SDK_INT < 18) goto L10;
        List<AccessibilityNodeInfo> r11 = this.mInfo.findAccessibilityNodeInfosByViewId(r10);
        ArrayList r12 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12.add(wrap(r13.next()));
        goto L6
    L8:
        return r12;
    L10:
        return Collections.emptyList();
    }

    public AccessibilityNodeInfoCompat findFocus(int r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.findFocus(r10));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.focusSearch(r10));
    }

    public List<AccessibilityActionCompat> getActionList() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        List<AccessibilityNodeInfo.AccessibilityAction> r10 = this.mInfo.getActionList();
    L6:
        if (r10 == null) goto L12;
        ArrayList r11 = new ArrayList();
        int r12 = r10.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        r11.add(new AccessibilityActionCompat(r10.get(r13)));
        r13 = r13 + 1;
        goto L8
    L10:
        return r11;
    L12:
        return Collections.emptyList();
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getAvailableExtraData();
    L7:
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect r10) {
        this.mInfo.getBoundsInParent(r10);
    }

    public void getBoundsInScreen(Rect r10) {
        this.mInfo.getBoundsInScreen(r10);
    }

    public AccessibilityNodeInfoCompat getChild(int r10) {
        return wrapNonNullInstance(this.mInfo.getChild(r10));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionInfo r10 = this.mInfo.getCollectionInfo();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new CollectionInfoCompat(r10);
    L8:
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionItemInfo r10 = this.mInfo.getCollectionItemInfo();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new CollectionItemInfoCompat(r10);
    L8:
        return null;
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 0;
    L5:
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return this.mInfo.getError();
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return null;
    L5:
        return Api33Impl.getExtraRenderingInfo(this.mInfo);
    }

    public Bundle getExtras() {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExtras(this.mInfo);
    L7:
        return new Bundle();
    }

    @Nullable
    public CharSequence getHintText() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 26) goto L7;
        return this.mInfo.getHintText();
    L7:
        if (r10 >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(HINT_TEXT_KEY);
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getExtras(this.mInfo).getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    public int getMovementGranularities() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L7;
        return this.mInfo.getPaneTitle();
    L7:
        if (r10 >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.RangeInfo r10 = this.mInfo.getRangeInfo();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new RangeInfoCompat(r10);
    L8:
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        if (BuildCompat.isAtLeastR() == false) goto L7;
        return this.mInfo.getStateDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (hasSpans() == false) goto L10;
        List<Integer> r10 = extrasIntList(SPANS_START_KEY);
        List<Integer> r11 = extrasIntList(SPANS_END_KEY);
        List<Integer> r12 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> r13 = extrasIntList(SPANS_ID_KEY);
        int r14 = 0;
        SpannableString r15 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
    L6:
        if (r14 >= r10.size()) goto L8;
        r15.setSpan(new AccessibilityClickableSpanCompat(r13.get(r14).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), r10.get(r14).intValue(), r11.get(r14).intValue(), r12.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        return r15;
    L10:
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return -1;
    L5:
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return -1;
    L5:
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L7;
        return this.mInfo.getTooltipText();
    L7:
        if (r10 >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(TOOLTIP_TEXT_KEY);
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        AccessibilityNodeInfo.TouchDelegateInfo r10 = this.mInfo.getTouchDelegateInfo();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new TouchDelegateInfoCompat(r10);
    L8:
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public String getUniqueId() {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return this.mInfo.getUniqueId();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean hasRequestInitialAccessibilityFocus() {
        return getBooleanProperty(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo r10 = this.mInfo;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isHeading();
    L7:
        if (getBooleanProperty(2) == false) goto L9;
        return true;
    L9:
        CollectionItemInfoCompat r10 = getCollectionItemInfo();
        if (r10 != null) goto L12;
    L14:
        return false;
    L12:
        if (r10.isHeading() == false) goto L14;
        return true;
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isScreenReaderFocusable();
    L7:
        return getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.isShowingHintText();
    L7:
        return getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mInfo.isTextEntryKey();
    L7:
        return getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Api33Impl.isTextSelectable(this.mInfo);
    }

    public boolean isVisibleToUser() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int r10) {
        return this.mInfo.performAction(r10);
    }

    public boolean performAction(int r10, Bundle r11) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.performAction(r10, r11);
    }

    @Deprecated
    public void recycle() {
    }

    public boolean refresh() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r10.mAction);
    }

    public boolean removeChild(View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r10);
    }

    public boolean removeChild(View r10, int r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r10, r11);
    }

    public void setAccessibilityFocused(boolean r10) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setAccessibilityFocused(r10);
        return;
    }

    public void setAvailableExtraData(@NonNull List<String> r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mInfo.setAvailableExtraData(r10);
        return;
    }

    @Deprecated
    public void setBoundsInParent(Rect r10) {
        this.mInfo.setBoundsInParent(r10);
    }

    public void setBoundsInScreen(Rect r10) {
        this.mInfo.setBoundsInScreen(r10);
    }

    public void setCanOpenPopup(boolean r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setCanOpenPopup(r10);
        return;
    }

    public void setCheckable(boolean r10) {
        this.mInfo.setCheckable(r10);
    }

    public void setChecked(boolean r10) {
        this.mInfo.setChecked(r10);
    }

    public void setClassName(CharSequence r10) {
        this.mInfo.setClassName(r10);
    }

    public void setClickable(boolean r10) {
        this.mInfo.setClickable(r10);
    }

    public void setCollectionInfo(Object r10) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r11 = this.mInfo;
        if (r10 != null) goto L7;
        AccessibilityNodeInfo.CollectionInfo r12 = null;
    L8:
        r11.setCollectionInfo(r12);
        return;
    L7:
        r12 = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) r10).mInfo;
        goto L8
    }

    public void setCollectionItemInfo(Object r10) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r11 = this.mInfo;
        if (r10 != null) goto L7;
        AccessibilityNodeInfo.CollectionItemInfo r12 = null;
    L8:
        r11.setCollectionItemInfo(r12);
        return;
    L7:
        r12 = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) r10).mInfo;
        goto L8
    }

    public void setContentDescription(CharSequence r10) {
        this.mInfo.setContentDescription(r10);
    }

    public void setContentInvalid(boolean r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setContentInvalid(r10);
        return;
    }

    public void setContextClickable(boolean r10) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mInfo.setContextClickable(r10);
        return;
    }

    public void setDismissable(boolean r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setDismissable(r10);
        return;
    }

    public void setDrawingOrder(int r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setDrawingOrder(r10);
        return;
    }

    public void setEditable(boolean r10) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setEditable(r10);
        return;
    }

    public void setEnabled(boolean r10) {
        this.mInfo.setEnabled(r10);
    }

    public void setError(CharSequence r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setError(r10);
        return;
    }

    public void setFocusable(boolean r10) {
        this.mInfo.setFocusable(r10);
    }

    public void setFocused(boolean r10) {
        this.mInfo.setFocused(r10);
    }

    public void setHeading(boolean r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setHeading(r10);
        return;
    L5:
        setBooleanProperty(2, r10);
    }

    public void setHintText(@Nullable CharSequence r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L6;
        this.mInfo.setHintText(r10);
        return;
    L6:
        if (r11 < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(HINT_TEXT_KEY, r10);
        return;
    }

    public void setImportantForAccessibility(boolean r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setImportantForAccessibility(r10);
        return;
    }

    public void setInputType(int r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setInputType(r10);
        return;
    }

    public void setLabelFor(View r10) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r10);
        return;
    }

    public void setLabelFor(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r10, r11);
        return;
    }

    public void setLabeledBy(View r10) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r10);
        return;
    }

    public void setLabeledBy(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r10, r11);
        return;
    }

    public void setLiveRegion(int r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setLiveRegion(r10);
        return;
    }

    public void setLongClickable(boolean r10) {
        this.mInfo.setLongClickable(r10);
    }

    public void setMaxTextLength(int r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setMaxTextLength(r10);
        return;
    }

    public void setMinDurationBetweenContentChangesMillis(long r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.getExtras(this.mInfo).putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, r10);
        return;
    }

    public void setMovementGranularities(int r10) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setMovementGranularities(r10);
        return;
    }

    public void setMultiLine(boolean r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setMultiLine(r10);
        return;
    }

    public void setPackageName(CharSequence r10) {
        this.mInfo.setPackageName(r10);
    }

    public void setPaneTitle(@Nullable CharSequence r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L6;
        this.mInfo.setPaneTitle(r10);
        return;
    L6:
        if (r11 < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(PANE_TITLE_KEY, r10);
        return;
    }

    public void setParent(View r10) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r10);
    }

    public void setParent(View r10, int r11) {
        this.mParentVirtualDescendantId = r11;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setParent(r10, r11);
        return;
    }

    public void setPassword(boolean r10) {
        this.mInfo.setPassword(r10);
    }

    public void setRangeInfo(RangeInfoCompat r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r10.mInfo);
        return;
    }

    @SuppressLint({"GetterSetterNames"})
    public void setRequestInitialAccessibilityFocus(boolean r10) {
        setBooleanProperty(32, r10);
    }

    public void setRoleDescription(@Nullable CharSequence r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.getExtras(this.mInfo).putCharSequence(ROLE_DESCRIPTION_KEY, r10);
        return;
    }

    public void setScreenReaderFocusable(boolean r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setScreenReaderFocusable(r10);
        return;
    L5:
        setBooleanProperty(1, r10);
    }

    public void setScrollable(boolean r10) {
        this.mInfo.setScrollable(r10);
    }

    public void setSelected(boolean r10) {
        this.mInfo.setSelected(r10);
    }

    public void setShowingHintText(boolean r10) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mInfo.setShowingHintText(r10);
        return;
    L5:
        setBooleanProperty(4, r10);
    }

    public void setSource(View r10) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r10);
    }

    public void setSource(View r10, int r11) {
        this.mVirtualDescendantId = r11;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setSource(r10, r11);
        return;
    }

    public void setStateDescription(@Nullable CharSequence r10) {
        if (BuildCompat.isAtLeastR() == false) goto L6;
        this.mInfo.setStateDescription(r10);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(STATE_DESCRIPTION_KEY, r10);
        return;
    }

    public void setText(CharSequence r10) {
        this.mInfo.setText(r10);
    }

    public void setTextEntryKey(boolean r10) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mInfo.setTextEntryKey(r10);
        return;
    L5:
        setBooleanProperty(8, r10);
    }

    public void setTextSelectable(boolean r10) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.setTextSelectable(this.mInfo, r10);
        return;
    }

    public void setTextSelection(int r10, int r11) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setTextSelection(r10, r11);
        return;
    }

    public void setTooltipText(@Nullable CharSequence r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L6;
        this.mInfo.setTooltipText(r10);
        return;
    L6:
        if (r11 < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(TOOLTIP_TEXT_KEY, r10);
        return;
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat r10) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        this.mInfo.setTouchDelegateInfo(r10.mInfo);
        return;
    }

    public void setTraversalAfter(View r10) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r10);
        return;
    }

    public void setTraversalAfter(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r10, r11);
        return;
    }

    public void setTraversalBefore(View r10) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r10);
        return;
    }

    public void setTraversalBefore(View r10, int r11) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r10, r11);
        return;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public void setUniqueId(@Nullable String r10) {
        if (BuildCompat.isAtLeastT() == false) goto L6;
        this.mInfo.setUniqueId(r10);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putString(UNIQUE_ID_KEY, r10);
        return;
    }

    public void setViewIdResourceName(String r10) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setViewIdResourceName(r10);
        return;
    }

    public void setVisibleToUser(boolean r10) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setVisibleToUser(r10);
        return;
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        Rect r11 = new Rect();
        getBoundsInParent(r11);
        r10.append("; boundsInParent: " + r11);
        getBoundsInScreen(r11);
        r10.append("; boundsInScreen: " + r11);
        r10.append("; packageName: ");
        r10.append(getPackageName());
        r10.append("; className: ");
        r10.append(getClassName());
        r10.append("; text: ");
        r10.append(getText());
        r10.append("; contentDescription: ");
        r10.append(getContentDescription());
        r10.append("; viewId: ");
        r10.append(getViewIdResourceName());
        r10.append("; uniqueId: ");
        r10.append(getUniqueId());
        r10.append("; checkable: ");
        r10.append(isCheckable());
        r10.append("; checked: ");
        r10.append(isChecked());
        r10.append("; focusable: ");
        r10.append(isFocusable());
        r10.append("; focused: ");
        r10.append(isFocused());
        r10.append("; selected: ");
        r10.append(isSelected());
        r10.append("; clickable: ");
        r10.append(isClickable());
        r10.append("; longClickable: ");
        r10.append(isLongClickable());
        r10.append("; enabled: ");
        r10.append(isEnabled());
        r10.append("; password: ");
        r10.append(isPassword());
        r10.append("; scrollable: " + isScrollable());
        r10.append("; [");
        if (Build.VERSION.SDK_INT < 21) goto L16;
        List<AccessibilityActionCompat> r12 = getActionList();
        int r13 = 0;
    L6:
        if (r13 >= r12.size()) goto L21;
        AccessibilityActionCompat r14 = r12.get(r13);
        String r15 = getActionSymbolicName(r14.getId());
        if (r15.equals("ACTION_UNKNOWN") == true) goto L10;
    L12:
        r10.append(r15);
        if (r13 == (r12.size() - 1)) goto L15;
        r10.append(", ");
    L15:
        r13 = r13 + 1;
        goto L6
    L10:
        if (r14.getLabel() == null) goto L12;
        r15 = r14.getLabel().toString();
    L21:
        r10.append("]");
        return r10.toString();
    L16:
        int r16 = getActions();
    L17:
        if (r16 == 0) goto L21;
        int r17 = 1 << Integer.numberOfTrailingZeros(r16);
        r16 = r16 & (~r17);
        r10.append(getActionSymbolicName(r17));
        if (r16 == 0) goto L17;
        r10.append(", ");
        goto L17
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
