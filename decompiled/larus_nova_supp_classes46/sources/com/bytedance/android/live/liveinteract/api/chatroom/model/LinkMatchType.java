package com.bytedance.android.live.liveinteract.api.chatroom.model;

import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkMatchType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "NONE", "MATCH", "SHAKE_MATCH", "SING_MATCH", "MORE", "AGAIN_MATCH", "AGAIN_SHAKE", "MORE_ROOM", "RECOMMEND_ROOM", "TRY_AGAIN", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkMatchType extends Enum<LinkMatchType> {
    public static final LinkMatchType AGAIN_MATCH = null;
    public static final LinkMatchType AGAIN_SHAKE = null;
    public static final a Companion = null;
    public static final LinkMatchType MATCH = null;
    public static final LinkMatchType MORE = null;
    public static final LinkMatchType MORE_ROOM = null;
    public static final LinkMatchType NONE = null;
    public static final LinkMatchType RECOMMEND_ROOM = null;
    public static final LinkMatchType SHAKE_MATCH = null;
    public static final LinkMatchType SING_MATCH = null;
    public static final LinkMatchType TRY_AGAIN = null;
    public static final /* synthetic */ LinkMatchType[] a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LinkMatchType a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            LinkMatchType r0 = LinkMatchType.MATCH;
            if (Intrinsics.areEqual(r2, r0.getValue()) == true) goto L19;
            LinkMatchType r1 = LinkMatchType.SHAKE_MATCH;
            if (Intrinsics.areEqual(r2, r1.getValue()) == true) goto L20;
            LinkMatchType r3 = LinkMatchType.SING_MATCH;
            if (Intrinsics.areEqual(r2, r3.getValue()) == true) goto L21;
            LinkMatchType r4 = LinkMatchType.TRY_AGAIN;
            if (Intrinsics.areEqual(r2, r4.getValue()) == true) goto L22;
            LinkMatchType r5 = LinkMatchType.RECOMMEND_ROOM;
            if (Intrinsics.areEqual(r2, r5.getValue()) == false) goto L18;
            return r5;
        L18:
            return LinkMatchType.NONE;
        L22:
            return r4;
        L21:
            return r3;
        L20:
            return r1;
        L19:
            return r0;
        }
    }

    @JvmStatic
    public static final LinkMatchType getMatchType(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static LinkMatchType valueOf(String r1) {
        return (LinkMatchType) r27.a.a(LinkMatchType.class, r1);
    }

    public static LinkMatchType[] values() {
        return (LinkMatchType[]) a.clone();
    }

    static {
        LinkMatchType r1 = new LinkMatchType("NONE", 0, "none");
        NONE = r1;
        LinkMatchType r2 = new LinkMatchType("MATCH", 1, ChatMatchViewModel.ENTER_METHOD_MATCH);
        MATCH = r2;
        LinkMatchType r3 = new LinkMatchType("SHAKE_MATCH", 2, "shake_match");
        SHAKE_MATCH = r3;
        LinkMatchType r4 = new LinkMatchType("SING_MATCH", 3, "sing_match");
        SING_MATCH = r4;
        LinkMatchType r5 = new LinkMatchType("MORE", 4, "more");
        MORE = r5;
        LinkMatchType r6 = new LinkMatchType("AGAIN_MATCH", 5, "again_match");
        AGAIN_MATCH = r6;
        LinkMatchType r7 = new LinkMatchType("AGAIN_SHAKE", 6, "again_shake");
        AGAIN_SHAKE = r7;
        LinkMatchType r8 = new LinkMatchType("MORE_ROOM", 7, "more_room");
        MORE_ROOM = r8;
        LinkMatchType r9 = new LinkMatchType("RECOMMEND_ROOM", 8, "recommend_room");
        RECOMMEND_ROOM = r9;
        LinkMatchType r10 = new LinkMatchType("TRY_AGAIN", 9, "try_again");
        TRY_AGAIN = r10;
        a = new LinkMatchType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public LinkMatchType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
