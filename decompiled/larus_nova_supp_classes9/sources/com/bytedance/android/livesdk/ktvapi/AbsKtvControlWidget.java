package com.bytedance.android.livesdk.ktvapi;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget;", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvSeiWidget;", "<init>", "()V", "a", "WidgetType", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKtvControlWidget extends AbsKtvSeiWidget {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget$WidgetType;", BuildConfig.FLAVOR, "KTV_AUDIENCE", "KTV_ANCHOR", "KTV_AUDIO_ROOM", "KTV_COMPONENT_V2_ANCHOR_LOGIC", "KTV_COMPONENT_V2_AUDIENCE_LOGIC", "KTV_COMPONENT_V2_UI_WIDGET", "CHORUS", "MULTI_CHORUS", "KTV_MV", "MIDI_DEBUG_VIEW", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum WidgetType extends Enum<WidgetType> {
        public static final WidgetType CHORUS = null;
        public static final WidgetType KTV_ANCHOR = null;
        public static final WidgetType KTV_AUDIENCE = null;
        public static final WidgetType KTV_AUDIO_ROOM = null;
        public static final WidgetType KTV_COMPONENT_V2_ANCHOR_LOGIC = null;
        public static final WidgetType KTV_COMPONENT_V2_AUDIENCE_LOGIC = null;
        public static final WidgetType KTV_COMPONENT_V2_UI_WIDGET = null;
        public static final WidgetType KTV_MV = null;
        public static final WidgetType MIDI_DEBUG_VIEW = null;
        public static final WidgetType MULTI_CHORUS = null;
        public static final /* synthetic */ WidgetType[] a = null;

        static {
            WidgetType r1 = new WidgetType("KTV_AUDIENCE", 0);
            KTV_AUDIENCE = r1;
            WidgetType r2 = new WidgetType("KTV_ANCHOR", 1);
            KTV_ANCHOR = r2;
            WidgetType r3 = new WidgetType("KTV_AUDIO_ROOM", 2);
            KTV_AUDIO_ROOM = r3;
            WidgetType r4 = new WidgetType("KTV_COMPONENT_V2_ANCHOR_LOGIC", 3);
            KTV_COMPONENT_V2_ANCHOR_LOGIC = r4;
            WidgetType r5 = new WidgetType("KTV_COMPONENT_V2_AUDIENCE_LOGIC", 4);
            KTV_COMPONENT_V2_AUDIENCE_LOGIC = r5;
            WidgetType r6 = new WidgetType("KTV_COMPONENT_V2_UI_WIDGET", 5);
            KTV_COMPONENT_V2_UI_WIDGET = r6;
            WidgetType r7 = new WidgetType("CHORUS", 6);
            CHORUS = r7;
            WidgetType r8 = new WidgetType("MULTI_CHORUS", 7);
            MULTI_CHORUS = r8;
            WidgetType r9 = new WidgetType("KTV_MV", 8);
            KTV_MV = r9;
            WidgetType r10 = new WidgetType("MIDI_DEBUG_VIEW", 9);
            MIDI_DEBUG_VIEW = r10;
            a = new WidgetType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        }

        public static WidgetType valueOf(String r1) {
            return (WidgetType) r27.a.a(WidgetType.class, r1);
        }

        public static WidgetType[] values() {
            return (WidgetType[]) a.clone();
        }

        public WidgetType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(WidgetType r1, Widget r2);

        void k(Widget r1);
    }

    public AbsKtvControlWidget() {
    }
}
