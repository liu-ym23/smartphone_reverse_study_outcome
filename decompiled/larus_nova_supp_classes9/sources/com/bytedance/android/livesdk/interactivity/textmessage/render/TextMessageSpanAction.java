package com.bytedance.android.livesdk.interactivity.textmessage.render;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textmessage/render/TextMessageSpanAction;", BuildConfig.FLAVOR, "Ltb2/b;", "CHAT_CONTENT", "INVITOR_NAME", "INVITEE_NAME", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TextMessageSpanAction extends Enum<TextMessageSpanAction> implements tb2.b {
    public static final TextMessageSpanAction CHAT_CONTENT = null;
    public static final TextMessageSpanAction INVITEE_NAME = null;
    public static final TextMessageSpanAction INVITOR_NAME = null;
    public static final /* synthetic */ TextMessageSpanAction[] a = null;

    static {
        TextMessageSpanAction r1 = new TextMessageSpanAction("CHAT_CONTENT", 0);
        CHAT_CONTENT = r1;
        TextMessageSpanAction r2 = new TextMessageSpanAction("INVITOR_NAME", 1);
        INVITOR_NAME = r2;
        TextMessageSpanAction r3 = new TextMessageSpanAction("INVITEE_NAME", 2);
        INVITEE_NAME = r3;
        a = new TextMessageSpanAction[]{r1, r2, r3};
    }

    public static TextMessageSpanAction valueOf(String r1) {
        return (TextMessageSpanAction) r27.a.a(TextMessageSpanAction.class, r1);
    }

    public static TextMessageSpanAction[] values() {
        return (TextMessageSpanAction[]) a.clone();
    }

    public TextMessageSpanAction(String r1, int r2) {
        super(r1, r2);
    }
}
