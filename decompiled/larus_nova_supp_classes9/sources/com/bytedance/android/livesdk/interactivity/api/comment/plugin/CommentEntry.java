package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentEntry;", BuildConfig.FLAVOR, "Click", "WannaSendAtEvent", "WannaSendEvent", "OpenPanelEvent", "GuideEvent", "SendFailed", "SendException", "ChatChannelWannaEvent", "SquareChatEvent", "SecretChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentEntry extends Enum<CommentEntry> {
    public static final CommentEntry ChatChannelWannaEvent = null;
    public static final CommentEntry Click = null;
    public static final CommentEntry GuideEvent = null;
    public static final CommentEntry OpenPanelEvent = null;
    public static final CommentEntry SecretChat = null;
    public static final CommentEntry SendException = null;
    public static final CommentEntry SendFailed = null;
    public static final CommentEntry SquareChatEvent = null;
    public static final CommentEntry WannaSendAtEvent = null;
    public static final CommentEntry WannaSendEvent = null;
    public static final /* synthetic */ CommentEntry[] a = null;

    static {
        CommentEntry r1 = new CommentEntry("Click", 0);
        Click = r1;
        CommentEntry r2 = new CommentEntry("WannaSendAtEvent", 1);
        WannaSendAtEvent = r2;
        CommentEntry r3 = new CommentEntry("WannaSendEvent", 2);
        WannaSendEvent = r3;
        CommentEntry r4 = new CommentEntry("OpenPanelEvent", 3);
        OpenPanelEvent = r4;
        CommentEntry r5 = new CommentEntry("GuideEvent", 4);
        GuideEvent = r5;
        CommentEntry r6 = new CommentEntry("SendFailed", 5);
        SendFailed = r6;
        CommentEntry r7 = new CommentEntry("SendException", 6);
        SendException = r7;
        CommentEntry r8 = new CommentEntry("ChatChannelWannaEvent", 7);
        ChatChannelWannaEvent = r8;
        CommentEntry r9 = new CommentEntry("SquareChatEvent", 8);
        SquareChatEvent = r9;
        CommentEntry r10 = new CommentEntry("SecretChat", 9);
        SecretChat = r10;
        a = new CommentEntry[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static CommentEntry valueOf(String r1) {
        return (CommentEntry) a.a(CommentEntry.class, r1);
    }

    public static CommentEntry[] values() {
        return (CommentEntry[]) a.clone();
    }

    public CommentEntry(String r1, int r2) {
        super(r1, r2);
    }
}
