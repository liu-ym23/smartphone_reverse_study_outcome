package go1;

import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class i1 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AbsKtvControlWidget.WidgetType.values().length];
        a = r0;
        r0[AbsKtvControlWidget.WidgetType.KTV_AUDIENCE.ordinal()] = 1;
        r0[AbsKtvControlWidget.WidgetType.KTV_ANCHOR.ordinal()] = 2;
        r0[AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_UI_WIDGET.ordinal()] = 3;
        r0[AbsKtvControlWidget.WidgetType.CHORUS.ordinal()] = 4;
        r0[AbsKtvControlWidget.WidgetType.MULTI_CHORUS.ordinal()] = 5;
        r0[AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_AUDIENCE_LOGIC.ordinal()] = 6;
        r0[AbsKtvControlWidget.WidgetType.KTV_COMPONENT_V2_ANCHOR_LOGIC.ordinal()] = 7;
        r0[AbsKtvControlWidget.WidgetType.MIDI_DEBUG_VIEW.ordinal()] = 8;
    }
}
