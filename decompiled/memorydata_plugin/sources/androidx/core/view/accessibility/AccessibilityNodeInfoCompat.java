package androidx.core.view.accessibility;

import android.R;
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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL = null;
        public static final AccessibilityActionCompat ACTION_DRAG_DROP = null;
        public static final AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;
        public static final AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN = null;
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final AccessibilityActionCompat ACTION_PASTE = null;
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
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
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction r2 = null;
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
            if (Build.VERSION.SDK_INT < 23) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        L6:
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(r6, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        L10:
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(r12, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (Build.VERSION.SDK_INT < 23) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        L14:
            ACTION_SCROLL_UP = new AccessibilityActionCompat(r7, R.id.accessibilityActionScrollUp, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        L18:
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(r13, R.id.accessibilityActionScrollLeft, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L21;
            AccessibilityNodeInfo.AccessibilityAction r8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        L22:
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(r8, R.id.accessibilityActionScrollDown, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L25;
            AccessibilityNodeInfo.AccessibilityAction r14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        L26:
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(r14, R.id.accessibilityActionScrollRight, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L29;
            AccessibilityNodeInfo.AccessibilityAction r9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        L30:
            ACTION_PAGE_UP = new AccessibilityActionCompat(r9, R.id.accessibilityActionPageUp, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L33;
            AccessibilityNodeInfo.AccessibilityAction r15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        L34:
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(r15, R.id.accessibilityActionPageDown, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L37;
            AccessibilityNodeInfo.AccessibilityAction r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        L38:
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(r10, R.id.accessibilityActionPageLeft, null, null, null);
            if (Build.VERSION.SDK_INT < 29) goto L41;
            AccessibilityNodeInfo.AccessibilityAction r16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        L42:
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(r16, R.id.accessibilityActionPageRight, null, null, null);
            if (Build.VERSION.SDK_INT < 23) goto L45;
            AccessibilityNodeInfo.AccessibilityAction r11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        L46:
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(r11, R.id.accessibilityActionContextClick, null, null, null);
            if (Build.VERSION.SDK_INT < 24) goto L49;
            AccessibilityNodeInfo.AccessibilityAction r17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        L50:
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(r17, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (Build.VERSION.SDK_INT < 26) goto L53;
            AccessibilityNodeInfo.AccessibilityAction r4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        L54:
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(r4, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (Build.VERSION.SDK_INT < 28) goto L57;
            AccessibilityNodeInfo.AccessibilityAction r18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        L58:
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(r18, R.id.accessibilityActionShowTooltip, null, null, null);
            if (Build.VERSION.SDK_INT < 28) goto L61;
            AccessibilityNodeInfo.AccessibilityAction r19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        L62:
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(r19, R.id.accessibilityActionHideTooltip, null, null, null);
            if (Build.VERSION.SDK_INT < 30) goto L65;
            AccessibilityNodeInfo.AccessibilityAction r5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        L66:
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(r5, R.id.accessibilityActionPressAndHold, null, null, null);
            if (Build.VERSION.SDK_INT < 30) goto L69;
            AccessibilityNodeInfo.AccessibilityAction r110 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        L70:
            ACTION_IME_ENTER = new AccessibilityActionCompat(r110, R.id.accessibilityActionImeEnter, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L73;
            AccessibilityNodeInfo.AccessibilityAction r20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L74:
            ACTION_DRAG_START = new AccessibilityActionCompat(r20, R.id.accessibilityActionDragStart, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L77;
            AccessibilityNodeInfo.AccessibilityAction r111 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L78:
            ACTION_DRAG_DROP = new AccessibilityActionCompat(r111, R.id.accessibilityActionDragDrop, null, null, null);
            if (Build.VERSION.SDK_INT < 32) goto L81;
            AccessibilityNodeInfo.AccessibilityAction r21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L82:
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(r21, R.id.accessibilityActionDragCancel, null, null, null);
            if (Build.VERSION.SDK_INT < 33) goto L85;
            AccessibilityNodeInfo.AccessibilityAction r112 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L86:
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(r112, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            if (Build.VERSION.SDK_INT < 34) goto L89;
            r2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        L89:
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(r2, R.id.accessibilityActionScrollInDirection, null, null, null);
            return;
        L85:
            r112 = null;
            goto L86
        L81:
            r21 = null;
            goto L82
        L77:
            r111 = null;
            goto L78
        L73:
            r20 = null;
            goto L74
        L69:
            r110 = null;
            goto L70
        L65:
            r5 = null;
            goto L66
        L61:
            r19 = null;
            goto L62
        L57:
            r18 = null;
            goto L58
        L53:
            r4 = null;
            goto L54
        L49:
            r17 = null;
            goto L50
        L45:
            r11 = null;
            goto L46
        L41:
            r16 = null;
            goto L42
        L37:
            r10 = null;
            goto L38
        L33:
            r15 = null;
            goto L34
        L29:
            r9 = null;
            goto L30
        L25:
            r14 = null;
            goto L26
        L21:
            r8 = null;
            goto L22
        L17:
            r13 = null;
            goto L18
        L13:
            r7 = null;
            goto L14
        L9:
            r12 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }

        public AccessibilityActionCompat(int r7, CharSequence r8) {
            this(null, r7, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin"), null, null);
        }

        public AccessibilityActionCompat(int r9, CharSequence r10, AccessibilityViewCommand r11) {
            this(null, r9, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin"), (AccessibilityViewCommand) ZeusTransformUtils.wrapperContextForParams(r11, AccessibilityViewCommand.class, "com.obric.memorydata.plugin"), null);
        }

        private AccessibilityActionCompat(int r7, CharSequence r8, Class<? extends AccessibilityViewCommand.CommandArguments> r9) {
            this(null, r7, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin"), null, r9);
        }

        AccessibilityActionCompat(Object r7) {
            this(r7, 0, null, null, null);
        }

        AccessibilityActionCompat(Object r3, int r4, CharSequence r5, AccessibilityViewCommand r6, Class<? extends AccessibilityViewCommand.CommandArguments> r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            AccessibilityViewCommand r9 = (AccessibilityViewCommand) ZeusTransformUtils.wrapperContextForParams(r6, AccessibilityViewCommand.class, "com.obric.memorydata.plugin");
            this.mId = r4;
            this.mCommand = r9;
            if (Build.VERSION.SDK_INT < 21) goto L6;
            if (r3 != null) goto L6;
            r3 = new AccessibilityNodeInfo.AccessibilityAction(r4, r8);
        L6:
            this.mAction = r3;
            this.mViewCommandArgumentClass = r7;
        }

        public AccessibilityActionCompat createReplacementAction(CharSequence r9, AccessibilityViewCommand r10) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
            AccessibilityViewCommand r6 = (AccessibilityViewCommand) ZeusTransformUtils.wrapperContextForParams(r10, AccessibilityViewCommand.class, "com.obric.memorydata.plugin");
            return new AccessibilityActionCompat(null, this.mId, r5, r6, this.mViewCommandArgumentClass);
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, AccessibilityActionCompat.class) == true) goto L8;
            return false;
        L8:
            AccessibilityActionCompat r5 = (AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r4, AccessibilityActionCompat.class, "com.obric.memorydata.plugin");
            Object r3 = this.mAction;
            if (r3 != null) goto L14;
            if (r5.mAction == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r3.equals(r5.mAction) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public int getId() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(this.mAction, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.memorydata.plugin")).getId();
        }

        public CharSequence getLabel() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return null;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(this.mAction, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.memorydata.plugin")).getLabel();
        }

        public int hashCode() {
            Object r0 = this.mAction;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public boolean perform(View r5, Bundle r6) {
            if (this.mCommand == null) goto L19;
            AccessibilityViewCommand.CommandArguments r0 = null;
            Class<? extends AccessibilityViewCommand.CommandArguments> r2 = this.mViewCommandArgumentClass;
            if (r2 == null) goto L18;
            AccessibilityViewCommand.CommandArguments r1 = (AccessibilityViewCommand.CommandArguments) ZeusTransformUtils.preCheckCast(r2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), AccessibilityViewCommand.CommandArguments.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
            r1.setBundle(r6);     // Catch: Exception -> L9
            r0 = r1;
        L9:
            e = e;
            r0 = r1;
        L12:
            Class<? extends AccessibilityViewCommand.CommandArguments> r3 = this.mViewCommandArgumentClass;
            if (r3 != null) goto L15;
            String r4 = "null";
        L16:
            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + r4, e);
            goto L18
        L15:
            r4 = r3.getName();
        L11:
            e = e;
        L18:
            return this.mCommand.perform(r5, r0);
        L19:
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AccessibilityActionCompat: ");
            String r1 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (r1.equals("ACTION_UNKNOWN") == true) goto L5;
        L7:
            r0.append(r1);
            return r0.toString();
        L5:
            if (getLabel() == null) goto L7;
            r1 = getLabel().toString();
            goto L7
        }
    }

    private static class Api19Impl {
        private Api19Impl() {
        }

        public static CollectionItemInfoCompat createCollectionItemInfo(int r1, int r2, int r3, int r4, boolean r5) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, r5));
        }

        public static Object createRangeInfo(int r0, float r1, float r2, float r3) {
            return AccessibilityNodeInfo.RangeInfo.obtain(r0, r1, r2, r3);
        }

        public static Bundle getExtras(AccessibilityNodeInfo r0) {
            return r0.getExtras();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static CollectionItemInfoCompat createCollectionItemInfo(int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, r5, r6));
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        public static Object createRangeInfo(int r1, float r2, float r3, float r4) {
            return new AccessibilityNodeInfo.RangeInfo(r1, r2, r3, r4);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo r0) {
            return r0.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo r2, CharSequence r3) {
            r2.setStateDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean r2, int r3, int r4, int r5, int r6, boolean r7, String r8, String r9) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(r2).setColumnIndex(r3).setRowIndex(r4).setColumnSpan(r5).setRowSpan(r6).setSelected(r7).setRowTitle(r8).setColumnTitle(r9).build());
        }

        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo r0, int r1, int r2) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r0.getChild(r1, r2));
        }

        public static String getCollectionItemColumnTitle(Object r2) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(r2, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object r2) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(r2, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo r0) {
            return r0.getExtraRenderingInfo();
        }

        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo r0, int r1) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r0.getParent(r1));
        }

        public static String getUniqueId(AccessibilityNodeInfo r0) {
            return r0.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo r0) {
            return r0.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo r0, boolean r1) {
            r0.setTextSelectable(r1);
        }

        public static void setUniqueId(AccessibilityNodeInfo r0, String r1) {
            r0.setUniqueId(r1);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo r0, Rect r1) {
            r0.getBoundsInWindow(r1);
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo r0) {
            return r0.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r2) {
            return r2.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo r0) {
            return r0.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo r0) {
            return r0.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo r0, boolean r1) {
            r0.setAccessibilityDataSensitive(r1);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo r0, Rect r1) {
            r0.setBoundsInWindow(r1);
        }

        public static void setContainerTitle(AccessibilityNodeInfo r2, CharSequence r3) {
            r2.setContainerTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r0, long r1) {
            r0.setMinDurationBetweenContentChanges(Duration.ofMillis(r1));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo r0, View r1, boolean r2) {
            r0.setQueryFromAppProcessEnabled(r1, r2);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo r0, boolean r1) {
            r0.setRequestInitialAccessibilityFocus(r1);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionInfoCompat obtain(int r2, int r3, boolean r4) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L7:
            return new CollectionInfoCompat(null);
        }

        public static CollectionInfoCompat obtain(int r2, int r3, boolean r4, int r5) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4, r5));
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L11:
            return new CollectionInfoCompat(null);
        }

        public int getColumnCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.memorydata.plugin")).getColumnCount();
        }

        public int getRowCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.memorydata.plugin")).getRowCount();
        }

        public int getSelectionMode() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.memorydata.plugin")).getSelectionMode();
        }

        public boolean isHierarchical() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.memorydata.plugin")).isHierarchical();
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

            public CollectionItemInfoCompat build() {
                if (Build.VERSION.SDK_INT < 33) goto L7;
                return Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle);
            L7:
                if (Build.VERSION.SDK_INT < 21) goto L11;
                return Api21Impl.createCollectionItemInfo(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected);
            L11:
                if (Build.VERSION.SDK_INT < 19) goto L15;
                return Api19Impl.createCollectionItemInfo(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading);
            L15:
                return new CollectionItemInfoCompat(null);
            }

            public Builder setColumnIndex(int r1) {
                this.mColumnIndex = r1;
                return this;
            }

            public Builder setColumnSpan(int r1) {
                this.mColumnSpan = r1;
                return this;
            }

            public Builder setColumnTitle(String r1) {
                this.mColumnTitle = r1;
                return this;
            }

            public Builder setHeading(boolean r1) {
                this.mHeading = r1;
                return this;
            }

            public Builder setRowIndex(int r1) {
                this.mRowIndex = r1;
                return this;
            }

            public Builder setRowSpan(int r1) {
                this.mRowSpan = r1;
                return this;
            }

            public Builder setRowTitle(String r1) {
                this.mRowTitle = r1;
                return this;
            }

            public Builder setSelected(boolean r1) {
                this.mSelected = r1;
                return this;
            }
        }

        CollectionItemInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionItemInfoCompat obtain(int r2, int r3, int r4, int r5, boolean r6) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6));
        L7:
            return new CollectionItemInfoCompat(null);
        }

        public static CollectionItemInfoCompat obtain(int r2, int r3, int r4, int r5, boolean r6, boolean r7) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6, r7));
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6));
        L11:
            return new CollectionItemInfoCompat(null);
        }

        public int getColumnIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getColumnIndex();
        }

        public int getColumnSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getColumnSpan();
        }

        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
        }

        public int getRowIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getRowIndex();
        }

        public int getRowSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).getRowSpan();
        }

        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemRowTitle(this.mInfo);
        }

        @Deprecated
        public boolean isHeading() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).isHeading();
        }

        public boolean isSelected() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin")).isSelected();
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        public RangeInfoCompat(int r3, float r4, float r5, float r6) {
            if (Build.VERSION.SDK_INT < 30) goto L7;
            Object r7 = Api30Impl.createRangeInfo(r3, r4, r5, r6);
        L5:
            this.mInfo = r7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L9;
            r7 = Api19Impl.createRangeInfo(r3, r4, r5, r6);
            goto L5
        L9:
            r7 = null;
            goto L5
        }

        RangeInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static RangeInfoCompat obtain(int r2, float r3, float r4, float r5) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r2, r3, r4, r5));
        L7:
            return new RangeInfoCompat(null);
        }

        public float getCurrent() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.RangeInfo.class, "com.obric.memorydata.plugin")).getCurrent();
        }

        public float getMax() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.RangeInfo.class, "com.obric.memorydata.plugin")).getMax();
        }

        public float getMin() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.RangeInfo.class, "com.obric.memorydata.plugin")).getMin();
        }

        public int getType() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityNodeInfo.RangeInfo.class, "com.obric.memorydata.plugin")).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo r1) {
            this.mInfo = r1;
        }

        public TouchDelegateInfoCompat(Map<Region, View> r3) {
            Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r4);
            return;
        L5:
            this.mInfo = null;
        }

        public Region getRegionAt(int r3) {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return null;
        L5:
            return this.mInfo.getRegionAt(r3);
        }

        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return 0;
        L5:
            return this.mInfo.getRegionCount();
        }

        public AccessibilityNodeInfoCompat getTargetForRegion(Region r3) {
            if (Build.VERSION.SDK_INT < 29) goto L8;
            AccessibilityNodeInfo r2 = this.mInfo.getTargetForRegion(r3);
            if (r2 != null) goto L7;
            return null;
        L7:
            return AccessibilityNodeInfoCompat.wrap(r2);
        L8:
            return null;
        }
    }

    static {
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r2) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r2;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object r3) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r3, AccessibilityNodeInfo.class, "com.obric.memorydata.plugin");
    }

    private void addSpanLocationToExtras(ClickableSpan r3, Spanned r4, int r5) {
        Spanned r6 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin");
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(r6.getSpanStart(r3)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(r6.getSpanEnd(r3)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(r6.getSpanFlags(r3)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(r5));
    }

    private void clearExtrasSpans() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.getExtras(this.mInfo).remove(SPANS_START_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_END_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_FLAGS_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_ID_KEY);
        return;
    }

    private List<Integer> extrasIntList(String r3) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        ArrayList<Integer> r0 = Api19Impl.getExtras(this.mInfo).getIntegerArrayList(r3);
        if (r0 != null) goto L10;
        ArrayList<Integer> r1 = new ArrayList();
        Api19Impl.getExtras(this.mInfo).putIntegerArrayList(r3, r1);
        return r1;
    L10:
        return r0;
    L5:
        return new ArrayList();
    }

    static String getActionSymbolicName(int r1) {
        if (r1 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r1 == 2) goto L92;
        switch(r1) {
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
        switch(r1) {
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
        switch(r1) {
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
        switch(r1) {
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

    private boolean getBooleanProperty(int r3) {
        Bundle r2 = getExtras();
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2.getInt(BOOLEAN_PROPERTY_KEY, 0) & r3) != r3) goto L9;
        return true;
    L9:
        return false;
    }

    public static ClickableSpan[] getClickableSpans(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r5.length(), ClickableSpan.class), ClickableSpan[].class, "com.obric.memorydata.plugin");
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View r4) {
        SparseArray<WeakReference<ClickableSpan>> r3 = getSpansFromViewTags(r4);
        if (r3 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r5 = new SparseArray();
        r4.setTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tag_accessibility_clickable_spans, OaidModel.KEY_ID, "tag_accessibility_clickable_spans"), r5);
        return r5;
    L6:
        return r3;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View r3) {
        return (SparseArray) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tag_accessibility_clickable_spans, OaidModel.KEY_ID, "tag_accessibility_clickable_spans")), SparseArray.class, "com.obric.memorydata.plugin");
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan r4, SparseArray<WeakReference<ClickableSpan>> r5) {
        if (r5 == null) goto L11;
        int r3 = 0;
    L5:
        if (r3 >= r5.size()) goto L11;
        if (r4.equals((ClickableSpan) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r5.valueAt(r3), WeakReference.class, "com.obric.memorydata.plugin")).get(), ClickableSpan.class, "com.obric.memorydata.plugin")) == true) goto L9;
        r3 = r3 + 1;
        goto L5
    L9:
        return r5.keyAt(r3);
    L11:
        int r6 = sClickableSpanId;
        sClickableSpanId = r6 + 1;
        return r6;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0));
    }

    public static AccessibilityNodeInfoCompat obtain(View r2, int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r2, r3));
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0.mInfo));
    }

    private void removeCollectedSpans(View r6) {
        SparseArray<WeakReference<ClickableSpan>> r5 = getSpansFromViewTags(r6);
        if (r5 == null) goto L14;
        ArrayList r7 = new ArrayList();
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r5.size()) goto L12;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r5.valueAt(r1), WeakReference.class, "com.obric.memorydata.plugin")).get() != null) goto L10;
        r7.add(Integer.valueOf(r1));
    L10:
        r1 = r1 + 1;
    L12:
        if (r0 >= r7.size()) goto L19;
        r5.remove(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L12
    L19:
        return;
    }

    private void setBooleanProperty(int r5, boolean r6) {
        Bundle r4 = getExtras();
        if (r4 == null) goto L10;
        int r2 = r4.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~r5);
        if (r6 == true) goto L8;
        r5 = 0;
    L8:
        r4.putInt(BOOLEAN_PROPERTY_KEY, r5 | r2);
        return;
    }

    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo r1) {
        return new AccessibilityNodeInfoCompat(r1);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r1);
    }

    public void addAction(int r1) {
        this.mInfo.addAction(r1);
    }

    public void addAction(AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(r3.mAction, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void addChild(View r1) {
        this.mInfo.addChild(r1);
    }

    public void addChild(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.addChild(r3, r4);
        return;
    }

    public void addSpansToExtras(CharSequence r7, View r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L18;
        clearExtrasSpans();
        removeCollectedSpans(r8);
        ClickableSpan[] r0 = getClickableSpans(r9);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.length <= 0) goto L20;
        getExtras().putInt(SPANS_ACTION_ID_KEY, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.accessibility_action_clickable_span, OaidModel.KEY_ID, "accessibility_action_clickable_span"));
        SparseArray<WeakReference<ClickableSpan>> r10 = getOrCreateSpansFromViewTags(r8);
        int r2 = 0;
    L11:
        if (r0 == null) goto L21;
        if (r2 >= r0.length) goto L22;
        int r3 = idForClickableSpan(r0[r2], r10);
        r10.put(r3, new WeakReference(r0[r2]));
        addSpanLocationToExtras(r0[r2], (Spanned) ZeusTransformUtils.preCheckCast(r9, Spanned.class, "com.obric.memorydata.plugin"), r3);
        r2 = r2 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public boolean canOpenPopup() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, AccessibilityNodeInfoCompat.class) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r6 = (AccessibilityNodeInfoCompat) ZeusTransformUtils.preCheckCast(r5, AccessibilityNodeInfoCompat.class, "com.obric.memorydata.plugin");
        AccessibilityNodeInfo r0 = this.mInfo;
        if (r0 != null) goto L17;
        if (r6.mInfo == null) goto L20;
        return false;
    L20:
        if (this.mVirtualDescendantId == r6.mVirtualDescendantId) goto L23;
        return false;
    L23:
        if (this.mParentVirtualDescendantId == r6.mParentVirtualDescendantId) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r0.equals(r6.mInfo) == true) goto L20;
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r6) {
        ArrayList r0 = new ArrayList();
        List<AccessibilityNodeInfo> r5 = this.mInfo.findAccessibilityNodeInfosByText(r6);
        int r7 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L5;
        r0.add(wrap((AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r5.get(r1), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin")));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r4) {
        if (Build.VERSION.SDK_INT < 18) goto L10;
        List<AccessibilityNodeInfo> r3 = this.mInfo.findAccessibilityNodeInfosByViewId(r4);
        ArrayList r5 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add(wrap((AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r6.next(), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin")));
        goto L6
    L8:
        return r5;
    L10:
        return Collections.emptyList();
    }

    public AccessibilityNodeInfoCompat findFocus(int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.findFocus(r3));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.focusSearch(r3));
    }

    public List<AccessibilityActionCompat> getActionList() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        List<AccessibilityNodeInfo.AccessibilityAction> r5 = this.mInfo.getActionList();
    L6:
        if (r5 == null) goto L12;
        ArrayList r0 = new ArrayList();
        int r1 = r5.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r0.add(new AccessibilityActionCompat(r5.get(r2)));
        r2 = r2 + 1;
        goto L8
    L10:
        return r0;
    L12:
        return Collections.emptyList();
    L5:
        r5 = null;
        goto L6
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getAvailableExtraData();
    L7:
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect r1) {
        this.mInfo.getBoundsInParent(r1);
    }

    public void getBoundsInScreen(Rect r1) {
        this.mInfo.getBoundsInScreen(r1);
    }

    public void getBoundsInWindow(Rect r4) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.getBoundsInWindow(this.mInfo, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L12;
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(Api19Impl.getExtras(this.mInfo).getParcelable(BOUNDS_IN_WINDOW_KEY), Rect.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        r4.set(r3.left, r3.top, r3.right, r3.bottom);
        return;
    L13:
        return;
    }

    public AccessibilityNodeInfoCompat getChild(int r1) {
        return wrapNonNullInstance(this.mInfo.getChild(r1));
    }

    public AccessibilityNodeInfoCompat getChild(int r3, int r4) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getChild(this.mInfo, r3, r4);
    L7:
        return getChild(r3);
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionInfo r2 = this.mInfo.getCollectionInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new CollectionInfoCompat(r2);
    L8:
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionItemInfo r2 = this.mInfo.getCollectionItemInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new CollectionItemInfoCompat(r2);
    L8:
        return null;
    }

    public CharSequence getContainerTitle() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getContainerTitle(this.mInfo);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(CONTAINER_TITLE_KEY);
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

    public CharSequence getHintText() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getHintText();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
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
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return 0;
    L9:
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

    public CharSequence getPaneTitle() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.getPaneTitle();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public AccessibilityNodeInfoCompat getParent(int r3) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getParent(this.mInfo, r3);
    L7:
        return getParent();
    }

    public RangeInfoCompat getRangeInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.RangeInfo r2 = this.mInfo.getRangeInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new RangeInfoCompat(r2);
    L8:
        return null;
    }

    public CharSequence getRoleDescription() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    public CharSequence getStateDescription() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getStateDescription(this.mInfo);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (hasSpans() == false) goto L10;
        List<Integer> r0 = extrasIntList(SPANS_START_KEY);
        List<Integer> r1 = extrasIntList(SPANS_END_KEY);
        List<Integer> r2 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> r3 = extrasIntList(SPANS_ID_KEY);
        int r7 = 0;
        SpannableString r4 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
    L6:
        if (r7 >= r0.size()) goto L8;
        r4.setSpan(new AccessibilityClickableSpanCompat(((Integer) ZeusTransformUtils.preCheckCast(r3.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r1.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r2.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r7 = r7 + 1;
        goto L6
    L8:
        return r4;
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

    public CharSequence getTooltipText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return Api19Impl.getExtras(this.mInfo).getCharSequence(TOOLTIP_TEXT_KEY);
    }

    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        AccessibilityNodeInfo.TouchDelegateInfo r2 = this.mInfo.getTouchDelegateInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new TouchDelegateInfoCompat(r2);
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

    public String getUniqueId() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getUniqueId(this.mInfo);
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

    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
    L7:
        return getBooleanProperty(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAccessibilityDataSensitive(this.mInfo);
    L7:
        return getBooleanProperty(64);
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

    public boolean isGranularScrollingSupported() {
        return getBooleanProperty(67108864);
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isHeading();
    L7:
        if (getBooleanProperty(2) == false) goto L9;
        return true;
    L9:
        CollectionItemInfoCompat r2 = getCollectionItemInfo();
        if (r2 != null) goto L12;
    L14:
        return false;
    L12:
        if (r2.isHeading() == false) goto L14;
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
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.isTextSelectable(this.mInfo);
    L7:
        return getBooleanProperty(8388608);
    }

    public boolean isVisibleToUser() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int r1) {
        return this.mInfo.performAction(r1);
    }

    public boolean performAction(int r3, Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.performAction(r3, r4);
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

    public boolean removeAction(AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) ZeusTransformUtils.preCheckCast(r3.mAction, AccessibilityNodeInfo.AccessibilityAction.class, "com.obric.memorydata.plugin"));
    }

    public boolean removeChild(View r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r3);
    }

    public boolean removeChild(View r3, int r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r3, r4);
    }

    public void setAccessibilityDataSensitive(boolean r3) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setAccessibilityDataSensitive(this.mInfo, r3);
        return;
    L5:
        setBooleanProperty(64, r3);
    }

    public void setAccessibilityFocused(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setAccessibilityFocused(r3);
        return;
    }

    public void setAvailableExtraData(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mInfo.setAvailableExtraData(r4);
        return;
    }

    @Deprecated
    public void setBoundsInParent(Rect r1) {
        this.mInfo.setBoundsInParent(r1);
    }

    public void setBoundsInScreen(Rect r1) {
        this.mInfo.setBoundsInScreen(r1);
    }

    public void setBoundsInWindow(Rect r3) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setBoundsInWindow(this.mInfo, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putParcelable(BOUNDS_IN_WINDOW_KEY, r3);
        return;
    }

    public void setCanOpenPopup(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setCanOpenPopup(r3);
        return;
    }

    public void setCheckable(boolean r1) {
        this.mInfo.setCheckable(r1);
    }

    public void setChecked(boolean r1) {
        this.mInfo.setChecked(r1);
    }

    public void setClassName(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mInfo.setClassName(r4);
    }

    public void setClickable(boolean r1) {
        this.mInfo.setClickable(r1);
    }

    public void setCollectionInfo(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.mInfo;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionInfo r4 = null;
    L8:
        r2.setCollectionInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionInfo) ZeusTransformUtils.preCheckCast(((CollectionInfoCompat) ZeusTransformUtils.preCheckCast(r3, CollectionInfoCompat.class, "com.obric.memorydata.plugin")).mInfo, AccessibilityNodeInfo.CollectionInfo.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public void setCollectionItemInfo(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.mInfo;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionItemInfo r4 = null;
    L8:
        r2.setCollectionItemInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionItemInfo) ZeusTransformUtils.preCheckCast(((CollectionItemInfoCompat) ZeusTransformUtils.preCheckCast(r3, CollectionItemInfoCompat.class, "com.obric.memorydata.plugin")).mInfo, AccessibilityNodeInfo.CollectionItemInfo.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public void setContainerTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setContainerTitle(this.mInfo, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(CONTAINER_TITLE_KEY, r4);
        return;
    }

    public void setContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mInfo.setContentDescription(r4);
    }

    public void setContentInvalid(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setContentInvalid(r3);
        return;
    }

    public void setContextClickable(boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mInfo.setContextClickable(r3);
        return;
    }

    public void setDismissable(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setDismissable(r3);
        return;
    }

    public void setDrawingOrder(int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setDrawingOrder(r3);
        return;
    }

    public void setEditable(boolean r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setEditable(r3);
        return;
    }

    public void setEnabled(boolean r1) {
        this.mInfo.setEnabled(r1);
    }

    public void setError(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setError(r4);
        return;
    }

    public void setFocusable(boolean r1) {
        this.mInfo.setFocusable(r1);
    }

    public void setFocused(boolean r1) {
        this.mInfo.setFocused(r1);
    }

    public void setGranularScrollingSupported(boolean r2) {
        setBooleanProperty(67108864, r2);
    }

    public void setHeading(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setHeading(r3);
        return;
    L5:
        setBooleanProperty(2, r3);
    }

    public void setHintText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mInfo.setHintText(r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(HINT_TEXT_KEY, r4);
        return;
    }

    public void setImportantForAccessibility(boolean r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setImportantForAccessibility(r3);
        return;
    }

    public void setInputType(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setInputType(r3);
        return;
    }

    public void setLabelFor(View r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r3);
        return;
    }

    public void setLabelFor(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r3, r4);
        return;
    }

    public void setLabeledBy(View r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r3);
        return;
    }

    public void setLabeledBy(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r3, r4);
        return;
    }

    public void setLiveRegion(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setLiveRegion(r3);
        return;
    }

    public void setLongClickable(boolean r1) {
        this.mInfo.setLongClickable(r1);
    }

    public void setMaxTextLength(int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setMaxTextLength(r3);
        return;
    }

    public void setMinDurationBetweenContentChangesMillis(long r3) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, r3);
        return;
    }

    public void setMovementGranularities(int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setMovementGranularities(r3);
        return;
    }

    public void setMultiLine(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setMultiLine(r3);
        return;
    }

    public void setPackageName(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mInfo.setPackageName(r4);
    }

    public void setPaneTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mInfo.setPaneTitle(r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(PANE_TITLE_KEY, r4);
        return;
    }

    public void setParent(View r2) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r2);
    }

    public void setParent(View r3, int r4) {
        this.mParentVirtualDescendantId = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setParent(r3, r4);
        return;
    }

    public void setPassword(boolean r1) {
        this.mInfo.setPassword(r1);
    }

    public void setQueryFromAppProcessEnabled(View r3, boolean r4) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, r3, r4);
        return;
    }

    public void setRangeInfo(RangeInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) ZeusTransformUtils.preCheckCast(r3.mInfo, AccessibilityNodeInfo.RangeInfo.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void setRequestInitialAccessibilityFocus(boolean r3) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, r3);
        return;
    L5:
        setBooleanProperty(32, r3);
    }

    public void setRoleDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.getExtras(this.mInfo).putCharSequence(ROLE_DESCRIPTION_KEY, r4);
        return;
    }

    public void setScreenReaderFocusable(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setScreenReaderFocusable(r3);
        return;
    L5:
        setBooleanProperty(1, r3);
    }

    public void setScrollable(boolean r1) {
        this.mInfo.setScrollable(r1);
    }

    public void setSelected(boolean r1) {
        this.mInfo.setSelected(r1);
    }

    public void setShowingHintText(boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mInfo.setShowingHintText(r3);
        return;
    L5:
        setBooleanProperty(4, r3);
    }

    public void setSource(View r2) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r2);
    }

    public void setSource(View r3, int r4) {
        this.mVirtualDescendantId = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setSource(r3, r4);
        return;
    }

    public void setStateDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setStateDescription(this.mInfo, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(STATE_DESCRIPTION_KEY, r4);
        return;
    }

    public void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mInfo.setText(r4);
    }

    public void setTextEntryKey(boolean r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mInfo.setTextEntryKey(r3);
        return;
    L5:
        setBooleanProperty(8, r3);
    }

    public void setTextSelectable(boolean r3) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.setTextSelectable(this.mInfo, r3);
        return;
    L5:
        setBooleanProperty(8388608, r3);
    }

    public void setTextSelection(int r3, int r4) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setTextSelection(r3, r4);
        return;
    }

    public void setTooltipText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mInfo.setTooltipText(r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putCharSequence(TOOLTIP_TEXT_KEY, r4);
        return;
    }

    public void setTouchDelegateInfo(TouchDelegateInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        this.mInfo.setTouchDelegateInfo(r3.mInfo);
        return;
    }

    public void setTraversalAfter(View r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r3);
        return;
    }

    public void setTraversalAfter(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r3, r4);
        return;
    }

    public void setTraversalBefore(View r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r3);
        return;
    }

    public void setTraversalBefore(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r3, r4);
        return;
    }

    public void setUniqueId(String r3) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.setUniqueId(this.mInfo, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        Api19Impl.getExtras(this.mInfo).putString(UNIQUE_ID_KEY, r3);
        return;
    }

    public void setViewIdResourceName(String r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setViewIdResourceName(r3);
        return;
    }

    public void setVisibleToUser(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setVisibleToUser(r3);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        Rect r1 = new Rect();
        getBoundsInParent(r1);
        r0.append("; boundsInParent: " + r1);
        getBoundsInScreen(r1);
        r0.append("; boundsInScreen: " + r1);
        getBoundsInWindow(r1);
        r0.append("; boundsInWindow: " + r1);
        r0.append("; packageName: ").append(getPackageName());
        r0.append("; className: ").append(getClassName());
        r0.append("; text: ").append(getText());
        r0.append("; error: ").append(getError());
        r0.append("; maxTextLength: ").append(getMaxTextLength());
        r0.append("; stateDescription: ").append(getStateDescription());
        r0.append("; contentDescription: ").append(getContentDescription());
        r0.append("; tooltipText: ").append(getTooltipText());
        r0.append("; viewIdResName: ").append(getViewIdResourceName());
        r0.append("; uniqueId: ").append(getUniqueId());
        r0.append("; checkable: ").append(isCheckable());
        r0.append("; checked: ").append(isChecked());
        r0.append("; focusable: ").append(isFocusable());
        r0.append("; focused: ").append(isFocused());
        r0.append("; selected: ").append(isSelected());
        r0.append("; clickable: ").append(isClickable());
        r0.append("; longClickable: ").append(isLongClickable());
        r0.append("; contextClickable: ").append(isContextClickable());
        r0.append("; enabled: ").append(isEnabled());
        r0.append("; password: ").append(isPassword());
        r0.append("; scrollable: " + isScrollable());
        r0.append("; containerTitle: ").append(getContainerTitle());
        r0.append("; granularScrollingSupported: ").append(isGranularScrollingSupported());
        r0.append("; importantForAccessibility: ").append(isImportantForAccessibility());
        r0.append("; visible: ").append(isVisibleToUser());
        r0.append("; isTextSelectable: ").append(isTextSelectable());
        r0.append("; accessibilityDataSensitive: ").append(isAccessibilityDataSensitive());
        r0.append("; [");
        if (Build.VERSION.SDK_INT < 21) goto L16;
        List<AccessibilityActionCompat> r7 = getActionList();
        int r2 = 0;
    L6:
        if (r2 >= r7.size()) goto L21;
        AccessibilityActionCompat r4 = (AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r7.get(r2), AccessibilityActionCompat.class, "com.obric.memorydata.plugin");
        String r5 = getActionSymbolicName(r4.getId());
        if (r5.equals("ACTION_UNKNOWN") == true) goto L10;
    L12:
        r0.append(r5);
        if (r2 == (r7.size() - 1)) goto L15;
        r0.append(", ");
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r4.getLabel() == null) goto L12;
        r5 = r4.getLabel().toString();
    L21:
        r0.append("]");
        return r0.toString();
    L16:
        int r8 = getActions();
    L17:
        if (r8 == 0) goto L21;
        int r3 = 1 << Integer.numberOfTrailingZeros(r8);
        r8 = r8 & (~r3);
        r0.append(getActionSymbolicName(r3));
        if (r8 == 0) goto L17;
        r0.append(", ");
        goto L17
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
