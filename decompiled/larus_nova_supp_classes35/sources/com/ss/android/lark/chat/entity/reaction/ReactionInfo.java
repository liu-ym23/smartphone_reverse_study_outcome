package com.ss.android.lark.chat.entity.reaction;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ReactionInfo implements Serializable, b<ReactionInfo> {
    private Reaction reaction;
    private Map<String, ChatChatter> reactionChatters;

    public boolean isItemSame(ReactionInfo r1) {
        return true;
    }

    public Reaction getReaction() {
        return this.reaction;
    }

    public Map<String, ChatChatter> getReactionChatters() {
        return this.reactionChatters;
    }

    public boolean isContentSame(ReactionInfo r6) {
        if (this.reaction.isContentSame(r6.reaction) == true) goto L6;
        return false;
    L6:
        if (this.reactionChatters.size() == r6.reactionChatters.size()) goto L8;
    L18:
        return false;
    L8:
        if (this.reactionChatters.values().containsAll(r6.reactionChatters.values()) == false) goto L18;
        Iterator<String> r0 = this.reactionChatters.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L16;
        String r2 = r0.next();
        if (a.c(this.reactionChatters.get(r2), r6.reactionChatters.get(r2)) == true) goto L12;
        return false;
    L16:
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((ReactionInfo) r1);
    }

    public void setReaction(Reaction r1) {
        this.reaction = r1;
    }

    public void setReactionChatters(Map<String, ChatChatter> r1) {
        this.reactionChatters = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((ReactionInfo) r1);
    }

    public ReactionInfo(Reaction r2, Map<String, ChatChatter> r3) {
        new HashMap();
        this.reaction = r2;
        this.reactionChatters = r3;
    }
}
