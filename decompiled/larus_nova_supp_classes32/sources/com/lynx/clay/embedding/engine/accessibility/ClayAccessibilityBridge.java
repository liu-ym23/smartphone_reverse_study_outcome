package com.lynx.clay.embedding.engine.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ClayAccessibilityBridge extends AccessibilityNodeProvider {

    public static final enum Action extends Enum<Action> {
        public static final Action LONG_PRESS = null;
        public static final Action SCROLL_DOWN = null;
        public static final Action SCROLL_LEFT = null;
        public static final Action SCROLL_RIGHT = null;
        public static final Action SCROLL_UP = null;
        public static final Action SHOW_ON_SCREEN = null;
        public static final Action TAP = null;
        public static final /* synthetic */ Action[] a = null;
        public final int value;

        static {
            Action r0 = new Action("TAP", 0, 1);
            TAP = r0;
            Action r1 = new Action("LONG_PRESS", 1, 2);
            LONG_PRESS = r1;
            Action r4 = new Action("SCROLL_LEFT", 2, 4);
            SCROLL_LEFT = r4;
            Action r6 = new Action("SCROLL_RIGHT", 3, 8);
            SCROLL_RIGHT = r6;
            Action r8 = new Action("SCROLL_UP", 4, 16);
            SCROLL_UP = r8;
            Action r9 = new Action("SCROLL_DOWN", 5, 32);
            SCROLL_DOWN = r9;
            Action r11 = new Action("SHOW_ON_SCREEN", 6, 64);
            SHOW_ON_SCREEN = r11;
            a = new Action[]{r0, r1, r4, r6, r8, r9, r11};
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public Action(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Flag extends Enum<Flag> {
        public static final Flag HAS_IMPLICIT_SCROLLING = null;
        public static final /* synthetic */ Flag[] a = null;
        final int value;

        static {
            Flag r0 = new Flag();
            HAS_IMPLICIT_SCROLLING = r0;
            a = new Flag[]{r0};
        }

        public Flag() {
            super("HAS_IMPLICIT_SCROLLING", 0);
            this.value = 1;
        }

        public static Flag[] values() {
            return (Flag[]) a.clone();
        }

        public static Flag valueOf(String r1) {
            return (Flag) r27.a.a(Flag.class, r1);
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r1) {
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int r1) {
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int r1, int r2, Bundle r3) {
        return false;
    }

    public ClayAccessibilityBridge() {
    }
}
