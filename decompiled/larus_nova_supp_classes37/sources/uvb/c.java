package uvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    public static final a D = null;
    public static final a E = null;
    public static final a F = null;
    public static final a G = null;
    public static final a H = null;
    public static final a I = null;
    public static final a J = null;
    public static final a K = null;
    public static final a L = null;
    public static final a M = null;
    public static final a N = null;
    public static final a O = null;
    public static final a P = null;
    public static final a Q = null;
    public static final a R = null;
    public static final a S = null;
    public static final a T = null;
    public static final a U = null;
    public static final a V = null;
    public static final a W = null;
    public static final a X = null;
    public static final a Y = null;
    public static final a Z = null;
    public static final a a = null;
    public static final a a0 = null;
    public static final a b = null;
    public static final a b0 = null;
    public static final a c = null;
    public static final a c0 = null;
    public static final a d = null;
    public static final a d0 = null;
    public static final a e = null;
    public static final a e0 = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    public static final a l = null;
    public static final a m = null;
    public static final a n = null;
    public static final a o = null;
    public static final a p = null;
    public static final a q = null;
    public static final a r = null;
    public static final a s = null;
    public static final a t = null;
    public static final a u = null;
    public static final a v = null;
    public static final a w = null;
    public static final a x = null;
    public static final a y = null;
    public static final a z = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Source(id=" + this.a + ", label=" + this.b + ", hint=" + this.c + ", expected=" + this.d + ')';
        }

        public a(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "label");
            Intrinsics.checkNotNullParameter(r4, "hint");
            Intrinsics.checkNotNullParameter(r5, "expected");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = new a("minutes-office-sdk-recording-activity", "OfficeSDK Recording Activity", "Hosts the OfficeSDK recording page", "minutes-office-sdk-recording-page");
        b = new a("minutes-office-sdk-recording-page", "OfficeSDK Recording Page", "Current page is an active OfficeSDK recording", "minutes-office-sdk-recording-page");
        c = new a("minutes-office-sdk-recording-title", "Recording Title", "Tap to edit the recording title", "minutes-office-sdk-recording-title-input");
        d = new a("minutes-office-sdk-recording-title-input", "Recording Title Input", "Edit the recording title", "minutes-office-sdk-recording-title");
        e = new a("minutes-office-sdk-recording-tabs", "Recording Content Tabs", "Switch between transcript and summary content", "minutes-office-sdk-subtitle-page|minutes-office-sdk-summary-page");
        f = new a("minutes-office-sdk-subtitle-tab", "Realtime Transcript Tab", "Tap to show realtime recording transcript", "minutes-office-sdk-subtitle-page");
        g = new a("minutes-office-sdk-summary-tab", "Realtime Summary Tab", "Tap to show realtime recording summary", "minutes-office-sdk-summary-page");
        h = new a("minutes-office-sdk-summary-new-indicator", "New Summary Indicator", "Shows that realtime summary has new content", "minutes-office-sdk-summary-new-indicator");
        i = new a("minutes-office-sdk-subtitle-page", "Realtime Transcript Page", "Shows realtime recording transcript", "minutes-office-sdk-subtitle-page");
        j = new a("minutes-office-sdk-subtitle-list", "Realtime Transcript List", "Shows realtime transcript rows", "minutes-office-sdk-subtitle-list");
        k = new a("minutes-office-sdk-subtitle-speaker", "Transcript Speaker", "Shows the speaker for a transcript row", "minutes-office-sdk-subtitle-list");
        l = new a("minutes-office-sdk-subtitle-time", "Transcript Time", "Shows the timestamp for a transcript row", "minutes-office-sdk-subtitle-list");
        m = new a("minutes-office-sdk-subtitle-content", "Transcript Content", "Shows the spoken content for a transcript row", "minutes-office-sdk-subtitle-list");
        n = new a("minutes-office-sdk-subtitle-back-to-bottom", "Back to Latest Transcript", "Tap to scroll to the latest transcript", "minutes-office-sdk-subtitle-list");
        o = new a("minutes-office-sdk-summary-page", "Realtime Summary Page", "Shows realtime recording summary", "minutes-office-sdk-summary-page");
        p = new a("minutes-office-sdk-recording-duration", "Recording Duration", "Shows the current recording duration", "minutes-office-sdk-recording-duration");
        q = new a("minutes-office-sdk-recording-wave", "Recording Wave", "Shows the current recording audio activity", "minutes-office-sdk-recording-wave");
        r = new a("minutes-office-sdk-recording-pause-resume", "Pause or Resume Recording", "Tap to pause or resume the current recording", "minutes-office-sdk-recording-page");
        s = new a("minutes-office-sdk-recording-stop", "Stop Recording", "Tap to stop the current recording", "minutes-office-sdk-end-window-activity");
        t = new a("minutes-office-sdk-recording-language", "Recording Language Settings", "Tap to open recording language settings", "minutes-office-sdk-language-panel");
        u = new a("minutes-office-sdk-recording-audio-save", "Recording Audio Save Settings", "Tap to open audio save settings", "minutes-office-sdk-audio-save-panel");
        v = new a("minutes-office-sdk-recording-ai-interpretation", "Recording AI Interpretation", "Tap to open AI interpretation settings", "minutes-office-sdk-ai-interpretation-panel");
        w = new a("minutes-office-sdk-recording-share", "Share Recording", "Tap to share the current recording", "minutes-office-sdk-share-sheet");
        x = new a("minutes-office-sdk-language-panel", "Recording Language Panel", "Shows spoken and translation language settings", "minutes-office-sdk-language-panel");
        y = new a("minutes-office-sdk-language-panel-close", "Close Recording Language Panel", "Tap to close recording language settings", "minutes-office-sdk-recording-page");
        z = new a("minutes-office-sdk-spoken-language-entry", "Spoken Language Entry", "Tap to choose the spoken language", "minutes-office-sdk-spoken-language-panel");
        A = new a("minutes-office-sdk-spoken-language-current", "Current Spoken Language", "Shows the current spoken language", "minutes-office-sdk-spoken-language-entry");
        B = new a("minutes-office-sdk-spoken-language-item", "Spoken Language Option", "Tap to select a spoken language", "minutes-office-sdk-spoken-language-panel");
        C = new a("minutes-office-sdk-spoken-language-selected", "Selected Spoken Language", "Shows the selected spoken language", "minutes-office-sdk-spoken-language-panel");
        D = new a("minutes-office-sdk-translate-language-entry", "Translation Language Entry", "Tap to choose the translation language", "minutes-office-sdk-translate-language-panel");
        E = new a("minutes-office-sdk-translate-language-current", "Current Translation Language", "Shows the current translation language", "minutes-office-sdk-translate-language-entry");
        F = new a("minutes-office-sdk-translate-language-item", "Translation Language Option", "Tap to select a translation language", "minutes-office-sdk-translate-language-panel");
        G = new a("minutes-office-sdk-translate-language-selected", "Selected Translation Language", "Shows the selected translation language", "minutes-office-sdk-translate-language-panel");
        H = new a("minutes-office-sdk-spoken-language-panel", "Spoken Language Panel", "Shows available spoken languages", "minutes-office-sdk-spoken-language-panel");
        I = new a("minutes-office-sdk-spoken-language-list", "Spoken Language List", "Shows selectable spoken languages", "minutes-office-sdk-spoken-language-list");
        J = new a("minutes-office-sdk-spoken-language-back", "Back from Spoken Language Panel", "Tap to return to recording language settings", "minutes-office-sdk-language-panel");
        K = new a("minutes-office-sdk-translate-language-panel", "Translation Language Panel", "Shows available translation languages", "minutes-office-sdk-translate-language-panel");
        L = new a("minutes-office-sdk-translate-language-list", "Translation Language List", "Shows selectable translation languages", "minutes-office-sdk-translate-language-list");
        M = new a("minutes-office-sdk-translate-language-back", "Back from Translation Language Panel", "Tap to return to recording language settings", "minutes-office-sdk-language-panel");
        N = new a("minutes-office-sdk-bilingual-switch", "Bilingual Transcript Switch", "Toggle bilingual transcript display", "minutes-office-sdk-translate-language-panel");
        O = new a("minutes-office-sdk-audio-save-panel", "Audio Save Settings Panel", "Shows audio save choices", "minutes-office-sdk-audio-save-panel");
        P = new a("minutes-office-sdk-audio-save-panel-close", "Close Audio Save Settings", "Tap to close audio save settings", "minutes-office-sdk-recording-page");
        Q = new a("minutes-office-sdk-audio-save-option", "Save Recording Audio", "Tap to save recording audio", "minutes-office-sdk-audio-save-panel");
        R = new a("minutes-office-sdk-audio-save-selected", "Save Recording Audio Selected", "Shows that recording audio will be saved", "minutes-office-sdk-audio-save-panel");
        S = new a("minutes-office-sdk-audio-not-save-option", "Do Not Save Recording Audio", "Tap to avoid saving recording audio", "minutes-office-sdk-audio-save-panel");
        T = new a("minutes-office-sdk-audio-not-save-selected", "Do Not Save Recording Audio Selected", "Shows that only the transcript will be saved", "minutes-office-sdk-audio-save-panel");
        U = new a("minutes-office-sdk-ai-interpretation-panel", "AI Interpretation Panel", "Shows AI interpretation language and controls", "minutes-office-sdk-ai-interpretation-panel");
        V = new a("minutes-office-sdk-ai-interpretation-panel-close", "Close AI Interpretation Panel", "Tap to close AI interpretation settings", "minutes-office-sdk-recording-page");
        W = new a("minutes-office-sdk-ai-interpretation-start", "Start AI Interpretation", "Tap to start AI interpretation", "minutes-office-sdk-recording-page");
        X = new a("minutes-office-sdk-ai-interpretation-stop", "Stop AI Interpretation", "Tap to stop AI interpretation", "minutes-office-sdk-recording-page");
        Y = new a("minutes-office-sdk-recording-float", "Recording Float Window", "Tap to restore the full recording page", "minutes-office-sdk-recording-page");
        Z = new a("minutes-office-sdk-recording-float-pause-resume", "Float Window Pause or Resume", "Tap to pause or resume recording from the float window", "minutes-office-sdk-recording-float");
        a0 = new a("minutes-office-sdk-recording-float-duration", "Float Window Recording Duration", "Shows the current recording duration in the float window", "minutes-office-sdk-recording-float-duration");
        b0 = new a("minutes-office-sdk-recording-float-wave", "Float Window Recording Wave", "Shows recording audio activity in the float window", "minutes-office-sdk-recording-float-wave");
        c0 = new a("minutes-office-sdk-end-window-activity", "OfficeSDK End Window Activity", "Hosts the OfficeSDK recording end window", "minutes-office-sdk-end-window-page");
        d0 = new a("minutes-office-sdk-end-window-page", "OfficeSDK End Window Page", "Shows the completed recording end window", "minutes-office-sdk-end-window-page");
        e0 = new a("minutes-office-sdk-end-window-close", "Close OfficeSDK End Window", "Tap to close the recording end window", "minutes-office-sdk-source-page");
    }
}
