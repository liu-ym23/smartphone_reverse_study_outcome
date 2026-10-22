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
import androidx.activity.e;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
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
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 64;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 67108864;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 8388608;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
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

        @NonNull
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION = null;
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
            AccessibilityNodeInfo.AccessibilityAction r5 = null;
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
            int r10 = Build.VERSION.SDK_INT;
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            ACTION_PAGE_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);
            ACTION_IME_ENTER = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);
            if (r10 < 32) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r11 = a.a();
        L6:
            ACTION_DRAG_START = new AccessibilityActionCompat(r11, R.id.accessibilityActionDragStart, null, null, null);
            if (r10 < 32) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r12 = a.b();
        L10:
            ACTION_DRAG_DROP = new AccessibilityActionCompat(r12, R.id.accessibilityActionDragDrop, null, null, null);
            if (r10 < 32) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r13 = a.c();
        L14:
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(r13, R.id.accessibilityActionDragCancel, null, null, null);
            if (r10 < 33) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r14 = e.h();
        L18:
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(r14, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            if (r10 < 34) goto L21;
            r5 = Api34Impl.getActionScrollInDirection();
        L21:
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(r5, R.id.accessibilityActionScrollInDirection, null, null, null);
            return;
        L17:
            r14 = null;
            goto L18
        L13:
            r13 = null;
            goto L14
        L9:
            r12 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }

        public AccessibilityActionCompat(int r10, CharSequence r11) {
            this(null, r10, r11, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence r10, AccessibilityViewCommand r11) {
            return new AccessibilityActionCompat(null, this.mId, r10, r11, this.mViewCommandArgumentClass);
        }

        public boolean equals(@Nullable Object r5) {
            if (r5 != null) goto L6;
            return false;
        L6:
            if ((r5 instanceof AccessibilityActionCompat) == true) goto L8;
            return false;
        L8:
            AccessibilityActionCompat r10 = (AccessibilityActionCompat) r5;
            Object r11 = this.mAction;
            if (r11 != null) goto L14;
            if (r10.mAction == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r11.equals(r10.mAction) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object r5 = this.mAction;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View r5, Bundle r10) {
            if (this.mCommand == null) goto L19;
            Class<? extends AccessibilityViewCommand.CommandArguments> r11 = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments r12 = null;
            if (r11 == null) goto L18;
            AccessibilityViewCommand.CommandArguments r13 = r11.getDeclaredConstructor(null).newInstance(null);     // Catch: Exception -> L11
            r13.setBundle(r10);     // Catch: Exception -> L9
            r12 = r13;
        L9:
            e = e;
            r12 = r13;
        L12:
            Class<? extends AccessibilityViewCommand.CommandArguments> r14 = this.mViewCommandArgumentClass;
            if (r14 != null) goto L15;
            String r15 = "null";
        L16:
            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: ".concat(r15), e);
            goto L18
        L15:
            r15 = r14.getName();
        L11:
            e = e;
        L18:
            return this.mCommand.perform(r5, r12);
        L19:
            return false;
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("AccessibilityActionCompat: ");
            String r10 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (r10.equals("ACTION_UNKNOWN") == true) goto L5;
        L7:
            r5.append(r10);
            return r5.toString();
        L5:
            if (getLabel() == null) goto L7;
            r10 = getLabel().toString();
            goto L7
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int r10, CharSequence r11, AccessibilityViewCommand r12) {
            this(null, r10, r11, r12, null);
        }

        public AccessibilityActionCompat(Object r10) {
            this(r10, 0, null, null, null);
        }

        private AccessibilityActionCompat(int r10, CharSequence r11, Class<? extends AccessibilityViewCommand.CommandArguments> r12) {
            this(null, r10, r11, null, r12);
        }

        public AccessibilityActionCompat(Object r5, int r10, CharSequence r11, AccessibilityViewCommand r12, Class<? extends AccessibilityViewCommand.CommandArguments> r13) {
            this.mId = r10;
            this.mCommand = r12;
            if (r5 != null) goto L5;
            this.mAction = new AccessibilityNodeInfo.AccessibilityAction(r10, r11);
        L6:
            this.mViewCommandArgumentClass = r13;
            return;
        L5:
            this.mAction = r5;
            goto L6
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static CollectionItemInfoCompat createCollectionItemInfo(int r5, int r10, int r11, int r12, boolean r13, boolean r14) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r5, r10, r11, r12, r13, r14));
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Object createRangeInfo(int r5, float r10, float r11, float r12) {
            return new AccessibilityNodeInfo.RangeInfo(r5, r10, r11, r12);
        }

        @DoNotInline
        public static CharSequence getStateDescription(AccessibilityNodeInfo r5) {
            return r5.getStateDescription();
        }

        @DoNotInline
        public static void setStateDescription(AccessibilityNodeInfo r5, CharSequence r10) {
            r5.setStateDescription(r10);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean r5, int r10, int r11, int r12, int r13, boolean r14, String r15, String r16) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(r5).setColumnIndex(r10).setRowIndex(r11).setColumnSpan(r12).setRowSpan(r13).setSelected(r14).setRowTitle(r15).setColumnTitle(r16).build());
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo r5, int r10, int r11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r5.getChild(r10, r11));
        }

        @DoNotInline
        public static String getCollectionItemColumnTitle(Object r5) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) r5).getColumnTitle();
        }

        @DoNotInline
        public static String getCollectionItemRowTitle(Object r5) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) r5).getRowTitle();
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo r5) {
            return r5.getExtraRenderingInfo();
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo r5, int r10) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r5.getParent(r10));
        }

        @DoNotInline
        public static String getUniqueId(AccessibilityNodeInfo r5) {
            return r5.getUniqueId();
        }

        @DoNotInline
        public static boolean isTextSelectable(AccessibilityNodeInfo r5) {
            return r5.isTextSelectable();
        }

        @DoNotInline
        public static void setTextSelectable(AccessibilityNodeInfo r5, boolean r10) {
            r5.setTextSelectable(r10);
        }

        @DoNotInline
        public static void setUniqueId(AccessibilityNodeInfo r5, String r10) {
            r5.setUniqueId(r10);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        @DoNotInline
        public static void getBoundsInWindow(AccessibilityNodeInfo r5, Rect r10) {
            r5.getBoundsInWindow(r10);
        }

        @DoNotInline
        public static CharSequence getContainerTitle(AccessibilityNodeInfo r5) {
            return r5.getContainerTitle();
        }

        @DoNotInline
        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r5) {
            return r5.getMinDurationBetweenContentChanges().toMillis();
        }

        @DoNotInline
        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo r5) {
            return r5.hasRequestInitialAccessibilityFocus();
        }

        @DoNotInline
        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo r5) {
            return r5.isAccessibilityDataSensitive();
        }

        @DoNotInline
        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo r5, boolean r10) {
            r5.setAccessibilityDataSensitive(r10);
        }

        @DoNotInline
        public static void setBoundsInWindow(AccessibilityNodeInfo r5, Rect r10) {
            r5.setBoundsInWindow(r10);
        }

        @DoNotInline
        public static void setContainerTitle(AccessibilityNodeInfo r5, CharSequence r10) {
            r5.setContainerTitle(r10);
        }

        @DoNotInline
        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r5, long r10) {
            r5.setMinDurationBetweenContentChanges(Duration.ofMillis(r10));
        }

        @DoNotInline
        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo r5, View r10, boolean r11) {
            r5.setQueryFromAppProcessEnabled(r10, r11);
        }

        @DoNotInline
        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo r5, boolean r10) {
            r5.setRequestInitialAccessibilityFocus(r10);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        public CollectionInfoCompat(Object r5) {
            this.mInfo = r5;
        }

        public static CollectionInfoCompat obtain(int r5, int r10, boolean r11, int r12) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r5, r10, r11, r12));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        public static CollectionInfoCompat obtain(int r5, int r10, boolean r11) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r5, r10, r11));
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        public static final class Builder {
            private int mColumnIndex;
            private int mColumnSpan;
            private String mColumnTitle;
            private boolean mHeading;
            private int mRowIndex;
            private int mRowSpan;
            private String mRowTitle;
            private boolean mSelected;

            public Builder() {
            }

            @NonNull
            public CollectionItemInfoCompat build() {
                if (Build.VERSION.SDK_INT < 33) goto L7;
                return Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle);
            L7:
                return Api21Impl.createCollectionItemInfo(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected);
            }

            @NonNull
            public Builder setColumnIndex(int r5) {
                this.mColumnIndex = r5;
                return this;
            }

            @NonNull
            public Builder setColumnSpan(int r5) {
                this.mColumnSpan = r5;
                return this;
            }

            @NonNull
            public Builder setColumnTitle(@Nullable String r5) {
                this.mColumnTitle = r5;
                return this;
            }

            @NonNull
            public Builder setHeading(boolean r5) {
                this.mHeading = r5;
                return this;
            }

            @NonNull
            public Builder setRowIndex(int r5) {
                this.mRowIndex = r5;
                return this;
            }

            @NonNull
            public Builder setRowSpan(int r5) {
                this.mRowSpan = r5;
                return this;
            }

            @NonNull
            public Builder setRowTitle(@Nullable String r5) {
                this.mRowTitle = r5;
                return this;
            }

            @NonNull
            public Builder setSelected(boolean r5) {
                this.mSelected = r5;
                return this;
            }
        }

        public CollectionItemInfoCompat(Object r5) {
            this.mInfo = r5;
        }

        public static CollectionItemInfoCompat obtain(int r5, int r10, int r11, int r12, boolean r13, boolean r14) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r5, r10, r11, r12, r13, r14));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        @Nullable
        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Nullable
        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemRowTitle(this.mInfo);
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }

        public static CollectionItemInfoCompat obtain(int r5, int r10, int r11, int r12, boolean r13) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r5, r10, r11, r12, r13));
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        public RangeInfoCompat(Object r5) {
            this.mInfo = r5;
        }

        public static RangeInfoCompat obtain(int r5, float r10, float r11, float r12) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r5, r10, r11, r12));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }

        public RangeInfoCompat(int r5, float r10, float r11, float r12) {
            this.mInfo = Api30Impl.createRangeInfo(r5, r10, r11, r12);
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> r5) {
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r5);
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int r5) {
            return this.mInfo.getRegionAt(r5);
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            return this.mInfo.getRegionCount();
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region r5) {
            AccessibilityNodeInfo r10 = this.mInfo.getTargetForRegion(r5);
            if (r10 != null) goto L5;
            return null;
        L5:
            return AccessibilityNodeInfoCompat.wrap(r10);
        }

        public TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo r5) {
            this.mInfo = r5;
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object r5) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) r5;
    }

    private void addSpanLocationToExtras(ClickableSpan r5, Spanned r10, int r11) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(r10.getSpanStart(r5)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(r10.getSpanEnd(r5)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(r10.getSpanFlags(r5)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(r11));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String r5) {
        ArrayList<Integer> r10 = this.mInfo.getExtras().getIntegerArrayList(r5);
        if (r10 != null) goto L6;
        ArrayList<Integer> r11 = new ArrayList();
        this.mInfo.getExtras().putIntegerArrayList(r5, r11);
        return r11;
    L6:
        return r10;
    }

    public static String getActionSymbolicName(int r5) {
        if (r5 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r5 == 2) goto L92;
        switch(r5) {
            case 4: goto L90;
            case 8: goto L88;
            case 16: goto L86;
            case 32: goto L84;
            case 64: goto L82;
            case 128: goto L80;
            case 256: goto L78;
            case 512: goto L76;
            case 1024: goto L74;
            case 2048: goto L72;
            case 4096: goto L70;
            case 8192: goto L68;
            case 16384: goto L66;
            case 32768: goto L64;
            case 65536: goto L62;
            case 131072: goto L60;
            case 262144: goto L58;
            case 524288: goto L56;
            case 2097152: goto L54;
            case 16908354: goto L52;
            case 16908382: goto L50;
            default: goto L7;
        };
    L7:
        switch(r5) {
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
        switch(r5) {
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
        switch(r5) {
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
        return "ACTION_SCROLL_IN_DIRECTION";
    L52:
        return "ACTION_MOVE_WINDOW";
    L54:
        return "ACTION_SET_TEXT";
    L56:
        return "ACTION_COLLAPSE";
    L58:
        return "ACTION_EXPAND";
    L60:
        return "ACTION_SET_SELECTION";
    L62:
        return "ACTION_CUT";
    L64:
        return "ACTION_PASTE";
    L66:
        return "ACTION_COPY";
    L68:
        return "ACTION_SCROLL_BACKWARD";
    L70:
        return "ACTION_SCROLL_FORWARD";
    L72:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L74:
        return "ACTION_NEXT_HTML_ELEMENT";
    L76:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L80:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L84:
        return "ACTION_LONG_CLICK";
    L86:
        return "ACTION_CLICK";
    L88:
        return "ACTION_CLEAR_SELECTION";
    L90:
        return "ACTION_SELECT";
    L92:
        return "ACTION_CLEAR_FOCUS";
    }

    private boolean getBooleanProperty(int r5) {
        Bundle r10 = getExtras();
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10.getInt(BOOLEAN_PROPERTY_KEY, 0) & r5) != r5) goto L9;
        return true;
    L9:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence r5) {
        if ((r5 instanceof Spanned) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ((Spanned) r5).getSpans(0, r5.length(), ClickableSpan.class);
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View r5) {
        SparseArray<WeakReference<ClickableSpan>> r10 = getSpansFromViewTags(r5);
        if (r10 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r11 = new SparseArray();
        r5.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, r11);
        return r11;
    L6:
        return r10;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View r5) {
        return (SparseArray) r5.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan r5, SparseArray<WeakReference<ClickableSpan>> r10) {
        if (r10 == null) goto L11;
        int r11 = 0;
    L5:
        if (r11 >= r10.size()) goto L11;
        if (r5.equals(r10.valueAt(r11).get()) == true) goto L9;
        r11 = r11 + 1;
        goto L5
    L9:
        return r10.keyAt(r11);
    L11:
        int r12 = sClickableSpanId;
        sClickableSpanId = r12 + 1;
        return r12;
    }

    public static AccessibilityNodeInfoCompat obtain(View r5) {
        return wrap(AccessibilityNodeInfo.obtain(r5));
    }

    private void removeCollectedSpans(View r5) {
        SparseArray<WeakReference<ClickableSpan>> r10 = getSpansFromViewTags(r5);
        if (r10 == null) goto L14;
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10.size()) goto L12;
        if (r10.valueAt(r13).get() != null) goto L10;
        r11.add(Integer.valueOf(r13));
    L10:
        r13 = r13 + 1;
    L12:
        if (r12 >= r11.size()) goto L19;
        r10.remove(((Integer) r11.get(r12)).intValue());
        r12 = r12 + 1;
        goto L12
    L19:
        return;
    }

    private void setBooleanProperty(int r5, boolean r10) {
        Bundle r11 = getExtras();
        if (r11 == null) goto L10;
        int r12 = r11.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~r5);
        if (r10 == true) goto L8;
        r5 = 0;
    L8:
        r11.putInt(BOOLEAN_PROPERTY_KEY, r5 | r12);
        return;
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo r5) {
        return new AccessibilityNodeInfoCompat(r5);
    }

    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r5);
    }

    public void addAction(int r5) {
        this.mInfo.addAction(r5);
    }

    public void addChild(View r5) {
        this.mInfo.addChild(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence r5, View r10) {
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof AccessibilityNodeInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r10 = (AccessibilityNodeInfoCompat) r5;
        AccessibilityNodeInfo r11 = this.mInfo;
        if (r11 != null) goto L17;
        if (r10.mInfo == null) goto L20;
        return false;
    L20:
        if (this.mVirtualDescendantId == r10.mVirtualDescendantId) goto L23;
        return false;
    L23:
        if (this.mParentVirtualDescendantId == r10.mParentVirtualDescendantId) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r11.equals(r10.mInfo) == true) goto L20;
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r5) {
        ArrayList r10 = new ArrayList();
        List<AccessibilityNodeInfo> r11 = this.mInfo.findAccessibilityNodeInfosByText(r5);
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.add(wrap(r11.get(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r5) {
        List<AccessibilityNodeInfo> r10 = this.mInfo.findAccessibilityNodeInfosByViewId(r5);
        ArrayList r11 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(wrap(r12.next()));
        goto L4
    L6:
        return r11;
    }

    public AccessibilityNodeInfoCompat findFocus(int r5) {
        return wrapNonNullInstance(this.mInfo.findFocus(r5));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r5) {
        return wrapNonNullInstance(this.mInfo.focusSearch(r5));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> r5 = this.mInfo.getActionList();
        if (r5 == null) goto L9;
        ArrayList r10 = new ArrayList();
        int r11 = r5.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r10.add(new AccessibilityActionCompat(r5.get(r12)));
        r12 = r12 + 1;
        goto L5
    L7:
        return r10;
    L9:
        return Collections.emptyList();
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        return this.mInfo.getAvailableExtraData();
    }

    @Deprecated
    public void getBoundsInParent(Rect r5) {
        this.mInfo.getBoundsInParent(r5);
    }

    public void getBoundsInScreen(Rect r5) {
        this.mInfo.getBoundsInScreen(r5);
    }

    public void getBoundsInWindow(@NonNull Rect r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.getBoundsInWindow(this.mInfo, r5);
        return;
    L5:
        Rect r10 = (Rect) this.mInfo.getExtras().getParcelable(BOUNDS_IN_WINDOW_KEY);
        if (r10 == null) goto L10;
        r5.set(r10.left, r10.top, r10.right, r10.bottom);
        return;
    }

    public AccessibilityNodeInfoCompat getChild(int r5) {
        return wrapNonNullInstance(this.mInfo.getChild(r5));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo r5 = this.mInfo.getCollectionInfo();
        if (r5 != null) goto L5;
        return null;
    L5:
        return new CollectionInfoCompat(r5);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo r5 = this.mInfo.getCollectionItemInfo();
        if (r5 != null) goto L5;
        return null;
    L5:
        return new CollectionItemInfoCompat(r5);
    }

    @Nullable
    public CharSequence getContainerTitle() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getContainerTitle(this.mInfo);
    L7:
        return this.mInfo.getExtras().getCharSequence(CONTAINER_TITLE_KEY);
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
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
        return this.mInfo.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        return this.mInfo.getHintText();
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo);
    L7:
        return this.mInfo.getExtras().getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        return this.mInfo.getPaneTitle();
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo r5 = this.mInfo.getRangeInfo();
        if (r5 != null) goto L5;
        return null;
    L5:
        return new RangeInfoCompat(r5);
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        return Api30Impl.getStateDescription(this.mInfo);
    }

    public CharSequence getText() {
        if (hasSpans() == false) goto L10;
        List<Integer> r5 = extrasIntList(SPANS_START_KEY);
        List<Integer> r10 = extrasIntList(SPANS_END_KEY);
        List<Integer> r11 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> r12 = extrasIntList(SPANS_ID_KEY);
        int r13 = 0;
        SpannableString r14 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
    L6:
        if (r13 >= r5.size()) goto L8;
        r14.setSpan(new AccessibilityClickableSpanCompat(r12.get(r13).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), r5.get(r13).intValue(), r10.get(r13).intValue(), r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        return r14;
    L10:
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        return this.mInfo.getTooltipText();
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo r5 = this.mInfo.getTouchDelegateInfo();
        if (r5 != null) goto L5;
        return null;
    L5:
        return new TouchDelegateInfoCompat(r5);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    @Nullable
    public String getUniqueId() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getUniqueId(this.mInfo);
    L7:
        return this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
    L7:
        return getBooleanProperty(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo r5 = this.mInfo;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAccessibilityDataSensitive(this.mInfo);
    L7:
        return getBooleanProperty(64);
    }

    public boolean isAccessibilityFocused() {
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
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
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

    public boolean isGranularScrollingSupported() {
        return getBooleanProperty(67108864);
    }

    public boolean isHeading() {
        return this.mInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        return this.mInfo.isScreenReaderFocusable();
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        return this.mInfo.isShowingHintText();
    }

    public boolean isTextEntryKey() {
        return this.mInfo.isTextEntryKey();
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.isTextSelectable(this.mInfo);
    L7:
        return getBooleanProperty(8388608);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int r5) {
        return this.mInfo.performAction(r5);
    }

    @Deprecated
    public void recycle() {
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat r5) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r5.mAction);
    }

    public boolean removeChild(View r5) {
        return this.mInfo.removeChild(r5);
    }

    public void setAccessibilityDataSensitive(boolean r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setAccessibilityDataSensitive(this.mInfo, r5);
        return;
    L5:
        setBooleanProperty(64, r5);
    }

    public void setAccessibilityFocused(boolean r5) {
        this.mInfo.setAccessibilityFocused(r5);
    }

    public void setAvailableExtraData(@NonNull List<String> r5) {
        this.mInfo.setAvailableExtraData(r5);
    }

    @Deprecated
    public void setBoundsInParent(Rect r5) {
        this.mInfo.setBoundsInParent(r5);
    }

    public void setBoundsInScreen(Rect r5) {
        this.mInfo.setBoundsInScreen(r5);
    }

    public void setBoundsInWindow(@NonNull Rect r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setBoundsInWindow(this.mInfo, r5);
        return;
    L5:
        this.mInfo.getExtras().putParcelable(BOUNDS_IN_WINDOW_KEY, r5);
    }

    public void setCanOpenPopup(boolean r5) {
        this.mInfo.setCanOpenPopup(r5);
    }

    public void setCheckable(boolean r5) {
        this.mInfo.setCheckable(r5);
    }

    public void setChecked(boolean r5) {
        this.mInfo.setChecked(r5);
    }

    public void setClassName(CharSequence r5) {
        this.mInfo.setClassName(r5);
    }

    public void setClickable(boolean r5) {
        this.mInfo.setClickable(r5);
    }

    public void setCollectionInfo(Object r5) {
        AccessibilityNodeInfo r10 = this.mInfo;
        if (r5 != null) goto L5;
        AccessibilityNodeInfo.CollectionInfo r11 = null;
    L6:
        r10.setCollectionInfo(r11);
        return;
    L5:
        r11 = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) r5).mInfo;
        goto L6
    }

    public void setCollectionItemInfo(Object r5) {
        AccessibilityNodeInfo r10 = this.mInfo;
        if (r5 != null) goto L5;
        AccessibilityNodeInfo.CollectionItemInfo r11 = null;
    L6:
        r10.setCollectionItemInfo(r11);
        return;
    L5:
        r11 = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) r5).mInfo;
        goto L6
    }

    public void setContainerTitle(@Nullable CharSequence r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setContainerTitle(this.mInfo, r5);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(CONTAINER_TITLE_KEY, r5);
    }

    public void setContentDescription(CharSequence r5) {
        this.mInfo.setContentDescription(r5);
    }

    public void setContentInvalid(boolean r5) {
        this.mInfo.setContentInvalid(r5);
    }

    public void setContextClickable(boolean r5) {
        this.mInfo.setContextClickable(r5);
    }

    public void setDismissable(boolean r5) {
        this.mInfo.setDismissable(r5);
    }

    public void setDrawingOrder(int r5) {
        this.mInfo.setDrawingOrder(r5);
    }

    public void setEditable(boolean r5) {
        this.mInfo.setEditable(r5);
    }

    public void setEnabled(boolean r5) {
        this.mInfo.setEnabled(r5);
    }

    public void setError(CharSequence r5) {
        this.mInfo.setError(r5);
    }

    public void setFocusable(boolean r5) {
        this.mInfo.setFocusable(r5);
    }

    public void setFocused(boolean r5) {
        this.mInfo.setFocused(r5);
    }

    public void setGranularScrollingSupported(boolean r5) {
        setBooleanProperty(67108864, r5);
    }

    public void setHeading(boolean r5) {
        this.mInfo.setHeading(r5);
    }

    public void setHintText(@Nullable CharSequence r5) {
        this.mInfo.setHintText(r5);
    }

    public void setImportantForAccessibility(boolean r5) {
        this.mInfo.setImportantForAccessibility(r5);
    }

    public void setInputType(int r5) {
        this.mInfo.setInputType(r5);
    }

    public void setLabelFor(View r5) {
        this.mInfo.setLabelFor(r5);
    }

    public void setLabeledBy(View r5) {
        this.mInfo.setLabeledBy(r5);
    }

    public void setLiveRegion(int r5) {
        this.mInfo.setLiveRegion(r5);
    }

    public void setLongClickable(boolean r5) {
        this.mInfo.setLongClickable(r5);
    }

    public void setMaxTextLength(int r5) {
        this.mInfo.setMaxTextLength(r5);
    }

    public void setMinDurationBetweenContentChangesMillis(long r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, r5);
        return;
    L5:
        this.mInfo.getExtras().putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, r5);
    }

    public void setMovementGranularities(int r5) {
        this.mInfo.setMovementGranularities(r5);
    }

    public void setMultiLine(boolean r5) {
        this.mInfo.setMultiLine(r5);
    }

    public void setPackageName(CharSequence r5) {
        this.mInfo.setPackageName(r5);
    }

    public void setPaneTitle(@Nullable CharSequence r5) {
        this.mInfo.setPaneTitle(r5);
    }

    public void setParent(View r5) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r5);
    }

    public void setPassword(boolean r5) {
        this.mInfo.setPassword(r5);
    }

    public void setQueryFromAppProcessEnabled(@NonNull View r5, boolean r10) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, r5, r10);
        return;
    }

    public void setRangeInfo(RangeInfoCompat r5) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r5.mInfo);
    }

    @SuppressLint({"GetterSetterNames"})
    public void setRequestInitialAccessibilityFocus(boolean r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, r5);
        return;
    L5:
        setBooleanProperty(32, r5);
    }

    public void setRoleDescription(@Nullable CharSequence r5) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, r5);
    }

    public void setScreenReaderFocusable(boolean r5) {
        this.mInfo.setScreenReaderFocusable(r5);
    }

    public void setScrollable(boolean r5) {
        this.mInfo.setScrollable(r5);
    }

    public void setSelected(boolean r5) {
        this.mInfo.setSelected(r5);
    }

    public void setShowingHintText(boolean r5) {
        this.mInfo.setShowingHintText(r5);
    }

    public void setSource(View r5) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r5);
    }

    public void setStateDescription(@Nullable CharSequence r5) {
        Api30Impl.setStateDescription(this.mInfo, r5);
    }

    public void setText(CharSequence r5) {
        this.mInfo.setText(r5);
    }

    public void setTextEntryKey(boolean r5) {
        this.mInfo.setTextEntryKey(r5);
    }

    public void setTextSelectable(boolean r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.setTextSelectable(this.mInfo, r5);
        return;
    L5:
        setBooleanProperty(8388608, r5);
    }

    public void setTextSelection(int r5, int r10) {
        this.mInfo.setTextSelection(r5, r10);
    }

    public void setTooltipText(@Nullable CharSequence r5) {
        this.mInfo.setTooltipText(r5);
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat r5) {
        this.mInfo.setTouchDelegateInfo(r5.mInfo);
    }

    public void setTraversalAfter(View r5) {
        this.mInfo.setTraversalAfter(r5);
    }

    public void setTraversalBefore(View r5) {
        this.mInfo.setTraversalBefore(r5);
    }

    public void setUniqueId(@Nullable String r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.setUniqueId(this.mInfo, r5);
        return;
    L5:
        this.mInfo.getExtras().putString(UNIQUE_ID_KEY, r5);
    }

    public void setViewIdResourceName(String r5) {
        this.mInfo.setViewIdResourceName(r5);
    }

    public void setVisibleToUser(boolean r5) {
        this.mInfo.setVisibleToUser(r5);
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        Rect r10 = new Rect();
        getBoundsInParent(r10);
        r5.append("; boundsInParent: " + r10);
        getBoundsInScreen(r10);
        r5.append("; boundsInScreen: " + r10);
        getBoundsInWindow(r10);
        r5.append("; boundsInWindow: " + r10);
        r5.append("; packageName: ");
        r5.append(getPackageName());
        r5.append("; className: ");
        r5.append(getClassName());
        r5.append("; text: ");
        r5.append(getText());
        r5.append("; error: ");
        r5.append(getError());
        r5.append("; maxTextLength: ");
        r5.append(getMaxTextLength());
        r5.append("; stateDescription: ");
        r5.append(getStateDescription());
        r5.append("; contentDescription: ");
        r5.append(getContentDescription());
        r5.append("; tooltipText: ");
        r5.append(getTooltipText());
        r5.append("; viewIdResName: ");
        r5.append(getViewIdResourceName());
        r5.append("; uniqueId: ");
        r5.append(getUniqueId());
        r5.append("; checkable: ");
        r5.append(isCheckable());
        r5.append("; checked: ");
        r5.append(isChecked());
        r5.append("; focusable: ");
        r5.append(isFocusable());
        r5.append("; focused: ");
        r5.append(isFocused());
        r5.append("; selected: ");
        r5.append(isSelected());
        r5.append("; clickable: ");
        r5.append(isClickable());
        r5.append("; longClickable: ");
        r5.append(isLongClickable());
        r5.append("; contextClickable: ");
        r5.append(isContextClickable());
        r5.append("; enabled: ");
        r5.append(isEnabled());
        r5.append("; password: ");
        r5.append(isPassword());
        r5.append("; scrollable: " + isScrollable());
        r5.append("; containerTitle: ");
        r5.append(getContainerTitle());
        r5.append("; granularScrollingSupported: ");
        r5.append(isGranularScrollingSupported());
        r5.append("; importantForAccessibility: ");
        r5.append(isImportantForAccessibility());
        r5.append("; visible: ");
        r5.append(isVisibleToUser());
        r5.append("; isTextSelectable: ");
        r5.append(isTextSelectable());
        r5.append("; accessibilityDataSensitive: ");
        r5.append(isAccessibilityDataSensitive());
        r5.append("; [");
        List<AccessibilityActionCompat> r11 = getActionList();
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L14;
        AccessibilityActionCompat r13 = r11.get(r12);
        String r14 = getActionSymbolicName(r13.getId());
        if (r14.equals("ACTION_UNKNOWN") == true) goto L8;
    L10:
        r5.append(r14);
        if (r12 == (r11.size() - 1)) goto L13;
        r5.append(", ");
    L13:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r13.getLabel() == null) goto L10;
        r14 = r13.getLabel().toString();
        goto L10
    L14:
        r5.append("]");
        return r5.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View r5, int r10) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r5, r10));
    }

    public void addAction(AccessibilityActionCompat r5) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) r5.mAction);
    }

    public void addChild(View r5, int r10) {
        this.mInfo.addChild(r5, r10);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getChild(int r5, int r10) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getChild(this.mInfo, r5, r10);
    L7:
        return getChild(r5);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getParent(int r5) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getParent(this.mInfo, r5);
    L7:
        return getParent();
    }

    public boolean performAction(int r5, Bundle r10) {
        return this.mInfo.performAction(r5, r10);
    }

    public boolean removeChild(View r5, int r10) {
        return this.mInfo.removeChild(r5, r10);
    }

    public void setLabelFor(View r5, int r10) {
        this.mInfo.setLabelFor(r5, r10);
    }

    public void setLabeledBy(View r5, int r10) {
        this.mInfo.setLabeledBy(r5, r10);
    }

    public void setTraversalAfter(View r5, int r10) {
        this.mInfo.setTraversalAfter(r5, r10);
    }

    public void setTraversalBefore(View r5, int r10) {
        this.mInfo.setTraversalBefore(r5, r10);
    }

    public void setParent(View r5, int r10) {
        this.mParentVirtualDescendantId = r10;
        this.mInfo.setParent(r5, r10);
    }

    public void setSource(View r5, int r10) {
        this.mVirtualDescendantId = r10;
        this.mInfo.setSource(r5, r10);
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r5) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r5;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r5) {
        return wrap(AccessibilityNodeInfo.obtain(r5.mInfo));
    }
}
