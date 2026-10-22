package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J+\u0010\f\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R6\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/bean/BotGenAvatarByPromptResult;", "", "avatarList", "Ljava/util/ArrayList;", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getAvatarList", "()Ljava/util/ArrayList;", "setAvatarList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotGenAvatarByPromptResult {

    @SerializedName("icons")
    private ArrayList<BotAvatarIconData> avatarList;

    public BotGenAvatarByPromptResult() {
        ArrayList r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotGenAvatarByPromptResult copy$default(BotGenAvatarByPromptResult r0, ArrayList r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.avatarList;
    L6:
        return r0.copy(r1);
    }

    public final ArrayList<BotAvatarIconData> component1() {
        return this.avatarList;
    }

    public final BotGenAvatarByPromptResult copy(ArrayList<BotAvatarIconData> r2) {
        return new BotGenAvatarByPromptResult(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BotGenAvatarByPromptResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.avatarList, ((BotGenAvatarByPromptResult) r4).avatarList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ArrayList<BotAvatarIconData> r0 = this.avatarList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "BotGenAvatarByPromptResult(avatarList=" + this.avatarList + ')';
    }

    public final ArrayList<BotAvatarIconData> getAvatarList() {
        return this.avatarList;
    }

    public BotGenAvatarByPromptResult(ArrayList<BotAvatarIconData> r1) {
        this.avatarList = r1;
    }

    public final void setAvatarList(ArrayList<BotAvatarIconData> r1) {
        this.avatarList = r1;
    }

    public /* synthetic */ BotGenAvatarByPromptResult(ArrayList r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1);
    }
}
