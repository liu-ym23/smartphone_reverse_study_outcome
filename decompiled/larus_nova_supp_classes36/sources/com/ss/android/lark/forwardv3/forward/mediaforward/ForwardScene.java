package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/mediaforward/ForwardScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "FAVORITE", "TODO", "Moments", "Mark", "Message", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForwardScene extends Enum<ForwardScene> {
    public static final ForwardScene CHAT = null;
    public static final a Companion = null;
    public static final ForwardScene FAVORITE = null;
    public static final ForwardScene Mark = null;
    public static final ForwardScene Message = null;
    public static final ForwardScene Moments = null;
    public static final ForwardScene TODO = null;
    public static final ForwardScene UNKNOWN = null;
    public static final /* synthetic */ ForwardScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ForwardScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.forward.mediaforward.ForwardScene$a] */
    static {
        ForwardScene r0 = new ForwardScene("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ForwardScene r1 = new ForwardScene("CHAT", 1, 1);
        CHAT = r1;
        ForwardScene r3 = new ForwardScene("FAVORITE", 2, 2);
        FAVORITE = r3;
        ForwardScene r5 = new ForwardScene("TODO", 3, 3);
        TODO = r5;
        ForwardScene r7 = new ForwardScene("Moments", 4, 4);
        Moments = r7;
        ForwardScene r9 = new ForwardScene("Mark", 5, 5);
        Mark = r9;
        ForwardScene r11 = new ForwardScene("Message", 6, 6);
        Message = r11;
        ForwardScene[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static ForwardScene[] values() {
        return (ForwardScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForwardScene valueOf(String r1) {
        return (ForwardScene) r27.a.a(ForwardScene.class, r1);
    }

    public ForwardScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
