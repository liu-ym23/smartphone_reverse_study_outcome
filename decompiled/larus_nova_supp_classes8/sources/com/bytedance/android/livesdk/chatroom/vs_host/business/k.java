package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdk.event.ISendCommentEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[SendReplayTextEvent.Sender.values().length];
        a = r0;
        r0[SendReplayTextEvent.Sender.CommentWidget.ordinal()] = 1;
        r0[SendReplayTextEvent.Sender.Lottery.ordinal()] = 2;
        r0[SendReplayTextEvent.Sender.VsPlusOne.ordinal()] = 3;
        r0[SendReplayTextEvent.Sender.Unknown.ordinal()] = 4;
        int[] r1 = new int[ISendCommentEvent.Sender.values().length];
        b = r1;
        r1[ISendCommentEvent.Sender.CommentWidget.ordinal()] = 1;
        r1[ISendCommentEvent.Sender.Lottery.ordinal()] = 2;
        r1[ISendCommentEvent.Sender.VsPlusOne.ordinal()] = 3;
        r1[ISendCommentEvent.Sender.Unknown.ordinal()] = 4;
    }
}
