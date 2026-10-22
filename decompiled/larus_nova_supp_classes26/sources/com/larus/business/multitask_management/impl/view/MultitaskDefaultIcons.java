package com.larus.business.multitask_management.impl.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0019"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/MultitaskDefaultIcons;", "", "uri", "", "resIdProvider", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getUri", "()Ljava/lang/String;", "PLAY", "PAUSE", "RIGHT", "RECORDING_ICON", "AI_SIMULT_TRANS_ICON", "RECORDING_PAUSE", "RECORDING_RESUME", "QUICK_ACCESS_DOC", "QUICK_ACCESS_PPT", "QUICK_ACCESS_SHEET", "QUICK_ACCESS_FOLDER", "resId", "getResId", "()I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultitaskDefaultIcons extends Enum<MultitaskDefaultIcons> {
    public static final MultitaskDefaultIcons AI_SIMULT_TRANS_ICON = null;
    public static final MultitaskDefaultIcons PAUSE = null;
    public static final MultitaskDefaultIcons PLAY = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_DOC = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_FOLDER = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_PPT = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_SHEET = null;
    public static final MultitaskDefaultIcons RECORDING_ICON = null;
    public static final MultitaskDefaultIcons RECORDING_PAUSE = null;
    public static final MultitaskDefaultIcons RECORDING_RESUME = null;
    public static final MultitaskDefaultIcons RIGHT = null;
    public static final /* synthetic */ MultitaskDefaultIcons[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final Function0<Integer> resIdProvider;
    private final String uri;

    public static EnumEntries<MultitaskDefaultIcons> getEntries() {
        return b;
    }

    static {
        MultitaskDefaultIcons r0 = new MultitaskDefaultIcons("PLAY", 0, "multitask_play", new i());
        PLAY = r0;
        MultitaskDefaultIcons r1 = new MultitaskDefaultIcons("PAUSE", 1, "multitask_pause", new l());
        PAUSE = r1;
        MultitaskDefaultIcons r2 = new MultitaskDefaultIcons("RIGHT", 2, "multitask_right_arrow", new m());
        RIGHT = r2;
        MultitaskDefaultIcons r4 = new MultitaskDefaultIcons("RECORDING_ICON", 3, "multitask_recording_icon", new n());
        RECORDING_ICON = r4;
        MultitaskDefaultIcons r6 = new MultitaskDefaultIcons("AI_SIMULT_TRANS_ICON", 4, "multitask_ai_simult_trans_icon", new o());
        AI_SIMULT_TRANS_ICON = r6;
        MultitaskDefaultIcons r8 = new MultitaskDefaultIcons("RECORDING_PAUSE", 5, "multitask_recording_icon_pause", new p());
        RECORDING_PAUSE = r8;
        MultitaskDefaultIcons r10 = new MultitaskDefaultIcons("RECORDING_RESUME", 6, "multitask_recording_icon_resume", new q());
        RECORDING_RESUME = r10;
        MultitaskDefaultIcons r12 = new MultitaskDefaultIcons("QUICK_ACCESS_DOC", 7, QuickAccessNodeDefaultIcons.DOC.getUri(), new r());
        QUICK_ACCESS_DOC = r12;
        MultitaskDefaultIcons r13 = new MultitaskDefaultIcons("QUICK_ACCESS_PPT", 8, QuickAccessNodeDefaultIcons.PPT.getUri(), new s());
        QUICK_ACCESS_PPT = r13;
        MultitaskDefaultIcons r11 = new MultitaskDefaultIcons("QUICK_ACCESS_SHEET", 9, QuickAccessNodeDefaultIcons.SHEET.getUri(), new j());
        QUICK_ACCESS_SHEET = r11;
        MultitaskDefaultIcons r9 = new MultitaskDefaultIcons("QUICK_ACCESS_FOLDER", 10, QuickAccessNodeDefaultIcons.FOLDER.getUri(), new k());
        QUICK_ACCESS_FOLDER = r9;
        MultitaskDefaultIcons[] r7 = {r0, r1, r2, r4, r6, r8, r10, r12, r13, r11, r9};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MultitaskDefaultIcons[] values() {
        return (MultitaskDefaultIcons[]) a.clone();
    }

    public final int getResId() {
        return ((Number) this.resIdProvider.invoke()).intValue();
    }

    public final String getUri() {
        return this.uri;
    }

    public static MultitaskDefaultIcons valueOf(String r1) {
        return (MultitaskDefaultIcons) r27.a.a(MultitaskDefaultIcons.class, r1);
    }

    public MultitaskDefaultIcons(String r1, int r2, String r3, Function0 r4) {
        super(r1, r2);
        this.uri = r3;
        this.resIdProvider = r4;
    }
}
