package jg8;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.layout.item.r;
import com.larus.bmhome.chat.layout.item.s;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends bd8.b {
    public FlowLayout l;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        FlowLayout r0 = this.l;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    public d(int r2) {
        super(true, r2);
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
    }

    @Override // bd8.b
    public final boolean G(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if (r6.getMessageStatusLocal() != 21) goto L7;
        if (com.larus.bmhome.chat.bean.d.Q0(r6) == false) goto L7;
        return false;
    L7:
        if (r6.getMessageStatusLocal() != 20) goto L9;
        return false;
    L9:
        if (r6.getMessageStatusLocal() == 23) goto L41;
        List<TextTagInfo> r7 = com.larus.bmhome.chat.bean.d.O(r6);
        if (r7 != null) goto L13;
        r7 = CollectionsKt.emptyList();
    L13:
        List<TextTagInfo> r8 = r7;
        if ((r8 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r9 = r8.iterator();
        int r0 = 0;
    L20:
        if (r9.hasNext() == false) goto L29;
        if (((TextTagInfo) r9.next()).type != TagEnum.TagEnum_Insertable.value) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L20;
        r0 = r0 + 1;
        if (r0 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r3 = false;
    L29:
        if (r0 == 0) goto L42;
        return true;
    L42:
        return false;
    L16:
        if (r8.isEmpty() == false) goto L18;
        r0 = 0;
        goto L29
    L41:
        return false;
    }

    @Override // bd8.b
    public final void w(final Message r11, int r12, ec8.b r13) {
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r11, "message");
        if (r11.getMessageStatusLocal() != 21) goto L7;
        if (com.larus.bmhome.chat.bean.d.Q0(r11) == false) goto L7;
    L93:
        FlowLayout r14 = this.l;
        if (r14 == null) goto L122;
        r14.setVisibility(8);
        return;
    L122:
        return;
    L7:
        if (r11.getMessageStatusLocal() == 20) goto L93;
        if (r11.getMessageStatusLocal() == 23) goto L93;
        List<TextTagInfo> r15 = com.larus.bmhome.chat.bean.d.O(r11);
        if (r15 != null) goto L13;
        r15 = CollectionsKt.emptyList();
    L13:
        List<TextTagInfo> r16 = r15;
        if ((r16 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r17 = r16.iterator();
        int r18 = 0;
    L20:
        if (r17.hasNext() == false) goto L29;
        if (((TextTagInfo) r17.next()).type != TagEnum.TagEnum_Insertable.value) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L20;
        r18 = r18 + 1;
        if (r18 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r3 = false;
    L29:
        if (r18 == 0) goto L93;
        FlowLayout r19 = this.l;
        if (r19 == null) goto L34;
        r19.setVisibility(0);
    L34:
        FlowLayout r110 = this.l;
        if (r110 == null) goto L37;
        r110.removeAllViews();
    L37:
        List<TextTagInfo> r111 = com.larus.bmhome.chat.bean.d.O(r11);
        if (r111 == null) goto L119;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L41:
        if (r113.hasNext() == false) goto L48;
        Object r4 = r113.next();
        if (((TextTagInfo) r4).type != TagEnum.TagEnum_Insertable.value) goto L45;
        boolean r5 = true;
    L46:
        if (r5 == false) goto L41;
        r112.add(r4);
        goto L41
    L45:
        r5 = false;
        goto L46
    L48:
        Iterator r114 = r112.iterator();
    L50:
        if (r114.hasNext() == false) goto L123;
        TextTagInfo r115 = (TextTagInfo) r114.next();
        FlowLayout r1 = this.l;
        if (r1 == null) goto L50;
        Gson r2 = new Gson();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L59
        String r116 = r115.tagInfo;     // Catch: Throwable -> L59
        if (r116 != null) goto L57;
        r116 = "{}";
    L57:
        Object r117 = Result.constructor-impl((IMMetaInfo.c) r2.fromJson(r116, IMMetaInfo.c.class));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r117) == false) goto L64;
        r117 = null;
    L64:
        final IMMetaInfo.c r7 = (IMMetaInfo.c) r117;
        if (r7 == null) goto L50;
        if (TextUtils.isEmpty(r7.b()) == true) goto L68;
        s r118 = new s(r1.getContext());
        y r8 = (y) this.n.getValue();
        if (r8 == null) goto L78;
        String r9 = r8.getBotId();
        if (r9 == null) goto L78;
    L79:
        final String r10 = r9;
        de8.c r20 = (de8.c) this.m.getValue();
        if (r20 == null) goto L82;
        final long r21 = r20.n;
    L83:
        Intrinsics.checkNotNullParameter(r7, "ref");
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r10, "botId");
        TextView r22 = r118.c;
        if (r22 == null) goto L86;
        r22.setText(r7.e());
    L86:
        TextView r23 = r118.a;
        if (r23 == null) goto L89;
        r23.setText(r7.c());
    L89:
        SimpleDraweeView r24 = r118.b;
        if (r24 == null) goto L92;
        ImageLoaderKt.u(r24, r7.b(), "citation_item_icon");
    L92:
        o r25 = o.a;
        JSONObject r26 = new JSONObject();
        r26.put("bot_id", r10);
        r26.put("message_id", r11.getMessageId());
        r26.put("conversation_id", r11.getConversationId());
        r26.put("footnote_style", "icon");
        Unit r27 = Unit.INSTANCE;
        r25.reportEvent("footnote_link_show", r26);
        r118.setOnClickListener(new r(r7, r21, r10, r11));
        r1.addView(r118);
        goto L50
    L82:
        r21 = 0;
    L78:
        r9 = "";
        goto L79
    L68:
        FlowLayout r119 = this.l;
        if (r119 == null) goto L71;
        r119.setVisibility(8);
    L71:
        FlowLayout r120 = this.l;
        if (r120 == null) goto L120;
        r120.removeAllViews();
        return;
    L120:
        return;
    L59:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L123:
        return;
    L119:
        return;
    L16:
        if (r16.isEmpty() == false) goto L18;
        r18 = 0;
        goto L29
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        FlowLayout r8 = new FlowLayout(r3);
        r8.setPadding(i5.q(), 0, i5.q(), i5.m());
        r8.setLineSpacing(i5.r0());
        r8.setItemSpacing(i5.r0());
        if (r5 == null) goto L5;
        r5.addView(r8, r2, new LinearLayout.LayoutParams(-2, -2));
    L5:
        this.l = r8;
        return CollectionsKt.listOf(r8);
    }
}
