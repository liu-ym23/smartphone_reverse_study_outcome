package com.ss.android.lark.picker.uitls;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.uitls.parse.ChatParser;
import com.ss.android.lark.picker.uitls.parse.ChatterParser;
import com.ss.android.lark.picker.uitls.parse.ReplyInThreadParser;
import com.ss.android.lark.picker.uitls.parse.ShieldP2PChatParser;
import com.ss.android.lark.picker.uitls.parse.ThreadParser;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/ss/android/lark/picker/uitls/PickerDataUtils;", "", "<init>", "()V", "chatParser", "Lcom/ss/android/lark/picker/uitls/parse/ChatParser;", "getChatParser", "()Lcom/ss/android/lark/picker/uitls/parse/ChatParser;", "chatParser$delegate", "Lkotlin/Lazy;", "chatterParser", "Lcom/ss/android/lark/picker/uitls/parse/ChatterParser;", "getChatterParser", "()Lcom/ss/android/lark/picker/uitls/parse/ChatterParser;", "chatterParser$delegate", "threadParser", "Lcom/ss/android/lark/picker/uitls/parse/ThreadParser;", "getThreadParser", "()Lcom/ss/android/lark/picker/uitls/parse/ThreadParser;", "threadParser$delegate", "replyInThreadParser", "Lcom/ss/android/lark/picker/uitls/parse/ReplyInThreadParser;", "getReplyInThreadParser", "()Lcom/ss/android/lark/picker/uitls/parse/ReplyInThreadParser;", "replyInThreadParser$delegate", "shieldP2PChatParser", "Lcom/ss/android/lark/picker/uitls/parse/ShieldP2PChatParser;", "getShieldP2PChatParser", "()Lcom/ss/android/lark/picker/uitls/parse/ShieldP2PChatParser;", "shieldP2PChatParser$delegate", "parseForwardCommonData2SearchBaseInfo", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "pb", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerDataUtils {
    public static final PickerDataUtils INSTANCE = null;
    private static final Lazy chatParser$delegate = null;
    private static final Lazy chatterParser$delegate = null;
    private static final Lazy replyInThreadParser$delegate = null;
    private static final Lazy shieldP2PChatParser$delegate = null;
    private static final Lazy threadParser$delegate = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ForwardCommonData.ItemType.values().length];
            r0[ForwardCommonData.ItemType.ITEM_TYPE_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ForwardCommonData.ItemType.ITEM_TYPE_CHATTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ForwardCommonData.ItemType.ITEM_TYPE_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ForwardCommonData.ItemType.ITEM_TYPE_REPLY_IN_THREAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ForwardCommonData.ItemType.ITEM_TYPE_SHIELD_P2P_CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private PickerDataUtils() {
    }

    static {
        INSTANCE = new PickerDataUtils();
        chatParser$delegate = LazyKt.lazy(PickerDataUtils$chatParser$2.INSTANCE);
        chatterParser$delegate = LazyKt.lazy(PickerDataUtils$chatterParser$2.INSTANCE);
        threadParser$delegate = LazyKt.lazy(PickerDataUtils$threadParser$2.INSTANCE);
        replyInThreadParser$delegate = LazyKt.lazy(PickerDataUtils$replyInThreadParser$2.INSTANCE);
        shieldP2PChatParser$delegate = LazyKt.lazy(PickerDataUtils$shieldP2PChatParser$2.INSTANCE);
    }

    private final ChatParser getChatParser() {
        return (ChatParser) chatParser$delegate.getValue();
    }

    private final ChatterParser getChatterParser() {
        return (ChatterParser) chatterParser$delegate.getValue();
    }

    private final ReplyInThreadParser getReplyInThreadParser() {
        return (ReplyInThreadParser) replyInThreadParser$delegate.getValue();
    }

    private final ShieldP2PChatParser getShieldP2PChatParser() {
        return (ShieldP2PChatParser) shieldP2PChatParser$delegate.getValue();
    }

    private final ThreadParser getThreadParser() {
        return (ThreadParser) threadParser$delegate.getValue();
    }

    public final SearchBaseInfo parseForwardCommonData2SearchBaseInfo(ForwardCommonData r3) {
        Intrinsics.checkNotNullParameter(r3, "pb");
        ForwardCommonData.ItemType r0 = r3.item_type;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L27;
        if (r1 == 3) goto L26;
        if (r1 == 4) goto L25;
        if (r1 == 5) goto L24;
        return null;
    L24:
        return getShieldP2PChatParser().parse2(r3, r3.shieldP2PChatInfo);
    L25:
        return getReplyInThreadParser().parse2(r3, r3.replyInThread);
    L26:
        return getThreadParser().parse2(r3, r3.thread);
    L27:
        return getChatterParser().parse2(r3, r3.chatter);
    L22:
        return getChatParser().parse2(r3, r3.chat);
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }
}
