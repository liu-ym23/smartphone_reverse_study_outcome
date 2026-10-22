package k0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.cae.network.BlockedReason;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f8890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8892c;

    public static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8893e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8894f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f8895g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f8896h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f8897i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f8898j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f8899k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f8900l = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<? extends j.a> f8903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j f8904d;

        static {
            new a(1);
            new a(2);
            new a(4);
            new a(8);
            f8893e = new a(16);
            new a(32);
            new a(64);
            new a(128);
            new a(256, j.b.class);
            new a(512, j.b.class);
            new a(1024, j.c.class);
            new a(2048, j.c.class);
            f8894f = new a(4096);
            f8895g = new a(8192);
            new a(16384);
            new a(32768);
            new a(65536);
            new a(131072, j.g.class);
            f8896h = new a(262144);
            f8897i = new a(524288);
            f8898j = new a(BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE);
            new a(TrafficControlConfig.DEFAULT_UNLIMITED_RATE, j.h.class);
            int r8 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, j.e.class);
            f8899k = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f8900l = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, j.f.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, j.d.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);
            AccessibilityNodeInfo.AccessibilityAction r10 = null;
            if (r8 < 32) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L6:
            new a(r11, R.id.accessibilityActionDragStart, null, null, null);
            if (r8 < 32) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L10:
            new a(r15, R.id.accessibilityActionDragDrop, null, null, null);
            if (r8 < 32) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L14:
            new a(r12, R.id.accessibilityActionDragCancel, null, null, null);
            if (r8 < 33) goto L17;
            r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L17:
            new a(r10, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            return;
        L13:
            r12 = null;
            goto L14
        L9:
            r15 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }

        public a(int r8) {
            this(null, r8, null, null, null);
        }

        public final int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f8901a).getId();
        }

        public final boolean equals(Object r8) {
            if (r8 != null) goto L6;
            return false;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            Object r10 = ((a) r8).f8901a;
            Object r11 = this.f8901a;
            if (r11 != null) goto L13;
            if (r10 == null) goto L15;
            return false;
        L15:
            return true;
        L13:
            if (r11.equals(r10) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Object r8 = this.f8901a;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.hashCode();
        }

        public a(int r8, Class r10) {
            this(null, r8, null, null, r10);
        }

        public a(Object r8, int r10, String r11, j r12, Class r13) {
            this.f8902b = r10;
            this.f8904d = r12;
            if (r8 != null) goto L5;
            r8 = new AccessibilityNodeInfo.AccessibilityAction(r10, r11);
        L5:
            this.f8901a = r8;
            this.f8903c = r13;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8905a;

        public b(AccessibilityNodeInfo.CollectionInfo r8) {
            this.f8905a = r8;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8906a;

        public c(AccessibilityNodeInfo.CollectionItemInfo r8) {
            this.f8906a = r8;
        }

        public static c a(int r8, int r10, int r11, int r12, boolean r13) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(r8, r10, r11, r12, false, r13));
        }
    }

    public f(AccessibilityNodeInfo r8) {
        this.f8891b = -1;
        this.f8892c = -1;
        this.f8890a = r8;
    }

    public final void a(int r8) {
        this.f8890a.addAction(r8);
    }

    public final void b(a r8) {
        AccessibilityNodeInfo.AccessibilityAction r10 = (AccessibilityNodeInfo.AccessibilityAction) r8.f8901a;
        this.f8890a.addAction(r10);
    }

    public final ArrayList c(String r8) {
        AccessibilityNodeInfo r10 = this.f8890a;
        ArrayList<Integer> r11 = r10.getExtras().getIntegerArrayList(r8);
        if (r11 != null) goto L6;
        ArrayList<Integer> r12 = new ArrayList();
        r10.getExtras().putIntegerArrayList(r8, r12);
        return r12;
    L6:
        return r11;
    }

    @Deprecated
    public final void d(Rect r8) {
        this.f8890a.getBoundsInParent(r8);
    }

    public final CharSequence e() {
        boolean r8 = !c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo r10 = this.f8890a;
        if (r8 == false) goto L10;
        ArrayList r11 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList r12 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList r13 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList r14 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        int r15 = 0;
        SpannableString r16 = new SpannableString(TextUtils.substring(r10.getText(), 0, r10.getText().length()));
    L6:
        if (r15 >= r11.size()) goto L8;
        r16.setSpan(new k0.a(((Integer) r14.get(r15)).intValue(), this, r10.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) r11.get(r15)).intValue(), ((Integer) r12.get(r15)).intValue(), ((Integer) r13.get(r15)).intValue());
        r15 = r15 + 1;
        goto L6
    L8:
        return r16;
    L10:
        return r10.getText();
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L9;
        return false;
    L9:
        if ((r8 instanceof f) == true) goto L11;
        return false;
    L11:
        f r10 = (f) r8;
        AccessibilityNodeInfo r11 = r10.f8890a;
        AccessibilityNodeInfo r12 = this.f8890a;
        if (r12 != null) goto L16;
        if (r11 == null) goto L19;
        return false;
    L19:
        if (this.f8892c == r10.f8892c) goto L22;
        return false;
    L22:
        if (this.f8891b == r10.f8891b) goto L24;
        return false;
    L24:
        return true;
    L16:
        if (r12.equals(r11) == true) goto L19;
        return false;
    }

    public final void f(CharSequence r8) {
        this.f8890a.setClassName(r8);
    }

    public final void g(b r8) {
        if (r8 != null) goto L4;
        AccessibilityNodeInfo.CollectionInfo r10 = null;
    L5:
        this.f8890a.setCollectionInfo(r10);
        return;
    L4:
        r10 = (AccessibilityNodeInfo.CollectionInfo) r8.f8905a;
        goto L5
    }

    public final void h(c r8) {
        AccessibilityNodeInfo.CollectionItemInfo r10 = (AccessibilityNodeInfo.CollectionItemInfo) r8.f8906a;
        this.f8890a.setCollectionItemInfo(r10);
    }

    public final int hashCode() {
        AccessibilityNodeInfo r8 = this.f8890a;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    public final void i(CharSequence r8) {
        this.f8890a.setContentDescription(r8);
    }

    public final void j(boolean r8) {
        this.f8890a.setScrollable(r8);
    }

    public final void k(CharSequence r8) {
        this.f8890a.setText(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(super.toString());
        Rect r10 = new Rect();
        d(r10);
        r8.append("; boundsInParent: " + r10);
        AccessibilityNodeInfo r11 = this.f8890a;
        r11.getBoundsInScreen(r10);
        r8.append("; boundsInScreen: " + r10);
        r8.append("; packageName: ");
        r8.append(r11.getPackageName());
        r8.append("; className: ");
        r8.append(r11.getClassName());
        r8.append("; text: ");
        r8.append(e());
        r8.append("; contentDescription: ");
        r8.append(r11.getContentDescription());
        r8.append("; viewId: ");
        r8.append(r11.getViewIdResourceName());
        r8.append("; uniqueId: ");
        if (f0.a.a() == false) goto L5;
        String r12 = r11.getUniqueId();
    L6:
        r8.append(r12);
        r8.append("; checkable: ");
        r8.append(r11.isCheckable());
        r8.append("; checked: ");
        r8.append(r11.isChecked());
        r8.append("; focusable: ");
        r8.append(r11.isFocusable());
        r8.append("; focused: ");
        r8.append(r11.isFocused());
        r8.append("; selected: ");
        r8.append(r11.isSelected());
        r8.append("; clickable: ");
        r8.append(r11.isClickable());
        r8.append("; longClickable: ");
        r8.append(r11.isLongClickable());
        r8.append("; enabled: ");
        r8.append(r11.isEnabled());
        r8.append("; password: ");
        r8.append(r11.isPassword());
        r8.append("; scrollable: " + r11.isScrollable());
        r8.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> r13 = r11.getActionList();
        int r14 = 0;
        if (r13 == null) goto L11;
        ?? r15 = new ArrayList();
        int r16 = r13.size();
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L13;
        r15.add(new a(r13.get(r17), 0, null, null, null));
        r17 = r17 + 1;
    L13:
        if (r14 >= r15.size()) goto L73;
        a r18 = (a) r15.get(r14);
        int r19 = r18.a();
        if (r19 != 1) goto L17;
        String r20 = "ACTION_FOCUS";
    L65:
        if (r20.equals("ACTION_UNKNOWN") == false) goto L69;
        Object r110 = r18.f8901a;
        if (((AccessibilityNodeInfo.AccessibilityAction) r110).getLabel() == null) goto L69;
        r20 = ((AccessibilityNodeInfo.AccessibilityAction) r110).getLabel().toString();
    L69:
        r8.append(r20);
        if (r14 == (r15.size() - 1)) goto L72;
        r8.append(", ");
    L72:
        r14 = r14 + 1;
        goto L13
    L17:
        if (r19 == 2) goto L62;
        switch(r19) {
            case 4: goto L42;
            case 8: goto L41;
            case 16: goto L40;
            case 32: goto L39;
            case 64: goto L38;
            case 128: goto L37;
            case 256: goto L36;
            case 512: goto L35;
            case 1024: goto L34;
            case 2048: goto L33;
            case 4096: goto L32;
            case 8192: goto L31;
            case 16384: goto L30;
            case 32768: goto L29;
            case 65536: goto L28;
            case 131072: goto L27;
            case 262144: goto L26;
            case 524288: goto L25;
            case 2097152: goto L24;
            case 16908354: goto L23;
            default: goto L19;
        };
    L19:
        switch(r19) {
            case 16908342: goto L50;
            case 16908343: goto L49;
            case 16908344: goto L48;
            case 16908345: goto L47;
            case 16908346: goto L46;
            case 16908347: goto L45;
            case 16908348: goto L44;
            case 16908349: goto L43;
            default: goto L20;
        };
    L20:
        switch(r19) {
            case 16908356: goto L57;
            case 16908357: goto L56;
            case 16908358: goto L55;
            case 16908359: goto L54;
            case 16908360: goto L53;
            case 16908361: goto L52;
            case 16908362: goto L51;
            default: goto L21;
        };
    L21:
        switch(r19) {
            case 16908372: goto L61;
            case 16908373: goto L60;
            case 16908374: goto L59;
            case 16908375: goto L58;
            default: goto L22;
        };
    L22:
        r20 = "ACTION_UNKNOWN";
        goto L65
    L58:
        r20 = "ACTION_DRAG_CANCEL";
        goto L65
    L59:
        r20 = "ACTION_DRAG_DROP";
        goto L65
    L60:
        r20 = "ACTION_DRAG_START";
        goto L65
    L61:
        r20 = "ACTION_IME_ENTER";
        goto L65
    L51:
        r20 = "ACTION_PRESS_AND_HOLD";
        goto L65
    L52:
        r20 = "ACTION_PAGE_RIGHT";
        goto L65
    L53:
        r20 = "ACTION_PAGE_LEFT";
        goto L65
    L54:
        r20 = "ACTION_PAGE_DOWN";
        goto L65
    L55:
        r20 = "ACTION_PAGE_UP";
        goto L65
    L56:
        r20 = "ACTION_HIDE_TOOLTIP";
        goto L65
    L57:
        r20 = "ACTION_SHOW_TOOLTIP";
        goto L65
    L43:
        r20 = "ACTION_SET_PROGRESS";
        goto L65
    L44:
        r20 = "ACTION_CONTEXT_CLICK";
        goto L65
    L45:
        r20 = "ACTION_SCROLL_RIGHT";
        goto L65
    L46:
        r20 = "ACTION_SCROLL_DOWN";
        goto L65
    L47:
        r20 = "ACTION_SCROLL_LEFT";
        goto L65
    L48:
        r20 = "ACTION_SCROLL_UP";
        goto L65
    L49:
        r20 = "ACTION_SCROLL_TO_POSITION";
        goto L65
    L50:
        r20 = "ACTION_SHOW_ON_SCREEN";
        goto L65
    L23:
        r20 = "ACTION_MOVE_WINDOW";
        goto L65
    L24:
        r20 = "ACTION_SET_TEXT";
        goto L65
    L25:
        r20 = "ACTION_COLLAPSE";
        goto L65
    L26:
        r20 = "ACTION_EXPAND";
        goto L65
    L27:
        r20 = "ACTION_SET_SELECTION";
        goto L65
    L28:
        r20 = "ACTION_CUT";
        goto L65
    L29:
        r20 = "ACTION_PASTE";
        goto L65
    L30:
        r20 = "ACTION_COPY";
        goto L65
    L31:
        r20 = "ACTION_SCROLL_BACKWARD";
        goto L65
    L32:
        r20 = "ACTION_SCROLL_FORWARD";
        goto L65
    L33:
        r20 = "ACTION_PREVIOUS_HTML_ELEMENT";
        goto L65
    L34:
        r20 = "ACTION_NEXT_HTML_ELEMENT";
        goto L65
    L35:
        r20 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        goto L65
    L36:
        r20 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        goto L65
    L37:
        r20 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        goto L65
    L38:
        r20 = "ACTION_ACCESSIBILITY_FOCUS";
        goto L65
    L39:
        r20 = "ACTION_LONG_CLICK";
        goto L65
    L40:
        r20 = "ACTION_CLICK";
        goto L65
    L41:
        r20 = "ACTION_CLEAR_SELECTION";
        goto L65
    L42:
        r20 = "ACTION_SELECT";
        goto L65
    L62:
        r20 = "ACTION_CLEAR_FOCUS";
        goto L65
    L73:
        r8.append("]");
        return r8.toString();
    L11:
        r15 = Collections.emptyList();
        goto L13
    L5:
        r12 = r11.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        goto L6
    }
}
