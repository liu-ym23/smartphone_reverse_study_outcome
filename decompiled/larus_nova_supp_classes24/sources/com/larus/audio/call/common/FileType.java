package com.larus.audio.call.common;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/common/FileType;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FileType {
    public static final int AEC_OUT = 18;
    public static final int ALL_TTS = 3;
    public static final int ALL_TTS_RAW = 7;
    public static final int AUDIO_TRACK = 19;
    public static final int BACKTRACE_RECORD = 20;
    public static final a Companion = null;
    public static final int FIRST_FRAME = 12;
    public static final int OPUS_RECORD_SEND = 13;
    public static final int PLAY = 2;
    public static final int PLAY_PROCESSED = 8;
    public static final int PLAY_PROCESSED_WITH_SILENT = 10;
    public static final int PLAY_RAW = 5;
    public static final int PLAY_RAW_WITH_SILENT = 9;
    public static final int PRODUCE_EMPTY = 6;
    public static final int RECORD = 0;
    public static final int REF = 4;
    public static final int SI_PLAY_LEFT = 14;
    public static final int SI_PLAY_MERGE = 16;
    public static final int SI_PLAY_RIGHT = 15;
    public static final int STREAM_PLAYER = 11;
    public static final int TTS = 1;
    public static final int VIDEO = 17;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
