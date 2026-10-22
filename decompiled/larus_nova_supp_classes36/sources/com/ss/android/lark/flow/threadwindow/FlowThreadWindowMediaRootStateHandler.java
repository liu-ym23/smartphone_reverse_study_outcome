package com.ss.android.lark.flow.threadwindow;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowMediaRootStateHandler {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public final Handler b;
    public final List<n5b.a> c;
    public final Map<String, Message> d;
    public final MutableLiveData<String> e;
    public final Function0<Boolean> f;
    public final Function0<Unit> g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FlowThreadWindowMediaRootStateHandler a;
        public final /* synthetic */ Message b;

        public b(FlowThreadWindowMediaRootStateHandler r1, Message r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FlowThreadWindowMediaRootStateHandler a;
        public final /* synthetic */ Message b;
        public final /* synthetic */ String c;

        public c(FlowThreadWindowMediaRootStateHandler r1, Message r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static Integer l(Integer r2) {
        if (r2 == null) goto L11;
        int r0 = r2.intValue();
        if (r0 > 0) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        return r2;
    L6:
        if (r0 == Integer.MAX_VALUE) goto L8;
        r1 = true;
    L11:
        return null;
    }

    public final int d(Message r9) {
        if (r9.getType() == Message.Type.MEDIA) goto L5;
        return -1;
    L5:
        Iterator<n5b.a> r0 = this.c.iterator();
        int r3 = 0;
    L7:
        if (r0.hasNext() == false) goto L26;
        n5b.a r4 = r0.next();
        Message r5 = r4.c;
        if (r5 != null) goto L11;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == true) goto L23;
        r3 = r3 + 1;
        goto L7
    L23:
        return r3;
    L11:
        if (r5.isPreMessage() == false) goto L19;
        if (r5.getType() != Message.Type.MEDIA) goto L19;
        if (n.a(r5) == false) goto L19;
        if (j(r4, r9) == false) goto L19;
        r6 = true;
        goto L20
    L26:
        return -1;
    }

    public final void f(ErrorResult r2) {
        String r3 = r2.getDisplayMsg(UIHelper.getString(2131891714));
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        this.e.postValue(r3);
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void g(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "preMessage");
        if (((Boolean) this.f.invoke()).booleanValue() == false) goto L5;
        return;
    L5:
        if (r3.getType() == Message.Type.MEDIA) goto L7;
        return;
    L7:
        if (n.a(r3) == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L13;
        this.b.post(new b(this, r3));
        return;
    L13:
        String r0 = r3.getcId();
        if (r0 != null) goto L16;
    L21:
        r0 = null;
    L22:
        int r1 = e(r3, r0);
        if (r1 >= 0) goto L25;
        return;
    L25:
        ((n5b.a) ListProtector.get(this.c, r1)).c = r3;
        this.g.invoke();
        return;
    L16:
        if (r0.length() <= 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
    L18:
        r2 = false;
        goto L19
    }

    public static final void b(FlowThreadWindowMediaRootStateHandler r2, Message r3) {
        r2.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        r2.b.post(new l(r2, r3));
        return;
    L5:
        String r0 = r3.getcId();
        if (r0 != null) goto L8;
    L13:
        r0 = null;
    L14:
        int r1 = r2.e(r3, r0);
        if (r1 < 0) goto L20;
        ((n5b.a) ListProtector.get(r2.c, r1)).c = r3;
        r2.g.invoke();
        return;
    L20:
        return;
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
    L10:
        r4 = false;
        goto L11
    }

    public static boolean i(n5b.a r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "threadInfo");
        Intrinsics.checkNotNullParameter(r8, TabAppInfo.IMAGE_JSON_KEY);
        Message r0 = r7.c;
        String r3 = null;
        if (r0 != null) goto L5;
    L13:
        MediaContent r4 = null;
    L14:
        String r5 = n.b(r8);
        ThreadTopic r6 = r7.b;
        if (r6 == null) goto L17;
        String r9 = r6.getId();
    L19:
        if (Intrinsics.areEqual(r9, r8) == true) goto L46;
        ThreadTopic r10 = r7.b;
        if (r10 == null) goto L23;
        String r11 = r10.getRootMsgId();
    L25:
        if (Intrinsics.areEqual(r11, r8) == true) goto L46;
        if (r0 == null) goto L28;
        String r12 = r0.getId();
    L30:
        if (Intrinsics.areEqual(r12, r8) == true) goto L46;
        if (r0 == null) goto L33;
        String r13 = r0.getcId();
    L35:
        if (Intrinsics.areEqual(r13, r8) == true) goto L46;
        if (r5 == null) goto L48;
        if (r4 == null) goto L39;
        String r14 = r4.getMediaUploadId();
    L41:
        if (Intrinsics.areEqual(n.b(r14), r5) == true) goto L46;
        if (r4 == null) goto L45;
        r3 = r4.getFirstScreenImageUploadId();
    L45:
        if (Intrinsics.areEqual(n.b(r3), r5) == true) goto L46;
        return false;
    L39:
        r14 = null;
        goto L41
    L48:
        return false;
    L33:
        r13 = null;
        goto L35
    L28:
        r12 = null;
        goto L30
    L23:
        r11 = null;
    L46:
        return true;
    L17:
        r9 = null;
        goto L19
    L5:
        if (r0.getType() != Message.Type.MEDIA) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L10;
        Message r16 = r0;
    L11:
        if (r16 == null) goto L13;
        r4 = (MediaContent) r16.getContent();
        goto L14
    L10:
        r16 = null;
        goto L11
    L7:
        r15 = false;
        goto L8
    }

    public static boolean j(n5b.a r7, Message r8) {
        Intrinsics.checkNotNullParameter(r7, "threadInfo");
        Intrinsics.checkNotNullParameter(r8, INotificationHitPoint.NoticeType.MESSAGE);
        String r0 = r8.getcId();
        String r3 = null;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        String r4 = r8.getId();
        if (r4 != null) goto L14;
    L19:
        r4 = null;
    L21:
        if (r8.getType() != Message.Type.MEDIA) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L27;
        r8 = null;
    L27:
        if (r8 == null) goto L29;
        MediaContent r9 = (MediaContent) r8.getContent();
    L30:
        String[] r6 = new String[4];
        r6[0] = r4;
        r6[1] = r0;
        if (r9 == null) goto L33;
        String r1 = r9.getMediaUploadId();
    L34:
        r6[2] = n.b(r1);
        if (r9 == null) goto L37;
        r3 = r9.getFirstScreenImageUploadId();
    L37:
        r6[3] = n.b(r3);
        List r10 = CollectionsKt.listOfNotNull(r6);
        if ((r10 instanceof Collection) == true) goto L40;
    L42:
        Iterator r11 = r10.iterator();
    L44:
        if (r11.hasNext() == false) goto L48;
        if (i(r7, (String) r11.next()) == false) goto L44;
        return true;
    L48:
        return false;
    L40:
        if (r10.isEmpty() == false) goto L42;
    L33:
        r1 = null;
        goto L34
    L29:
        r9 = null;
        goto L30
    L23:
        r5 = false;
        goto L24
    L14:
        if (r4.length() <= 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
    L16:
        r12 = false;
        goto L17
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L10;
    L7:
        r13 = false;
        goto L8
    }

    public final int c(Message r17, ThreadTopic r18) {
        if (r17 == null) goto L174;
        if (r17.isPreMessage() == true) goto L174;
        if (r17.getType() != Message.Type.MEDIA) goto L174;
        Iterable r2 = CollectionsKt.withIndex(this.c);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L10:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L51;
        Object r6 = r4.next();
        Message r7 = ((n5b.a) ((IndexedValue) r6).component2()).c;
        if (r7 != null) goto L16;
    L48:
        if (r5 == false) goto L10;
        r3.add(r6);
        goto L10
    L16:
        if (r7.isPreMessage() == false) goto L48;
        if (r7.getType() != Message.Type.MEDIA) goto L48;
        if (r7.isFromMe() == false) goto L48;
        if (r17.isFromMe() == false) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == false) goto L48;
        String r9 = r7.getRootId();
        if (r9 != null) goto L34;
    L37:
        boolean r10 = true;
    L38:
        if (r10 == false) goto L48;
        String r11 = r7.getParentId();
        if (r11 != null) goto L42;
    L45:
        boolean r12 = true;
    L46:
        if (r12 == false) goto L48;
        r5 = true;
        goto L48
    L42:
        if (r11.length() == 0) goto L45;
        r12 = false;
        goto L46
    L34:
        if (r9.length() == 0) goto L37;
        r10 = false;
        goto L38
    L26:
        if (Intrinsics.areEqual(r17.getFromId(), r7.getFromId()) == true) goto L29;
        r8 = false;
        goto L30
    L51:
        if (r3.isEmpty() == false) goto L53;
        return -1;
    L53:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r3.iterator();
    L54:
        Integer r15 = null;
        if (r14.hasNext() == false) goto L167;
        Object r16 = r14.next();
        n5b.a r19 = (n5b.a) ((IndexedValue) r16).component2();
        Message r20 = r19.c;
        if (r20 == null) goto L163;
        Message.Type r110 = r20.getType();
        Message.Type r111 = Message.Type.MEDIA;
        if (r110 != r111) goto L62;
        boolean r112 = true;
    L63:
        if (r112 == true) goto L66;
        r20 = null;
    L66:
        if (r20 == null) goto L163;
        MediaContent r21 = r20.getContent();
        if (r21 == null) goto L163;
        if (r17.getType() != r111) goto L73;
        boolean r113 = true;
    L74:
        if (r113 == false) goto L76;
        Message r114 = r17;
    L77:
        if (r114 == null) goto L163;
        MediaContent r115 = r114.getContent();
        if (r115 == null) goto L163;
        String r116 = r21.getMediaUploadId();
        String r117 = r115.getMediaUploadId();
        String r118 = n.b(r116);
        if (r118 != null) goto L84;
    L86:
        boolean r119 = false;
    L87:
        if (r119 == true) goto L97;
        String r120 = r21.getFirstScreenImageUploadId();
        String r121 = r115.getFirstScreenImageUploadId();
        String r122 = n.b(r120);
        if (r122 != null) goto L91;
    L93:
        boolean r123 = false;
    L94:
        if (r123 == true) goto L97;
        boolean r124 = false;
    L98:
        if (r124 == true) goto L162;
        if (r18 == null) goto L102;
        Integer r125 = Integer.valueOf(r18.getPosition());
    L103:
        Integer r126 = l(r125);
        if (r126 != null) goto L106;
        r126 = l(Integer.valueOf(r17.getThreadPosition()));
    L106:
        ThreadTopic r127 = r19.b;
        if (r127 == null) goto L109;
        Integer r128 = Integer.valueOf(r127.getPosition());
    L110:
        Integer r129 = l(r128);
        if (r129 != null) goto L116;
        Message r22 = r19.c;
        if (r22 == null) goto L115;
        r15 = Integer.valueOf(r22.getThreadPosition());
    L115:
        r129 = l(r15);
    L116:
        if (r126 != null) goto L118;
    L120:
        boolean r23 = false;
    L121:
        if (r23 == false) goto L163;
        if (r21.getSize() > 0) goto L125;
    L127:
        boolean r24 = false;
    L129:
        if (r21.getDuration() > 0) goto L131;
    L133:
        boolean r25 = false;
    L135:
        if (r21.getName().length() <= 0) goto L137;
        boolean r130 = true;
    L138:
        if (r130 == true) goto L140;
    L142:
        boolean r131 = false;
    L144:
        if (r21.getMime().length() <= 0) goto L146;
        boolean r132 = true;
    L147:
        if (r132 == true) goto L149;
    L151:
        boolean r26 = false;
    L152:
        if (r24 == false) goto L154;
        if (r25 == false) goto L154;
    L159:
        boolean r27 = true;
    L161:
        if (r27 == false) goto L163;
    L154:
        if (r24 == false) goto L156;
        if (r131 == true) goto L159;
    L156:
        if (r25 == false) goto L160;
        if (r131 == false) goto L160;
        if (r26 == true) goto L159;
    L160:
        r27 = false;
        goto L161
    L149:
        if (Intrinsics.areEqual(r21.getMime(), r115.getMime()) == false) goto L151;
        r26 = true;
        goto L152
    L146:
        r132 = false;
        goto L147
    L140:
        if (Intrinsics.areEqual(r21.getName(), r115.getName()) == false) goto L142;
        r131 = true;
        goto L144
    L137:
        r130 = false;
        goto L138
    L131:
        if (r21.getDuration() != r115.getDuration()) goto L133;
        r25 = true;
        goto L135
    L125:
        if (r21.getSize() != r115.getSize()) goto L127;
        r24 = true;
        goto L129
    L118:
        if (Intrinsics.areEqual(r126, r129) == false) goto L120;
        r23 = true;
        goto L121
    L109:
        r128 = null;
        goto L110
    L102:
        r125 = null;
    L162:
        boolean r28 = true;
    L164:
        if (r28 == false) goto L54;
        r13.add(r16);
        goto L54
    L91:
        if (Intrinsics.areEqual(r122, n.b(r121)) == false) goto L93;
        r123 = true;
    L97:
        r124 = true;
        goto L98
    L84:
        if (Intrinsics.areEqual(r118, n.b(r117)) == false) goto L86;
        r119 = true;
        goto L87
    L76:
        r114 = null;
        goto L77
    L73:
        r113 = false;
        goto L74
    L62:
        r112 = false;
    L163:
        r28 = false;
        goto L164
    L167:
        if (r13.size() != 1) goto L169;
        r15 = (IndexedValue) CollectionsKt.first(r13);
    L170:
        if (r15 != null) goto L185;
        return -1;
    L185:
        return r15.getIndex();
    L169:
        r13.size();
    L174:
        return -1;
    }

    public final int e(Message r6, String r7) {
        int r0 = 0;
        if (r7 == null) goto L11;
        Iterator<n5b.a> r2 = this.c.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L11;
        if (i(r2.next(), r7) == true) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L14;
        return r3;
    L14:
        int r8 = d(r6);
        if (r8 < 0) goto L17;
        return r8;
    L17:
        Iterator<n5b.a> r9 = this.c.iterator();
    L19:
        if (r9.hasNext() == false) goto L29;
        if (j(r9.next(), r6) == true) goto L24;
        r0 = r0 + 1;
        goto L19
    L24:
        return r0;
    L29:
        return -1;
    L11:
        r3 = -1;
        goto L12
    }

    public final void h(Message r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "preMessage");
        Intrinsics.checkNotNullParameter(r10, "messageId");
        if (((Boolean) this.f.invoke()).booleanValue() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        this.b.post(new c(this, r9, r10));
        return;
    L9:
        boolean r1 = false;
        if (r10.length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        Integer r3 = null;
        if (r0 == true) goto L17;
        r10 = null;
    L17:
        if (r10 != null) goto L19;
        return;
    L19:
        String r2 = r9.getcId();
        if (r2 != null) goto L22;
    L27:
        r2 = null;
    L28:
        Iterator<n5b.a> r4 = this.c.iterator();
        int r5 = 0;
    L29:
        int r7 = -1;
        if (r4.hasNext() == false) goto L35;
        if (i(r4.next(), r10) == true) goto L37;
        r5 = r5 + 1;
    L37:
        if (r9.getType() != Message.Type.MEDIA) goto L42;
        int r6 = d(r9);
        if (r6 < 0) goto L41;
    L40:
        r7 = r6;
    L50:
        Integer r11 = Integer.valueOf(r5);
        if (r11.intValue() < 0) goto L53;
        r1 = true;
    L53:
        if (r1 == false) goto L55;
        r3 = r11;
    L55:
        if (r3 == null) goto L57;
        int r12 = r3.intValue();
    L58:
        if (r12 >= 0) goto L60;
        return;
    L60:
        n5b.a r13 = (n5b.a) ListProtector.get(this.c, r12);
        ThreadTopic r8 = r13.b;
        if (r8 == null) goto L63;
        r8.setId(r10);
    L63:
        ThreadTopic r14 = r13.b;
        if (r14 == null) goto L66;
        r14.setRootMsgId(r10);
    L66:
        Message r15 = r13.c;
        if (r15 == null) goto L69;
        r15.setId(r10);
    L69:
        Message r16 = r13.c;
        if (r16 == null) goto L72;
        r16.setSendStatus(SendStatus.SUCCESS);
    L72:
        if (r5 < 0) goto L76;
        if (r7 < 0) goto L76;
        if (r5 == r7) goto L76;
        ListProtector.remove(this.c, r7);
    L76:
        if (r2 == null) goto L78;
        Message r17 = this.d.remove(r2);
    L78:
        this.g.invoke();
        return;
    L57:
        r12 = r7;
        goto L58
    L41:
        r7 = e(r9, r2);
        goto L50
    L42:
        if (r2 == null) goto L50;
        Iterator<n5b.a> r18 = this.c.iterator();
        r6 = 0;
    L45:
        if (r18.hasNext() == false) goto L50;
        if (i(r18.next(), r2) == true) goto L40;
        r6 = r6 + 1;
        goto L45
    L35:
        r5 = -1;
        goto L37
    L22:
        if (r2.length() <= 0) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == false) goto L27;
    L24:
        r19 = false;
        goto L25
    L12:
        r0 = false;
        goto L13
    }

    public static final void a(FlowThreadWindowMediaRootStateHandler r6, String r7, ErrorResult r8) {
        if (((Boolean) r6.f.invoke()).booleanValue() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L8;
        r6.b.post(new k(r6, r7, r8));
        return;
    L8:
        Iterator<n5b.a> r0 = r6.c.iterator();
        int r2 = 0;
    L10:
        if (r0.hasNext() == false) goto L40;
        n5b.a r3 = r0.next();
        Message r4 = r3.c;
        String r5 = null;
        if (r4 == null) goto L14;
        String r9 = r4.getcId();
    L16:
        if (Intrinsics.areEqual(r9, r7) == true) goto L36;
        Message r10 = r3.c;
        if (r10 == null) goto L20;
        String r11 = r10.getId();
    L22:
        if (Intrinsics.areEqual(r11, r7) == true) goto L36;
        ThreadTopic r12 = r3.b;
        if (r12 == null) goto L26;
        String r13 = r12.getId();
    L28:
        if (Intrinsics.areEqual(r13, r7) == true) goto L36;
        ThreadTopic r14 = r3.b;
        if (r14 == null) goto L33;
        r5 = r14.getRootMsgId();
    L33:
        if (Intrinsics.areEqual(r5, r7) == true) goto L36;
        boolean r15 = false;
    L37:
        if (r15 == true) goto L41;
        r2 = r2 + 1;
    L41:
        if (r2 >= 0) goto L43;
        r6.f(r8);
        return;
    L43:
        Message r16 = ((n5b.a) ListProtector.get(r6.c, r2)).c;
        if (r16 != null) goto L47;
        return;
    L47:
        if (r16.getSendStatus() == SendStatus.SUCCESS) goto L57;
        r16.setSendStatus(SendStatus.FAIL);
        r6.g.invoke();
        r6.f(r8);
        return;
    L57:
        return;
    L26:
        r13 = null;
        goto L28
    L20:
        r11 = null;
    L36:
        r15 = true;
        goto L37
    L14:
        r9 = null;
        goto L16
    L40:
        r2 = -1;
        goto L41
    }

    public final boolean k(String r5, Function1<? super f5b.b, ? extends f5b.b> r6, final Function1<? super SendStatus, Boolean> r7) {
        final String r8 = n.b(r5);
        boolean r0 = false;
        if (r8 != null) goto L5;
        return false;
    L5:
        Function1<n5b.a, Boolean> r1 = new FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$2(r7, this, r8);
        IntIterator r9 = CollectionsKt.getIndices(this.c).iterator();
    L7:
        if (r9.hasNext() == false) goto L17;
        int r10 = r9.nextInt();
        n5b.a r2 = (n5b.a) ListProtector.get(this.c, r10);
        if (((Boolean) r1.invoke(r2)).booleanValue() == false) goto L7;
        Object r3 = r6.invoke(r2);
        if ((r3 instanceof n5b.a) == false) goto L13;
        n5b.a r4 = (n5b.a) r3;
    L14:
        if (r4 == null) goto L7;
        ListProtector.set(this.c, r10, r4);
        r0 = true;
        goto L7
    L13:
        r4 = null;
        goto L14
    L17:
        if (r0 == false) goto L19;
        this.g.invoke();
    L19:
        return r0;
    }

    public FlowThreadWindowMediaRootStateHandler(String r2, Handler r3, List<n5b.a> r4, Map<String, Message> r5, MutableLiveData<String> r6, Function0<Boolean> r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "mainHandler");
        Intrinsics.checkNotNullParameter(r4, "threads");
        Intrinsics.checkNotNullParameter(r5, "pendingRootPlaceholders");
        Intrinsics.checkNotNullParameter(r6, "toastInfo");
        Intrinsics.checkNotNullParameter(r7, "isDestroyed");
        Intrinsics.checkNotNullParameter(r8, "publishThreads");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
