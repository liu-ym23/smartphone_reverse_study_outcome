package com.ss.android.lark.message.card.view.richtext;

import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RichTextStyle {
    public static final String[] a = null;

    public static final enum ButtonMode extends Enum<ButtonMode> {
        public static final ButtonMode MODE_DANGER = null;
        public static final ButtonMode MODE_DEFAULT = null;
        public static final ButtonMode MODE_PRIMARY = null;
        public static final /* synthetic */ ButtonMode[] a = null;
        private String mode;

        static {
            ButtonMode r0 = new ButtonMode("MODE_DEFAULT", 0, LocationHitPoint$ResultType.DEFAULT);
            MODE_DEFAULT = r0;
            ButtonMode r1 = new ButtonMode("MODE_PRIMARY", 1, "primary");
            MODE_PRIMARY = r1;
            ButtonMode r2 = new ButtonMode("MODE_DANGER", 2, "danger");
            MODE_DANGER = r2;
            a = new ButtonMode[]{r0, r1, r2};
        }

        public static ButtonMode[] values() {
            return (ButtonMode[]) a.clone();
        }

        public String getMode() {
            return this.mode;
        }

        public static ButtonMode valueOf(String r1) {
            return (ButtonMode) r27.a.a(ButtonMode.class, r1);
        }

        public ButtonMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.mode = r3;
        }
    }

    static {
        a = new String[]{"backgroundColor", "backgroundColorDisable", "backgroundColorActive", "borderWidth", "borderColor", "borderRadius", "backgroundColorToken", "backgroundColorDisableToken", "backgroundColorActiveToken", "borderColorToken"};
    }
}
