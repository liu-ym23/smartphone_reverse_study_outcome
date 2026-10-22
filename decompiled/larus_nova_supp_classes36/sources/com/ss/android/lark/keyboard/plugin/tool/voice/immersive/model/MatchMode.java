package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/MatchMode;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "ClientMode", "ServerMode", "ServerWithClientMode", "toString", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MatchMode extends Enum<MatchMode> {
    public static final MatchMode ClientMode = null;
    public static final MatchMode ServerMode = null;
    public static final MatchMode ServerWithClientMode = null;
    public static final /* synthetic */ MatchMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int mode;

    public static EnumEntries<MatchMode> getEntries() {
        return b;
    }

    static {
        MatchMode r0 = new MatchMode("ClientMode", 0, 0);
        ClientMode = r0;
        MatchMode r1 = new MatchMode("ServerMode", 1, 1);
        ServerMode = r1;
        MatchMode r3 = new MatchMode("ServerWithClientMode", 2, 2);
        ServerWithClientMode = r3;
        MatchMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MatchMode[] values() {
        return (MatchMode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.mode;
        if (r0 != 0) goto L5;
        return "ClientMode";
    L5:
        if (r0 != 1) goto L7;
        return "ServerMode";
    L7:
        if (r0 != 2) goto L14;
        return "ServerWithClientMode";
    L14:
        return "ClientMode";
    }

    public static MatchMode valueOf(String r1) {
        return (MatchMode) r27.a.a(MatchMode.class, r1);
    }

    public MatchMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mode = r3;
    }
}
