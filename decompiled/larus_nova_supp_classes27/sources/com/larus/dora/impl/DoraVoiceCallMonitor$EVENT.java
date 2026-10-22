package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/DoraVoiceCallMonitor$EVENT;", "", "<init>", "(Ljava/lang/String;I)V", "VAD_END", "TTS_START", "VAD_END_TX", "TTS_START_RX", "QUERY_START", "QUERY_END", "CLIENT_VAD_END", "CLIENT_TTS_START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraVoiceCallMonitor$EVENT extends Enum<DoraVoiceCallMonitor$EVENT> {
    public static final DoraVoiceCallMonitor$EVENT CLIENT_TTS_START = null;
    public static final DoraVoiceCallMonitor$EVENT CLIENT_VAD_END = null;
    public static final DoraVoiceCallMonitor$EVENT QUERY_END = null;
    public static final DoraVoiceCallMonitor$EVENT QUERY_START = null;
    public static final DoraVoiceCallMonitor$EVENT TTS_START = null;
    public static final DoraVoiceCallMonitor$EVENT TTS_START_RX = null;
    public static final DoraVoiceCallMonitor$EVENT VAD_END = null;
    public static final DoraVoiceCallMonitor$EVENT VAD_END_TX = null;
    public static final /* synthetic */ DoraVoiceCallMonitor$EVENT[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraVoiceCallMonitor$EVENT> getEntries() {
        return b;
    }

    static {
        DoraVoiceCallMonitor$EVENT r0 = new DoraVoiceCallMonitor$EVENT("VAD_END", 0);
        VAD_END = r0;
        DoraVoiceCallMonitor$EVENT r1 = new DoraVoiceCallMonitor$EVENT("TTS_START", 1);
        TTS_START = r1;
        DoraVoiceCallMonitor$EVENT r3 = new DoraVoiceCallMonitor$EVENT("VAD_END_TX", 2);
        VAD_END_TX = r3;
        DoraVoiceCallMonitor$EVENT r5 = new DoraVoiceCallMonitor$EVENT("TTS_START_RX", 3);
        TTS_START_RX = r5;
        DoraVoiceCallMonitor$EVENT r7 = new DoraVoiceCallMonitor$EVENT("QUERY_START", 4);
        QUERY_START = r7;
        DoraVoiceCallMonitor$EVENT r9 = new DoraVoiceCallMonitor$EVENT("QUERY_END", 5);
        QUERY_END = r9;
        DoraVoiceCallMonitor$EVENT r11 = new DoraVoiceCallMonitor$EVENT("CLIENT_VAD_END", 6);
        CLIENT_VAD_END = r11;
        DoraVoiceCallMonitor$EVENT r13 = new DoraVoiceCallMonitor$EVENT("CLIENT_TTS_START", 7);
        CLIENT_TTS_START = r13;
        DoraVoiceCallMonitor$EVENT[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DoraVoiceCallMonitor$EVENT[] values() {
        return (DoraVoiceCallMonitor$EVENT[]) a.clone();
    }

    public static DoraVoiceCallMonitor$EVENT valueOf(String r1) {
        return (DoraVoiceCallMonitor$EVENT) a.a(DoraVoiceCallMonitor$EVENT.class, r1);
    }

    public DoraVoiceCallMonitor$EVENT(String r1, int r2) {
        super(r1, r2);
    }
}
