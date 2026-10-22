package com.ss.android.lark.forwardv2.impl.statistics;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/ForwardHitpointExtraParams$LeaveAMessage;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", TabAppInfo.IMAGE_JSON_KEY, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "True", "False", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForwardHitpointExtraParams$LeaveAMessage extends Enum<ForwardHitpointExtraParams$LeaveAMessage> implements d {
    public static final ForwardHitpointExtraParams$LeaveAMessage False = null;
    public static final ForwardHitpointExtraParams$LeaveAMessage True = null;
    public static final /* synthetic */ ForwardHitpointExtraParams$LeaveAMessage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;
    private final String value;

    public ForwardHitpointExtraParams$LeaveAMessage() {
        throw null;
    }

    public static EnumEntries<ForwardHitpointExtraParams$LeaveAMessage> getEntries() {
        return b;
    }

    static {
        ForwardHitpointExtraParams$LeaveAMessage r7 = new ForwardHitpointExtraParams$LeaveAMessage("True", 0, "true", null, 2, null);
        True = r7;
        ForwardHitpointExtraParams$LeaveAMessage r0 = new ForwardHitpointExtraParams$LeaveAMessage("False", 1, "false", null, 2, null);
        False = r0;
        ForwardHitpointExtraParams$LeaveAMessage[] r1 = {r7, r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public static ForwardHitpointExtraParams$LeaveAMessage[] values() {
        return (ForwardHitpointExtraParams$LeaveAMessage[]) a.clone();
    }

    public JSONObject toJson() {
        return d.b.c(this);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public static ForwardHitpointExtraParams$LeaveAMessage valueOf(String r1) {
        return (ForwardHitpointExtraParams$LeaveAMessage) a.a(ForwardHitpointExtraParams$LeaveAMessage.class, r1);
    }

    public d plus(Map<String, ? extends Object> r1) {
        return d.b.a(this, r1);
    }

    public d plus(d r1) {
        return d.b.b(this, r1);
    }

    public ForwardHitpointExtraParams$LeaveAMessage(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "leave_a_message";
    L5:
        super(r1, r2);
        this.value = r3;
        this.key = r4;
    }
}
