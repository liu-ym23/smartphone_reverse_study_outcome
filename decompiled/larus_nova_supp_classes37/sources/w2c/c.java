package w2c;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.threaddetail.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends com.ss.android.lark.threaddetail.model.a {
    public final int U(boolean r1) {
        if (r1 == false) goto L4;
        return 22;
    L4:
        return 23;
    }

    public final String x() {
        return "ReplyInThreadDataStore";
    }

    public final boolean C(f5b.b r2) {
        MessageInfo r3 = (MessageInfo) r2;
        if (((com.ss.android.lark.threaddetail.model.a) this).p == true) goto L5;
    L10:
        return true;
    L5:
        if (super/*com.ss.android.lark.chatbase.BasePageStore*/.C(r3) == true) goto L10;
        if (r3.getMessage().getThreadMessageType() == Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L10;
        return false;
    }

    public final boolean E(f5b.b r7) {
        Message r8 = ((MessageInfo) r7).getMessage();
        if (r8 == null) goto L60;
        String r1 = r8.getcId();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return true;
    L9:
        if (r8.isPreMessage() == false) goto L22;
        Iterator r9 = ((BasePageStore) this).b.iterator();
    L12:
        if (r9.hasNext() == false) goto L63;
        Message r2 = ((MessageInfo) r9.next()).getMessage();
        if (r2 == null) goto L12;
        if (r2.isPreMessage() == true) goto L12;
        if (Objects.equals(r2.getcId(), r1) == false) goto L12;
        Log.i("ReplyInThreadDataStore", "isValidData: drop preMessage as real message already exists, cid: " + r1);
        return false;
    L63:
        return true;
    L22:
        if (((BasePageStore) this).b.containsKey(new String[]{r8.getId(), r8.getcId()}) == true) goto L58;
        String r10 = r8.getcId();
        if (TextUtils.isEmpty(r10) == true) goto L62;
        Iterator r3 = ((BasePageStore) this).b.iterator();
    L28:
        if (r3.hasNext() == false) goto L37;
        final MessageInfo r4 = (MessageInfo) r3.next();
        Message r5 = r4.getMessage();
        if (r5 == null) goto L28;
        if (r5.isPreMessage() == false) goto L28;
        if (Objects.equals(r5.getcId(), r10) == false) goto L28;
    L38:
        if (r4 == null) goto L59;
        Log.i("ReplyInThreadDataStore", "tryRemoveFakeMessageInDatas: find preMessage in mDatas, cid: " + r10);
        ((com.ss.android.lark.chatbase.model.c) this).a.execute(new a(this, r4));
        return true;
    L59:
        return true;
    L37:
        r4 = null;
        goto L38
    L62:
        return true;
    L58:
        return true;
    L60:
        return true;
    }

    public final void G(final x4b.a<MessageInfo> r3) {
        super/*com.ss.android.lark.chatbase.BasePageStore*/.G(r3);
        if ((r3 instanceof e) == false) goto L6;
        ((com.ss.android.lark.chatbase.model.c) this).a.execute(new b(this, r3));
        return;
    }

    public final void T(e r3) {
        if (X(r3) == true) goto L5;
        return;
    L5:
        MessageInfo r4 = ((com.ss.android.lark.threaddetail.model.a) this).l;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getMessage() == null) goto L12;
        Log.i("ReplyInThreadDataStore", "handAppendDataList: add topic message");
        ((BasePageStore) this).b.add(0, ((com.ss.android.lark.threaddetail.model.a) this).l);
        return;
    }

    public final boolean X(e r6) {
        ThreadTopic r0 = ((com.ss.android.lark.threaddetail.model.a) this).k;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (((BasePageStore) this).b.containsKey(new String[]{r0.getId()}) == false) goto L10;
        Log.i("ReplyInThreadDataStore", "not add topic message: topic message already added");
        return false;
    L10:
        if (((com.ss.android.lark.threaddetail.model.a) this).k.getReplyCount() != 0) goto L13;
        return true;
    L13:
        if (CollectionUtils.isEmpty(((x4b.a) r6).a) == false) goto L17;
        Log.i("ReplyInThreadDataStore", "add topic message: data list is null");
        return true;
    L17:
        if (((MessageInfo) ListProtector.get(((x4b.a) r6).a, 0)).getMessage().getThreadPosition() > 0) goto L21;
        Log.i("ReplyInThreadDataStore", "add topic message: first message thread position from page data == 0");
        return true;
    L21:
        if (CollectionUtils.isEmpty(((x4b.a) r6).b) == false) goto L23;
    L26:
        return false;
    L23:
        if (((ArrayList) ((x4b.a) r6).b).contains(0) == false) goto L26;
        Log.i("ReplyInThreadDataStore", "add topic message: first reply under thread is invisible");
        return true;
    }

    public c(FragmentActivity r8, d r9, ThreadTopic r10, Chat r11, BasePageStore.c r12, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.a r13) {
        super(r9, r10, r11, r12, r8, r13);
    }
}
