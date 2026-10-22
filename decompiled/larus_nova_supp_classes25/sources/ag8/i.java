package ag8;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageOutboxRetrySlotCell;
import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Image d;
    public final /* synthetic */ SendImageCell e;
    public final /* synthetic */ Message f;

    public /* synthetic */ i(Uri r1, Uri r2, int r3, Image r4, SendImageCell r5, Message r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r35) {
        Uri r1 = this.a;
        Uri r2 = this.b;
        int r12 = this.c;
        Image r3 = this.d;
        SendImageCell r14 = this.e;
        Message r15 = this.f;
        SimpleDraweeView r11 = (SimpleDraweeView) r35;
        int r4 = SendImageCell.t;
        Intrinsics.checkNotNullParameter(r11, "view");
        FLogger.a.d("SendImageCell", "preview " + r1 + ", download " + r2 + " position:" + r12);
        String r5 = r3.key;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r14.getClass();
        com.larus.platform.service.o r6 = com.larus.platform.service.o.a;
        JSONObject r7 = new JSONObject();
        r7.put("bot_id", r14.r().getBotId());
        r7.put("message_id", r15.getMessageId());
        r7.put("conversation_id", r15.getConversationId());
        r7.put("user_type", "user");
        r7.put("pic_position", "1");
        r7.put("pic_id", r5);
        r7.put("is_onboarding", com.larus.bmhome.chat.bean.d.z0(r15) ? 1 : 0);
        Unit r8 = Unit.INSTANCE;
        r6.reportEvent("picture_message_click", r7);
        r14.w();
        com.larus.bmhome.chat.component.collection.o r9 = (com.larus.bmhome.chat.component.collection.o) r14.h.getValue();
        if (r9 != null) goto L8;
    L10:
        boolean r10 = false;
    L11:
        IChatGalleryService.Companion r13 = IChatGalleryService.a;
        MessageOutboxRetrySlotCell r17 = null;
        if (r13.n(PreviewScene.MESSAGE, r10) == false) goto L14;
    L60:
        Fragment r0 = lf8.a.d(r14);
        if (r0 == null) goto L65;
        FragmentActivity r16 = r0.getActivity();
        if (r16 == null) goto L65;
        FragmentManager r18 = r16.getSupportFragmentManager();
    L66:
        BotModel r19 = r14.r();
        q0 r20 = lf8.a.b(r14);
        TraceFragment r21 = lf8.a.d(r14);
        if ((r21 instanceof TraceFragment) == false) goto L69;
        TraceFragment r22 = r21;
    L70:
        r13.i(r18, new ty8.a(r19, r15, r22, LifecycleOwnerKt.getLifecycleScope(r14), r20, 0, r11.getContext(), r11, r12, 15904));
    L72:
        if (r15.getMessageStatusLocal() != 12) goto L74;
    L75:
        Iterator r23 = ((BaseMessageListCell) r14).c.iterator();
    L77:
        if (r23.hasNext() == false) goto L81;
        Object r24 = r23.next();
        if ((((BaseMessageSlotCell) r24) instanceof MessageOutboxRetrySlotCell) == false) goto L77;
    L82:
        BaseMessageSlotCell r25 = (BaseMessageSlotCell) r24;
        if (r25 != null) goto L85;
    L91:
        return Unit.INSTANCE;
    L85:
        if ((r25 instanceof MessageOutboxRetrySlotCell) == false) goto L87;
        r17 = (MessageOutboxRetrySlotCell) r25;
    L87:
        MessageOutboxRetrySlotCell r26 = r17;
        if (r26 == null) goto L91;
        r26.m(r15);
        goto L91
    L81:
        r24 = null;
        goto L82
    L74:
        if (r15.getMessageStatusLocal() != 3) goto L91;
    L69:
        r22 = null;
    L65:
        r18 = null;
        goto L66
    L14:
        if (r13.h(r10) == true) goto L60;
        Context r110 = r11.getContext();
        List r27 = CollectionsKt.listOf(new n1(r1.toString(), r2.toString()));
        Pair[] r28 = new Pair[11];
        r28[0] = TuplesKt.to("source", "send_img_holder");
        r28[1] = TuplesKt.to("user_type", "user");
        String r29 = "chat";
        r28[2] = TuplesKt.to("enter_picture_method", "chat");
        com.larus.bmhome.chat.component.collection.o r30 = (com.larus.bmhome.chat.component.collection.o) r14.h.getValue();
        if (r30 != null) goto L19;
    L21:
        boolean r31 = false;
    L22:
        if (r31 == false) goto L24;
        r29 = "temporary_chat";
    L24:
        r28[3] = TuplesKt.to("enter_from", r29);
        String r32 = r15.getMessageId();
        if (r32 != null) goto L27;
        r32 = "";
    L27:
        r28[4] = TuplesKt.to("message_id", r32);
        String r33 = r15.getConversationId();
        if (r33 != null) goto L30;
        r33 = "";
    L30:
        r28[5] = TuplesKt.to("conversation_id", r33);
        String r34 = r14.r().getBotId();
        if (r34 != null) goto L33;
        r34 = "";
    L33:
        r28[6] = TuplesKt.to("bot_id", r34);
        ChatParam r36 = (ChatParam) r14.l.getValue();
        if (r36 == null) goto L36;
        String r37 = r36.e;
    L37:
        if (r37 != null) goto L39;
        r37 = "";
    L39:
        r28[7] = TuplesKt.to("chat_type", r37);
        ChatParam r38 = (ChatParam) r14.l.getValue();
        if (r38 == null) goto L42;
        String r39 = r38.d;
    L43:
        if (r39 != null) goto L45;
        r39 = "";
    L45:
        r28[8] = TuplesKt.to("current_page", r39);
        ChatParam r40 = (ChatParam) r14.l.getValue();
        if (r40 == null) goto L48;
        String r41 = r40.c;
    L49:
        if (r41 != null) goto L51;
        r41 = "";
    L51:
        r28[9] = TuplesKt.to("previous_page", r41);
        Map r42 = r15.getExt();
        if (r42 == null) goto L54;
        Integer r43 = Integer.valueOf(ic8.j.a(r42) ? 1 : 0);
    L55:
        Pair r44 = TuplesKt.to("is_image_edit", r43);
        if (r44 != null) goto L59;
        r44 = 0;
    L59:
        r28[10] = r44;
        new BigImagePhotoViewerDialog(r110, r27, null, new uo8.k(MapsKt.mapOf(r28), CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("pic_id", r5)))), false, null, null, null, null, null, null, false, false, false, 32752).v(0, r11, SendImageCell.class.getName());
        goto L72
    L54:
        r43 = null;
        goto L55
    L48:
        r41 = null;
        goto L49
    L42:
        r39 = null;
        goto L43
    L36:
        r37 = null;
        goto L37
    L19:
        if (r30.i0() != true) goto L21;
        r31 = true;
        goto L22
    L8:
        if (r9.i0() != true) goto L10;
        r10 = true;
        goto L11
    }
}
