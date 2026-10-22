package com.larus.bmhome.chat.component.list.pipeline.direct_add;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class UserActiveDeleteTipHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/direct_add/UserActiveDeleteTipHelper$DeleteMsgTipDisplay;", "", "value", "", "textPluralResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getTextPluralResId", "()I", "DELETE", "RECALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum DeleteMsgTipDisplay extends Enum<DeleteMsgTipDisplay> {
        public static final DeleteMsgTipDisplay DELETE = null;
        public static final DeleteMsgTipDisplay RECALL = null;
        public static final /* synthetic */ DeleteMsgTipDisplay[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int textPluralResId;
        private final String value;

        public static EnumEntries<DeleteMsgTipDisplay> getEntries() {
            return b;
        }

        static {
            DeleteMsgTipDisplay r0 = new DeleteMsgTipDisplay("DELETE", 0, "1", 2131755149);
            DELETE = r0;
            DeleteMsgTipDisplay r1 = new DeleteMsgTipDisplay("RECALL", 1, "2", 2131755150);
            RECALL = r1;
            DeleteMsgTipDisplay[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static DeleteMsgTipDisplay[] values() {
            return (DeleteMsgTipDisplay[]) a.clone();
        }

        public final int getTextPluralResId() {
            return this.textPluralResId;
        }

        public final String getValue() {
            return this.value;
        }

        public static DeleteMsgTipDisplay valueOf(String r1) {
            return (DeleteMsgTipDisplay) r27.a.a(DeleteMsgTipDisplay.class, r1);
        }

        public DeleteMsgTipDisplay(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.value = r3;
            this.textPluralResId = r4;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static List b(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
        JSONArray r4 = new JSONArray(r10);     // Catch: Throwable -> L23
        List r5 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L23
        int r6 = r4.length();     // Catch: Throwable -> L23
        int r7 = 0;
    L13:
        if (r7 >= r6) goto L21;
        String r8 = r4.optString(r7);     // Catch: Throwable -> L23
        if ((!StringsKt.isBlank(r8)) == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L20;
        r5.add(r8);     // Catch: Throwable -> L23
    L20:
        r7 = r7 + 1;     // Catch: Throwable -> L23
        goto L13
    L21:
        ?? r9 = Result.constructor-impl(CollectionsKt.build(r5));     // Catch: Throwable -> L23
    L26:
        if (Result.exceptionOrNull-impl(r9) == null) goto L39;
        List r11 = StringsKt.split$default(r10, new char[]{','}, false, 0, 6, null);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L30:
        if (r12.hasNext() == false) goto L32;
        r0.add(StringsKt.trim((String) r12.next()).toString());
        goto L30
    L32:
        r9 = new ArrayList();
        Iterator r13 = r0.iterator();
    L34:
        if (r13.hasNext() == false) goto L39;
        Object r1 = r13.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L34;
        r9.add(r1);
    L39:
        return CollectionsKt.distinct((Iterable) r9);
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static List d(Map r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        if (r5 != null) goto L14;
    L15:
        r0 = true;
    L16:
        String r3 = null;
        if (r0 == true) goto L35;
        String r4 = (String) r5.get("suffix_active_delete_message_id_list");
        if (r4 != null) goto L22;
    L27:
        String r6 = (String) r5.get("sub_active_msg_id_list");
        if (r6 == null) goto L35;
        if ((true ^ StringsKt.isBlank(r6)) == true) goto L33;
        r6 = null;
    L33:
        if (r6 == null) goto L35;
        Pair r7 = TuplesKt.to("sub_active_msg_id_list", r6);
    L36:
        if (r7 == null) goto L39;
        r3 = (String) r7.getSecond();
    L39:
        return b(r3);
    L22:
        if ((!StringsKt.isBlank(r4)) == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        r7 = TuplesKt.to("suffix_active_delete_message_id_list", r4);
    L35:
        r7 = null;
        goto L36
    L14:
        if (r5.isEmpty() == false) goto L16;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r5.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public static List e(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List r0 = d(r2.getExt());
        if (com.larus.im.bean.message.a.y0(r2) == false) goto L5;
    L18:
        Map r3 = r2.getExt();
        if (r3 == null) goto L21;
        String r4 = (String) r3.get("crowd_test_delete_tip_anchor");
    L23:
        if (Intrinsics.areEqual(r4, "1") == false) goto L26;
        return r0;
    L26:
        return CollectionsKt.emptyList();
    L21:
        r4 = null;
        goto L23
    L5:
        if (com.larus.im.bean.message.a.x0(r2) == true) goto L18;
        List r1 = CollectionsKt.createListBuilder();
        r1.addAll(r0);
        if (com.larus.im.bean.message.a.E0(r2) == false) goto L17;
        List r5 = r2.getSubListGroup();
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        Iterator r6 = CollectionsKt.flatten(r5).iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        r1.addAll(d(((Message) r6.next()).getExt()));
    L17:
        return CollectionsKt.distinct(CollectionsKt.build(r1));
    }

    public static boolean c(Message r3, Message r4) {
        String r0 = r3.getMessageId();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L19;
        String r5 = r4.getMessageId();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        return Intrinsics.areEqual(r3.getMessageId(), r4.getMessageId());
    L13:
        if (StringsKt.isBlank(r5) == true) goto L16;
        r6 = false;
    L19:
        String r7 = r3.getLocalMessageId();
        if (r7 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == true) goto L37;
        String r9 = r4.getLocalMessageId();
        if (r9 != null) goto L30;
    L33:
        if (r1 == false) goto L35;
        return false;
    L35:
        return Intrinsics.areEqual(r3.getLocalMessageId(), r4.getLocalMessageId());
    L30:
        if (StringsKt.isBlank(r9) == true) goto L33;
        r1 = false;
        goto L33
    L37:
        return false;
    L22:
        if (StringsKt.isBlank(r7) == true) goto L25;
        r8 = false;
        goto L26
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static Message a(Message r50, List r51, DeleteMsgTipDisplay r52) {
        Intrinsics.checkNotNullParameter(r50, "anchor");
        Intrinsics.checkNotNullParameter(r51, "deletedMessageIds");
        Intrinsics.checkNotNullParameter(r52, "tipDisplay");
        int r1 = r51.size();
        String r15 = com.larus.im.internal.core.message.converter.a.a(new TextContent(FlowRuntime.a().getApplication().getResources().getQuantityString(r52.getTextPluralResId(), r1, new Object[]{Integer.valueOf(r1)}), null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null), TextContent.Companion.serializer());
        String r6 = r50.getConversationId();
        StringBuilder r2 = new StringBuilder();
        String r4 = r50.getMessageId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r2.append(r4);
        r2.append("-user-active-delete-tip-");
        r2.append(r52.getValue());
        r2.append('-');
        r2.append(String.valueOf(CollectionsKt.joinToString$default(r51, "_", null, null, 0, null, null, 62, null).hashCode()));
        return b0.j(new Message(r6, null, null, 0, 21, null, 1001, false, null, r15, null, null, null, null, null, r2.toString(), r50.getLocalIndex(), 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -98898, 31, null), 14);
    }
}
