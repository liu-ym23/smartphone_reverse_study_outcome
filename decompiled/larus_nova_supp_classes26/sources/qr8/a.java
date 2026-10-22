package qr8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void b(Integer r11, String r12, String r13, int r14, int r15, Message r16, boolean r17, String r18, int r19) {
        if ((r19 & 128) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r19 & 512) == 0) goto L9;
        String r9 = null;
    L10:
        if (r16 == null) goto L14;
        o.a.reportEvent("click_card", a(r11, r12, r13, r14, r15, r16, null, r7, false, r9));
        return;
    L14:
        return;
    L9:
        r9 = r18;
        goto L10
    L5:
        r7 = r17;
        goto L7
    }

    public static /* synthetic */ void d(Integer r10, String r11, String r12, int r13, int r14, Message r15, boolean r16, String r17, int r18) {
        if ((r18 & 256) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r18 & 1024) == 0) goto L9;
        String r9 = null;
    L10:
        c(r10, r11, r12, r13, r14, r15, null, r7, false, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r7 = r16;
        goto L7
    }

    public static JSONObject a(Integer r4, String r5, String r6, int r7, int r8, Message r9, Integer r10, boolean r11, boolean r12, String r13) {
        if (r12 == false) goto L6;
        if (r11 == false) goto L5;
        String r14 = "wcb_feed";
    L9:
        JSONObject r15 = new JSONObject();
        int r0 = 1;
        r15.put("rank", r7 + 1);
        r15.put("column", r8 + 1);
        ItemType r16 = ItemType.VIDEO;
        int r17 = r16.getValue();
        String r1 = "video";
        if (r4 != null) goto L13;
    L15:
        Object r18 = "graphic";
    L16:
        r15.put("group_type", r18);
        r15.put("bot_id", r9.getSenderId());
        r15.put("chat_type", "default");
        int r19 = r16.getValue();
        if (r4 != null) goto L20;
    L22:
        r1 = "graphic";
    L23:
        r15.put("card_type", r1);
        r15.put("host_enter_from", r14);
        if (r10 == null) goto L26;
        r0 = r10.intValue();
    L26:
        r15.put("impr_index", r0);
        r15.put("video_id", r5);
        String r20 = r9.getMessageId();
        if (r20 == null) goto L31;
        Long r21 = StringsKt.toLongOrNull(r20);
        if (r21 == null) goto L31;
        String r22 = r21.toString();
    L32:
        r15.put(MusicAppletPage.KEY_MESSAGE_ID, r22);
        r15.put("reply_id", r9.getReplyId());
        r15.put("req_id", r6);
        r15.put("search_id", r13);
        return r15;
    L31:
        r22 = null;
        goto L32
    L20:
        if (r4.intValue() != r19) goto L22;
    L13:
        if (r4.intValue() != r17) goto L15;
        r18 = "video";
        goto L16
    L5:
        r14 = "chat_feed";
        goto L9
    L6:
        if (r11 == false) goto L8;
        r14 = "wcb_first_card";
        goto L9
    L8:
        r14 = "chat_first_card";
        goto L9
    }

    public static void c(Integer r1, String r2, String r3, int r4, int r5, Message r6, Integer r7, boolean r8, boolean r9, String r10) {
        if (r6 != null) goto L4;
        return;
    L4:
        o.a.reportEvent("show_card", a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10));
    }
}
